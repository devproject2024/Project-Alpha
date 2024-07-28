package net.one97.paytm.common.entity.movies.foodbeverage;

import com.google.gsonhtcfix.a.b;
import java.util.Date;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFoodBeverageItem implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "is_veg")
    private Boolean isVeg;
    private Date itemSelectionTimeStamp = null;
    @b(a = "paytm_cinema_id")
    private String mCinemaID;
    @b(a = "conv_fee")
    private String mConvinienceFee;
    @b(a = "created_at")
    private String mCreatedAt;
    @b(a = "discount")
    private String mDiscount;
    private int mFoodQauntitySelected;
    @b(a = "id")
    private String mID;
    @b(a = "item_description")
    private String mItemDescription;
    @b(a = "item_image_url")
    private String mItemImageURL;
    @b(a = "item_name")
    private String mItemName;
    @b(a = "mrp_price")
    private String mMrpPrice;
    @b(a = "pg_charges")
    private String mPGCharges;
    @b(a = "price")
    private String mPrice;
    @b(a = "product_id")
    private String mProductID;
    @b(a = "provider_id")
    private String mProviderID;
    @b(a = "provider_item_id")
    private String mProviderItemID;
    @b(a = "status")
    private String mStatus;
    @b(a = "updated_at")
    private String mupdatedAt;

    public Boolean isVeg() {
        return this.isVeg;
    }

    public int getmFoodQauntitySelected() {
        return this.mFoodQauntitySelected;
    }

    public void setmFoodQauntitySelected(int i2) {
        this.mFoodQauntitySelected = i2;
    }

    public String getmPrice() {
        return this.mPrice;
    }

    public void setmPrice(String str) {
        this.mPrice = str;
    }

    public String getmID() {
        return this.mID;
    }

    public void setmID(String str) {
        this.mID = str;
    }

    public String getmProviderID() {
        return this.mProviderID;
    }

    public void setmProviderID(String str) {
        this.mProviderID = str;
    }

    public String getmCinemaID() {
        return this.mCinemaID;
    }

    public void setmCinemaID(String str) {
        this.mCinemaID = str;
    }

    public String getmItemName() {
        return this.mItemName;
    }

    public void setmItemName(String str) {
        this.mItemName = str;
    }

    public String getmProviderItemID() {
        return this.mProviderItemID;
    }

    public void setmProviderItemID(String str) {
        this.mProviderItemID = str;
    }

    public String getmItemImageURL() {
        return this.mItemImageURL;
    }

    public void setmItemImageURL(String str) {
        this.mItemImageURL = str;
    }

    public String getmItemDescription() {
        return this.mItemDescription;
    }

    public void setmItemDescription(String str) {
        this.mItemDescription = str;
    }

    public String getmStatus() {
        return this.mStatus;
    }

    public void setmStatus(String str) {
        this.mStatus = str;
    }

    public String getmConvinienceFee() {
        return this.mConvinienceFee;
    }

    public void setmConvinienceFee(String str) {
        this.mConvinienceFee = str;
    }

    public String getmPGCharges() {
        return this.mPGCharges;
    }

    public void setmPGCharges(String str) {
        this.mPGCharges = str;
    }

    public String getmCreatedAt() {
        return this.mCreatedAt;
    }

    public void setmCreatedAt(String str) {
        this.mCreatedAt = str;
    }

    public String getMupdatedAt() {
        return this.mupdatedAt;
    }

    public void setMupdatedAt(String str) {
        this.mupdatedAt = str;
    }

    public String getmProductID() {
        return this.mProductID;
    }

    public void setmProductID(String str) {
        this.mProductID = str;
    }

    public String getmMrpPrice() {
        return this.mMrpPrice;
    }

    public String getmDiscount() {
        return this.mDiscount;
    }

    public Date getItemSelectionTimeStamp() {
        if (this.itemSelectionTimeStamp == null || this.mFoodQauntitySelected <= 0) {
            this.itemSelectionTimeStamp = new Date(0);
        }
        return this.itemSelectionTimeStamp;
    }

    public void setItemSelectionTimeStamp(Date date) {
        this.itemSelectionTimeStamp = date;
    }
}
