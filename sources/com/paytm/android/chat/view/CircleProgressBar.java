package com.paytm.android.chat.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.paytm.android.chat.R;
import com.paytm.android.chat.utils.DensityUtil;
import java.lang.reflect.Field;

public class CircleProgressBar extends ProgressBar {

    /* renamed from: a  reason: collision with root package name */
    private final RectF f42479a;

    /* renamed from: b  reason: collision with root package name */
    private final Rect f42480b;

    /* renamed from: c  reason: collision with root package name */
    private final Paint f42481c;

    /* renamed from: d  reason: collision with root package name */
    private final Paint f42482d;

    /* renamed from: e  reason: collision with root package name */
    private final Paint f42483e;

    /* renamed from: f  reason: collision with root package name */
    private final Paint f42484f;

    /* renamed from: g  reason: collision with root package name */
    private float f42485g;

    /* renamed from: h  reason: collision with root package name */
    private float f42486h;

    /* renamed from: i  reason: collision with root package name */
    private float f42487i;
    private int j;
    private int k;
    private float l;
    private float m;
    private float n;
    private int o;
    private int p;
    private int q;
    private int r;
    private boolean s;
    private String t;
    private int u;
    private int v;
    private Paint.Cap w;

    public CircleProgressBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f42479a = new RectF();
        this.f42480b = new Rect();
        this.f42481c = new Paint(1);
        this.f42482d = new Paint(1);
        this.f42483e = new Paint(1);
        this.f42484f = new Paint(1);
        try {
            Field declaredField = ProgressBar.class.getDeclaredField("mOnlyIndeterminate");
            declaredField.setAccessible(true);
            declaredField.set(this, Boolean.FALSE);
            Field declaredField2 = ProgressBar.class.getDeclaredField("mIndeterminate");
            declaredField2.setAccessible(true);
            declaredField2.set(this, Boolean.FALSE);
            Field declaredField3 = ProgressBar.class.getDeclaredField("mCurrentDrawable");
            declaredField3.setAccessible(true);
            declaredField3.set(this, (Object) null);
        } catch (IllegalAccessException | NoSuchFieldException unused) {
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CircleProgressBar);
        this.j = obtainStyledAttributes.getColor(R.styleable.CircleProgressBar_background_color, 0);
        this.s = obtainStyledAttributes.getBoolean(R.styleable.CircleProgressBar_draw_progress_text, true);
        this.k = obtainStyledAttributes.getInt(R.styleable.CircleProgressBar_line_count, 45);
        this.t = obtainStyledAttributes.hasValue(R.styleable.CircleProgressBar_progress_text_format_pattern) ? obtainStyledAttributes.getString(R.styleable.CircleProgressBar_progress_text_format_pattern) : "%d%%";
        this.u = obtainStyledAttributes.getInt(R.styleable.CircleProgressBar_style, 0);
        this.v = obtainStyledAttributes.getInt(R.styleable.CircleProgressBar_progress_shader, 0);
        this.w = obtainStyledAttributes.hasValue(R.styleable.CircleProgressBar_progress_stroke_cap) ? Paint.Cap.values()[obtainStyledAttributes.getInt(R.styleable.CircleProgressBar_progress_stroke_cap, 0)] : Paint.Cap.BUTT;
        this.l = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleProgressBar_pb_line_width, DensityUtil.dp2px(4.0f));
        this.n = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleProgressBar_progress_text_size, DensityUtil.dp2px(11.0f));
        this.m = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleProgressBar_progress_stroke_width, DensityUtil.dp2px(1.0f));
        this.o = obtainStyledAttributes.getColor(R.styleable.CircleProgressBar_progress_start_color, Color.parseColor("#fff2a670"));
        this.p = obtainStyledAttributes.getColor(R.styleable.CircleProgressBar_progress_end_color, Color.parseColor("#fff2a670"));
        this.q = obtainStyledAttributes.getColor(R.styleable.CircleProgressBar_progress_text_color, Color.parseColor("#fff2a670"));
        this.r = obtainStyledAttributes.getColor(R.styleable.CircleProgressBar_progress_background_color, Color.parseColor("#ffe3e3e5"));
        obtainStyledAttributes.recycle();
        this.f42484f.setTextAlign(Paint.Align.CENTER);
        this.f42484f.setTextSize(this.n);
        this.f42481c.setStyle(this.u == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.f42481c.setStrokeWidth(this.m);
        this.f42481c.setColor(this.o);
        this.f42481c.setStrokeCap(this.w);
        this.f42482d.setStyle(this.u == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.f42482d.setStrokeWidth(this.m);
        this.f42482d.setColor(this.r);
        this.f42482d.setStrokeCap(this.w);
        this.f42483e.setStyle(Paint.Style.FILL);
        this.f42483e.setColor(this.j);
    }

    /* JADX WARNING: type inference failed for: r1v4, types: [android.graphics.RadialGradient] */
    /* JADX WARNING: type inference failed for: r2v10, types: [android.graphics.Shader, android.graphics.SweepGradient] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a() {
        /*
            r17 = this;
            r0 = r17
            int r5 = r0.o
            int r6 = r0.p
            r1 = 0
            if (r5 == r6) goto L_0x009b
            int r2 = r0.v
            if (r2 == 0) goto L_0x0079
            r3 = 1
            if (r2 == r3) goto L_0x006a
            r4 = 2
            if (r2 == r4) goto L_0x0015
            goto L_0x0095
        L_0x0015:
            float r1 = r0.m
            double r1 = (double) r1
            r5 = 4614256656552045848(0x400921fb54442d18, double:3.141592653589793)
            double r1 = r1 / r5
            r5 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r1 = r1 * r5
            float r5 = r0.f42485g
            double r5 = (double) r5
            double r1 = r1 / r5
            float r1 = (float) r1
            r5 = -4587338432941916160(0xc056800000000000, double:-90.0)
            android.graphics.Paint$Cap r2 = r0.w
            android.graphics.Paint$Cap r7 = android.graphics.Paint.Cap.BUTT
            if (r2 != r7) goto L_0x0039
            int r2 = r0.u
            if (r2 != r4) goto L_0x0039
            r1 = 0
            goto L_0x003e
        L_0x0039:
            double r1 = (double) r1
            double r1 = java.lang.Math.toDegrees(r1)
        L_0x003e:
            double r5 = r5 - r1
            float r1 = (float) r5
            android.graphics.SweepGradient r2 = new android.graphics.SweepGradient
            float r5 = r0.f42486h
            float r6 = r0.f42487i
            int[] r7 = new int[r4]
            r8 = 0
            int r9 = r0.o
            r7[r8] = r9
            int r8 = r0.p
            r7[r3] = r8
            float[] r3 = new float[r4]
            r3 = {0, 1065353216} // fill-array
            r2.<init>(r5, r6, r7, r3)
            android.graphics.Matrix r3 = new android.graphics.Matrix
            r3.<init>()
            float r4 = r0.f42486h
            float r5 = r0.f42487i
            r3.postRotate(r1, r4, r5)
            r2.setLocalMatrix(r3)
            r1 = r2
            goto L_0x0095
        L_0x006a:
            android.graphics.RadialGradient r8 = new android.graphics.RadialGradient
            float r2 = r0.f42486h
            float r3 = r0.f42487i
            float r4 = r0.f42485g
            android.graphics.Shader$TileMode r7 = android.graphics.Shader.TileMode.CLAMP
            r1 = r8
            r1.<init>(r2, r3, r4, r5, r6, r7)
            goto L_0x0095
        L_0x0079:
            android.graphics.LinearGradient r1 = new android.graphics.LinearGradient
            android.graphics.RectF r2 = r0.f42479a
            float r10 = r2.left
            android.graphics.RectF r2 = r0.f42479a
            float r11 = r2.top
            android.graphics.RectF r2 = r0.f42479a
            float r12 = r2.left
            android.graphics.RectF r2 = r0.f42479a
            float r13 = r2.bottom
            int r14 = r0.o
            int r15 = r0.p
            android.graphics.Shader$TileMode r16 = android.graphics.Shader.TileMode.CLAMP
            r9 = r1
            r9.<init>(r10, r11, r12, r13, r14, r15, r16)
        L_0x0095:
            android.graphics.Paint r2 = r0.f42481c
            r2.setShader(r1)
            return
        L_0x009b:
            android.graphics.Paint r2 = r0.f42481c
            r2.setShader(r1)
            android.graphics.Paint r1 = r0.f42481c
            int r2 = r0.o
            r1.setColor(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.view.CircleProgressBar.a():void");
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f42486h = (float) (i2 / 2);
        this.f42487i = (float) (i3 / 2);
        this.f42485g = Math.min(this.f42486h, this.f42487i);
        RectF rectF = this.f42479a;
        float f2 = this.f42487i;
        float f3 = this.f42485g;
        rectF.top = f2 - f3;
        rectF.bottom = f2 + f3;
        float f4 = this.f42486h;
        rectF.left = f4 - f3;
        rectF.right = f4 + f3;
        a();
        RectF rectF2 = this.f42479a;
        float f5 = this.m;
        rectF2.inset(f5 / 2.0f, f5 / 2.0f);
    }

    public int getBackgroundColor() {
        return this.j;
    }

    public void setBackgroundColor(int i2) {
        this.j = i2;
        this.f42483e.setColor(i2);
        invalidate();
    }

    public void setProgressTextFormatPattern(String str) {
        this.t = str;
        invalidate();
    }

    public String getProgressTextFormatPattern() {
        return this.t;
    }

    public void setProgressStrokeWidth(float f2) {
        this.m = f2;
        RectF rectF = this.f42479a;
        float f3 = this.m;
        rectF.inset(f3 / 2.0f, f3 / 2.0f);
        invalidate();
    }

    public float getProgressStrokeWidth() {
        return this.m;
    }

    public void setProgressTextSize(float f2) {
        this.n = f2;
        invalidate();
    }

    public float getProgressTextSize() {
        return this.n;
    }

    public void setProgressStartColor(int i2) {
        this.o = i2;
        a();
        invalidate();
    }

    public int getProgressStartColor() {
        return this.o;
    }

    public void setProgressEndColor(int i2) {
        this.p = i2;
        a();
        invalidate();
    }

    public int getProgressEndColor() {
        return this.p;
    }

    public void setProgressTextColor(int i2) {
        this.q = i2;
        invalidate();
    }

    public int getProgressTextColor() {
        return this.q;
    }

    public void setProgressBackgroundColor(int i2) {
        this.r = i2;
        this.f42482d.setColor(this.r);
        invalidate();
    }

    public int getProgressBackgroundColor() {
        return this.r;
    }

    public int getLineCount() {
        return this.k;
    }

    public void setLineCount(int i2) {
        this.k = i2;
        invalidate();
    }

    public float getLineWidth() {
        return this.l;
    }

    public void setLineWidth(float f2) {
        this.l = f2;
        invalidate();
    }

    public int getStyle() {
        return this.u;
    }

    public void setStyle(int i2) {
        this.u = i2;
        this.f42481c.setStyle(this.u == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.f42482d.setStyle(this.u == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        invalidate();
    }

    public int getShader() {
        return this.v;
    }

    public void setShader(int i2) {
        this.v = i2;
        a();
        invalidate();
    }

    public Paint.Cap getCap() {
        return this.w;
    }

    public void setCap(Paint.Cap cap) {
        this.w = cap;
        this.f42481c.setStrokeCap(cap);
        this.f42482d.setStrokeCap(cap);
        invalidate();
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        Canvas canvas2 = canvas;
        synchronized (this) {
            if (this.j != 0) {
                canvas2.drawCircle(this.f42486h, this.f42486h, this.f42485g, this.f42483e);
            }
            int i2 = this.u;
            if (i2 == 1) {
                canvas.drawArc(this.f42479a, -90.0f, 360.0f, false, this.f42482d);
                canvas.drawArc(this.f42479a, -90.0f, (((float) getProgress()) * 360.0f) / ((float) getMax()), true, this.f42481c);
            } else if (i2 != 2) {
                float f2 = (float) (6.283185307179586d / ((double) this.k));
                float f3 = this.f42485g;
                float f4 = this.f42485g - this.l;
                int progress = (int) ((((float) getProgress()) / ((float) getMax())) * ((float) this.k));
                for (int i3 = 0; i3 < this.k; i3++) {
                    double d2 = (double) (((float) i3) * f2);
                    float sin = this.f42486h + (((float) Math.sin(d2)) * f4);
                    float cos = this.f42486h - (((float) Math.cos(d2)) * f4);
                    float sin2 = (((float) Math.sin(d2)) * f3) + this.f42486h;
                    float cos2 = this.f42486h - (((float) Math.cos(d2)) * f3);
                    if (i3 < progress) {
                        canvas.drawLine(sin, cos, sin2, cos2, this.f42481c);
                    } else {
                        canvas.drawLine(sin, cos, sin2, cos2, this.f42482d);
                    }
                }
            } else {
                canvas.drawArc(this.f42479a, -90.0f, 360.0f, false, this.f42482d);
                canvas.drawArc(this.f42479a, -90.0f, (((float) getProgress()) * 360.0f) / ((float) getMax()), false, this.f42481c);
            }
            if (this.s) {
                String format = String.format(this.t, new Object[]{Integer.valueOf(getProgress())});
                this.f42484f.setTextSize(this.n);
                this.f42484f.setColor(this.q);
                this.f42484f.getTextBounds(format, 0, format.length(), this.f42480b);
                canvas2.drawText(format, this.f42486h, this.f42487i + ((float) (this.f42480b.height() / 2)), this.f42484f);
            }
        }
    }
}
