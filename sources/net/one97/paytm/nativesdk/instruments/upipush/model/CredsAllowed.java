package net.one97.paytm.nativesdk.instruments.upipush.model;

import kotlin.g.b.k;
import net.one97.paytm.nativesdk.common.model.BaseDataModel;

public final class CredsAllowed implements BaseDataModel {
    private String CredsAllowedDLength;
    private String CredsAllowedDType;
    private String CredsAllowedSubType;
    private String CredsAllowedType;
    private String dLength;

    public static /* synthetic */ CredsAllowed copy$default(CredsAllowed credsAllowed, String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = credsAllowed.dLength;
        }
        if ((i2 & 2) != 0) {
            str2 = credsAllowed.CredsAllowedSubType;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = credsAllowed.CredsAllowedType;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = credsAllowed.CredsAllowedDLength;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = credsAllowed.CredsAllowedDType;
        }
        return credsAllowed.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.dLength;
    }

    public final String component2() {
        return this.CredsAllowedSubType;
    }

    public final String component3() {
        return this.CredsAllowedType;
    }

    public final String component4() {
        return this.CredsAllowedDLength;
    }

    public final String component5() {
        return this.CredsAllowedDType;
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
        return k.a((Object) this.dLength, (Object) credsAllowed.dLength) && k.a((Object) this.CredsAllowedSubType, (Object) credsAllowed.CredsAllowedSubType) && k.a((Object) this.CredsAllowedType, (Object) credsAllowed.CredsAllowedType) && k.a((Object) this.CredsAllowedDLength, (Object) credsAllowed.CredsAllowedDLength) && k.a((Object) this.CredsAllowedDType, (Object) credsAllowed.CredsAllowedDType);
    }

    public final int hashCode() {
        String str = this.dLength;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.CredsAllowedSubType;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.CredsAllowedType;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.CredsAllowedDLength;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.CredsAllowedDType;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        return hashCode4 + i2;
    }

    public final String toString() {
        return "CredsAllowed(dLength=" + this.dLength + ", CredsAllowedSubType=" + this.CredsAllowedSubType + ", CredsAllowedType=" + this.CredsAllowedType + ", CredsAllowedDLength=" + this.CredsAllowedDLength + ", CredsAllowedDType=" + this.CredsAllowedDType + ")";
    }

    public CredsAllowed(String str, String str2, String str3, String str4, String str5) {
        this.dLength = str;
        this.CredsAllowedSubType = str2;
        this.CredsAllowedType = str3;
        this.CredsAllowedDLength = str4;
        this.CredsAllowedDType = str5;
    }

    public final String getDLength() {
        return this.dLength;
    }

    public final void setDLength(String str) {
        this.dLength = str;
    }

    public final String getCredsAllowedSubType() {
        return this.CredsAllowedSubType;
    }

    public final void setCredsAllowedSubType(String str) {
        this.CredsAllowedSubType = str;
    }

    public final String getCredsAllowedType() {
        return this.CredsAllowedType;
    }

    public final void setCredsAllowedType(String str) {
        this.CredsAllowedType = str;
    }

    public final String getCredsAllowedDLength() {
        return this.CredsAllowedDLength;
    }

    public final void setCredsAllowedDLength(String str) {
        this.CredsAllowedDLength = str;
    }

    public final String getCredsAllowedDType() {
        return this.CredsAllowedDType;
    }

    public final void setCredsAllowedDType(String str) {
        this.CredsAllowedDType = str;
    }
}
