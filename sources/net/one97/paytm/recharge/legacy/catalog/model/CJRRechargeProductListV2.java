package net.one97.paytm.recharge.legacy.catalog.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.recharge.model.CJRGroupField;

public class CJRRechargeProductListV2 extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "group_field")
    public ArrayList<CJRGroupField> groupField;
    private boolean isCached = false;
    @b(a = "showFastforward")
    private boolean mIsFastForward;
    @b(a = "meta_description_new")
    private String mMetaDescription;
    @b(a = "ProductList")
    private ArrayList<CJRRechargeProductV2> mRechargeProduct;
    @b(a = "removeProducts")
    private CJRRechargeUtilRemoveProduct mRemoveProducts;
    private Long mServerResponseTime;

    public boolean isCached() {
        return this.isCached;
    }

    public void setIsCached(boolean z) {
        this.isCached = z;
    }

    public ArrayList<CJRRechargeProductV2> getRechargeProduct() {
        return this.mRechargeProduct;
    }

    public void setRechargeProduct(ArrayList<CJRRechargeProductV2> arrayList) {
        this.mRechargeProduct = arrayList;
    }

    public Long getServerResponseTime() {
        return this.mServerResponseTime;
    }

    public void setServerResponseTime(Long l) {
        this.mServerResponseTime = l;
    }

    public String getMetaDescription() {
        return this.mMetaDescription;
    }

    public boolean getFastForward() {
        return this.mIsFastForward;
    }

    public ArrayList<CJRGroupField> getGroupField() {
        return this.groupField;
    }

    public CJRRechargeUtilRemoveProduct getRemoveProducts() {
        return this.mRemoveProducts;
    }

    public void setRemoveProducts(CJRRechargeUtilRemoveProduct cJRRechargeUtilRemoveProduct) {
        this.mRemoveProducts = cJRRechargeUtilRemoveProduct;
    }
}
