package net.one97.paytm.recharge.model.metro;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRMetroQRFrequentOrderListV2 extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "DELHI_METRO")
    private CJRMetroQRFrequentOrderList mDelhiOrders = new CJRMetroQRFrequentOrderList();
    @b(a = "HYDERABAD_METRO")
    private CJRMetroQRFrequentOrderList mHyderabadOrders = new CJRMetroQRFrequentOrderList();
    @b(a = "MUMBAI_METRO")
    private CJRMetroQRFrequentOrderList mMumbaiOrders = new CJRMetroQRFrequentOrderList();

    public final CJRMetroQRFrequentOrderList getMDelhiOrders() {
        return this.mDelhiOrders;
    }

    public final void setMDelhiOrders(CJRMetroQRFrequentOrderList cJRMetroQRFrequentOrderList) {
        k.c(cJRMetroQRFrequentOrderList, "<set-?>");
        this.mDelhiOrders = cJRMetroQRFrequentOrderList;
    }

    public final CJRMetroQRFrequentOrderList getMMumbaiOrders() {
        return this.mMumbaiOrders;
    }

    public final void setMMumbaiOrders(CJRMetroQRFrequentOrderList cJRMetroQRFrequentOrderList) {
        k.c(cJRMetroQRFrequentOrderList, "<set-?>");
        this.mMumbaiOrders = cJRMetroQRFrequentOrderList;
    }

    public final CJRMetroQRFrequentOrderList getMHyderabadOrders() {
        return this.mHyderabadOrders;
    }

    public final void setMHyderabadOrders(CJRMetroQRFrequentOrderList cJRMetroQRFrequentOrderList) {
        k.c(cJRMetroQRFrequentOrderList, "<set-?>");
        this.mHyderabadOrders = cJRMetroQRFrequentOrderList;
    }
}
