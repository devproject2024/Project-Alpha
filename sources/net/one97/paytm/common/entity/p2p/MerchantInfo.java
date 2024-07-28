package net.one97.paytm.common.entity.p2p;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class MerchantInfo extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "merBusName")
    private String merBusName;
    @b(a = "merDispname")
    private String merDispname;
    @b(a = "merLogoUrl")
    private String merLogoUrl;
    @b(a = "merchantId")
    private String merchantId;

    public MerchantInfo() {
        this((String) null, (String) null, (String) null, (String) null, 15, (g) null);
    }

    public static /* synthetic */ MerchantInfo copy$default(MerchantInfo merchantInfo, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = merchantInfo.merDispname;
        }
        if ((i2 & 2) != 0) {
            str2 = merchantInfo.merBusName;
        }
        if ((i2 & 4) != 0) {
            str3 = merchantInfo.merLogoUrl;
        }
        if ((i2 & 8) != 0) {
            str4 = merchantInfo.merchantId;
        }
        return merchantInfo.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.merDispname;
    }

    public final String component2() {
        return this.merBusName;
    }

    public final String component3() {
        return this.merLogoUrl;
    }

    public final String component4() {
        return this.merchantId;
    }

    public final MerchantInfo copy(String str, String str2, String str3, String str4) {
        return new MerchantInfo(str, str2, str3, str4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MerchantInfo)) {
            return false;
        }
        MerchantInfo merchantInfo = (MerchantInfo) obj;
        return k.a((Object) this.merDispname, (Object) merchantInfo.merDispname) && k.a((Object) this.merBusName, (Object) merchantInfo.merBusName) && k.a((Object) this.merLogoUrl, (Object) merchantInfo.merLogoUrl) && k.a((Object) this.merchantId, (Object) merchantInfo.merchantId);
    }

    public final int hashCode() {
        String str = this.merDispname;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.merBusName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.merLogoUrl;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.merchantId;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "MerchantInfo(merDispname=" + this.merDispname + ", merBusName=" + this.merBusName + ", merLogoUrl=" + this.merLogoUrl + ", merchantId=" + this.merchantId + ")";
    }

    public final Object clone() {
        return super.clone();
    }

    public final String getMerDispname() {
        return this.merDispname;
    }

    public final void setMerDispname(String str) {
        this.merDispname = str;
    }

    public final String getMerBusName() {
        return this.merBusName;
    }

    public final void setMerBusName(String str) {
        this.merBusName = str;
    }

    public final String getMerLogoUrl() {
        return this.merLogoUrl;
    }

    public final void setMerLogoUrl(String str) {
        this.merLogoUrl = str;
    }

    public MerchantInfo(String str, String str2, String str3, String str4) {
        this.merDispname = str;
        this.merBusName = str2;
        this.merLogoUrl = str3;
        this.merchantId = str4;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MerchantInfo(String str, String str2, String str3, String str4, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4);
    }

    public final String getMerchantId() {
        return this.merchantId;
    }

    public final void setMerchantId(String str) {
        this.merchantId = str;
    }
}
