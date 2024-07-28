package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import android.widget.ListView;
import androidx.core.h.i;
import androidx.core.h.j;
import androidx.core.h.k;
import androidx.core.h.l;
import androidx.core.h.m;
import androidx.core.h.n;
import androidx.core.h.o;
import androidx.core.h.p;
import androidx.core.h.u;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;

public class SwipeRefreshLayout extends ViewGroup implements i, j, k, m, n, o {
    private static final int[] F = {16842766};
    private static final String n = SwipeRefreshLayout.class.getSimpleName();
    private float A;
    private boolean B;
    private int C;
    private boolean D;
    private final DecelerateInterpolator E;
    private int G;
    private Animation H;
    private Animation I;
    private Animation J;
    private Animation K;
    private Animation L;
    private int M;
    private a N;
    private boolean O;
    private Animation.AnimationListener P;
    private final Animation Q;
    private final Animation R;

    /* renamed from: a  reason: collision with root package name */
    b f4571a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f4572b;

    /* renamed from: c  reason: collision with root package name */
    int f4573c;

    /* renamed from: d  reason: collision with root package name */
    boolean f4574d;

    /* renamed from: e  reason: collision with root package name */
    a f4575e;

    /* renamed from: f  reason: collision with root package name */
    protected int f4576f;

    /* renamed from: g  reason: collision with root package name */
    float f4577g;

    /* renamed from: h  reason: collision with root package name */
    protected int f4578h;

    /* renamed from: i  reason: collision with root package name */
    int f4579i;
    int j;
    b k;
    boolean l;
    boolean m;
    private View o;
    private int p;
    private float q;
    private float r;
    private final p s;
    private final l t;
    private final int[] u;
    private final int[] v;
    private final int[] w;
    private boolean x;
    private int y;
    private float z;

    public interface a {
        boolean a();
    }

