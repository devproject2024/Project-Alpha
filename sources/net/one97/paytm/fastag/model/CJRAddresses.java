package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class CJRAddresses extends IJRPaytmDataModel {
    @b(a = "addressess")
    ArrayList<CJRAddress> addressess;

    public ArrayList<CJRAddress> getAddressess() {
        return this.addressess;
    }

    public void setAddressess(ArrayList<CJRAddress> arrayList) {
        this.addressess = arrayList;
    }
}
