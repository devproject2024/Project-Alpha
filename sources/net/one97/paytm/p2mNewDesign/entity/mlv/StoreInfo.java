package net.one97.paytm.p2mNewDesign.entity.mlv;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public final class StoreInfo extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "kybId")
    private String kybId;
    @b(a = "shopId")
    private String shopId;

    public StoreInfo() {
        this((String) null, (String) null, 3, (g) null);
    }

    public static /* synthetic */ StoreInfo copy$default(StoreInfo storeInfo, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = storeInfo.kybId;
        }
        if ((i2 & 2) != 0) {
            str2 = storeInfo.shopId;
        }
        return storeInfo.copy(str, str2);
    }

    public final String component1() {
        return this.kybId;
    }

    public final String component2() {
        return this.shopId;
    }

    public final StoreInfo copy(String str, String str2) {
        return new StoreInfo(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StoreInfo)) {
            return false;
        }
        StoreInfo storeInfo = (StoreInfo) obj;
        return k.a((Object) this.kybId, (Object) storeInfo.kybId) && k.a((Object) this.shopId, (Object) storeInfo.shopId);
    }

    public final int hashCode() {
        String str = this.kybId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.shopId;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "StoreInfo(kybId=" + this.kybId + ", shopId=" + this.shopId + ")";
    }

    public StoreInfo(String str, String str2) {
        this.kybId = str;
        this.shopId = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StoreInfo(String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2);
    }

    public final Object clone() {
        return super.clone();
    }

    public final String getKybId() {
        return this.kybId;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final void setKybId(String str) {
        this.kybId = str;
    }

    public final void setShopId(String str) {
        this.shopId = str;
    }
}
