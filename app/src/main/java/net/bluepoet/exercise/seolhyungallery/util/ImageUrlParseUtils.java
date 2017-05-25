package net.bluepoet.exercise.seolhyungallery.util;

/**
 * Created by bluepoet on 2017. 5. 25..
 */

public class ImageUrlParseUtils {
    public static String getFullImageUrl(String thumbImageUrl) {
        thumbImageUrl = thumbImageUrl.replaceAll("%2F", "/").replace("%3A", ":");
        return thumbImageUrl.substring(0, thumbImageUrl.indexOf("&type=b360"));
    }
}
