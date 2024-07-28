package net.one97.paytm.recharge.model.metro;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMetroQRFrequentOrderList extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "orders")
    private List<CJRMetroQRFrequentOrder> mOrderList = new ArrayList();

    public List<CJRMetroQRFrequentOrder> getmOrderList() {
        return this.mOrderList;
    }

    public void setmOrderList(List<CJRMetroQRFrequentOrder> list) {
        this.mOrderList = list;
    }
}
