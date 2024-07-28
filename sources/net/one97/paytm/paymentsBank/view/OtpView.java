package net.one97.paytm.paymentsBank.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.b.f;
import androidx.core.h.u;
import net.one97.paytm.paymentsBank.R;

public class OtpView extends AppCompatEditText {

    /* renamed from: a  reason: collision with root package name */
    private static final InputFilter[] f19608a = new InputFilter[0];

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f19609b = {16842913};
    private int A;
    private Drawable B;
    private boolean C;
    private b D;

    /* renamed from: c  reason: collision with root package name */
    private int f19610c;

    /* renamed from: d  reason: collision with root package name */
    private int f19611d;

    /* renamed from: e  reason: collision with root package name */
    private int f19612e;

    /* renamed from: f  reason: collision with root package name */
    private int f19613f;

    /* renamed from: g  reason: collision with root package name */
    private int f19614g;

    /* renamed from: h  reason: collision with root package name */
    private int f19615h;

    /* renamed from: i  reason: collision with root package name */
    private final Paint f19616i;
    private final TextPaint j;
    private ColorStateList k;
    private int l;
    private int m;
    private final Rect n;
    private final RectF o;
    private final RectF p;
    private final Path q;
    private final PointF r;
    private ValueAnimator s;
    private boolean t;
    private a u;
    private boolean v;
    /* access modifiers changed from: private */
    public boolean w;
    private float x;
    private int y;
    private int z;

    public OtpView(Context context) {
        this(context, (AttributeSet) null);
    }

