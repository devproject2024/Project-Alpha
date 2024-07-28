package com.google.android.play.core.d.b;

import android.content.Intent;
import android.os.SystemClock;
import java.util.List;

final class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ long f37391a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ List f37392b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ List f37393c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ List f37394d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ a f37395e;

    i(a aVar, long j, List list, List list2, List list3) {
        this.f37395e = aVar;
        this.f37391a = j;
        this.f37392b = list;
        this.f37393c = list2;
        this.f37394d = list3;
    }

    public final void run() {
        long j = this.f37391a / 3;
        long j2 = 0;
        int i2 = 0;
        while (((long) i2) < 3) {
            j2 = Math.min(this.f37391a, j2 + j);
            this.f37395e.a(2, 0, Long.valueOf(j2), (Long) null, (List<String>) null, (Integer) null, (List<String>) null);
            i2++;
            SystemClock.sleep(a.f37367b);
        }
        if (this.f37395e.m.get()) {
            this.f37395e.a(6, -6, (Long) null, (Long) null, (List<String>) null, (Integer) null, (List<String>) null);
        } else {
            this.f37395e.a((List<Intent>) this.f37392b, (List<String>) this.f37393c, (List<String>) this.f37394d, this.f37391a, false);
        }
    }
}
