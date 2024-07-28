package net.one97.paytm.paymentsBank.chequebook.model;

import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CBStopPaymentView implements IJRDataModel {
    private String screenName;

    public CBStopPaymentView() {
        this((String) null, 1, (g) null);
    }

    public static /* synthetic */ CBStopPaymentView copy$default(CBStopPaymentView cBStopPaymentView, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cBStopPaymentView.screenName;
        }
        return cBStopPaymentView.copy(str);
    }

    public final String component1() {
        return this.screenName;
    }

    public final CBStopPaymentView copy(String str) {
        return new CBStopPaymentView(str);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof CBStopPaymentView) && k.a((Object) this.screenName, (Object) ((CBStopPaymentView) obj).screenName);
        }
        return true;
    }

    public final int hashCode() {
        String str = this.screenName;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "CBStopPaymentView(screenName=" + this.screenName + ")";
    }

    public CBStopPaymentView(String str) {
        this.screenName = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CBStopPaymentView(String str, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str);
    }

    public final String getScreenName() {
        return this.screenName;
    }

    public final void setScreenName(String str) {
        this.screenName = str;
    }
}
