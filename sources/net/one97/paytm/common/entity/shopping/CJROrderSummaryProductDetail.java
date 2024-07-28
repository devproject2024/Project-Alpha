package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.recharge.CJRAttributes;

public class CJROrderSummaryProductDetail implements IJRDataModel {
    private static final long serialVersionUID = 1;
    public double discountedPrice;
    @b(a = "attributes")
    private CJRAttributes mAttributes;
    @b(a = "brand")
    private String mBrandName;
    @b(a = "category_id")
    private long mCategoryId;
    @b(a = "categoryMap")
    private ArrayList<CJRCategoryMap> mCategoryMap;
    @b(a = "category_path")
    private String mCategoryPath;
    @b(a = "ga_key")
    private String mGAkey;
    @b(a = "id")
    private long mId;
    @b(a = "image")
    private String mImageUrl;
    @b(a = "merchant")
    private CJROrderSummaryMerchant mMercahnt;
    @b(a = "merchant_name")
    private String mMerchantName;
    @b(a = "name")
    private String mName;
    @b(a = "need_shipping")
    private String mNeedShipping;
    @b(a = "parent_id")
    public String mParentId;
    @b(a = "price")
    private double mPrice;
    @b(a = "product_type")
    private String mProductType;
    @b(a = "promo_text")
    private String mPromoText;
    private String mRedeemText;
    @b(a = "thumbnail")
    private String mThumnail;
    @b(a = "thumbnail_base64")
    private String mThumnailBase64;
    @b(a = "url")
    private String mURL;
    @b(a = "vertical_label")
    private String mVertical;
    @b(a = "vertical_id")
    private long mVerticalId;
    @b(a = "purity")
    private String purity;
    @b(a = "return_policy_text")
    private String returnPolicyText;

    public String getGAkey() {
        return this.mGAkey;
    }

    public String getName() {
        return this.mName;
    }

    public long getId() {
        return this.mId;
    }

    public String getMerchantName() {
        return this.mMerchantName;
    }

    public String getProductType() {
        return this.mProductType;
    }

    public String getBrandName() {
        return this.mBrandName;
    }

    public String getPromoText() {
        return this.mPromoText;
    }

    public double getPrice() {
        return this.mPrice;
    }

    public String getURL() {
        return this.mURL;
    }

    public String getThumbnail() {
        return this.mThumnail;
    }

    public void setThumbnail(String str) {
        this.mThumnail = str;
    }

    public CJROrderSummaryMerchant getMercahnt() {
        return this.mMercahnt;
    }

    public String getImageUrl() {
        return this.mImageUrl;
    }

    public String getThumnailBase64() {
        return this.mThumnailBase64;
    }

    public String getVertical() {
        return this.mVertical;
    }

    public long getVerticalId() {
        return this.mVerticalId;
    }

    public String getNeedShipping() {
        return this.mNeedShipping;
    }

    public long getCategoryId() {
        return this.mCategoryId;
    }

    public String getCategoryPath() {
        return this.mCategoryPath;
    }

    public ArrayList<CJRCategoryMap> getCategoryMap() {
        return this.mCategoryMap;
    }

    public String getCategoryMapPath() {
        StringBuilder sb = new StringBuilder();
        ArrayList<CJRCategoryMap> arrayList = this.mCategoryMap;
        if (arrayList != null && arrayList.size() > 0) {
            int size = this.mCategoryMap.size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append(this.mCategoryMap.get(i2).getName());
                if (size > 1 && i2 < size - 1) {
                    sb.append("/");
                }
            }
        }
        return sb.toString();
    }

    public double getDiscountedPrice() {
        return this.discountedPrice;
    }

    public void setDiscountedPrice(double d2) {
        this.discountedPrice = d2;
    }

    public String getParentId() {
        return this.mParentId;
    }

    public String getCategoryIdMapPath() {
        StringBuilder sb = new StringBuilder();
        ArrayList<CJRCategoryMap> arrayList = this.mCategoryMap;
        if (arrayList != null && arrayList.size() > 0) {
            int size = this.mCategoryMap.size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append(this.mCategoryMap.get(i2).getCategoryId());
                if (size > 1 && i2 < size - 1) {
                    sb.append("/");
                }
            }
        }
        return sb.toString();
    }

    public CJRCategoryMap getImmidiateCategory() {
        ArrayList<CJRCategoryMap> arrayList = this.mCategoryMap;
        if (arrayList == null || arrayList.size() - 2 < 0) {
            return null;
        }
        ArrayList<CJRCategoryMap> arrayList2 = this.mCategoryMap;
        CJRCategoryMap cJRCategoryMap = arrayList2.get(arrayList2.size() - 2);
        if (cJRCategoryMap != null) {
            return cJRCategoryMap;
        }
        return null;
    }

    public CJRAttributes getAttributes() {
        return this.mAttributes;
    }

    public void setAttributes(CJRAttributes cJRAttributes) {
        this.mAttributes = cJRAttributes;
    }

    public String getReturnPolicyText() {
        return this.returnPolicyText;
    }

    public String getRedeemText() {
        return this.mRedeemText;
    }

    public void setRedeemText(String str) {
        this.mRedeemText = str;
    }

    public String getPurity() {
        return this.purity;
    }

    public void setPurity(String str) {
        this.purity = str;
    }
}
