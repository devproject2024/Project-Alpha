package net.one97.paytm.h5.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.shopping.CJRAddress;

public final class CJRH5UserAddressInfo extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "addressess")
    private ArrayList<CJRAddress> address;

    public final ArrayList<CJRAddress> getAddress() {
        return this.address;
    }

    public final void setAddress(ArrayList<CJRAddress> arrayList) {
        this.address = arrayList;
    }
}
