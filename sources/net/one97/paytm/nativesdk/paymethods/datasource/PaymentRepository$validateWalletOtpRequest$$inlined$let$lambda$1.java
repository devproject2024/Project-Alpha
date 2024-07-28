package net.one97.paytm.nativesdk.paymethods.datasource;

import com.android.volley.Response;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource;
import net.one97.paytm.nativesdk.walletOtp.WalletOtpResponse;

final class PaymentRepository$validateWalletOtpRequest$$inlined$let$lambda$1<T> implements Response.Listener<WalletOtpResponse> {
    final /* synthetic */ PaymentMethodDataSource.Callback $callback$inlined;
    final /* synthetic */ String $otp$inlined;
    final /* synthetic */ PaymentRepository this$0;

    PaymentRepository$validateWalletOtpRequest$$inlined$let$lambda$1(PaymentRepository paymentRepository, String str, PaymentMethodDataSource.Callback callback) {
        this.this$0 = paymentRepository;
        this.$otp$inlined = str;
        this.$callback$inlined = callback;
    }

    public final void onResponse(WalletOtpResponse walletOtpResponse) {
        k.c(walletOtpResponse, "walletResponse");
        this.$callback$inlined.onResponse(walletOtpResponse);
    }
}
