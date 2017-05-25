package net.bluepoet.exercise.seolhyungallery;

import junit.framework.Assert;

import net.bluepoet.exercise.seolhyungallery.util.ImageUrlParseUtils;

import org.junit.Test;

/**
 * Created by bluepoet on 2017. 5. 25..
 */

public class FullPhotoUrlParseTest {
    @Test
    public void originPhotoUrlParseTest() throws Exception {
        // Given
        String thumbPhotoUrl = "http%3A%2F%2Fblogfiles7.naver.net%2F20150126_24%2Ffstdevil_1422278275724f5dsD_JPEG%2FibfR1VrGqyljG1.jpg&type=b360&type=b360";

        // When
        thumbPhotoUrl = ImageUrlParseUtils.getFullImageUrl(thumbPhotoUrl);

        // Then
        Assert.assertEquals(thumbPhotoUrl, "http://blogfiles7.naver.net/20150126_24/fstdevil_1422278275724f5dsD_JPEG/ibfR1VrGqyljG1.jpg");
    }
}
