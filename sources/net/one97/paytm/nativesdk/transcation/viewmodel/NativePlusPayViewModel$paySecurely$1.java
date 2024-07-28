package net.one97.paytm.nativesdk.transcation.viewmodel;

import androidx.lifecycle.y;
import com.android.volley.VolleyError;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource;
import net.one97.paytm.nativesdk.transcation.model.OtpApiResponse;

public final class NativePlusPayViewModel$paySecurely$1 implements PaymentMethodDataSource.Callback<OtpApiResponse> {
    final /* synthetic */ NativePlusPayViewModel this$0;

    NativePlusPayViewModel$paySecurely$1(NativePlusPayViewModel nativePlusPayViewModel) {
        this.this$0 = nativePlusPayViewModel;
    }

    public final void onResponse(OtpApiResponse otpApiResponse) {
        y<OtpApiResponse> otpSubmitResponse = this.this$0.getOtpSubmitResponse();
        if (otpSubmitResponse != null) {
            otpSubmitResponse.postValue(otpApiResponse);
        }
    }

    public final void onErrorResponse(VolleyError volleyError, OtpApiResponse otpApiResponse) {
        y<OtpApiResponse> otpSubmitResponse = this.this$0.getOtpSubmitResponse();
        if (otpSubmitResponse != null) {
            otpSubmitResponse.postValue(otpApiResponse);
        }
    }
}
