package net.one97.paytm.common.entity.home;

import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CkycResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "statusCode")
    private String code;
    private String iv;
    private String key;
    @b(a = "statusMessage")
    private String msg;

    public CkycResponse() {
        this((String) null, (String) null, (String) null, (String) null, 15, (g) null);
    }

    public static /* synthetic */ CkycResponse copy$default(CkycResponse ckycResponse, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = ckycResponse.key;
        }
        if ((i2 & 2) != 0) {
            str2 = ckycResponse.iv;
        }
        if ((i2 & 4) != 0) {
            str3 = ckycResponse.msg;
        }
        if ((i2 & 8) != 0) {
            str4 = ckycResponse.code;
        }
        return ckycResponse.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.key;
    }

    public final String component2() {
        return this.iv;
    }

    public final String component3() {
        return this.msg;
    }

    public final String component4() {
        return this.code;
    }

    public final CkycResponse copy(String str, String str2, String str3, String str4) {
        return new CkycResponse(str, str2, str3, str4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CkycResponse)) {
            return false;
        }
        CkycResponse ckycResponse = (CkycResponse) obj;
        return k.a((Object) this.key, (Object) ckycResponse.key) && k.a((Object) this.iv, (Object) ckycResponse.iv) && k.a((Object) this.msg, (Object) ckycResponse.msg) && k.a((Object) this.code, (Object) ckycResponse.code);
    }

    public final int hashCode() {
        String str = this.key;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.iv;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.msg;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.code;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "CkycResponse(key=" + this.key + ", iv=" + this.iv + ", msg=" + this.msg + ", code=" + this.code + ")";
    }

    public final String getKey() {
        return this.key;
    }

    public final void setKey(String str) {
        this.key = str;
    }

    public final String getIv() {
        return this.iv;
    }

    public final void setIv(String str) {
        this.iv = str;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final void setMsg(String str) {
        this.msg = str;
    }

    public CkycResponse(String str, String str2, String str3, String str4) {
        this.key = str;
        this.iv = str2;
        this.msg = str3;
        this.code = str4;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CkycResponse(String str, String str2, String str3, String str4, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4);
    }

    public final String getCode() {
        return this.code;
    }

    public final void setCode(String str) {
        this.code = str;
    }

    public final IJRPaytmDataModel parseResponse(String str, f fVar) {
        k.c(fVar, "gson");
        Object a2 = fVar.a(net.one97.paytm.common.utility.f.b(this.iv, this.key, str), new net.one97.paytm.common.entity.upgradeKyc.CkycResponse((String) null, (String) null, (String) null, (String) null, 15, (g) null).getClass());
        k.a((Object) a2, "gson.fromJson(jsonString, ckycResponse.javaClass)");
        return (net.one97.paytm.common.entity.upgradeKyc.CkycResponse) a2;
    }
}
