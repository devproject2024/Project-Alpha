package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJREmiOffers implements IJRDataModel {
    @b(a = "additional_text")
    private String additional_text;
    @b(a = "no_cost_emi")
    private boolean noCostEmi;
    @b(a = "offer_description")
    private String offerDescription;
    @b(a = "offer_icon")
    private String offerIcon;
    @b(a = "offer_text")
    private String offerText;
    @b(a = "offer_url")
    private String offerUrl;
    @b(a = "plans")
    private ArrayList<CJREmiPlans> plans;

    public String getOfferUrl() {
        return this.offerUrl;
    }

    public void setOfferUrl(String str) {
        this.offerUrl = str;
    }

    public String getOfferText() {
        return this.offerText;
    }

    public void setOfferText(String str) {
        this.offerText = str;
    }

    public String getOfferIcon() {
        return this.offerIcon;
    }

    public void setOfferIcon(String str) {
        this.offerIcon = str;
    }

    public boolean isNoCostEmi() {
        return this.noCostEmi;
    }

    public void setNoCostEmi(boolean z) {
        this.noCostEmi = z;
    }

    public String getAdditional_text() {
        return this.additional_text;
    }

    public void setAdditional_text(String str) {
        this.additional_text = str;
    }

    public String getOfferDescription() {
        return this.offerDescription;
    }

    public void setOfferDescription(String str) {
        this.offerDescription = str;
    }

    public ArrayList<CJREmiPlans> getPlans() {
        return this.plans;
    }

    public void setPlans(ArrayList<CJREmiPlans> arrayList) {
        this.plans = arrayList;
    }
}
