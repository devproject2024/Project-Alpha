package com.google.android.play.core.c;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.play.core.b.b;
import com.google.android.play.core.d.as;
import com.google.android.play.core.splitcompat.r;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public abstract class c<StateT> {

    /* renamed from: a  reason: collision with root package name */
    private final IntentFilter f37331a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f37332b;

    /* renamed from: c  reason: collision with root package name */
    private b f37333c = null;

    /* renamed from: d  reason: collision with root package name */
    public final b f37334d;

    /* renamed from: e  reason: collision with root package name */
    protected final Set<a<StateT>> f37335e = new HashSet();

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f37336f = false;

    protected c(b bVar, IntentFilter intentFilter, Context context) {
        this.f37334d = bVar;
        this.f37331a = intentFilter;
        this.f37332b = as.a(context);
    }

    private final void b() {
        b bVar;
        if ((this.f37336f || !this.f37335e.isEmpty()) && this.f37333c == null) {
            this.f37333c = new b(this);
            this.f37332b.registerReceiver(this.f37333c, this.f37331a);
        }
        if (!this.f37336f && this.f37335e.isEmpty() && (bVar = this.f37333c) != null) {
            this.f37332b.unregisterReceiver(bVar);
            this.f37333c = null;
        }
    }

    /* access modifiers changed from: protected */
    public abstract void a(Context context, Intent intent);

    public final synchronized void a(a<StateT> aVar) {
        this.f37334d.d("registerListener", new Object[0]);
        r.a(aVar, (Object) "Registered Play Core listener should not be null.");
        this.f37335e.add(aVar);
        b();
    }

    public final synchronized void a(StateT statet) {
        Iterator it2 = new HashSet(this.f37335e).iterator();
        while (it2.hasNext()) {
            ((a) it2.next()).onStateUpdate(statet);
        }
    }

    public final synchronized void a(boolean z) {
        this.f37336f = z;
        b();
    }

    public final synchronized boolean a() {
        return this.f37333c != null;
    }

    public final synchronized void b(a<StateT> aVar) {
        this.f37334d.d("unregisterListener", new Object[0]);
        r.a(aVar, (Object) "Unregistered Play Core listener should not be null.");
        this.f37335e.remove(aVar);
        b();
    }
}
