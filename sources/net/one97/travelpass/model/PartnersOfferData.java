package net.one97.travelpass.model;

import com.paytm.network.model.IJRPaytmDataModel;

public class PartnersOfferData extends IJRPaytmDataModel {
    private String brandLogoUrl;
    private String createdAt;
    private String createdBy;
    private String imageUrl;
    private boolean isClickable;
    private String mergedImage;
    private String partnerOfferId;
    private String partnerOfferName;
    private int position;
    private int promoCodeCount;
    private String promocode;
    private boolean status;
    private String tncId;
    private String webLink;

    public String getPartnerOfferId() {
        return this.partnerOfferId;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getBrandLogoUrl() {
        return this.brandLogoUrl;
    }

    public String getTncId() {
        return this.tncId;
    }

    public boolean isClickable() {
        return this.isClickable;
    }

    public boolean isStatus() {
        return this.status;
    }

    public int getPosition() {
        return this.position;
    }

    public String getMergedImageUrl() {
        return this.mergedImage;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public String getWebLink() {
        return this.webLink;
    }

    public String getPartnerOfferName() {
        return this.partnerOfferName;
    }

    public int getPromoCodeCount() {
        return this.promoCodeCount;
    }

    public String getMergedImage() {
        return this.mergedImage;
    }

    public String getPromocode() {
        return this.promocode;
    }

    public void setPromocode(String str) {
        this.promocode = str;
    }
}
