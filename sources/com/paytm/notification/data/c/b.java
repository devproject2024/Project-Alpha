package com.paytm.notification.data.c;

import com.paytm.notification.data.datasource.dao.i;
import com.paytm.notification.models.PaytmInbox;
import com.paytm.notification.models.PushMessage;
import java.util.ArrayList;
import java.util.List;

public interface b {
    void a();

    void a(int i2);

    void a(int i2, int i3);

    void a(i iVar);

    void a(PaytmInbox paytmInbox);

    void a(PushMessage pushMessage);

    void a(PushMessage pushMessage, String str);

    void a(PushMessage pushMessage, boolean z);

    void a(String str, String str2);

    void a(String str, String str2, String str3);

    void a(String str, ArrayList<String> arrayList);

    void b();

    void b(int i2);

    void b(PaytmInbox paytmInbox);

    void b(PushMessage pushMessage);

    void b(PushMessage pushMessage, String str);

    void b(String str, String str2);

    List<i> c();

    void c(PushMessage pushMessage);

    void c(PushMessage pushMessage, String str);

    void c(String str, String str2);

    int d();

    void d(PushMessage pushMessage);

    void d(String str, String str2);

    void e(PushMessage pushMessage);

    void e(String str, String str2);

    void f(String str, String str2);

    void g(String str, String str2);
}
