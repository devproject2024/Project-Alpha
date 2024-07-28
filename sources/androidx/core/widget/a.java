package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.h.u;

public abstract class a implements View.OnTouchListener {
    private static final int r = ViewConfiguration.getTapTimeout();

    /* renamed from: a  reason: collision with root package name */
    final C0050a f3169a = new C0050a();

    /* renamed from: b  reason: collision with root package name */
    final View f3170b;

    /* renamed from: c  reason: collision with root package name */
    boolean f3171c;

    /* renamed from: d  reason: collision with root package name */
    boolean f3172d;

    /* renamed from: e  reason: collision with root package name */
    boolean f3173e;

    /* renamed from: f  reason: collision with root package name */
    private final Interpolator f3174f = new AccelerateInterpolator();

    /* renamed from: g  reason: collision with root package name */
    private Runnable f3175g;

    /* renamed from: h  reason: collision with root package name */
    private float[] f3176h = {0.0f, 0.0f};

    /* renamed from: i  reason: collision with root package name */
    private float[] f3177i = {Float.MAX_VALUE, Float.MAX_VALUE};
    private int j;
    private int k;
    private float[] l = {0.0f, 0.0f};
    private float[] m = {0.0f, 0.0f};
    private float[] n = {Float.MAX_VALUE, Float.MAX_VALUE};
    private boolean o;
    private boolean p;
    private boolean q;

    static float a(float f2, float f3, float f4) {
        return f2 > f4 ? f4 : f2 < f3 ? f3 : f2;
    }

    static int a(int i2, int i3) {
        if (i2 > i3) {
            return i3;
        }
        if (i2 < 0) {
            return 0;
        }
        return i2;
    }

    public abstract void a(int i2);

    public abstract boolean b(int i2);

    public a(View view) {
        this.f3170b = view;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        float[] fArr = this.n;
        float f2 = ((float) ((int) ((displayMetrics.density * 1575.0f) + 0.5f))) / 1000.0f;
        fArr[0] = f2;
        fArr[1] = f2;
        float[] fArr2 = this.m;
        float f3 = ((float) ((int) ((displayMetrics.density * 315.0f) + 0.5f))) / 1000.0f;
        fArr2[0] = f3;
        fArr2[1] = f3;
        this.j = 1;
        float[] fArr3 = this.f3177i;
        fArr3[0] = Float.MAX_VALUE;
        fArr3[1] = Float.MAX_VALUE;
        float[] fArr4 = this.f3176h;
        fArr4[0] = 0.2f;
        fArr4[1] = 0.2f;
        float[] fArr5 = this.l;
        fArr5[0] = 0.001f;
        fArr5[1] = 0.001f;
        this.k = r;
        C0050a aVar = this.f3169a;
        aVar.f3178a = 500;
        aVar.f3179b = 500;
    }

