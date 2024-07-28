package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public class CJRTPData extends IJRDataModel {
    boolean isClickedImpressionTracked;
    boolean isImpressionTracked;
    @b(a = "abClick")
    public String mAbClick;
    @b(a = "abImpression")
    public String mAbImpression;
    @b(a = "im_contextCode")
    public String mContextCode;
    @b(a = "im_namespace")
    public String mNamespace;
    @b(a = "im_pubContent")
    public String mPubContent;

    public String getAbImpression() {
        return this.mAbImpression;
    }

    public String getAbClick() {
        return this.mAbClick;
    }

    public String getPubContent() {
        return this.mPubContent;
    }

    public boolean isImpressionTracked() {
        return this.isImpressionTracked;
    }

    public void setIsImpressionTracked(boolean z) {
        this.isImpressionTracked = z;
    }

    public boolean isClickedImpressionTracked() {
        return this.isClickedImpressionTracked;
    }

    public void setIsClickedImpressionTracked(boolean z) {
        this.isClickedImpressionTracked = z;
    }

    public String getContextCode() {
        return this.mContextCode;
    }

    public String getNamespace() {
        return this.mNamespace;
    }
}
