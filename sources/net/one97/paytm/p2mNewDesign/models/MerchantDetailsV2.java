package net.one97.paytm.p2mNewDesign.models;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public final class MerchantDetailsV2 extends CJRWalletDataModel implements IJRDataModel {
    @b(a = "mcc")
    private String mcc;
    @b(a = "merchantDisplayName")
    private final String merchantDisplayName;
    @b(a = "merchantLogo")
    private final String merchantLogo;
    @b(a = "merchantName")
    private String merchantName;
    @b(a = "merchantVpa")
    private String merchantVpa;

    public MerchantDetailsV2() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, 31, (g) null);
    }

    public MerchantDetailsV2(String str, String str2, String str3, String str4, String str5) {
        this.merchantVpa = str;
        this.mcc = str2;
        this.merchantName = str3;
        this.merchantLogo = str4;
        this.merchantDisplayName = str5;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MerchantDetailsV2(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, int r10, kotlin.g.b.g r11) {
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
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.models.MerchantDetailsV2.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getMcc() {
        return this.mcc;
    }

    public final String getMerchantDisplayName() {
        return this.merchantDisplayName;
    }

    public final String getMerchantLogo() {
        return this.merchantLogo;
    }

    public final String getMerchantName() {
        return this.merchantName;
    }

    public final String getMerchantVpa() {
        return this.merchantVpa;
    }

    public final void setMcc(String str) {
        this.mcc = str;
    }

    public final void setMerchantName(String str) {
        this.merchantName = str;
    }

    public final void setMerchantVpa(String str) {
        this.merchantVpa = str;
    }
}
