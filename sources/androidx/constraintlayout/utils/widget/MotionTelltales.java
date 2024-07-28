package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewParent;
import androidx.constraintlayout.motion.a.h;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.g;
import androidx.constraintlayout.motion.widget.n;
import androidx.constraintlayout.motion.widget.o;
import androidx.constraintlayout.motion.widget.p;
import androidx.constraintlayout.motion.widget.r;
import androidx.constraintlayout.widget.R;

public class MotionTelltales extends MockView {

    /* renamed from: b  reason: collision with root package name */
    MotionLayout f2470b;

    /* renamed from: c  reason: collision with root package name */
    float[] f2471c = new float[2];

    /* renamed from: d  reason: collision with root package name */
    Matrix f2472d = new Matrix();

    /* renamed from: e  reason: collision with root package name */
    int f2473e = 0;

    /* renamed from: f  reason: collision with root package name */
    int f2474f = -65281;

    /* renamed from: g  reason: collision with root package name */
    float f2475g = 0.25f;

    /* renamed from: h  reason: collision with root package name */
    private Paint f2476h = new Paint();

    public MotionTelltales(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    public MotionTelltales(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public MotionTelltales(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MotionTelltales);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.MotionTelltales_telltales_tailColor) {
                    this.f2474f = obtainStyledAttributes.getColor(index, this.f2474f);
                } else if (index == R.styleable.MotionTelltales_telltales_velocityMode) {
                    this.f2473e = obtainStyledAttributes.getInt(index, this.f2473e);
                } else if (index == R.styleable.MotionTelltales_telltales_tailScale) {
                    this.f2475g = obtainStyledAttributes.getFloat(index, this.f2475g);
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f2476h.setColor(this.f2474f);
        this.f2476h.setStrokeWidth(5.0f);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void setText(CharSequence charSequence) {
        this.f2461a = charSequence.toString();
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        postInvalidate();
    }

    public void onDraw(Canvas canvas) {
        float f2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        float[] fArr;
        float[] fArr2;
        r rVar;
        r rVar2;
        r rVar3;
        int i7;
        r rVar4;
        MotionTelltales motionTelltales = this;
        super.onDraw(canvas);
        getMatrix().invert(motionTelltales.f2472d);
        if (motionTelltales.f2470b == null) {
            ViewParent parent = getParent();
            if (parent instanceof MotionLayout) {
                motionTelltales.f2470b = (MotionLayout) parent;
                return;
            }
            return;
        }
        int width = getWidth();
        int height = getHeight();
        int i8 = 5;
        float[] fArr3 = {0.1f, 0.25f, 0.5f, 0.75f, 0.9f};
        int i9 = 0;
        while (i9 < i8) {
            float f3 = fArr3[i9];
            int i10 = 0;
            while (i10 < i8) {
                float f4 = fArr3[i10];
                MotionLayout motionLayout = motionTelltales.f2470b;
                float[] fArr4 = motionTelltales.f2471c;
                int i11 = motionTelltales.f2473e;
                float f5 = motionLayout.f2252d;
                float f6 = motionLayout.j;
                if (motionLayout.f2251c != null) {
                    float signum = Math.signum(motionLayout.k - motionLayout.j);
                    float interpolation = motionLayout.f2251c.getInterpolation(motionLayout.j + 1.0E-5f);
                    f2 = motionLayout.f2251c.getInterpolation(motionLayout.j);
                    f5 = (signum * ((interpolation - f2) / 1.0E-5f)) / motionLayout.f2256h;
                } else {
                    f2 = f6;
                }
                if (motionLayout.f2251c instanceof o) {
                    f5 = ((o) motionLayout.f2251c).a();
                }
                float f7 = f5;
                n nVar = motionLayout.f2255g.get(motionTelltales);
                if ((i11 & 1) == 0) {
                    int width2 = getWidth();
                    int height2 = getHeight();
                    float a2 = nVar.a(f2, nVar.o);
                    g gVar = null;
                    r rVar5 = nVar.q == null ? null : nVar.q.get("translationX");
                    fArr = fArr3;
                    if (nVar.q == null) {
                        i6 = i11;
                        rVar = null;
                    } else {
                        rVar = nVar.q.get("translationY");
                        i6 = i11;
                    }
                    i5 = i9;
                    if (nVar.q == null) {
                        i4 = i10;
                        rVar2 = null;
                    } else {
                        rVar2 = nVar.q.get("rotation");
                        i4 = i10;
                    }
                    i3 = height;
                    if (nVar.q == null) {
                        i2 = width;
                        rVar3 = null;
                    } else {
                        rVar3 = nVar.q.get("scaleX");
                        i2 = width;
                    }
                    if (nVar.q == null) {
                        i7 = width2;
                        rVar4 = null;
                    } else {
                        rVar4 = nVar.q.get("scaleY");
                        i7 = width2;
                    }
                    g gVar2 = nVar.r == null ? null : nVar.r.get("translationX");
                    g gVar3 = nVar.r == null ? null : nVar.r.get("translationY");
                    g gVar4 = nVar.r == null ? null : nVar.r.get("rotation");
                    g gVar5 = nVar.r == null ? null : nVar.r.get("scaleX");
                    if (nVar.r != null) {
                        gVar = nVar.r.get("scaleY");
                    }
                    g gVar6 = gVar;
                    h hVar = new h();
                    hVar.a();
                    hVar.a(rVar2, a2);
                    hVar.a(rVar5, rVar, a2);
                    hVar.b(rVar3, rVar4, a2);
                    hVar.a(gVar4, a2);
                    hVar.a(gVar2, gVar3, a2);
                    hVar.b(gVar5, gVar6, a2);
                    g gVar7 = gVar6;
                    if (nVar.f2367h != null) {
                        if (nVar.m.length > 0) {
                            double d2 = (double) a2;
                            nVar.f2367h.a(d2, nVar.m);
                            nVar.f2367h.b(d2, nVar.n);
                            p.a(f4, f3, fArr4, nVar.l, nVar.n);
                        }
                        int i12 = i6;
                        hVar.a(f4, f3, i7, height2, fArr4);
                        fArr2 = fArr4;
                    } else if (nVar.f2366g != null) {
                        double a3 = (double) nVar.a(a2, nVar.o);
                        nVar.f2366g[0].b(a3, nVar.n);
                        nVar.f2366g[0].a(a3, nVar.m);
                        float f8 = nVar.o[0];
                        for (int i13 = 0; i13 < nVar.n.length; i13++) {
                            double[] dArr = nVar.n;
                            dArr[i13] = dArr[i13] * ((double) f8);
                        }
                        p.a(f4, f3, fArr4, nVar.l, nVar.n);
                        fArr2 = fArr4;
                        hVar.a(f4, f3, i7, height2, fArr4);
                    } else {
                        fArr2 = fArr4;
                        g gVar8 = gVar5;
                        float f9 = nVar.f2364e.f2374f - nVar.f2363d.f2374f;
                        float f10 = nVar.f2364e.f2375g - nVar.f2363d.f2375g;
                        g gVar9 = gVar2;
                        float f11 = (nVar.f2364e.f2377i - nVar.f2363d.f2377i) + f10;
                        fArr2[0] = (f9 * (1.0f - f4)) + (((nVar.f2364e.f2376h - nVar.f2363d.f2376h) + f9) * f4);
                        fArr2[1] = (f10 * (1.0f - f3)) + (f11 * f3);
                        hVar.a();
                        hVar.a(rVar2, a2);
                        hVar.a(rVar5, rVar, a2);
                        hVar.b(rVar3, rVar4, a2);
                        hVar.a(gVar4, a2);
                        hVar.a(gVar9, gVar3, a2);
                        hVar.b(gVar8, gVar7, a2);
                        hVar.a(f4, f3, i7, height2, fArr2);
                    }
                } else {
                    i2 = width;
                    i3 = height;
                    fArr = fArr3;
                    i5 = i9;
                    i6 = i11;
                    fArr2 = fArr4;
                    i4 = i10;
                    nVar.a(f2, f4, f3, fArr2);
                }
                if (i6 < 2) {
                    fArr2[0] = fArr2[0] * f7;
                    fArr2[1] = fArr2[1] * f7;
                }
                motionTelltales = this;
                motionTelltales.f2472d.mapVectors(motionTelltales.f2471c);
                width = i2;
                float f12 = ((float) width) * f4;
                height = i3;
                float f13 = ((float) height) * f3;
                float[] fArr5 = motionTelltales.f2471c;
                float f14 = fArr5[0];
                float f15 = motionTelltales.f2475g;
                float f16 = f13 - (fArr5[1] * f15);
                motionTelltales.f2472d.mapVectors(fArr5);
                canvas.drawLine(f12, f13, f12 - (f14 * f15), f16, motionTelltales.f2476h);
                i10 = i4 + 1;
                fArr3 = fArr;
                i9 = i5;
                i8 = 5;
            }
            float[] fArr6 = fArr3;
            i9++;
            i8 = 5;
        }
    }
}
