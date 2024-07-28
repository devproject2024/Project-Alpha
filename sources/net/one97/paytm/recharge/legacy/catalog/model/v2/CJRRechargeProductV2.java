package net.one97.paytm.recharge.legacy.catalog.model.v2;

import com.google.gsonhtcfix.a.b;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRRechargeProductV2 implements IJRDataModel {
    @b(a = "input_fields")
    private List<CJRRechargeInputFieldsTypeV2> inputFieldsTypeV2List;
    @b(a = "id")
    private String productId;
    @b(a = "attributes")
    private CJRRechargeProductAttributesV2 rechargeProductAttributesV2;

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public CJRRechargeProductAttributesV2 getRechargeProductAttributesV2() {
        return this.rechargeProductAttributesV2;
    }

    public void setRechargeProductAttributesV2(CJRRechargeProductAttributesV2 cJRRechargeProductAttributesV2) {
        this.rechargeProductAttributesV2 = cJRRechargeProductAttributesV2;
    }

    public List<CJRRechargeInputFieldsTypeV2> getInputFieldsTypeV2List() {
        return this.inputFieldsTypeV2List;
    }

    public void setInputFieldsTypeV2List(List<CJRRechargeInputFieldsTypeV2> list) {
        this.inputFieldsTypeV2List = list;
    }
}
