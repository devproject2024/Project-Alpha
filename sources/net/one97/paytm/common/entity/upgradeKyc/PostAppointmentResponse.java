package net.one97.paytm.common.entity.upgradeKyc;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class PostAppointmentResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "statusMessage")
    private final String msg;

    public PostAppointmentResponse() {
        this((String) null, 1, (g) null);
    }

    public static /* synthetic */ PostAppointmentResponse copy$default(PostAppointmentResponse postAppointmentResponse, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = postAppointmentResponse.msg;
        }
        return postAppointmentResponse.copy(str);
    }

    public final String component1() {
        return this.msg;
    }

    public final PostAppointmentResponse copy(String str) {
        return new PostAppointmentResponse(str);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof PostAppointmentResponse) && k.a((Object) this.msg, (Object) ((PostAppointmentResponse) obj).msg);
        }
        return true;
    }

    public final int hashCode() {
        String str = this.msg;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "PostAppointmentResponse(msg=" + this.msg + ")";
    }

    public PostAppointmentResponse(String str) {
        this.msg = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PostAppointmentResponse(String str, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str);
    }

    public final String getMsg() {
        return this.msg;
    }
}
