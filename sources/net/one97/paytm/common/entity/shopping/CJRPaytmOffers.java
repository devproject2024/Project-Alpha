package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRPaytmOffers implements IJRDataModel {
    @b(a = "offer_description")
    private String offerDescription;
    @b(a = "offer_icon")
    private String offerIcon;
    @b(a = "offer_name")
    private String offerName;
    @b(a = "offer_text")
    private String offerText;
    @b(a = "offer_url")
    private String offerUrl;
    private transient List<CJRPaytmOffers> otherBankOffers;

    public String getOfferName() {
        return this.offerName;
    }

    public void setOfferName(String str) {
        this.offerName = str;
    }

    public String getOfferIcon() {
        return this.offerIcon;
    }

    public void setOfferIcon(String str) {
        this.offerIcon = str;
    }

    public String getOfferText() {
        return this.offerText;
    }

    public void setOfferText(String str) {
        this.offerText = str;
    }

    public String getOfferDescription() {
        return this.offerDescription;
    }

    public void setOfferDescription(String str) {
        this.offerDescription = str;
    }

    public String getOfferUrl() {
        return this.offerUrl;
    }

    public void setOfferUrl(String str) {
        this.offerUrl = str;
    }

    public List<CJRPaytmOffers> getOtherBankOffers() {
        return this.otherBankOffers;
    }

    public void setOtherBankOffers(List<CJRPaytmOffers> list) {
        this.otherBankOffers = list;
    }
}
