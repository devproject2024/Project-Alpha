package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRLifafa extends IJRPaytmDataModel {
    public static final String LIFAFA_TYPE_CASHBACK = "CASHBACK";
    public static final String LIFAFA_TYPE_CROSSPROMO = "CROSSPROMO";
    public static final String LIFAFA_TYPE_DEAL = "DEAL";
    public static final String LIFAFA_TYPE_GOLDBACK = "GOLDBACK";
    public static final String LIFAFA_TYPE_NOT_LUCKY = "NOTLUCKY";
    public static final String LIFAFA_TYPE_SKU = "SKU";
    @b(a = "theme_url")
    private String backgroundImgUrl;
    @b(a = "buttonText")
    private String buttonText;
    @b(a = "deepLink1")
    private String deepLink1;
    @b(a = "deepLink2")
    private String deepLink2;
    @b(a = "failure_text")
    private String failureText;
    @b(a = "full_text")
    private String fullText;
    @b(a = "hasOfferText")
    private int hasOffertext = 0;
    @b(a = "hasTnc")
    private int hasTnc = 0;
    @b(a = "deal")
    private CJRLifafaOffer lifafaDeal;
    @b(a = "offer")
    private CJRLifafaOffer lifafaOffer;
    @b(a = "type")
    private String lifafaType;
    @b(a = "voucher")
    private CJRLifafaOffer lifafaVoucher;
    @b(a = "offerText")
    private String offerText;
    @b(a = "tnc_text")
    private String tncText;
    @b(a = "tnc_URL")
    private String tncUrl;
    @b(a = "text1")
    private String txt1;
    @b(a = "text2")
    private String txt2;

    public String getFailureText() {
        return this.failureText;
    }

    public String getFullText() {
        return this.fullText;
    }

    public String getLifafaType() {
        return this.lifafaType;
    }

    public CJRLifafaOffer getLifafaOffer() {
        return this.lifafaOffer;
    }

    public CJRLifafaOffer getLifafaDeal() {
        return this.lifafaDeal;
    }

    public CJRLifafaOffer getLifafaVoucher() {
        return this.lifafaVoucher;
    }

    public String getTxt1() {
        return this.txt1;
    }

    public String getTxt2() {
        return this.txt2;
    }

    public boolean getHasTnc() {
        return this.hasTnc == 1;
    }

    public boolean getHasOffertext() {
        return this.hasOffertext == 1;
    }

    public String getTncText() {
        return this.tncText;
    }

    public String getTncUrl() {
        return this.tncUrl;
    }

    public String getOfferText() {
        return this.offerText;
    }

    public String getButtonText() {
        return this.buttonText;
    }

    public String getDeepLink1() {
        return this.deepLink1;
    }

    public String getDeepLink2() {
        return this.deepLink2;
    }

    public String getBackgroundImgUrl() {
        return this.backgroundImgUrl;
    }

    public void setBackgroundImgUrl(String str) {
        this.backgroundImgUrl = str;
    }
}
