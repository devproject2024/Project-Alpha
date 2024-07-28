package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.cardview.R;

public class CardView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f1959e = {16842801};

    /* renamed from: f  reason: collision with root package name */
    private static final e f1960f;

    /* renamed from: a  reason: collision with root package name */
    int f1961a;

    /* renamed from: b  reason: collision with root package name */
    int f1962b;

    /* renamed from: c  reason: collision with root package name */
    final Rect f1963c;

    /* renamed from: d  reason: collision with root package name */
    final Rect f1964d;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1965g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1966h;

    /* renamed from: i  reason: collision with root package name */
    private final d f1967i;

    public void setPadding(int i2, int i3, int i4, int i5) {
    }

    public void setPaddingRelative(int i2, int i3, int i4, int i5) {
    }

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            f1960f = new b();
        } else if (Build.VERSION.SDK_INT >= 17) {
            f1960f = new a();
        } else {
            f1960f = new c();
        }
        f1960f.a();
    }

    public CardView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.cardViewStyle);
    }

    public CardView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        int i3;
        ColorStateList valueOf;
        this.f1963c = new Rect();
        this.f1964d = new Rect();
        this.f1967i = new d() {

            /* renamed from: b  reason: collision with root package name */
            private Drawable f1969b;

            public final void a(Drawable drawable) {
                this.f1969b = drawable;
                CardView.this.setBackgroundDrawable(drawable);
            }

            public final boolean a() {
                return CardView.this.getUseCompatPadding();
            }

            public final boolean b() {
                return CardView.this.getPreventCornerOverlap();
            }

            public final void a(int i2, int i3, int i4, int i5) {
                CardView.this.f1964d.set(i2, i3, i4, i5);
                CardView cardView = CardView.this;
                CardView.super.setPadding(i2 + cardView.f1963c.left, i3 + CardView.this.f1963c.top, i4 + CardView.this.f1963c.right, i5 + CardView.this.f1963c.bottom);
            }

            public final void a(int i2, int i3) {
                if (i2 > CardView.this.f1961a) {
                    CardView.super.setMinimumWidth(i2);
                }
                if (i3 > CardView.this.f1962b) {
                    CardView.super.setMinimumHeight(i3);
                }
            }

            public final Drawable c() {
                return this.f1969b;
            }

            public final View d() {
                return CardView.this;
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CardView, i2, R.style.CardView);
        if (obtainStyledAttributes.hasValue(R.styleable.CardView_cardBackgroundColor)) {
            valueOf = obtainStyledAttributes.getColorStateList(R.styleable.CardView_cardBackgroundColor);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(f1959e);
            int color = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            if (fArr[2] > 0.5f) {
                i3 = getResources().getColor(R.color.cardview_light_background);
            } else {
                i3 = getResources().getColor(R.color.cardview_dark_background);
            }
            valueOf = ColorStateList.valueOf(i3);
        }
        ColorStateList colorStateList = valueOf;
        float dimension = obtainStyledAttributes.getDimension(R.styleable.CardView_cardCornerRadius, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(R.styleable.CardView_cardElevation, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(R.styleable.CardView_cardMaxElevation, 0.0f);
        this.f1965g = obtainStyledAttributes.getBoolean(R.styleable.CardView_cardUseCompatPadding, false);
        this.f1966h = obtainStyledAttributes.getBoolean(R.styleable.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CardView_contentPadding, 0);
        this.f1963c.left = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CardView_contentPaddingLeft, dimensionPixelSize);
        this.f1963c.top = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CardView_contentPaddingTop, dimensionPixelSize);
        this.f1963c.right = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CardView_contentPaddingRight, dimensionPixelSize);
        this.f1963c.bottom = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CardView_contentPaddingBottom, dimensionPixelSize);
        float f2 = dimension2 > dimension3 ? dimension2 : dimension3;
        this.f1961a = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CardView_android_minWidth, 0);
        this.f1962b = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CardView_android_minHeight, 0);
        obtainStyledAttributes.recycle();
        f1960f.a(this.f1967i, context, colorStateList, dimension, dimension2, f2);
    }

    public boolean getUseCompatPadding() {
        return this.f1965g;
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f1965g != z) {
            this.f1965g = z;
            f1960f.g(this.f1967i);
        }
    }

    public void setContentPadding(int i2, int i3, int i4, int i5) {
        this.f1963c.set(i2, i3, i4, i5);
        f1960f.f(this.f1967i);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (!(f1960f instanceof b)) {
            int mode = View.MeasureSpec.getMode(i2);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i2 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) f1960f.b(this.f1967i)), View.MeasureSpec.getSize(i2)), mode);
            }
            int mode2 = View.MeasureSpec.getMode(i3);
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i3 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) f1960f.c(this.f1967i)), View.MeasureSpec.getSize(i3)), mode2);
            }
            super.onMeasure(i2, i3);
            return;
        }
        super.onMeasure(i2, i3);
    }

    public void setMinimumWidth(int i2) {
        this.f1961a = i2;
        super.setMinimumWidth(i2);
    }

    public void setMinimumHeight(int i2) {
        this.f1962b = i2;
        super.setMinimumHeight(i2);
    }

    public void setCardBackgroundColor(int i2) {
        f1960f.a(this.f1967i, ColorStateList.valueOf(i2));
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        f1960f.a(this.f1967i, colorStateList);
    }

    public ColorStateList getCardBackgroundColor() {
        return f1960f.i(this.f1967i);
    }

    public int getContentPaddingLeft() {
        return this.f1963c.left;
    }

    public int getContentPaddingRight() {
        return this.f1963c.right;
    }

    public int getContentPaddingTop() {
        return this.f1963c.top;
    }

    public int getContentPaddingBottom() {
        return this.f1963c.bottom;
    }

    public void setRadius(float f2) {
        f1960f.a(this.f1967i, f2);
    }

    public float getRadius() {
        return f1960f.d(this.f1967i);
    }

    public void setCardElevation(float f2) {
        f1960f.c(this.f1967i, f2);
    }

    public float getCardElevation() {
        return f1960f.e(this.f1967i);
    }

    public void setMaxCardElevation(float f2) {
        f1960f.b(this.f1967i, f2);
    }

    public float getMaxCardElevation() {
        return f1960f.a(this.f1967i);
    }

    public boolean getPreventCornerOverlap() {
        return this.f1966h;
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.f1966h) {
            this.f1966h = z;
            f1960f.h(this.f1967i);
        }
    }
}
