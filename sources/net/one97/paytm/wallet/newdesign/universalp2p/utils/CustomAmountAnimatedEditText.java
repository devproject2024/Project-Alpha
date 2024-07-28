package net.one97.paytm.wallet.newdesign.universalp2p.utils;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.ai;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Pattern;
import net.one97.paytm.wallet.R;

public class CustomAmountAnimatedEditText extends AppCompatEditText {

    /* renamed from: a  reason: collision with root package name */
    Collection<Animator> f71424a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private Paint f71425b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Paint f71426c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f71427d;

    /* renamed from: e  reason: collision with root package name */
    private ColorStateList f71428e;

    /* renamed from: f  reason: collision with root package name */
    private int f71429f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f71430g = true;

    /* renamed from: h  reason: collision with root package name */
    private boolean f71431h = true;

    /* renamed from: i  reason: collision with root package name */
    private c f71432i = c.BOTTOM_UP;
    private String j = null;
    private StringBuilder k = null;
    private float l = 0.0f;
    private float m = 0.0f;
    /* access modifiers changed from: private */
    public float n = 0.0f;
    /* access modifiers changed from: private */
    public float o = 0.0f;
    private int p = 0;
    private int q = 0;
    private d r;
    private e s;
    private AnimatorSet t = null;
    /* access modifiers changed from: private */
    public float u = 0.0f;
    private boolean v = false;
    private boolean w = false;
    private boolean x = false;
    private int y = 6;
    private int z = 2;

    public enum c {
        RIGHT_TO_LEFT,
        BOTTOM_UP,
        MIDDLE_UP,
        POP_IN,
        NONE
    }

    public interface d {
    }

    public interface e {
    }

    public int getMaxDigitsBeforeDecimal() {
        return this.y;
    }

    public void setMaxDigitsBeforeDecimal(int i2) {
        this.y = i2;
    }

    public int getMaxDigitsAfterDecimal() {
        return this.z;
    }

    public void setMaxDigitsAfterDecimal(int i2) {
        this.z = i2;
    }

    public CustomAmountAnimatedEditText(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    public CustomAmountAnimatedEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public CustomAmountAnimatedEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }

    /* JADX INFO: finally extract failed */
    private void a(Context context, AttributeSet attributeSet) {
        setFilters(new InputFilter[]{new a(getMaxDigitsBeforeDecimal(), getMaxDigitsAfterDecimal())});
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AnimatedEditText, 0, 0);
        try {
            TypedValue typedValue = new TypedValue();
            obtainStyledAttributes.getValue(R.styleable.AnimatedEditText_animationType, typedValue);
            if (typedValue.data == 0) {
                c cVar = c.BOTTOM_UP;
                this.f71432i = cVar;
                setAnimationType(cVar);
            } else if (typedValue.data == 1) {
                c cVar2 = c.RIGHT_TO_LEFT;
                this.f71432i = cVar2;
                setAnimationType(cVar2);
            } else if (typedValue.data == 2) {
                c cVar3 = c.MIDDLE_UP;
                this.f71432i = cVar3;
                setAnimationType(cVar3);
            } else if (typedValue.data == 3) {
                c cVar4 = c.POP_IN;
                this.f71432i = cVar4;
                setAnimationType(cVar4);
            } else if (typedValue.data == -1) {
                c cVar5 = c.NONE;
                this.f71432i = cVar5;
                setAnimationType(cVar5);
            }
            this.j = obtainStyledAttributes.getString(R.styleable.AnimatedEditText_textMask);
            this.f71431h = obtainStyledAttributes.getBoolean(R.styleable.AnimatedEditText_animateTextClear, this.f71431h);
            this.v = obtainStyledAttributes.getBoolean(R.styleable.AnimatedEditText_animateCursor, this.v);
            obtainStyledAttributes.recycle();
            if ((getInputType() & 128) == 128 && TextUtils.isEmpty(this.j)) {
                this.j = "●";
            } else if ((getInputType() & 16) == 16 && TextUtils.isEmpty(this.j)) {
                this.j = "●";
            }
            if (!TextUtils.isEmpty(this.j)) {
                this.k = getMaskChars();
            }
            this.f71427d = new Paint(1);
            TypedValue typedValue2 = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.colorControlActivated, typedValue2, true);
            this.f71427d.setColor(typedValue2.data);
            this.f71427d.setStrokeWidth(context.getResources().getDisplayMetrics().density * 2.0f);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void setTextAnimated(boolean z2) {
        this.f71430g = z2;
        if (z2) {
            setTextColor(0);
            return;
        }
        ColorStateList colorStateList = this.f71428e;
        if (colorStateList != null) {
            setTextColor(colorStateList);
        }
    }

