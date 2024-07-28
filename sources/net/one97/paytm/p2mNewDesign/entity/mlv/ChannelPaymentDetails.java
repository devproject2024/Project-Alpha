package net.one97.paytm.p2mNewDesign.entity.mlv;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public final class ChannelPaymentDetails extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "cart")
    private Cart cart;
    @b(a = "offerText")
    private String offerText;
    @b(a = "promoCode")
    private String promoCode;
    @b(a = "status")
    private Status status;

    public ChannelPaymentDetails() {
        this((Status) null, (String) null, (String) null, (Cart) null, 15, (g) null);
    }

    public static /* synthetic */ ChannelPaymentDetails copy$default(ChannelPaymentDetails channelPaymentDetails, Status status2, String str, String str2, Cart cart2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            status2 = channelPaymentDetails.status;
        }
        if ((i2 & 2) != 0) {
            str = channelPaymentDetails.offerText;
        }
        if ((i2 & 4) != 0) {
            str2 = channelPaymentDetails.promoCode;
        }
        if ((i2 & 8) != 0) {
            cart2 = channelPaymentDetails.cart;
        }
        return channelPaymentDetails.copy(status2, str, str2, cart2);
    }

    public final Status component1() {
        return this.status;
    }

    public final String component2() {
        return this.offerText;
    }

    public final String component3() {
        return this.promoCode;
    }

    public final Cart component4() {
        return this.cart;
    }

    public final ChannelPaymentDetails copy(Status status2, String str, String str2, Cart cart2) {
        return new ChannelPaymentDetails(status2, str, str2, cart2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChannelPaymentDetails)) {
            return false;
        }
        ChannelPaymentDetails channelPaymentDetails = (ChannelPaymentDetails) obj;
        return k.a((Object) this.status, (Object) channelPaymentDetails.status) && k.a((Object) this.offerText, (Object) channelPaymentDetails.offerText) && k.a((Object) this.promoCode, (Object) channelPaymentDetails.promoCode) && k.a((Object) this.cart, (Object) channelPaymentDetails.cart);
    }

    public final int hashCode() {
        Status status2 = this.status;
        int i2 = 0;
        int hashCode = (status2 != null ? status2.hashCode() : 0) * 31;
        String str = this.offerText;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.promoCode;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Cart cart2 = this.cart;
        if (cart2 != null) {
            i2 = cart2.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "ChannelPaymentDetails(status=" + this.status + ", offerText=" + this.offerText + ", promoCode=" + this.promoCode + ", cart=" + this.cart + ")";
    }

    public ChannelPaymentDetails(Status status2, String str, String str2, Cart cart2) {
        this.status = status2;
        this.offerText = str;
        this.promoCode = str2;
        this.cart = cart2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChannelPaymentDetails(Status status2, String str, String str2, Cart cart2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : status2, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : cart2);
    }

    public final Object clone() {
        return super.clone();
    }

    public final Cart getCart() {
        return this.cart;
    }

    public final String getOfferText() {
        return this.offerText;
    }

    public final String getPromoCode() {
        return this.promoCode;
    }

    public final Status getStatus() {
        return this.status;
    }

    public final void setCart(Cart cart2) {
        this.cart = cart2;
    }

    public final void setOfferText(String str) {
        this.offerText = str;
    }

    public final void setPromoCode(String str) {
        this.promoCode = str;
    }

    public final void setStatus(Status status2) {
        this.status = status2;
    }
}
