package net.one97.paytm.common.entity.events;

import com.google.gson.a.c;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJREventPickupAddressInfo implements IJRDataModel {
    @c(a = "address")
    private String address;
    @c(a = "google_map_link")
    private String google_map_link;
    @c(a = "message")
    private String message;
    @c(a = "terms")
    private String terms;

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getGoogleMapLink() {
        return this.google_map_link;
    }

    public void setGoogleMapLink(String str) {
        this.google_map_link = str;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String getTerms() {
        return this.terms;
    }

    public void setTerms(String str) {
        this.terms = str;
    }
}
