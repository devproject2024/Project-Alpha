package com.google.firebase.appindexing.internal;

import com.google.android.gms.common.internal.s;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.f;
import java.util.concurrent.Executor;

final class l {

    /* renamed from: a  reason: collision with root package name */
    final zzy f38029a;

    /* renamed from: b  reason: collision with root package name */
    final f<Void> f38030b = new f<>();

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ m f38031c;

    public l(m mVar, zzy zzy) {
        this.f38031c = mVar;
        this.f38029a = zzy;
    }

    public final void a() {
        synchronized (this.f38031c.f38034c) {
            s.a(this.f38031c.f38035d == 0);
            int unused = this.f38031c.f38035d = 1;
        }
        this.f38031c.f38032a.doWrite(new n(this)).a((Executor) this.f38031c, (OnFailureListener) new o(this));
    }
}
