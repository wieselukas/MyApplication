package data;

import com.example.lukas.myapplication.R;

/**
 * Created by Lukas on 19.11.2016.
 * Remodeled by Vitus on 14.01.2017
 */

public class Data {
    private String title;       //for weather: city name
    private String content;     //for Weather: current temperature
    private String link;        //for Weather: link to website
    private String imgInfo;     //for Weather: weather Image
    private String info;        //for weather: temperature for next day, for RSS: Publication date

    public Data(String content, String imgInfo, String info, String link, String title) {
        this.content = content;
        this.imgInfo = imgInfo;
        this.info = info;
        this.link = link;
        this.title = title;
    }

    public Data() {
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setInfo(int info) {
        this.info = Integer.toString(info);
    }

    public int getViewType(){
        return 99;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImgInfo() {
        return imgInfo;
    }

    public int getTempIcon() {
        switch(imgInfo){
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

    public void setImgInfo(String imgInfo) {
        this.imgInfo = imgInfo;
    }

    public void setImgInfo(int imgInfo) {
        this.imgInfo = Integer.toString(imgInfo);
    }
}