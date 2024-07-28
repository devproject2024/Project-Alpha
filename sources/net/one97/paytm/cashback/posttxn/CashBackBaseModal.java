package net.one97.paytm.cashback.posttxn;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class CashBackBaseModal extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "errors")
    private ArrayList<GetVIPCashBackErrorModal> errors;
    @b(a = "status")
    private int status;

    public static long getSerialVersionUID() {
        return 1;
    }

    public ArrayList<GetVIPCashBackErrorModal> getErrors() {
        return this.errors;
    }

    public void setErrors(ArrayList<GetVIPCashBackErrorModal> arrayList) {
        this.errors = arrayList;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }
}
