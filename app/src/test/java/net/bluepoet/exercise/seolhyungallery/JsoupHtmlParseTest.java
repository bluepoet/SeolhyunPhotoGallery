package net.bluepoet.exercise.seolhyungallery;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by bluepoet on 2017. 5. 18..
 */

public class JsoupHtmlParseTest {
    @Test
    public void getSeolHyunImagesByNaver() throws Exception {
        // Given
        Document doc = Jsoup.connect("https://search.naver.com/search.naver?where=image&sm=tab_jum&ie=utf8&query=seolhyun").get();
        Elements elements = doc.select("div.photo_grid div._box img[src]");

        // When
        for(Element element : elements) {
            System.out.println(element.attr("data-source"));
        }
        // Then
    }

    @Test
    public void getSeolHyunImagesByNate() throws Exception {
        URL url;
        HttpURLConnection connection;
        BufferedReader br;
        String line;
        String result = null;

        try {
            url = new URL("https://images.search.yahoo.com/search/images;_ylt=A0SO8zi2cidZ244Au_NXNyoA;_ylu=X3oDMTEzZ2M5aGc1BGNvbG8DZ3ExBHBvcwMxBHZ0aWQDREZENl8xBHNlYwNwaXZz?p=seolhyun&fr2=piv-web&fr=yfp-t");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while((line = br.readLine()) != null) {
                result += line;
            }

            br.close();
        }catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(result);
        // Given
        Document doc = Jsoup.connect("https://images.search.yahoo.com/search/images;_ylt=A0SO8zi2cidZ244Au_NXNyoA;_ylu=X3oDMTEzZ2M5aGc1BGNvbG8DZ3ExBHBvcwMxBHZ0aWQDREZENl8xBHNlYwNwaXZz?p=seolhyun&fr2=piv-web&fr=yfp-t").get();

        // When

        // Then

    }
}
