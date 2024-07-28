package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.core.widget.i;
import androidx.viewpager.widget.ViewPager;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import java.lang.ref.WeakReference;
import java.util.Locale;

@ViewPager.a
public class PagerTitleStrip extends ViewGroup {
    private static final int[] n = {16842804, 16842901, 16842904, 16842927};
    private static final int[] o = {16843660};

    /* renamed from: a  reason: collision with root package name */
    ViewPager f4944a;

    /* renamed from: b  reason: collision with root package name */
    TextView f4945b;

    /* renamed from: c  reason: collision with root package name */
    TextView f4946c;

    /* renamed from: d  reason: collision with root package name */
    TextView f4947d;

    /* renamed from: e  reason: collision with root package name */
    float f4948e;

    /* renamed from: f  reason: collision with root package name */
    int f4949f;

    /* renamed from: g  reason: collision with root package name */
    private int f4950g;

    /* renamed from: h  reason: collision with root package name */
    private int f4951h;

    /* renamed from: i  reason: collision with root package name */
    private int f4952i;
    private boolean j;
    private boolean k;
    private final a l;
    private WeakReference<a> m;
    private int p;

    static class b extends SingleLineTransformationMethod {

        /* renamed from: a  reason: collision with root package name */
        private Locale f4955a;

        b(Context context) {
            this.f4955a = context.getResources().getConfiguration().locale;
        }

        public final CharSequence getTransformation(CharSequence charSequence, View view) {
            CharSequence transformation = super.getTransformation(charSequence, view);
            if (transformation != null) {
                return transformation.toString().toUpperCase(this.f4955a);
            }
            return null;
        }
    }

    private static void setSingleLineAllCaps(TextView textView) {
        textView.setTransformationMethod(new b(textView.getContext()));
    }

    public PagerTitleStrip(Context context) {
        this(context, (AttributeSet) null);
    }

