package net.one97.paytm.common.entity.vipcashback;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.cashback.posttxn.CashBackBaseModal;

public class SourceMetaData extends CashBackBaseModal {
    @b(a = "deeplink")
    private String deeplink;
    @b(a = "offerDescription")
    private String offerDescription;
    @b(a = "offerIconUrl")
    private String offerIconUrl;
    @b(a = "offerId")
    private String offerId;
    @b(a = "offerName")
    private String offerName;
    @b(a = "stage")
    private String stage;
    @b(a = "type")
    private String type;

    public String getOfferName() {
        return this.offerName;
    }

    public void setOfferName(String str) {
        this.offerName = str;
    }

    public String getStage() {
        return this.stage;
    }

    public void setStage(String str) {
        this.stage = str;
    }

    public String getOfferDescription() {
        return this.offerDescription;
    }

    public void setOfferDescription(String str) {
        this.offerDescription = str;
    }

    public String getDeeplink() {
        return this.deeplink;
    }

    public void setDeeplink(String str) {
        this.deeplink = str;
    }

    public String getOfferId() {
        return this.offerId;
    }

    public void setOfferId(String str) {
        this.offerId = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getOfferIconUrl() {
        return this.offerIconUrl;
    }

    public void setOfferIconUrl(String str) {
        this.offerIconUrl = str;
    }
}
