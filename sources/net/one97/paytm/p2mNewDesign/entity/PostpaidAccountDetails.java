package net.one97.paytm.p2mNewDesign.entity;

import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public class PostpaidAccountDetails extends CJRWalletDataModel implements IJRDataModel {
    private String accountStatus;
    private PostpaidBalanceInfo balanceInfo;
    private ArrayList<PostpaidBalanceInfo> detailedBalanceInfo;
    private String displayMessage;
    private boolean enable;
    private String extraParamsMap;
    private String infoButtonMessage;
    private String passcodeRequired;
    private ResultInfo resultInfo;

    public ArrayList<PostpaidBalanceInfo> getDetailedBalanceInfo() {
        return this.detailedBalanceInfo;
    }

    public void setDetailedBalanceInfo(ArrayList<PostpaidBalanceInfo> arrayList) {
        this.detailedBalanceInfo = arrayList;
    }

    public String getAccountStatus() {
        return this.accountStatus;
    }

    public void setAccountStatus(String str) {
        this.accountStatus = str;
    }

    public String getPasscodeRequired() {
        return this.passcodeRequired;
    }

    public void setPasscodeRequired(String str) {
        this.passcodeRequired = str;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public String getExtraParamsMap() {
        return this.extraParamsMap;
    }

    public void setExtraParamsMap(String str) {
        this.extraParamsMap = str;
    }

    public PostpaidBalanceInfo getBalanceInfo() {
        return this.balanceInfo;
    }

    public void setBalanceInfo(PostpaidBalanceInfo postpaidBalanceInfo) {
        this.balanceInfo = postpaidBalanceInfo;
    }

    public ResultInfo getResultInfo() {
        return this.resultInfo;
    }

    public void setResultInfo(ResultInfo resultInfo2) {
        this.resultInfo = resultInfo2;
    }

    public String toString() {
        return "ClassPojo [accountStatus = " + this.accountStatus + ", passcodeRequired = " + this.passcodeRequired + ", enable = " + this.enable + ", extraParamsMap = " + this.extraParamsMap + ", balanceInfo = " + this.balanceInfo + ", resultInfo = " + this.resultInfo + "]";
    }

    public String getInfoButtonMessage() {
        return this.infoButtonMessage;
    }

    public String getDisplayMessage() {
        return this.displayMessage;
    }
}
