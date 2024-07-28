package com.google.android.material.appbar;

import android.view.View;
import androidx.core.h.u;

final class a {

    /* renamed from: a  reason: collision with root package name */
    int f35873a;

    /* renamed from: b  reason: collision with root package name */
    int f35874b;

    /* renamed from: c  reason: collision with root package name */
    int f35875c;

    /* renamed from: d  reason: collision with root package name */
    boolean f35876d = true;

    /* renamed from: e  reason: collision with root package name */
    boolean f35877e = true;

    /* renamed from: f  reason: collision with root package name */
    private final View f35878f;

    /* renamed from: g  reason: collision with root package name */
    private int f35879g;

    public a(View view) {
        this.f35878f = view;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.f35873a = this.f35878f.getTop();
        this.f35879g = this.f35878f.getLeft();
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        View view = this.f35878f;
        u.f(view, this.f35874b - (view.getTop() - this.f35873a));
        View view2 = this.f35878f;
        u.g(view2, this.f35875c - (view2.getLeft() - this.f35879g));
    }

    public final boolean a(int i2) {
        if (!this.f35876d || this.f35874b == i2) {
            return false;
        }
        this.f35874b = i2;
        b();
        return true;
    }

    public final boolean b(int i2) {
        if (!this.f35877e || this.f35875c == i2) {
            return false;
        }
        this.f35875c = i2;
        b();
        return true;
    }
}
