package net.bluepoet.exercise.seolhyungallery;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bluepoet on 2017. 5. 18..
 */

public class PhotoFetcher {

    public static final String ENDPOINT = "https://search.naver.com/search.naver?where=image&sm=tab_jum&ie=utf8&query=seolhyun";

    public byte[] getUrlBytes(String urlSpec) throws IOException {
        URL url = new URL(urlSpec);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            InputStream is = connection.getInputStream();

            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                return null;
            }

            int bytesRead = 0;
            byte[] buffer = new byte[1024];
            while ((bytesRead = is.read(buffer)) > 0) {
                out.write(buffer, 0, bytesRead);
            }
            out.close();
            return out.toByteArray();
        } finally {
            connection.disconnect();
        }
    }

    public String getUrl(String urlSpec) throws IOException {
        return new String(getUrlBytes(urlSpec));
    }

    public List<GalleryItem> fetchItems() {
        List<GalleryItem> items = new ArrayList<>();


        Document doc = null;
        try {
            doc = Jsoup.connect(ENDPOINT).get();
            Elements elements = doc.select("div.photo_grid div._box img[src]");

            for (Element element : elements) {
                items.add(new GalleryItem(element.attr("data-source")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return items;
    }
}
