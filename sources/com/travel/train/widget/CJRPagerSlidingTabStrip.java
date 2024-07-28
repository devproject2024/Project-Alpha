package com.travel.train.widget;

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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.travel.train.R;
import java.util.Locale;

public class CJRPagerSlidingTabStrip extends HorizontalScrollView {

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f28325b = {16842901, 16842904};
    private int A;
    private int B;
    private int C;
    private Typeface D;
    private int E;
    private int F;
    private int G;
    private Locale H;

    /* renamed from: a  reason: collision with root package name */
    public ViewPager.e f28326a;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout.LayoutParams f28327c;

    /* renamed from: d  reason: collision with root package name */
    private LinearLayout.LayoutParams f28328d;

    /* renamed from: e  reason: collision with root package name */
    private final c f28329e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f28330f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public ViewPager f28331g;

    /* renamed from: h  reason: collision with root package name */
    private LayoutInflater f28332h;

    /* renamed from: i  reason: collision with root package name */
    private int f28333i;
    /* access modifiers changed from: private */
    public int j;
    /* access modifiers changed from: private */
    public int k;
    /* access modifiers changed from: private */
    public float l;
    private Paint m;
    private Paint n;
    private int o;
    private int p;
    private int q;
    private boolean r;
    private boolean s;
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

    public interface b {
    }

    public CJRPagerSlidingTabStrip(Context context) {
        this(context, (AttributeSet) null);
        a(context);
    }

