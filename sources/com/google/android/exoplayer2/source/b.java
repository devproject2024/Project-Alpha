package com.google.android.exoplayer2.source;

import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.ah;
import com.google.android.exoplayer2.f.ad;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.p;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class b implements o {

    /* renamed from: a  reason: collision with root package name */
    protected final p.a f32800a = new p.a();

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<o.b> f32801b = new ArrayList<>(1);

    /* renamed from: c  reason: collision with root package name */
    private Looper f32802c;

    /* renamed from: d  reason: collision with root package name */
    private ah f32803d;

    /* renamed from: e  reason: collision with root package name */
    private Object f32804e;

    /* access modifiers changed from: protected */
    public abstract void a();

    /* access modifiers changed from: protected */
    public abstract void a(ad adVar);

    /* access modifiers changed from: protected */
    public final void a(ah ahVar, Object obj) {
        this.f32803d = ahVar;
        this.f32804e = obj;
        Iterator<o.b> it2 = this.f32801b.iterator();
        while (it2.hasNext()) {
            it2.next().onSourceInfoRefreshed(this, ahVar, obj);
        }
    }

    /* access modifiers changed from: protected */
    public final p.a a(o.a aVar) {
        return this.f32800a.a(0, aVar, 0);
    }

    /* access modifiers changed from: protected */
    public final p.a a(int i2, o.a aVar) {
        return this.f32800a.a(i2, aVar, 0);
    }

    public final void a(Handler handler, p pVar) {
        p.a aVar = this.f32800a;
        a.a((handler == null || pVar == null) ? false : true);
        aVar.f33231c.add(new p.a.C0549a(handler, pVar));
    }

    public final void a(p pVar) {
        p.a aVar = this.f32800a;
        Iterator<p.a.C0549a> it2 = aVar.f33231c.iterator();
        while (it2.hasNext()) {
            p.a.C0549a next = it2.next();
            if (next.f33234b == pVar) {
                aVar.f33231c.remove(next);
            }
        }
    }

    public final void a(o.b bVar, ad adVar) {
        Looper myLooper = Looper.myLooper();
        Looper looper = this.f32802c;
        a.a(looper == null || looper == myLooper);
        this.f32801b.add(bVar);
        if (this.f32802c == null) {
            this.f32802c = myLooper;
            a(adVar);
            return;
        }
        ah ahVar = this.f32803d;
        if (ahVar != null) {
            bVar.onSourceInfoRefreshed(this, ahVar, this.f32804e);
        }
    }

    public final void a(o.b bVar) {
        this.f32801b.remove(bVar);
        if (this.f32801b.isEmpty()) {
            this.f32802c = null;
            this.f32803d = null;
            this.f32804e = null;
            a();
        }
    }
}