    public PagerTitleStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4950g = -1;
        this.f4948e = -1.0f;
        this.l = new a();
        TextView textView = new TextView(context);
        this.f4945b = textView;
        addView(textView);
        TextView textView2 = new TextView(context);
        this.f4946c = textView2;
        addView(textView2);
        TextView textView3 = new TextView(context);
        this.f4947d = textView3;
        addView(textView3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, n);
        boolean z = false;
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            i.a(this.f4945b, resourceId);
            i.a(this.f4946c, resourceId);
            i.a(this.f4947d, resourceId);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            setTextSize(0, (float) dimensionPixelSize);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            int color = obtainStyledAttributes.getColor(2, 0);
            this.f4945b.setTextColor(color);
            this.f4946c.setTextColor(color);
            this.f4947d.setTextColor(color);
        }
        this.f4952i = obtainStyledAttributes.getInteger(3, 80);
        obtainStyledAttributes.recycle();
        this.f4949f = this.f4946c.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(0.6f);
        this.f4945b.setEllipsize(TextUtils.TruncateAt.END);
        this.f4946c.setEllipsize(TextUtils.TruncateAt.END);
        this.f4947d.setEllipsize(TextUtils.TruncateAt.END);
        if (resourceId != 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, o);
            z = obtainStyledAttributes2.getBoolean(0, false);
            obtainStyledAttributes2.recycle();
        }
        if (z) {
            setSingleLineAllCaps(this.f4945b);
            setSingleLineAllCaps(this.f4946c);
            setSingleLineAllCaps(this.f4947d);
        } else {
            this.f4945b.setSingleLine();
            this.f4946c.setSingleLine();
            this.f4947d.setSingleLine();
        }
        this.f4951h = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }

    public void setTextSpacing(int i2) {
        this.f4951h = i2;
        requestLayout();
    }

    public int getTextSpacing() {
        return this.f4951h;
    }

    public void setNonPrimaryAlpha(float f2) {
        this.p = ((int) (f2 * 255.0f)) & PriceRangeSeekBar.INVALID_POINTER_ID;
        int i2 = (this.p << 24) | (this.f4949f & 16777215);
        this.f4945b.setTextColor(i2);
        this.f4947d.setTextColor(i2);
    }

    public void setTextColor(int i2) {
        this.f4949f = i2;
        this.f4946c.setTextColor(i2);
        int i3 = (this.p << 24) | (this.f4949f & 16777215);
        this.f4945b.setTextColor(i3);
        this.f4947d.setTextColor(i3);
    }

    public void setTextSize(int i2, float f2) {
        this.f4945b.setTextSize(i2, f2);
        this.f4946c.setTextSize(i2, f2);
        this.f4947d.setTextSize(i2, f2);
    }

    public void setGravity(int i2) {
        this.f4952i = i2;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof ViewPager) {
            ViewPager viewPager = (ViewPager) parent;
            a adapter = viewPager.getAdapter();
            viewPager.setInternalPageChangeListener(this.l);
            viewPager.addOnAdapterChangeListener(this.l);
            this.f4944a = viewPager;
            WeakReference<a> weakReference = this.m;
            a(weakReference != null ? (a) weakReference.get() : null, adapter);
            return;
        }
        throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewPager viewPager = this.f4944a;
        if (viewPager != null) {
            a(viewPager.getAdapter(), (a) null);
            this.f4944a.setInternalPageChangeListener((ViewPager.e) null);
            this.f4944a.removeOnAdapterChangeListener(this.l);
            this.f4944a = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, a aVar) {
        int count = aVar != null ? aVar.getCount() : 0;
        this.j = true;
        CharSequence charSequence = null;
        this.f4945b.setText((i2 <= 0 || aVar == null) ? null : aVar.getPageTitle(i2 - 1));
        this.f4946c.setText((aVar == null || i2 >= count) ? null : aVar.getPageTitle(i2));
        int i3 = i2 + 1;
        if (i3 < count && aVar != null) {
            charSequence = aVar.getPageTitle(i3);
        }
        this.f4947d.setText(charSequence);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((float) ((getWidth() - getPaddingLeft()) - getPaddingRight())) * 0.8f)), Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        this.f4945b.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f4946c.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f4947d.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f4950g = i2;
        if (!this.k) {
            a(i2, this.f4948e, false);
        }
        this.j = false;
    }

    public void requestLayout() {
        if (!this.j) {
            super.requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(a aVar, a aVar2) {
        if (aVar != null) {
            aVar.unregisterDataSetObserver(this.l);
            this.m = null;
        }
        if (aVar2 != null) {
            aVar2.registerDataSetObserver(this.l);
            this.m = new WeakReference<>(aVar2);
        }
        ViewPager viewPager = this.f4944a;
        if (viewPager != null) {
            this.f4950g = -1;
            this.f4948e = -1.0f;
            a(viewPager.getCurrentItem(), aVar2);
            requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, float f2, boolean z) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = i2;
        float f3 = f2;
        if (i7 != this.f4950g) {
            a(i7, this.f4944a.getAdapter());
        } else if (!z && f3 == this.f4948e) {
            return;
        }
        this.k = true;
        int measuredWidth = this.f4945b.getMeasuredWidth();
        int measuredWidth2 = this.f4946c.getMeasuredWidth();
        int measuredWidth3 = this.f4947d.getMeasuredWidth();
        int i8 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i9 = paddingRight + i8;
        int i10 = (width - (paddingLeft + i8)) - i9;
        float f4 = 0.5f + f3;
        if (f4 > 1.0f) {
            f4 -= 1.0f;
        }
        int i11 = ((width - i9) - ((int) (((float) i10) * f4))) - i8;
        int i12 = measuredWidth2 + i11;
        int baseline = this.f4945b.getBaseline();
        int baseline2 = this.f4946c.getBaseline();
        int baseline3 = this.f4947d.getBaseline();
        int max = Math.max(Math.max(baseline, baseline2), baseline3);
        int i13 = max - baseline;
        int i14 = max - baseline2;
        int i15 = max - baseline3;
        int i16 = measuredWidth3;
        int max2 = Math.max(Math.max(this.f4945b.getMeasuredHeight() + i13, this.f4946c.getMeasuredHeight() + i14), this.f4947d.getMeasuredHeight() + i15);
        int i17 = this.f4952i & 112;
        if (i17 == 16) {
            i6 = (((height - paddingTop) - paddingBottom) - max2) / 2;
        } else if (i17 != 80) {
            i5 = i13 + paddingTop;
            i3 = i14 + paddingTop;
            i4 = paddingTop + i15;
            TextView textView = this.f4946c;
            textView.layout(i11, i3, i12, textView.getMeasuredHeight() + i3);
            int min = Math.min(paddingLeft, (i11 - this.f4951h) - measuredWidth);
            TextView textView2 = this.f4945b;
            textView2.layout(min, i5, measuredWidth + min, textView2.getMeasuredHeight() + i5);
            int max3 = Math.max((width - paddingRight) - i16, i12 + this.f4951h);
            TextView textView3 = this.f4947d;
            textView3.layout(max3, i4, max3 + i16, textView3.getMeasuredHeight() + i4);
            this.f4948e = f2;
            this.k = false;
        } else {
            i6 = (height - paddingBottom) - max2;
        }
        i5 = i13 + i6;
        i3 = i14 + i6;
        i4 = i6 + i15;
        TextView textView4 = this.f4946c;
        textView4.layout(i11, i3, i12, textView4.getMeasuredHeight() + i3);
        int min2 = Math.min(paddingLeft, (i11 - this.f4951h) - measuredWidth);
        TextView textView22 = this.f4945b;
        textView22.layout(min2, i5, measuredWidth + min2, textView22.getMeasuredHeight() + i5);
        int max32 = Math.max((width - paddingRight) - i16, i12 + this.f4951h);
        TextView textView32 = this.f4947d;
        textView32.layout(max32, i4, max32 + i16, textView32.getMeasuredHeight() + i4);
        this.f4948e = f2;
        this.k = false;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        if (View.MeasureSpec.getMode(i2) == 1073741824) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int childMeasureSpec = getChildMeasureSpec(i3, paddingTop, -2);
            int size = View.MeasureSpec.getSize(i2);
            int childMeasureSpec2 = getChildMeasureSpec(i2, (int) (((float) size) * 0.2f), -2);
            this.f4945b.measure(childMeasureSpec2, childMeasureSpec);
            this.f4946c.measure(childMeasureSpec2, childMeasureSpec);
            this.f4947d.measure(childMeasureSpec2, childMeasureSpec);
            if (View.MeasureSpec.getMode(i3) == 1073741824) {
                i4 = View.MeasureSpec.getSize(i3);
            } else {
                i4 = Math.max(getMinHeight(), this.f4946c.getMeasuredHeight() + paddingTop);
            }
            setMeasuredDimension(size, View.resolveSizeAndState(i4, i3, this.f4946c.getMeasuredState() << 16));
            return;
        }
        throw new IllegalStateException("Must measure with an exact width");
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (this.f4944a != null) {
            float f2 = this.f4948e;
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            a(this.f4950g, f2, true);
        }
    }

    /* access modifiers changed from: package-private */
    public int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }

    class a extends DataSetObserver implements ViewPager.d, ViewPager.e {

        /* renamed from: b  reason: collision with root package name */
        private int f4954b;

        a() {
        }

        public final void onPageScrolled(int i2, float f2, int i3) {
            if (f2 > 0.5f) {
                i2++;
            }
            PagerTitleStrip.this.a(i2, f2, false);
        }

        public final void onPageSelected(int i2) {
            if (this.f4954b == 0) {
                PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
                pagerTitleStrip.a(pagerTitleStrip.f4944a.getCurrentItem(), PagerTitleStrip.this.f4944a.getAdapter());
                float f2 = 0.0f;
                if (PagerTitleStrip.this.f4948e >= 0.0f) {
                    f2 = PagerTitleStrip.this.f4948e;
                }
                PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
                pagerTitleStrip2.a(pagerTitleStrip2.f4944a.getCurrentItem(), f2, true);
            }
        }

        public final void onPageScrollStateChanged(int i2) {
            this.f4954b = i2;
        }

        public final void onAdapterChanged(ViewPager viewPager, a aVar, a aVar2) {
            PagerTitleStrip.this.a(aVar, aVar2);
        }

        public final void onChanged() {
            PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
            pagerTitleStrip.a(pagerTitleStrip.f4944a.getCurrentItem(), PagerTitleStrip.this.f4944a.getAdapter());
            float f2 = 0.0f;
            if (PagerTitleStrip.this.f4948e >= 0.0f) {
                f2 = PagerTitleStrip.this.f4948e;
            }
            PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
            pagerTitleStrip2.a(pagerTitleStrip2.f4944a.getCurrentItem(), f2, true);
        }
    }
}
