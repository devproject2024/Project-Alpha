package net.one97.paytm.common.entity;

import com.google.gsonhtcfix.a.b;

public class CJRFilterValue implements IJRDataModel {
    private static final long serialVersionUID = 1;
    private boolean isToggleChecked;
    @b(a = "max")
    private double mAbsoluteMax;
    @b(a = "min")
    private double mAbsoluteMin;
    @b(a = "count")
    private String mCount;
    @b(a = "filter_value_prefix")
    private String mFilterValuePrefix;
    @b(a = "filter_value_suffix")
    private String mFilterValueSufix;
    @b(a = "id")
    private String mID;
    @b(a = "applied")
    private boolean mIsApplied;
    @b(a = "exist")
    private boolean mIsExist;
    @b(a = "label")
    private String mLabel;
    @b(a = "name")
    private String mName;
    private int mSelectedMax;
    private int mSelectedMin;
    @b(a = "url")
    private String mUrl;
    @b(a = "product_id")
    private String productId;

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

    public boolean isApplied() {
        return this.mIsApplied;
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
