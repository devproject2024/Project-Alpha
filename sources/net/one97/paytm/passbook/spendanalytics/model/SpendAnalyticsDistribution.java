package net.one97.paytm.passbook.spendanalytics.model;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class SpendAnalyticsDistribution extends IJRDataModel {
    @b(a = "cnt")
    private String cnt;
    @b(a = "key")
    private String key;
    @b(a = "logo")
    private String logo;
    @b(a = "mdn")
    private String mdn;
    @b(a = "sum")
    private String sum;

    public SpendAnalyticsDistribution() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, 31, (g) null);
    }

    public static /* synthetic */ SpendAnalyticsDistribution copy$default(SpendAnalyticsDistribution spendAnalyticsDistribution, String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = spendAnalyticsDistribution.mdn;
        }
        if ((i2 & 2) != 0) {
            str2 = spendAnalyticsDistribution.cnt;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = spendAnalyticsDistribution.logo;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = spendAnalyticsDistribution.sum;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = spendAnalyticsDistribution.key;
        }
        return spendAnalyticsDistribution.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.mdn;
    }

    public final String component2() {
        return this.cnt;
    }

    public final String component3() {
        return this.logo;
    }

    public final String component4() {
        return this.sum;
    }

    public final String component5() {
        return this.key;
    }

    public final SpendAnalyticsDistribution copy(String str, String str2, String str3, String str4, String str5) {
        return new SpendAnalyticsDistribution(str, str2, str3, str4, str5);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SpendAnalyticsDistribution)) {
            return false;
        }
        SpendAnalyticsDistribution spendAnalyticsDistribution = (SpendAnalyticsDistribution) obj;
        return k.a((Object) this.mdn, (Object) spendAnalyticsDistribution.mdn) && k.a((Object) this.cnt, (Object) spendAnalyticsDistribution.cnt) && k.a((Object) this.logo, (Object) spendAnalyticsDistribution.logo) && k.a((Object) this.sum, (Object) spendAnalyticsDistribution.sum) && k.a((Object) this.key, (Object) spendAnalyticsDistribution.key);
    }

    public final int hashCode() {
        String str = this.mdn;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.cnt;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.logo;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.sum;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.key;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        return hashCode4 + i2;
    }

    public final String toString() {
        return "SpendAnalyticsDistribution(mdn=" + this.mdn + ", cnt=" + this.cnt + ", logo=" + this.logo + ", sum=" + this.sum + ", key=" + this.key + ")";
    }

    public final String getMdn() {
        return this.mdn;
    }

    public final void setMdn(String str) {
        this.mdn = str;
    }

    public final String getCnt() {
        return this.cnt;
    }

    public final void setCnt(String str) {
        this.cnt = str;
    }

    public final String getLogo() {
        return this.logo;
    }

    public final void setLogo(String str) {
        this.logo = str;
    }

    public final String getSum() {
        return this.sum;
    }

    public final void setSum(String str) {
        this.sum = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SpendAnalyticsDistribution(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, int r10, kotlin.g.b.g r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0007
            r11 = r0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r7
        L_0x0016:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r8
        L_0x001d:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0023
            r10 = r0
            goto L_0x0024
        L_0x0023:
            r10 = r9
        L_0x0024:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getKey() {
        return this.key;
    }

    public final void setKey(String str) {
        this.key = str;
    }

    public SpendAnalyticsDistribution(String str, String str2, String str3, String str4, String str5) {
        this.mdn = str;
        this.cnt = str2;
        this.logo = str3;
        this.sum = str4;
        this.key = str5;
    }
}
