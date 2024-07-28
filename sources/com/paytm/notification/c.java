package com.paytm.notification;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.paytm.notification.data.datasource.dao.f;
import com.paytm.notification.models.PaytmInbox;
import com.paytm.notification.schedulers.d;
import java.util.List;

public interface c {
    LiveData<List<f>> a();

    void a(PaytmInbox paytmInbox);

    void a(d dVar);

    void b();

    void b(PaytmInbox paytmInbox);

    void c();

    int d();

    y<Integer> e();

    void f();

    void g();
}
