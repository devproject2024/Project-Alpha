package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public class Response extends IJRDataModel {
    @a
    @b(a = "merchantWiseDetails")
    private ArrayList<MerchantWiseDetail> merchantWiseDetails = null;
    @a
    @b(a = "totalBlockedAmount")
    private Double totalBlockedAmount;

    public Double getTotalBlockedAmount() {
        return this.totalBlockedAmount;
    }

    public void setTotalBlockedAmount(Double d2) {
        this.totalBlockedAmount = d2;
    }

    public ArrayList<MerchantWiseDetail> getMerchantWiseDetails() {
        return this.merchantWiseDetails;
    }

    public void setMerchantWiseDetails(ArrayList<MerchantWiseDetail> arrayList) {
        this.merchantWiseDetails = arrayList;
    }
}
