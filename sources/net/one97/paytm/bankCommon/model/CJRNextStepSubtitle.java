package net.one97.paytm.bankCommon.model;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRNextStepSubtitle implements IJRDataModel {
    @b(a = "deeplink")
    private String deeplink;
    @b(a = "heading")
    private String heading;

    public String getHeading() {
        return this.heading;
    }

    public String getDeeplink() {
        return this.deeplink;
    }
}
