package net.one97.travelpass.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class InternalOfferData extends IJRPaytmDataModel {
    @b(a = "createdAt")
    private String createdAt;
    @b(a = "createdBy")
    private String createdBy;
    @b(a = "imageUrl")
    private String imageUrl;
    @b(a = "internalOfferId")
    private String internalOfferId;
    @b(a = "internalOfferName")
    private String internalOfferName;
    @b(a = "isClickable")
    private boolean isClickable;
    @b(a = "tncId")
    private String tncId;

    public String getOffersId() {
        return this.internalOfferId;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getTncId() {
        return this.tncId;
    }

    public boolean isClickable() {
        return this.isClickable;
    }

    public String getInternalOfferId() {
        return this.internalOfferId;
    }

    public String getInternalOfferName() {
        return this.internalOfferName;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }
}
