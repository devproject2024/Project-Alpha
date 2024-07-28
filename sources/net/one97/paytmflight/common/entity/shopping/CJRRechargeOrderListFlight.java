package net.one97.paytmflight.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.CJRError;
import com.paytm.network.model.CJRStatusError;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.shopping.CJROrderList;

public class CJRRechargeOrderListFlight extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "error")
    private CJRError mError;
    @b(a = "next")
    private String mNextUrl;
    @b(a = "orders")
    private ArrayList<CJROrderList> mOrderList;
    @b(a = "status")
    private CJRStatusError mStatus;
    private String pageType = "";

    public String getPageType() {
        return this.pageType;
    }

    public void setPageType(String str) {
        this.pageType = str;
    }

    public CJRStatusError getStatus() {
        return this.mStatus;
    }

    public CJRError getError() {
        return this.mError;
    }

    public ArrayList<CJROrderList> getOrderList() {
        return this.mOrderList;
    }

    public void addNewItems(ArrayList<CJROrderList> arrayList) {
        ArrayList<CJROrderList> arrayList2 = this.mOrderList;
        if (arrayList2 == null) {
            this.mOrderList = arrayList;
            return;
        }
        try {
            if (arrayList2.size() > 0 && this.mOrderList.get(this.mOrderList.size() - 1).isFooter()) {
                this.mOrderList.remove(this.mOrderList.size() - 1);
            }
        } catch (Exception unused) {
        }
        this.mOrderList.addAll(arrayList);
    }

    public String getNextUrl() {
        return this.mNextUrl;
    }

    public void setNextUrl(String str) {
        this.mNextUrl = str;
    }

    public void setOrderList(ArrayList<CJROrderList> arrayList) {
        this.mOrderList = arrayList;
    }
}
