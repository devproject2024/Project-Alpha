package com.paytmmall.clpartifact.modal.grid;

import com.google.gson.a.c;
import java.io.Serializable;

public class CJRFilterValue implements Serializable {
    private static final long serialVersionUID = 1;
    private boolean isToggleChecked;
    @c(a = "max")
    private double mAbsoluteMax = -1.0d;
    @c(a = "min")
    private double mAbsoluteMin = -1.0d;
    @c(a = "color_code")
    public String mColorCode;
    @c(a = "count")
    private String mCount;
    @c(a = "filter_value_prefix")
    private String mFilterValuePrefix;
    @c(a = "filter_value_suffix")
    private String mFilterValueSufix;
    @c(a = "id")
    private String mID;
    @c(a = "applied")
    private boolean mIsApplied;
    @c(a = "exist")
    private boolean mIsExist;
    @c(a = "label")
    private String mLabel;
    @c(a = "name")
    private String mName;
    private int mSelectedMax;
    private int mSelectedMin;
    @c(a = "url")
    private String mUrl;
    @c(a = "popular")
    private boolean popular;
    @c(a = "product_id")
    private String productId;

    public boolean isPopular() {
        return this.popular;
    }

    public void setPopular(boolean z) {
        this.popular = z;
    }

    public String getmColorCode() {
        return this.mColorCode;
    }

    public void setmColorCode(String str) {
        this.mColorCode = str;
    }

    public int getSelectedMin() {
        return this.mSelectedMin;
    }

    public void setSelectedMin(int i2) {
        this.mSelectedMin = i2;
    }

    public int getSelectedMax() {
        return this.mSelectedMax;
    }

    public void setSelectedMax(int i2) {
        this.mSelectedMax = i2;
    }

    public int getAbsoluteMax() {
        return (int) this.mAbsoluteMax;
    }

    public void setAbsoluteMax(int i2) {
        this.mAbsoluteMax = (double) i2;
    }

    public int getAbsoluteMin() {
        return (int) this.mAbsoluteMin;
    }

    public void setAbsoluteMin(int i2) {
        this.mAbsoluteMin = (double) i2;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public String getID() {
        return this.mID;
    }

    public String getCount() {
        return this.mCount;
    }

    public void setID(String str) {
        this.mID = str;
    }

    public boolean equals(Object obj) {
        try {
            return this.mName.equalsIgnoreCase(((CJRFilterValue) obj).mName);
        } catch (Exception unused) {
            return false;
        }
    }

    public void setChecked(boolean z) {
        this.mIsApplied = z;
    }

    public boolean isChecked() {
        return this.mIsApplied;
    }

    public boolean getIsExist() {
        return this.mIsExist;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public String getLabel() {
        return this.mLabel;
    }

    public void setLabel(String str) {
        this.mLabel = str;
    }

    public String getFilterValuePrefix() {
        return this.mFilterValuePrefix;
    }

    public String getFilterValueSufix() {
        return this.mFilterValueSufix;
    }

    public String getProductId() {
        return this.productId;
    }
}
