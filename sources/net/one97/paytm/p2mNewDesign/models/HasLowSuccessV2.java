package net.one97.paytm.p2mNewDesign.models;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public final class HasLowSuccessV2 extends CJRWalletDataModel implements IJRDataModel {
    @b(a = "msg")
    private String msg;
    @b(a = "status")
    private Boolean status;

    public HasLowSuccessV2() {
        this((String) null, (Boolean) null, 3, (g) null);
    }

    public static /* synthetic */ HasLowSuccessV2 copy$default(HasLowSuccessV2 hasLowSuccessV2, String str, Boolean bool, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = hasLowSuccessV2.msg;
        }
        if ((i2 & 2) != 0) {
            bool = hasLowSuccessV2.status;
        }
        return hasLowSuccessV2.copy(str, bool);
    }

    public final String component1() {
        return this.msg;
    }

    public final Boolean component2() {
        return this.status;
    }

    public final HasLowSuccessV2 copy(String str, Boolean bool) {
        return new HasLowSuccessV2(str, bool);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HasLowSuccessV2)) {
            return false;
        }
        HasLowSuccessV2 hasLowSuccessV2 = (HasLowSuccessV2) obj;
        return k.a((Object) this.msg, (Object) hasLowSuccessV2.msg) && k.a((Object) this.status, (Object) hasLowSuccessV2.status);
    }

    public final int hashCode() {
        String str = this.msg;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Boolean bool = this.status;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "HasLowSuccessV2(msg=" + this.msg + ", status=" + this.status + ")";
    }

    public HasLowSuccessV2(String str, Boolean bool) {
        this.msg = str;
        this.status = bool;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HasLowSuccessV2(String str, Boolean bool, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? Boolean.FALSE : bool);
    }

    public final String getMsg() {
        return this.msg;
    }

    public final Boolean getStatus() {
        return this.status;
    }

    public final void setMsg(String str) {
        this.msg = str;
    }

    public final void setStatus(Boolean bool) {
        this.status = bool;
    }
}
