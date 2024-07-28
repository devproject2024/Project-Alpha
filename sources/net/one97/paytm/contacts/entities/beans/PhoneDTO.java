package net.one97.paytm.contacts.entities.beans;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class PhoneDTO extends IJRPaytmDataModel implements IJRDataModel {
    PhoneDetails primaryMobile;
    ArrayList<PhoneDetails> secondaryMobile;

    public ArrayList<PhoneDetails> getSecondaryMobile() {
        return this.secondaryMobile;
    }

    public void setSecondaryMobile(ArrayList<PhoneDetails> arrayList) {
        this.secondaryMobile = arrayList;
    }

    public PhoneDetails getPrimaryMobile() {
        return this.primaryMobile;
    }

    public void setPrimaryMobile(PhoneDetails phoneDetails) {
        this.primaryMobile = phoneDetails;
    }
}
