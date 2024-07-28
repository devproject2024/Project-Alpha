package net.one97.paytm.nativesdk.paymethods.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.i;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.paytm.contactsSdk.database.ContactColumn;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.nativesdk.BuildConfig;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.Gtm.NativeSdkGtmLoader;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.NetworkHandler.VolleyPostRequest;
import net.one97.paytm.nativesdk.NetworkHandler.VolleyRequestQueue;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.LogUtility;
import net.one97.paytm.nativesdk.Utils.PayMethodType;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.common.listeners.BaseViewActions;
import net.one97.paytm.nativesdk.common.model.CJRVerifyPasscodeResponse;
import net.one97.paytm.nativesdk.common.model.PayChannelOptions;
import net.one97.paytm.nativesdk.common.model.PaymentModes;
import net.one97.paytm.nativesdk.common.model.SelectedInstrument;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;
import net.one97.paytm.nativesdk.instruments.InstrumentActivity;
import net.one97.paytm.nativesdk.instruments.wallet.viewmodel.WalletViewModel;
import net.one97.paytm.nativesdk.paymethods.listeners.OnBottomSheetChangeListener;
import net.one97.paytm.nativesdk.transcation.PayActivityNew;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.nativesdk.transcation.PaymentInstrument;

public class SelectedInstrumentSheetViewModel extends BaseViewModel implements Response.ErrorListener, Response.Listener {
    private static final String TAG = "SelectedInstrumentSheetViewModel";
    private AppCompatActivity appCompatActivity;
    private OnBottomSheetChangeListener mBottomSheetChangeListener;
    public ObservableInt mInsufficentMsgVisiblity = new ObservableInt();
    public i<String> mPayButtonTitle = new i<>();
    private i<String> mSelectedInstrumentBalance;
    private i<String> mSelectedInstrumentDetails;
    public i<Integer> mSelectedInstrumentIconurl;
    private i<String> mSelectedInstrumentName;
    private String mSelectedInstrumentPaymentMode;
    private ObservableBoolean mShowInstrumentInfoMsg;

    public void completeTransaction(AppCompatActivity appCompatActivity2) {
    }

    public void deselectView() {
    }

    public i<String> getSelectedInstrumentBalance() {
        return this.mSelectedInstrumentBalance;
    }

    public void setSelectedInstrumentBalance(i<String> iVar) {
        this.mSelectedInstrumentBalance = iVar;
    }

    public i<String> getSelectedInstrumentName() {
        return this.mSelectedInstrumentName;
    }

    public void setSelectedInstrumentName(i<String> iVar) {
        this.mSelectedInstrumentName = iVar;
    }

    public ObservableBoolean getShowInstrumentInfoMsg() {
        return this.mShowInstrumentInfoMsg;
    }

    public void setShowInstrumentInfoMsg(ObservableBoolean observableBoolean) {
        this.mShowInstrumentInfoMsg = observableBoolean;
    }

    public SelectedInstrumentSheetViewModel(OnBottomSheetChangeListener onBottomSheetChangeListener, AppCompatActivity appCompatActivity2) {
        super(appCompatActivity2, (BaseViewActions) null);
        this.appCompatActivity = appCompatActivity2;
        this.mBottomSheetChangeListener = onBottomSheetChangeListener;
        initObservables();
        setDefaultInstrument();
        setmInsufficentMsgVisiblity();
    }

    private void initObservables() {
        this.mSelectedInstrumentBalance = new i<>();
        this.mSelectedInstrumentName = new i<>();
        this.mShowInstrumentInfoMsg = new ObservableBoolean(true);
        this.mSelectedInstrumentDetails = new i<>("");
        this.mSelectedInstrumentIconurl = new i<>();
        this.mSelectedInstrumentPaymentMode = "";
    }

