package net.one97.paytm.p2mNewDesign.models;

import com.google.gsonhtcfix.a.b;
import java.util.HashMap;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class ExtendInfoV2 implements IJRDataModel {
    @b(a = "additionalProperties")
    private HashMap<String, Object> additionalProperties;
    @b(a = "key")
    private String key;
    @b(a = "lenderDescription")
    private String lenderDescription;
    @b(a = "lenderId")
    private String lenderId;
    @b(a = "otpRequired")
    private String otpRequired;
    @b(a = "passcodeRequired")
    private String passcodeRequired;

    public static /* synthetic */ ExtendInfoV2 copy$default(ExtendInfoV2 extendInfoV2, String str, String str2, String str3, String str4, String str5, HashMap<String, Object> hashMap, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = extendInfoV2.lenderId;
        }
        if ((i2 & 2) != 0) {
            str2 = extendInfoV2.lenderDescription;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = extendInfoV2.otpRequired;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = extendInfoV2.passcodeRequired;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = extendInfoV2.key;
        }
        String str9 = str5;
        if ((i2 & 32) != 0) {
            hashMap = extendInfoV2.additionalProperties;
        }
        return extendInfoV2.copy(str, str6, str7, str8, str9, hashMap);
    }

    public final String component1() {
        return this.lenderId;
    }

    public final String component2() {
        return this.lenderDescription;
    }

    public final String component3() {
        return this.otpRequired;
    }

    public final String component4() {
        return this.passcodeRequired;
    }

    public final String component5() {
        return this.key;
    }

    public final HashMap<String, Object> component6() {
        return this.additionalProperties;
    }

    public final ExtendInfoV2 copy(String str, String str2, String str3, String str4, String str5, HashMap<String, Object> hashMap) {
        return new ExtendInfoV2(str, str2, str3, str4, str5, hashMap);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExtendInfoV2)) {
            return false;
        }
        ExtendInfoV2 extendInfoV2 = (ExtendInfoV2) obj;
        return k.a((Object) this.lenderId, (Object) extendInfoV2.lenderId) && k.a((Object) this.lenderDescription, (Object) extendInfoV2.lenderDescription) && k.a((Object) this.otpRequired, (Object) extendInfoV2.otpRequired) && k.a((Object) this.passcodeRequired, (Object) extendInfoV2.passcodeRequired) && k.a((Object) this.key, (Object) extendInfoV2.key) && k.a((Object) this.additionalProperties, (Object) extendInfoV2.additionalProperties);
    }

    public final int hashCode() {
        String str = this.lenderId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.lenderDescription;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.otpRequired;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.passcodeRequired;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.key;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        HashMap<String, Object> hashMap = this.additionalProperties;
        if (hashMap != null) {
            i2 = hashMap.hashCode();
        }
        return hashCode5 + i2;
    }

    public final String toString() {
        return "ExtendInfoV2(lenderId=" + this.lenderId + ", lenderDescription=" + this.lenderDescription + ", otpRequired=" + this.otpRequired + ", passcodeRequired=" + this.passcodeRequired + ", key=" + this.key + ", additionalProperties=" + this.additionalProperties + ")";
    }

    public ExtendInfoV2(String str, String str2, String str3, String str4, String str5, HashMap<String, Object> hashMap) {
        this.lenderId = str;
        this.lenderDescription = str2;
        this.otpRequired = str3;
        this.passcodeRequired = str4;
        this.key = str5;
        this.additionalProperties = hashMap;
    }

    public final String getLenderDescription() {
        return this.lenderDescription;
    }

    public final String getLenderId() {
        return this.lenderId;
    }

    public final void setLenderDescription(String str) {
        this.lenderDescription = str;
    }

    public final void setLenderId(String str) {
        this.lenderId = str;
    }

    public final String getOtpRequired() {
        return this.otpRequired;
    }

    public final void setOtpRequired(String str) {
        this.otpRequired = str;
    }

    public final String getPasscodeRequired() {
        return this.passcodeRequired;
    }

    public final void setPasscodeRequired(String str) {
        this.passcodeRequired = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ExtendInfoV2(String str, String str2, String str3, String str4, String str5, HashMap hashMap, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4, (i2 & 16) != 0 ? null : str5, hashMap);
    }

    public final HashMap<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public final String getKey() {
        return this.key;
    }

    public final void setAdditionalProperties(HashMap<String, Object> hashMap) {
        this.additionalProperties = hashMap;
    }

    public final void setKey(String str) {
        this.key = str;
    }
}
