package net.one97.paytm.upi.common;

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
import net.one97.paytm.upi.R;

public class ShimmerFrameLayout extends FrameLayout {
    private static final PorterDuffXfermode DST_IN_PORTER_DUFF_XFERMODE = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    private static final String TAG = "ShimmerFrameLayout";
    private Paint mAlphaPaint;
    /* access modifiers changed from: private */
    public boolean mAnimationStarted;
    protected ValueAnimator mAnimator;
    /* access modifiers changed from: private */
    public boolean mAutoStart;
    private int mDuration;
    private ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener;
    private a mMask;
    protected Bitmap mMaskBitmap;
    private int mMaskOffsetX;
    private int mMaskOffsetY;
    private Paint mMaskPaint;
    /* access modifiers changed from: private */
    public b mMaskTranslation;
    private Bitmap mRenderMaskBitmap;
    private Bitmap mRenderUnmaskBitmap;
    private int mRepeatCount;
    private int mRepeatDelay;
    private int mRepeatMode;

    public enum MaskAngle {
        CW_0,
        CW_90,
        CW_180,
        CW_270
    }

    public enum MaskShape {
        LINEAR,
        RADIAL
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        public MaskAngle f66643a;

        /* renamed from: b  reason: collision with root package name */
        public float f66644b;

        /* renamed from: c  reason: collision with root package name */
        public float f66645c;

        /* renamed from: d  reason: collision with root package name */
        public int f66646d;

        /* renamed from: e  reason: collision with root package name */
        public int f66647e;

        /* renamed from: f  reason: collision with root package name */
        public float f66648f;

        /* renamed from: g  reason: collision with root package name */
        public float f66649g;

        /* renamed from: h  reason: collision with root package name */
        public float f66650h;

        /* renamed from: i  reason: collision with root package name */
        public MaskShape f66651i;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        public final int[] a() {
            if (AnonymousClass3.f66641a[this.f66651i.ordinal()] != 2) {
                return new int[]{0, -16777216, -16777216, 0};
            }
            return new int[]{-16777216, -16777216, 0};
        }

