package com.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.c.a.l;
import com.airbnb.lottie.c.c.a;
import com.airbnb.lottie.g.c;
import com.airbnb.lottie.g.d;
import com.airbnb.lottie.k;
import java.util.Collections;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    public a<PointF, PointF> f5779a;

    /* renamed from: b  reason: collision with root package name */
    public a<?, PointF> f5780b;

    /* renamed from: c  reason: collision with root package name */
    public a<d, d> f5781c;

    /* renamed from: d  reason: collision with root package name */
    public a<Float, Float> f5782d;

    /* renamed from: e  reason: collision with root package name */
    public a<Integer, Integer> f5783e;

    /* renamed from: f  reason: collision with root package name */
    public c f5784f;

    /* renamed from: g  reason: collision with root package name */
    public c f5785g;

    /* renamed from: h  reason: collision with root package name */
    public a<?, Float> f5786h;

    /* renamed from: i  reason: collision with root package name */
    public a<?, Float> f5787i;
    private final Matrix j = new Matrix();
    private final Matrix k;
    private final Matrix l;
    private final Matrix m;
    private final float[] n;

    public o(l lVar) {
        a<PointF, PointF> aVar;
        a<PointF, PointF> aVar2;
        a<d, d> aVar3;
        a<Float, Float> aVar4;
        c cVar;
        c cVar2;
        if (lVar.f5817a == null) {
            aVar = null;
        } else {
            aVar = lVar.f5817a.a();
        }
        this.f5779a = aVar;
        if (lVar.f5818b == null) {
            aVar2 = null;
        } else {
            aVar2 = lVar.f5818b.a();
        }
        this.f5780b = aVar2;
        if (lVar.f5819c == null) {
            aVar3 = null;
        } else {
            aVar3 = lVar.f5819c.a();
        }
        this.f5781c = aVar3;
        if (lVar.f5820d == null) {
            aVar4 = null;
        } else {
            aVar4 = lVar.f5820d.a();
        }
        this.f5782d = aVar4;
        if (lVar.f5822f == null) {
            cVar = null;
        } else {
            cVar = (c) lVar.f5822f.a();
        }
        this.f5784f = cVar;
        if (this.f5784f != null) {
            this.k = new Matrix();
            this.l = new Matrix();
            this.m = new Matrix();
            this.n = new float[9];
        } else {
            this.k = null;
            this.l = null;
            this.m = null;
            this.n = null;
        }
        if (lVar.f5823g == null) {
            cVar2 = null;
        } else {
            cVar2 = (c) lVar.f5823g.a();
        }
        this.f5785g = cVar2;
        if (lVar.f5821e != null) {
            this.f5783e = lVar.f5821e.a();
        }
        if (lVar.f5824h != null) {
            this.f5786h = lVar.f5824h.a();
        } else {
            this.f5786h = null;
        }
        if (lVar.f5825i != null) {
            this.f5787i = lVar.f5825i.a();
        } else {
            this.f5787i = null;
        }
    }

    public final void a(a aVar) {
        aVar.a((a<?, ?>) this.f5783e);
        aVar.a((a<?, ?>) this.f5786h);
        aVar.a((a<?, ?>) this.f5787i);
        aVar.a((a<?, ?>) this.f5779a);
        aVar.a((a<?, ?>) this.f5780b);
        aVar.a((a<?, ?>) this.f5781c);
        aVar.a((a<?, ?>) this.f5782d);
        aVar.a((a<?, ?>) this.f5784f);
        aVar.a((a<?, ?>) this.f5785g);
    }

    public final void a(a.C0083a aVar) {
        a<Integer, Integer> aVar2 = this.f5783e;
        if (aVar2 != null) {
            aVar2.a(aVar);
        }
        a<?, Float> aVar3 = this.f5786h;
        if (aVar3 != null) {
            aVar3.a(aVar);
        }
        a<?, Float> aVar4 = this.f5787i;
        if (aVar4 != null) {
            aVar4.a(aVar);
        }
        a<PointF, PointF> aVar5 = this.f5779a;
        if (aVar5 != null) {
            aVar5.a(aVar);
        }
        a<?, PointF> aVar6 = this.f5780b;
        if (aVar6 != null) {
            aVar6.a(aVar);
        }
        a<d, d> aVar7 = this.f5781c;
        if (aVar7 != null) {
            aVar7.a(aVar);
        }
        a<Float, Float> aVar8 = this.f5782d;
        if (aVar8 != null) {
            aVar8.a(aVar);
        }
        c cVar = this.f5784f;
        if (cVar != null) {
            cVar.a(aVar);
        }
        c cVar2 = this.f5785g;
        if (cVar2 != null) {
            cVar2.a(aVar);
        }
    }

    public final Matrix a() {
        float f2;
        this.j.reset();
        a<?, PointF> aVar = this.f5780b;
        if (aVar != null) {
            PointF f3 = aVar.f();
            if (!(f3.x == 0.0f && f3.y == 0.0f)) {
                this.j.preTranslate(f3.x, f3.y);
            }
        }
        a<Float, Float> aVar2 = this.f5782d;
        if (aVar2 != null) {
            if (aVar2 instanceof p) {
                f2 = aVar2.f().floatValue();
            } else {
                f2 = ((c) aVar2).h();
            }
            if (f2 != 0.0f) {
                this.j.preRotate(f2);
            }
        }
        if (this.f5784f != null) {
            c cVar = this.f5785g;
            float cos = cVar == null ? 0.0f : (float) Math.cos(Math.toRadians((double) ((-cVar.h()) + 90.0f)));
            c cVar2 = this.f5785g;
            float sin = cVar2 == null ? 1.0f : (float) Math.sin(Math.toRadians((double) ((-cVar2.h()) + 90.0f)));
            b();
            float[] fArr = this.n;
            fArr[0] = cos;
            fArr[1] = sin;
            float f4 = -sin;
            fArr[3] = f4;
            fArr[4] = cos;
            fArr[8] = 1.0f;
            this.k.setValues(fArr);
            b();
            float[] fArr2 = this.n;
            fArr2[0] = 1.0f;
            fArr2[3] = (float) Math.tan(Math.toRadians((double) this.f5784f.h()));
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.l.setValues(fArr2);
            b();
            float[] fArr3 = this.n;
            fArr3[0] = cos;
            fArr3[1] = f4;
            fArr3[3] = sin;
            fArr3[4] = cos;
            fArr3[8] = 1.0f;
            this.m.setValues(fArr3);
            this.l.preConcat(this.k);
            this.m.preConcat(this.l);
            this.j.preConcat(this.m);
        }
        a<d, d> aVar3 = this.f5781c;
        if (aVar3 != null) {
            d f5 = aVar3.f();
            if (!(f5.f6153a == 1.0f && f5.f6154b == 1.0f)) {
                this.j.preScale(f5.f6153a, f5.f6154b);
            }
        }
        a<PointF, PointF> aVar4 = this.f5779a;
        if (aVar4 != null) {
            PointF f6 = aVar4.f();
            if (!(f6.x == 0.0f && f6.y == 0.0f)) {
                this.j.preTranslate(-f6.x, -f6.y);
            }
        }
        return this.j;
    }

    private void b() {
        for (int i2 = 0; i2 < 9; i2++) {
            this.n[i2] = 0.0f;
        }
    }

    public final Matrix a(float f2) {
        a<?, PointF> aVar = this.f5780b;
        PointF pointF = null;
        PointF f3 = aVar == null ? null : aVar.f();
        a<d, d> aVar2 = this.f5781c;
        d f4 = aVar2 == null ? null : aVar2.f();
        this.j.reset();
        if (f3 != null) {
            this.j.preTranslate(f3.x * f2, f3.y * f2);
        }
        if (f4 != null) {
            double d2 = (double) f2;
            this.j.preScale((float) Math.pow((double) f4.f6153a, d2), (float) Math.pow((double) f4.f6154b, d2));
        }
        a<Float, Float> aVar3 = this.f5782d;
        if (aVar3 != null) {
            float floatValue = aVar3.f().floatValue();
            a<PointF, PointF> aVar4 = this.f5779a;
            if (aVar4 != null) {
                pointF = aVar4.f();
            }
            Matrix matrix = this.j;
            float f5 = floatValue * f2;
            float f6 = 0.0f;
            float f7 = pointF == null ? 0.0f : pointF.x;
            if (pointF != null) {
                f6 = pointF.y;
            }
            matrix.preRotate(f5, f7, f6);
        }
        return this.j;
    }

    public final <T> boolean a(T t, c<T> cVar) {
        c cVar2;
        c cVar3;
        a<?, Float> aVar;
        a<?, Float> aVar2;
        if (t == k.f6159e) {
            a<PointF, PointF> aVar3 = this.f5779a;
            if (aVar3 == null) {
                this.f5779a = new p(cVar, new PointF());
                return true;
            }
            aVar3.a((c<PointF>) cVar);
            return true;
        } else if (t == k.f6160f) {
            a<?, PointF> aVar4 = this.f5780b;
            if (aVar4 == null) {
                this.f5780b = new p(cVar, new PointF());
                return true;
            }
            aVar4.a((c<PointF>) cVar);
            return true;
        } else if (t == k.k) {
            a<d, d> aVar5 = this.f5781c;
            if (aVar5 == null) {
                this.f5781c = new p(cVar, new d());
                return true;
            }
            aVar5.a((c<d>) cVar);
            return true;
        } else if (t == k.l) {
            a<Float, Float> aVar6 = this.f5782d;
            if (aVar6 == null) {
                this.f5782d = new p(cVar, Float.valueOf(0.0f));
                return true;
            }
            aVar6.a((c<Float>) cVar);
            return true;
        } else if (t == k.f6157c) {
            a<Integer, Integer> aVar7 = this.f5783e;
            if (aVar7 == null) {
                this.f5783e = new p(cVar, 100);
                return true;
            }
            aVar7.a((c<Integer>) cVar);
            return true;
        } else if (t != k.y || (aVar2 = this.f5786h) == null) {
            if (t != k.z || (aVar = this.f5787i) == null) {
                if (t == k.m && (cVar3 = this.f5784f) != null) {
                    if (cVar3 == null) {
                        this.f5784f = new c(Collections.singletonList(new com.airbnb.lottie.g.a(Float.valueOf(0.0f))));
                    }
                    this.f5784f.a(cVar);
                    return true;
                } else if (t != k.n || (cVar2 = this.f5785g) == null) {
                    return false;
                } else {
                    if (cVar2 == null) {
                        this.f5785g = new c(Collections.singletonList(new com.airbnb.lottie.g.a(Float.valueOf(0.0f))));
                    }
                    this.f5785g.a(cVar);
                    return true;
                }
            } else if (aVar == null) {
                this.f5787i = new p(cVar, 100);
                return true;
            } else {
                aVar.a((c<Float>) cVar);
                return true;
            }
        } else if (aVar2 == null) {
            this.f5786h = new p(cVar, 100);
            return true;
        } else {
            aVar2.a((c<Float>) cVar);
            return true;
        }
    }
}
