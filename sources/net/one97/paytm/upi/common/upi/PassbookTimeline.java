package net.one97.paytm.upi.common.upi;

import com.google.gson.a.c;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.upi.common.UpiBaseDataModel;

public final class PassbookTimeline implements UpiBaseDataModel {
    @c(a = "imageurl")
    private String imageurl;
    @c(a = "message")
    private String message;

    public PassbookTimeline() {
        this((String) null, (String) null, 3, (g) null);
    }

    public static /* synthetic */ PassbookTimeline copy$default(PassbookTimeline passbookTimeline, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = passbookTimeline.imageurl;
        }
        if ((i2 & 2) != 0) {
            str2 = passbookTimeline.message;
        }
        return passbookTimeline.copy(str, str2);
    }

    public final String component1() {
        return this.imageurl;
    }

    public final String component2() {
        return this.message;
    }

    public final PassbookTimeline copy(String str, String str2) {
        return new PassbookTimeline(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PassbookTimeline)) {
            return false;
        }
        PassbookTimeline passbookTimeline = (PassbookTimeline) obj;
        return k.a((Object) this.imageurl, (Object) passbookTimeline.imageurl) && k.a((Object) this.message, (Object) passbookTimeline.message);
    }

    public final int hashCode() {
        String str = this.imageurl;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.message;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "PassbookTimeline(imageurl=" + this.imageurl + ", message=" + this.message + ")";
    }

    public PassbookTimeline(String str, String str2) {
        this.imageurl = str;
        this.message = str2;
    }

    public final String getImageurl() {
        return this.imageurl;
    }

    public final void setImageurl(String str) {
        this.imageurl = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PassbookTimeline(String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2);
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }
}
