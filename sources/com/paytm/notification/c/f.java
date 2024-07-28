package com.paytm.notification.c;

import com.paytm.notification.models.NotificationUserConfig;
import com.paytm.notification.models.request.DeviceDetails;
import com.paytm.notification.models.request.FetchInboxRequest;
import com.paytm.notification.models.request.Messaging;
import com.paytm.notification.models.request.TokenRegisterRequest;
import com.paytm.notification.models.request.User;
import easypay.manager.Constants;
import java.util.ArrayList;
import kotlin.g.b.k;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final f f43030a = new f();

    private f() {
    }

    public static TokenRegisterRequest a(String str, NotificationUserConfig notificationUserConfig) {
        k.c(str, "fcmToken");
        k.c(notificationUserConfig, Constants.EASY_PAY_CONFIG_PREF_KEY);
        TokenRegisterRequest tokenRegisterRequest = new TokenRegisterRequest();
        User user = new User();
        user.setId(notificationUserConfig.getCustomerId$paytmnotification_paytmRelease());
        tokenRegisterRequest.setUser(user);
        Messaging messaging = new Messaging();
        messaging.setFcmToken(str);
        tokenRegisterRequest.setMessaging(messaging);
        return tokenRegisterRequest;
    }

    public static TokenRegisterRequest a(String str, NotificationUserConfig notificationUserConfig, DeviceDetails deviceDetails, boolean z) {
        k.c(str, "fcmToken");
        k.c(notificationUserConfig, Constants.EASY_PAY_CONFIG_PREF_KEY);
        k.c(deviceDetails, "deviceDetails");
        TokenRegisterRequest tokenRegisterRequest = new TokenRegisterRequest();
        if (notificationUserConfig.getAppLanguage$paytmnotification_paytmRelease() != null) {
            deviceDetails.setLanguage(notificationUserConfig.getAppLanguage$paytmnotification_paytmRelease());
        }
        if (notificationUserConfig.getAppVersion$paytmnotification_paytmRelease() != null) {
            deviceDetails.setVersion(notificationUserConfig.getAppVersion$paytmnotification_paytmRelease());
        }
        deviceDetails.setClient(notificationUserConfig.getClientName$paytmnotification_paytmRelease());
        tokenRegisterRequest.setDeviceDetails(deviceDetails);
        User user = new User();
        if (z) {
            user.setId(notificationUserConfig.getCustomerId$paytmnotification_paytmRelease());
        }
        if (!(user.getId() == null && user.getToken() == null)) {
            tokenRegisterRequest.setUser(user);
        }
        Messaging messaging = new Messaging();
        messaging.setFcmToken(str);
        tokenRegisterRequest.setMessaging(messaging);
        return tokenRegisterRequest;
    }

    public static FetchInboxRequest a(String str, ArrayList<String> arrayList) {
        k.c(str, "deviceId");
        FetchInboxRequest fetchInboxRequest = new FetchInboxRequest();
        fetchInboxRequest.setDevice(str);
        fetchInboxRequest.setTag((String) null);
        fetchInboxRequest.setOrder((String) null);
        fetchInboxRequest.setIds(arrayList);
        return fetchInboxRequest;
    }
}
