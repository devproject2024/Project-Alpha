package com.google.android.exoplayer2.f.a;

import java.io.File;

public final class g implements Comparable<g> {

    /* renamed from: a  reason: collision with root package name */
    public final String f32339a;

    /* renamed from: b  reason: collision with root package name */
    public final long f32340b;

    /* renamed from: c  reason: collision with root package name */
    public final long f32341c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f32342d;

    /* renamed from: e  reason: collision with root package name */
    public final File f32343e;

    public final /* synthetic */ int compareTo(Object obj) {
        g gVar = (g) obj;
        if (!this.f32339a.equals(gVar.f32339a)) {
            return this.f32339a.compareTo(gVar.f32339a);
        }
        int i2 = ((this.f32340b - gVar.f32340b) > 0 ? 1 : ((this.f32340b - gVar.f32340b) == 0 ? 0 : -1));
        if (i2 == 0) {
            return 0;
        }
        return i2 < 0 ? -1 : 1;
    }

    public final boolean a() {
        return this.f32341c == -1;
    }

    public final boolean b() {
        return !this.f32342d;
    }
}
