package net.one97.paytm.recharge.model;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

@Deprecated
public class CJRDevotionMetaData implements IJRDataModel {
    @b(a = "Amount")
    private String amount;
    @b(a = "Description")
    private String description;
    @b(a = "devotional_place")
    private String devotionalPlace;
    @b(a = "location")
    private String location;
    @b(a = "offering_type")
    private String offeringType;
    @b(a = "On Behalf Of")
    private String onBehafOf;

    public String getOnBehafOf() {
        return this.onBehafOf;
    }

    public String getDescription() {
        return this.description;
    }

    public String getAmount() {
        return this.amount;
    }

    public String getLocation() {
        return this.location;
    }

    public String getDevotionalPlace() {
        return this.devotionalPlace;
    }

    public String getOfferingType() {
        return this.offeringType;
    }
}
