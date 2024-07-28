package net.one97.paytm.common.entity.amPark;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRCategoriesDetailModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "category")
    private String mCategory;
    @b(a = "color")
    private String mColor;
    @b(a = "id")
    private String mId;

    public String getId() {
        return this.mId;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getColor() {
        return this.mColor;
    }

    public void setColor(String str) {
        this.mColor = str;
    }
}
