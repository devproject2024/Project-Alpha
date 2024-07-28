package net.one97.paytm.paymentsBank.model.offermodel;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class ItemsItem extends IJRPaytmDataModel implements IJRDataModel {
    @c(a = "alt_image_url")
    private Object altImageUrl;
    @c(a = "end_time")
    private Object endTime;
    @c(a = "ga_category")
    private String gaCategory;
    @c(a = "id")
    private int id;
    @c(a = "image_url")
    private String imageUrl;
    @c(a = "item_id")
    private int itemId;
    @c(a = "metadata")
    private Metadata metadata;
    @c(a = "name")
    private String name;
    @c(a = "newurl")
    private String newurl;
    @c(a = "priority")
    private int priority;
    @c(a = "seourl")
    private String seourl;
    @c(a = "source")
    private String source;
    @c(a = "start_time")
    private Object startTime;
    @c(a = "subtitle")
    private String subtitle;
    @c(a = "title")
    private String title;
    @c(a = "url")
    private String url;
    @c(a = "url_info")
    private String urlInfo;
    @c(a = "url_key")
    private String urlKey;
    @c(a = "url_type")
    private String urlType;

    public void setMetadata(Metadata metadata2) {
        this.metadata = metadata2;
    }

    public Metadata getMetadata() {
        return this.metadata;
    }

    public void setItemId(int i2) {
        this.itemId = i2;
    }

    public int getItemId() {
        return this.itemId;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setUrlType(String str) {
        this.urlType = str;
    }

    public String getUrlType() {
        return this.urlType;
    }

    public void setEndTime(Object obj) {
        this.endTime = obj;
    }

    public Object getEndTime() {
        return this.endTime;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public String getSource() {
        return this.source;
    }

    public void setPriority(int i2) {
        this.priority = i2;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrlKey(String str) {
        this.urlKey = str;
    }

    public String getUrlKey() {
        return this.urlKey;
    }

    public void setStartTime(Object obj) {
        this.startTime = obj;
    }

    public Object getStartTime() {
        return this.startTime;
    }

    public void setSeourl(String str) {
        this.seourl = str;
    }

    public String getSeourl() {
        return this.seourl;
    }

    public void setAltImageUrl(Object obj) {
        this.altImageUrl = obj;
    }

    public Object getAltImageUrl() {
        return this.altImageUrl;
    }

    public void setNewurl(String str) {
        this.newurl = str;
    }

    public String getNewurl() {
        return this.newurl;
    }

    public void setSubtitle(String str) {
        this.subtitle = str;
    }

    public String getSubtitle() {
        return this.subtitle;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    public void setUrlInfo(String str) {
        this.urlInfo = str;
    }

    public String getUrlInfo() {
        return this.urlInfo;
    }

    public void setId(int i2) {
        this.id = i2;
    }

    public int getId() {
        return this.id;
    }

    public void setGaCategory(String str) {
        this.gaCategory = str;
    }

    public String getGaCategory() {
        return this.gaCategory;
    }

    public String toString() {
        return "StoreFrontItem{metadata = '" + this.metadata + '\'' + ",item_id = '" + this.itemId + '\'' + ",image_url = '" + this.imageUrl + '\'' + ",url_type = '" + this.urlType + '\'' + ",end_time = '" + this.endTime + '\'' + ",source = '" + this.source + '\'' + ",priority = '" + this.priority + '\'' + ",title = '" + this.title + '\'' + ",url = '" + this.url + '\'' + ",url_key = '" + this.urlKey + '\'' + ",start_time = '" + this.startTime + '\'' + ",seourl = '" + this.seourl + '\'' + ",alt_image_url = '" + this.altImageUrl + '\'' + ",newurl = '" + this.newurl + '\'' + ",subtitle = '" + this.subtitle + '\'' + ",name = '" + this.name + '\'' + ",url_info = '" + this.urlInfo + '\'' + ",id = '" + this.id + '\'' + ",ga_category = '" + this.gaCategory + '\'' + "}";
    }
}
