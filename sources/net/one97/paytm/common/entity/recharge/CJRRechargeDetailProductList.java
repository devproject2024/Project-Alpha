package net.one97.paytm.common.entity.recharge;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRRechargeDetailProductList implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "attributes")
    private CJRAttributes mAttributes;
    @b(a = "configuration")
    private CJRRechargeConfigurationV2 mConfiguration;
    @b(a = "input_fields")
    private ArrayList<CJRInputFields> mInputFields;
    @b(a = "product_id")
    private String mProductId;

    public void setProductId(String str) {
        this.mProductId = str;
    }

    public void setConfiguration(CJRRechargeConfigurationV2 cJRRechargeConfigurationV2) {
        this.mConfiguration = cJRRechargeConfigurationV2;
    }

    public void setAttributes(CJRAttributes cJRAttributes) {
        this.mAttributes = cJRAttributes;
    }

    public void setInputFields(ArrayList<CJRInputFields> arrayList) {
        this.mInputFields = arrayList;
    }

    public String getProductId() {
        return this.mProductId;
    }

    public CJRRechargeConfigurationV2 getConfiguration() {
        return this.mConfiguration;
    }

    public CJRAttributes getAttributes() {
        return this.mAttributes;
    }

    public ArrayList<CJRInputFields> getInputFields() {
        return this.mInputFields;
    }
}
