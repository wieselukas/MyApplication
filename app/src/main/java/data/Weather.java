package data;

/**
 * Created by Vitus on 14.01.2017.
 */

public class Weather extends Data {
    public Weather(String content, String imgInfo, String info, String link, String title) {
        super(content, imgInfo, info, link, title);
    }

    @Override
    public int getViewType(){
        return 0;
    }

}