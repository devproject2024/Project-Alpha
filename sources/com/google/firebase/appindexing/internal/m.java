package com.google.firebase.appindexing.internal;

import android.os.Handler;
import com.google.android.gms.c.a.a.a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.c;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;

final class m implements c<Void>, Executor {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final d<?> f38032a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f38033b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Queue<l> f38034c = new ArrayDeque();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f38035d = 0;

    public m(d<?> dVar) {
        this.f38032a = dVar;
        this.f38033b = new a(dVar.getLooper());
    }

    public final Task<Void> a(zzy zzy) {
        boolean isEmpty;
        l lVar = new l(this, zzy);
        ab<TResult> abVar = lVar.f38030b.f12478a;
        abVar.a((Executor) this, (c<TResult>) this);
        synchronized (this.f38034c) {
            isEmpty = this.f38034c.isEmpty();
            this.f38034c.add(lVar);
        }
        if (isEmpty) {
            lVar.a();
        }
        return abVar;
    }

    public final void a(Task<Void> task) {
        l lVar;
        synchronized (this.f38034c) {
            if (this.f38035d == 2) {
                lVar = this.f38034c.peek();
                s.a(lVar != null);
            } else {
                lVar = null;
            }
            this.f38035d = 0;
        }
        if (lVar != null) {
            lVar.a();
        }
    }

    public final void execute(Runnable runnable) {
        this.f38033b.post(runnable);
    }
}
