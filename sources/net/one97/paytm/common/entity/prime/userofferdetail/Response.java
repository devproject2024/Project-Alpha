package net.one97.paytm.common.entity.prime.userofferdetail;

import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class Response implements IJRDataModel {
    private Attributes attributes;
    private String background_image_url;
    private String claim_btn_text;
    private ArrayList<ContentShowCase> content_showcase;
    private Boolean is_availed;
    private Boolean is_coupon_available;
    private String merchant_id;
    private String offer_description_text;
    private String offer_duration;
    private String offer_duration_text;
    private String offer_id;
    private String offer_partner_logo;
    private String offer_partner_name;
    private String offer_tag;
    private ArrayList<Offers> offers;
    private OverLayPopUpDetails overlay_popup_details;
    private String partner_offer_claim_screen_url;
    private String plan_id;
    private String plan_name;

    public String getOffer_id() {
        return this.offer_id;
    }

    public String getBackground_image_url() {
        return this.background_image_url;
    }

    public String getOffer_duration_text() {
        return this.offer_duration_text;
    }

    public ArrayList<Offers> getOffers() {
        return this.offers;
    }

    public String getOffer_tag() {
        return this.offer_tag;
    }

    public String getOffer_partner_logo() {
        return this.offer_partner_logo;
    }

    public String getOffer_description_text() {
        return this.offer_description_text;
    }

    public String getPlan_id() {
        return this.plan_id;
    }

    public OverLayPopUpDetails getOverlay_popup_details() {
        return this.overlay_popup_details;
    }

    public String getClaim_btn_text() {
        return this.claim_btn_text;
    }

    public String getOffer_duration() {
        return this.offer_duration;
    }

    public Attributes getAttributes() {
        return this.attributes;
    }

    public String getMerchant_id() {
        return this.merchant_id;
    }

    public ArrayList<ContentShowCase> getContent_showcase() {
        return this.content_showcase;
    }

    public String getOffer_partner_name() {
        return this.offer_partner_name;
    }

    public String getPlan_name() {
        return this.plan_name;
    }

    public Boolean getIs_coupon_available() {
        return this.is_coupon_available;
    }

    public void setIs_coupon_available(Boolean bool) {
        this.is_coupon_available = bool;
    }

    public String getPartner_offer_claim_screen_url() {
        return this.partner_offer_claim_screen_url;
    }

    public void setPartner_offer_claim_screen_url(String str) {
        this.partner_offer_claim_screen_url = str;
    }

    public Boolean getIs_availed() {
        return this.is_availed;
    }

    public void setIs_availed(Boolean bool) {
        this.is_availed = bool;
    }
}
