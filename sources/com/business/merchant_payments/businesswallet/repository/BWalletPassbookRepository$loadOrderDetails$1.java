package com.business.merchant_payments.businesswallet.repository;

import androidx.lifecycle.y;
import com.alipay.mobile.h5container.api.H5Event;
import com.appsflyer.internal.referrer.Payload;
import com.business.common_module.utilities.LogUtility;
import com.business.common_module.utilities.a.b;
import com.business.merchant_payments.model.businesswallet.BWalletOrderDetails;
import kotlin.g.b.k;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public final class BWalletPassbookRepository$loadOrderDetails$1 implements Callback<BWalletOrderDetails> {
    public final /* synthetic */ y $responseObj;

    public BWalletPassbookRepository$loadOrderDetails$1(y yVar) {
        this.$responseObj = yVar;
    }

    public final void onFailure(Call<BWalletOrderDetails> call, Throwable th) {
        LogUtility.d(BWalletPassbookRepository.TAG, "error in loadOrderDetails api");
        this.$responseObj.setValue(b.a(th));
    }

    public final void onResponse(Call<BWalletOrderDetails> call, Response<BWalletOrderDetails> response) {
        k.d(call, H5Event.TYPE_CALL);
        k.d(response, Payload.RESPONSE);
        if (!response.isSuccessful() || response.body() == null) {
            this.$responseObj.setValue(b.a((Response<?>) response));
            return;
        }
        BWalletOrderDetails body = response.body();
        if (body != null) {
            this.$responseObj.setValue(b.a(response, body));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.business.merchant_payments.model.businesswallet.BWalletOrderDetails");
    }
}
