package net.one97.paytm.paymentsBank.chequebook.utils;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class ChequeBookNames extends IJRPaytmDataModel {
    @b(a = "message")
    private final String message;
    @b(a = "responseCode")
    private final String responseCode;
    @b(a = "status")
    private final String status;
    @b(a = "response")
    private final List<String> suggestedNames;

    public ChequeBookNames() {
        this((String) null, (List) null, (String) null, (String) null, 15, (g) null);
    }

    public static /* synthetic */ ChequeBookNames copy$default(ChequeBookNames chequeBookNames, String str, List<String> list, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = chequeBookNames.message;
        }
        if ((i2 & 2) != 0) {
            list = chequeBookNames.suggestedNames;
        }
        if ((i2 & 4) != 0) {
            str2 = chequeBookNames.responseCode;
        }
        if ((i2 & 8) != 0) {
            str3 = chequeBookNames.status;
        }
        return chequeBookNames.copy(str, list, str2, str3);
    }

    public final String component1() {
        return this.message;
    }

    public final List<String> component2() {
        return this.suggestedNames;
    }

    public final String component3() {
        return this.responseCode;
    }

    public final String component4() {
        return this.status;
    }

    public final ChequeBookNames copy(String str, List<String> list, String str2, String str3) {
        return new ChequeBookNames(str, list, str2, str3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChequeBookNames)) {
            return false;
        }
        ChequeBookNames chequeBookNames = (ChequeBookNames) obj;
        return k.a((Object) this.message, (Object) chequeBookNames.message) && k.a((Object) this.suggestedNames, (Object) chequeBookNames.suggestedNames) && k.a((Object) this.responseCode, (Object) chequeBookNames.responseCode) && k.a((Object) this.status, (Object) chequeBookNames.status);
    }

    public final int hashCode() {
        String str = this.message;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<String> list = this.suggestedNames;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.responseCode;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.status;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "ChequeBookNames(message=" + this.message + ", suggestedNames=" + this.suggestedNames + ", responseCode=" + this.responseCode + ", status=" + this.status + ")";
    }

    public final String getMessage() {
        return this.message;
    }

    public final List<String> getSuggestedNames() {
        return this.suggestedNames;
    }

    public final String getResponseCode() {
        return this.responseCode;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChequeBookNames(String str, List list, String str2, String str3, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : list, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : str3);
    }

    public final String getStatus() {
        return this.status;
    }

    public ChequeBookNames(String str, List<String> list, String str2, String str3) {
        this.message = str;
        this.suggestedNames = list;
        this.responseCode = str2;
        this.status = str3;
    }
}
