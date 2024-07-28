package com.airbnb.lottie.c.b;

import com.airbnb.lottie.a.a.c;
import com.airbnb.lottie.a.a.l;
import com.airbnb.lottie.f;
import com.airbnb.lottie.f.d;

public final class h implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f5865a;

    /* renamed from: b  reason: collision with root package name */
    public final a f5866b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f5867c;

    public enum a {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static a forId(int i2) {
            if (i2 == 1) {
                return MERGE;
            }
            if (i2 == 2) {
                return ADD;
            }
            if (i2 == 3) {
                return SUBTRACT;
            }
            if (i2 == 4) {
                return INTERSECT;
            }
            if (i2 != 5) {
                return MERGE;
            }
            return EXCLUDE_INTERSECTIONS;
        }
    }

    public h(String str, a aVar, boolean z) {
        this.f5865a = str;
        this.f5866b = aVar;
        this.f5867c = z;
    }

    public final String toString() {
        return "MergePaths{mode=" + this.f5866b + '}';
    }

    public final c a(f fVar, com.airbnb.lottie.c.c.a aVar) {
        if (fVar.o) {
            return new l(this);
        }
        d.a("Animation contains merge paths but they are disabled.");
        return null;
    }
}
