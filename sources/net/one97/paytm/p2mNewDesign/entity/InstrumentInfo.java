package net.one97.paytm.p2mNewDesign.entity;

import android.text.TextUtils;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.gold.jeweller.CJRGoldPortfolio;
import net.one97.paytm.p2mNewDesign.models.AmountV2;
import net.one97.paytm.p2mNewDesign.models.HasLowSuccessV2;
import net.one97.paytm.p2mNewDesign.models.IsDisabledV2;
import net.one97.paytm.p2mNewDesign.models.a;
import org.json.JSONObject;

public class InstrumentInfo implements Cloneable, IJRDataModel {
    private String accountNumber;
    private String accountType;
    private String bankName;
    private String blockMessage;
    private String cardFirstSixDigit;
    private String cardLastFourDigit;
    private String channelCode;
    private Double emiPerMonth;
    private String emiType;
    private String errorMessage;
    private String expiryDate;
    private String iconUrl;
    private boolean isActive = true;
    private boolean isAllPaymodeFetched;
    private boolean isBlocked;
    private boolean isCardFromEMITab;
    private boolean isDummyWalletView;
    private boolean isEMICard;
    private boolean isEMIavailable;
    private boolean isEmiClicked;
    private boolean isEmiTypeCard;
    private boolean isEnrollmentPossible;
    private boolean isFromSavedCard;
    private boolean isLimitBreached;
    private boolean isMore;
    private boolean isOneClickSupported;
    private boolean isPostpaidAPIFail;
    private boolean isSavedCard;
    private boolean isSavedCardPresent;
    private boolean isScpEnrolled;
    private boolean isWalletAPIFAIL;
    private JSONObject mAdditionalParams;
    private String mBalance;
    private String mBankCode;
    private String mCardType;
    private IJRDataModel mDataModel;
    private String mDisplayPrimaryInfo;
    private String mDisplayPrimaryInfo2;
    private String mDisplaySecondaryInfo;
    private String mDisplaySecondaryInfo2;
    private String mDisplaythirdInfo;
    private CJRGoldPortfolio mGoldPortfolio;
    private IsDisabledV2 mIsDisabled;
    private HasLowSuccessV2 mLowSuccess;
    private AmountV2 mMaxAmount;
    private AmountV2 mMinAmount;
    private String mPayMode;
    private String mPaymentDetails;
    private String mPaymentTypeId;
    private String mTotalBalance;
    private double minimumLimitForPayWithGold;
    private String passcode;
    private String passcodeRequired;
    private String paymodeType;
    private String planId;
    private String priority;
    private a selectedEMIPlan;
    private String selectedEMIPlanId;
    private String storeFrontUrl;
    private String templeteId;
    private String uniqueId;
    private int upiOnboardingStatus;

    public String getmDisplayPrimaryInfo2() {
        return this.mDisplayPrimaryInfo2;
    }

    public void setmDisplayPrimaryInfo2(String str) {
        this.mDisplayPrimaryInfo2 = str;
    }

    public String getPriority() {
        return this.priority;
    }

