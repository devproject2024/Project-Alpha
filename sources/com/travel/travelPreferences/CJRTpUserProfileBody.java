package com.travel.travelPreferences;

import com.google.gson.a.c;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTpUserProfileBody implements IJRDataModel {
    @c(a = "cancellation_insurance")
    private Boolean cancellationInsurance;
    @c(a = "contacts")
    private ArrayList<CJRBusTpUserProfileContact> contacts;
    @c(a = "gst")
    private CJRTpGst gst;
    @c(a = "travel_insurance")
    private Boolean travelInsurance;

    public ArrayList<CJRBusTpUserProfileContact> getContacts() {
        return this.contacts;
    }

    public void setContacts(ArrayList<CJRBusTpUserProfileContact> arrayList) {
        this.contacts = arrayList;
    }

    public Boolean isTravelInsurance() {
        return this.travelInsurance;
    }

    public Boolean isCancellationInsurance() {
        return this.cancellationInsurance;
    }

    public CJRTpGst getGst() {
        return this.gst;
    }
}
