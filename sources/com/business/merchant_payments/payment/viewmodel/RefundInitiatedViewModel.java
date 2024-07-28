package com.business.merchant_payments.payment.viewmodel;

import android.content.Context;
import android.text.Spannable;
import android.text.TextUtils;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.i;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.utility.APSharedPreferences;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.AppUtility;
import com.business.merchant_payments.common.utility.DateUtility;
import com.business.merchant_payments.common.viewmodel.BaseViewModel;
import com.business.merchant_payments.databinding.MpRefundInitiatedNewBinding;
import com.business.merchant_payments.model.initiaterefundmodel.InitiateRefundResponseModel;
import com.business.merchant_payments.model.lastcollectedpaymentmodel.OrderListItem;

public class RefundInitiatedViewModel extends BaseViewModel {
    public ObservableInt commentVisibility;
    public i<String> custId = new i<>();
    public i<String> email = new i<>();
    public ObservableInt fail;
    public ObservableInt failIcon;
    public String failReason;
    public ObservableInt failedVisibility;
    public String inAmount;
    public String inDate;
    public ObservableInt initiateFailed;
    public ObservableInt initiatedMob;
    public ObservableBoolean isEmailVisible;
    public boolean isMigrated = false;
    public ObservableBoolean isMobileVisibile;
    public ObservableBoolean isRefIDVisibile;
    public Context mContext;
    public String mRefundAmount;
    public String mRefundDate;
    public InitiateRefundResponseModel mResponseModel;
    public Boolean mStatus;
    public OrderListItem mTransDetails;
    public String mTxnId;
    public String mUserComments;
    public ObservableInt mobileVisibility;
    public i<String> orderId = new i<>();
    public i<String> paymentDate = new i<>();
    public ObservableInt refundAmountisibility;
    public ObservableInt refundIdVisibility;
    public i<String> settledDate = new i<>();
    public ObservableInt successIcon;
    public i<String> txnAmount = new i<>();
    public ObservableInt txnIdVisibility;
    public ObservableInt viewVisibility;

    public RefundInitiatedViewModel(Context context, OrderListItem orderListItem, InitiateRefundResponseModel initiateRefundResponseModel, String str, String str2, Boolean bool, MpRefundInitiatedNewBinding mpRefundInitiatedNewBinding) {
        this.inAmount = str2;
        this.inDate = str;
        this.successIcon = new ObservableInt();
        this.failIcon = new ObservableInt();
        this.mStatus = bool;
        this.mTransDetails = orderListItem;
        this.commentVisibility = new ObservableInt();
        this.txnIdVisibility = new ObservableInt();
        this.refundIdVisibility = new ObservableInt();
        this.failedVisibility = new ObservableInt();
        this.initiateFailed = new ObservableInt();
        this.initiatedMob = new ObservableInt();
        this.mobileVisibility = new ObservableInt();
        this.viewVisibility = new ObservableInt();
        this.refundAmountisibility = new ObservableInt();
        this.fail = new ObservableInt();
        this.isRefIDVisibile = new ObservableBoolean(false);
        this.isMobileVisibile = new ObservableBoolean(false);
        this.isEmailVisible = new ObservableBoolean(false);
        this.mResponseModel = initiateRefundResponseModel;
        this.mContext = context;
        this.isMigrated = APSharedPreferences.getInstance().isMerchantMigrated();
        changeIcon();
        setData();
    }

    private void setData() {
        this.txnAmount.set(displayFormat(this.mTransDetails.getTxnAmt()));
        this.orderId.set(this.mTransDetails.getOrderId());
        this.settledDate.set(this.mTransDetails.getSettlementDate());
        if (!TextUtils.isEmpty(this.mTransDetails.getCustomerEmailId())) {
            this.email.set(this.mTransDetails.getCustomerEmailId());
            this.isEmailVisible.set(true);
        } else {
            this.isEmailVisible.set(false);
        }
        this.paymentDate.set(DateUtility.getFormattedDate(this.mTransDetails.getOrderCreatedTime(), "yyyy-MM-dd HH:mm:ss", "dd MMM yyyy, hh:mm a"));
    }

