package net.bluepoet.exercise.seolhyungallery;

/**
 * Created by bluepoet on 2017. 5. 19..
 */

public class GalleryItem {
    private String imgUrl;

    public GalleryItem(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return imgUrl.substring(imgUrl.length()- 3, imgUrl.length()) + "\n";
    }
}
