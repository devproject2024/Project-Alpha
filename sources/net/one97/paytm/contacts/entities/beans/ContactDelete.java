package net.one97.paytm.contacts.entities.beans;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class ContactDelete extends IJRPaytmDataModel implements IJRDataModel {
    String code;
    String message;
    ContactDeleteResponse response;
    String status;
    boolean success;

    public boolean isSuccess() {
        return this.success;
    }

    public String getCode() {
        return this.code;
    }

    public String getStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }

    public ContactDeleteResponse getResponse() {
        return this.response;
    }
}
