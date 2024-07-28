package net.one97.paytm.contacts.utils;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class ContactUpload extends IJRPaytmDataModel implements IJRDataModel {
    private String contactType;
    private ArrayList<ContactDetailReqt> contacts = new ArrayList<>();
    private String deviceId;

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public String getContactType() {
        return this.contactType;
    }

    public void setContactType(String str) {
        this.contactType = str;
    }

    public ArrayList<ContactDetailReqt> getContacts() {
        return this.contacts;
    }

    public void setContacts(ArrayList<ContactDetailReqt> arrayList) {
        this.contacts = arrayList;
    }
}
