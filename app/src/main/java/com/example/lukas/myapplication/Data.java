package com.example.lukas.myapplication;

/**
 * Created by Lukas on 19.11.2016.
 */

public class Data {
    private Integer viewType;        //possible: ToDo: Number description

    private Integer tempInCel;       //ToDo: City, Temperature next day

    private String tempCity;
    private String tempDayTmrw;
    private Integer tempInCelTmrw;

    private String rssHeadline;     //ToDo: date,
    private String rssText;

    private String rssInfo;

    public Data(Integer viewType, Integer tempInCel, String tempCity, String tempDayTmrw, Integer tempInCelTmrw) {
        this.viewType = viewType;
        this.tempInCel = tempInCel;
        this.tempCity = tempCity;
        this.tempDayTmrw = tempDayTmrw;
        this. tempInCelTmrw = tempInCelTmrw;
    }

    public Data(Integer viewType, String rssHeadline, String rssText, String rssInfo) {
        this.viewType = viewType;
        this.rssHeadline = rssHeadline;
        this.rssText = rssText;
        this.rssInfo = rssInfo;
    }

    public Integer getViewType() {
        return viewType;
    }

    public String getTempInCel() {return tempInCel.toString();}

    public String getTempCity() {
        return tempCity;
    }

    public String getTempInCelTmrw() {
        return tempInCelTmrw.toString();
    }

    public String getTempDayTmrw() {
        return tempDayTmrw;
    }

    public String getRssHeadline() {
        return rssHeadline;
    }

    public String getRssText() {
        return rssText;
    }

    public String getRssInfo() {
        return rssInfo;
    }

}


