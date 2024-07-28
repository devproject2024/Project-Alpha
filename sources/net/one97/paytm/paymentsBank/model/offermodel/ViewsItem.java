package net.one97.paytm.paymentsBank.model.offermodel;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class ViewsItem extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "end_time")
    private String endTime;
    @b(a = "id")
    private int id;
    @b(a = "image_url")
    private String imageUrl;
    @b(a = "items")
    private List<ItemsItem> items;
    @b(a = "landing_page_meta_flag")
    private int landingPageMetaFlag;
    @b(a = "layout")
    private Layout layout;
    @b(a = "manage_by_engage")
    private int manageByEngage;
    @b(a = "meta_layout")
    private MetaLayout metaLayout;
    @b(a = "priority")
    private int priority;
    @b(a = "seourl")
    private String seourl;
    @b(a = "start_time")
    private String startTime;
    @b(a = "subtitle")
    private String subtitle;
    @b(a = "title")
    private String title;
    @b(a = "type")
    private String type;

    public void setManageByEngage(int i2) {
        this.manageByEngage = i2;
    }

    public int getManageByEngage() {
        return this.manageByEngage;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public Object getEndTime() {
        return this.endTime;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getType() {
        return this.type;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setPriority(int i2) {
        this.priority = i2;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setLayout(Layout layout2) {
        this.layout = layout2;
    }

    public Layout getLayout() {
        return this.layout;
    }

    public void setStartTime(String str) {
        this.startTime = str;
    }

    public Object getStartTime() {
        return this.startTime;
    }

    public void setSeourl(String str) {
        this.seourl = str;
    }

    public Object getSeourl() {
        return this.seourl;
    }

    public void setLandingPageMetaFlag(int i2) {
        this.landingPageMetaFlag = i2;
    }

    public int getLandingPageMetaFlag() {
        return this.landingPageMetaFlag;
    }

    public void setSubtitle(String str) {
        this.subtitle = str;
    }

    public String getSubtitle() {
        return this.subtitle;
    }

    public void setId(int i2) {
        this.id = i2;
    }

    public int getId() {
        return this.id;
    }

    public void setItems(List<ItemsItem> list) {
        this.items = list;
    }

    public List<ItemsItem> getItems() {
        return this.items;
    }

    public void setMetaLayout(MetaLayout metaLayout2) {
        this.metaLayout = metaLayout2;
    }

    public MetaLayout getMetaLayout() {
        return this.metaLayout;
    }
}
