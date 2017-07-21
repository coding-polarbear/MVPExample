package com.example.baehyeonbin.mvpexample.Data;

/**
 * Created by baehyeonbin on 2017. 7. 21..
 */

public class ImageItem {
    private int imageRes;
    private String title;

    public ImageItem(int imageRes, String title) {
        this.imageRes = imageRes;
        this.title = title;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
