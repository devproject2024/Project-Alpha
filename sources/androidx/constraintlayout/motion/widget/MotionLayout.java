package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.constraintlayout.a.a.e;
import androidx.constraintlayout.a.a.i;
import androidx.constraintlayout.a.a.j;
import androidx.constraintlayout.a.a.l;
import androidx.constraintlayout.motion.widget.q;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.e;
import androidx.core.h.o;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MotionLayout extends ConstraintLayout implements o {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f2249a;
    boolean A = false;
    protected boolean B = false;
    int C;
    int D;
    int E;
    int F;
    int G;
    int H;
    float I;
    h J = h.UNDEFINED;
    c K = new c();
    ArrayList<Integer> L = new ArrayList<>();
    private int M = -1;
    /* access modifiers changed from: private */
    public int N = -1;
    /* access modifiers changed from: private */
    public int O = 0;
    /* access modifiers changed from: private */
    public int P = 0;
    private long Q = 0;
    private long R;
    private boolean S;
    private g T;
    private float U;
    private float V;
    private boolean W = false;
    private androidx.constraintlayout.motion.a.g aa = new androidx.constraintlayout.motion.a.g();
    private a ab = new a();
    private b ac;
    private boolean ad = false;
    private ArrayList<MotionHelper> ae = null;
    private ArrayList<MotionHelper> af = null;
    private int ag = 0;
    private long ah = -1;
    private float ai = 0.0f;
    private int aj = 0;
    private float ak = 0.0f;
    private e al = new e();
    private boolean am = false;
    private f an;
    private boolean ao = false;
    private RectF ap = new RectF();
    private View aq = null;

    /* renamed from: b  reason: collision with root package name */
    q f2250b;

    /* renamed from: c  reason: collision with root package name */
    public Interpolator f2251c;

    /* renamed from: d  reason: collision with root package name */
    public float f2252d = 0.0f;

    /* renamed from: e  reason: collision with root package name */
    int f2253e = -1;

    /* renamed from: f  reason: collision with root package name */
    boolean f2254f = true;

    /* renamed from: g  reason: collision with root package name */
    public HashMap<View, n> f2255g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    public float f2256h = 1.0f;

    /* renamed from: i  reason: collision with root package name */
    float f2257i = 0.0f;
    public float j = 0.0f;
    public float k = 0.0f;
    boolean l = false;
    boolean m = false;
    int n = 0;
    b o;
    boolean p = true;
    int q;
    int r;
    int s;
    int t;
    boolean u = false;
    float v;
    float w;
    long x;
    float y;
    ArrayList<g> z = null;

    protected interface d {
        void a();

        void a(MotionEvent motionEvent);

        void b();

        float c();

        float d();
    }

    public interface g {
    }

    enum h {
        UNDEFINED,
        SETUP,
        MOVING,
        FINISHED
    }

    public final void a(View view, int i2, int i3, int i4, int i5, int i6) {
    }

    public final void b(View view, View view2, int i2, int i3) {
    }

    public boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        return false;
    }

    public boolean onNestedPreFling(View view, float f2, float f3) {
        return false;
    }

    public MotionLayout(Context context) {
        super(context);
        a((AttributeSet) null);
    }

    public MotionLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public MotionLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(attributeSet);
    }

    /* access modifiers changed from: protected */
    public long getNanoTime() {
        return System.nanoTime();
    }

    protected static d a() {
        return e.e();
    }

    /* access modifiers changed from: package-private */
    public void setState(h hVar) {
        if (hVar != h.FINISHED || this.f2253e != -1) {
            h hVar2 = this.J;
            this.J = hVar;
            if (hVar2 == h.MOVING && hVar == h.MOVING) {
                e();
            }
            int i2 = AnonymousClass2.f2260a[hVar2.ordinal()];
            if (i2 == 1 || i2 == 2) {
                if (hVar == h.MOVING) {
                    e();
                }
                if (hVar == h.FINISHED) {
                    f();
                }
            } else if (i2 == 3 && hVar == h.FINISHED) {
                f();
            }
        }
    }

    /* renamed from: androidx.constraintlayout.motion.widget.MotionLayout$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2260a = new int[h.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                androidx.constraintlayout.motion.widget.MotionLayout$h[] r0 = androidx.constraintlayout.motion.widget.MotionLayout.h.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2260a = r0
                int[] r0 = f2260a     // Catch:{ NoSuchFieldError -> 0x0014 }
                androidx.constraintlayout.motion.widget.MotionLayout$h r1 = androidx.constraintlayout.motion.widget.MotionLayout.h.UNDEFINED     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f2260a     // Catch:{ NoSuchFieldError -> 0x001f }
                androidx.constraintlayout.motion.widget.MotionLayout$h r1 = androidx.constraintlayout.motion.widget.MotionLayout.h.SETUP     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f2260a     // Catch:{ NoSuchFieldError -> 0x002a }
                androidx.constraintlayout.motion.widget.MotionLayout$h r1 = androidx.constraintlayout.motion.widget.MotionLayout.h.MOVING     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f2260a     // Catch:{ NoSuchFieldError -> 0x0035 }
                androidx.constraintlayout.motion.widget.MotionLayout$h r1 = androidx.constraintlayout.motion.widget.MotionLayout.h.FINISHED     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.AnonymousClass2.<clinit>():void");
        }
    }

    static class e implements d {

        /* renamed from: b  reason: collision with root package name */
        private static e f2281b = new e();

        /* renamed from: a  reason: collision with root package name */
        VelocityTracker f2282a;

        private e() {
        }

        public static e e() {
            f2281b.f2282a = VelocityTracker.obtain();
            return f2281b;
        }

        public final void a() {
            VelocityTracker velocityTracker = this.f2282a;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f2282a = null;
            }
        }

        public final void a(MotionEvent motionEvent) {
            VelocityTracker velocityTracker = this.f2282a;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
        }

        public final void b() {
            VelocityTracker velocityTracker = this.f2282a;
            if (velocityTracker != null) {
                velocityTracker.computeCurrentVelocity(1000);
            }
        }

        public final float c() {
            VelocityTracker velocityTracker = this.f2282a;
            if (velocityTracker != null) {
                return velocityTracker.getXVelocity();
            }
            return 0.0f;
        }

        public final float d() {
            VelocityTracker velocityTracker = this.f2282a;
            if (velocityTracker != null) {
                return velocityTracker.getYVelocity();
            }
            return 0.0f;
        }
    }

    public void setTransition(int i2, int i3) {
        if (!isAttachedToWindow()) {
            if (this.an == null) {
                this.an = new f();
            }
            f fVar = this.an;
            fVar.f2285c = i2;
            fVar.f2286d = i3;
            return;
        }
        q qVar = this.f2250b;
        if (qVar != null) {
            this.M = i2;
            this.N = i3;
            qVar.a(i2, i3);
            this.K.a(this.f2250b.a(i2), this.f2250b.a(i3));
            h();
            this.j = 0.0f;
            a(0.0f);
        }
    }

    public void setTransition(int i2) {
        q.a aVar;
        q qVar = this.f2250b;
        if (qVar != null) {
            Iterator<q.a> it2 = qVar.f2381d.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    aVar = null;
                    break;
                }
                aVar = it2.next();
                if (aVar.f2389a == i2) {
                    break;
                }
            }
            this.M = aVar.f2392d;
            this.N = aVar.f2391c;
            if (!isAttachedToWindow()) {
                if (this.an == null) {
                    this.an = new f();
                }
                f fVar = this.an;
                fVar.f2285c = this.M;
                fVar.f2286d = this.N;
                return;
            }
            float f2 = Float.NaN;
            int i3 = this.f2253e;
            if (i3 == this.M) {
                f2 = 0.0f;
            } else if (i3 == this.N) {
                f2 = 1.0f;
            }
            this.f2250b.a(aVar);
            this.K.a(this.f2250b.a(this.M), this.f2250b.a(this.N));
            h();
            this.j = Float.isNaN(f2) ? 0.0f : f2;
            if (Float.isNaN(f2)) {
                StringBuilder sb = new StringBuilder();
                sb.append(a.a());
                sb.append(" transitionToStart ");
                a(0.0f);
                return;
            }
            setProgress(f2);
        }
    }

    /* access modifiers changed from: protected */
    public void setTransition(q.a aVar) {
        this.f2250b.a(aVar);
        setState(h.SETUP);
        if (this.f2253e == this.f2250b.c()) {
            this.j = 1.0f;
            this.f2257i = 1.0f;
            this.k = 1.0f;
        } else {
            this.j = 0.0f;
            this.f2257i = 0.0f;
            this.k = 0.0f;
        }
        boolean z2 = true;
        if ((aVar.r & 1) == 0) {
            z2 = false;
        }
        this.R = z2 ? -1 : getNanoTime();
        int b2 = this.f2250b.b();
        int c2 = this.f2250b.c();
        if (b2 != this.M || c2 != this.N) {
            this.M = b2;
            this.N = c2;
            this.f2250b.a(this.M, this.N);
            this.K.a(this.f2250b.a(this.M), this.f2250b.a(this.N));
            this.K.a(this.M, this.N);
            this.K.a();
            h();
        }
    }

    public void loadLayoutDescription(int i2) {
        if (i2 != 0) {
            try {
                this.f2250b = new q(getContext(), this, i2);
                if (Build.VERSION.SDK_INT < 19 || isAttachedToWindow()) {
                    this.f2250b.a(this);
                    this.K.a(this.f2250b.a(this.M), this.f2250b.a(this.N));
                    h();
                    this.f2250b.a(isRtl());
                }
            } catch (Exception e2) {
                throw new IllegalArgumentException("unable to parse MotionScene file", e2);
            }
        } else {
            this.f2250b = null;
        }
    }

    public boolean isAttachedToWindow() {
        if (Build.VERSION.SDK_INT >= 19) {
            return super.isAttachedToWindow();
        }
        return getWindowToken() != null;
    }

    public void setState(int i2, int i3, int i4) {
        setState(h.SETUP);
        this.f2253e = i2;
        this.M = -1;
        this.N = -1;
        if (this.mConstraintLayoutSpec != null) {
            this.mConstraintLayoutSpec.a(i2, (float) i3, (float) i4);
            return;
        }
        q qVar = this.f2250b;
        if (qVar != null) {
            qVar.a(i2).c((ConstraintLayout) this);
        }
    }

    public void setInterpolatedProgress(float f2) {
        if (this.f2250b != null) {
            setState(h.MOVING);
            Interpolator d2 = this.f2250b.d();
            if (d2 != null) {
                setProgress(d2.getInterpolation(f2));
                return;
            }
        }
        setProgress(f2);
    }

    public void setProgress(float f2, float f3) {
        if (!isAttachedToWindow()) {
            if (this.an == null) {
                this.an = new f();
            }
            f fVar = this.an;
            fVar.f2283a = f2;
            fVar.f2284b = f3;
            return;
        }
        setProgress(f2);
        setState(h.MOVING);
        this.f2252d = f3;
        a(1.0f);
    }

    class f {

        /* renamed from: a  reason: collision with root package name */
        float f2283a = Float.NaN;

        /* renamed from: b  reason: collision with root package name */
        float f2284b = Float.NaN;

        /* renamed from: c  reason: collision with root package name */
        int f2285c = -1;

        /* renamed from: d  reason: collision with root package name */
        int f2286d = -1;

        /* renamed from: e  reason: collision with root package name */
        final String f2287e = "motion.progress";

        /* renamed from: f  reason: collision with root package name */
        final String f2288f = "motion.velocity";

        /* renamed from: g  reason: collision with root package name */
        final String f2289g = "motion.StartState";

        /* renamed from: h  reason: collision with root package name */
        final String f2290h = "motion.EndState";

        f() {
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            if (!(this.f2285c == -1 && this.f2286d == -1)) {
                int i2 = this.f2285c;
                if (i2 == -1) {
                    MotionLayout.this.a(this.f2286d);
                } else {
                    int i3 = this.f2286d;
                    if (i3 == -1) {
                        MotionLayout.this.setState(i2, -1, -1);
                    } else {
                        MotionLayout.this.setTransition(i2, i3);
                    }
                }
                MotionLayout.this.setState(h.SETUP);
            }
            if (!Float.isNaN(this.f2284b)) {
                MotionLayout.this.setProgress(this.f2283a, this.f2284b);
                this.f2283a = Float.NaN;
                this.f2284b = Float.NaN;
                this.f2285c = -1;
                this.f2286d = -1;
            } else if (!Float.isNaN(this.f2283a)) {
                MotionLayout.this.setProgress(this.f2283a);
            }
        }
    }

    public void setTransitionState(Bundle bundle) {
        if (this.an == null) {
            this.an = new f();
        }
        f fVar = this.an;
        fVar.f2283a = bundle.getFloat("motion.progress");
        fVar.f2284b = bundle.getFloat("motion.velocity");
        fVar.f2285c = bundle.getInt("motion.StartState");
        fVar.f2286d = bundle.getInt("motion.EndState");
        if (isAttachedToWindow()) {
            this.an.a();
        }
    }

    public Bundle getTransitionState() {
        if (this.an == null) {
            this.an = new f();
        }
        f fVar = this.an;
        fVar.f2286d = MotionLayout.this.N;
        fVar.f2285c = MotionLayout.this.M;
        fVar.f2284b = MotionLayout.this.getVelocity();
        fVar.f2283a = MotionLayout.this.getProgress();
        f fVar2 = this.an;
        Bundle bundle = new Bundle();
        bundle.putFloat("motion.progress", fVar2.f2283a);
        bundle.putFloat("motion.velocity", fVar2.f2284b);
        bundle.putInt("motion.StartState", fVar2.f2285c);
        bundle.putInt("motion.EndState", fVar2.f2286d);
        return bundle;
    }

    public void setProgress(float f2) {
        if (!isAttachedToWindow()) {
            if (this.an == null) {
                this.an = new f();
            }
            this.an.f2283a = f2;
            return;
        }
        if (f2 <= 0.0f) {
            this.f2253e = this.M;
            if (this.j == 0.0f) {
                setState(h.FINISHED);
            }
        } else if (f2 >= 1.0f) {
            this.f2253e = this.N;
            if (this.j == 1.0f) {
                setState(h.FINISHED);
            }
        } else {
            this.f2253e = -1;
            setState(h.MOVING);
        }
        if (this.f2250b != null) {
            this.S = true;
            this.k = f2;
            this.f2257i = f2;
            this.R = -1;
            this.Q = -1;
            this.f2251c = null;
            this.l = true;
            invalidate();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0056, code lost:
        if ((r13 + ((r15 * r6) - (((r2 * r6) * r6) / 2.0f))) > 1.0f) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0066, code lost:
        if ((r13 + ((r15 * r1) + (((r2 * r1) * r1) / 2.0f))) < 0.0f) goto L_0x006a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r13, float r14, float r15) {
        /*
            r12 = this;
            androidx.constraintlayout.motion.widget.q r0 = r12.f2250b
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            float r0 = r12.j
            int r0 = (r0 > r14 ? 1 : (r0 == r14 ? 0 : -1))
            if (r0 != 0) goto L_0x000c
            return
        L_0x000c:
            r0 = 1
            r12.W = r0
            long r1 = r12.getNanoTime()
            r12.Q = r1
            androidx.constraintlayout.motion.widget.q r1 = r12.f2250b
            int r1 = r1.e()
            float r1 = (float) r1
            r2 = 1148846080(0x447a0000, float:1000.0)
            float r1 = r1 / r2
            r12.f2256h = r1
            r12.k = r14
            r12.l = r0
            r1 = 1065353216(0x3f800000, float:1.0)
            r2 = 2
            r3 = 0
            r4 = 0
            if (r13 == 0) goto L_0x00b4
            if (r13 == r0) goto L_0x00b4
            if (r13 == r2) goto L_0x00b4
            r2 = 3
            if (r13 == r2) goto L_0x00dd
            r2 = 4
            if (r13 == r2) goto L_0x00a2
            r2 = 5
            if (r13 == r2) goto L_0x003b
            goto L_0x00dd
        L_0x003b:
            float r13 = r12.j
            androidx.constraintlayout.motion.widget.q r2 = r12.f2250b
            float r2 = r2.g()
            r5 = 1073741824(0x40000000, float:2.0)
            int r6 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x0059
            float r6 = r15 / r2
            float r7 = r15 * r6
            float r2 = r2 * r6
            float r2 = r2 * r6
            float r2 = r2 / r5
            float r7 = r7 - r2
            float r13 = r13 + r7
            int r13 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r13 <= 0) goto L_0x0069
            goto L_0x006a
        L_0x0059:
            float r1 = -r15
            float r1 = r1 / r2
            float r6 = r15 * r1
            float r2 = r2 * r1
            float r2 = r2 * r1
            float r2 = r2 / r5
            float r6 = r6 + r2
            float r13 = r13 + r6
            int r13 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r13 >= 0) goto L_0x0069
            goto L_0x006a
        L_0x0069:
            r0 = 0
        L_0x006a:
            if (r0 == 0) goto L_0x007e
            androidx.constraintlayout.motion.widget.MotionLayout$a r13 = r12.ab
            float r14 = r12.j
            androidx.constraintlayout.motion.widget.q r0 = r12.f2250b
            float r0 = r0.g()
            r13.a(r15, r14, r0)
            androidx.constraintlayout.motion.widget.MotionLayout$a r13 = r12.ab
            r12.f2251c = r13
            goto L_0x00dd
        L_0x007e:
            androidx.constraintlayout.motion.a.g r5 = r12.aa
            float r6 = r12.j
            float r9 = r12.f2256h
            androidx.constraintlayout.motion.widget.q r13 = r12.f2250b
            float r10 = r13.g()
            androidx.constraintlayout.motion.widget.q r13 = r12.f2250b
            float r11 = r13.h()
            r7 = r14
            r8 = r15
            r5.a(r6, r7, r8, r9, r10, r11)
            r12.f2252d = r4
            int r13 = r12.f2253e
            r12.k = r14
            r12.f2253e = r13
            androidx.constraintlayout.motion.a.g r13 = r12.aa
            r12.f2251c = r13
            goto L_0x00dd
        L_0x00a2:
            androidx.constraintlayout.motion.widget.MotionLayout$a r13 = r12.ab
            float r14 = r12.j
            androidx.constraintlayout.motion.widget.q r0 = r12.f2250b
            float r0 = r0.g()
            r13.a(r15, r14, r0)
            androidx.constraintlayout.motion.widget.MotionLayout$a r13 = r12.ab
            r12.f2251c = r13
            goto L_0x00dd
        L_0x00b4:
            if (r13 != r0) goto L_0x00b8
            r14 = 0
            goto L_0x00bc
        L_0x00b8:
            if (r13 != r2) goto L_0x00bc
            r14 = 1065353216(0x3f800000, float:1.0)
        L_0x00bc:
            androidx.constraintlayout.motion.a.g r4 = r12.aa
            float r5 = r12.j
            float r8 = r12.f2256h
            androidx.constraintlayout.motion.widget.q r13 = r12.f2250b
            float r9 = r13.g()
            androidx.constraintlayout.motion.widget.q r13 = r12.f2250b
            float r10 = r13.h()
            r6 = r14
            r7 = r15
            r4.a(r5, r6, r7, r8, r9, r10)
            int r13 = r12.f2253e
            r12.k = r14
            r12.f2253e = r13
            androidx.constraintlayout.motion.a.g r13 = r12.aa
            r12.f2251c = r13
        L_0x00dd:
            r12.S = r3
            long r13 = r12.getNanoTime()
            r12.Q = r13
            r12.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.a(int, float, float):void");
    }

    class a extends o {

        /* renamed from: a  reason: collision with root package name */
        float f2261a = 0.0f;

        /* renamed from: b  reason: collision with root package name */
        float f2262b = 0.0f;

        /* renamed from: c  reason: collision with root package name */
        float f2263c;

        a() {
        }

        public final void a(float f2, float f3, float f4) {
            this.f2261a = f2;
            this.f2262b = f3;
            this.f2263c = f4;
        }

        public final float getInterpolation(float f2) {
            float f3;
            float f4;
            float f5 = this.f2261a;
            if (f5 > 0.0f) {
                float f6 = this.f2263c;
                if (f5 / f6 < f2) {
                    f2 = f5 / f6;
                }
                MotionLayout motionLayout = MotionLayout.this;
                float f7 = this.f2261a;
                float f8 = this.f2263c;
                motionLayout.f2252d = f7 - (f8 * f2);
                f3 = (f7 * f2) - (((f8 * f2) * f2) / 2.0f);
                f4 = this.f2262b;
            } else {
                float f9 = this.f2263c;
                if ((-f5) / f9 < f2) {
                    f2 = (-f5) / f9;
                }
                MotionLayout motionLayout2 = MotionLayout.this;
                float f10 = this.f2261a;
                float f11 = this.f2263c;
                motionLayout2.f2252d = (f11 * f2) + f10;
                f3 = (f10 * f2) + (((f11 * f2) * f2) / 2.0f);
                f4 = this.f2262b;
            }
            return f3 + f4;
        }

        public final float a() {
            return MotionLayout.this.f2252d;
        }
    }

    private void a(float f2) {
        if (this.f2250b != null) {
            float f3 = this.j;
            float f4 = this.f2257i;
            if (f3 != f4 && this.S) {
                this.j = f4;
            }
            float f5 = this.j;
            if (f5 != f2) {
                this.W = false;
                this.k = f2;
                this.f2256h = ((float) this.f2250b.e()) / 1000.0f;
                setProgress(this.k);
                this.f2251c = this.f2250b.d();
                this.S = false;
                this.Q = getNanoTime();
                this.l = true;
                this.f2257i = f5;
                this.j = f5;
                invalidate();
            }
        }
    }

    public final void b() {
        a(0.0f);
    }

    public final void c() {
        a(1.0f);
    }

    public final void a(int i2) {
        int i3;
        if (!isAttachedToWindow()) {
            if (this.an == null) {
                this.an = new f();
            }
            this.an.f2286d = i2;
            return;
        }
        q qVar = this.f2250b;
        if (!(qVar == null || qVar.f2379b == null)) {
            androidx.constraintlayout.widget.e eVar = this.f2250b.f2379b;
            int i4 = this.f2253e;
            e.a aVar = eVar.f2578d.get(i2);
            if (aVar == null) {
                i3 = i2;
            } else if (aVar.f2583c == i4) {
                i3 = i4;
            } else {
                Iterator<e.b> it2 = aVar.f2582b.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (i4 == it2.next().f2589e) {
                            break;
                        }
                    } else {
                        i3 = aVar.f2583c;
                        break;
                    }
                }
                i3 = i4;
            }
            if (i3 != -1) {
                i2 = i3;
            }
        }
        int i5 = this.f2253e;
        if (i5 == i2) {
            return;
        }
        if (this.M == i2) {
            a(0.0f);
        } else if (this.N == i2) {
            a(1.0f);
        } else {
            this.N = i2;
            if (i5 != -1) {
                setTransition(i5, i2);
                a(1.0f);
                this.j = 0.0f;
                a(1.0f);
                return;
            }
            this.W = false;
            this.k = 1.0f;
            this.f2257i = 0.0f;
            this.j = 0.0f;
            this.R = getNanoTime();
            this.Q = getNanoTime();
            this.S = false;
            this.f2251c = null;
            this.f2256h = ((float) this.f2250b.e()) / 1000.0f;
            this.M = -1;
            this.f2250b.a(this.M, this.N);
            int childCount = getChildCount();
            this.f2255g.clear();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                this.f2255g.put(childAt, new n(childAt));
            }
            this.l = true;
            this.K.a((androidx.constraintlayout.widget.c) null, this.f2250b.a(i2));
            h();
            this.K.b();
            int childCount2 = getChildCount();
            for (int i7 = 0; i7 < childCount2; i7++) {
                View childAt2 = getChildAt(i7);
                n nVar = this.f2255g.get(childAt2);
                if (nVar != null) {
                    nVar.f2363d.f2372d = 0.0f;
                    nVar.f2363d.f2373e = 0.0f;
                    nVar.f2363d.a(childAt2.getX(), childAt2.getY(), (float) childAt2.getWidth(), (float) childAt2.getHeight());
                    m mVar = nVar.f2365f;
                    mVar.a(childAt2.getX(), childAt2.getY(), (float) childAt2.getWidth(), (float) childAt2.getHeight());
                    mVar.f2353c = childAt2.getVisibility();
                    mVar.f2351a = childAt2.getVisibility() != 0 ? 0.0f : childAt2.getAlpha();
                    mVar.f2354d = false;
                    if (Build.VERSION.SDK_INT >= 21) {
                        mVar.f2355e = childAt2.getElevation();
                    }
                    mVar.f2356f = childAt2.getRotation();
                    mVar.f2357g = childAt2.getRotationX();
                    mVar.f2358h = childAt2.getRotationY();
                    mVar.f2359i = childAt2.getScaleX();
                    mVar.j = childAt2.getScaleY();
                    mVar.k = childAt2.getPivotX();
                    mVar.l = childAt2.getPivotY();
                    mVar.m = childAt2.getTranslationX();
                    mVar.n = childAt2.getTranslationY();
                    if (Build.VERSION.SDK_INT >= 21) {
                        mVar.o = childAt2.getTranslationZ();
                    }
                }
            }
            int width = getWidth();
            int height = getHeight();
            for (int i8 = 0; i8 < childCount; i8++) {
                n nVar2 = this.f2255g.get(getChildAt(i8));
                this.f2250b.a(nVar2);
                nVar2.a(width, height, getNanoTime());
            }
            float f2 = this.f2250b.f();
            if (f2 != 0.0f) {
                float f3 = Float.MAX_VALUE;
                float f4 = -3.4028235E38f;
                for (int i9 = 0; i9 < childCount; i9++) {
                    n nVar3 = this.f2255g.get(getChildAt(i9));
                    float f5 = nVar3.f2364e.f2375g + nVar3.f2364e.f2374f;
                    f3 = Math.min(f3, f5);
                    f4 = Math.max(f4, f5);
                }
                for (int i10 = 0; i10 < childCount; i10++) {
                    n nVar4 = this.f2255g.get(getChildAt(i10));
                    float f6 = nVar4.f2364e.f2374f;
                    float f7 = nVar4.f2364e.f2375g;
                    nVar4.k = 1.0f / (1.0f - f2);
                    nVar4.j = f2 - ((((f6 + f7) - f3) * f2) / (f4 - f3));
                }
            }
            this.f2257i = 0.0f;
            this.j = 0.0f;
            this.l = true;
            invalidate();
        }
    }

    public float getVelocity() {
        return this.f2252d;
    }

    class c {

        /* renamed from: a  reason: collision with root package name */
        androidx.constraintlayout.a.a.f f2274a = new androidx.constraintlayout.a.a.f();

        /* renamed from: b  reason: collision with root package name */
        androidx.constraintlayout.a.a.f f2275b = new androidx.constraintlayout.a.a.f();

        /* renamed from: c  reason: collision with root package name */
        androidx.constraintlayout.widget.c f2276c = null;

        /* renamed from: d  reason: collision with root package name */
        androidx.constraintlayout.widget.c f2277d = null;

        /* renamed from: e  reason: collision with root package name */
        int f2278e;

        /* renamed from: f  reason: collision with root package name */
        int f2279f;

        c() {
        }

        /* access modifiers changed from: package-private */
        public final void a(androidx.constraintlayout.widget.c cVar, androidx.constraintlayout.widget.c cVar2) {
            this.f2276c = cVar;
            this.f2277d = cVar2;
            this.f2274a = new androidx.constraintlayout.a.a.f();
            this.f2275b = new androidx.constraintlayout.a.a.f();
            this.f2274a.a(MotionLayout.this.mLayoutWidget.y());
            this.f2275b.a(MotionLayout.this.mLayoutWidget.y());
            this.f2274a.bh.clear();
            this.f2275b.bh.clear();
            a(MotionLayout.this.mLayoutWidget, this.f2274a);
            a(MotionLayout.this.mLayoutWidget, this.f2275b);
            if (((double) MotionLayout.this.j) > 0.5d) {
                if (cVar != null) {
                    a(this.f2274a, cVar);
                }
                a(this.f2275b, cVar2);
            } else {
                a(this.f2275b, cVar2);
                if (cVar != null) {
                    a(this.f2274a, cVar);
                }
            }
            this.f2274a.f2106d = MotionLayout.this.isRtl();
            this.f2274a.e();
            this.f2275b.f2106d = MotionLayout.this.isRtl();
            this.f2275b.e();
            ViewGroup.LayoutParams layoutParams = MotionLayout.this.getLayoutParams();
            if (layoutParams != null) {
                if (layoutParams.width == -2) {
                    androidx.constraintlayout.a.a.f fVar = this.f2274a;
                    fVar.U[0] = e.a.WRAP_CONTENT;
                    androidx.constraintlayout.a.a.f fVar2 = this.f2275b;
                    fVar2.U[0] = e.a.WRAP_CONTENT;
                }
                if (layoutParams.height == -2) {
                    androidx.constraintlayout.a.a.f fVar3 = this.f2274a;
                    fVar3.U[1] = e.a.WRAP_CONTENT;
                    androidx.constraintlayout.a.a.f fVar4 = this.f2275b;
                    fVar4.U[1] = e.a.WRAP_CONTENT;
                }
            }
        }

        private void a(androidx.constraintlayout.a.a.f fVar, androidx.constraintlayout.widget.c cVar) {
            SparseArray sparseArray = new SparseArray();
            Constraints.LayoutParams layoutParams = new Constraints.LayoutParams(-2);
            sparseArray.clear();
            sparseArray.put(0, fVar);
            sparseArray.put(MotionLayout.this.getId(), fVar);
            Iterator<androidx.constraintlayout.a.a.e> it2 = fVar.bh.iterator();
            while (it2.hasNext()) {
                androidx.constraintlayout.a.a.e next = it2.next();
                sparseArray.put(((View) next.am).getId(), next);
            }
            Iterator<androidx.constraintlayout.a.a.e> it3 = fVar.bh.iterator();
            while (it3.hasNext()) {
                androidx.constraintlayout.a.a.e next2 = it3.next();
                View view = (View) next2.am;
                cVar.a(view.getId(), (ConstraintLayout.LayoutParams) layoutParams);
                next2.g(cVar.d(view.getId()));
                next2.h(cVar.c(view.getId()));
                if (view instanceof ConstraintHelper) {
                    cVar.a((ConstraintHelper) view, next2, (ConstraintLayout.LayoutParams) layoutParams, (SparseArray<androidx.constraintlayout.a.a.e>) sparseArray);
                    if (view instanceof Barrier) {
                        ((Barrier) view).b();
                    }
                }
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams.resolveLayoutDirection(MotionLayout.this.getLayoutDirection());
                } else {
                    layoutParams.resolveLayoutDirection(0);
                }
                MotionLayout.this.applyConstraintsFromLayoutParams(false, view, next2, layoutParams, sparseArray);
                if (cVar.a(view.getId()) == 1) {
                    next2.an = view.getVisibility();
                } else {
                    next2.an = cVar.b(view.getId());
                }
            }
            Iterator<androidx.constraintlayout.a.a.e> it4 = fVar.bh.iterator();
            while (it4.hasNext()) {
                androidx.constraintlayout.a.a.e next3 = it4.next();
                if (next3 instanceof l) {
                    i iVar = (i) next3;
                    ((ConstraintHelper) next3.am).a(iVar, (SparseArray<androidx.constraintlayout.a.a.e>) sparseArray);
                    ((l) iVar).d();
                }
            }
        }

        public final void a() {
            b(MotionLayout.this.O, MotionLayout.this.P);
            MotionLayout.j(MotionLayout.this);
        }

        private void b(int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            MotionLayout motionLayout = MotionLayout.this;
            motionLayout.G = mode;
            motionLayout.H = mode2;
            int optimizationLevel = motionLayout.getOptimizationLevel();
            if (MotionLayout.this.f2253e == MotionLayout.this.getStartState()) {
                MotionLayout.this.resolveSystem(this.f2275b, optimizationLevel, i2, i3);
                if (this.f2276c != null) {
                    MotionLayout.this.resolveSystem(this.f2274a, optimizationLevel, i2, i3);
                }
            } else {
                if (this.f2276c != null) {
                    MotionLayout.this.resolveSystem(this.f2274a, optimizationLevel, i2, i3);
                }
                MotionLayout.this.resolveSystem(this.f2275b, optimizationLevel, i2, i3);
            }
            if (((MotionLayout.this.getParent() instanceof MotionLayout) && mode == 1073741824 && mode2 == 1073741824) ? false : true) {
                MotionLayout motionLayout2 = MotionLayout.this;
                motionLayout2.G = mode;
                motionLayout2.H = mode2;
                if (motionLayout2.f2253e == MotionLayout.this.getStartState()) {
                    MotionLayout.this.resolveSystem(this.f2275b, optimizationLevel, i2, i3);
                    if (this.f2276c != null) {
                        MotionLayout.this.resolveSystem(this.f2274a, optimizationLevel, i2, i3);
                    }
                } else {
                    if (this.f2276c != null) {
                        MotionLayout.this.resolveSystem(this.f2274a, optimizationLevel, i2, i3);
                    }
                    MotionLayout.this.resolveSystem(this.f2275b, optimizationLevel, i2, i3);
                }
                MotionLayout.this.C = this.f2274a.n();
                MotionLayout.this.D = this.f2274a.o();
                MotionLayout.this.E = this.f2275b.n();
                MotionLayout.this.F = this.f2275b.o();
                MotionLayout motionLayout3 = MotionLayout.this;
                motionLayout3.B = (motionLayout3.C == MotionLayout.this.E && MotionLayout.this.D == MotionLayout.this.F) ? false : true;
            }
            int i4 = MotionLayout.this.C;
            int i5 = MotionLayout.this.D;
            if (MotionLayout.this.G == Integer.MIN_VALUE || MotionLayout.this.G == 0) {
                i4 = (int) (((float) MotionLayout.this.C) + (MotionLayout.this.I * ((float) (MotionLayout.this.E - MotionLayout.this.C))));
            }
            int i6 = i4;
            if (MotionLayout.this.H == Integer.MIN_VALUE || MotionLayout.this.H == 0) {
                i5 = (int) (((float) MotionLayout.this.D) + (MotionLayout.this.I * ((float) (MotionLayout.this.F - MotionLayout.this.D))));
            }
            MotionLayout.this.resolveMeasuredDimension(i2, i3, i6, i5, this.f2274a.bc || this.f2275b.bc, this.f2274a.bd || this.f2275b.bd);
        }

        public final void b() {
            int childCount = MotionLayout.this.getChildCount();
            MotionLayout.this.f2255g.clear();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = MotionLayout.this.getChildAt(i2);
                MotionLayout.this.f2255g.put(childAt, new n(childAt));
            }
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt2 = MotionLayout.this.getChildAt(i3);
                n nVar = MotionLayout.this.f2255g.get(childAt2);
                if (nVar != null) {
                    if (this.f2276c != null) {
                        androidx.constraintlayout.a.a.e a2 = a(this.f2274a, childAt2);
                        if (a2 != null) {
                            nVar.a(a2, this.f2276c);
                        } else if (MotionLayout.this.n != 0) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(a.a());
                            sb.append("no widget for  ");
                            sb.append(a.a(childAt2));
                            sb.append(" (");
                            sb.append(childAt2.getClass().getName());
                            sb.append(")");
                        }
                    }
                    if (this.f2277d != null) {
                        androidx.constraintlayout.a.a.e a3 = a(this.f2275b, childAt2);
                        if (a3 != null) {
                            nVar.b(a3, this.f2277d);
                        } else if (MotionLayout.this.n != 0) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(a.a());
                            sb2.append("no widget for  ");
                            sb2.append(a.a(childAt2));
                            sb2.append(" (");
                            sb2.append(childAt2.getClass().getName());
                            sb2.append(")");
                        }
                    }
                }
            }
        }

        public final void a(int i2, int i3) {
            this.f2278e = i2;
            this.f2279f = i3;
        }

        private static void a(androidx.constraintlayout.a.a.f fVar, androidx.constraintlayout.a.a.f fVar2) {
            androidx.constraintlayout.a.a.e eVar;
            ArrayList<androidx.constraintlayout.a.a.e> arrayList = fVar.bh;
            HashMap hashMap = new HashMap();
            hashMap.put(fVar, fVar2);
            fVar2.bh.clear();
            fVar2.a((androidx.constraintlayout.a.a.e) fVar, (HashMap<androidx.constraintlayout.a.a.e, androidx.constraintlayout.a.a.e>) hashMap);
            Iterator<androidx.constraintlayout.a.a.e> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                androidx.constraintlayout.a.a.e next = it2.next();
                if (next instanceof androidx.constraintlayout.a.a.a) {
                    eVar = new androidx.constraintlayout.a.a.a();
                } else if (next instanceof androidx.constraintlayout.a.a.h) {
                    eVar = new androidx.constraintlayout.a.a.h();
                } else if (next instanceof androidx.constraintlayout.a.a.g) {
                    eVar = new androidx.constraintlayout.a.a.g();
                } else if (next instanceof i) {
                    eVar = new j();
                } else {
                    eVar = new androidx.constraintlayout.a.a.e();
                }
                fVar2.a(eVar);
                hashMap.put(next, eVar);
            }
            Iterator<androidx.constraintlayout.a.a.e> it3 = arrayList.iterator();
            while (it3.hasNext()) {
                androidx.constraintlayout.a.a.e next2 = it3.next();
                ((androidx.constraintlayout.a.a.e) hashMap.get(next2)).a(next2, (HashMap<androidx.constraintlayout.a.a.e, androidx.constraintlayout.a.a.e>) hashMap);
            }
        }

        private static androidx.constraintlayout.a.a.e a(androidx.constraintlayout.a.a.f fVar, View view) {
            if (fVar.am == view) {
                return fVar;
            }
            ArrayList<androidx.constraintlayout.a.a.e> arrayList = fVar.bh;
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                androidx.constraintlayout.a.a.e eVar = arrayList.get(i2);
                if (eVar.am == view) {
                    return eVar;
                }
            }
            return null;
        }
    }

    public void requestLayout() {
        q qVar;
        if (this.B || this.f2253e != -1 || (qVar = this.f2250b) == null || qVar.f2380c == null || this.f2250b.f2380c.q != 0) {
            super.requestLayout();
        }
    }

    public String toString() {
        Context context = getContext();
        return a.a(context, this.M) + "->" + a.a(context, this.N) + " (pos:" + this.j + " Dpos/Dt:" + this.f2252d;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0048, code lost:
        if (((r3 == r0.f2278e && r4 == r0.f2279f) ? false : true) != false) goto L_0x004a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r14, int r15) {
        /*
            r13 = this;
            androidx.constraintlayout.motion.widget.q r0 = r13.f2250b
            if (r0 != 0) goto L_0x0008
            super.onMeasure(r14, r15)
            return
        L_0x0008:
            int r0 = r13.O
            r1 = 0
            r2 = 1
            if (r0 != r14) goto L_0x0015
            int r0 = r13.P
            if (r0 == r15) goto L_0x0013
            goto L_0x0015
        L_0x0013:
            r0 = 0
            goto L_0x0016
        L_0x0015:
            r0 = 1
        L_0x0016:
            boolean r3 = r13.ao
            if (r3 == 0) goto L_0x0023
            r13.ao = r1
            r13.d()
            r13.g()
            r0 = 1
        L_0x0023:
            boolean r3 = r13.mDirtyHierarchy
            if (r3 == 0) goto L_0x0028
            r0 = 1
        L_0x0028:
            r13.O = r14
            r13.P = r15
            androidx.constraintlayout.motion.widget.q r3 = r13.f2250b
            int r3 = r3.b()
            androidx.constraintlayout.motion.widget.q r4 = r13.f2250b
            int r4 = r4.c()
            if (r0 != 0) goto L_0x004a
            androidx.constraintlayout.motion.widget.MotionLayout$c r0 = r13.K
            int r5 = r0.f2278e
            if (r3 != r5) goto L_0x0047
            int r0 = r0.f2279f
            if (r4 == r0) goto L_0x0045
            goto L_0x0047
        L_0x0045:
            r0 = 0
            goto L_0x0048
        L_0x0047:
            r0 = 1
        L_0x0048:
            if (r0 == 0) goto L_0x006f
        L_0x004a:
            int r0 = r13.M
            r5 = -1
            if (r0 == r5) goto L_0x006f
            super.onMeasure(r14, r15)
            androidx.constraintlayout.motion.widget.MotionLayout$c r14 = r13.K
            androidx.constraintlayout.motion.widget.q r15 = r13.f2250b
            androidx.constraintlayout.widget.c r15 = r15.a((int) r3)
            androidx.constraintlayout.motion.widget.q r0 = r13.f2250b
            androidx.constraintlayout.widget.c r0 = r0.a((int) r4)
            r14.a((androidx.constraintlayout.widget.c) r15, (androidx.constraintlayout.widget.c) r0)
            androidx.constraintlayout.motion.widget.MotionLayout$c r14 = r13.K
            r14.a()
            androidx.constraintlayout.motion.widget.MotionLayout$c r14 = r13.K
            r14.a((int) r3, (int) r4)
            r14 = 0
            goto L_0x0070
        L_0x006f:
            r14 = 1
        L_0x0070:
            boolean r15 = r13.B
            if (r15 != 0) goto L_0x0076
            if (r14 == 0) goto L_0x00c7
        L_0x0076:
            int r14 = r13.getPaddingTop()
            int r15 = r13.getPaddingBottom()
            int r14 = r14 + r15
            int r15 = r13.getPaddingLeft()
            int r0 = r13.getPaddingRight()
            int r15 = r15 + r0
            androidx.constraintlayout.a.a.f r0 = r13.mLayoutWidget
            int r0 = r0.n()
            int r0 = r0 + r15
            androidx.constraintlayout.a.a.f r15 = r13.mLayoutWidget
            int r15 = r15.o()
            int r15 = r15 + r14
            int r14 = r13.G
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r14 == r3) goto L_0x009e
            if (r14 != 0) goto L_0x00ae
        L_0x009e:
            int r14 = r13.C
            float r0 = (float) r14
            float r4 = r13.I
            int r5 = r13.E
            int r5 = r5 - r14
            float r14 = (float) r5
            float r4 = r4 * r14
            float r0 = r0 + r4
            int r0 = (int) r0
            r13.requestLayout()
        L_0x00ae:
            int r14 = r13.H
            if (r14 == r3) goto L_0x00b4
            if (r14 != 0) goto L_0x00c4
        L_0x00b4:
            int r14 = r13.D
            float r15 = (float) r14
            float r3 = r13.I
            int r4 = r13.F
            int r4 = r4 - r14
            float r14 = (float) r4
            float r3 = r3 * r14
            float r15 = r15 + r3
            int r15 = (int) r15
            r13.requestLayout()
        L_0x00c4:
            r13.setMeasuredDimension(r0, r15)
        L_0x00c7:
            float r14 = r13.k
            float r15 = r13.j
            float r14 = r14 - r15
            float r14 = java.lang.Math.signum(r14)
            long r3 = r13.getNanoTime()
            android.view.animation.Interpolator r15 = r13.f2251c
            boolean r15 = r15 instanceof androidx.constraintlayout.motion.a.g
            r0 = 814313567(0x3089705f, float:1.0E-9)
            r5 = 0
            if (r15 != 0) goto L_0x00eb
            long r6 = r13.R
            long r6 = r3 - r6
            float r15 = (float) r6
            float r15 = r15 * r14
            float r15 = r15 * r0
            float r6 = r13.f2256h
            float r15 = r15 / r6
            goto L_0x00ec
        L_0x00eb:
            r15 = 0
        L_0x00ec:
            float r6 = r13.j
            float r6 = r6 + r15
            boolean r15 = r13.S
            if (r15 == 0) goto L_0x00f5
            float r6 = r13.k
        L_0x00f5:
            int r15 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r15 <= 0) goto L_0x00ff
            float r7 = r13.k
            int r7 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r7 >= 0) goto L_0x0109
        L_0x00ff:
            int r7 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r7 > 0) goto L_0x010c
            float r7 = r13.k
            int r7 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r7 > 0) goto L_0x010c
        L_0x0109:
            float r6 = r13.k
            goto L_0x010d
        L_0x010c:
            r2 = 0
        L_0x010d:
            android.view.animation.Interpolator r7 = r13.f2251c
            if (r7 == 0) goto L_0x0126
            if (r2 != 0) goto L_0x0126
            boolean r2 = r13.W
            if (r2 == 0) goto L_0x0122
            long r8 = r13.Q
            long r3 = r3 - r8
            float r2 = (float) r3
            float r2 = r2 * r0
            float r6 = r7.getInterpolation(r2)
            goto L_0x0126
        L_0x0122:
            float r6 = r7.getInterpolation(r6)
        L_0x0126:
            if (r15 <= 0) goto L_0x012e
            float r15 = r13.k
            int r15 = (r6 > r15 ? 1 : (r6 == r15 ? 0 : -1))
            if (r15 >= 0) goto L_0x0138
        L_0x012e:
            int r14 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r14 > 0) goto L_0x013a
            float r14 = r13.k
            int r14 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r14 > 0) goto L_0x013a
        L_0x0138:
            float r6 = r13.k
        L_0x013a:
            r13.I = r6
            int r14 = r13.getChildCount()
            long r2 = r13.getNanoTime()
        L_0x0144:
            if (r1 >= r14) goto L_0x015f
            android.view.View r8 = r13.getChildAt(r1)
            java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.n> r15 = r13.f2255g
            java.lang.Object r15 = r15.get(r8)
            r7 = r15
            androidx.constraintlayout.motion.widget.n r7 = (androidx.constraintlayout.motion.widget.n) r7
            if (r7 == 0) goto L_0x015c
            androidx.constraintlayout.motion.widget.e r12 = r13.al
            r9 = r6
            r10 = r2
            r7.a((android.view.View) r8, (float) r9, (long) r10, (androidx.constraintlayout.motion.widget.e) r12)
        L_0x015c:
            int r1 = r1 + 1
            goto L_0x0144
        L_0x015f:
            boolean r14 = r13.B
            if (r14 == 0) goto L_0x0166
            r13.requestLayout()
        L_0x0166:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.onMeasure(int, int):void");
    }

    public final boolean a(View view, View view2, int i2, int i3) {
        q qVar = this.f2250b;
        return (qVar == null || qVar.f2380c == null || this.f2250b.f2380c.l == null || (this.f2250b.f2380c.l.r & 2) != 0) ? false : true;
    }

    public final void a(View view, int i2) {
        float f2;
        q qVar = this.f2250b;
        if (qVar != null) {
            float f3 = this.v;
            float f4 = this.y;
            float f5 = f3 / f4;
            float f6 = this.w / f4;
            if (qVar.f2380c != null && qVar.f2380c.l != null) {
                t tVar = qVar.f2380c.l;
                boolean z2 = false;
                tVar.f2429i = false;
                float progress = tVar.m.getProgress();
                tVar.m.a(tVar.f2422b, progress, tVar.f2426f, tVar.f2425e, tVar.j);
                if (tVar.f2427g != 0.0f) {
                    f2 = (f5 * tVar.f2427g) / tVar.j[0];
                } else {
                    f2 = (f6 * tVar.f2428h) / tVar.j[1];
                }
                if (!Float.isNaN(f2)) {
                    progress += f2 / 3.0f;
                }
                if (progress != 0.0f) {
                    float f7 = 1.0f;
                    boolean z3 = progress != 1.0f;
                    if (tVar.f2421a != 3) {
                        z2 = true;
                    }
                    if (z2 && z3) {
                        MotionLayout motionLayout = tVar.m;
                        int i3 = tVar.f2421a;
                        if (((double) progress) < 0.5d) {
                            f7 = 0.0f;
                        }
                        motionLayout.a(i3, f7, f2);
                    }
                }
            }
        }
    }

    public final void a(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        if (!(!this.u && i2 == 0 && i3 == 0)) {
            iArr[0] = iArr[0] + i4;
            iArr[1] = iArr[1] + i5;
        }
        this.u = false;
    }

    public final void a(View view, int i2, int i3, int[] iArr, int i4) {
        float f2;
        float f3;
        boolean z2;
        t tVar;
        int i5;
        final View view2 = view;
        int i6 = i2;
        int i7 = i3;
        q qVar = this.f2250b;
        if (qVar != null && qVar.f2380c != null && this.f2250b.f2380c.a()) {
            q.a aVar = this.f2250b.f2380c;
            if (aVar == null || !aVar.a() || (tVar = aVar.l) == null || (i5 = tVar.f2423c) == -1 || view.getId() == i5) {
                q qVar2 = this.f2250b;
                if (qVar2 != null) {
                    if (qVar2.f2380c == null || qVar2.f2380c.l == null) {
                        z2 = false;
                    } else {
                        z2 = qVar2.f2380c.l.p;
                    }
                    if (z2) {
                        float f4 = this.f2257i;
                        if ((f4 == 1.0f || f4 == 0.0f) && view2.canScrollVertically(-1)) {
                            return;
                        }
                    }
                }
                if (!(aVar.l == null || (this.f2250b.f2380c.l.r & 1) == 0)) {
                    q qVar3 = this.f2250b;
                    float f5 = (float) i6;
                    float f6 = (float) i7;
                    if (qVar3.f2380c == null || qVar3.f2380c.l == null) {
                        f3 = 0.0f;
                    } else {
                        t tVar2 = qVar3.f2380c.l;
                        float progress = tVar2.m.getProgress();
                        tVar2.m.a(tVar2.f2422b, progress, tVar2.f2426f, tVar2.f2425e, tVar2.j);
                        if (tVar2.f2427g != 0.0f) {
                            if (tVar2.j[0] == 0.0f) {
                                tVar2.j[0] = 1.0E-7f;
                            }
                            f3 = (f5 * tVar2.f2427g) / tVar2.j[0];
                        } else {
                            if (tVar2.j[1] == 0.0f) {
                                tVar2.j[1] = 1.0E-7f;
                            }
                            f3 = (f6 * tVar2.f2428h) / tVar2.j[1];
                        }
                    }
                    if ((this.j <= 0.0f && f3 < 0.0f) || (this.j >= 1.0f && f3 > 0.0f)) {
                        if (Build.VERSION.SDK_INT >= 21) {
                            view2.setNestedScrollingEnabled(false);
                            view2.post(new Runnable() {
                                public final void run() {
                                    view2.setNestedScrollingEnabled(true);
                                }
                            });
                            return;
                        }
                        return;
                    }
                }
                float f7 = this.f2257i;
                long nanoTime = getNanoTime();
                float f8 = (float) i6;
                this.v = f8;
                float f9 = (float) i7;
                this.w = f9;
                this.y = (float) (((double) (nanoTime - this.x)) * 1.0E-9d);
                this.x = nanoTime;
                q qVar4 = this.f2250b;
                if (!(qVar4.f2380c == null || qVar4.f2380c.l == null)) {
                    t tVar3 = qVar4.f2380c.l;
                    float progress2 = tVar3.m.getProgress();
                    if (!tVar3.f2429i) {
                        tVar3.f2429i = true;
                        tVar3.m.setProgress(progress2);
                    }
                    tVar3.m.a(tVar3.f2422b, progress2, tVar3.f2426f, tVar3.f2425e, tVar3.j);
                    if (((double) Math.abs((tVar3.f2427g * tVar3.j[0]) + (tVar3.f2428h * tVar3.j[1]))) < 0.01d) {
                        tVar3.j[0] = 0.01f;
                        tVar3.j[1] = 0.01f;
                    }
                    if (tVar3.f2427g != 0.0f) {
                        f2 = (f8 * tVar3.f2427g) / tVar3.j[0];
                    } else {
                        f2 = (f9 * tVar3.f2428h) / tVar3.j[1];
                    }
                    float max = Math.max(Math.min(progress2 + f2, 1.0f), 0.0f);
                    if (max != tVar3.m.getProgress()) {
                        tVar3.m.setProgress(max);
                    }
                }
                if (f7 != this.f2257i) {
                    iArr[0] = i6;
                    iArr[1] = i7;
                }
                a(false);
                if (iArr[0] != 0 || iArr[1] != 0) {
                    this.u = true;
                }
            }
        }
    }

    class b {

        /* renamed from: a  reason: collision with root package name */
        float[] f2265a;

        /* renamed from: b  reason: collision with root package name */
        int[] f2266b;

        /* renamed from: c  reason: collision with root package name */
        float[] f2267c;

        /* renamed from: d  reason: collision with root package name */
        Path f2268d;

        /* renamed from: e  reason: collision with root package name */
        Paint f2269e = new Paint();

        /* renamed from: f  reason: collision with root package name */
        Paint f2270f;

        /* renamed from: g  reason: collision with root package name */
        Paint f2271g;

        /* renamed from: h  reason: collision with root package name */
        Paint f2272h;

        /* renamed from: i  reason: collision with root package name */
        Paint f2273i;
        final int j = -21965;
        final int k = -2067046;
        final int l = -13391360;
        final int m = 1996488704;
        final int n = 10;
        DashPathEffect o;
        int p;
        Rect q = new Rect();
        boolean r = false;
        int s = 1;
        private float[] u;

        public b() {
            this.f2269e.setAntiAlias(true);
            this.f2269e.setColor(-21965);
            this.f2269e.setStrokeWidth(2.0f);
            this.f2269e.setStyle(Paint.Style.STROKE);
            this.f2270f = new Paint();
            this.f2270f.setAntiAlias(true);
            this.f2270f.setColor(-2067046);
            this.f2270f.setStrokeWidth(2.0f);
            this.f2270f.setStyle(Paint.Style.STROKE);
            this.f2271g = new Paint();
            this.f2271g.setAntiAlias(true);
            this.f2271g.setColor(-13391360);
            this.f2271g.setStrokeWidth(2.0f);
            this.f2271g.setStyle(Paint.Style.STROKE);
            this.f2272h = new Paint();
            this.f2272h.setAntiAlias(true);
            this.f2272h.setColor(-13391360);
            this.f2272h.setTextSize(MotionLayout.this.getContext().getResources().getDisplayMetrics().density * 12.0f);
            this.u = new float[8];
            this.f2273i = new Paint();
            this.f2273i.setAntiAlias(true);
            this.o = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
            this.f2271g.setPathEffect(this.o);
            this.f2267c = new float[100];
            this.f2266b = new int[50];
            if (this.r) {
                this.f2269e.setStrokeWidth(8.0f);
                this.f2273i.setStrokeWidth(8.0f);
                this.f2270f.setStrokeWidth(8.0f);
                this.s = 4;
            }
        }

        public final void a(Canvas canvas, HashMap<View, n> hashMap, int i2, int i3) {
            if (hashMap != null && hashMap.size() != 0) {
                canvas.save();
                if (!MotionLayout.this.isInEditMode() && (i3 & 1) == 2) {
                    String str = MotionLayout.this.getContext().getResources().getResourceName(MotionLayout.this.N) + AppConstants.COLON + MotionLayout.this.getProgress();
                    canvas.drawText(str, 10.0f, (float) (MotionLayout.this.getHeight() - 30), this.f2272h);
                    canvas.drawText(str, 11.0f, (float) (MotionLayout.this.getHeight() - 29), this.f2269e);
                }
                for (n next : hashMap.values()) {
                    int a2 = next.a();
                    if (i3 > 0 && a2 == 0) {
                        a2 = 1;
                    }
                    if (a2 != 0) {
                        this.p = next.a(this.f2267c, this.f2266b);
                        if (a2 > 0) {
                            int i4 = i2 / 16;
                            float[] fArr = this.f2265a;
                            if (fArr == null || fArr.length != i4 * 2) {
                                this.f2265a = new float[(i4 * 2)];
                                this.f2268d = new Path();
                            }
                            int i5 = this.s;
                            canvas.translate((float) i5, (float) i5);
                            this.f2269e.setColor(1996488704);
                            this.f2273i.setColor(1996488704);
                            this.f2270f.setColor(1996488704);
                            this.f2271g.setColor(1996488704);
                            next.a(this.f2265a, i4);
                            a(canvas, a2, this.p, next);
                            this.f2269e.setColor(-21965);
                            this.f2270f.setColor(-2067046);
                            this.f2273i.setColor(-2067046);
                            this.f2271g.setColor(-13391360);
                            int i6 = this.s;
                            canvas.translate((float) (-i6), (float) (-i6));
                            a(canvas, a2, this.p, next);
                            if (a2 == 5) {
                                a(canvas, next);
                            }
                        }
                    }
                }
                canvas.restore();
            }
        }

        private void a(Canvas canvas, int i2, int i3, n nVar) {
            if (i2 == 4) {
                c(canvas);
            }
            if (i2 == 2) {
                b(canvas);
            }
            if (i2 == 3) {
                d(canvas);
            }
            a(canvas);
            b(canvas, i2, i3, nVar);
        }

        private void a(Canvas canvas) {
            canvas.drawLines(this.f2265a, this.f2269e);
        }

        private void b(Canvas canvas, int i2, int i3, n nVar) {
            int i4;
            int i5;
            float f2;
            float f3;
            int i6;
            Canvas canvas2 = canvas;
            int i7 = i2;
            n nVar2 = nVar;
            if (nVar2.f2360a != null) {
                i5 = nVar2.f2360a.getWidth();
                i4 = nVar2.f2360a.getHeight();
            } else {
                i5 = 0;
                i4 = 0;
            }
            for (int i8 = 1; i8 < i3 - 1; i8++) {
                if (i7 != 4 || this.f2266b[i8 - 1] != 0) {
                    float[] fArr = this.f2267c;
                    int i9 = i8 * 2;
                    float f4 = fArr[i9];
                    float f5 = fArr[i9 + 1];
                    this.f2268d.reset();
                    this.f2268d.moveTo(f4, f5 + 10.0f);
                    this.f2268d.lineTo(f4 + 10.0f, f5);
                    this.f2268d.lineTo(f4, f5 - 10.0f);
                    this.f2268d.lineTo(f4 - 10.0f, f5);
                    this.f2268d.close();
                    int i10 = i8 - 1;
                    nVar2.a(i10);
                    if (i7 == 4) {
                        int[] iArr = this.f2266b;
                        if (iArr[i10] == 1) {
                            a(canvas2, f4 - 0.0f, f5 - 0.0f);
                        } else if (iArr[i10] == 2) {
                            b(canvas2, f4 - 0.0f, f5 - 0.0f);
                        } else if (iArr[i10] == 3) {
                            i6 = 3;
                            f3 = f5;
                            f2 = f4;
                            a(canvas, f4 - 0.0f, f5 - 0.0f, i5, i4);
                            canvas2.drawPath(this.f2268d, this.f2273i);
                        }
                        f3 = f5;
                        f2 = f4;
                        i6 = 3;
                        canvas2.drawPath(this.f2268d, this.f2273i);
                    } else {
                        f3 = f5;
                        f2 = f4;
                        i6 = 3;
                    }
                    if (i7 == 2) {
                        a(canvas2, f2 - 0.0f, f3 - 0.0f);
                    }
                    if (i7 == i6) {
                        b(canvas2, f2 - 0.0f, f3 - 0.0f);
                    }
                    if (i7 == 6) {
                        a(canvas, f2 - 0.0f, f3 - 0.0f, i5, i4);
                    }
                    canvas2.drawPath(this.f2268d, this.f2273i);
                }
            }
            float[] fArr2 = this.f2265a;
            if (fArr2.length > 1) {
                canvas2.drawCircle(fArr2[0], fArr2[1], 8.0f, this.f2270f);
                float[] fArr3 = this.f2265a;
                canvas2.drawCircle(fArr3[fArr3.length - 2], fArr3[fArr3.length - 1], 8.0f, this.f2270f);
            }
        }

        private void b(Canvas canvas) {
            float[] fArr = this.f2265a;
            canvas.drawLine(fArr[0], fArr[1], fArr[fArr.length - 2], fArr[fArr.length - 1], this.f2271g);
        }

        private void c(Canvas canvas) {
            boolean z = false;
            boolean z2 = false;
            for (int i2 = 0; i2 < this.p; i2++) {
                if (this.f2266b[i2] == 1) {
                    z = true;
                }
                if (this.f2266b[i2] == 2) {
                    z2 = true;
                }
            }
            if (z) {
                b(canvas);
            }
            if (z2) {
                d(canvas);
            }
        }

        private void a(Canvas canvas, float f2, float f3) {
            float[] fArr = this.f2265a;
            float f4 = fArr[0];
            float f5 = fArr[1];
            float f6 = fArr[fArr.length - 2];
            float f7 = fArr[fArr.length - 1];
            float hypot = (float) Math.hypot((double) (f4 - f6), (double) (f5 - f7));
            float f8 = f6 - f4;
            float f9 = f7 - f5;
            float f10 = (((f2 - f4) * f8) + ((f3 - f5) * f9)) / (hypot * hypot);
            float f11 = f4 + (f8 * f10);
            float f12 = f5 + (f10 * f9);
            Path path = new Path();
            path.moveTo(f2, f3);
            path.lineTo(f11, f12);
            float hypot2 = (float) Math.hypot((double) (f11 - f2), (double) (f12 - f3));
            StringBuilder sb = new StringBuilder();
            sb.append(((float) ((int) ((hypot2 * 100.0f) / hypot))) / 100.0f);
            String sb2 = sb.toString();
            a(sb2, this.f2272h);
            canvas.drawTextOnPath(sb2, path, (hypot2 / 2.0f) - ((float) (this.q.width() / 2)), -20.0f, this.f2272h);
            canvas.drawLine(f2, f3, f11, f12, this.f2271g);
        }

        private void a(String str, Paint paint) {
            paint.getTextBounds(str, 0, str.length(), this.q);
        }

        private void d(Canvas canvas) {
            float[] fArr = this.f2265a;
            float f2 = fArr[0];
            float f3 = fArr[1];
            float f4 = fArr[fArr.length - 2];
            float f5 = fArr[fArr.length - 1];
            canvas.drawLine(Math.min(f2, f4), Math.max(f3, f5), Math.max(f2, f4), Math.max(f3, f5), this.f2271g);
            canvas.drawLine(Math.min(f2, f4), Math.min(f3, f5), Math.min(f2, f4), Math.max(f3, f5), this.f2271g);
        }

        private void b(Canvas canvas, float f2, float f3) {
            Canvas canvas2 = canvas;
            float[] fArr = this.f2265a;
            float f4 = fArr[0];
            float f5 = fArr[1];
            float f6 = fArr[fArr.length - 2];
            float f7 = fArr[fArr.length - 1];
            float min = Math.min(f4, f6);
            float max = Math.max(f5, f7);
            float min2 = f2 - Math.min(f4, f6);
            float max2 = Math.max(f5, f7) - f3;
            StringBuilder sb = new StringBuilder();
            sb.append(((float) ((int) (((double) ((min2 * 100.0f) / Math.abs(f6 - f4))) + 0.5d))) / 100.0f);
            String sb2 = sb.toString();
            a(sb2, this.f2272h);
            canvas2.drawText(sb2, ((min2 / 2.0f) - ((float) (this.q.width() / 2))) + min, f3 - 20.0f, this.f2272h);
            canvas.drawLine(f2, f3, Math.min(f4, f6), f3, this.f2271g);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(((float) ((int) (((double) ((max2 * 100.0f) / Math.abs(f7 - f5))) + 0.5d))) / 100.0f);
            String sb4 = sb3.toString();
            a(sb4, this.f2272h);
            canvas2.drawText(sb4, f2 + 5.0f, max - ((max2 / 2.0f) - ((float) (this.q.height() / 2))), this.f2272h);
            canvas.drawLine(f2, f3, f2, Math.max(f5, f7), this.f2271g);
        }

        private void a(Canvas canvas, float f2, float f3, int i2, int i3) {
            Canvas canvas2 = canvas;
            StringBuilder sb = new StringBuilder();
            sb.append(((float) ((int) (((double) (((f2 - ((float) (i2 / 2))) * 100.0f) / ((float) (MotionLayout.this.getWidth() - i2)))) + 0.5d))) / 100.0f);
            String sb2 = sb.toString();
            a(sb2, this.f2272h);
            canvas.drawText(sb2, ((f2 / 2.0f) - ((float) (this.q.width() / 2))) + 0.0f, f3 - 20.0f, this.f2272h);
            canvas.drawLine(f2, f3, Math.min(0.0f, 1.0f), f3, this.f2271g);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(((float) ((int) (((double) (((f3 - ((float) (i3 / 2))) * 100.0f) / ((float) (MotionLayout.this.getHeight() - i3)))) + 0.5d))) / 100.0f);
            String sb4 = sb3.toString();
            a(sb4, this.f2272h);
            canvas.drawText(sb4, f2 + 5.0f, 0.0f - ((f3 / 2.0f) - ((float) (this.q.height() / 2))), this.f2272h);
            canvas.drawLine(f2, f3, f2, Math.max(0.0f, 1.0f), this.f2271g);
        }

        private void a(Canvas canvas, n nVar) {
            Canvas canvas2 = canvas;
            n nVar2 = nVar;
            this.f2268d.reset();
            char c2 = 0;
            int i2 = 0;
            while (i2 <= 50) {
                float[] fArr = this.u;
                nVar2.f2366g[c2].a((double) nVar2.a(((float) i2) / 50.0f, (float[]) null), nVar2.m);
                p pVar = nVar2.f2363d;
                int[] iArr = nVar2.l;
                double[] dArr = nVar2.m;
                float f2 = pVar.f2374f;
                float f3 = pVar.f2375g;
                float f4 = pVar.f2376h;
                float f5 = pVar.f2377i;
                int i3 = 0;
                while (i3 < iArr.length) {
                    int i4 = i2;
                    float f6 = (float) dArr[i3];
                    int i5 = iArr[i3];
                    if (i5 != 0) {
                        if (i5 == 1) {
                            f2 = f6;
                        } else if (i5 == 2) {
                            f3 = f6;
                        } else if (i5 == 3) {
                            f4 = f6;
                        } else if (i5 == 4) {
                            f5 = f6;
                        }
                    }
                    i3++;
                    i2 = i4;
                }
                float f7 = f4 + f2;
                float f8 = f5 + f3;
                Float.isNaN(Float.NaN);
                Float.isNaN(Float.NaN);
                float f9 = f2 + 0.0f;
                float f10 = f3 + 0.0f;
                float f11 = f7 + 0.0f;
                float f12 = f8 + 0.0f;
                fArr[0] = f9;
                fArr[1] = f10;
                fArr[2] = f11;
                fArr[3] = f10;
                fArr[4] = f11;
                fArr[5] = f12;
                fArr[6] = f9;
                fArr[7] = f12;
                Path path = this.f2268d;
                float[] fArr2 = this.u;
                path.moveTo(fArr2[0], fArr2[1]);
                Path path2 = this.f2268d;
                float[] fArr3 = this.u;
                path2.lineTo(fArr3[2], fArr3[3]);
                Path path3 = this.f2268d;
                float[] fArr4 = this.u;
                path3.lineTo(fArr4[4], fArr4[5]);
                Path path4 = this.f2268d;
                float[] fArr5 = this.u;
                path4.lineTo(fArr5[6], fArr5[7]);
                this.f2268d.close();
                i2++;
                c2 = 0;
            }
            this.f2269e.setColor(1140850688);
            canvas2.translate(2.0f, 2.0f);
            canvas2.drawPath(this.f2268d, this.f2269e);
            canvas2.translate(-2.0f, -2.0f);
            this.f2269e.setColor(-65536);
            canvas2.drawPath(this.f2268d, this.f2269e);
        }
    }

    public void dispatchDraw(Canvas canvas) {
        String str;
        a(false);
        super.dispatchDraw(canvas);
        if (this.f2250b != null) {
            if ((this.n & 1) == 1 && !isInEditMode()) {
                this.ag++;
                long nanoTime = getNanoTime();
                long j2 = this.ah;
                if (j2 != -1) {
                    long j3 = nanoTime - j2;
                    if (j3 > 200000000) {
                        this.ai = ((float) ((int) ((((float) this.ag) / (((float) j3) * 1.0E-9f)) * 100.0f))) / 100.0f;
                        this.ag = 0;
                        this.ah = nanoTime;
                    }
                } else {
                    this.ah = nanoTime;
                }
                Paint paint = new Paint();
                paint.setTextSize(42.0f);
                StringBuilder sb = new StringBuilder();
                sb.append(this.ai + " fps " + a.a(this, this.M) + " -> ");
                sb.append(a.a(this, this.N));
                sb.append(" (progress: ");
                sb.append(((float) ((int) (getProgress() * 1000.0f))) / 10.0f);
                sb.append(" ) state=");
                int i2 = this.f2253e;
                if (i2 == -1) {
                    str = "undefined";
                } else {
                    str = a.a(this, i2);
                }
                sb.append(str);
                String sb2 = sb.toString();
                paint.setColor(-16777216);
                canvas.drawText(sb2, 11.0f, (float) (getHeight() - 29), paint);
                paint.setColor(-7864184);
                canvas.drawText(sb2, 10.0f, (float) (getHeight() - 30), paint);
            }
            if (this.n > 1) {
                if (this.o == null) {
                    this.o = new b();
                }
                this.o.a(canvas, this.f2255g, this.f2250b.e(), this.n);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z2) {
        float f2;
        boolean z3;
        int i2;
        int i3;
        if (this.R == -1) {
            this.R = getNanoTime();
        }
        float f3 = this.j;
        if (f3 > 0.0f && f3 < 1.0f) {
            this.f2253e = -1;
        }
        boolean z4 = false;
        if (this.ad || (this.l && (z2 || this.k != this.j))) {
            float signum = Math.signum(this.k - this.j);
            long nanoTime = getNanoTime();
            if (!(this.f2251c instanceof o)) {
                f2 = ((((float) (nanoTime - this.R)) * signum) * 1.0E-9f) / this.f2256h;
                this.f2252d = f2;
            } else {
                f2 = 0.0f;
            }
            float f4 = this.j + f2;
            if (this.S) {
                f4 = this.k;
            }
            int i4 = (signum > 0.0f ? 1 : (signum == 0.0f ? 0 : -1));
            if ((i4 <= 0 || f4 < this.k) && (signum > 0.0f || f4 > this.k)) {
                z3 = false;
            } else {
                f4 = this.k;
                this.l = false;
                z3 = true;
            }
            this.j = f4;
            this.f2257i = f4;
            this.R = nanoTime;
            Interpolator interpolator = this.f2251c;
            if (interpolator != null && !z3) {
                if (this.W) {
                    float interpolation = interpolator.getInterpolation(((float) (nanoTime - this.Q)) * 1.0E-9f);
                    this.j = interpolation;
                    this.R = nanoTime;
                    Interpolator interpolator2 = this.f2251c;
                    if (interpolator2 instanceof o) {
                        float a2 = ((o) interpolator2).a();
                        this.f2252d = a2;
                        if (Math.abs(a2) * this.f2256h <= 1.0E-5f) {
                            this.l = false;
                        }
                        if (a2 > 0.0f && interpolation >= 1.0f) {
                            this.j = 1.0f;
                            this.l = false;
                            interpolation = 1.0f;
                        }
                        if (a2 < 0.0f && interpolation <= 0.0f) {
                            this.j = 0.0f;
                            this.l = false;
                            f4 = 0.0f;
                        }
                    }
                    f4 = interpolation;
                } else {
                    float interpolation2 = interpolator.getInterpolation(f4);
                    Interpolator interpolator3 = this.f2251c;
                    if (interpolator3 instanceof o) {
                        this.f2252d = ((o) interpolator3).a();
                    } else {
                        this.f2252d = ((interpolator3.getInterpolation(f4 + f2) - interpolation2) * signum) / f2;
                    }
                    f4 = interpolation2;
                }
            }
            if (Math.abs(this.f2252d) > 1.0E-5f) {
                setState(h.MOVING);
            }
            if ((i4 > 0 && f4 >= this.k) || (signum <= 0.0f && f4 <= this.k)) {
                f4 = this.k;
                this.l = false;
            }
            int i5 = (f4 > 1.0f ? 1 : (f4 == 1.0f ? 0 : -1));
            if (i5 >= 0 || f4 <= 0.0f) {
                this.l = false;
                setState(h.FINISHED);
            }
            int childCount = getChildCount();
            this.ad = false;
            long nanoTime2 = getNanoTime();
            this.I = f4;
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                n nVar = this.f2255g.get(childAt);
                if (nVar != null) {
                    this.ad = nVar.a(childAt, f4, nanoTime2, this.al) | this.ad;
                }
            }
            boolean z5 = (i4 > 0 && f4 >= this.k) || (signum <= 0.0f && f4 <= this.k);
            if (!this.ad && !this.l && z5) {
                setState(h.FINISHED);
            }
            if (this.B) {
                requestLayout();
            }
            this.ad = (!z5) | this.ad;
            if (!(f4 > 0.0f || (i3 = this.M) == -1 || this.f2253e == i3)) {
                this.f2253e = i3;
                this.f2250b.a(i3).d((ConstraintLayout) this);
                setState(h.FINISHED);
                z4 = true;
            }
            if (((double) f4) >= 1.0d && this.f2253e != (i2 = this.N)) {
                this.f2253e = i2;
                this.f2250b.a(i2).d((ConstraintLayout) this);
                setState(h.FINISHED);
                z4 = true;
            }
            if (this.ad || this.l) {
                invalidate();
            } else if ((i4 > 0 && i5 == 0) || (signum < 0.0f && f4 == 0.0f)) {
                setState(h.FINISHED);
            }
            if ((!this.ad && this.l && i4 > 0 && i5 == 0) || (signum < 0.0f && f4 == 0.0f)) {
                d();
            }
        }
        float f5 = this.j;
        if (f5 >= 1.0f) {
            if (this.f2253e != this.N) {
                z4 = true;
            }
            this.f2253e = this.N;
        } else if (f5 <= 0.0f) {
            if (this.f2253e != this.M) {
                z4 = true;
            }
            this.f2253e = this.M;
        }
        this.ao |= z4;
        if (z4 && !this.am) {
            requestLayout();
        }
        this.f2257i = this.j;
    }

    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        this.am = true;
        try {
            if (this.f2250b == null) {
                super.onLayout(z2, i2, i3, i4, i5);
                return;
            }
            int i6 = i4 - i2;
            int i7 = i5 - i3;
            if (!(this.s == i6 && this.t == i7)) {
                h();
                a(true);
            }
            this.s = i6;
            this.t = i7;
            this.q = i6;
            this.r = i7;
            this.am = false;
        } finally {
            this.am = false;
        }
    }

    public void parseLayoutDescription(int i2) {
        this.mConstraintLayoutSpec = null;
    }

    private void a(AttributeSet attributeSet) {
        q qVar;
        q qVar2;
        String str;
        String str2;
        f2249a = isInEditMode();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.MotionLayout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            boolean z2 = true;
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.MotionLayout_layoutDescription) {
                    this.f2250b = new q(getContext(), this, obtainStyledAttributes.getResourceId(index, -1));
                } else if (index == R.styleable.MotionLayout_currentState) {
                    this.f2253e = obtainStyledAttributes.getResourceId(index, -1);
                } else if (index == R.styleable.MotionLayout_motionProgress) {
                    this.k = obtainStyledAttributes.getFloat(index, 0.0f);
                    this.l = true;
                } else if (index == R.styleable.MotionLayout_applyMotionScene) {
                    z2 = obtainStyledAttributes.getBoolean(index, z2);
                } else if (index == R.styleable.MotionLayout_showPaths) {
                    if (this.n == 0) {
                        this.n = obtainStyledAttributes.getBoolean(index, false) ? 2 : 0;
                    }
                } else if (index == R.styleable.MotionLayout_motionDebug) {
                    this.n = obtainStyledAttributes.getInt(index, 0);
                }
            }
            obtainStyledAttributes.recycle();
            if (!z2) {
                this.f2250b = null;
            }
        }
        if (!(this.n == 0 || (qVar2 = this.f2250b) == null)) {
            int b2 = qVar2.b();
            q qVar3 = this.f2250b;
            androidx.constraintlayout.widget.c a2 = qVar3.a(qVar3.b());
            String a3 = a.a(getContext(), b2);
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                int id = childAt.getId();
                if (id == -1) {
                    StringBuilder sb = new StringBuilder("CHECK: ");
                    sb.append(a3);
                    sb.append(" ALL VIEWS SHOULD HAVE ID's ");
                    sb.append(childAt.getClass().getName());
                    sb.append(" does not!");
                }
                if ((a2.f2536c.containsKey(Integer.valueOf(id)) ? a2.f2536c.get(Integer.valueOf(id)) : null) == null) {
                    StringBuilder sb2 = new StringBuilder("CHECK: ");
                    sb2.append(a3);
                    sb2.append(" NO CONSTRAINTS for ");
                    sb2.append(a.a(childAt));
                }
            }
            int[] a4 = a2.a();
            for (int i4 = 0; i4 < a4.length; i4++) {
                int i5 = a4[i4];
                String a5 = a.a(getContext(), i5);
                if (findViewById(a4[i4]) == null) {
                    StringBuilder sb3 = new StringBuilder("CHECK: ");
                    sb3.append(a3);
                    sb3.append(" NO View matches id ");
                    sb3.append(a5);
                }
                if (a2.c(i5) == -1) {
                    StringBuilder sb4 = new StringBuilder("CHECK: ");
                    sb4.append(a3);
                    sb4.append("(");
                    sb4.append(a5);
                    sb4.append(") no LAYOUT_HEIGHT");
                }
                if (a2.d(i5) == -1) {
                    StringBuilder sb5 = new StringBuilder("CHECK: ");
                    sb5.append(a3);
                    sb5.append("(");
                    sb5.append(a5);
                    sb5.append(") no LAYOUT_HEIGHT");
                }
            }
            SparseIntArray sparseIntArray = new SparseIntArray();
            SparseIntArray sparseIntArray2 = new SparseIntArray();
            Iterator<q.a> it2 = this.f2250b.f2381d.iterator();
            while (it2.hasNext()) {
                q.a next = it2.next();
                StringBuilder sb6 = new StringBuilder("CHECK: transition = ");
                Context context = getContext();
                if (next.f2392d == -1) {
                    str = "null";
                } else {
                    str = context.getResources().getResourceEntryName(next.f2392d);
                }
                if (next.f2391c == -1) {
                    str2 = str + " -> null";
                } else {
                    str2 = str + " -> " + context.getResources().getResourceEntryName(next.f2391c);
                }
                sb6.append(str2);
                new StringBuilder("CHECK: transition.setDuration = ").append(next.f2396h);
                int i6 = next.f2392d;
                int i7 = next.f2391c;
                String a6 = a.a(getContext(), i6);
                String a7 = a.a(getContext(), i7);
                if (sparseIntArray.get(i6) == i7) {
                    StringBuilder sb7 = new StringBuilder("CHECK: two transitions with the same start and end ");
                    sb7.append(a6);
                    sb7.append("->");
                    sb7.append(a7);
                }
                if (sparseIntArray2.get(i7) == i6) {
                    StringBuilder sb8 = new StringBuilder("CHECK: you can't have reverse transitions");
                    sb8.append(a6);
                    sb8.append("->");
                    sb8.append(a7);
                }
                sparseIntArray.put(i6, i7);
                sparseIntArray2.put(i7, i6);
                this.f2250b.a(i6);
                this.f2250b.a(i7);
            }
        }
        if (this.f2253e == -1 && (qVar = this.f2250b) != null) {
            this.f2253e = qVar.b();
            this.M = this.f2250b.b();
            this.N = this.f2250b.c();
        }
    }

    public void setScene(q qVar) {
        this.f2250b = qVar;
        this.f2250b.a(isRtl());
        h();
    }

    public void setDebugMode(int i2) {
        this.n = i2;
        invalidate();
    }

    private boolean a(float f2, float f3, View view, MotionEvent motionEvent) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (a(((float) view.getLeft()) + f2, ((float) view.getTop()) + f3, viewGroup.getChildAt(i2), motionEvent)) {
                    return true;
                }
            }
        }
        this.ap.set(((float) view.getLeft()) + f2, ((float) view.getTop()) + f3, f2 + ((float) view.getRight()), f3 + ((float) view.getBottom()));
        if (motionEvent.getAction() == 0) {
            return this.ap.contains(motionEvent.getX(), motionEvent.getY()) && view.onTouchEvent(motionEvent);
        }
        if (view.onTouchEvent(motionEvent)) {
            return true;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        q.a aVar;
        t tVar;
        int i2;
        RectF a2;
        q qVar = this.f2250b;
        if (qVar != null && this.f2254f && (aVar = qVar.f2380c) != null && aVar.a() && (tVar = aVar.l) != null && ((motionEvent.getAction() != 0 || (a2 = tVar.a(this, new RectF())) == null || a2.contains(motionEvent.getX(), motionEvent.getY())) && (i2 = tVar.f2423c) != -1)) {
            View view = this.aq;
            if (view == null || view.getId() != i2) {
                this.aq = findViewById(i2);
            }
            View view2 = this.aq;
            if (view2 != null) {
                this.ap.set((float) view2.getLeft(), (float) this.aq.getTop(), (float) this.aq.getRight(), (float) this.aq.getBottom());
                if (this.ap.contains(motionEvent.getX(), motionEvent.getY()) && !a(0.0f, 0.0f, this.aq, motionEvent)) {
                    return onTouchEvent(motionEvent);
                }
            }
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        q qVar = this.f2250b;
        if (qVar == null || !this.f2254f || !qVar.a()) {
            return super.onTouchEvent(motionEvent);
        }
        q.a aVar = this.f2250b.f2380c;
        if (aVar != null && !aVar.a()) {
            return super.onTouchEvent(motionEvent);
        }
        this.f2250b.a(motionEvent, getCurrentState(), this);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        int i2;
        super.onAttachedToWindow();
        q qVar = this.f2250b;
        if (!(qVar == null || (i2 = this.f2253e) == -1)) {
            androidx.constraintlayout.widget.c a2 = qVar.a(i2);
            this.f2250b.a(this);
            if (a2 != null) {
                a2.c((ConstraintLayout) this);
            }
            this.M = this.f2253e;
        }
        d();
        f fVar = this.an;
        if (fVar != null) {
            fVar.a();
            return;
        }
        q qVar2 = this.f2250b;
        if (qVar2 != null && qVar2.f2380c != null && this.f2250b.f2380c.n == 4) {
            a(1.0f);
            setState(h.SETUP);
            setState(h.MOVING);
        }
    }

    public void onRtlPropertiesChanged(int i2) {
        q qVar = this.f2250b;
        if (qVar != null) {
            qVar.a(isRtl());
        }
    }

    /* access modifiers changed from: package-private */
    public final void d() {
        q qVar = this.f2250b;
        if (qVar != null) {
            if (qVar.b(this, this.f2253e)) {
                requestLayout();
                return;
            }
            int i2 = this.f2253e;
            if (i2 != -1) {
                this.f2250b.a(this, i2);
            }
            if (this.f2250b.a()) {
                this.f2250b.i();
            }
        }
    }

    public int getCurrentState() {
        return this.f2253e;
    }

    public float getProgress() {
        return this.j;
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, float f2, float f3, float f4, float[] fArr) {
        HashMap<View, n> hashMap = this.f2255g;
        View viewById = getViewById(i2);
        n nVar = hashMap.get(viewById);
        if (nVar != null) {
            nVar.a(f2, f3, f4, fArr);
            float y2 = viewById.getY();
            this.U = f2;
            this.V = y2;
        } else if (viewById == null) {
            String.valueOf(i2);
        } else {
            viewById.getContext().getResources().getResourceName(i2);
        }
    }

    public long getTransitionTimeMs() {
        q qVar = this.f2250b;
        if (qVar != null) {
            this.f2256h = ((float) qVar.e()) / 1000.0f;
        }
        return (long) (this.f2256h * 1000.0f);
    }

    public void setTransitionListener(g gVar) {
        this.T = gVar;
    }

    private void e() {
        ArrayList<g> arrayList;
        if ((this.T != null || ((arrayList = this.z) != null && !arrayList.isEmpty())) && this.ak != this.f2257i) {
            if (this.aj != -1) {
                ArrayList<g> arrayList2 = this.z;
                if (arrayList2 != null) {
                    Iterator<g> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        it2.next();
                    }
                }
                this.A = true;
            }
            this.aj = -1;
            this.ak = this.f2257i;
            ArrayList<g> arrayList3 = this.z;
            if (arrayList3 != null) {
                Iterator<g> it3 = arrayList3.iterator();
                while (it3.hasNext()) {
                    it3.next();
                }
            }
            this.A = true;
        }
    }

    private void f() {
        int i2;
        ArrayList<g> arrayList;
        if ((this.T != null || ((arrayList = this.z) != null && !arrayList.isEmpty())) && this.aj == -1) {
            this.aj = this.f2253e;
            if (!this.L.isEmpty()) {
                ArrayList<Integer> arrayList2 = this.L;
                i2 = arrayList2.get(arrayList2.size() - 1).intValue();
            } else {
                i2 = -1;
            }
            int i3 = this.f2253e;
            if (!(i2 == i3 || i3 == -1)) {
                this.L.add(Integer.valueOf(i3));
            }
        }
        g();
    }

    private void g() {
        ArrayList<g> arrayList;
        if (this.T != null || ((arrayList = this.z) != null && !arrayList.isEmpty())) {
            this.A = false;
            Iterator<Integer> it2 = this.L.iterator();
            while (it2.hasNext()) {
                Integer next = it2.next();
                if (this.T != null) {
                    next.intValue();
                }
                ArrayList<g> arrayList2 = this.z;
                if (arrayList2 != null) {
                    Iterator<g> it3 = arrayList2.iterator();
                    while (it3.hasNext()) {
                        it3.next();
                        next.intValue();
                    }
                }
            }
            this.L.clear();
        }
    }

    public b getDesignTool() {
        if (this.ac == null) {
            this.ac = new b(this);
        }
        return this.ac;
    }

    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof MotionHelper) {
            MotionHelper motionHelper = (MotionHelper) view;
            if (this.z == null) {
                this.z = new ArrayList<>();
            }
            this.z.add(motionHelper);
            if (motionHelper.f2245a) {
                if (this.ae == null) {
                    this.ae = new ArrayList<>();
                }
                this.ae.add(motionHelper);
            }
            if (motionHelper.f2246b) {
                if (this.af == null) {
                    this.af = new ArrayList<>();
                }
                this.af.add(motionHelper);
            }
        }
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList<MotionHelper> arrayList = this.ae;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        ArrayList<MotionHelper> arrayList2 = this.af;
        if (arrayList2 != null) {
            arrayList2.remove(view);
        }
    }

    public void setOnShow(float f2) {
        ArrayList<MotionHelper> arrayList = this.ae;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.ae.get(i2).setProgress(f2);
            }
        }
    }

    public void setOnHide(float f2) {
        ArrayList<MotionHelper> arrayList = this.af;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.af.get(i2).setProgress(f2);
            }
        }
    }

    public int[] getConstraintSetIds() {
        q qVar = this.f2250b;
        if (qVar == null) {
            return null;
        }
        int[] iArr = new int[qVar.f2382e.size()];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = qVar.f2382e.keyAt(i2);
        }
        return iArr;
    }

    private void h() {
        this.K.a();
        invalidate();
    }

    public ArrayList<q.a> getDefinedTransitions() {
        q qVar = this.f2250b;
        if (qVar == null) {
            return null;
        }
        return qVar.f2381d;
    }

    public int getStartState() {
        return this.M;
    }

    public int getEndState() {
        return this.N;
    }

    public float getTargetPosition() {
        return this.k;
    }

    public void setTransitionDuration(int i2) {
        q qVar = this.f2250b;
        if (qVar != null) {
            if (qVar.f2380c != null) {
                qVar.f2380c.f2396h = i2;
            } else {
                qVar.f2383f = i2;
            }
        }
    }

    public void setInteractionEnabled(boolean z2) {
        this.f2254f = z2;
    }

    static /* synthetic */ void j(MotionLayout motionLayout) {
        int i2;
        int childCount = motionLayout.getChildCount();
        motionLayout.K.b();
        boolean z2 = true;
        motionLayout.l = true;
        int width = motionLayout.getWidth();
        int height = motionLayout.getHeight();
        q qVar = motionLayout.f2250b;
        if (qVar.f2380c != null) {
            i2 = qVar.f2380c.p;
        } else {
            i2 = -1;
        }
        int i3 = 0;
        if (i2 != -1) {
            for (int i4 = 0; i4 < childCount; i4++) {
                n nVar = motionLayout.f2255g.get(motionLayout.getChildAt(i4));
                if (nVar != null) {
                    nVar.s = i2;
                }
            }
        }
        for (int i5 = 0; i5 < childCount; i5++) {
            n nVar2 = motionLayout.f2255g.get(motionLayout.getChildAt(i5));
            if (nVar2 != null) {
                motionLayout.f2250b.a(nVar2);
                nVar2.a(width, height, motionLayout.getNanoTime());
            }
        }
        float f2 = motionLayout.f2250b.f();
        if (f2 != 0.0f) {
            boolean z3 = ((double) f2) < 0.0d;
            float abs = Math.abs(f2);
            float f3 = -3.4028235E38f;
            float f4 = Float.MAX_VALUE;
            int i6 = 0;
            float f5 = Float.MAX_VALUE;
            float f6 = -3.4028235E38f;
            while (true) {
                if (i6 >= childCount) {
                    z2 = false;
                    break;
                }
                n nVar3 = motionLayout.f2255g.get(motionLayout.getChildAt(i6));
                if (!Float.isNaN(nVar3.f2368i)) {
                    break;
                }
                float f7 = nVar3.f2364e.f2374f;
                float f8 = nVar3.f2364e.f2375g;
                float f9 = z3 ? f8 - f7 : f8 + f7;
                f5 = Math.min(f5, f9);
                f6 = Math.max(f6, f9);
                i6++;
            }
            if (z2) {
                for (int i7 = 0; i7 < childCount; i7++) {
                    n nVar4 = motionLayout.f2255g.get(motionLayout.getChildAt(i7));
                    if (!Float.isNaN(nVar4.f2368i)) {
                        f4 = Math.min(f4, nVar4.f2368i);
                        f3 = Math.max(f3, nVar4.f2368i);
                    }
                }
                while (i3 < childCount) {
                    n nVar5 = motionLayout.f2255g.get(motionLayout.getChildAt(i3));
                    if (!Float.isNaN(nVar5.f2368i)) {
                        nVar5.k = 1.0f / (1.0f - abs);
                        if (z3) {
                            nVar5.j = abs - (((f3 - nVar5.f2368i) / (f3 - f4)) * abs);
                        } else {
                            nVar5.j = abs - (((nVar5.f2368i - f4) * abs) / (f3 - f4));
                        }
                    }
                    i3++;
                }
                return;
            }
            while (i3 < childCount) {
                n nVar6 = motionLayout.f2255g.get(motionLayout.getChildAt(i3));
                float f10 = nVar6.f2364e.f2374f;
                float f11 = nVar6.f2364e.f2375g;
                float f12 = z3 ? f11 - f10 : f11 + f10;
                nVar6.k = 1.0f / (1.0f - abs);
                nVar6.j = abs - (((f12 - f5) * abs) / (f6 - f5));
                i3++;
            }
        }
    }
}
