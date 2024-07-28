package net.one97.paytm.nativesdk.otp.viewmodel;

import android.content.Context;
import android.view.View;
import androidx.databinding.ObservableInt;
import androidx.databinding.a;
import androidx.databinding.i;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.nativesdk.Gtm.NativeSdkGtmLoader;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.NetworkHandler.VolleyPostRequest;
import net.one97.paytm.nativesdk.NetworkHandler.VolleyRequestQueue;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.common.model.CustomVolleyError;
import net.one97.paytm.nativesdk.login.models.SendOTPResponse;
import net.one97.paytm.nativesdk.otp.Listner.OTPListner;
import net.one97.paytm.nativesdk.otp.Model.ValidateOtpResponse;
import net.one97.paytm.nativesdk.otp.OTPUtility.OtpUtility;
import net.one97.paytm.nativesdk.otp.RequestGenerator.OtpRequester;

public class OtpViewModel extends a implements Response.ErrorListener, Response.Listener {
    public ObservableInt lytErrorMsgsVisblity = new ObservableInt();
    private Context mContext;
    public i<String> mErrorMsg = new i<>();
    private i<String> mMobileNo = new i<>();
    public i<String> mOtp = new i<>();
    private String mToken;
    public ObservableInt otpEdittextVisiblity = new ObservableInt();
    private OTPListner otpListner;
    public ObservableInt progressBarVisiblity = new ObservableInt();
    public ObservableInt txtOtpSentVisiblity = new ObservableInt();
    public ObservableInt validatingOtpViewVisiblity = new ObservableInt();

    public OtpViewModel(Context context, String str, OTPListner oTPListner) {
        this.mMobileNo.set(str);
        this.otpListner = oTPListner;
        this.mContext = context;
        this.validatingOtpViewVisiblity.set(8);
        this.otpEdittextVisiblity.set(0);
        this.txtOtpSentVisiblity.set(0);
        this.lytErrorMsgsVisblity.set(4);
        this.progressBarVisiblity.set(8);
    }

    public void setmToken(String str) {
        this.mToken = str;
    }

    public void onErrorResponse(VolleyError volleyError) {
        if (volleyError instanceof CustomVolleyError) {
            CustomVolleyError customVolleyError = (CustomVolleyError) volleyError;
            if (customVolleyError.getUrl().contains(NativeSdkGtmLoader.getValidateOtp(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId()))) {
                this.mErrorMsg.set("Something went wrong");
                this.validatingOtpViewVisiblity.set(8);
                this.otpEdittextVisiblity.set(0);
                this.txtOtpSentVisiblity.set(8);
                this.lytErrorMsgsVisblity.set(0);
                this.otpListner.onFailureOTPSend("Something went wrong");
            } else if (customVolleyError.getUrl().contains(NativeSdkGtmLoader.getOtpUrl(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId()))) {
                this.mErrorMsg.set("Something went wrong");
                this.validatingOtpViewVisiblity.set(8);
                this.otpEdittextVisiblity.set(0);
                this.txtOtpSentVisiblity.set(8);
                this.lytErrorMsgsVisblity.set(0);
                this.otpListner.onFailureOTPSend("Something went wrong");
            }
        }
        new StringBuilder().append(volleyError.toString());
    }

    public void onResponse(Object obj) {
        if (obj instanceof SendOTPResponse) {
            this.progressBarVisiblity.set(8);
            SendOTPResponse sendOTPResponse = (SendOTPResponse) obj;
            if (OtpUtility.isOTPSentSuccessfully(sendOTPResponse.getBody())) {
                this.otpListner.resendOtpDisable();
            } else {
                this.otpListner.onFailureOTPSend(OtpUtility.getMessageFromServerResponse(sendOTPResponse.getBody()));
            }
        } else if (obj instanceof ValidateOtpResponse) {
            ValidateOtpResponse validateOtpResponse = (ValidateOtpResponse) obj;
            this.validatingOtpViewVisiblity.set(8);
            this.otpEdittextVisiblity.set(0);
            if (OtpUtility.isOTPValidatedSuccessfully(validateOtpResponse.getBody())) {
                this.otpListner.onVerifyOTP(true);
                return;
            }
            this.mErrorMsg.set(validateOtpResponse.getBody().getResultInfo().getResultMsg());
            this.lytErrorMsgsVisblity.set(0);
            this.otpListner.onFailureOTPSend(OtpUtility.getMessageFromServerResponse(validateOtpResponse.getBody()));
        }
    }

    public void onOtpReceived(Context context, CharSequence charSequence) {
        if (charSequence.length() == 6) {
            this.mOtp.set(charSequence.toString());
            Request validateOTPRequest = getValidateOTPRequest();
            if (SDKUtility.isNetworkAvailable(context)) {
                VolleyRequestQueue.getInstance(context).addToRequestQueue(validateOTPRequest);
                this.validatingOtpViewVisiblity.set(0);
                this.otpEdittextVisiblity.set(8);
                return;
            }
            this.otpListner.onNetworkUnavailable(validateOTPRequest);
            return;
        }
        this.lytErrorMsgsVisblity.set(4);
        this.mErrorMsg.set("");
    }

    public void setmOtp(String str) {
        this.mOtp.set(str);
    }

    public void handleResendOtpClick(View view) {
        Request oTPRequest = getOTPRequest();
        if (SDKUtility.isNetworkAvailable(this.mContext)) {
            VolleyRequestQueue.getInstance(this.mContext).addToRequestQueue(oTPRequest);
            this.mOtp.set("");
            this.progressBarVisiblity.set(0);
            this.txtOtpSentVisiblity.set(0);
            this.lytErrorMsgsVisblity.set(4);
            return;
        }
        this.otpListner.onNetworkUnavailable(oTPRequest);
    }

    private Request getValidateOTPRequest() {
        new HashMap();
        VolleyPostRequest volleyPostRequest = new VolleyPostRequest(1, NativeSdkGtmLoader.getValidateOtp(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId()), (Map<String, String>) null, (Map<String, String>) null, OtpRequester.createValidateOtpRequest(this.mOtp.get()), this, this, ValidateOtpResponse.class);
        volleyPostRequest.setRetryPolicy(new DefaultRetryPolicy(2500, 2, 1.0f));
        return volleyPostRequest;
    }

    private Request getOTPRequest() {
        new HashMap();
        VolleyPostRequest volleyPostRequest = new VolleyPostRequest(1, NativeSdkGtmLoader.getOtpUrl(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId()), (Map<String, String>) null, (Map<String, String>) null, OtpRequester.createSendOtpRequest(this.mMobileNo.get()), this, this, SendOTPResponse.class);
        volleyPostRequest.setRetryPolicy(new DefaultRetryPolicy(2500, 2, 1.0f));
        return volleyPostRequest;
    }
}
