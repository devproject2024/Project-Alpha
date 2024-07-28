package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public class CJRCSTTransactionDetailResponse extends IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "txnDetails")
    private ArrayList<CJRCSTTransactionDetail> txnDetails;
    @b(a = "validationStatus")
    private String validationStatus;

    public String getValidationStatus() {
        return this.validationStatus;
    }

    public void setValidationStatus(String str) {
        this.validationStatus = str;
    }

    public ArrayList<CJRCSTTransactionDetail> getTxnDetails() {
        return this.txnDetails;
    }

    public void setTxnDetails(ArrayList<CJRCSTTransactionDetail> arrayList) {
        this.txnDetails = arrayList;
    }
}
