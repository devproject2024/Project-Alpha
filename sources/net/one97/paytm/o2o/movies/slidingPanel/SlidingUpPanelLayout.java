package net.one97.paytm.o2o.movies.slidingPanel;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.h.u;
import com.paytm.utility.q;
import java.util.List;
import net.one97.paytm.o2o.movies.slidingPanel.b;

public class SlidingUpPanelLayout extends ViewGroup {

    /* renamed from: b  reason: collision with root package name */
    private static final String f75846b = SlidingUpPanelLayout.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    private static c f75847c = c.COLLAPSED;

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f75848d = {16842927};
    /* access modifiers changed from: private */
    public float A;
    /* access modifiers changed from: private */
    public boolean B;
    private boolean C;
    private float D;
    private float E;
    private float F;
    private float G;
    private boolean H;
    private View.OnClickListener I;
    /* access modifiers changed from: private */
    public final b J;
    private boolean K;
    private final Rect L;

    /* renamed from: a  reason: collision with root package name */
    public final List<b> f75849a;

    /* renamed from: e  reason: collision with root package name */
    private int f75850e;

    /* renamed from: f  reason: collision with root package name */
    private int f75851f;

    /* renamed from: g  reason: collision with root package name */
    private final Paint f75852g;

    /* renamed from: h  reason: collision with root package name */
    private final Drawable f75853h;

    /* renamed from: i  reason: collision with root package name */
    private int f75854i;
    private int j;
    private int k;
    /* access modifiers changed from: private */
    public boolean l;
    private boolean m;
    private boolean n;
    private View o;
    private int p;
    private View q;
    private int r;
    private a s;
    /* access modifiers changed from: private */
    public View t;
    private View u;
    /* access modifiers changed from: private */
    public boolean v;
    /* access modifiers changed from: private */
    public c w;
    private c x;
    /* access modifiers changed from: private */
    public float y;
    /* access modifiers changed from: private */
    public int z;

    public interface b {
        void a(View view);

        void a(View view, float f2);

        void a(View view, c cVar, c cVar2);

        void b(View view);
    }

    public enum c {
        EXPANDED,
        COLLAPSED,
        ANCHORED,
        HIDDEN,
        DRAGGING
    }

