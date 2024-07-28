package net.one97.paytm.common.entity.movies.moviepass;

import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRPrevalidateMoviePassModel implements IJRDataModel {
    private CJRMoviePassModel data;
    private String passId;
    private String paytmCityId;
    private String totalChargedPrice;

    public CJRPrevalidateMoviePassModel(String str, String str2, String str3, CJRMoviePassModel cJRMoviePassModel) {
        this.passId = str;
        this.paytmCityId = str2;
        this.totalChargedPrice = str3;
        this.data = cJRMoviePassModel;
    }

    public final String getPassId() {
        return this.passId;
    }

    public final void setPassId(String str) {
        this.passId = str;
    }

    public final String getPaytmCityId() {
        return this.paytmCityId;
    }

    public final void setPaytmCityId(String str) {
        this.paytmCityId = str;
    }

    public final String getTotalChargedPrice() {
        return this.totalChargedPrice;
    }

    public final void setTotalChargedPrice(String str) {
        this.totalChargedPrice = str;
    }

    public final CJRMoviePassModel getData() {
        return this.data;
    }

    public final void setData(CJRMoviePassModel cJRMoviePassModel) {
        this.data = cJRMoviePassModel;
    }
}
