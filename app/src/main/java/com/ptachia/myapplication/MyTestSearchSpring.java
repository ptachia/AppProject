package com.ptachia.myapplication;

public class MyTestSearchSpring {
    private String levelType, temp;
    private Integer kmDist, levelVal, deep;
    private Double yCoord, xCoord;

    public MyTestSearchSpring(String levelType, String temp, Integer kmDist, Integer levelVal,
                              Integer deep, Double yCoord, Double xCoord) {
        this.levelType = levelType;
        this.temp = temp;
        this.kmDist = kmDist;
        this.levelVal = levelVal;
        this.deep = deep;
        this.yCoord = yCoord;
        this.xCoord = xCoord;
    }

    public String getLevelType() {
        return levelType;
    }

    public void setLevelType(String levelType) {
        this.levelType = levelType;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public Integer getKmDist() {
        return kmDist;
    }

    public void setKmDist(Integer kmDist) {
        this.kmDist = kmDist;
    }

    public Integer getLevelVal() {
        return levelVal;
    }

    public void setLevelVal(Integer levelVal) {
        this.levelVal = levelVal;
    }

    public Integer getDeep() {
        return deep;
    }

    public void setDeep(Integer deep) {
        this.deep = deep;
    }

    public Double getyCoord() {
        return yCoord;
    }

    public void setyCoord(Double yCoord) {
        this.yCoord = yCoord;
    }

    public Double getxCoord() {
        return xCoord;
    }

    public void setxCoord(Double xCoord) {
        this.xCoord = xCoord;
    }
}
