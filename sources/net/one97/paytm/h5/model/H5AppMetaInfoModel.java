package net.one97.paytm.h5.model;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class H5AppMetaInfoModel implements IJRDataModel {
    @b(a = "category_id")
    private String categoryId;
    @b(a = "category_name")
    private String categoryName;
    @b(a = "startup_params")
    private H5AppStartupParamsModel startupParams;
    @b(a = "subtitle")
    private String subtitle;
    @b(a = "title")
    private String title;
    @b(a = "url")
    private H5AppUrlInfoModel urlMetaInfo;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getSubtitle() {
        return this.subtitle;
    }

    public void setSubtitle(String str) {
        this.subtitle = str;
    }

    public H5AppUrlInfoModel getUrlMetaInfo() {
        return this.urlMetaInfo;
    }

    public void setUrlMetaInfo(H5AppUrlInfoModel h5AppUrlInfoModel) {
        this.urlMetaInfo = h5AppUrlInfoModel;
    }

    public String getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(String str) {
        this.categoryId = str;
    }

    public H5AppStartupParamsModel getStartupParams() {
        return this.startupParams;
    }

    public void setStartupParams(H5AppStartupParamsModel h5AppStartupParamsModel) {
        this.startupParams = h5AppStartupParamsModel;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public void setCategoryName(String str) {
        this.categoryName = str;
    }

    public String toString() {
        return "H5AppMetaInfoModel{title='" + this.title + '\'' + ", subtitle='" + this.subtitle + '\'' + ", urlMetaInfo=" + this.urlMetaInfo + ", categoryId='" + this.categoryId + '\'' + ", startupParams=" + this.startupParams + ", categoryName='" + this.categoryName + '\'' + '}';
    }
}
