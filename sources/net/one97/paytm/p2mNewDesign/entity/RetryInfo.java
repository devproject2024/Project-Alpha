package net.one97.paytm.p2mNewDesign.entity;

import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class RetryInfo implements IJRDataModel {
    private String blockerMessage;
    private ArrayList<Buttons> buttons;
    private String failureHeader;
    private String failureLogo;
    private String failureMessage;
    private String failureType;
    private String merchantLogo;
    private String merchantName;
    private boolean popupEnable;

    public ArrayList<Buttons> getButtons() {
        return this.buttons;
    }

    public void setButtons(ArrayList<Buttons> arrayList) {
        this.buttons = arrayList;
    }

    public String getMerchantLogo() {
        return this.merchantLogo;
    }

    public void setMerchantLogo(String str) {
        this.merchantLogo = str;
    }

    public String getFailureType() {
        return this.failureType;
    }

    public void setFailureType(String str) {
        this.failureType = str;
    }

    public boolean getPopupEnable() {
        return this.popupEnable;
    }

    public String getBlockerMessage() {
        return this.blockerMessage;
    }

    public void setBlockerMessage(String str) {
        this.blockerMessage = str;
    }

    public String getFailureLogo() {
        return this.failureLogo;
    }

    public void setFailureLogo(String str) {
        this.failureLogo = str;
    }

    public String getFailureMessage() {
        return this.failureMessage;
    }

    public void setFailureMessage(String str) {
        this.failureMessage = str;
    }

    public String getFailureHeader() {
        return this.failureHeader;
    }

    public void setFailureHeader(String str) {
        this.failureHeader = str;
    }

    public String getMerchantName() {
        return this.merchantName;
    }

    public void setMerchantName(String str) {
        this.merchantName = str;
    }

    public String toString() {
        return "ClassPojo [buttons = " + this.buttons + ", merchantLogo = " + this.merchantLogo + ", failureType = " + this.failureType + ", popupEnable = " + this.popupEnable + ", blockerMessage = " + this.blockerMessage + ", failureLogo = " + this.failureLogo + ", failureMessage = " + this.failureMessage + ", failureHeader = " + this.failureHeader + ", merchantName = " + this.merchantName + "]";
    }
}
