package net.one97.paytm.common.entity.insurance;

import java.util.List;
import kotlin.g.b.k;

public final class InsuranceCartObj {
    private List<CartItem> cart_items;

    public static /* synthetic */ InsuranceCartObj copy$default(InsuranceCartObj insuranceCartObj, List<CartItem> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = insuranceCartObj.cart_items;
        }
        return insuranceCartObj.copy(list);
    }

    public final List<CartItem> component1() {
        return this.cart_items;
    }

    public final InsuranceCartObj copy(List<CartItem> list) {
        return new InsuranceCartObj(list);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof InsuranceCartObj) && k.a((Object) this.cart_items, (Object) ((InsuranceCartObj) obj).cart_items);
        }
        return true;
    }

    public final int hashCode() {
        List<CartItem> list = this.cart_items;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "InsuranceCartObj(cart_items=" + this.cart_items + ")";
    }

    public InsuranceCartObj(List<CartItem> list) {
        this.cart_items = list;
    }

    public final List<CartItem> getCart_items() {
        return this.cart_items;
    }

    public final void setCart_items(List<CartItem> list) {
        this.cart_items = list;
    }
}
