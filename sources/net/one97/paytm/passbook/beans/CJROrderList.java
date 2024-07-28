package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.CJRStatusError;
import java.util.ArrayList;

public class CJROrderList extends CJRDataModelItem {
    private static final long serialVersionUID = 1;
    @b(a = "error")
    private CJRError mError;
    @b(a = "next")
    private String mNextUrl;
    @b(a = "orders")
    private ArrayList<CJROrder> mOrderList;
    @b(a = "status")
    private CJRStatusError mStatus;

    public String getName() {
        return null;
    }

    public CJRStatusError getStatus() {
        return this.mStatus;
    }

    public CJRError getError() {
        return this.mError;
    }

    public ArrayList<CJROrder> getOrderList() {
        return this.mOrderList;
    }

    public void addNewItems(ArrayList<CJROrder> arrayList) {
        ArrayList<CJROrder> arrayList2 = this.mOrderList;
        if (arrayList2 == null) {
            this.mOrderList = arrayList;
        } else {
            arrayList2.addAll(arrayList);
        }
    }

    public String getNextUrl() {
        return this.mNextUrl;
    }

    public void setNextUrl(String str) {
        this.mNextUrl = str;
    }
}
