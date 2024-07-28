package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBrandStoreFrontEndFilters implements IJRDataModel {
    @b(a = "filter_param")
    private String mFilterParam;
    @b(a = "title")
    private String mTitle;
    @b(a = "type")
    private String mType;
    @b(a = "values")
    private CJRBrandStoreCategoryValues mValues;

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public CJRBrandStoreCategoryValues getValues() {
        return this.mValues;
    }

    public void setValues(CJRBrandStoreCategoryValues cJRBrandStoreCategoryValues) {
        this.mValues = cJRBrandStoreCategoryValues;
    }

    public String getFilterParam() {
        return this.mFilterParam;
    }

    public void setFilterParam(String str) {
        this.mFilterParam = str;
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String str) {
        this.mType = str;
    }
}
