package com.business.merchant_payments.model.lastcollectedpaymentmodel;

import android.text.TextUtils;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.AppUtility;
import com.business.merchant_payments.common.utility.DateUtility;
import com.business.merchant_payments.model.BaseModel;
import com.google.gson.a.c;

public class OfflineTransDetailObject extends BaseModel implements Comparable<OfflineTransDetailObject> {
    public static final long serialVersionUID = 1;
    public int backgroundResource = R.drawable.mp_sqare_bg;
    @c(a = "chargebackAmt")
    public String chargebackAmt;
    @c(a = "commission")
    public String commission;
    public String email;
    @c(a = "cbAmount")
    public String mChangeBackAmmount;
    @c(a = "commisionAmount")
    public String mCommissionAmmount;
    @c(a = "custId")
    public String mCustID;
    @c(a = "isSettled")
    public String mIsSettled;
    @c(a = "merchantDisplayName")
    public String mMerchantDisplayName;
    @c(a = "merchantId")
    public String mMerchantID;
    @c(a = "merchantName")
    public String mMerchantName;
    @c(a = "merchantOrderId")
    public String mMerchantOrderID;
    @c(a = "pccCode")
    public String mPCCCode;
    @c(a = "pccReconCode")
    public String mPCCRecognitionCode;
    @c(a = "pgTxnId")
    public String mPGTransactionID;
    @c(a = "payerPhoneNo")
    public String mPayerPhoneNumber;
    @c(a = "TXN_DATE")
    public String mPaymentCreatedDate;
    @c(a = "mode")
    public String mPaymentMode;
    @c(a = "payoutDate")
    public String mPayoutDate;
    @c(a = "posId")
    public String mPosID;
    @c(a = "refundAmount")
    public String mRefundAmmount;
    @c(a = "remarks")
    public String mRemarks;
    @c(a = "serviceTax")
    public String mServiceTax;
    @c(a = "settlementAmount")
    public String mSettlementAmmount;
    @c(a = "settlementDate")
    public String mSettlementDate;
    @c(a = "txnAmount")
    public String mTransactionAmmount;
    @c(a = "txnDate")
    public String mTransactionDate;
    @c(a = "txnId")
    public String mTransactionID;
    @c(a = "txnStatus")
    public String mTransactionStatus;
    @c(a = "txnType")
    public String mTransactionType;
    public String mTxnType;
    @c(a = "utrNumber")
    public String mUTRNumber;
    @c(a = "uniqueReferenceLabel")
    public String mUniqueReferenceLabel;
    @c(a = "uniqueReferenceValue")
    public String mUniqueReferenceValue;
    @c(a = "userPhoneNo")
    public String mUserPhoneNo;
    public String maskedCardNo;
    @c(a = "orderId")
    public String orderId;
    public String originalPayMode;
    public String payMethod;
    @c(a = "paymentMode")
    public String paymentMode;
    @c(a = "phoneNum")
    public String phoneNum;
    @c(a = "reconStatus")
    public String reconStatus;
    @c(a = "sTax")
    public String sTax;
    public boolean setItemDevider = true;
    @c(a = "settledAmt")
    public String settledAmt;
    @c(a = "settledDate")
    public String settledDate;
    public transient boolean showEntryAnimation = false;
    @c(a = "status")
    public String status;
    @c(a = "txnAmt")
    public String txnAmt;
    public long txnTimestamp;
    public String userName;
    public String userVPA;
    @c(a = "utrNo")
    public String utrNo;

    public String getmTxnType() {
        return this.mTxnType;
    }

    public void setmTxnType(String str) {
        this.mTxnType = str;
    }

    public String getMaskedCardNo() {
        return this.maskedCardNo;
    }

    public void setMaskedCardNo(String str) {
        this.maskedCardNo = str;
    }

    public String getPayMethod() {
        return this.payMethod;
    }

