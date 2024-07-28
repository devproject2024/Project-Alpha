package net.one97.paytm.hotel4.service.model;

import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class ScreenNavigationInfo {
    private String from;
    private boolean isAddtoBackStack;
    private String screenName;

    public ScreenNavigationInfo(String str, String str2, boolean z) {
        k.c(str, "from");
        k.c(str2, SDKConstants.EVENT_KEY_SCREEN_NAME);
        this.from = str;
        this.screenName = str2;
        this.isAddtoBackStack = z;
    }

    public final String getFrom() {
        return this.from;
    }

    public final void setFrom(String str) {
        k.c(str, "<set-?>");
        this.from = str;
    }

    public final String getScreenName() {
        return this.screenName;
    }

    public final void setScreenName(String str) {
        k.c(str, "<set-?>");
        this.screenName = str;
    }

    public final boolean isAddtoBackStack() {
        return this.isAddtoBackStack;
    }

    public final void setAddtoBackStack(boolean z) {
        this.isAddtoBackStack = z;
    }
}
