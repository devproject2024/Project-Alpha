package net.one97.paytm.common.entity.inbox.news;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.LinkedList;

public class NewsFeedModel extends IJRPaytmDataModel {
    private LinkedList<Object> deletedContent = null;
    private LinkedList<Feed> feed;
    private String layoutType;

    public LinkedList<Feed> getFeed() {
        return this.feed;
    }

    public void setFeed(LinkedList<Feed> linkedList) {
        this.feed = linkedList;
    }

    public String getLayoutType() {
        return this.layoutType;
    }

    public void setLayoutType(String str) {
        this.layoutType = str;
    }

    public LinkedList<Object> getDeletedContent() {
        return this.deletedContent;
    }

    public void setDeletedContent(LinkedList<Object> linkedList) {
        this.deletedContent = linkedList;
    }
}
