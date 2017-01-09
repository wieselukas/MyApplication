package data;

/**
 * Created by Vitus on 18.12.2016.
 */

public class FeedEntry {
    private String title;
    private String link;
    private String description;
    private String pubDate;
    private String thumbnailUrl;

    public String getTitle() {
        return title;
    }

    public int getViewType(){
        return 1;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}