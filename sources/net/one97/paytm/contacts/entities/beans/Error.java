package net.one97.paytm.contacts.entities.beans;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class Error extends IJRPaytmDataModel implements IJRDataModel {
    private String code;
    private String message;

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
