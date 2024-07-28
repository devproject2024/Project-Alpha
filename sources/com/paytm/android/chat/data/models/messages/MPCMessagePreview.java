package com.paytm.android.chat.data.models.messages;

import kotlin.g.b.k;

public final class MPCMessagePreview {
    private MPCPreviewDrawable previewDrawable;
    private String previewText;

    public static /* synthetic */ MPCMessagePreview copy$default(MPCMessagePreview mPCMessagePreview, String str, MPCPreviewDrawable mPCPreviewDrawable, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = mPCMessagePreview.previewText;
        }
        if ((i2 & 2) != 0) {
            mPCPreviewDrawable = mPCMessagePreview.previewDrawable;
        }
        return mPCMessagePreview.copy(str, mPCPreviewDrawable);
    }

    public final String component1() {
        return this.previewText;
    }

    public final MPCPreviewDrawable component2() {
        return this.previewDrawable;
    }

    public final MPCMessagePreview copy(String str, MPCPreviewDrawable mPCPreviewDrawable) {
        k.c(mPCPreviewDrawable, "previewDrawable");
        return new MPCMessagePreview(str, mPCPreviewDrawable);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MPCMessagePreview)) {
            return false;
        }
        MPCMessagePreview mPCMessagePreview = (MPCMessagePreview) obj;
        return k.a((Object) this.previewText, (Object) mPCMessagePreview.previewText) && k.a((Object) this.previewDrawable, (Object) mPCMessagePreview.previewDrawable);
    }

    public final int hashCode() {
        String str = this.previewText;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        MPCPreviewDrawable mPCPreviewDrawable = this.previewDrawable;
        if (mPCPreviewDrawable != null) {
            i2 = mPCPreviewDrawable.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "MPCMessagePreview(previewText=" + this.previewText + ", previewDrawable=" + this.previewDrawable + ")";
    }

    public MPCMessagePreview(String str, MPCPreviewDrawable mPCPreviewDrawable) {
        k.c(mPCPreviewDrawable, "previewDrawable");
        this.previewText = str;
        this.previewDrawable = mPCPreviewDrawable;
    }

    public final MPCPreviewDrawable getPreviewDrawable() {
        return this.previewDrawable;
    }

    public final String getPreviewText() {
        return this.previewText;
    }

    public final void setPreviewDrawable(MPCPreviewDrawable mPCPreviewDrawable) {
        k.c(mPCPreviewDrawable, "<set-?>");
        this.previewDrawable = mPCPreviewDrawable;
    }

    public final void setPreviewText(String str) {
        this.previewText = str;
    }
}
