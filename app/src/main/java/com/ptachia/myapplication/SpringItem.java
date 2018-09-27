package com.ptachia.myapplication;

public class SpringItem {

    private String name, shortText, imgPath;

    public SpringItem(String name, String shortText, String imgPath) {
        this.name = name;
        this.shortText = shortText;
        this.imgPath = imgPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortText() {
        return shortText;
    }

    public void setShortText(String shortText) {
        this.shortText = shortText;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
}
