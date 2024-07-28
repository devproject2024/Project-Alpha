package net.one97.paytm.p2b.view.CustomView;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.business.merchant_payments.utility.StringUtility;
import net.one97.paytm.p2b.R;

public class P2BShimmerFrameLayout extends FrameLayout {

    /* renamed from: c  reason: collision with root package name */
    private static final PorterDuffXfermode f12855c = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);

    /* renamed from: a  reason: collision with root package name */
    protected ValueAnimator f12856a;

    /* renamed from: b  reason: collision with root package name */
    protected Bitmap f12857b;

    /* renamed from: d  reason: collision with root package name */
    private Paint f12858d;

    /* renamed from: e  reason: collision with root package name */
    private Paint f12859e;

    /* renamed from: f  reason: collision with root package name */
    private a f12860f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public d f12861g;

    /* renamed from: h  reason: collision with root package name */
    private Bitmap f12862h;

    /* renamed from: i  reason: collision with root package name */
    private Bitmap f12863i;
    /* access modifiers changed from: private */
    public boolean j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    /* access modifiers changed from: private */
    public boolean q;
    private ViewTreeObserver.OnGlobalLayoutListener r;

    public enum b {
        CW_0,
        CW_90,
        CW_180,
        CW_270
    }

    public enum c {
        LINEAR,
        RADIAL
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        public b f12868a;

        /* renamed from: b  reason: collision with root package name */
        public float f12869b;

        /* renamed from: c  reason: collision with root package name */
        public float f12870c;

        /* renamed from: d  reason: collision with root package name */
        public int f12871d;

        /* renamed from: e  reason: collision with root package name */
        public int f12872e;

        /* renamed from: f  reason: collision with root package name */
        public float f12873f;

        /* renamed from: g  reason: collision with root package name */
        public float f12874g;

        /* renamed from: h  reason: collision with root package name */
        public float f12875h;

        /* renamed from: i  reason: collision with root package name */
        public c f12876i;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        public final int[] a() {
            if (AnonymousClass3.f12866a[this.f12876i.ordinal()] != 2) {
                return new int[]{0, -16777216, -16777216, 0};
            }
            return new int[]{-16777216, -16777216, 0};
        }

        public final float[] b() {
            if (AnonymousClass3.f12866a[this.f12876i.ordinal()] != 2) {
                return new float[]{Math.max(((1.0f - this.f12873f) - this.f12870c) / 2.0f, 0.0f), Math.max((1.0f - this.f12873f) / 2.0f, 0.0f), Math.min((this.f12873f + 1.0f) / 2.0f, 1.0f), Math.min(((this.f12873f + 1.0f) + this.f12870c) / 2.0f, 1.0f)};
            }
            return new float[]{0.0f, Math.min(this.f12873f, 1.0f), Math.min(this.f12873f + this.f12870c, 1.0f)};
        }
    }

    static class d {

        /* renamed from: a  reason: collision with root package name */
        public int f12877a;

        /* renamed from: b  reason: collision with root package name */
        public int f12878b;

        /* renamed from: c  reason: collision with root package name */
        public int f12879c;

        /* renamed from: d  reason: collision with root package name */
        public int f12880d;

        private d() {
        }

        /* synthetic */ d(byte b2) {
            this();
        }

        public final void a(int i2, int i3, int i4, int i5) {
            this.f12877a = i2;
            this.f12878b = i3;
            this.f12879c = i4;
            this.f12880d = i5;
        }
    }

    public P2BShimmerFrameLayout(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public P2BShimmerFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public P2BShimmerFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setWillNotDraw(false);
        this.f12860f = new a((byte) 0);
        this.f12858d = new Paint();
        this.f12859e = new Paint();
        this.f12859e.setAntiAlias(true);
        this.f12859e.setDither(true);
        this.f12859e.setFilterBitmap(true);
        this.f12859e.setXfermode(f12855c);
        setAutoStart(false);
        setDuration(1000);
        setRepeatCount(-1);
        setRepeatDelay(0);
        setRepeatMode(1);
        this.f12860f.f12868a = b.CW_0;
        this.f12860f.f12876i = c.LINEAR;
        a aVar = this.f12860f;
        aVar.f12870c = 0.5f;
        aVar.f12871d = 0;
        aVar.f12872e = 0;
        aVar.f12873f = 0.0f;
        aVar.f12874g = 1.0f;
        aVar.f12875h = 1.0f;
        aVar.f12869b = 20.0f;
        this.f12861g = new d((byte) 0);
        setBaseAlpha(0.3f);
        d();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ShimmerFrameLayout, 0, 0);
            try {
                if (obtainStyledAttributes.hasValue(R.styleable.ShimmerFrameLayout_auto_start)) {
                    setAutoStart(obtainStyledAttributes.getBoolean(R.styleable.ShimmerFrameLayout_auto_start, false));
                }
                if (obtainStyledAttributes.hasValue(R.styleable.ShimmerFrameLayout_base_alpha)) {
                    setBaseAlpha(obtainStyledAttributes.getFloat(R.styleable.ShimmerFrameLayout_base_alpha, 0.0f));
                }
                if (obtainStyledAttributes.hasValue(R.styleable.ShimmerFrameLayout_shimmer_duration)) {
                    setDuration(obtainStyledAttributes.getInt(R.styleable.ShimmerFrameLayout_shimmer_duration, 0));
                }
                if (obtainStyledAttributes.hasValue(R.styleable.ShimmerFrameLayout_repeat_count)) {
                    setRepeatCount(obtainStyledAttributes.getInt(R.styleable.ShimmerFrameLayout_repeat_count, 0));
                }
                if (obtainStyledAttributes.hasValue(R.styleable.ShimmerFrameLayout_repeat_delay)) {
                    setRepeatDelay(obtainStyledAttributes.getInt(R.styleable.ShimmerFrameLayout_repeat_delay, 0));
                }
                if (obtainStyledAttributes.hasValue(R.styleable.ShimmerFrameLayout_repeat_mode)) {
                    setRepeatMode(obtainStyledAttributes.getInt(R.styleable.ShimmerFrameLayout_repeat_mode, 0));
                }
                if (obtainStyledAttributes.hasValue(R.styleable.ShimmerFrameLayout_angle)) {
                    int i3 = obtainStyledAttributes.getInt(R.styleable.ShimmerFrameLayout_angle, 0);
                    if (i3 == 90) {
                        this.f12860f.f12868a = b.CW_90;
                    } else if (i3 == 180) {
                        this.f12860f.f12868a = b.CW_180;
                    } else if (i3 != 270) {
                        this.f12860f.f12868a = b.CW_0;
                    } else {
                        this.f12860f.f12868a = b.CW_270;
                    }
                }
                if (obtainStyledAttributes.hasValue(R.styleable.ShimmerFrameLayout_shape)) {
                    if (obtainStyledAttributes.getInt(R.styleable.ShimmerFrameLayout_shape, 0) != 1) {
                        this.f12860f.f12876i = c.LINEAR;
                    } else {
                        this.f12860f.f12876i = c.RADIAL;
                    }
                }
                if (obtainStyledAttributes.hasValue(R.styleable.ShimmerFrameLayout_dropoff)) {
                    this.f12860f.f12870c = obtainStyledAttributes.getFloat(R.styleable.ShimmerFrameLayout_dropoff, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(R.styleable.ShimmerFrameLayout_fixed_width)) {
                    this.f12860f.f12871d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ShimmerFrameLayout_fixed_width, 0);
                }
                if (obtainStyledAttributes.hasValue(R.styleable.ShimmerFrameLayout_fixed_height)) {
                    this.f12860f.f12872e = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ShimmerFrameLayout_fixed_height, 0);
                }
                if (obtainStyledAttributes.hasValue(R.styleable.ShimmerFrameLayout_intensity)) {
                    this.f12860f.f12873f = obtainStyledAttributes.getFloat(R.styleable.ShimmerFrameLayout_intensity, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(R.styleable.ShimmerFrameLayout_relative_width)) {
                    this.f12860f.f12874g = obtainStyledAttributes.getFloat(R.styleable.ShimmerFrameLayout_relative_width, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(R.styleable.ShimmerFrameLayout_relative_height)) {
                    this.f12860f.f12875h = obtainStyledAttributes.getFloat(R.styleable.ShimmerFrameLayout_relative_height, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(R.styleable.ShimmerFrameLayout_tilt)) {
                    this.f12860f.f12869b = obtainStyledAttributes.getFloat(R.styleable.ShimmerFrameLayout_tilt, 0.0f);
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void setAutoStart(boolean z) {
        this.j = z;
        d();
    }

    public float getBaseAlpha() {
        return ((float) this.f12858d.getAlpha()) / 255.0f;
    }

    public void setBaseAlpha(float f2) {
        this.f12858d.setAlpha((int) (Math.min(1.0f, Math.max(0.0f, f2)) * 255.0f));
        d();
    }

    public int getDuration() {
        return this.k;
    }

    public void setDuration(int i2) {
        this.k = i2;
        d();
    }

    public int getRepeatCount() {
        return this.l;
    }

    public void setRepeatCount(int i2) {
        this.l = i2;
        d();
    }

    public int getRepeatDelay() {
        return this.m;
    }

    public void setRepeatDelay(int i2) {
        this.m = i2;
        d();
    }

    public int getRepeatMode() {
        return this.n;
    }

    public void setRepeatMode(int i2) {
        this.n = i2;
        d();
    }

    public c getMaskShape() {
        return this.f12860f.f12876i;
    }

    public void setMaskShape(c cVar) {
        this.f12860f.f12876i = cVar;
        d();
    }

    public b getAngle() {
        return this.f12860f.f12868a;
    }

    public void setAngle(b bVar) {
        this.f12860f.f12868a = bVar;
        d();
    }

    public float getDropoff() {
        return this.f12860f.f12870c;
    }

    public void setDropoff(float f2) {
        this.f12860f.f12870c = f2;
        d();
    }

    public int getFixedWidth() {
        return this.f12860f.f12871d;
    }

    public void setFixedWidth(int i2) {
        this.f12860f.f12871d = i2;
        d();
    }

    public int getFixedHeight() {
        return this.f12860f.f12872e;
    }

    public void setFixedHeight(int i2) {
        this.f12860f.f12872e = i2;
        d();
    }

    public float getIntensity() {
        return this.f12860f.f12873f;
    }

    public void setIntensity(float f2) {
        this.f12860f.f12873f = f2;
        d();
    }

    public float getRelativeWidth() {
        return this.f12860f.f12874g;
    }

    public void setRelativeWidth(int i2) {
        this.f12860f.f12874g = (float) i2;
        d();
    }

    public float getRelativeHeight() {
        return this.f12860f.f12875h;
    }

    public void setRelativeHeight(int i2) {
        this.f12860f.f12875h = (float) i2;
        d();
    }

    public float getTilt() {
        return this.f12860f.f12869b;
    }

    public void setTilt(float f2) {
        this.f12860f.f12869b = f2;
        d();
    }

    public final void a() {
        if (!this.q) {
            getShimmerAnimation().start();
            this.q = true;
        }
    }

    public final void b() {
        ValueAnimator valueAnimator = this.f12856a;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.f12856a.removeAllUpdateListeners();
            this.f12856a.cancel();
        }
        this.f12856a = null;
        this.q = false;
    }

    /* access modifiers changed from: private */
    public void setMaskOffsetX(int i2) {
        if (this.o != i2) {
            this.o = i2;
            invalidate();
        }
    }

    /* access modifiers changed from: private */
    public void setMaskOffsetY(int i2) {
        if (this.p != i2) {
            this.p = i2;
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.r == null) {
            this.r = getLayoutListener();
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.r);
    }

    private ViewTreeObserver.OnGlobalLayoutListener getLayoutListener() {
        return new ViewTreeObserver.OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                boolean a2 = P2BShimmerFrameLayout.this.q;
                P2BShimmerFrameLayout.this.d();
                if (P2BShimmerFrameLayout.this.j || a2) {
                    P2BShimmerFrameLayout.this.a();
                }
            }
        };
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        b();
        if (this.r != null) {
            getViewTreeObserver().removeGlobalOnLayoutListener(this.r);
            this.r = null;
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        if (!this.q || getWidth() <= 0 || getHeight() <= 0) {
            super.dispatchDraw(canvas);
            return;
        }
        if (this.f12863i == null) {
            this.f12863i = c();
        }
        Bitmap bitmap = this.f12863i;
        if (this.f12862h == null) {
            this.f12862h = c();
        }
        Bitmap bitmap2 = this.f12862h;
        if (bitmap != null && bitmap2 != null) {
            Canvas canvas2 = new Canvas(bitmap);
            canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
            super.dispatchDraw(canvas2);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.f12858d);
            Canvas canvas3 = new Canvas(bitmap2);
            Bitmap maskBitmap = getMaskBitmap();
            if (maskBitmap != null) {
                int i2 = this.o;
                canvas3.clipRect(i2, this.p, maskBitmap.getWidth() + i2, this.p + maskBitmap.getHeight());
                canvas3.drawColor(0, PorterDuff.Mode.CLEAR);
                super.dispatchDraw(canvas3);
                canvas3.drawBitmap(maskBitmap, (float) this.o, (float) this.p, this.f12859e);
            }
            canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
        }
    }

    private Bitmap c() {
        int width = getWidth();
        int height = getHeight();
        try {
            return a(width, height);
        } catch (OutOfMemoryError unused) {
            StringBuilder sb = new StringBuilder("ShimmerFrameLayout failed to create working bitmap");
            sb.append(" (width = ");
            sb.append(width);
            sb.append(", height = ");
            sb.append(height);
            sb.append(")\n\n");
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                sb.append(stackTraceElement.toString());
                sb.append(StringUtility.NEW_LINE);
            }
            return null;
        }
    }

    /* access modifiers changed from: private */
    public void d() {
        b();
        e();
        f();
    }

    private void e() {
        Bitmap bitmap = this.f12857b;
        if (bitmap != null) {
            bitmap.recycle();
            this.f12857b = null;
        }
    }

    private void f() {
        Bitmap bitmap = this.f12863i;
        if (bitmap != null) {
            bitmap.recycle();
            this.f12863i = null;
        }
        Bitmap bitmap2 = this.f12862h;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.f12862h = null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: android.graphics.RadialGradient} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v15, resolved type: android.graphics.RadialGradient} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: android.graphics.LinearGradient} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v21, resolved type: android.graphics.RadialGradient} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap getMaskBitmap() {
        /*
            r20 = this;
            r0 = r20
            android.graphics.Bitmap r1 = r0.f12857b
            if (r1 == 0) goto L_0x0007
            return r1
        L_0x0007:
            net.one97.paytm.p2b.view.CustomView.P2BShimmerFrameLayout$a r1 = r0.f12860f
            int r2 = r20.getWidth()
            int r3 = r1.f12871d
            if (r3 <= 0) goto L_0x0014
            int r1 = r1.f12871d
            goto L_0x001a
        L_0x0014:
            float r2 = (float) r2
            float r1 = r1.f12874g
            float r2 = r2 * r1
            int r1 = (int) r2
        L_0x001a:
            net.one97.paytm.p2b.view.CustomView.P2BShimmerFrameLayout$a r2 = r0.f12860f
            int r3 = r20.getHeight()
            int r4 = r2.f12872e
            if (r4 <= 0) goto L_0x0027
            int r2 = r2.f12872e
            goto L_0x002d
        L_0x0027:
            float r3 = (float) r3
            float r2 = r2.f12875h
            float r3 = r3 * r2
            int r2 = (int) r3
        L_0x002d:
            android.graphics.Bitmap r3 = a((int) r1, (int) r2)
            r0.f12857b = r3
            android.graphics.Bitmap r3 = r0.f12857b
            if (r3 != 0) goto L_0x0039
            r1 = 0
            return r1
        L_0x0039:
            android.graphics.Canvas r4 = new android.graphics.Canvas
            r4.<init>(r3)
            int[] r3 = net.one97.paytm.p2b.view.CustomView.P2BShimmerFrameLayout.AnonymousClass3.f12866a
            net.one97.paytm.p2b.view.CustomView.P2BShimmerFrameLayout$a r5 = r0.f12860f
            net.one97.paytm.p2b.view.CustomView.P2BShimmerFrameLayout$c r5 = r5.f12876i
            int r5 = r5.ordinal()
            r3 = r3[r5]
            r5 = 4611686018427387904(0x4000000000000000, double:2.0)
            r7 = 2
            if (r3 == r7) goto L_0x008d
            int[] r3 = net.one97.paytm.p2b.view.CustomView.P2BShimmerFrameLayout.AnonymousClass3.f12867b
            net.one97.paytm.p2b.view.CustomView.P2BShimmerFrameLayout$a r8 = r0.f12860f
            net.one97.paytm.p2b.view.CustomView.P2BShimmerFrameLayout$b r8 = r8.f12868a
            int r8 = r8.ordinal()
            r3 = r3[r8]
            r8 = 0
            if (r3 == r7) goto L_0x006e
            r9 = 3
            if (r3 == r9) goto L_0x006a
            r9 = 4
            if (r3 == r9) goto L_0x0068
            r9 = r1
            r3 = 0
        L_0x0066:
            r10 = 0
            goto L_0x0071
        L_0x0068:
            r3 = r2
            goto L_0x006c
        L_0x006a:
            r8 = r1
            r3 = 0
        L_0x006c:
            r9 = 0
            goto L_0x0066
        L_0x006e:
            r10 = r2
            r3 = 0
            r9 = 0
        L_0x0071:
            android.graphics.LinearGradient r19 = new android.graphics.LinearGradient
            float r12 = (float) r8
            float r13 = (float) r3
            float r14 = (float) r9
            float r15 = (float) r10
            net.one97.paytm.p2b.view.CustomView.P2BShimmerFrameLayout$a r3 = r0.f12860f
            int[] r16 = r3.a()
            net.one97.paytm.p2b.view.CustomView.P2BShimmerFrameLayout$a r3 = r0.f12860f
            float[] r17 = r3.b()
            android.graphics.Shader$TileMode r18 = android.graphics.Shader.TileMode.REPEAT
            r11 = r19
            r11.<init>(r12, r13, r14, r15, r16, r17, r18)
            r3 = r19
            goto L_0x00b5
        L_0x008d:
            int r3 = r1 / 2
            int r8 = r2 / 2
            android.graphics.RadialGradient r16 = new android.graphics.RadialGradient
            float r10 = (float) r3
            float r11 = (float) r8
            int r3 = java.lang.Math.max(r1, r2)
            double r8 = (double) r3
            double r12 = java.lang.Math.sqrt(r5)
            double r8 = r8 / r12
            float r12 = (float) r8
            net.one97.paytm.p2b.view.CustomView.P2BShimmerFrameLayout$a r3 = r0.f12860f
            int[] r13 = r3.a()
            net.one97.paytm.p2b.view.CustomView.P2BShimmerFrameLayout$a r3 = r0.f12860f
            float[] r14 = r3.b()
            android.graphics.Shader$TileMode r15 = android.graphics.Shader.TileMode.REPEAT
            r9 = r16
            r9.<init>(r10, r11, r12, r13, r14, r15)
            r3 = r16
        L_0x00b5:
            net.one97.paytm.p2b.view.CustomView.P2BShimmerFrameLayout$a r8 = r0.f12860f
            float r8 = r8.f12869b
            int r9 = r1 / 2
            float r9 = (float) r9
            int r10 = r2 / 2
            float r10 = (float) r10
            r4.rotate(r8, r9, r10)
            android.graphics.Paint r8 = new android.graphics.Paint
            r8.<init>()
            r8.setShader(r3)
            double r5 = java.lang.Math.sqrt(r5)
            int r3 = java.lang.Math.max(r1, r2)
            double r9 = (double) r3
            double r5 = r5 * r9
            int r3 = (int) r5
            int r3 = r3 / r7
            int r5 = -r3
            float r5 = (float) r5
            int r1 = r1 + r3
            float r1 = (float) r1
            int r2 = r2 + r3
            float r6 = (float) r2
            r2 = r4
            r3 = r5
            r4 = r5
            r5 = r1
            r7 = r8
            r2.drawRect(r3, r4, r5, r6, r7)
            android.graphics.Bitmap r1 = r0.f12857b
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2b.view.CustomView.P2BShimmerFrameLayout.getMaskBitmap():android.graphics.Bitmap");
    }

    /* renamed from: net.one97.paytm.p2b.view.CustomView.P2BShimmerFrameLayout$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f12866a = new int[c.values().length];

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f12867b = new int[b.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|(2:1|2)|3|5|6|7|8|(2:9|10)|11|13|14|(3:15|16|18)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0048 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002a */
        static {
            /*
                net.one97.paytm.p2b.view.CustomView.P2BShimmerFrameLayout$b[] r0 = net.one97.paytm.p2b.view.CustomView.P2BShimmerFrameLayout.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f12867b = r0
                r0 = 1
                int[] r1 = f12867b     // Catch:{ NoSuchFieldError -> 0x0014 }
                net.one97.paytm.p2b.view.CustomView.P2BShimmerFrameLayout$b r2 = net.one97.paytm.p2b.view.CustomView.P2BShimmerFrameLayout.b.CW_0     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f12867b     // Catch:{ NoSuchFieldError -> 0x001f }
                net.one97.paytm.p2b.view.CustomView.P2BShimmerFrameLayout$b r3 = net.one97.paytm.p2b.view.CustomView.P2BShimmerFrameLayout.b.CW_90     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r2 = f12867b     // Catch:{ NoSuchFieldError -> 0x002a }
                net.one97.paytm.p2b.view.CustomView.P2BShimmerFrameLayout$b r3 = net.one97.paytm.p2b.view.CustomView.P2BShimmerFrameLayout.b.CW_180     // Catch:{ NoSuchFieldError -> 0x002a }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r4 = 3
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r2 = f12867b     // Catch:{ NoSuchFieldError -> 0x0035 }
                net.one97.paytm.p2b.view.CustomView.P2BShimmerFrameLayout$b r3 = net.one97.paytm.p2b.view.CustomView.P2BShimmerFrameLayout.b.CW_270     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r4 = 4
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                net.one97.paytm.p2b.view.CustomView.P2BShimmerFrameLayout$c[] r2 = net.one97.paytm.p2b.view.CustomView.P2BShimmerFrameLayout.c.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f12866a = r2
                int[] r2 = f12866a     // Catch:{ NoSuchFieldError -> 0x0048 }
                net.one97.paytm.p2b.view.CustomView.P2BShimmerFrameLayout$c r3 = net.one97.paytm.p2b.view.CustomView.P2BShimmerFrameLayout.c.LINEAR     // Catch:{ NoSuchFieldError -> 0x0048 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0048 }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0048 }
            L_0x0048:
                int[] r0 = f12866a     // Catch:{ NoSuchFieldError -> 0x0052 }
                net.one97.paytm.p2b.view.CustomView.P2BShimmerFrameLayout$c r2 = net.one97.paytm.p2b.view.CustomView.P2BShimmerFrameLayout.c.RADIAL     // Catch:{ NoSuchFieldError -> 0x0052 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0052 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0052 }
            L_0x0052:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2b.view.CustomView.P2BShimmerFrameLayout.AnonymousClass3.<clinit>():void");
        }
    }

    private Animator getShimmerAnimation() {
        ValueAnimator valueAnimator = this.f12856a;
        if (valueAnimator != null) {
            return valueAnimator;
        }
        int width = getWidth();
        int height = getHeight();
        int[] iArr = AnonymousClass3.f12866a;
        this.f12860f.f12876i.ordinal();
        int i2 = AnonymousClass3.f12867b[this.f12860f.f12868a.ordinal()];
        if (i2 == 2) {
            this.f12861g.a(0, -height, 0, height);
        } else if (i2 == 3) {
            this.f12861g.a(width, 0, -width, 0);
        } else if (i2 != 4) {
            this.f12861g.a(-width, 0, width, 0);
        } else {
            this.f12861g.a(0, height, 0, -height);
        }
        this.f12856a = ValueAnimator.ofFloat(new float[]{0.0f, (((float) this.m) / ((float) this.k)) + 1.0f});
        this.f12856a.setDuration((long) (this.k + this.m));
        this.f12856a.setRepeatCount(this.l);
        this.f12856a.setRepeatMode(this.n);
        this.f12856a.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float max = Math.max(0.0f, Math.min(1.0f, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                P2BShimmerFrameLayout p2BShimmerFrameLayout = P2BShimmerFrameLayout.this;
                float f2 = 1.0f - max;
                p2BShimmerFrameLayout.setMaskOffsetX((int) ((((float) p2BShimmerFrameLayout.f12861g.f12877a) * f2) + (((float) P2BShimmerFrameLayout.this.f12861g.f12879c) * max)));
                P2BShimmerFrameLayout p2BShimmerFrameLayout2 = P2BShimmerFrameLayout.this;
                p2BShimmerFrameLayout2.setMaskOffsetY((int) ((((float) p2BShimmerFrameLayout2.f12861g.f12878b) * f2) + (((float) P2BShimmerFrameLayout.this.f12861g.f12880d) * max)));
            }
        });
        return this.f12856a;
    }

    private static Bitmap a(int i2, int i3) {
        try {
            return Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError unused) {
            System.gc();
            return null;
        }
    }
}
