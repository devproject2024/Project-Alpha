package net.one97.paytm.common.entity.movies.moviepass;

import com.google.gsonhtcfix.a.b;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMoviePassModel implements IJRDataModel {
    private Object FAQ;
    private List<String> benefits;
    private String campaignName;
    @b(a = "_id")
    private String dbId;
    private String description;
    private List<String> features;
    private CJRMoviePassGeneralDetail general;
    private String heading;
    private boolean isAvailable;
    private int isEnabled;
    @b(a = "quotaAlloted")
    private int maximumPassesAllowed;
    private String merchantId;
    private int passesLeft;
    private int passesSold;
    private String paytmCityId;
    @b(a = "price")
    private CJRMoviePassPriceModel priceList;
    private String productId;
    private String productImage;
    private String quotaLabel;
    private Object redeemSteps;
    private String savingsLabel;
    @b(a = "terms&Conditions")
    private Object tnc;
    private String totalPrice;
    private String valadityLabel;
    private int validityDays;
    private int verticalId;

    public String getDbId() {
        return this.dbId;
    }

    public String getProductId() {
        return this.productId;
    }

    public String getPaytmCityId() {
        return this.paytmCityId;
    }

    public String getMerchantId() {
        return this.merchantId;
    }

    public String getCampaignName() {
        return this.campaignName;
    }

    public String getHeading() {
        return this.heading;
    }

    public String getDescription() {
        return this.description;
    }

    public Object getTnc() {
        return this.tnc;
    }

    public Object getFAQ() {
        return this.FAQ;
    }

    public Object getRedeemSteps() {
        return this.redeemSteps;
    }

    public int getIsEnabled() {
        return this.isEnabled;
    }

    public int getPassesLeft() {
        return this.passesLeft;
    }

    public CJRMoviePassPriceModel getPriceList() {
        return this.priceList;
    }

    public int getMaximumPassesAllowed() {
        return this.maximumPassesAllowed;
    }

    public int getValidityDays() {
        return this.validityDays;
    }

    public int getVerticalId() {
        return this.verticalId;
    }

    public int getPassesSold() {
        return this.passesSold;
    }

    public String getTotalPrice() {
        return this.totalPrice;
    }

    public boolean isAvailable() {
        return this.isAvailable;
    }

    public String getProductImage() {
        return this.productImage;
    }

    public CJRMoviePassGeneralDetail getGeneral() {
        return this.general;
    }

    public String getQuotaLabel() {
        return this.quotaLabel;
    }

    public String getValadityLabel() {
        return this.valadityLabel;
    }

    public String getSavingsLabel() {
        return this.savingsLabel;
    }

    public List<String> getBenefits() {
        return this.benefits;
    }

    public List<String> getFeatures() {
        return this.features;
    }
}
