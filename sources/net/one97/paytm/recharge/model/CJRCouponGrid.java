package net.one97.paytm.recharge.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.shopping.CJRGridProduct;

public class CJRCouponGrid extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "grid_layout")
    private ArrayList<CJRGridProduct> mGridLayout = new ArrayList<>();
    @b(a = "has_more")
    private boolean mHasMore;

    public ArrayList<CJRGridProduct> getGridLayout() {
        return this.mGridLayout;
    }

    public boolean hasMore() {
        return this.mHasMore;
    }
}
