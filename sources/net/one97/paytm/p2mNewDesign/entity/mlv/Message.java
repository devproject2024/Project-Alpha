package net.one97.paytm.p2mNewDesign.entity.mlv;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public final class Message extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "message")
    private String message;
    @b(a = "title")
    private String title;

    public Message() {
        this((String) null, (String) null, 3, (g) null);
    }

    public static /* synthetic */ Message copy$default(Message message2, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = message2.title;
        }
        if ((i2 & 2) != 0) {
            str2 = message2.message;
        }
        return message2.copy(str, str2);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.message;
    }

    public final Message copy(String str, String str2) {
        return new Message(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Message)) {
            return false;
        }
        Message message2 = (Message) obj;
        return k.a((Object) this.title, (Object) message2.title) && k.a((Object) this.message, (Object) message2.message);
    }

    public final int hashCode() {
        String str = this.title;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.message;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "Message(title=" + this.title + ", message=" + this.message + ")";
    }

    public Message(String str, String str2) {
        this.title = str;
        this.message = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Message(String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2);
    }

    public final Object clone() {
        return super.clone();
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final void setTitle(String str) {
        this.title = str;
    }
}
