package net.one97.paytm.p2mNewDesign.entity.mlv.myorders;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public final class InfoObj extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "c_sid")
    private String cSid;

    public InfoObj() {
        this((String) null, 1, (g) null);
    }

    public static /* synthetic */ InfoObj copy$default(InfoObj infoObj, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = infoObj.cSid;
        }
        return infoObj.copy(str);
    }

    public final String component1() {
        return this.cSid;
    }

    public final InfoObj copy(String str) {
        return new InfoObj(str);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof InfoObj) && k.a((Object) this.cSid, (Object) ((InfoObj) obj).cSid);
        }
        return true;
    }

    public final int hashCode() {
        String str = this.cSid;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "InfoObj(cSid=" + this.cSid + ")";
    }

    public InfoObj(String str) {
        this.cSid = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InfoObj(String str, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str);
    }

    public final Object clone() {
        return super.clone();
    }

    public final String getCSid() {
        return this.cSid;
    }

    public final void setCSid(String str) {
        this.cSid = str;
    }
}
