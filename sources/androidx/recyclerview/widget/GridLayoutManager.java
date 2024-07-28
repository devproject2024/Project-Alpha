package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.h.a.c;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager {
    private static final boolean DEBUG = false;
    public static final int DEFAULT_SPAN_COUNT = -1;
    private static final String TAG = "GridLayoutManager";
    int[] mCachedBorders;
    final Rect mDecorInsets = new Rect();
    boolean mPendingSpanCountChange = false;
    final SparseIntArray mPreLayoutSpanIndexCache = new SparseIntArray();
    final SparseIntArray mPreLayoutSpanSizeCache = new SparseIntArray();
    View[] mSet;
    int mSpanCount = -1;
    b mSpanSizeLookup = new a();
    private boolean mUsingSpansToEstimateScrollBarDimensions;

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        setSpanCount(getProperties(context, attributeSet, i2, i3).f4051b);
    }

    public GridLayoutManager(Context context, int i2) {
        super(context);
        setSpanCount(i2);
    }

    public GridLayoutManager(Context context, int i2, int i3, boolean z) {
        super(context, i3, z);
        setSpanCount(i2);
    }

    public void setStackFromEnd(boolean z) {
        if (!z) {
            super.setStackFromEnd(false);
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    public int getRowCountForAccessibility(RecyclerView.n nVar, RecyclerView.s sVar) {
        if (this.mOrientation == 0) {
            return this.mSpanCount;
        }
        if (sVar.a() <= 0) {
            return 0;
        }
        return getSpanGroupIndex(nVar, sVar, sVar.a() - 1) + 1;
    }

    public int getColumnCountForAccessibility(RecyclerView.n nVar, RecyclerView.s sVar) {
        if (this.mOrientation == 1) {
            return this.mSpanCount;
        }
        if (sVar.a() <= 0) {
            return 0;
        }
        return getSpanGroupIndex(nVar, sVar, sVar.a() - 1) + 1;
    }

    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.n nVar, RecyclerView.s sVar, View view, c cVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, cVar);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int spanGroupIndex = getSpanGroupIndex(nVar, sVar, layoutParams2.f4054c.getLayoutPosition());
        if (this.mOrientation == 0) {
            cVar.b((Object) c.C0046c.a(layoutParams2.f4016a, layoutParams2.f4017b, spanGroupIndex, 1, false, false));
            return;
        }
        cVar.b((Object) c.C0046c.a(spanGroupIndex, 1, layoutParams2.f4016a, layoutParams2.f4017b, false, false));
    }

    public void onLayoutCompleted(RecyclerView.s sVar) {
        super.onLayoutCompleted(sVar);
        this.mPendingSpanCountChange = false;
    }

    private void clearPreLayoutSpanMappingCache() {
        this.mPreLayoutSpanSizeCache.clear();
        this.mPreLayoutSpanIndexCache.clear();
    }

    private void cachePreLayoutSpanMapping() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i2).getLayoutParams();
            int layoutPosition = layoutParams.f4054c.getLayoutPosition();
            this.mPreLayoutSpanSizeCache.put(layoutPosition, layoutParams.f4017b);
            this.mPreLayoutSpanIndexCache.put(layoutPosition, layoutParams.f4016a);
        }
    }

    public void onItemsAdded(RecyclerView recyclerView, int i2, int i3) {
        this.mSpanSizeLookup.f4018a.clear();
        this.mSpanSizeLookup.f4019b.clear();
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        this.mSpanSizeLookup.f4018a.clear();
        this.mSpanSizeLookup.f4019b.clear();
    }

    public void onItemsRemoved(RecyclerView recyclerView, int i2, int i3) {
        this.mSpanSizeLookup.f4018a.clear();
        this.mSpanSizeLookup.f4019b.clear();
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i2, int i3, Object obj) {
        this.mSpanSizeLookup.f4018a.clear();
        this.mSpanSizeLookup.f4019b.clear();
    }

    public void onItemsMoved(RecyclerView recyclerView, int i2, int i3, int i4) {
        this.mSpanSizeLookup.f4018a.clear();
        this.mSpanSizeLookup.f4019b.clear();
    }

    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.mOrientation == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void setSpanSizeLookup(b bVar) {
        this.mSpanSizeLookup = bVar;
    }

    public b getSpanSizeLookup() {
        return this.mSpanSizeLookup;
    }

    private void updateMeasurements() {
        int i2;
        int i3;
        if (getOrientation() == 1) {
            i3 = getWidth() - getPaddingRight();
            i2 = getPaddingLeft();
        } else {
            i3 = getHeight() - getPaddingBottom();
            i2 = getPaddingTop();
        }
        calculateItemBorders(i3 - i2);
    }

    public void setMeasuredDimension(Rect rect, int i2, int i3) {
        int i4;
        int i5;
        if (this.mCachedBorders == null) {
            super.setMeasuredDimension(rect, i2, i3);
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            i5 = chooseSize(i3, rect.height() + paddingTop, getMinimumHeight());
            int[] iArr = this.mCachedBorders;
            i4 = chooseSize(i2, iArr[iArr.length - 1] + paddingLeft, getMinimumWidth());
        } else {
            i4 = chooseSize(i2, rect.width() + paddingLeft, getMinimumWidth());
            int[] iArr2 = this.mCachedBorders;
            i5 = chooseSize(i3, iArr2[iArr2.length - 1] + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(i4, i5);
    }

    private void calculateItemBorders(int i2) {
        this.mCachedBorders = calculateItemBorders(this.mCachedBorders, this.mSpanCount, i2);
    }

    static int[] calculateItemBorders(int[] iArr, int i2, int i3) {
        int i4;
        if (!(iArr != null && iArr.length == i2 + 1 && iArr[iArr.length - 1] == i3)) {
            iArr = new int[(i2 + 1)];
        }
        int i5 = 0;
        iArr[0] = 0;
        int i6 = i3 / i2;
        int i7 = i3 % i2;
        int i8 = 0;
        for (int i9 = 1; i9 <= i2; i9++) {
            i5 += i7;
            if (i5 <= 0 || i2 - i5 >= i7) {
                i4 = i6;
            } else {
                i4 = i6 + 1;
                i5 -= i2;
            }
            i8 += i4;
            iArr[i9] = i8;
        }
        return iArr;
    }

    /* access modifiers changed from: package-private */
    public int getSpaceForSpanRange(int i2, int i3) {
        if (this.mOrientation != 1 || !isLayoutRTL()) {
            int[] iArr = this.mCachedBorders;
            return iArr[i3 + i2] - iArr[i2];
        }
        int[] iArr2 = this.mCachedBorders;
        int i4 = this.mSpanCount;
        return iArr2[i4 - i2] - iArr2[(i4 - i2) - i3];
    }

    /* access modifiers changed from: package-private */
    public void onAnchorReady(RecyclerView.n nVar, RecyclerView.s sVar, LinearLayoutManager.a aVar, int i2) {
        super.onAnchorReady(nVar, sVar, aVar, i2);
        updateMeasurements();
        if (sVar.a() > 0 && !sVar.f4096g) {
            ensureAnchorIsInCorrectSpan(nVar, sVar, aVar, i2);
        }
        ensureViewSet();
    }

    private void ensureViewSet() {
        View[] viewArr = this.mSet;
        if (viewArr == null || viewArr.length != this.mSpanCount) {
            this.mSet = new View[this.mSpanCount];
        }
    }

    public int scrollHorizontallyBy(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollHorizontallyBy(i2, nVar, sVar);
    }

    public int scrollVerticallyBy(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollVerticallyBy(i2, nVar, sVar);
    }

    private void ensureAnchorIsInCorrectSpan(RecyclerView.n nVar, RecyclerView.s sVar, LinearLayoutManager.a aVar, int i2) {
        boolean z = i2 == 1;
        int spanIndex = getSpanIndex(nVar, sVar, aVar.f4026b);
        if (z) {
            while (spanIndex > 0 && aVar.f4026b > 0) {
                aVar.f4026b--;
                spanIndex = getSpanIndex(nVar, sVar, aVar.f4026b);
            }
            return;
        }
        int a2 = sVar.a() - 1;
        int i3 = aVar.f4026b;
        while (i3 < a2) {
            int i4 = i3 + 1;
            int spanIndex2 = getSpanIndex(nVar, sVar, i4);
            if (spanIndex2 <= spanIndex) {
                break;
            }
            i3 = i4;
            spanIndex = spanIndex2;
        }
        aVar.f4026b = i3;
    }

    /* access modifiers changed from: package-private */
    public View findReferenceChild(RecyclerView.n nVar, RecyclerView.s sVar, int i2, int i3, int i4) {
        ensureLayoutState();
        int b2 = this.mOrientationHelper.b();
        int c2 = this.mOrientationHelper.c();
        int i5 = i3 > i2 ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i2 != i3) {
            View childAt = getChildAt(i2);
            int position = getPosition(childAt);
            if (position >= 0 && position < i4 && getSpanIndex(nVar, sVar, position) == 0) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).f4054c.isRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else if (this.mOrientationHelper.a(childAt) < c2 && this.mOrientationHelper.b(childAt) >= b2) {
                    return childAt;
                } else {
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i2 += i5;
        }
        return view != null ? view : view2;
    }

    /* access modifiers changed from: package-private */
    public void collectPrefetchPositionsForLayoutState(RecyclerView.s sVar, LinearLayoutManager.c cVar, RecyclerView.LayoutManager.a aVar) {
        int i2 = this.mSpanCount;
        for (int i3 = 0; i3 < this.mSpanCount && cVar.a(sVar) && i2 > 0; i3++) {
            aVar.a(cVar.f4037d, Math.max(0, cVar.f4040g));
            i2--;
            cVar.f4037d += cVar.f4038e;
        }
    }

    /* access modifiers changed from: package-private */
    public void layoutChunk(RecyclerView.n nVar, RecyclerView.s sVar, LinearLayoutManager.c cVar, LinearLayoutManager.b bVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        View a2;
        RecyclerView.n nVar2 = nVar;
        RecyclerView.s sVar2 = sVar;
        LinearLayoutManager.c cVar2 = cVar;
        LinearLayoutManager.b bVar2 = bVar;
        int h2 = this.mOrientationHelper.h();
        boolean z = false;
        boolean z2 = h2 != 1073741824;
        int i12 = getChildCount() > 0 ? this.mCachedBorders[this.mSpanCount] : 0;
        if (z2) {
            updateMeasurements();
        }
        boolean z3 = cVar2.f4038e == 1;
        int i13 = this.mSpanCount;
        if (!z3) {
            i13 = getSpanIndex(nVar2, sVar2, cVar2.f4037d) + getSpanSize(nVar2, sVar2, cVar2.f4037d);
        }
        int i14 = i13;
        int i15 = 0;
        while (i15 < this.mSpanCount && cVar2.a(sVar2) && i14 > 0) {
            int i16 = cVar2.f4037d;
            int spanSize = getSpanSize(nVar2, sVar2, i16);
            if (spanSize <= this.mSpanCount) {
                i14 -= spanSize;
                if (i14 < 0 || (a2 = cVar2.a(nVar2)) == null) {
                    break;
                }
                this.mSet[i15] = a2;
                i15++;
            } else {
                throw new IllegalArgumentException("Item at position " + i16 + " requires " + spanSize + " spans but GridLayoutManager has only " + this.mSpanCount + " spans.");
            }
        }
        if (i15 == 0) {
            bVar2.f4031b = true;
            return;
        }
        float f2 = 0.0f;
        assignSpans(nVar2, sVar2, i15, z3);
        int i17 = 0;
        int i18 = 0;
        while (i17 < i15) {
            View view = this.mSet[i17];
            if (cVar2.l == null) {
                if (z3) {
                    addView(view);
                } else {
                    addView(view, z);
                }
            } else if (z3) {
                addDisappearingView(view);
            } else {
                addDisappearingView(view, z ? 1 : 0);
            }
            calculateItemDecorationsForChild(view, this.mDecorInsets);
            measureChild(view, h2, z);
            int e2 = this.mOrientationHelper.e(view);
            if (e2 > i18) {
                i18 = e2;
            }
            float f3 = (((float) this.mOrientationHelper.f(view)) * 1.0f) / ((float) ((LayoutParams) view.getLayoutParams()).f4017b);
            if (f3 > f2) {
                f2 = f3;
            }
            i17++;
            z = false;
        }
        if (z2) {
            guessMeasurement(f2, i12);
            i18 = 0;
            for (int i19 = 0; i19 < i15; i19++) {
                View view2 = this.mSet[i19];
                measureChild(view2, 1073741824, true);
                int e3 = this.mOrientationHelper.e(view2);
                if (e3 > i18) {
                    i18 = e3;
                }
            }
        }
        for (int i20 = 0; i20 < i15; i20++) {
            View view3 = this.mSet[i20];
            if (this.mOrientationHelper.e(view3) != i18) {
                LayoutParams layoutParams = (LayoutParams) view3.getLayoutParams();
                Rect rect = layoutParams.f4055d;
                int i21 = rect.top + rect.bottom + layoutParams.topMargin + layoutParams.bottomMargin;
                int i22 = rect.left + rect.right + layoutParams.leftMargin + layoutParams.rightMargin;
                int spaceForSpanRange = getSpaceForSpanRange(layoutParams.f4016a, layoutParams.f4017b);
                if (this.mOrientation == 1) {
                    i11 = getChildMeasureSpec(spaceForSpanRange, 1073741824, i22, layoutParams.width, false);
                    i10 = View.MeasureSpec.makeMeasureSpec(i18 - i21, 1073741824);
                } else {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i18 - i22, 1073741824);
                    i10 = getChildMeasureSpec(spaceForSpanRange, 1073741824, i21, layoutParams.height, false);
                    i11 = makeMeasureSpec;
                }
                measureChildWithDecorationsAndMargin(view3, i11, i10, true);
            }
        }
        int i23 = 0;
        bVar2.f4030a = i18;
        if (this.mOrientation != 1) {
            if (cVar2.f4039f == -1) {
                int i24 = cVar2.f4035b;
                i3 = i24 - i18;
                i5 = i24;
            } else {
                int i25 = cVar2.f4035b;
                i5 = i25 + i18;
                i3 = i25;
            }
            i4 = 0;
            i2 = 0;
        } else if (cVar2.f4039f == -1) {
            int i26 = cVar2.f4035b;
            int i27 = i26 - i18;
            i4 = i26;
            i3 = 0;
            i2 = i27;
            i5 = 0;
        } else {
            i2 = cVar2.f4035b;
            i4 = i2 + i18;
            i5 = 0;
            i3 = 0;
        }
        while (i23 < i15) {
            View view4 = this.mSet[i23];
            LayoutParams layoutParams2 = (LayoutParams) view4.getLayoutParams();
            if (this.mOrientation == 1) {
                if (isLayoutRTL()) {
                    int paddingLeft = getPaddingLeft() + this.mCachedBorders[this.mSpanCount - layoutParams2.f4016a];
                    i7 = paddingLeft;
                    i6 = i4;
                    i9 = paddingLeft - this.mOrientationHelper.f(view4);
                } else {
                    int paddingLeft2 = getPaddingLeft() + this.mCachedBorders[layoutParams2.f4016a];
                    i9 = paddingLeft2;
                    i6 = i4;
                    i7 = this.mOrientationHelper.f(view4) + paddingLeft2;
                }
                i8 = i2;
            } else {
                int paddingTop = getPaddingTop() + this.mCachedBorders[layoutParams2.f4016a];
                i7 = i5;
                i8 = paddingTop;
                i9 = i3;
                i6 = this.mOrientationHelper.f(view4) + paddingTop;
            }
            layoutDecoratedWithMargins(view4, i9, i8, i7, i6);
            if (layoutParams2.f4054c.isRemoved() || layoutParams2.f4054c.isUpdated()) {
                bVar2.f4032c = true;
            }
            bVar2.f4033d |= view4.hasFocusable();
            i23++;
            i3 = i9;
            i2 = i8;
            i5 = i7;
            i4 = i6;
        }
        Arrays.fill(this.mSet, (Object) null);
    }

    private void measureChild(View view, int i2, boolean z) {
        int i3;
        int i4;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.f4055d;
        int i5 = rect.top + rect.bottom + layoutParams.topMargin + layoutParams.bottomMargin;
        int i6 = rect.left + rect.right + layoutParams.leftMargin + layoutParams.rightMargin;
        int spaceForSpanRange = getSpaceForSpanRange(layoutParams.f4016a, layoutParams.f4017b);
        if (this.mOrientation == 1) {
            i3 = getChildMeasureSpec(spaceForSpanRange, i2, i6, layoutParams.width, false);
            i4 = getChildMeasureSpec(this.mOrientationHelper.e(), getHeightMode(), i5, layoutParams.height, true);
        } else {
            int childMeasureSpec = getChildMeasureSpec(spaceForSpanRange, i2, i5, layoutParams.height, false);
            int childMeasureSpec2 = getChildMeasureSpec(this.mOrientationHelper.e(), getWidthMode(), i6, layoutParams.width, true);
            i4 = childMeasureSpec;
            i3 = childMeasureSpec2;
        }
        measureChildWithDecorationsAndMargin(view, i3, i4, z);
    }

    private void guessMeasurement(float f2, int i2) {
        calculateItemBorders(Math.max(Math.round(f2 * ((float) this.mSpanCount)), i2));
    }

    private void measureChildWithDecorationsAndMargin(View view, int i2, int i3, boolean z) {
        boolean z2;
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (z) {
            z2 = shouldReMeasureChild(view, i2, i3, layoutParams);
        } else {
            z2 = shouldMeasureChild(view, i2, i3, layoutParams);
        }
        if (z2) {
            view.measure(i2, i3);
        }
    }

    private void assignSpans(RecyclerView.n nVar, RecyclerView.s sVar, int i2, boolean z) {
        int i3;
        int i4 = 0;
        int i5 = -1;
        if (z) {
            i5 = 1;
            i3 = 0;
        } else {
            i3 = i2 - 1;
            i2 = -1;
        }
        while (i3 != i2) {
            View view = this.mSet[i3];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.f4017b = getSpanSize(nVar, sVar, getPosition(view));
            layoutParams.f4016a = i4;
            i4 += layoutParams.f4017b;
            i3 += i5;
        }
    }

    public int getSpanCount() {
        return this.mSpanCount;
    }

    public void setSpanCount(int i2) {
        if (i2 != this.mSpanCount) {
            this.mPendingSpanCountChange = true;
            if (i2 > 0) {
                this.mSpanCount = i2;
                this.mSpanSizeLookup.f4018a.clear();
                requestLayout();
                return;
            }
            throw new IllegalArgumentException("Span count should be at least 1. Provided ".concat(String.valueOf(i2)));
        }
    }

    public static abstract class b {

        /* renamed from: a  reason: collision with root package name */
        final SparseIntArray f4018a = new SparseIntArray();

        /* renamed from: b  reason: collision with root package name */
        final SparseIntArray f4019b = new SparseIntArray();

        /* renamed from: c  reason: collision with root package name */
        private boolean f4020c = false;

        /* renamed from: d  reason: collision with root package name */
        private boolean f4021d = false;

        /* access modifiers changed from: package-private */
        public final int b(int i2, int i3) {
            if (!this.f4020c) {
                return a(i2, i3);
            }
            int i4 = this.f4018a.get(i2, -1);
            if (i4 != -1) {
                return i4;
            }
            int a2 = a(i2, i3);
            this.f4018a.put(i2, a2);
            return a2;
        }

        /* access modifiers changed from: package-private */
        public final int c(int i2, int i3) {
            if (!this.f4021d) {
                return d(i2, i3);
            }
            int i4 = this.f4019b.get(i2, -1);
            if (i4 != -1) {
                return i4;
            }
            int d2 = d(i2, i3);
            this.f4019b.put(i2, d2);
            return d2;
        }

        public int a(int i2, int i3) {
            int i4;
            int i5;
            int a2;
            if (1 == i3) {
                return 0;
            }
            if (!this.f4020c || (a2 = a(this.f4018a, i2)) < 0) {
                i5 = 0;
                i4 = 0;
            } else {
                i4 = this.f4018a.get(a2) + 1;
                i5 = a2 + 1;
            }
            while (i5 < i2) {
                int i6 = i4 + 1;
                if (i6 == i3) {
                    i6 = 0;
                } else if (i6 > i3) {
                    i6 = 1;
                }
                i5++;
            }
            if (i4 + 1 <= i3) {
                return i4;
            }
            return 0;
        }

        private static int a(SparseIntArray sparseIntArray, int i2) {
            int size = sparseIntArray.size() - 1;
            int i3 = 0;
            while (i3 <= size) {
                int i4 = (i3 + size) >>> 1;
                if (sparseIntArray.keyAt(i4) < i2) {
                    i3 = i4 + 1;
                } else {
                    size = i4 - 1;
                }
            }
            int i5 = i3 - 1;
            if (i5 < 0 || i5 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i5);
        }

        private int d(int i2, int i3) {
            int i4;
            int i5;
            int i6;
            int a2;
            if (!this.f4021d || (a2 = a(this.f4019b, i2)) == -1) {
                i6 = 0;
                i5 = 0;
                i4 = 0;
            } else {
                i5 = this.f4019b.get(a2);
                i4 = a2 + 1;
                i6 = b(a2, i3) + 1;
                if (i6 == i3) {
                    i5++;
                    i6 = 0;
                }
            }
            while (i4 < i2) {
                int i7 = i6 + 1;
                if (i7 == i3) {
                    i5++;
                    i7 = 0;
                } else if (i7 > i3) {
                    i5++;
                    i7 = 1;
                }
                i4++;
            }
            return i6 + 1 > i3 ? i5 + 1 : i5;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00d5, code lost:
        if (r13 == (r2 > r8)) goto L_0x00b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00f5, code lost:
        if (r13 == r14) goto L_0x00b9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0103  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View onFocusSearchFailed(android.view.View r23, int r24, androidx.recyclerview.widget.RecyclerView.n r25, androidx.recyclerview.widget.RecyclerView.s r26) {
        /*
            r22 = this;
            r0 = r22
            r1 = r25
            r2 = r26
            android.view.View r3 = r22.findContainingItemView(r23)
            r4 = 0
            if (r3 != 0) goto L_0x000e
            return r4
        L_0x000e:
            android.view.ViewGroup$LayoutParams r5 = r3.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$LayoutParams r5 = (androidx.recyclerview.widget.GridLayoutManager.LayoutParams) r5
            int r6 = r5.f4016a
            int r7 = r5.f4016a
            int r5 = r5.f4017b
            int r7 = r7 + r5
            android.view.View r5 = super.onFocusSearchFailed(r23, r24, r25, r26)
            if (r5 != 0) goto L_0x0022
            return r4
        L_0x0022:
            r5 = r24
            int r5 = r0.convertFocusDirectionToLayoutDirection(r5)
            r9 = 1
            if (r5 != r9) goto L_0x002d
            r5 = 1
            goto L_0x002e
        L_0x002d:
            r5 = 0
        L_0x002e:
            boolean r10 = r0.mShouldReverseLayout
            if (r5 == r10) goto L_0x0034
            r5 = 1
            goto L_0x0035
        L_0x0034:
            r5 = 0
        L_0x0035:
            r10 = -1
            if (r5 == 0) goto L_0x0040
            int r5 = r22.getChildCount()
            int r5 = r5 - r9
            r11 = -1
            r12 = -1
            goto L_0x0047
        L_0x0040:
            int r5 = r22.getChildCount()
            r11 = r5
            r5 = 0
            r12 = 1
        L_0x0047:
            int r13 = r0.mOrientation
            if (r13 != r9) goto L_0x0053
            boolean r13 = r22.isLayoutRTL()
            if (r13 == 0) goto L_0x0053
            r13 = 1
            goto L_0x0054
        L_0x0053:
            r13 = 0
        L_0x0054:
            int r14 = r0.getSpanGroupIndex(r1, r2, r5)
            r10 = r4
            r8 = -1
            r15 = 0
            r16 = 0
            r17 = -1
        L_0x005f:
            if (r5 == r11) goto L_0x0141
            int r9 = r0.getSpanGroupIndex(r1, r2, r5)
            android.view.View r1 = r0.getChildAt(r5)
            if (r1 == r3) goto L_0x0141
            boolean r18 = r1.hasFocusable()
            if (r18 == 0) goto L_0x0085
            if (r9 == r14) goto L_0x0085
            if (r4 == 0) goto L_0x0077
            goto L_0x0141
        L_0x0077:
            r18 = r3
            r20 = r8
            r19 = r11
            r23 = r14
            r8 = r16
            r11 = r17
            goto L_0x012d
        L_0x0085:
            android.view.ViewGroup$LayoutParams r9 = r1.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$LayoutParams r9 = (androidx.recyclerview.widget.GridLayoutManager.LayoutParams) r9
            int r2 = r9.f4016a
            r18 = r3
            int r3 = r9.f4016a
            r19 = r11
            int r11 = r9.f4017b
            int r3 = r3 + r11
            boolean r11 = r1.hasFocusable()
            if (r11 == 0) goto L_0x00a1
            if (r2 != r6) goto L_0x00a1
            if (r3 != r7) goto L_0x00a1
            return r1
        L_0x00a1:
            boolean r11 = r1.hasFocusable()
            if (r11 == 0) goto L_0x00a9
            if (r4 == 0) goto L_0x00b1
        L_0x00a9:
            boolean r11 = r1.hasFocusable()
            if (r11 != 0) goto L_0x00bb
            if (r10 != 0) goto L_0x00bb
        L_0x00b1:
            r20 = r8
            r23 = r14
            r8 = r16
            r11 = r17
        L_0x00b9:
            r14 = 1
            goto L_0x0101
        L_0x00bb:
            int r11 = java.lang.Math.max(r2, r6)
            int r20 = java.lang.Math.min(r3, r7)
            int r11 = r20 - r11
            boolean r20 = r1.hasFocusable()
            if (r20 == 0) goto L_0x00d8
            if (r11 <= r15) goto L_0x00ce
            goto L_0x00b1
        L_0x00ce:
            if (r11 != r15) goto L_0x00f8
            if (r2 <= r8) goto L_0x00d4
            r11 = 1
            goto L_0x00d5
        L_0x00d4:
            r11 = 0
        L_0x00d5:
            if (r13 != r11) goto L_0x00f8
            goto L_0x00b1
        L_0x00d8:
            if (r4 != 0) goto L_0x00f8
            r20 = r8
            r23 = r14
            r8 = 0
            r14 = 1
            boolean r21 = r0.isViewPartiallyVisible(r1, r8, r14)
            r8 = r16
            if (r21 == 0) goto L_0x00fe
            if (r11 <= r8) goto L_0x00ed
            r11 = r17
            goto L_0x0101
        L_0x00ed:
            if (r11 != r8) goto L_0x00fe
            r11 = r17
            if (r2 <= r11) goto L_0x00f4
            goto L_0x00f5
        L_0x00f4:
            r14 = 0
        L_0x00f5:
            if (r13 != r14) goto L_0x0100
            goto L_0x00b9
        L_0x00f8:
            r20 = r8
            r23 = r14
            r8 = r16
        L_0x00fe:
            r11 = r17
        L_0x0100:
            r14 = 0
        L_0x0101:
            if (r14 == 0) goto L_0x012d
            boolean r14 = r1.hasFocusable()
            if (r14 == 0) goto L_0x011c
            int r4 = r9.f4016a
            int r3 = java.lang.Math.min(r3, r7)
            int r2 = java.lang.Math.max(r2, r6)
            int r3 = r3 - r2
            r15 = r3
            r16 = r8
            r17 = r11
            r8 = r4
            r4 = r1
            goto L_0x0133
        L_0x011c:
            int r8 = r9.f4016a
            int r3 = java.lang.Math.min(r3, r7)
            int r2 = java.lang.Math.max(r2, r6)
            int r3 = r3 - r2
            r10 = r1
            r16 = r3
            r17 = r8
            goto L_0x0131
        L_0x012d:
            r16 = r8
            r17 = r11
        L_0x0131:
            r8 = r20
        L_0x0133:
            int r5 = r5 + r12
            r14 = r23
            r1 = r25
            r2 = r26
            r3 = r18
            r11 = r19
            r9 = 1
            goto L_0x005f
        L_0x0141:
            if (r4 == 0) goto L_0x0144
            return r4
        L_0x0144:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.onFocusSearchFailed(android.view.View, int, androidx.recyclerview.widget.RecyclerView$n, androidx.recyclerview.widget.RecyclerView$s):android.view.View");
    }

    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && !this.mPendingSpanCountChange;
    }

    public int computeHorizontalScrollRange(RecyclerView.s sVar) {
        if (this.mUsingSpansToEstimateScrollBarDimensions) {
            return computeScrollRangeWithSpanInfo(sVar);
        }
        return super.computeHorizontalScrollRange(sVar);
    }

    public int computeVerticalScrollRange(RecyclerView.s sVar) {
        if (this.mUsingSpansToEstimateScrollBarDimensions) {
            return computeScrollRangeWithSpanInfo(sVar);
        }
        return super.computeVerticalScrollRange(sVar);
    }

    public int computeHorizontalScrollOffset(RecyclerView.s sVar) {
        if (this.mUsingSpansToEstimateScrollBarDimensions) {
            return computeScrollOffsetWithSpanInfo(sVar);
        }
        return super.computeHorizontalScrollOffset(sVar);
    }

    public int computeVerticalScrollOffset(RecyclerView.s sVar) {
        if (this.mUsingSpansToEstimateScrollBarDimensions) {
            return computeScrollOffsetWithSpanInfo(sVar);
        }
        return super.computeVerticalScrollOffset(sVar);
    }

    public void setUsingSpansToEstimateScrollbarDimensions(boolean z) {
        this.mUsingSpansToEstimateScrollBarDimensions = z;
    }

    public boolean isUsingSpansToEstimateScrollbarDimensions() {
        return this.mUsingSpansToEstimateScrollBarDimensions;
    }

    private int computeScrollRangeWithSpanInfo(RecyclerView.s sVar) {
        if (!(getChildCount() == 0 || sVar.a() == 0)) {
            ensureLayoutState();
            View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled(), true);
            View findFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled(), true);
            if (!(findFirstVisibleChildClosestToStart == null || findFirstVisibleChildClosestToEnd == null)) {
                if (!isSmoothScrollbarEnabled()) {
                    return this.mSpanSizeLookup.c(sVar.a() - 1, this.mSpanCount) + 1;
                }
                int b2 = this.mOrientationHelper.b(findFirstVisibleChildClosestToEnd) - this.mOrientationHelper.a(findFirstVisibleChildClosestToStart);
                int c2 = this.mSpanSizeLookup.c(getPosition(findFirstVisibleChildClosestToStart), this.mSpanCount);
                return (int) ((((float) b2) / ((float) ((this.mSpanSizeLookup.c(getPosition(findFirstVisibleChildClosestToEnd), this.mSpanCount) - c2) + 1))) * ((float) (this.mSpanSizeLookup.c(sVar.a() - 1, this.mSpanCount) + 1)));
            }
        }
        return 0;
    }

    private int computeScrollOffsetWithSpanInfo(RecyclerView.s sVar) {
        int i2;
        if (!(getChildCount() == 0 || sVar.a() == 0)) {
            ensureLayoutState();
            boolean isSmoothScrollbarEnabled = isSmoothScrollbarEnabled();
            View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled, true);
            View findFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled, true);
            if (!(findFirstVisibleChildClosestToStart == null || findFirstVisibleChildClosestToEnd == null)) {
                int c2 = this.mSpanSizeLookup.c(getPosition(findFirstVisibleChildClosestToStart), this.mSpanCount);
                int c3 = this.mSpanSizeLookup.c(getPosition(findFirstVisibleChildClosestToEnd), this.mSpanCount);
                int min = Math.min(c2, c3);
                int max = Math.max(c2, c3);
                int c4 = this.mSpanSizeLookup.c(sVar.a() - 1, this.mSpanCount) + 1;
                if (this.mShouldReverseLayout) {
                    i2 = Math.max(0, (c4 - max) - 1);
                } else {
                    i2 = Math.max(0, min);
                }
                if (!isSmoothScrollbarEnabled) {
                    return i2;
                }
                return Math.round((((float) i2) * (((float) Math.abs(this.mOrientationHelper.b(findFirstVisibleChildClosestToEnd) - this.mOrientationHelper.a(findFirstVisibleChildClosestToStart))) / ((float) ((this.mSpanSizeLookup.c(getPosition(findFirstVisibleChildClosestToEnd), this.mSpanCount) - this.mSpanSizeLookup.c(getPosition(findFirstVisibleChildClosestToStart), this.mSpanCount)) + 1)))) + ((float) (this.mOrientationHelper.b() - this.mOrientationHelper.a(findFirstVisibleChildClosestToStart))));
            }
        }
        return 0;
    }

    public static final class a extends b {
        public final int a(int i2, int i3) {
            return i2 % i3;
        }
    }

    public static class LayoutParams extends RecyclerView.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f4016a = -1;

        /* renamed from: b  reason: collision with root package name */
        int f4017b = 0;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public void onLayoutChildren(RecyclerView.n nVar, RecyclerView.s sVar) {
        if (sVar.f4096g) {
            cachePreLayoutSpanMapping();
        }
        super.onLayoutChildren(nVar, sVar);
        clearPreLayoutSpanMappingCache();
    }

    private int getSpanGroupIndex(RecyclerView.n nVar, RecyclerView.s sVar, int i2) {
        if (!sVar.f4096g) {
            return this.mSpanSizeLookup.c(i2, this.mSpanCount);
        }
        int a2 = nVar.a(i2);
        if (a2 == -1) {
            return 0;
        }
        return this.mSpanSizeLookup.c(a2, this.mSpanCount);
    }

    private int getSpanIndex(RecyclerView.n nVar, RecyclerView.s sVar, int i2) {
        if (!sVar.f4096g) {
            return this.mSpanSizeLookup.b(i2, this.mSpanCount);
        }
        int i3 = this.mPreLayoutSpanIndexCache.get(i2, -1);
        if (i3 != -1) {
            return i3;
        }
        int a2 = nVar.a(i2);
        if (a2 == -1) {
            return 0;
        }
        return this.mSpanSizeLookup.b(a2, this.mSpanCount);
    }

    private int getSpanSize(RecyclerView.n nVar, RecyclerView.s sVar, int i2) {
        if (!sVar.f4096g) {
            return 1;
        }
        int i3 = this.mPreLayoutSpanSizeCache.get(i2, -1);
        if (i3 != -1) {
            return i3;
        }
        if (nVar.a(i2) == -1) {
        }
        return 1;
    }
}
