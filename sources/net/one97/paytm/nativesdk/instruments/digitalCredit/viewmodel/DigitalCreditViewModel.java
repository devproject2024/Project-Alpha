package net.one97.paytm.nativesdk.instruments.digitalCredit.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ObservableInt;
import androidx.databinding.i;
import androidx.localbroadcastmanager.a.a;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.paytm.contactsSdk.database.ContactColumn;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.Gtm.NativeSdkGtmLoader;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.NetworkHandler.VolleyPostRequest;
import net.one97.paytm.nativesdk.NetworkHandler.VolleyRequestQueue;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.DialogUtility;
import net.one97.paytm.nativesdk.Utils.LogUtility;
import net.one97.paytm.nativesdk.Utils.OfflineDataEncryption;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.common.Requester.APIReqtGenerator;
import net.one97.paytm.nativesdk.common.listeners.BaseViewActions;
import net.one97.paytm.nativesdk.common.model.AccountBalance;
import net.one97.paytm.nativesdk.common.model.BalanceInfo;
import net.one97.paytm.nativesdk.common.model.CJRVerifyPasscodeResponse;
import net.one97.paytm.nativesdk.common.model.CustomVolleyError;
import net.one97.paytm.nativesdk.common.model.IsDisabled;
import net.one97.paytm.nativesdk.common.model.PaymentModes;
import net.one97.paytm.nativesdk.common.model.SelectedInstrument;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;
import net.one97.paytm.nativesdk.instruments.digitalCredit.listeners.DigitalCreditLisnter;
import net.one97.paytm.nativesdk.paymethods.datasource.NativeSDKRepository;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource;
import net.one97.paytm.nativesdk.paymethods.model.fetchBalance.CJRFetchBalanceResponse;
import net.one97.paytm.nativesdk.pincvv.listeners.SetOnPinCvvResultListener;
import net.one97.paytm.nativesdk.pincvv.views.bottomsheet.PinCvvBottomSheet;
import net.one97.paytm.nativesdk.transcation.PayActivityNew;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.nativesdk.transcation.PaymentInstrument;
import org.json.JSONObject;

public class DigitalCreditViewModel extends BaseViewModel implements Response.ErrorListener, Response.Listener {
    public ObservableInt balanceTxtVisiblity = new ObservableInt();
    private DigitalCreditLisnter digitalCreditLisnter;
    public ObservableInt fetchBalanceMsgVisiblity = new ObservableInt();
    public boolean isAmountSufficent;
    private IsDisabled isDisabled;
    private boolean isValid;
    /* access modifiers changed from: private */
    public Context mContext;
    public i<String> mPrimaryInformation = new i<>();
    public i<String> mSecondaryInformation = new i<>();
    private PaymentModes paymentModes;
    public PinCvvBottomSheet pinCvvBottomSheet;
    private SelectedInstrument selectedInstrument;

    public DigitalCreditViewModel(Context context, PaymentModes paymentModes2, DigitalCreditLisnter digitalCreditLisnter2, boolean z) {
        super(context, (BaseViewActions) null);
        this.mContext = context;
        this.paymentModes = paymentModes2;
        this.digitalCreditLisnter = digitalCreditLisnter2;
        this.isValid = z;
        init();
    }

    private void init() {
        this.fetchBalanceMsgVisiblity.set(8);
        this.balanceTxtVisiblity.set(0);
        this.mPrimaryInformation.set(this.paymentModes.getDisplayName());
        PaymentModes paymentModes2 = this.paymentModes;
        if (paymentModes2 != null && paymentModes2.getPayChannelOptions() != null && this.paymentModes.getPayChannelOptions().size() > 0) {
            this.isDisabled = this.paymentModes.getIsDisabled();
            if (this.paymentModes.getPayChannelOptions().get(0).getBalanceInfo() != null && this.paymentModes.getPayChannelOptions().get(0).getBalanceInfo().getAccountBalance() != null) {
                this.mSecondaryInformation.set(Html.fromHtml(this.mContext.getString(R.string.nativesdk_balance, new Object[]{MerchantBL.getMerchantInstance().getWithoutDoubleAmount(Double.valueOf(this.paymentModes.getPayChannelOptions().get(0).getBalanceInfo().getAccountBalance().getValue()).doubleValue())})).toString());
                this.isAmountSufficent = SDKUtility.isPayableAmountGreaterThanOwnedMoney(this.paymentModes.getPayChannelOptions().get(0).getBalanceInfo().getAccountBalance().getValue(), false, 0.0d);
                if (!this.isAmountSufficent) {
                    this.digitalCreditLisnter.disableView(true);
                }
            }
        }
    }

