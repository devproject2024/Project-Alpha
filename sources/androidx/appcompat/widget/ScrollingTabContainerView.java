package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.LinearLayoutCompat;

public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {
    private static final Interpolator k = new DecelerateInterpolator();

    /* renamed from: a  reason: collision with root package name */
    Runnable f1575a;

    /* renamed from: b  reason: collision with root package name */
    LinearLayoutCompat f1576b;

    /* renamed from: c  reason: collision with root package name */
    int f1577c;

    /* renamed from: d  reason: collision with root package name */
    int f1578d;

    /* renamed from: e  reason: collision with root package name */
    int f1579e;

    /* renamed from: f  reason: collision with root package name */
    protected ViewPropertyAnimator f1580f;

    /* renamed from: g  reason: collision with root package name */
    protected final c f1581g = new c();

    /* renamed from: h  reason: collision with root package name */
    private Spinner f1582h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f1583i;
    private int j;

    public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public ScrollingTabContainerView(Context context) {
        super(context);
        setHorizontalScrollBarEnabled(false);
        androidx.appcompat.view.a a2 = androidx.appcompat.view.a.a(context);
        setContentHeight(a2.c());
        this.f1578d = a2.e();
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(getContext(), (AttributeSet) null, R.attr.actionBarTabBarStyle);
        linearLayoutCompat.setMeasureWithLargestChildEnabled(true);
        linearLayoutCompat.setGravity(17);
        linearLayoutCompat.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        this.f1576b = linearLayoutCompat;
        addView(this.f1576b, new ViewGroup.LayoutParams(-2, -1));
    }

    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        boolean z = true;
        boolean z2 = mode == 1073741824;
        setFillViewport(z2);
        int childCount = this.f1576b.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.f1577c = -1;
        } else {
            if (childCount > 2) {
                this.f1577c = (int) (((float) View.MeasureSpec.getSize(i2)) * 0.4f);
            } else {
                this.f1577c = View.MeasureSpec.getSize(i2) / 2;
            }
            this.f1577c = Math.min(this.f1577c, this.f1578d);
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f1579e, 1073741824);
        if (z2 || !this.f1583i) {
            z = false;
        }
        if (z) {
            this.f1576b.measure(0, makeMeasureSpec);
            if (this.f1576b.getMeasuredWidth() <= View.MeasureSpec.getSize(i2)) {
                b();
            } else if (!a()) {
                if (this.f1582h == null) {
                    AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), (AttributeSet) null, R.attr.actionDropDownStyle);
                    appCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
                    appCompatSpinner.setOnItemSelectedListener(this);
                    this.f1582h = appCompatSpinner;
                }
                removeView(this.f1576b);
                addView(this.f1582h, new ViewGroup.LayoutParams(-2, -1));
                if (this.f1582h.getAdapter() == null) {
                    this.f1582h.setAdapter(new a());
                }
                Runnable runnable = this.f1575a;
                if (runnable != null) {
                    removeCallbacks(runnable);
                    this.f1575a = null;
                }
                this.f1582h.setSelection(this.j);
            }
        } else {
            b();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i2, makeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (z2 && measuredWidth != measuredWidth2) {
            setTabSelected(this.j);
        }
    }

    private boolean a() {
        Spinner spinner = this.f1582h;
        return spinner != null && spinner.getParent() == this;
    }

    public void setAllowCollapse(boolean z) {
        this.f1583i = z;
    }

    private boolean b() {
        if (!a()) {
            return false;
        }
        removeView(this.f1582h);
        addView(this.f1576b, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.f1582h.getSelectedItemPosition());
        return false;
    }

    public void setTabSelected(int i2) {
        this.j = i2;
        int childCount = this.f1576b.getChildCount();
        int i3 = 0;
        while (i3 < childCount) {
            View childAt = this.f1576b.getChildAt(i3);
            boolean z = i3 == i2;
            childAt.setSelected(z);
            if (z) {
                final View childAt2 = this.f1576b.getChildAt(i2);
                Runnable runnable = this.f1575a;
                if (runnable != null) {
                    removeCallbacks(runnable);
                }
                this.f1575a = new Runnable() {
                    public final void run() {
                        ScrollingTabContainerView.this.smoothScrollTo(childAt2.getLeft() - ((ScrollingTabContainerView.this.getWidth() - childAt2.getWidth()) / 2), 0);
                        ScrollingTabContainerView.this.f1575a = null;
                    }
                };
                post(this.f1575a);
            }
            i3++;
        }
        Spinner spinner = this.f1582h;
        if (spinner != null && i2 >= 0) {
            spinner.setSelection(i2);
        }
    }

    public void setContentHeight(int i2) {
        this.f1579e = i2;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        androidx.appcompat.view.a a2 = androidx.appcompat.view.a.a(getContext());
        setContentHeight(a2.c());
        this.f1578d = a2.e();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f1575a;
        if (runnable != null) {
            post(runnable);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f1575a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    class b extends LinearLayout {

        /* renamed from: a  reason: collision with root package name */
        ActionBar.a f1587a;

        /* renamed from: c  reason: collision with root package name */
        private final int[] f1589c = {16842964};

        /* renamed from: d  reason: collision with root package name */
        private TextView f1590d;

        /* renamed from: e  reason: collision with root package name */
        private ImageView f1591e;

        /* renamed from: f  reason: collision with root package name */
        private View f1592f;

        public b(Context context, ActionBar.a aVar) {
            super(context, (AttributeSet) null, R.attr.actionBarTabStyle);
            this.f1587a = aVar;
            ac a2 = ac.a(context, (AttributeSet) null, this.f1589c, R.attr.actionBarTabStyle, 0);
            if (a2.g(0)) {
                setBackgroundDrawable(a2.a(0));
            }
            a2.f1669a.recycle();
            setGravity(8388627);
            a();
        }

        public final void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }

        public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        public final void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            if (ScrollingTabContainerView.this.f1577c > 0 && getMeasuredWidth() > ScrollingTabContainerView.this.f1577c) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(ScrollingTabContainerView.this.f1577c, 1073741824), i3);
            }
        }

        public final void a() {
            ActionBar.a aVar = this.f1587a;
            View c2 = aVar.c();
            CharSequence charSequence = null;
            if (c2 != null) {
                ViewParent parent = c2.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(c2);
                    }
                    addView(c2);
                }
                this.f1592f = c2;
                TextView textView = this.f1590d;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f1591e;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f1591e.setImageDrawable((Drawable) null);
                    return;
                }
                return;
            }
            View view = this.f1592f;
            if (view != null) {
                removeView(view);
                this.f1592f = null;
            }
            Drawable a2 = aVar.a();
            CharSequence b2 = aVar.b();
            if (a2 != null) {
                if (this.f1591e == null) {
                    AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.f1591e = appCompatImageView;
                }
                this.f1591e.setImageDrawable(a2);
                this.f1591e.setVisibility(0);
            } else {
                ImageView imageView2 = this.f1591e;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.f1591e.setImageDrawable((Drawable) null);
                }
            }
            boolean z = !TextUtils.isEmpty(b2);
            if (z) {
                if (this.f1590d == null) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), (AttributeSet) null, R.attr.actionBarTabTextStyle);
                    appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    appCompatTextView.setLayoutParams(layoutParams2);
                    addView(appCompatTextView);
                    this.f1590d = appCompatTextView;
                }
                this.f1590d.setText(b2);
                this.f1590d.setVisibility(0);
            } else {
                TextView textView2 = this.f1590d;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.f1590d.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.f1591e;
            if (imageView3 != null) {
                imageView3.setContentDescription(aVar.d());
            }
            if (!z) {
                charSequence = aVar.d();
            }
            ae.a(this, charSequence);
        }
    }

    class a extends BaseAdapter {
        public final long getItemId(int i2) {
            return (long) i2;
        }

        a() {
        }

        public final int getCount() {
            return ScrollingTabContainerView.this.f1576b.getChildCount();
        }

        public final Object getItem(int i2) {
            return ((b) ScrollingTabContainerView.this.f1576b.getChildAt(i2)).f1587a;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                ScrollingTabContainerView scrollingTabContainerView = ScrollingTabContainerView.this;
                b bVar = new b(scrollingTabContainerView.getContext(), (ActionBar.a) getItem(i2));
                bVar.setBackgroundDrawable((Drawable) null);
                bVar.setLayoutParams(new AbsListView.LayoutParams(-1, scrollingTabContainerView.f1579e));
                return bVar;
            }
            b bVar2 = (b) view;
            bVar2.f1587a = (ActionBar.a) getItem(i2);
            bVar2.a();
            return view;
        }
    }

    protected class c extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        private boolean f1594b = false;

        /* renamed from: c  reason: collision with root package name */
        private int f1595c;

        protected c() {
        }

        public final void onAnimationStart(Animator animator) {
            ScrollingTabContainerView.this.setVisibility(0);
            this.f1594b = false;
        }

        public final void onAnimationEnd(Animator animator) {
            if (!this.f1594b) {
                ScrollingTabContainerView scrollingTabContainerView = ScrollingTabContainerView.this;
                scrollingTabContainerView.f1580f = null;
                scrollingTabContainerView.setVisibility(this.f1595c);
            }
        }

        public final void onAnimationCancel(Animator animator) {
            this.f1594b = true;
        }
    }
}
