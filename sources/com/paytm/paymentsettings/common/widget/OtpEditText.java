package com.paytm.paymentsettings.common.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.f.f;
import androidx.core.h.u;
import com.paytm.paymentsettings.R;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import java.util.Locale;
import net.one97.paytm.nativesdk.otp.view.PinEntryEditText;

public class OtpEditText extends AppCompatEditText {
    protected boolean A = false;
    protected int B = 0;
    protected int C;
    protected int D;
    protected int E;
    protected int F;
    protected ColorStateList G;
    private float[] H;
    private boolean I = true;

    /* renamed from: a  reason: collision with root package name */
    protected int f43436a = 6;

    /* renamed from: b  reason: collision with root package name */
    protected RectF[] f43437b;

    /* renamed from: c  reason: collision with root package name */
    protected float[] f43438c;

    /* renamed from: d  reason: collision with root package name */
    protected Paint f43439d;

    /* renamed from: e  reason: collision with root package name */
    protected Paint f43440e;

    /* renamed from: f  reason: collision with root package name */
    protected Drawable f43441f;

    /* renamed from: g  reason: collision with root package name */
    protected Rect f43442g = new Rect();

    /* renamed from: h  reason: collision with root package name */
    protected boolean f43443h = false;

    /* renamed from: i  reason: collision with root package name */
    protected String f43444i = null;
    protected StringBuilder j = null;
    protected int k = 0;
    protected int l = 0;
    protected float m = 24.0f;
    protected float n;
    protected float o = 6.0f;
    protected float p = 8.0f;
    protected View.OnClickListener q;
    protected View.OnLongClickListener r;
    protected a s = null;
    protected b t = null;
    protected float u = 1.0f;
    protected float v = 2.0f;
    protected Paint w;
    protected boolean x = false;
    protected boolean y = false;
    protected boolean z = false;

    public interface a {
    }

    public interface b {
    }

    public void setError(CharSequence charSequence) {
    }

    public void setError(CharSequence charSequence, Drawable drawable) {
    }

    public OtpEditText(Context context) {
        super(context);
    }

