package net.one97.paytm.recharge.domain.entities;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRAutomaticEditBillNameResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "code")
    private final Integer code;
    @b(a = "message")
    private final String message;
    @b(a = "status")
    private final int status;

    public CJRAutomaticEditBillNameResponse() {
        this(0, (String) null, (Integer) null, 7, (g) null);
    }

    public static /* synthetic */ CJRAutomaticEditBillNameResponse copy$default(CJRAutomaticEditBillNameResponse cJRAutomaticEditBillNameResponse, int i2, String str, Integer num, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = cJRAutomaticEditBillNameResponse.status;
        }
        if ((i3 & 2) != 0) {
            str = cJRAutomaticEditBillNameResponse.message;
        }
        if ((i3 & 4) != 0) {
            num = cJRAutomaticEditBillNameResponse.code;
        }
        return cJRAutomaticEditBillNameResponse.copy(i2, str, num);
    }

    public final int component1() {
        return this.status;
    }

    public final String component2() {
        return this.message;
    }

    public final Integer component3() {
        return this.code;
    }

    public final CJRAutomaticEditBillNameResponse copy(int i2, String str, Integer num) {
        return new CJRAutomaticEditBillNameResponse(i2, str, num);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CJRAutomaticEditBillNameResponse) {
                CJRAutomaticEditBillNameResponse cJRAutomaticEditBillNameResponse = (CJRAutomaticEditBillNameResponse) obj;
                if (!(this.status == cJRAutomaticEditBillNameResponse.status) || !k.a((Object) this.message, (Object) cJRAutomaticEditBillNameResponse.message) || !k.a((Object) this.code, (Object) cJRAutomaticEditBillNameResponse.code)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i2 = this.status * 31;
        String str = this.message;
        int i3 = 0;
        int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        Integer num = this.code;
        if (num != null) {
            i3 = num.hashCode();
        }
        return hashCode + i3;
    }

    public final String toString() {
        return "CJRAutomaticEditBillNameResponse(status=" + this.status + ", message=" + this.message + ", code=" + this.code + ")";
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRAutomaticEditBillNameResponse(int i2, String str, Integer num, int i3, g gVar) {
        this((i3 & 1) != 0 ? 0 : i2, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? 0 : num);
    }

    public final Integer getCode() {
        return this.code;
    }

    public CJRAutomaticEditBillNameResponse(int i2, String str, Integer num) {
        this.status = i2;
        this.message = str;
        this.code = num;
    }
}
