package net.one97.paytm.recharge.model.rechargeutility;

import com.google.gson.a.a;
import com.google.gsonhtcfix.a.b;
import java.util.List;

public class CJRBowsePlanGroupingListV8 {
    private String disclaimer;
    @b(a = "fetchDynamic")
    @a
    private Integer fetchDynamic;
    @b(a = "filter")
    @a
    private String filter;
    @b(a = "hasMore")
    @a
    private Integer hasMore;
    @b(a = "image_url")
    @a
    private String imageUrl;
    private boolean isOneToOne;
    @b(a = "level")
    @a
    private Integer level;
    @b(a = "name")
    @a
    private String name;
    @b(a = "priority")
    @a
    private Integer priority;
    @b(a = "productList")
    @a
    private List<CJRBrowsePlanProductList> productList = null;
    private boolean stopLoading = false;
    @b(a = "tag_label_color")
    @a
    private String tagLabelColor;
    @b(a = "tag_label_name")
    @a
    private String tagLabelName;
    @b(a = "url_type")
    @a
    private Object urlType;
    @b(a = "visibility")
    @a
    private Integer visibility;

    public String getFilter() {
        return this.filter;
    }

    public void setFilter(String str) {
        this.filter = str;
    }

    public String getTagLabelName() {
        return this.tagLabelName;
    }

    public void setTagLabelName(String str) {
        this.tagLabelName = str;
    }

    public Integer getVisibility() {
        return this.visibility;
    }

    public void setVisibility(Integer num) {
        this.visibility = num;
    }

    public Integer getLevel() {
        return this.level;
    }

    public void setLevel(Integer num) {
        this.level = num;
    }

    public String getTagLabelColor() {
        return this.tagLabelColor;
    }

    public void setTagLabelColor(String str) {
        this.tagLabelColor = str;
    }

    public Object getUrlType() {
        return this.urlType;
    }

    public void setUrlType(Object obj) {
        this.urlType = obj;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public Integer getHasMore() {
        return this.hasMore;
    }

    public void setHasMore(Integer num) {
        this.hasMore = num;
    }

    public Integer getPriority() {
        return this.priority;
    }

    public void setPriority(Integer num) {
        this.priority = num;
    }

    public Integer getFetchDynamic() {
        return this.fetchDynamic;
    }

    public void setFetchDynamic(Integer num) {
        this.fetchDynamic = num;
    }

    public List<CJRBrowsePlanProductList> getProductList() {
        return this.productList;
    }

    public void setProductList(List<CJRBrowsePlanProductList> list) {
        this.productList = list;
    }

    public void setIsOneToOne(boolean z) {
        this.isOneToOne = z;
    }

    public boolean isOneToOne() {
        return this.isOneToOne;
    }

    public void setDisclaimer(String str) {
        this.disclaimer = str;
    }

    public String getDisclaimer() {
        return this.disclaimer;
    }

    public boolean isStopLoading() {
        return this.stopLoading;
    }

    public void setStopLoading(boolean z) {
        this.stopLoading = z;
    }
}
