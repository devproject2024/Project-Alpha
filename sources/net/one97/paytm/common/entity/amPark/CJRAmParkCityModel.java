package net.one97.paytm.common.entity.amPark;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRAmParkCityModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "isTopCity")
    private boolean mIsTopCity;
    @b(a = "label")
    private String mLabel;
    @b(a = "value")
    private String mValue;

    public String getLabel() {
        return this.mLabel;
    }

    public void setlabel(String str) {
        this.mLabel = str;
    }

    public String getValue() {
        return this.mValue;
    }

    public void setValue(String str) {
        this.mValue = str;
    }

    public boolean isTopCity() {
        return this.mIsTopCity;
    }

    public void setIsTopCity(boolean z) {
        this.mIsTopCity = z;
    }
}
