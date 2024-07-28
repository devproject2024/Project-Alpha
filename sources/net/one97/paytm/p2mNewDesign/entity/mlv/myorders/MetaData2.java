package net.one97.paytm.p2mNewDesign.entity.mlv.myorders;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public final class MetaData2 extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "order_created_by")
    private String orderCreatedBy;
    @b(a = "promo_details")
    private PromoDetails promoDetails;
    @b(a = "random_alphanum")
    private String randomAlphanum;

    public MetaData2() {
        this((PromoDetails) null, (String) null, (String) null, 7, (g) null);
    }

    public static /* synthetic */ MetaData2 copy$default(MetaData2 metaData2, PromoDetails promoDetails2, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            promoDetails2 = metaData2.promoDetails;
        }
        if ((i2 & 2) != 0) {
            str = metaData2.randomAlphanum;
        }
        if ((i2 & 4) != 0) {
            str2 = metaData2.orderCreatedBy;
        }
        return metaData2.copy(promoDetails2, str, str2);
    }

    public final PromoDetails component1() {
        return this.promoDetails;
    }

    public final String component2() {
        return this.randomAlphanum;
    }

    public final String component3() {
        return this.orderCreatedBy;
    }

    public final MetaData2 copy(PromoDetails promoDetails2, String str, String str2) {
        return new MetaData2(promoDetails2, str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MetaData2)) {
            return false;
        }
        MetaData2 metaData2 = (MetaData2) obj;
        return k.a((Object) this.promoDetails, (Object) metaData2.promoDetails) && k.a((Object) this.randomAlphanum, (Object) metaData2.randomAlphanum) && k.a((Object) this.orderCreatedBy, (Object) metaData2.orderCreatedBy);
    }

    public final int hashCode() {
        PromoDetails promoDetails2 = this.promoDetails;
        int i2 = 0;
        int hashCode = (promoDetails2 != null ? promoDetails2.hashCode() : 0) * 31;
        String str = this.randomAlphanum;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.orderCreatedBy;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "MetaData2(promoDetails=" + this.promoDetails + ", randomAlphanum=" + this.randomAlphanum + ", orderCreatedBy=" + this.orderCreatedBy + ")";
    }

    public final Object clone() {
        return super.clone();
    }

    public final PromoDetails getPromoDetails() {
        return this.promoDetails;
    }

    public final void setPromoDetails(PromoDetails promoDetails2) {
        this.promoDetails = promoDetails2;
    }

    public final String getRandomAlphanum() {
        return this.randomAlphanum;
    }

    public final void setRandomAlphanum(String str) {
        this.randomAlphanum = str;
    }

    public MetaData2(PromoDetails promoDetails2, String str, String str2) {
        this.promoDetails = promoDetails2;
        this.randomAlphanum = str;
        this.orderCreatedBy = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MetaData2(PromoDetails promoDetails2, String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : promoDetails2, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2);
    }

    public final String getOrderCreatedBy() {
        return this.orderCreatedBy;
    }

    public final void setOrderCreatedBy(String str) {
        this.orderCreatedBy = str;
    }
}
