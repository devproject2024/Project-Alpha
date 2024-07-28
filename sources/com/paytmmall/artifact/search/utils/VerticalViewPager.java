package com.paytmmall.artifact.search.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import androidx.core.d.k;
import androidx.core.d.l;
import androidx.core.h.u;
import androidx.core.h.v;
import com.alipay.mobile.nebula.refresh.H5PullContainer;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;

public class VerticalViewPager extends ViewGroup {
    private static final h ag = new h();
    /* access modifiers changed from: private */
    public static final int[] n = {16842931};
    private static final Comparator<b> o = new Comparator<b>() {
        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return ((b) obj).f16003a - ((b) obj2).f16003a;
        }
    };
    private static final Interpolator p = new Interpolator() {
        public final float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    };
    private int A;
    private int B;
    private int C;
    private boolean D;
    private boolean E;
    private int F = 1;
    private boolean G;
    private int H;
    private int I;
    private int J;
    private float K;
    private float L;
    private int M;
    private int N;
    private int O;
    private int P;
    private int Q;
    private androidx.core.widget.d R;
    private androidx.core.widget.d S;
    private boolean T = true;
    private boolean U;
    private int V;
    private e W;

    /* renamed from: a  reason: collision with root package name */
    final ArrayList<b> f15983a = new ArrayList<>();
    private e aa;
    private d ab;
    private f ac;
    private Method ad;
    private int ae;
    private ArrayList<View> af;
    private final Runnable ah = new Runnable() {
        public final void run() {
            VerticalViewPager.this.setScrollState(0);
            VerticalViewPager.this.b();
        }
    };
    private int ai = 0;
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public com.paytmmall.artifact.search.a.e f15984b;

    /* renamed from: c  reason: collision with root package name */
    float f15985c = -3.4028235E38f;

    /* renamed from: d  reason: collision with root package name */
    float f15986d = Float.MAX_VALUE;

    /* renamed from: e  reason: collision with root package name */
    boolean f15987e;

    /* renamed from: f  reason: collision with root package name */
    boolean f15988f;

    /* renamed from: g  reason: collision with root package name */
    float f15989g;

    /* renamed from: h  reason: collision with root package name */
    float f15990h;

    /* renamed from: i  reason: collision with root package name */
    int f15991i = -1;
    VelocityTracker j;
    int k;
    boolean l;
    long m;
    private final b q = new b();
    private final Rect r = new Rect();
    /* access modifiers changed from: private */
    public int s;
    private int t = -1;
    private Parcelable u = null;
    private ClassLoader v = null;
    private Scroller w;
    private g x;
    private int y;
    private Drawable z;

    interface a {
    }

    interface d {
    }

    public interface e {
    }

    public interface f {
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        int f16003a;

        /* renamed from: b  reason: collision with root package name */
        boolean f16004b;

        /* renamed from: c  reason: collision with root package name */
        float f16005c;

        /* renamed from: d  reason: collision with root package name */
        float f16006d;

        /* renamed from: e  reason: collision with root package name */
        float f16007e;

        b() {
        }
    }

    public VerticalViewPager(Context context) {
        super(context);
        f();
    }

    public VerticalViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f();
    }

    private void f() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.w = new Scroller(context, p);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.J = v.a(viewConfiguration);
        this.M = viewConfiguration.getScaledMinimumFlingVelocity();
        this.k = viewConfiguration.getScaledMaximumFlingVelocity();
        this.R = new androidx.core.widget.d(context);
        this.S = new androidx.core.widget.d(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.N = (int) (25.0f * f2);
        this.O = (int) (2.0f * f2);
        this.H = (int) (f2 * 16.0f);
        u.a((View) this, (androidx.core.h.a) new c());
        if (u.h(this) == 0) {
            u.c((View) this, 1);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.ah);
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: package-private */
    public void setScrollState(int i2) {
        if (this.ai != i2) {
            this.ai = i2;
            boolean z2 = true;
            if (i2 == 1) {
                this.Q = -1;
                this.P = -1;
            }
            if (this.ac != null) {
                if (i2 == 0) {
                    z2 = false;
                }
                int childCount = getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    u.e(getChildAt(i3), z2 ? 2 : 0);
                }
            }
        }
    }

    public void setAdapter(com.paytmmall.artifact.search.a.e eVar) {
        com.paytmmall.artifact.search.a.e eVar2 = this.f15984b;
        if (eVar2 != null) {
            eVar2.f15949a.unregisterObserver(this.x);
            for (int i2 = 0; i2 < this.f15983a.size(); i2++) {
                this.f15983a.get(i2);
                com.paytmmall.artifact.search.a.e.b();
            }
            this.f15983a.clear();
            int i3 = 0;
            while (i3 < getChildCount()) {
                if (!((LayoutParams) getChildAt(i3).getLayoutParams()).f15993a) {
                    removeViewAt(i3);
                    i3--;
                }
                i3++;
            }
            this.s = 0;
            scrollTo(0, 0);
        }
        this.f15984b = eVar;
        if (this.f15984b != null) {
            if (this.x == null) {
                this.x = new g(this, (byte) 0);
            }
            this.f15984b.f15949a.registerObserver(this.x);
            this.f15987e = false;
            this.T = true;
            int i4 = this.t;
            if (i4 >= 0) {
                a(i4, false, true);
                this.t = -1;
                this.u = null;
                this.v = null;
                return;
            }
            b();
        }
    }

    public com.paytmmall.artifact.search.a.e getAdapter() {
        return this.f15984b;
    }

    /* access modifiers changed from: package-private */
    public void setOnAdapterChangeListener(d dVar) {
        this.ab = dVar;
    }

    public void setCurrentItem(int i2) {
        this.f15987e = false;
        a(i2, !this.T, false);
    }

    public void setCurrentItem(int i2, boolean z2) {
        this.f15987e = false;
        a(i2, z2, false);
    }

    public int getCurrentItem() {
        return this.s;
    }

    private void a(int i2, boolean z2, boolean z3) {
        a(i2, z2, z3, 0);
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, boolean z2, boolean z3, int i3) {
        com.paytmmall.artifact.search.a.e eVar = this.f15984b;
        if (eVar == null || eVar.a() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z3 || this.s != i2 || this.f15983a.size() == 0) {
            boolean z4 = true;
            if (i2 < 0) {
                i2 = 0;
            } else if (i2 >= this.f15984b.a()) {
                i2 = this.f15984b.a() - 1;
            }
            int i4 = this.F;
            int i5 = this.s;
            if (i2 > i5 + i4 || i2 < i5 - i4) {
                for (int i6 = 0; i6 < this.f15983a.size(); i6++) {
                    this.f15983a.get(i6).f16004b = true;
                }
            }
            if (this.s == i2) {
                z4 = false;
            }
            c(i2);
            a(i2, z2, i3, z4);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    private void a(int i2, boolean z2, int i3, boolean z3) {
        b d2 = d(i2);
        int height = d2 != null ? (int) (((float) getHeight()) * Math.max(this.f15985c, Math.min(d2.f16007e, this.f15986d))) : 0;
        if (z2) {
            a(height, i3);
            if (z3 && this.aa == null) {
                return;
            }
            return;
        }
        a(false);
        scrollTo(0, height);
    }

    public void setOnPageChangeListener(e eVar) {
        this.W = eVar;
    }

    public void setPageTransformer(boolean z2, f fVar) {
        if (Build.VERSION.SDK_INT >= 11) {
            int i2 = 1;
            boolean z3 = fVar != null;
            boolean z4 = z3 != (this.ac != null);
            this.ac = fVar;
            setChildrenDrawingOrderEnabledCompat(z3);
            if (z3) {
                if (z2) {
                    i2 = 2;
                }
                this.ae = i2;
            } else {
                this.ae = 0;
            }
            if (z4) {
                b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setChildrenDrawingOrderEnabledCompat(boolean z2) {
        if (this.ad == null) {
            Class<ViewGroup> cls = ViewGroup.class;
            try {
                this.ad = cls.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
            } catch (NoSuchMethodException unused) {
                boolean z3 = com.paytmmall.artifact.d.c.f15691a;
            }
        }
        try {
            this.ad.invoke(this, new Object[]{Boolean.valueOf(z2)});
        } catch (Exception unused2) {
            boolean z4 = com.paytmmall.artifact.d.c.f15691a;
        }
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i2, int i3) {
        if (this.ae == 2) {
            i3 = (i2 - 1) - i3;
        }
        return ((LayoutParams) this.af.get(i3).getLayoutParams()).f15999g;
    }

    public int getOffscreenPageLimit() {
        return this.F;
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 <= 0) {
            StringBuilder sb = new StringBuilder("Requested offscreen page limit ");
            sb.append(i2);
            sb.append(" too small; defaulting to 1");
            boolean z2 = com.paytmmall.artifact.d.c.f15691a;
            i2 = 1;
        }
        if (i2 != this.F) {
            this.F = i2;
            b();
        }
    }

    public void setPageMargin(int i2) {
        int i3 = this.y;
        this.y = i2;
        int width = getWidth();
        a(width, width, i2, i3);
        requestLayout();
    }

    public int getPageMargin() {
        return this.y;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.z = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageMarginDrawable(int i2) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i2));
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.z;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.z;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    private static float a(float f2) {
        return (float) Math.sin((double) ((float) (((double) (f2 - 0.5f)) * 0.4712389167638204d)));
    }

    private void a(int i2, int i3) {
        int i4;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i5 = 0 - scrollX;
        int i6 = i2 - scrollY;
        if (i5 == 0 && i6 == 0) {
            a(false);
            b();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int height = getHeight();
        int i7 = height / 2;
        float f2 = (float) height;
        float f3 = (float) i7;
        float a2 = f3 + (a(Math.min(1.0f, (((float) Math.abs(i5)) * 1.0f) / f2)) * f3);
        int abs = Math.abs(i3);
        if (abs > 0) {
            i4 = Math.round(Math.abs(a2 / ((float) abs)) * 1000.0f) * 4;
        } else {
            i4 = (int) (((((float) Math.abs(i5)) / ((f2 * 1.0f) + ((float) this.y))) + 1.0f) * 100.0f);
        }
        this.w.startScroll(scrollX, scrollY, i5, i6, Math.min(i4, H5PullContainer.DEFALUT_DURATION));
        u.g(this);
    }

    private static b b(int i2) {
        new b().f16003a = i2;
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        boolean z2 = this.f15983a.size() < (this.F * 2) + 1 && this.f15983a.size() < this.f15984b.a();
        int i2 = this.s;
        for (int i3 = 0; i3 < this.f15983a.size(); i3++) {
            this.f15983a.get(i3);
        }
        Collections.sort(this.f15983a, o);
        if (z2) {
            int childCount = getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i4).getLayoutParams();
                if (!layoutParams.f15993a) {
                    layoutParams.f15995c = 0.0f;
                    layoutParams.f15996d = 0.0f;
                }
            }
            a(i2, false, true);
            requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        c(this.s);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0055, code lost:
        if (r8.f16003a == r0.s) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005b, code lost:
        r8 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c(int r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r0.s
            if (r2 == r1) goto L_0x000f
            com.paytmmall.artifact.search.utils.VerticalViewPager$b r2 = r0.d(r2)
            r0.s = r1
            goto L_0x0010
        L_0x000f:
            r2 = 0
        L_0x0010:
            com.paytmmall.artifact.search.a.e r1 = r0.f15984b
            if (r1 != 0) goto L_0x0015
            return
        L_0x0015:
            boolean r1 = r0.f15987e
            if (r1 == 0) goto L_0x001a
            return
        L_0x001a:
            android.os.IBinder r1 = r17.getWindowToken()
            if (r1 != 0) goto L_0x0021
            return
        L_0x0021:
            int r1 = r0.F
            int r4 = r0.s
            int r4 = r4 - r1
            r5 = 0
            int r4 = java.lang.Math.max(r5, r4)
            com.paytmmall.artifact.search.a.e r6 = r0.f15984b
            int r6 = r6.a()
            int r7 = r6 + -1
            int r8 = r0.s
            int r8 = r8 + r1
            int r1 = java.lang.Math.min(r7, r8)
            r7 = 0
        L_0x003b:
            java.util.ArrayList<com.paytmmall.artifact.search.utils.VerticalViewPager$b> r8 = r0.f15983a
            int r8 = r8.size()
            if (r7 >= r8) goto L_0x005b
            java.util.ArrayList<com.paytmmall.artifact.search.utils.VerticalViewPager$b> r8 = r0.f15983a
            java.lang.Object r8 = r8.get(r7)
            com.paytmmall.artifact.search.utils.VerticalViewPager$b r8 = (com.paytmmall.artifact.search.utils.VerticalViewPager.b) r8
            int r9 = r8.f16003a
            int r10 = r0.s
            if (r9 < r10) goto L_0x0058
            int r9 = r8.f16003a
            int r10 = r0.s
            if (r9 != r10) goto L_0x005b
            goto L_0x005c
        L_0x0058:
            int r7 = r7 + 1
            goto L_0x003b
        L_0x005b:
            r8 = 0
        L_0x005c:
            if (r8 != 0) goto L_0x0066
            if (r6 <= 0) goto L_0x0066
            int r8 = r0.s
            com.paytmmall.artifact.search.utils.VerticalViewPager$b r8 = b((int) r8)
        L_0x0066:
            r9 = 0
            r10 = 1
            if (r8 == 0) goto L_0x0162
            int r11 = r7 + -1
            if (r11 < 0) goto L_0x0077
            java.util.ArrayList<com.paytmmall.artifact.search.utils.VerticalViewPager$b> r12 = r0.f15983a
            java.lang.Object r12 = r12.get(r11)
            com.paytmmall.artifact.search.utils.VerticalViewPager$b r12 = (com.paytmmall.artifact.search.utils.VerticalViewPager.b) r12
            goto L_0x0078
        L_0x0077:
            r12 = 0
        L_0x0078:
            float r13 = r8.f16006d
            r14 = 1073741824(0x40000000, float:2.0)
            float r13 = r14 - r13
            int r15 = r0.s
            int r15 = r15 - r10
            r3 = r11
            r11 = r7
            r7 = 0
        L_0x0084:
            if (r15 < 0) goto L_0x00dd
            int r16 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
            if (r16 < 0) goto L_0x00ad
            if (r15 >= r4) goto L_0x00ad
            if (r12 == 0) goto L_0x00dd
            int r5 = r12.f16003a
            if (r15 != r5) goto L_0x00d9
            boolean r5 = r12.f16004b
            if (r5 != 0) goto L_0x00d9
            java.util.ArrayList<com.paytmmall.artifact.search.utils.VerticalViewPager$b> r5 = r0.f15983a
            r5.remove(r3)
            com.paytmmall.artifact.search.a.e.b()
            int r3 = r3 + -1
            int r11 = r11 + -1
            if (r3 < 0) goto L_0x00d7
            java.util.ArrayList<com.paytmmall.artifact.search.utils.VerticalViewPager$b> r5 = r0.f15983a
            java.lang.Object r5 = r5.get(r3)
            com.paytmmall.artifact.search.utils.VerticalViewPager$b r5 = (com.paytmmall.artifact.search.utils.VerticalViewPager.b) r5
            goto L_0x00d8
        L_0x00ad:
            if (r12 == 0) goto L_0x00c3
            int r5 = r12.f16003a
            if (r15 != r5) goto L_0x00c3
            float r5 = r12.f16006d
            float r7 = r7 + r5
            int r3 = r3 + -1
            if (r3 < 0) goto L_0x00d7
            java.util.ArrayList<com.paytmmall.artifact.search.utils.VerticalViewPager$b> r5 = r0.f15983a
            java.lang.Object r5 = r5.get(r3)
            com.paytmmall.artifact.search.utils.VerticalViewPager$b r5 = (com.paytmmall.artifact.search.utils.VerticalViewPager.b) r5
            goto L_0x00d8
        L_0x00c3:
            com.paytmmall.artifact.search.utils.VerticalViewPager$b r5 = b((int) r15)
            float r5 = r5.f16006d
            float r7 = r7 + r5
            int r11 = r11 + 1
            if (r3 < 0) goto L_0x00d7
            java.util.ArrayList<com.paytmmall.artifact.search.utils.VerticalViewPager$b> r5 = r0.f15983a
            java.lang.Object r5 = r5.get(r3)
            com.paytmmall.artifact.search.utils.VerticalViewPager$b r5 = (com.paytmmall.artifact.search.utils.VerticalViewPager.b) r5
            goto L_0x00d8
        L_0x00d7:
            r5 = 0
        L_0x00d8:
            r12 = r5
        L_0x00d9:
            int r15 = r15 + -1
            r5 = 0
            goto L_0x0084
        L_0x00dd:
            float r3 = r8.f16006d
            int r4 = r11 + 1
            int r5 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r5 >= 0) goto L_0x015f
            java.util.ArrayList<com.paytmmall.artifact.search.utils.VerticalViewPager$b> r5 = r0.f15983a
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x00f6
            java.util.ArrayList<com.paytmmall.artifact.search.utils.VerticalViewPager$b> r5 = r0.f15983a
            java.lang.Object r5 = r5.get(r4)
            com.paytmmall.artifact.search.utils.VerticalViewPager$b r5 = (com.paytmmall.artifact.search.utils.VerticalViewPager.b) r5
            goto L_0x00f7
        L_0x00f6:
            r5 = 0
        L_0x00f7:
            int r7 = r0.s
            int r7 = r7 + r10
        L_0x00fa:
            if (r7 >= r6) goto L_0x015f
            int r12 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r12 < 0) goto L_0x0127
            if (r7 <= r1) goto L_0x0127
            if (r5 == 0) goto L_0x015f
            int r12 = r5.f16003a
            if (r7 != r12) goto L_0x015c
            boolean r12 = r5.f16004b
            if (r12 != 0) goto L_0x015c
            java.util.ArrayList<com.paytmmall.artifact.search.utils.VerticalViewPager$b> r5 = r0.f15983a
            r5.remove(r4)
            com.paytmmall.artifact.search.a.e.b()
            java.util.ArrayList<com.paytmmall.artifact.search.utils.VerticalViewPager$b> r5 = r0.f15983a
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x0125
            java.util.ArrayList<com.paytmmall.artifact.search.utils.VerticalViewPager$b> r5 = r0.f15983a
            java.lang.Object r5 = r5.get(r4)
            com.paytmmall.artifact.search.utils.VerticalViewPager$b r5 = (com.paytmmall.artifact.search.utils.VerticalViewPager.b) r5
            goto L_0x015c
        L_0x0125:
            r5 = 0
            goto L_0x015c
        L_0x0127:
            if (r5 == 0) goto L_0x0143
            int r12 = r5.f16003a
            if (r7 != r12) goto L_0x0143
            float r5 = r5.f16006d
            float r3 = r3 + r5
            int r4 = r4 + 1
            java.util.ArrayList<com.paytmmall.artifact.search.utils.VerticalViewPager$b> r5 = r0.f15983a
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x0125
            java.util.ArrayList<com.paytmmall.artifact.search.utils.VerticalViewPager$b> r5 = r0.f15983a
            java.lang.Object r5 = r5.get(r4)
            com.paytmmall.artifact.search.utils.VerticalViewPager$b r5 = (com.paytmmall.artifact.search.utils.VerticalViewPager.b) r5
            goto L_0x015c
        L_0x0143:
            com.paytmmall.artifact.search.utils.VerticalViewPager$b r5 = b((int) r7)
            int r4 = r4 + 1
            float r5 = r5.f16006d
            float r3 = r3 + r5
            java.util.ArrayList<com.paytmmall.artifact.search.utils.VerticalViewPager$b> r5 = r0.f15983a
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x0125
            java.util.ArrayList<com.paytmmall.artifact.search.utils.VerticalViewPager$b> r5 = r0.f15983a
            java.lang.Object r5 = r5.get(r4)
            com.paytmmall.artifact.search.utils.VerticalViewPager$b r5 = (com.paytmmall.artifact.search.utils.VerticalViewPager.b) r5
        L_0x015c:
            int r7 = r7 + 1
            goto L_0x00fa
        L_0x015f:
            r0.a((com.paytmmall.artifact.search.utils.VerticalViewPager.b) r8, (int) r11, (com.paytmmall.artifact.search.utils.VerticalViewPager.b) r2)
        L_0x0162:
            int r1 = r0.ae
            if (r1 == 0) goto L_0x0167
            goto L_0x0168
        L_0x0167:
            r10 = 0
        L_0x0168:
            if (r10 == 0) goto L_0x0179
            java.util.ArrayList<android.view.View> r1 = r0.af
            if (r1 != 0) goto L_0x0176
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r0.af = r1
            goto L_0x0179
        L_0x0176:
            r1.clear()
        L_0x0179:
            int r1 = r17.getChildCount()
            r2 = 0
        L_0x017e:
            if (r2 >= r1) goto L_0x01ae
            android.view.View r3 = r0.getChildAt(r2)
            android.view.ViewGroup$LayoutParams r4 = r3.getLayoutParams()
            com.paytmmall.artifact.search.utils.VerticalViewPager$LayoutParams r4 = (com.paytmmall.artifact.search.utils.VerticalViewPager.LayoutParams) r4
            r4.f15999g = r2
            boolean r5 = r4.f15993a
            if (r5 != 0) goto L_0x01a4
            float r5 = r4.f15996d
            int r5 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r5 != 0) goto L_0x01a4
            com.paytmmall.artifact.search.utils.VerticalViewPager$b r5 = r17.g()
            if (r5 == 0) goto L_0x01a4
            float r6 = r5.f16006d
            r4.f15996d = r6
            int r5 = r5.f16003a
            r4.f15998f = r5
        L_0x01a4:
            if (r10 == 0) goto L_0x01ab
            java.util.ArrayList<android.view.View> r4 = r0.af
            r4.add(r3)
        L_0x01ab:
            int r2 = r2 + 1
            goto L_0x017e
        L_0x01ae:
            if (r10 == 0) goto L_0x01b7
            java.util.ArrayList<android.view.View> r1 = r0.af
            com.paytmmall.artifact.search.utils.VerticalViewPager$h r2 = ag
            java.util.Collections.sort(r1, r2)
        L_0x01b7:
            boolean r1 = r17.hasFocus()
            if (r1 == 0) goto L_0x01f2
            android.view.View r1 = r17.findFocus()
            if (r1 == 0) goto L_0x01c8
            com.paytmmall.artifact.search.utils.VerticalViewPager$b r3 = r0.a((android.view.View) r1)
            goto L_0x01c9
        L_0x01c8:
            r3 = 0
        L_0x01c9:
            if (r3 == 0) goto L_0x01d1
            int r1 = r3.f16003a
            int r2 = r0.s
            if (r1 == r2) goto L_0x01f2
        L_0x01d1:
            r1 = 0
        L_0x01d2:
            int r2 = r17.getChildCount()
            if (r1 >= r2) goto L_0x01f2
            android.view.View r2 = r0.getChildAt(r1)
            com.paytmmall.artifact.search.utils.VerticalViewPager$b r3 = r17.g()
            if (r3 == 0) goto L_0x01ef
            int r3 = r3.f16003a
            int r4 = r0.s
            if (r3 != r4) goto L_0x01ef
            r3 = 2
            boolean r2 = r2.requestFocus(r3)
            if (r2 != 0) goto L_0x01f2
        L_0x01ef:
            int r1 = r1 + 1
            goto L_0x01d2
        L_0x01f2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.artifact.search.utils.VerticalViewPager.c(int):void");
    }

    private void a(b bVar, int i2, b bVar2) {
        b bVar3;
        b bVar4;
        int a2 = this.f15984b.a();
        int height = getHeight();
        float f2 = height > 0 ? ((float) this.y) / ((float) height) : 0.0f;
        if (bVar2 != null) {
            int i3 = bVar2.f16003a;
            if (i3 < bVar.f16003a) {
                int i4 = 0;
                float f3 = bVar2.f16007e + bVar2.f16006d + f2;
                while (true) {
                    i3++;
                    if (i3 > bVar.f16003a || i4 >= this.f15983a.size()) {
                        break;
                    }
                    Object obj = this.f15983a.get(i4);
                    while (true) {
                        bVar4 = (b) obj;
                        if (i3 > bVar4.f16003a && i4 < this.f15983a.size() - 1) {
                            i4++;
                            obj = this.f15983a.get(i4);
                        }
                    }
                    while (i3 < bVar4.f16003a) {
                        f3 += f2 + 1.0f;
                        i3++;
                    }
                    bVar4.f16007e = f3;
                    f3 += bVar4.f16006d + f2;
                }
            } else if (i3 > bVar.f16003a) {
                int size = this.f15983a.size() - 1;
                float f4 = bVar2.f16007e;
                while (true) {
                    int i5 = i3 - 1;
                    if (i5 < bVar.f16003a || size < 0) {
                        break;
                    }
                    Object obj2 = this.f15983a.get(size);
                    while (true) {
                        bVar3 = (b) obj2;
                        if (i5 < bVar3.f16003a && size > 0) {
                            size--;
                            obj2 = this.f15983a.get(size);
                        }
                    }
                    while (i3 > bVar3.f16003a) {
                        f4 -= f2 + 1.0f;
                        i5 = i3 - 1;
                    }
                    f4 -= bVar3.f16006d + f2;
                    bVar3.f16007e = f4;
                }
            }
        }
        int size2 = this.f15983a.size();
        float f5 = bVar.f16007e;
        int i6 = bVar.f16003a - 1;
        this.f15985c = bVar.f16003a == 0 ? bVar.f16007e : -3.4028235E38f;
        int i7 = a2 - 1;
        this.f15986d = bVar.f16003a == i7 ? (bVar.f16007e + bVar.f16006d) - 1.0f : Float.MAX_VALUE;
        int i8 = i2 - 1;
        while (i8 >= 0) {
            b bVar5 = this.f15983a.get(i8);
            while (i6 > bVar5.f16003a) {
                i6--;
                f5 -= f2 + 1.0f;
            }
            f5 -= bVar5.f16006d + f2;
            bVar5.f16007e = f5;
            if (bVar5.f16003a == 0) {
                this.f15985c = f5;
            }
            i8--;
            i6--;
        }
        float f6 = bVar.f16007e + bVar.f16006d + f2;
        int i9 = bVar.f16003a + 1;
        int i10 = i2 + 1;
        while (i10 < size2) {
            b bVar6 = this.f15983a.get(i10);
            while (i9 < bVar6.f16003a) {
                i9++;
                f6 += f2 + 1.0f;
            }
            if (bVar6.f16003a == i7) {
                this.f15986d = (bVar6.f16006d + f6) - 1.0f;
            }
            bVar6.f16007e = f6;
            f6 += bVar6.f16006d + f2;
            i10++;
            i9++;
        }
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = k.a(new l<SavedState>() {
            public final /* bridge */ /* synthetic */ Object[] a(int i2) {
                return new SavedState[i2];
            }

            public final /* synthetic */ Object a(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }
        });

        /* renamed from: a  reason: collision with root package name */
        int f16000a;

        /* renamed from: b  reason: collision with root package name */
        Parcelable f16001b;

        /* renamed from: c  reason: collision with root package name */
        ClassLoader f16002c;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f16000a);
            parcel.writeParcelable(this.f16001b, i2);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f16000a + "}";
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f16000a = parcel.readInt();
            this.f16001b = parcel.readParcelable(classLoader);
            this.f16002c = classLoader;
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f16000a = this.s;
        if (this.f15984b != null) {
            savedState.f16001b = null;
        }
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.f15984b != null) {
            a(savedState.f16000a, false, true);
            return;
        }
        this.t = savedState.f16000a;
        this.u = savedState.f16001b;
        this.v = savedState.f16002c;
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        layoutParams2.f15993a |= view instanceof a;
        if (!this.D) {
            super.addView(view, i2, layoutParams);
        } else if (layoutParams2 == null || !layoutParams2.f15993a) {
            layoutParams2.f15997e = true;
            addViewInLayout(view, i2, layoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    private b g() {
        for (int i2 = 0; i2 < this.f15983a.size(); i2++) {
            b bVar = this.f15983a.get(i2);
            if (this.f15984b.c()) {
                return bVar;
            }
        }
        return null;
    }

    private b a(View view) {
        while (true) {
            ViewParent parent = view.getParent();
            if (parent == this) {
                return g();
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    private b d(int i2) {
        for (int i3 = 0; i3 < this.f15983a.size(); i3++) {
            b bVar = this.f15983a.get(i3);
            if (bVar.f16003a == i2) {
                return bVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.T = true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00bb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r17, int r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = 0
            r2 = r17
            int r2 = getDefaultSize(r1, r2)
            r3 = r18
            int r3 = getDefaultSize(r1, r3)
            r0.setMeasuredDimension(r2, r3)
            int r2 = r16.getMeasuredWidth()
            int r3 = r16.getMeasuredHeight()
            int r4 = r3 / 10
            int r5 = r0.H
            int r4 = java.lang.Math.min(r4, r5)
            r0.I = r4
            int r4 = r16.getPaddingLeft()
            int r2 = r2 - r4
            int r4 = r16.getPaddingRight()
            int r2 = r2 - r4
            int r4 = r16.getPaddingTop()
            int r3 = r3 - r4
            int r4 = r16.getPaddingBottom()
            int r3 = r3 - r4
            int r4 = r16.getChildCount()
            r5 = r3
            r3 = r2
            r2 = 0
        L_0x003f:
            r6 = 8
            r7 = 1
            r8 = 1073741824(0x40000000, float:2.0)
            if (r2 >= r4) goto L_0x00c7
            android.view.View r9 = r0.getChildAt(r2)
            int r10 = r9.getVisibility()
            if (r10 == r6) goto L_0x00c2
            android.view.ViewGroup$LayoutParams r6 = r9.getLayoutParams()
            com.paytmmall.artifact.search.utils.VerticalViewPager$LayoutParams r6 = (com.paytmmall.artifact.search.utils.VerticalViewPager.LayoutParams) r6
            if (r6 == 0) goto L_0x00c2
            boolean r10 = r6.f15993a
            if (r10 == 0) goto L_0x00c2
            int r10 = r6.f15994b
            r10 = r10 & 7
            int r11 = r6.f15994b
            r11 = r11 & 112(0x70, float:1.57E-43)
            r12 = 48
            if (r11 == r12) goto L_0x006f
            r12 = 80
            if (r11 != r12) goto L_0x006d
            goto L_0x006f
        L_0x006d:
            r11 = 0
            goto L_0x0070
        L_0x006f:
            r11 = 1
        L_0x0070:
            r12 = 3
            if (r10 == r12) goto L_0x0078
            r12 = 5
            if (r10 != r12) goto L_0x0077
            goto L_0x0078
        L_0x0077:
            r7 = 0
        L_0x0078:
            r10 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r11 == 0) goto L_0x007f
            r10 = 1073741824(0x40000000, float:2.0)
            goto L_0x0084
        L_0x007f:
            if (r7 == 0) goto L_0x0084
            r12 = 1073741824(0x40000000, float:2.0)
            goto L_0x0086
        L_0x0084:
            r12 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x0086:
            int r13 = r6.width
            r14 = -1
            r15 = -2
            if (r13 == r15) goto L_0x0098
            int r10 = r6.width
            if (r10 == r14) goto L_0x0094
            int r10 = r6.width
            r13 = r10
            goto L_0x0095
        L_0x0094:
            r13 = r3
        L_0x0095:
            r10 = 1073741824(0x40000000, float:2.0)
            goto L_0x0099
        L_0x0098:
            r13 = r3
        L_0x0099:
            int r1 = r6.height
            if (r1 == r15) goto L_0x00a6
            int r1 = r6.height
            if (r1 == r14) goto L_0x00a4
            int r1 = r6.height
            goto L_0x00a8
        L_0x00a4:
            r1 = r5
            goto L_0x00a8
        L_0x00a6:
            r1 = r5
            r8 = r12
        L_0x00a8:
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r13, r10)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r8)
            r9.measure(r6, r1)
            if (r11 == 0) goto L_0x00bb
            int r1 = r9.getMeasuredHeight()
            int r5 = r5 - r1
            goto L_0x00c2
        L_0x00bb:
            if (r7 == 0) goto L_0x00c2
            int r1 = r9.getMeasuredWidth()
            int r3 = r3 - r1
        L_0x00c2:
            int r2 = r2 + 1
            r1 = 0
            goto L_0x003f
        L_0x00c7:
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r8)
            r0.C = r1
            r0.D = r7
            r16.b()
            r1 = 0
            r0.D = r1
            int r2 = r16.getChildCount()
        L_0x00d9:
            if (r1 >= r2) goto L_0x0103
            android.view.View r3 = r0.getChildAt(r1)
            int r4 = r3.getVisibility()
            if (r4 == r6) goto L_0x0100
            android.view.ViewGroup$LayoutParams r4 = r3.getLayoutParams()
            com.paytmmall.artifact.search.utils.VerticalViewPager$LayoutParams r4 = (com.paytmmall.artifact.search.utils.VerticalViewPager.LayoutParams) r4
            if (r4 == 0) goto L_0x00f1
            boolean r7 = r4.f15993a
            if (r7 != 0) goto L_0x0100
        L_0x00f1:
            float r7 = (float) r5
            float r4 = r4.f15996d
            float r7 = r7 * r4
            int r4 = (int) r7
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r8)
            int r7 = r0.C
            r3.measure(r7, r4)
        L_0x0100:
            int r1 = r1 + 1
            goto L_0x00d9
        L_0x0103:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.artifact.search.utils.VerticalViewPager.onMeasure(int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            int i6 = this.y;
            a(i2, i4, i6, i6);
        }
    }

    private void a(int i2, int i3, int i4, int i5) {
        if (i3 <= 0 || this.f15983a.isEmpty()) {
            b d2 = d(this.s);
            int min = (int) ((d2 != null ? Math.min(d2.f16007e, this.f15986d) : 0.0f) * ((float) i2));
            if (min != getScrollY()) {
                a(false);
                scrollTo(getScrollX(), min);
                return;
            }
            return;
        }
        int scrollY = (int) ((((float) getScrollY()) / ((float) (i3 + i5))) * ((float) (i4 + i2)));
        scrollTo(getScrollX(), scrollY);
        if (!this.w.isFinished()) {
            this.w.startScroll(0, scrollY, 0, (int) (d(this.s).f16007e * ((float) i2)), this.w.getDuration() - this.w.timePassed());
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        b g2;
        int i6;
        int i7;
        int i8;
        int i9 = 1;
        this.D = true;
        b();
        this.D = false;
        int childCount = getChildCount();
        int i10 = i4 - i2;
        int i11 = i5 - i3;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollY = getScrollY();
        int i12 = paddingTop;
        int i13 = paddingBottom;
        int i14 = 0;
        int i15 = paddingLeft;
        int i16 = 0;
        while (i16 < childCount) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f15993a) {
                    int i17 = layoutParams.f15994b & 7;
                    int i18 = layoutParams.f15994b & 112;
                    if (i17 == i9) {
                        i6 = Math.max((i10 - childAt.getMeasuredWidth()) / 2, i15);
                    } else if (i17 == 3) {
                        int i19 = i15;
                        i15 = childAt.getMeasuredWidth() + i15;
                        i6 = i19;
                    } else if (i17 != 5) {
                        i6 = i15;
                    } else {
                        i6 = (i10 - paddingRight) - childAt.getMeasuredWidth();
                        paddingRight += childAt.getMeasuredWidth();
                    }
                    if (i18 != 16) {
                        if (i18 == 48) {
                            i7 = childAt.getMeasuredHeight() + i12;
                        } else if (i18 != 80) {
                            i7 = i12;
                        } else {
                            i8 = (i11 - i13) - childAt.getMeasuredHeight();
                            i13 += childAt.getMeasuredHeight();
                        }
                        int i20 = i12 + scrollY;
                        childAt.layout(i6, i20, childAt.getMeasuredWidth() + i6, i20 + childAt.getMeasuredHeight());
                        i14++;
                        i12 = i7;
                    } else {
                        i8 = Math.max((i11 - childAt.getMeasuredHeight()) / 2, i12);
                    }
                    int i21 = i8;
                    i7 = i12;
                    i12 = i21;
                    int i202 = i12 + scrollY;
                    childAt.layout(i6, i202, childAt.getMeasuredWidth() + i6, i202 + childAt.getMeasuredHeight());
                    i14++;
                    i12 = i7;
                }
            }
            i16++;
            i9 = 1;
        }
        for (int i22 = 0; i22 < childCount; i22++) {
            View childAt2 = getChildAt(i22);
            if (childAt2.getVisibility() != 8) {
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                if (!layoutParams2.f15993a && (g2 = g()) != null) {
                    int i23 = (int) (((float) i11) * g2.f16007e);
                    if (layoutParams2.f15997e) {
                        layoutParams2.f15997e = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (((float) ((i10 - i15) - paddingRight)) * layoutParams2.f15995c), 1073741824), View.MeasureSpec.makeMeasureSpec((i11 - i23) - i13, 1073741824));
                    }
                    childAt2.layout(i15, i23, childAt2.getMeasuredWidth() + i15, childAt2.getMeasuredHeight() + i23);
                }
            }
        }
        this.A = i15;
        this.B = i10 - paddingRight;
        this.V = i14;
        this.T = false;
    }

    public void computeScroll() {
        if (this.w.isFinished() || !this.w.computeScrollOffset()) {
            a(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.w.getCurrX();
        int currY = this.w.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!a(currX)) {
                this.w.abortAnimation();
                scrollTo(0, currY);
            }
        }
        u.g(this);
    }

    /* access modifiers changed from: package-private */
    public final boolean a(int i2) {
        if (this.f15983a.size() == 0) {
            this.U = false;
            a(0, 0.0f);
            if (this.U) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        b c2 = c();
        float height = (float) getHeight();
        float f2 = ((float) this.y) / height;
        this.U = false;
        a(c2.f16003a, ((((float) i2) / height) - c2.f16007e) / (c2.f16006d + f2));
        if (this.U) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0068  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int r12, float r13) {
        /*
            r11 = this;
            int r0 = r11.V
            r1 = 0
            if (r0 <= 0) goto L_0x006f
            int r0 = r11.getScrollY()
            int r2 = r11.getPaddingTop()
            int r3 = r11.getPaddingBottom()
            int r4 = r11.getHeight()
            int r5 = r11.getChildCount()
            r6 = r3
            r3 = r2
            r2 = 0
        L_0x001c:
            if (r2 >= r5) goto L_0x006f
            android.view.View r7 = r11.getChildAt(r2)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            com.paytmmall.artifact.search.utils.VerticalViewPager$LayoutParams r8 = (com.paytmmall.artifact.search.utils.VerticalViewPager.LayoutParams) r8
            boolean r9 = r8.f15993a
            if (r9 == 0) goto L_0x006c
            int r8 = r8.f15994b
            r8 = r8 & 112(0x70, float:1.57E-43)
            r9 = 16
            if (r8 == r9) goto L_0x0051
            r9 = 48
            if (r8 == r9) goto L_0x004b
            r9 = 80
            if (r8 == r9) goto L_0x003e
            r8 = r3
            goto L_0x0060
        L_0x003e:
            int r8 = r4 - r6
            int r9 = r7.getMeasuredHeight()
            int r8 = r8 - r9
            int r9 = r7.getMeasuredHeight()
            int r6 = r6 + r9
            goto L_0x005d
        L_0x004b:
            int r8 = r7.getHeight()
            int r8 = r8 + r3
            goto L_0x0060
        L_0x0051:
            int r8 = r7.getMeasuredHeight()
            int r8 = r4 - r8
            int r8 = r8 / 2
            int r8 = java.lang.Math.max(r8, r3)
        L_0x005d:
            r10 = r8
            r8 = r3
            r3 = r10
        L_0x0060:
            int r3 = r3 + r0
            int r9 = r7.getTop()
            int r3 = r3 - r9
            if (r3 == 0) goto L_0x006b
            r7.offsetTopAndBottom(r3)
        L_0x006b:
            r3 = r8
        L_0x006c:
            int r2 = r2 + 1
            goto L_0x001c
        L_0x006f:
            int r0 = r11.P
            if (r0 < 0) goto L_0x0075
            if (r12 >= r0) goto L_0x0077
        L_0x0075:
            r11.P = r12
        L_0x0077:
            int r0 = r11.Q
            r2 = 1
            if (r0 < 0) goto L_0x008a
            float r0 = (float) r12
            float r0 = r0 + r13
            double r3 = (double) r0
            double r3 = java.lang.Math.ceil(r3)
            int r13 = r11.Q
            double r5 = (double) r13
            int r13 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r13 <= 0) goto L_0x008d
        L_0x008a:
            int r12 = r12 + r2
            r11.Q = r12
        L_0x008d:
            com.paytmmall.artifact.search.utils.VerticalViewPager$f r12 = r11.ac
            if (r12 == 0) goto L_0x00b1
            r11.getScrollY()
            int r12 = r11.getChildCount()
        L_0x0098:
            if (r1 >= r12) goto L_0x00b1
            android.view.View r13 = r11.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r0 = r13.getLayoutParams()
            com.paytmmall.artifact.search.utils.VerticalViewPager$LayoutParams r0 = (com.paytmmall.artifact.search.utils.VerticalViewPager.LayoutParams) r0
            boolean r0 = r0.f15993a
            if (r0 != 0) goto L_0x00ae
            r13.getTop()
            r11.getHeight()
        L_0x00ae:
            int r1 = r1 + 1
            goto L_0x0098
        L_0x00b1:
            r11.U = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.artifact.search.utils.VerticalViewPager.a(int, float):void");
    }

    private void a(boolean z2) {
        boolean z3 = this.ai == 2;
        if (z3) {
            setScrollingCacheEnabled(false);
            this.w.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.w.getCurrX();
            int currY = this.w.getCurrY();
            if (!(scrollX == currX && scrollY == currY)) {
                scrollTo(currX, currY);
            }
        }
        this.f15987e = false;
        boolean z4 = z3;
        for (int i2 = 0; i2 < this.f15983a.size(); i2++) {
            b bVar = this.f15983a.get(i2);
            if (bVar.f16004b) {
                bVar.f16004b = false;
                z4 = true;
            }
        }
        if (!z4) {
            return;
        }
        if (z2) {
            u.a((View) this, this.ah);
        } else {
            this.ah.run();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        int action = motionEvent.getAction() & PriceRangeSeekBar.INVALID_POINTER_ID;
        if (action == 3 || action == 1) {
            this.f15988f = false;
            this.G = false;
            this.f15991i = -1;
            VelocityTracker velocityTracker = this.j;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.j = null;
            }
            return false;
        }
        if (action != 0) {
            if (this.f15988f) {
                return true;
            }
            if (this.G) {
                return false;
            }
        }
        if (action == 0) {
            float y2 = motionEvent.getY();
            this.f15989g = y2;
            this.f15990h = y2;
            this.L = motionEvent.getX();
            this.f15991i = motionEvent2.getPointerId(0);
            this.G = false;
            this.w.computeScrollOffset();
            if (this.ai != 2 || Math.abs(this.w.getFinalY() - this.w.getCurrY()) <= this.O) {
                a(false);
                this.f15988f = false;
            } else {
                this.w.abortAnimation();
                this.f15987e = false;
                b();
                this.f15988f = true;
                setScrollState(1);
            }
        } else if (action == 2) {
            int i2 = this.f15991i;
            if (i2 != -1) {
                int findPointerIndex = motionEvent2.findPointerIndex(i2);
                float x2 = motionEvent2.getX(findPointerIndex);
                float abs = Math.abs(x2 - this.L);
                float y3 = motionEvent2.getY(findPointerIndex);
                float f2 = this.f15990h;
                float f3 = y3 - f2;
                float abs2 = Math.abs(y3 - f2);
                int i3 = (f3 > 0.0f ? 1 : (f3 == 0.0f ? 0 : -1));
                if (i3 != 0) {
                    float f4 = this.f15990h;
                    if (!((f4 < ((float) this.I) && i3 > 0) || (f4 > ((float) (getHeight() - this.I)) && f3 < 0.0f))) {
                        if (a(this, false, (int) f3, (int) x2, (int) y3)) {
                            this.f15990h = y3;
                            this.f15989g = y3;
                            this.L = x2;
                            this.G = true;
                            return false;
                        }
                    }
                }
                if (abs2 > ((float) this.J) && abs2 > abs) {
                    this.f15988f = true;
                    setScrollState(1);
                    float f5 = this.f15989g;
                    float f6 = (float) this.J;
                    this.f15990h = i3 > 0 ? f5 + f6 : f5 - f6;
                    setScrollingCacheEnabled(true);
                } else if (abs > ((float) this.J)) {
                    this.G = true;
                }
                if (this.f15988f && b(y3)) {
                    u.g(this);
                }
            }
        } else if (action == 6) {
            a(motionEvent);
        }
        if (this.j == null) {
            this.j = VelocityTracker.obtain();
        }
        this.j.addMovement(motionEvent2);
        return this.f15988f;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        com.paytmmall.artifact.search.a.e eVar;
        boolean z2;
        boolean z3;
        if (this.l) {
            return true;
        }
        boolean z4 = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (eVar = this.f15984b) == null || eVar.a() == 0) {
            return false;
        }
        if (this.j == null) {
            this.j = VelocityTracker.obtain();
        }
        this.j.addMovement(motionEvent);
        int action = motionEvent.getAction() & PriceRangeSeekBar.INVALID_POINTER_ID;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (!this.f15988f) {
                        int findPointerIndex = motionEvent.findPointerIndex(this.f15991i);
                        float abs = Math.abs(motionEvent.getX(findPointerIndex) - this.L);
                        float y2 = motionEvent.getY(findPointerIndex);
                        float abs2 = Math.abs(y2 - this.f15990h);
                        int i2 = this.J;
                        if (abs2 > ((float) i2) && abs2 > abs) {
                            this.f15988f = true;
                            float f2 = this.f15989g;
                            this.f15990h = y2 - f2 > 0.0f ? f2 + ((float) i2) : f2 - ((float) i2);
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                        }
                    }
                    if (this.f15988f) {
                        z4 = false | b(motionEvent.getY(motionEvent.findPointerIndex(this.f15991i)));
                    }
                } else if (action != 3) {
                    if (action == 5) {
                        int actionIndex = motionEvent.getActionIndex();
                        this.f15990h = motionEvent.getY(actionIndex);
                        this.f15991i = motionEvent.getPointerId(actionIndex);
                    } else if (action == 6) {
                        a(motionEvent);
                        this.f15990h = motionEvent.getY(motionEvent.findPointerIndex(this.f15991i));
                    }
                } else if (this.f15988f) {
                    a(this.s, true, 0, false);
                    this.f15991i = -1;
                    d();
                    z2 = this.R.a();
                    z3 = this.S.a();
                }
            } else if (this.f15988f) {
                VelocityTracker velocityTracker = this.j;
                velocityTracker.computeCurrentVelocity(1000, (float) this.k);
                int yVelocity = (int) velocityTracker.getYVelocity(this.f15991i);
                this.f15987e = true;
                int height = getHeight();
                int scrollY = getScrollY();
                b c2 = c();
                a(a(c2.f16003a, ((((float) scrollY) / ((float) height)) - c2.f16007e) / c2.f16006d, yVelocity, (int) (motionEvent.getY(motionEvent.findPointerIndex(this.f15991i)) - this.K)), true, true, yVelocity);
                this.f15991i = -1;
                d();
                z2 = this.R.a();
                z3 = this.S.a();
            }
            z4 = z2 | z3;
        } else {
            this.w.abortAnimation();
            this.f15987e = false;
            b();
            this.f15988f = true;
            setScrollState(1);
            float y3 = motionEvent.getY();
            this.f15989g = y3;
            this.f15990h = y3;
            this.f15991i = motionEvent.getPointerId(0);
        }
        if (z4) {
            u.g(this);
        }
        return true;
    }

    private boolean b(float f2) {
        boolean z2;
        float f3 = this.f15990h - f2;
        this.f15990h = f2;
        float scrollY = ((float) getScrollY()) + f3;
        float height = (float) getHeight();
        float f4 = this.f15985c * height;
        float f5 = this.f15986d * height;
        boolean z3 = false;
        b bVar = this.f15983a.get(0);
        ArrayList<b> arrayList = this.f15983a;
        boolean z4 = true;
        b bVar2 = arrayList.get(arrayList.size() - 1);
        if (bVar.f16003a != 0) {
            f4 = bVar.f16007e * height;
            z2 = false;
        } else {
            z2 = true;
        }
        if (bVar2.f16003a != this.f15984b.a() - 1) {
            f5 = bVar2.f16007e * height;
            z4 = false;
        }
        if (scrollY < f4) {
            if (z2) {
                z3 = this.R.a(Math.abs(f4 - scrollY) / height);
            }
            scrollY = f4;
        } else if (scrollY > f5) {
            if (z4) {
                z3 = this.S.a(Math.abs(scrollY - f5) / height);
            }
            scrollY = f5;
        }
        int i2 = (int) scrollY;
        this.f15990h += scrollY - ((float) i2);
        scrollTo(getScrollX(), i2);
        a(i2);
        return z3;
    }

    /* access modifiers changed from: package-private */
    public final b c() {
        int i2;
        int height = getHeight();
        float scrollY = height > 0 ? ((float) getScrollY()) / ((float) height) : 0.0f;
        float f2 = height > 0 ? ((float) this.y) / ((float) height) : 0.0f;
        b bVar = null;
        int i3 = 0;
        boolean z2 = true;
        int i4 = -1;
        float f3 = 0.0f;
        float f4 = 0.0f;
        while (i3 < this.f15983a.size()) {
            b bVar2 = this.f15983a.get(i3);
            if (!z2 && bVar2.f16003a != (i2 = i4 + 1)) {
                bVar2 = this.q;
                bVar2.f16007e = f3 + f4 + f2;
                bVar2.f16003a = i2;
                bVar2.f16005c = 1.0f;
                i3--;
            }
            f3 = bVar2.f16007e;
            float f5 = bVar2.f16006d + f3 + f2;
            if (!z2 && scrollY < f3) {
                return bVar;
            }
            if (scrollY < f5 || i3 == this.f15983a.size() - 1) {
                return bVar2;
            }
            i4 = bVar2.f16003a;
            f4 = bVar2.f16006d;
            i3++;
            bVar = bVar2;
            z2 = false;
        }
        return bVar;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        if (r4 > 0) goto L_0x0036;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(int r2, float r3, int r4, int r5) {
        /*
            r1 = this;
            int r5 = java.lang.Math.abs(r5)
            int r0 = r1.N
            if (r5 <= r0) goto L_0x0014
            int r5 = java.lang.Math.abs(r4)
            int r0 = r1.M
            if (r5 <= r0) goto L_0x0014
            if (r4 <= 0) goto L_0x0013
            goto L_0x0036
        L_0x0013:
            goto L_0x0020
        L_0x0014:
            int r4 = r1.P
            r5 = 1056964608(0x3f000000, float:0.5)
            if (r4 < 0) goto L_0x0023
            if (r4 >= r2) goto L_0x0023
            int r4 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r4 >= 0) goto L_0x0023
        L_0x0020:
            int r2 = r2 + 1
            goto L_0x0036
        L_0x0023:
            int r4 = r1.Q
            if (r4 < 0) goto L_0x0032
            int r0 = r2 + 1
            if (r4 <= r0) goto L_0x0032
            int r4 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r4 < 0) goto L_0x0032
            int r2 = r2 + -1
            goto L_0x0036
        L_0x0032:
            float r2 = (float) r2
            float r2 = r2 + r3
            float r2 = r2 + r5
            int r2 = (int) r2
        L_0x0036:
            java.util.ArrayList<com.paytmmall.artifact.search.utils.VerticalViewPager$b> r3 = r1.f15983a
            int r3 = r3.size()
            if (r3 <= 0) goto L_0x0061
            java.util.ArrayList<com.paytmmall.artifact.search.utils.VerticalViewPager$b> r3 = r1.f15983a
            r4 = 0
            java.lang.Object r3 = r3.get(r4)
            com.paytmmall.artifact.search.utils.VerticalViewPager$b r3 = (com.paytmmall.artifact.search.utils.VerticalViewPager.b) r3
            java.util.ArrayList<com.paytmmall.artifact.search.utils.VerticalViewPager$b> r4 = r1.f15983a
            int r5 = r4.size()
            int r5 = r5 + -1
            java.lang.Object r4 = r4.get(r5)
            com.paytmmall.artifact.search.utils.VerticalViewPager$b r4 = (com.paytmmall.artifact.search.utils.VerticalViewPager.b) r4
            int r3 = r3.f16003a
            int r4 = r4.f16003a
            int r2 = java.lang.Math.min(r2, r4)
            int r2 = java.lang.Math.max(r3, r2)
        L_0x0061:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.artifact.search.utils.VerticalViewPager.a(int, float, int, int):int");
    }

    public void draw(Canvas canvas) {
        com.paytmmall.artifact.search.a.e eVar;
        super.draw(canvas);
        int a2 = u.a((View) this);
        boolean z2 = false;
        if (a2 == 0 || (a2 == 1 && (eVar = this.f15984b) != null && eVar.a() > 1)) {
            if (!this.R.f3191a.isFinished()) {
                int height = getHeight();
                this.R.a((getWidth() - getPaddingLeft()) - getPaddingRight(), height);
                z2 = this.R.a(canvas) | false;
            }
            if (!this.S.f3191a.isFinished()) {
                int height2 = getHeight();
                this.S.a((getWidth() - getPaddingLeft()) - getPaddingRight(), height2);
                z2 |= this.S.a(canvas);
            }
        } else {
            this.R.f3191a.finish();
            this.S.f3191a.finish();
        }
        if (z2) {
            u.g(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f2;
        float f3;
        float f4;
        super.onDraw(canvas);
        if (this.y > 0 && this.z != null && this.f15983a.size() > 0 && this.f15984b != null) {
            int scrollY = getScrollY();
            int height = getHeight();
            float f5 = (float) height;
            float f6 = ((float) this.y) / f5;
            int i2 = 0;
            b bVar = this.f15983a.get(0);
            float f7 = bVar.f16007e;
            int size = this.f15983a.size();
            int i3 = bVar.f16003a;
            int i4 = this.f15983a.get(size - 1).f16003a;
            while (i3 < i4) {
                while (i3 > bVar.f16003a && i2 < size) {
                    i2++;
                    bVar = this.f15983a.get(i2);
                }
                if (i3 == bVar.f16003a) {
                    f3 = (bVar.f16007e + bVar.f16006d) * f5;
                    f2 = bVar.f16007e + bVar.f16006d + f6;
                } else {
                    f2 = f7 + 1.0f + f6;
                    f3 = (f7 + 1.0f) * f5;
                }
                int i5 = this.y;
                if (((float) i5) + f3 > ((float) scrollY)) {
                    f4 = f6;
                    this.z.setBounds(this.A, (int) f3, this.B, (int) (((float) i5) + f3 + 0.5f));
                    this.z.draw(canvas);
                } else {
                    Canvas canvas2 = canvas;
                    f4 = f6;
                }
                if (f3 <= ((float) (scrollY + height))) {
                    i3++;
                    f7 = f2;
                    f6 = f4;
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void d() {
        this.f15988f = false;
        this.G = false;
        VelocityTracker velocityTracker = this.j;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.j = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z2) {
        if (this.E != z2) {
            this.E = z2;
        }
    }

    private boolean a(View view, boolean z2, int i2, int i3, int i4) {
        int i5;
        View view2 = view;
        int i6 = i2;
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i7 = i3 + scrollX;
                if (i7 >= childAt.getLeft() && i7 < childAt.getRight() && (i5 = i4 + scrollY) >= childAt.getTop() && i5 < childAt.getBottom()) {
                    if (a(childAt, true, i2, i7 - childAt.getLeft(), i5 - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (view2 instanceof ExtendedWebView) {
            return ((ExtendedWebView) view2).a(-i6);
        }
        if (!z2 || !u.b(view, -i6)) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0048 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchKeyEvent(android.view.KeyEvent r5) {
        /*
            r4 = this;
            boolean r0 = super.dispatchKeyEvent(r5)
            r1 = 1
            if (r0 != 0) goto L_0x0049
            int r0 = r5.getAction()
            r2 = 0
            if (r0 != 0) goto L_0x0044
            int r0 = r5.getKeyCode()
            r3 = 21
            if (r0 == r3) goto L_0x003d
            r3 = 22
            if (r0 == r3) goto L_0x0036
            r3 = 61
            if (r0 == r3) goto L_0x001f
            goto L_0x0044
        L_0x001f:
            boolean r0 = r5.hasNoModifiers()
            if (r0 == 0) goto L_0x002b
            r5 = 2
            boolean r5 = r4.e(r5)
            goto L_0x0045
        L_0x002b:
            boolean r5 = r5.hasModifiers(r1)
            if (r5 == 0) goto L_0x0044
            boolean r5 = r4.e(r1)
            goto L_0x0045
        L_0x0036:
            r5 = 66
            boolean r5 = r4.e(r5)
            goto L_0x0045
        L_0x003d:
            r5 = 17
            boolean r5 = r4.e(r5)
            goto L_0x0045
        L_0x0044:
            r5 = 0
        L_0x0045:
            if (r5 == 0) goto L_0x0048
            goto L_0x0049
        L_0x0048:
            return r2
        L_0x0049:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.artifact.search.utils.VerticalViewPager.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005e, code lost:
        if (r6 != 2) goto L_0x0069;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean e(int r6) {
        /*
            r5 = this;
            android.view.View r0 = r5.findFocus()
            if (r0 != r5) goto L_0x0007
            r0 = 0
        L_0x0007:
            r1 = 0
            android.view.FocusFinder r2 = android.view.FocusFinder.getInstance()
            android.view.View r2 = r2.findNextFocus(r5, r0, r6)
            r3 = 66
            if (r2 == 0) goto L_0x0053
            if (r2 == r0) goto L_0x0053
            r4 = 33
            if (r6 != r4) goto L_0x0038
            android.graphics.Rect r1 = r5.r
            android.graphics.Rect r1 = r5.a((android.graphics.Rect) r1, (android.view.View) r2)
            int r1 = r1.top
            android.graphics.Rect r3 = r5.r
            android.graphics.Rect r3 = r5.a((android.graphics.Rect) r3, (android.view.View) r0)
            int r3 = r3.top
            if (r0 == 0) goto L_0x0033
            if (r1 < r3) goto L_0x0033
            boolean r1 = r5.h()
            goto L_0x0069
        L_0x0033:
            boolean r1 = r2.requestFocus()
            goto L_0x0069
        L_0x0038:
            if (r6 != r3) goto L_0x0069
            android.graphics.Rect r1 = r5.r
            android.graphics.Rect r1 = r5.a((android.graphics.Rect) r1, (android.view.View) r2)
            int r1 = r1.bottom
            android.graphics.Rect r3 = r5.r
            android.graphics.Rect r3 = r5.a((android.graphics.Rect) r3, (android.view.View) r0)
            int r3 = r3.bottom
            if (r0 == 0) goto L_0x004e
            if (r1 <= r3) goto L_0x0060
        L_0x004e:
            boolean r1 = r2.requestFocus()
            goto L_0x0069
        L_0x0053:
            r0 = 17
            if (r6 == r0) goto L_0x0065
            r0 = 1
            if (r6 != r0) goto L_0x005b
            goto L_0x0065
        L_0x005b:
            if (r6 == r3) goto L_0x0060
            r0 = 2
            if (r6 != r0) goto L_0x0069
        L_0x0060:
            boolean r1 = r5.i()
            goto L_0x0069
        L_0x0065:
            boolean r1 = r5.h()
        L_0x0069:
            if (r1 == 0) goto L_0x0072
            int r6 = android.view.SoundEffectConstants.getContantForFocusDirection(r6)
            r5.playSoundEffect(r6)
        L_0x0072:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.artifact.search.utils.VerticalViewPager.e(int):boolean");
    }

    private Rect a(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    private boolean h() {
        int i2 = this.s;
        if (i2 <= 0) {
            return false;
        }
        setCurrentItem(i2 - 1, true);
        return true;
    }

    private boolean i() {
        com.paytmmall.artifact.search.a.e eVar = this.f15984b;
        if (eVar == null || this.s >= eVar.a() - 1) {
            return false;
        }
        setCurrentItem(this.s + 1, true);
        return true;
    }

    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        b g2;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() == 0 && (g2 = g()) != null && g2.f16003a == this.s) {
                    childAt.addFocusables(arrayList, i2, i3);
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (((i3 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
            arrayList.add(this);
        }
    }

    public void addTouchables(ArrayList<View> arrayList) {
        b g2;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (g2 = g()) != null && g2.f16003a == this.s) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        int i3;
        int i4;
        b g2;
        int childCount = getChildCount();
        int i5 = -1;
        if ((i2 & 130) != 0) {
            i5 = childCount;
            i4 = 0;
            i3 = 1;
        } else {
            i4 = childCount - 1;
            i3 = -1;
        }
        while (i4 != i5) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() == 0 && (g2 = g()) != null && g2.f16003a == this.s && childAt.requestFocus(i2, rect)) {
                return true;
            }
            i4 += i3;
        }
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        b g2;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (g2 = g()) != null && g2.f16003a == this.s && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    class c extends androidx.core.h.a {
        c() {
        }

        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(VerticalViewPager.class.getName());
        }

        public final void onInitializeAccessibilityNodeInfo(View view, androidx.core.h.a.c cVar) {
            super.onInitializeAccessibilityNodeInfo(view, cVar);
            cVar.b((CharSequence) VerticalViewPager.class.getName());
            cVar.j(VerticalViewPager.this.f15984b != null && VerticalViewPager.this.f15984b.a() > 1);
            if (VerticalViewPager.this.f15984b != null && VerticalViewPager.this.s >= 0 && VerticalViewPager.this.s < VerticalViewPager.this.f15984b.a() - 1) {
                cVar.a(4096);
            }
            if (VerticalViewPager.this.f15984b != null && VerticalViewPager.this.s > 0 && VerticalViewPager.this.s < VerticalViewPager.this.f15984b.a()) {
                cVar.a((int) FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
            }
        }

        public final boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
            if (super.performAccessibilityAction(view, i2, bundle)) {
                return true;
            }
            if (i2 != 4096) {
                if (i2 != 8192 || VerticalViewPager.this.f15984b == null || VerticalViewPager.this.s <= 0 || VerticalViewPager.this.s >= VerticalViewPager.this.f15984b.a()) {
                    return false;
                }
                VerticalViewPager verticalViewPager = VerticalViewPager.this;
                verticalViewPager.setCurrentItem(verticalViewPager.s - 1);
                return true;
            } else if (VerticalViewPager.this.f15984b == null || VerticalViewPager.this.s < 0 || VerticalViewPager.this.s >= VerticalViewPager.this.f15984b.a() - 1) {
                return false;
            } else {
                VerticalViewPager verticalViewPager2 = VerticalViewPager.this;
                verticalViewPager2.setCurrentItem(verticalViewPager2.s + 1);
                return true;
            }
        }
    }

    class g extends DataSetObserver {
        private g() {
        }

        /* synthetic */ g(VerticalViewPager verticalViewPager, byte b2) {
            this();
        }

        public final void onChanged() {
            VerticalViewPager.this.a();
        }

        public final void onInvalidated() {
            VerticalViewPager.this.a();
        }
    }

    public static class LayoutParams extends ViewGroup.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public boolean f15993a;

        /* renamed from: b  reason: collision with root package name */
        public int f15994b;

        /* renamed from: c  reason: collision with root package name */
        float f15995c = 0.0f;

        /* renamed from: d  reason: collision with root package name */
        float f15996d = 0.0f;

        /* renamed from: e  reason: collision with root package name */
        boolean f15997e;

        /* renamed from: f  reason: collision with root package name */
        int f15998f;

        /* renamed from: g  reason: collision with root package name */
        int f15999g;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, VerticalViewPager.n);
            this.f15994b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    static class h implements Comparator<View> {
        h() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            LayoutParams layoutParams = (LayoutParams) ((View) obj).getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) ((View) obj2).getLayoutParams();
            if (layoutParams.f15993a != layoutParams2.f15993a) {
                return layoutParams.f15993a ? 1 : -1;
            }
            return layoutParams.f15998f - layoutParams2.f15998f;
        }
    }

    private void a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f15991i) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.f15990h = motionEvent.getY(i2);
            this.f15991i = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.j;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }
}