    public SlidingUpPanelLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public SlidingUpPanelLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0135  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SlidingUpPanelLayout(android.content.Context r9, android.util.AttributeSet r10, int r11) {
        /*
            r8 = this;
            r8.<init>(r9, r10, r11)
            r11 = 400(0x190, float:5.6E-43)
            r8.f75850e = r11
            r0 = -1728053248(0xffffffff99000000, float:-6.617445E-24)
            r8.f75851f = r0
            android.graphics.Paint r1 = new android.graphics.Paint
            r1.<init>()
            r8.f75852g = r1
            r1 = -1
            r8.f75854i = r1
            r8.j = r1
            r8.k = r1
            r2 = 0
            r8.m = r2
            r3 = 1
            r8.n = r3
            r8.p = r1
            net.one97.paytm.o2o.movies.slidingPanel.a r4 = new net.one97.paytm.o2o.movies.slidingPanel.a
            r4.<init>()
            r8.s = r4
            r8.v = r3
            net.one97.paytm.o2o.movies.slidingPanel.SlidingUpPanelLayout$c r4 = f75847c
            r8.w = r4
            r8.x = r4
            r4 = 1065353216(0x3f800000, float:1.0)
            r8.A = r4
            r8.H = r2
            java.util.concurrent.CopyOnWriteArrayList r5 = new java.util.concurrent.CopyOnWriteArrayList
            r5.<init>()
            r8.f75849a = r5
            r8.K = r3
            android.graphics.Rect r5 = new android.graphics.Rect
            r5.<init>()
            r8.L = r5
            boolean r5 = r8.isInEditMode()
            r6 = 0
            if (r5 == 0) goto L_0x0052
            r8.f75853h = r6
            r8.J = r6
            return
        L_0x0052:
            if (r10 == 0) goto L_0x00e4
            int[] r5 = f75848d
            android.content.res.TypedArray r5 = r9.obtainStyledAttributes(r10, r5)
            if (r5 == 0) goto L_0x0066
            int r7 = r5.getInt(r2, r2)
            r8.setGravity(r7)
            r5.recycle()
        L_0x0066:
            int[] r5 = net.one97.paytm.o2o.movies.R.styleable.SlidingUpPanelLayout
            android.content.res.TypedArray r10 = r9.obtainStyledAttributes(r10, r5)
            if (r10 == 0) goto L_0x00e4
            int r5 = net.one97.paytm.o2o.movies.R.styleable.SlidingUpPanelLayout_umanoPanelHeight
            int r5 = r10.getDimensionPixelSize(r5, r1)
            r8.f75854i = r5
            int r5 = net.one97.paytm.o2o.movies.R.styleable.SlidingUpPanelLayout_umanoShadowHeight
            int r5 = r10.getDimensionPixelSize(r5, r1)
            r8.j = r5
            int r5 = net.one97.paytm.o2o.movies.R.styleable.SlidingUpPanelLayout_umanoParallaxOffset
            int r5 = r10.getDimensionPixelSize(r5, r1)
            r8.k = r5
            int r5 = net.one97.paytm.o2o.movies.R.styleable.SlidingUpPanelLayout_umanoFlingVelocity
            int r11 = r10.getInt(r5, r11)
            r8.f75850e = r11
            int r11 = net.one97.paytm.o2o.movies.R.styleable.SlidingUpPanelLayout_umanoFadeColor
            int r11 = r10.getColor(r11, r0)
            r8.f75851f = r11
            int r11 = net.one97.paytm.o2o.movies.R.styleable.SlidingUpPanelLayout_umanoDragView
            int r11 = r10.getResourceId(r11, r1)
            r8.p = r11
            int r11 = net.one97.paytm.o2o.movies.R.styleable.SlidingUpPanelLayout_umanoScrollableView
            int r11 = r10.getResourceId(r11, r1)
            r8.r = r11
            int r11 = net.one97.paytm.o2o.movies.R.styleable.SlidingUpPanelLayout_umanoOverlay
            boolean r11 = r10.getBoolean(r11, r2)
            r8.m = r11
            int r11 = net.one97.paytm.o2o.movies.R.styleable.SlidingUpPanelLayout_umanoClipPanel
            boolean r11 = r10.getBoolean(r11, r3)
            r8.n = r11
            int r11 = net.one97.paytm.o2o.movies.R.styleable.SlidingUpPanelLayout_umanoAnchorPoint
            float r11 = r10.getFloat(r11, r4)
            r8.A = r11
            net.one97.paytm.o2o.movies.slidingPanel.SlidingUpPanelLayout$c[] r11 = net.one97.paytm.o2o.movies.slidingPanel.SlidingUpPanelLayout.c.values()
            int r0 = net.one97.paytm.o2o.movies.R.styleable.SlidingUpPanelLayout_umanoInitialState
            net.one97.paytm.o2o.movies.slidingPanel.SlidingUpPanelLayout$c r4 = f75847c
            int r4 = r4.ordinal()
            int r0 = r10.getInt(r0, r4)
            r11 = r11[r0]
            r8.w = r11
            int r11 = net.one97.paytm.o2o.movies.R.styleable.SlidingUpPanelLayout_umanoScrollInterpolator
            int r11 = r10.getResourceId(r11, r1)
            if (r11 == r1) goto L_0x00df
            android.view.animation.Interpolator r11 = android.view.animation.AnimationUtils.loadInterpolator(r9, r11)
            goto L_0x00e0
        L_0x00df:
            r11 = r6
        L_0x00e0:
            r10.recycle()
            goto L_0x00e5
        L_0x00e4:
            r11 = r6
        L_0x00e5:
            android.content.res.Resources r9 = r9.getResources()
            android.util.DisplayMetrics r9 = r9.getDisplayMetrics()
            float r9 = r9.density
            int r10 = r8.f75854i
            r0 = 1056964608(0x3f000000, float:0.5)
            if (r10 != r1) goto L_0x00fd
            r10 = 1116209152(0x42880000, float:68.0)
            float r10 = r10 * r9
            float r10 = r10 + r0
            int r10 = (int) r10
            r8.f75854i = r10
        L_0x00fd:
            int r10 = r8.j
            if (r10 != r1) goto L_0x0109
            r10 = 1082130432(0x40800000, float:4.0)
            float r10 = r10 * r9
            float r10 = r10 + r0
            int r10 = (int) r10
            r8.j = r10
        L_0x0109:
            int r10 = r8.k
            if (r10 != r1) goto L_0x0113
            r10 = 0
            float r10 = r10 * r9
            int r10 = (int) r10
            r8.k = r10
        L_0x0113:
            int r10 = r8.j
            if (r10 <= 0) goto L_0x0135
            boolean r10 = r8.l
            if (r10 == 0) goto L_0x0128
            android.content.res.Resources r10 = r8.getResources()
            int r0 = net.one97.paytm.o2o.movies.R.drawable.above_shadow
            android.graphics.drawable.Drawable r10 = r10.getDrawable(r0)
            r8.f75853h = r10
            goto L_0x0137
        L_0x0128:
            android.content.res.Resources r10 = r8.getResources()
            int r0 = net.one97.paytm.o2o.movies.R.drawable.below_shadow
            android.graphics.drawable.Drawable r10 = r10.getDrawable(r0)
            r8.f75853h = r10
            goto L_0x0137
        L_0x0135:
            r8.f75853h = r6
        L_0x0137:
            r8.setWillNotDraw(r2)
            net.one97.paytm.o2o.movies.slidingPanel.SlidingUpPanelLayout$a r10 = new net.one97.paytm.o2o.movies.slidingPanel.SlidingUpPanelLayout$a
            r10.<init>(r8, r2)
            net.one97.paytm.o2o.movies.slidingPanel.b r10 = net.one97.paytm.o2o.movies.slidingPanel.b.a((android.view.ViewGroup) r8, (android.view.animation.Interpolator) r11, (net.one97.paytm.o2o.movies.slidingPanel.b.a) r10)
            r8.J = r10
            net.one97.paytm.o2o.movies.slidingPanel.b r10 = r8.J
            int r11 = r8.f75850e
            float r11 = (float) r11
            float r11 = r11 * r9
            r10.f75867h = r11
            r8.C = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.slidingPanel.SlidingUpPanelLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        int i2 = this.p;
        if (i2 != -1) {
            setDragView(findViewById(i2));
        }
        int i3 = this.r;
        if (i3 != -1) {
            setScrollableView(findViewById(i3));
        }
    }

    public void setGravity(int i2) {
        if (i2 == 48 || i2 == 80) {
            this.l = i2 == 80;
            if (!this.K) {
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("gravity must be set to either top or bottom");
    }

    public void setCoveredFadeColor(int i2) {
        this.f75851f = i2;
        requestLayout();
    }

    public int getCoveredFadeColor() {
        return this.f75851f;
    }

    public void setTouchEnabled(boolean z2) {
        this.C = z2;
    }

    public final boolean a() {
        return (!this.C || this.t == null || this.w == c.HIDDEN) ? false : true;
    }

    public void setPanelHeight(int i2) {
        if (getPanelHeight() != i2) {
            this.f75854i = i2;
            if (!this.K) {
                requestLayout();
            }
            if (getPanelState() == c.COLLAPSED) {
                b(0.0f);
                invalidate();
            }
        }
    }

    public int getShadowHeight() {
        return this.j;
    }

    public void setShadowHeight(int i2) {
        this.j = i2;
        if (!this.K) {
            invalidate();
        }
    }

    public int getPanelHeight() {
        return this.f75854i;
    }

    public int getCurrentParallaxOffset() {
        int max = (int) (((float) this.k) * Math.max(this.y, 0.0f));
        return this.l ? -max : max;
    }

    public void setParallaxOffset(int i2) {
        this.k = i2;
        if (!this.K) {
            requestLayout();
        }
    }

    public int getMinFlingVelocity() {
        return this.f75850e;
    }

    public void setMinFlingVelocity(int i2) {
        this.f75850e = i2;
    }

    public void setFadeOnClickListener(View.OnClickListener onClickListener) {
        this.I = onClickListener;
    }

    public void setDragView(View view) {
        View view2 = this.o;
        if (view2 != null) {
            view2.setOnClickListener((View.OnClickListener) null);
        }
        this.o = view;
        View view3 = this.o;
        if (view3 != null) {
            view3.setClickable(true);
            this.o.setFocusable(false);
            this.o.setFocusableInTouchMode(false);
            this.o.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (SlidingUpPanelLayout.this.isEnabled() && SlidingUpPanelLayout.this.a()) {
                        if (SlidingUpPanelLayout.this.w == c.EXPANDED || SlidingUpPanelLayout.this.w == c.ANCHORED) {
                            SlidingUpPanelLayout.this.setPanelState(c.COLLAPSED);
                        } else if (SlidingUpPanelLayout.this.A < 1.0f) {
                            SlidingUpPanelLayout.this.setPanelState(c.ANCHORED);
                        } else {
                            SlidingUpPanelLayout.this.setPanelState(c.EXPANDED);
                        }
                    }
                }
            });
        }
    }

    public void setDragView(int i2) {
        this.p = i2;
        setDragView(findViewById(i2));
    }

    public void setScrollableView(View view) {
        this.q = view;
    }

    public void setScrollableViewHelper(a aVar) {
        this.s = aVar;
    }

    public void setAnchorPoint(float f2) {
        if (f2 > 0.0f && f2 <= 1.0f) {
            this.A = f2;
            this.K = true;
            requestLayout();
        }
    }

    public float getAnchorPoint() {
        return this.A;
    }

    public void setOverlayed(boolean z2) {
        this.m = z2;
    }

    public void setClipPanel(boolean z2) {
        this.n = z2;
    }

    /* access modifiers changed from: package-private */
    public final void a(View view) {
        synchronized (this.f75849a) {
            for (b a2 : this.f75849a) {
                a2.a(view);
            }
        }
        sendAccessibilityEvent(32);
    }

    /* access modifiers changed from: package-private */
    public final void b(View view) {
        synchronized (this.f75849a) {
            for (b b2 : this.f75849a) {
                b2.b(view);
            }
        }
        sendAccessibilityEvent(32);
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        int i2;
        int i3;
        int i4;
        int i5;
        if (getChildCount() != 0) {
            int paddingLeft = getPaddingLeft();
            int width = getWidth() - getPaddingRight();
            int paddingTop = getPaddingTop();
            int height = getHeight() - getPaddingBottom();
            View view = this.t;
            int i6 = 0;
            if (view != null) {
                Drawable background = view.getBackground();
                if (background != null && background.getOpacity() == -1) {
                    i5 = this.t.getLeft();
                    i4 = this.t.getRight();
                    i3 = this.t.getTop();
                    i2 = this.t.getBottom();
                    View childAt = getChildAt(0);
                    int max = Math.max(paddingLeft, childAt.getLeft());
                    int max2 = Math.max(paddingTop, childAt.getTop());
                    int min = Math.min(width, childAt.getRight());
                    int min2 = Math.min(height, childAt.getBottom());
                    if (max >= i5 && max2 >= i3 && min <= i4 && min2 <= i2) {
                        i6 = 4;
                    }
                    childAt.setVisibility(i6);
                }
            }
            i5 = 0;
            i4 = 0;
            i3 = 0;
            i2 = 0;
            View childAt2 = getChildAt(0);
            int max3 = Math.max(paddingLeft, childAt2.getLeft());
            int max22 = Math.max(paddingTop, childAt2.getTop());
            int min3 = Math.min(width, childAt2.getRight());
            int min22 = Math.min(height, childAt2.getBottom());
            i6 = 4;
            childAt2.setVisibility(i6);
        }
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.K = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.K = true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode != 1073741824 && mode != Integer.MIN_VALUE) {
            throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
        } else if (mode2 == 1073741824 || mode2 == Integer.MIN_VALUE) {
            int childCount = getChildCount();
            if (childCount == 2) {
                this.u = getChildAt(0);
                this.t = getChildAt(1);
                if (this.o == null) {
                    setDragView(this.t);
                }
                if (this.t.getVisibility() != 0) {
                    this.w = c.HIDDEN;
                }
                int paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
                int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
                for (int i8 = 0; i8 < childCount; i8++) {
                    View childAt = getChildAt(i8);
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    if (childAt.getVisibility() != 8 || i8 != 0) {
                        if (childAt == this.u) {
                            i5 = (this.m || this.w == c.HIDDEN) ? paddingTop : paddingTop - this.f75854i;
                            i4 = paddingLeft - (layoutParams.leftMargin + layoutParams.rightMargin);
                        } else {
                            i5 = childAt == this.t ? paddingTop - layoutParams.topMargin : paddingTop;
                            i4 = paddingLeft;
                        }
                        if (layoutParams.width == -2) {
                            i6 = View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
                        } else if (layoutParams.width == -1) {
                            i6 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                        } else {
                            i6 = View.MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824);
                        }
                        if (layoutParams.height == -2) {
                            i7 = View.MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE);
                        } else {
                            if (layoutParams.f75858a > 0.0f && layoutParams.f75858a < 1.0f) {
                                i5 = (int) (((float) i5) * layoutParams.f75858a);
                            } else if (layoutParams.height != -1) {
                                i5 = layoutParams.height;
                            }
                            i7 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
                        }
                        childAt.measure(i6, i7);
                        View view = this.t;
                        if (childAt == view) {
                            this.z = view.getMeasuredHeight() - this.f75854i;
                        }
                    }
                }
                setMeasuredDimension(size, size2);
                return;
            }
            throw new IllegalStateException("Sliding up panel layout must have exactly 2 children!");
        } else {
            throw new IllegalStateException("Height must have an exact value or MATCH_PARENT");
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        q.d("mFirstLayout  : " + this.K + " mSlideState : " + this.w);
        if (this.K) {
            int i6 = AnonymousClass2.f75856a[this.w.ordinal()];
            if (i6 == 1) {
                this.y = 1.0f;
            } else if (i6 == 2) {
                this.y = this.A;
            } else if (i6 != 3) {
                this.y = 0.0f;
            } else {
                this.y = a(a(0.0f) + (this.l ? this.f75854i : -this.f75854i));
            }
        }
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() != 8 || (i7 != 0 && !this.K)) {
                int measuredHeight = childAt.getMeasuredHeight();
                int a2 = childAt == this.t ? a(this.y) : paddingTop;
                if (!this.l && childAt == this.u && !this.m) {
                    a2 = a(this.y) + this.t.getMeasuredHeight();
                }
                int i8 = layoutParams.leftMargin + paddingLeft;
                childAt.layout(i8, a2, childAt.getMeasuredWidth() + i8, measuredHeight + a2);
            }
        }
        if (this.K) {
            b();
        }
        d();
        this.K = false;
    }

    /* renamed from: net.one97.paytm.o2o.movies.slidingPanel.SlidingUpPanelLayout$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f75856a = new int[c.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                net.one97.paytm.o2o.movies.slidingPanel.SlidingUpPanelLayout$c[] r0 = net.one97.paytm.o2o.movies.slidingPanel.SlidingUpPanelLayout.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f75856a = r0
                int[] r0 = f75856a     // Catch:{ NoSuchFieldError -> 0x0014 }
                net.one97.paytm.o2o.movies.slidingPanel.SlidingUpPanelLayout$c r1 = net.one97.paytm.o2o.movies.slidingPanel.SlidingUpPanelLayout.c.EXPANDED     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f75856a     // Catch:{ NoSuchFieldError -> 0x001f }
                net.one97.paytm.o2o.movies.slidingPanel.SlidingUpPanelLayout$c r1 = net.one97.paytm.o2o.movies.slidingPanel.SlidingUpPanelLayout.c.ANCHORED     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f75856a     // Catch:{ NoSuchFieldError -> 0x002a }
                net.one97.paytm.o2o.movies.slidingPanel.SlidingUpPanelLayout$c r1 = net.one97.paytm.o2o.movies.slidingPanel.SlidingUpPanelLayout.c.HIDDEN     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f75856a     // Catch:{ NoSuchFieldError -> 0x0035 }
                net.one97.paytm.o2o.movies.slidingPanel.SlidingUpPanelLayout$c r1 = net.one97.paytm.o2o.movies.slidingPanel.SlidingUpPanelLayout.c.COLLAPSED     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.slidingPanel.SlidingUpPanelLayout.AnonymousClass2.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i3 != i5) {
            this.K = true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0036, code lost:
        if (r0 != 3) goto L_0x009b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r11) {
        /*
            r10 = this;
            boolean r0 = r10.H
            r1 = 0
            if (r0 != 0) goto L_0x0182
            boolean r0 = r10.a()
            if (r0 != 0) goto L_0x000d
            goto L_0x0182
        L_0x000d:
            int r0 = r11.getActionMasked()
            float r2 = r11.getX()
            float r3 = r11.getY()
            float r4 = r10.F
            float r4 = r2 - r4
            float r4 = java.lang.Math.abs(r4)
            float r5 = r10.G
            float r5 = r3 - r5
            float r5 = java.lang.Math.abs(r5)
            net.one97.paytm.o2o.movies.slidingPanel.b r6 = r10.J
            int r6 = r6.f75861b
            r7 = 3
            r8 = 2
            r9 = 1
            if (r0 == 0) goto L_0x0083
            if (r0 == r9) goto L_0x004a
            if (r0 == r8) goto L_0x0039
            if (r0 == r7) goto L_0x004a
            goto L_0x009b
        L_0x0039:
            float r0 = (float) r6
            int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x009b
            int r0 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x009b
            net.one97.paytm.o2o.movies.slidingPanel.b r11 = r10.J
            r11.a()
            r10.B = r9
            return r1
        L_0x004a:
            net.one97.paytm.o2o.movies.slidingPanel.b r0 = r10.J
            boolean r0 = r0.c()
            if (r0 == 0) goto L_0x0058
            net.one97.paytm.o2o.movies.slidingPanel.b r0 = r10.J
            r0.b((android.view.MotionEvent) r11)
            return r9
        L_0x0058:
            float r0 = (float) r6
            int r2 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x009b
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 > 0) goto L_0x009b
            float r0 = r10.y
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x009b
            android.view.View r0 = r10.t
            float r2 = r10.F
            int r2 = (int) r2
            float r3 = r10.G
            int r3 = (int) r3
            boolean r0 = r10.a(r0, r2, r3)
            if (r0 != 0) goto L_0x009b
            android.view.View$OnClickListener r0 = r10.I
            if (r0 == 0) goto L_0x009b
            r10.playSoundEffect(r1)
            android.view.View$OnClickListener r11 = r10.I
            r11.onClick(r10)
            return r9
        L_0x0083:
            r10.B = r1
            r10.F = r2
            r10.G = r3
            android.view.View r0 = r10.o
            int r2 = (int) r2
            int r3 = (int) r3
            boolean r0 = r10.a(r0, r2, r3)
            if (r0 != 0) goto L_0x009b
            net.one97.paytm.o2o.movies.slidingPanel.b r11 = r10.J
            r11.a()
            r10.B = r9
            return r1
        L_0x009b:
            net.one97.paytm.o2o.movies.slidingPanel.b r0 = r10.J
            int r2 = r11.getActionMasked()
            int r3 = r11.getActionIndex()
            if (r2 != 0) goto L_0x00aa
            r0.a()
        L_0x00aa:
            android.view.VelocityTracker r4 = r0.f75866g
            if (r4 != 0) goto L_0x00b4
            android.view.VelocityTracker r4 = android.view.VelocityTracker.obtain()
            r0.f75866g = r4
        L_0x00b4:
            android.view.VelocityTracker r4 = r0.f75866g
            r4.addMovement(r11)
            if (r2 == 0) goto L_0x0155
            if (r2 == r9) goto L_0x0151
            if (r2 == r8) goto L_0x00f8
            if (r2 == r7) goto L_0x0151
            r4 = 5
            if (r2 == r4) goto L_0x00d2
            r4 = 6
            if (r2 == r4) goto L_0x00c9
            goto L_0x017c
        L_0x00c9:
            int r11 = r11.getPointerId(r3)
            r0.a((int) r11)
            goto L_0x017c
        L_0x00d2:
            int r2 = r11.getPointerId(r3)
            float r4 = r11.getX(r3)
            float r11 = r11.getY(r3)
            r0.a((float) r4, (float) r11, (int) r2)
            int r3 = r0.f75860a
            if (r3 == 0) goto L_0x017c
            int r3 = r0.f75860a
            if (r3 != r8) goto L_0x017c
            int r3 = (int) r4
            int r11 = (int) r11
            android.view.View r11 = r0.a((int) r3, (int) r11)
            android.view.View r3 = r0.l
            if (r11 != r3) goto L_0x017c
            r0.a((android.view.View) r11, (int) r2)
            goto L_0x017c
        L_0x00f8:
            int r2 = r11.getPointerCount()
            r3 = 0
        L_0x00fd:
            if (r3 >= r2) goto L_0x014d
            float[] r4 = r0.f75863d
            if (r4 == 0) goto L_0x014d
            float[] r4 = r0.f75864e
            if (r4 == 0) goto L_0x014d
            int r4 = r11.getPointerId(r3)
            float[] r5 = r0.f75863d
            int r5 = r5.length
            if (r4 >= r5) goto L_0x014a
            float[] r5 = r0.f75864e
            int r5 = r5.length
            if (r4 >= r5) goto L_0x014a
            float r5 = r11.getX(r3)
            float r6 = r11.getY(r3)
            float[] r7 = r0.f75863d
            r7 = r7[r4]
            float r5 = r5 - r7
            float[] r7 = r0.f75864e
            r7 = r7[r4]
            float r6 = r6 - r7
            r0.b((float) r5, (float) r6, (int) r4)
            int r5 = r0.f75860a
            if (r5 == r9) goto L_0x014d
            float[] r5 = r0.f75863d
            r5 = r5[r4]
            int r5 = (int) r5
            float[] r7 = r0.f75864e
            r7 = r7[r4]
            int r7 = (int) r7
            android.view.View r5 = r0.a((int) r5, (int) r7)
            if (r5 == 0) goto L_0x014a
            boolean r6 = r0.a((android.view.View) r5, (float) r6)
            if (r6 == 0) goto L_0x014a
            boolean r4 = r0.a((android.view.View) r5, (int) r4)
            if (r4 != 0) goto L_0x014d
        L_0x014a:
            int r3 = r3 + 1
            goto L_0x00fd
        L_0x014d:
            r0.a((android.view.MotionEvent) r11)
            goto L_0x017c
        L_0x0151:
            r0.a()
            goto L_0x017c
        L_0x0155:
            float r2 = r11.getX()
            float r3 = r11.getY()
            int r11 = r11.getPointerId(r1)
            r0.a((float) r2, (float) r3, (int) r11)
            int r2 = (int) r2
            int r3 = (int) r3
            android.view.View r2 = r0.a((int) r2, (int) r3)
            android.view.View r3 = r0.l
            if (r2 != r3) goto L_0x0175
            int r3 = r0.f75860a
            if (r3 != r8) goto L_0x0175
            r0.a((android.view.View) r2, (int) r11)
        L_0x0175:
            int[] r2 = r0.f75865f
            r11 = r2[r11]
            int r2 = r0.f75868i
            r11 = r11 & r2
        L_0x017c:
            int r11 = r0.f75860a
            if (r11 != r9) goto L_0x0181
            return r9
        L_0x0181:
            return r1
        L_0x0182:
            net.one97.paytm.o2o.movies.slidingPanel.b r11 = r10.J
            r11.b()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.slidingPanel.SlidingUpPanelLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || !a()) {
            return super.onTouchEvent(motionEvent);
        }
        try {
            this.J.b(motionEvent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean a(View view, int i2, int i3) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        getLocationOnScreen(iArr2);
        int i4 = iArr2[0] + i2;
        int i5 = iArr2[1] + i3;
        if (i4 < iArr[0] || i4 >= iArr[0] + view.getWidth() || i5 < iArr[1] || i5 >= iArr[1] + view.getHeight()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public int a(float f2) {
        View view = this.t;
        int measuredHeight = view != null ? view.getMeasuredHeight() : 0;
        int i2 = (int) (f2 * ((float) this.z));
        if (this.l) {
            return ((getMeasuredHeight() - getPaddingBottom()) - this.f75854i) - i2;
        }
        return (getPaddingTop() - measuredHeight) + this.f75854i + i2;
    }

    /* access modifiers changed from: private */
    public float a(int i2) {
        int a2 = a(0.0f);
        return (this.l ? (float) (a2 - i2) : (float) (i2 - a2)) / ((float) this.z);
    }

    public c getPanelState() {
        return this.w;
    }

    public void setPanelState(c cVar) {
        c cVar2;
        if (this.J.f75860a == 2) {
            this.J.b();
        }
        if (cVar == null || cVar == c.DRAGGING) {
            throw new IllegalArgumentException("Panel state cannot be null or DRAGGING.");
        } else if (!isEnabled()) {
        } else {
            if ((this.K || this.t != null) && cVar != (cVar2 = this.w) && cVar2 != c.DRAGGING) {
                if (this.K) {
                    setPanelStateInternal(cVar);
                    return;
                }
                if (this.w == c.HIDDEN) {
                    this.t.setVisibility(0);
                    requestLayout();
                }
                int i2 = AnonymousClass2.f75856a[cVar.ordinal()];
                if (i2 == 1) {
                    b(1.0f);
                } else if (i2 == 2) {
                    b(this.A);
                } else if (i2 == 3) {
                    b(a(a(0.0f) + (this.l ? this.f75854i : -this.f75854i)));
                } else if (i2 == 4) {
                    b(0.0f);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void setPanelStateInternal(c cVar) {
        c cVar2 = this.w;
        if (cVar2 != cVar) {
            this.w = cVar;
            synchronized (this.f75849a) {
                for (b a2 : this.f75849a) {
                    a2.a(this, cVar2, cVar);
                }
            }
            sendAccessibilityEvent(32);
        }
    }

    /* access modifiers changed from: private */
    public void d() {
        if (this.k > 0) {
            u.b(this.u, (float) getCurrentParallaxOffset());
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j2) {
        boolean z2;
        int save = canvas.save();
        View view2 = this.t;
        if (view2 == null || view2 == view) {
            z2 = super.drawChild(canvas, view, j2);
        } else {
            canvas.getClipBounds(this.L);
            if (!this.m) {
                if (this.l) {
                    Rect rect = this.L;
                    rect.bottom = Math.min(rect.bottom, this.t.getTop());
                } else {
                    Rect rect2 = this.L;
                    rect2.top = Math.max(rect2.top, this.t.getBottom());
                }
            }
            if (this.n) {
                canvas.clipRect(this.L);
            }
            z2 = super.drawChild(canvas, view, j2);
            int i2 = this.f75851f;
            if (i2 != 0) {
                float f2 = this.y;
                if (f2 > 0.0f) {
                    this.f75852g.setColor((i2 & 16777215) | (((int) (((float) ((-16777216 & i2) >>> 24)) * f2)) << 24));
                    canvas.drawRect(this.L, this.f75852g);
                }
            }
        }
        canvas.restoreToCount(save);
        return z2;
    }

    private boolean b(float f2) {
        if (isEnabled() && this.t != null) {
            int a2 = a(f2);
            b bVar = this.J;
            View view = this.t;
            if (bVar.a(view, view.getLeft(), a2)) {
                c();
                u.g(this);
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0088, code lost:
        if (r0.f75860a == 2) goto L_0x008c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void computeScroll() {
        /*
            r10 = this;
            net.one97.paytm.o2o.movies.slidingPanel.b r0 = r10.J
            if (r0 == 0) goto L_0x009d
            android.view.View r1 = r0.l
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x008b
            int r1 = r0.f75860a
            r4 = 2
            if (r1 != r4) goto L_0x0086
            androidx.core.widget.h r1 = r0.j
            android.widget.OverScroller r1 = r1.f3197a
            boolean r1 = r1.computeScrollOffset()
            androidx.core.widget.h r5 = r0.j
            android.widget.OverScroller r5 = r5.f3197a
            int r5 = r5.getCurrX()
            androidx.core.widget.h r6 = r0.j
            android.widget.OverScroller r6 = r6.f3197a
            int r6 = r6.getCurrY()
            android.view.View r7 = r0.l
            int r7 = r7.getLeft()
            int r7 = r5 - r7
            android.view.View r8 = r0.l
            int r8 = r8.getTop()
            int r8 = r6 - r8
            if (r1 != 0) goto L_0x0041
            if (r8 == 0) goto L_0x0041
            android.view.View r0 = r0.l
            r0.setTop(r3)
            goto L_0x008c
        L_0x0041:
            if (r7 == 0) goto L_0x0048
            android.view.View r9 = r0.l
            r9.offsetLeftAndRight(r7)
        L_0x0048:
            if (r8 == 0) goto L_0x004f
            android.view.View r9 = r0.l
            r9.offsetTopAndBottom(r8)
        L_0x004f:
            if (r7 != 0) goto L_0x0053
            if (r8 == 0) goto L_0x0058
        L_0x0053:
            net.one97.paytm.o2o.movies.slidingPanel.b$a r7 = r0.k
            r7.a((int) r6)
        L_0x0058:
            if (r1 == 0) goto L_0x007d
            androidx.core.widget.h r7 = r0.j
            android.widget.OverScroller r7 = r7.f3197a
            int r7 = r7.getFinalX()
            if (r5 != r7) goto L_0x007d
            androidx.core.widget.h r5 = r0.j
            android.widget.OverScroller r5 = r5.f3197a
            int r5 = r5.getFinalY()
            if (r6 != r5) goto L_0x007d
            androidx.core.widget.h r1 = r0.j
            android.widget.OverScroller r1 = r1.f3197a
            r1.abortAnimation()
            androidx.core.widget.h r1 = r0.j
            android.widget.OverScroller r1 = r1.f3197a
            boolean r1 = r1.isFinished()
        L_0x007d:
            if (r1 != 0) goto L_0x0086
            android.view.ViewGroup r1 = r0.n
            java.lang.Runnable r5 = r0.o
            r1.post(r5)
        L_0x0086:
            int r0 = r0.f75860a
            if (r0 != r4) goto L_0x008b
            goto L_0x008c
        L_0x008b:
            r2 = 0
        L_0x008c:
            if (r2 == 0) goto L_0x009d
            boolean r0 = r10.isEnabled()
            if (r0 != 0) goto L_0x009a
            net.one97.paytm.o2o.movies.slidingPanel.b r0 = r10.J
            r0.b()
            return
        L_0x009a:
            androidx.core.h.u.g(r10)
        L_0x009d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.slidingPanel.SlidingUpPanelLayout.computeScroll():void");
    }

    public void draw(Canvas canvas) {
        View view;
        int i2;
        int i3;
        super.draw(canvas);
        if (this.f75853h != null && (view = this.t) != null) {
            int right = view.getRight();
            if (this.l) {
                i3 = this.t.getTop() - this.j;
                i2 = this.t.getTop();
            } else {
                i3 = this.t.getBottom();
                i2 = this.t.getBottom() + this.j;
            }
            this.f75853h.setBounds(this.t.getLeft(), i3, right, i2);
            this.f75853h.draw(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("superState", super.onSaveInstanceState());
        bundle.putSerializable("sliding_state", this.w != c.DRAGGING ? this.w : this.x);
        return bundle;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.w = (c) bundle.getSerializable("sliding_state");
            c cVar = this.w;
            if (cVar == null) {
                cVar = f75847c;
            }
            this.w = cVar;
            parcelable = bundle.getParcelable("superState");
        }
        super.onRestoreInstanceState(parcelable);
    }

    class a extends b.a {
        private a() {
        }

        /* synthetic */ a(SlidingUpPanelLayout slidingUpPanelLayout, byte b2) {
            this();
        }

        public final boolean a(View view) {
            return !SlidingUpPanelLayout.this.B && view == SlidingUpPanelLayout.this.t;
        }

        public final void a() {
            float f2;
            if (SlidingUpPanelLayout.this.J != null && SlidingUpPanelLayout.this.J.f75860a == 0) {
                SlidingUpPanelLayout slidingUpPanelLayout = SlidingUpPanelLayout.this;
                if (slidingUpPanelLayout.v) {
                    f2 = 1.0f;
                } else {
                    SlidingUpPanelLayout slidingUpPanelLayout2 = SlidingUpPanelLayout.this;
                    f2 = slidingUpPanelLayout2.a(slidingUpPanelLayout2.t.getTop());
                }
                float unused = slidingUpPanelLayout.y = f2;
                SlidingUpPanelLayout.this.d();
                if (SlidingUpPanelLayout.this.v) {
                    boolean unused2 = SlidingUpPanelLayout.this.v = false;
                }
                q.d("onViewDragStateChanged : " + SlidingUpPanelLayout.this.y);
                if (SlidingUpPanelLayout.this.y == 1.0f) {
                    SlidingUpPanelLayout.this.b();
                    SlidingUpPanelLayout.this.setPanelStateInternal(c.EXPANDED);
                    SlidingUpPanelLayout slidingUpPanelLayout3 = SlidingUpPanelLayout.this;
                    slidingUpPanelLayout3.a(slidingUpPanelLayout3.t);
                } else if (SlidingUpPanelLayout.this.y == 0.0f) {
                    SlidingUpPanelLayout.this.setPanelStateInternal(c.COLLAPSED);
                    SlidingUpPanelLayout slidingUpPanelLayout4 = SlidingUpPanelLayout.this;
                    slidingUpPanelLayout4.b(slidingUpPanelLayout4.t);
                } else if (SlidingUpPanelLayout.this.y < 0.0f) {
                    SlidingUpPanelLayout.this.setPanelStateInternal(c.HIDDEN);
                    SlidingUpPanelLayout.this.t.setVisibility(4);
                } else {
                    SlidingUpPanelLayout.this.b();
                    SlidingUpPanelLayout.this.setPanelStateInternal(c.ANCHORED);
                }
            }
        }

        public final void b() {
            SlidingUpPanelLayout.this.c();
        }

        public final void a(int i2) {
            SlidingUpPanelLayout.b(SlidingUpPanelLayout.this, i2);
            SlidingUpPanelLayout.this.invalidate();
        }

        public final void a(View view, float f2) {
            int i2;
            if (SlidingUpPanelLayout.this.l) {
                f2 = -f2;
            }
            int i3 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            if (i3 > 0 && SlidingUpPanelLayout.this.y <= SlidingUpPanelLayout.this.A) {
                SlidingUpPanelLayout slidingUpPanelLayout = SlidingUpPanelLayout.this;
                i2 = slidingUpPanelLayout.a(slidingUpPanelLayout.A);
            } else if (i3 <= 0 || SlidingUpPanelLayout.this.y <= SlidingUpPanelLayout.this.A) {
                int i4 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                if (i4 >= 0 || SlidingUpPanelLayout.this.y < SlidingUpPanelLayout.this.A) {
                    if (i4 >= 0 || SlidingUpPanelLayout.this.y >= SlidingUpPanelLayout.this.A) {
                        if (SlidingUpPanelLayout.this.y >= (SlidingUpPanelLayout.this.A + 1.0f) / 2.0f) {
                            i2 = SlidingUpPanelLayout.this.a(1.0f);
                        } else if (SlidingUpPanelLayout.this.y >= SlidingUpPanelLayout.this.A / 2.0f) {
                            SlidingUpPanelLayout slidingUpPanelLayout2 = SlidingUpPanelLayout.this;
                            i2 = slidingUpPanelLayout2.a(slidingUpPanelLayout2.A);
                        }
                    }
                    i2 = SlidingUpPanelLayout.this.a(0.0f);
                } else {
                    SlidingUpPanelLayout slidingUpPanelLayout3 = SlidingUpPanelLayout.this;
                    i2 = slidingUpPanelLayout3.a(slidingUpPanelLayout3.A);
                }
            } else {
                i2 = SlidingUpPanelLayout.this.a(1.0f);
            }
            if (SlidingUpPanelLayout.this.J != null) {
                b e2 = SlidingUpPanelLayout.this.J;
                int left = view.getLeft();
                if (e2.m) {
                    e2.a(left, i2, (int) e2.f75866g.getXVelocity(e2.f75862c), (int) e2.f75866g.getYVelocity(e2.f75862c));
                } else {
                    throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
                }
            }
            SlidingUpPanelLayout.this.invalidate();
        }

        public final int c() {
            return SlidingUpPanelLayout.this.z;
        }

        public final int b(int i2) {
            int b2 = SlidingUpPanelLayout.this.a(0.0f);
            int b3 = SlidingUpPanelLayout.this.a(1.0f);
            if (SlidingUpPanelLayout.this.l) {
                return Math.min(Math.max(i2, b3), b2);
            }
            return Math.min(Math.max(i2, b2), b3);
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: b  reason: collision with root package name */
        private static final int[] f75857b = {16843137};

        /* renamed from: a  reason: collision with root package name */
        public float f75858a = 0.0f;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f75857b);
            if (obtainStyledAttributes != null) {
                this.f75858a = obtainStyledAttributes.getFloat(0, 0.0f);
                obtainStyledAttributes.recycle();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0143  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            int r0 = r8.getActionMasked()
            boolean r1 = r7.isEnabled()
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x01a5
            boolean r1 = r7.a()
            if (r1 == 0) goto L_0x01a5
            boolean r1 = r7.B
            if (r1 == 0) goto L_0x001a
            if (r0 == 0) goto L_0x001a
            goto L_0x01a5
        L_0x001a:
            float r1 = r8.getX()
            float r4 = r8.getY()
            if (r0 != 0) goto L_0x002c
            r7.H = r3
            r7.D = r1
            r7.E = r4
            goto L_0x01a0
        L_0x002c:
            r5 = 2
            if (r0 != r5) goto L_0x0195
            float r0 = r7.D
            float r0 = r1 - r0
            float r5 = r7.E
            float r5 = r4 - r5
            r7.D = r1
            r7.E = r4
            float r0 = java.lang.Math.abs(r0)
            float r1 = java.lang.Math.abs(r5)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x004c
            boolean r8 = super.dispatchTouchEvent(r8)
            return r8
        L_0x004c:
            android.view.View r0 = r7.q
            float r1 = r7.F
            int r1 = (int) r1
            float r4 = r7.G
            int r4 = (int) r4
            boolean r0 = r7.a(r0, r1, r4)
            if (r0 != 0) goto L_0x005f
            boolean r8 = super.dispatchTouchEvent(r8)
            return r8
        L_0x005f:
            boolean r0 = r7.l
            r1 = -1
            if (r0 == 0) goto L_0x0066
            r0 = 1
            goto L_0x0067
        L_0x0066:
            r0 = -1
        L_0x0067:
            float r0 = (float) r0
            float r0 = r0 * r5
            r4 = 0
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x015f
            android.view.View r0 = r7.q
            boolean r1 = r7.l
            if (r0 == 0) goto L_0x0139
            boolean r4 = r0 instanceof android.widget.ScrollView
            if (r4 == 0) goto L_0x0098
            if (r1 == 0) goto L_0x0081
            int r0 = r0.getScrollY()
            goto L_0x013a
        L_0x0081:
            android.widget.ScrollView r0 = (android.widget.ScrollView) r0
            android.view.View r1 = r0.getChildAt(r3)
            int r1 = r1.getBottom()
            int r4 = r0.getHeight()
            int r0 = r0.getScrollY()
            int r4 = r4 + r0
            int r0 = r1 - r4
            goto L_0x013a
        L_0x0098:
            boolean r4 = r0 instanceof android.widget.ListView
            if (r4 == 0) goto L_0x00e9
            r4 = r0
            android.widget.ListView r4 = (android.widget.ListView) r4
            int r5 = r4.getChildCount()
            if (r5 <= 0) goto L_0x00e9
            android.widget.ListAdapter r0 = r4.getAdapter()
            if (r0 == 0) goto L_0x0139
            if (r1 == 0) goto L_0x00c0
            android.view.View r0 = r4.getChildAt(r3)
            int r1 = r4.getFirstVisiblePosition()
            int r4 = r0.getHeight()
            int r1 = r1 * r4
            int r0 = r0.getTop()
            goto L_0x00e6
        L_0x00c0:
            int r0 = r4.getChildCount()
            int r0 = r0 - r2
            android.view.View r0 = r4.getChildAt(r0)
            android.widget.ListAdapter r1 = r4.getAdapter()
            int r1 = r1.getCount()
            int r5 = r4.getLastVisiblePosition()
            int r1 = r1 - r5
            int r1 = r1 - r2
            int r5 = r0.getHeight()
            int r1 = r1 * r5
            int r0 = r0.getBottom()
            int r1 = r1 + r0
            int r0 = r4.getBottom()
        L_0x00e6:
            int r0 = r1 - r0
            goto L_0x013a
        L_0x00e9:
            boolean r4 = r0 instanceof androidx.recyclerview.widget.RecyclerView
            if (r4 == 0) goto L_0x0139
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            int r4 = r0.getChildCount()
            if (r4 <= 0) goto L_0x0139
            androidx.recyclerview.widget.RecyclerView$LayoutManager r4 = r0.getLayoutManager()
            androidx.recyclerview.widget.RecyclerView$a r5 = r0.getAdapter()
            if (r5 == 0) goto L_0x0139
            if (r1 == 0) goto L_0x0115
            android.view.View r1 = r0.getChildAt(r3)
            int r0 = r0.getChildLayoutPosition(r1)
            int r5 = r4.getDecoratedMeasuredHeight(r1)
            int r0 = r0 * r5
            int r1 = r4.getDecoratedTop(r1)
            int r0 = r0 - r1
            goto L_0x013a
        L_0x0115:
            int r1 = r0.getChildCount()
            int r1 = r1 - r2
            android.view.View r1 = r0.getChildAt(r1)
            androidx.recyclerview.widget.RecyclerView$a r5 = r0.getAdapter()
            int r5 = r5.getItemCount()
            int r5 = r5 - r2
            int r6 = r4.getDecoratedMeasuredHeight(r1)
            int r5 = r5 * r6
            int r1 = r4.getDecoratedBottom(r1)
            int r5 = r5 + r1
            int r0 = r0.getBottom()
            int r0 = r5 - r0
            goto L_0x013a
        L_0x0139:
            r0 = 0
        L_0x013a:
            if (r0 <= 0) goto L_0x0143
            r7.H = r2
            boolean r8 = super.dispatchTouchEvent(r8)
            return r8
        L_0x0143:
            boolean r0 = r7.H
            if (r0 == 0) goto L_0x0158
            android.view.MotionEvent r0 = android.view.MotionEvent.obtain(r8)
            r1 = 3
            r0.setAction(r1)
            super.dispatchTouchEvent(r0)
            r0.recycle()
            r8.setAction(r3)
        L_0x0158:
            r7.H = r3
            boolean r8 = r7.onTouchEvent(r8)
            return r8
        L_0x015f:
            boolean r0 = r7.l
            if (r0 == 0) goto L_0x0164
            r1 = 1
        L_0x0164:
            float r0 = (float) r1
            float r5 = r5 * r0
            int r0 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r0 >= 0) goto L_0x01a0
            float r0 = r7.y
            r1 = 1065353216(0x3f800000, float:1.0)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x017a
            r7.H = r3
            boolean r8 = r7.onTouchEvent(r8)
            return r8
        L_0x017a:
            boolean r0 = r7.H
            if (r0 != 0) goto L_0x018e
            net.one97.paytm.o2o.movies.slidingPanel.b r0 = r7.J
            boolean r0 = r0.c()
            if (r0 == 0) goto L_0x018e
            net.one97.paytm.o2o.movies.slidingPanel.b r0 = r7.J
            r0.a()
            r8.setAction(r3)
        L_0x018e:
            r7.H = r2
            boolean r8 = super.dispatchTouchEvent(r8)
            return r8
        L_0x0195:
            if (r0 != r2) goto L_0x01a0
            boolean r0 = r7.H
            if (r0 == 0) goto L_0x01a0
            net.one97.paytm.o2o.movies.slidingPanel.b r0 = r7.J
            r0.b((int) r3)
        L_0x01a0:
            boolean r8 = super.dispatchTouchEvent(r8)
            return r8
        L_0x01a5:
            net.one97.paytm.o2o.movies.slidingPanel.SlidingUpPanelLayout$c r0 = r7.getPanelState()
            net.one97.paytm.o2o.movies.slidingPanel.SlidingUpPanelLayout$c r1 = net.one97.paytm.o2o.movies.slidingPanel.SlidingUpPanelLayout.c.DRAGGING
            if (r0 == r1) goto L_0x01b2
            net.one97.paytm.o2o.movies.slidingPanel.b r0 = r7.J
            r0.b()
        L_0x01b2:
            net.one97.paytm.o2o.movies.slidingPanel.SlidingUpPanelLayout$c r0 = r7.getPanelState()
            net.one97.paytm.o2o.movies.slidingPanel.SlidingUpPanelLayout$c r1 = net.one97.paytm.o2o.movies.slidingPanel.SlidingUpPanelLayout.c.EXPANDED
            if (r0 != r1) goto L_0x01c1
            int r0 = r8.getAction()
            if (r0 == r2) goto L_0x01c1
            return r3
        L_0x01c1:
            boolean r8 = super.dispatchTouchEvent(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.slidingPanel.SlidingUpPanelLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    static /* synthetic */ void b(SlidingUpPanelLayout slidingUpPanelLayout, int i2) {
        if (slidingUpPanelLayout.w != c.DRAGGING) {
            slidingUpPanelLayout.x = slidingUpPanelLayout.w;
        }
        slidingUpPanelLayout.setPanelStateInternal(c.DRAGGING);
        slidingUpPanelLayout.y = slidingUpPanelLayout.a(i2);
        slidingUpPanelLayout.d();
        View view = slidingUpPanelLayout.t;
        synchronized (slidingUpPanelLayout.f75849a) {
            for (b a2 : slidingUpPanelLayout.f75849a) {
                a2.a(view, slidingUpPanelLayout.y);
            }
        }
        LayoutParams layoutParams = (LayoutParams) slidingUpPanelLayout.u.getLayoutParams();
        int height = ((slidingUpPanelLayout.getHeight() - slidingUpPanelLayout.getPaddingBottom()) - slidingUpPanelLayout.getPaddingTop()) - slidingUpPanelLayout.f75854i;
        if (slidingUpPanelLayout.y <= 0.0f && !slidingUpPanelLayout.m) {
            layoutParams.height = slidingUpPanelLayout.l ? i2 - slidingUpPanelLayout.getPaddingBottom() : ((slidingUpPanelLayout.getHeight() - slidingUpPanelLayout.getPaddingBottom()) - slidingUpPanelLayout.t.getMeasuredHeight()) - i2;
            if (layoutParams.height == height) {
                layoutParams.height = -1;
            }
            slidingUpPanelLayout.u.requestLayout();
        } else if (layoutParams.height != -1 && !slidingUpPanelLayout.m) {
            layoutParams.height = -1;
            slidingUpPanelLayout.u.requestLayout();
        }
    }
}
