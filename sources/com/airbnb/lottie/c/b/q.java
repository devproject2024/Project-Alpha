package com.airbnb.lottie.c.b;

import com.airbnb.lottie.a.a.c;
import com.airbnb.lottie.a.a.s;
import com.airbnb.lottie.c.a.b;
import com.airbnb.lottie.f;

public final class q implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f5914a;

    /* renamed from: b  reason: collision with root package name */
    public final a f5915b;

    /* renamed from: c  reason: collision with root package name */
    public final b f5916c;

    /* renamed from: d  reason: collision with root package name */
    public final b f5917d;

    /* renamed from: e  reason: collision with root package name */
    public final b f5918e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f5919f;

    public enum a {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static a forId(int i2) {
            if (i2 == 1) {
                return SIMULTANEOUSLY;
            }
            if (i2 == 2) {
                return INDIVIDUALLY;
            }
            throw new IllegalArgumentException("Unknown trim path type ".concat(String.valueOf(i2)));
        }
    }

    public q(String str, a aVar, b bVar, b bVar2, b bVar3, boolean z) {
        this.f5914a = str;
        this.f5915b = aVar;
        this.f5916c = bVar;
        this.f5917d = bVar2;
        this.f5918e = bVar3;
        this.f5919f = z;
    }

    public final c a(f fVar, com.airbnb.lottie.c.c.a aVar) {
        return new s(aVar, this);
    }

    public final String toString() {
        return "Trim Path: {start: " + this.f5916c + ", end: " + this.f5917d + ", offset: " + this.f5918e + "}";
    }
}
