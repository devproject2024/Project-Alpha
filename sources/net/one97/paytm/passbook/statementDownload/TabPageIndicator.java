package net.one97.paytm.passbook.statementDownload;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import net.one97.paytm.passbook.R;

public class TabPageIndicator extends HorizontalScrollView implements i {

    /* renamed from: b  reason: collision with root package name */
    private static final CharSequence f58642b = "";

    /* renamed from: a  reason: collision with root package name */
    public b f58643a;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Runnable f58644c;

    /* renamed from: d  reason: collision with root package name */
    private final View.OnClickListener f58645d;

    /* renamed from: e  reason: collision with root package name */
    private final e f58646e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public ViewPager f58647f;

    /* renamed from: g  reason: collision with root package name */
    private ViewPager.e f58648g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public int f58649h;

    /* renamed from: i  reason: collision with root package name */
    private int f58650i;
    /* access modifiers changed from: private */
    public c j;
    private a k;

    public interface a {
        void a(ViewGroup viewGroup, int i2);

        void a(ViewGroup viewGroup, boolean z);
    }

    public interface b {
    }

    public interface c {
    }

    public void setOnTabClickedListener(b bVar) {
        this.f58643a = bVar;
    }

    public TabPageIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    public TabPageIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f58645d = new View.OnClickListener() {
            public final void onClick(View view) {
                if (!(TabPageIndicator.this.f58647f instanceof SmartViewPager) || ((SmartViewPager) TabPageIndicator.this.f58647f).f58606a) {
                    int currentItem = TabPageIndicator.this.f58647f.getCurrentItem();
                    int i2 = ((d) view).f58654a;
                    TabPageIndicator.this.f58647f.setCurrentItem(i2);
                    if (currentItem == i2 && TabPageIndicator.this.j != null) {
                        c unused = TabPageIndicator.this.j;
                    }
                }
            }
        };
        setHorizontalScrollBarEnabled(false);
        this.f58646e = new e(context, R.attr.vpiTabPageIndicatorStyle);
        addView(this.f58646e, new ViewGroup.LayoutParams(-2, -1));
    }

    public void setOnTabReselectedListener(c cVar) {
        this.j = cVar;
    }

    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.f58646e.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.f58649h = -1;
        } else if (childCount > 2) {
            this.f58649h = (int) (((float) View.MeasureSpec.getSize(i2)) * 0.4f);
        } else {
            this.f58649h = View.MeasureSpec.getSize(i2) / 2;
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i2, i3);
        int measuredWidth2 = getMeasuredWidth();
        if (z && measuredWidth != measuredWidth2) {
            setCurrentItem(this.f58650i);
        }
    }

    private void b(int i2) {
        final View childAt = this.f58646e.getChildAt(i2);
        Runnable runnable = this.f58644c;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        this.f58644c = new Runnable() {
            public final void run() {
                TabPageIndicator.this.smoothScrollTo(childAt.getLeft() - ((TabPageIndicator.this.getWidth() - childAt.getWidth()) / 2), 0);
                Runnable unused = TabPageIndicator.this.f58644c = null;
            }
        };
        post(this.f58644c);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f58644c;
        if (runnable != null) {
            post(runnable);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f58644c;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    public void onPageScrollStateChanged(int i2) {
        ViewPager.e eVar = this.f58648g;
        if (eVar != null) {
            eVar.onPageScrollStateChanged(i2);
        }
    }

    public void onPageScrolled(int i2, float f2, int i3) {
        ViewPager.e eVar = this.f58648g;
        if (eVar != null) {
            eVar.onPageScrolled(i2, f2, i3);
        }
    }

    public void onPageSelected(int i2) {
        setCurrentItem(i2);
        ViewPager.e eVar = this.f58648g;
        if (eVar != null) {
            eVar.onPageSelected(i2);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        ViewPager viewPager2 = this.f58647f;
        if (viewPager2 != viewPager) {
            if (viewPager2 != null) {
                viewPager2.setOnPageChangeListener((ViewPager.e) null);
            }
            if (viewPager.getAdapter() != null) {
                this.f58647f = viewPager;
                if (this.f58647f.getAdapter() instanceof a) {
                    this.k = (a) this.f58647f.getAdapter();
                }
                viewPager.setOnPageChangeListener(this);
                this.f58646e.removeAllViews();
                androidx.viewpager.widget.a adapter = this.f58647f.getAdapter();
                int count = adapter.getCount();
                for (int i2 = 0; i2 < count; i2++) {
                    a aVar = this.k;
                    if (aVar == null) {
                        CharSequence pageTitle = adapter.getPageTitle(i2);
                        if (pageTitle == null) {
                            pageTitle = f58642b;
                        }
                        d dVar = new d(getContext());
                        int unused = dVar.f58654a = i2;
                        dVar.setFocusable(true);
                        dVar.setOnClickListener(this.f58645d);
                        dVar.setText(pageTitle);
                        this.f58646e.addView(dVar, new LinearLayout.LayoutParams(0, -1, 1.0f));
                    } else {
                        aVar.a((ViewGroup) this.f58646e, i2);
                    }
                }
                if (this.f58650i > count) {
                    this.f58650i = count - 1;
                }
                setCurrentItem(this.f58650i);
                requestLayout();
            }
        }
    }

    public void setViewPager(ViewPager viewPager, int i2) {
        setViewPager(viewPager);
        setCurrentItem(i2);
    }

    public void setCurrentItem(int i2) {
        ViewPager viewPager = this.f58647f;
        if (viewPager != null) {
            this.f58650i = i2;
            viewPager.setCurrentItem(i2);
            int childCount = this.f58646e.getChildCount();
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = this.f58646e.getChildAt(i3);
                boolean z = i3 == i2;
                childAt.setSelected(z);
                a aVar = this.k;
                if (aVar != null) {
                    try {
                        aVar.a((ViewGroup) childAt, z);
                        if (z) {
                            b(i2);
                        }
                    } catch (Exception unused) {
                    }
                } else if (z) {
                    b(i2);
                }
                childAt.setSelected(z);
                if (z) {
                    b(i2);
                }
                i3++;
            }
        }
    }

    public void setOnPageChangeListener(ViewPager.e eVar) {
        this.f58648g = eVar;
    }

    class d extends TextView {
        /* access modifiers changed from: package-private */

        /* renamed from: a  reason: collision with root package name */
        public int f58654a;

        public d(Context context) {
            super(context, (AttributeSet) null, R.attr.vpiTabPageIndicatorStyle);
        }

        public final void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            if (TabPageIndicator.this.f58649h > 0 && getMeasuredWidth() > TabPageIndicator.this.f58649h) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(TabPageIndicator.this.f58649h, 0), i3);
            }
        }
    }

    public final View a(int i2) {
        e eVar = this.f58646e;
        if (eVar == null || eVar.getChildAt(i2) == null) {
            return null;
        }
        return this.f58646e.getChildAt(i2);
    }
}
