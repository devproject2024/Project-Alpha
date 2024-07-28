package net.one97.paytm.p2mNewDesign.models;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.network.CJRWalletDataModel;

public final class MetaDetailsV2 extends CJRWalletDataModel {
    @b(a = "npciHealthCategory")
    private String npciHealthCategory;
    @b(a = "npciHealthMsg")
    private String npciHealthMsg;

    public MetaDetailsV2() {
        this((String) null, (String) null, 3, (g) null);
    }

    public static /* synthetic */ MetaDetailsV2 copy$default(MetaDetailsV2 metaDetailsV2, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = metaDetailsV2.npciHealthCategory;
        }
        if ((i2 & 2) != 0) {
            str2 = metaDetailsV2.npciHealthMsg;
        }
        return metaDetailsV2.copy(str, str2);
    }

    public final String component1() {
        return this.npciHealthCategory;
    }

    public final String component2() {
        return this.npciHealthMsg;
    }

    public final MetaDetailsV2 copy(String str, String str2) {
        return new MetaDetailsV2(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MetaDetailsV2)) {
            return false;
        }
        MetaDetailsV2 metaDetailsV2 = (MetaDetailsV2) obj;
        return k.a((Object) this.npciHealthCategory, (Object) metaDetailsV2.npciHealthCategory) && k.a((Object) this.npciHealthMsg, (Object) metaDetailsV2.npciHealthMsg);
    }

    public final int hashCode() {
        String str = this.npciHealthCategory;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.npciHealthMsg;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "MetaDetailsV2(npciHealthCategory=" + this.npciHealthCategory + ", npciHealthMsg=" + this.npciHealthMsg + ")";
    }

    public MetaDetailsV2(String str, String str2) {
        this.npciHealthCategory = str;
        this.npciHealthMsg = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MetaDetailsV2(String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2);
    }

    public final String getNpciHealthCategory() {
        return this.npciHealthCategory;
    }

    public final String getNpciHealthMsg() {
        return this.npciHealthMsg;
    }

    public final void setNpciHealthCategory(String str) {
        this.npciHealthCategory = str;
    }

    public final void setNpciHealthMsg(String str) {
        this.npciHealthMsg = str;
    }
}
