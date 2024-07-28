package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;

public class CJRBrandStoreCategoriesResponse extends CJRHomePageItem {
    @b(a = "frontend_filters")
    private ArrayList<CJRBrandStoreFrontEndFilters> mFrontEndFilters;
    @b(a = "result_type")
    private String mResultType;

    public String getResultType() {
        return this.mResultType;
    }

    public void setResultType(String str) {
        this.mResultType = str;
    }

    public ArrayList<CJRBrandStoreFrontEndFilters> getFrontEndFilters() {
        return this.mFrontEndFilters;
    }

    public void setFrontEndFilters(ArrayList<CJRBrandStoreFrontEndFilters> arrayList) {
        this.mFrontEndFilters = arrayList;
    }
}
