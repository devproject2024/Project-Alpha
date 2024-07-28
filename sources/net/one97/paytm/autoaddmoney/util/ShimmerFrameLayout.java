package net.one97.paytm.autoaddmoney.util;

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
import com.paytm.utility.q;
import net.one97.paytm.addmoney.R;

public class ShimmerFrameLayout extends FrameLayout {

    /* renamed from: d  reason: collision with root package name */
    private static final PorterDuffXfermode f49253d = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public boolean f49254a;

    /* renamed from: b  reason: collision with root package name */
    protected ValueAnimator f49255b;

    /* renamed from: c  reason: collision with root package name */
    protected Bitmap f49256c;

    /* renamed from: e  reason: collision with root package name */
    private Paint f49257e;

    /* renamed from: f  reason: collision with root package name */
    private Paint f49258f;

    /* renamed from: g  reason: collision with root package name */
    private a f49259g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public d f49260h;

    /* renamed from: i  reason: collision with root package name */
    private Bitmap f49261i;
    private Bitmap j;
    /* access modifiers changed from: private */
    public boolean k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
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
        public b f49266a;

        /* renamed from: b  reason: collision with root package name */
        public float f49267b;

        /* renamed from: c  reason: collision with root package name */
        public float f49268c;

        /* renamed from: d  reason: collision with root package name */
        public int f49269d;

        /* renamed from: e  reason: collision with root package name */
        public int f49270e;

        /* renamed from: f  reason: collision with root package name */
        public float f49271f;

        /* renamed from: g  reason: collision with root package name */
        public float f49272g;

        /* renamed from: h  reason: collision with root package name */
        public float f49273h;

        /* renamed from: i  reason: collision with root package name */
        public c f49274i;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        public final int[] a() {
            if (AnonymousClass3.f49264a[this.f49274i.ordinal()] != 2) {
                return new int[]{0, -16777216, -16777216, 0};
            }
            return new int[]{-16777216, -16777216, 0};
        }

