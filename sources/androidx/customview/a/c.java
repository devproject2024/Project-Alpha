package androidx.customview.a;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.h.u;
import com.alipay.mobile.nebula.refresh.H5PullContainer;
import java.util.Arrays;

public final class c {
    private static final Interpolator v = new Interpolator() {
        public final float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public int f3234a;

    /* renamed from: b  reason: collision with root package name */
    public int f3235b;

    /* renamed from: c  reason: collision with root package name */
    public float f3236c;

    /* renamed from: d  reason: collision with root package name */
    public int f3237d;

    /* renamed from: e  reason: collision with root package name */
    public int f3238e;

    /* renamed from: f  reason: collision with root package name */
    public View f3239f;

    /* renamed from: g  reason: collision with root package name */
    private int f3240g = -1;

    /* renamed from: h  reason: collision with root package name */
    private float[] f3241h;

    /* renamed from: i  reason: collision with root package name */
    private float[] f3242i;
    private float[] j;
    private float[] k;
    private int[] l;
    private int[] m;
    private int[] n;
    private int o;
    private VelocityTracker p;
    private float q;
    private OverScroller r;
    private final a s;
    private boolean t;
    private final ViewGroup u;
    private final Runnable w = new Runnable() {
        public final void run() {
            c.this.a(0);
        }
    };

    public static abstract class a {
        public int a(View view) {
            return 0;
        }

        public void a() {
        }

        public void a(int i2) {
        }

        public void a(int i2, int i3) {
        }

        public void a(View view, float f2, float f3) {
        }

        public void a(View view, int i2) {
        }

        public void a(View view, int i2, int i3, int i4, int i5) {
        }

        public int b() {
            return 0;
        }

        public abstract boolean b(View view, int i2);

        public int c(View view, int i2) {
            return 0;
        }

        public int d(View view, int i2) {
            return 0;
        }
    }

    public static c a(ViewGroup viewGroup, a aVar) {
        return new c(viewGroup.getContext(), viewGroup, aVar);
    }

    public static c a(ViewGroup viewGroup, float f2, a aVar) {
        c a2 = a(viewGroup, aVar);
        a2.f3235b = (int) (((float) a2.f3235b) * (1.0f / f2));
        return a2;
    }

    private c(Context context, ViewGroup viewGroup, a aVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (aVar != null) {
            this.u = viewGroup;
            this.s = aVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.f3237d = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.f3235b = viewConfiguration.getScaledTouchSlop();
            this.q = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.f3236c = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.r = new OverScroller(context, v);
        } else {
            throw new IllegalArgumentException("Callback may not be null");
        }
    }

    public final int a() {
        return this.f3234a;
    }

    public final void a(View view, int i2) {
        if (view.getParent() == this.u) {
            this.f3239f = view;
            this.f3240g = i2;
            this.s.a(view, i2);
            a(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.u + ")");
    }

    public final View b() {
        return this.f3239f;
    }

    public final int c() {
        return this.f3235b;
    }

    public final void d() {
        this.f3240g = -1;
        float[] fArr = this.f3241h;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.f3242i, 0.0f);
            Arrays.fill(this.j, 0.0f);
            Arrays.fill(this.k, 0.0f);
            Arrays.fill(this.l, 0);
            Arrays.fill(this.m, 0);
            Arrays.fill(this.n, 0);
            this.o = 0;
        }
        VelocityTracker velocityTracker = this.p;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.p = null;
        }
    }

    public final void e() {
        d();
        if (this.f3234a == 2) {
            int currX = this.r.getCurrX();
            int currY = this.r.getCurrY();
            this.r.abortAnimation();
            int currX2 = this.r.getCurrX();
            int currY2 = this.r.getCurrY();
            this.s.a(this.f3239f, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        a(0);
    }

    public final boolean a(View view, int i2, int i3) {
        this.f3239f = view;
        this.f3240g = -1;
        boolean a2 = a(i2, i3, 0, 0);
        if (!a2 && this.f3234a == 0 && this.f3239f != null) {
            this.f3239f = null;
        }
        return a2;
    }

    public final boolean a(int i2, int i3) {
        if (this.t) {
            return a(i2, i3, (int) this.p.getXVelocity(this.f3240g), (int) this.p.getYVelocity(this.f3240g));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    private boolean a(int i2, int i3, int i4, int i5) {
        int left = this.f3239f.getLeft();
        int top = this.f3239f.getTop();
        int i6 = i2 - left;
        int i7 = i3 - top;
        if (i6 == 0 && i7 == 0) {
            this.r.abortAnimation();
            a(0);
            return false;
        }
        this.r.startScroll(left, top, i6, i7, a(this.f3239f, i6, i7, i4, i5));
        a(2);
        return true;
    }

    private int a(View view, int i2, int i3, int i4, int i5) {
        float f2;
        float f3;
        float f4;
        float f5;
        int b2 = b(i4, (int) this.f3236c, (int) this.q);
        int b3 = b(i5, (int) this.f3236c, (int) this.q);
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
        float f7 = f5 / f4;
        return (int) ((((float) a(i2, b2, this.s.a(view))) * f6) + (((float) a(i3, b3, this.s.b())) * f7));
    }

    private int a(int i2, int i3, int i4) {
        int i5;
        if (i2 == 0) {
            return 0;
        }
        int width = this.u.getWidth();
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
        return (float) Math.sin((double) ((f2 - 0.5f) * 0.47123894f));
    }

    public final boolean f() {
        if (this.f3234a == 2) {
            boolean computeScrollOffset = this.r.computeScrollOffset();
            int currX = this.r.getCurrX();
            int currY = this.r.getCurrY();
            int left = currX - this.f3239f.getLeft();
            int top = currY - this.f3239f.getTop();
            if (left != 0) {
                u.g(this.f3239f, left);
            }
            if (top != 0) {
                u.f(this.f3239f, top);
            }
            if (!(left == 0 && top == 0)) {
                this.s.a(this.f3239f, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.r.getFinalX() && currY == this.r.getFinalY()) {
                this.r.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                this.u.post(this.w);
            }
        }
        if (this.f3234a == 2) {
            return true;
        }
        return false;
    }

    private void a(float f2, float f3) {
        this.t = true;
        this.s.a(this.f3239f, f2, f3);
        this.t = false;
        if (this.f3234a == 1) {
            a(0);
        }
    }

    private void c(int i2) {
        if (this.f3241h != null && d(i2)) {
            this.f3241h[i2] = 0.0f;
            this.f3242i[i2] = 0.0f;
            this.j[i2] = 0.0f;
            this.k[i2] = 0.0f;
            this.l[i2] = 0;
            this.m[i2] = 0;
            this.n[i2] = 0;
            this.o = (~(1 << i2)) & this.o;
        }
    }

    private void c(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i2 = 0; i2 < pointerCount; i2++) {
            int pointerId = motionEvent.getPointerId(i2);
            if (e(pointerId)) {
                float x = motionEvent.getX(i2);
                float y = motionEvent.getY(i2);
                this.j[pointerId] = x;
                this.k[pointerId] = y;
            }
        }
    }

    private boolean d(int i2) {
        return ((1 << i2) & this.o) != 0;
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        this.u.removeCallbacks(this.w);
        if (this.f3234a != i2) {
            this.f3234a = i2;
            this.s.a(i2);
            if (this.f3234a == 0) {
                this.f3239f = null;
            }
        }
    }

    private boolean b(View view, int i2) {
        if (view == this.f3239f && this.f3240g == i2) {
            return true;
        }
        if (view == null || !this.s.b(view, i2)) {
            return false;
        }
        this.f3240g = i2;
        a(view, i2);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00d8, code lost:
        if (r12 != r11) goto L_0x00e0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(android.view.MotionEvent r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            int r2 = r17.getActionMasked()
            int r3 = r17.getActionIndex()
            if (r2 != 0) goto L_0x0011
            r16.d()
        L_0x0011:
            android.view.VelocityTracker r4 = r0.p
            if (r4 != 0) goto L_0x001b
            android.view.VelocityTracker r4 = android.view.VelocityTracker.obtain()
            r0.p = r4
        L_0x001b:
            android.view.VelocityTracker r4 = r0.p
            r4.addMovement(r1)
            r4 = 2
            r6 = 1
            if (r2 == 0) goto L_0x00fa
            if (r2 == r6) goto L_0x00f6
            if (r2 == r4) goto L_0x0070
            r7 = 3
            if (r2 == r7) goto L_0x00f6
            r7 = 5
            if (r2 == r7) goto L_0x003c
            r4 = 6
            if (r2 == r4) goto L_0x0033
            goto L_0x0129
        L_0x0033:
            int r1 = r1.getPointerId(r3)
            r0.c((int) r1)
            goto L_0x0129
        L_0x003c:
            int r2 = r1.getPointerId(r3)
            float r7 = r1.getX(r3)
            float r1 = r1.getY(r3)
            r0.a((float) r7, (float) r1, (int) r2)
            int r3 = r0.f3234a
            if (r3 != 0) goto L_0x005f
            int[] r1 = r0.l
            r1 = r1[r2]
            int r2 = r0.f3238e
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0129
            androidx.customview.a.c$a r1 = r0.s
            r1.a()
            goto L_0x0129
        L_0x005f:
            if (r3 != r4) goto L_0x0129
            int r3 = (int) r7
            int r1 = (int) r1
            android.view.View r1 = r0.b((int) r3, (int) r1)
            android.view.View r3 = r0.f3239f
            if (r1 != r3) goto L_0x0129
            r0.b((android.view.View) r1, (int) r2)
            goto L_0x0129
        L_0x0070:
            float[] r2 = r0.f3241h
            if (r2 == 0) goto L_0x0129
            float[] r2 = r0.f3242i
            if (r2 == 0) goto L_0x0129
            int r2 = r17.getPointerCount()
            r3 = 0
        L_0x007d:
            if (r3 >= r2) goto L_0x00f2
            int r4 = r1.getPointerId(r3)
            boolean r7 = r0.e(r4)
            if (r7 == 0) goto L_0x00ef
            float r7 = r1.getX(r3)
            float r8 = r1.getY(r3)
            float[] r9 = r0.f3241h
            r9 = r9[r4]
            float r9 = r7 - r9
            float[] r10 = r0.f3242i
            r10 = r10[r4]
            float r10 = r8 - r10
            int r7 = (int) r7
            int r8 = (int) r8
            android.view.View r7 = r0.b((int) r7, (int) r8)
            if (r7 == 0) goto L_0x00ad
            boolean r8 = r0.a((android.view.View) r7, (float) r9, (float) r10)
            if (r8 == 0) goto L_0x00ad
            r8 = 1
            goto L_0x00ae
        L_0x00ad:
            r8 = 0
        L_0x00ae:
            if (r8 == 0) goto L_0x00e0
            int r11 = r7.getLeft()
            int r12 = (int) r9
            int r12 = r12 + r11
            androidx.customview.a.c$a r13 = r0.s
            int r12 = r13.c(r7, r12)
            int r13 = r7.getTop()
            int r14 = (int) r10
            int r14 = r14 + r13
            androidx.customview.a.c$a r15 = r0.s
            int r14 = r15.d(r7, r14)
            androidx.customview.a.c$a r15 = r0.s
            int r15 = r15.a((android.view.View) r7)
            androidx.customview.a.c$a r5 = r0.s
            int r5 = r5.b()
            if (r15 == 0) goto L_0x00da
            if (r15 <= 0) goto L_0x00e0
            if (r12 != r11) goto L_0x00e0
        L_0x00da:
            if (r5 == 0) goto L_0x00f2
            if (r5 <= 0) goto L_0x00e0
            if (r14 == r13) goto L_0x00f2
        L_0x00e0:
            r0.b((float) r9, (float) r10, (int) r4)
            int r5 = r0.f3234a
            if (r5 == r6) goto L_0x00f2
            if (r8 == 0) goto L_0x00ef
            boolean r4 = r0.b((android.view.View) r7, (int) r4)
            if (r4 != 0) goto L_0x00f2
        L_0x00ef:
            int r3 = r3 + 1
            goto L_0x007d
        L_0x00f2:
            r16.c((android.view.MotionEvent) r17)
            goto L_0x0129
        L_0x00f6:
            r16.d()
            goto L_0x0129
        L_0x00fa:
            float r2 = r17.getX()
            float r3 = r17.getY()
            r5 = 0
            int r1 = r1.getPointerId(r5)
            r0.a((float) r2, (float) r3, (int) r1)
            int r2 = (int) r2
            int r3 = (int) r3
            android.view.View r2 = r0.b((int) r2, (int) r3)
            android.view.View r3 = r0.f3239f
            if (r2 != r3) goto L_0x011b
            int r3 = r0.f3234a
            if (r3 != r4) goto L_0x011b
            r0.b((android.view.View) r2, (int) r1)
        L_0x011b:
            int[] r2 = r0.l
            r1 = r2[r1]
            int r2 = r0.f3238e
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0129
            androidx.customview.a.c$a r1 = r0.s
            r1.a()
        L_0x0129:
            int r1 = r0.f3234a
            if (r1 != r6) goto L_0x012e
            return r6
        L_0x012e:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.customview.a.c.a(android.view.MotionEvent):boolean");
    }

    public final void b(MotionEvent motionEvent) {
        int i2;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            d();
        }
        if (this.p == null) {
            this.p = VelocityTracker.obtain();
        }
        this.p.addMovement(motionEvent);
        int i3 = 0;
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View b2 = b((int) x, (int) y);
            a(x, y, pointerId);
            b(b2, pointerId);
            if ((this.l[pointerId] & this.f3238e) != 0) {
                this.s.a();
            }
        } else if (actionMasked == 1) {
            if (this.f3234a == 1) {
                g();
            }
            d();
        } else if (actionMasked != 2) {
            if (actionMasked == 3) {
                if (this.f3234a == 1) {
                    a(0.0f, 0.0f);
                }
                d();
            } else if (actionMasked == 5) {
                int pointerId2 = motionEvent.getPointerId(actionIndex);
                float x2 = motionEvent.getX(actionIndex);
                float y2 = motionEvent.getY(actionIndex);
                a(x2, y2, pointerId2);
                if (this.f3234a == 0) {
                    b(b((int) x2, (int) y2), pointerId2);
                    if ((this.l[pointerId2] & this.f3238e) != 0) {
                        this.s.a();
                        return;
                    }
                    return;
                }
                if (b(this.f3239f, (int) x2, (int) y2)) {
                    b(this.f3239f, pointerId2);
                }
            } else if (actionMasked == 6) {
                int pointerId3 = motionEvent.getPointerId(actionIndex);
                if (this.f3234a == 1 && pointerId3 == this.f3240g) {
                    int pointerCount = motionEvent.getPointerCount();
                    while (true) {
                        if (i3 >= pointerCount) {
                            i2 = -1;
                            break;
                        }
                        int pointerId4 = motionEvent.getPointerId(i3);
                        if (pointerId4 != this.f3240g) {
                            View b3 = b((int) motionEvent.getX(i3), (int) motionEvent.getY(i3));
                            View view = this.f3239f;
                            if (b3 == view && b(view, pointerId4)) {
                                i2 = this.f3240g;
                                break;
                            }
                        }
                        i3++;
                    }
                    if (i2 == -1) {
                        g();
                    }
                }
                c(pointerId3);
            }
        } else if (this.f3234a != 1) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (i3 < pointerCount2) {
                int pointerId5 = motionEvent.getPointerId(i3);
                if (e(pointerId5)) {
                    float x3 = motionEvent.getX(i3);
                    float y3 = motionEvent.getY(i3);
                    float f2 = x3 - this.f3241h[pointerId5];
                    float f3 = y3 - this.f3242i[pointerId5];
                    b(f2, f3, pointerId5);
                    if (this.f3234a == 1) {
                        break;
                    }
                    View b4 = b((int) x3, (int) y3);
                    if (a(b4, f2, f3) && b(b4, pointerId5)) {
                        break;
                    }
                }
                i3++;
            }
            c(motionEvent);
        } else if (e(this.f3240g)) {
            int findPointerIndex = motionEvent.findPointerIndex(this.f3240g);
            float x4 = motionEvent.getX(findPointerIndex);
            float y4 = motionEvent.getY(findPointerIndex);
            float[] fArr = this.j;
            int i4 = this.f3240g;
            int i5 = (int) (x4 - fArr[i4]);
            int i6 = (int) (y4 - this.k[i4]);
            int left = this.f3239f.getLeft() + i5;
            int top = this.f3239f.getTop() + i6;
            int left2 = this.f3239f.getLeft();
            int top2 = this.f3239f.getTop();
            if (i5 != 0) {
                left = this.s.c(this.f3239f, left);
                u.g(this.f3239f, left - left2);
            }
            int i7 = left;
            if (i6 != 0) {
                top = this.s.d(this.f3239f, top);
                u.f(this.f3239f, top - top2);
            }
            int i8 = top;
            if (!(i5 == 0 && i6 == 0)) {
                this.s.a(this.f3239f, i7, i8, i7 - left2, i8 - top2);
            }
            c(motionEvent);
        }
    }

    private void b(float f2, float f3, int i2) {
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
            int[] iArr = this.m;
            iArr[i2] = iArr[i2] | a2;
            this.s.a(a2 ? 1 : 0, i2);
        }
    }

    private boolean a(float f2, float f3, int i2, int i3) {
        float abs = Math.abs(f2);
        float abs2 = Math.abs(f3);
        if (!((this.l[i2] & i3) != i3 || (this.f3238e & i3) == 0 || (this.n[i2] & i3) == i3 || (this.m[i2] & i3) == i3)) {
            int i4 = this.f3235b;
            if ((abs > ((float) i4) || abs2 > ((float) i4)) && (this.m[i2] & i3) == 0 && abs > ((float) this.f3235b)) {
                return true;
            }
        }
        return false;
    }

    private boolean a(View view, float f2, float f3) {
        if (view == null) {
            return false;
        }
        boolean z = this.s.a(view) > 0;
        boolean z2 = this.s.b() > 0;
        if (!z || !z2) {
            return z ? Math.abs(f2) > ((float) this.f3235b) : z2 && Math.abs(f3) > ((float) this.f3235b);
        }
        int i2 = this.f3235b;
        return (f2 * f2) + (f3 * f3) > ((float) (i2 * i2));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003f, code lost:
        if (((r6 * r6) + (r7 * r7)) > ((float) (r3 * r3))) goto L_0x004f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0063 A[LOOP:0: B:1:0x0005->B:27:0x0063, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0062 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(int r10) {
        /*
            r9 = this;
            float[] r0 = r9.f3241h
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            if (r2 >= r0) goto L_0x0066
            boolean r3 = r9.d(r2)
            r4 = 1
            if (r3 == 0) goto L_0x005f
            r3 = r10 & 1
            if (r3 != r4) goto L_0x0014
            r3 = 1
            goto L_0x0015
        L_0x0014:
            r3 = 0
        L_0x0015:
            r5 = r10 & 2
            r6 = 2
            if (r5 != r6) goto L_0x001c
            r5 = 1
            goto L_0x001d
        L_0x001c:
            r5 = 0
        L_0x001d:
            float[] r6 = r9.j
            r6 = r6[r2]
            float[] r7 = r9.f3241h
            r7 = r7[r2]
            float r6 = r6 - r7
            float[] r7 = r9.k
            r7 = r7[r2]
            float[] r8 = r9.f3242i
            r8 = r8[r2]
            float r7 = r7 - r8
            if (r3 == 0) goto L_0x0042
            if (r5 == 0) goto L_0x0042
            float r6 = r6 * r6
            float r7 = r7 * r7
            float r6 = r6 + r7
            int r3 = r9.f3235b
            int r3 = r3 * r3
            float r3 = (float) r3
            int r3 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x005f
            goto L_0x004f
        L_0x0042:
            if (r3 == 0) goto L_0x0051
            float r3 = java.lang.Math.abs(r6)
            int r5 = r9.f3235b
            float r5 = (float) r5
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x005f
        L_0x004f:
            r3 = 1
            goto L_0x0060
        L_0x0051:
            if (r5 == 0) goto L_0x005f
            float r3 = java.lang.Math.abs(r7)
            int r5 = r9.f3235b
            float r5 = (float) r5
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x005f
            goto L_0x004f
        L_0x005f:
            r3 = 0
        L_0x0060:
            if (r3 == 0) goto L_0x0063
            return r4
        L_0x0063:
            int r2 = r2 + 1
            goto L_0x0005
        L_0x0066:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.customview.a.c.b(int):boolean");
    }

    private void g() {
        this.p.computeCurrentVelocity(1000, this.q);
        a(a(this.p.getXVelocity(this.f3240g), this.f3236c, this.q), a(this.p.getYVelocity(this.f3240g), this.f3236c, this.q));
    }

    public static boolean b(View view, int i2, int i3) {
        if (view != null && i2 >= view.getLeft() && i2 < view.getRight() && i3 >= view.getTop() && i3 < view.getBottom()) {
            return true;
        }
        return false;
    }

    public final View b(int i2, int i3) {
        for (int childCount = this.u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.u.getChildAt(childCount);
            if (i2 >= childAt.getLeft() && i2 < childAt.getRight() && i3 >= childAt.getTop() && i3 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    private boolean e(int i2) {
        if (d(i2)) {
            return true;
        }
        StringBuilder sb = new StringBuilder("Ignoring pointerId=");
        sb.append(i2);
        sb.append(" because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    private void a(float f2, float f3, int i2) {
        float[] fArr = this.f3241h;
        int i3 = 0;
        if (fArr == null || fArr.length <= i2) {
            int i4 = i2 + 1;
            float[] fArr2 = new float[i4];
            float[] fArr3 = new float[i4];
            float[] fArr4 = new float[i4];
            float[] fArr5 = new float[i4];
            int[] iArr = new int[i4];
            int[] iArr2 = new int[i4];
            int[] iArr3 = new int[i4];
            float[] fArr6 = this.f3241h;
            if (fArr6 != null) {
                System.arraycopy(fArr6, 0, fArr2, 0, fArr6.length);
                float[] fArr7 = this.f3242i;
                System.arraycopy(fArr7, 0, fArr3, 0, fArr7.length);
                float[] fArr8 = this.j;
                System.arraycopy(fArr8, 0, fArr4, 0, fArr8.length);
                float[] fArr9 = this.k;
                System.arraycopy(fArr9, 0, fArr5, 0, fArr9.length);
                int[] iArr4 = this.l;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.m;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.n;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f3241h = fArr2;
            this.f3242i = fArr3;
            this.j = fArr4;
            this.k = fArr5;
            this.l = iArr;
            this.m = iArr2;
            this.n = iArr3;
        }
        float[] fArr10 = this.f3241h;
        this.j[i2] = f2;
        fArr10[i2] = f2;
        float[] fArr11 = this.f3242i;
        this.k[i2] = f3;
        fArr11[i2] = f3;
        int[] iArr7 = this.l;
        int i5 = (int) f2;
        int i6 = (int) f3;
        if (i5 < this.u.getLeft() + this.f3237d) {
            i3 = 1;
        }
        if (i6 < this.u.getTop() + this.f3237d) {
            i3 |= 4;
        }
        if (i5 > this.u.getRight() - this.f3237d) {
            i3 |= 2;
        }
        if (i6 > this.u.getBottom() - this.f3237d) {
            i3 |= 8;
        }
        iArr7[i2] = i3;
        this.o |= 1 << i2;
    }
}