    private void setDefaultInstrument() {
        this.mShowInstrumentInfoMsg.set(true);
        if (DirectPaymentBL.getInstance().isWalletEnabledOnMerchant()) {
            PaymentModes instrument = DirectPaymentBL.getInstance().getInstrument(PayMethodType.BALANCE);
            if (instrument != null) {
                this.mSelectedInstrumentName.set(instrument.getDisplayName());
                this.mSelectedInstrumentPaymentMode = instrument.getPaymentMode();
                ArrayList<PayChannelOptions> payChannelOptions = instrument.getPayChannelOptions();
                if (payChannelOptions != null && payChannelOptions.size() > 0) {
                    if (!(instrument.getPayChannelOptions().get(0).getBalanceInfo() == null || instrument.getPayChannelOptions().get(0).getBalanceInfo().getAccountBalance() == null)) {
                        this.mSelectedInstrumentBalance.set(Html.fromHtml(this.appCompatActivity.getString(R.string.nativesdk_balance, new Object[]{SDKUtility.formatNumber(instrument.getPayChannelOptions().get(0).getBalanceInfo().getAccountBalance().getValue())})).toString());
                    }
                    if (instrument.getPaymentMode().equalsIgnoreCase("BALANCE")) {
                        this.mSelectedInstrumentIconurl.set(Integer.valueOf(R.drawable.paytm_wallet));
                    } else {
                        this.mSelectedInstrumentIconurl.set(Integer.valueOf(R.drawable.ic_paytm_payments_bank));
                    }
                }
            }
            DirectPaymentBL.getInstance().setSelectedInstrument(new SelectedInstrument(this.mSelectedInstrumentName.get(), this.mSelectedInstrumentBalance.get(), (BaseViewModel) null));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(SDKConstants.RESPONSE, "Unknown Error-Wallet is not present");
        new Intent().putExtra("data", bundle);
        if (PaytmSDK.getCallbackListener() != null) {
            PaytmSDK.getCallbackListener().onTransactionResponse(bundle);
        }
        this.mBottomSheetChangeListener.onChangeBottomSheet("close", false);
    }

    public void openCashierSheet(View view) {
        this.mBottomSheetChangeListener.onChangeBottomSheet("cashier", true);
    }

    public static void setTopMargin(View view, float f2) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.topMargin = (int) f2;
        view.setLayoutParams(marginLayoutParams);
    }

    public void updateState(String str, String str2) {
        if (str2.contains(SDKConstants.GA_KEY_BALANCE)) {
            this.mSelectedInstrumentIconurl.set(Integer.valueOf(R.drawable.paytm_wallet));
        } else {
            this.mSelectedInstrumentIconurl.set(Integer.valueOf(R.drawable.ic_paytm_payments_bank));
        }
        this.mSelectedInstrumentName.set(str);
        this.mSelectedInstrumentBalance.set(str2);
        setmInsufficentMsgVisiblity();
    }

    private void setmInsufficentMsgVisiblity() {
        if (DirectPaymentBL.getInstance().getSelectedInstrument() == null || !DirectPaymentBL.getInstance().getSelectedInstrument().getPrimaryName().equalsIgnoreCase(DirectPaymentBL.getInstance().getInstrument(PayMethodType.BALANCE).getDisplayName()) || DirectPaymentBL.getInstance().isWalletAmountSufficientToPay()) {
            this.mInsufficentMsgVisiblity.set(8);
            this.mPayButtonTitle.set(this.appCompatActivity.getString(R.string.nativesdk_proceed_to_pay));
            return;
        }
        this.mInsufficentMsgVisiblity.set(0);
        this.mPayButtonTitle.set(this.appCompatActivity.getString(R.string.add_pay, new Object[]{DirectPaymentBL.getInstance().getDifferentialAmount()}));
    }