        public final float[] b() {
            if (AnonymousClass3.f49264a[this.f49274i.ordinal()] != 2) {
                return new float[]{Math.max(((1.0f - this.f49271f) - this.f49268c) / 2.0f, 0.0f), Math.max((1.0f - this.f49271f) / 2.0f, 0.0f), Math.min((this.f49271f + 1.0f) / 2.0f, 1.0f), Math.min(((this.f49271f + 1.0f) + this.f49268c) / 2.0f, 1.0f)};
            }
            return new float[]{0.0f, Math.min(this.f49271f, 1.0f), Math.min(this.f49271f + this.f49268c, 1.0f)};
        }
    }

    static class d {

        /* renamed from: a  reason: collision with root package name */
        public int f49275a;

        /* renamed from: b  reason: collision with root package name */
        public int f49276b;

        /* renamed from: c  reason: collision with root package name */
        public int f49277c;

        /* renamed from: d  reason: collision with root package name */
        public int f49278d;

        private d() {
        }

        /* synthetic */ d(byte b2) {
            this();
        }

        public final void a(int i2, int i3, int i4, int i5) {
            this.f49275a = i2;
            this.f49276b = i3;
            this.f49277c = i4;
            this.f49278d = i5;
        }
    }

    public ShimmerFrameLayout(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setWillNotDraw(false);
        this.f49259g = new a((byte) 0);
        this.f49257e = new Paint();
        this.f49258f = new Paint();
        this.f49258f.setAntiAlias(true);
        this.f49258f.setDither(true);
        this.f49258f.setFilterBitmap(true);
        this.f49258f.setXfermode(f49253d);
        setAutoStart(false);
        setDuration(1000);
        setRepeatCount(-1);
        setRepeatDelay(0);
        setRepeatMode(1);
        this.f49259g.f49266a = b.CW_0;
        this.f49259g.f49274i = c.LINEAR;
        a aVar = this.f49259g;
        aVar.f49268c = 0.5f;
        aVar.f49269d = 0;
        aVar.f49270e = 0;
        aVar.f49271f = 0.0f;
        aVar.f49272g = 1.0f;
        aVar.f49273h = 1.0f;
        aVar.f49267b = 20.0f;
        this.f49260h = new d((byte) 0);
        setBaseAlpha(0.3f);
        c();
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
                        this.f49259g.f49266a = b.CW_90;
                    } else if (i3 == 180) {
                        this.f49259g.f49266a = b.CW_180;
                    } else if (i3 != 270) {
                        this.f49259g.f49266a = b.CW_0;
                    } else {
                        this.f49259g.f49266a = b.CW_270;
                    }
                }
                if (obtainStyledAttributes.hasValue(R.styleable.ShimmerFrameLayout_shape)) {
                    if (obtainStyledAttributes.getInt(R.styleable.ShimmerFrameLayout_shape, 0) != 1) {
                        this.f49259g.f49274i = c.LINEAR;
                    } else {
                        this.f49259g.f49274i = c.RADIAL;
                    }
                }
                if (obtainStyledAttributes.hasValue(R.styleable.ShimmerFrameLayout_dropoff)) {
                    this.f49259g.f49268c = obtainStyledAttributes.getFloat(R.styleable.ShimmerFrameLayout_dropoff, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(R.styleable.ShimmerFrameLayout_fixed_width)) {
                    this.f49259g.f49269d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ShimmerFrameLayout_fixed_width, 0);
                }
                if (obtainStyledAttributes.hasValue(R.styleable.ShimmerFrameLayout_fixed_height)) {
                    this.f49259g.f49270e = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ShimmerFrameLayout_fixed_height, 0);
                }
                if (obtainStyledAttributes.hasValue(R.styleable.ShimmerFrameLayout_intensity)) {
                    this.f49259g.f49271f = obtainStyledAttributes.getFloat(R.styleable.ShimmerFrameLayout_intensity, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(R.styleable.ShimmerFrameLayout_relative_width)) {
                    this.f49259g.f49272g = obtainStyledAttributes.getFloat(R.styleable.ShimmerFrameLayout_relative_width, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(R.styleable.ShimmerFrameLayout_relative_height)) {
                    this.f49259g.f49273h = obtainStyledAttributes.getFloat(R.styleable.ShimmerFrameLayout_relative_height, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(R.styleable.ShimmerFrameLayout_tilt)) {
                    this.f49259g.f49267b = obtainStyledAttributes.getFloat(R.styleable.ShimmerFrameLayout_tilt, 0.0f);
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void setAutoStart(boolean z) {
        this.k = z;
        c();
    }

    public float getBaseAlpha() {
        return ((float) this.f49257e.getAlpha()) / 255.0f;
    }

    public void setBaseAlpha(float f2) {
        this.f49257e.setAlpha((int) (Math.min(1.0f, Math.max(0.0f, f2)) * 255.0f));
        c();
    }

    public int getDuration() {
        return this.l;
    }

    public void setDuration(int i2) {
        this.l = i2;
        c();
    }

    public int getRepeatCount() {
        return this.m;
    }

    public void setRepeatCount(int i2) {
        this.m = i2;
        c();
    }

    public int getRepeatDelay() {
        return this.n;
    }

    public void setRepeatDelay(int i2) {
        this.n = i2;
        c();
    }

    public int getRepeatMode() {
        return this.o;
    }

    public void setRepeatMode(int i2) {
        this.o = i2;
        c();
    }

    public c getMaskShape() {
        return this.f49259g.f49274i;
    }

    public void setMaskShape(c cVar) {
        this.f49259g.f49274i = cVar;
        c();
    }

    public b getAngle() {
        return this.f49259g.f49266a;
    }

    public void setAngle(b bVar) {
        this.f49259g.f49266a = bVar;
        c();
    }

    public float getDropoff() {
        return this.f49259g.f49268c;
    }

    public void setDropoff(float f2) {
        this.f49259g.f49268c = f2;
        c();
    }

    public int getFixedWidth() {
        return this.f49259g.f49269d;
    }

    public void setFixedWidth(int i2) {
        this.f49259g.f49269d = i2;
        c();
    }

    public int getFixedHeight() {
        return this.f49259g.f49270e;
    }

    public void setFixedHeight(int i2) {
        this.f49259g.f49270e = i2;
        c();
    }

    public float getIntensity() {
        return this.f49259g.f49271f;
    }

    public void setIntensity(float f2) {
        this.f49259g.f49271f = f2;
        c();
    }

    public float getRelativeWidth() {
        return this.f49259g.f49272g;
    }

    public void setRelativeWidth(int i2) {
        this.f49259g.f49272g = (float) i2;
        c();
    }

    public float getRelativeHeight() {
        return this.f49259g.f49273h;
    }

    public void setRelativeHeight(int i2) {
        this.f49259g.f49273h = (float) i2;
        c();
    }

    public float getTilt() {
        return this.f49259g.f49267b;
    }

    public void setTilt(float f2) {
        this.f49259g.f49267b = f2;
        c();
    }

    public final void a() {
        ValueAnimator valueAnimator = this.f49255b;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.f49255b.removeAllUpdateListeners();
            this.f49255b.cancel();
        }
        this.f49255b = null;
        this.f49254a = false;
    }

    /* access modifiers changed from: private */
    public void setMaskOffsetX(int i2) {
        if (this.p != i2) {
            this.p = i2;
            invalidate();
        }
    }

    /* access modifiers changed from: private */
    public void setMaskOffsetY(int i2) {
        if (this.q != i2) {
            this.q = i2;
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
                boolean a2 = ShimmerFrameLayout.this.f49254a;
                ShimmerFrameLayout.this.c();
                if (ShimmerFrameLayout.this.k || a2) {
                    ShimmerFrameLayout shimmerFrameLayout = ShimmerFrameLayout.this;
                    if (!shimmerFrameLayout.f49254a) {
                        shimmerFrameLayout.getShimmerAnimation().start();
                        shimmerFrameLayout.f49254a = true;
                    }
                }
            }
        };
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        a();
        if (this.r != null) {
            getViewTreeObserver().removeGlobalOnLayoutListener(this.r);
            this.r = null;
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        if (!this.f49254a || getWidth() <= 0 || getHeight() <= 0) {
            super.dispatchDraw(canvas);
            return;
        }
        if (this.j == null) {
            this.j = b();
        }
        Bitmap bitmap = this.j;
        if (this.f49261i == null) {
            this.f49261i = b();
        }
        Bitmap bitmap2 = this.f49261i;
        if (bitmap != null && bitmap2 != null) {
            Canvas canvas2 = new Canvas(bitmap);
            canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
            super.dispatchDraw(canvas2);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.f49257e);
            Canvas canvas3 = new Canvas(bitmap2);
            Bitmap maskBitmap = getMaskBitmap();
            if (maskBitmap != null) {
                int i2 = this.p;
                canvas3.clipRect(i2, this.q, maskBitmap.getWidth() + i2, this.q + maskBitmap.getHeight());
                canvas3.drawColor(0, PorterDuff.Mode.CLEAR);
                super.dispatchDraw(canvas3);
                canvas3.drawBitmap(maskBitmap, (float) this.p, (float) this.q, this.f49258f);
            }
            canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
        }
    }

    private Bitmap b() {
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
            q.d(sb.toString());
            return null;
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        a();
        d();
        e();
    }

    private void d() {
        Bitmap bitmap = this.f49256c;
        if (bitmap != null) {
            bitmap.recycle();
            this.f49256c = null;
        }
    }

    private void e() {
        Bitmap bitmap = this.j;
        if (bitmap != null) {
            bitmap.recycle();
            this.j = null;
        }
        Bitmap bitmap2 = this.f49261i;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.f49261i = null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: android.graphics.RadialGradient} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: android.graphics.RadialGradient} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: android.graphics.LinearGradient} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: android.graphics.RadialGradient} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap getMaskBitmap() {
        /*
            r20 = this;
            r0 = r20
            android.graphics.Bitmap r1 = r0.f49256c
            if (r1 == 0) goto L_0x0007
            return r1
        L_0x0007:
            net.one97.paytm.autoaddmoney.util.ShimmerFrameLayout$a r1 = r0.f49259g
            int r2 = r20.getWidth()
            int r3 = r1.f49269d
            if (r3 <= 0) goto L_0x0014
            int r1 = r1.f49269d
            goto L_0x001a
        L_0x0014:
            float r2 = (float) r2
            float r1 = r1.f49272g
            float r2 = r2 * r1
            int r1 = (int) r2
        L_0x001a:
            net.one97.paytm.autoaddmoney.util.ShimmerFrameLayout$a r2 = r0.f49259g
            int r3 = r20.getHeight()
            int r4 = r2.f49270e
            if (r4 <= 0) goto L_0x0027
            int r2 = r2.f49270e
            goto L_0x002d
        L_0x0027:
            float r3 = (float) r3
            float r2 = r2.f49273h
            float r3 = r3 * r2
            int r2 = (int) r3
        L_0x002d:
            android.graphics.Bitmap r3 = a((int) r1, (int) r2)
            r0.f49256c = r3
            android.graphics.Canvas r4 = new android.graphics.Canvas
            android.graphics.Bitmap r3 = r0.f49256c
            r4.<init>(r3)
            int[] r3 = net.one97.paytm.autoaddmoney.util.ShimmerFrameLayout.AnonymousClass3.f49264a
            net.one97.paytm.autoaddmoney.util.ShimmerFrameLayout$a r5 = r0.f49259g
            net.one97.paytm.autoaddmoney.util.ShimmerFrameLayout$c r5 = r5.f49274i
            int r5 = r5.ordinal()
            r3 = r3[r5]
            r5 = 4611686018427387904(0x4000000000000000, double:2.0)
            r7 = 2
            if (r3 == r7) goto L_0x0089
            int[] r3 = net.one97.paytm.autoaddmoney.util.ShimmerFrameLayout.AnonymousClass3.f49265b
            net.one97.paytm.autoaddmoney.util.ShimmerFrameLayout$a r8 = r0.f49259g
            net.one97.paytm.autoaddmoney.util.ShimmerFrameLayout$b r8 = r8.f49266a
            int r8 = r8.ordinal()
            r3 = r3[r8]
            r8 = 0
            if (r3 == r7) goto L_0x006a
            r9 = 3
            if (r3 == r9) goto L_0x0066
            r9 = 4
            if (r3 == r9) goto L_0x0064
            r9 = r1
            r3 = 0
        L_0x0062:
            r10 = 0
            goto L_0x006d
        L_0x0064:
            r3 = r2
            goto L_0x0068
        L_0x0066:
            r8 = r1
            r3 = 0
        L_0x0068:
            r9 = 0
            goto L_0x0062
        L_0x006a:
            r10 = r2
            r3 = 0
            r9 = 0
        L_0x006d:
            android.graphics.LinearGradient r19 = new android.graphics.LinearGradient
            float r12 = (float) r8
            float r13 = (float) r3
            float r14 = (float) r9
            float r15 = (float) r10
            net.one97.paytm.autoaddmoney.util.ShimmerFrameLayout$a r3 = r0.f49259g
            int[] r16 = r3.a()
            net.one97.paytm.autoaddmoney.util.ShimmerFrameLayout$a r3 = r0.f49259g
            float[] r17 = r3.b()
            android.graphics.Shader$TileMode r18 = android.graphics.Shader.TileMode.REPEAT
            r11 = r19
            r11.<init>(r12, r13, r14, r15, r16, r17, r18)
            r3 = r19
            goto L_0x00b1
        L_0x0089:
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
            net.one97.paytm.autoaddmoney.util.ShimmerFrameLayout$a r3 = r0.f49259g
            int[] r13 = r3.a()
            net.one97.paytm.autoaddmoney.util.ShimmerFrameLayout$a r3 = r0.f49259g
            float[] r14 = r3.b()
            android.graphics.Shader$TileMode r15 = android.graphics.Shader.TileMode.REPEAT
            r9 = r16
            r9.<init>(r10, r11, r12, r13, r14, r15)
            r3 = r16
        L_0x00b1:
            net.one97.paytm.autoaddmoney.util.ShimmerFrameLayout$a r8 = r0.f49259g
            float r8 = r8.f49267b
            int r9 = r1 / 2
            float r9 = (float) r9
            int r10 = r2 / 2
            float r10 = (float) r10
            r4.rotate(r8, r9, r10)
            android.graphics.Paint r9 = new android.graphics.Paint
            r9.<init>()
            r9.setShader(r3)
            double r5 = java.lang.Math.sqrt(r5)
            int r3 = java.lang.Math.max(r1, r2)
            double r10 = (double) r3
            double r5 = r5 * r10
            int r3 = (int) r5
            int r3 = r3 / r7
            int r5 = -r3
            float r6 = (float) r5
            int r1 = r1 + r3
            float r7 = (float) r1
            int r2 = r2 + r3
            float r8 = (float) r2
            r5 = r6
            r4.drawRect(r5, r6, r7, r8, r9)
            android.graphics.Bitmap r1 = r0.f49256c
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.autoaddmoney.util.ShimmerFrameLayout.getMaskBitmap():android.graphics.Bitmap");
    }

    /* renamed from: net.one97.paytm.autoaddmoney.util.ShimmerFrameLayout$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f49264a = new int[c.values().length];

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f49265b = new int[b.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|(2:1|2)|3|5|6|7|8|(2:9|10)|11|13|14|(3:15|16|18)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0048 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002a */
        static {
            /*
                net.one97.paytm.autoaddmoney.util.ShimmerFrameLayout$b[] r0 = net.one97.paytm.autoaddmoney.util.ShimmerFrameLayout.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f49265b = r0
                r0 = 1
                int[] r1 = f49265b     // Catch:{ NoSuchFieldError -> 0x0014 }
                net.one97.paytm.autoaddmoney.util.ShimmerFrameLayout$b r2 = net.one97.paytm.autoaddmoney.util.ShimmerFrameLayout.b.CW_0     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f49265b     // Catch:{ NoSuchFieldError -> 0x001f }
                net.one97.paytm.autoaddmoney.util.ShimmerFrameLayout$b r3 = net.one97.paytm.autoaddmoney.util.ShimmerFrameLayout.b.CW_90     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r2 = f49265b     // Catch:{ NoSuchFieldError -> 0x002a }
                net.one97.paytm.autoaddmoney.util.ShimmerFrameLayout$b r3 = net.one97.paytm.autoaddmoney.util.ShimmerFrameLayout.b.CW_180     // Catch:{ NoSuchFieldError -> 0x002a }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r4 = 3
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r2 = f49265b     // Catch:{ NoSuchFieldError -> 0x0035 }
                net.one97.paytm.autoaddmoney.util.ShimmerFrameLayout$b r3 = net.one97.paytm.autoaddmoney.util.ShimmerFrameLayout.b.CW_270     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r4 = 4
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                net.one97.paytm.autoaddmoney.util.ShimmerFrameLayout$c[] r2 = net.one97.paytm.autoaddmoney.util.ShimmerFrameLayout.c.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f49264a = r2
                int[] r2 = f49264a     // Catch:{ NoSuchFieldError -> 0x0048 }
                net.one97.paytm.autoaddmoney.util.ShimmerFrameLayout$c r3 = net.one97.paytm.autoaddmoney.util.ShimmerFrameLayout.c.LINEAR     // Catch:{ NoSuchFieldError -> 0x0048 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0048 }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0048 }
            L_0x0048:
                int[] r0 = f49264a     // Catch:{ NoSuchFieldError -> 0x0052 }
                net.one97.paytm.autoaddmoney.util.ShimmerFrameLayout$c r2 = net.one97.paytm.autoaddmoney.util.ShimmerFrameLayout.c.RADIAL     // Catch:{ NoSuchFieldError -> 0x0052 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0052 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0052 }
            L_0x0052:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.autoaddmoney.util.ShimmerFrameLayout.AnonymousClass3.<clinit>():void");
        }
    }

    /* access modifiers changed from: package-private */
    public Animator getShimmerAnimation() {
        ValueAnimator valueAnimator = this.f49255b;
        if (valueAnimator != null) {
            return valueAnimator;
        }
        int width = getWidth();
        int height = getHeight();
        int[] iArr = AnonymousClass3.f49264a;
        this.f49259g.f49274i.ordinal();
        int i2 = AnonymousClass3.f49265b[this.f49259g.f49266a.ordinal()];
        if (i2 == 2) {
            this.f49260h.a(0, -height, 0, height);
        } else if (i2 == 3) {
            this.f49260h.a(width, 0, -width, 0);
        } else if (i2 != 4) {
            this.f49260h.a(-width, 0, width, 0);
        } else {
            this.f49260h.a(0, height, 0, -height);
        }
        this.f49255b = ValueAnimator.ofFloat(new float[]{0.0f, (((float) this.n) / ((float) this.l)) + 1.0f});
        this.f49255b.setDuration((long) (this.l + this.n));
        this.f49255b.setRepeatCount(this.m);
        this.f49255b.setRepeatMode(this.o);
        this.f49255b.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float max = Math.max(0.0f, Math.min(1.0f, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                ShimmerFrameLayout shimmerFrameLayout = ShimmerFrameLayout.this;
                float f2 = 1.0f - max;
                shimmerFrameLayout.setMaskOffsetX((int) ((((float) shimmerFrameLayout.f49260h.f49275a) * f2) + (((float) ShimmerFrameLayout.this.f49260h.f49277c) * max)));
                ShimmerFrameLayout shimmerFrameLayout2 = ShimmerFrameLayout.this;
                shimmerFrameLayout2.setMaskOffsetY((int) ((((float) shimmerFrameLayout2.f49260h.f49276b) * f2) + (((float) ShimmerFrameLayout.this.f49260h.f49278d) * max)));
            }
        });
        return this.f49255b;
    }

    private static Bitmap a(int i2, int i3) {
        try {
            return Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError unused) {
            System.gc();
            return Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        }
    }
}
