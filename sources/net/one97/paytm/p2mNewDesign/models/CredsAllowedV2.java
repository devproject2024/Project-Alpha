package net.one97.paytm.p2mNewDesign.models;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.network.CJRWalletDataModel;

public final class CredsAllowedV2 extends CJRWalletDataModel {
    @b(a = "CredsAllowedDLength")
    private String CredsAllowedDLength;
    @b(a = "CredsAllowedDType")
    private String CredsAllowedDType;
    @b(a = "CredsAllowedSubType")
    private String CredsAllowedSubType;
    @b(a = "CredsAllowedType")
    private String CredsAllowedType;
    @b(a = "dLength")
    private String dLength;

    public CredsAllowedV2() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, 31, (g) null);
    }

    public static /* synthetic */ CredsAllowedV2 copy$default(CredsAllowedV2 credsAllowedV2, String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = credsAllowedV2.CredsAllowedDLength;
        }
        if ((i2 & 2) != 0) {
            str2 = credsAllowedV2.CredsAllowedDType;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = credsAllowedV2.CredsAllowedSubType;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = credsAllowedV2.CredsAllowedType;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = credsAllowedV2.dLength;
        }
        return credsAllowedV2.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.CredsAllowedDLength;
    }

    public final String component2() {
        return this.CredsAllowedDType;
    }

    public final String component3() {
        return this.CredsAllowedSubType;
    }

    public final String component4() {
        return this.CredsAllowedType;
    }

    public final String component5() {
        return this.dLength;
    }

    public final CredsAllowedV2 copy(String str, String str2, String str3, String str4, String str5) {
        return new CredsAllowedV2(str, str2, str3, str4, str5);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CredsAllowedV2)) {
            return false;
        }
        CredsAllowedV2 credsAllowedV2 = (CredsAllowedV2) obj;
        return k.a((Object) this.CredsAllowedDLength, (Object) credsAllowedV2.CredsAllowedDLength) && k.a((Object) this.CredsAllowedDType, (Object) credsAllowedV2.CredsAllowedDType) && k.a((Object) this.CredsAllowedSubType, (Object) credsAllowedV2.CredsAllowedSubType) && k.a((Object) this.CredsAllowedType, (Object) credsAllowedV2.CredsAllowedType) && k.a((Object) this.dLength, (Object) credsAllowedV2.dLength);
    }

    public final int hashCode() {
        String str = this.CredsAllowedDLength;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.CredsAllowedDType;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.CredsAllowedSubType;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.CredsAllowedType;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.dLength;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        return hashCode4 + i2;
    }

    public final String toString() {
        return "CredsAllowedV2(CredsAllowedDLength=" + this.CredsAllowedDLength + ", CredsAllowedDType=" + this.CredsAllowedDType + ", CredsAllowedSubType=" + this.CredsAllowedSubType + ", CredsAllowedType=" + this.CredsAllowedType + ", dLength=" + this.dLength + ")";
    }

    public CredsAllowedV2(String str, String str2, String str3, String str4, String str5) {
        this.CredsAllowedDLength = str;
        this.CredsAllowedDType = str2;
        this.CredsAllowedSubType = str3;
        this.CredsAllowedType = str4;
        this.dLength = str5;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CredsAllowedV2(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, int r10, kotlin.g.b.g r11) {
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
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.models.CredsAllowedV2.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getCredsAllowedDLength() {
        return this.CredsAllowedDLength;
    }

    public final String getCredsAllowedDType() {
        return this.CredsAllowedDType;
    }

    public final String getCredsAllowedSubType() {
        return this.CredsAllowedSubType;
    }

    public final String getCredsAllowedType() {
        return this.CredsAllowedType;
    }

    public final String getDLength() {
        return this.dLength;
    }

    public final void setCredsAllowedDLength(String str) {
        this.CredsAllowedDLength = str;
    }

    public final void setCredsAllowedDType(String str) {
        this.CredsAllowedDType = str;
    }

    public final void setCredsAllowedSubType(String str) {
        this.CredsAllowedSubType = str;
    }

    public final void setCredsAllowedType(String str) {
        this.CredsAllowedType = str;
    }

    public final void setDLength(String str) {
        this.dLength = str;
    }
}
