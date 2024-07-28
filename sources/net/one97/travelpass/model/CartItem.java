package net.one97.travelpass.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytmmall.clpartifact.utils.CLPConstants;
import kotlin.g.b.k;

public final class CartItem extends IJRPaytmDataModel {
    @b(a = "aggregate_conv_fee")
    private float aggregate_conv_fee;
    @b(a = "aggregate_price")
    private float aggregate_price;
    @b(a = "conv_fee")
    private float conv_fee;
    @b(a = "discount")
    private float discount;
    @b(a = "item_id")
    public String item_id;
    @b(a = "meta_data")
    public MetaData meta_data;
    @b(a = "mrp")
    private float mrp;
    @b(a = "parent_id")
    public String parent_id;
    @b(a = "price")
    private float price;
    @b(a = "product_id")
    public String product_id;
    @b(a = "quantity")
    public Integer quantity;
    @b(a = "selling_price")
    private float selling_price;
    @b(a = "shipping_amount")
    private float shipping_amount;
    @b(a = "shipping_charges")
    private float shipping_charges;
    @b(a = "shipping_discount")
    private float shipping_discount;
    @b(a = "total_price")
    private float total_price;
    @b(a = "vertical_id")
    private int vertical_id;
    @b(a = "vertical_label")
    public String vertical_label;

    public final String getItem_id() {
        String str = this.item_id;
        if (str == null) {
            k.a("item_id");
        }
        return str;
    }

    public final void setItem_id(String str) {
        k.c(str, "<set-?>");
        this.item_id = str;
    }

    public final String getProduct_id() {
        String str = this.product_id;
        if (str == null) {
            k.a(CLPConstants.PRODUCT_ID);
        }
        return str;
    }

    public final void setProduct_id(String str) {
        k.c(str, "<set-?>");
        this.product_id = str;
    }

    public final Integer getQuantity() {
        Integer num = this.quantity;
        if (num == null) {
            k.a("quantity");
        }
        return num;
    }

    public final void setQuantity(Integer num) {
        k.c(num, "<set-?>");
        this.quantity = num;
    }

    public final MetaData getMeta_data() {
        MetaData metaData = this.meta_data;
        if (metaData == null) {
            k.a("meta_data");
        }
        return metaData;
    }

    public final void setMeta_data(MetaData metaData) {
        k.c(metaData, "<set-?>");
        this.meta_data = metaData;
    }

    public final float getPrice() {
        return this.price;
    }

    public final void setPrice(float f2) {
        this.price = f2;
    }

    public final float getConv_fee() {
        return this.conv_fee;
    }

    public final void setConv_fee(float f2) {
        this.conv_fee = f2;
    }

    public final float getTotal_price() {
        return this.total_price;
    }

    public final void setTotal_price(float f2) {
        this.total_price = f2;
    }

    public final float getSelling_price() {
        return this.selling_price;
    }

    public final void setSelling_price(float f2) {
        this.selling_price = f2;
    }

    public final float getDiscount() {
        return this.discount;
    }

    public final void setDiscount(float f2) {
        this.discount = f2;
    }

    public final float getShipping_charges() {
        return this.shipping_charges;
    }

    public final void setShipping_charges(float f2) {
        this.shipping_charges = f2;
    }

    public final float getShipping_amount() {
        return this.shipping_amount;
    }

    public final void setShipping_amount(float f2) {
        this.shipping_amount = f2;
    }

    public final float getShipping_discount() {
        return this.shipping_discount;
    }

    public final void setShipping_discount(float f2) {
        this.shipping_discount = f2;
    }

    public final float getAggregate_price() {
        return this.aggregate_price;
    }

    public final void setAggregate_price(float f2) {
        this.aggregate_price = f2;
    }

    public final float getAggregate_conv_fee() {
        return this.aggregate_conv_fee;
    }

    public final void setAggregate_conv_fee(float f2) {
        this.aggregate_conv_fee = f2;
    }

    public final String getParent_id() {
        String str = this.parent_id;
        if (str == null) {
            k.a(CLPConstants.PARENT_ID);
        }
        return str;
    }

    public final void setParent_id(String str) {
        k.c(str, "<set-?>");
        this.parent_id = str;
    }

    public final int getVertical_id() {
        return this.vertical_id;
    }

    public final void setVertical_id(int i2) {
        this.vertical_id = i2;
    }

    public final String getVertical_label() {
        String str = this.vertical_label;
        if (str == null) {
            k.a("vertical_label");
        }
        return str;
    }

    public final void setVertical_label(String str) {
        k.c(str, "<set-?>");
        this.vertical_label = str;
    }

    public final float getMrp() {
        return this.mrp;
    }

    public final void setMrp(float f2) {
        this.mrp = f2;
    }

    public static final class MetaData extends IJRPaytmDataModel {
        @b(a = "contact_email")
        public String contact_email;
        @b(a = "product_id")
        public String product_id;
        @b(a = "user_id")
        public String user_id;

        public final String getProduct_id() {
            String str = this.product_id;
            if (str == null) {
                k.a(CLPConstants.PRODUCT_ID);
            }
            return str;
        }

        public final void setProduct_id(String str) {
            k.c(str, "<set-?>");
            this.product_id = str;
        }

        public final String getContact_email() {
            String str = this.contact_email;
            if (str == null) {
                k.a("contact_email");
            }
            return str;
        }

        public final void setContact_email(String str) {
            k.c(str, "<set-?>");
            this.contact_email = str;
        }

        public final String getUser_id() {
            String str = this.user_id;
            if (str == null) {
                k.a("user_id");
            }
            return str;
        }

        public final void setUser_id(String str) {
            k.c(str, "<set-?>");
            this.user_id = str;
        }
    }
}
