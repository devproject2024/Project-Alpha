package com.business.merchant_payments.model.v2;

import com.business.merchant_payments.model.businesswallet.ResultInfo;
import com.business.merchant_payments.model.lastcollectedpaymentmodel.SettlementInfoList;
import com.business.merchant_payments.model.paymentlinks.PayMoneyAmount;
import com.google.gson.a.a;
import com.google.gson.a.c;
import java.io.Serializable;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class OrderDetailV2Model implements Serializable {
    @c(a = "accountNo")
    @a
    public String accountNo;
    @c(a = "additionalInfo")
    @a
    public AdditionalInfo additionalInfo;
    @c(a = "bizOrderId")
    @a
    public String bizOrderId;
    public String bizSystemDesc;
    public String bizSystemName;
    @c(a = "bizType")
    @a
    public String bizType;
    @c(a = "cashPosIncentiveAmount")
    public PayMoneyAmount cashPosIncentiveAmount;
    @c(a = "commission")
    @a
    public Commission commission;
    @c(a = "commissionTax")
    @a
    public CommissionTax commissionTax;
    public String deductionLabel;
    @c(a = "deductionName")
    @a
    public String deductionName;
    @c(a = "extendInfo")
    @a
    public String extendInfo;
    @c(a = "feeOnHold")
    @a
    public boolean feeOnHold;
    @c(a = "flagInfo")
    @a
    public String flagInfo;
    @c(a = "goodsInfo")
    @a
    public String goodsInfo;
    @c(a = "ipRoleId")
    @a
    public String ipRoleId;
    public String loanRefNumber;
    public String mMaskedCardNo;
    public String mPayMode;
    public String mUpiId;
    @c(a = "maxRefundableAmt")
    public PayMoneyAmount maxRefundableAmt;
    @c(a = "mercUnqRef")
    @a
    public String mercUnqRef;
    @c(a = "merchantReferenceId")
    @a
    public String merchantReferenceId;
    @c(a = "merchantTransId")
    @a
    public String merchantTransId;
    @c(a = "nickName")
    @a
    public String nickName;
    @c(a = "oppositeAccountNo")
    @a
    public String oppositeAccountNo;
    @c(a = "oppositeEmail")
    @a
    public String oppositeEmail;
    @c(a = "oppositeNickname")
    @a
    public String oppositeNickname;
    @c(a = "oppositePhone")
    @a
    public String oppositePhone;
    @c(a = "oppositeUserId")
    @a
    public String oppositeUserId;
    @c(a = "orderCompletedTime")
    @a
    public String orderCompletedTime;
    @c(a = "orderCreatedTime")
    @a
    public String orderCreatedTime;
    @c(a = "orderStatus")
    @a
    public String orderStatus;
    @c(a = "payMethodChargeInfo")
    @a
    public String payMethodChargeInfo;
    @c(a = "payMoneyAmount")
    @a
    public PayMoneyAmount payMoneyAmount;
    @c(a = "pcTax")
    @a
    public PcTax pcTax;
    @c(a = "pcfee")
    @a
    public Pcfee pcfee;
    @c(a = "productCode")
    @a
    public String productCode;
    @c(a = "reconId")
    @a
    public String reconId;
    @c(a = "referenceBizOrderId")
    @a
    public String referenceBizOrderId;
    @c(a = "resultInfo")
    @a
    public ResultInfo resultInfo;
    @c(a = "settlementInfoList")
    @a
    public List<SettlementInfoList> settlementInfoList = null;
    public transient boolean showEntryAnimation = false;
    @c(a = "terminalType")
    @a
    public String terminalType;
    public String txnSettleType;

    public String getTxnSettleType() {
        return this.txnSettleType;
    }

    public void setTxnSettleType(String str) {
        this.txnSettleType = str;
    }

    public void setFeeOnHold(boolean z) {
        this.feeOnHold = z;
    }

    public boolean isFeeOnHold() {
        return this.feeOnHold;
    }

    public String getmPayMode() {
        return this.mPayMode;
    }

    public PayMoneyAmount getCashPosIncentiveAmount() {
        return this.cashPosIncentiveAmount;
    }

    public void setCashPosIncentiveAmount(PayMoneyAmount payMoneyAmount2) {
        this.cashPosIncentiveAmount = payMoneyAmount2;
    }

    public Pcfee getPcfee() {
        return this.pcfee;
    }

    public void setPcfee(Pcfee pcfee2) {
        this.pcfee = pcfee2;
    }

    public PcTax getPcTax() {
        return this.pcTax;
    }

    public void setPcTax(PcTax pcTax2) {
        this.pcTax = pcTax2;
    }

    public void setmPayMode(String str) {
        this.mPayMode = str;
    }

    public String getmMaskedCardNo() {
        return this.mMaskedCardNo;
    }

    public void setmMaskedCardNo(String str) {
        this.mMaskedCardNo = str;
    }

    public String getmUpiId() {
        return this.mUpiId;
    }

    public void setmUpiId(String str) {
        this.mUpiId = str;
    }

    public String getAccountNo() {
        return this.accountNo;
    }

    public String getMerchantReferenceId() {
        return this.merchantReferenceId;
    }

    public String getReferenceBizOrderId() {
        return this.referenceBizOrderId;
    }

    public String getOppositeAccountNo() {
        return this.oppositeAccountNo;
    }

    public String getReconId() {
        return this.reconId;
    }

    public String getBizOrderId() {
        return this.bizOrderId;
    }

    public void setBizOrderId(String str) {
        this.bizOrderId = str;
    }

    public String getBizType() {
        return this.bizType;
    }

    public void setBizType(String str) {
        this.bizType = str;
    }

    public Commission getCommission() {
        return this.commission;
    }

    public void setCommission(Commission commission2) {
        this.commission = commission2;
    }

    public CommissionTax getCommissionTax() {
        return this.commissionTax;
    }

    public void setCommissionTax(CommissionTax commissionTax2) {
        this.commissionTax = commissionTax2;
    }

    public String getExtendInfo() {
        return this.extendInfo;
    }

    public void setExtendInfo(String str) {
        this.extendInfo = str;
    }

    public String getFlagInfo() {
        return this.flagInfo;
    }

    public void setFlagInfo(String str) {
        this.flagInfo = str;
    }

    public String getGoodsInfo() {
        return this.goodsInfo;
    }

    public void setGoodsInfo(String str) {
        this.goodsInfo = str;
    }

    public String getIpRoleId() {
        return this.ipRoleId;
    }

    public void setIpRoleId(String str) {
        this.ipRoleId = str;
    }

    public String getMercUnqRef() {
        return this.mercUnqRef;
    }

    public void setMercUnqRef(String str) {
        this.mercUnqRef = str;
    }

    public String getMerchantTransId() {
        return this.merchantTransId;
    }

    public void setMerchantTransId(String str) {
        this.merchantTransId = str;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public String getOppositeEmail() {
        return this.oppositeEmail;
    }

    public void setOppositeEmail(String str) {
        this.oppositeEmail = str;
    }

    public String getOppositeNickname() {
        return this.oppositeNickname;
    }

    public void setOppositeNickname(String str) {
        this.oppositeNickname = str;
    }

    public String getOppositePhone() {
        return this.oppositePhone;
    }

    public void setOppositePhone(String str) {
        this.oppositePhone = str;
    }

    public String getOppositeUserId() {
        return this.oppositeUserId;
    }

    public void setOppositeUserId(String str) {
        this.oppositeUserId = str;
    }

    public String getOrderCompletedTime() {
        return this.orderCompletedTime;
    }

    public void setOrderCompletedTime(String str) {
        this.orderCompletedTime = str;
    }

    public String getOrderCreatedTime() {
        return this.orderCreatedTime;
    }

    public void setOrderCreatedTime(String str) {
        this.orderCreatedTime = str;
    }

    public String getOrderStatus() {
        return this.orderStatus;
    }

    public PayMoneyAmount getPayMoneyAmount() {
        return this.payMoneyAmount;
    }

    public String getDeductionName() {
        return this.deductionName;
    }

    public String getProductCode() {
        return this.productCode;
    }

    public void setProductCode(String str) {
        this.productCode = str;
    }

    public ResultInfo getResultInfo() {
        return this.resultInfo;
    }

    public void setResultInfo(ResultInfo resultInfo2) {
        this.resultInfo = resultInfo2;
    }

    public List<SettlementInfoList> getSettlementInfoList() {
        return this.settlementInfoList;
    }

    public void setSettlementInfoList(List<SettlementInfoList> list) {
        this.settlementInfoList = list;
    }

    public String getTerminalType() {
        return this.terminalType;
    }

    public void setTerminalType(String str) {
        this.terminalType = str;
    }

    public boolean showEntryAnimation() {
        return this.showEntryAnimation;
    }

    public void setShowEntryAnimation(boolean z) {
        this.showEntryAnimation = z;
    }

    public void setmLoanRefNumber(String str) {
        this.loanRefNumber = str;
    }

    public String getLoanRefNumber() {
        return this.loanRefNumber;
    }

    public String getBizSystemName() {
        return this.bizSystemName;
    }

    public void setBizSystemName(String str) {
        this.bizSystemName = str;
    }

    public AdditionalInfo getAdditionalInfo() {
        return this.additionalInfo;
    }

    public String getDeductionLabel() {
        return this.deductionLabel;
    }

    public String getBizSystemDesc() {
        return this.bizSystemDesc;
    }

    public PayMoneyAmount getMaxRefundableAmt() {
        return this.maxRefundableAmt;
    }

    public Boolean getIsRefund() {
        String str = this.flagInfo;
        if (str != null) {
            try {
                return Boolean.valueOf(new JSONObject(str.replaceAll("\"", "")).getBoolean("isRefund"));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return Boolean.FALSE;
    }

    public static class AdditionalInfo implements Serializable {
        public String bankIconUrl;
        public String cancelRequestType;
        @c(a = "comment")
        @a
        public String comment;
        public String customerName;
        @c(a = "isRefundAllowed")
        @a
        public Boolean isRefundAllowed;
        @c(a = "issuingBankName")
        @a
        public String issuingBankName;
        public String loanRefNumber;
        public String maskedCardNo;
        @c(a = "parentOrderAmount")
        @a
        public PayMoneyAmount parentOrderAmount;
        @c(a = "payMethod")
        @a
        public String payMethod;
        @c(a = "payMethodIconUrl")
        @a
        public String payMethodIconUrl;
        @c(a = "paytmUserId")
        @a
        public String paytmUserId;
        public String receiverBankName;
        public String receiverIfscCode;
        public String userEmail;
        public String userMobile;
        @c(a = "virtualPaymentAddr")
        @a
        public String virtualPaymentAddr;

        public String getCustomerName() {
            return this.customerName;
        }

        public String getBankIconUrl() {
            return this.bankIconUrl;
        }

        public String getReceiverBankName() {
            return this.receiverBankName;
        }

        public String getReceiverIfscCode() {
            return this.receiverIfscCode;
        }

        public String getComment() {
            return this.comment;
        }

        public String getPayMethod() {
            return this.payMethod;
        }

        public String getMaskedCardNo() {
            return this.maskedCardNo;
        }

        public String getVirtualPaymentAddr() {
            return this.virtualPaymentAddr;
        }

        public String getCancelRequestType() {
            return this.cancelRequestType;
        }

        public String getLoanRefNumber() {
            return this.loanRefNumber;
        }

        public String getUserEmail() {
            return this.userEmail;
        }

        public String getUserMobile() {
            return this.userMobile;
        }

        public Boolean getRefundAllowed() {
            return this.isRefundAllowed;
        }

        public String getPayMethodIconUrl() {
            return this.payMethodIconUrl;
        }

        public PayMoneyAmount getParentOrderAmount() {
            return this.parentOrderAmount;
        }

        public String getIssuingBankName() {
            return this.issuingBankName;
        }

        public void setIssuingBankName(String str) {
            this.issuingBankName = str;
        }
    }
}
