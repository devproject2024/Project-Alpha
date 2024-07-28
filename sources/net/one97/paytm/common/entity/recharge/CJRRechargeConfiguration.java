package net.one97.paytm.common.entity.recharge;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRRechargeConfiguration implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "caption")
    private String mCaption;
    @b(a = "products")
    private ArrayList<CJRRechargeProduct> mProductList;

    public String getCaption() {
        return this.mCaption;
    }

    public ArrayList<CJRRechargeProduct> getProductList() {
        return this.mProductList;
    }
}
