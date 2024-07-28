package net.one97.paytm.p2mNewDesign.models;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public final class NativePromoCodeDataV2 extends CJRWalletDataModel implements IJRDataModel {
    @b(a = "isPromoCodeValid")
    private final boolean isPromoCodeValid;
    @b(a = "promoCode")
    private final String promoCode;
    @b(a = "promoCodeMsg")
    private final String promoCodeMsg;
    @b(a = "promoCodeTypeName")
    private final String promoCodeTypeName;
    @b(a = "promoMsg")
    private final String promoMsg;

    public NativePromoCodeDataV2() {
        this((String) null, (String) null, false, (String) null, (String) null, 31, (g) null);
    }

    public static /* synthetic */ NativePromoCodeDataV2 copy$default(NativePromoCodeDataV2 nativePromoCodeDataV2, String str, String str2, boolean z, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = nativePromoCodeDataV2.promoCode;
        }
        if ((i2 & 2) != 0) {
            str2 = nativePromoCodeDataV2.promoMsg;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            z = nativePromoCodeDataV2.isPromoCodeValid;
        }
        boolean z2 = z;
        if ((i2 & 8) != 0) {
            str3 = nativePromoCodeDataV2.promoCodeTypeName;
        }
        String str6 = str3;
        if ((i2 & 16) != 0) {
            str4 = nativePromoCodeDataV2.promoCodeMsg;
        }
        return nativePromoCodeDataV2.copy(str, str5, z2, str6, str4);
    }

    public final String component1() {
        return this.promoCode;
    }

    public final String component2() {
        return this.promoMsg;
    }

    public final boolean component3() {
        return this.isPromoCodeValid;
    }

    public final String component4() {
        return this.promoCodeTypeName;
    }

    public final String component5() {
        return this.promoCodeMsg;
    }

    public final NativePromoCodeDataV2 copy(String str, String str2, boolean z, String str3, String str4) {
        return new NativePromoCodeDataV2(str, str2, z, str3, str4);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof NativePromoCodeDataV2) {
                NativePromoCodeDataV2 nativePromoCodeDataV2 = (NativePromoCodeDataV2) obj;
                if (k.a((Object) this.promoCode, (Object) nativePromoCodeDataV2.promoCode) && k.a((Object) this.promoMsg, (Object) nativePromoCodeDataV2.promoMsg)) {
                    if (!(this.isPromoCodeValid == nativePromoCodeDataV2.isPromoCodeValid) || !k.a((Object) this.promoCodeTypeName, (Object) nativePromoCodeDataV2.promoCodeTypeName) || !k.a((Object) this.promoCodeMsg, (Object) nativePromoCodeDataV2.promoCodeMsg)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.promoCode;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.promoMsg;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z = this.isPromoCodeValid;
        if (z) {
            z = true;
        }
        int i3 = (hashCode2 + (z ? 1 : 0)) * 31;
        String str3 = this.promoCodeTypeName;
        int hashCode3 = (i3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.promoCodeMsg;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "NativePromoCodeDataV2(promoCode=" + this.promoCode + ", promoMsg=" + this.promoMsg + ", isPromoCodeValid=" + this.isPromoCodeValid + ", promoCodeTypeName=" + this.promoCodeTypeName + ", promoCodeMsg=" + this.promoCodeMsg + ")";
    }

    public NativePromoCodeDataV2(String str, String str2, boolean z, String str3, String str4) {
        this.promoCode = str;
        this.promoMsg = str2;
        this.isPromoCodeValid = z;
        this.promoCodeTypeName = str3;
        this.promoCodeMsg = str4;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ NativePromoCodeDataV2(java.lang.String r5, java.lang.String r6, boolean r7, java.lang.String r8, java.lang.String r9, int r10, kotlin.g.b.g r11) {
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
            if (r5 == 0) goto L_0x0016
            r7 = 0
            r2 = 0
            goto L_0x0017
        L_0x0016:
            r2 = r7
        L_0x0017:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001d
            r3 = r0
            goto L_0x001e
        L_0x001d:
            r3 = r8
        L_0x001e:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0024
            r10 = r0
            goto L_0x0025
        L_0x0024:
            r10 = r9
        L_0x0025:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.models.NativePromoCodeDataV2.<init>(java.lang.String, java.lang.String, boolean, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getPromoCode() {
        return this.promoCode;
    }

    public final String getPromoCodeMsg() {
        return this.promoCodeMsg;
    }

    public final String getPromoCodeTypeName() {
        return this.promoCodeTypeName;
    }

    public final String getPromoMsg() {
        return this.promoMsg;
    }

    public final boolean isPromoCodeValid() {
        return this.isPromoCodeValid;
    }
}
