package net.one97.paytm.nativesdk.login.viewmodel;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import androidx.databinding.ObservableInt;
import androidx.databinding.a;
import androidx.databinding.i;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.business.merchant_payments.common.utility.AppUtility;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.Gtm.NativeSdkGtmLoader;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.NetworkHandler.VolleyPostRequest;
import net.one97.paytm.nativesdk.NetworkHandler.VolleyRequestQueue;
import net.one97.paytm.nativesdk.Utils.LogUtility;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.common.Requester.APIReqtGenerator;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.common.model.CustomVolleyError;
import net.one97.paytm.nativesdk.login.listeners.LoginListeners;
import net.one97.paytm.nativesdk.login.models.SendOTPResponse;
import net.one97.paytm.nativesdk.otp.OTPUtility.OtpUtility;
import net.one97.paytm.nativesdk.otp.RequestGenerator.OtpRequester;

public class LoginViewModel extends a implements Response.ErrorListener, Response.Listener {
    private String TAG = getClass().getCanonicalName();
    private LoginListeners loginListeners;
    public i<String> mAmount = new i<>();
    public i<String> mAmountDec = new i<>();
    private Context mContext;
    public i<String> mMobileNo = new i<>();
    private Dialog mProgressDialog;
    private String mToken;
    public ObservableInt progressbarVisiblity = new ObservableInt();

    public LoginViewModel(Context context, String str, LoginListeners loginListeners2, String str2) {
        this.mToken = str;
        this.mContext = context;
        this.loginListeners = loginListeners2;
        this.progressbarVisiblity.set(8);
        setAmount(str2);
    }

    public void handleLoginClick(View view) {
        int mobileNumberValidateStatus = getMobileNumberValidateStatus();
        if (mobileNumberValidateStatus != 1) {
            this.loginListeners.errorOnMobileNumber(mobileNumberValidateStatus);
            return;
        }
        this.loginListeners.errorOnMobileNumber(mobileNumberValidateStatus);
        Request oTPRequest = getOTPRequest();
        oTPRequest.setRetryPolicy(new DefaultRetryPolicy(2500, 2, 1.0f));
        if (SDKUtility.isNetworkAvailable(this.mContext)) {
            VolleyRequestQueue.getInstance(this.mContext).addToRequestQueue(oTPRequest);
            this.progressbarVisiblity.set(0);
            return;
        }
        this.loginListeners.onNetworkUnavailable(oTPRequest);
    }

    private Request getOTPRequest() {
        new HashMap();
        return new VolleyPostRequest(1, NativeSdkGtmLoader.getOtpUrl(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId()), (Map<String, String>) null, (Map<String, String>) null, OtpRequester.createSendOtpRequest(this.mMobileNo.get()), this, this, SendOTPResponse.class);
    }

    public void callFetchPayAPI() {
        Request fetchInstrumentRequest = getFetchInstrumentRequest();
        if (SDKUtility.isNetworkAvailable(this.mContext)) {
            VolleyRequestQueue.getInstance(this.mContext).addToRequestQueue(fetchInstrumentRequest);
        } else {
            this.loginListeners.onNetworkUnavailable(fetchInstrumentRequest);
        }
    }

    private Request getFetchInstrumentRequest() {
        new HashMap();
        VolleyPostRequest volleyPostRequest = new VolleyPostRequest(1, SDKUtility.addAuthDefaultParams(this.mContext, NativeSdkGtmLoader.getFetchPay(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId())), (Map<String, String>) null, (Map<String, String>) null, APIReqtGenerator.createJsonForFetchAPILogin(SDKConstants.ALL_TYPE), this, this, CJPayMethodResponse.class);
        volleyPostRequest.setRetryPolicy(new DefaultRetryPolicy(2500, 2, 1.0f));
        return volleyPostRequest;
    }

    public String getmToken() {
        return this.mToken;
    }

    public void onErrorResponse(VolleyError volleyError) {
        if (volleyError instanceof CustomVolleyError) {
            CustomVolleyError customVolleyError = (CustomVolleyError) volleyError;
            if (customVolleyError.getUrl().contains(NativeSdkGtmLoader.getOtpUrl(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId()))) {
                this.progressbarVisiblity.set(8);
                this.loginListeners.onFailureOTPSend("Something went wrong");
            } else if (customVolleyError.getUrl().contains(NativeSdkGtmLoader.getFetchPay(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId()))) {
                Toast.makeText(this.mContext, "Something went wrong", 1).show();
            }
            LogUtility.d(this.TAG, volleyError.toString());
        }
    }

    public void onResponse(Object obj) {
        if (obj instanceof SendOTPResponse) {
            this.progressbarVisiblity.set(8);
            SendOTPResponse sendOTPResponse = (SendOTPResponse) obj;
            if (OtpUtility.isOTPSentSuccessfully(sendOTPResponse.getBody())) {
                this.loginListeners.onOTPSend(this.mMobileNo.get());
            } else {
                this.loginListeners.onFailureOTPSend(OtpUtility.getMessageFromServerResponse(sendOTPResponse.getBody()));
            }
        } else if (obj instanceof CJPayMethodResponse) {
            DirectPaymentBL.getInstance().setResponse((CJPayMethodResponse) obj);
            this.loginListeners.setPayMethodViews();
        }
    }

    public void onTextChanged(Context context, CharSequence charSequence) {
        this.loginListeners.hideOtpFragment();
        this.mMobileNo.set(charSequence.toString());
        this.loginListeners.errorOnMobileNumber(1);
        if (charSequence.length() == 10) {
            this.loginListeners.hideKeyboard();
        }
    }

    private int getMobileNumberValidateStatus() {
        i<String> iVar = this.mMobileNo;
        if (iVar == null) {
            return 2;
        }
        if (TextUtils.isEmpty(iVar.get())) {
            return -1;
        }
        return !SDKUtility.isValidMobileNo(this.mContext, this.mMobileNo.get()) ? 0 : 1;
    }

    private void setAmount(String str) {
        if (str.contains(AppUtility.CENTER_DOT)) {
            this.mAmount.set(str.substring(0, str.indexOf(AppUtility.CENTER_DOT)));
            this.mAmountDec.set(str.substring(str.indexOf(AppUtility.CENTER_DOT), str.length()));
            return;
        }
        this.mAmount.set(str);
        this.mAmountDec.set(".00");
    }
}
