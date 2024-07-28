package net.one97.paytm.common.entity.offline_pg;

import android.text.TextUtils;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.gold.jeweller.CJRGoldPortfolio;
import net.one97.paytm.common.entity.offline_pg.paymethodresponse.HasLowSuccess;
import net.one97.paytm.common.entity.offline_pg.paymethodresponse.IsDisabled;
import org.json.JSONObject;

public class InstrumentInfo {
    private String accountNumber;
    private String iconUrl;
    private boolean isWalletAPIFAIL;
    private JSONObject mAdditionalParams;
    private String mBalance;
    private String mBankCode;
    private String mCardType;
    private IJRDataModel mDataModel;
    private String mDisplayPrimaryInfo;
    private String mDisplayPrimaryInfo2;
    private String mDisplaySecondaryInfo;
    private String mDisplaythirdInfo;
    private CJRGoldPortfolio mGoldPortfolio;
    private IsDisabled mIsDisabled;
    private HasLowSuccess mLowSuccess;
    private String mPayMode;
    private String mPaymentDetails;
    private String mPaymentTypeId;
    private String mTotalBalance;
    private double minimumLimitForPayWithGold;
    private String passcodeRequired;

    public String getmDisplayPrimaryInfo2() {
        return this.mDisplayPrimaryInfo2;
    }

    public void setmDisplayPrimaryInfo2(String str) {
        this.mDisplayPrimaryInfo2 = str;
    }

    public String getPasscodeRequired() {
        return this.passcodeRequired;
    }

    public void setPasscodeRequired(String str) {
        this.passcodeRequired = str;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public IsDisabled getmIsDisabled() {
        return this.mIsDisabled;
    }

    public void setmIsDisabled(IsDisabled isDisabled) {
        this.mIsDisabled = isDisabled;
    }

    public void setmLowSuccess(HasLowSuccess hasLowSuccess) {
        this.mLowSuccess = hasLowSuccess;
    }

    public String getCardType() {
        return this.mCardType;
    }

    public void setCardType(String str) {
        this.mCardType = str;
    }

    public String getBalance() {
        return this.mBalance;
    }

    public void setBalance(String str) {
        this.mBalance = str;
    }

    public String getPaymentTypeId() {
        return this.mPaymentTypeId;
    }

    public void setPaymentTypeId(String str) {
        this.mPaymentTypeId = str;
    }

    public String getBankCode() {
        return this.mBankCode;
    }

    public void setBankCode(String str) {
        this.mBankCode = str;
    }

    public String getDisplayPrimaryInfo() {
        return this.mDisplayPrimaryInfo;
    }

    public void setDisplayPrimaryInfo(String str) {
        this.mDisplayPrimaryInfo = str;
    }

    public String getDisplaySecondaryInfo() {
        return this.mDisplaySecondaryInfo;
    }

    public void setDisplaySecondaryInfo(String str) {
        this.mDisplaySecondaryInfo = str;
    }

    public String getPaymentDetails() {
        return this.mPaymentDetails;
    }

    public void setPaymentDetails(String str) {
        this.mPaymentDetails = str;
    }

    public String getPayMode() {
        return this.mPayMode;
    }

    public void setPayMode(String str) {
        this.mPayMode = str;
    }

    public boolean equals(Object obj) {
        InstrumentInfo instrumentInfo = (InstrumentInfo) obj;
        if (instrumentInfo == null || instrumentInfo.getDisplayPrimaryInfo() == null || getDisplayPrimaryInfo() == null || getDisplaySecondaryInfo() == null || instrumentInfo.getDisplaySecondaryInfo() == null || instrumentInfo.getPayMode() == null || !instrumentInfo.getDisplayPrimaryInfo().equals(getDisplayPrimaryInfo()) || !instrumentInfo.getDisplaySecondaryInfo().equalsIgnoreCase(getDisplaySecondaryInfo()) || !instrumentInfo.getPayMode().equalsIgnoreCase(getPayMode())) {
            return false;
        }
        return true;
    }

    public JSONObject getmAdditionalParams() {
        return this.mAdditionalParams;
    }

    public void setmAdditionalParams(JSONObject jSONObject) {
        this.mAdditionalParams = jSONObject;
    }

    public IJRDataModel getDataModel() {
        return this.mDataModel;
    }

    public void setDataModel(IJRDataModel iJRDataModel) {
        this.mDataModel = iJRDataModel;
    }

    public HasLowSuccess getmLowSuccess() {
        return this.mLowSuccess;
    }

    public double getMinimumLimitForPayWithGold() {
        return this.minimumLimitForPayWithGold;
    }

    public void setMinimumLimitForPayWithGold(double d2) {
        this.minimumLimitForPayWithGold = d2;
    }

    public CJRGoldPortfolio getmGoldPortfolio() {
        return this.mGoldPortfolio;
    }

    public void setmGoldPortfolio(CJRGoldPortfolio cJRGoldPortfolio) {
        this.mGoldPortfolio = cJRGoldPortfolio;
    }

    public String getTotalBalance() {
        return TextUtils.isEmpty(this.mTotalBalance) ? "0" : this.mTotalBalance;
    }

    public void setTotalBalance(String str) {
        this.mTotalBalance = str;
    }

    public String getmDisplaythirdInfo() {
        return this.mDisplaythirdInfo;
    }

    public void setmDisplaythirdInfo(String str) {
        this.mDisplaythirdInfo = str;
    }

    public boolean isWalletAPIFAIL() {
        return this.isWalletAPIFAIL;
    }

    public void setWalletAPIFAIL(boolean z) {
        this.isWalletAPIFAIL = z;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(String str) {
        this.accountNumber = str;
    }
}
