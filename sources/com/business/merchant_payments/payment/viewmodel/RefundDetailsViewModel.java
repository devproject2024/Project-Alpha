package com.business.merchant_payments.payment.viewmodel;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.webkit.URLUtil;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.a;
import androidx.databinding.i;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ah;
import androidx.lifecycle.y;
import com.business.common_module.events.e;
import com.business.common_module.utilities.LogUtility;
import com.business.common_module.utilities.a.b;
import com.business.common_module.utilities.a.d;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.R;
import com.business.merchant_payments.businesswallet.util.TransactionType;
import com.business.merchant_payments.collection.model.CollectionRepository;
import com.business.merchant_payments.common.ErrorUtil;
import com.business.merchant_payments.common.utility.APSharedPreferences;
import com.business.merchant_payments.common.utility.AppUtility;
import com.business.merchant_payments.common.utility.DateUtility;
import com.business.merchant_payments.common.utility.DialogUtility;
import com.business.merchant_payments.common.utility.GTMDataProviderImpl;
import com.business.merchant_payments.common.utility.RequestParamUtil;
import com.business.merchant_payments.model.lastcollectedpaymentmodel.OfflineTransDetailObject;
import com.business.merchant_payments.model.lastcollectedpaymentmodel.OfflineTransactionDetails;
import com.business.merchant_payments.model.v2.OrderDetailV2Model;
import com.business.merchant_payments.utility.NetworkService;
import com.business.merchant_payments.utility.StringUtility;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.greenrobot.eventbus.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RefundDetailsViewModel extends a {
    public final String PENDING = "PENDING";
    public final String SUCCESS = "SUCCESS";
    public final String TAG = "REFUNDDETAIL";
    public i<String> comment;
    public ObservableBoolean dottedProgressBarVisibility;
    public ObservableBoolean emailVisibility;
    public ObservableBoolean inclVisibility = new ObservableBoolean();
    public boolean isCancel;
    public ObservableBoolean isDirectSettleViaBankVisible;
    public ObservableBoolean isMobileAvailable;
    public ObservableBoolean isPayDetailsVisible;
    public ObservableBoolean isPayModeVisible;
    public ObservableBoolean isPaymentDescriptionVisible;
    public Context mContext;
    public final LiveData<b<OrderDetailV2Model>> mObservableV2PaymentAmtResponse;
    public final LiveData<b<OrderDetailV2Model>> mObservableV2Response;
    public final LiveData<b<OrderDetailV2Model>> mObservableV2ResponseAcquiring;
    public OfflineTransDetailObject mOfflineTransDetailObject;
    public OrderDetailV2Model orderDetailV2ModelAcquiring;
    public OrderDetailV2Model orderDetailV2ModelRefund;
    public i<String> payMethodIconUrl;
    public i<String> payModeDetailText;
    public ObservableBoolean paymentDetailLoading = new ObservableBoolean(false);
    public String referenceBizOrderId;
    public String refundAmount;
    public String refundDate;
    public String settlementDate;
    public d<String> showSnackBarMessage;
    public ObservableInt successVisibility;
    public i<Spannable> txnAmount;
    public String txnId;
    public OfflineTransDetailObject txnObject;
    public final y<Boolean> v2Flag;
    public final y<Boolean> vPaymentFlag;

    public RefundDetailsViewModel(Context context, OfflineTransDetailObject offlineTransDetailObject, boolean z) {
        this.mContext = context;
        this.v2Flag = new y<>();
        this.vPaymentFlag = new y<>();
        this.mOfflineTransDetailObject = offlineTransDetailObject;
        this.successVisibility = new ObservableInt();
        this.emailVisibility = new ObservableBoolean(false);
        this.isMobileAvailable = new ObservableBoolean(false);
        this.isDirectSettleViaBankVisible = new ObservableBoolean(false);
        this.dottedProgressBarVisibility = new ObservableBoolean(false);
        this.isPayModeVisible = new ObservableBoolean(false);
        this.payModeDetailText = new i<>();
        this.comment = new i<>();
        this.isPaymentDescriptionVisible = new ObservableBoolean(false);
        this.inclVisibility.set(false);
        this.isPayDetailsVisible = new ObservableBoolean(false);
        this.isCancel = z;
        this.showSnackBarMessage = new d<>();
        this.txnAmount = new i<>();
        this.mObservableV2Response = ah.b(this.v2Flag, new androidx.arch.core.c.a() {
            public final Object apply(Object obj) {
                return RefundDetailsViewModel.this.lambda$new$0$RefundDetailsViewModel((Boolean) obj);
            }
        });
        this.mObservableV2ResponseAcquiring = ah.b(this.v2Flag, new androidx.arch.core.c.a() {
            public final Object apply(Object obj) {
                return RefundDetailsViewModel.this.lambda$new$1$RefundDetailsViewModel((Boolean) obj);
            }
        });
        this.mObservableV2PaymentAmtResponse = ah.b(this.vPaymentFlag, new androidx.arch.core.c.a() {
            public final Object apply(Object obj) {
                return RefundDetailsViewModel.this.lambda$new$2$RefundDetailsViewModel((Boolean) obj);
            }
        });
        callRefundDetails();
    }

    public /* synthetic */ LiveData lambda$new$0$RefundDetailsViewModel(Boolean bool) {
        if (bool.booleanValue()) {
            return callV2RefundDetails(true);
        }
        return new com.business.common_module.utilities.a.a();
    }

    public /* synthetic */ LiveData lambda$new$1$RefundDetailsViewModel(Boolean bool) {
        if (bool.booleanValue()) {
            return callV2RefundDetails(false);
        }
        return new com.business.common_module.utilities.a.a();
    }

    public /* synthetic */ LiveData lambda$new$2$RefundDetailsViewModel(Boolean bool) {
        if (bool.booleanValue()) {
            return callV2RefundPaymentDetails();
        }
        return new com.business.common_module.utilities.a.a();
    }

    private LiveData<b<OrderDetailV2Model>> callV2RefundPaymentDetails() {
        if (!com.business.common_module.utilities.i.a(PaymentsConfig.getInstance().getApplication())) {
            this.inclVisibility.set(true);
            this.showSnackBarMessage.setValue(PaymentsConfig.getInstance().getAppContext().getString(R.string.mp_no_internet_connection));
            return new com.business.common_module.utilities.a.a();
        }
        String v3OrderDetail = GTMDataProviderImpl.Companion.getMInstance().getV3OrderDetail();
        if (!URLUtil.isValidUrl(v3OrderDetail)) {
            return new com.business.common_module.utilities.a.a();
        }
        return CollectionRepository.getInstance().getV2OrderDetails(v3OrderDetail, RequestParamUtil.getRequestHeaderMidParam(PaymentsConfig.getInstance().getAppContext()), getBodyParamsRest());
    }

    private LiveData<b<OrderDetailV2Model>> callV2RefundDetails(boolean z) {
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
        return CollectionRepository.getInstance().getV2OrderDetails(v3OrderDetail, RequestParamUtil.getRequestHeaderMidParam(PaymentsConfig.getInstance().getAppContext()), getBodyParamsRest());
    }

    public LiveData<String> snackBarCmd() {
        return this.showSnackBarMessage;
    }

    public String getEmail() {
        OrderDetailV2Model orderDetailV2Model = this.orderDetailV2ModelRefund;
        if (orderDetailV2Model == null || TextUtils.isEmpty(orderDetailV2Model.getOppositeEmail())) {
            OfflineTransDetailObject offlineTransDetailObject = this.txnObject;
            if (offlineTransDetailObject == null || TextUtils.isEmpty(offlineTransDetailObject.getEmail())) {
                OfflineTransDetailObject offlineTransDetailObject2 = this.mOfflineTransDetailObject;
                if (offlineTransDetailObject2 == null || TextUtils.isEmpty(offlineTransDetailObject2.getEmail())) {
                    this.emailVisibility.set(false);
                    return "-";
                }
                this.emailVisibility.set(true);
                return AppUtility.getMaskedUPI_Email(this.mOfflineTransDetailObject.getEmail());
            }
            this.emailVisibility.set(true);
            return AppUtility.getMaskedUPI_Email(this.txnObject.getEmail());
        }
        this.emailVisibility.set(true);
        return this.orderDetailV2ModelRefund.getOppositeEmail();
    }

    public String getRefundAmount() {
        OfflineTransDetailObject offlineTransDetailObject = this.mOfflineTransDetailObject;
        if (offlineTransDetailObject == null || offlineTransDetailObject.getmTransactionAmmount() == null || TextUtils.isEmpty(this.mOfflineTransDetailObject.getmTransactionAmmount())) {
            return this.refundAmount;
        }
        Double valueOf = Double.valueOf(Double.parseDouble(this.mOfflineTransDetailObject.getmTransactionAmmount().replace(AppConstants.COMMA, "").replace("-", "").replace(AppConstants.COMMA, "")));
        return "-" + this.mContext.getString(R.string.mp_rupee_symbol) + AppUtility.formatNumber(String.valueOf(valueOf), com.business.merchant_payments.common.utility.AppConstants.PRICE_PATTERN);
    }

    public String getRefundDate() {
        OfflineTransDetailObject offlineTransDetailObject = this.mOfflineTransDetailObject;
        if (!(offlineTransDetailObject == null || offlineTransDetailObject.getmTransactionDate() == null || TextUtils.isEmpty(this.mOfflineTransDetailObject.getmTransactionDate()))) {
            String[] split = this.mOfflineTransDetailObject.getmTransactionDate().split(" ");
            String str = split[1];
            String formattedDate = DateUtility.getFormattedDate(split[0], "dd/MM/yyyy", "dd MMM yyyy");
            this.refundDate = (formattedDate + ", " + DateUtility.getFormattedDate(str, "HH:mm:ss", "hh:mm a")).replace("AM", "am").replace("PM", "pm");
        }
        return this.refundDate;
    }

    public int isUnlimitedMerchant() {
        return (PaymentsConfig.getInstance().getMerchantDataProvider().q() || PaymentsConfig.getInstance().getMerchantDataProvider().r()) ? 0 : 8;
    }

    public String getTxnId() {
        OfflineTransDetailObject offlineTransDetailObject = this.mOfflineTransDetailObject;
        if (!(offlineTransDetailObject == null || offlineTransDetailObject.getmTransactionID() == null || TextUtils.isEmpty(this.mOfflineTransDetailObject.getmTransactionID()))) {
            this.txnId = this.mContext.getString(R.string.mp_refund_id) + " " + this.mOfflineTransDetailObject.getmTransactionID();
        }
        return this.txnId;
    }

    public String getOrderId() {
        OrderDetailV2Model orderDetailV2Model = this.orderDetailV2ModelAcquiring;
        if (orderDetailV2Model != null && !TextUtils.isEmpty(orderDetailV2Model.getMerchantTransId())) {
            return this.orderDetailV2ModelAcquiring.getMerchantTransId();
        }
        OfflineTransDetailObject offlineTransDetailObject = this.txnObject;
        return (offlineTransDetailObject == null || TextUtils.isEmpty(offlineTransDetailObject.getmMerchantOrderID())) ? "" : this.txnObject.getmMerchantOrderID();
    }

    public Spannable getReceivedAmount() {
        OrderDetailV2Model orderDetailV2Model;
        if (this.orderDetailV2ModelAcquiring == null || (orderDetailV2Model = this.orderDetailV2ModelRefund) == null || orderDetailV2Model.getPayMoneyAmount() == null || TextUtils.isEmpty(this.orderDetailV2ModelRefund.getPayMoneyAmount().getValue()) || this.orderDetailV2ModelAcquiring.getPayMoneyAmount() == null || TextUtils.isEmpty(this.orderDetailV2ModelAcquiring.getPayMoneyAmount().getValue())) {
            OfflineTransDetailObject offlineTransDetailObject = this.txnObject;
            if (offlineTransDetailObject == null || TextUtils.isEmpty(offlineTransDetailObject.getmSettlementAmmount())) {
                return new SpannableString("");
            }
            return AppUtility.formattedPrice(this.mContext.getString(R.string.mp_rupee_symbol) + AppUtility.formatNumber(String.valueOf(Double.parseDouble(this.txnObject.getmSettlementAmmount()) / 100.0d), com.business.merchant_payments.common.utility.AppConstants.PRICE_PATTERN), this.mContext);
        } else if (isPCFCase()) {
            return getTxnAmount();
        } else {
            Double valueOf = Double.valueOf(Double.parseDouble(this.orderDetailV2ModelRefund.getPayMoneyAmount().getValue()));
            Double valueOf2 = Double.valueOf(Double.parseDouble(this.orderDetailV2ModelAcquiring.getPayMoneyAmount().getValue()));
            double d2 = 0.0d;
            double parseDouble = (this.orderDetailV2ModelAcquiring.getCommission() == null || TextUtils.isEmpty(this.orderDetailV2ModelAcquiring.getCommission().getValue())) ? 0.0d : Double.parseDouble(this.orderDetailV2ModelAcquiring.getCommission().getValue());
            if (this.orderDetailV2ModelAcquiring.getCommissionTax() != null && !TextUtils.isEmpty(this.orderDetailV2ModelAcquiring.getCommissionTax().getValue())) {
                d2 = Double.parseDouble(this.orderDetailV2ModelAcquiring.getCommissionTax().getValue());
            }
            double doubleValue = valueOf.doubleValue() / valueOf2.doubleValue();
            return AppUtility.formattedPrice(this.mContext.getString(R.string.mp_rupee_symbol) + AppUtility.formatNumber(String.valueOf(((valueOf.doubleValue() - (parseDouble * doubleValue)) - (d2 * doubleValue)) / 100.0d), com.business.merchant_payments.common.utility.AppConstants.PRICE_PATTERN), this.mContext);
        }
    }

    public String getCommissionText() {
        if (!isPCFCase()) {
            return this.mContext.getString(R.string.mp_commission);
        }
        return String.format("%s %s", new Object[]{this.mContext.getString(R.string.mp_commission), this.mContext.getString(R.string.mp_paid_by_user_text)});
    }

    private boolean isPCFCase() {
        OrderDetailV2Model orderDetailV2Model = this.orderDetailV2ModelAcquiring;
        return (orderDetailV2Model == null || orderDetailV2Model.getPcTax() == null || this.orderDetailV2ModelAcquiring.getPcfee() == null) ? false : true;
    }

    public Spannable getCommissionAmount() {
        OrderDetailV2Model orderDetailV2Model;
        OrderDetailV2Model orderDetailV2Model2 = this.orderDetailV2ModelAcquiring;
        if (orderDetailV2Model2 == null || orderDetailV2Model2.getCommission() == null || TextUtils.isEmpty(this.orderDetailV2ModelAcquiring.getCommission().getValue()) || this.orderDetailV2ModelAcquiring.getPayMoneyAmount() == null || (orderDetailV2Model = this.orderDetailV2ModelRefund) == null || TextUtils.isEmpty(orderDetailV2Model.getPayMoneyAmount().getValue())) {
            OfflineTransDetailObject offlineTransDetailObject = this.txnObject;
            if (offlineTransDetailObject != null && !TextUtils.isEmpty(offlineTransDetailObject.getmCommissionAmmount())) {
                return AppUtility.formattedPrice("+ " + this.mContext.getString(R.string.mp_rupee_symbol) + AppUtility.formatNumber(String.valueOf(Double.parseDouble(this.txnObject.getmCommissionAmmount()) / 100.0d), com.business.merchant_payments.common.utility.AppConstants.PRICE_PATTERN), this.mContext);
            } else if (isPCFCase()) {
                return AppUtility.formattedPrice(String.format("%s%s", new Object[]{this.mContext.getString(R.string.mp_rupee_symbol), StringUtility.formatNumber(this.mContext, this.orderDetailV2ModelAcquiring.getPcfee().getValue(), com.business.merchant_payments.common.utility.AppConstants.PRICE_PATTERN)}), this.mContext);
            } else {
                OrderDetailV2Model orderDetailV2Model3 = this.orderDetailV2ModelAcquiring;
                if (orderDetailV2Model3 == null || !AppUtility.isDirectSettlement(orderDetailV2Model3.getTxnSettleType())) {
                    return new SpannableString("");
                }
                return new SpannableString("+ " + this.mContext.getString(R.string.mp_rupee_symbol) + AppUtility.formatNumber("0", com.business.merchant_payments.common.utility.AppConstants.PRICE_PATTERN));
            }
        } else {
            double parseDouble = Double.parseDouble(this.orderDetailV2ModelAcquiring.getCommission().getValue());
            Double valueOf = Double.valueOf(Double.parseDouble(this.orderDetailV2ModelRefund.getPayMoneyAmount().getValue()));
            Double valueOf2 = Double.valueOf(Double.parseDouble(this.orderDetailV2ModelAcquiring.getPayMoneyAmount().getValue()));
            return AppUtility.formattedPrice("+ " + this.mContext.getString(R.string.mp_rupee_symbol) + AppUtility.formatNumber(String.valueOf((parseDouble * (valueOf.doubleValue() / valueOf2.doubleValue())) / 100.0d), com.business.merchant_payments.common.utility.AppConstants.PRICE_PATTERN), this.mContext);
        }
    }

    public String getGstText() {
        if (!isPCFCase()) {
            return this.mContext.getString(R.string.mp_gst);
        }
        return String.format("%s %s", new Object[]{this.mContext.getString(R.string.mp_gst), this.mContext.getString(R.string.mp_paid_by_user_text)});
    }

    public Spannable getGstAmount() {
        OrderDetailV2Model orderDetailV2Model;
        OrderDetailV2Model orderDetailV2Model2 = this.orderDetailV2ModelAcquiring;
        if (orderDetailV2Model2 == null || orderDetailV2Model2.getCommissionTax() == null || TextUtils.isEmpty(this.orderDetailV2ModelAcquiring.getCommissionTax().getValue()) || (orderDetailV2Model = this.orderDetailV2ModelRefund) == null || orderDetailV2Model.getPayMoneyAmount() == null || TextUtils.isEmpty(this.orderDetailV2ModelRefund.getPayMoneyAmount().getValue()) || this.orderDetailV2ModelAcquiring.getPayMoneyAmount() == null || TextUtils.isEmpty(this.orderDetailV2ModelAcquiring.getPayMoneyAmount().getValue())) {
            OfflineTransDetailObject offlineTransDetailObject = this.txnObject;
            if (offlineTransDetailObject != null && !TextUtils.isEmpty(offlineTransDetailObject.getmServiceTax())) {
                return AppUtility.formattedPrice("+ " + this.mContext.getString(R.string.mp_rupee_symbol) + AppUtility.formatNumber(String.valueOf(Double.parseDouble(this.txnObject.getmServiceTax()) / 100.0d), com.business.merchant_payments.common.utility.AppConstants.PRICE_PATTERN), this.mContext);
            } else if (isPCFCase()) {
                return AppUtility.formattedPrice(String.format("%s%s", new Object[]{this.mContext.getString(R.string.mp_rupee_symbol), StringUtility.formatNumber(this.mContext, this.orderDetailV2ModelAcquiring.getPcTax().getValue(), com.business.merchant_payments.common.utility.AppConstants.PRICE_PATTERN)}), this.mContext);
            } else {
                OrderDetailV2Model orderDetailV2Model3 = this.orderDetailV2ModelAcquiring;
                if (orderDetailV2Model3 == null || !AppUtility.isDirectSettlement(orderDetailV2Model3.getTxnSettleType())) {
                    return new SpannableString("");
                }
                return new SpannableString("+ " + this.mContext.getString(R.string.mp_rupee_symbol) + AppUtility.formatNumber("0", com.business.merchant_payments.common.utility.AppConstants.PRICE_PATTERN));
            }
        } else {
            double parseDouble = Double.parseDouble(this.orderDetailV2ModelAcquiring.getCommissionTax().getValue());
            Double valueOf = Double.valueOf(Double.parseDouble(this.orderDetailV2ModelRefund.getPayMoneyAmount().getValue()));
            Double valueOf2 = Double.valueOf(Double.parseDouble(this.orderDetailV2ModelAcquiring.getPayMoneyAmount().getValue()));
            return AppUtility.formattedPrice("+ " + this.mContext.getString(R.string.mp_rupee_symbol) + AppUtility.formatNumber(String.valueOf((parseDouble * (valueOf.doubleValue() / valueOf2.doubleValue())) / 100.0d), com.business.merchant_payments.common.utility.AppConstants.PRICE_PATTERN), this.mContext);
        }
    }

    public Spannable getSettledAmount() {
        OrderDetailV2Model orderDetailV2Model = this.orderDetailV2ModelRefund;
        if (orderDetailV2Model == null || orderDetailV2Model.getPayMoneyAmount() == null) {
            OfflineTransDetailObject offlineTransDetailObject = this.txnObject;
            if (offlineTransDetailObject == null || TextUtils.isEmpty(offlineTransDetailObject.getmSettlementAmmount())) {
                return new SpannableString("");
            }
            double parseDouble = TextUtils.isEmpty(this.txnObject.getmSettlementAmmount()) ? Double.parseDouble("0") : Double.parseDouble(this.txnObject.getmSettlementAmmount());
            return AppUtility.formattedPrice(this.mContext.getString(R.string.mp_rupee_symbol) + AppUtility.formatNumber(String.valueOf(parseDouble / 100.0d), com.business.merchant_payments.common.utility.AppConstants.PRICE_PATTERN), this.mContext);
        } else if (isPCFCase()) {
            double parseAmountAndConvertToRs = parseAmountAndConvertToRs(this.orderDetailV2ModelAcquiring.getPayMoneyAmount().getValue()) + parseAmountAndConvertToRs(this.orderDetailV2ModelAcquiring.getPcfee().getValue()) + parseAmountAndConvertToRs(this.orderDetailV2ModelAcquiring.getPcTax().getValue());
            return AppUtility.formattedPrice(this.mContext.getString(R.string.mp_rupee_symbol) + AppUtility.formatNumber(String.valueOf(parseAmountAndConvertToRs), com.business.merchant_payments.common.utility.AppConstants.PRICE_PATTERN), this.mContext);
        } else {
            Double valueOf = Double.valueOf((TextUtils.isEmpty(this.orderDetailV2ModelRefund.getPayMoneyAmount().getValue()) ? Double.parseDouble("0") : Double.parseDouble(this.orderDetailV2ModelRefund.getPayMoneyAmount().getValue())) / 100.0d);
            return AppUtility.formattedPrice(this.mContext.getString(R.string.mp_rupee_symbol) + AppUtility.formatNumber(String.valueOf(valueOf), com.business.merchant_payments.common.utility.AppConstants.PRICE_PATTERN), this.mContext);
        }
    }

    public String getPayMethodIconUrl() {
        OrderDetailV2Model orderDetailV2Model = this.orderDetailV2ModelRefund;
        return (orderDetailV2Model == null || orderDetailV2Model.getAdditionalInfo() == null || TextUtils.isEmpty(this.orderDetailV2ModelRefund.getAdditionalInfo().getPayMethodIconUrl())) ? "" : this.orderDetailV2ModelRefund.getAdditionalInfo().getPayMethodIconUrl();
    }

    private double parseAmountAndConvertToRs(String str) {
        if (str == null) {
            return 0.0d;
        }
        return Double.parseDouble(str) / 100.0d;
    }

    public Spannable getTxnAmount() {
        OrderDetailV2Model orderDetailV2Model = this.orderDetailV2ModelAcquiring;
        if (orderDetailV2Model == null || orderDetailV2Model.getPayMoneyAmount() == null || TextUtils.isEmpty(this.orderDetailV2ModelAcquiring.getPayMoneyAmount().getValue())) {
            OfflineTransDetailObject offlineTransDetailObject = this.txnObject;
            if (offlineTransDetailObject == null || offlineTransDetailObject.getmTransactionAmmount() == null || TextUtils.isEmpty(this.txnObject.getmTransactionAmmount())) {
                return this.txnAmount.get();
            }
            double parseDouble = Double.parseDouble(this.txnObject.getmTransactionAmmount());
            return AppUtility.formattedPrice(this.mContext.getString(R.string.mp_rupee_symbol) + AppUtility.formatNumber(String.valueOf(parseDouble), com.business.merchant_payments.common.utility.AppConstants.PRICE_PATTERN), this.mContext);
        }
        return AppUtility.formattedPrice(this.mContext.getString(R.string.mp_rupee_symbol) + AppUtility.formatNumber(String.valueOf(Double.parseDouble(this.orderDetailV2ModelAcquiring.getPayMoneyAmount().getValue()) / 100.0d), com.business.merchant_payments.common.utility.AppConstants.PRICE_PATTERN), this.mContext);
    }

    public String getTxnDate() {
        OrderDetailV2Model orderDetailV2Model = this.orderDetailV2ModelAcquiring;
        if (orderDetailV2Model != null && !TextUtils.isEmpty(orderDetailV2Model.getOrderCreatedTime())) {
            return DateUtility.getFormattedDate(this.orderDetailV2ModelAcquiring.getOrderCreatedTime(), "yyyy-MM-dd'T'HH:mm:ssZ", "dd MMM yyyy, hh:mm a");
        }
        OfflineTransDetailObject offlineTransDetailObject = this.txnObject;
        if (offlineTransDetailObject != null && offlineTransDetailObject.getmPaymentCreatedDate() != null && !TextUtils.isEmpty(this.txnObject.getmPaymentCreatedDate())) {
            return this.txnObject.getmPaymentCreatedDate();
        }
        OfflineTransDetailObject offlineTransDetailObject2 = this.txnObject;
        return (offlineTransDetailObject2 == null || offlineTransDetailObject2.getmTransactionDate() == null || TextUtils.isEmpty(this.txnObject.getmTransactionDate())) ? "" : DateUtility.getFormattedDate(this.txnObject.getmTransactionDate(), "dd/MM/yyyy HH:mm:ss", "dd MMM yyyy, hh:mm a");
    }

    public String getPaymentMode() {
        OrderDetailV2Model orderDetailV2Model = this.orderDetailV2ModelRefund;
        if (orderDetailV2Model == null || TextUtils.isEmpty(orderDetailV2Model.getOppositePhone())) {
            OfflineTransDetailObject offlineTransDetailObject = this.mOfflineTransDetailObject;
            if (offlineTransDetailObject != null) {
                String maskedMobileNumber = AppUtility.getMaskedMobileNumber(offlineTransDetailObject.getmUserPhoneNo());
                if (!TextUtils.isEmpty(maskedMobileNumber)) {
                    this.isMobileAvailable.set(true);
                    return maskedMobileNumber;
                }
            }
            this.isMobileAvailable.set(false);
            return null;
        }
        this.isMobileAvailable.set(true);
        return this.orderDetailV2ModelRefund.getOppositePhone();
    }

    public SpannableString getPaymentAmt(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            return new SpannableString("");
        }
        return AppUtility.formattedPrice(this.mContext.getString(R.string.mp_rupee_symbol) + AppUtility.formatNumber(String.valueOf(Double.parseDouble(str) / 100.0d), com.business.merchant_payments.common.utility.AppConstants.PRICE_PATTERN), this.mContext);
    }

    public String getPayMode() {
        OrderDetailV2Model orderDetailV2Model = this.orderDetailV2ModelAcquiring;
        if (orderDetailV2Model == null || TextUtils.isEmpty(orderDetailV2Model.getAdditionalInfo().getPayMethod())) {
            OfflineTransDetailObject offlineTransDetailObject = this.mOfflineTransDetailObject;
            if (offlineTransDetailObject != null && !TextUtils.isEmpty(offlineTransDetailObject.getmPaymentMode())) {
                String payMode = AppUtility.getPayMode(this.mOfflineTransDetailObject.getmPaymentMode());
                if (!TextUtils.isEmpty(payMode)) {
                    this.isPayModeVisible.set(true);
                    return payMode;
                }
            }
            this.isPayModeVisible.set(false);
            return null;
        }
        this.isPayModeVisible.set(true);
        return this.orderDetailV2ModelAcquiring.getAdditionalInfo().getPayMethod();
    }

    public void callRefundDetails() {
        if (APSharedPreferences.getInstance().isMerchantMigrated()) {
            this.v2Flag.setValue(Boolean.TRUE);
        } else {
            callRefundDetailsBizOrderAPI();
        }
    }

    private void callRefundDetailsBizOrderAPI() {
        if (!com.business.common_module.utilities.i.a(PaymentsConfig.getInstance().getApplication())) {
            this.inclVisibility.set(true);
            this.showSnackBarMessage.setValue(PaymentsConfig.getInstance().getAppContext().getString(R.string.mp_no_internet_connection));
            return;
        }
        this.paymentDetailLoading.set(true);
        NetworkService networkService = PaymentsConfig.getInstance().getNetworkService();
        OfflineTransDetailObject offlineTransDetailObject = this.mOfflineTransDetailObject;
        if (offlineTransDetailObject != null && !TextUtils.isEmpty(offlineTransDetailObject.getmTransactionDate())) {
            String refundDetails = GTMDataProviderImpl.Companion.getMInstance().getRefundDetails();
            if (URLUtil.isValidUrl(refundDetails)) {
                networkService.getTxnDetailByTxnId(refundDetails, RequestParamUtil.getRequestHeaderMidParam(this.mContext), addRefundDetailsURLParams(splitDate(this.mOfflineTransDetailObject.getmTransactionDate()), DateUtility.getLastThirtyDaysDate(splitDate(this.mOfflineTransDetailObject.getmTransactionDate()), "dd/MM/yyyy"))).enqueue(new Callback<OfflineTransactionDetails>() {
                    public void onResponse(Call<OfflineTransactionDetails> call, Response<OfflineTransactionDetails> response) {
                        RefundDetailsViewModel.this.paymentDetailLoading.set(false);
                        LogUtility.i("REFUNDDETAIL", response.toString());
                        if (!response.isSuccessful() || response.body() == null) {
                            RefundDetailsViewModel.this.handleErrorCondition(response);
                            return;
                        }
                        OfflineTransactionDetails body = response.body();
                        LogUtility.d("REFUNDDETAIL", "on success of paymments api");
                        if (body != null && body.getmOfflineTransactionDetailMsg() != null && body.getmOfflineTransactionDetailMsg().getmOfflineTransDetailObj() != null && body.getmOfflineTransactionDetailMsg().getmOfflineTransDetailObj().size() > 0) {
                            if (PaymentsConfig.getInstance().getMerchantDataProvider().q()) {
                                Collections.sort(body.getmOfflineTransactionDetailMsg().getmOfflineTransDetailObj());
                            }
                            OfflineTransDetailObject unused = RefundDetailsViewModel.this.txnObject = body.getmOfflineTransactionDetailMsg().getmOfflineTransDetailObj().get(0);
                            RefundDetailsViewModel.this.notifyChange();
                        }
                    }

                    public void onFailure(Call<OfflineTransactionDetails> call, Throwable th) {
                        RefundDetailsViewModel.this.paymentDetailLoading.set(false);
                        LogUtility.d("REFUNDDETAIL", "error payments api");
                    }
                });
            }
        }
    }

    private String getBodyParamsRest() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.referenceBizOrderId != null) {
                jSONObject.put("bizOrderId", this.referenceBizOrderId);
            } else {
                jSONObject.put("bizOrderId", this.mOfflineTransDetailObject.getmTransactionID());
            }
            jSONObject.put("isSettlementInfo", true);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    private String getBodyParamsCommission() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(TransactionType.ACQUIRING);
            jSONObject.put("bizTypeList", jSONArray);
            jSONObject.put("pageNum", "1");
            jSONObject.put("pageSize", "20");
            jSONObject.put("bizOrderId", this.mOfflineTransDetailObject.getmTransactionID());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    private Map<String, String> addRefundDetailsURLParams(String str, String str2) {
        String str3;
        HashMap hashMap = new HashMap();
        if (PaymentsConfig.getInstance().getMerchantDataProvider().q()) {
            str2 = DateUtility.getFormattedDate(str2, "dd/MM/yyyy", "MM/dd/yyyy");
            str = DateUtility.getFormattedDate(str, "dd/MM/yyyy", "MM/dd/yyyy");
            str3 = "orderId";
        } else {
            str3 = "ORDER_ID";
        }
        hashMap.put("end", str);
        hashMap.put("limit", "100");
        hashMap.put("status", "SUCCESS");
        hashMap.put(com.business.merchant_payments.common.utility.AppConstants.KEY_SEARCH_BY, str3);
        OfflineTransDetailObject offlineTransDetailObject = this.mOfflineTransDetailObject;
        if (offlineTransDetailObject != null) {
            hashMap.put(com.business.merchant_payments.common.utility.AppConstants.KEY_SEARCH_VALUE, offlineTransDetailObject.getmMerchantOrderID());
        }
        hashMap.put("start", str2);
        return hashMap;
    }

    private String splitDate(String str) {
        if (str != null) {
            return str.split(" ")[0];
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void handleErrorCondition(Response<?> response) {
        if (response.code() == 400) {
            String parseError = ErrorUtil.parseError(response);
            if (TextUtils.isEmpty(parseError) || !parseError.equalsIgnoreCase(com.business.merchant_payments.common.utility.AppConstants.INVALID_TOKEN)) {
                Context context = this.mContext;
                DialogUtility.showAlert(context, context.getString(R.string.mp_error), parseError);
                return;
            }
            c.a().c(new e(com.business.merchant_payments.common.utility.AppConstants.REFUND_DETAILS_SCREEN));
        }
    }

    public Spannable payModeDescription() {
        OrderDetailV2Model orderDetailV2Model = this.orderDetailV2ModelRefund;
        if (orderDetailV2Model == null || orderDetailV2Model.getAdditionalInfo() == null || TextUtils.isEmpty(this.orderDetailV2ModelRefund.getAdditionalInfo().getComment())) {
            OrderDetailV2Model orderDetailV2Model2 = this.orderDetailV2ModelAcquiring;
            if (orderDetailV2Model2 == null || orderDetailV2Model2.getAdditionalInfo() == null || TextUtils.isEmpty(this.orderDetailV2ModelAcquiring.getAdditionalInfo().getComment())) {
                this.isPaymentDescriptionVisible.set(false);
                return null;
            }
            this.isPaymentDescriptionVisible.set(true);
            String comment2 = this.orderDetailV2ModelAcquiring.getAdditionalInfo().getComment();
            this.comment.set(comment2);
            SpannableString spannableString = new SpannableString(comment2);
            if (comment2.length() > 10) {
                spannableString = new SpannableString(comment2.substring(0, 10) + " ...");
                spannableString.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(this.mContext, R.color.color_00B9F5)), 10, 14, 17);
            }
            if (!TextUtils.isEmpty(this.payModeDetailText.get()) && this.payModeDetailText.get().toLowerCase().endsWith("@ybl")) {
                this.isPaymentDescriptionVisible.set(false);
            }
            return spannableString;
        }
        this.comment.set(this.orderDetailV2ModelRefund.getAdditionalInfo().getComment());
        this.isPaymentDescriptionVisible.set(true);
        String comment3 = this.orderDetailV2ModelRefund.getAdditionalInfo().getComment();
        this.comment.set(comment3);
        SpannableString spannableString2 = new SpannableString(comment3);
        if (comment3.length() > 10) {
            spannableString2 = new SpannableString(comment3.substring(0, 10) + " ...");
            spannableString2.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(this.mContext, R.color.color_00B9F5)), 10, 14, 17);
        }
        if (!TextUtils.isEmpty(this.payModeDetailText.get()) && this.payModeDetailText.get().toLowerCase().endsWith("@ybl")) {
            this.isPaymentDescriptionVisible.set(false);
        }
        return spannableString2;
    }

    public String getPayModeDetailLabel() {
        OrderDetailV2Model orderDetailV2Model = this.orderDetailV2ModelAcquiring;
        if (!(orderDetailV2Model == null || orderDetailV2Model.getAdditionalInfo() == null)) {
            String payMethod = this.orderDetailV2ModelAcquiring.getAdditionalInfo().getPayMethod();
            if (!TextUtils.isEmpty(payMethod)) {
                String upperCase = payMethod.toUpperCase();
                char c2 = 65535;
                switch (upperCase.hashCode()) {
                    case 68769:
                        if (upperCase.equals("EMI")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 84238:
                        if (upperCase.equals("UPI")) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case 1222764004:
                        if (upperCase.equals(com.business.merchant_payments.common.utility.AppConstants.DEBIT_CARD)) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 1820538839:
                        if (upperCase.equals(com.business.merchant_payments.common.utility.AppConstants.CREDIT_CARD)) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 2048730175:
                        if (upperCase.equals(com.business.merchant_payments.common.utility.AppConstants.EMI_CC)) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 2048730206:
                        if (upperCase.equals(com.business.merchant_payments.common.utility.AppConstants.EMI_DC)) {
                            c2 = 4;
                            break;
                        }
                        break;
                }
                if (c2 == 0 || c2 == 1 || c2 == 2 || c2 == 3 || c2 == 4) {
                    if (!TextUtils.isEmpty(this.orderDetailV2ModelAcquiring.getAdditionalInfo().getMaskedCardNo())) {
                        this.isPayDetailsVisible.set(true);
                        this.payModeDetailText.set(this.orderDetailV2ModelAcquiring.getAdditionalInfo().getMaskedCardNo());
                        return this.mContext.getString(R.string.mp_card_number);
                    }
                } else if (c2 == 5 && !TextUtils.isEmpty(this.orderDetailV2ModelAcquiring.getAdditionalInfo().getVirtualPaymentAddr())) {
                    this.payModeDetailText.set(this.orderDetailV2ModelAcquiring.getAdditionalInfo().getVirtualPaymentAddr());
                    this.isPayDetailsVisible.set(true);
                    if (!TextUtils.isEmpty(this.payModeDetailText.get()) && this.payModeDetailText.get().toLowerCase().endsWith("@ybl")) {
                        this.isPaymentDescriptionVisible.set(false);
                    }
                    return this.mContext.getString(R.string.mp_upi_id);
                }
            }
        }
        OfflineTransDetailObject offlineTransDetailObject = this.mOfflineTransDetailObject;
        if (offlineTransDetailObject != null) {
            String maskedUPI_Email = AppUtility.getMaskedUPI_Email(offlineTransDetailObject.getUserVPA());
            if (!TextUtils.isEmpty(maskedUPI_Email)) {
                this.payModeDetailText.set(maskedUPI_Email);
                this.isPayDetailsVisible.set(true);
                return this.mContext.getString(R.string.mp_upi_id);
            }
            String maskedCardNo = this.mOfflineTransDetailObject.getMaskedCardNo();
            if (!TextUtils.isEmpty(maskedCardNo)) {
                this.isPayDetailsVisible.set(true);
                this.payModeDetailText.set(AppUtility.getFormattedCardNumber(maskedCardNo));
                return this.mContext.getString(R.string.mp_card_number);
            }
        }
        this.isPayDetailsVisible.set(false);
        return null;
    }

    public LiveData<b<OrderDetailV2Model>> getmObservableV2ResponseRefund() {
        return this.mObservableV2Response;
    }

    public LiveData<b<OrderDetailV2Model>> getObservableV2ResponseAcquiring() {
        return this.mObservableV2ResponseAcquiring;
    }

    public LiveData<b<OrderDetailV2Model>> getObservableV2ResponsePayment() {
        return this.mObservableV2PaymentAmtResponse;
    }

    public void setProgress(boolean z) {
        this.dottedProgressBarVisibility.set(z);
    }

    public void setV2RefundObject(OrderDetailV2Model orderDetailV2Model) {
        this.orderDetailV2ModelRefund = orderDetailV2Model;
        notifyChange();
    }

    public void setV2AcquiringObject(OrderDetailV2Model orderDetailV2Model) {
        this.orderDetailV2ModelAcquiring = orderDetailV2Model;
        this.mOfflineTransDetailObject = convertOrderDetailsToOfflineTransactionDetail(orderDetailV2Model);
        OrderDetailV2Model orderDetailV2Model2 = this.orderDetailV2ModelAcquiring;
        if (orderDetailV2Model2 == null || !AppUtility.isDirectSettlement(orderDetailV2Model2.getTxnSettleType())) {
            this.isDirectSettleViaBankVisible.set(false);
        } else {
            this.isDirectSettleViaBankVisible.set(true);
        }
        notifyChange();
    }

    private OfflineTransDetailObject convertOrderDetailsToOfflineTransactionDetail(OrderDetailV2Model orderDetailV2Model) {
        OfflineTransDetailObject offlineTransDetailObject = new OfflineTransDetailObject();
        if (orderDetailV2Model != null) {
            offlineTransDetailObject.setmTransactionAmmount(String.valueOf(Double.parseDouble(orderDetailV2Model.getPayMoneyAmount().getValue()) / 100.0d));
            if (!TextUtils.isEmpty(orderDetailV2Model.getOrderCreatedTime())) {
                offlineTransDetailObject.setmTransactionDate(DateUtility.getFormattedDate(orderDetailV2Model.getOrderCreatedTime().split("\\+")[0], "yyyy-MM-dd'T'HH:mm:ss", "dd/MM/yyyy HH:mm:ss"));
            }
            offlineTransDetailObject.setmTransactionID(orderDetailV2Model.getBizOrderId());
            if (!TextUtils.isEmpty(orderDetailV2Model.getOppositePhone())) {
                offlineTransDetailObject.setmUserPhoneNo(orderDetailV2Model.getOppositePhone());
            }
            offlineTransDetailObject.setUserName(orderDetailV2Model.getOppositeNickname());
            if (!TextUtils.isEmpty(orderDetailV2Model.getmUpiId())) {
                offlineTransDetailObject.setUserVPA(orderDetailV2Model.getmUpiId());
            }
            if (!TextUtils.isEmpty(orderDetailV2Model.getmMaskedCardNo())) {
                offlineTransDetailObject.setMaskedCardNo(orderDetailV2Model.getmMaskedCardNo());
            }
            if (!TextUtils.isEmpty(orderDetailV2Model.getmPayMode())) {
                offlineTransDetailObject.setmPaymentMode(orderDetailV2Model.getmPayMode());
            }
            offlineTransDetailObject.setmMerchantOrderID(orderDetailV2Model.getMerchantTransId());
            offlineTransDetailObject.setEmail(orderDetailV2Model.getOppositeEmail());
        }
        return offlineTransDetailObject;
    }

    public String getCustomerName() {
        OrderDetailV2Model orderDetailV2Model = this.orderDetailV2ModelRefund;
        return (orderDetailV2Model == null || orderDetailV2Model.getAdditionalInfo() == null || TextUtils.isEmpty(this.orderDetailV2ModelRefund.getAdditionalInfo().getCustomerName())) ? "" : AppUtility.removeNullFromString(this.orderDetailV2ModelRefund.getAdditionalInfo().getCustomerName());
    }

    public void makePaymentAmtCall(String str) {
        this.referenceBizOrderId = str;
        this.vPaymentFlag.setValue(Boolean.TRUE);
    }
}
