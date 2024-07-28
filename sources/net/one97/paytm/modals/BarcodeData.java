package net.one97.paytm.modals;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

@Deprecated
public class BarcodeData implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "deep_link")
    private String deepLink;

    public String getDeepLink() {
        return this.deepLink;
    }
}
