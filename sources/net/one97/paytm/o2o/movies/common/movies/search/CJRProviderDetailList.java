package net.one97.paytm.o2o.movies.common.movies.search;

import com.google.gsonhtcfix.a.b;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRProviderDetailList implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "appCoverImageUrl")
    private String appCoverImageUrl;
    @b(a = "cinemas")
    private List<Integer> cinemas = null;
    @b(a = "coverImageUrl")
    private String coverImageUrl;
    @b(a = "providerId")
    private Integer providerId;
    @b(a = "providerName")
    private String providerName;

    public List<Integer> getCinemas() {
        return this.cinemas;
    }

    public void setCinemas(List<Integer> list) {
        this.cinemas = list;
    }

    public Integer getProviderId() {
        return this.providerId;
    }

    public void setProviderId(Integer num) {
        this.providerId = num;
    }

    public String getProviderName() {
        return this.providerName;
    }

    public void setProviderName(String str) {
        this.providerName = str;
    }

    public String getCoverImageUrl() {
        return this.coverImageUrl;
    }

    public void setCoverImageUrl(String str) {
        this.coverImageUrl = str;
    }

    public String getAppCoverImageUrl() {
        return this.appCoverImageUrl;
    }

    public void setAppCoverImageUrl(String str) {
        this.appCoverImageUrl = str;
    }
}
