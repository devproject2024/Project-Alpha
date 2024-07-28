package net.one97.paytm.bankCommon.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.CJRError;
import com.paytm.network.model.CJRStatusError;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJROrdersNew extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "error")
    private CJRError mError;
    @b(a = "next")
    private String mNextUrl;
    @b(a = "orders")
    private ArrayList<CJROrderList> mOrders;
    @b(a = "status")
    private CJRStatusError mStatus;

    public ArrayList<CJROrderList> getOrders() {
        return this.mOrders;
    }

    public CJRStatusError getStatus() {
        return this.mStatus;
    }

    public CJRError getError() {
        return this.mError;
    }

    public void addNewItems(ArrayList<CJROrderList> arrayList) {
        ArrayList<CJROrderList> arrayList2 = this.mOrders;
        if (arrayList2 == null) {
            this.mOrders = arrayList;
            return;
        }
        try {
            if (arrayList2.size() > 0 && this.mOrders.get(this.mOrders.size() - 1).isFooter()) {
                this.mOrders.remove(this.mOrders.size() - 1);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.mOrders.addAll(arrayList);
    }

    public String getNextUrl() {
        return this.mNextUrl;
    }

    public void setNextUrl(String str) {
        this.mNextUrl = str;
    }
}
