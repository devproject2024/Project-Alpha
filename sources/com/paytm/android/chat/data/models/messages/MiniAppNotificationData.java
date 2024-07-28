package com.paytm.android.chat.data.models.messages;

import java.io.Serializable;

public final class MiniAppNotificationData implements Serializable {
    private String cta;
    private String cta_text;
    private String desc;
    private String preview_text;
    private String title;

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final void setDesc(String str) {
        this.desc = str;
    }

    public final String getCta() {
        return this.cta;
    }

    public final void setCta(String str) {
        this.cta = str;
    }

    public final String getCta_text() {
        return this.cta_text;
    }

    public final void setCta_text(String str) {
        this.cta_text = str;
    }

    public final String getPreview_text() {
        return this.preview_text;
    }

    public final void setPreview_text(String str) {
        this.preview_text = str;
    }
}