    public void setPriority(String str) {
        this.priority = str;
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

    public IsDisabledV2 getmIsDisabled() {
        return this.mIsDisabled;
    }

    public void setmIsDisabled(IsDisabledV2 isDisabledV2) {
        this.mIsDisabled = isDisabledV2;
    }

    public void setmLowSuccess(HasLowSuccessV2 hasLowSuccessV2) {
        this.mLowSuccess = this.mLowSuccess;
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

    public HasLowSuccessV2 getmLowSuccess() {
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
        return TextUtils.isEmpty(this.mTotalBalance) ? "0" : net.one97.paytm.wallet.utility.a.p(this.mTotalBalance);
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

    public boolean isActive() {
        return this.isActive;
    }

    public void setActive(boolean z) {
        this.isActive = z;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public boolean isPostpaidAPIFail() {
        return this.isPostpaidAPIFail;
    }

    public void setPostpaidAPIFail(boolean z) {
        this.isPostpaidAPIFail = z;
    }

    public boolean isMore() {
        return this.isMore;
    }

    public void setMore(boolean z) {
        this.isMore = z;
    }

    public AmountV2 getmMinAmount() {
        return this.mMinAmount;
    }

    public void setmMinAmount(AmountV2 amountV2) {
        this.mMinAmount = amountV2;
    }

    public AmountV2 getmMaxAmount() {
        return this.mMaxAmount;
    }

    public void setmMaxAmount(AmountV2 amountV2) {
        this.mMaxAmount = amountV2;
    }

    public String getSelectedEMIPlanId() {
        return this.selectedEMIPlanId;
    }

    public void setSelectedEMIPlanId(String str) {
        this.selectedEMIPlanId = str;
    }

    public void setSelectedEMIPlan(a aVar) {
        this.selectedEMIPlan = aVar;
    }

    public a getSelectedEMIPlan() {
        return this.selectedEMIPlan;
    }

    public boolean isEMIavailable() {
        return this.isEMIavailable;
    }

    public void setEMIavailable(boolean z) {
        this.isEMIavailable = z;
    }

    public String getBankName() {
        return this.bankName;
    }

    public void setBankName(String str) {
        this.bankName = str;
    }

    public String getChannelCode() {
        return this.channelCode;
    }

    public void setChannelCode(String str) {
        this.channelCode = str;
    }

    public boolean isEmiTypeCard() {
        return this.isEmiTypeCard;
    }

    public void setEmiTypeCard(boolean z) {
        this.isEmiTypeCard = z;
    }

    public boolean isEmiClicked() {
        return this.isEmiClicked;
    }

    public void setEmiClicked(boolean z) {
        this.isEmiClicked = z;
    }

    public boolean isFromSavedCard() {
        return this.isFromSavedCard;
    }

    public void setFromSavedCard(boolean z) {
        this.isFromSavedCard = z;
    }

    public String getPlanId() {
        return this.planId;
    }

    public void setPlanId(String str) {
        this.planId = str;
    }

    public String getEmiType() {
        return this.emiType;
    }

    public void setEmiType(String str) {
        this.emiType = str;
    }

    public Double getEmiPerMonth() {
        return this.emiPerMonth;
    }

    public void setEmiPerMonth(Double d2) {
        this.emiPerMonth = d2;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getAccountType() {
        return this.accountType;
    }

    public void setAccountType(String str) {
        this.accountType = str;
    }

    public String getmDisplaySecondaryInfo2() {
        return this.mDisplaySecondaryInfo2;
    }

    public void setmDisplaySecondaryInfo2(String str) {
        this.mDisplaySecondaryInfo2 = str;
    }

    public boolean isCardFromEMITab() {
        return this.isCardFromEMITab;
    }

    public void setCardFromEMITab(boolean z) {
        this.isCardFromEMITab = z;
    }

    public boolean isDummyWalletView() {
        return this.isDummyWalletView;
    }

    public void setDummyWalletView(boolean z) {
        this.isDummyWalletView = z;
    }

    public int getUpiOnboardingStatus() {
        return this.upiOnboardingStatus;
    }

    public void setUpiOnboardingStatus(int i2) {
        this.upiOnboardingStatus = i2;
    }

    public String getTempleteId() {
        return this.templeteId;
    }

    public void setTempleteId(String str) {
        this.templeteId = str;
    }

    public String getStoreFrontUrl() {
        return this.storeFrontUrl;
    }

    public void setStoreFrontUrl(String str) {
        this.storeFrontUrl = str;
    }

    public boolean isLimitBreached() {
        return this.isLimitBreached;
    }

    public void setLimitBreached(boolean z) {
        this.isLimitBreached = z;
    }

    public boolean isBlocked() {
        return this.isBlocked;
    }

    public void setBlocked(boolean z) {
        this.isBlocked = z;
    }

    public String getBlockMessage() {
        return this.blockMessage;
    }

    public void setBlockMessage(String str) {
        this.blockMessage = str;
    }

    public boolean isOneClickSupported() {
        return this.isOneClickSupported;
    }

    public void setOneClickSupported(boolean z) {
        this.isOneClickSupported = z;
    }

    public String getCardFirstSixDigit() {
        return this.cardFirstSixDigit;
    }

    public void setCardFirstSixDigit(String str) {
        this.cardFirstSixDigit = str;
    }

    public String getCardLastFourDigit() {
        return this.cardLastFourDigit;
    }

    public void setCardLastFourDigit(String str) {
        this.cardLastFourDigit = str;
    }

    public String getExpiryDate() {
        return this.expiryDate;
    }

    public void setExpiryDate(String str) {
        this.expiryDate = str;
    }

    public boolean isEMICard() {
        return this.isEMICard;
    }

    public void setEMICard(boolean z) {
        this.isEMICard = z;
    }

    public boolean isSavedCardPresent() {
        return this.isSavedCardPresent;
    }

    public void setSavedCardPresent(boolean z) {
        this.isSavedCardPresent = z;
    }

    public void setPasscode(String str) {
        this.passcode = str;
    }

    public String getPasscode() {
        return this.passcode;
    }

    public String PaymodeType() {
        return this.paymodeType;
    }

    public void setPaymodeType(String str) {
        this.paymodeType = str;
    }

    public String getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(String str) {
        this.uniqueId = str;
    }

    public void setIsScpEnrolled(boolean z) {
        this.isScpEnrolled = z;
    }

    public boolean isScpEnrolled() {
        return this.isScpEnrolled;
    }

    public boolean isEnrollmentPossible() {
        return this.isEnrollmentPossible;
    }

    public void setEnrollmentPossible(boolean z) {
        this.isEnrollmentPossible = z;
    }

    public boolean isAllPaymodeFetched() {
        return this.isAllPaymodeFetched;
    }

    public void setAllPaymodeFetched(boolean z) {
        this.isAllPaymodeFetched = z;
    }

    public boolean isSavedCard() {
        return this.isSavedCard;
    }

    public void setSavedCard(boolean z) {
        this.isSavedCard = z;
    }
}
