package net.one97.paytm.o2o.movies.common.movies.search;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRIMAXDifferenceModel implements IJRDataModel {
    @b(a = "content")
    private String mDifferenceContent;
    @b(a = "banner_url")
    private String mDifferenceImageUrl;
    @b(a = "name")
    private String mDifferenceName;

    public String getDifferenceName() {
        return this.mDifferenceName;
    }

    public void setDifferenceName(String str) {
        this.mDifferenceName = str;
    }

    public String getDifferenceImageUrl() {
        return this.mDifferenceImageUrl;
    }

    public void setDifferenceImageUrl(String str) {
        this.mDifferenceImageUrl = str;
    }

    public String getDifferenceContent() {
        return this.mDifferenceContent;
    }

    public void setDifferenceContent(String str) {
        this.mDifferenceContent = str;
    }
}