    public final a a(boolean z) {
        if (this.p && !z) {
            b();
        }
        this.p = z;
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        if (r0 != 3) goto L_0x007d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0085 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0086 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.p
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L_0x001a
            if (r0 == r2) goto L_0x0016
            r3 = 2
            if (r0 == r3) goto L_0x001e
            r6 = 3
            if (r0 == r6) goto L_0x0016
            goto L_0x007d
        L_0x0016:
            r5.b()
            goto L_0x007d
        L_0x001a:
            r5.f3172d = r2
            r5.o = r1
        L_0x001e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.f3170b
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.a((int) r1, (float) r0, (float) r3, (float) r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.f3170b
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.a((int) r2, (float) r7, (float) r6, (float) r3)
            androidx.core.widget.a$a r7 = r5.f3169a
            r7.f3180c = r0
            r7.f3181d = r6
            boolean r6 = r5.f3173e
            if (r6 != 0) goto L_0x007d
            boolean r6 = r5.a()
            if (r6 == 0) goto L_0x007d
            java.lang.Runnable r6 = r5.f3175g
            if (r6 != 0) goto L_0x0061
            androidx.core.widget.a$b r6 = new androidx.core.widget.a$b
            r6.<init>()
            r5.f3175g = r6
        L_0x0061:
            r5.f3173e = r2
            r5.f3171c = r2
            boolean r6 = r5.o
            if (r6 != 0) goto L_0x0076
            int r6 = r5.k
            if (r6 <= 0) goto L_0x0076
            android.view.View r7 = r5.f3170b
            java.lang.Runnable r0 = r5.f3175g
            long r3 = (long) r6
            androidx.core.h.u.a((android.view.View) r7, (java.lang.Runnable) r0, (long) r3)
            goto L_0x007b
        L_0x0076:
            java.lang.Runnable r6 = r5.f3175g
            r6.run()
        L_0x007b:
            r5.o = r2
        L_0x007d:
            boolean r6 = r5.q
            if (r6 == 0) goto L_0x0086
            boolean r6 = r5.f3173e
            if (r6 == 0) goto L_0x0086
            return r2
        L_0x0086:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: package-private */
    public final boolean a() {
        C0050a aVar = this.f3169a;
        int c2 = aVar.c();
        int b2 = aVar.b();
        return c2 != 0 && b(c2);
    }

    private void b() {
        if (this.f3171c) {
            this.f3173e = false;
        } else {
            this.f3169a.a();
        }
    }

    private float a(int i2, float f2, float f3, float f4) {
        float a2 = a(this.f3176h[i2], f3, this.f3177i[i2], f2);
        int i3 = (a2 > 0.0f ? 1 : (a2 == 0.0f ? 0 : -1));
        if (i3 == 0) {
            return 0.0f;
        }
        float f5 = this.l[i2];
        float f6 = this.m[i2];
        float f7 = this.n[i2];
        float f8 = f5 * f4;
        if (i3 > 0) {
            return a(a2 * f8, f6, f7);
        }
        return -a((-a2) * f8, f6, f7);
    }

    private float a(float f2, float f3, float f4, float f5) {
        float f6;
        float a2 = a(f2 * f3, 0.0f, f4);
        float a3 = a(f3 - f5, a2) - a(f5, a2);
        if (a3 < 0.0f) {
            f6 = -this.f3174f.getInterpolation(-a3);
        } else if (a3 <= 0.0f) {
            return 0.0f;
        } else {
            f6 = this.f3174f.getInterpolation(a3);
        }
        return a(f6, -1.0f, 1.0f);
    }

    private float a(float f2, float f3) {
        if (f3 == 0.0f) {
            return 0.0f;
        }
        int i2 = this.j;
        if (i2 == 0 || i2 == 1) {
            if (f2 < f3) {
                if (f2 >= 0.0f) {
                    return 1.0f - (f2 / f3);
                }
                return (!this.f3173e || this.j != 1) ? 0.0f : 1.0f;
            }
        } else if (i2 == 2 && f2 < 0.0f) {
            return f2 / (-f3);
        }
    }

    class b implements Runnable {
        b() {
        }

        public final void run() {
            if (a.this.f3173e) {
                if (a.this.f3171c) {
                    a aVar = a.this;
                    aVar.f3171c = false;
                    C0050a aVar2 = aVar.f3169a;
                    aVar2.f3182e = AnimationUtils.currentAnimationTimeMillis();
                    aVar2.f3186i = -1;
                    aVar2.f3183f = aVar2.f3182e;
                    aVar2.j = 0.5f;
                    aVar2.f3184g = 0;
                    aVar2.f3185h = 0;
                }
                C0050a aVar3 = a.this.f3169a;
                if ((aVar3.f3186i > 0 && AnimationUtils.currentAnimationTimeMillis() > aVar3.f3186i + ((long) aVar3.k)) || !a.this.a()) {
                    a.this.f3173e = false;
                    return;
                }
                if (a.this.f3172d) {
                    a aVar4 = a.this;
                    aVar4.f3172d = false;
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    aVar4.f3170b.onTouchEvent(obtain);
                    obtain.recycle();
                }
                if (aVar3.f3183f != 0) {
                    long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                    float a2 = aVar3.a(currentAnimationTimeMillis);
                    aVar3.f3183f = currentAnimationTimeMillis;
                    float f2 = ((float) (currentAnimationTimeMillis - aVar3.f3183f)) * ((-4.0f * a2 * a2) + (a2 * 4.0f));
                    aVar3.f3184g = (int) (aVar3.f3180c * f2);
                    aVar3.f3185h = (int) (f2 * aVar3.f3181d);
                    a.this.a(aVar3.f3185h);
                    u.a(a.this.f3170b, (Runnable) this);
                    return;
                }
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
        }
    }

    /* renamed from: androidx.core.widget.a$a  reason: collision with other inner class name */
    static class C0050a {

        /* renamed from: a  reason: collision with root package name */
        int f3178a;

        /* renamed from: b  reason: collision with root package name */
        int f3179b;

        /* renamed from: c  reason: collision with root package name */
        float f3180c;

        /* renamed from: d  reason: collision with root package name */
        float f3181d;

        /* renamed from: e  reason: collision with root package name */
        long f3182e = Long.MIN_VALUE;

        /* renamed from: f  reason: collision with root package name */
        long f3183f = 0;

        /* renamed from: g  reason: collision with root package name */
        int f3184g = 0;

        /* renamed from: h  reason: collision with root package name */
        int f3185h = 0;

        /* renamed from: i  reason: collision with root package name */
        long f3186i = -1;
        float j;
        int k;

        C0050a() {
        }

        public final void a() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.k = a.a((int) (currentAnimationTimeMillis - this.f3182e), this.f3179b);
            this.j = a(currentAnimationTimeMillis);
            this.f3186i = currentAnimationTimeMillis;
        }

        /* access modifiers changed from: package-private */
        public final float a(long j2) {
            if (j2 < this.f3182e) {
                return 0.0f;
            }
            long j3 = this.f3186i;
            if (j3 < 0 || j2 < j3) {
                return a.a(((float) (j2 - this.f3182e)) / ((float) this.f3178a), 0.0f, 1.0f) * 0.5f;
            }
            long j4 = j2 - j3;
            float f2 = this.j;
            return (1.0f - f2) + (f2 * a.a(((float) j4) / ((float) this.k), 0.0f, 1.0f));
        }

        public final int b() {
            float f2 = this.f3180c;
            return (int) (f2 / Math.abs(f2));
        }

        public final int c() {
            float f2 = this.f3181d;
            return (int) (f2 / Math.abs(f2));
        }
    }
}
