package net.one97.paytm.nativesdk.paymethods.model.fetchBalance;

import java.util.ArrayList;
import net.one97.paytm.nativesdk.common.model.BaseDataModel;

public class Body implements BaseDataModel {
    private String accountStatus;
    private BalanceInfo balanceInfo;
    private String displayMessage;
    private boolean enable;
    private FullTnCDetails fullTnCDetails;
    private String infoButtonMessage;
    private String kycCode;
    private String kycVersion;
    private ArrayList<String> mictLines;
    private Boolean passcodeRequired;
    private ResultInfo resultInfo;

    public String getDisplayMessage() {
        return this.displayMessage;
    }

    public void setDisplayMessage(String str) {
        this.displayMessage = str;
    }

    public String getAccountStatus() {
        return this.accountStatus;
    }

    public void setAccountStatus(String str) {
        this.accountStatus = str;
    }

    public String getKycCode() {
        return this.kycCode;
    }

    public void setKycCode(String str) {
        this.kycCode = str;
    }

    public String getKycVersion() {
        return this.kycVersion;
    }

    public void setKycVersion(String str) {
        this.kycVersion = str;
    }

    public ArrayList<String> getMictLines() {
        return this.mictLines;
    }

    public void setMictLines(ArrayList<String> arrayList) {
        this.mictLines = arrayList;
    }

    public FullTnCDetails getFullTnCDetails() {
        return this.fullTnCDetails;
    }

    public void setFullTnCDetails(FullTnCDetails fullTnCDetails2) {
        this.fullTnCDetails = fullTnCDetails2;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public void setEnable(boolean z) {
        this.enable = z;
    }

    public BalanceInfo getBalanceInfo() {
        return this.balanceInfo;
    }

    public void setBalanceInfo(BalanceInfo balanceInfo2) {
        this.balanceInfo = balanceInfo2;
    }

    public ResultInfo getResultInfo() {
        return this.resultInfo;
    }

    public void setResultInfo(ResultInfo resultInfo2) {
        this.resultInfo = resultInfo2;
    }

    public String toString() {
        return "ClassPojo [balanceInfo = " + this.balanceInfo + ", resultInfo = " + this.resultInfo + "]";
    }

    public Boolean getPasscodeRequired() {
        return this.passcodeRequired;
    }

    public void setPasscodeRequired(Boolean bool) {
        this.passcodeRequired = bool;
    }

    public static class FullTnCDetails {
        private String link;
        private String linkMessage;
        private String message;

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String str) {
            this.message = str;
        }

        public String getLink() {
            return this.link;
        }

        public void setLink(String str) {
            this.link = str;
        }

        public String getLinkMessage() {
            return this.linkMessage;
        }

        public void setLinkMessage(String str) {
            this.linkMessage = str;
        }
    }

    public String getInfoButtonMessage() {
        return this.infoButtonMessage;
    }

    public void setInfoButtonMessage(String str) {
        this.infoButtonMessage = str;
    }
}
