package com.google.android.exoplayer2.e.f;

import android.text.Layout;
import com.google.android.exoplayer2.g.a;

final class d {

    /* renamed from: a  reason: collision with root package name */
    String f31571a;

    /* renamed from: b  reason: collision with root package name */
    int f31572b;

    /* renamed from: c  reason: collision with root package name */
    boolean f31573c;

    /* renamed from: d  reason: collision with root package name */
    int f31574d;

    /* renamed from: e  reason: collision with root package name */
    boolean f31575e;

    /* renamed from: f  reason: collision with root package name */
    int f31576f = -1;

    /* renamed from: g  reason: collision with root package name */
    int f31577g = -1;

    /* renamed from: h  reason: collision with root package name */
    int f31578h = -1;

    /* renamed from: i  reason: collision with root package name */
    int f31579i = -1;
    int j = -1;
    float k;
    String l;
    d m;
    Layout.Alignment n;

    public final int a() {
        if (this.f31578h == -1 && this.f31579i == -1) {
            return -1;
        }
        int i2 = 0;
        int i3 = this.f31578h == 1 ? 1 : 0;
        if (this.f31579i == 1) {
            i2 = 2;
        }
        return i3 | i2;
    }

    public final d a(boolean z) {
        a.b(this.m == null);
        this.f31576f = z ? 1 : 0;
        return this;
    }

    public final d b(boolean z) {
        a.b(this.m == null);
        this.f31577g = z ? 1 : 0;
        return this;
    }

    public final d a(int i2) {
        a.b(this.m == null);
        this.f31572b = i2;
        this.f31573c = true;
        return this;
    }

    public final d b(int i2) {
        this.f31574d = i2;
        this.f31575e = true;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final d a(d dVar) {
        if (dVar != null) {
            if (!this.f31573c && dVar.f31573c) {
                a(dVar.f31572b);
            }
            if (this.f31578h == -1) {
                this.f31578h = dVar.f31578h;
            }
            if (this.f31579i == -1) {
                this.f31579i = dVar.f31579i;
            }
            if (this.f31571a == null) {
                this.f31571a = dVar.f31571a;
            }
            if (this.f31576f == -1) {
                this.f31576f = dVar.f31576f;
            }
            if (this.f31577g == -1) {
                this.f31577g = dVar.f31577g;
            }
            if (this.n == null) {
                this.n = dVar.n;
            }
            if (this.j == -1) {
                this.j = dVar.j;
                this.k = dVar.k;
            }
            if (!this.f31575e && dVar.f31575e) {
                b(dVar.f31574d);
            }
        }
        return this;
    }
}
