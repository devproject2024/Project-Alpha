package com.business.merchant_payments.mapqr.repository;

import androidx.lifecycle.y;
import com.alipay.mobile.h5container.api.H5Event;
import com.appsflyer.internal.referrer.Payload;
import com.business.common_module.utilities.LogUtility;
import com.business.common_module.utilities.a.b;
import com.google.gson.l;
import kotlin.g.b.k;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public final class QRSurveyRepo$saveQRSurveyResponse$2 implements Callback<l> {
    public final /* synthetic */ y $responseObj;

    public QRSurveyRepo$saveQRSurveyResponse$2(y yVar) {
        this.$responseObj = yVar;
    }

    public final void onFailure(Call<l> call, Throwable th) {
        LogUtility.d(QRSurveyRepo.TAG, "error in SaveQRResponse api");
        this.$responseObj.setValue(b.a(th));
    }

    public final void onResponse(Call<l> call, Response<l> response) {
        k.d(call, H5Event.TYPE_CALL);
        k.d(response, Payload.RESPONSE);
        if (!response.isSuccessful() || response.body() == null) {
            this.$responseObj.setValue(b.a((Response<?>) response));
        } else {
            this.$responseObj.setValue(b.a(response.body()));
        }
    }
}
