package net.one97.paytm.contacts.entities.beans;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class PhoneInfo extends IJRPaytmDataModel implements IJRDataModel {
    private String primaryMobile;
    private ArrayList<String> secondaryMobile;

    public String getPrimaryMobile() {
        return this.primaryMobile;
    }

    public void setPrimaryMobile(String str) {
        this.primaryMobile = str;
    }

    public ArrayList<String> getSecondaryMobile() {
        return this.secondaryMobile;
    }

    public void setSecondaryMobile(ArrayList<String> arrayList) {
        this.secondaryMobile = arrayList;
    }
}
