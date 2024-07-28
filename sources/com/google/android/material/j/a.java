package com.google.android.material.j;

import android.graphics.Paint;
import android.graphics.Path;

public final class a {

    /* renamed from: g  reason: collision with root package name */
    public static final int[] f36510g = new int[3];

    /* renamed from: h  reason: collision with root package name */
    public static final float[] f36511h = {0.0f, 0.5f, 1.0f};

    /* renamed from: i  reason: collision with root package name */
    public static final int[] f36512i = new int[4];
    public static final float[] j = {0.0f, 0.0f, 0.5f, 1.0f};

    /* renamed from: a  reason: collision with root package name */
    public final Paint f36513a;

    /* renamed from: b  reason: collision with root package name */
    public final Paint f36514b;

    /* renamed from: c  reason: collision with root package name */
    public final Paint f36515c;

    /* renamed from: d  reason: collision with root package name */
    public int f36516d;

    /* renamed from: e  reason: collision with root package name */
    public int f36517e;

    /* renamed from: f  reason: collision with root package name */
    public int f36518f;
    public final Path k;
    public Paint l;

    public a() {
        this((byte) 0);
    }

    private a(byte b2) {
        this.k = new Path();
        this.l = new Paint();
        this.f36513a = new Paint();
        a(-16777216);
        this.l.setColor(0);
        this.f36514b = new Paint(4);
        this.f36514b.setStyle(Paint.Style.FILL);
        this.f36515c = new Paint(this.f36514b);
    }

    public final void a(int i2) {
        this.f36516d = androidx.core.graphics.a.b(i2, 68);
        this.f36517e = androidx.core.graphics.a.b(i2, 20);
        this.f36518f = androidx.core.graphics.a.b(i2, 0);
        this.f36513a.setColor(this.f36516d);
    }
}
