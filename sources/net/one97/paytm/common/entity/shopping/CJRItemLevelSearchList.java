package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.CJRError;
import com.paytm.network.model.CJRStatusError;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.q;
import java.util.ArrayList;
import net.one97.paytm.common.entity.CJRDataModelItem;

public class CJRItemLevelSearchList extends CJRDataModelItem {
    private static final long serialVersionUID = 1;
    @b(a = "error")
    private CJRError mError;
    @b(a = "next")
    private String mNextUrl;
    @b(a = "orders")
    private ArrayList<CJROrderList> mOrderList;
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
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
        this.mOrderList.addAll(arrayList);
    }

    public String getNextUrl() {
        return this.mNextUrl;
    }

    public void setNextUrl(String str) {
        this.mNextUrl = str;
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        return super.parseResponse(str, fVar);
    }
}
