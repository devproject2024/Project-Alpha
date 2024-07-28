package net.one97.paytm.common.entity.insurance;

import kotlin.g.b.k;

public final class CartItem {
    private Configuration configuration;
    private Object meta_data;
    private Integer product_id;
    private Integer quantity;

    public static /* synthetic */ CartItem copy$default(CartItem cartItem, Integer num, Integer num2, Configuration configuration2, Object obj, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            num = cartItem.product_id;
        }
        if ((i2 & 2) != 0) {
            num2 = cartItem.quantity;
        }
        if ((i2 & 4) != 0) {
            configuration2 = cartItem.configuration;
        }
        if ((i2 & 8) != 0) {
            obj = cartItem.meta_data;
        }
        return cartItem.copy(num, num2, configuration2, obj);
    }

    public final Integer component1() {
        return this.product_id;
    }

    public final Integer component2() {
        return this.quantity;
    }

    public final Configuration component3() {
        return this.configuration;
    }

    public final Object component4() {
        return this.meta_data;
    }

    public final CartItem copy(Integer num, Integer num2, Configuration configuration2, Object obj) {
        return new CartItem(num, num2, configuration2, obj);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CartItem)) {
            return false;
        }
        CartItem cartItem = (CartItem) obj;
        return k.a((Object) this.product_id, (Object) cartItem.product_id) && k.a((Object) this.quantity, (Object) cartItem.quantity) && k.a((Object) this.configuration, (Object) cartItem.configuration) && k.a(this.meta_data, cartItem.meta_data);
    }

    public final int hashCode() {
        Integer num = this.product_id;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        Integer num2 = this.quantity;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 31;
        Configuration configuration2 = this.configuration;
        int hashCode3 = (hashCode2 + (configuration2 != null ? configuration2.hashCode() : 0)) * 31;
        Object obj = this.meta_data;
        if (obj != null) {
            i2 = obj.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "CartItem(product_id=" + this.product_id + ", quantity=" + this.quantity + ", configuration=" + this.configuration + ", meta_data=" + this.meta_data + ")";
    }

    public CartItem(Integer num, Integer num2, Configuration configuration2, Object obj) {
        this.product_id = num;
        this.quantity = num2;
        this.configuration = configuration2;
        this.meta_data = obj;
    }

    public final Integer getProduct_id() {
        return this.product_id;
    }

    public final void setProduct_id(Integer num) {
        this.product_id = num;
    }

    public final Integer getQuantity() {
        return this.quantity;
    }

    public final void setQuantity(Integer num) {
        this.quantity = num;
    }

    public final Configuration getConfiguration() {
        return this.configuration;
    }

    public final void setConfiguration(Configuration configuration2) {
        this.configuration = configuration2;
    }

    public final Object getMeta_data() {
        return this.meta_data;
    }

    public final void setMeta_data(Object obj) {
        this.meta_data = obj;
    }
}
