package net.one97.paytm.upi.registration;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.HashMap;
import kotlin.g.b.k;

public final class EditVpaResponse extends IJRPaytmDataModel {
    @b(a = "editable")
    private final boolean editable;
    @b(a = "respCode")
    private final String responseCode;
    @b(a = "respMessage")
    private final String responseMessage;
    @b(a = "seqNo")
    private final String seqNumber;
    @b(a = "status")
    private final String status;
    @b(a = "vaMap")
    private final HashMap<String, String> vaMap;

    public static /* synthetic */ EditVpaResponse copy$default(EditVpaResponse editVpaResponse, String str, String str2, String str3, String str4, boolean z, HashMap<String, String> hashMap, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = editVpaResponse.status;
        }
        if ((i2 & 2) != 0) {
            str2 = editVpaResponse.responseCode;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            str3 = editVpaResponse.responseMessage;
        }
        String str6 = str3;
        if ((i2 & 8) != 0) {
            str4 = editVpaResponse.seqNumber;
        }
        String str7 = str4;
        if ((i2 & 16) != 0) {
            z = editVpaResponse.editable;
        }
        boolean z2 = z;
        if ((i2 & 32) != 0) {
            hashMap = editVpaResponse.vaMap;
        }
        return editVpaResponse.copy(str, str5, str6, str7, z2, hashMap);
    }

    public final String component1() {
        return this.status;
    }

    public final String component2() {
        return this.responseCode;
    }

    public final String component3() {
        return this.responseMessage;
    }

    public final String component4() {
        return this.seqNumber;
    }

    public final boolean component5() {
        return this.editable;
    }

    public final HashMap<String, String> component6() {
        return this.vaMap;
    }

    public final EditVpaResponse copy(String str, String str2, String str3, String str4, boolean z, HashMap<String, String> hashMap) {
        k.c(str, "status");
        k.c(str2, "responseCode");
        k.c(str3, "responseMessage");
        k.c(str4, "seqNumber");
        k.c(hashMap, "vaMap");
        return new EditVpaResponse(str, str2, str3, str4, z, hashMap);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EditVpaResponse)) {
            return false;
        }
        EditVpaResponse editVpaResponse = (EditVpaResponse) obj;
        return k.a((Object) this.status, (Object) editVpaResponse.status) && k.a((Object) this.responseCode, (Object) editVpaResponse.responseCode) && k.a((Object) this.responseMessage, (Object) editVpaResponse.responseMessage) && k.a((Object) this.seqNumber, (Object) editVpaResponse.seqNumber) && this.editable == editVpaResponse.editable && k.a((Object) this.vaMap, (Object) editVpaResponse.vaMap);
    }

    public final int hashCode() {
        String str = this.status;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.responseCode;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.responseMessage;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.seqNumber;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        boolean z = this.editable;
        if (z) {
            z = true;
        }
        int i3 = (hashCode4 + (z ? 1 : 0)) * 31;
        HashMap<String, String> hashMap = this.vaMap;
        if (hashMap != null) {
            i2 = hashMap.hashCode();
        }
        return i3 + i2;
    }

    public final String toString() {
        return "EditVpaResponse(status=" + this.status + ", responseCode=" + this.responseCode + ", responseMessage=" + this.responseMessage + ", seqNumber=" + this.seqNumber + ", editable=" + this.editable + ", vaMap=" + this.vaMap + ")";
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getResponseCode() {
        return this.responseCode;
    }

    public final String getResponseMessage() {
        return this.responseMessage;
    }

    public final String getSeqNumber() {
        return this.seqNumber;
    }

    public final boolean getEditable() {
        return this.editable;
    }

    public final HashMap<String, String> getVaMap() {
        return this.vaMap;
    }

    public EditVpaResponse(String str, String str2, String str3, String str4, boolean z, HashMap<String, String> hashMap) {
        k.c(str, "status");
        k.c(str2, "responseCode");
        k.c(str3, "responseMessage");
        k.c(str4, "seqNumber");
        k.c(hashMap, "vaMap");
        this.status = str;
        this.responseCode = str2;
        this.responseMessage = str3;
        this.seqNumber = str4;
        this.editable = z;
        this.vaMap = hashMap;
    }
}
