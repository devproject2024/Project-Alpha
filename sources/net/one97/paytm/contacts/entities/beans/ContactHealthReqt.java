package net.one97.paytm.contacts.entities.beans;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class ContactHealthReqt extends IJRPaytmDataModel implements IJRDataModel {
    private ArrayList<Contacts> contacts;
    private String deviceId;

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public ArrayList<Contacts> getContacts() {
        return this.contacts;
    }

    public void setContacts(ArrayList<Contacts> arrayList) {
        this.contacts = arrayList;
    }
}
