package net.one97.paytm.common.entity.p2p;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CredsAllowed extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "CredsAllowedDLength")
    private String credsAllowedDLength;
    @b(a = "CredsAllowedDType")
    private String credsAllowedDType;
    @b(a = "CredsAllowedSubType")
    private String credsAllowedSubType;
    @b(a = "CredsAllowedType")
    private String credsAllowedType;
    @b(a = "dLength")
    private String dLength;

    public CredsAllowed() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, 31, (g) null);
    }

    public static /* synthetic */ CredsAllowed copy$default(CredsAllowed credsAllowed, String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = credsAllowed.credsAllowedType;
        }
        if ((i2 & 2) != 0) {
            str2 = credsAllowed.credsAllowedDType;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = credsAllowed.credsAllowedSubType;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = credsAllowed.credsAllowedDLength;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = credsAllowed.dLength;
        }
        return credsAllowed.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.credsAllowedType;
    }

    public final String component2() {
        return this.credsAllowedDType;
    }

    public final String component3() {
        return this.credsAllowedSubType;
    }

    public final String component4() {
        return this.credsAllowedDLength;
    }

    public final String component5() {
        return this.dLength;
    }

    public final CredsAllowed copy(String str, String str2, String str3, String str4, String str5) {
        return new CredsAllowed(str, str2, str3, str4, str5);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CredsAllowed)) {
            return false;
        }
        CredsAllowed credsAllowed = (CredsAllowed) obj;
        return k.a((Object) this.credsAllowedType, (Object) credsAllowed.credsAllowedType) && k.a((Object) this.credsAllowedDType, (Object) credsAllowed.credsAllowedDType) && k.a((Object) this.credsAllowedSubType, (Object) credsAllowed.credsAllowedSubType) && k.a((Object) this.credsAllowedDLength, (Object) credsAllowed.credsAllowedDLength) && k.a((Object) this.dLength, (Object) credsAllowed.dLength);
    }

    public final int hashCode() {
        String str = this.credsAllowedType;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.credsAllowedDType;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.credsAllowedSubType;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.credsAllowedDLength;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.dLength;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        return hashCode4 + i2;
    }

    public final String toString() {
        return "CredsAllowed(credsAllowedType=" + this.credsAllowedType + ", credsAllowedDType=" + this.credsAllowedDType + ", credsAllowedSubType=" + this.credsAllowedSubType + ", credsAllowedDLength=" + this.credsAllowedDLength + ", dLength=" + this.dLength + ")";
    }

    public final Object clone() {
        return super.clone();
    }

    public final String getCredsAllowedType() {
        return this.credsAllowedType;
    }

    public final void setCredsAllowedType(String str) {
        this.credsAllowedType = str;
    }

    public final String getCredsAllowedDType() {
        return this.credsAllowedDType;
    }

    public final void setCredsAllowedDType(String str) {
        this.credsAllowedDType = str;
    }

    public final String getCredsAllowedSubType() {
        return this.credsAllowedSubType;
    }

    public final void setCredsAllowedSubType(String str) {
        this.credsAllowedSubType = str;
    }

    public final String getCredsAllowedDLength() {
        return this.credsAllowedDLength;
    }

    public final void setCredsAllowedDLength(String str) {
        this.credsAllowedDLength = str;
    }

    public CredsAllowed(String str, String str2, String str3, String str4, String str5) {
        this.credsAllowedType = str;
        this.credsAllowedDType = str2;
        this.credsAllowedSubType = str3;
        this.credsAllowedDLength = str4;
        this.dLength = str5;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CredsAllowed(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, int r10, kotlin.g.b.g r11) {
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
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.common.entity.p2p.CredsAllowed.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getDLength() {
        return this.dLength;
    }

    public final void setDLength(String str) {
        this.dLength = str;
    }
}
