package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class FirstGamesSMSResponse extends IJRDataModel {
    @b(a = "message")
    private String message;
    @b(a = "status")
    private String status;

    public FirstGamesSMSResponse() {
        this((String) null, (String) null, 3, (g) null);
    }

    public static /* synthetic */ FirstGamesSMSResponse copy$default(FirstGamesSMSResponse firstGamesSMSResponse, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = firstGamesSMSResponse.status;
        }
        if ((i2 & 2) != 0) {
            str2 = firstGamesSMSResponse.message;
        }
        return firstGamesSMSResponse.copy(str, str2);
    }

    public final String component1() {
        return this.status;
    }

    public final String component2() {
        return this.message;
    }

    public final FirstGamesSMSResponse copy(String str, String str2) {
        return new FirstGamesSMSResponse(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FirstGamesSMSResponse)) {
            return false;
        }
        FirstGamesSMSResponse firstGamesSMSResponse = (FirstGamesSMSResponse) obj;
        return k.a((Object) this.status, (Object) firstGamesSMSResponse.status) && k.a((Object) this.message, (Object) firstGamesSMSResponse.message);
    }

    public final int hashCode() {
        String str = this.status;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.message;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "FirstGamesSMSResponse(status=" + this.status + ", message=" + this.message + ")";
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FirstGamesSMSResponse(String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2);
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public FirstGamesSMSResponse(String str, String str2) {
        this.status = str;
        this.message = str2;
    }
}
