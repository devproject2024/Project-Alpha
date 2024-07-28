package net.one97.paytm.recharge.legacy.catalog.model.v2;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRRechargeProductListGroupArrV2 implements IJRDataModel {
    @b(a = "circle")
    private CJRRechargeProductListGroupArrItemV2 circleItem;
    @b(a = "operator")
    private CJRRechargeProductListGroupArrItemV2 operatorItem;
    @b(a = "producttype")
    private CJRRechargeProductListGroupArrItemV2 productType;

    public CJRRechargeProductListGroupArrItemV2 getOperatorItem() {
        return this.operatorItem;
    }

    public CJRRechargeProductListGroupArrItemV2 getCircleItem() {
        return this.circleItem;
    }

    public CJRRechargeProductListGroupArrItemV2 getProductType() {
        return this.productType;
    }

    public void setCircleItem(CJRRechargeProductListGroupArrItemV2 cJRRechargeProductListGroupArrItemV2) {
        this.circleItem = cJRRechargeProductListGroupArrItemV2;
    }

    public void setOperatorItem(CJRRechargeProductListGroupArrItemV2 cJRRechargeProductListGroupArrItemV2) {
        this.operatorItem = cJRRechargeProductListGroupArrItemV2;
    }

    public void setProductTypeItem(CJRRechargeProductListGroupArrItemV2 cJRRechargeProductListGroupArrItemV2) {
        this.productType = cJRRechargeProductListGroupArrItemV2;
    }
}
