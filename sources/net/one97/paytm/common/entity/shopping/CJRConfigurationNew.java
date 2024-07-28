package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRConfigurationNew implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "caption")
    private String mCaption;
    @b(a = "products")
    private ArrayList<CJRDetailProduct> mProductList;

    public String getCaption() {
        return this.mCaption;
    }

    public ArrayList<CJRDetailProduct> getProductList() {
        return this.mProductList;
    }
}
