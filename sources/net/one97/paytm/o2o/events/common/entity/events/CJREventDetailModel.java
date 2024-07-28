package net.one97.paytm.o2o.events.common.entity.events;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.events.CJRCategoriesDetailModel;

public class CJREventDetailModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "active_from")
    private String mActiveFrom;
    @b(a = "active_to")
    private String mActiveTo;
    @b(a = "address")
    private String mAddress;
    @b(a = "categories")
    private ArrayList<CJRCategoriesDetailModel> mCategories = new ArrayList<>();
    @b(a = "cities")
    private List<String> mCities = new ArrayList();
    @b(a = "id")
    private String mId;
    @b(a = "image")
    private String mImage;
    @b(a = "name")
    private String mName;
    @b(a = "price")
    private String mPrice;
    @b(a = "provider_id")
    private String mProviderId;
    @b(a = "provider_priority")
    private String mProviderPriority;
    @b(a = "tags")
    private String mtags;

    public String getId() {
        return this.mId;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public String getProviderId() {
        return this.mProviderId;
    }

    public void setProviderId(String str) {
        this.mProviderId = str;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public String getActiveFrom() {
        return this.mActiveFrom;
    }

    public void setActiveFrom(String str) {
        this.mActiveFrom = str;
    }

    public String getActiveTo() {
        return this.mActiveTo;
    }

    public void setActiveTo(String str) {
        this.mActiveTo = str;
    }

    public String getPrice() {
        return this.mPrice;
    }

    public void setPrice(String str) {
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

    public void setImage(String str) {
        this.mImage = str;
    }

    public ArrayList<CJRCategoriesDetailModel> getCategories() {
        return this.mCategories;
    }

    public void setCategories(ArrayList<CJRCategoriesDetailModel> arrayList) {
        this.mCategories = arrayList;
    }

    public List<String> getCities() {
        return this.mCities;
    }

    public void setCities(List<String> list) {
        this.mCities = list;
    }

    public String getProviderPriority() {
        return this.mProviderPriority;
    }

    public void setProviderPriority(String str) {
        this.mProviderPriority = str;
    }
}
