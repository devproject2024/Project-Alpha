package com.business.merchant_payments.payment.viewmodel;

import com.alipay.mobile.h5container.api.H5Event;
import com.appsflyer.internal.referrer.Payload;
import com.business.common_module.utilities.a.b;
import com.business.merchant_payments.model.nonMigratedPayments.NonMigratedPaymentsModel;
import kotlin.g.b.k;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public final class PaymentsListViewModel$callNonMigratedPaymentsAPI$1 implements Callback<NonMigratedPaymentsModel> {
    public final /* synthetic */ PaymentsListViewModel this$0;

    public PaymentsListViewModel$callNonMigratedPaymentsAPI$1(PaymentsListViewModel paymentsListViewModel) {
        this.this$0 = paymentsListViewModel;
    }

    public final void onFailure(Call<NonMigratedPaymentsModel> call, Throwable th) {
        k.d(call, H5Event.TYPE_CALL);
        k.d(th, "t");
        this.this$0.getMNonMigratedPaymentsAPIData().setValue(b.a(th));
    }

    public final void onResponse(Call<NonMigratedPaymentsModel> call, Response<NonMigratedPaymentsModel> response) {
        k.d(call, H5Event.TYPE_CALL);
        k.d(response, Payload.RESPONSE);
        if (response.isSuccessful()) {
            this.this$0.getMNonMigratedPaymentsAPIData().setValue(b.a(response, response.body()));
        } else {
            this.this$0.getMNonMigratedPaymentsAPIData().setValue(b.b(response, response.body()));
        }
    }
}
