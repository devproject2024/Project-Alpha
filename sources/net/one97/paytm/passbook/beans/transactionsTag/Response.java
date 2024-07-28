package net.one97.paytm.passbook.beans.transactionsTag;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class Response extends IJRDataModel {
    @b(a = "status")
    private String statusMessage;

    public Response() {
        this((String) null, 1, (g) null);
    }

    public static /* synthetic */ Response copy$default(Response response, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = response.statusMessage;
        }
        return response.copy(str);
    }

    public final String component1() {
        return this.statusMessage;
    }

    public final Response copy(String str) {
        return new Response(str);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof Response) && k.a((Object) this.statusMessage, (Object) ((Response) obj).statusMessage);
        }
        return true;
    }

    public final int hashCode() {
        String str = this.statusMessage;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "Response(statusMessage=" + this.statusMessage + ")";
    }

    public Response(String str) {
        this.statusMessage = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Response(String str, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str);
    }

    public final String getStatusMessage() {
        return this.statusMessage;
    }

    public final void setStatusMessage(String str) {
        this.statusMessage = str;
    }
}
