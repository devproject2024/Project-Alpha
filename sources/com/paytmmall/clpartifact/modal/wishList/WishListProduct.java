package com.paytmmall.clpartifact.modal.wishList;

import com.google.gson.a.c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class WishListProduct implements Serializable {
    @c(a = "attributes_dim")
    private HashMap<String, String> attributeNames = new HashMap<>(0);
    @c(a = "attributes_dim_values")
    private HashMap<String, String> attributeSeletedValues = new HashMap<>(0);
    @c(a = "brand")
    private String brand;
    @c(a = "discount")
    private String discount;
    @c(a = "image_url")
    private String imageUrl;
    @c(a = "is_in_stock")
    public boolean isInStock;
    @c(a = "item_id")
    private String mItemId;
    @c(a = "name")
    private String mName;
    @c(a = "parent_id")
    private String mParentID;
    @c(a = "tags")
    private ArrayList<WishListTag> mTagList = new ArrayList<>(0);
    @c(a = "mrp")
    private String mrp;
    @c(a = "offer_url")
    private String offerUrl;
    @c(a = "price")
    private String price;
    @c(a = "product_id")
    private String productId;
    @c(a = "product_type")
    private int productType;
    @c(a = "shareurl")
    private String shareUrl;
    @c(a = "url")
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

    public ArrayList<WishListTag> getmTagList() {
        return this.mTagList;
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
