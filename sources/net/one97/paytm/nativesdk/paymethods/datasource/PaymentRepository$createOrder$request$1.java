package net.one97.paytm.nativesdk.paymethods.datasource;

import android.text.TextUtils;
import com.android.volley.Response;
import kotlin.m.p;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.common.model.CreateOrderResponse;
import net.one97.paytm.nativesdk.common.model.CustomVolleyError;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource;

final class PaymentRepository$createOrder$request$1<T> implements Response.Listener<CreateOrderResponse> {
    final /* synthetic */ PaymentMethodDataSource.Callback $callback;

    PaymentRepository$createOrder$request$1(PaymentMethodDataSource.Callback callback) {
        this.$callback = callback;
    }

    public final void onResponse(CreateOrderResponse createOrderResponse) {
        String str = null;
        if (p.a(createOrderResponse != null ? createOrderResponse.getStatus() : null, "success", true)) {
            if (!TextUtils.isEmpty(createOrderResponse != null ? createOrderResponse.getORDER_ID() : null)) {
                this.$callback.onResponse(createOrderResponse);
                return;
            }
        }
        if (SDKUtility.isAppInvokeFlow()) {
            SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_API_ERROR_RESPONSE, "Create Order"));
            if (createOrderResponse != null) {
                str = createOrderResponse.getMessage();
            }
            SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_ERROR_MESSAGE_RESPONSE, str));
        }
        this.$callback.onErrorResponse(new CustomVolleyError(""), createOrderResponse);
    }
}
