package org.npci.upi.security.pinactivitycomponent.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.EditText;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import net.one97.paytm.nativesdk.otp.view.PinEntryEditText;
import org.npci.upi.security.pinactivitycomponent.R;

public class FormItemEditText extends EditText {
    private int[][] A = {new int[]{16842913}, new int[]{16842914}, new int[]{16842908}, new int[]{-16842908}};
    private int[] B = {-16711936, -65536, -16777216, -7829368};
    private ColorStateList C = new ColorStateList(this.A, this.B);

    /* renamed from: a  reason: collision with root package name */
    private String f73014a = null;

    /* renamed from: b  reason: collision with root package name */
    private StringBuilder f73015b = null;

    /* renamed from: c  reason: collision with root package name */
    private String f73016c = null;

    /* renamed from: d  reason: collision with root package name */
    private int f73017d = 0;

    /* renamed from: e  reason: collision with root package name */
    private float f73018e = 24.0f;

    /* renamed from: f  reason: collision with root package name */
    private float f73019f;

    /* renamed from: g  reason: collision with root package name */
    private float f73020g = 4.0f;

    /* renamed from: h  reason: collision with root package name */
    private float f73021h = 8.0f;

    /* renamed from: i  reason: collision with root package name */
    private int f73022i = 4;
    private RectF[] j;
    /* access modifiers changed from: private */
    public float[] k;
    private Paint l;
    /* access modifiers changed from: private */
    public Paint m;
    private Paint n;
    private Drawable o;
    private Rect p = new Rect();
    private boolean q = false;
    /* access modifiers changed from: private */
    public View.OnClickListener r;
    /* access modifiers changed from: private */
    public i s = null;
    private boolean t;
    private float u = 1.0f;
    private float v = 2.0f;
    private Paint w;
    private boolean x = false;
    private boolean y = false;
    private ColorStateList z;

    public FormItemEditText(Context context) {
        super(context);
    }