    public void payMethodSelected(View view) {
        IsDisabled isDisabled2;
        if (this.isValid) {
            String str = this.mPrimaryInformation.get();
            String str2 = this.mSecondaryInformation.get();
            this.paymentModes.getPaymentMode();
            this.digitalCreditLisnter.showAnimation(false);
            if (this.isAmountSufficent && ((isDisabled2 = this.isDisabled) == null || !isDisabled2.getStatus())) {
                if (this.mSecondaryInformation.get().equalsIgnoreCase(this.mContext.getString(R.string.check_balance))) {
                    this.fetchBalanceMsgVisiblity.set(0);
                    this.balanceTxtVisiblity.set(8);
                    callBalanceAPI(this.paymentModes.getPaymentMode());
                } else {
                    setSelectedInstrument(str, str2);
                }
            }
            SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams(SDKConstants.NATIVESDK_USER_CHANGES, SDKConstants.GA_KEY_POSTPAID, SDKConstants.GA_KEY_NEW));
        }
    }

    public void setSelectedInstrument(String str, String str2) {
        this.selectedInstrument = new SelectedInstrument();
        this.selectedInstrument.setPrimaryName(str);
        this.selectedInstrument.setSecondaryName(str2);
        this.selectedInstrument.setBaseViewModel(this);
        DirectPaymentBL.getInstance().setSelectedInstrument(this.selectedInstrument);
        this.digitalCreditLisnter.closeCachierSheet();
    }

    /* access modifiers changed from: private */
    public void goForTransaction(String str) {
        String addAuthDefaultParams = SDKUtility.addAuthDefaultParams(this.mContext, NativeSdkGtmLoader.getProcessTranscationUrl(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId()));
        HashMap<String, String> digitalCreditParam = PayUtility.getDigitalCreditParam(this.paymentModes.getPaymentMode(), str);
        Intent intent = new Intent(this.mContext, PayActivityNew.class);
        intent.putExtra(SDKConstants.PAYMENT_INFO, new PaymentInstrument(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId(), addAuthDefaultParams, digitalCreditParam));
        intent.putExtra(SDKConstants.KEY_PAYMODE, BaseViewModel.PaymentType.POSTPAID);
        this.mContext.startActivity(intent);
        PayUtility.startPayActivity(this.mContext);
    }

    public void completeTransaction(AppCompatActivity appCompatActivity) {
        this.pinCvvBottomSheet = PinCvvBottomSheet.getInstance(new SetOnPinCvvResultListener() {
            public void onResult(String str) {
                if (!TextUtils.isEmpty(MerchantBL.getMerchantInstance().getClientId())) {
                    try {
                        DigitalCreditViewModel.this.pinCvvBottomSheet.pinCvvModel.loaderVisiblity.set(0);
                        DigitalCreditViewModel.this.pinCvvBottomSheet.pinCvvModel.cvvOrPinTitle.set(DigitalCreditViewModel.this.mContext.getString(R.string.validating_otp));
                        DigitalCreditViewModel.this.pinCvvBottomSheet.pinCvvModel.cvvVisiblity.set(8);
                        DigitalCreditViewModel.this.executeRequest(DigitalCreditViewModel.this.getVerifyPasscodeRequest(DigitalCreditViewModel.this.mContext, OfflineDataEncryption.encrypt(MerchantBL.getMerchantInstance().getRSAkey(), str), "dc_txn"));
                    } catch (Exception unused) {
                    }
                } else {
                    DigitalCreditViewModel.this.pinCvvBottomSheet.dismiss();
                    DigitalCreditViewModel.this.goForTransaction(str);
                }
            }
        }, this.selectedInstrument.getPrimaryName(), this.selectedInstrument.getSecondaryName(), appCompatActivity.getResources().getString(R.string.enter_cvv_number), "", 4);
        this.pinCvvBottomSheet.show(appCompatActivity.getSupportFragmentManager().a(), (String) null);
    }

    private void callBalanceAPI(String str) {
        NativeSDKRepository.getInstance().fetchBalance(str, new PaymentMethodDataSource.Callback<CJRFetchBalanceResponse>() {
            public void onResponse(CJRFetchBalanceResponse cJRFetchBalanceResponse) {
                DigitalCreditViewModel.this.handleResponse(cJRFetchBalanceResponse);
            }

            public void onErrorResponse(VolleyError volleyError, CJRFetchBalanceResponse cJRFetchBalanceResponse) {
                DigitalCreditViewModel.this.handleError(volleyError);
            }
        });
    }

    private Request getFetchBalanceInstrumentRequest(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("SSO_TOKEN", MerchantBL.getMerchantInstance().getSsoToken());
        VolleyPostRequest volleyPostRequest = new VolleyPostRequest(1, NativeSdkGtmLoader.getFetchBalanceUrl(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId()), hashMap, (Map<String, String>) null, APIReqtGenerator.createJsonForFetchBalance(str, false), this, this, CJRFetchBalanceResponse.class);
        volleyPostRequest.setRetryPolicy(new DefaultRetryPolicy(2500, 2, 1.0f));
        return volleyPostRequest;
    }

    /* access modifiers changed from: private */
    public void executeRequest(Request request) {
        if (SDKUtility.isNetworkAvailable(this.mContext)) {
            VolleyRequestQueue.getInstance(this.mContext).addToRequestQueue(request);
            Context context = this.mContext;
            DialogUtility.showProgressDialog(context, context.getString(R.string.please_wait), false);
            return;
        }
        DialogUtility.showNetworkDialog(request, this.mContext);
    }

    /* access modifiers changed from: private */
    public void handleError(VolleyError volleyError) {
        String str;
        CustomVolleyError customVolleyError = (CustomVolleyError) volleyError;
        if (customVolleyError.getUrl().contains(NativeSdkGtmLoader.getFetchBalanceUrl(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId()))) {
            this.fetchBalanceMsgVisiblity.set(8);
            this.balanceTxtVisiblity.set(0);
        } else if (customVolleyError.getUrl().contains(NativeSdkGtmLoader.getToken())) {
            setAnimation();
            try {
                str = new JSONObject(customVolleyError.getErrorMsg()).getString("error_description");
            } catch (Exception unused) {
                str = "";
            }
            this.pinCvvBottomSheet.pinCvvModel.cvvOrPinTitle.set(str);
            this.pinCvvBottomSheet.cvvPinLayoutBinding.titleTxt.setTextColor(this.mContext.getResources().getColor(R.color.red));
            this.pinCvvBottomSheet.pinCvvModel.cvvVisiblity.set(0);
            this.pinCvvBottomSheet.pinCvvModel.loaderVisiblity.set(8);
        }
    }

    public void onErrorResponse(VolleyError volleyError) {
        handleError(volleyError);
    }

    /* access modifiers changed from: private */
    public void handleResponse(Object obj) {
        if (obj instanceof CJRFetchBalanceResponse) {
            CJRFetchBalanceResponse cJRFetchBalanceResponse = (CJRFetchBalanceResponse) obj;
            if (cJRFetchBalanceResponse.getBody() != null && cJRFetchBalanceResponse.getBody().getBalanceInfo() != null) {
                this.fetchBalanceMsgVisiblity.set(8);
                this.balanceTxtVisiblity.set(0);
                String value = cJRFetchBalanceResponse.getBody().getBalanceInfo().getValue();
                String currency = cJRFetchBalanceResponse.getBody().getBalanceInfo().getCurrency();
                this.mSecondaryInformation.set(Html.fromHtml(this.mContext.getString(R.string.nativesdk_balance, new Object[]{MerchantBL.getMerchantInstance().getWithoutDoubleAmount(Double.valueOf(this.paymentModes.getPayChannelOptions().get(0).getBalanceInfo().getAccountBalance().getValue()).doubleValue())})).toString());
                BalanceInfo balanceInfo = new BalanceInfo();
                AccountBalance accountBalance = new AccountBalance();
                accountBalance.setValue(value);
                accountBalance.setCurrency(currency);
                balanceInfo.setAccountBalance(accountBalance);
                this.paymentModes.getPayChannelOptions().get(0).setBalanceInfo(balanceInfo);
                this.isAmountSufficent = !SDKUtility.isPayableAmountGreaterThanOwnedMoney(this.paymentModes.getPayChannelOptions().get(0).getBalanceInfo().getAccountBalance().getValue(), false, 0.0d);
                if (!this.isAmountSufficent) {
                    this.digitalCreditLisnter.disableView(true);
                    openNextInstrument();
                }
                this.digitalCreditLisnter.onFetchBalance();
            }
        } else if (obj instanceof CJRVerifyPasscodeResponse) {
            CJRVerifyPasscodeResponse cJRVerifyPasscodeResponse = (CJRVerifyPasscodeResponse) obj;
            if (!TextUtils.isEmpty(cJRVerifyPasscodeResponse.getError())) {
                setAnimation();
                this.pinCvvBottomSheet.pinCvvModel.cvvOrPinTitle.set(null);
                this.pinCvvBottomSheet.pinCvvModel.cvvVisiblity.set(0);
                this.pinCvvBottomSheet.pinCvvModel.loaderVisiblity.set(8);
                return;
            }
            goForTransaction(cJRVerifyPasscodeResponse.getAccessToken());
        }
    }

    public void onResponse(Object obj) {
        handleResponse(obj);
    }

    private void openNextInstrument() {
        if (this.mContext != null) {
            Intent intent = new Intent();
            intent.setAction(SDKConstants.OPEN_AUTO_INSTRUMENT_PPB_POSTPAID);
            a.a(this.mContext.getApplicationContext()).a(intent);
        }
    }

    public Request getVerifyPasscodeRequest(Context context, String str, String str2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("Authorization", MerchantBL.getMerchantInstance().getAuthentication());
            hashMap.put("Content-Type", "application/x-www-form-urlencoded");
            hashMap.put("session_token", MerchantBL.getMerchantInstance().getSsoToken());
            String addAuthDefaultParams = SDKUtility.addAuthDefaultParams(context, NativeSdkGtmLoader.getToken());
            return new VolleyPostRequest(1, addAuthDefaultParams, hashMap, (Map<String, String>) null, "grant_type=" + URLEncoder.encode("password", AppConstants.UTF_8) + "&login_id=" + URLEncoder.encode(MerchantBL.getMerchantInstance().getMobileNumber(), AppConstants.UTF_8) + "&login_secret=" + URLEncoder.encode(str, AppConstants.UTF_8) + "&scope=" + URLEncoder.encode(str2, AppConstants.UTF_8) + "&login_id_type=" + URLEncoder.encode(ContactColumn.PHONE_NUMBER, AppConstants.UTF_8) + "&login_secret_type=" + URLEncoder.encode("passcode", AppConstants.UTF_8), this, this, CJRVerifyPasscodeResponse.class);
        } catch (Exception e2) {
            LogUtility.printStackTrace(e2);
            return null;
        }
    }

    public void setAnimation() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, R.anim.shake_from_left_anim);
        final Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mContext, R.anim.shake_from_right_anim);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
            int count = 0;

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                loadAnimation2.setAnimationListener(new Animation.AnimationListener() {
                    public void onAnimationRepeat(Animation animation) {
                    }

                    public void onAnimationStart(Animation animation) {
                    }

                    public void onAnimationEnd(Animation animation) {
                        if (AnonymousClass3.this.count < 2) {
                            AnonymousClass3.this.count++;
                            DigitalCreditViewModel.this.pinCvvBottomSheet.cvvPinLayoutBinding.etPincvv.startAnimation(loadAnimation);
                        }
                    }
                });
                DigitalCreditViewModel.this.pinCvvBottomSheet.cvvPinLayoutBinding.etPincvv.startAnimation(loadAnimation2);
            }
        });
        this.pinCvvBottomSheet.cvvPinLayoutBinding.etPincvv.startAnimation(loadAnimation);
    }

    public void deselectView() {
        this.digitalCreditLisnter.deselectView();
    }

    public boolean isHybridDisabled() {
        return this.paymentModes.isHybridDisabled();
    }

    public boolean isEmiHybridDisabled() {
        return this.paymentModes.isEmiHybridDisabled();
    }
}
