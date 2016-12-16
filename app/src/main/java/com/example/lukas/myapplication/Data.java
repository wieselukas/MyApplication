package com.example.lukas.myapplication;

import android.graphics.drawable.Drawable;

/**
 * Created by Lukas on 19.11.2016.
 */

public class Data {
    private Integer viewType;        //possible: ToDo: Number description

    private Integer tempInCel;       //ToDo: City, Temperature next day

    private String tempCity;
    private String tempDayTmrw;
    private Integer tempInCelTmrw;



    private String tempIcon;

    private String rssHeadline;     //ToDo: date,
    private String rssText;

    private String rssInfo;

    public Data(Integer viewType, Integer tempInCel, String tempCity, String tempDayTmrw, Integer tempInCelTmrw, String tempIcon) {
        this.viewType = viewType;
        this.tempInCel = tempInCel;
        this.tempCity = tempCity;
        this.tempDayTmrw = tempDayTmrw;
        this.tempInCelTmrw = tempInCelTmrw;
        this.tempIcon = tempIcon;
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

    public String getTempInCel() {return tempInCel.toString()+"°C";}

    public String getTempCity() {
        return tempCity;
    }

    public String getTempInCelTmrw() {
        return tempInCelTmrw.toString()+"°C";
    }

    public String getTempDayTmrw() {
        return tempDayTmrw;
    }

    public int getTempIcon() {
        switch(tempIcon){
            case "01": return R.drawable.i01;
            case "02": return R.drawable.i02;
            case "03": return R.drawable.i03;
            case "04": return R.drawable.i04;
            case "09": return R.drawable.i09;
            case "10": return R.drawable.i10;
            case "11": return R.drawable.i11;
            case "13": return R.drawable.i13;
            case "50": return R.drawable.i50;
            default: return R.drawable.i03;
        }
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


