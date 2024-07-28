package net.one97.paytm.o2o.movies.common.movies.search;

import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMovieLanguages implements IJRDataModel {
    private static final long serialVersionUID = 1;
    private boolean mIsSelected = false;
    private String mLanguage;

    public String getLanguage() {
        return this.mLanguage;
    }

    public void setLanguage(String str) {
        this.mLanguage = str;
    }

    public boolean getIsSelected() {
        return this.mIsSelected;
    }

    public void setIsSelected(boolean z) {
        this.mIsSelected = z;
    }

    public boolean equals(Object obj) {
        return this.mLanguage.equals(((CJRMovieLanguages) obj).mLanguage);
    }
}
