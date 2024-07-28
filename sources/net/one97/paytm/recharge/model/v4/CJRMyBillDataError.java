package net.one97.paytm.recharge.model.v4;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CJRMyBillDataError extends IJRPaytmDataModel {
    @b(a = "error")
    private final String error;
    @b(a = "error_title")
    private final String errorTitle;

    public CJRMyBillDataError() {
        this((String) null, (String) null, 3, (g) null);
    }

    public static /* synthetic */ CJRMyBillDataError copy$default(CJRMyBillDataError cJRMyBillDataError, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cJRMyBillDataError.errorTitle;
        }
        if ((i2 & 2) != 0) {
            str2 = cJRMyBillDataError.error;
        }
        return cJRMyBillDataError.copy(str, str2);
    }

    public final String component1() {
        return this.errorTitle;
    }

    public final String component2() {
        return this.error;
    }

    public final CJRMyBillDataError copy(String str, String str2) {
        return new CJRMyBillDataError(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRMyBillDataError)) {
            return false;
        }
        CJRMyBillDataError cJRMyBillDataError = (CJRMyBillDataError) obj;
        return k.a((Object) this.errorTitle, (Object) cJRMyBillDataError.errorTitle) && k.a((Object) this.error, (Object) cJRMyBillDataError.error);
    }

    public final int hashCode() {
        String str = this.errorTitle;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.error;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "CJRMyBillDataError(errorTitle=" + this.errorTitle + ", error=" + this.error + ")";
    }

    public final String getErrorTitle() {
        return this.errorTitle;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRMyBillDataError(String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2);
    }

    public final String getError() {
        return this.error;
    }

    public CJRMyBillDataError(String str, String str2) {
        this.errorTitle = str;
        this.error = str2;
    }
}
