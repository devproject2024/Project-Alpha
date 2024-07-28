package net.one97.paytm.common.entity.recharge;

import android.text.TextUtils;
import com.google.gsonhtcfix.a.b;
import com.paytm.utility.q;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRInputFields implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "hide")
    private String hide;
    @b(a = "isAlphanumeric")
    private String mAlphaNumeric;
    @b(a = "config_key")
    private String mConfigKey;
    @b(a = "date_format")
    private String mDateFormat;
    @b(a = "display_title")
    private String mDisplayTitle;
    @b(a = "mandatory")
    private boolean mIsMandatory;
    @b(a = "max_date")
    private String mMaxDate;
    @b(a = "min_date")
    private String mMinDate;
    @b(a = "regex")
    private String mRegex;
    @b(a = "show_phonebook")
    private String mShowContactPicker;
    @b(a = "sub_title")
    private String mSubTitle;
    @b(a = "title")
    private String mTitle;
    @b(a = "type")
    private String mType;

    public String getType() {
        return this.mType;
    }

    public boolean isIsMandatory() {
        return this.mIsMandatory;
    }

    public boolean ismIsMandatory() {
        return this.mIsMandatory;
    }

    public String getMinDate() {
        return this.mMinDate;
    }

    public String getMaxDate() {
        return this.mMaxDate;
    }

    public String getDateFormat() {
        return this.mDateFormat;
    }

    public boolean isShowContactPicker() {
        try {
            return !TextUtils.isEmpty(this.mShowContactPicker) && this.mShowContactPicker.equalsIgnoreCase("1");
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
            return false;
        }
    }

    public String getAlphaNumeric() {
        return this.mAlphaNumeric;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getSubTitle() {
        return this.mSubTitle;
    }

    public String getDisplayTitle() {
        return this.mDisplayTitle;
    }

    public String getConfigKey() {
        return this.mConfigKey;
    }

    public String getRegex() {
        return this.mRegex;
    }

    public void setHide(String str) {
        this.hide = str;
    }

    public boolean getHidden() {
        return !TextUtils.isEmpty(this.hide) && this.hide.equalsIgnoreCase("TRUE");
    }
}
