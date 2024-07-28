package com.business.merchant_payments.payment.viewmodel;

import android.app.Application;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.webkit.URLUtil;
import androidx.arch.core.c.a;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.i;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ah;
import androidx.lifecycle.y;
import com.business.common_module.utilities.a.b;
import com.business.common_module.utilities.a.c;
import com.business.common_module.utilities.a.d;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.R;
import com.business.merchant_payments.collection.model.CollectionRepository;
import com.business.merchant_payments.common.utility.APSharedPreferences;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.AppUtility;
import com.business.merchant_payments.common.utility.DateUtility;
import com.business.merchant_payments.common.utility.GTMDataProviderImpl;
import com.business.merchant_payments.common.utility.RequestParamUtil;
import com.business.merchant_payments.model.businesswallet.OrdersItem;
import com.business.merchant_payments.model.lastcollectedpaymentmodel.OfflineTransDetailObject;
import com.business.merchant_payments.model.lastcollectedpaymentmodel.OrderDetailItem;
import com.business.merchant_payments.model.lastcollectedpaymentmodel.OrderListItem;
import com.business.merchant_payments.model.v2.OrderDetailV2Model;
import com.business.merchant_payments.payment.view.OnlineTxnDetailsActivity;
import com.business.merchant_payments.utility.StringUtility;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class OnlineTxnDetailsViewModel extends c {
    public i<String> GST;
    public i<String> accNo;
    public i<String> amount;
    public ObservableInt amountColor;
    public final y<Boolean> apiFlag = new y<>();
    public i<String> bankIconUrl;
    public i<String> comment;
    public i<String> commision;
    public i<String> commissionText;
    public i<String> custEmail;
    public i<String> customerName;
    public i<String> dateText;
    public i<Spannable> description;
    public ObservableBoolean dottedProgressBarVisibility = new ObservableBoolean();
    public i<String> ifscCode;
    public i<String> incentiveAmt;
    public ObservableBoolean inclVisibility;
    public ObservableBoolean isBankNameVisible;
    public ObservableBoolean isCardNoAvailable;
    public ObservableBoolean isCashWithdrawalIncentive;
    public ObservableBoolean isCommisionPaidByUser;
    public ObservableBoolean isDirectSettlementVisible;
    public ObservableBoolean isEmailAvailable;
    public ObservableBoolean isGstPaidByUser;
    public ObservableBoolean isMobileAvailable = new ObservableBoolean();
    public ObservableBoolean isPCFTransaction;
    public ObservableBoolean isPayDescriptionVisible = new ObservableBoolean(false);
    public ObservableBoolean isPayDetailsVisible = new ObservableBoolean(false);
    public ObservableBoolean isRefund = new ObservableBoolean(!PaymentsConfig.getInstance().getMerchantDataProvider().g());
    public ObservableBoolean isRefundNeededForNonMigrated;
    public ObservableBoolean isRefundable;
    public i<String> mBizOrderId;
    public final LiveData<b<OfflineTransDetailObject>> mObservableOfflineResponse = ah.b(this.offlineApiFlag, new a() {
        public final Object apply(Object obj) {
            return OnlineTxnDetailsViewModel.this.lambda$new$2$OnlineTxnDetailsViewModel((Boolean) obj);
        }
    });
    public final LiveData<b<OrderDetailV2Model>> mObservableV2Response = ah.b(this.v2Flag, new a() {
        public final Object apply(Object obj) {
            return OnlineTxnDetailsViewModel.this.lambda$new$1$OnlineTxnDetailsViewModel((Boolean) obj);
        }
    });
    public final LiveData<b<OrderDetailItem>> mObservalbleResponse = ah.b(this.apiFlag, new a() {
        public final Object apply(Object obj) {
            return OnlineTxnDetailsViewModel.this.lambda$new$0$OnlineTxnDetailsViewModel((Boolean) obj);
        }
    });
    public i<String> netTotal;
    public final y<Boolean> offlineApiFlag = new y<>();
    public OfflineTransDetailObject offlineResponseObject;
    public i<String> orderId;
    public OrderListItem orderListItem;
    public i<String> payMethodIconUrl;
    public i<String> payMode;
    public i<String> payModeDetailLabel;
    public i<String> payModeDetailText;
    public i<String> receivedForText;
    public i<String> receivedFrom;
    public OrderDetailItem responseItem;
    public int retryCount = 0;
    public y<Boolean> setStartToEndForBarrier = new y<>();
    public i<String> settlementDate;
    public ObservableBoolean settlementVisibility;
    public d<String> showSnackBarMessage;
    public i<String> totalPaymentCollected;
    public String transactionAMount;
    public i<Drawable> transactionStatusImage;
    public i<String> transactionType;
    public i<String> txnId;
    public i<String> utr;
    public i<Spannable> utrNo;
    public final y<Boolean> v2Flag = new y<>();
    public String vpa;
    public i<Integer> warningVisibility;
    public String whiteSpace = " ";

    public OnlineTxnDetailsViewModel(Application application) {
        super(application);
    }

    public /* synthetic */ LiveData lambda$new$0$OnlineTxnDetailsViewModel(Boolean bool) {
        if (bool.booleanValue()) {
            return callOrderDetail();
        }
        return new com.business.common_module.utilities.a.a();
    }

    public /* synthetic */ LiveData lambda$new$1$OnlineTxnDetailsViewModel(Boolean bool) {
        if (bool.booleanValue()) {
            return callV2Details();
        }
        return new com.business.common_module.utilities.a.a();
    }

    public /* synthetic */ LiveData lambda$new$2$OnlineTxnDetailsViewModel(Boolean bool) {
        if (bool.booleanValue()) {
            return callOfflineOrderDetail();
        }
        return new com.business.common_module.utilities.a.a();
    }

    public LiveData<b<OrderDetailV2Model>> getmObservableV2Response() {
        return this.mObservableV2Response;
    }

    public LiveData<String> snackBarCmd() {
        return this.showSnackBarMessage;
    }

    private LiveData<b<OrderDetailV2Model>> callV2Details() {
        if (!com.business.common_module.utilities.i.a(PaymentsConfig.getInstance().getApplication())) {
            this.inclVisibility.set(true);
            this.showSnackBarMessage.setValue(PaymentsConfig.getInstance().getAppContext().getString(R.string.mp_no_internet_connection));
            return new com.business.common_module.utilities.a.a();
        }
        String v3OrderDetail = GTMDataProviderImpl.Companion.getMInstance().getV3OrderDetail();
        if (!URLUtil.isValidUrl(v3OrderDetail)) {
            return new com.business.common_module.utilities.a.a();
        }
        this.dottedProgressBarVisibility.set(true);
        return CollectionRepository.getInstance().getV2OrderDetails(v3OrderDetail, RequestParamUtil.getRequestHeaderMidParam(PaymentsConfig.getInstance().getAppContext()), getBodyParamsCommission());
    }

    private String getBodyParamsCommission() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("bizOrderId", this.txnId.get());
            jSONObject.put("isSettlementInfo", true);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    private LiveData<b<OfflineTransDetailObject>> callOfflineOrderDetail() {
        if (!com.business.common_module.utilities.i.a(PaymentsConfig.getInstance().getApplication())) {
            this.inclVisibility.set(true);
            this.showSnackBarMessage.setValue(PaymentsConfig.getInstance().getAppContext().getString(R.string.mp_no_internet_connection));
            return new com.business.common_module.utilities.a.a();
        }
        String offlineOrderDetailAPI = GTMDataProviderImpl.Companion.getMInstance().getOfflineOrderDetailAPI();
        if (!URLUtil.isValidUrl(offlineOrderDetailAPI)) {
            return new com.business.common_module.utilities.a.a();
        }
        this.dottedProgressBarVisibility.set(true);
        return CollectionRepository.getInstance().getOfflineOrderDetail(offlineOrderDetailAPI, RequestParamUtil.getHeaders(this.mAppInstance.getApplicationContext()), addOfflineURLParams());
    }

    public void setData(OrderListItem orderListItem2) {
        this.orderListItem = orderListItem2;
        this.txnId.set(orderListItem2.getTxnId());
        this.transactionAMount = getContext().getString(R.string.mp_rupee_symbol) + this.orderListItem.getTxnAmt();
        if (orderListItem2.getIncentiveAmt() != null && !orderListItem2.getIncentiveAmt().isEmpty()) {
            i<String> iVar = this.incentiveAmt;
            iVar.set(getContext().getString(R.string.mp_rupee_symbol) + " " + AppUtility.formatNumber(String.valueOf(Double.parseDouble(orderListItem2.getIncentiveAmt()) / 100.0d), AppConstants.PRICE_PATTERN));
            this.isRefund.set(true);
        }
        if (orderListItem2.getProductCode() != null && !orderListItem2.getProductCode().isEmpty()) {
            if (orderListItem2.getProductCode().equalsIgnoreCase(OnlineTxnDetailsActivity.CASH_WITHDRAWAL_INCENTIVE_TXN)) {
                this.isRefund.set(true);
                this.transactionType.set(getContext().getResources().getString(R.string.mp_cash_at_pos_incentive));
            } else if (orderListItem2.getProductCode().equalsIgnoreCase(OnlineTxnDetailsActivity.CASH_WITHDRAWAL_TXN)) {
                this.transactionType.set(getContext().getResources().getString(R.string.mp_cash_withdrawal));
            }
        }
        this.vpa = orderListItem2.getUserVPA();
        if (!TextUtils.isEmpty(orderListItem2.getUserPhoneNo())) {
            i<String> iVar2 = this.receivedFrom;
            boolean isMerchantMigrated = APSharedPreferences.getInstance().isMerchantMigrated();
            String userPhoneNo = orderListItem2.getUserPhoneNo();
            if (!isMerchantMigrated) {
                userPhoneNo = AppUtility.getMaskedMobileNumber(userPhoneNo);
            }
            iVar2.set(userPhoneNo);
            this.isMobileAvailable.set(true);
        }
        if (this.orderListItem.getOrderCreatedTime() != null) {
            this.dateText.set(DateUtility.getFormattedDate(this.orderListItem.getOrderCreatedTime(), "yyyy-MM-dd HH:mm:ss", "dd MMM yyyy, hh:mm a").replace("AM", "am").replace("PM", "pm"));
        }
        if (!TextUtils.isEmpty(this.orderListItem.getOrderType()) && ((AppConstants.ApiNames.MERCHANT_TO_PAYER_REFUND.equalsIgnoreCase(this.orderListItem.getOrderType()) || AppConstants.ApiNames.Refund_Report.equalsIgnoreCase(this.orderListItem.getOrderType()) || "REFUND".equalsIgnoreCase(this.orderListItem.getOrderType())) && !PaymentsConfig.getInstance().getMerchantDataProvider().g())) {
            this.isRefund.set(true);
        }
        setOrderStatusData(this.orderListItem.getOrderStatus());
    }

    public void setData(OrdersItem ordersItem) {
        if (!PaymentsConfig.getInstance().getMerchantDataProvider().g()) {
            this.isRefund.set(true);
        }
        this.txnId.set(ordersItem.getTxnId());
        this.transactionAMount = getContext().getString(R.string.mp_rupee_symbol) + ordersItem.getTxnAmt();
        this.vpa = ordersItem.getUserVPA();
        if (!TextUtils.isEmpty(ordersItem.getUserPhoneNo())) {
            this.receivedFrom.set(AppUtility.getMaskedMobileNumber(ordersItem.getUserPhoneNo()));
            this.isMobileAvailable.set(true);
        }
        this.dateText.set(DateUtility.getFormattedDate(ordersItem.getOrderCreatedTime(), "yyyy-MM-dd HH:mm:ss", "dd MMM yyyy, hh:mm a").replace("AM", "am").replace("PM", "pm"));
        setOrderStatusData(ordersItem.getOrderStatus());
    }

    public String getAmount() {
        String str = this.transactionAMount;
        return str != null ? str : "";
    }

    public void initDefaultParams() {
        this.isDirectSettlementVisible = new ObservableBoolean(false);
        this.inclVisibility = new ObservableBoolean(false);
        this.settlementVisibility = new ObservableBoolean(false);
        this.isCashWithdrawalIncentive = new ObservableBoolean(false);
        this.amount = new i<>();
        this.dateText = new i<>();
        this.orderId = new i<>();
        this.payMode = new i<>();
        this.description = new i<>();
        this.comment = new i<>();
        this.transactionType = new i<>();
        this.receivedForText = new i<>();
        this.custEmail = new i<>();
        this.isEmailAvailable = new ObservableBoolean(false);
        this.settlementDate = new i<>();
        this.utr = new i<>();
        this.utrNo = new i<>();
        this.totalPaymentCollected = new i<>();
        this.commision = new i<>();
        this.GST = new i<>();
        this.netTotal = new i<>();
        this.incentiveAmt = new i<>();
        this.isRefundable = new ObservableBoolean(false);
        this.receivedFrom = new i<>();
        this.payModeDetailLabel = new i<>();
        this.payModeDetailText = new i<>();
        this.showSnackBarMessage = new d<>();
        this.warningVisibility = new i<>(8);
        this.amountColor = new ObservableInt(androidx.core.content.b.c(getContext(), R.color.color_00c673));
        this.transactionStatusImage = new i<>(androidx.core.content.b.a(getContext(), R.drawable.mp_ic_success_new));
        this.mBizOrderId = new i<>("");
        this.commissionText = new i<>("");
        this.txnId = new i<>("");
        this.isPCFTransaction = new ObservableBoolean(false);
        this.isCardNoAvailable = new ObservableBoolean(false);
        this.isCommisionPaidByUser = new ObservableBoolean(false);
        this.isGstPaidByUser = new ObservableBoolean(false);
        this.isRefundNeededForNonMigrated = new ObservableBoolean(false);
        this.payMethodIconUrl = new i<>();
        this.bankIconUrl = new i<>();
        this.accNo = new i<>();
        this.ifscCode = new i<>();
        this.customerName = new i<>();
    }

    private LiveData<b<OrderDetailItem>> callOrderDetail() {
        if (!com.business.common_module.utilities.i.a(PaymentsConfig.getInstance().getApplication())) {
            this.inclVisibility.set(true);
            this.showSnackBarMessage.setValue(PaymentsConfig.getInstance().getAppContext().getString(R.string.mp_no_internet_connection));
            return new com.business.common_module.utilities.a.a();
        }
        String onlineOrderDetailAPI = GTMDataProviderImpl.Companion.getMInstance().getOnlineOrderDetailAPI();
        if (!URLUtil.isValidUrl(onlineOrderDetailAPI)) {
            return new com.business.common_module.utilities.a.a();
        }
        this.dottedProgressBarVisibility.set(true);
        return CollectionRepository.getInstance().getOnlineOrderDetail(onlineOrderDetailAPI, RequestParamUtil.getHeaders(this.mAppInstance.getApplicationContext()), addAggregateURLParams());
    }

    private Map<String, String> addAggregateURLParams() {
        HashMap hashMap = new HashMap();
        hashMap.put(AppConstants.KEY_SEARCH_BY, "txnId");
        hashMap.put(AppConstants.KEY_SEARCH_VALUE, this.txnId.get());
        return hashMap;
    }

    private Map<String, String> addOfflineURLParams() {
        HashMap hashMap = new HashMap();
        hashMap.put(AppConstants.KEY_SEARCH_BY, "TXN_ID");
        hashMap.put(AppConstants.KEY_SEARCH_VALUE, this.txnId.get());
        return hashMap;
    }

    public void setApiFlag() {
        boolean isMerchantMigrated = APSharedPreferences.getInstance().isMerchantMigrated();
        boolean q = PaymentsConfig.getInstance().getMerchantDataProvider().q();
        boolean r = PaymentsConfig.getInstance().getMerchantDataProvider().r();
        if (isMerchantMigrated) {
            this.v2Flag.setValue(Boolean.TRUE);
            return;
        }
        this.setStartToEndForBarrier.setValue(Boolean.TRUE);
        if (q || r) {
            this.apiFlag.setValue(Boolean.TRUE);
        } else {
            this.offlineApiFlag.setValue(Boolean.TRUE);
        }
    }

    public LiveData<b<OrderDetailItem>> getmObservalbleResponse() {
        return this.mObservalbleResponse;
    }

    public LiveData<b<OfflineTransDetailObject>> getmObservableOfflineResponse() {
        return this.mObservableOfflineResponse;
    }

    public void setProgress(boolean z) {
        this.dottedProgressBarVisibility.set(z);
    }

    public void setUtrNo(String str) {
        this.utr.set(str);
        this.utrNo.set(new SpannableString(str));
        this.settlementVisibility.set(true);
    }

    public void setOrderData(OrderDetailItem orderDetailItem) {
        this.responseItem = orderDetailItem;
        if (orderDetailItem != null) {
            if (!TextUtils.isEmpty(orderDetailItem.getUtrNo())) {
                setUtrNo(this.responseItem.getUtrNo());
            } else {
                this.settlementVisibility.set(false);
            }
            if (!TextUtils.isEmpty(this.responseItem.getTxnAmt())) {
                i<String> iVar = this.totalPaymentCollected;
                iVar.set(getContext().getString(R.string.mp_rupee_symbol) + " " + this.responseItem.getTxnAmt());
            }
            if (!TextUtils.isEmpty(this.responseItem.getCommission())) {
                i<String> iVar2 = this.commision;
                iVar2.set("- " + getContext().getString(R.string.mp_rupee_symbol) + " " + this.responseItem.getCommission());
            } else {
                this.commision.set("-");
            }
            if (!TextUtils.isEmpty(this.responseItem.getsTax())) {
                i<String> iVar3 = this.GST;
                iVar3.set("- " + getContext().getString(R.string.mp_rupee_symbol) + " " + this.responseItem.getsTax());
            }
            if (!TextUtils.isEmpty(this.responseItem.getSettledAmt())) {
                i<String> iVar4 = this.netTotal;
                iVar4.set(getContext().getString(R.string.mp_rupee_symbol) + " " + this.responseItem.getSettledAmt());
            }
            if (!TextUtils.isEmpty(this.responseItem.getSettledDate())) {
                this.settlementDate.set(DateUtility.getFormattedDate(this.responseItem.getSettledDate(), "yyyy-MM-dd HH:mm:ss", "dd MMM yyyy"));
                OrderListItem orderListItem2 = this.orderListItem;
                if (orderListItem2 != null) {
                    orderListItem2.setSettlementDate(this.settlementDate.get());
                }
            } else {
                this.settlementDate.set("-");
            }
            OrderListItem orderListItem3 = this.orderListItem;
            if (orderListItem3 == null || TextUtils.isEmpty(orderListItem3.getUserEmail())) {
                this.isEmailAvailable.set(false);
                this.custEmail.set("-");
            } else {
                this.custEmail.set(AppUtility.getMaskedUPI_Email(this.orderListItem.getUserEmail()));
                this.isEmailAvailable.set(true);
                OrderListItem orderListItem4 = this.orderListItem;
                orderListItem4.setCustomerEmailId(orderListItem4.getUserEmail());
            }
            if (!TextUtils.isEmpty(this.responseItem.getOrderId())) {
                this.orderId.set(this.responseItem.getOrderId());
            }
            if (!TextUtils.isEmpty(this.responseItem.getPaymentMode())) {
                this.payMode.set(AppUtility.getPayModeLocalised(getContext(), this.responseItem.getPaymentMode()));
            } else {
                this.payMode.set("-");
            }
            pcfCaseHandlingForNonMigrated(orderDetailItem);
        }
    }

    private void pcfCaseHandlingForNonMigrated(OrderDetailItem orderDetailItem) {
        if (orderDetailItem.isPostConv()) {
            this.settlementVisibility.set(true);
            this.isPCFTransaction.set(true);
            this.netTotal.set(this.totalPaymentCollected.get());
            this.isRefundNeededForNonMigrated.set(orderDetailItem.isConvFeeVO());
            this.isCommisionPaidByUser.set(true);
            this.isGstPaidByUser.set(true);
            return;
        }
        this.isPCFTransaction.set(false);
        this.isGstPaidByUser.set(false);
    }

    public void setOfflineObject(OfflineTransDetailObject offlineTransDetailObject) {
        this.offlineResponseObject = offlineTransDetailObject;
        setData(transformToOrderList(offlineTransDetailObject));
        OfflineTransDetailObject offlineTransDetailObject2 = this.offlineResponseObject;
        if (offlineTransDetailObject2 != null) {
            if (!TextUtils.isEmpty(offlineTransDetailObject2.getmUTRNumber())) {
                setUtrNo(this.offlineResponseObject.getmUTRNumber());
            } else {
                this.settlementVisibility.set(false);
            }
            if (!TextUtils.isEmpty(this.offlineResponseObject.getmTransactionAmmount())) {
                i<String> iVar = this.totalPaymentCollected;
                iVar.set(getContext().getString(R.string.mp_rupee_symbol) + " " + this.offlineResponseObject.getmTransactionAmmount());
            }
            if (!TextUtils.isEmpty(this.offlineResponseObject.getmCommissionAmmount())) {
                i<String> iVar2 = this.commision;
                iVar2.set("- " + getContext().getString(R.string.mp_rupee_symbol) + " " + this.offlineResponseObject.getmCommissionAmmount());
            } else {
                this.commision.set("-");
            }
            if (!TextUtils.isEmpty(this.offlineResponseObject.getmServiceTax())) {
                i<String> iVar3 = this.GST;
                iVar3.set("- " + getContext().getString(R.string.mp_rupee_symbol) + " " + this.offlineResponseObject.getmServiceTax());
            }
            if (!TextUtils.isEmpty(this.offlineResponseObject.getmSettlementAmmount())) {
                String.valueOf(AppUtility.formatDecimalIntegerNumber(Double.parseDouble(this.offlineResponseObject.getmSettlementAmmount()), AppConstants.PRICE_PATTERN));
                i<String> iVar4 = this.netTotal;
                iVar4.set(getContext().getString(R.string.mp_rupee_symbol) + " " + Double.parseDouble(this.offlineResponseObject.getmSettlementAmmount()));
            }
            if (!TextUtils.isEmpty(this.offlineResponseObject.getmMerchantOrderID())) {
                this.orderId.set(this.offlineResponseObject.getmMerchantOrderID());
            } else {
                this.orderId.set("-");
            }
            if (!TextUtils.isEmpty(this.offlineResponseObject.getmPaymentMode())) {
                this.payMode.set(AppUtility.getPayModeLocalised(getContext(), this.offlineResponseObject.getmPaymentMode()));
            } else {
                this.payMode.set("-");
            }
            OrderListItem orderListItem2 = this.orderListItem;
            if (orderListItem2 == null || TextUtils.isEmpty(orderListItem2.getUserEmail())) {
                this.isEmailAvailable.set(false);
                this.custEmail.set("-");
            } else {
                this.custEmail.set(AppUtility.getMaskedUPI_Email(this.orderListItem.getUserEmail()));
                this.isEmailAvailable.set(true);
            }
            this.isGstPaidByUser.set(false);
        }
    }

    public void setV2Object(OrderDetailV2Model orderDetailV2Model) {
        int i2;
        boolean z;
        setData(transformToOrderList(orderDetailV2Model));
        if (orderDetailV2Model.getPayMoneyAmount() == null || TextUtils.isEmpty(orderDetailV2Model.getPayMoneyAmount().getValue())) {
            i2 = 0;
        } else {
            i<String> iVar = this.totalPaymentCollected;
            iVar.set(getContext().getString(R.string.mp_rupee_symbol) + " " + AppUtility.formatNumber(String.valueOf(Double.parseDouble(orderDetailV2Model.getPayMoneyAmount().getValue()) / 100.0d), AppConstants.PRICE_PATTERN));
            i2 = 1;
        }
        if (orderDetailV2Model.getCommission() != null && !TextUtils.isEmpty(orderDetailV2Model.getCommission().getValue())) {
            if (orderDetailV2Model.isFeeOnHold()) {
                this.commision.set(PaymentsConfig.getInstance().getAppContext().getString(R.string.mp_not_applicable));
            } else {
                i<String> iVar2 = this.commision;
                iVar2.set("- " + getContext().getString(R.string.mp_rupee_symbol) + " " + AppUtility.formatNumber(String.valueOf(Double.parseDouble(orderDetailV2Model.getCommission().getValue()) / 100.0d), AppConstants.PRICE_PATTERN));
            }
            i2++;
        } else if (AppUtility.isDirectSettlement(orderDetailV2Model.getTxnSettleType())) {
            i<String> iVar3 = this.commision;
            iVar3.set(getContext().getString(R.string.mp_rupee_symbol) + AppUtility.formatNumber("0", AppConstants.PRICE_PATTERN));
        } else {
            this.commision.set("-");
        }
        if (this.orderListItem.getProductCode().equalsIgnoreCase(OnlineTxnDetailsActivity.CASH_WITHDRAWAL_INCENTIVE_TXN)) {
            this.isCashWithdrawalIncentive.set(true);
        }
        if (this.isCashWithdrawalIncentive.get() && orderDetailV2Model.getAdditionalInfo() != null && orderDetailV2Model.getAdditionalInfo().getParentOrderAmount() != null && !TextUtils.isEmpty(orderDetailV2Model.getAdditionalInfo().getParentOrderAmount().getValue())) {
            i<String> iVar4 = this.receivedForText;
            iVar4.set(getContext().getString(R.string.mp_received_for_cash_withdrawal) + " " + getContext().getString(R.string.mp_rupee_symbol) + AppUtility.formatNumber(String.valueOf(Double.parseDouble(orderDetailV2Model.getAdditionalInfo().getParentOrderAmount().getValue()) / 100.0d), AppConstants.PRICE_PATTERN) + " " + getContext().getString(R.string.mp_on_sc) + " " + this.dateText.get());
        }
        if (orderDetailV2Model.getCommissionTax() != null && !TextUtils.isEmpty(orderDetailV2Model.getCommissionTax().getValue())) {
            if (orderDetailV2Model.isFeeOnHold()) {
                this.GST.set(PaymentsConfig.getInstance().getAppContext().getString(R.string.mp_not_applicable));
            } else {
                i<String> iVar5 = this.GST;
                iVar5.set("- " + getContext().getString(R.string.mp_rupee_symbol) + " " + AppUtility.formatNumber(String.valueOf(Double.parseDouble(orderDetailV2Model.getCommissionTax().getValue()) / 100.0d), AppConstants.PRICE_PATTERN));
            }
            i2++;
        } else if (AppUtility.isDirectSettlement(orderDetailV2Model.getTxnSettleType())) {
            i<String> iVar6 = this.GST;
            iVar6.set(getContext().getString(R.string.mp_rupee_symbol) + AppUtility.formatNumber("0", AppConstants.PRICE_PATTERN));
        }
        if (i2 == 3) {
            double parseDouble = Double.parseDouble(orderDetailV2Model.getPayMoneyAmount().getValue());
            if (!orderDetailV2Model.isFeeOnHold()) {
                parseDouble -= Double.parseDouble(orderDetailV2Model.getCommission().getValue()) + Double.parseDouble(orderDetailV2Model.getCommissionTax().getValue());
            }
            i<String> iVar7 = this.netTotal;
            iVar7.set(getContext().getString(R.string.mp_rupee_symbol) + " " + AppUtility.formatNumber(String.valueOf(parseDouble / 100.0d), AppConstants.PRICE_PATTERN));
        } else if (AppUtility.isDirectSettlement(orderDetailV2Model.getTxnSettleType())) {
            this.netTotal.set(this.totalPaymentCollected.get());
        }
        if (!TextUtils.isEmpty(orderDetailV2Model.getMerchantTransId())) {
            this.orderId.set(orderDetailV2Model.getMerchantTransId());
        } else {
            this.orderId.set("-");
        }
        if (orderDetailV2Model.getSettlementInfoList() == null || orderDetailV2Model.getSettlementInfoList().size() <= 0 || orderDetailV2Model.getSettlementInfoList().get(0).getUtrNoList() == null || orderDetailV2Model.getSettlementInfoList().get(0).getUtrNoList().size() <= 0 || TextUtils.isEmpty(orderDetailV2Model.getSettlementInfoList().get(0).getUtrNoList().get(0))) {
            this.utr.set("-");
            this.utrNo.set(new SpannableString("-"));
            z = false;
        } else {
            setUtrNo(orderDetailV2Model.getSettlementInfoList().get(0).getUtrNoList().get(0));
            z = true;
        }
        if (orderDetailV2Model.getSettlementInfoList() != null && !orderDetailV2Model.getSettlementInfoList().isEmpty()) {
            String settlementTime = orderDetailV2Model.getSettlementInfoList().get(0).getSettlementTime();
            if (!TextUtils.isEmpty(settlementTime)) {
                this.settlementDate.set(DateUtility.getFormattedDate(settlementTime.split("\\+")[0], "yyyy-MM-dd'T'HH:mm:ss", "dd MMM yyyy"));
            }
        }
        if (!TextUtils.isEmpty(orderDetailV2Model.getBizOrderId())) {
            this.mBizOrderId.set(orderDetailV2Model.getBizOrderId());
        }
        setPayModeDetails(orderDetailV2Model);
        if (!TextUtils.isEmpty(orderDetailV2Model.getOppositeEmail())) {
            this.custEmail.set(orderDetailV2Model.getOppositeEmail());
            this.isEmailAvailable.set(true);
        } else if (orderDetailV2Model.getAdditionalInfo() == null || TextUtils.isEmpty(orderDetailV2Model.getAdditionalInfo().getUserEmail())) {
            this.isEmailAvailable.set(false);
            this.custEmail.set("-");
        } else {
            this.custEmail.set(orderDetailV2Model.getAdditionalInfo().getUserEmail());
            this.isEmailAvailable.set(true);
        }
        if (!TextUtils.isEmpty(orderDetailV2Model.getOppositePhone())) {
            this.receivedFrom.set(orderDetailV2Model.getOppositePhone());
            this.isMobileAvailable.set(true);
        } else if (orderDetailV2Model.getAdditionalInfo() != null && !TextUtils.isEmpty(orderDetailV2Model.getAdditionalInfo().getUserMobile())) {
            this.receivedFrom.set(orderDetailV2Model.getAdditionalInfo().getUserMobile());
            this.isMobileAvailable.set(true);
        }
        if (orderDetailV2Model.getAdditionalInfo() != null && !TextUtils.isEmpty(orderDetailV2Model.getAdditionalInfo().getCustomerName())) {
            this.customerName.set(AppUtility.removeNullFromString(orderDetailV2Model.getAdditionalInfo().getCustomerName()));
        }
        if (z || AppUtility.isDirectSettlement(orderDetailV2Model.getTxnSettleType())) {
            this.settlementVisibility.set(true);
        } else {
            this.settlementVisibility.set(false);
        }
        pcfCaseHandlingForMigrated(orderDetailV2Model);
        setDirectSettlementViewVisibility(orderDetailV2Model.getTxnSettleType());
    }

    private void setDirectSettlementViewVisibility(String str) {
        if (AppUtility.isDirectSettlement(str)) {
            this.isDirectSettlementVisible.set(true);
        } else {
            this.isDirectSettlementVisible.set(false);
        }
    }

    private void pcfCaseHandlingForMigrated(OrderDetailV2Model orderDetailV2Model) {
        if (orderDetailV2Model.getPcfee() == null || orderDetailV2Model.getPcTax() == null) {
            this.isPCFTransaction.set(false);
        } else {
            this.settlementVisibility.set(true);
            this.isPCFTransaction.set(true);
            this.netTotal.set(this.totalPaymentCollected.get());
        }
        setCommission(orderDetailV2Model);
        setGst(orderDetailV2Model);
    }

    private void setPayModeDetails(OrderDetailV2Model orderDetailV2Model) {
        if (orderDetailV2Model.getAdditionalInfo() != null) {
            setOrderStatusData(orderDetailV2Model.getOrderStatus());
            String payMethod = orderDetailV2Model.getAdditionalInfo().getPayMethod();
            if (!TextUtils.isEmpty(payMethod)) {
                this.payMode.set(payMethod);
                String upperCase = payMethod.toUpperCase();
                char c2 = 65535;
                switch (upperCase.hashCode()) {
                    case -1515067795:
                        if (upperCase.equals(AppConstants.CASH_WITHDRAWAL_INCENTIVE)) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case -1265803326:
                        if (upperCase.equals(AppConstants.CASH_WITHDRAWAL)) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 68769:
                        if (upperCase.equals("EMI")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case 84238:
                        if (upperCase.equals("UPI")) {
                            c2 = 7;
                            break;
                        }
                        break;
                    case 1222764004:
                        if (upperCase.equals(AppConstants.DEBIT_CARD)) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 1820538839:
                        if (upperCase.equals(AppConstants.CREDIT_CARD)) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 2048730175:
                        if (upperCase.equals(AppConstants.EMI_CC)) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case 2048730206:
                        if (upperCase.equals(AppConstants.EMI_DC)) {
                            c2 = 6;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        this.isCardNoAvailable.set(true);
                        String maskedCardNo = orderDetailV2Model.getAdditionalInfo().getMaskedCardNo();
                        if (!TextUtils.isEmpty(maskedCardNo)) {
                            this.payModeDetailText.set(maskedCardNo);
                            this.isPayDetailsVisible.set(true);
                            break;
                        }
                        break;
                    case 7:
                        this.isCardNoAvailable.set(false);
                        if (!TextUtils.isEmpty(orderDetailV2Model.getAdditionalInfo().getVirtualPaymentAddr())) {
                            this.isPayDetailsVisible.set(true);
                            String virtualPaymentAddr = orderDetailV2Model.getAdditionalInfo().getVirtualPaymentAddr();
                            this.vpa = virtualPaymentAddr;
                            this.payModeDetailText.set(virtualPaymentAddr);
                            break;
                        }
                        break;
                }
            }
            if (!TextUtils.isEmpty(orderDetailV2Model.getAdditionalInfo().getComment())) {
                setPaymentDescription(orderDetailV2Model);
            }
            if (!TextUtils.isEmpty(orderDetailV2Model.getAdditionalInfo().getPayMethodIconUrl())) {
                this.payMethodIconUrl.set(orderDetailV2Model.getAdditionalInfo().getPayMethodIconUrl());
            } else {
                this.setStartToEndForBarrier.setValue(Boolean.TRUE);
            }
            if (!TextUtils.isEmpty(orderDetailV2Model.getAdditionalInfo().getReceiverBankName())) {
                this.accNo.set(orderDetailV2Model.getAdditionalInfo().getReceiverBankName());
            }
            if (!TextUtils.isEmpty(orderDetailV2Model.getAdditionalInfo().getReceiverIfscCode())) {
                this.ifscCode.set(orderDetailV2Model.getAdditionalInfo().getReceiverIfscCode());
            }
            if (!TextUtils.isEmpty(orderDetailV2Model.getAdditionalInfo().getBankIconUrl())) {
                this.bankIconUrl.set(orderDetailV2Model.getAdditionalInfo().getBankIconUrl());
            }
        }
    }

    public void setPaymentDescription(OrderDetailV2Model orderDetailV2Model) {
        if (TextUtils.isEmpty(this.vpa) || !this.vpa.toLowerCase().endsWith("@ybl")) {
            String comment2 = orderDetailV2Model.getAdditionalInfo().getComment();
            this.comment.set(comment2);
            SpannableString spannableString = new SpannableString(comment2);
            this.description.set(spannableString);
            if (comment2.length() > 10) {
                spannableString = new SpannableString(comment2.substring(0, 10) + " ...");
                spannableString.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(getContext(), R.color.color_00B9F5)), 10, 14, 17);
            }
            this.description.set(spannableString);
            this.isPayDescriptionVisible.set(true);
        }
    }

    private void setOrderStatusData(String str) {
        if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase(AppConstants.TRANSACTION_STATUS_CLIENT_PENDING)) {
            this.warningVisibility.set(0);
            this.amountColor.set(androidx.core.content.b.c(getContext(), R.color.orange));
            this.transactionStatusImage.set(androidx.core.content.b.a(getContext(), R.drawable.mp_ic_status_pending));
        }
    }

    private void setCommission(OrderDetailV2Model orderDetailV2Model) {
        if (this.isPCFTransaction.get()) {
            this.isCommisionPaidByUser.set(true);
            this.commision.set(String.format("%s %s", new Object[]{getContext().getString(R.string.mp_rupee_symbol), StringUtility.formatNumber(getContext(), orderDetailV2Model.getPcfee().getValue(), AppConstants.PRICE_PATTERN)}));
        }
    }

    private void setGst(OrderDetailV2Model orderDetailV2Model) {
        if (this.isPCFTransaction.get()) {
            this.isGstPaidByUser.set(true);
            this.GST.set(String.format("%s %s", new Object[]{getContext().getString(R.string.mp_rupee_symbol), StringUtility.formatNumber(getContext(), orderDetailV2Model.getPcTax().getValue(), AppConstants.PRICE_PATTERN)}));
            return;
        }
        this.isGstPaidByUser.set(false);
    }

    private OrderListItem transformToOrderList(OrderDetailV2Model orderDetailV2Model) {
        OrderListItem orderListItem2 = new OrderListItem();
        orderListItem2.setmTxnId(orderDetailV2Model.getBizOrderId());
        orderListItem2.setmOrderId(orderDetailV2Model.getMerchantTransId());
        orderListItem2.setmOrderCreatedTime(DateUtility.getFormattedDate(orderDetailV2Model.getOrderCreatedTime(), "yyyy-MM-dd'T'HH:mm:ssZ", "yyyy-MM-dd HH:mm:ss"));
        orderListItem2.setmUserPhoneNo(orderDetailV2Model.getOppositePhone());
        orderListItem2.setmUserEmail(orderDetailV2Model.getOppositeEmail());
        orderListItem2.setCustomerEmailId(orderDetailV2Model.getOppositeEmail());
        orderListItem2.setOrderStatus(orderDetailV2Model.getOrderStatus());
        orderListItem2.setUserVPA(orderDetailV2Model.getmUpiId());
        if (orderDetailV2Model.getCashPosIncentiveAmount() != null && !orderDetailV2Model.getCashPosIncentiveAmount().getValue().isEmpty()) {
            orderListItem2.setIncentiveAmt(orderDetailV2Model.getCashPosIncentiveAmount().getValue());
        }
        if (orderDetailV2Model.getProductCode() != null && !orderDetailV2Model.getProductCode().isEmpty()) {
            orderListItem2.setProductCode(orderDetailV2Model.getProductCode());
        }
        orderListItem2.setmTxnAmt(String.valueOf(Double.parseDouble(orderDetailV2Model.getPayMoneyAmount().getValue().replace(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COMMA, "")) / 100.0d));
        orderListItem2.setPayMethod(orderDetailV2Model.getmPayMode());
        return orderListItem2;
    }

    private OrderListItem transformToOrderList(OfflineTransDetailObject offlineTransDetailObject) {
        OrderListItem orderListItem2 = new OrderListItem();
        orderListItem2.setmTxnId(offlineTransDetailObject.getmTransactionID());
        orderListItem2.setmOrderId(offlineTransDetailObject.getmMerchantOrderID());
        orderListItem2.setmOrderCreatedTime(DateUtility.getFormattedDate(offlineTransDetailObject.getmTransactionDate(), "dd/MM/yyyy HH:mm:ss", "yyyy-MM-dd HH:mm:ss"));
        orderListItem2.setmUserPhoneNo(offlineTransDetailObject.getmPayerPhoneNumber());
        orderListItem2.setmTxnAmt(offlineTransDetailObject.getmTransactionAmmount());
        return orderListItem2;
    }
}
