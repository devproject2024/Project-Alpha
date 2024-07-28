package com.paytm.android.chat.bean;

import java.io.Serializable;

public final class CTA implements Serializable {
    private String btnText;
    private String deeplink;
    private String type;

    public final String getBtnText() {
        return this.btnText;
    }

    public final void setBtnText(String str) {
        this.btnText = str;
    }

    public final String getDeeplink() {
        return this.deeplink;
    }

    public final void setDeeplink(String str) {
        this.deeplink = str;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final CtaType getCtaType() {
        return CtaType.Companion.fromString(this.type);
    }
}