    public OtpEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public OtpEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }

    public OtpEditText(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }

    public void setMaxLength(int i2) {
        this.f43436a = i2;
        this.o = (float) i2;
        this.H = new float[((int) this.o)];
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2)});
        setText((CharSequence) null);
        invalidate();
    }

    public void setActive(boolean z2) {
        this.I = z2;
    }

    /* JADX INFO: finally extract failed */
    private void a(Context context, AttributeSet attributeSet) {
        float f2 = context.getResources().getDisplayMetrics().density;
        this.u *= f2;
        this.v *= f2;
        this.m *= f2;
        this.p = f2 * this.p;
        boolean z2 = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.OtpEditText, 0, 0);
        try {
            TypedValue typedValue = new TypedValue();
            obtainStyledAttributes.getValue(R.styleable.OtpEditText_otpInputAnimStyle, typedValue);
            this.k = typedValue.data;
            obtainStyledAttributes.getValue(R.styleable.OtpEditText_otpErrorAnimStyle, typedValue);
            this.l = typedValue.data;
            this.u = obtainStyledAttributes.getDimension(R.styleable.OtpEditText_otpStrokeLineHeight, this.u);
            this.v = obtainStyledAttributes.getDimension(R.styleable.OtpEditText_otpStrokeLineSelectedHeight, this.v);
            this.m = obtainStyledAttributes.getDimension(R.styleable.OtpEditText_otpCharacterSpacing, this.m);
            this.p = obtainStyledAttributes.getDimension(R.styleable.OtpEditText_otpTextBottomLinePadding, this.p);
            this.f43443h = obtainStyledAttributes.getBoolean(R.styleable.OtpEditText_otpBackgroundIsSquare, this.f43443h);
            this.f43441f = obtainStyledAttributes.getDrawable(R.styleable.OtpEditText_otpBackgroundDrawable);
            this.B = obtainStyledAttributes.getColor(R.styleable.OtpEditText_otpErrorTextColor, -7829368);
            this.F = obtainStyledAttributes.getColor(R.styleable.OtpEditText_otpLineErrorColor, getTextColors().getColorForState(new int[]{16842914}, Color.parseColor("#fd5c5c")));
            this.D = obtainStyledAttributes.getColor(R.styleable.OtpEditText_otpLineFocusedColor, getTextColors().getColorForState(new int[]{16842908}, -12303292));
            this.E = obtainStyledAttributes.getColor(R.styleable.OtpEditText_otpLineNextCharColor, getTextColors().getColorForState(new int[]{16842908}, -12303292));
            this.C = obtainStyledAttributes.getColor(R.styleable.OtpEditText_otpLineUnFocusedColor, getTextColors().getColorForState(new int[]{16842914}, -7829368));
            obtainStyledAttributes.recycle();
            this.f43439d = new Paint(getPaint());
            this.f43440e = new Paint(getPaint());
            this.w = new Paint(getPaint());
            this.w.setStrokeWidth(this.u);
            setBackgroundResource(0);
            this.f43436a = attributeSet.getAttributeIntValue(PinEntryEditText.XML_NAMESPACE_ANDROID, "maxLength", 6);
            this.o = (float) this.f43436a;
            this.H = new float[((int) this.o)];
            super.setCustomSelectionActionModeCallback(new ActionMode.Callback() {
                public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                    return false;
                }

                public final boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                    return false;
                }

                public final void onDestroyActionMode(ActionMode actionMode) {
                }

                public final boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                    return false;
                }
            });
            super.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    OtpEditText otpEditText = OtpEditText.this;
                    otpEditText.setSelection(otpEditText.getText().length());
                    if (OtpEditText.this.q != null) {
                        OtpEditText.this.q.onClick(view);
                    }
                }
            });
            super.setOnLongClickListener(new View.OnLongClickListener() {
                public final boolean onLongClick(View view) {
                    OtpEditText otpEditText = OtpEditText.this;
                    otpEditText.setSelection(otpEditText.getText().length());
                    if (OtpEditText.this.r == null) {
                        return false;
                    }
                    return OtpEditText.this.r.onLongClick(view);
                }
            });
            if ((getInputType() & 128) == 128) {
                this.f43444i = "●";
            } else if ((getInputType() & 16) == 16) {
                this.f43444i = "●";
            }
            if (!TextUtils.isEmpty(this.f43444i)) {
                this.j = getMaskChars();
            }
            getPaint().getTextBounds("|", 0, 1, this.f43442g);
            this.x = this.k >= 0;
            if (this.l >= 0) {
                z2 = true;
            }
            this.y = z2;
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        int i6;
        float f2;
        super.onSizeChanged(i2, i3, i4, i5);
        this.G = getTextColors();
        ColorStateList colorStateList = this.G;
        if (colorStateList != null) {
            this.f43440e.setColor(colorStateList.getDefaultColor());
            this.f43439d.setColor(this.G.getDefaultColor());
        }
        int width = (getWidth() - u.n(this)) - u.m(this);
        float f3 = this.m;
        if (f3 < 0.0f) {
            this.n = ((float) width) / ((this.o * 2.0f) - 1.0f);
        } else {
            float f4 = this.o;
            this.n = ((((float) width) - (f3 * (f4 - 1.0f))) / f4) + ((float) a());
        }
        float f5 = this.o;
        this.f43437b = new RectF[((int) f5)];
        this.f43438c = new float[((int) f5)];
        int height = getHeight() - getPaddingBottom();
        int i7 = 1;
        if (f.a(Locale.getDefault()) == 1) {
            i7 = -1;
            i6 = (int) (((float) (getWidth() - u.m(this))) - this.n);
        } else {
            i6 = u.m(this) + a();
        }
        for (int i8 = 0; ((float) i8) < this.o; i8++) {
            float f6 = (float) i6;
            float f7 = (float) height;
            this.f43437b[i8] = new RectF(f6, f7, this.n + f6, f7);
            if (this.f43441f != null) {
                if (this.f43443h) {
                    this.f43437b[i8].top = (float) getPaddingTop();
                    RectF[] rectFArr = this.f43437b;
                    rectFArr[i8].right = rectFArr[i8].height() + f6;
                } else {
                    this.f43437b[i8].top -= ((float) this.f43442g.height()) + (this.p * 2.0f);
                }
            }
            float f8 = this.m;
            if (f8 < 0.0f) {
                f2 = f6 + (((float) i7) * this.n * 2.0f);
            } else {
                f2 = f6 + (((float) i7) * (this.n + f8));
            }
            i6 = (int) f2;
            this.f43438c[i8] = this.f43437b[i8].bottom - this.p;
        }
    }

    private int a() {
        return (int) TypedValue.applyDimension(1, 2.0f, getContext().getApplicationContext().getResources().getDisplayMetrics());
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.q = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.r = onLongClickListener;
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        throw new RuntimeException("setCustomSelectionActionModeCallback() is not allowed.");
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i2;
        CharSequence fullText = getFullText();
        int length = fullText.length();
        float[] fArr = this.H;
        if (length > fArr.length) {
            length = fArr.length;
        }
        int i3 = length;
        getPaint().getTextWidths(fullText, 0, i3, this.H);
        int i4 = 0;
        while (((float) i4) < this.o) {
            if (this.f43441f != null) {
                boolean z2 = i4 < i3;
                boolean z3 = i4 == i3;
                if (this.z) {
                    this.f43441f.setState(new int[]{16842914});
                } else if (isFocused()) {
                    this.f43441f.setState(new int[]{16842908});
                    if (z3) {
                        this.f43441f.setState(new int[]{16842908, 16842913});
                    } else if (z2) {
                        this.f43441f.setState(new int[]{16842908, 16842912});
                    }
                } else {
                    this.f43441f.setState(new int[]{-16842908});
                }
                this.f43441f.setBounds((int) this.f43437b[i4].left, (int) this.f43437b[i4].top, (int) this.f43437b[i4].right, (int) this.f43437b[i4].bottom);
                this.f43441f.draw(canvas);
            }
            float f2 = this.f43437b[i4].left + (this.n / 2.0f);
            if (i3 > i4) {
                if (!this.x || i4 != i3 - 1) {
                    canvas.drawText(fullText, i4, i4 + 1, f2 - (this.H[i4] / 2.0f), this.f43438c[i4], this.f43439d);
                } else {
                    canvas.drawText(fullText, i4, i4 + 1, f2 - (this.H[i4] / 2.0f), this.f43438c[i4], this.f43440e);
                }
            }
            if (this.f43441f == null) {
                if (this.z) {
                    this.w.setColor(this.F);
                } else if (isFocused()) {
                    this.w.setStrokeWidth(this.v);
                    if (i4 == i3 || (i3 == (i2 = this.f43436a) && i4 == i2 - 1 && this.I)) {
                        this.w.setColor(this.E);
                    } else if (i4 < i3) {
                        this.w.setColor(this.D);
                    } else {
                        this.w.setColor(this.C);
                    }
                } else {
                    this.w.setStrokeWidth(this.u);
                    this.w.setColor(this.C);
                }
                canvas.drawLine(this.f43437b[i4].left, this.f43437b[i4].top, this.f43437b[i4].right, this.f43437b[i4].bottom, this.w);
            }
            i4++;
        }
    }

    private CharSequence getFullText() {
        if (this.f43444i == null) {
            return getText();
        }
        return getMaskChars();
    }

    private StringBuilder getMaskChars() {
        if (this.j == null) {
            this.j = new StringBuilder();
        }
        int length = getText().length();
        while (this.j.length() != length) {
            if (this.j.length() < length) {
                this.j.append(this.f43444i);
            } else {
                StringBuilder sb = this.j;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return this.j;
    }

    public void setError(boolean z2) {
        this.z = z2;
    }

    public boolean onTextContextMenuItem(int i2) {
        return super.onTextContextMenuItem(i2);
    }

    public void setOnTextChangedListener(b bVar) {
        this.t = bVar;
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, final int i2, int i3, int i4) {
        setError(false);
        if (this.A || this.z) {
            this.A = false;
            this.z = false;
            ColorStateList colorStateList = this.G;
            if (colorStateList != null) {
                this.f43440e.setColor(colorStateList.getDefaultColor());
                this.f43439d.setColor(this.G.getDefaultColor());
            }
        }
        RectF[] rectFArr = this.f43437b;
        if (rectFArr != null && this.x) {
            int i5 = this.k;
            if (i5 == -1) {
                invalidate();
            } else if (i4 <= i3) {
            } else {
                if (i5 == 0) {
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, getPaint().getTextSize()});
                    ofFloat.setDuration(200);
                    ofFloat.setInterpolator(new OvershootInterpolator());
                    ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            OtpEditText.this.f43440e.setTextSize(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            OtpEditText.this.invalidate();
                        }
                    });
                    if (getText().length() == this.f43436a && this.s != null) {
                        ofFloat.addListener(new Animator.AnimatorListener() {
                            public final void onAnimationCancel(Animator animator) {
                            }

                            public final void onAnimationRepeat(Animator animator) {
                            }

                            public final void onAnimationStart(Animator animator) {
                            }

                            public final void onAnimationEnd(Animator animator) {
                                OtpEditText.this.getText();
                            }
                        });
                    }
                    ofFloat.start();
                    return;
                }
                this.f43438c[i2] = rectFArr[i2].bottom - this.p;
                ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{this.f43438c[i2] + getPaint().getTextSize(), this.f43438c[i2]});
                ofFloat2.setDuration(300);
                ofFloat2.setInterpolator(new OvershootInterpolator());
                ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        OtpEditText.this.f43438c[i2] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        OtpEditText.this.invalidate();
                    }
                });
                this.f43440e.setAlpha(PriceRangeSeekBar.INVALID_POINTER_ID);
                ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, PriceRangeSeekBar.INVALID_POINTER_ID});
                ofInt.setDuration(300);
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        OtpEditText.this.f43440e.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                });
                AnimatorSet animatorSet = new AnimatorSet();
                if (charSequence.length() == this.f43436a && this.s != null) {
                    animatorSet.addListener(new Animator.AnimatorListener() {
                        public final void onAnimationCancel(Animator animator) {
                        }

                        public final void onAnimationRepeat(Animator animator) {
                        }

                        public final void onAnimationStart(Animator animator) {
                        }

                        public final void onAnimationEnd(Animator animator) {
                            OtpEditText.this.getText();
                        }
                    });
                }
                animatorSet.playTogether(new Animator[]{ofFloat2, ofInt});
                animatorSet.start();
            }
        } else if (this.s != null) {
            charSequence.length();
        }
    }

    public void setOnPinEnteredListener(a aVar) {
        this.s = aVar;
    }

    public CharSequence getError() {
        return super.getError();
    }
}
