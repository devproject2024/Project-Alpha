package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRNextStepSubtitle extends IJRPaytmDataModel {
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