    private void changeIcon() {
        int i2 = 8;
        if (this.mStatus.booleanValue()) {
            this.successIcon.set(0);
            this.failIcon.set(8);
            this.txnIdVisibility.set(0);
            this.failedVisibility.set(8);
            this.initiateFailed.set(8);
            this.fail.set(8);
            this.mobileVisibility.set(0);
            this.initiatedMob.set(0);
            this.viewVisibility.set(8);
            this.refundAmountisibility.set(0);
        } else {
            this.successIcon.set(8);
            this.failIcon.set(0);
            this.txnIdVisibility.set(8);
            this.failedVisibility.set(0);
            this.initiateFailed.set(0);
            this.fail.set(0);
            this.mobileVisibility.set(8);
            this.initiatedMob.set(8);
            this.viewVisibility.set(0);
            this.refundAmountisibility.set(0);
        }
        ObservableInt observableInt = this.refundIdVisibility;
        if (!TextUtils.isEmpty(getRefundId())) {
            i2 = 0;
        }
        observableInt.set(i2);
    }

    public Spannable getRefundAmount() {
        String displayFormat = displayFormat(this.inAmount);
        if (!displayFormat.contains("-")) {
            displayFormat = "- ".concat(String.valueOf(displayFormat));
        }
        if (this.isMigrated) {
            return AppUtility.formattedPrice(0.5f, displayFormat, this.mContext.getResources().getColor(R.color.orange));
        }
        return AppUtility.formattedPrice(0.5f, displayFormat, this.mContext.getResources().getColor(R.color.color_00c673));
    }

    public String getMobileNo() {
        String str;
        OrderListItem orderListItem = this.mTransDetails;
        if (orderListItem == null || TextUtils.isEmpty(orderListItem.getUserPhoneNo())) {
            str = "";
        } else {
            str = APSharedPreferences.getInstance().isMerchantMigrated() ? this.mTransDetails.getUserPhoneNo() : AppUtility.getMaskedMobileNumber(this.mTransDetails.getUserPhoneNo());
            this.isMobileVisibile.set(true);
        }
        if (TextUtils.isEmpty(str)) {
            this.isMobileVisibile.set(false);
        }
        return str;
    }

    public String getPrice(String str) {
        if (str.contains(AppUtility.CENTER_DOT)) {
            return str;
        }
        return str.concat(".00");
    }

    public String getRefundDate() {
        String str = this.inDate;
        if (str == null || TextUtils.isEmpty(str)) {
            return "";
        }
        String[] split = this.inDate.split(" ");
        String str2 = split[1];
        return this.mContext.getResources().getString(R.string.mp_on) + " " + (DateUtility.getFormattedDate(split[0], "dd/MM/yyyy", "dd MMM yyyy") + ", " + DateUtility.getFormattedDate(str2, "HH:mm:ss", "hh:mm a"));
    }

    public String getTxnId() {
        OrderListItem orderListItem = this.mTransDetails;
        if (orderListItem != null && !TextUtils.isEmpty(orderListItem.getOrderId())) {
            this.mTxnId = this.mTransDetails.getOrderId();
        }
        return this.mTxnId;
    }

    public String getFailReason() {
        InitiateRefundResponseModel initiateRefundResponseModel = this.mResponseModel;
        if (!(initiateRefundResponseModel == null || initiateRefundResponseModel.getStatusMessage() == null || TextUtils.isEmpty(this.mResponseModel.getStatusMessage()))) {
            this.failReason = " " + this.mResponseModel.getStatusMessage();
        }
        return this.failReason;
    }

    public String getRefundId() {
        InitiateRefundResponseModel initiateRefundResponseModel = this.mResponseModel;
        String refundTxnGuid = (initiateRefundResponseModel == null || initiateRefundResponseModel.getResponse() == null || this.mResponseModel.getResponse().getRefundTxnGuid() == null) ? null : this.mResponseModel.getResponse().getRefundTxnGuid();
        if (refundTxnGuid == null) {
            this.isRefIDVisibile.set(false);
        } else {
            this.isRefIDVisibile.set(true);
        }
        return refundTxnGuid;
    }

    public String getUserComments() {
        return this.mUserComments;
    }

    public String displayFormat(String str) {
        return getContext().getString(R.string.mp_rupee_symbol) + AppUtility.formatNumber(str, AppConstants.PRICE_PATTERN);
    }
}
