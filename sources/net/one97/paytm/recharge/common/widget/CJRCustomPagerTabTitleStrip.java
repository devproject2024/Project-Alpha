package net.one97.paytm.recharge.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import java.util.Locale;
import net.one97.paytm.recharge.R;

public class CJRCustomPagerTabTitleStrip extends HorizontalScrollView {

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f61864b = {16842901, 16842904};
    private Typeface A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private Locale G;

    /* renamed from: a  reason: collision with root package name */
    public ViewPager.e f61865a;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout.LayoutParams f61866c;

    /* renamed from: d  reason: collision with root package name */
    private LinearLayout.LayoutParams f61867d;

    /* renamed from: e  reason: collision with root package name */
    private final b f61868e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f61869f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public ViewPager f61870g;

    /* renamed from: h  reason: collision with root package name */
    private int f61871h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public int f61872i;
    /* access modifiers changed from: private */
    public float j;
    private Paint k;
    private Paint l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private boolean q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    public interface a {
        int a();
    }

    public CJRCustomPagerTabTitleStrip(Context context) {
        this(context, (AttributeSet) null);
    }

    public CJRCustomPagerTabTitleStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CJRCustomPagerTabTitleStrip(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f61868e = new b(this, (byte) 0);
        this.f61872i = 0;
        this.j = 0.0f;
        this.m = 0;
        this.n = 436207616;
        this.o = 436207616;
        this.p = false;
        this.q = true;
        this.r = 52;
        this.s = 8;
        this.t = 2;
        this.u = 12;
        this.v = 8;
        this.w = 1;
        this.x = 20;
        this.y = -10066330;
        this.z = -16111507;
        this.A = null;
        this.B = 1;
        this.C = 0;
        this.D = 4;
        this.E = 17;
        this.F = R.drawable.background_tab;
        setFillViewport(true);
        setWillNotDraw(false);
        this.f61869f = new LinearLayout(context);
        this.f61869f.setOrientation(0);
        this.f61869f.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.f61869f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.r = (int) TypedValue.applyDimension(1, (float) this.r, displayMetrics);
        this.s = (int) TypedValue.applyDimension(1, (float) this.s, displayMetrics);
        this.t = (int) TypedValue.applyDimension(1, (float) this.t, displayMetrics);
        this.u = (int) TypedValue.applyDimension(1, (float) this.u, displayMetrics);
        this.v = (int) TypedValue.applyDimension(1, (float) this.v, displayMetrics);
        this.w = (int) TypedValue.applyDimension(1, (float) this.w, displayMetrics);
        this.x = (int) TypedValue.applyDimension(2, (float) this.x, displayMetrics);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f61864b);
        this.x = obtainStyledAttributes.getDimensionPixelSize(0, this.x);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.CJRCustomPagerTabTitleStrip);
        this.m = obtainStyledAttributes2.getColor(R.styleable.CJRCustomPagerTabTitleStrip_cpstsIndicatorColor, this.m);
        this.n = obtainStyledAttributes2.getColor(R.styleable.CJRCustomPagerTabTitleStrip_cpstsUnderlineColor, this.n);
        this.o = obtainStyledAttributes2.getColor(R.styleable.CJRCustomPagerTabTitleStrip_cpstsDividerColor, this.o);
        this.z = obtainStyledAttributes2.getColor(R.styleable.CJRCustomPagerTabTitleStrip_cpstsSelectedTextColor, this.y);
        this.s = obtainStyledAttributes2.getDimensionPixelSize(R.styleable.CJRCustomPagerTabTitleStrip_cpstsIndicatorHeight, this.s);
        this.t = obtainStyledAttributes2.getDimensionPixelSize(R.styleable.CJRCustomPagerTabTitleStrip_cpstsUnderlineHeight, this.t);
        this.u = obtainStyledAttributes2.getDimensionPixelSize(R.styleable.CJRCustomPagerTabTitleStrip_cpstsDividerPadding, this.u);
        this.v = obtainStyledAttributes2.getDimensionPixelSize(R.styleable.CJRCustomPagerTabTitleStrip_cpstsTabPaddingLeftRight, this.v);
        this.F = obtainStyledAttributes2.getResourceId(R.styleable.CJRCustomPagerTabTitleStrip_cpstsTabBackground, this.F);
        this.p = obtainStyledAttributes2.getBoolean(R.styleable.CJRCustomPagerTabTitleStrip_cpstsShouldExpand, this.p);
        this.r = obtainStyledAttributes2.getDimensionPixelSize(R.styleable.CJRCustomPagerTabTitleStrip_cpstsScrollOffset, this.r);
        this.q = obtainStyledAttributes2.getBoolean(R.styleable.CJRCustomPagerTabTitleStrip_cpstsTextAllCaps, this.q);
        obtainStyledAttributes2.recycle();
        this.k = new Paint();
        this.k.setAntiAlias(true);
        this.k.setStyle(Paint.Style.FILL);
        this.l = new Paint();
        this.l.setAntiAlias(true);
        this.l.setStrokeWidth((float) this.w);
        this.f61866c = new LinearLayout.LayoutParams(-2, -1);
        this.f61867d = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.G == null) {
            this.G = getResources().getConfiguration().locale;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.f61870g = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.f61868e);
            a();
            return;
        }
        throw new IllegalStateException("ViewPager does not have adapter instance.");
    }

    public void setOnPageChangeListener(ViewPager.e eVar) {
        this.f61865a = eVar;
    }

    private void a() {
        this.f61869f.removeAllViews();
        this.f61871h = this.f61870g.getAdapter().getCount();
        this.f61872i = this.f61870g.getCurrentItem();
        for (int i2 = 0; i2 < this.f61871h; i2++) {
            if (this.f61870g.getAdapter() instanceof a) {
                int a2 = ((a) this.f61870g.getAdapter()).a();
                ImageButton imageButton = new ImageButton(getContext());
                imageButton.setImageResource(a2);
                a(i2, (View) imageButton);
            } else {
                String charSequence = this.f61870g.getAdapter().getPageTitle(i2).toString();
                TextView textView = new TextView(getContext());
                textView.setText(charSequence);
                if (Build.VERSION.SDK_INT >= 17) {
                    textView.setGravity(16);
                    textView.setTextAlignment(this.D);
                } else {
                    textView.setGravity(this.E);
                }
                textView.setSingleLine();
                a(i2, (View) textView);
            }
        }
        b();
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                if (Build.VERSION.SDK_INT < 16) {
                    CJRCustomPagerTabTitleStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    CJRCustomPagerTabTitleStrip.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                CJRCustomPagerTabTitleStrip cJRCustomPagerTabTitleStrip = CJRCustomPagerTabTitleStrip.this;
                int unused = cJRCustomPagerTabTitleStrip.f61872i = cJRCustomPagerTabTitleStrip.f61870g.getCurrentItem();
                CJRCustomPagerTabTitleStrip cJRCustomPagerTabTitleStrip2 = CJRCustomPagerTabTitleStrip.this;
                CJRCustomPagerTabTitleStrip.a(cJRCustomPagerTabTitleStrip2, cJRCustomPagerTabTitleStrip2.f61872i, 0);
            }
        });
    }

    private void a(final int i2, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CJRCustomPagerTabTitleStrip.this.f61870g.setCurrentItem(i2);
                int unused = CJRCustomPagerTabTitleStrip.this.f61872i = i2;
                CJRCustomPagerTabTitleStrip.this.b();
            }
        });
        int i3 = this.v;
        view.setPadding(i3, 0, i3, 0);
        this.f61869f.setGravity(16);
        this.f61869f.addView(view, i2, this.p ? this.f61867d : this.f61866c);
    }

    /* access modifiers changed from: private */
    public void b() {
        for (int i2 = 0; i2 < this.f61871h; i2++) {
            View childAt = this.f61869f.getChildAt(i2);
            childAt.setBackgroundResource(this.F);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (Build.VERSION.SDK_INT >= 17) {
                    textView.setGravity(16);
                    textView.setTextAlignment(this.D);
                } else {
                    textView.setGravity(this.E);
                }
                textView.setTextSize(0, (float) this.x);
                textView.setTypeface(this.A, this.B);
                if (i2 == this.f61872i) {
                    textView.setTextColor(this.z);
                } else {
                    textView.setTextColor(this.y);
                }
                if (this.q) {
                    if (Build.VERSION.SDK_INT >= 14) {
                        textView.setAllCaps(true);
                    } else {
                        textView.setText(textView.getText().toString().toUpperCase(this.G));
                    }
                }
            }
        }
    }

    public void setTitleGravity(int i2) {
        this.D = i2;
        b();
    }

    public void setTitleTypefaceStyle(int i2) {
        this.B = i2;
        b();
    }

    public void setTitleTextColor(int i2) {
        this.z = i2;
        b();
    }

    public void setTitleStyle(int i2, int i3, int i4, int i5, int i6, int i7) {
        this.D = i2;
        this.B = i4;
        this.z = i6;
        this.m = i5;
        this.y = i7;
        this.E = i3;
        b();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i2;
        super.onDraw(canvas);
        if (!isInEditMode() && this.f61871h != 0) {
            int height = getHeight();
            this.k.setColor(this.m);
            View childAt = this.f61869f.getChildAt(this.f61872i);
            float left = (float) childAt.getLeft();
            float right = (float) childAt.getRight();
            if (this.j > 0.0f && (i2 = this.f61872i) < this.f61871h - 1) {
                View childAt2 = this.f61869f.getChildAt(i2 + 1);
                float f2 = this.j;
                left = (((float) childAt2.getLeft()) * f2) + ((1.0f - f2) * left);
                right = (((float) childAt2.getRight()) * f2) + ((1.0f - f2) * right);
            }
            float f3 = (float) height;
            Canvas canvas2 = canvas;
            canvas2.drawRect(left, (float) (height - this.s), right, f3, this.k);
            this.k.setColor(this.n);
            canvas.drawRect(0.0f, (float) (height - this.t), (float) this.f61869f.getWidth(), f3, this.k);
            this.l.setColor(this.o);
            for (int i3 = 0; i3 < this.f61871h - 1; i3++) {
                View childAt3 = this.f61869f.getChildAt(i3);
                canvas.drawLine((float) childAt3.getRight(), (float) this.u, (float) childAt3.getRight(), (float) (height - this.u), this.l);
            }
        }
    }

    class b implements ViewPager.e {
        private b() {
        }

        /* synthetic */ b(CJRCustomPagerTabTitleStrip cJRCustomPagerTabTitleStrip, byte b2) {
            this();
        }

        public final void onPageScrolled(int i2, float f2, int i3) {
            int unused = CJRCustomPagerTabTitleStrip.this.f61872i = i2;
            float unused2 = CJRCustomPagerTabTitleStrip.this.j = f2;
            CJRCustomPagerTabTitleStrip cJRCustomPagerTabTitleStrip = CJRCustomPagerTabTitleStrip.this;
            CJRCustomPagerTabTitleStrip.a(cJRCustomPagerTabTitleStrip, i2, (int) (((float) cJRCustomPagerTabTitleStrip.f61869f.getChildAt(i2).getWidth()) * f2));
            CJRCustomPagerTabTitleStrip.this.invalidate();
            if (CJRCustomPagerTabTitleStrip.this.f61865a != null) {
                CJRCustomPagerTabTitleStrip.this.f61865a.onPageScrolled(i2, f2, i3);
            }
        }

        public final void onPageScrollStateChanged(int i2) {
            if (i2 == 0) {
                CJRCustomPagerTabTitleStrip cJRCustomPagerTabTitleStrip = CJRCustomPagerTabTitleStrip.this;
                CJRCustomPagerTabTitleStrip.a(cJRCustomPagerTabTitleStrip, cJRCustomPagerTabTitleStrip.f61870g.getCurrentItem(), 0);
            }
            if (CJRCustomPagerTabTitleStrip.this.f61865a != null) {
                CJRCustomPagerTabTitleStrip.this.f61865a.onPageScrollStateChanged(i2);
            }
        }

        public final void onPageSelected(int i2) {
            if (CJRCustomPagerTabTitleStrip.this.f61865a != null) {
                CJRCustomPagerTabTitleStrip.this.f61865a.onPageSelected(i2);
            }
        }
    }

    public void setIndicatorColor(int i2) {
        this.m = i2;
        invalidate();
    }

    public void setIndicatorColorResource(int i2) {
        this.m = getResources().getColor(i2);
        invalidate();
    }

    public int getIndicatorColor() {
        return this.m;
    }

    public void setIndicatorHeight(int i2) {
        this.s = i2;
        invalidate();
    }

    public int getIndicatorHeight() {
        return this.s;
    }

    public void setUnderlineColor(int i2) {
        this.n = i2;
        invalidate();
    }

    public void setUnderlineColorResource(int i2) {
        this.n = getResources().getColor(i2);
        invalidate();
    }

    public int getUnderlineColor() {
        return this.n;
    }

    public void setDividerColor(int i2) {
        this.o = i2;
        invalidate();
    }

    public void setDividerColorResource(int i2) {
        this.o = getResources().getColor(i2);
        invalidate();
    }

    public int getDividerColor() {
        return this.o;
    }

    public void setUnderlineHeight(int i2) {
        this.t = i2;
        invalidate();
    }

    public int getUnderlineHeight() {
        return this.t;
    }

    public void setDividerPadding(int i2) {
        this.u = i2;
        invalidate();
    }

    public int getDividerPadding() {
        return this.u;
    }

    public void setScrollOffset(int i2) {
        this.r = i2;
        invalidate();
    }

    public int getScrollOffset() {
        return this.r;
    }

    public void setShouldExpand(boolean z2) {
        this.p = z2;
        requestLayout();
    }

    public boolean getShouldExpand() {
        return this.p;
    }

    public void setAllCaps(boolean z2) {
        this.q = z2;
    }

    public void setTextSize(int i2) {
        this.x = i2;
        b();
    }

    public int getTextSize() {
        return this.x;
    }

    public void setTextColor(int i2) {
        this.y = i2;
        b();
    }

    public void setTextColorResource(int i2) {
        this.y = getResources().getColor(i2);
        b();
    }

    public int getTextColor() {
        return this.y;
    }

    public void setTypeface(Typeface typeface, int i2) {
        this.A = typeface;
        this.B = i2;
        b();
    }

    public void setTabBackground(int i2) {
        this.F = i2;
    }

    public int getTabBackground() {
        return this.F;
    }

    public void setTabPaddingLeftRight(int i2) {
        this.v = i2;
        b();
    }

    public int getTabPaddingLeftRight() {
        return this.v;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f61872i = savedState.f61876a;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f61876a = this.f61872i;
        return savedState;
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new SavedState[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (byte) 0);
            }
        };

        /* renamed from: a  reason: collision with root package name */
        int f61876a;

        /* synthetic */ SavedState(Parcel parcel, byte b2) {
            this(parcel);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f61876a = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f61876a);
        }
    }

    static /* synthetic */ void a(CJRCustomPagerTabTitleStrip cJRCustomPagerTabTitleStrip, int i2, int i3) {
        if (cJRCustomPagerTabTitleStrip.f61871h != 0) {
            int left = cJRCustomPagerTabTitleStrip.f61869f.getChildAt(i2).getLeft() + i3;
            if (i2 > 0 || i3 > 0) {
                left -= cJRCustomPagerTabTitleStrip.r;
            }
            if (left != cJRCustomPagerTabTitleStrip.C) {
                cJRCustomPagerTabTitleStrip.C = left;
                cJRCustomPagerTabTitleStrip.scrollTo(left, 0);
            }
            cJRCustomPagerTabTitleStrip.f61872i = i2;
            cJRCustomPagerTabTitleStrip.b();
        }
    }
}
