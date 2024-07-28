package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRIMEIValidation implements IJRDataModel {
    private boolean isIMEIVerified;
    private boolean isScanResult;
    @b(a = "description")
    private String mDescription;
    @b(a = "endpoint_url")
    private String mEndPointURL;
    @b(a = "header_text")
    private String mHeaderText;
    @b(a = "help_text")
    private String mHelpText;
    @b(a = "icon")
    private String mIconURL;
    private String mImeiInputValue;
    private String mImeiScanedValue;
    @b(a = "input_label")
    private String mInputLabel;
    @b(a = "input_length")
    private int mInputLength;
    @b(a = "input_type")
    private String mKeyboardType;
    @b(a = "regex")
    private String mRegex;
    private String mValidateMsg;
    @b(a = "validation_name")
    private String mValidationName;

    public String getValidationName() {
        return this.mValidationName;
    }

    public String getHeaderText() {
        return this.mHeaderText;
    }

    public String getInputLabel() {
        return this.mInputLabel;
    }

    public String getKeyboardType() {
        return this.mKeyboardType;
    }

    public String getHelpText() {
        return this.mHelpText;
    }

    public String getRegex() {
        return this.mRegex;
    }

    public String getEndPointURL() {
        return this.mEndPointURL;
    }

    public String getIconURL() {
        return this.mIconURL;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public boolean isIMEIVerified() {
        return this.isIMEIVerified;
    }

    public void setIMEIVerified(boolean z) {
        this.isIMEIVerified = z;
    }

    public String getImeiQrCodeValue() {
        return this.mImeiScanedValue;
    }

    public void setImeiQrCodeValue(String str) {
        this.mImeiScanedValue = str;
    }

    public String getValidateMsg() {
        return this.mValidateMsg;
    }

    public void setValidateMsg(String str) {
        this.mValidateMsg = str;
    }

    public void setIsScanResult(boolean z) {
        this.isScanResult = z;
    }

    public boolean isScanResult() {
        return this.isScanResult;
    }

    public String getImeiInputValue() {
        return this.mImeiInputValue;
    }

    public void setImeiInputValue(String str) {
        this.mImeiInputValue = str;
    }

    public int getInputLength() {
        return this.mInputLength;
    }
}
