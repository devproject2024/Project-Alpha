package net.one97.paytm.recharge.legacy.catalog.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.paytm.utility.q;
import net.one97.paytm.common.widgets.SmartViewPager;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.ao;

@Deprecated
public class TabPageIndicator extends HorizontalScrollView implements ao {

    /* renamed from: b  reason: collision with root package name */
    private static final CharSequence f62998b = "";

    /* renamed from: a  reason: collision with root package name */
    public b f62999a;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Runnable f63000c;

    /* renamed from: d  reason: collision with root package name */
    private final View.OnClickListener f63001d;

    /* renamed from: e  reason: collision with root package name */
    private final a f63002e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public ViewPager f63003f;

    /* renamed from: g  reason: collision with root package name */
    private ViewPager.e f63004g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public int f63005h;

    /* renamed from: i  reason: collision with root package name */
    private int f63006i;
    /* access modifiers changed from: private */
    public c j;
    private a k;

    public interface a {
    }

    public interface b {
    }

    public interface c {
    }

    public void setOnTabClickedListener(b bVar) {
        this.f62999a = bVar;
    }

    public TabPageIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    public TabPageIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f63001d = new View.OnClickListener() {
            public final void onClick(View view) {
                if (!(TabPageIndicator.this.f63003f instanceof SmartViewPager) || ((SmartViewPager) TabPageIndicator.this.f63003f).f49875a) {
                    int currentItem = TabPageIndicator.this.f63003f.getCurrentItem();
                    int i2 = ((d) view).f63010a;
                    TabPageIndicator.this.f63003f.setCurrentItem(i2);
                    if (currentItem == i2 && TabPageIndicator.this.j != null) {
                        c unused = TabPageIndicator.this.j;
                    }
                }
            }
        };
        setHorizontalScrollBarEnabled(false);
        this.f63002e = new a(context, R.attr.vpiTabPageIndicatorStyle);
        addView(this.f63002e, new ViewGroup.LayoutParams(-2, -1));
    }

    public void setOnTabReselectedListener(c cVar) {
        this.j = cVar;
    }

    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.f63002e.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.f63005h = -1;
        } else if (childCount > 2) {
            this.f63005h = (int) (((float) View.MeasureSpec.getSize(i2)) * 0.4f);
        } else {
            this.f63005h = View.MeasureSpec.getSize(i2) / 2;
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i2, i3);
        int measuredWidth2 = getMeasuredWidth();
        if (z && measuredWidth != measuredWidth2) {
            setCurrentItem(this.f63006i);
        }
    }

    private void a(int i2) {
        final View childAt = this.f63002e.getChildAt(i2);
        Runnable runnable = this.f63000c;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        this.f63000c = new Runnable() {
            public final void run() {
                TabPageIndicator.this.smoothScrollTo(childAt.getLeft() - ((TabPageIndicator.this.getWidth() - childAt.getWidth()) / 2), 0);
                Runnable unused = TabPageIndicator.this.f63000c = null;
            }
        };
        post(this.f63000c);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f63000c;
        if (runnable != null) {
            post(runnable);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f63000c;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    public void onPageScrollStateChanged(int i2) {
        ViewPager.e eVar = this.f63004g;
        if (eVar != null) {
            eVar.onPageScrollStateChanged(i2);
        }
    }

    public void onPageScrolled(int i2, float f2, int i3) {
        ViewPager.e eVar = this.f63004g;
        if (eVar != null) {
            eVar.onPageScrolled(i2, f2, i3);
        }
    }

    public void onPageSelected(int i2) {
        setCurrentItem(i2);
        ViewPager.e eVar = this.f63004g;
        if (eVar != null) {
            eVar.onPageSelected(i2);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        ViewPager viewPager2 = this.f63003f;
        if (viewPager2 != viewPager) {
            if (viewPager2 != null) {
                viewPager2.setOnPageChangeListener((ViewPager.e) null);
            }
            if (viewPager.getAdapter() != null) {
                this.f63003f = viewPager;
                if (this.f63003f.getAdapter() instanceof a) {
                    this.k = (a) this.f63003f.getAdapter();
                }
                viewPager.setOnPageChangeListener(this);
                this.f63002e.removeAllViews();
                androidx.viewpager.widget.a adapter = this.f63003f.getAdapter();
                int count = adapter.getCount();
                for (int i2 = 0; i2 < count; i2++) {
                    if (this.k == null) {
                        CharSequence pageTitle = adapter.getPageTitle(i2);
                        if (pageTitle == null) {
                            pageTitle = f62998b;
                        }
                        d dVar = new d(getContext());
                        int unused = dVar.f63010a = i2;
                        dVar.setFocusable(true);
                        dVar.setOnClickListener(this.f63001d);
                        dVar.setText(pageTitle);
                        this.f63002e.addView(dVar, new LinearLayout.LayoutParams(0, -1, 1.0f));
                    }
                }
                if (this.f63006i > count) {
                    this.f63006i = count - 1;
                }
                setCurrentItem(this.f63006i);
                requestLayout();
            }
        }
    }

    public void setViewPager(ViewPager viewPager, int i2) {
        setViewPager(viewPager);
        setCurrentItem(i2);
    }

    public void setCurrentItem(int i2) {
        ViewPager viewPager = this.f63003f;
        if (viewPager != null) {
            this.f63006i = i2;
            viewPager.setCurrentItem(i2);
            int childCount = this.f63002e.getChildCount();
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = this.f63002e.getChildAt(i3);
                boolean z = i3 == i2;
                childAt.setSelected(z);
                if (this.k != null) {
                    if (z) {
                        try {
                            a(i2);
                        } catch (Exception e2) {
                            q.d(e2.getMessage());
                        }
                    }
                } else if (z) {
                    a(i2);
                }
                childAt.setSelected(z);
                if (z) {
                    a(i2);
                }
                i3++;
            }
        }
    }

    public void setOnPageChangeListener(ViewPager.e eVar) {
        this.f63004g = eVar;
    }

    class d extends TextView {
        /* access modifiers changed from: package-private */

        /* renamed from: a  reason: collision with root package name */
        public int f63010a;

        public d(Context context) {
            super(context, (AttributeSet) null, R.attr.vpiTabPageIndicatorStyle);
        }

        public final void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            if (TabPageIndicator.this.f63005h > 0 && getMeasuredWidth() > TabPageIndicator.this.f63005h) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(TabPageIndicator.this.f63005h, 0), i3);
            }
        }
    }
}
