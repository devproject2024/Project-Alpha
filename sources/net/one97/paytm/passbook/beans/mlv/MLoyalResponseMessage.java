package net.one97.paytm.passbook.beans.mlv;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class MLoyalResponseMessage extends IJRDataModel {
    @b(a = "message")
    private String message;
    @b(a = "title")
    private String title;

    public MLoyalResponseMessage() {
        this((String) null, (String) null, 3, (g) null);
    }

    public static /* synthetic */ MLoyalResponseMessage copy$default(MLoyalResponseMessage mLoyalResponseMessage, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = mLoyalResponseMessage.title;
        }
        if ((i2 & 2) != 0) {
            str2 = mLoyalResponseMessage.message;
        }
        return mLoyalResponseMessage.copy(str, str2);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.message;
    }

    public final MLoyalResponseMessage copy(String str, String str2) {
        return new MLoyalResponseMessage(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MLoyalResponseMessage)) {
            return false;
        }
        MLoyalResponseMessage mLoyalResponseMessage = (MLoyalResponseMessage) obj;
        return k.a((Object) this.title, (Object) mLoyalResponseMessage.title) && k.a((Object) this.message, (Object) mLoyalResponseMessage.message);
    }

    public final int hashCode() {
        String str = this.title;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.message;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "MLoyalResponseMessage(title=" + this.title + ", message=" + this.message + ")";
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MLoyalResponseMessage(String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2);
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public MLoyalResponseMessage(String str, String str2) {
        this.title = str;
        this.message = str2;
    }
}
