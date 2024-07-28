package com.paytm.notification.data.c;

import com.paytm.notification.data.a.a;
import com.paytm.notification.models.NotificationProjectConfig;
import com.paytm.notification.models.NotificationUserConfig;
import com.paytm.notification.models.request.TokenRegisterRequest;
import com.paytm.pai.network.model.EventResponse;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

public interface h {
    NotificationProjectConfig a(NotificationProjectConfig notificationProjectConfig) throws Exception;

    NotificationUserConfig a();

    EventResponse<Map<String, String>> a(TokenRegisterRequest tokenRegisterRequest, String str, String str2, String str3) throws a, MalformedURLException;

    EventResponse<?> a(TokenRegisterRequest tokenRegisterRequest, String str, String str2, String str3, String str4) throws a, MalformedURLException;

    EventResponse<HashMap<String, String>> a(String str, String str2, String str3) throws a, MalformedURLException;

    void a(NotificationUserConfig notificationUserConfig);

    void a(String str);

    void a(boolean z);

    String b();

    void b(String str);

    long c();

    void c(String str);

    boolean d();

    boolean e();

    String f();

    NotificationProjectConfig g();

    void h();

    void i();

    String j();
}
