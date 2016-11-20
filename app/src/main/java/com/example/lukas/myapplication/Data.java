package com.example.lukas.myapplication;

/**
 * Created by Lukas on 19.11.2016.
 */

public class Data {
    private Integer viewType;        //possible: weather, rss
    private Integer tempInCel;

    private String rssHeadline;
    private String rssText;

    public Data(Integer viewType, Integer tempInCel) {
        this.viewType = viewType;
        this.tempInCel = tempInCel;
    }

    public Data(Integer viewType, String rssHeadline, String rssText) {
        this.viewType = viewType;
        this.rssHeadline = rssHeadline;
        this.rssText = rssText;
    }

    public Integer getViewType() {
        return viewType;
    }

    public String getTempInCel() {return tempInCel.toString();}

    public String getRssHeadline() {
        return rssHeadline;
    }

    public String getRssText() {
        return rssText;
    }
}


