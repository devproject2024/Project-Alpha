package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import java.util.HashMap;
import net.one97.paytm.common.entity.IJRDataModel;

public class WishListProduct implements IJRDataModel {
    @b(a = "attributes_dim")
    private HashMap<String, String> attributeNames = new HashMap<>(0);
    @b(a = "attributes_dim_values")
    private HashMap<String, String> attributeSeletedValues = new HashMap<>(0);
    @b(a = "brand")
    private String brand;
    @b(a = "discount")
    private String discount;
    @b(a = "image_url")
    private String imageUrl;
    @b(a = "is_in_stock")
    public boolean isInStock;
    @b(a = "item_id")
    private String mItemId;
    @b(a = "name")
    private String mName;
    @b(a = "parent_id")
    private String mParentID;
    @b(a = "mrp")
    private String mrp;
    @b(a = "offer_url")
    private String offerUrl;
    @b(a = "price")
    private String price;
    @b(a = "product_id")
    private String productId;
    @b(a = "product_type")
    private int productType;
    @b(a = "shareurl")
    private String shareUrl;
    @b(a = "url")
    private String url;

    public String getmItemId() {
        return this.mItemId;
    }

    public String getParentID() {
        return this.mParentID;
    }

    public String getName() {
        return this.mName;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getProductId() {
        return this.productId;
    }

    public String getPrice() {
        return this.price;
    }

    public String getMrp() {
        return this.mrp;
    }

    public String getDiscount() {
        return this.discount;
    }

    public HashMap<String, String> getAttributeNames() {
        return this.attributeNames;
    }

    public int getProductType() {
        return this.productType;
    }

    public HashMap<String, String> getAttributeSeletedValues() {
        return this.attributeSeletedValues;
    }

    public String getUrl() {
        return this.url;
    }

    public String getShareUrl() {
        return this.shareUrl;
    }

    public String getOfferUrl() {
        return this.offerUrl;
    }

    public boolean isInStock() {
        return this.isInStock;
    }
}
