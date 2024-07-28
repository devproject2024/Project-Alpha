package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class MerchantRating implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "communication")
    private String mCommunication;
    @b(a = "item_as_described")
    private String mItemAsDescribed;
    @b(a = "shipping_time")
    private String mShippingTime;
    @b(a = "total")
    private String mTotal;
}
