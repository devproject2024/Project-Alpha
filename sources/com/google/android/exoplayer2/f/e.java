package com.google.android.exoplayer2.f;

import com.google.android.exoplayer2.f.i;
import com.google.android.exoplayer2.g.ae;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class e implements i {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f32375a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<ad> f32376b = new ArrayList<>(1);

    /* renamed from: c  reason: collision with root package name */
    private int f32377c;

    /* renamed from: d  reason: collision with root package name */
    private l f32378d;

    public /* synthetic */ Map<String, List<String>> b() {
        return i.CC.$default$b(this);
    }

    protected e(boolean z) {
        this.f32375a = z;
    }

    public final void a(ad adVar) {
        if (!this.f32376b.contains(adVar)) {
            this.f32376b.add(adVar);
            this.f32377c++;
        }
    }

    /* access modifiers changed from: protected */
    public final void d() {
        for (int i2 = 0; i2 < this.f32377c; i2++) {
            this.f32376b.get(i2);
        }
    }

    /* access modifiers changed from: protected */
    public final void b(l lVar) {
        this.f32378d = lVar;
        for (int i2 = 0; i2 < this.f32377c; i2++) {
            this.f32376b.get(i2).a(this, lVar, this.f32375a);
        }
    }

    /* access modifiers changed from: protected */
    public final void a(int i2) {
        l lVar = (l) ae.a(this.f32378d);
        for (int i3 = 0; i3 < this.f32377c; i3++) {
            this.f32376b.get(i3).a(this, lVar, this.f32375a, i2);
        }
    }

    /* access modifiers changed from: protected */
    public final void e() {
        l lVar = (l) ae.a(this.f32378d);
        for (int i2 = 0; i2 < this.f32377c; i2++) {
            this.f32376b.get(i2).b(this, lVar, this.f32375a);
        }
        this.f32378d = null;
    }
}
