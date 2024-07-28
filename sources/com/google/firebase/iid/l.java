package com.google.firebase.iid;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.c;
import java.util.concurrent.CountDownLatch;

final /* synthetic */ class l implements c {

    /* renamed from: a  reason: collision with root package name */
    private final CountDownLatch f38871a;

    l(CountDownLatch countDownLatch) {
        this.f38871a = countDownLatch;
    }

    public final void a(Task task) {
        this.f38871a.countDown();
    }
}
