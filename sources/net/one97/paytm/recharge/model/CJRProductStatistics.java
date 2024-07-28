package net.one97.paytm.recharge.model;

import com.google.gsonhtcfix.a.b;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.HashMap;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRProductStatistics implements IJRDataModel {
    private final String KEY_ORDER_COUNT = "order_count";
    private final String KEY_WISH_LIST = CLPConstants.WISHLIST;
    private final String KEY_WISH_LIST_COUNT = "wl_count";
    @b(a = "all")
    private HashMap<String, Integer> mAll;
    @b(a = "user")
    private HashMap<String, Boolean> mUser;

    public int getWishListCount() {
        HashMap<String, Integer> hashMap = this.mAll;
        if (hashMap == null || !hashMap.containsKey("wl_count")) {
            return 0;
        }
        return this.mAll.get("wl_count").intValue();
    }

    public boolean getIsWishListed() {
        HashMap<String, Boolean> hashMap = this.mUser;
        if (hashMap == null || !hashMap.containsKey(CLPConstants.WISHLIST)) {
            return false;
        }
        return this.mUser.get(CLPConstants.WISHLIST).booleanValue();
    }

    public int getOrderCount() {
        HashMap<String, Integer> hashMap = this.mAll;
        if (hashMap == null || !hashMap.containsKey("order_count")) {
            return 0;
        }
        return this.mAll.get("order_count").intValue();
    }
}
