package net.one97.paytm.contacts.entities.beans;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class DeleteContacts extends IJRPaytmDataModel implements IJRDataModel {
    String contactId;
    Error error;
    boolean success;

    public void setSuccess(boolean z) {
    }

    public String getContactId() {
        return this.contactId;
    }

    public void setContactId(String str) {
        this.contactId = str;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public Error getError() {
        return this.error;
    }

    public void setError(Error error2) {
        this.error = error2;
    }
}