    public void onProceedToPayClick(View view) {
        SelectedInstrument selectedInstrument = DirectPaymentBL.getInstance().getSelectedInstrument();
        if (DirectPaymentBL.getInstance().isWalletAmountSufficientToPay() && selectedInstrument.getBaseViewModel() == null) {
            startTranscation();
        } else if (DirectPaymentBL.getInstance().isWalletAmountSufficientToPay() && selectedInstrument.getBaseViewModel() != null && (selectedInstrument.getBaseViewModel() instanceof WalletViewModel)) {
            startTranscation();
        } else if (selectedInstrument.getBaseViewModel() == null || (selectedInstrument.getBaseViewModel() instanceof WalletViewModel)) {
            this.mBottomSheetChangeListener.onChangeBottomSheet("cashier", DirectPaymentBL.getInstance().isWalletAmountSufficientToPay());
        } else {
            selectedInstrument.getBaseViewModel().completeTransaction(this.appCompatActivity);
        }
    }

    public static void loadImage(ImageView imageView, int i2) {
        try {
            imageView.setBackgroundResource(i2);
        } catch (Exception unused) {
            imageView.setBackgroundResource(R.drawable.ic_paytm_payments_bank);
        }
    }

    public Request getVerifyPasscodeRequest(Context context, String str, String str2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("Authorization", BuildConfig.AUTHORIZATION_VALUE);
            hashMap.put("Content-Type", "application/x-www-form-urlencoded");
            hashMap.put("session_token", MerchantBL.getMerchantInstance().getSsoToken());
            String addAuthDefaultParams = SDKUtility.addAuthDefaultParams(context, NativeSdkGtmLoader.getToken());
            return new VolleyPostRequest(1, addAuthDefaultParams, hashMap, (Map<String, String>) null, "grant_type=" + URLEncoder.encode("password", AppConstants.UTF_8) + "&login_id=" + URLEncoder.encode("9599711105", AppConstants.UTF_8) + "&login_secret=" + URLEncoder.encode(str, AppConstants.UTF_8) + "&scope=" + URLEncoder.encode(str2, AppConstants.UTF_8) + "&login_id_type=" + URLEncoder.encode(ContactColumn.PHONE_NUMBER, AppConstants.UTF_8) + "&login_secret_type=" + URLEncoder.encode("passcode", AppConstants.UTF_8), this, this, CJRVerifyPasscodeResponse.class);
        } catch (Exception e2) {
            LogUtility.printStackTrace(e2);
            return null;
        }
    }

    public void onErrorResponse(VolleyError volleyError) {
        LogUtility.d("", "");
    }

    public void onResponse(Object obj) {
        if (obj instanceof CJRVerifyPasscodeResponse) {
            CJRVerifyPasscodeResponse cJRVerifyPasscodeResponse = (CJRVerifyPasscodeResponse) obj;
            if (cJRVerifyPasscodeResponse.getScope().equalsIgnoreCase(BuildConfig.BANK_TXN_SCOPE)) {
                PayUtility.startPayActivity(this.appCompatActivity);
            } else if (cJRVerifyPasscodeResponse.getScope().equalsIgnoreCase(BuildConfig.BANK_TXN_SCOPE)) {
                PayUtility.startPayActivity(this.appCompatActivity);
            }
        }
    }

    private void executeRequest(Request request) {
        if (SDKUtility.isNetworkAvailable(this.appCompatActivity)) {
            VolleyRequestQueue.getInstance(this.appCompatActivity).addToRequestQueue(request);
        } else {
            this.mBottomSheetChangeListener.onNetworkUnavailable(request);
        }
    }

    public void startTranscation() {
        String addAuthDefaultParams = SDKUtility.addAuthDefaultParams(this.appCompatActivity.getApplicationContext(), NativeSdkGtmLoader.getProcessTranscationUrl(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId()));
        HashMap<String, String> balanceParam = PayUtility.getBalanceParam(PayMethodType.BALANCE.name());
        Intent intent = new Intent(this.appCompatActivity, PayActivityNew.class);
        intent.putExtra(SDKConstants.PAYMENT_INFO, new PaymentInstrument(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId(), addAuthDefaultParams, balanceParam));
        intent.putExtra(SDKConstants.KEY_PAYMODE, "wallet");
        this.appCompatActivity.startActivityForResult(intent, InstrumentActivity.PAYACTIVITY_REQUEST_CODE);
    }
}