    public OtpView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.otpViewStyle);
    }

    public OtpView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.j = new TextPaint();
        this.l = -16777216;
        this.n = new Rect();
        this.o = new RectF();
        this.p = new RectF();
        this.q = new Path();
        this.r = new PointF();
        this.t = false;
        Resources resources = getResources();
        this.f19616i = new Paint(1);
        this.f19616i.setStyle(Paint.Style.STROKE);
        this.j.set(getPaint());
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.OtpView, i2, 0);
        this.f19610c = obtainStyledAttributes.getInt(R.styleable.OtpView_viewType, 0);
        this.f19611d = obtainStyledAttributes.getInt(R.styleable.OtpView_itemCount, 4);
        this.f19613f = (int) obtainStyledAttributes.getDimension(R.styleable.OtpView_itemHeight, (float) resources.getDimensionPixelSize(R.dimen.otp_view_item_size));
        this.f19612e = (int) obtainStyledAttributes.getDimension(R.styleable.OtpView_itemWidth, (float) resources.getDimensionPixelSize(R.dimen.otp_view_item_size));
        this.f19615h = obtainStyledAttributes.getDimensionPixelSize(R.styleable.OtpView_itemSpacing, resources.getDimensionPixelSize(R.dimen.otp_view_item_spacing));
        this.f19614g = (int) obtainStyledAttributes.getDimension(R.styleable.OtpView_itemRadius, 0.0f);
        this.m = (int) obtainStyledAttributes.getDimension(R.styleable.OtpView_lineWidth, (float) resources.getDimensionPixelSize(R.dimen.otp_view_item_line_width));
        this.k = obtainStyledAttributes.getColorStateList(R.styleable.OtpView_lineColor);
        this.v = obtainStyledAttributes.getBoolean(R.styleable.OtpView_android_cursorVisible, true);
        this.z = obtainStyledAttributes.getColor(R.styleable.OtpView_cursorColor, getCurrentTextColor());
        this.y = obtainStyledAttributes.getDimensionPixelSize(R.styleable.OtpView_cursorWidth, resources.getDimensionPixelSize(R.dimen.otp_view_cursor_width));
        this.B = obtainStyledAttributes.getDrawable(R.styleable.OtpView_android_itemBackground);
        this.C = obtainStyledAttributes.getBoolean(R.styleable.OtpView_hideLineWhenFilled, false);
        obtainStyledAttributes.recycle();
        ColorStateList colorStateList = this.k;
        if (colorStateList != null) {
            this.l = colorStateList.getDefaultColor();
        }
        i();
        a();
        setMaxLength(this.f19611d);
        this.f19616i.setStrokeWidth((float) this.m);
        this.s = ValueAnimator.ofFloat(new float[]{0.5f, 1.0f});
        this.s.setDuration(150);
        this.s.setInterpolator(new DecelerateInterpolator());
        this.s.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                OtpView.this.a(valueAnimator);
            }
        });
        super.setCursorVisible(false);
        setTextIsSelectable(false);
    }

    public void setTypeface(Typeface typeface, int i2) {
        super.setTypeface(typeface, i2);
    }

    public void setTypeface(Typeface typeface) {
        super.setTypeface(typeface);
        TextPaint textPaint = this.j;
        if (textPaint != null) {
            textPaint.set(getPaint());
        }
    }

    private void setMaxLength(int i2) {
        setFilters(i2 >= 0 ? new InputFilter[]{new InputFilter.LengthFilter(i2)} : f19608a);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.j.setTextSize(getTextSize() * floatValue);
        this.j.setAlpha((int) (255.0f * floatValue));
        postInvalidate();
    }

    private void a() {
        int i2 = this.f19610c;
        if (i2 == 1) {
            if (((float) this.f19614g) > ((float) this.m) / 2.0f) {
                throw new IllegalArgumentException("The itemRadius can not be greater than lineWidth when viewType is line");
            }
        } else if (i2 == 0) {
            if (((float) this.f19614g) > ((float) this.f19612e) / 2.0f) {
                throw new IllegalArgumentException("The itemRadius can not be greater than itemWidth");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int i4 = this.f19613f;
        if (mode != 1073741824) {
            int i5 = this.f19611d;
            size = u.m(this) + ((i5 - 1) * this.f19615h) + (i5 * this.f19612e) + u.n(this);
            if (this.f19615h == 0) {
                size -= (this.f19611d - 1) * this.m;
            }
        }
        if (mode2 != 1073741824) {
            size2 = getPaddingBottom() + i4 + getPaddingTop();
        }
        setMeasuredDimension(size, size2);
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        ValueAnimator valueAnimator;
        if (i2 != charSequence.length()) {
            b();
        }
        if (charSequence.length() == this.f19611d && this.D != null) {
            charSequence.toString();
        }
        f();
        if (this.t) {
            if ((i4 - i3 > 0) && (valueAnimator = this.s) != null) {
                valueAnimator.end();
                this.s.start();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z2, int i2, Rect rect) {
        super.onFocusChanged(z2, i2, rect);
        if (z2) {
            b();
            f();
        }
    }

    /* access modifiers changed from: protected */
    public void onSelectionChanged(int i2, int i3) {
        super.onSelectionChanged(i2, i3);
        if (i3 != getText().length()) {
            b();
        }
    }

    public String getOtp() {
        return getText().toString();
    }

    private void b() {
        setSelection(getText().length());
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        ColorStateList colorStateList = this.k;
        if (colorStateList == null || colorStateList.isStateful()) {
            c();
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i2;
        canvas.save();
        this.f19616i.setColor(this.l);
        this.f19616i.setStyle(Paint.Style.STROKE);
        this.f19616i.setStrokeWidth((float) this.m);
        getPaint().setColor(getCurrentTextColor());
        int length = getText().length();
        int i3 = 0;
        while (i3 < this.f19611d) {
            boolean z5 = true;
            boolean z6 = isFocused() && length == i3;
            this.f19616i.setColor(z6 ? a(f19609b) : this.l);
            b(i3);
            d();
            canvas.save();
            if (this.f19610c == 0) {
                a(i3);
                canvas.clipPath(this.q);
            }
            if (this.B != null) {
                float f2 = ((float) this.m) / 2.0f;
                this.B.setBounds(Math.round(this.o.left - f2), Math.round(this.o.top - f2), Math.round(this.o.right + f2), Math.round(this.o.bottom + f2));
                this.B.setState(z6 ? f19609b : getDrawableState());
                this.B.draw(canvas);
            }
            canvas.restore();
            if (z6 && this.w) {
                float f3 = this.r.x;
                float f4 = this.r.y - (this.x / 2.0f);
                int color = this.f19616i.getColor();
                float strokeWidth = this.f19616i.getStrokeWidth();
                this.f19616i.setColor(this.z);
                this.f19616i.setStrokeWidth((float) this.y);
                canvas.drawLine(f3, f4, f3, f4 + this.x, this.f19616i);
                this.f19616i.setColor(color);
                this.f19616i.setStrokeWidth(strokeWidth);
            }
            int i4 = this.f19610c;
            if (i4 == 0) {
                a(canvas, i3);
            } else if (i4 == 1 && (!this.C || i3 >= getText().length())) {
                if (this.f19615h != 0 || (i2 = this.f19611d) <= 1) {
                    z4 = true;
                } else {
                    if (i3 == 0) {
                        z3 = true;
                    } else if (i3 == i2 - 1) {
                        z4 = false;
                    } else {
                        z3 = false;
                    }
                    z2 = false;
                    this.f19616i.setStyle(Paint.Style.FILL);
                    this.f19616i.setStrokeWidth(((float) this.m) / 10.0f);
                    float f5 = ((float) this.m) / 2.0f;
                    this.p.set(this.o.left - f5, this.o.bottom - f5, this.o.right + f5, this.o.bottom + f5);
                    RectF rectF = this.p;
                    int i5 = this.f19614g;
                    a(rectF, (float) i5, (float) i5, z3, z2);
                    canvas.drawPath(this.q, this.f19616i);
                }
                z2 = true;
                this.f19616i.setStyle(Paint.Style.FILL);
                this.f19616i.setStrokeWidth(((float) this.m) / 10.0f);
                float f52 = ((float) this.m) / 2.0f;
                this.p.set(this.o.left - f52, this.o.bottom - f52, this.o.right + f52, this.o.bottom + f52);
                RectF rectF2 = this.p;
                int i52 = this.f19614g;
                a(rectF2, (float) i52, (float) i52, z3, z2);
                canvas.drawPath(this.q, this.f19616i);
            }
            if (getText().length() > i3) {
                int inputType = getInputType() & 4095;
                if (!(inputType == 129 || inputType == 225 || inputType == 18)) {
                    z5 = false;
                }
                if (z5) {
                    Paint c2 = c(i3);
                    canvas.drawCircle(this.r.x, this.r.y, c2.getTextSize() / 2.0f, c2);
                } else {
                    a(canvas, c(i3), getText(), i3);
                }
            } else if (!TextUtils.isEmpty(getHint()) && getHint().length() == this.f19611d) {
                Paint c3 = c(i3);
                c3.setColor(getCurrentHintTextColor());
                a(canvas, c3, getHint(), i3);
            }
            i3++;
        }
        if (isFocused() && getText().length() != this.f19611d && this.f19610c == 0) {
            int length2 = getText().length();
            b(length2);
            d();
            a(length2);
            this.f19616i.setColor(a(f19609b));
            a(canvas, length2);
        }
        canvas.restore();
    }

    private int a(int... iArr) {
        ColorStateList colorStateList = this.k;
        return colorStateList != null ? colorStateList.getColorForState(iArr, this.l) : this.l;
    }

    private void a(int i2) {
        boolean z2;
        boolean z3;
        if (this.f19615h != 0) {
            z3 = true;
        } else {
            boolean z4 = i2 == 0 && i2 != this.f19611d - 1;
            if (i2 != this.f19611d - 1 || i2 == 0) {
                z3 = z4;
                z2 = false;
                RectF rectF = this.o;
                int i3 = this.f19614g;
                a(rectF, (float) i3, (float) i3, z3, z2);
            }
            z3 = z4;
        }
        z2 = true;
        RectF rectF2 = this.o;
        int i32 = this.f19614g;
        a(rectF2, (float) i32, (float) i32, z3, z2);
    }

    private void a(Canvas canvas, int i2) {
        if (!this.C || i2 >= getText().length()) {
            canvas.drawPath(this.q, this.f19616i);
        }
    }

    private void a(RectF rectF, float f2, float f3, boolean z2, boolean z3) {
        a(rectF, f2, f3, z2, z3, z3, z2);
    }

    private void a(RectF rectF, float f2, float f3, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.q.reset();
        float f4 = rectF.left;
        float f5 = rectF.top;
        float f6 = (rectF.right - f4) - (f2 * 2.0f);
        float f7 = (rectF.bottom - f5) - (2.0f * f3);
        this.q.moveTo(f4, f5 + f3);
        if (z2) {
            float f8 = -f3;
            this.q.rQuadTo(0.0f, f8, f2, f8);
        } else {
            this.q.rLineTo(0.0f, -f3);
            this.q.rLineTo(f2, 0.0f);
        }
        this.q.rLineTo(f6, 0.0f);
        if (z3) {
            this.q.rQuadTo(f2, 0.0f, f2, f3);
        } else {
            this.q.rLineTo(f2, 0.0f);
            this.q.rLineTo(0.0f, f3);
        }
        this.q.rLineTo(0.0f, f7);
        if (z4) {
            this.q.rQuadTo(0.0f, f3, -f2, f3);
        } else {
            this.q.rLineTo(0.0f, f3);
            this.q.rLineTo(-f2, 0.0f);
        }
        this.q.rLineTo(-f6, 0.0f);
        if (z5) {
            float f9 = -f2;
            this.q.rQuadTo(f9, 0.0f, f9, -f3);
        } else {
            this.q.rLineTo(-f2, 0.0f);
            this.q.rLineTo(0.0f, -f3);
        }
        this.q.rLineTo(0.0f, -f7);
        this.q.close();
    }

    private void b(int i2) {
        float f2 = ((float) this.m) / 2.0f;
        int scrollX = getScrollX() + u.m(this);
        int i3 = this.f19615h;
        float f3 = ((float) (scrollX + ((this.f19612e + i3) * i2))) + f2;
        if (i3 == 0 && i2 > 0) {
            f3 -= (float) (this.m * i2);
        }
        float f4 = (((float) this.f19612e) + f3) - ((float) this.m);
        float scrollY = ((float) (getScrollY() + getPaddingTop())) + f2;
        this.o.set(f3, scrollY, f4, (((float) this.f19613f) + scrollY) - ((float) this.m));
    }

    private void a(Canvas canvas, Paint paint, CharSequence charSequence, int i2) {
        int i3 = i2 + 1;
        paint.getTextBounds(charSequence.toString(), i2, i3, this.n);
        float f2 = this.r.x;
        float f3 = this.r.y;
        canvas.drawText(charSequence, i2, i3, (f2 - (Math.abs((float) this.n.width()) / 2.0f)) - ((float) this.n.left), (f3 + (Math.abs((float) this.n.height()) / 2.0f)) - ((float) this.n.bottom), paint);
    }

    private Paint c(int i2) {
        if (!this.t || i2 != getText().length() - 1) {
            return getPaint();
        }
        this.j.setColor(getPaint().getColor());
        return this.j;
    }

    private void c() {
        int i2;
        ColorStateList colorStateList = this.k;
        boolean z2 = false;
        if (colorStateList != null) {
            i2 = colorStateList.getColorForState(getDrawableState(), 0);
        } else {
            i2 = getCurrentTextColor();
        }
        if (i2 != this.l) {
            this.l = i2;
            z2 = true;
        }
        if (z2) {
            invalidate();
        }
    }

    private void d() {
        this.r.set(this.o.left + (Math.abs(this.o.width()) / 2.0f), this.o.top + (Math.abs(this.o.height()) / 2.0f));
    }

    /* access modifiers changed from: protected */
    public MovementMethod getDefaultMovementMethod() {
        return a.a();
    }

    public void setLineColor(int i2) {
        this.k = ColorStateList.valueOf(i2);
        c();
    }

    public void setLineColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.k = colorStateList;
            c();
            return;
        }
        throw new IllegalArgumentException("Color cannot be null");
    }

    public ColorStateList getLineColors() {
        return this.k;
    }

    public int getCurrentLineColor() {
        return this.l;
    }

    public void setLineWidth(int i2) {
        this.m = i2;
        a();
        requestLayout();
    }

    public int getLineWidth() {
        return this.m;
    }

    public void setItemCount(int i2) {
        this.f19611d = i2;
        setMaxLength(i2);
        requestLayout();
    }

    public int getItemCount() {
        return this.f19611d;
    }

    public void setItemRadius(int i2) {
        this.f19614g = i2;
        a();
        requestLayout();
    }

    public int getItemRadius() {
        return this.f19614g;
    }

    public void setItemSpacing(int i2) {
        this.f19615h = i2;
        requestLayout();
    }

    public int getItemSpacing() {
        return this.f19615h;
    }

    public void setItemHeight(int i2) {
        this.f19613f = i2;
        i();
        requestLayout();
    }

    public int getItemHeight() {
        return this.f19613f;
    }

    public void setItemWidth(int i2) {
        this.f19612e = i2;
        a();
        requestLayout();
    }

    public int getItemWidth() {
        return this.f19612e;
    }

    public void setAnimationEnable(boolean z2) {
        this.t = z2;
    }

    public void setHideLineWhenFilled(boolean z2) {
        this.C = z2;
    }

    public void setTextSize(float f2) {
        super.setTextSize(f2);
        i();
    }

    public void setTextSize(int i2, float f2) {
        super.setTextSize(i2, f2);
        i();
    }

    public void setOtpCompletionListener(b bVar) {
        this.D = bVar;
    }

    public void setItemBackgroundResources(int i2) {
        if (i2 == 0 || this.A == i2) {
            this.B = f.a(getResources(), i2, getContext().getTheme());
            setItemBackground(this.B);
            this.A = i2;
        }
    }

    public void setItemBackgroundColor(int i2) {
        Drawable drawable = this.B;
        if (drawable instanceof ColorDrawable) {
            ((ColorDrawable) drawable.mutate()).setColor(i2);
            this.A = 0;
            return;
        }
        setItemBackground(new ColorDrawable(i2));
    }

    public void setItemBackground(Drawable drawable) {
        this.A = 0;
        this.B = drawable;
        invalidate();
    }

    public void setCursorWidth(int i2) {
        this.y = i2;
        if (isCursorVisible()) {
            a(true);
        }
    }

    public int getCursorWidth() {
        return this.y;
    }

    public void setCursorColor(int i2) {
        this.z = i2;
        if (isCursorVisible()) {
            a(true);
        }
    }

    public int getCursorColor() {
        return this.z;
    }

    public void setCursorVisible(boolean z2) {
        if (this.v != z2) {
            this.v = z2;
            a(this.v);
            f();
        }
    }

    public boolean isCursorVisible() {
        return this.v;
    }

    public void onScreenStateChanged(int i2) {
        super.onScreenStateChanged(i2);
        if (i2 == 1) {
            h();
        } else if (i2 == 0) {
            g();
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        h();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g();
    }

    /* access modifiers changed from: private */
    public boolean e() {
        return isCursorVisible() && isFocused();
    }

    private void f() {
        if (e()) {
            if (this.u == null) {
                this.u = new a(this, (byte) 0);
            }
            removeCallbacks(this.u);
            this.w = false;
            postDelayed(this.u, 500);
            return;
        }
        a aVar = this.u;
        if (aVar != null) {
            removeCallbacks(aVar);
        }
    }

    private void g() {
        a aVar = this.u;
        if (aVar != null) {
            a.a(aVar);
            a(false);
        }
    }

    private void h() {
        a aVar = this.u;
        if (aVar != null) {
            aVar.f19618b = false;
            f();
        }
    }

    /* access modifiers changed from: private */
    public void a(boolean z2) {
        if (this.w != z2) {
            this.w = z2;
            invalidate();
        }
    }

    private void i() {
        float j2 = (float) (j() * 2);
        this.x = ((float) this.f19613f) - getTextSize() > j2 ? getTextSize() + j2 : getTextSize();
    }

    class a implements Runnable {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public boolean f19618b;

        private a() {
        }

        /* synthetic */ a(OtpView otpView, byte b2) {
            this();
        }

        public final void run() {
            if (!this.f19618b) {
                OtpView.this.removeCallbacks(this);
                if (OtpView.this.e()) {
                    OtpView otpView = OtpView.this;
                    otpView.a(!otpView.w);
                    OtpView.this.postDelayed(this, 500);
                }
            }
        }

        static /* synthetic */ void a(a aVar) {
            if (!aVar.f19618b) {
                OtpView.this.removeCallbacks(aVar);
                aVar.f19618b = true;
            }
        }
    }

    private int j() {
        return (int) ((getResources().getDisplayMetrics().density * 2.0f) + 0.5f);
    }
}
