package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.StateSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.h.u;
import com.google.android.material.R;
import com.google.android.material.a.h;
import com.google.android.material.internal.g;
import com.google.android.material.k.m;
import com.google.android.material.k.p;
import java.util.ArrayList;
import java.util.Iterator;

public class d {

    /* renamed from: a  reason: collision with root package name */
    static final TimeInterpolator f36331a = com.google.android.material.a.a.f35802c;
    static final int[] t = {16842919, 16842910};
    static final int[] u = {16843623, 16842908, 16842910};
    static final int[] v = {16842908, 16842910};
    static final int[] w = {16843623, 16842910};
    static final int[] x = {16842910};
    static final int[] y = new int[0];
    final com.google.android.material.j.b A;
    ViewTreeObserver.OnPreDrawListener B;
    private final com.google.android.material.internal.g C;
    private h D;
    private h E;
    /* access modifiers changed from: private */
    public Animator F;
    /* access modifiers changed from: private */
    public float G = 1.0f;
    /* access modifiers changed from: private */
    public int H = 0;
    private final Rect I = new Rect();
    private final RectF J = new RectF();
    private final RectF K = new RectF();
    private final Matrix L = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    m f36332b;

    /* renamed from: c  reason: collision with root package name */
    com.google.android.material.k.h f36333c;

    /* renamed from: d  reason: collision with root package name */
    Drawable f36334d;

    /* renamed from: e  reason: collision with root package name */
    c f36335e;

    /* renamed from: f  reason: collision with root package name */
    Drawable f36336f;

    /* renamed from: g  reason: collision with root package name */
    boolean f36337g;

    /* renamed from: h  reason: collision with root package name */
    boolean f36338h = true;

    /* renamed from: i  reason: collision with root package name */
    float f36339i;
    float j;
    float k;
    int l;
    h m;
    h n;
    float o;
    int p;
    public ArrayList<Animator.AnimatorListener> q;
    public ArrayList<Animator.AnimatorListener> r;
    public ArrayList<C0605d> s;
    final FloatingActionButton z;

    /* renamed from: com.google.android.material.floatingactionbutton.d$d  reason: collision with other inner class name */
    interface C0605d {
        void a();

        void b();
    }

    interface e {
        void a();

        void b();
    }

    /* access modifiers changed from: package-private */
    public void g() {
    }

    /* access modifiers changed from: package-private */
    public boolean i() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean j() {
        return true;
    }

    d(FloatingActionButton floatingActionButton, com.google.android.material.j.b bVar) {
        this.z = floatingActionButton;
        this.A = bVar;
        this.C = new com.google.android.material.internal.g();
        this.C.a(t, a((g) new c()));
        this.C.a(u, a((g) new b()));
        this.C.a(v, a((g) new b()));
        this.C.a(w, a((g) new b()));
        this.C.a(x, a((g) new f()));
        this.C.a(y, a((g) new a()));
        this.o = this.z.getRotation();
    }

    /* access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i2) {
        this.f36333c = k();
        this.f36333c.setTintList(colorStateList);
        if (mode != null) {
            this.f36333c.setTintMode(mode);
        }
        this.f36333c.k();
        this.f36333c.a(this.z.getContext());
        com.google.android.material.i.a aVar = new com.google.android.material.i.a(this.f36333c.G.f36536a);
        aVar.setTintList(com.google.android.material.i.b.b(colorStateList2));
        this.f36334d = aVar;
        this.f36336f = new LayerDrawable(new Drawable[]{(Drawable) androidx.core.g.f.a(this.f36333c), aVar});
    }

    /* access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        Drawable drawable = this.f36334d;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, com.google.android.material.i.b.b(colorStateList));
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(float f2) {
        if (this.f36339i != f2) {
            this.f36339i = f2;
            a(this.f36339i, this.j, this.k);
        }
    }

    /* access modifiers changed from: package-private */
    public float a() {
        return this.f36339i;
    }

    /* access modifiers changed from: package-private */
    public final void b(float f2) {
        if (this.j != f2) {
            this.j = f2;
            a(this.f36339i, this.j, this.k);
        }
    }

