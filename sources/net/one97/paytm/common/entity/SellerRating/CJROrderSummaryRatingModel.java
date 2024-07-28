package net.one97.paytm.common.entity.SellerRating;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJROrderSummaryRatingModel implements IJRDataModel {
    @b(a = "rating")
    private boolean mIsRated;
    @b(a = "item_id")
    private long mItemId;
    @b(a = "s3")
    private float mProductDeliveryRating;
    @b(a = "s1")
    private float mProductDescRating;
    @b(a = "s2")
    private float mProductPackagingRating;

    public boolean getIsRated() {
        return this.mIsRated;
    }

    public void setIsRated(boolean z) {
        this.mIsRated = z;
    }

    public long getItemId() {
        return this.mItemId;
    }

    public void setItemId(long j) {
        this.mItemId = j;
    }

    public float getProductDescRating() {
        return this.mProductDescRating;
    }

    public void setProductDescRating(float f2) {
        this.mProductDescRating = f2;
    }

    public float getProductPackagingRating() {
        return this.mProductPackagingRating;
    }

    public void setProductPackagingRating(float f2) {
        this.mProductPackagingRating = f2;
    }

    public float getProductDeliveryRating() {
        return this.mProductDeliveryRating;
    }

    public void setProductDeliveryRating(float f2) {
        this.mProductDeliveryRating = f2;
    }
}
