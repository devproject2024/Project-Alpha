package net.one97.paytm.nativesdk.transcation.viewmodel;

import androidx.lifecycle.y;
import com.android.volley.VolleyError;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource;
import net.one97.paytm.nativesdk.transcation.model.OtpApiResponse;

public final class NativePlusPayViewModel$cancelTransaction$1 implements PaymentMethodDataSource.Callback<OtpApiResponse> {
    final /* synthetic */ NativePlusPayViewModel this$0;

    NativePlusPayViewModel$cancelTransaction$1(NativePlusPayViewModel nativePlusPayViewModel) {
        this.this$0 = nativePlusPayViewModel;
    }

    public final void onResponse(OtpApiResponse otpApiResponse) {
        y<OtpApiResponse> otpCancelResponse = this.this$0.getOtpCancelResponse();
        if (otpCancelResponse != null) {
            otpCancelResponse.postValue(otpApiResponse);
        }
    }

    public final void onErrorResponse(VolleyError volleyError, OtpApiResponse otpApiResponse) {
        y<OtpApiResponse> otpCancelResponse = this.this$0.getOtpCancelResponse();
        if (otpCancelResponse != null) {
            otpCancelResponse.postValue(otpApiResponse);
        }
    }
}
