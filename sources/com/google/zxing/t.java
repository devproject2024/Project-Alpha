package com.google.zxing;

import com.google.zxing.b.a.a;

public class t {

    /* renamed from: a  reason: collision with root package name */
    public final float f40584a;

    /* renamed from: b  reason: collision with root package name */
    public final float f40585b;

    public t(float f2, float f3) {
        this.f40584a = f2;
        this.f40585b = f3;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof t) {
            t tVar = (t) obj;
            if (this.f40584a == tVar.f40584a && this.f40585b == tVar.f40585b) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f40584a) * 31) + Float.floatToIntBits(this.f40585b);
    }

    public final String toString() {
        return "(" + this.f40584a + ',' + this.f40585b + ')';
    }

    public static void a(t[] tVarArr) {
        t tVar;
        t tVar2;
        t tVar3;
        float a2 = a(tVarArr[0], tVarArr[1]);
        float a3 = a(tVarArr[1], tVarArr[2]);
        float a4 = a(tVarArr[0], tVarArr[2]);
        if (a3 >= a2 && a3 >= a4) {
            tVar3 = tVarArr[0];
            tVar2 = tVarArr[1];
            tVar = tVarArr[2];
        } else if (a4 < a3 || a4 < a2) {
            tVar3 = tVarArr[2];
            tVar2 = tVarArr[0];
            tVar = tVarArr[1];
        } else {
            tVar3 = tVarArr[1];
            tVar2 = tVarArr[0];
            tVar = tVarArr[2];
        }
        float f2 = tVar3.f40584a;
        float f3 = tVar3.f40585b;
        if (((tVar.f40584a - f2) * (tVar2.f40585b - f3)) - ((tVar.f40585b - f3) * (tVar2.f40584a - f2)) < 0.0f) {
            t tVar4 = tVar;
            tVar = tVar2;
            tVar2 = tVar4;
        }
        tVarArr[0] = tVar2;
        tVarArr[1] = tVar3;
        tVarArr[2] = tVar;
    }

    public static float a(t tVar, t tVar2) {
        return a.a(tVar.f40584a, tVar.f40585b, tVar2.f40584a, tVar2.f40585b);
    }
}
