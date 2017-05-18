package net.bluepoet.exercise.seolhyungallery;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

/**
 * Created by bluepoet on 2017. 5. 18..
 */

public class JsoupHtmlParseTest {
    @Test
    public void getSeolHyun10Images() throws Exception {
        // Given
        Document doc = Jsoup.connect("https://search.naver.com/search.naver?where=image&sm=tab_jum&ie=utf8&query=seolhyun").get();
        Elements elements = doc.select("ø");

        // When
        for(Element element : elements) {
            System.out.println(element.attr("data-source"));
        }
        // Then

    }
}
