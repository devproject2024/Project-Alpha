package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class SAInstrument extends IJRDataModel {
    @b(a = "additionalDetail")
    private String additionalDetail;
    @b(a = "amount")
    private String amount;
    @b(a = "instrumentDetail")
    private String instrumentDetail;
    @b(a = "logoUrl")
    private String logoUrl;
    @b(a = "name")
    private String name;
    @b(a = "narration")
    private String narration;

    public SAInstrument() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 63, (g) null);
    }

    public static /* synthetic */ SAInstrument copy$default(SAInstrument sAInstrument, String str, String str2, String str3, String str4, String str5, String str6, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = sAInstrument.narration;
        }
        if ((i2 & 2) != 0) {
            str2 = sAInstrument.name;
        }
        String str7 = str2;
        if ((i2 & 4) != 0) {
            str3 = sAInstrument.logoUrl;
        }
        String str8 = str3;
        if ((i2 & 8) != 0) {
            str4 = sAInstrument.instrumentDetail;
        }
        String str9 = str4;
        if ((i2 & 16) != 0) {
            str5 = sAInstrument.additionalDetail;
        }
        String str10 = str5;
        if ((i2 & 32) != 0) {
            str6 = sAInstrument.amount;
        }
        return sAInstrument.copy(str, str7, str8, str9, str10, str6);
    }

    public final String component1() {
        return this.narration;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.logoUrl;
    }

    public final String component4() {
        return this.instrumentDetail;
    }

    public final String component5() {
        return this.additionalDetail;
    }

    public final String component6() {
        return this.amount;
    }

    public final SAInstrument copy(String str, String str2, String str3, String str4, String str5, String str6) {
        return new SAInstrument(str, str2, str3, str4, str5, str6);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SAInstrument)) {
            return false;
        }
        SAInstrument sAInstrument = (SAInstrument) obj;
        return k.a((Object) this.narration, (Object) sAInstrument.narration) && k.a((Object) this.name, (Object) sAInstrument.name) && k.a((Object) this.logoUrl, (Object) sAInstrument.logoUrl) && k.a((Object) this.instrumentDetail, (Object) sAInstrument.instrumentDetail) && k.a((Object) this.additionalDetail, (Object) sAInstrument.additionalDetail) && k.a((Object) this.amount, (Object) sAInstrument.amount);
    }

    public final int hashCode() {
        String str = this.narration;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.logoUrl;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.instrumentDetail;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.additionalDetail;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.amount;
        if (str6 != null) {
            i2 = str6.hashCode();
        }
        return hashCode5 + i2;
    }

    public final String toString() {
        return "SAInstrument(narration=" + this.narration + ", name=" + this.name + ", logoUrl=" + this.logoUrl + ", instrumentDetail=" + this.instrumentDetail + ", additionalDetail=" + this.additionalDetail + ", amount=" + this.amount + ")";
    }

    public final String getNarration() {
        return this.narration;
    }

    public final void setNarration(String str) {
        this.narration = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getLogoUrl() {
        return this.logoUrl;
    }

    public final void setLogoUrl(String str) {
        this.logoUrl = str;
    }

    public final String getInstrumentDetail() {
        return this.instrumentDetail;
    }

    public final void setInstrumentDetail(String str) {
        this.instrumentDetail = str;
    }

    public final String getAdditionalDetail() {
        return this.additionalDetail;
    }

    public final void setAdditionalDetail(String str) {
        this.additionalDetail = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SAInstrument(java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, int r12, kotlin.g.b.g r13) {
        /*
            r5 = this;
            r13 = r12 & 1
            r0 = 0
            if (r13 == 0) goto L_0x0007
            r13 = r0
            goto L_0x0008
        L_0x0007:
            r13 = r6
        L_0x0008:
            r6 = r12 & 2
            if (r6 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r7
        L_0x000f:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r8
        L_0x0016:
            r6 = r12 & 8
            if (r6 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r9
        L_0x001d:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r10
        L_0x0024:
            r6 = r12 & 32
            if (r6 == 0) goto L_0x002a
            r12 = r0
            goto L_0x002b
        L_0x002a:
            r12 = r11
        L_0x002b:
            r6 = r5
            r7 = r13
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.beans.SAInstrument.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getAmount() {
        return this.amount;
    }

    public final void setAmount(String str) {
        this.amount = str;
    }

    public SAInstrument(String str, String str2, String str3, String str4, String str5, String str6) {
        this.narration = str;
        this.name = str2;
        this.logoUrl = str3;
        this.instrumentDetail = str4;
        this.additionalDetail = str5;
        this.amount = str6;
    }
}
