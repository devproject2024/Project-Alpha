package net.one97.paytm.contacts.utils;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class ContactDetailReqt extends IJRPaytmDataModel implements IJRDataModel {
    String contactId;
    ContactReqtInfo contactInfo;
    String name;

    public String getContactId() {
        return this.contactId;
    }

    public void setContactId(String str) {
        this.contactId = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public ContactReqtInfo getContactInfo() {
        return this.contactInfo;
    }

    public void setContactInfo(ContactReqtInfo contactReqtInfo) {
        this.contactInfo = contactReqtInfo;
    }
}
