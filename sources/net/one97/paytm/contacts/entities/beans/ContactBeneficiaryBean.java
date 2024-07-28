package net.one97.paytm.contacts.entities.beans;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class ContactBeneficiaryBean extends IJRPaytmDataModel implements IJRDataModel {
    private String code;
    private String message;
    Response response;
    private String status;
    private boolean success;

    public Response getResponseObject() {
        return this.response;
    }

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
}
