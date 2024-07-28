package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTermsAndConditions implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "cancelButton")
    private String mCancelButton;
    @b(a = "message")
    private String mMessage;
    @b(a = "okbutton")
    private String mOkButton;
    @b(a = "title")
    private String mTitle;

    public String getTitle() {
        return this.mTitle;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public String getCancelButton() {
        return this.mCancelButton;
    }

    public String getOkButton() {
        return this.mOkButton;
    }
}
