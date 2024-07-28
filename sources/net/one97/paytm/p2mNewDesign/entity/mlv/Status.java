package net.one97.paytm.p2mNewDesign.entity.mlv;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public final class Status extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "code")
    private String code;
    @b(a = "message")
    private Message message;
    @b(a = "result")
    private String result;

    public Status() {
        this((String) null, (Message) null, (String) null, 7, (g) null);
    }

    public static /* synthetic */ Status copy$default(Status status, String str, Message message2, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = status.result;
        }
        if ((i2 & 2) != 0) {
            message2 = status.message;
        }
        if ((i2 & 4) != 0) {
            str2 = status.code;
        }
        return status.copy(str, message2, str2);
    }

    public final String component1() {
        return this.result;
    }

    public final Message component2() {
        return this.message;
    }

    public final String component3() {
        return this.code;
    }

    public final Status copy(String str, Message message2, String str2) {
        return new Status(str, message2, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return k.a((Object) this.result, (Object) status.result) && k.a((Object) this.message, (Object) status.message) && k.a((Object) this.code, (Object) status.code);
    }

    public final int hashCode() {
        String str = this.result;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Message message2 = this.message;
        int hashCode2 = (hashCode + (message2 != null ? message2.hashCode() : 0)) * 31;
        String str2 = this.code;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "Status(result=" + this.result + ", message=" + this.message + ", code=" + this.code + ")";
    }

    public Status(String str, Message message2, String str2) {
        this.result = str;
        this.message = message2;
        this.code = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Status(String str, Message message2, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : message2, (i2 & 4) != 0 ? null : str2);
    }

    public final Object clone() {
        return super.clone();
    }

    public final String getCode() {
        return this.code;
    }

    public final Message getMessage() {
        return this.message;
    }

    public final String getResult() {
        return this.result;
    }

    public final void setCode(String str) {
        this.code = str;
    }

    public final void setMessage(Message message2) {
        this.message = message2;
    }

    public final void setResult(String str) {
        this.result = str;
    }
}
