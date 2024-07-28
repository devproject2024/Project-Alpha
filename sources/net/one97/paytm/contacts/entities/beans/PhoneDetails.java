package net.one97.paytm.contacts.entities.beans;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class PhoneDetails extends IJRPaytmDataModel implements IJRDataModel {
    String id;
    String phoneNo;

    public String getId() {
        return this.id;
    }

    public String getPhoneNo() {
        return this.phoneNo;
    }
}
