package net.one97.paytm.o2o.events.common.entity.events;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJREventCategoryDetail implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "category")
    private String category;
    @b(a = "category_name")
    private String categoryName;
    @b(a = "city_name")
    private String city_name;
    @b(a = "flag")
    private int flag;
    @b(a = "id")
    private String id;
    @b(a = "park_key")
    private String park_key;
    @b(a = "park_name")
    private String park_name;
    @b(a = "provider_id")
    private int provider_id;

    public static long getSerialVersionUID() {
        return 1;
    }

    public int getProvider_id() {
        return this.provider_id;
    }

    public void setProvider_id(int i2) {
        this.provider_id = i2;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public String getPark_name() {
        return this.park_name;
    }

    public void setPark_name(String str) {
        this.park_name = str;
    }

    public String getPark_key() {
        return this.park_key;
    }

    public void setPark_key(String str) {
        this.park_key = str;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public void setCategoryName(String str) {
        this.categoryName = str;
    }

    public String getCity_name() {
        return this.city_name;
    }

    public void setCity_name(String str) {
        this.city_name = str;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public int getFlag() {
        return this.flag;
    }

    public void setFlag(int i2) {
        this.flag = i2;
    }
}
