package net.one97.paytm.common.entity.amPark;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRAmParkAutosuggestEventItem implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "category")
    private String category;
    @b(a = "city")
    private String city;
    @b(a = "id")
    private String parkId;
    @b(a = "name")
    private String parkName;
    @b(a = "provider_id")
    private String providerId;
    private int type = 1;

    public String getParkId() {
        return this.parkId;
    }

    public void setParkId(String str) {
        this.parkId = str;
    }

    public String getParkName() {
        return this.parkName;
    }

    public void setParkName(String str) {
        this.parkName = str;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public String getProviderId() {
        return this.providerId;
    }

    public void setProviderId(String str) {
        this.providerId = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i2) {
        this.type = i2;
    }
}
