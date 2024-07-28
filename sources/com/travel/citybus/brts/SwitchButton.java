package com.travel.citybus.brts;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.Checkable;
import com.travel.citybus.R;

public class SwitchButton extends View implements Checkable {

    /* renamed from: a  reason: collision with root package name */
    private static final int f23157a = ((int) a(58.0f));

    /* renamed from: b  reason: collision with root package name */
    private static final int f23158b = ((int) a(36.0f));
    /* access modifiers changed from: private */
    public int A;
    private int B;
    private float C;
    private int D;
    private int E;
    private float F;
    private float G;
    private float H;
    private float I;
    /* access modifiers changed from: private */
    public float J;
    /* access modifiers changed from: private */
    public float K;
    private Paint L;
    private Paint M;
    /* access modifiers changed from: private */
    public b N;
    /* access modifiers changed from: private */
    public b O;
    /* access modifiers changed from: private */
    public b P;
    private RectF Q = new RectF();
    /* access modifiers changed from: private */
    public int R = 0;
    private ValueAnimator S;
    /* access modifiers changed from: private */
    public boolean T;
    private boolean U;
    private boolean V;
    private boolean W;
    private boolean aa = false;
    private boolean ab = false;
    private boolean ac = false;
    private a ad;
    private long ae;
    private Runnable af = new Runnable() {
        public final void run() {
            if (!SwitchButton.this.c()) {
                SwitchButton.b(SwitchButton.this);
            }
        }
    };
    private ValueAnimator.AnimatorUpdateListener ag = new ValueAnimator.AnimatorUpdateListener() {
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int c2 = SwitchButton.this.R;
            if (c2 == 1 || c2 == 3 || c2 == 4) {
                SwitchButton.this.N.f23171c = ((Integer) SwitchButton.this.f23165i.evaluate(floatValue, Integer.valueOf(SwitchButton.this.O.f23171c), Integer.valueOf(SwitchButton.this.P.f23171c))).intValue();
                SwitchButton.this.N.f23172d = SwitchButton.this.O.f23172d + ((SwitchButton.this.P.f23172d - SwitchButton.this.O.f23172d) * floatValue);
                if (SwitchButton.this.R != 1) {
                    SwitchButton.this.N.f23169a = SwitchButton.this.O.f23169a + ((SwitchButton.this.P.f23169a - SwitchButton.this.O.f23169a) * floatValue);
                }
                SwitchButton.this.N.f23170b = ((Integer) SwitchButton.this.f23165i.evaluate(floatValue, Integer.valueOf(SwitchButton.this.O.f23170b), Integer.valueOf(SwitchButton.this.P.f23170b))).intValue();
            } else if (c2 == 5) {
                SwitchButton.this.N.f23169a = SwitchButton.this.O.f23169a + ((SwitchButton.this.P.f23169a - SwitchButton.this.O.f23169a) * floatValue);
                float h2 = (SwitchButton.this.N.f23169a - SwitchButton.this.J) / (SwitchButton.this.K - SwitchButton.this.J);
                SwitchButton.this.N.f23170b = ((Integer) SwitchButton.this.f23165i.evaluate(h2, Integer.valueOf(SwitchButton.this.x), Integer.valueOf(SwitchButton.this.y))).intValue();
                SwitchButton.this.N.f23172d = SwitchButton.this.m * h2;
                SwitchButton.this.N.f23171c = ((Integer) SwitchButton.this.f23165i.evaluate(h2, 0, Integer.valueOf(SwitchButton.this.A))).intValue();
            }
            SwitchButton.this.postInvalidate();
        }
    };
    private Animator.AnimatorListener ah = new Animator.AnimatorListener() {
        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            int c2 = SwitchButton.this.R;
            if (c2 == 1) {
                int unused = SwitchButton.this.R = 2;
                SwitchButton.this.N.f23171c = 0;
                SwitchButton.this.N.f23172d = SwitchButton.this.m;
                SwitchButton.this.postInvalidate();
            } else if (c2 == 2) {
            } else {
                if (c2 == 3) {
                    int unused2 = SwitchButton.this.R = 0;
                    SwitchButton.this.postInvalidate();
                } else if (c2 == 4) {
                    int unused3 = SwitchButton.this.R = 0;
                    SwitchButton.this.postInvalidate();
                    SwitchButton.this.b();
                } else if (c2 == 5) {
                    SwitchButton switchButton = SwitchButton.this;
                    boolean unused4 = switchButton.T = !switchButton.T;
                    int unused5 = SwitchButton.this.R = 0;
                    SwitchButton.this.postInvalidate();
                    SwitchButton.this.b();
                }
            }
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final int f23159c = 0;

    /* renamed from: d  reason: collision with root package name */
    private final int f23160d = 1;

    /* renamed from: e  reason: collision with root package name */
    private final int f23161e = 2;

    /* renamed from: f  reason: collision with root package name */
    private final int f23162f = 3;

    /* renamed from: g  reason: collision with root package name */
    private final int f23163g = 4;

    /* renamed from: h  reason: collision with root package name */
    private final int f23164h = 5;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final ArgbEvaluator f23165i = new ArgbEvaluator();
    private int j;
    private int k;
    private int l;
    /* access modifiers changed from: private */
    public float m;
    private float n;
    private float o;
    private float p;
    private float q;
    private float r;
    private float s;
    private float t;
    private float u;
    private float v;
    private int w;
    /* access modifiers changed from: private */
    public int x;
    /* access modifiers changed from: private */
    public int y;
    private int z;

    public interface a {
        void a(boolean z);
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
    }

    public final void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
    }

    public SwitchButton(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        a(context, attributeSet);
    }

    private static float a(float f2) {
        return TypedValue.applyDimension(1, f2, Resources.getSystem().getDisplayMetrics());
    }

    private static int a(TypedArray typedArray, int i2) {
        if (typedArray == null) {
            return 300;
        }
        return typedArray.getInt(i2, 300);
    }

    private static float a(TypedArray typedArray, int i2, float f2) {
        return typedArray == null ? f2 : typedArray.getDimension(i2, f2);
    }

    private static int a(TypedArray typedArray, int i2, int i3) {
        return typedArray == null ? i3 : typedArray.getDimensionPixelOffset(i2, i3);
    }

    private static int b(TypedArray typedArray, int i2, int i3) {
        return typedArray == null ? i3 : typedArray.getColor(i2, i3);
    }

    private static boolean a(TypedArray typedArray, int i2, boolean z2) {
        return typedArray == null ? z2 : typedArray.getBoolean(i2, z2);
    }

    public final void setPadding(int i2, int i3, int i4, int i5) {
        super.setPadding(0, 0, 0, 0);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = attributeSet != null ? context.obtainStyledAttributes(attributeSet, R.styleable.SwitchButton) : null;
        this.V = a(obtainStyledAttributes, R.styleable.SwitchButton_sb_shadow_effect, true);
        this.D = b(obtainStyledAttributes, R.styleable.SwitchButton_sb_uncheckcircle_color, -5592406);
        this.E = a(obtainStyledAttributes, R.styleable.SwitchButton_sb_uncheckcircle_width, (int) a(1.5f));
        this.F = a(10.0f);
        this.G = a(obtainStyledAttributes, R.styleable.SwitchButton_sb_uncheckcircle_radius, a(4.0f));
        this.H = a(4.0f);
        this.I = a(4.0f);
        this.j = a(obtainStyledAttributes, R.styleable.SwitchButton_sb_shadow_radius, (int) a(2.5f));
        this.k = a(obtainStyledAttributes, R.styleable.SwitchButton_sb_shadow_offset, (int) a(1.5f));
        this.l = b(obtainStyledAttributes, R.styleable.SwitchButton_sb_shadow_color, 855638016);
        this.x = b(obtainStyledAttributes, R.styleable.SwitchButton_sb_uncheck_color, -2236963);
        this.y = b(obtainStyledAttributes, R.styleable.SwitchButton_sb_checked_color, -11414681);
        this.z = a(obtainStyledAttributes, R.styleable.SwitchButton_sb_border_width, (int) a(1.0f));
        this.A = b(obtainStyledAttributes, R.styleable.SwitchButton_sb_checkline_color, -1);
        this.B = a(obtainStyledAttributes, R.styleable.SwitchButton_sb_checkline_width, (int) a(1.0f));
        this.C = a(6.0f);
        int b2 = b(obtainStyledAttributes, R.styleable.SwitchButton_sb_button_color, -1);
        int a2 = a(obtainStyledAttributes, R.styleable.SwitchButton_sb_effect_duration);
        this.T = a(obtainStyledAttributes, R.styleable.SwitchButton_sb_checked, false);
        this.W = a(obtainStyledAttributes, R.styleable.SwitchButton_sb_show_indicator, true);
        this.w = b(obtainStyledAttributes, R.styleable.SwitchButton_sb_background, -1);
        this.U = a(obtainStyledAttributes, R.styleable.SwitchButton_sb_enable_effect, true);
        if (obtainStyledAttributes != null) {
            obtainStyledAttributes.recycle();
        }
        this.M = new Paint(1);
        this.L = new Paint(1);
        this.L.setColor(b2);
        if (this.V) {
            this.L.setShadowLayer((float) this.j, 0.0f, (float) this.k, this.l);
        }
        this.N = new b();
        this.O = new b();
        this.P = new b();
        this.S = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.S.setDuration((long) a2);
        this.S.setRepeatCount(0);
        this.S.addUpdateListener(this.ag);
        this.S.addListener(this.ah);
        super.setClickable(true);
        setPadding(0, 0, 0, 0);
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, (Paint) null);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        if (mode == 0 || mode == Integer.MIN_VALUE) {
            i2 = View.MeasureSpec.makeMeasureSpec(f23157a, 1073741824);
        }
        if (mode2 == 0 || mode2 == Integer.MIN_VALUE) {
            i3 = View.MeasureSpec.makeMeasureSpec(f23158b, 1073741824);
        }
        super.onMeasure(i2, i3);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        float max = (float) Math.max(this.j + this.k, this.z);
        float f2 = ((float) i3) - max;
        this.o = f2 - max;
        float f3 = ((float) i2) - max;
        this.p = f3 - max;
        this.m = this.o * 0.5f;
        float f4 = this.m;
        this.n = f4 - ((float) this.z);
        this.q = max;
        this.r = max;
        this.s = f3;
        this.t = f2;
        float f5 = this.q;
        float f6 = this.s;
        this.u = (f5 + f6) * 0.5f;
        this.v = (this.r + this.t) * 0.5f;
        this.J = f5 + f4;
        this.K = f6 - f4;
        if (isChecked()) {
            setCheckedViewState(this.N);
        } else {
            setUncheckViewState(this.N);
        }
        this.ab = true;
        postInvalidate();
    }

    private void setUncheckViewState(b bVar) {
        bVar.f23172d = 0.0f;
        bVar.f23170b = this.x;
        bVar.f23171c = 0;
        bVar.f23169a = this.J;
    }

    private void setCheckedViewState(b bVar) {
        bVar.f23172d = this.m;
        bVar.f23170b = this.y;
        bVar.f23171c = this.A;
        bVar.f23169a = this.K;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Canvas canvas2;
        Canvas canvas3 = canvas;
        super.onDraw(canvas);
        this.M.setStrokeWidth((float) this.z);
        this.M.setStyle(Paint.Style.FILL);
        this.M.setColor(this.w);
        a(canvas, this.q, this.r, this.s, this.t, this.m, this.M);
        this.M.setStyle(Paint.Style.STROKE);
        this.M.setColor(this.x);
        a(canvas, this.q, this.r, this.s, this.t, this.m, this.M);
        if (this.W) {
            int i2 = this.D;
            float f2 = this.s - this.F;
            float f3 = this.v;
            float f4 = this.G;
            Paint paint = this.M;
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(i2);
            paint.setStrokeWidth((float) this.E);
            canvas3.drawCircle(f2, f3, f4, paint);
        }
        float f5 = this.N.f23172d * 0.5f;
        this.M.setStyle(Paint.Style.STROKE);
        this.M.setColor(this.N.f23170b);
        this.M.setStrokeWidth(((float) this.z) + (f5 * 2.0f));
        a(canvas, this.q + f5, this.r + f5, this.s - f5, this.t - f5, this.m, this.M);
        this.M.setStyle(Paint.Style.FILL);
        this.M.setStrokeWidth(1.0f);
        float f6 = this.q;
        float f7 = this.r;
        float f8 = this.m;
        float f9 = f6 + (f8 * 2.0f);
        float f10 = f7 + (f8 * 2.0f);
        Paint paint2 = this.M;
        if (Build.VERSION.SDK_INT >= 21) {
            canvas2 = canvas3;
            canvas.drawArc(f6, f7, f9, f10, 90.0f, 180.0f, true, paint2);
        } else {
            canvas2 = canvas3;
            this.Q.set(f6, f7, f9, f10);
            canvas.drawArc(this.Q, 90.0f, 180.0f, true, paint2);
        }
        Canvas canvas4 = canvas;
        canvas4.drawRect(this.m + this.q, this.r, this.N.f23169a, (this.m * 2.0f) + this.r, this.M);
        if (this.W) {
            int i3 = this.N.f23171c;
            float f11 = this.q;
            float f12 = this.m;
            float f13 = (f11 + f12) - this.H;
            float f14 = this.v;
            float f15 = this.C;
            float f16 = f14 - f15;
            float f17 = (f11 + f12) - this.I;
            float f18 = f14 + f15;
            Paint paint3 = this.M;
            paint3.setStyle(Paint.Style.STROKE);
            paint3.setColor(i3);
            paint3.setStrokeWidth((float) this.B);
            canvas.drawLine(f13, f16, f17, f18, paint3);
        }
        float f19 = this.N.f23169a;
        float f20 = this.v;
        canvas2.drawCircle(f19, f20, this.n, this.L);
        this.M.setStyle(Paint.Style.STROKE);
        this.M.setStrokeWidth(1.0f);
        this.M.setColor(-2236963);
        canvas2.drawCircle(f19, f20, this.n, this.M);
    }

    private void a(Canvas canvas, float f2, float f3, float f4, float f5, float f6, Paint paint) {
        if (Build.VERSION.SDK_INT >= 21) {
            canvas.drawRoundRect(f2, f3, f4, f5, f6, f6, paint);
            return;
        }
        this.Q.set(f2, f3, f4, f5);
        canvas.drawRoundRect(this.Q, f6, f6, paint);
    }

    public boolean isChecked() {
        return this.T;
    }

    public void setChecked(boolean z2) {
        if (z2 == isChecked()) {
            postInvalidate();
        } else {
            a(this.U, false);
        }
    }

    public final void a() {
        a(true, true);
    }

    private void a(boolean z2, boolean z3) {
        if (isEnabled()) {
            if (this.ac) {
                throw new RuntimeException("should NOT switch the state in method: [onCheckedChanged]!");
            } else if (!this.ab) {
                this.T = !this.T;
                if (z3) {
                    b();
                }
            } else {
                if (this.S.isRunning()) {
                    this.S.cancel();
                }
                if (!this.U || !z2) {
                    this.T = !this.T;
                    if (isChecked()) {
                        setCheckedViewState(this.N);
                    } else {
                        setUncheckViewState(this.N);
                    }
                    postInvalidate();
                    if (z3) {
                        b();
                        return;
                    }
                    return;
                }
                this.R = 5;
                this.O.a(this.N);
                if (isChecked()) {
                    setUncheckViewState(this.P);
                } else {
                    setCheckedViewState(this.P);
                }
                this.S.start();
            }
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        a aVar = this.ad;
        if (aVar != null) {
            this.ac = true;
            aVar.a(isChecked());
        }
        this.ac = false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        if (e() == false) goto L_0x0157;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0108, code lost:
        if (d() != false) goto L_0x010a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r11) {
        /*
            r10 = this;
            boolean r0 = r10.isEnabled()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            int r0 = r11.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L_0x0143
            r3 = 3
            r4 = 1065353216(0x3f800000, float:1.0)
            r5 = 0
            if (r0 == r2) goto L_0x0096
            r6 = 2
            if (r0 == r6) goto L_0x0031
            if (r0 == r3) goto L_0x001c
            goto L_0x0157
        L_0x001c:
            r10.aa = r1
            java.lang.Runnable r11 = r10.af
            r10.removeCallbacks(r11)
            boolean r11 = r10.d()
            if (r11 != 0) goto L_0x010a
            boolean r11 = r10.e()
            if (r11 == 0) goto L_0x0157
            goto L_0x010a
        L_0x0031:
            float r11 = r11.getX()
            boolean r0 = r10.d()
            if (r0 == 0) goto L_0x0057
            int r0 = r10.getWidth()
            float r0 = (float) r0
            float r11 = r11 / r0
            float r11 = java.lang.Math.min(r4, r11)
            float r11 = java.lang.Math.max(r5, r11)
            com.travel.citybus.brts.SwitchButton$b r0 = r10.N
            float r1 = r10.J
            float r3 = r10.K
            float r3 = r3 - r1
            float r3 = r3 * r11
            float r1 = r1 + r3
            r0.f23169a = r1
            goto L_0x0157
        L_0x0057:
            boolean r0 = r10.e()
            if (r0 == 0) goto L_0x0157
            int r0 = r10.getWidth()
            float r0 = (float) r0
            float r11 = r11 / r0
            float r11 = java.lang.Math.min(r4, r11)
            float r11 = java.lang.Math.max(r5, r11)
            com.travel.citybus.brts.SwitchButton$b r0 = r10.N
            float r1 = r10.J
            float r3 = r10.K
            float r3 = r3 - r1
            float r3 = r3 * r11
            float r1 = r1 + r3
            r0.f23169a = r1
            android.animation.ArgbEvaluator r1 = r10.f23165i
            int r3 = r10.x
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            int r4 = r10.y
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.Object r11 = r1.evaluate(r11, r3, r4)
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            r0.f23170b = r11
            r10.postInvalidate()
            goto L_0x0157
        L_0x0096:
            r10.aa = r1
            java.lang.Runnable r0 = r10.af
            r10.removeCallbacks(r0)
            long r6 = java.lang.System.currentTimeMillis()
            long r8 = r10.ae
            long r6 = r6 - r8
            r8 = 300(0x12c, double:1.48E-321)
            int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r0 > 0) goto L_0x00af
            r10.toggle()
            goto L_0x0157
        L_0x00af:
            boolean r0 = r10.e()
            if (r0 == 0) goto L_0x0104
            float r11 = r11.getX()
            int r0 = r10.getWidth()
            float r0 = (float) r0
            float r11 = r11 / r0
            float r11 = java.lang.Math.min(r4, r11)
            float r11 = java.lang.Math.max(r5, r11)
            r0 = 1056964608(0x3f000000, float:0.5)
            int r11 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
            if (r11 <= 0) goto L_0x00ce
            r1 = 1
        L_0x00ce:
            boolean r11 = r10.isChecked()
            if (r1 == r11) goto L_0x010a
            r10.T = r1
            android.animation.ValueAnimator r11 = r10.S
            boolean r11 = r11.isRunning()
            if (r11 == 0) goto L_0x00e3
            android.animation.ValueAnimator r11 = r10.S
            r11.cancel()
        L_0x00e3:
            r11 = 4
            r10.R = r11
            com.travel.citybus.brts.SwitchButton$b r11 = r10.O
            com.travel.citybus.brts.SwitchButton$b r0 = r10.N
            r11.a(r0)
            boolean r11 = r10.isChecked()
            if (r11 == 0) goto L_0x00f9
            com.travel.citybus.brts.SwitchButton$b r11 = r10.P
            r10.setCheckedViewState(r11)
            goto L_0x00fe
        L_0x00f9:
            com.travel.citybus.brts.SwitchButton$b r11 = r10.P
            r10.setUncheckViewState(r11)
        L_0x00fe:
            android.animation.ValueAnimator r11 = r10.S
            r11.start()
            goto L_0x0157
        L_0x0104:
            boolean r11 = r10.d()
            if (r11 == 0) goto L_0x0157
        L_0x010a:
            boolean r11 = r10.e()
            if (r11 != 0) goto L_0x0116
            boolean r11 = r10.d()
            if (r11 == 0) goto L_0x0157
        L_0x0116:
            android.animation.ValueAnimator r11 = r10.S
            boolean r11 = r11.isRunning()
            if (r11 == 0) goto L_0x0123
            android.animation.ValueAnimator r11 = r10.S
            r11.cancel()
        L_0x0123:
            r10.R = r3
            com.travel.citybus.brts.SwitchButton$b r11 = r10.O
            com.travel.citybus.brts.SwitchButton$b r0 = r10.N
            r11.a(r0)
            boolean r11 = r10.isChecked()
            if (r11 == 0) goto L_0x0138
            com.travel.citybus.brts.SwitchButton$b r11 = r10.P
            r10.setCheckedViewState(r11)
            goto L_0x013d
        L_0x0138:
            com.travel.citybus.brts.SwitchButton$b r11 = r10.P
            r10.setUncheckViewState(r11)
        L_0x013d:
            android.animation.ValueAnimator r11 = r10.S
            r11.start()
            goto L_0x0157
        L_0x0143:
            r10.aa = r2
            long r0 = java.lang.System.currentTimeMillis()
            r10.ae = r0
            java.lang.Runnable r11 = r10.af
            r10.removeCallbacks(r11)
            java.lang.Runnable r11 = r10.af
            r0 = 100
            r10.postDelayed(r11, r0)
        L_0x0157:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.citybus.brts.SwitchButton.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: private */
    public boolean c() {
        return this.R != 0;
    }

    private boolean d() {
        int i2 = this.R;
        return i2 == 1 || i2 == 3;
    }

    private boolean e() {
        return this.R == 2;
    }

    public void setShadowEffect(boolean z2) {
        if (this.V != z2) {
            this.V = z2;
            if (this.V) {
                this.L.setShadowLayer((float) this.j, 0.0f, (float) this.k, this.l);
            } else {
                this.L.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    public void setEnableEffect(boolean z2) {
        this.U = z2;
    }

    public void setOnCheckedChangeListener(a aVar) {
        this.ad = aVar;
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        float f23169a;

        /* renamed from: b  reason: collision with root package name */
        int f23170b;

        /* renamed from: c  reason: collision with root package name */
        int f23171c;

        /* renamed from: d  reason: collision with root package name */
        float f23172d;

        b() {
        }

        /* access modifiers changed from: package-private */
        public final void a(b bVar) {
            this.f23169a = bVar.f23169a;
            this.f23170b = bVar.f23170b;
            this.f23171c = bVar.f23171c;
            this.f23172d = bVar.f23172d;
        }
    }

    public void toggle() {
        a(true, true);
    }

    static /* synthetic */ void b(SwitchButton switchButton) {
        if (!switchButton.c() && switchButton.aa) {
            if (switchButton.S.isRunning()) {
                switchButton.S.cancel();
            }
            switchButton.R = 1;
            switchButton.O.a(switchButton.N);
            switchButton.P.a(switchButton.N);
            if (switchButton.isChecked()) {
                b bVar = switchButton.P;
                int i2 = switchButton.y;
                bVar.f23170b = i2;
                bVar.f23169a = switchButton.K;
                bVar.f23171c = i2;
            } else {
                b bVar2 = switchButton.P;
                bVar2.f23170b = switchButton.x;
                bVar2.f23169a = switchButton.J;
                bVar2.f23172d = switchButton.m;
            }
            switchButton.S.start();
        }
    }
}
