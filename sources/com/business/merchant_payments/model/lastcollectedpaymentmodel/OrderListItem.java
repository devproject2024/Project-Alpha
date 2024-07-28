package com.business.merchant_payments.model.lastcollectedpaymentmodel;

import android.text.TextUtils;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.common.utility.DateUtility;
import com.business.merchant_payments.model.BaseModel;

public class OrderListItem extends BaseModel {
    public String accountNo;
    public String custId;
    public String customerEmailId;
    public String incentiveAmt;
    public boolean isRefundAllowed;
    public String isSettled;
    public String maskedCardNo;
    public String maxRefund;
    public String mercUnqRef;
    public String merchantId;
    public String merchantName;
    public String merchantOrderId;
    public String oppositeAccountNo;
    public String orderCompletedTime;
    public String orderCreatedTime;
    public String orderId;
    public String orderStatus;
    public String orderType;
    public String payMethod;
    public String payerPhoneNo;
    public String prnValidateTime;
    public boolean prnValidated;
    public String productCode;
    public String reconId;
    public String settlementDate;
    public transient boolean showEntryAnimation = false;
    public String txnAmount;
    public String txnAmt;
    public String txnDate;
    public String txnId;
    public String txnStatus;
    public String txnType;
    public String userEmail;
    public String userName;
    public String userPhoneNo;
    public String userVPA;

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

    public String getProductCode() {
        return this.productCode;
    }

    public void setProductCode(String str) {
        this.productCode = str;
    }

    public String getMercUnqRef() {
        return this.mercUnqRef;
    }

    public void setMercUnqRef(String str) {
        this.mercUnqRef = str;
    }

    public String getMerchantId() {
        return this.merchantId;
    }

    public void setMerchantId(String str) {
        this.merchantId = str;
    }

    public String getMerchantName() {
        return this.merchantName;
    }

    public void setMerchantName(String str) {
        this.merchantName = str;
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

    public String getOppositeAccountNo() {
        return this.oppositeAccountNo;
    }

    public void setOppositeAccountNo(String str) {
        this.oppositeAccountNo = str;
    }

    public String getReconId() {
        return this.reconId;
    }

    public void setReconId(String str) {
        this.reconId = str;
    }

    public String getAccountNo() {
        return this.accountNo;
    }

    public void setAccountNo(String str) {
        this.accountNo = str;
    }

    public String getPrnValidateTime() {
        return this.prnValidateTime;
    }

    public void setPrnValidateTime(String str) {
        this.prnValidateTime = str;
    }

    public boolean isPrnValidated() {
        return this.prnValidated;
    }

    public void setPrnValidated(boolean z) {
        this.prnValidated = z;
    }

    public String getIncentiveAmt() {
        return this.incentiveAmt;
    }

    public void setIncentiveAmt(String str) {
        this.incentiveAmt = str;
    }

    public boolean showEntryAnimation() {
        return this.showEntryAnimation;
    }

    public void setShowEntryAnimation(boolean z) {
        this.showEntryAnimation = z;
    }

    public String getCustomerEmailId() {
        return this.customerEmailId;
    }

    public void setCustomerEmailId(String str) {
        this.customerEmailId = str;
    }

    public String getCustId() {
        return this.custId;
    }

    public void setCustId(String str) {
        this.custId = str;
    }

    public String getSettlementDate() {
        return this.settlementDate;
    }

    public void setSettlementDate(String str) {
        this.settlementDate = str;
    }

    public String getTxnId() {
        return this.txnId;
    }

    public void setmTxnId(String str) {
        this.txnId = str;
    }

    public void setmOrderId(String str) {
        this.orderId = str;
        this.merchantOrderId = str;
    }

    public String getOrderId() {
        boolean q = PaymentsConfig.getInstance().getMerchantDataProvider().q();
        boolean r = PaymentsConfig.getInstance().getMerchantDataProvider().r();
        if (q || r) {
            return this.orderId;
        }
        return this.merchantOrderId;
    }

    public void setmOrderCreatedTime(String str) {
        this.orderCreatedTime = str;
        this.txnDate = str;
    }

    public String getOrderCreatedTime() {
        boolean q = PaymentsConfig.getInstance().getMerchantDataProvider().q();
        boolean r = PaymentsConfig.getInstance().getMerchantDataProvider().r();
        if (!TextUtils.isEmpty(this.txnDate) && DateUtility.isExactlySameFormat(this.txnDate, "yyyy-MM-dd HH:mm:ss")) {
            return this.orderCreatedTime;
        }
        if (q || r || TextUtils.isEmpty(this.txnDate)) {
            return this.orderCreatedTime;
        }
        return DateUtility.getFormattedDate(this.txnDate, "dd/MM/yyyy HH:mm:ss", "yyyy-MM-dd HH:mm:ss");
    }

    public String getOrderCompletedTime() {
        return this.orderCompletedTime;
    }

    public String getOrderType() {
        boolean q = PaymentsConfig.getInstance().getMerchantDataProvider().q();
        boolean r = PaymentsConfig.getInstance().getMerchantDataProvider().r();
        if (q || r) {
            return this.orderType;
        }
        return this.txnType;
    }

    public String getOrderStatus() {
        boolean q = PaymentsConfig.getInstance().getMerchantDataProvider().q();
        boolean r = PaymentsConfig.getInstance().getMerchantDataProvider().r();
        if (q || r) {
            return this.orderStatus;
        }
        return this.txnStatus;
    }

    public String getUserPhoneNo() {
        String str;
        if (this.userPhoneNo != null || (str = this.payerPhoneNo) == null) {
            return this.userPhoneNo;
        }
        return str;
    }

    public void setmUserPhoneNo(String str) {
        this.userPhoneNo = str;
        this.payerPhoneNo = str;
    }

    public String getUserEmail() {
        return this.userEmail;
    }

    public void setmUserEmail(String str) {
        this.userEmail = str;
    }

    public String getTxnAmt() {
        boolean q = PaymentsConfig.getInstance().getMerchantDataProvider().q();
        boolean r = PaymentsConfig.getInstance().getMerchantDataProvider().r();
        if (q || r) {
            return this.txnAmt;
        }
        return this.txnAmount;
    }

    public void setmTxnAmt(String str) {
        this.txnAmount = str;
        this.txnAmt = str;
    }

    public void setOrderStatus(String str) {
        this.orderStatus = str;
    }

    public String getMaxRefund() {
        return this.maxRefund;
    }

    public void setMaxRefund(String str) {
        this.maxRefund = str;
    }

    public void setIsRefundAllowed(boolean z) {
        this.isRefundAllowed = z;
    }

    public boolean getIsRefundAllowed() {
        return this.isRefundAllowed;
    }
}
