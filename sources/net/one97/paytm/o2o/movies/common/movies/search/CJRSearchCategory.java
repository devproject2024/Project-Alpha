package net.one97.paytm.o2o.movies.common.movies.search;

import net.one97.paytm.common.entity.IJRDataModel;

public class CJRSearchCategory implements IJRDataModel {
    private String mCategoryTitle;

    public String getCategoryTitle() {
        return this.mCategoryTitle;
    }

    public void setmCategoryTitle(String str) {
        this.mCategoryTitle = str;
    }
}
