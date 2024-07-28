package com.business.merchant_payments.payment.viewmodel;

import com.alipay.mobile.h5container.api.H5Event;
import com.appsflyer.internal.referrer.Payload;
import com.business.common_module.utilities.a.b;
import com.business.merchant_payments.model.orderList.V2OrderListModel;
import kotlin.g.b.k;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public final class PaymentsListViewModel$callV2OrderListApiForDate$1 implements Callback<V2OrderListModel> {
    public final /* synthetic */ PaymentsListViewModel this$0;

    public PaymentsListViewModel$callV2OrderListApiForDate$1(PaymentsListViewModel paymentsListViewModel) {
        this.this$0 = paymentsListViewModel;
    }

    public final void onFailure(Call<V2OrderListModel> call, Throwable th) {
        k.d(call, H5Event.TYPE_CALL);
        k.d(th, "t");
        this.this$0.getMorePaymentsForDateAPIData().setValue(b.a(th));
    }

    public final void onResponse(Call<V2OrderListModel> call, Response<V2OrderListModel> response) {
        k.d(call, H5Event.TYPE_CALL);
        k.d(response, Payload.RESPONSE);
        if (response.isSuccessful()) {
            this.this$0.getMorePaymentsForDateAPIData().setValue(b.a(response, response.body()));
        } else {
            this.this$0.getMorePaymentsForDateAPIData().setValue(b.b(response, response.body()));
        }
    }
}
