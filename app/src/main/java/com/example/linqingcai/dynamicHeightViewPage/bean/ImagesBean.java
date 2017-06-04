package com.example.linqingcai.dynamicHeightViewPage.bean;

/**
 * Created by linqingcai on 2017/6/4.
 */

public class ImagesBean {
    private String url;

    private int width;
    private int height;

    public ImagesBean(String url, int width, int height) {
        this.url = url;
        this.width = width;
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
