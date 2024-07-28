package net.one97.paytm.contacts.entities.beans;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class ContactInfo extends IJRPaytmDataModel implements IJRDataModel {
    private Meta meta;

    public Meta getMeta() {
        return this.meta;
    }
}
