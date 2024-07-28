package net.one97.paytm.common.entity.inbox.news;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.LinkedList;
import net.one97.paytm.common.entity.inbox.InboxCategories;
import net.one97.paytm.common.entity.inbox.videos.NewsFeedVideoCardModel;

public class CardInfoModel extends IJRPaytmDataModel {
    private String category;
    private LinkedList<InboxCategories> cateogries;
    private long createdAt;
    private String description;
    private String id;
    private String imageUrl;
    private String language;
    private LinkedList<NewsFeedVideoCardModel> listing;
    private String site;
    private String source;
    private String sourceLink;
    private String title;
    private long updatedAt;
    private String url;

    public String getSource() {
        return this.source;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public String getSite() {
        return this.site;
    }

    public void setSite(String str) {
        this.site = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(long j) {
        this.createdAt = j;
    }

    public LinkedList<InboxCategories> getCateogries() {
        return this.cateogries;
    }

    public void setCateogries(LinkedList<InboxCategories> linkedList) {
        this.cateogries = linkedList;
    }

    public LinkedList<NewsFeedVideoCardModel> getVideoCard() {
        return this.listing;
    }

    public void setVideoCard(LinkedList<NewsFeedVideoCardModel> linkedList) {
        this.listing = linkedList;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public long getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(long j) {
        this.updatedAt = j;
    }

    public String getSourceLink() {
        return this.sourceLink;
    }

    public void setSourceLink(String str) {
        this.sourceLink = str;
    }
}
