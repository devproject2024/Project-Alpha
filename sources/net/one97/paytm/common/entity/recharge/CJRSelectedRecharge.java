package net.one97.paytm.common.entity.recharge;

import java.util.Map;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRSelectedRecharge implements IJRDataModel {
    private Map<String, String> mConfigList;
    private String mProductId;
    private String mProductPrice;

    public String getProductId() {
        return this.mProductId;
    }

    public void setProductPrice(String str) {
        this.mProductPrice = str;
    }

    public String getProductPrice() {
        return this.mProductPrice;
    }

    public void setProductId(String str) {
        this.mProductId = str;
    }

    public Map<String, String> getConfigList() {
        return this.mConfigList;
    }

    public void setConfigList(Map<String, String> map) {
        this.mConfigList = map;
    }

    public boolean equals(Object obj) {
        CJRSelectedRecharge cJRSelectedRecharge = (CJRSelectedRecharge) obj;
        try {
            if (!this.mProductId.equalsIgnoreCase(cJRSelectedRecharge.getProductId())) {
                return this.mProductId.equalsIgnoreCase(cJRSelectedRecharge.getProductId());
            }
            if (Integer.parseInt(this.mProductPrice) == Integer.parseInt(cJRSelectedRecharge.getProductPrice())) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }
}
