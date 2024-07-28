package net.one97.paytm.o2o.movies.slidingPanel;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.core.widget.h;
import com.alipay.mobile.nebula.refresh.H5PullContainer;
import java.util.Arrays;

public final class b {
    private static final Interpolator w = new Interpolator() {
        public final float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    int f75860a;

    /* renamed from: b  reason: collision with root package name */
    int f75861b;

    /* renamed from: c  reason: collision with root package name */
    int f75862c = -1;

    /* renamed from: d  reason: collision with root package name */
    float[] f75863d;

    /* renamed from: e  reason: collision with root package name */
    float[] f75864e;

    /* renamed from: f  reason: collision with root package name */
    int[] f75865f;

    /* renamed from: g  reason: collision with root package name */
    VelocityTracker f75866g;

    /* renamed from: h  reason: collision with root package name */
    float f75867h;

    /* renamed from: i  reason: collision with root package name */
    int f75868i;
    h j;
    final a k;
    View l;
    boolean m;
    final ViewGroup n;
    final Runnable o = new Runnable() {
        public final void run() {
            b.this.b(0);
        }
    };
    private float[] p;
    private float[] q;
    private int[] r;
    private int[] s;
    private int t;
    private float u;
    private int v;

    public static abstract class a {
        public void a() {
        }

        public void a(int i2) {
        }

        public void a(View view, float f2) {
        }

        public abstract boolean a(View view);

        public int b(int i2) {
            return 0;
        }

        public void b() {
        }

        public int c() {
            return 0;
        }
    }

    private b(Context context, ViewGroup viewGroup, Interpolator interpolator, a aVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (aVar != null) {
            this.n = viewGroup;
            this.k = aVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.v = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.f75861b = viewConfiguration.getScaledTouchSlop();
            this.u = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.f75867h = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.j = h.a(context, interpolator == null ? w : interpolator);
        } else {
            throw new IllegalArgumentException("Callback may not be null");
        }
    }

    private void b(View view, int i2) {
        if (view.getParent() == this.n) {
            this.l = view;
            this.f75862c = i2;
            this.k.b();
            b(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.n + ")");
    }

    public final void a() {
        this.f75862c = -1;
        d();
        VelocityTracker velocityTracker = this.f75866g;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f75866g = null;
        }
    }

    public final void b() {
        a();
        if (this.f75860a == 2) {
            this.j.f3197a.getCurrX();
            this.j.f3197a.getCurrY();
            this.j.f3197a.abortAnimation();
            this.j.f3197a.getCurrX();
            this.k.a(this.j.f3197a.getCurrY());
        }
        b(0);
    }

    public final boolean a(View view, int i2, int i3) {
        this.l = view;
        this.f75862c = -1;
        return a(i2, i3, 0, 0);
    }

    /* access modifiers changed from: package-private */
    public final boolean a(int i2, int i3, int i4, int i5) {
        int left = this.l.getLeft();
        int top = this.l.getTop();
        int i6 = i2 - left;
        int i7 = i3 - top;
        if (i6 == 0 && i7 == 0) {
            this.j.f3197a.abortAnimation();
            b(0);
            return false;
        }
        this.j.a(left, top, i6, i7, b(i6, i7, i4, i5));
        b(2);
        return true;
    }

    private int b(int i2, int i3, int i4, int i5) {
        float f2;
        float f3;
        float f4;
        float f5;
        int b2 = b(i4, (int) this.f75867h, (int) this.u);
        int b3 = b(i5, (int) this.f75867h, (int) this.u);
        int abs = Math.abs(i2);
        int abs2 = Math.abs(i3);
        int abs3 = Math.abs(b2);
        int abs4 = Math.abs(b3);
        int i6 = abs3 + abs4;
        int i7 = abs + abs2;
        if (b2 != 0) {
            f3 = (float) abs3;
            f2 = (float) i6;
        } else {
            f3 = (float) abs;
            f2 = (float) i7;
        }
        float f6 = f3 / f2;
        if (b3 != 0) {
            f5 = (float) abs4;
            f4 = (float) i6;
        } else {
            f5 = (float) abs2;
            f4 = (float) i7;
        }
        return (int) ((((float) a(i2, b2, 0)) * f6) + (((float) a(i3, b3, this.k.c())) * (f5 / f4)));
    }

    private int a(int i2, int i3, int i4) {
        int i5;
        if (i2 == 0) {
            return 0;
        }
        int width = this.n.getWidth();
        float f2 = (float) (width / 2);
        float a2 = f2 + (a(Math.min(1.0f, ((float) Math.abs(i2)) / ((float) width))) * f2);
        int abs = Math.abs(i3);
        if (abs > 0) {
            i5 = Math.round(Math.abs(a2 / ((float) abs)) * 1000.0f) * 4;
        } else {
            i5 = (int) (((((float) Math.abs(i2)) / ((float) i4)) + 1.0f) * 256.0f);
        }
        return Math.min(i5, H5PullContainer.DEFALUT_DURATION);
    }

    private static int b(int i2, int i3, int i4) {
        int abs = Math.abs(i2);
        if (abs < i3) {
            return 0;
        }
        if (abs > i4) {
            return i2 > 0 ? i4 : -i4;
        }
        return i2;
    }

    private static float a(float f2, float f3, float f4) {
        float abs = Math.abs(f2);
        if (abs < f3) {
            return 0.0f;
        }
        if (abs > f4) {
            return f2 > 0.0f ? f4 : -f4;
        }
        return f2;
    }

    private static float a(float f2) {
        return (float) Math.sin((double) ((float) (((double) (f2 - 0.5f)) * 0.4712389167638204d)));
    }

    private void b(float f2) {
        this.m = true;
        this.k.a(this.l, f2);
        this.m = false;
        if (this.f75860a == 1) {
            b(0);
        }
    }

    private void d() {
        float[] fArr = this.f75863d;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.f75864e, 0.0f);
            Arrays.fill(this.p, 0.0f);
            Arrays.fill(this.q, 0.0f);
            Arrays.fill(this.f75865f, 0);
            Arrays.fill(this.r, 0);
            Arrays.fill(this.s, 0);
            this.t = 0;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        float[] fArr = this.f75863d;
        if (fArr != null && fArr.length > i2) {
            fArr[i2] = 0.0f;
            this.f75864e[i2] = 0.0f;
            this.p[i2] = 0.0f;
            this.q[i2] = 0.0f;
            this.f75865f[i2] = 0;
            this.r[i2] = 0;
            this.s[i2] = 0;
            this.t = (~(1 << i2)) & this.t;
        }
    }

