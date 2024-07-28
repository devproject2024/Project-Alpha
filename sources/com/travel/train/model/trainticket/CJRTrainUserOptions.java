package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainUserOptions implements IJRDataModel {
    @b(a = "auto_upgrade")
    private boolean autoUpgrade;
    @b(a = "coach_id")
    private String coachId;
    @b(a = "contact_email")
    private String contactEmail;
    @b(a = "contact_mobile")
    private String contactMobile;
    @b(a = "gst_details")
    private CJRTrainGstDetails gstDetails;
    @b(a = "irctc_user_id")
    private String irctcUserId;
    @b(a = "reservation_choice")
    private int reservationChoice;
    @b(a = "user_email")
    private String userEmail;
    @b(a = "user_mobile")
    private String userMobile;

    public String getIrctcUserId() {
        return this.irctcUserId;
    }

    public int getReservationChoice() {
        return this.reservationChoice;
    }

    public boolean getAutoUpgrade() {
        return this.autoUpgrade;
    }

    public String getCoachId() {
        return this.coachId;
    }

    public CJRTrainGstDetails getGstDetails() {
        return this.gstDetails;
    }

    public String getUserMobile() {
        return this.userMobile;
    }

    public String getUserEmail() {
        return this.userEmail;
    }

    public String getContactEmail() {
        return this.contactEmail;
    }

    public String getContactMobile() {
        return this.contactMobile;
    }
}
