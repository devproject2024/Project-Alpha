package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class TollMetaDataModel extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "back_rc_id")
    private String back_rc_id;
    @b(a = "contact_email")
    private String contact_email;
    @b(a = "contact_phone")
    private String contact_phone;
    @b(a = "front_rc_id")
    private String front_rc_id;
    @b(a = "vehicle_registrtion_number")
    private String vehicle_registrtion_number;

    public String getVehicle_registrtion_number() {
        return this.vehicle_registrtion_number;
    }

    public void setVehicle_registrtion_number(String str) {
        this.vehicle_registrtion_number = str;
    }

    public String getFront_rc_id() {
        return this.front_rc_id;
    }

    public void setFront_rc_id(String str) {
        this.front_rc_id = str;
    }

    public String getBack_rc_id() {
        return this.back_rc_id;
    }

    public void setBack_rc_id(String str) {
        this.back_rc_id = str;
    }

    public String getContactEmail() {
        return this.contact_email;
    }

    public void setContactEmail(String str) {
        this.contact_email = str;
    }

    public String getContact_phone() {
        return this.contact_phone;
    }

    public void setContact_phone(String str) {
        this.contact_phone = str;
    }
}
