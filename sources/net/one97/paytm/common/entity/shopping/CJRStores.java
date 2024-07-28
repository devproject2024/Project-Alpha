package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRStores implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "store_id")
    private String mStoreID;
    @b(a = "store_image")
    private String mStoreImage;
    @b(a = "store_name")
    private String mStoreName;

    public String getStoreID() {
        return this.mStoreID;
    }

    public String getStoreImage() {
        return this.mStoreImage;
    }

    public String getStoreName() {
        return this.mStoreName;
    }
}
