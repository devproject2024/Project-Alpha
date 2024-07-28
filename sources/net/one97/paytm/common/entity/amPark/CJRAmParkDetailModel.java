package net.one97.paytm.common.entity.amPark;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRAmParkDetailModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "address")
    private String mAddress;
    @b(a = "categories")
    private ArrayList<CJRCategoriesDetailModel> mCategories = new ArrayList<>();
    @b(a = "city")
    private String mCity;
    @b(a = "custom_info")
    private CJRAmParkCustomInfo mCustomInfo;
    @b(a = "id")
    private String mId;
    @b(a = "image")
    private String mImage;
    @b(a = "image_app")
    private String mImageApp;
    @b(a = "name")
    private String mName;
    @b(a = "open_from")
    private String mOpenFrom;
    @b(a = "open_till")
    private String mOpenTill;
    @b(a = "paytm_id")
    private String mPaytmId;
    @b(a = "price")
    private String mPrice;
    @b(a = "priority")
    private String mPriority;
    @b(a = "provider_id")
    private String mProviderId;
    @b(a = "provider_priority")
    private String mProviderPriority;
    @b(a = "resource_id")
    private String mResourceId;
    @b(a = "status")
    private String mStatus;
    @b(a = "tags")
    private String mtags;

    public String getmId() {
        return this.mId;
    }

    public void setmId(String str) {
        this.mId = str;
    }

    public String getProviderId() {
        return this.mProviderId;
    }

    public void setmProviderId(String str) {
        this.mProviderId = str;
    }

    public String getmPaytmId() {
        return this.mPaytmId;
    }

    public void setmPaytmId(String str) {
        this.mPaytmId = str;
    }

    public String getmResourceId() {
        return this.mResourceId;
    }

    public void setmResourceId(String str) {
        this.mResourceId = str;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public String getmCity() {
        return this.mCity;
    }

    public void setmCity(String str) {
        this.mCity = str;
    }

    public String getmOpenFrom() {
        return this.mOpenFrom;
    }

    public void setmOpenFrom(String str) {
        this.mOpenFrom = str;
    }

    public String getmOpenTill() {
        return this.mOpenTill;
    }

    public void setmOpenTill(String str) {
        this.mOpenTill = str;
    }

    public String getPrice() {
        return this.mPrice;
    }

    public void setmPrice(String str) {
        this.mPrice = str;
    }

    public String gettags() {
        return this.mtags;
    }

    public void settags(String str) {
        this.mtags = str;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public void setAddress(String str) {
        this.mAddress = str;
    }

    public String getImageURL() {
        return this.mImage;
    }

    public void setmImage(String str) {
        this.mImage = str;
    }

    public String getmImageApp() {
        return this.mImageApp;
    }

    public void setmImageApp(String str) {
        this.mImageApp = str;
    }

    public CJRAmParkCustomInfo getmCustomInfo() {
        return this.mCustomInfo;
    }

    public void setmCustomInfo(CJRAmParkCustomInfo cJRAmParkCustomInfo) {
        this.mCustomInfo = cJRAmParkCustomInfo;
    }

    public String getmPriority() {
        return this.mPriority;
    }

    public void setmPriority(String str) {
        this.mPriority = str;
    }

    public String getmStatus() {
        return this.mStatus;
    }

    public void setmStatus(String str) {
        this.mStatus = str;
    }

    public ArrayList<CJRCategoriesDetailModel> getCategories() {
        return this.mCategories;
    }

    public void setmCategories(ArrayList<CJRCategoriesDetailModel> arrayList) {
        this.mCategories = arrayList;
    }

    public String getmProviderPriority() {
        return this.mProviderPriority;
    }

    public void setmProviderPriority(String str) {
        this.mProviderPriority = str;
    }
}
