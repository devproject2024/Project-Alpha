package com.alipay.mobile.nebulacore.dev.bugme;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.h.u;
import androidx.interpolator.a.a.b;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.a;
import com.alipay.mobile.nebulacore.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class H5TabLayout extends HorizontalScrollView {
    private static final int ANIMATION_DURATION = 300;
    private static final int DEFAULT_HEIGHT = 45;
    /* access modifiers changed from: private */
    public static final Interpolator INTERPOLATOR = new b();
    private static final int MOTION_NON_ADJACENT_OFFSET = 24;
    private static final int TAB_MIN_WIDTH_MARGIN = 56;
    private OnTabSelectedListener mOnTabSelectedListener;
    private Tab mSelectedTab;
    /* access modifiers changed from: private */
    public final int mTabBackgroundResId;
    private View.OnClickListener mTabClickListener;
    /* access modifiers changed from: private */
    public int mTabMaxWidth;
    /* access modifiers changed from: private */
    public final int mTabMinWidth;
    /* access modifiers changed from: private */
    public int mTabPadding;
    /* access modifiers changed from: private */
    public int mTabSelectedTextColor;
    private final SlidingTabStrip mTabStrip;
    /* access modifiers changed from: private */
    public final int mTabTextAppearance;
    private final ArrayList<Tab> mTabs;

    public interface OnTabSelectedListener {
        void onTabReselected(Tab tab);

        void onTabSelected(Tab tab);

        void onTabUnselected(Tab tab);
    }

    static float lerp(float f2, float f3, float f4) {
        return f2 + (f4 * (f3 - f2));
    }

    public H5TabLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public H5TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public H5TabLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mTabs = new ArrayList<>();
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        this.mTabStrip = new SlidingTabStrip(context);
        addView(this.mTabStrip, -2, -1);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.H5TabLayout, i2, R.style.H5_Widget_Design_TabLayout);
        this.mTabStrip.setSelectedIndicatorHeight(obtainStyledAttributes.getDimensionPixelSize(R.styleable.H5TabLayout_tabIndicatorHeight, 0));
        this.mTabStrip.setSelectedIndicatorColor(obtainStyledAttributes.getColor(R.styleable.H5TabLayout_tabIndicatorColor, 0));
        this.mTabStrip.setSelectedIndicatorScrollable(obtainStyledAttributes.getBoolean(R.styleable.H5TabLayout_tabIndicatorScrollable, true));
        this.mTabTextAppearance = obtainStyledAttributes.getResourceId(R.styleable.H5TabLayout_tabTextAppearance, R.style.H5_TextAppearance_Design_Tab);
        this.mTabPadding = obtainStyledAttributes.getDimensionPixelSize(R.styleable.H5TabLayout_tabPadding, 0);
        if (obtainStyledAttributes.hasValue(R.styleable.H5TabLayout_tabSelectedTextColor)) {
            this.mTabSelectedTextColor = obtainStyledAttributes.getColor(R.styleable.H5TabLayout_tabSelectedTextColor, 0);
        }
        this.mTabMinWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.H5TabLayout_tabMinWidth, 0);
        this.mTabBackgroundResId = obtainStyledAttributes.getResourceId(R.styleable.H5TabLayout_tabBackground, 0);
        obtainStyledAttributes.recycle();
        applyModeAndGravity();
    }

    public void setScrollPosition(int i2, float f2) {
        if (!isAnimationRunning(getAnimation()) && i2 >= 0 && i2 < this.mTabStrip.getChildCount()) {
            this.mTabStrip.setIndicatorPositionFromTabPosition(i2, f2);
            scrollTo(calculateScrollXForTab(i2, f2), 0);
            setSelectedTabView(Math.round(((float) i2) + f2));
        }
    }

    public void addTabsFromPagerAdapter(a aVar) {
        int count = aVar.getCount();
        for (int i2 = 0; i2 < count; i2++) {
            addTab(newTab().setText(aVar.getPageTitle(i2)));
        }
    }

    public void setupWithViewPager(ViewPager viewPager) {
        a adapter = viewPager.getAdapter();
        if (adapter != null) {
            addTabsFromPagerAdapter(adapter);
            viewPager.setOnPageChangeListener(new TabLayoutOnPageChangeListener(this));
            setOnTabSelectedListener(new ViewPagerOnTabSelectedListener(viewPager));
            Tab tab = this.mSelectedTab;
            if (tab == null || tab.getPosition() != viewPager.getCurrentItem()) {
                getTabAt(viewPager.getCurrentItem()).select();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("ViewPager does not have a PagerAdapter set");
    }

    public static class ViewPagerOnTabSelectedListener implements OnTabSelectedListener {
        private final ViewPager mViewPager;

        public void onTabReselected(Tab tab) {
        }

        public void onTabUnselected(Tab tab) {
        }

        public ViewPagerOnTabSelectedListener(ViewPager viewPager) {
            this.mViewPager = viewPager;
        }

        public void onTabSelected(Tab tab) {
            this.mViewPager.setCurrentItem(tab.getPosition());
        }
    }

    public static class TabLayoutOnPageChangeListener implements ViewPager.e {
        private final WeakReference<H5TabLayout> mTabLayoutRef;

        public void onPageScrollStateChanged(int i2) {
        }

        public TabLayoutOnPageChangeListener(H5TabLayout h5TabLayout) {
            this.mTabLayoutRef = new WeakReference<>(h5TabLayout);
        }

        public void onPageScrolled(int i2, float f2, int i3) {
            H5TabLayout h5TabLayout = (H5TabLayout) this.mTabLayoutRef.get();
            if (h5TabLayout != null) {
                h5TabLayout.setScrollPosition(i2, f2);
            }
        }

        public void onPageSelected(int i2) {
            H5TabLayout h5TabLayout = (H5TabLayout) this.mTabLayoutRef.get();
            if (h5TabLayout != null) {
                h5TabLayout.selectTab(h5TabLayout.getTabAt(i2));
            }
        }
    }

    public void addTab(Tab tab) {
        addTab(tab, this.mTabs.isEmpty());
    }

    public void addTab(Tab tab, boolean z) {
        if (tab.mParent == this) {
            addTabView(tab, z);
            configureTab(tab, this.mTabs.size());
            if (z) {
                tab.select();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    public void setOnTabSelectedListener(OnTabSelectedListener onTabSelectedListener) {
        this.mOnTabSelectedListener = onTabSelectedListener;
    }

    public Tab newTab() {
        return new Tab(this);
    }

    public Tab getTabAt(int i2) {
        return this.mTabs.get(i2);
    }

    private TabView createTabView(Tab tab) {
        TabView tabView = new TabView(getContext(), tab);
        tabView.setFocusable(true);
        if (this.mTabClickListener == null) {
            this.mTabClickListener = new View.OnClickListener() {
                public void onClick(View view) {
                    ((TabView) view).getTab().select();
                }
            };
        }
        tabView.setOnClickListener(this.mTabClickListener);
        return tabView;
    }

    private void configureTab(Tab tab, int i2) {
        tab.setPosition(i2);
        this.mTabs.add(i2, tab);
        int size = this.mTabs.size();
        while (true) {
            i2++;
            if (i2 < size) {
                this.mTabs.get(i2).setPosition(i2);
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public void updateTab(int i2) {
        TabView tabView = (TabView) this.mTabStrip.getChildAt(i2);
        if (tabView != null) {
            tabView.update();
        }
    }

    private void addTabView(Tab tab, boolean z) {
        TabView createTabView = createTabView(tab);
        this.mTabStrip.addView(createTabView, createLayoutParamsForTabs());
        if (z) {
            createTabView.setSelected(true);
        }
    }

    private LinearLayout.LayoutParams createLayoutParamsForTabs() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        updateTabViewLayoutParams(layoutParams);
        return layoutParams;
    }

    private void updateTabViewLayoutParams(LinearLayout.LayoutParams layoutParams) {
        layoutParams.width = -2;
        layoutParams.weight = 0.0f;
    }

    /* access modifiers changed from: private */
    public int dpToPx(int i2) {
        return Math.round(getResources().getDisplayMetrics().density * ((float) i2));
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        if (mode == Integer.MIN_VALUE) {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.min(dpToPx(45), View.MeasureSpec.getSize(i3)), 1073741824);
        } else if (mode == 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(dpToPx(45), 1073741824);
        }
        super.onMeasure(i2, i3);
        this.mTabMaxWidth = getMeasuredWidth() - dpToPx(56);
    }

    private void animateToTab(int i2) {
        clearAnimation();
        if (i2 != -1) {
            if (getWindowToken() == null || !u.J(this)) {
                setScrollPosition(i2, 0.0f);
                return;
            }
            final int scrollX = getScrollX();
            final int calculateScrollXForTab = calculateScrollXForTab(i2, 0.0f);
            if (scrollX != calculateScrollXForTab) {
                AnonymousClass2 r2 = new Animation() {
                    /* access modifiers changed from: protected */
                    public void applyTransformation(float f2, Transformation transformation) {
                        H5TabLayout.this.scrollTo((int) H5TabLayout.lerp((float) scrollX, (float) calculateScrollXForTab, f2), 0);
                    }
                };
                r2.setInterpolator(INTERPOLATOR);
                r2.setDuration(300);
                startAnimation(r2);
            }
            this.mTabStrip.animateIndicatorToPosition(i2, 300);
        }
    }

    private void setSelectedTabView(int i2) {
        int childCount = this.mTabStrip.getChildCount();
        int i3 = 0;
        while (i3 < childCount) {
            this.mTabStrip.getChildAt(i3).setSelected(i3 == i2);
            i3++;
        }
    }

    /* access modifiers changed from: private */
    public static boolean isAnimationRunning(Animation animation) {
        return animation != null && animation.hasStarted() && !animation.hasEnded();
    }

    /* access modifiers changed from: package-private */
    public void selectTab(Tab tab) {
        OnTabSelectedListener onTabSelectedListener;
        OnTabSelectedListener onTabSelectedListener2;
        Tab tab2 = this.mSelectedTab;
        if (tab2 != tab) {
            int position = tab != null ? tab.getPosition() : -1;
            setSelectedTabView(position);
            Tab tab3 = this.mSelectedTab;
            if ((tab3 == null || tab3.getPosition() == -1) && position != -1) {
                setScrollPosition(position, 0.0f);
            } else {
                animateToTab(position);
            }
            Tab tab4 = this.mSelectedTab;
            if (!(tab4 == null || (onTabSelectedListener2 = this.mOnTabSelectedListener) == null)) {
                onTabSelectedListener2.onTabUnselected(tab4);
            }
            this.mSelectedTab = tab;
            Tab tab5 = this.mSelectedTab;
            if (tab5 != null && (onTabSelectedListener = this.mOnTabSelectedListener) != null) {
                onTabSelectedListener.onTabSelected(tab5);
            }
        } else if (tab2 != null) {
            OnTabSelectedListener onTabSelectedListener3 = this.mOnTabSelectedListener;
            if (onTabSelectedListener3 != null) {
                onTabSelectedListener3.onTabReselected(tab2);
            }
            animateToTab(tab.getPosition());
        }
    }

    private int calculateScrollXForTab(int i2, float f2) {
        View childAt = this.mTabStrip.getChildAt(i2);
        int i3 = i2 + 1;
        View childAt2 = i3 < this.mTabStrip.getChildCount() ? this.mTabStrip.getChildAt(i3) : null;
        int i4 = 0;
        int width = childAt != null ? childAt.getWidth() : 0;
        if (childAt2 != null) {
            i4 = childAt2.getWidth();
        }
        return (int) (((((float) childAt.getLeft()) + ((((float) (width + i4)) * f2) * 0.5f)) + (((float) childAt.getWidth()) * 0.5f)) - (((float) getWidth()) * 0.5f));
    }

    private void applyModeAndGravity() {
        u.b(this.mTabStrip, Math.max(0, 0 - this.mTabPadding), 0, 0, 0);
        this.mTabStrip.setGravity(8388611);
        updateTabViewsLayoutParams();
    }

    private void updateTabViewsLayoutParams() {
        for (int i2 = 0; i2 < this.mTabStrip.getChildCount(); i2++) {
            View childAt = this.mTabStrip.getChildAt(i2);
            updateTabViewLayoutParams((LinearLayout.LayoutParams) childAt.getLayoutParams());
            childAt.requestLayout();
        }
    }

    public static final class Tab {
        public static final int INVALID_POSITION = -1;
        /* access modifiers changed from: private */
        public final H5TabLayout mParent;
        private int mPosition = -1;
        private CharSequence mText;

        Tab(H5TabLayout h5TabLayout) {
            this.mParent = h5TabLayout;
        }

        public final int getPosition() {
            return this.mPosition;
        }

        /* access modifiers changed from: package-private */
        public final void setPosition(int i2) {
            this.mPosition = i2;
        }

        public final CharSequence getText() {
            return this.mText;
        }

        public final Tab setText(CharSequence charSequence) {
            this.mText = charSequence;
            int i2 = this.mPosition;
            if (i2 >= 0) {
                this.mParent.updateTab(i2);
            }
            return this;
        }

        public final void select() {
            this.mParent.selectTab(this);
        }
    }

    class TabView extends LinearLayout {
        private final Tab mTab;
        private TextView mTextView;

        public TabView(Context context, Tab tab) {
            super(context);
            this.mTab = tab;
            if (H5TabLayout.this.mTabBackgroundResId != 0) {
                setBackgroundDrawable(context.getResources().getDrawable(H5TabLayout.this.mTabBackgroundResId));
            }
            u.b(this, H5TabLayout.this.mTabPadding, H5TabLayout.this.mTabPadding, H5TabLayout.this.mTabPadding, H5TabLayout.this.mTabPadding);
            setGravity(17);
            update();
        }

        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
                TextView textView = this.mTextView;
                if (textView != null) {
                    textView.setSelected(z);
                }
            }
        }

        public void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            if (getMeasuredWidth() > H5TabLayout.this.mTabMaxWidth) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(H5TabLayout.this.mTabMaxWidth, 1073741824), i3);
            } else if (H5TabLayout.this.mTabMinWidth > 0 && getMeasuredHeight() < H5TabLayout.this.mTabMinWidth) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(H5TabLayout.this.mTabMinWidth, 1073741824), i3);
            }
        }

        /* access modifiers changed from: package-private */
        public final void update() {
            CharSequence text = this.mTab.getText();
            if (!TextUtils.isEmpty(text)) {
                if (this.mTextView == null) {
                    TextView textView = new TextView(getContext());
                    textView.setTextAppearance(getContext(), H5TabLayout.this.mTabTextAppearance);
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                    textView.setGravity(17);
                    textView.setTextColor(createColorStateList(textView.getCurrentTextColor(), H5TabLayout.this.mTabSelectedTextColor));
                    addView(textView, -2, -2);
                    this.mTextView = textView;
                }
                this.mTextView.setText(text);
                this.mTextView.setVisibility(0);
                return;
            }
            TextView textView2 = this.mTextView;
            if (textView2 != null) {
                textView2.setVisibility(8);
                this.mTextView.setText((CharSequence) null);
            }
        }

        private ColorStateList createColorStateList(int i2, int i3) {
            return new ColorStateList(new int[][]{SELECTED_STATE_SET, EMPTY_STATE_SET}, new int[]{i3, i2});
        }

        public Tab getTab() {
            return this.mTab;
        }
    }

    class SlidingTabStrip extends LinearLayout {
        private boolean mHasInit = false;
        private int mIndicatorLeft = -1;
        private int mIndicatorRight = -1;
        private boolean mIsIndicatorScrollable = true;
        private int mSelectedIndicatorHeight;
        private final Paint mSelectedIndicatorPaint;
        /* access modifiers changed from: private */
        public int mSelectedPosition = -1;
        /* access modifiers changed from: private */
        public float mSelectionOffset;

        SlidingTabStrip(Context context) {
            super(context);
            setWillNotDraw(false);
            this.mSelectedIndicatorPaint = new Paint();
        }

        /* access modifiers changed from: package-private */
        public void setSelectedIndicatorColor(int i2) {
            this.mSelectedIndicatorPaint.setColor(i2);
            u.g(this);
        }

        /* access modifiers changed from: package-private */
        public void setSelectedIndicatorHeight(int i2) {
            this.mSelectedIndicatorHeight = i2;
            u.g(this);
        }

        /* access modifiers changed from: package-private */
        public void setIndicatorPositionFromTabPosition(int i2, float f2) {
            if ((this.mIsIndicatorScrollable || !this.mHasInit) && !H5TabLayout.isAnimationRunning(getAnimation())) {
                this.mSelectedPosition = i2;
                this.mSelectionOffset = f2;
                updateIndicatorPosition();
                this.mHasInit = true;
            }
        }

        /* access modifiers changed from: package-private */
        public void setSelectedIndicatorScrollable(boolean z) {
            this.mIsIndicatorScrollable = z;
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            if (View.MeasureSpec.getMode(i2) != 1073741824) {
            }
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            super.onLayout(z, i2, i3, i4, i5);
            if (!H5TabLayout.isAnimationRunning(getAnimation())) {
                updateIndicatorPosition();
            }
        }

        private void updateIndicatorPosition() {
            int i2;
            int i3;
            View childAt = getChildAt(this.mSelectedPosition);
            if (childAt == null || childAt.getWidth() <= 0) {
                i2 = -1;
                i3 = -1;
            } else {
                i2 = childAt.getLeft();
                i3 = childAt.getRight();
                if (this.mSelectionOffset > 0.0f && this.mSelectedPosition < getChildCount() - 1) {
                    View childAt2 = getChildAt(this.mSelectedPosition + 1);
                    float left = this.mSelectionOffset * ((float) childAt2.getLeft());
                    float f2 = this.mSelectionOffset;
                    i2 = (int) (left + ((1.0f - f2) * ((float) i2)));
                    i3 = (int) ((f2 * ((float) childAt2.getRight())) + ((1.0f - this.mSelectionOffset) * ((float) i3)));
                }
            }
            setIndicatorPosition(i2, i3);
        }

        /* access modifiers changed from: private */
        public void setIndicatorPosition(int i2, int i3) {
            if (i2 != this.mIndicatorLeft || i3 != this.mIndicatorRight) {
                this.mIndicatorLeft = i2;
                this.mIndicatorRight = i3;
                u.g(this);
            }
        }

        /* access modifiers changed from: package-private */
        public void animateIndicatorToPosition(final int i2, int i3) {
            final int i4;
            final int i5;
            boolean z = u.j(this) == 1;
            View childAt = getChildAt(i2);
            final int left = childAt.getLeft();
            final int right = childAt.getRight();
            if (Math.abs(i2 - this.mSelectedPosition) <= 1) {
                i5 = this.mIndicatorLeft;
                i4 = this.mIndicatorRight;
            } else {
                int access$900 = H5TabLayout.this.dpToPx(24);
                i5 = (i2 >= this.mSelectedPosition ? !z : z) ? left - access$900 : access$900 + right;
                i4 = i5;
            }
            if (i5 != left || i4 != right) {
                AnonymousClass1 r3 = new Animation() {
                    /* access modifiers changed from: protected */
                    public void applyTransformation(float f2, Transformation transformation) {
                        SlidingTabStrip.this.setIndicatorPosition((int) H5TabLayout.lerp((float) i5, (float) left, f2), (int) H5TabLayout.lerp((float) i4, (float) right, f2));
                    }
                };
                r3.setInterpolator(H5TabLayout.INTERPOLATOR);
                r3.setDuration((long) i3);
                r3.setAnimationListener(new Animation.AnimationListener() {
                    public void onAnimationRepeat(Animation animation) {
                    }

                    public void onAnimationStart(Animation animation) {
                    }

                    public void onAnimationEnd(Animation animation) {
                        int unused = SlidingTabStrip.this.mSelectedPosition = i2;
                        float unused2 = SlidingTabStrip.this.mSelectionOffset = 0.0f;
                    }
                });
                startAnimation(r3);
            }
        }

        public void draw(Canvas canvas) {
            super.draw(canvas);
            int i2 = this.mIndicatorLeft;
            if (i2 >= 0 && this.mIndicatorRight > i2) {
                canvas.drawRect((float) i2, (float) (getHeight() - this.mSelectedIndicatorHeight), (float) this.mIndicatorRight, (float) getHeight(), this.mSelectedIndicatorPaint);
            }
        }
    }
}