    private void c(int i2) {
        float[] fArr = this.f75863d;
        if (fArr == null || fArr.length <= i2) {
            int i3 = i2 + 1;
            float[] fArr2 = new float[i3];
            float[] fArr3 = new float[i3];
            float[] fArr4 = new float[i3];
            float[] fArr5 = new float[i3];
            int[] iArr = new int[i3];
            int[] iArr2 = new int[i3];
            int[] iArr3 = new int[i3];
            float[] fArr6 = this.f75863d;
            if (fArr6 != null) {
                System.arraycopy(fArr6, 0, fArr2, 0, fArr6.length);
                float[] fArr7 = this.f75864e;
                System.arraycopy(fArr7, 0, fArr3, 0, fArr7.length);
                float[] fArr8 = this.p;
                System.arraycopy(fArr8, 0, fArr4, 0, fArr8.length);
                float[] fArr9 = this.q;
                System.arraycopy(fArr9, 0, fArr5, 0, fArr9.length);
                int[] iArr4 = this.f75865f;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.r;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.s;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f75863d = fArr2;
            this.f75864e = fArr3;
            this.p = fArr4;
            this.q = fArr5;
            this.f75865f = iArr;
            this.r = iArr2;
            this.s = iArr3;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(float f2, float f3, int i2) {
        c(i2);
        float[] fArr = this.f75863d;
        this.p[i2] = f2;
        fArr[i2] = f2;
        float[] fArr2 = this.f75864e;
        this.q[i2] = f3;
        fArr2[i2] = f3;
        this.f75865f[i2] = c((int) f2, (int) f3);
        this.t |= 1 << i2;
    }

    /* access modifiers changed from: package-private */
    public final void b(int i2) {
        if (this.f75860a != i2) {
            this.f75860a = i2;
            this.k.a();
            if (this.f75860a == 0) {
                this.l = null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean a(View view, int i2) {
        if (view == this.l && this.f75862c == i2) {
            return true;
        }
        if (view == null || !this.k.a(view)) {
            return false;
        }
        this.f75862c = i2;
        b(view, i2);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void b(float f2, float f3, int i2) {
        boolean a2 = a(f2, f3, i2, 1);
        if (a(f3, f2, i2, 4)) {
            a2 |= true;
        }
        if (a(f2, f3, i2, 2)) {
            a2 |= true;
        }
        if (a(f3, f2, i2, 8)) {
            a2 |= true;
        }
        if (a2) {
            int[] iArr = this.r;
            iArr[i2] = iArr[i2] | a2;
        }
    }

    private boolean a(float f2, float f3, int i2, int i3) {
        float abs = Math.abs(f2);
        float abs2 = Math.abs(f3);
        if (!((this.f75865f[i2] & i3) != i3 || (this.f75868i & i3) == 0 || (this.s[i2] & i3) == i3 || (this.r[i2] & i3) == i3)) {
            int i4 = this.f75861b;
            if ((abs > ((float) i4) || abs2 > ((float) i4)) && (this.r[i2] & i3) == 0 && abs > ((float) this.f75861b)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(View view, float f2) {
        if (view == null) {
            return false;
        }
        return (this.k.c() > 0) && Math.abs(f2) > ((float) this.f75861b);
    }

    public final boolean c() {
        return this.f75860a == 1;
    }

    private void e() {
        this.f75866g.computeCurrentVelocity(1000, this.u);
        a(this.f75866g.getXVelocity(this.f75862c), this.f75867h, this.u);
        b(a(this.f75866g.getYVelocity(this.f75862c), this.f75867h, this.u));
    }

    private void c(int i2, int i3, int i4) {
        int left = this.l.getLeft();
        int top = this.l.getTop();
        if (i3 != 0) {
            this.l.offsetLeftAndRight(0 - left);
        }
        if (i4 != 0) {
            i2 = this.k.b(i2);
            this.l.offsetTopAndBottom(i2 - top);
        }
        if (i3 != 0 || i4 != 0) {
            this.k.a(i2);
        }
    }

    private boolean b(int i2, int i3) {
        return b(this.l, i2, i3);
    }

    private static boolean b(View view, int i2, int i3) {
        if (view != null && i2 >= view.getLeft() && i2 < view.getRight() && i3 >= view.getTop() && i3 < view.getBottom()) {
            return true;
        }
        return false;
    }

    public final View a(int i2, int i3) {
        for (int childCount = this.n.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.n.getChildAt(childCount);
            if (i2 >= childAt.getLeft() && i2 < childAt.getRight() && i3 >= childAt.getTop() && i3 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    private int c(int i2, int i3) {
        int i4 = i2 < this.n.getLeft() + this.v ? 1 : 0;
        if (i3 < this.n.getTop() + this.v) {
            i4 |= 4;
        }
        if (i2 > this.n.getRight() - this.v) {
            i4 |= 2;
        }
        return i3 > this.n.getBottom() - this.v ? i4 | 8 : i4;
    }

    public static b a(ViewGroup viewGroup, Interpolator interpolator, a aVar) {
        b bVar = new b(viewGroup.getContext(), viewGroup, interpolator, aVar);
        bVar.f75861b = (int) (((float) bVar.f75861b) * 2.0f);
        return bVar;
    }

    /* access modifiers changed from: package-private */
    public final void a(MotionEvent motionEvent) {
        float[] fArr;
        int pointerCount = motionEvent.getPointerCount();
        for (int i2 = 0; i2 < pointerCount; i2++) {
            int pointerId = motionEvent.getPointerId(i2);
            float x = motionEvent.getX(i2);
            float y = motionEvent.getY(i2);
            float[] fArr2 = this.p;
            if (fArr2 != null && (fArr = this.q) != null && fArr2.length > pointerId && fArr.length > pointerId) {
                fArr2[pointerId] = x;
                fArr[pointerId] = y;
            }
        }
    }

    public final void b(MotionEvent motionEvent) {
        int i2;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.f75866g == null) {
            this.f75866g = VelocityTracker.obtain();
        }
        this.f75866g.addMovement(motionEvent);
        int i3 = 0;
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View a2 = a((int) x, (int) y);
            a(x, y, pointerId);
            a(a2, pointerId);
            if ((this.f75865f[pointerId] & this.f75868i) != 0) {
            }
        } else if (actionMasked == 1) {
            if (this.f75860a == 1) {
                e();
            }
            a();
        } else if (actionMasked != 2) {
            if (actionMasked == 3) {
                if (this.f75860a == 1) {
                    b(0.0f);
                }
                a();
            } else if (actionMasked == 5) {
                int pointerId2 = motionEvent.getPointerId(actionIndex);
                float x2 = motionEvent.getX(actionIndex);
                float y2 = motionEvent.getY(actionIndex);
                a(x2, y2, pointerId2);
                if (this.f75860a == 0) {
                    a(a((int) x2, (int) y2), pointerId2);
                } else if (b((int) x2, (int) y2)) {
                    a(this.l, pointerId2);
                }
            } else if (actionMasked == 6) {
                int pointerId3 = motionEvent.getPointerId(actionIndex);
                if (this.f75860a == 1 && pointerId3 == this.f75862c) {
                    int pointerCount = motionEvent.getPointerCount();
                    while (true) {
                        if (i3 >= pointerCount) {
                            i2 = -1;
                            break;
                        }
                        int pointerId4 = motionEvent.getPointerId(i3);
                        if (pointerId4 != this.f75862c) {
                            View a3 = a((int) motionEvent.getX(i3), (int) motionEvent.getY(i3));
                            View view = this.l;
                            if (a3 == view && a(view, pointerId4)) {
                                i2 = this.f75862c;
                                break;
                            }
                        }
                        i3++;
                    }
                    if (i2 == -1) {
                        e();
                    }
                }
                a(pointerId3);
            }
        } else if (this.f75860a == 1) {
            int findPointerIndex = motionEvent.findPointerIndex(this.f75862c);
            float x3 = motionEvent.getX(findPointerIndex);
            float y3 = motionEvent.getY(findPointerIndex);
            float[] fArr = this.p;
            int i4 = this.f75862c;
            int i5 = (int) (y3 - this.q[i4]);
            this.l.getLeft();
            c(this.l.getTop() + i5, (int) (x3 - fArr[i4]), i5);
            a(motionEvent);
        } else {
            int pointerCount2 = motionEvent.getPointerCount();
            while (i3 < pointerCount2) {
                int pointerId5 = motionEvent.getPointerId(i3);
                float x4 = motionEvent.getX(i3);
                float y4 = motionEvent.getY(i3);
                float f2 = x4 - this.f75863d[pointerId5];
                float f3 = y4 - this.f75864e[pointerId5];
                b(f2, f3, pointerId5);
                if (this.f75860a == 1) {
                    break;
                }
                View a4 = a((int) this.f75863d[pointerId5], (int) this.f75864e[pointerId5]);
                if (a(a4, f3) && a(a4, pointerId5)) {
                    break;
                }
                i3++;
            }
            a(motionEvent);
        }
    }
}
