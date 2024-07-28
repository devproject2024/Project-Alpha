package net.one97.paytm.paymentsBank.chequebook.utils;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;

public final class CbPreValidatePayLoad extends IJRPaytmDataModel {
    @b(a = "documentation")
    private final String documentation;
    @b(a = "errorCode")
    private final Integer errorCode;
    @b(a = "errorMessage")
    private String errorMessage;

    public static /* synthetic */ CbPreValidatePayLoad copy$default(CbPreValidatePayLoad cbPreValidatePayLoad, String str, Integer num, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cbPreValidatePayLoad.errorMessage;
        }
        if ((i2 & 2) != 0) {
            num = cbPreValidatePayLoad.errorCode;
        }
        if ((i2 & 4) != 0) {
            str2 = cbPreValidatePayLoad.documentation;
        }
        return cbPreValidatePayLoad.copy(str, num, str2);
    }

    public final String component1() {
        return this.errorMessage;
    }

    public final Integer component2() {
        return this.errorCode;
    }

    public final String component3() {
        return this.documentation;
    }

    public final CbPreValidatePayLoad copy(String str, Integer num, String str2) {
        return new CbPreValidatePayLoad(str, num, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CbPreValidatePayLoad)) {
            return false;
        }
        CbPreValidatePayLoad cbPreValidatePayLoad = (CbPreValidatePayLoad) obj;
        return k.a((Object) this.errorMessage, (Object) cbPreValidatePayLoad.errorMessage) && k.a((Object) this.errorCode, (Object) cbPreValidatePayLoad.errorCode) && k.a((Object) this.documentation, (Object) cbPreValidatePayLoad.documentation);
    }

    public final int hashCode() {
        String str = this.errorMessage;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.errorCode;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        String str2 = this.documentation;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "CbPreValidatePayLoad(errorMessage=" + this.errorMessage + ", errorCode=" + this.errorCode + ", documentation=" + this.documentation + ")";
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final Integer getErrorCode() {
        return this.errorCode;
    }

    public CbPreValidatePayLoad(String str, Integer num, String str2) {
        this.errorMessage = str;
        this.errorCode = num;
        this.documentation = str2;
    }

    public final String getDocumentation() {
        return this.documentation;
    }
}
