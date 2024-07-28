package net.one97.paytm.o2o.movies.common.movies.moviepass;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMoviePassStorefrontDataModel implements IJRDataModel {
    @b(a = "city_id")
    private Integer cityId;
    @b(a = "_id")
    private String id;
    @b(a = "is_cinema_list_enabled")
    private boolean isCinemaListEnabled;
    @b(a = "is_faq_enabled")
    private boolean isFaqEnabled;
    @b(a = "is_how_to_redeem_enabled")
    private boolean isHowToRedeemEnabled;
    @b(a = "is_movie_list_enabled")
    private boolean isMovieListEnabled;
    private boolean is_enabled;
    @b(a = "movie_pass_benefits")
    private CJRMoviePassBenefitsModel moviePassBenefit;
    @b(a = "brand_promotion")
    private CJRMoviePassBrandPromotionModel moviePassBrandPromotion;

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public Integer getCityId() {
        return this.cityId;
    }

    public void setCityId(Integer num) {
        this.cityId = num;
    }

    public boolean isMovieListEnabled() {
        return this.isMovieListEnabled;
    }

    public void setMovieListEnabled(boolean z) {
        this.isMovieListEnabled = z;
    }

    public boolean isCinemaListEnabled() {
        return this.isCinemaListEnabled;
    }

    public void setCinemaListEnabled(boolean z) {
        this.isCinemaListEnabled = z;
    }

    public boolean isHowToRedeemEnabled() {
        return this.isHowToRedeemEnabled;
    }

    public void setHowToRedeemEnabled(boolean z) {
        this.isHowToRedeemEnabled = z;
    }

    public boolean isFaqEnabled() {
        return this.isFaqEnabled;
    }

    public void setFaqEnabled(boolean z) {
        this.isFaqEnabled = z;
    }

    public CJRMoviePassBenefitsModel getMoviePassBenefit() {
        return this.moviePassBenefit;
    }

    public void setMoviePassBenefit(CJRMoviePassBenefitsModel cJRMoviePassBenefitsModel) {
        this.moviePassBenefit = cJRMoviePassBenefitsModel;
    }

    public CJRMoviePassBrandPromotionModel getMoviePassBrandPromotion() {
        return this.moviePassBrandPromotion;
    }

    public void setMoviePassBrandPromotion(CJRMoviePassBrandPromotionModel cJRMoviePassBrandPromotionModel) {
        this.moviePassBrandPromotion = cJRMoviePassBrandPromotionModel;
    }

    public boolean isIs_enabled() {
        return this.is_enabled;
    }

    public void setIs_enabled(boolean z) {
        this.is_enabled = z;
    }
}
