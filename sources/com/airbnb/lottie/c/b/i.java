package com.airbnb.lottie.c.b;

import android.graphics.PointF;
import com.airbnb.lottie.a.a.c;
import com.airbnb.lottie.a.a.n;
import com.airbnb.lottie.c.a.b;
import com.airbnb.lottie.c.a.m;
import com.airbnb.lottie.f;

public final class i implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f5868a;

    /* renamed from: b  reason: collision with root package name */
    public final a f5869b;

    /* renamed from: c  reason: collision with root package name */
    public final b f5870c;

    /* renamed from: d  reason: collision with root package name */
    public final m<PointF, PointF> f5871d;

    /* renamed from: e  reason: collision with root package name */
    public final b f5872e;

    /* renamed from: f  reason: collision with root package name */
    public final b f5873f;

    /* renamed from: g  reason: collision with root package name */
    public final b f5874g;

    /* renamed from: h  reason: collision with root package name */
    public final b f5875h;

    /* renamed from: i  reason: collision with root package name */
    public final b f5876i;
    public final boolean j;

    public enum a {
        STAR(1),
        POLYGON(2);
        
        private final int value;

        private a(int i2) {
            this.value = i2;
        }

        public static a forValue(int i2) {
            for (a aVar : values()) {
                if (aVar.value == i2) {
                    return aVar;
                }
            }
            return null;
        }
    }

    public i(String str, a aVar, b bVar, m<PointF, PointF> mVar, b bVar2, b bVar3, b bVar4, b bVar5, b bVar6, boolean z) {
        this.f5868a = str;
        this.f5869b = aVar;
        this.f5870c = bVar;
        this.f5871d = mVar;
        this.f5872e = bVar2;
        this.f5873f = bVar3;
        this.f5874g = bVar4;
        this.f5875h = bVar5;
        this.f5876i = bVar6;
        this.j = z;
    }

    public final c a(f fVar, com.airbnb.lottie.c.c.a aVar) {
        return new n(fVar, aVar, this);
    }
}
