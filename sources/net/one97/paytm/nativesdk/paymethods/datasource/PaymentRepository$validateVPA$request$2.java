package net.one97.paytm.nativesdk.paymethods.datasource;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource;

final class PaymentRepository$validateVPA$request$2 implements Response.ErrorListener {
    final /* synthetic */ PaymentMethodDataSource.Callback $callback;

    PaymentRepository$validateVPA$request$2(PaymentMethodDataSource.Callback callback) {
        this.$callback = callback;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        if (SDKUtility.isAppInvokeFlow()) {
            SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_API_ERROR_RESPONSE, "Validate VPA"));
            k.a((Object) volleyError, "error");
            SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_ERROR_MESSAGE_RESPONSE, volleyError.getLocalizedMessage()));
        }
        this.$callback.onErrorResponse(volleyError, null);
    }
}
