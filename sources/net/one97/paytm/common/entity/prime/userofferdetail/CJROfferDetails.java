package net.one97.paytm.common.entity.prime.userofferdetail;

import net.one97.paytm.common.entity.IJRDataModel;

public class CJROfferDetails implements IJRDataModel {
    String descriptions;
    boolean isClaimOffer;
    String stepsLabel;

    public CJROfferDetails(String str, boolean z, String str2) {
        this.descriptions = str;
        this.isClaimOffer = z;
        this.stepsLabel = str2;
    }

    public String getDescriptions() {
        return this.descriptions;
    }

    public boolean isClaimOffer() {
        return this.isClaimOffer;
    }

    public String getStepsLabel() {
        return this.stepsLabel;
    }
}
