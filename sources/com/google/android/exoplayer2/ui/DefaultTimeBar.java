package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.ui.c;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;

public class DefaultTimeBar extends View implements c {
    private int A;
    private long B;
    private int C;
    private boolean D;
    private long E;
    private long F;
    private long G;
    private long H;
    private int I;
    private long[] J;
    private boolean[] K;

    /* renamed from: a  reason: collision with root package name */
    private final Rect f33531a;

    /* renamed from: b  reason: collision with root package name */
    private final Rect f33532b;

    /* renamed from: c  reason: collision with root package name */
    private final Rect f33533c;

    /* renamed from: d  reason: collision with root package name */
    private final Rect f33534d;

    /* renamed from: e  reason: collision with root package name */
    private final Paint f33535e;

    /* renamed from: f  reason: collision with root package name */
    private final Paint f33536f;

    /* renamed from: g  reason: collision with root package name */
    private final Paint f33537g;

    /* renamed from: h  reason: collision with root package name */
    private final Paint f33538h;

    /* renamed from: i  reason: collision with root package name */
    private final Paint f33539i;
    private final Paint j;
    private final Drawable k;
    private final int l;
    private final int m;
    private final int n;
    private final int o;
    private final int p;
    private final int q;
    private final int r;
    private final int s;
    private final StringBuilder t;
    private final Formatter u;
    private final Runnable v;
    private final CopyOnWriteArraySet<c.a> w;
    private final int[] x;
    private final Point y;
    private final float z;

    private static int a(float f2, int i2) {
        return (int) ((((float) i2) * f2) + 0.5f);
    }

