package com.airbnb.lottie.g;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.airbnb.lottie.d;

public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final d f6134a;

    /* renamed from: b  reason: collision with root package name */
    public final T f6135b;

    /* renamed from: c  reason: collision with root package name */
    public T f6136c;

    /* renamed from: d  reason: collision with root package name */
    public final Interpolator f6137d;

    /* renamed from: e  reason: collision with root package name */
    public final float f6138e;

    /* renamed from: f  reason: collision with root package name */
    public Float f6139f;

    /* renamed from: g  reason: collision with root package name */
    public float f6140g;

    /* renamed from: h  reason: collision with root package name */
    public float f6141h;

    /* renamed from: i  reason: collision with root package name */
    public int f6142i;
    public int j;
    public PointF k;
    public PointF l;
    private float m;
    private float n;

    public a(d dVar, T t, T t2, Interpolator interpolator, float f2, Float f3) {
        this.f6140g = -3987645.8f;
        this.f6141h = -3987645.8f;
        this.f6142i = 784923401;
        this.j = 784923401;
        this.m = Float.MIN_VALUE;
        this.n = Float.MIN_VALUE;
        this.k = null;
        this.l = null;
        this.f6134a = dVar;
        this.f6135b = t;
        this.f6136c = t2;
        this.f6137d = interpolator;
        this.f6138e = f2;
        this.f6139f = f3;
    }

    public a(T t) {
        this.f6140g = -3987645.8f;
        this.f6141h = -3987645.8f;
        this.f6142i = 784923401;
        this.j = 784923401;
        this.m = Float.MIN_VALUE;
        this.n = Float.MIN_VALUE;
        this.k = null;
        this.l = null;
        this.f6134a = null;
        this.f6135b = t;
        this.f6136c = t;
        this.f6137d = null;
        this.f6138e = Float.MIN_VALUE;
        this.f6139f = Float.valueOf(Float.MAX_VALUE);
    }

    public final float b() {
        d dVar = this.f6134a;
        if (dVar == null) {
            return 0.0f;
        }
        if (this.m == Float.MIN_VALUE) {
            this.m = (this.f6138e - dVar.j) / this.f6134a.b();
        }
        return this.m;
    }

    public final float c() {
        if (this.f6134a == null) {
            return 1.0f;
        }
        if (this.n == Float.MIN_VALUE) {
            if (this.f6139f == null) {
                this.n = 1.0f;
            } else {
                this.n = b() + ((this.f6139f.floatValue() - this.f6138e) / this.f6134a.b());
            }
        }
        return this.n;
    }

    public final boolean d() {
        return this.f6137d == null;
    }

    public final boolean a(float f2) {
        return f2 >= b() && f2 < c();
    }

    public String toString() {
        return "Keyframe{startValue=" + this.f6135b + ", endValue=" + this.f6136c + ", startFrame=" + this.f6138e + ", endFrame=" + this.f6139f + ", interpolator=" + this.f6137d + '}';
    }
}
