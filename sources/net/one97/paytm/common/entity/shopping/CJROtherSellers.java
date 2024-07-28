package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJROtherSellers implements IJRDataModel {
    private static final long serialVersionUID = 1;
    private boolean isAuthrised;
    private boolean isBrandAuthorised;
    @b(a = "actual_price")
    private double mACtualPrice;
    @b(a = "address")
    private String mAddress;
    @b(a = "discount")
    private String mDiscountPrice;
    @b(a = "id")
    private String mId;
    private String mImageAuthUrl;
    @b(a = "applied")
    private boolean mIsApplied;
    @b(a = "exist")
    private boolean mIsExist;
    @b(a = "pick_at_store")
    private boolean mIsPickAtStore;
    @b(a = "name")
    private String mName;
    @b(a = "offer_price")
    private double mOfferPrice;
    @b(a = "offer_text")
    private String mOfferText;
    @b(a = "product_id")
    private String mProductId;
    private CJRSellerRatings mRatings;
    private boolean mSelected = false;
    @b(a = "totalScore")
    private float mTotalScore;
    @b(a = "url")
    private String mUrl;

    public String getOfferText() {
        return this.mOfferText;
    }

    public String getName() {
        return this.mName;
    }

    public double getOfferPrice() {
        return this.mOfferPrice;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public boolean isExist() {
        return this.mIsExist;
    }

    public boolean ssApplied() {
        return this.mIsApplied;
    }

    public String getmId() {
        return this.mId;
    }

    public boolean isAuthrised() {
        return this.isAuthrised;
    }

    public void setIsAuthrised(boolean z) {
        this.isAuthrised = z;
    }

    public CJRSellerRatings getRatings() {
        return this.mRatings;
    }

    public void setRatings(CJRSellerRatings cJRSellerRatings) {
        this.mRatings = cJRSellerRatings;
    }

    public String getmImageAuthUrl() {
        return this.mImageAuthUrl;
    }

    public void setmImageAuthUrl(String str) {
        this.mImageAuthUrl = str;
    }

    public String getmProductId() {
        return this.mProductId;
    }

    public void setmProductId(String str) {
        this.mProductId = str;
    }

    public float getTotalScore() {
        return this.mTotalScore;
    }

    public void setTotalScore(float f2) {
        this.mTotalScore = f2;
    }

    public boolean isSelected() {
        return this.mSelected;
    }

    public String getmOfferText() {
        return this.mOfferText;
    }

    public String getmName() {
        return this.mName;
    }

    public double getmOfferPrice() {
        return this.mOfferPrice;
    }

    public float getmTotalScore() {
        return this.mTotalScore;
    }

    public String getmAddress() {
        return this.mAddress;
    }

    public boolean ismIsPickAtStore() {
        return this.mIsPickAtStore;
    }

    public void setSelected(boolean z) {
        this.mSelected = z;
    }

    public double getmACtualPrice() {
        return this.mACtualPrice;
    }

    public void setmACtualPrice(double d2) {
        this.mACtualPrice = d2;
    }

    public String getmDiscountPrice() {
        return this.mDiscountPrice;
    }

    public void setmDiscountPrice(String str) {
        this.mDiscountPrice = str;
    }

    public boolean isBrandAuthorised() {
        return this.isBrandAuthorised;
    }

    public void setBrandAuthorised(boolean z) {
        this.isBrandAuthorised = z;
    }
}
