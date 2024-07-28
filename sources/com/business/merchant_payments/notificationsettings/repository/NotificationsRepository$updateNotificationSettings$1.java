package com.business.merchant_payments.notificationsettings.repository;

import androidx.lifecycle.y;
import com.alipay.mobile.h5container.api.H5Event;
import com.appsflyer.internal.referrer.Payload;
import com.business.common_module.utilities.a.b;
import com.business.merchant_payments.notificationsettings.model.NotificationOnOffDataModel;
import kotlin.g.b.k;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public final class NotificationsRepository$updateNotificationSettings$1 implements Callback<NotificationOnOffDataModel> {
    public final /* synthetic */ y $responseObj;

    public NotificationsRepository$updateNotificationSettings$1(y yVar) {
        this.$responseObj = yVar;
    }

    public final void onFailure(Call<NotificationOnOffDataModel> call, Throwable th) {
        this.$responseObj.setValue(b.a(th));
    }

    public final void onResponse(Call<NotificationOnOffDataModel> call, Response<NotificationOnOffDataModel> response) {
        k.d(call, H5Event.TYPE_CALL);
        k.d(response, Payload.RESPONSE);
        if (!response.isSuccessful() || response.body() == null) {
            this.$responseObj.setValue(b.a((Response<?>) response));
        } else {
            this.$responseObj.setValue(b.a(response.body()));
        }
    }
}
