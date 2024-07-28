package net.one97.paytm.recharge.model.rechargeutility;

import com.google.gson.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBrowsePlanSearchModelV8 extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "description")
    @a
    private String description;
    @b(a = "displayName")
    @a
    private String displayName;
    @b(a = "productList")
    @a
    private List<CJRBrowsePlanProductList> productList = null;

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public List<CJRBrowsePlanProductList> getProductList() {
        return this.productList;
    }

    public void setProductList(List<CJRBrowsePlanProductList> list) {
        this.productList = list;
    }
}
