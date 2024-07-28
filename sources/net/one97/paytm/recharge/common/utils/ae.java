package net.one97.paytm.recharge.common.utils;

import com.paytm.network.model.NetworkCustomError;

public final class ae extends NetworkCustomError {
    private String alertMessageText;
    private String title;

    public ae(String str, String str2) {
        this.title = str;
        this.alertMessageText = str2;
    }

    public final String getAlertMessageText() {
        return this.alertMessageText;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setAlertMessageText(String str) {
        this.alertMessageText = str;
    }

    public final void setTitle(String str) {
        this.title = str;
    }
}
