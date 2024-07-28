package net.one97.paytm.bankOpen.ica.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class ICALeadCreateResponse extends IJRPaytmDataModel {
    @b(a = "leadId")
    private final String leadId;
    @b(a = "refId")
    private final String refId;
    @b(a = "statusCode")
    private final int statusCode;

    public ICALeadCreateResponse() {
        this((String) null, (String) null, 0, 7, (g) null);
    }

    public static /* synthetic */ ICALeadCreateResponse copy$default(ICALeadCreateResponse iCALeadCreateResponse, String str, String str2, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = iCALeadCreateResponse.refId;
        }
        if ((i3 & 2) != 0) {
            str2 = iCALeadCreateResponse.leadId;
        }
        if ((i3 & 4) != 0) {
            i2 = iCALeadCreateResponse.statusCode;
        }
        return iCALeadCreateResponse.copy(str, str2, i2);
    }

    public final String component1() {
        return this.refId;
    }

    public final String component2() {
        return this.leadId;
    }

    public final int component3() {
        return this.statusCode;
    }

    public final ICALeadCreateResponse copy(String str, String str2, int i2) {
        k.c(str, "refId");
        k.c(str2, "leadId");
        return new ICALeadCreateResponse(str, str2, i2);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ICALeadCreateResponse) {
                ICALeadCreateResponse iCALeadCreateResponse = (ICALeadCreateResponse) obj;
                if (k.a((Object) this.refId, (Object) iCALeadCreateResponse.refId) && k.a((Object) this.leadId, (Object) iCALeadCreateResponse.leadId)) {
                    if (this.statusCode == iCALeadCreateResponse.statusCode) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.refId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.leadId;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return ((hashCode + i2) * 31) + this.statusCode;
    }

    public final String toString() {
        return "ICALeadCreateResponse(refId=" + this.refId + ", leadId=" + this.leadId + ", statusCode=" + this.statusCode + ")";
    }

    public final String getRefId() {
        return this.refId;
    }

    public final String getLeadId() {
        return this.leadId;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ICALeadCreateResponse(String str, String str2, int i2, int i3, g gVar) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? 0 : i2);
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public ICALeadCreateResponse(String str, String str2, int i2) {
        k.c(str, "refId");
        k.c(str2, "leadId");
        this.refId = str;
        this.leadId = str2;
        this.statusCode = i2;
    }
}