    public void setPayMethod(String str) {
        this.payMethod = str;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public String getUserVPA() {
        return this.userVPA;
    }

    public void setUserVPA(String str) {
        this.userVPA = str;
    }

    public boolean showEntryAnimation() {
        return this.showEntryAnimation;
    }

    public void setShowEntryAnimation(boolean z) {
        this.showEntryAnimation = z;
    }

    public String getmPaymentCreatedDate() {
        return this.mPaymentCreatedDate;
    }

    public void setmPaymentCreatedDate(String str) {
        this.mPaymentCreatedDate = str;
    }

    public boolean isSetItemDevider() {
        return this.setItemDevider;
    }

    public void setSetItemDevider(boolean z) {
        this.setItemDevider = z;
    }

    public String getmPaymentMode() {
        if (AppUtility.isNonEmptyString(this.paymentMode)) {
            return this.paymentMode;
        }
        return this.mPaymentMode;
    }

    public void setmPaymentMode(String str) {
        this.mPaymentMode = str;
    }

    public String getmRefundAmmount() {
        return this.mRefundAmmount;
    }

    public void setmRefundAmmount(String str) {
        this.mRefundAmmount = str;
    }

    public String getmChangeBackAmmount() {
        return this.mChangeBackAmmount;
    }

    public void setmChangeBackAmmount(String str) {
        this.mChangeBackAmmount = str;
    }

    public String getmPayoutDate() {
        return this.mPayoutDate;
    }

    public void setmPayoutDate(String str) {
        this.mPayoutDate = str;
    }

    public String getmTransactionID() {
        return this.mTransactionID;
    }

    public void setmTransactionID(String str) {
        this.mTransactionID = str;
    }

    public String getmMerchantOrderID() {
        if (AppUtility.isNonEmptyString(this.orderId)) {
            return this.orderId;
        }
        return this.mMerchantOrderID;
    }

    public void setmMerchantOrderID(String str) {
        this.mMerchantOrderID = str;
    }

    public String getmPGTransactionID() {
        return this.mPGTransactionID;
    }

    public void setmPGTransactionID(String str) {
        this.mPGTransactionID = str;
    }

    public String getmCustID() {
        return this.mCustID;
    }

    public void setmCustID(String str) {
        this.mCustID = str;
    }

    public String getmTransactionType() {
        return this.mTransactionType;
    }

    public void setmTransactionType(String str) {
        this.mTransactionType = str;
    }

    public String getmTransactionAmmount() {
        if (AppUtility.isNonEmptyString(this.txnAmt)) {
            return this.txnAmt;
        }
        return this.mTransactionAmmount;
    }

    public void setmTransactionAmmount(String str) {
        this.mTransactionAmmount = str;
    }

    public String getmCommissionAmmount() {
        if (AppUtility.isNonEmptyString(this.commission)) {
            return this.commission;
        }
        return this.mCommissionAmmount;
    }

    public void setmCommissionAmmount(String str) {
        this.mCommissionAmmount = str;
    }

    public String getmTransactionStatus() {
        if (AppUtility.isNonEmptyString(this.status) && TextUtils.isEmpty(this.mTransactionStatus)) {
            String str = this.status;
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1944610896:
                    if (str.equals(AppConstants.TRANSACTION_STATUS_REFUND_PENDING)) {
                        c2 = 5;
                        break;
                    }
                    break;
                case -1882253182:
                    if (str.equals("TXN_PENDING")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 1165774364:
                    if (str.equals(AppConstants.TRANSACTION_STATUS_REFUND_SUCCESS)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 1228132078:
                    if (str.equals("TXN_SUCCESS")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 1946369955:
                    if (str.equals(AppConstants.TRANSACTION_STATUS_REFUND_FAILURE)) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 2008727669:
                    if (str.equals("TXN_FAILURE")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            if (c2 == 0 || c2 == 1) {
                this.mTransactionStatus = "SUCCESS";
            } else if (c2 == 2 || c2 == 3) {
                this.mTransactionStatus = "FAILURE";
            } else if (c2 == 4 || c2 == 5) {
                this.mTransactionStatus = "PENDING";
            } else {
                this.mTransactionStatus = this.status;
            }
        }
        return this.mTransactionStatus;
    }

    public void setmTransactionStatus(String str) {
        this.mTransactionStatus = str;
    }

    public String getmTransactionDate() {
        return DateUtility.getOfflineCompatibleDate(this.mTransactionDate);
    }

    public void setmTransactionDate(String str) {
        this.mTransactionDate = str;
    }

    public String getIsSettled() {
        if (AppUtility.isNonEmptyString(this.reconStatus)) {
            return this.reconStatus.equalsIgnoreCase("SETTLED") ? "1" : "0";
        }
        return this.mIsSettled;
    }

    public void setIsSettled(String str) {
        this.mIsSettled = str;
    }

    public String getmPosID() {
        return this.mPosID;
    }

    public void setmPosID(String str) {
        this.mPosID = str;
    }

    public String getmUTRNumber() {
        if (AppUtility.isNonEmptyString(this.utrNo)) {
            return this.utrNo;
        }
        return this.mUTRNumber;
    }

    public void setmUTRNumber(String str) {
        this.mUTRNumber = str;
    }

    public String getmUniqueReferenceLabel() {
        return this.mUniqueReferenceLabel;
    }

    public void setmUniqueReferenceLabel(String str) {
        this.mUniqueReferenceLabel = str;
    }

    public String getmUniqueReferenceValue() {
        return this.mUniqueReferenceValue;
    }

    public void setmUniqueReferenceValue(String str) {
        this.mUniqueReferenceValue = str;
    }

    public String getmMerchantID() {
        return this.mMerchantID;
    }

    public void setmMerchantID(String str) {
        this.mMerchantID = str;
    }

    public String getmMerchantDisplayName() {
        return this.mMerchantDisplayName;
    }

    public void setmMerchantDisplayName(String str) {
        this.mMerchantDisplayName = str;
    }

    public String getmMerchantName() {
        return this.mMerchantName;
    }

    public void setmMerchantName(String str) {
        this.mMerchantName = str;
    }

    public String getmSettlementDate() {
        if (AppUtility.isNonEmptyString(this.settledDate)) {
            return DateUtility.getOfflineCompatibleDate(this.settledDate);
        }
        return this.mSettlementDate;
    }

    public void setmSettlementDate(String str) {
        this.mSettlementDate = str;
    }

    public String getmServiceTax() {
        if (AppUtility.isNonEmptyString(this.sTax)) {
            return this.sTax;
        }
        return this.mServiceTax;
    }

    public void setmServiceTax(String str) {
        this.mServiceTax = str;
    }

    public String getmPCCCode() {
        return this.mPCCCode;
    }

    public void setmPCCCode(String str) {
        this.mPCCCode = str;
    }

    public String getmPCCRecognitionCode() {
        return this.mPCCRecognitionCode;
    }

    public void setmPCCRecognitionCode(String str) {
        this.mPCCRecognitionCode = str;
    }

    public String getmPayerPhoneNumber() {
        if (AppUtility.isNonEmptyString(this.phoneNum)) {
            return this.phoneNum;
        }
        return this.mPayerPhoneNumber;
    }

    public void setmPayerPhoneNumber(String str) {
        this.mPayerPhoneNumber = str;
    }

    public String getmRemarks() {
        return this.mRemarks;
    }

    public void setmRemarks(String str) {
        this.mRemarks = str;
    }

    public String getmSettlementAmmount() {
        if (AppUtility.isNonEmptyString(this.settledAmt)) {
            return this.settledAmt;
        }
        return this.mSettlementAmmount;
    }

    public void setmSettlementAmmount(String str) {
        this.mSettlementAmmount = str;
    }

    public int getBackgroundResource() {
        return this.backgroundResource;
    }

    public void setBackgroundResource(int i2) {
        this.backgroundResource = i2;
    }

    public String getChargebackAmt() {
        return this.chargebackAmt;
    }

    private long getTxnTimestamp() {
        return this.txnTimestamp;
    }

    private void setTxnTimestamp(long j) {
        this.txnTimestamp = j;
    }

    public String getmUserPhoneNo() {
        return this.mUserPhoneNo;
    }

    public void setmUserPhoneNo(String str) {
        this.mUserPhoneNo = str;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public String getOriginalPayMode() {
        return this.originalPayMode;
    }

    public void setOriginalPayMode(String str) {
        this.originalPayMode = str;
    }

    public int compareTo(OfflineTransDetailObject offlineTransDetailObject) {
        if (getTxnTimestamp() == 0) {
            setTxnTimestamp(DateUtility.getTimestamp(getmTransactionDate(), "dd/MM/yyyy HH:mm:ss"));
        }
        if (offlineTransDetailObject.getTxnTimestamp() == 0) {
            offlineTransDetailObject.setTxnTimestamp(DateUtility.getTimestamp(offlineTransDetailObject.getmTransactionDate(), "dd/MM/yyyy HH:mm:ss"));
        }
        if (getTxnTimestamp() > offlineTransDetailObject.getTxnTimestamp()) {
            return -1;
        }
        return getTxnTimestamp() < offlineTransDetailObject.getTxnTimestamp() ? 1 : 0;
    }
}
