package net.one97.paytm.recharge.model;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.CJRDataModelItem;

public class CJRCouponHeader extends CJRDataModelItem {
    private static final long serialVersionUID = 1;
    @b(a = "items")
    private ArrayList<CJRCouponHeaderItem> mCouponHeaderItemList = new ArrayList<>();

    public String getName() {
        return null;
    }

    public ArrayList<CJRCouponHeaderItem> getCouponHeaderItemList() {
        return this.mCouponHeaderItemList;
    }
}
