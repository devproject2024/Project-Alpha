package com.business.merchant_payments.notificationsettings.repository;

import androidx.lifecycle.y;
import com.alipay.mobile.h5container.api.H5Event;
import com.appsflyer.internal.referrer.Payload;
import com.business.common_module.utilities.a.b;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.notificationsettings.model.MerchantProfileResponse;
import kotlin.g.b.k;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public final class NotificationsRepository$updateMerchantProfileSecondary$1 implements Callback<MerchantProfileResponse> {
    public final /* synthetic */ String $screenName;
    public final /* synthetic */ y $secondaryMutableLiveData;
    public final /* synthetic */ long $startTime;

    public NotificationsRepository$updateMerchantProfileSecondary$1(long j, String str, y yVar) {
        this.$startTime = j;
        this.$screenName = str;
        this.$secondaryMutableLiveData = yVar;
    }

    public final void onResponse(Call<MerchantProfileResponse> call, Response<MerchantProfileResponse> response) {
        k.d(call, H5Event.TYPE_CALL);
        k.d(response, Payload.RESPONSE);
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        instance.getEventPublisher();
        response.code();
        if (!response.isSuccessful() || response.body() == null) {
            this.$secondaryMutableLiveData.setValue(b.a((Response<?>) response));
        } else {
            this.$secondaryMutableLiveData.setValue(b.a(response, response.body()));
        }
    }

    public final void onFailure(Call<MerchantProfileResponse> call, Throwable th) {
        k.d(call, H5Event.TYPE_CALL);
        k.d(th, "t");
        this.$secondaryMutableLiveData.setValue(b.a(th));
    }
}
