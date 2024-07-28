package net.one97.paytm.nativesdk.app;

import net.one97.paytm.nativesdk.common.model.CreateOrderModel;
import net.one97.paytm.nativesdk.common.model.CreateOrderResponse;
import net.one97.paytm.nativesdk.common.model.CustomVolleyError;

public interface OnOrderCreatedListener {
    void onOrderCreated(CreateOrderResponse createOrderResponse);

    void onOrderCreationError(CustomVolleyError customVolleyError, CreateOrderModel createOrderModel);
}
