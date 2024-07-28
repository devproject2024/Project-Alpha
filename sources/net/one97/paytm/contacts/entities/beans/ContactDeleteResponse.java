package net.one97.paytm.contacts.entities.beans;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class ContactDeleteResponse extends IJRPaytmDataModel implements IJRDataModel {
    private String contactType;
    private ArrayList<DeleteContacts> contacts;
    private String deviceId;

    public String getContactType() {
        return this.contactType;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public ArrayList<DeleteContacts> getContacts() {
        return this.contacts;
    }
}
