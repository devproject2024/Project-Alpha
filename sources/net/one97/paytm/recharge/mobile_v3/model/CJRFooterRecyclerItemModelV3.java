package net.one97.paytm.recharge.mobile_v3.model;

import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.recharge.mobile_v3.c.b;

public final class CJRFooterRecyclerItemModelV3 extends IJRPaytmDataModel {
    private String deeplink;
    private Integer iconResourceId;
    private String title;
    private b.a type;

    public static /* synthetic */ CJRFooterRecyclerItemModelV3 copy$default(CJRFooterRecyclerItemModelV3 cJRFooterRecyclerItemModelV3, String str, Integer num, String str2, b.a aVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cJRFooterRecyclerItemModelV3.title;
        }
        if ((i2 & 2) != 0) {
            num = cJRFooterRecyclerItemModelV3.iconResourceId;
        }
        if ((i2 & 4) != 0) {
            str2 = cJRFooterRecyclerItemModelV3.deeplink;
        }
        if ((i2 & 8) != 0) {
            aVar = cJRFooterRecyclerItemModelV3.type;
        }
        return cJRFooterRecyclerItemModelV3.copy(str, num, str2, aVar);
    }

    public final String component1() {
        return this.title;
    }

    public final Integer component2() {
        return this.iconResourceId;
    }

    public final String component3() {
        return this.deeplink;
    }

    public final b.a component4() {
        return this.type;
    }

    public final CJRFooterRecyclerItemModelV3 copy(String str, Integer num, String str2, b.a aVar) {
        k.c(aVar, "type");
        return new CJRFooterRecyclerItemModelV3(str, num, str2, aVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRFooterRecyclerItemModelV3)) {
            return false;
        }
        CJRFooterRecyclerItemModelV3 cJRFooterRecyclerItemModelV3 = (CJRFooterRecyclerItemModelV3) obj;
        return k.a((Object) this.title, (Object) cJRFooterRecyclerItemModelV3.title) && k.a((Object) this.iconResourceId, (Object) cJRFooterRecyclerItemModelV3.iconResourceId) && k.a((Object) this.deeplink, (Object) cJRFooterRecyclerItemModelV3.deeplink) && k.a((Object) this.type, (Object) cJRFooterRecyclerItemModelV3.type);
    }

    public final int hashCode() {
        String str = this.title;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.iconResourceId;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        String str2 = this.deeplink;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        b.a aVar = this.type;
        if (aVar != null) {
            i2 = aVar.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "CJRFooterRecyclerItemModelV3(title=" + this.title + ", iconResourceId=" + this.iconResourceId + ", deeplink=" + this.deeplink + ", type=" + this.type + ")";
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final Integer getIconResourceId() {
        return this.iconResourceId;
    }

    public final void setIconResourceId(Integer num) {
        this.iconResourceId = num;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRFooterRecyclerItemModelV3(String str, Integer num, String str2, b.a aVar, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : num, (i2 & 4) != 0 ? null : str2, aVar);
    }

    public final String getDeeplink() {
        return this.deeplink;
    }

    public final void setDeeplink(String str) {
        this.deeplink = str;
    }

    public final b.a getType() {
        return this.type;
    }

    public final void setType(b.a aVar) {
        k.c(aVar, "<set-?>");
        this.type = aVar;
    }

    public CJRFooterRecyclerItemModelV3(String str, Integer num, String str2, b.a aVar) {
        k.c(aVar, "type");
        this.title = str;
        this.iconResourceId = num;
        this.deeplink = str2;
        this.type = aVar;
    }
}