    public FormItemEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public FormItemEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }

    public FormItemEditText(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        a(context, attributeSet);
    }

    private int a(int... iArr) {
        return this.C.getColorForState(iArr, -7829368);
    }

    /* JADX INFO: finally extract failed */
    private void a(Context context, AttributeSet attributeSet) {
        this.u = (float) a(this.u);
        this.v = (float) a(this.v);
        this.f73018e = (float) a(this.f73018e);
        this.f73021h = (float) a(this.f73021h);
        boolean z2 = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FormItemEditText, 0, 0);
        try {
            TypedValue typedValue = new TypedValue();
            obtainStyledAttributes.getValue(R.styleable.FormItemEditText_pinAnimationType, typedValue);
            this.f73017d = typedValue.data;
            this.f73014a = obtainStyledAttributes.getString(R.styleable.FormItemEditText_pinCharacterMask);
            this.f73016c = obtainStyledAttributes.getString(R.styleable.FormItemEditText_pinRepeatedHint);
            this.u = obtainStyledAttributes.getDimension(R.styleable.FormItemEditText_pinLineStroke, this.u);
            this.v = obtainStyledAttributes.getDimension(R.styleable.FormItemEditText_pinLineStrokeSelected, this.v);
            this.t = obtainStyledAttributes.getBoolean(R.styleable.FormItemEditText_pinLineStrokeCentered, false);
            this.f73019f = obtainStyledAttributes.getDimension(R.styleable.FormItemEditText_pinCharacterSize, 0.0f);
            this.f73018e = obtainStyledAttributes.getDimension(R.styleable.FormItemEditText_pinCharacterSpacing, this.f73018e);
            this.f73021h = obtainStyledAttributes.getDimension(R.styleable.FormItemEditText_pinTextBottomPadding, this.f73021h);
            this.q = obtainStyledAttributes.getBoolean(R.styleable.FormItemEditText_pinBackgroundIsSquare, this.q);
            this.o = obtainStyledAttributes.getDrawable(R.styleable.FormItemEditText_pinBackgroundDrawable);
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(R.styleable.FormItemEditText_pinLineColors);
            if (colorStateList != null) {
                this.C = colorStateList;
            }
            obtainStyledAttributes.recycle();
            this.l = new Paint(getPaint());
            this.m = new Paint(getPaint());
            this.n = new Paint(getPaint());
            this.w = new Paint(getPaint());
            this.w.setStrokeWidth(this.u);
            setFontSize(this.f73019f);
            TypedValue typedValue2 = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.colorControlActivated, typedValue2, true);
            int i2 = typedValue2.data;
            int[] iArr = this.B;
            iArr[0] = i2;
            iArr[1] = -7829368;
            iArr[2] = -7829368;
            setBackgroundResource(0);
            this.f73022i = attributeSet.getAttributeIntValue(PinEntryEditText.XML_NAMESPACE_ANDROID, "maxLength", 4);
            this.f73020g = (float) this.f73022i;
            super.setOnClickListener(new b(this));
            super.setOnLongClickListener(new c(this));
            if (((getInputType() & 128) == 128 && TextUtils.isEmpty(this.f73014a)) || ((getInputType() & 16) == 16 && TextUtils.isEmpty(this.f73014a))) {
                this.f73014a = "●";
            }
            if (!TextUtils.isEmpty(this.f73014a)) {
                this.f73015b = getMaskChars();
            }
            getPaint().getTextBounds("|", 0, 1, this.p);
            if (this.f73017d >= 0) {
                z2 = true;
            }
            this.x = z2;
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    private void a(CharSequence charSequence) {
        this.m.setAlpha(125);
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{125, PriceRangeSeekBar.INVALID_POINTER_ID});
        ofInt.setDuration(150);
        ofInt.addUpdateListener(new d(this));
        AnimatorSet animatorSet = new AnimatorSet();
        if (charSequence.length() == this.f73022i && this.s != null) {
            animatorSet.addListener(new e(this));
        }
        animatorSet.playTogether(new Animator[]{ofInt});
        animatorSet.start();
    }

    private void a(CharSequence charSequence, int i2) {
        this.k[i2] = this.j[i2].bottom - this.f73021h;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.k[i2] + getPaint().getTextSize(), this.k[i2]});
        ofFloat.setDuration(300);
        ofFloat.setInterpolator(new OvershootInterpolator());
        ofFloat.addUpdateListener(new f(this, i2));
        this.m.setAlpha(PriceRangeSeekBar.INVALID_POINTER_ID);
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, PriceRangeSeekBar.INVALID_POINTER_ID});
        ofInt.setDuration(300);
        ofInt.addUpdateListener(new g(this));
        AnimatorSet animatorSet = new AnimatorSet();
        if (charSequence.length() == this.f73022i && this.s != null) {
            animatorSet.addListener(new h(this));
        }
        animatorSet.playTogether(new Animator[]{ofFloat, ofInt});
        animatorSet.start();
    }

    private void a(boolean z2, boolean z3) {
        if (this.y) {
            this.w.setColor(a(16842914));
            return;
        }
        this.w.setStrokeWidth(isFocused() ? this.v : this.u);
        if (z2) {
            this.w.setColor(a(16842913));
            return;
        }
        boolean isFocused = isFocused();
        if (z3) {
            this.w.setColor(isFocused ? a(16842918) : a(-16842918));
        } else {
            this.w.setColor(isFocused ? a(16842908) : a(-16842908));
        }
    }

    private void b(boolean z2, boolean z3) {
        if (this.y) {
            this.o.setState(new int[]{16842914});
        } else if (isFocused()) {
            this.o.setState(new int[]{16842908});
            if (z3) {
                this.o.setState(new int[]{16842908, 16842913});
            } else if (z2) {
                this.o.setState(new int[]{16842908, 16842912});
            }
        } else {
            this.o.setState(new int[]{-16842908});
        }
    }

    private CharSequence getFullText() {
        return this.f73014a == null ? getText() : getMaskChars();
    }

    private StringBuilder getMaskChars() {
        if (this.f73015b == null) {
            this.f73015b = new StringBuilder();
        }
        int length = getText().length();
        while (this.f73015b.length() != length) {
            if (this.f73015b.length() < length) {
                this.f73015b.append(this.f73014a);
            } else {
                StringBuilder sb = this.f73015b;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return this.f73015b;
    }

    /* access modifiers changed from: package-private */
    public int a(float f2) {
        return (int) (f2 * ((float) (getResources().getDisplayMetrics().densityDpi / 160)));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f2;
        Paint paint;
        float f3;
        float f4;
        int i2;
        CharSequence fullText = getFullText();
        int length = fullText.length();
        float[] fArr = new float[length];
        getPaint().getTextWidths(fullText, 0, length, fArr);
        String str = this.f73016c;
        if (str != null) {
            float[] fArr2 = new float[str.length()];
            getPaint().getTextWidths(this.f73016c, fArr2);
            float f5 = 0.0f;
            for (float f6 : fArr2) {
                f5 += f6;
            }
            f2 = f5;
        } else {
            f2 = 0.0f;
        }
        int i3 = 0;
        while (((float) i3) < this.f73020g) {
            boolean z2 = true;
            if (this.o != null) {
                b(i3 < length, i3 == length);
                this.o.setBounds((int) this.j[i3].left, (int) this.j[i3].top, (int) this.j[i3].right, (int) this.j[i3].bottom);
                this.o.draw(canvas);
            }
            float f7 = this.j[i3].left + (this.f73019f / 2.0f);
            if (length > i3) {
                if (!this.x || i3 != length - 1) {
                    i2 = i3 + 1;
                    f4 = f7 - (fArr[i3] / 2.0f);
                    f3 = this.k[i3];
                    paint = this.l;
                } else {
                    i2 = i3 + 1;
                    f4 = f7 - (fArr[i3] / 2.0f);
                    f3 = this.k[i3];
                    paint = this.m;
                }
                canvas.drawText(fullText, i3, i2, f4, f3, paint);
            } else {
                String str2 = this.f73016c;
                if (str2 != null) {
                    canvas.drawText(str2, f7 - (f2 / 2.0f), this.k[i3], this.n);
                }
            }
            if (this.o == null) {
                boolean z3 = i3 < length;
                if (i3 != length) {
                    z2 = false;
                }
                a(z3, z2);
                canvas.drawLine(this.j[i3].left, this.j[i3].top, this.j[i3].right, this.j[i3].bottom, this.w);
            }
            i3++;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00a3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSizeChanged(int r7, int r8, int r9, int r10) {
        /*
            r6 = this;
            super.onSizeChanged(r7, r8, r9, r10)
            android.content.res.ColorStateList r7 = r6.getTextColors()
            r6.z = r7
            android.content.res.ColorStateList r7 = r6.z
            if (r7 == 0) goto L_0x002a
            android.graphics.Paint r8 = r6.m
            int r7 = r7.getDefaultColor()
            r8.setColor(r7)
            android.graphics.Paint r7 = r6.l
            android.content.res.ColorStateList r8 = r6.z
            int r8 = r8.getDefaultColor()
            r7.setColor(r8)
            android.graphics.Paint r7 = r6.n
            int r8 = r6.getCurrentHintTextColor()
            r7.setColor(r8)
        L_0x002a:
            int r7 = r6.getWidth()
            int r8 = androidx.core.h.u.n(r6)
            int r7 = r7 - r8
            int r8 = androidx.core.h.u.m(r6)
            int r7 = r7 - r8
            float r8 = r6.f73018e
            r9 = 1065353216(0x3f800000, float:1.0)
            r10 = 0
            r0 = 1073741824(0x40000000, float:2.0)
            int r1 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r1 >= 0) goto L_0x004d
            float r7 = (float) r7
            float r8 = r6.f73020g
            float r8 = r8 * r0
            float r8 = r8 - r9
            float r7 = r7 / r8
        L_0x004a:
            r6.f73019f = r7
            goto L_0x005d
        L_0x004d:
            float r1 = r6.f73019f
            int r1 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r1 != 0) goto L_0x005d
            float r7 = (float) r7
            float r1 = r6.f73020g
            float r9 = r1 - r9
            float r8 = r8 * r9
            float r7 = r7 - r8
            float r7 = r7 / r1
            goto L_0x004a
        L_0x005d:
            float r7 = r6.f73020g
            int r8 = (int) r7
            android.graphics.RectF[] r8 = new android.graphics.RectF[r8]
            r6.j = r8
            int r7 = (int) r7
            float[] r7 = new float[r7]
            r6.k = r7
            int r7 = r6.getHeight()
            int r8 = r6.getPaddingBottom()
            int r7 = r7 - r8
            int r8 = r6.getPaddingTop()
            int r7 = r7 - r8
            java.util.Locale r8 = java.util.Locale.getDefault()
            int r8 = androidx.core.f.f.a(r8)
            r9 = 0
            r1 = 1
            if (r8 != r1) goto L_0x0085
            r8 = 1
            goto L_0x0086
        L_0x0085:
            r8 = 0
        L_0x0086:
            if (r8 == 0) goto L_0x0098
            r1 = -1
            int r8 = r6.getWidth()
            int r2 = androidx.core.h.u.m(r6)
            int r8 = r8 - r2
            float r8 = (float) r8
            float r2 = r6.f73019f
            float r8 = r8 - r2
            int r8 = (int) r8
            goto L_0x009c
        L_0x0098:
            int r8 = androidx.core.h.u.m(r6)
        L_0x009c:
            float r2 = (float) r9
            float r3 = r6.f73020g
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 >= 0) goto L_0x0129
            android.graphics.RectF[] r2 = r6.j
            android.graphics.RectF r3 = new android.graphics.RectF
            float r8 = (float) r8
            float r4 = (float) r7
            float r5 = r6.f73019f
            float r5 = r5 + r8
            r3.<init>(r8, r4, r5, r4)
            r2[r9] = r3
            android.graphics.drawable.Drawable r2 = r6.o
            if (r2 == 0) goto L_0x00e7
            boolean r2 = r6.q
            if (r2 == 0) goto L_0x00d2
            android.graphics.RectF[] r2 = r6.j
            r2 = r2[r9]
            int r3 = r6.getPaddingTop()
            float r3 = (float) r3
            r2.top = r3
            android.graphics.RectF[] r2 = r6.j
            r3 = r2[r9]
            r2 = r2[r9]
            float r2 = r2.height()
            float r2 = r2 + r8
            r3.right = r2
            goto L_0x00e7
        L_0x00d2:
            android.graphics.RectF[] r2 = r6.j
            r2 = r2[r9]
            float r3 = r2.top
            android.graphics.Rect r4 = r6.p
            int r4 = r4.height()
            float r4 = (float) r4
            float r5 = r6.f73021h
            float r5 = r5 * r0
            float r4 = r4 + r5
            float r3 = r3 - r4
            r2.top = r3
        L_0x00e7:
            float r2 = r6.f73018e
            int r3 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r3 >= 0) goto L_0x00f6
            float r2 = (float) r1
            float r3 = r6.f73019f
            float r2 = r2 * r3
            float r2 = r2 * r0
            float r8 = r8 + r2
            goto L_0x00fd
        L_0x00f6:
            float r3 = (float) r1
            float r4 = r6.f73019f
            float r4 = r4 + r2
            float r3 = r3 * r4
            float r8 = r8 + r3
        L_0x00fd:
            int r8 = (int) r8
            float[] r2 = r6.k
            android.graphics.RectF[] r3 = r6.j
            r3 = r3[r9]
            float r3 = r3.bottom
            float r4 = r6.f73021h
            float r3 = r3 - r4
            r2[r9] = r3
            boolean r2 = r6.t
            if (r2 == 0) goto L_0x0125
            android.graphics.RectF[] r2 = r6.j
            r3 = r2[r9]
            r2 = r2[r9]
            float r2 = r2.top
            float r2 = r2 / r0
            r3.top = r2
            android.graphics.RectF[] r2 = r6.j
            r3 = r2[r9]
            r2 = r2[r9]
            float r2 = r2.bottom
            float r2 = r2 / r0
            r3.bottom = r2
        L_0x0125:
            int r9 = r9 + 1
            goto L_0x009c
        L_0x0129:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.npci.upi.security.pinactivitycomponent.widget.FormItemEditText.onSizeChanged(int, int, int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        setError(false);
        if (this.j != null && this.x) {
            int i5 = this.f73017d;
            if (i5 == -1) {
                invalidate();
            } else if (i4 <= i3) {
            } else {
                if (i5 == 0) {
                    a(charSequence);
                } else {
                    a(charSequence, i2);
                }
            }
        } else if (this.s != null && charSequence.length() == this.f73022i) {
            this.s.a(charSequence);
        }
    }

    public void setAnimateText(boolean z2) {
        this.x = z2;
    }

    public void setCharSize(float f2) {
        this.f73019f = f2;
        invalidate();
    }

    public void setColorStates(ColorStateList colorStateList) {
        this.C = colorStateList;
        invalidate();
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        throw new RuntimeException("setCustomSelectionActionModeCallback() not supported.");
    }

    public void setError(boolean z2) {
        this.y = z2;
    }

    public void setFontSize(float f2) {
        this.l.setTextSize(f2);
        this.m.setTextSize(f2);
        this.n.setTextSize(f2);
    }

    public void setLineStroke(float f2) {
        this.u = f2;
        invalidate();
    }

    public void setLineStrokeCentered(boolean z2) {
        this.t = z2;
        invalidate();
    }

    public void setLineStrokeSelected(float f2) {
        this.v = f2;
        invalidate();
    }

    public void setMargin(int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        marginLayoutParams.setMargins(iArr[0], iArr[1], iArr[2], iArr[3]);
        setLayoutParams(marginLayoutParams);
    }

    public void setMaxLength(int i2) {
        this.f73022i = i2;
        this.f73020g = (float) i2;
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2)});
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.r = onClickListener;
    }

    public void setOnPinEnteredListener(i iVar) {
        this.s = iVar;
    }

    public void setSpace(float f2) {
        this.f73018e = f2;
        invalidate();
    }
}
