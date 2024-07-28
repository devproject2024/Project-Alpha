package com.business.merchant_payments.notificationsettings.repository;

import androidx.lifecycle.y;
import com.alipay.mobile.h5container.api.H5Event;
import com.appsflyer.internal.referrer.Payload;
import com.business.common_module.utilities.a.b;
import com.business.merchant_payments.notificationsettings.model.NotificationsSettingsDataModel;
import kotlin.g.b.k;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public final class NotificationsRepository$getNotificationSettings$1 implements Callback<NotificationsSettingsDataModel> {
    public final /* synthetic */ y $mutableLiveData;

    public NotificationsRepository$getNotificationSettings$1(y yVar) {
        this.$mutableLiveData = yVar;
    }

    public final void onResponse(Call<NotificationsSettingsDataModel> call, Response<NotificationsSettingsDataModel> response) {
        k.d(call, H5Event.TYPE_CALL);
        k.d(response, Payload.RESPONSE);
        if (!response.isSuccessful() || response.body() == null) {
            this.$mutableLiveData.setValue(b.a((Response<?>) response));
        } else {
            this.$mutableLiveData.setValue(b.a(response, response.body()));
        }
    }

    public final void onFailure(Call<NotificationsSettingsDataModel> call, Throwable th) {
        this.$mutableLiveData.setValue(b.a(th));
    }
}
