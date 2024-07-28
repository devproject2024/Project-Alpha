package androidx.constraintlayout.motion.a;

import androidx.constraintlayout.motion.widget.g;
import androidx.constraintlayout.motion.widget.r;

public final class h {

    /* renamed from: g  reason: collision with root package name */
    private static String f2238g = "VelocityMatrix";

    /* renamed from: a  reason: collision with root package name */
    float f2239a;

    /* renamed from: b  reason: collision with root package name */
    float f2240b;

    /* renamed from: c  reason: collision with root package name */
    float f2241c;

    /* renamed from: d  reason: collision with root package name */
    float f2242d;

    /* renamed from: e  reason: collision with root package name */
    float f2243e;

    /* renamed from: f  reason: collision with root package name */
    float f2244f;

    public final void a() {
        this.f2243e = 0.0f;
        this.f2242d = 0.0f;
        this.f2241c = 0.0f;
        this.f2240b = 0.0f;
        this.f2239a = 0.0f;
    }

    public final void a(r rVar, float f2) {
        if (rVar != null) {
            this.f2243e = rVar.b(f2);
            this.f2244f = rVar.a(f2);
        }
    }

    public final void a(r rVar, r rVar2, float f2) {
        if (rVar != null) {
            this.f2241c = rVar.b(f2);
        }
        if (rVar2 != null) {
            this.f2242d = rVar2.b(f2);
        }
    }

    public final void b(r rVar, r rVar2, float f2) {
        if (rVar != null) {
            this.f2239a = rVar.b(f2);
        }
        if (rVar2 != null) {
            this.f2240b = rVar2.b(f2);
        }
    }

    public final void a(g gVar, float f2) {
        if (gVar != null) {
            this.f2243e = gVar.b(f2);
        }
    }

    public final void a(g gVar, g gVar2, float f2) {
        if (gVar != null) {
            this.f2241c = gVar.b(f2);
        }
        if (gVar2 != null) {
            this.f2242d = gVar2.b(f2);
        }
    }

    public final void b(g gVar, g gVar2, float f2) {
        if (gVar != null || gVar2 != null) {
            if (gVar == null) {
                this.f2239a = gVar.b(f2);
            }
            if (gVar2 == null) {
                this.f2240b = gVar2.b(f2);
            }
        }
    }

    public final void a(float f2, float f3, int i2, int i3, float[] fArr) {
        int i4 = i2;
        float f4 = fArr[0];
        float f5 = fArr[1];
        float f6 = (f2 - 0.5f) * 2.0f;
        float f7 = (f3 - 0.5f) * 2.0f;
        float f8 = f4 + this.f2241c;
        float f9 = f5 + this.f2242d;
        float f10 = f8 + (this.f2239a * f6);
        float f11 = f9 + (this.f2240b * f7);
        float radians = (float) Math.toRadians((double) this.f2243e);
        double radians2 = (double) ((float) Math.toRadians((double) this.f2244f));
        double d2 = (double) (((float) i3) * f7);
        fArr[0] = f10 + (((float) ((((double) (((float) (-i4)) * f6)) * Math.sin(radians2)) - (Math.cos(radians2) * d2))) * radians);
        fArr[1] = f11 + (radians * ((float) ((((double) (((float) i4) * f6)) * Math.cos(radians2)) - (d2 * Math.sin(radians2)))));
    }
}
