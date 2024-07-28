package com.travel.bus.pojo;

import com.google.gson.a.c;
import com.travel.bus.pojo.common.entity.travel.CJRBusTpUserProfileContact;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTpUserProfileBody implements IJRDataModel {
    @c(a = "contacts")
    private ArrayList<CJRBusTpUserProfileContact> contacts;

    public ArrayList<CJRBusTpUserProfileContact> getContacts() {
        return this.contacts;
    }
}
