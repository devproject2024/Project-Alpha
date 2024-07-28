package net.one97.paytmflight.common.entity.flightticket;

import net.one97.paytm.common.entity.IJRDataModel;

public class BundleCard implements IJRDataModel {
    private String background_image_url;
    private boolean is_pending;
    private String promo_code;
    private String promo_code_validity;
    private String promo_title;
    private String promo_use_hint;
    private String terms_condition_url;
    private String title;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public boolean isIs_pending() {
        return this.is_pending;
    }

    public void setIs_pending(boolean z) {
        this.is_pending = z;
    }

    public String getPromo_title() {
        return this.promo_title;
    }

    public void setPromo_title(String str) {
        this.promo_title = str;
    }

    public String getPromo_code() {
        return this.promo_code;
    }

    public void setPromo_code(String str) {
        this.promo_code = str;
    }

    public String getPromo_code_validity() {
        return this.promo_code_validity;
    }

    public void setPromo_code_validity(String str) {
        this.promo_code_validity = str;
    }

    public String getPromo_use_hint() {
        return this.promo_use_hint;
    }

    public void setPromo_use_hint(String str) {
        this.promo_use_hint = str;
    }

    public String getBackground_image_url() {
        return this.background_image_url;
    }

    public void setBackground_image_url(String str) {
        this.background_image_url = str;
    }

    public String getTerms_condition_url() {
        return this.terms_condition_url;
    }

    public void setTerms_condition_url(String str) {
        this.terms_condition_url = str;
    }
}
