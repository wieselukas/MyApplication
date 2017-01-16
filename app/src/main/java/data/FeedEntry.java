package data;

/**
 * Created by Vitus on 18.12.2016.
 */

public class FeedEntry extends Data {
    public FeedEntry(String content, String imgInfo, String info, String link, String title) {
        super(content, imgInfo, info, link, title);
    }

    public FeedEntry() {
    }

    @Override
    public int getViewType(){
        return 1;
    }

}