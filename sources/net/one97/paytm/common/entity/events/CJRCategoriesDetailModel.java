package net.one97.paytm.common.entity.events;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRCategoriesDetailModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "category")
    private String category;
    @b(a = "category_id")
    private String category_id;
    @b(a = "color")
    private String mColor;

    public String getCategoryId() {
        return this.category_id;
    }

    public void setCategoryId(String str) {
        this.category_id = str;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public String getColor() {
        return this.mColor;
    }

    public void setColor(String str) {
        this.mColor = str;
    }
}