    /* access modifiers changed from: package-private */
    public final void c(float f2) {
        if (this.k != f2) {
            this.k = f2;
            a(this.f36339i, this.j, this.k);
        }
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        e(this.G);
    }

    private void e(float f2) {
        this.G = f2;
        Matrix matrix = this.L;
        a(f2, matrix);
        this.z.setImageMatrix(matrix);
    }

    private void a(float f2, Matrix matrix) {
        matrix.reset();
        Drawable drawable = this.z.getDrawable();
        if (drawable != null && this.p != 0) {
            RectF rectF = this.J;
            RectF rectF2 = this.K;
            rectF.set(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
            int i2 = this.p;
            rectF2.set(0.0f, 0.0f, (float) i2, (float) i2);
            matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            int i3 = this.p;
            matrix.postScale(f2, f2, ((float) i3) / 2.0f, ((float) i3) / 2.0f);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(m mVar) {
        this.f36332b = mVar;
        com.google.android.material.k.h hVar = this.f36333c;
        if (hVar != null) {
            hVar.setShapeAppearanceModel(mVar);
        }
        Drawable drawable = this.f36334d;
        if (drawable instanceof p) {
            ((p) drawable).setShapeAppearanceModel(mVar);
        }
        c cVar = this.f36335e;
        if (cVar != null) {
            cVar.a(mVar);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean c() {
        return !this.f36337g || this.z.getSizeDimension() >= this.l;
    }

    /* access modifiers changed from: package-private */
    public void a(float f2, float f3, float f4) {
        h();
        d(f2);
    }

    /* access modifiers changed from: package-private */
    public final void d(float f2) {
        com.google.android.material.k.h hVar = this.f36333c;
        if (hVar != null) {
            hVar.r(f2);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int[] iArr) {
        g.a aVar;
        com.google.android.material.internal.g gVar = this.C;
        int size = gVar.f36464a.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                aVar = null;
                break;
            }
            aVar = gVar.f36464a.get(i2);
            if (StateSet.stateSetMatches(aVar.f36469a, iArr)) {
                break;
            }
            i2++;
        }
        if (aVar != gVar.f36465b) {
            if (!(gVar.f36465b == null || gVar.f36466c == null)) {
                gVar.f36466c.cancel();
                gVar.f36466c = null;
            }
            gVar.f36465b = aVar;
            if (aVar != null) {
                gVar.f36466c = aVar.f36470b;
                gVar.f36466c.start();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void d() {
        com.google.android.material.internal.g gVar = this.C;
        if (gVar.f36466c != null) {
            gVar.f36466c.end();
            gVar.f36466c = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(final e eVar, final boolean z2) {
        if (!m()) {
            Animator animator = this.F;
            if (animator != null) {
                animator.cancel();
            }
            if (q()) {
                h hVar = this.n;
                if (hVar == null) {
                    hVar = p();
                }
                AnimatorSet a2 = a(hVar, 0.0f, 0.0f, 0.0f);
                a2.addListener(new AnimatorListenerAdapter() {

                    /* renamed from: d  reason: collision with root package name */
                    private boolean f36343d;

                    public final void onAnimationStart(Animator animator) {
                        d.this.z.a(0, z2);
                        int unused = d.this.H = 1;
                        Animator unused2 = d.this.F = animator;
                        this.f36343d = false;
                    }

                    public final void onAnimationCancel(Animator animator) {
                        this.f36343d = true;
                    }

                    public final void onAnimationEnd(Animator animator) {
                        int unused = d.this.H = 0;
                        Animator unused2 = d.this.F = null;
                        if (!this.f36343d) {
                            d.this.z.a(z2 ? 8 : 4, z2);
                            e eVar = eVar;
                            if (eVar != null) {
                                eVar.b();
                            }
                        }
                    }
                });
                ArrayList<Animator.AnimatorListener> arrayList = this.r;
                if (arrayList != null) {
                    Iterator<Animator.AnimatorListener> it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        a2.addListener(it2.next());
                    }
                }
                a2.start();
                return;
            }
            this.z.a(z2 ? 8 : 4, z2);
            if (eVar != null) {
                eVar.b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(final e eVar, final boolean z2) {
        if (!l()) {
            Animator animator = this.F;
            if (animator != null) {
                animator.cancel();
            }
            if (q()) {
                if (this.z.getVisibility() != 0) {
                    this.z.setAlpha(0.0f);
                    this.z.setScaleY(0.0f);
                    this.z.setScaleX(0.0f);
                    e(0.0f);
                }
                h hVar = this.m;
                if (hVar == null) {
                    hVar = o();
                }
                AnimatorSet a2 = a(hVar, 1.0f, 1.0f, 1.0f);
                a2.addListener(new AnimatorListenerAdapter() {
                    public final void onAnimationStart(Animator animator) {
                        d.this.z.a(0, z2);
                        int unused = d.this.H = 2;
                        Animator unused2 = d.this.F = animator;
                    }

                    public final void onAnimationEnd(Animator animator) {
                        int unused = d.this.H = 0;
                        Animator unused2 = d.this.F = null;
                        e eVar = eVar;
                        if (eVar != null) {
                            eVar.a();
                        }
                    }
                });
                ArrayList<Animator.AnimatorListener> arrayList = this.q;
                if (arrayList != null) {
                    Iterator<Animator.AnimatorListener> it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        a2.addListener(it2.next());
                    }
                }
                a2.start();
                return;
            }
            this.z.a(0, z2);
            this.z.setAlpha(1.0f);
            this.z.setScaleY(1.0f);
            this.z.setScaleX(1.0f);
            e(1.0f);
            if (eVar != null) {
                eVar.a();
            }
        }
    }

    private h o() {
        if (this.D == null) {
            this.D = h.a(this.z.getContext(), R.animator.design_fab_show_motion_spec);
        }
        return (h) androidx.core.g.f.a(this.D);
    }

    private h p() {
        if (this.E == null) {
            this.E = h.a(this.z.getContext(), R.animator.design_fab_hide_motion_spec);
        }
        return (h) androidx.core.g.f.a(this.E);
    }

    private AnimatorSet a(h hVar, float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.z, View.ALPHA, new float[]{f2});
        hVar.a("opacity").a((Animator) ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.z, View.SCALE_X, new float[]{f3});
        hVar.a("scale").a((Animator) ofFloat2);
        a(ofFloat2);
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.z, View.SCALE_Y, new float[]{f3});
        hVar.a("scale").a((Animator) ofFloat3);
        a(ofFloat3);
        arrayList.add(ofFloat3);
        a(f4, this.L);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.z, new com.google.android.material.a.f(), new com.google.android.material.a.g() {
            /* renamed from: a */
            public final Matrix evaluate(float f2, Matrix matrix, Matrix matrix2) {
                float unused = d.this.G = f2;
                return super.evaluate(f2, matrix, matrix2);
            }
        }, new Matrix[]{new Matrix(this.L)});
        hVar.a("iconScale").a((Animator) ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        com.google.android.material.a.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    private void a(ObjectAnimator objectAnimator) {
        if (Build.VERSION.SDK_INT == 26) {
            objectAnimator.setEvaluator(new TypeEvaluator<Float>() {

                /* renamed from: a  reason: collision with root package name */
                FloatEvaluator f36348a = new FloatEvaluator();

                public final /* synthetic */ Object evaluate(float f2, Object obj, Object obj2) {
                    float floatValue = this.f36348a.evaluate(f2, (Float) obj, (Float) obj2).floatValue();
                    if (floatValue < 0.1f) {
                        floatValue = 0.0f;
                    }
                    return Float.valueOf(floatValue);
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public final void e() {
        ArrayList<C0605d> arrayList = this.s;
        if (arrayList != null) {
            Iterator<C0605d> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                it2.next().a();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void f() {
        ArrayList<C0605d> arrayList = this.s;
        if (arrayList != null) {
            Iterator<C0605d> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                it2.next().b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void h() {
        Rect rect = this.I;
        a(rect);
        b(rect);
        this.A.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* access modifiers changed from: package-private */
    public void a(Rect rect) {
        int sizeDimension = this.f36337g ? (this.l - this.z.getSizeDimension()) / 2 : 0;
        float a2 = this.f36338h ? a() + this.k : 0.0f;
        int max = Math.max(sizeDimension, (int) Math.ceil((double) a2));
        int max2 = Math.max(sizeDimension, (int) Math.ceil((double) (a2 * 1.5f)));
        rect.set(max, max2, max, max2);
    }

    private void b(Rect rect) {
        androidx.core.g.f.a(this.f36336f, "Didn't initialize content background");
        if (i()) {
            this.A.a(new InsetDrawable(this.f36336f, rect.left, rect.top, rect.right, rect.bottom));
            return;
        }
        this.A.a(this.f36336f);
    }

    /* access modifiers changed from: package-private */
    public com.google.android.material.k.h k() {
        return new com.google.android.material.k.h((m) androidx.core.g.f.a(this.f36332b));
    }

    public final boolean l() {
        return this.z.getVisibility() != 0 ? this.H == 2 : this.H != 1;
    }

    public final boolean m() {
        return this.z.getVisibility() == 0 ? this.H == 1 : this.H != 2;
    }

    private static ValueAnimator a(g gVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(f36331a);
        valueAnimator.setDuration(100);
        valueAnimator.addListener(gVar);
        valueAnimator.addUpdateListener(gVar);
        valueAnimator.setFloatValues(new float[]{0.0f, 1.0f});
        return valueAnimator;
    }

    abstract class g extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        private boolean f36355a;

        /* renamed from: c  reason: collision with root package name */
        private float f36357c;

        /* renamed from: d  reason: collision with root package name */
        private float f36358d;

        /* access modifiers changed from: protected */
        public abstract float a();

        private g() {
        }

        /* synthetic */ g(d dVar, byte b2) {
            this();
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float f2;
            if (!this.f36355a) {
                if (d.this.f36333c == null) {
                    f2 = 0.0f;
                } else {
                    f2 = d.this.f36333c.G.o;
                }
                this.f36357c = f2;
                this.f36358d = a();
                this.f36355a = true;
            }
            d dVar = d.this;
            float f3 = this.f36357c;
            dVar.d((float) ((int) (f3 + ((this.f36358d - f3) * valueAnimator.getAnimatedFraction()))));
        }

        public void onAnimationEnd(Animator animator) {
            d.this.d((float) ((int) this.f36358d));
            this.f36355a = false;
        }
    }

    class f extends g {
        f() {
            super(d.this, (byte) 0);
        }

        /* access modifiers changed from: protected */
        public final float a() {
            return d.this.f36339i;
        }
    }

    class b extends g {
        b() {
            super(d.this, (byte) 0);
        }

        /* access modifiers changed from: protected */
        public final float a() {
            return d.this.f36339i + d.this.j;
        }
    }

    class c extends g {
        c() {
            super(d.this, (byte) 0);
        }

        /* access modifiers changed from: protected */
        public final float a() {
            return d.this.f36339i + d.this.k;
        }
    }

    class a extends g {
        /* access modifiers changed from: protected */
        public final float a() {
            return 0.0f;
        }

        a() {
            super(d.this, (byte) 0);
        }
    }

    private boolean q() {
        return u.J(this.z) && !this.z.isInEditMode();
    }

    /* access modifiers changed from: package-private */
    public void n() {
        int i2;
        if (Build.VERSION.SDK_INT == 19) {
            if (this.o % 90.0f != 0.0f) {
                if (this.z.getLayerType() != 1) {
                    this.z.setLayerType(1, (Paint) null);
                }
            } else if (this.z.getLayerType() != 0) {
                this.z.setLayerType(0, (Paint) null);
            }
        }
        com.google.android.material.k.h hVar = this.f36333c;
        if (hVar != null && hVar.G.t != (i2 = (int) this.o)) {
            hVar.G.t = i2;
            hVar.j();
        }
    }
}