    public CJRPagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        a(context);
    }

    private void a(Context context) {
        this.f28332h = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public CJRPagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f28329e = new c(this, (byte) 0);
        this.j = 0;
        this.k = 0;
        this.l = 0.0f;
        this.o = -10066330;
        this.p = 436207616;
        this.q = 436207616;
        this.r = false;
        this.s = true;
        this.t = 52;
        this.u = 8;
        this.v = 2;
        this.w = 12;
        this.x = 24;
        this.y = 1;
        this.z = 0;
        this.A = -1;
        this.B = 12;
        this.C = -10066330;
        this.D = null;
        this.E = 1;
        this.F = 0;
        this.G = R.drawable.pre_t_train_train_background_tab;
        setFillViewport(true);
        setWillNotDraw(false);
        this.f28330f = new LinearLayout(context);
        this.f28330f.setOrientation(0);
        this.f28330f.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.f28330f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.t = (int) TypedValue.applyDimension(1, (float) this.t, displayMetrics);
        this.u = (int) TypedValue.applyDimension(1, (float) this.u, displayMetrics);
        this.v = (int) TypedValue.applyDimension(1, (float) this.v, displayMetrics);
        this.w = (int) TypedValue.applyDimension(1, (float) this.w, displayMetrics);
        this.x = (int) TypedValue.applyDimension(1, (float) this.x, displayMetrics);
        this.y = (int) TypedValue.applyDimension(1, (float) this.y, displayMetrics);
        this.B = (int) TypedValue.applyDimension(2, (float) this.B, displayMetrics);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f28325b);
        this.B = obtainStyledAttributes.getDimensionPixelSize(0, this.B);
        this.C = obtainStyledAttributes.getColor(1, this.C);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.PagerSlidingTabStrip);
        this.o = obtainStyledAttributes2.getColor(R.styleable.PagerSlidingTabStrip_pstsIndicatorColor, this.o);
        this.p = obtainStyledAttributes2.getColor(R.styleable.PagerSlidingTabStrip_pstsUnderlineColor, this.p);
        this.q = obtainStyledAttributes2.getColor(R.styleable.PagerSlidingTabStrip_pstsDividerColor, this.q);
        this.u = obtainStyledAttributes2.getDimensionPixelSize(R.styleable.PagerSlidingTabStrip_pstsIndicatorHeight, this.u);
        this.v = obtainStyledAttributes2.getDimensionPixelSize(R.styleable.PagerSlidingTabStrip_pstsUnderlineHeight, this.v);
        this.w = obtainStyledAttributes2.getDimensionPixelSize(R.styleable.PagerSlidingTabStrip_pstsDividerPadding, this.w);
        this.x = obtainStyledAttributes2.getDimensionPixelSize(R.styleable.PagerSlidingTabStrip_pstsTabPaddingLeftRight, this.x);
        this.G = obtainStyledAttributes2.getResourceId(R.styleable.PagerSlidingTabStrip_pstsTabBackground, this.G);
        this.r = obtainStyledAttributes2.getBoolean(R.styleable.PagerSlidingTabStrip_pstsShouldExpand, this.r);
        this.t = obtainStyledAttributes2.getDimensionPixelSize(R.styleable.PagerSlidingTabStrip_pstsScrollOffset, this.t);
        this.s = obtainStyledAttributes2.getBoolean(R.styleable.PagerSlidingTabStrip_pstsTextAllCaps, this.s);
        obtainStyledAttributes2.recycle();
        this.m = new Paint();
        this.m.setAntiAlias(true);
        this.m.setStyle(Paint.Style.FILL);
        this.n = new Paint();
        this.n.setAntiAlias(true);
        this.n.setStrokeWidth((float) this.y);
        this.f28327c = new LinearLayout.LayoutParams(-2, -1);
        this.f28328d = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.H == null) {
            this.H = getResources().getConfiguration().locale;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.f28331g = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.f28329e);
            a();
            return;
        }
        throw new IllegalStateException("ViewPager does not have adapter instance.");
    }

    public void setOnPageChangeListener(ViewPager.e eVar) {
        this.f28326a = eVar;
    }

    private void a() {
        this.f28330f.removeAllViews();
        this.f28333i = this.f28331g.getAdapter().getCount();
        for (int i2 = 0; i2 < this.f28333i; i2++) {
            if (this.f28331g.getAdapter() instanceof a) {
                int a2 = ((a) this.f28331g.getAdapter()).a();
                ImageButton imageButton = new ImageButton(getContext());
                imageButton.setImageResource(a2);
                a(i2, (View) imageButton);
            } else if (this.f28331g.getAdapter() instanceof b) {
                String charSequence = this.f28331g.getAdapter().getPageTitle(i2).toString();
                this.f28331g.getAdapter();
                View inflate = this.f28332h.inflate(R.layout.pre_t_lyt_tab_item, (ViewGroup) null);
                if (this.z > 0) {
                    ((LinearLayout) inflate.findViewById(R.id.lyt_tab_container)).getLayoutParams().width = this.z;
                }
                TextView textView = (TextView) inflate.findViewById(R.id.txt_tab);
                getContext();
                com.paytm.utility.b.c(textView);
                textView.setText(charSequence);
                a(i2, inflate);
            } else {
                String charSequence2 = this.f28331g.getAdapter().getPageTitle(i2).toString();
                TextView textView2 = new TextView(getContext());
                textView2.setText(charSequence2);
                textView2.setGravity(17);
                textView2.setSingleLine();
                a(i2, (View) textView2);
            }
        }
        b();
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                if (Build.VERSION.SDK_INT < 16) {
                    CJRPagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    CJRPagerSlidingTabStrip.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                CJRPagerSlidingTabStrip cJRPagerSlidingTabStrip = CJRPagerSlidingTabStrip.this;
                int unused = cJRPagerSlidingTabStrip.k = cJRPagerSlidingTabStrip.f28331g.getCurrentItem();
                CJRPagerSlidingTabStrip cJRPagerSlidingTabStrip2 = CJRPagerSlidingTabStrip.this;
                CJRPagerSlidingTabStrip.a(cJRPagerSlidingTabStrip2, cJRPagerSlidingTabStrip2.k, 0);
            }
        });
    }

    private void a(final int i2, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CJRPagerSlidingTabStrip.this.f28331g.setCurrentItem(i2);
            }
        });
        int i3 = this.x;
        view.setPadding(i3, 0, i3, 0);
        this.f28330f.addView(view, i2, this.r ? this.f28328d : this.f28327c);
    }

    private void b() {
        for (int i2 = 0; i2 < this.f28333i; i2++) {
            View childAt = this.f28330f.getChildAt(i2);
            childAt.setBackgroundResource(this.G);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                textView.setTextSize(0, (float) this.B);
                textView.setTypeface(this.D, this.E);
                textView.setTextColor(this.C);
                if (this.s) {
                    if (Build.VERSION.SDK_INT >= 14) {
                        textView.setAllCaps(true);
                    } else {
                        textView.setText(textView.getText().toString().toUpperCase(this.H));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i2;
        TextView textView;
        super.onDraw(canvas);
        if (!isInEditMode() && this.f28333i != 0) {
            int height = getHeight();
            this.m.setColor(this.o);
            int i3 = 0;
            while (true) {
                boolean z2 = true;
                if (i3 >= this.f28330f.getChildCount()) {
                    break;
                }
                View childAt = this.f28330f.getChildAt(i3);
                if (!(childAt == null || (textView = (TextView) childAt.findViewById(R.id.txt_tab)) == null)) {
                    if (i3 != this.j) {
                        z2 = false;
                    }
                    textView.setSelected(z2);
                }
                i3++;
            }
            View childAt2 = this.f28330f.getChildAt(this.k);
            float left = (float) childAt2.getLeft();
            float right = (float) childAt2.getRight();
            if (this.l > 0.0f && (i2 = this.k) < this.f28333i - 1) {
                View childAt3 = this.f28330f.getChildAt(i2 + 1);
                float f2 = this.l;
                left = (((float) childAt3.getLeft()) * f2) + ((1.0f - f2) * left);
                right = (((float) childAt3.getRight()) * f2) + ((1.0f - f2) * right);
            }
            float f3 = (float) height;
            Canvas canvas2 = canvas;
            canvas2.drawRect(left, (float) (height - this.u), right, f3, this.m);
            this.m.setColor(this.p);
            canvas.drawRect(0.0f, (float) (height - this.v), (float) this.f28330f.getWidth(), f3, this.m);
            this.n.setColor(this.q);
            for (int i4 = 0; i4 < this.f28333i - 1; i4++) {
                View childAt4 = this.f28330f.getChildAt(i4);
                canvas.drawLine((float) childAt4.getRight(), (float) this.w, (float) childAt4.getRight(), (float) (height - this.w), this.n);
            }
        }
    }

    class c implements ViewPager.e {
        private c() {
        }

        /* synthetic */ c(CJRPagerSlidingTabStrip cJRPagerSlidingTabStrip, byte b2) {
            this();
        }

        public final void onPageScrolled(int i2, float f2, int i3) {
            int unused = CJRPagerSlidingTabStrip.this.k = i2;
            float unused2 = CJRPagerSlidingTabStrip.this.l = f2;
            CJRPagerSlidingTabStrip cJRPagerSlidingTabStrip = CJRPagerSlidingTabStrip.this;
            CJRPagerSlidingTabStrip.a(cJRPagerSlidingTabStrip, i2, (int) (((float) cJRPagerSlidingTabStrip.f28330f.getChildAt(i2).getWidth()) * f2));
            CJRPagerSlidingTabStrip.this.invalidate();
            if (CJRPagerSlidingTabStrip.this.f28326a != null) {
                CJRPagerSlidingTabStrip.this.f28326a.onPageScrolled(i2, f2, i3);
            }
        }

        public final void onPageScrollStateChanged(int i2) {
            if (i2 == 0) {
                CJRPagerSlidingTabStrip cJRPagerSlidingTabStrip = CJRPagerSlidingTabStrip.this;
                CJRPagerSlidingTabStrip.a(cJRPagerSlidingTabStrip, cJRPagerSlidingTabStrip.f28331g.getCurrentItem(), 0);
            }
            if (CJRPagerSlidingTabStrip.this.f28326a != null) {
                CJRPagerSlidingTabStrip.this.f28326a.onPageScrollStateChanged(i2);
            }
        }

        public final void onPageSelected(int i2) {
            if (CJRPagerSlidingTabStrip.this.f28326a != null) {
                CJRPagerSlidingTabStrip.this.f28326a.onPageSelected(i2);
            }
            int unused = CJRPagerSlidingTabStrip.this.j = i2;
            CJRPagerSlidingTabStrip.this.invalidate();
        }
    }

    public void setIndicatorColor(int i2) {
        this.o = i2;
        invalidate();
    }

    public void setIndicatorColorResource(int i2) {
        this.o = getResources().getColor(i2);
        invalidate();
    }

    public int getIndicatorColor() {
        return this.o;
    }

    public void setIndicatorHeight(int i2) {
        this.u = i2;
        invalidate();
    }

    public int getIndicatorHeight() {
        return this.u;
    }

    public void setUnderlineColor(int i2) {
        this.p = i2;
        invalidate();
    }

    public void setUnderlineColorResource(int i2) {
        this.p = getResources().getColor(i2);
        invalidate();
    }

    public int getUnderlineColor() {
        return this.p;
    }

    public void setDividerColor(int i2) {
        this.q = i2;
        invalidate();
    }

    public void setDividerColorResource(int i2) {
        this.q = getResources().getColor(i2);
        invalidate();
    }

    public int getDividerColor() {
        return this.q;
    }

    public void setUnderlineHeight(int i2) {
        this.v = i2;
        invalidate();
    }

    public int getUnderlineHeight() {
        return this.v;
    }

    public void setDividerPadding(int i2) {
        this.w = i2;
        invalidate();
    }

    public int getDividerPadding() {
        return this.w;
    }

    public void setScrollOffset(int i2) {
        this.t = i2;
        invalidate();
    }

    public int getScrollOffset() {
        return this.t;
    }

    public void setShouldExpand(boolean z2) {
        this.r = z2;
        requestLayout();
    }

    public boolean getShouldExpand() {
        return this.r;
    }

    public void setAllCaps(boolean z2) {
        this.s = z2;
    }

    public void setTextSize(int i2) {
        this.B = i2;
        b();
    }

    public int getTextSize() {
        return this.B;
    }

    public void setTextColor(int i2) {
        this.C = i2;
        b();
    }

    public void setTextColorResource(int i2) {
        this.C = getResources().getColor(i2);
        b();
    }

    public int getTextColor() {
        return this.C;
    }

    public void setTypeface(Typeface typeface, int i2) {
        this.D = typeface;
        this.E = i2;
        b();
    }

    public void setTabBackground(int i2) {
        this.G = i2;
    }

    public int getTabBackground() {
        return this.G;
    }

    public void setTabPaddingLeftRight(int i2) {
        this.x = i2;
        b();
    }

    public int getTabPaddingLeftRight() {
        return this.x;
    }

    public void setTabItemWidth(int i2) {
        this.z = i2;
    }

    public void setTabIconHeight(int i2) {
        this.A = i2;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.k = savedState.f28337a;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f28337a = this.k;
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
        int f28337a;

        /* synthetic */ SavedState(Parcel parcel, byte b2) {
            this(parcel);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f28337a = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f28337a);
        }
    }

    static /* synthetic */ void a(CJRPagerSlidingTabStrip cJRPagerSlidingTabStrip, int i2, int i3) {
        if (cJRPagerSlidingTabStrip.f28333i != 0) {
            int left = cJRPagerSlidingTabStrip.f28330f.getChildAt(i2).getLeft() + i3;
            if (i2 > 0 || i3 > 0) {
                left -= cJRPagerSlidingTabStrip.t;
            }
            if (left != cJRPagerSlidingTabStrip.F) {
                cJRPagerSlidingTabStrip.F = left;
                cJRPagerSlidingTabStrip.scrollTo(left, 0);
            }
        }
    }
}
