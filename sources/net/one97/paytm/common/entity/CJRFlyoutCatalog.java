package net.one97.paytm.common.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.shopping.CJRCatalog;

public class CJRFlyoutCatalog extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "items")
    private CJRCatalog mFlyoutCatalog;

    public CJRCatalog getFlyoutCatalog() {
        return this.mFlyoutCatalog;
    }
}
