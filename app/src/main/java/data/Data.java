package data;

import android.graphics.drawable.Drawable;

import com.example.lukas.myapplication.R;

/**
 * Created by Lukas on 19.11.2016.
 */

public class Data {
    private Integer viewType;       //Layout

    private Integer tempInCel;      //temperature in Celsius

    private String tempCity;        //City as a text
    private String tempDayTmrw;     //Day of Tomorrow as a Text (eg.: "Mo")
    private Integer tempInCelTmrw;  //Temperature of Tomorrow
    private String tempIcon;        //number of Icon (eg.: "092")

    private String rssHeadline;     //Headline of RSS Message
    private String rssText;         //Example Text of RSS Message
    private String rssInfo;         //summarized info text

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