        public final float[] b() {
            if (AnonymousClass3.f66641a[this.f66651i.ordinal()] != 2) {
                return new float[]{Math.max(((1.0f - this.f66648f) - this.f66645c) / 2.0f, 0.0f), Math.max((1.0f - this.f66648f) / 2.0f, 0.0f), Math.min((this.f66648f + 1.0f) / 2.0f, 1.0f), Math.min(((this.f66648f + 1.0f) + this.f66645c) / 2.0f, 1.0f)};
            }
            return new float[]{0.0f, Math.min(this.f66648f, 1.0f), Math.min(this.f66648f + this.f66645c, 1.0f)};
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f66652a;

        /* renamed from: b  reason: collision with root package name */
        public int f66653b;

        /* renamed from: c  reason: collision with root package name */
        public int f66654c;

        /* renamed from: d  reason: collision with root package name */
        public int f66655d;

        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        public final void a(int i2, int i3, int i4, int i5) {
            this.f66652a = i2;
            this.f66653b = i3;
            this.f66654c = i4;
            this.f66655d = i5;
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
        this.mMask = new a((byte) 0);
        this.mAlphaPaint = new Paint();
        this.mMaskPaint = new Paint();
        this.mMaskPaint.setAntiAlias(true);
        this.mMaskPaint.setDither(true);
        this.mMaskPaint.setFilterBitmap(true);
        this.mMaskPaint.setXfermode(DST_IN_PORTER_DUFF_XFERMODE);
        useDefaults();
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
                        this.mMask.f66643a = MaskAngle.CW_90;
                    } else if (i3 == 180) {
                        this.mMask.f66643a = MaskAngle.CW_180;
                    } else if (i3 != 270) {
                        this.mMask.f66643a = MaskAngle.CW_0;
                    } else {
                        this.mMask.f66643a = MaskAngle.CW_270;
                    }
                }
                if (obtainStyledAttributes.hasValue(R.styleable.ShimmerFrameLayout_shape)) {
                    if (obtainStyledAttributes.getInt(R.styleable.ShimmerFrameLayout_shape, 0) != 1) {
                        this.mMask.f66651i = MaskShape.LINEAR;
                    } else {
                        this.mMask.f66651i = MaskShape.RADIAL;
                    }
                }
                if (obtainStyledAttributes.hasValue(R.styleable.ShimmerFrameLayout_dropoff)) {
                    this.mMask.f66645c = obtainStyledAttributes.getFloat(R.styleable.ShimmerFrameLayout_dropoff, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(R.styleable.ShimmerFrameLayout_fixed_width)) {
                    this.mMask.f66646d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ShimmerFrameLayout_fixed_width, 0);
                }
                if (obtainStyledAttributes.hasValue(R.styleable.ShimmerFrameLayout_fixed_height)) {
                    this.mMask.f66647e = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ShimmerFrameLayout_fixed_height, 0);
                }
                if (obtainStyledAttributes.hasValue(R.styleable.ShimmerFrameLayout_intensity)) {
                    this.mMask.f66648f = obtainStyledAttributes.getFloat(R.styleable.ShimmerFrameLayout_intensity, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(R.styleable.ShimmerFrameLayout_relative_width)) {
                    this.mMask.f66649g = obtainStyledAttributes.getFloat(R.styleable.ShimmerFrameLayout_relative_width, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(R.styleable.ShimmerFrameLayout_relative_height)) {
                    this.mMask.f66650h = obtainStyledAttributes.getFloat(R.styleable.ShimmerFrameLayout_relative_height, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(R.styleable.ShimmerFrameLayout_tilt)) {
                    this.mMask.f66644b = obtainStyledAttributes.getFloat(R.styleable.ShimmerFrameLayout_tilt, 0.0f);
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void useDefaults() {
        setAutoStart(false);
        setDuration(1000);
        setRepeatCount(-1);
        setRepeatDelay(0);
        setRepeatMode(1);
        this.mMask.f66643a = MaskAngle.CW_0;
        this.mMask.f66651i = MaskShape.LINEAR;
        a aVar = this.mMask;
        aVar.f66645c = 0.5f;
        aVar.f66646d = 0;
        aVar.f66647e = 0;
        aVar.f66648f = 0.0f;
        aVar.f66649g = 1.0f;
        aVar.f66650h = 1.0f;
        aVar.f66644b = 20.0f;
        this.mMaskTranslation = new b((byte) 0);
        setBaseAlpha(0.3f);
        resetAll();
    }

    public boolean isAutoStart() {
        return this.mAutoStart;
    }

    public void setAutoStart(boolean z) {
        this.mAutoStart = z;
        resetAll();
    }

    public float getBaseAlpha() {
        return ((float) this.mAlphaPaint.getAlpha()) / 255.0f;
    }

    public void setBaseAlpha(float f2) {
        this.mAlphaPaint.setAlpha((int) (clamp(0.0f, 1.0f, f2) * 255.0f));
        resetAll();
    }

    public int getDuration() {
        return this.mDuration;
    }

    public void setDuration(int i2) {
        this.mDuration = i2;
        resetAll();
    }

    public int getRepeatCount() {
        return this.mRepeatCount;
    }

    public void setRepeatCount(int i2) {
        this.mRepeatCount = i2;
        resetAll();
    }

    public int getRepeatDelay() {
        return this.mRepeatDelay;
    }

    public void setRepeatDelay(int i2) {
        this.mRepeatDelay = i2;
        resetAll();
    }

    public int getRepeatMode() {
        return this.mRepeatMode;
    }

    public void setRepeatMode(int i2) {
        this.mRepeatMode = i2;
        resetAll();
    }

    public MaskShape getMaskShape() {
        return this.mMask.f66651i;
    }

    public void setMaskShape(MaskShape maskShape) {
        this.mMask.f66651i = maskShape;
        resetAll();
    }

    public MaskAngle getAngle() {
        return this.mMask.f66643a;
    }

    public void setAngle(MaskAngle maskAngle) {
        this.mMask.f66643a = maskAngle;
        resetAll();
    }

    public float getDropoff() {
        return this.mMask.f66645c;
    }

    public void setDropoff(float f2) {
        this.mMask.f66645c = f2;
        resetAll();
    }

    public int getFixedWidth() {
        return this.mMask.f66646d;
    }

    public void setFixedWidth(int i2) {
        this.mMask.f66646d = i2;
        resetAll();
    }

    public int getFixedHeight() {
        return this.mMask.f66647e;
    }

    public void setFixedHeight(int i2) {
        this.mMask.f66647e = i2;
        resetAll();
    }

    public float getIntensity() {
        return this.mMask.f66648f;
    }

    public void setIntensity(float f2) {
        this.mMask.f66648f = f2;
        resetAll();
    }

    public float getRelativeWidth() {
        return this.mMask.f66649g;
    }

    public void setRelativeWidth(int i2) {
        this.mMask.f66649g = (float) i2;
        resetAll();
    }

    public float getRelativeHeight() {
        return this.mMask.f66650h;
    }

    public void setRelativeHeight(int i2) {
        this.mMask.f66650h = (float) i2;
        resetAll();
    }

    public float getTilt() {
        return this.mMask.f66644b;
    }

    public void setTilt(float f2) {
        this.mMask.f66644b = f2;
        resetAll();
    }

    public void startShimmerAnimation() {
        if (!this.mAnimationStarted) {
            getShimmerAnimation().start();
            this.mAnimationStarted = true;
        }
    }

    public void stopShimmerAnimation() {
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.mAnimator.removeAllUpdateListeners();
            this.mAnimator.cancel();
        }
        this.mAnimator = null;
        this.mAnimationStarted = false;
    }

    public boolean isAnimationStarted() {
        return this.mAnimationStarted;
    }

    /* access modifiers changed from: private */
    public void setMaskOffsetX(int i2) {
        if (this.mMaskOffsetX != i2) {
            this.mMaskOffsetX = i2;
            invalidate();
        }
    }

    /* access modifiers changed from: private */
    public void setMaskOffsetY(int i2) {
        if (this.mMaskOffsetY != i2) {
            this.mMaskOffsetY = i2;
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mGlobalLayoutListener == null) {
            this.mGlobalLayoutListener = getLayoutListener();
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.mGlobalLayoutListener);
    }

    private ViewTreeObserver.OnGlobalLayoutListener getLayoutListener() {
        return new ViewTreeObserver.OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                boolean access$200 = ShimmerFrameLayout.this.mAnimationStarted;
                ShimmerFrameLayout.this.resetAll();
                if (ShimmerFrameLayout.this.mAutoStart || access$200) {
                    ShimmerFrameLayout.this.startShimmerAnimation();
                }
            }
        };
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        stopShimmerAnimation();
        if (this.mGlobalLayoutListener != null) {
            getViewTreeObserver().removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
            this.mGlobalLayoutListener = null;
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        if (!this.mAnimationStarted || getWidth() <= 0 || getHeight() <= 0) {
            super.dispatchDraw(canvas);
        } else {
            dispatchDrawUsingBitmap(canvas);
        }
    }

    private static float clamp(float f2, float f3, float f4) {
        return Math.min(f3, Math.max(f2, f4));
    }

    private boolean dispatchDrawUsingBitmap(Canvas canvas) {
        Bitmap tryObtainRenderUnmaskBitmap = tryObtainRenderUnmaskBitmap();
        Bitmap tryObtainRenderMaskBitmap = tryObtainRenderMaskBitmap();
        if (tryObtainRenderUnmaskBitmap == null || tryObtainRenderMaskBitmap == null) {
            return false;
        }
        drawUnmasked(new Canvas(tryObtainRenderUnmaskBitmap));
        canvas.drawBitmap(tryObtainRenderUnmaskBitmap, 0.0f, 0.0f, this.mAlphaPaint);
        drawMasked(new Canvas(tryObtainRenderMaskBitmap));
        canvas.drawBitmap(tryObtainRenderMaskBitmap, 0.0f, 0.0f, (Paint) null);
        return true;
    }

    private Bitmap tryObtainRenderUnmaskBitmap() {
        if (this.mRenderUnmaskBitmap == null) {
            this.mRenderUnmaskBitmap = tryCreateRenderBitmap();
        }
        return this.mRenderUnmaskBitmap;
    }

    private Bitmap tryObtainRenderMaskBitmap() {
        if (this.mRenderMaskBitmap == null) {
            this.mRenderMaskBitmap = tryCreateRenderBitmap();
        }
        return this.mRenderMaskBitmap;
    }

    private Bitmap tryCreateRenderBitmap() {
        int width = getWidth();
        int height = getHeight();
        try {
            return createBitmapAndGcIfNecessary(width, height);
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
            PaytmLogs.d(TAG, sb.toString());
            return null;
        }
    }

    private void drawUnmasked(Canvas canvas) {
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        super.dispatchDraw(canvas);
    }

    private void drawMasked(Canvas canvas) {
        Bitmap maskBitmap = getMaskBitmap();
        if (maskBitmap != null) {
            int i2 = this.mMaskOffsetX;
            canvas.clipRect(i2, this.mMaskOffsetY, maskBitmap.getWidth() + i2, this.mMaskOffsetY + maskBitmap.getHeight());
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            super.dispatchDraw(canvas);
            canvas.drawBitmap(maskBitmap, (float) this.mMaskOffsetX, (float) this.mMaskOffsetY, this.mMaskPaint);
        }
    }

    /* access modifiers changed from: private */
    public void resetAll() {
        stopShimmerAnimation();
        resetMaskBitmap();
        resetRenderedView();
    }

    private void resetMaskBitmap() {
        Bitmap bitmap = this.mMaskBitmap;
        if (bitmap != null) {
            bitmap.recycle();
            this.mMaskBitmap = null;
        }
    }

    private void resetRenderedView() {
        Bitmap bitmap = this.mRenderUnmaskBitmap;
        if (bitmap != null) {
            bitmap.recycle();
            this.mRenderUnmaskBitmap = null;
        }
        Bitmap bitmap2 = this.mRenderMaskBitmap;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.mRenderMaskBitmap = null;
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
            android.graphics.Bitmap r1 = r0.mMaskBitmap
            if (r1 == 0) goto L_0x0007
            return r1
        L_0x0007:
            net.one97.paytm.upi.common.ShimmerFrameLayout$a r1 = r0.mMask
            int r2 = r20.getWidth()
            int r3 = r1.f66646d
            if (r3 <= 0) goto L_0x0014
            int r1 = r1.f66646d
            goto L_0x001a
        L_0x0014:
            float r2 = (float) r2
            float r1 = r1.f66649g
            float r2 = r2 * r1
            int r1 = (int) r2
        L_0x001a:
            net.one97.paytm.upi.common.ShimmerFrameLayout$a r2 = r0.mMask
            int r3 = r20.getHeight()
            int r4 = r2.f66647e
            if (r4 <= 0) goto L_0x0027
            int r2 = r2.f66647e
            goto L_0x002d
        L_0x0027:
            float r3 = (float) r3
            float r2 = r2.f66650h
            float r3 = r3 * r2
            int r2 = (int) r3
        L_0x002d:
            android.graphics.Bitmap r3 = createBitmapAndGcIfNecessary(r1, r2)
            r0.mMaskBitmap = r3
            android.graphics.Bitmap r3 = r0.mMaskBitmap
            if (r3 != 0) goto L_0x0039
            r1 = 0
            return r1
        L_0x0039:
            android.graphics.Canvas r4 = new android.graphics.Canvas
            r4.<init>(r3)
            int[] r3 = net.one97.paytm.upi.common.ShimmerFrameLayout.AnonymousClass3.f66641a
            net.one97.paytm.upi.common.ShimmerFrameLayout$a r5 = r0.mMask
            net.one97.paytm.upi.common.ShimmerFrameLayout$MaskShape r5 = r5.f66651i
            int r5 = r5.ordinal()
            r3 = r3[r5]
            r5 = 4611686018427387904(0x4000000000000000, double:2.0)
            r7 = 2
            if (r3 == r7) goto L_0x008d
            int[] r3 = net.one97.paytm.upi.common.ShimmerFrameLayout.AnonymousClass3.f66642b
            net.one97.paytm.upi.common.ShimmerFrameLayout$a r8 = r0.mMask
            net.one97.paytm.upi.common.ShimmerFrameLayout$MaskAngle r8 = r8.f66643a
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
            net.one97.paytm.upi.common.ShimmerFrameLayout$a r3 = r0.mMask
            int[] r16 = r3.a()
            net.one97.paytm.upi.common.ShimmerFrameLayout$a r3 = r0.mMask
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
            net.one97.paytm.upi.common.ShimmerFrameLayout$a r3 = r0.mMask
            int[] r13 = r3.a()
            net.one97.paytm.upi.common.ShimmerFrameLayout$a r3 = r0.mMask
            float[] r14 = r3.b()
            android.graphics.Shader$TileMode r15 = android.graphics.Shader.TileMode.REPEAT
            r9 = r16
            r9.<init>(r10, r11, r12, r13, r14, r15)
            r3 = r16
        L_0x00b5:
            net.one97.paytm.upi.common.ShimmerFrameLayout$a r8 = r0.mMask
            float r8 = r8.f66644b
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
            android.graphics.Bitmap r1 = r0.mMaskBitmap
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.common.ShimmerFrameLayout.getMaskBitmap():android.graphics.Bitmap");
    }

    /* renamed from: net.one97.paytm.upi.common.ShimmerFrameLayout$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f66641a = new int[MaskShape.values().length];

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f66642b = new int[MaskAngle.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|(2:1|2)|3|5|6|7|8|(2:9|10)|11|13|14|(3:15|16|18)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0048 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002a */
        static {
            /*
                net.one97.paytm.upi.common.ShimmerFrameLayout$MaskAngle[] r0 = net.one97.paytm.upi.common.ShimmerFrameLayout.MaskAngle.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f66642b = r0
                r0 = 1
                int[] r1 = f66642b     // Catch:{ NoSuchFieldError -> 0x0014 }
                net.one97.paytm.upi.common.ShimmerFrameLayout$MaskAngle r2 = net.one97.paytm.upi.common.ShimmerFrameLayout.MaskAngle.CW_0     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f66642b     // Catch:{ NoSuchFieldError -> 0x001f }
                net.one97.paytm.upi.common.ShimmerFrameLayout$MaskAngle r3 = net.one97.paytm.upi.common.ShimmerFrameLayout.MaskAngle.CW_90     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r2 = f66642b     // Catch:{ NoSuchFieldError -> 0x002a }
                net.one97.paytm.upi.common.ShimmerFrameLayout$MaskAngle r3 = net.one97.paytm.upi.common.ShimmerFrameLayout.MaskAngle.CW_180     // Catch:{ NoSuchFieldError -> 0x002a }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r4 = 3
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r2 = f66642b     // Catch:{ NoSuchFieldError -> 0x0035 }
                net.one97.paytm.upi.common.ShimmerFrameLayout$MaskAngle r3 = net.one97.paytm.upi.common.ShimmerFrameLayout.MaskAngle.CW_270     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r4 = 4
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                net.one97.paytm.upi.common.ShimmerFrameLayout$MaskShape[] r2 = net.one97.paytm.upi.common.ShimmerFrameLayout.MaskShape.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f66641a = r2
                int[] r2 = f66641a     // Catch:{ NoSuchFieldError -> 0x0048 }
                net.one97.paytm.upi.common.ShimmerFrameLayout$MaskShape r3 = net.one97.paytm.upi.common.ShimmerFrameLayout.MaskShape.LINEAR     // Catch:{ NoSuchFieldError -> 0x0048 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0048 }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0048 }
            L_0x0048:
                int[] r0 = f66641a     // Catch:{ NoSuchFieldError -> 0x0052 }
                net.one97.paytm.upi.common.ShimmerFrameLayout$MaskShape r2 = net.one97.paytm.upi.common.ShimmerFrameLayout.MaskShape.RADIAL     // Catch:{ NoSuchFieldError -> 0x0052 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0052 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0052 }
            L_0x0052:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.common.ShimmerFrameLayout.AnonymousClass3.<clinit>():void");
        }
    }

    private Animator getShimmerAnimation() {
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null) {
            return valueAnimator;
        }
        int width = getWidth();
        int height = getHeight();
        int[] iArr = AnonymousClass3.f66641a;
        this.mMask.f66651i.ordinal();
        int i2 = AnonymousClass3.f66642b[this.mMask.f66643a.ordinal()];
        if (i2 == 2) {
            this.mMaskTranslation.a(0, -height, 0, height);
        } else if (i2 == 3) {
            this.mMaskTranslation.a(width, 0, -width, 0);
        } else if (i2 != 4) {
            this.mMaskTranslation.a(-width, 0, width, 0);
        } else {
            this.mMaskTranslation.a(0, height, 0, -height);
        }
        this.mAnimator = ValueAnimator.ofFloat(new float[]{0.0f, (((float) this.mRepeatDelay) / ((float) this.mDuration)) + 1.0f});
        this.mAnimator.setDuration((long) (this.mDuration + this.mRepeatDelay));
        this.mAnimator.setRepeatCount(this.mRepeatCount);
        this.mAnimator.setRepeatMode(this.mRepeatMode);
        this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float max = Math.max(0.0f, Math.min(1.0f, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                ShimmerFrameLayout shimmerFrameLayout = ShimmerFrameLayout.this;
                float f2 = 1.0f - max;
                shimmerFrameLayout.setMaskOffsetX((int) ((((float) shimmerFrameLayout.mMaskTranslation.f66652a) * f2) + (((float) ShimmerFrameLayout.this.mMaskTranslation.f66654c) * max)));
                ShimmerFrameLayout shimmerFrameLayout2 = ShimmerFrameLayout.this;
                shimmerFrameLayout2.setMaskOffsetY((int) ((((float) shimmerFrameLayout2.mMaskTranslation.f66653b) * f2) + (((float) ShimmerFrameLayout.this.mMaskTranslation.f66655d) * max)));
            }
        });
        return this.mAnimator;
    }

    protected static Bitmap createBitmapAndGcIfNecessary(int i2, int i3) {
        try {
            return Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError unused) {
            System.gc();
            return null;
        }
    }
}
