package net.one97.paytm.p2mNewDesign.models;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public final class IsDisabledV2 extends CJRWalletDataModel implements IJRDataModel {
    @b(a = "merchantAccept")
    private final Boolean merchantAccept;
    @b(a = "msg")
    private final String msg;
    @b(a = "status")
    private final Boolean status;
    @b(a = "userAccountExist")
    private final Boolean userAccountExist;

    public static /* synthetic */ IsDisabledV2 copy$default(IsDisabledV2 isDisabledV2, String str, Boolean bool, Boolean bool2, Boolean bool3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = isDisabledV2.msg;
        }
        if ((i2 & 2) != 0) {
            bool = isDisabledV2.merchantAccept;
        }
        if ((i2 & 4) != 0) {
            bool2 = isDisabledV2.userAccountExist;
        }
        if ((i2 & 8) != 0) {
            bool3 = isDisabledV2.status;
        }
        return isDisabledV2.copy(str, bool, bool2, bool3);
    }

    public final String component1() {
        return this.msg;
    }

    public final Boolean component2() {
        return this.merchantAccept;
    }

    public final Boolean component3() {
        return this.userAccountExist;
    }

    public final Boolean component4() {
        return this.status;
    }

    public final IsDisabledV2 copy(String str, Boolean bool, Boolean bool2, Boolean bool3) {
        return new IsDisabledV2(str, bool, bool2, bool3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IsDisabledV2)) {
            return false;
        }
        IsDisabledV2 isDisabledV2 = (IsDisabledV2) obj;
        return k.a((Object) this.msg, (Object) isDisabledV2.msg) && k.a((Object) this.merchantAccept, (Object) isDisabledV2.merchantAccept) && k.a((Object) this.userAccountExist, (Object) isDisabledV2.userAccountExist) && k.a((Object) this.status, (Object) isDisabledV2.status);
    }

    public final int hashCode() {
        String str = this.msg;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Boolean bool = this.merchantAccept;
        int hashCode2 = (hashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.userAccountExist;
        int hashCode3 = (hashCode2 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.status;
        if (bool3 != null) {
            i2 = bool3.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "IsDisabledV2(msg=" + this.msg + ", merchantAccept=" + this.merchantAccept + ", userAccountExist=" + this.userAccountExist + ", status=" + this.status + ")";
    }

    public IsDisabledV2(String str, Boolean bool, Boolean bool2, Boolean bool3) {
        this.msg = str;
        this.merchantAccept = bool;
        this.userAccountExist = bool2;
        this.status = bool3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ IsDisabledV2(String str, Boolean bool, Boolean bool2, Boolean bool3, int i2, g gVar) {
        this(str, (i2 & 2) != 0 ? Boolean.TRUE : bool, (i2 & 4) != 0 ? Boolean.TRUE : bool2, (i2 & 8) != 0 ? Boolean.FALSE : bool3);
    }

    public final Boolean getMerchantAccept() {
        return this.merchantAccept;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final Boolean getStatus() {
        return this.status;
    }

    public final Boolean getUserAccountExist() {
        return this.userAccountExist;
    }
}
