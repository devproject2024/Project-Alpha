package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.appcompat.view.menu.p;

public abstract class r implements View.OnAttachStateChangeListener, View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    private final float f1785a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1786b;

    /* renamed from: c  reason: collision with root package name */
    final View f1787c;

    /* renamed from: d  reason: collision with root package name */
    private final int f1788d;

    /* renamed from: e  reason: collision with root package name */
    private Runnable f1789e;

    /* renamed from: f  reason: collision with root package name */
    private Runnable f1790f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1791g;

    /* renamed from: h  reason: collision with root package name */
    private int f1792h;

    /* renamed from: i  reason: collision with root package name */
    private final int[] f1793i = new int[2];

    public abstract p a();

    public void onViewAttachedToWindow(View view) {
    }

    public r(View view) {
        this.f1787c = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f1785a = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.f1786b = ViewConfiguration.getTapTimeout();
        this.f1788d = (this.f1786b + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0084, code lost:
        if (r4 != 3) goto L_0x0102;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0110  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r12, android.view.MotionEvent r13) {
        /*
            r11 = this;
            boolean r12 = r11.f1791g
            r0 = 3
            r1 = 1
            r2 = 0
            if (r12 == 0) goto L_0x0071
            android.view.View r3 = r11.f1787c
            androidx.appcompat.view.menu.p r4 = r11.a()
            if (r4 == 0) goto L_0x0061
            boolean r5 = r4.e()
            if (r5 != 0) goto L_0x0016
            goto L_0x0061
        L_0x0016:
            android.widget.ListView r4 = r4.g()
            androidx.appcompat.widget.DropDownListView r4 = (androidx.appcompat.widget.DropDownListView) r4
            if (r4 == 0) goto L_0x0061
            boolean r5 = r4.isShown()
            if (r5 != 0) goto L_0x0025
            goto L_0x0061
        L_0x0025:
            android.view.MotionEvent r5 = android.view.MotionEvent.obtainNoHistory(r13)
            int[] r6 = r11.f1793i
            r3.getLocationOnScreen(r6)
            r3 = r6[r2]
            float r3 = (float) r3
            r6 = r6[r1]
            float r6 = (float) r6
            r5.offsetLocation(r3, r6)
            int[] r3 = r11.f1793i
            r4.getLocationOnScreen(r3)
            r6 = r3[r2]
            int r6 = -r6
            float r6 = (float) r6
            r3 = r3[r1]
            int r3 = -r3
            float r3 = (float) r3
            r5.offsetLocation(r6, r3)
            int r3 = r11.f1792h
            boolean r3 = r4.a(r5, r3)
            r5.recycle()
            int r13 = r13.getActionMasked()
            if (r13 == r1) goto L_0x005a
            if (r13 == r0) goto L_0x005a
            r13 = 1
            goto L_0x005b
        L_0x005a:
            r13 = 0
        L_0x005b:
            if (r3 == 0) goto L_0x0061
            if (r13 == 0) goto L_0x0061
            r13 = 1
            goto L_0x0062
        L_0x0061:
            r13 = 0
        L_0x0062:
            if (r13 != 0) goto L_0x006e
            boolean r13 = r11.c()
            if (r13 != 0) goto L_0x006b
            goto L_0x006e
        L_0x006b:
            r13 = 0
            goto L_0x0125
        L_0x006e:
            r13 = 1
            goto L_0x0125
        L_0x0071:
            android.view.View r3 = r11.f1787c
            boolean r4 = r3.isEnabled()
            if (r4 == 0) goto L_0x0102
            int r4 = r13.getActionMasked()
            if (r4 == 0) goto L_0x00d6
            if (r4 == r1) goto L_0x00d2
            r5 = 2
            if (r4 == r5) goto L_0x0088
            if (r4 == r0) goto L_0x00d2
            goto L_0x0102
        L_0x0088:
            int r0 = r11.f1792h
            int r0 = r13.findPointerIndex(r0)
            if (r0 < 0) goto L_0x0102
            float r4 = r13.getX(r0)
            float r13 = r13.getY(r0)
            float r0 = r11.f1785a
            float r5 = -r0
            int r6 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r6 < 0) goto L_0x00c3
            int r5 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
            if (r5 < 0) goto L_0x00c3
            int r5 = r3.getRight()
            int r6 = r3.getLeft()
            int r5 = r5 - r6
            float r5 = (float) r5
            float r5 = r5 + r0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 >= 0) goto L_0x00c3
            int r4 = r3.getBottom()
            int r5 = r3.getTop()
            int r4 = r4 - r5
            float r4 = (float) r4
            float r4 = r4 + r0
            int r13 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r13 >= 0) goto L_0x00c3
            r13 = 1
            goto L_0x00c4
        L_0x00c3:
            r13 = 0
        L_0x00c4:
            if (r13 != 0) goto L_0x0102
            r11.e()
            android.view.ViewParent r13 = r3.getParent()
            r13.requestDisallowInterceptTouchEvent(r1)
            r13 = 1
            goto L_0x0103
        L_0x00d2:
            r11.e()
            goto L_0x0102
        L_0x00d6:
            int r13 = r13.getPointerId(r2)
            r11.f1792h = r13
            java.lang.Runnable r13 = r11.f1789e
            if (r13 != 0) goto L_0x00e7
            androidx.appcompat.widget.r$a r13 = new androidx.appcompat.widget.r$a
            r13.<init>()
            r11.f1789e = r13
        L_0x00e7:
            java.lang.Runnable r13 = r11.f1789e
            int r0 = r11.f1786b
            long r4 = (long) r0
            r3.postDelayed(r13, r4)
            java.lang.Runnable r13 = r11.f1790f
            if (r13 != 0) goto L_0x00fa
            androidx.appcompat.widget.r$b r13 = new androidx.appcompat.widget.r$b
            r13.<init>()
            r11.f1790f = r13
        L_0x00fa:
            java.lang.Runnable r13 = r11.f1790f
            int r0 = r11.f1788d
            long r4 = (long) r0
            r3.postDelayed(r13, r4)
        L_0x0102:
            r13 = 0
        L_0x0103:
            if (r13 == 0) goto L_0x010d
            boolean r13 = r11.b()
            if (r13 == 0) goto L_0x010d
            r13 = 1
            goto L_0x010e
        L_0x010d:
            r13 = 0
        L_0x010e:
            if (r13 == 0) goto L_0x0125
            long r5 = android.os.SystemClock.uptimeMillis()
            r7 = 3
            r8 = 0
            r9 = 0
            r10 = 0
            r3 = r5
            android.view.MotionEvent r0 = android.view.MotionEvent.obtain(r3, r5, r7, r8, r9, r10)
            android.view.View r3 = r11.f1787c
            r3.onTouchEvent(r0)
            r0.recycle()
        L_0x0125:
            r11.f1791g = r13
            if (r13 != 0) goto L_0x012d
            if (r12 == 0) goto L_0x012c
            goto L_0x012d
        L_0x012c:
            return r2
        L_0x012d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.r.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void onViewDetachedFromWindow(View view) {
        this.f1791g = false;
        this.f1792h = -1;
        Runnable runnable = this.f1789e;
        if (runnable != null) {
            this.f1787c.removeCallbacks(runnable);
        }
    }

    /* access modifiers changed from: protected */
    public boolean b() {
        p a2 = a();
        if (a2 == null || a2.e()) {
            return true;
        }
        a2.a_();
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean c() {
        p a2 = a();
        if (a2 == null || !a2.e()) {
            return true;
        }
        a2.d();
        return true;
    }

    private void e() {
        Runnable runnable = this.f1790f;
        if (runnable != null) {
            this.f1787c.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f1789e;
        if (runnable2 != null) {
            this.f1787c.removeCallbacks(runnable2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void d() {
        e();
        View view = this.f1787c;
        if (view.isEnabled() && !view.isLongClickable() && b()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
            this.f1791g = true;
        }
    }

    class a implements Runnable {
        a() {
        }

        public final void run() {
            ViewParent parent = r.this.f1787c.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        public final void run() {
            r.this.d();
        }
    }
}
