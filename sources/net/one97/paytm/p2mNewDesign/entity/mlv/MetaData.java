package net.one97.paytm.p2mNewDesign.entity.mlv;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public final class MetaData extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "kybid")
    private String kybid;
    @b(a = "promo_details")
    private PromoDetails promoDetails;
    @b(a = "shop_data")
    private String shopData;
    @b(a = "shopid")
    private String shopid;

    public MetaData() {
        this((String) null, (String) null, (String) null, (PromoDetails) null, 15, (g) null);
    }

    public static /* synthetic */ MetaData copy$default(MetaData metaData, String str, String str2, String str3, PromoDetails promoDetails2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = metaData.kybid;
        }
        if ((i2 & 2) != 0) {
            str2 = metaData.shopid;
        }
        if ((i2 & 4) != 0) {
            str3 = metaData.shopData;
        }
        if ((i2 & 8) != 0) {
            promoDetails2 = metaData.promoDetails;
        }
        return metaData.copy(str, str2, str3, promoDetails2);
    }

    public final String component1() {
        return this.kybid;
    }

    public final String component2() {
        return this.shopid;
    }

    public final String component3() {
        return this.shopData;
    }

    public final PromoDetails component4() {
        return this.promoDetails;
    }

    public final MetaData copy(String str, String str2, String str3, PromoDetails promoDetails2) {
        return new MetaData(str, str2, str3, promoDetails2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MetaData)) {
            return false;
        }
        MetaData metaData = (MetaData) obj;
        return k.a((Object) this.kybid, (Object) metaData.kybid) && k.a((Object) this.shopid, (Object) metaData.shopid) && k.a((Object) this.shopData, (Object) metaData.shopData) && k.a((Object) this.promoDetails, (Object) metaData.promoDetails);
    }

    public final int hashCode() {
        String str = this.kybid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.shopid;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.shopData;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        PromoDetails promoDetails2 = this.promoDetails;
        if (promoDetails2 != null) {
            i2 = promoDetails2.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "MetaData(kybid=" + this.kybid + ", shopid=" + this.shopid + ", shopData=" + this.shopData + ", promoDetails=" + this.promoDetails + ")";
    }

    public MetaData(String str, String str2, String str3, PromoDetails promoDetails2) {
        this.kybid = str;
        this.shopid = str2;
        this.shopData = str3;
        this.promoDetails = promoDetails2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MetaData(String str, String str2, String str3, PromoDetails promoDetails2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : promoDetails2);
    }

    public final Object clone() {
        return super.clone();
    }

    public final String getKybid() {
        return this.kybid;
    }

    public final PromoDetails getPromoDetails() {
        return this.promoDetails;
    }

    public final String getShopData() {
        return this.shopData;
    }

    public final String getShopid() {
        return this.shopid;
    }

    public final void setKybid(String str) {
        this.kybid = str;
    }

    public final void setPromoDetails(PromoDetails promoDetails2) {
        this.promoDetails = promoDetails2;
    }

    public final void setShopData(String str) {
        this.shopData = str;
    }

    public final void setShopid(String str) {
        this.shopid = str;
    }
}
