package net.one97.paytm.widget;

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
import net.one97.paytm.paytm_finance.R;

public class TabPageIndicator extends HorizontalScrollView implements e {

    /* renamed from: b  reason: collision with root package name */
    private static final CharSequence f72380b = "";

    /* renamed from: a  reason: collision with root package name */
    public b f72381a;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Runnable f72382c;

    /* renamed from: d  reason: collision with root package name */
    private final View.OnClickListener f72383d;

    /* renamed from: e  reason: collision with root package name */
    private final c f72384e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public ViewPager f72385f;

    /* renamed from: g  reason: collision with root package name */
    private ViewPager.e f72386g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public int f72387h;

    /* renamed from: i  reason: collision with root package name */
    private int f72388i;
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
        this.f72381a = bVar;
    }

    public TabPageIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    public TabPageIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f72383d = new View.OnClickListener() {
            public final void onClick(View view) {
                if (!(TabPageIndicator.this.f72385f instanceof SmartViewPager) || ((SmartViewPager) TabPageIndicator.this.f72385f).f49875a) {
                    int currentItem = TabPageIndicator.this.f72385f.getCurrentItem();
                    int i2 = ((d) view).f72392a;
                    TabPageIndicator.this.f72385f.setCurrentItem(i2);
                    if (currentItem == i2 && TabPageIndicator.this.j != null) {
                        c unused = TabPageIndicator.this.j;
                    }
                }
            }
        };
        setHorizontalScrollBarEnabled(false);
        this.f72384e = new c(context);
        addView(this.f72384e, new ViewGroup.LayoutParams(-2, -1));
    }

    public void setOnTabReselectedListener(c cVar) {
        this.j = cVar;
    }

    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.f72384e.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.f72387h = -1;
        } else if (childCount > 2) {
            this.f72387h = (int) (((float) View.MeasureSpec.getSize(i2)) * 0.4f);
        } else {
            this.f72387h = View.MeasureSpec.getSize(i2) / 2;
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i2, i3);
        int measuredWidth2 = getMeasuredWidth();
        if (z && measuredWidth != measuredWidth2) {
            setCurrentItem(this.f72388i);
        }
    }

    private void a(int i2) {
        final View childAt = this.f72384e.getChildAt(i2);
        Runnable runnable = this.f72382c;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        this.f72382c = new Runnable() {
            public final void run() {
                TabPageIndicator.this.smoothScrollTo(childAt.getLeft() - ((TabPageIndicator.this.getWidth() - childAt.getWidth()) / 2), 0);
                Runnable unused = TabPageIndicator.this.f72382c = null;
            }
        };
        post(this.f72382c);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f72382c;
        if (runnable != null) {
            post(runnable);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f72382c;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    public void onPageScrollStateChanged(int i2) {
        ViewPager.e eVar = this.f72386g;
        if (eVar != null) {
            eVar.onPageScrollStateChanged(i2);
        }
    }

    public void onPageScrolled(int i2, float f2, int i3) {
        ViewPager.e eVar = this.f72386g;
        if (eVar != null) {
            eVar.onPageScrolled(i2, f2, i3);
        }
    }

    public void onPageSelected(int i2) {
        setCurrentItem(i2);
        ViewPager.e eVar = this.f72386g;
        if (eVar != null) {
            eVar.onPageSelected(i2);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        ViewPager viewPager2 = this.f72385f;
        if (viewPager2 != viewPager) {
            if (viewPager2 != null) {
                viewPager2.setOnPageChangeListener((ViewPager.e) null);
            }
            if (viewPager.getAdapter() != null) {
                this.f72385f = viewPager;
                if (this.f72385f.getAdapter() instanceof a) {
                    this.k = (a) this.f72385f.getAdapter();
                }
                viewPager.setOnPageChangeListener(this);
                this.f72384e.removeAllViews();
                androidx.viewpager.widget.a adapter = this.f72385f.getAdapter();
                int count = adapter.getCount();
                for (int i2 = 0; i2 < count; i2++) {
                    if (this.k == null) {
                        CharSequence pageTitle = adapter.getPageTitle(i2);
                        if (pageTitle == null) {
                            pageTitle = f72380b;
                        }
                        d dVar = new d(getContext());
                        int unused = dVar.f72392a = i2;
                        dVar.setFocusable(true);
                        dVar.setOnClickListener(this.f72383d);
                        dVar.setText(pageTitle);
                        this.f72384e.addView(dVar, new LinearLayout.LayoutParams(0, -1, 1.0f));
                    }
                }
                if (this.f72388i > count) {
                    this.f72388i = count - 1;
                }
                setCurrentItem(this.f72388i);
                requestLayout();
            }
        }
    }

    public void setViewPager(ViewPager viewPager, int i2) {
        setViewPager(viewPager);
        setCurrentItem(i2);
    }

    public void setCurrentItem(int i2) {
        ViewPager viewPager = this.f72385f;
        if (viewPager != null) {
            this.f72388i = i2;
            viewPager.setCurrentItem(i2);
            int childCount = this.f72384e.getChildCount();
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = this.f72384e.getChildAt(i3);
                boolean z = i3 == i2;
                childAt.setSelected(z);
                if (this.k != null) {
                    if (z) {
                        try {
                            a(i2);
                        } catch (Exception e2) {
                            q.b(e2.getMessage());
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
        this.f72386g = eVar;
    }

    class d extends TextView {
        /* access modifiers changed from: package-private */

        /* renamed from: a  reason: collision with root package name */
        public int f72392a;

        public d(Context context) {
            super(context, (AttributeSet) null, R.attr.vpiTabPageIndicatorStyle);
        }

        public final void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            if (TabPageIndicator.this.f72387h > 0 && getMeasuredWidth() > TabPageIndicator.this.f72387h) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(TabPageIndicator.this.f72387h, 0), i3);
            }
        }
    }
}