    public DefaultTimeBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public DefaultTimeBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DefaultTimeBar(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, attributeSet);
    }

    public DefaultTimeBar(Context context, AttributeSet attributeSet, int i2, AttributeSet attributeSet2) {
        super(context, attributeSet, i2);
        this.f33531a = new Rect();
        this.f33532b = new Rect();
        this.f33533c = new Rect();
        this.f33534d = new Rect();
        this.f33535e = new Paint();
        this.f33536f = new Paint();
        this.f33537g = new Paint();
        this.f33538h = new Paint();
        this.f33539i = new Paint();
        this.j = new Paint();
        this.j.setAntiAlias(true);
        this.w = new CopyOnWriteArraySet<>();
        this.x = new int[2];
        this.y = new Point();
        this.z = context.getResources().getDisplayMetrics().density;
        this.s = a(this.z, -50);
        int a2 = a(this.z, 4);
        int a3 = a(this.z, 26);
        int a4 = a(this.z, 4);
        int a5 = a(this.z, 12);
        int a6 = a(this.z, 0);
        int a7 = a(this.z, 16);
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R.styleable.DefaultTimeBar, 0, 0);
            try {
                this.k = obtainStyledAttributes.getDrawable(R.styleable.DefaultTimeBar_scrubber_drawable);
                if (this.k != null) {
                    Drawable drawable = this.k;
                    if (ae.f32499a >= 23) {
                        a(drawable, getLayoutDirection());
                    }
                    a3 = Math.max(this.k.getMinimumHeight(), a3);
                }
                this.l = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DefaultTimeBar_bar_height, a2);
                this.m = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DefaultTimeBar_touch_target_height, a3);
                this.n = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DefaultTimeBar_ad_marker_width, a4);
                this.o = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DefaultTimeBar_scrubber_enabled_size, a5);
                this.p = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DefaultTimeBar_scrubber_disabled_size, a6);
                this.q = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DefaultTimeBar_scrubber_dragged_size, a7);
                int i3 = obtainStyledAttributes.getInt(R.styleable.DefaultTimeBar_played_color, -1);
                int i4 = obtainStyledAttributes.getInt(R.styleable.DefaultTimeBar_scrubber_color, -16777216 | i3);
                int i5 = i3 & 16777215;
                int i6 = obtainStyledAttributes.getInt(R.styleable.DefaultTimeBar_buffered_color, -872415232 | i5);
                int i7 = obtainStyledAttributes.getInt(R.styleable.DefaultTimeBar_unplayed_color, i5 | 855638016);
                int i8 = obtainStyledAttributes.getInt(R.styleable.DefaultTimeBar_ad_marker_color, -1291845888);
                int i9 = obtainStyledAttributes.getInt(R.styleable.DefaultTimeBar_played_ad_marker_color, (16777215 & i8) | 855638016);
                this.f33535e.setColor(i3);
                this.j.setColor(i4);
                this.f33536f.setColor(i6);
                this.f33537g.setColor(i7);
                this.f33538h.setColor(i8);
                this.f33539i.setColor(i9);
            } finally {
                obtainStyledAttributes.recycle();
            }
        } else {
            this.l = a2;
            this.m = a3;
            this.n = a4;
            this.o = a5;
            this.p = a6;
            this.q = a7;
            this.f33535e.setColor(-1);
            this.j.setColor(-1);
            this.f33536f.setColor(-855638017);
            this.f33537g.setColor(872415231);
            this.f33538h.setColor(-1291845888);
            this.k = null;
        }
        this.t = new StringBuilder();
        this.u = new Formatter(this.t, Locale.getDefault());
        this.v = new Runnable() {
            public final void run() {
                DefaultTimeBar.this.c();
            }
        };
        Drawable drawable2 = this.k;
        if (drawable2 != null) {
            this.r = (drawable2.getMinimumWidth() + 1) / 2;
        } else {
            this.r = (Math.max(this.p, Math.max(this.o, this.q)) + 1) / 2;
        }
        this.F = -9223372036854775807L;
        this.B = -9223372036854775807L;
        this.A = 20;
        setFocusable(true);
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c() {
        a(false);
    }

    public void setPlayedColor(int i2) {
        this.f33535e.setColor(i2);
        invalidate(this.f33531a);
    }

    public void setScrubberColor(int i2) {
        this.j.setColor(i2);
        invalidate(this.f33531a);
    }

    public void setBufferedColor(int i2) {
        this.f33536f.setColor(i2);
        invalidate(this.f33531a);
    }

    public void setUnplayedColor(int i2) {
        this.f33537g.setColor(i2);
        invalidate(this.f33531a);
    }

    public void setAdMarkerColor(int i2) {
        this.f33538h.setColor(i2);
        invalidate(this.f33531a);
    }

    public void setPlayedAdMarkerColor(int i2) {
        this.f33539i.setColor(i2);
        invalidate(this.f33531a);
    }

    public final void a(c.a aVar) {
        this.w.add(aVar);
    }

    public void setKeyTimeIncrement(long j2) {
        a.a(j2 > 0);
        this.A = -1;
        this.B = j2;
    }

    public void setKeyCountIncrement(int i2) {
        a.a(i2 > 0);
        this.A = i2;
        this.B = -9223372036854775807L;
    }

    public void setPosition(long j2) {
        this.G = j2;
        setContentDescription(getProgressText());
        a();
    }

    public void setBufferedPosition(long j2) {
        this.H = j2;
        a();
    }

    public void setDuration(long j2) {
        this.F = j2;
        if (this.D && j2 == -9223372036854775807L) {
            a(true);
        }
        a();
    }

    public long getPreferredUpdateDelay() {
        int width = (int) (((float) this.f33532b.width()) / this.z);
        if (width == 0) {
            return Long.MAX_VALUE;
        }
        long j2 = this.F;
        if (j2 == 0 || j2 == -9223372036854775807L) {
            return Long.MAX_VALUE;
        }
        return j2 / ((long) width);
    }

    public void setAdGroupTimesMs(long[] jArr, boolean[] zArr, int i2) {
        a.a(i2 == 0 || !(jArr == null || zArr == null));
        this.I = i2;
        this.J = jArr;
        this.K = zArr;
        a();
    }

    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        if (this.D && !z2) {
            a(true);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v25, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v1, resolved type: boolean[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r23) {
        /*
            r22 = this;
            r0 = r22
            r7 = r23
            r23.save()
            android.graphics.Rect r1 = r0.f33532b
            int r1 = r1.height()
            android.graphics.Rect r2 = r0.f33532b
            int r2 = r2.centerY()
            int r3 = r1 / 2
            int r8 = r2 - r3
            int r9 = r8 + r1
            long r1 = r0.F
            r10 = 0
            int r3 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r3 > 0) goto L_0x0036
            android.graphics.Rect r1 = r0.f33532b
            int r1 = r1.left
            float r2 = (float) r1
            float r3 = (float) r8
            android.graphics.Rect r1 = r0.f33532b
            int r1 = r1.right
            float r4 = (float) r1
            float r5 = (float) r9
            android.graphics.Paint r6 = r0.f33537g
            r1 = r23
            r1.drawRect(r2, r3, r4, r5, r6)
            goto L_0x0108
        L_0x0036:
            android.graphics.Rect r1 = r0.f33533c
            int r12 = r1.left
            android.graphics.Rect r1 = r0.f33533c
            int r13 = r1.right
            android.graphics.Rect r1 = r0.f33532b
            int r1 = r1.left
            int r1 = java.lang.Math.max(r1, r13)
            android.graphics.Rect r2 = r0.f33534d
            int r2 = r2.right
            int r1 = java.lang.Math.max(r1, r2)
            android.graphics.Rect r2 = r0.f33532b
            int r2 = r2.right
            if (r1 >= r2) goto L_0x0063
            float r2 = (float) r1
            float r3 = (float) r8
            android.graphics.Rect r1 = r0.f33532b
            int r1 = r1.right
            float r4 = (float) r1
            float r5 = (float) r9
            android.graphics.Paint r6 = r0.f33537g
            r1 = r23
            r1.drawRect(r2, r3, r4, r5, r6)
        L_0x0063:
            android.graphics.Rect r1 = r0.f33534d
            int r1 = r1.right
            int r1 = java.lang.Math.max(r12, r1)
            if (r13 <= r1) goto L_0x0078
            float r2 = (float) r1
            float r3 = (float) r8
            float r4 = (float) r13
            float r5 = (float) r9
            android.graphics.Paint r6 = r0.f33536f
            r1 = r23
            r1.drawRect(r2, r3, r4, r5, r6)
        L_0x0078:
            android.graphics.Rect r1 = r0.f33534d
            int r1 = r1.width()
            if (r1 <= 0) goto L_0x0093
            android.graphics.Rect r1 = r0.f33534d
            int r1 = r1.left
            float r2 = (float) r1
            float r3 = (float) r8
            android.graphics.Rect r1 = r0.f33534d
            int r1 = r1.right
            float r4 = (float) r1
            float r5 = (float) r9
            android.graphics.Paint r6 = r0.f33535e
            r1 = r23
            r1.drawRect(r2, r3, r4, r5, r6)
        L_0x0093:
            int r1 = r0.I
            if (r1 == 0) goto L_0x0108
            long[] r1 = r0.J
            java.lang.Object r1 = com.google.android.exoplayer2.g.a.a(r1)
            r12 = r1
            long[] r12 = (long[]) r12
            boolean[] r1 = r0.K
            java.lang.Object r1 = com.google.android.exoplayer2.g.a.a(r1)
            r13 = r1
            boolean[] r13 = (boolean[]) r13
            int r1 = r0.n
            int r14 = r1 / 2
            r15 = 0
            r6 = 0
        L_0x00af:
            int r1 = r0.I
            if (r6 >= r1) goto L_0x0108
            r16 = r12[r6]
            r18 = 0
            long r1 = r0.F
            r20 = r1
            long r1 = com.google.android.exoplayer2.g.ae.a((long) r16, (long) r18, (long) r20)
            android.graphics.Rect r3 = r0.f33532b
            int r3 = r3.width()
            long r3 = (long) r3
            long r3 = r3 * r1
            long r1 = r0.F
            long r3 = r3 / r1
            int r1 = (int) r3
            int r1 = r1 - r14
            android.graphics.Rect r2 = r0.f33532b
            int r2 = r2.left
            android.graphics.Rect r3 = r0.f33532b
            int r3 = r3.width()
            int r4 = r0.n
            int r3 = r3 - r4
            int r1 = java.lang.Math.max(r15, r1)
            int r1 = java.lang.Math.min(r3, r1)
            int r2 = r2 + r1
            boolean r1 = r13[r6]
            if (r1 == 0) goto L_0x00ea
            android.graphics.Paint r1 = r0.f33539i
            goto L_0x00ec
        L_0x00ea:
            android.graphics.Paint r1 = r0.f33538h
        L_0x00ec:
            r16 = r1
            float r3 = (float) r2
            float r4 = (float) r8
            int r1 = r0.n
            int r2 = r2 + r1
            float r5 = (float) r2
            float r2 = (float) r9
            r1 = r23
            r17 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r17
            r17 = r6
            r6 = r16
            r1.drawRect(r2, r3, r4, r5, r6)
            int r6 = r17 + 1
            goto L_0x00af
        L_0x0108:
            long r1 = r0.F
            int r3 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r3 <= 0) goto L_0x016a
            android.graphics.Rect r1 = r0.f33534d
            int r1 = r1.right
            android.graphics.Rect r2 = r0.f33534d
            int r2 = r2.left
            android.graphics.Rect r3 = r0.f33532b
            int r3 = r3.right
            int r1 = com.google.android.exoplayer2.g.ae.a((int) r1, (int) r2, (int) r3)
            android.graphics.Rect r2 = r0.f33534d
            int r2 = r2.centerY()
            android.graphics.drawable.Drawable r3 = r0.k
            if (r3 != 0) goto L_0x014c
            boolean r3 = r0.D
            if (r3 != 0) goto L_0x013f
            boolean r3 = r22.isFocused()
            if (r3 == 0) goto L_0x0133
            goto L_0x013f
        L_0x0133:
            boolean r3 = r22.isEnabled()
            if (r3 == 0) goto L_0x013c
            int r3 = r0.o
            goto L_0x0141
        L_0x013c:
            int r3 = r0.p
            goto L_0x0141
        L_0x013f:
            int r3 = r0.q
        L_0x0141:
            int r3 = r3 / 2
            float r1 = (float) r1
            float r2 = (float) r2
            float r3 = (float) r3
            android.graphics.Paint r4 = r0.j
            r7.drawCircle(r1, r2, r3, r4)
            goto L_0x016a
        L_0x014c:
            int r3 = r3.getIntrinsicWidth()
            android.graphics.drawable.Drawable r4 = r0.k
            int r4 = r4.getIntrinsicHeight()
            android.graphics.drawable.Drawable r5 = r0.k
            int r3 = r3 / 2
            int r6 = r1 - r3
            int r4 = r4 / 2
            int r8 = r2 - r4
            int r1 = r1 + r3
            int r2 = r2 + r4
            r5.setBounds(r6, r8, r1, r2)
            android.graphics.drawable.Drawable r1 = r0.k
            r1.draw(r7)
        L_0x016a:
            r23.restore()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.DefaultTimeBar.onDraw(android.graphics.Canvas):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0042, code lost:
        if (r3 != 3) goto L_0x0097;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            boolean r0 = r7.isEnabled()
            r1 = 0
            if (r0 == 0) goto L_0x0097
            long r2 = r7.F
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 > 0) goto L_0x0011
            goto L_0x0097
        L_0x0011:
            int[] r0 = r7.x
            r7.getLocationOnScreen(r0)
            android.graphics.Point r0 = r7.y
            float r2 = r8.getRawX()
            int r2 = (int) r2
            int[] r3 = r7.x
            r3 = r3[r1]
            int r2 = r2 - r3
            float r3 = r8.getRawY()
            int r3 = (int) r3
            int[] r4 = r7.x
            r5 = 1
            r4 = r4[r5]
            int r3 = r3 - r4
            r0.set(r2, r3)
            android.graphics.Point r0 = r7.y
            int r2 = r0.x
            int r0 = r0.y
            int r3 = r8.getAction()
            if (r3 == 0) goto L_0x007a
            r4 = 3
            if (r3 == r5) goto L_0x006b
            r6 = 2
            if (r3 == r6) goto L_0x0045
            if (r3 == r4) goto L_0x006b
            goto L_0x0097
        L_0x0045:
            boolean r8 = r7.D
            if (r8 == 0) goto L_0x0097
            int r8 = r7.s
            if (r0 >= r8) goto L_0x0057
            int r8 = r7.C
            int r2 = r2 - r8
            int r2 = r2 / r4
            int r8 = r8 + r2
            float r8 = (float) r8
            r7.a((float) r8)
            goto L_0x005d
        L_0x0057:
            r7.C = r2
            float r8 = (float) r2
            r7.a((float) r8)
        L_0x005d:
            long r0 = r7.getScrubberPosition()
            r7.b(r0)
            r7.a()
            r7.invalidate()
            return r5
        L_0x006b:
            boolean r0 = r7.D
            if (r0 == 0) goto L_0x0097
            int r8 = r8.getAction()
            if (r8 != r4) goto L_0x0076
            r1 = 1
        L_0x0076:
            r7.a((boolean) r1)
            return r5
        L_0x007a:
            float r8 = (float) r2
            float r0 = (float) r0
            android.graphics.Rect r2 = r7.f33531a
            int r3 = (int) r8
            int r0 = (int) r0
            boolean r0 = r2.contains(r3, r0)
            if (r0 == 0) goto L_0x0097
            r7.a((float) r8)
            long r0 = r7.getScrubberPosition()
            r7.a((long) r0)
            r7.a()
            r7.invalidate()
            return r5
        L_0x0097:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.DefaultTimeBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0018, code lost:
        if (c(r0) == false) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        removeCallbacks(r4.v);
        postDelayed(r4.v, 1000);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onKeyDown(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            boolean r0 = r4.isEnabled()
            if (r0 == 0) goto L_0x0030
            long r0 = r4.getPositionIncrement()
            r2 = 66
            r3 = 1
            if (r5 == r2) goto L_0x0027
            switch(r5) {
                case 21: goto L_0x0013;
                case 22: goto L_0x0014;
                case 23: goto L_0x0027;
                default: goto L_0x0012;
            }
        L_0x0012:
            goto L_0x0030
        L_0x0013:
            long r0 = -r0
        L_0x0014:
            boolean r0 = r4.c(r0)
            if (r0 == 0) goto L_0x0030
            java.lang.Runnable r5 = r4.v
            r4.removeCallbacks(r5)
            java.lang.Runnable r5 = r4.v
            r0 = 1000(0x3e8, double:4.94E-321)
            r4.postDelayed(r5, r0)
            return r3
        L_0x0027:
            boolean r0 = r4.D
            if (r0 == 0) goto L_0x0030
            r5 = 0
            r4.a((boolean) r5)
            return r3
        L_0x0030:
            boolean r5 = super.onKeyDown(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.DefaultTimeBar.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z2, int i2, Rect rect) {
        super.onFocusChanged(z2, i2, rect);
        if (this.D && !z2) {
            a(false);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        b();
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.k;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode == 0) {
            size = this.m;
        } else if (mode != 1073741824) {
            size = Math.min(this.m, size);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i2), size);
        b();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6 = ((i5 - i3) - this.m) / 2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i4 - i2) - getPaddingRight();
        int i7 = this.m;
        int i8 = ((i7 - this.l) / 2) + i6;
        this.f33531a.set(paddingLeft, i6, paddingRight, i7 + i6);
        this.f33532b.set(this.f33531a.left + this.r, i8, this.f33531a.right - this.r, this.l + i8);
        a();
    }

    public void onRtlPropertiesChanged(int i2) {
        Drawable drawable = this.k;
        if (drawable != null && a(drawable, i2)) {
            invalidate();
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 4) {
            accessibilityEvent.getText().add(getProgressText());
        }
        accessibilityEvent.setClassName("android.widget.SeekBar");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.SeekBar");
        accessibilityNodeInfo.setContentDescription(getProgressText());
        if (this.F > 0) {
            if (ae.f32499a >= 21) {
                accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
                accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
                return;
            }
            accessibilityNodeInfo.addAction(4096);
            accessibilityNodeInfo.addAction(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
        }
    }

    public boolean performAccessibilityAction(int i2, Bundle bundle) {
        if (super.performAccessibilityAction(i2, bundle)) {
            return true;
        }
        if (this.F <= 0) {
            return false;
        }
        if (i2 == 8192) {
            if (c(-getPositionIncrement())) {
                a(false);
            }
        } else if (i2 != 4096) {
            return false;
        } else {
            if (c(getPositionIncrement())) {
                a(false);
            }
        }
        sendAccessibilityEvent(4);
        return true;
    }

    private void a(long j2) {
        this.E = j2;
        this.D = true;
        setPressed(true);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        Iterator<c.a> it2 = this.w.iterator();
        while (it2.hasNext()) {
            it2.next().a(j2);
        }
    }

    private void b(long j2) {
        if (this.E != j2) {
            this.E = j2;
            Iterator<c.a> it2 = this.w.iterator();
            while (it2.hasNext()) {
                it2.next().b(j2);
            }
        }
    }

    private void a(boolean z2) {
        removeCallbacks(this.v);
        this.D = false;
        setPressed(false);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        invalidate();
        Iterator<c.a> it2 = this.w.iterator();
        while (it2.hasNext()) {
            it2.next().a(this.E, z2);
        }
    }

    private boolean c(long j2) {
        if (this.F <= 0) {
            return false;
        }
        long j3 = this.D ? this.E : this.G;
        long a2 = ae.a(j3 + j2, 0, this.F);
        if (a2 == j3) {
            return false;
        }
        if (!this.D) {
            a(a2);
        } else {
            b(a2);
        }
        a();
        return true;
    }

    private void a() {
        this.f33533c.set(this.f33532b);
        this.f33534d.set(this.f33532b);
        long j2 = this.D ? this.E : this.G;
        if (this.F > 0) {
            this.f33533c.right = Math.min(this.f33532b.left + ((int) ((((long) this.f33532b.width()) * this.H) / this.F)), this.f33532b.right);
            this.f33534d.right = Math.min(this.f33532b.left + ((int) ((((long) this.f33532b.width()) * j2) / this.F)), this.f33532b.right);
        } else {
            this.f33533c.right = this.f33532b.left;
            this.f33534d.right = this.f33532b.left;
        }
        invalidate(this.f33531a);
    }

    private void a(float f2) {
        this.f33534d.right = ae.a((int) f2, this.f33532b.left, this.f33532b.right);
    }

    private long getScrubberPosition() {
        if (this.f33532b.width() <= 0 || this.F == -9223372036854775807L) {
            return 0;
        }
        return (((long) this.f33534d.width()) * this.F) / ((long) this.f33532b.width());
    }

    private void b() {
        Drawable drawable = this.k;
        if (drawable != null && drawable.isStateful() && this.k.setState(getDrawableState())) {
            invalidate();
        }
    }

    private String getProgressText() {
        return ae.a(this.t, this.u, this.G);
    }

    private long getPositionIncrement() {
        long j2 = this.B;
        if (j2 != -9223372036854775807L) {
            return j2;
        }
        long j3 = this.F;
        if (j3 == -9223372036854775807L) {
            return 0;
        }
        return j3 / ((long) this.A);
    }

    private static boolean a(Drawable drawable, int i2) {
        return ae.f32499a >= 23 && drawable.setLayoutDirection(i2);
    }
}
