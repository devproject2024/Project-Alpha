package com.travel.train.model.travellerProfile.model;

import com.google.gson.a.c;
import com.travel.train.travellerProfile.travel.CJRTpUserProfileContact;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTpUserProfileBody implements IJRDataModel {
    @c(a = "cancellation_insurance")
    private Boolean cancellationInsurance;
    @c(a = "contacts")
    private ArrayList<CJRTpUserProfileContact> contacts;
    @c(a = "travel_insurance")
    private Boolean travelInsurance;

    public ArrayList<CJRTpUserProfileContact> getContacts() {
        return this.contacts;
    }

    public Boolean isTravelInsurance() {
        return this.travelInsurance;
    }

    public Boolean isCancellationInsurance() {
        return this.cancellationInsurance;
    }
}
