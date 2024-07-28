package net.one97.paytm.passbook.beans.mlv;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class MerchantItem extends IJRDataModel {
    @b(a = "balancePoints")
    private String balancePoints;
    @b(a = "description")
    private String description;
    @b(a = "logo")
    private String logo;
    @b(a = "merchantId")
    private String merchantId;
    @b(a = "name")
    private String name;
    @b(a = "status")
    private String status;
    @b(a = "txnListUrl")
    private String txnListUrl;

    public MerchantItem() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 127, (g) null);
    }

    public static /* synthetic */ MerchantItem copy$default(MerchantItem merchantItem, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = merchantItem.balancePoints;
        }
        if ((i2 & 2) != 0) {
            str2 = merchantItem.merchantId;
        }
        String str8 = str2;
        if ((i2 & 4) != 0) {
            str3 = merchantItem.name;
        }
        String str9 = str3;
        if ((i2 & 8) != 0) {
            str4 = merchantItem.logo;
        }
        String str10 = str4;
        if ((i2 & 16) != 0) {
            str5 = merchantItem.description;
        }
        String str11 = str5;
        if ((i2 & 32) != 0) {
            str6 = merchantItem.status;
        }
        String str12 = str6;
        if ((i2 & 64) != 0) {
            str7 = merchantItem.txnListUrl;
        }
        return merchantItem.copy(str, str8, str9, str10, str11, str12, str7);
    }

    public final String component1() {
        return this.balancePoints;
    }

    public final String component2() {
        return this.merchantId;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.logo;
    }

    public final String component5() {
        return this.description;
    }

    public final String component6() {
        return this.status;
    }

    public final String component7() {
        return this.txnListUrl;
    }

    public final MerchantItem copy(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        return new MerchantItem(str, str2, str3, str4, str5, str6, str7);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MerchantItem)) {
            return false;
        }
        MerchantItem merchantItem = (MerchantItem) obj;
        return k.a((Object) this.balancePoints, (Object) merchantItem.balancePoints) && k.a((Object) this.merchantId, (Object) merchantItem.merchantId) && k.a((Object) this.name, (Object) merchantItem.name) && k.a((Object) this.logo, (Object) merchantItem.logo) && k.a((Object) this.description, (Object) merchantItem.description) && k.a((Object) this.status, (Object) merchantItem.status) && k.a((Object) this.txnListUrl, (Object) merchantItem.txnListUrl);
    }

    public final int hashCode() {
        String str = this.balancePoints;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.merchantId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.name;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.logo;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.description;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.status;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.txnListUrl;
        if (str7 != null) {
            i2 = str7.hashCode();
        }
        return hashCode6 + i2;
    }

    public final String toString() {
        return "MerchantItem(balancePoints=" + this.balancePoints + ", merchantId=" + this.merchantId + ", name=" + this.name + ", logo=" + this.logo + ", description=" + this.description + ", status=" + this.status + ", txnListUrl=" + this.txnListUrl + ")";
    }

    public final String getBalancePoints() {
        return this.balancePoints;
    }

    public final void setBalancePoints(String str) {
        this.balancePoints = str;
    }

    public final String getMerchantId() {
        return this.merchantId;
    }

    public final void setMerchantId(String str) {
        this.merchantId = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getLogo() {
        return this.logo;
    }

    public final void setLogo(String str) {
        this.logo = str;
    }

    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MerchantItem(java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, int r14, kotlin.g.b.g r15) {
        /*
            r6 = this;
            r15 = r14 & 1
            r0 = 0
            if (r15 == 0) goto L_0x0007
            r15 = r0
            goto L_0x0008
        L_0x0007:
            r15 = r7
        L_0x0008:
            r7 = r14 & 2
            if (r7 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r8
        L_0x000f:
            r7 = r14 & 4
            if (r7 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r9
        L_0x0016:
            r7 = r14 & 8
            if (r7 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r10
        L_0x001d:
            r7 = r14 & 16
            if (r7 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r11
        L_0x0024:
            r7 = r14 & 32
            if (r7 == 0) goto L_0x002a
            r5 = r0
            goto L_0x002b
        L_0x002a:
            r5 = r12
        L_0x002b:
            r7 = r14 & 64
            if (r7 == 0) goto L_0x0031
            r14 = r0
            goto L_0x0032
        L_0x0031:
            r14 = r13
        L_0x0032:
            r7 = r6
            r8 = r15
            r9 = r1
            r10 = r2
            r11 = r3
            r12 = r4
            r13 = r5
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.beans.mlv.MerchantItem.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getTxnListUrl() {
        return this.txnListUrl;
    }

    public final void setTxnListUrl(String str) {
        this.txnListUrl = str;
    }

    public MerchantItem(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.balancePoints = str;
        this.merchantId = str2;
        this.name = str3;
        this.logo = str4;
        this.description = str5;
        this.status = str6;
        this.txnListUrl = str7;
    }
}
