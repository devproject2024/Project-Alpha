package net.one97.paytm.p2mNewDesign.entity.mlv;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public final class PromoDetails extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "seller_funded_promo")
    private Integer sellerFundedPromo;

    public PromoDetails() {
        this((Integer) null, 1, (g) null);
    }

    public static /* synthetic */ PromoDetails copy$default(PromoDetails promoDetails, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = promoDetails.sellerFundedPromo;
        }
        return promoDetails.copy(num);
    }

    public final Integer component1() {
        return this.sellerFundedPromo;
    }

    public final PromoDetails copy(Integer num) {
        return new PromoDetails(num);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof PromoDetails) && k.a((Object) this.sellerFundedPromo, (Object) ((PromoDetails) obj).sellerFundedPromo);
        }
        return true;
    }

    public final int hashCode() {
        Integer num = this.sellerFundedPromo;
        if (num != null) {
            return num.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "PromoDetails(sellerFundedPromo=" + this.sellerFundedPromo + ")";
    }

    public PromoDetails(Integer num) {
        this.sellerFundedPromo = num;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PromoDetails(Integer num, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : num);
    }

    public final Object clone() {
        return super.clone();
    }

    public final Integer getSellerFundedPromo() {
        return this.sellerFundedPromo;
    }

    public final void setSellerFundedPromo(Integer num) {
        this.sellerFundedPromo = num;
    }
}
