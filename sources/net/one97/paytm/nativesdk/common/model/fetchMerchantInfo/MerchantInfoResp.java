package net.one97.paytm.nativesdk.common.model.fetchMerchantInfo;

import com.google.gson.a.c;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.instruments.upipush.pojo.IJRDataModel;

public final class MerchantInfoResp implements IJRDataModel {
    @c(a = "merBusName")
    private final String merBusName;
    @c(a = "merDispname")
    private final String merDispname;
    @c(a = "merLogoUrl")
    private final String merLogoUrl;

    public MerchantInfoResp() {
        this((String) null, (String) null, (String) null, 7, (g) null);
    }

    public static /* synthetic */ MerchantInfoResp copy$default(MerchantInfoResp merchantInfoResp, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = merchantInfoResp.merBusName;
        }
        if ((i2 & 2) != 0) {
            str2 = merchantInfoResp.merLogoUrl;
        }
        if ((i2 & 4) != 0) {
            str3 = merchantInfoResp.merDispname;
        }
        return merchantInfoResp.copy(str, str2, str3);
    }

    public final String component1() {
        return this.merBusName;
    }

    public final String component2() {
        return this.merLogoUrl;
    }

    public final String component3() {
        return this.merDispname;
    }

    public final MerchantInfoResp copy(String str, String str2, String str3) {
        return new MerchantInfoResp(str, str2, str3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MerchantInfoResp)) {
            return false;
        }
        MerchantInfoResp merchantInfoResp = (MerchantInfoResp) obj;
        return k.a((Object) this.merBusName, (Object) merchantInfoResp.merBusName) && k.a((Object) this.merLogoUrl, (Object) merchantInfoResp.merLogoUrl) && k.a((Object) this.merDispname, (Object) merchantInfoResp.merDispname);
    }

    public final int hashCode() {
        String str = this.merBusName;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.merLogoUrl;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.merDispname;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "MerchantInfoResp(merBusName=" + this.merBusName + ", merLogoUrl=" + this.merLogoUrl + ", merDispname=" + this.merDispname + ")";
    }

    public MerchantInfoResp(String str, String str2, String str3) {
        this.merBusName = str;
        this.merLogoUrl = str2;
        this.merDispname = str3;
    }

    public final String getMerBusName() {
        return this.merBusName;
    }

    public final String getMerLogoUrl() {
        return this.merLogoUrl;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MerchantInfoResp(String str, String str2, String str3, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3);
    }

    public final String getMerDispname() {
        return this.merDispname;
    }
}
