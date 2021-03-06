package com.ptachia.myapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RetroSpring {

    @SerializedName("KayMayan")
    @Expose
    private Integer kayMayan;
    @SerializedName("NameMayan")
    @Expose
    private String nameMayan;
    @SerializedName("moreNameMayan")
    @Expose
    private String moreNameMayan;
    @SerializedName("Abstract")
    @Expose
    private String _abstract;
    @SerializedName("Directions")
    @Expose
    private String directions;
    @SerializedName("KordintotX")
    @Expose
    private Integer kordintotX;
    @SerializedName("KordintotY")
    @Expose
    private Integer kordintotY;
    // coordinates for navigating:
    @SerializedName("wgs84_x")
    @Expose
    private Double wgs84_x;
    @SerializedName("wgs84_y")
    @Expose
    private Double wgs84_y;

    public RetroSpring() {}

    public RetroSpring(Integer kayMayan, String nameMayan, String moreNameMayan,
                       String _abstract, String directions, Integer kordintotX,
                       Integer kordintotY, Double wgs84_x, Double wgs84_y) {
        super();
        this.kayMayan = kayMayan;
        this.nameMayan = nameMayan;
        this.moreNameMayan = moreNameMayan;
        this._abstract = _abstract;
        this.directions = directions;
        this.kordintotX = kordintotX;
        this.kordintotY = kordintotY;
        this.wgs84_x = wgs84_x;
        this.wgs84_y = wgs84_y;
    }

    public Integer getKayMayan() {
        return kayMayan;
    }

    public void setKayMayan(Integer kayMayan) {
        this.kayMayan = kayMayan;
    }

    public String getNameMayan() {
        return nameMayan;
    }

    public void setNameMayan(String nameMayan) {
        this.nameMayan = nameMayan;
    }

    public String getMoreNameMayan() {
        return moreNameMayan;
    }

    public void setMoreNameMayan(String moreNameMayan) {
        this.moreNameMayan = moreNameMayan;
    }

    public String getAbstract() {
        return _abstract;
    }

    public void setAbstract(String _abstract) {
        this._abstract = _abstract;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public Integer getKordintotX() {
        return kordintotX;
    }

    public void setKordintotX(Integer kordintotX) {
        this.kordintotX = kordintotX;
    }

    public Integer getKordintotY() {
        return kordintotY;
    }

    public void setKordintotY(Integer kordintotY) {
        this.kordintotY = kordintotY;
    }

    public Double getWgs84_x() {
        return wgs84_x;
    }

    public void setWgs84_x(Double wgs84_x) {
        this.wgs84_x = wgs84_x;
    }

    public Double getWgs84_y() {
        return wgs84_y;
    }

    public void setWgs84_y(Double wgs84_y) {
        this.wgs84_y = wgs84_y;
    }
}