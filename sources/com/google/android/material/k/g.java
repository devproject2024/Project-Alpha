package com.google.android.material.k;

public final class g extends f {

    /* renamed from: a  reason: collision with root package name */
    private final float f36523a;

    /* access modifiers changed from: package-private */
    public final boolean a() {
        return true;
    }

    public g(float f2) {
        this.f36523a = f2 - 0.001f;
    }

    public final void a(float f2, float f3, float f4, o oVar) {
        float sqrt = (float) ((((double) this.f36523a) * Math.sqrt(2.0d)) / 2.0d);
        float sqrt2 = (float) Math.sqrt(Math.pow((double) this.f36523a, 2.0d) - Math.pow((double) sqrt, 2.0d));
        oVar.a(f3 - sqrt, ((float) (-((((double) this.f36523a) * Math.sqrt(2.0d)) - ((double) this.f36523a)))) + sqrt2);
        oVar.b(f3, (float) (-((((double) this.f36523a) * Math.sqrt(2.0d)) - ((double) this.f36523a))));
        oVar.b(f3 + sqrt, ((float) (-((((double) this.f36523a) * Math.sqrt(2.0d)) - ((double) this.f36523a)))) + sqrt2);
    }
}