    public interface b {
        void onRefresh();
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.f4575e.clearAnimation();
        this.k.stop();
        this.f4575e.setVisibility(8);
        setColorViewAlpha(PriceRangeSeekBar.INVALID_POINTER_ID);
        if (this.f4574d) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.f4578h - this.f4573c);
        }
        this.f4573c = this.f4575e.getTop();
    }

    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        if (!z2) {
            a();
        }
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new SavedState[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        };

        /* renamed from: a  reason: collision with root package name */
        final boolean f4590a;

        SavedState(Parcelable parcelable, boolean z) {
            super(parcelable);
            this.f4590a = z;
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f4590a = parcel.readByte() != 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.f4590a ? (byte) 1 : 0);
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.f4572b);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setRefreshing(savedState.f4590a);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    private void setColorViewAlpha(int i2) {
        this.f4575e.getBackground().setAlpha(i2);
        this.k.setAlpha(i2);
    }

    public void setProgressViewOffset(boolean z2, int i2, int i3) {
        this.f4574d = z2;
        this.f4578h = i2;
        this.f4579i = i3;
        this.m = true;
        a();
        this.f4572b = false;
    }

    public int getProgressViewStartOffset() {
        return this.f4578h;
    }

    public int getProgressViewEndOffset() {
        return this.f4579i;
    }

    public void setProgressViewEndTarget(boolean z2, int i2) {
        this.f4579i = i2;
        this.f4574d = z2;
        this.f4575e.invalidate();
    }

    public void setSlingshotDistance(int i2) {
        this.j = i2;
    }

    public void setSize(int i2) {
        if (i2 == 0 || i2 == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i2 == 0) {
                this.M = (int) (displayMetrics.density * 56.0f);
            } else {
                this.M = (int) (displayMetrics.density * 40.0f);
            }
            this.f4575e.setImageDrawable((Drawable) null);
            this.k.a(i2);
            this.f4575e.setImageDrawable(this.k);
        }
    }

    public SwipeRefreshLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4572b = false;
        this.q = -1.0f;
        this.u = new int[2];
        this.v = new int[2];
        this.w = new int[2];
        this.C = -1;
        this.G = -1;
        this.P = new Animation.AnimationListener() {
            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                if (SwipeRefreshLayout.this.f4572b) {
                    SwipeRefreshLayout.this.k.setAlpha(PriceRangeSeekBar.INVALID_POINTER_ID);
                    SwipeRefreshLayout.this.k.start();
                    if (SwipeRefreshLayout.this.l && SwipeRefreshLayout.this.f4571a != null) {
                        SwipeRefreshLayout.this.f4571a.onRefresh();
                    }
                    SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
                    swipeRefreshLayout.f4573c = swipeRefreshLayout.f4575e.getTop();
                    return;
                }
                SwipeRefreshLayout.this.a();
            }
        };
        this.Q = new Animation() {
            public final void applyTransformation(float f2, Transformation transformation) {
                int i2;
                if (!SwipeRefreshLayout.this.m) {
                    i2 = SwipeRefreshLayout.this.f4579i - Math.abs(SwipeRefreshLayout.this.f4578h);
                } else {
                    i2 = SwipeRefreshLayout.this.f4579i;
                }
                SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((SwipeRefreshLayout.this.f4576f + ((int) (((float) (i2 - SwipeRefreshLayout.this.f4576f)) * f2))) - SwipeRefreshLayout.this.f4575e.getTop());
                SwipeRefreshLayout.this.k.a(1.0f - f2);
            }
        };
        this.R = new Animation() {
            public final void applyTransformation(float f2, Transformation transformation) {
                SwipeRefreshLayout.this.a(f2);
            }
        };
        this.p = ViewConfiguration.get(context).getScaledTouchSlop();
        this.y = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.E = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.M = (int) (displayMetrics.density * 40.0f);
        this.f4575e = new a(getContext());
        this.k = new b(getContext());
        this.k.a(1);
        this.f4575e.setImageDrawable(this.k);
        this.f4575e.setVisibility(8);
        addView(this.f4575e);
        setChildrenDrawingOrderEnabled(true);
        this.f4579i = (int) (displayMetrics.density * 64.0f);
        this.q = (float) this.f4579i;
        this.s = new p();
        this.t = new l(this);
        setNestedScrollingEnabled(true);
        int i2 = -this.M;
        this.f4573c = i2;
        this.f4578h = i2;
        a(1.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, F);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i2, int i3) {
        int i4 = this.G;
        if (i4 < 0) {
            return i3;
        }
        if (i3 == i2 - 1) {
            return i4;
        }
        return i3 >= i4 ? i3 + 1 : i3;
    }

    public void setOnRefreshListener(b bVar) {
        this.f4571a = bVar;
    }

    public void setRefreshing(boolean z2) {
        int i2;
        if (!z2 || this.f4572b == z2) {
            a(z2, false);
            return;
        }
        this.f4572b = z2;
        if (!this.m) {
            i2 = this.f4579i + this.f4578h;
        } else {
            i2 = this.f4579i;
        }
        setTargetOffsetTopAndBottom(i2 - this.f4573c);
        this.l = false;
        Animation.AnimationListener animationListener = this.P;
        this.f4575e.setVisibility(0);
        this.k.setAlpha(PriceRangeSeekBar.INVALID_POINTER_ID);
        this.H = new Animation() {
            public final void applyTransformation(float f2, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(f2);
            }
        };
        this.H.setDuration((long) this.y);
        if (animationListener != null) {
            this.f4575e.f4591a = animationListener;
        }
        this.f4575e.clearAnimation();
        this.f4575e.startAnimation(this.H);
    }

    /* access modifiers changed from: package-private */
    public void setAnimationProgress(float f2) {
        this.f4575e.setScaleX(f2);
        this.f4575e.setScaleY(f2);
    }

    private void a(boolean z2, boolean z3) {
        if (this.f4572b != z2) {
            this.l = z3;
            e();
            this.f4572b = z2;
            if (this.f4572b) {
                a(this.f4573c, this.P);
            } else {
                a(this.P);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Animation.AnimationListener animationListener) {
        this.I = new Animation() {
            public final void applyTransformation(float f2, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(1.0f - f2);
            }
        };
        this.I.setDuration(150);
        a aVar = this.f4575e;
        aVar.f4591a = animationListener;
        aVar.clearAnimation();
        this.f4575e.startAnimation(this.I);
    }

    private void c() {
        this.J = a(this.k.getAlpha(), 76);
    }

    private void d() {
        this.K = a(this.k.getAlpha(), (int) PriceRangeSeekBar.INVALID_POINTER_ID);
    }

    private Animation a(final int i2, final int i3) {
        AnonymousClass4 r0 = new Animation() {
            public final void applyTransformation(float f2, Transformation transformation) {
                b bVar = SwipeRefreshLayout.this.k;
                int i2 = i2;
                bVar.setAlpha((int) (((float) i2) + (((float) (i3 - i2)) * f2)));
            }
        };
        r0.setDuration(300);
        a aVar = this.f4575e;
        aVar.f4591a = null;
        aVar.clearAnimation();
        this.f4575e.startAnimation(r0);
        return r0;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i2) {
        setProgressBackgroundColorSchemeResource(i2);
    }

    public void setProgressBackgroundColorSchemeResource(int i2) {
        setProgressBackgroundColorSchemeColor(androidx.core.content.b.c(getContext(), i2));
    }

    public void setProgressBackgroundColorSchemeColor(int i2) {
        this.f4575e.setBackgroundColor(i2);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr2[i2] = androidx.core.content.b.c(context, iArr[i2]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setColorSchemeColors(int... iArr) {
        e();
        b bVar = this.k;
        bVar.f4600a.a(iArr);
        bVar.f4600a.a(0);
        bVar.invalidateSelf();
    }

    public final boolean b() {
        return this.f4572b;
    }

    private void e() {
        if (this.o == null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (!childAt.equals(this.f4575e)) {
                    this.o = childAt;
                    return;
                }
            }
        }
    }

    public void setDistanceToTriggerSync(int i2) {
        this.q = (float) i2;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.o == null) {
                e();
            }
            View view = this.o;
            if (view != null) {
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
                int measuredWidth2 = this.f4575e.getMeasuredWidth();
                int measuredHeight2 = this.f4575e.getMeasuredHeight();
                int i6 = measuredWidth / 2;
                int i7 = measuredWidth2 / 2;
                int i8 = this.f4573c;
                this.f4575e.layout(i6 - i7, i8, i6 + i7, measuredHeight2 + i8);
            }
        }
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.o == null) {
            e();
        }
        View view = this.o;
        if (view != null) {
            view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            this.f4575e.measure(View.MeasureSpec.makeMeasureSpec(this.M, 1073741824), View.MeasureSpec.makeMeasureSpec(this.M, 1073741824));
            this.G = -1;
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                if (getChildAt(i4) == this.f4575e) {
                    this.G = i4;
                    return;
                }
            }
        }
    }

    public int getProgressCircleDiameter() {
        return this.M;
    }

    private boolean f() {
        a aVar = this.N;
        if (aVar != null) {
            return aVar.a();
        }
        View view = this.o;
        if (!(view instanceof ListView)) {
            return view.canScrollVertically(-1);
        }
        ListView listView = (ListView) view;
        if (Build.VERSION.SDK_INT >= 19) {
            return listView.canScrollList(-1);
        }
        if (listView.getChildCount() != 0) {
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            int top = listView.getChildAt(0).getTop();
            if (firstVisiblePosition > 0 || top < listView.getListPaddingTop()) {
                return true;
            }
        }
        return false;
    }

    public void setOnChildScrollUpCallback(a aVar) {
        this.N = aVar;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int findPointerIndex;
        e();
        int actionMasked = motionEvent.getActionMasked();
        if (this.D && actionMasked == 0) {
            this.D = false;
        }
        if (!isEnabled() || this.D || f() || this.f4572b || this.x) {
            return false;
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i2 = this.C;
                    if (i2 == -1 || (findPointerIndex = motionEvent.findPointerIndex(i2)) < 0) {
                        return false;
                    }
                    d(motionEvent.getY(findPointerIndex));
                } else if (actionMasked != 3) {
                    if (actionMasked == 6) {
                        a(motionEvent);
                    }
                }
            }
            this.B = false;
            this.C = -1;
        } else {
            setTargetOffsetTopAndBottom(this.f4578h - this.f4575e.getTop());
            this.C = motionEvent.getPointerId(0);
            this.B = false;
            int findPointerIndex2 = motionEvent.findPointerIndex(this.C);
            if (findPointerIndex2 < 0) {
                return false;
            }
            this.A = motionEvent.getY(findPointerIndex2);
        }
        return this.B;
    }

    @Deprecated
    public void setLegacyRequestDisallowInterceptTouchEventEnabled(boolean z2) {
        this.O = z2;
    }

    public void requestDisallowInterceptTouchEvent(boolean z2) {
        ViewParent parent;
        View view;
        if ((Build.VERSION.SDK_INT >= 21 || !(this.o instanceof AbsListView)) && ((view = this.o) == null || u.G(view))) {
            super.requestDisallowInterceptTouchEvent(z2);
        } else if (!this.O && (parent = getParent()) != null) {
            parent.requestDisallowInterceptTouchEvent(z2);
        }
    }

    public final void a(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        if (i6 == 0) {
            int i7 = iArr[1];
            int[] iArr2 = this.v;
            if (i6 == 0) {
                this.t.a(i2, i3, i4, i5, iArr2, i6, iArr);
            }
            int i8 = i5 - (iArr[1] - i7);
            int i9 = i8 == 0 ? i5 + this.v[1] : i8;
            if (i9 < 0 && !f()) {
                this.r += (float) Math.abs(i9);
                b(this.r);
                iArr[1] = iArr[1] + i8;
            }
        }
    }

    public final boolean a(View view, View view2, int i2, int i3) {
        if (i3 == 0) {
            return onStartNestedScroll(view, view2, i2);
        }
        return false;
    }

    public final void b(View view, View view2, int i2, int i3) {
        if (i3 == 0) {
            onNestedScrollAccepted(view, view2, i2);
        }
    }

    public final void a(View view, int i2) {
        if (i2 == 0) {
            onStopNestedScroll(view);
        }
    }

    public final void a(View view, int i2, int i3, int i4, int i5, int i6) {
        a(view, i2, i3, i4, i5, i6, this.w);
    }

    public final void a(View view, int i2, int i3, int[] iArr, int i4) {
        if (i4 == 0) {
            onNestedPreScroll(view, i2, i3, iArr);
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return isEnabled() && !this.D && !this.f4572b && (i2 & 2) != 0;
    }

    public void onNestedScrollAccepted(View view, View view2, int i2) {
        this.s.a(i2, 0);
        startNestedScroll(i2 & 2);
        this.r = 0.0f;
        this.x = true;
    }

    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        if (i3 > 0) {
            float f2 = this.r;
            if (f2 > 0.0f) {
                float f3 = (float) i3;
                if (f3 > f2) {
                    iArr[1] = (int) f2;
                    this.r = 0.0f;
                } else {
                    this.r = f2 - f3;
                    iArr[1] = i3;
                }
                b(this.r);
            }
        }
        if (this.m && i3 > 0 && this.r == 0.0f && Math.abs(i3 - iArr[1]) > 0) {
            this.f4575e.setVisibility(8);
        }
        int[] iArr2 = this.u;
        if (dispatchNestedPreScroll(i2 - iArr[0], i3 - iArr[1], iArr2, (int[]) null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    public int getNestedScrollAxes() {
        return this.s.a();
    }

    public void onStopNestedScroll(View view) {
        this.s.a(0);
        this.x = false;
        float f2 = this.r;
        if (f2 > 0.0f) {
            c(f2);
            this.r = 0.0f;
        }
        stopNestedScroll();
    }

    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        a(view, i2, i3, i4, i5, 0, this.w);
    }

    public boolean onNestedPreFling(View view, float f2, float f3) {
        return dispatchNestedPreFling(f2, f3);
    }

    public boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        return dispatchNestedFling(f2, f3, z2);
    }

    public void stopNestedScroll(int i2) {
        if (i2 == 0) {
            stopNestedScroll();
        }
    }

    public void setNestedScrollingEnabled(boolean z2) {
        this.t.a(z2);
    }

    public boolean isNestedScrollingEnabled() {
        return this.t.f3109a;
    }

    public boolean startNestedScroll(int i2) {
        return this.t.a(i2, 0);
    }

    public void stopNestedScroll() {
        this.t.b(0);
    }

    public boolean hasNestedScrollingParent() {
        return this.t.a(0);
    }

    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return this.t.a(i2, i3, i4, i5, iArr);
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return this.t.a(i2, i3, iArr, iArr2);
    }

    public boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return this.t.a(f2, f3, z2);
    }

    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.t.a(f2, f3);
    }

    private static boolean a(Animation animation) {
        return animation != null && animation.hasStarted() && !animation.hasEnded();
    }

    private void b(float f2) {
        this.k.a(true);
        float min = Math.min(1.0f, Math.abs(f2 / this.q));
        float max = (Math.max((float) (((double) min) - 0.4d), 0.0f) * 5.0f) / 3.0f;
        float abs = Math.abs(f2) - this.q;
        int i2 = this.j;
        if (i2 <= 0) {
            if (this.m) {
                i2 = this.f4579i - this.f4578h;
            } else {
                i2 = this.f4579i;
            }
        }
        float f3 = (float) i2;
        double max2 = (double) (Math.max(0.0f, Math.min(abs, f3 * 2.0f) / f3) / 4.0f);
        float pow = ((float) (max2 - Math.pow(max2, 2.0d))) * 2.0f;
        int i3 = this.f4578h + ((int) ((f3 * min) + (f3 * pow * 2.0f)));
        if (this.f4575e.getVisibility() != 0) {
            this.f4575e.setVisibility(0);
        }
        if (!this.f4574d) {
            this.f4575e.setScaleX(1.0f);
            this.f4575e.setScaleY(1.0f);
        }
        if (this.f4574d) {
            setAnimationProgress(Math.min(1.0f, f2 / this.q));
        }
        if (f2 < this.q) {
            if (this.k.getAlpha() > 76 && !a(this.J)) {
                c();
            }
        } else if (this.k.getAlpha() < 255 && !a(this.K)) {
            d();
        }
        this.k.b(Math.min(0.8f, max * 0.8f));
        this.k.a(Math.min(1.0f, max));
        this.k.c((((max * 0.4f) - 16.0f) + (pow * 2.0f)) * 0.5f);
        setTargetOffsetTopAndBottom(i3 - this.f4573c);
    }

    private void c(float f2) {
        if (f2 > this.q) {
            a(true, true);
            return;
        }
        this.f4572b = false;
        this.k.b(0.0f);
        AnonymousClass5 r0 = null;
        if (!this.f4574d) {
            r0 = new Animation.AnimationListener() {
                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    if (!SwipeRefreshLayout.this.f4574d) {
                        SwipeRefreshLayout.this.a((Animation.AnimationListener) null);
                    }
                }
            };
        }
        b(this.f4573c, r0);
        this.k.a(false);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.D && actionMasked == 0) {
            this.D = false;
        }
        if (!isEnabled() || this.D || f() || this.f4572b || this.x) {
            return false;
        }
        if (actionMasked == 0) {
            this.C = motionEvent.getPointerId(0);
            this.B = false;
        } else if (actionMasked == 1) {
            int findPointerIndex = motionEvent.findPointerIndex(this.C);
            if (findPointerIndex < 0) {
                return false;
            }
            if (this.B) {
                this.B = false;
                c((motionEvent.getY(findPointerIndex) - this.z) * 0.5f);
            }
            this.C = -1;
            return false;
        } else if (actionMasked == 2) {
            int findPointerIndex2 = motionEvent.findPointerIndex(this.C);
            if (findPointerIndex2 < 0) {
                return false;
            }
            float y2 = motionEvent.getY(findPointerIndex2);
            d(y2);
            if (this.B) {
                float f2 = (y2 - this.z) * 0.5f;
                if (f2 <= 0.0f) {
                    return false;
                }
                getParent().requestDisallowInterceptTouchEvent(true);
                b(f2);
            }
        } else if (actionMasked == 3) {
            return false;
        } else {
            if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                if (actionIndex < 0) {
                    return false;
                }
                this.C = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                a(motionEvent);
            }
        }
        return true;
    }

    private void d(float f2) {
        float f3 = this.A;
        int i2 = this.p;
        if (f2 - f3 > ((float) i2) && !this.B) {
            this.z = f3 + ((float) i2);
            this.B = true;
            this.k.setAlpha(76);
        }
    }

    private void a(int i2, Animation.AnimationListener animationListener) {
        this.f4576f = i2;
        this.Q.reset();
        this.Q.setDuration(200);
        this.Q.setInterpolator(this.E);
        if (animationListener != null) {
            this.f4575e.f4591a = animationListener;
        }
        this.f4575e.clearAnimation();
        this.f4575e.startAnimation(this.Q);
    }

    private void b(int i2, Animation.AnimationListener animationListener) {
        if (this.f4574d) {
            c(i2, animationListener);
            return;
        }
        this.f4576f = i2;
        this.R.reset();
        this.R.setDuration(200);
        this.R.setInterpolator(this.E);
        if (animationListener != null) {
            this.f4575e.f4591a = animationListener;
        }
        this.f4575e.clearAnimation();
        this.f4575e.startAnimation(this.R);
    }

    /* access modifiers changed from: package-private */
    public final void a(float f2) {
        int i2 = this.f4576f;
        setTargetOffsetTopAndBottom((i2 + ((int) (((float) (this.f4578h - i2)) * f2))) - this.f4575e.getTop());
    }

    private void c(int i2, Animation.AnimationListener animationListener) {
        this.f4576f = i2;
        this.f4577g = this.f4575e.getScaleX();
        this.L = new Animation() {
            public final void applyTransformation(float f2, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(SwipeRefreshLayout.this.f4577g + ((-SwipeRefreshLayout.this.f4577g) * f2));
                SwipeRefreshLayout.this.a(f2);
            }
        };
        this.L.setDuration(150);
        if (animationListener != null) {
            this.f4575e.f4591a = animationListener;
        }
        this.f4575e.clearAnimation();
        this.f4575e.startAnimation(this.L);
    }

    /* access modifiers changed from: package-private */
    public void setTargetOffsetTopAndBottom(int i2) {
        this.f4575e.bringToFront();
        u.f((View) this.f4575e, i2);
        this.f4573c = this.f4575e.getTop();
    }

    private void a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.C) {
            this.C = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }
}
