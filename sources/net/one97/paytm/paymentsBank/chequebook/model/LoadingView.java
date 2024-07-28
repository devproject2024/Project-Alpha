package net.one97.paytm.paymentsBank.chequebook.model;

import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class LoadingView implements IJRDataModel {
    private String screenName;

    public LoadingView() {
        this((String) null, 1, (g) null);
    }

    public static /* synthetic */ LoadingView copy$default(LoadingView loadingView, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = loadingView.screenName;
        }
        return loadingView.copy(str);
    }

    public final String component1() {
        return this.screenName;
    }

    public final LoadingView copy(String str) {
        return new LoadingView(str);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof LoadingView) && k.a((Object) this.screenName, (Object) ((LoadingView) obj).screenName);
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
        return "LoadingView(screenName=" + this.screenName + ")";
    }

    public LoadingView(String str) {
        this.screenName = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LoadingView(String str, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str);
    }

    public final String getScreenName() {
        return this.screenName;
    }

    public final void setScreenName(String str) {
        this.screenName = str;
    }
}
