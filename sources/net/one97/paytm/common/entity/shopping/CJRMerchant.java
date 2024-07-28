package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.common.entity.CJRSellerStoreInfo;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMerchant implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "is_C2I_Merchant")
    private int isInternationalized;
    @b(a = "address")
    private HashMap<String, String> mMerchantAdress;
    @b(a = "merchant_id")
    private String mMerchantID;
    @b(a = "merchant_image")
    private String mMerchantImage;
    @b(a = "merchant_name")
    private String mMerchantName;
    @b(a = "merchant_rating")
    private MerchantRating mMerchantRating;
    @b(a = "paytm_verified")
    private int mPaytmVerified;
    @b(a = "stores")
    private ArrayList<CJRStores> mStoreList;
    @b(a = "sellerstore_info")
    private CJRSellerStoreInfo sellerStroreInfo;

    public String getMerchantID() {
        return this.mMerchantID;
    }

    public String getMerchantImage() {
        return this.mMerchantImage;
    }

    public String getMerchantName() {
        return this.mMerchantName;
    }

    public MerchantRating getMerchantRating() {
        return this.mMerchantRating;
    }

    public ArrayList<CJRStores> getStoreList() {
        return this.mStoreList;
    }

    public HashMap<String, String> getmMerchantAdress() {
        return this.mMerchantAdress;
    }

    public CJRSellerStoreInfo getSellerStroreInfo() {
        return this.sellerStroreInfo;
    }

    public ArrayList<CJRStores> getmStoreList() {
        return this.mStoreList;
    }

    public int getIsInternationalized() {
        return this.isInternationalized;
    }

    public void setIsInternationalized(int i2) {
        this.isInternationalized = i2;
    }

    public int getmPaytmVerified() {
        return this.mPaytmVerified;
    }

    public void setmMerchantID(String str) {
        this.mMerchantID = str;
    }

    public void setmMerchantName(String str) {
        this.mMerchantName = str;
    }

    public void setmMerchantAdress(HashMap<String, String> hashMap) {
        this.mMerchantAdress = hashMap;
    }
}
