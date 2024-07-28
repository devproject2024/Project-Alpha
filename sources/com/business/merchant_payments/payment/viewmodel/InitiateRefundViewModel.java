package com.business.merchant_payments.payment.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.CheckBox;
import android.widget.Toast;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.i;
import androidx.lifecycle.LiveData;
import com.business.common_module.events.e;
import com.business.common_module.utilities.LogUtility;
import com.business.common_module.utilities.a.d;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.ErrorUtil;
import com.business.merchant_payments.common.utility.APSharedPreferences;
import com.business.merchant_payments.common.utility.AppUtility;
import com.business.merchant_payments.common.utility.DateUtility;
import com.business.merchant_payments.common.utility.GTMDataProviderImpl;
import com.business.merchant_payments.common.utility.GTMScreenViewsConstants;
import com.business.merchant_payments.common.utility.RequestParamUtil;
import com.business.merchant_payments.common.viewmodel.BaseViewModel;
import com.business.merchant_payments.gtm.GAGTMTagAnalytics;
import com.business.merchant_payments.model.initiaterefundmodel.InitiateRefundResponseModel;
import com.business.merchant_payments.model.lastcollectedpaymentmodel.OrderListItem;
import com.business.merchant_payments.payment.listener.InitiateRefundListener;
import com.business.merchant_payments.payment.view.RefundInitiatedActivity;
import com.business.merchant_payments.utility.NetworkService;
import com.paytmmall.clpartifact.view.fragment.FilterPriceSliderFragment;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.HashMap;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import org.greenrobot.eventbus.c;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InitiateRefundViewModel extends BaseViewModel {
    public final String TAG = "INITIATEREFUNDRESPONSE";
    public i<String> amountText;
    public ObservableInt enterAmountVisibility;
    public String enteredAmount;
    public i<String> errorText;
    public ObservableBoolean inclVisibility = new ObservableBoolean();
    public boolean isMultipleQRCase;
    public boolean isPCFTransaction;
    public Context mContext;
    public InitiateRefundResponseModel mInitiateRefundResponseModel;
    public final InitiateRefundListener mListener;
    public i<String> mMaxRefundNote;
    public Spannable mRefundAmount;
    public i<String> mTotalAmount;
    public OrderListItem mTransDetails;
    public String mTxnId;
    public ObservableInt orVisibility;
    public i<String> refundType;
    public d<String> showSnackBarMessage;
    public String totalTxnAmount;

    public InitiateRefundViewModel(InitiateRefundListener initiateRefundListener, Context context, OrderListItem orderListItem, boolean z) {
        this.mTransDetails = orderListItem;
        this.mContext = context;
        this.mListener = initiateRefundListener;
        this.enterAmountVisibility = new ObservableInt(8);
        this.orVisibility = new ObservableInt(8);
        this.inclVisibility.set(false);
        this.errorText = new i<>();
        this.amountText = new i<>();
        this.mMaxRefundNote = new i<>();
        this.mTotalAmount = new i<>();
        this.showSnackBarMessage = new d<>();
        String txnAmt = orderListItem.getTxnAmt();
        this.totalTxnAmount = txnAmt;
        this.mTotalAmount.set(displayFormat(txnAmt));
        if (orderListItem.getIsRefundAllowed()) {
            this.mMaxRefundNote.set(getMaxRefundNote(orderListItem.getMaxRefund()));
            this.amountText.set(displayFormat(String.valueOf(Double.valueOf(orderListItem.getMaxRefund()).doubleValue() / 100.0d)));
        } else {
            String str = this.totalTxnAmount;
            if (str != null) {
                this.amountText.set(displayFormat(str));
            }
        }
        OrderListItem orderListItem2 = this.mTransDetails;
        if (!(orderListItem2 == null || orderListItem2.getTxnId() == null || TextUtils.isEmpty(this.mTransDetails.getTxnId()))) {
            this.mTxnId = this.mTransDetails.getTxnId();
        }
        this.refundType = new i<>("N/A");
        this.isPCFTransaction = z;
    }

    private String getMaxRefundNote(String str) {
        return " " + getContext().getString(R.string.mp_refund_note, new Object[]{displayFormat(String.valueOf(Double.valueOf(str).doubleValue() / 100.0d))});
    }

    private HashMap<String, Object> getRequestBodyParam(String str, String str2, String str3, String str4) {
        HashMap<String, Object> hashMap = new HashMap<>();
        boolean isMerchantMigrated = APSharedPreferences.getInstance().isMerchantMigrated();
        String replace = str3.replace(AppConstants.COMMA, "");
        if (isMerchantMigrated) {
            hashMap.put("mid", APSharedPreferences.getInstance().getMerchantMid());
            hashMap.put("txnId", str);
            hashMap.put("refundAmt", replace);
            hashMap.put("orderId", str4);
            hashMap.put("refundType", this.refundType.get());
            return hashMap;
        }
        if (PaymentsConfig.getInstance().getMerchantDataProvider().q()) {
            hashMap.put("comments", "refund");
            hashMap.put("mid", APSharedPreferences.getInstance().getMerchantMid());
            hashMap.put("txnId", str);
            hashMap.put("refundAmt", replace);
        } else {
            hashMap.put("txnGuid", str);
            hashMap.put("amount", replace);
            if (this.isPCFTransaction) {
                hashMap.put("refundType", this.refundType.get());
            }
        }
        hashMap.put("txnAmount", str2);
        hashMap.put(CJRQRScanResultModel.KEY_MERCHANT_ORDER_ID, str4);
        hashMap.put("guid", APSharedPreferences.getInstance().getCurrentMerchantGuid());
        return hashMap;
    }

    public LiveData<String> snackBarCmd() {
        return this.showSnackBarMessage;
    }

    public Spannable getmTotalAmount() {
        OrderListItem orderListItem = this.mTransDetails;
        if (orderListItem == null || TextUtils.isEmpty(orderListItem.getTxnAmt())) {
            return new SpannableString("");
        }
        return new SpannableString(displayFormat(this.mTransDetails.getTxnAmt()));
    }

    public String getMobileNo() {
        OrderListItem orderListItem = this.mTransDetails;
        if (orderListItem != null) {
            if (!TextUtils.isEmpty(orderListItem.getUserPhoneNo())) {
                return this.mTransDetails.getUserPhoneNo();
            }
            if (!TextUtils.isEmpty(this.mTransDetails.getUserVPA())) {
                return this.mTransDetails.getUserVPA();
            }
        }
        return "";
    }

    public String getTxnId() {
        OrderListItem orderListItem = this.mTransDetails;
        if (!(orderListItem == null || orderListItem.getTxnId() == null || TextUtils.isEmpty(this.mTransDetails.getTxnId()))) {
            this.mTxnId = this.mTransDetails.getTxnId();
        }
        return this.mTxnId;
    }

    public Spannable getRefundAmount() {
        OrderListItem orderListItem = this.mTransDetails;
        if (orderListItem == null || orderListItem.getTxnAmt() == null || TextUtils.isEmpty(this.mTransDetails.getTxnAmt())) {
            return this.mRefundAmount;
        }
        return AppUtility.formattedPrice(" " + displayFormat(this.mTransDetails.getTxnAmt()), getContext());
    }

    public void onClickRefundRequest() {
        String replace = this.amountText.get().replace(FilterPriceSliderFragment.RUPEE_SYMBOL, "").replace(AppConstants.COMMA, "");
        GAGTMTagAnalytics.getSingleInstance().sendEventAndScreen(this.mContext, "Payments", "select transaction", "Final Refund");
        if (TextUtils.isEmpty(replace)) {
            this.errorText.set(getContext().getString(R.string.mp_enter_amount_to_proceed));
        } else if (Double.parseDouble(replace) > Double.parseDouble(this.mTransDetails.getTxnAmt().replace(AppConstants.COMMA, ""))) {
            this.errorText.set(getContext().getString(R.string.mp_amount_cannot_greater));
        } else if (Double.parseDouble(replace) == 0.0d) {
            this.errorText.set(getContext().getString(R.string.mp_amount_greater_zero));
        } else {
            getApiCall();
        }
    }

    public void getApiCall() {
        if (!com.business.common_module.utilities.i.a(PaymentsConfig.getInstance().getApplication())) {
            this.inclVisibility.set(true);
            this.showSnackBarMessage.setValue(PaymentsConfig.getInstance().getAppContext().getString(R.string.mp_no_internet_connection));
            return;
        }
        this.mListener.showProgressDialog();
        NetworkService networkService = PaymentsConfig.getInstance().getNetworkService();
        String initiateRefundAPI = GTMDataProviderImpl.Companion.getMInstance().getInitiateRefundAPI();
        if (URLUtil.isValidUrl(initiateRefundAPI)) {
            networkService.initiateRefund(initiateRefundAPI + this.mTxnId + "/refund", getRequestBodyParam(this.mTxnId, this.totalTxnAmount, this.amountText.get().replace(FilterPriceSliderFragment.RUPEE_SYMBOL, ""), this.mTransDetails.getOrderId()), RequestParamUtil.getRequestHeaderMidParam(getContext())).enqueue(new Callback<InitiateRefundResponseModel>() {
                public void onResponse(Call<InitiateRefundResponseModel> call, Response<InitiateRefundResponseModel> response) {
                    InitiateRefundViewModel.this.mListener.removeProgressDialog();
                    LogUtility.d("REFUND", response.toString());
                    if (!response.isSuccessful() || response.body() == null) {
                        InitiateRefundViewModel.this.handleErrorCondition(response);
                        return;
                    }
                    InitiateRefundResponseModel unused = InitiateRefundViewModel.this.mInitiateRefundResponseModel = response.body();
                    boolean access$200 = InitiateRefundViewModel.this.getFlag(response);
                    if (!(InitiateRefundViewModel.this.mInitiateRefundResponseModel.getResponse() == null || InitiateRefundViewModel.this.mInitiateRefundResponseModel.getResponse().getRefundTxnGuid() == null)) {
                        InitiateRefundViewModel.this.notifyChange();
                    }
                    InitiateRefundViewModel initiateRefundViewModel = InitiateRefundViewModel.this;
                    initiateRefundViewModel.callRefundScreen(initiateRefundViewModel.mInitiateRefundResponseModel, InitiateRefundViewModel.this.mTransDetails, DateUtility.getCurrentFormattedDate("dd/MM/yyyy HH:mm:ss"), InitiateRefundViewModel.this.amountText.get().replace(FilterPriceSliderFragment.RUPEE_SYMBOL, ""), access$200);
                }

                public void onFailure(Call<InitiateRefundResponseModel> call, Throwable th) {
                    InitiateRefundViewModel.this.mListener.removeProgressDialog();
                    Toast.makeText(InitiateRefundViewModel.this.getContext(), InitiateRefundViewModel.this.getContext().getString(R.string.mp_unable_to_refund), 1).show();
                    LogUtility.d("INITIATEREFUNDRESPONSE", "error in initiate refund response");
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public boolean getFlag(Response<InitiateRefundResponseModel> response) {
        return response.body().getStatus() != null && response.body().getStatus().equalsIgnoreCase("SUCCESS");
    }

    /* access modifiers changed from: private */
    public void callRefundScreen(InitiateRefundResponseModel initiateRefundResponseModel, OrderListItem orderListItem, String str, String str2, boolean z) {
        if (this.mContext != null) {
            if (z) {
                GAGTMTagAnalytics singleInstance = GAGTMTagAnalytics.getSingleInstance();
                singleInstance.pushScreenEvent(GTMScreenViewsConstants.GTMString + GTMScreenViewsConstants.SUCCESSFUL_REFUND);
                Intent intent = new Intent(this.mContext, RefundInitiatedActivity.class);
                intent.putExtra("Initiate_response", initiateRefundResponseModel);
                intent.putExtra(com.business.merchant_payments.common.utility.AppConstants.TRANSACTION_OBJECT, orderListItem);
                intent.putExtra("Date", str);
                intent.putExtra("Status", z);
                if (str2 != null) {
                    intent.putExtra("Amount", str2.replace(AppConstants.COMMA, ""));
                }
                intent.putExtra(com.business.merchant_payments.common.utility.AppConstants.IS_FROM_MULTIPLE_QR, this.isMultipleQRCase);
                if (!TextUtils.isEmpty(this.mListener.getComingFromScreen())) {
                    intent.putExtra(com.business.merchant_payments.common.utility.AppConstants.SCREEN_NAME, this.mListener.getComingFromScreen());
                }
                intent.addFlags(268435456);
                this.mContext.startActivity(intent);
            } else if (!TextUtils.isEmpty(initiateRefundResponseModel.getStatusMessage())) {
                Toast.makeText(getContext(), initiateRefundResponseModel.getStatusMessage(), 1).show();
            } else {
                Toast.makeText(getContext(), getContext().getString(R.string.mp_unable_to_refund), 1).show();
            }
        }
    }

    private String displayFormat(String str) {
        return getContext().getString(R.string.mp_rupee_symbol) + AppUtility.formatNumber(str, com.business.merchant_payments.common.utility.AppConstants.PRICE_PATTERN);
    }

    /* access modifiers changed from: private */
    public void handleErrorCondition(Response<?> response) {
        if (response.code() == 400) {
            String parseError = ErrorUtil.parseError(response);
            if (TextUtils.isEmpty(parseError) || !parseError.equalsIgnoreCase(com.business.merchant_payments.common.utility.AppConstants.INVALID_TOKEN)) {
                Toast.makeText(getContext(), getContext().getString(R.string.mp_unable_to_refund), 1).show();
            } else {
                c.a().c(new e(com.business.merchant_payments.common.utility.AppConstants.INITIATE_REFUND_SCREEN));
            }
        } else {
            Toast.makeText(getContext(), getContext().getString(R.string.mp_unable_to_refund), 1).show();
        }
    }

    public void onRefundCommissionCheckboxClicked(View view) {
        if (((CheckBox) view).isChecked()) {
            String str = this.enteredAmount;
            if (str == null || !str.equalsIgnoreCase(this.mTotalAmount.get())) {
                this.refundType.set(AppConstants.FEED_COMMUNITY);
            } else {
                this.refundType.set("R");
            }
            GAGTMTagAnalytics.getSingleInstance().sendEvent(this.mContext, "Payments", "Select transaction", "", "Refund commission to customer");
            return;
        }
        this.refundType.set("N/A");
    }

    public void setEnteredAmount(String str) {
        this.enteredAmount = str;
    }

    public void setMultipleQR(boolean z) {
        this.isMultipleQRCase = z;
    }
}