    public void setAnimationType(c cVar) {
        if (this.f71432i == null || cVar == c.NONE) {
            this.f71432i = c.NONE;
            setTextAnimated(false);
            return;
        }
        this.f71432i = cVar;
    }

    public void setCursorAnimated(boolean z2) {
        this.v = z2 && Build.VERSION.SDK_INT >= 16 && !ai.a(this);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f71425b = new Paint(getPaint());
        this.f71426c = new Paint(getPaint());
        this.f71428e = getTextColors();
        if (!TextUtils.isEmpty(this.j)) {
            this.f71425b.setTypeface(Typeface.MONOSPACE);
            this.f71426c.setTypeface(Typeface.MONOSPACE);
        }
        ColorStateList colorStateList = this.f71428e;
        if (colorStateList != null) {
            this.f71425b.setColor(colorStateList.getDefaultColor());
            this.f71426c.setColor(this.f71428e.getDefaultColor());
            this.f71429f = this.f71426c.getAlpha();
        }
        if (this.f71432i != c.NONE) {
            setTextColor(0);
        }
        if (!TextUtils.isEmpty(getText())) {
            this.p = 0;
            this.q = getText().length();
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007d A[Catch:{ Exception -> 0x013d }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008d A[Catch:{ Exception -> 0x013d }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00cc A[Catch:{ Exception -> 0x013d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r9) {
        /*
            r8 = this;
            super.onDraw(r9)     // Catch:{ Exception -> 0x013d }
            boolean r0 = r8.f71430g     // Catch:{ Exception -> 0x013d }
            if (r0 != 0) goto L_0x0008
            return
        L_0x0008:
            android.content.res.ColorStateList r0 = r8.f71428e     // Catch:{ Exception -> 0x013d }
            r1 = 2
            r2 = 1
            r3 = 3
            r4 = 0
            if (r0 == 0) goto L_0x0060
            int[] r0 = new int[r3]     // Catch:{ Exception -> 0x013d }
            boolean r5 = r8.isEnabled()     // Catch:{ Exception -> 0x013d }
            if (r5 == 0) goto L_0x001c
            r5 = 16842910(0x101009e, float:2.3694E-38)
            goto L_0x001f
        L_0x001c:
            r5 = -16842910(0xfffffffffefeff62, float:-1.6947497E38)
        L_0x001f:
            r0[r4] = r5     // Catch:{ Exception -> 0x013d }
            boolean r5 = r8.isFocused()     // Catch:{ Exception -> 0x013d }
            if (r5 == 0) goto L_0x002b
            r5 = 16842908(0x101009c, float:2.3693995E-38)
            goto L_0x002e
        L_0x002b:
            r5 = -16842908(0xfffffffffefeff64, float:-1.6947499E38)
        L_0x002e:
            r0[r2] = r5     // Catch:{ Exception -> 0x013d }
            boolean r5 = r8.isSelected()     // Catch:{ Exception -> 0x013d }
            if (r5 == 0) goto L_0x003a
            r5 = 16842913(0x10100a1, float:2.369401E-38)
            goto L_0x003d
        L_0x003a:
            r5 = -16842913(0xfffffffffefeff5f, float:-1.6947494E38)
        L_0x003d:
            r0[r1] = r5     // Catch:{ Exception -> 0x013d }
            android.content.res.ColorStateList r5 = r8.f71428e     // Catch:{ Exception -> 0x013d }
            android.content.res.ColorStateList r6 = r8.f71428e     // Catch:{ Exception -> 0x013d }
            int r6 = r6.getDefaultColor()     // Catch:{ Exception -> 0x013d }
            int r0 = r5.getColorForState(r0, r6)     // Catch:{ Exception -> 0x013d }
            android.graphics.Paint r5 = r8.f71425b     // Catch:{ Exception -> 0x013d }
            r5.setColor(r0)     // Catch:{ Exception -> 0x013d }
            android.graphics.Paint r5 = r8.f71426c     // Catch:{ Exception -> 0x013d }
            int r5 = r5.getAlpha()     // Catch:{ Exception -> 0x013d }
            android.graphics.Paint r6 = r8.f71426c     // Catch:{ Exception -> 0x013d }
            r6.setColor(r0)     // Catch:{ Exception -> 0x013d }
            android.graphics.Paint r0 = r8.f71426c     // Catch:{ Exception -> 0x013d }
            r0.setAlpha(r5)     // Catch:{ Exception -> 0x013d }
        L_0x0060:
            int r0 = r8.getGravity()     // Catch:{ Exception -> 0x013d }
            r5 = 5
            r0 = r0 & r5
            if (r0 == r5) goto L_0x0075
            int r0 = r8.getGravity()     // Catch:{ Exception -> 0x013d }
            r5 = 8388613(0x800005, float:1.175495E-38)
            r0 = r0 & r5
            if (r0 != r5) goto L_0x0073
            goto L_0x0075
        L_0x0073:
            r0 = 0
            goto L_0x0076
        L_0x0075:
            r0 = 1
        L_0x0076:
            int r5 = r8.getGravity()     // Catch:{ Exception -> 0x013d }
            r5 = r5 & r3
            if (r5 == r3) goto L_0x0089
            int r3 = r8.getGravity()     // Catch:{ Exception -> 0x013d }
            r5 = 8388611(0x800003, float:1.1754948E-38)
            r3 = r3 & r5
            if (r3 != r5) goto L_0x0088
            goto L_0x0089
        L_0x0088:
            r2 = 0
        L_0x0089:
            r3 = 0
            r5 = 0
            if (r0 == 0) goto L_0x00cc
            int r0 = r8.getScrollX()     // Catch:{ Exception -> 0x013d }
            float r0 = (float) r0     // Catch:{ Exception -> 0x013d }
            r9.translate(r0, r3)     // Catch:{ Exception -> 0x013d }
            java.lang.String r0 = r8.getFixedText()     // Catch:{ Exception -> 0x013d }
            android.graphics.Paint r1 = r8.f71425b     // Catch:{ Exception -> 0x013d }
            float r1 = r1.measureText(r0)     // Catch:{ Exception -> 0x013d }
            java.lang.String r2 = r8.getAnimText()     // Catch:{ Exception -> 0x013d }
            android.graphics.Paint r3 = r8.f71425b     // Catch:{ Exception -> 0x013d }
            float r2 = r3.measureText(r2)     // Catch:{ Exception -> 0x013d }
            float r1 = r1 + r2
            int r3 = r8.getWidth()     // Catch:{ Exception -> 0x013d }
            int r6 = r8.getCompoundPaddingRight()     // Catch:{ Exception -> 0x013d }
            int r3 = r3 - r6
            float r3 = (float) r3     // Catch:{ Exception -> 0x013d }
            float r1 = r3 - r1
            int r6 = r8.getLineBounds(r4, r5)     // Catch:{ Exception -> 0x013d }
            float r6 = (float) r6     // Catch:{ Exception -> 0x013d }
            r8.a((android.graphics.Canvas) r9, (java.lang.String) r0, (float) r1, (float) r6)     // Catch:{ Exception -> 0x013d }
            java.lang.CharSequence r0 = r8.getFullText()     // Catch:{ Exception -> 0x013d }
            float r3 = r3 - r2
            int r1 = r8.getLineBounds(r4, r5)     // Catch:{ Exception -> 0x013d }
            float r1 = (float) r1     // Catch:{ Exception -> 0x013d }
            r8.a((android.graphics.Canvas) r9, (java.lang.CharSequence) r0, (float) r3, (float) r1)     // Catch:{ Exception -> 0x013d }
            return
        L_0x00cc:
            if (r2 == 0) goto L_0x00f6
            java.lang.String r0 = r8.getFixedText()     // Catch:{ Exception -> 0x013d }
            android.graphics.Paint r1 = r8.f71425b     // Catch:{ Exception -> 0x013d }
            float r1 = r1.measureText(r0)     // Catch:{ Exception -> 0x013d }
            int r2 = r8.getCompoundPaddingLeft()     // Catch:{ Exception -> 0x013d }
            float r2 = (float) r2     // Catch:{ Exception -> 0x013d }
            int r3 = r8.getLineBounds(r4, r5)     // Catch:{ Exception -> 0x013d }
            float r3 = (float) r3     // Catch:{ Exception -> 0x013d }
            r8.a((android.graphics.Canvas) r9, (java.lang.String) r0, (float) r2, (float) r3)     // Catch:{ Exception -> 0x013d }
            java.lang.CharSequence r0 = r8.getFullText()     // Catch:{ Exception -> 0x013d }
            float r2 = r2 + r1
            int r1 = r8.getLineBounds(r4, r5)     // Catch:{ Exception -> 0x013d }
            float r1 = (float) r1     // Catch:{ Exception -> 0x013d }
            r8.a((android.graphics.Canvas) r9, (java.lang.CharSequence) r0, (float) r2, (float) r1)     // Catch:{ Exception -> 0x013d }
            r8.a((android.graphics.Canvas) r9, (float) r2)     // Catch:{ Exception -> 0x013d }
            return
        L_0x00f6:
            int r0 = r8.getScrollX()     // Catch:{ Exception -> 0x013d }
            float r0 = (float) r0     // Catch:{ Exception -> 0x013d }
            r9.translate(r0, r3)     // Catch:{ Exception -> 0x013d }
            java.lang.String r0 = r8.getFixedText()     // Catch:{ Exception -> 0x013d }
            android.graphics.Paint r2 = r8.f71425b     // Catch:{ Exception -> 0x013d }
            float r2 = r2.measureText(r0)     // Catch:{ Exception -> 0x013d }
            java.lang.String r3 = r8.getAnimText()     // Catch:{ Exception -> 0x013d }
            android.graphics.Paint r6 = r8.f71425b     // Catch:{ Exception -> 0x013d }
            float r3 = r6.measureText(r3)     // Catch:{ Exception -> 0x013d }
            float r2 = r2 + r3
            int r6 = r8.getWidth()     // Catch:{ Exception -> 0x013d }
            int r6 = r6 / r1
            float r6 = (float) r6     // Catch:{ Exception -> 0x013d }
            r7 = 1073741824(0x40000000, float:2.0)
            float r2 = r2 / r7
            float r6 = r6 - r2
            int r7 = r8.getWidth()     // Catch:{ Exception -> 0x013d }
            int r7 = r7 / r1
            float r1 = (float) r7     // Catch:{ Exception -> 0x013d }
            float r1 = r1 + r2
            float r1 = r1 - r3
            int r2 = r8.getLineBounds(r4, r5)     // Catch:{ Exception -> 0x013d }
            float r2 = (float) r2     // Catch:{ Exception -> 0x013d }
            r8.a((android.graphics.Canvas) r9, (java.lang.String) r0, (float) r6, (float) r2)     // Catch:{ Exception -> 0x013d }
            java.lang.CharSequence r0 = r8.getFullText()     // Catch:{ Exception -> 0x013d }
            int r2 = r8.getLineBounds(r4, r5)     // Catch:{ Exception -> 0x013d }
            float r2 = (float) r2     // Catch:{ Exception -> 0x013d }
            r8.a((android.graphics.Canvas) r9, (java.lang.CharSequence) r0, (float) r1, (float) r2)     // Catch:{ Exception -> 0x013d }
            r8.a((android.graphics.Canvas) r9, (float) r1)     // Catch:{ Exception -> 0x013d }
            return
        L_0x013d:
            r9 = move-exception
            java.lang.String r9 = java.lang.String.valueOf(r9)
            com.paytm.utility.q.d(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.newdesign.universalp2p.utils.CustomAmountAnimatedEditText.onDraw(android.graphics.Canvas):void");
    }

    private void a(Canvas canvas, String str, float f2, float f3) {
        canvas.drawText(str, f2 + this.l, f3 + this.m, this.f71425b);
    }

    private void a(Canvas canvas, CharSequence charSequence, float f2, float f3) {
        canvas.drawText(charSequence, this.p, this.q, f2 + this.n, f3 + this.o, this.f71426c);
    }

    private void a(Canvas canvas, float f2) {
        if (this.v && isFocused() && Build.VERSION.SDK_INT >= 16 && !isCursorVisible()) {
            float f3 = f2 + this.u;
            canvas.drawLine(f3, (float) getCompoundPaddingTop(), f3, ((float) getHeight()) - (getContext().getResources().getDisplayMetrics().scaledDensity * 11.0f), this.f71427d);
        }
    }

    private CharSequence getFullText() {
        if (TextUtils.isEmpty(this.j)) {
            return getText();
        }
        return getMaskChars();
    }

    private String getFixedText() {
        if (this.p < 0) {
            return "";
        }
        if (TextUtils.isEmpty(this.j)) {
            return TextUtils.substring(getText(), 0, this.p);
        }
        return TextUtils.substring(getMaskChars(), 0, this.p);
    }

    private String getAnimText() {
        if (TextUtils.isEmpty(this.j)) {
            return TextUtils.substring(getText(), this.p, this.q);
        }
        return TextUtils.substring(getMaskChars(), this.p, this.q);
    }

    private StringBuilder getMaskChars() {
        if (this.k == null) {
            this.k = new StringBuilder();
        }
        int length = getText().length();
        while (this.k.length() != length) {
            if (this.k.length() < length) {
                this.k.append(this.j);
            } else {
                StringBuilder sb = this.k;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return this.k;
    }

    public void setText(CharSequence charSequence, final TextView.BufferType bufferType) {
        if (!this.f71430g || !this.f71431h || this.f71425b == null || !TextUtils.isEmpty(charSequence)) {
            super.setText(charSequence, bufferType);
            return;
        }
        AnonymousClass1 r0 = new b() {
            public final void onAnimationEnd(Animator animator) {
                CustomAmountAnimatedEditText.super.setText((CharSequence) null, bufferType);
            }
        };
        this.p = 0;
        this.q = getText().length();
        int i2 = AnonymousClass4.f71440a[this.f71432i.ordinal()];
        if (i2 == 1) {
            d(true, r0);
        } else if (i2 == 2) {
            a(true, (b) r0);
        } else if (i2 == 3) {
            b(true, (b) r0);
        } else if (i2 != 4) {
            super.setText(charSequence, bufferType);
        } else {
            c(true, (b) r0);
        }
    }

    /* renamed from: net.one97.paytm.wallet.newdesign.universalp2p.utils.CustomAmountAnimatedEditText$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f71440a = new int[c.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                net.one97.paytm.wallet.newdesign.universalp2p.utils.CustomAmountAnimatedEditText$c[] r0 = net.one97.paytm.wallet.newdesign.universalp2p.utils.CustomAmountAnimatedEditText.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f71440a = r0
                int[] r0 = f71440a     // Catch:{ NoSuchFieldError -> 0x0014 }
                net.one97.paytm.wallet.newdesign.universalp2p.utils.CustomAmountAnimatedEditText$c r1 = net.one97.paytm.wallet.newdesign.universalp2p.utils.CustomAmountAnimatedEditText.c.POP_IN     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f71440a     // Catch:{ NoSuchFieldError -> 0x001f }
                net.one97.paytm.wallet.newdesign.universalp2p.utils.CustomAmountAnimatedEditText$c r1 = net.one97.paytm.wallet.newdesign.universalp2p.utils.CustomAmountAnimatedEditText.c.BOTTOM_UP     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f71440a     // Catch:{ NoSuchFieldError -> 0x002a }
                net.one97.paytm.wallet.newdesign.universalp2p.utils.CustomAmountAnimatedEditText$c r1 = net.one97.paytm.wallet.newdesign.universalp2p.utils.CustomAmountAnimatedEditText.c.RIGHT_TO_LEFT     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f71440a     // Catch:{ NoSuchFieldError -> 0x0035 }
                net.one97.paytm.wallet.newdesign.universalp2p.utils.CustomAmountAnimatedEditText$c r1 = net.one97.paytm.wallet.newdesign.universalp2p.utils.CustomAmountAnimatedEditText.c.MIDDLE_UP     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.newdesign.universalp2p.utils.CustomAmountAnimatedEditText.AnonymousClass4.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z2, int i2, Rect rect) {
        super.onFocusChanged(z2, i2, rect);
        this.w = this.v && z2;
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        if (this.f71430g) {
            if (this.f71425b == null) {
                invalidate();
                return;
            }
            int i5 = i2 + i4;
            String substring = TextUtils.substring(charSequence, i2, i5);
            int length = charSequence.length();
            if (i4 == 1 && substring.equals(" ")) {
                return;
            }
            if (i3 == i4) {
                this.p = length - 1;
                this.q = length;
            } else if (i3 >= i4 || length != i5 || this.x) {
                this.p = 0;
                this.q = charSequence.length();
            } else {
                AnimatorSet animatorSet = this.t;
                if (animatorSet != null) {
                    animatorSet.cancel();
                    this.t = null;
                }
                if (i3 == 0) {
                    this.p = i2;
                    this.q = i5;
                } else {
                    this.p = length - 1;
                    this.q = length;
                }
                int i6 = AnonymousClass4.f71440a[this.f71432i.ordinal()];
                if (i6 == 1) {
                    d(false, (b) null);
                } else if (i6 == 2) {
                    a(false, (b) null);
                } else if (i6 == 3) {
                    b(false, (b) null);
                } else if (i6 != 4) {
                    this.p = 0;
                    this.q = charSequence.length();
                    invalidate();
                } else {
                    c(false, (b) new b() {
                        public final void onAnimationEnd(Animator animator) {
                            CustomAmountAnimatedEditText.this.getText();
                            CustomAmountAnimatedEditText.this.getText();
                        }
                    });
                }
            }
        }
    }

    private void a(boolean z2, b bVar) {
        int i2;
        float f2 = 0.0f;
        float height = z2 ? 0.0f : (float) ((getHeight() - getCompoundPaddingBottom()) - getCompoundPaddingTop());
        if (z2) {
            f2 = (float) ((getHeight() - getCompoundPaddingBottom()) - getCompoundPaddingTop());
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{height, f2});
        long j2 = 300;
        ofFloat.setDuration(300);
        ofFloat.setInterpolator(new OvershootInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = CustomAmountAnimatedEditText.this.o = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CustomAmountAnimatedEditText.this.invalidate();
            }
        });
        int i3 = z2 ? this.f71429f : 0;
        if (z2) {
            i2 = 0;
        } else {
            i2 = this.f71429f;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i3, i2});
        if (z2) {
            j2 = 100;
        }
        ofInt.setDuration(j2);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                CustomAmountAnimatedEditText.this.f71426c.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        this.t = new AnimatorSet();
        if (bVar != null) {
            this.t.addListener(bVar);
        }
        this.f71424a.clear();
        this.f71424a.add(ofInt);
        this.f71424a.add(ofFloat);
        if (this.w) {
            this.f71424a.add(a(z2));
        }
        this.t.playTogether(this.f71424a);
        this.t.start();
    }

    private void b(boolean z2, b bVar) {
        float f2 = 0.0f;
        float width = z2 ? 0.0f : (float) (getWidth() + (getContext().getResources().getDisplayMetrics().widthPixels - getWidth()));
        if (z2) {
            f2 = (float) (getWidth() + (getContext().getResources().getDisplayMetrics().widthPixels - getWidth()));
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{width, f2});
        ofFloat.setDuration(300);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = CustomAmountAnimatedEditText.this.n = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CustomAmountAnimatedEditText.this.invalidate();
            }
        });
        this.t = new AnimatorSet();
        if (bVar != null) {
            this.t.addListener(bVar);
        }
        this.f71424a.clear();
        this.f71424a.add(ofFloat);
        if (this.w) {
            this.f71424a.add(a(z2));
        }
        this.t.playTogether(this.f71424a);
        this.t.start();
    }

    private void c(boolean z2, b bVar) {
        float f2;
        float f3;
        int i2;
        try {
            final float measureText = this.f71425b.measureText(TextUtils.substring(getText(), 0, this.p));
            if (z2) {
                f2 = measureText;
            } else {
                f2 = (float) (getWidth() / 3);
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f2, z2 ? (float) (getWidth() / 3) : measureText});
            ofFloat.setInterpolator(new DecelerateInterpolator());
            ofFloat.setDuration(150);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float unused = CustomAmountAnimatedEditText.this.n = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    CustomAmountAnimatedEditText customAmountAnimatedEditText = CustomAmountAnimatedEditText.this;
                    float unused2 = customAmountAnimatedEditText.n = customAmountAnimatedEditText.n - measureText;
                    CustomAmountAnimatedEditText.this.invalidate();
                }
            });
            float f4 = 0.0f;
            if (z2) {
                f3 = 0.0f;
            } else {
                f3 = (float) ((getHeight() - getCompoundPaddingBottom()) - getCompoundPaddingTop());
            }
            if (z2) {
                f4 = (float) ((getHeight() - getCompoundPaddingBottom()) - getCompoundPaddingTop());
            }
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{f3, f4});
            ofFloat2.setDuration(200);
            ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float unused = CustomAmountAnimatedEditText.this.o = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    CustomAmountAnimatedEditText.this.invalidate();
                }
            });
            int i3 = z2 ? this.f71429f : 0;
            if (z2) {
                i2 = 0;
            } else {
                i2 = this.f71429f;
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i3, i2});
            ofInt.setDuration(200);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    CustomAmountAnimatedEditText.this.f71426c.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
            this.t = new AnimatorSet();
            this.t.addListener(bVar);
            this.f71424a.clear();
            this.f71424a.add(ofInt);
            this.f71424a.add(ofFloat);
            if (this.w) {
                this.f71424a.add(a(z2));
            }
            this.t.playTogether(this.f71424a);
            this.t.start();
        } catch (IndexOutOfBoundsException e2) {
            q.d(String.valueOf(e2));
        }
    }

    private void d(boolean z2, b bVar) {
        float f2 = 1.0f;
        float textSize = z2 ? getPaint().getTextSize() : 1.0f;
        if (!z2) {
            f2 = getPaint().getTextSize();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{textSize, f2});
        ofFloat.setInterpolator(new OvershootInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                CustomAmountAnimatedEditText.this.f71426c.setTextSize(((Float) valueAnimator.getAnimatedValue()).floatValue());
                CustomAmountAnimatedEditText.this.invalidate();
            }
        });
        this.t = new AnimatorSet();
        if (bVar != null) {
            this.t.addListener(bVar);
        }
        this.f71424a.clear();
        this.f71424a.add(ofFloat);
        if (this.w) {
            this.f71424a.add(a(z2));
        }
        this.t.playTogether(this.f71424a);
        this.t.setDuration(200);
        this.t.start();
    }

    private ValueAnimator a(boolean z2) {
        float f2 = 0.0f;
        float measureText = z2 ? getPaint().measureText(getAnimText()) : 0.0f;
        if (!z2) {
            f2 = getPaint().measureText(getAnimText());
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{measureText, f2});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                CustomAmountAnimatedEditText customAmountAnimatedEditText = CustomAmountAnimatedEditText.this;
                float unused = customAmountAnimatedEditText.u = ((float) customAmountAnimatedEditText.getCompoundPaddingLeft()) + ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        if (isCursorVisible()) {
            ofFloat.addListener(new b() {
                public final void onAnimationStart(Animator animator) {
                    CustomAmountAnimatedEditText.this.setCursorVisible(false);
                }

                public final void onAnimationEnd(Animator animator) {
                    CustomAmountAnimatedEditText.this.setCursorVisible(true);
                    CustomAmountAnimatedEditText customAmountAnimatedEditText = CustomAmountAnimatedEditText.this;
                    customAmountAnimatedEditText.setSelection(customAmountAnimatedEditText.getText().length());
                }
            });
        }
        return ofFloat;
    }

    abstract class b implements Animator.AnimatorListener {
        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }

        b() {
        }
    }

    public static class a implements InputFilter {

        /* renamed from: a  reason: collision with root package name */
        private Pattern f71447a;

        /* renamed from: b  reason: collision with root package name */
        private final int f71448b;

        /* renamed from: c  reason: collision with root package name */
        private final int f71449c;

        public a(int i2, int i3) {
            this.f71448b = i2;
            this.f71449c = i3;
            StringBuilder sb = new StringBuilder("(([₹]{1})?([\\s]{1})?([1-9]{1})([0-9,]{0,");
            sb.append(this.f71448b - 1);
            sb.append("})?)(?:\\.[0-9]{0,");
            sb.append(this.f71449c);
            sb.append("})?");
            this.f71447a = Pattern.compile(sb.toString());
        }

        public final CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
            StringBuilder sb = new StringBuilder(spanned);
            sb.replace(i4, i5, charSequence.subSequence(i2, i3).toString());
            try {
                if (!this.f71447a.matcher(sb.toString()).matches()) {
                    return "";
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public boolean onKeyPreIme(int i2, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1 && this.r != null) {
            getText();
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public void setOnEditTextImeBackListener(d dVar) {
        this.r = dVar;
    }

    public e getRupeeVisibility() {
        return this.s;
    }

    public void setRupeeVisibility(e eVar) {
        this.s = eVar;
    }
}
