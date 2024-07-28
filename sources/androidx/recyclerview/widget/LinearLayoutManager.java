package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.l;
import java.util.List;
import net.one97.paytm.upi.util.UpiConstants;

public class LinearLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.r.b, l.e {
    static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    final a mAnchorInfo;
    private int mInitialPrefetchItemCount;
    private boolean mLastStackFromEnd;
    private final b mLayoutChunkResult;
    private c mLayoutState;
    int mOrientation;
    u mOrientationHelper;
    SavedState mPendingSavedState;
    int mPendingScrollPosition;
    int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private int[] mReusableIntPair;
    private boolean mReverseLayout;
    boolean mShouldReverseLayout;
    private boolean mSmoothScrollbarEnabled;
    private boolean mStackFromEnd;

    public boolean isAutoMeasureEnabled() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public void onAnchorReady(RecyclerView.n nVar, RecyclerView.s sVar, a aVar, int i2) {
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int i2, boolean z) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new a();
        this.mLayoutChunkResult = new b();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        setOrientation(i2);
        setReverseLayout(z);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new a();
        this.mLayoutChunkResult = new b();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        RecyclerView.LayoutManager.Properties properties = getProperties(context, attributeSet, i2, i3);
        setOrientation(properties.f4050a);
        setReverseLayout(properties.f4052c);
        setStackFromEnd(properties.f4053d);
    }

    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public void setRecycleChildrenOnDetach(boolean z) {
        this.mRecycleChildrenOnDetach = z;
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.n nVar) {
        super.onDetachedFromWindow(recyclerView, nVar);
        if (this.mRecycleChildrenOnDetach) {
            removeAndRecycleAllViews(nVar);
            nVar.a();
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
            accessibilityEvent.setToIndex(findLastVisibleItemPosition());
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            return new SavedState(savedState);
        }
        SavedState savedState2 = new SavedState();
        if (getChildCount() > 0) {
            ensureLayoutState();
            boolean z = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
            savedState2.f4024c = z;
            if (z) {
                View childClosestToEnd = getChildClosestToEnd();
                savedState2.f4023b = this.mOrientationHelper.c() - this.mOrientationHelper.b(childClosestToEnd);
                savedState2.f4022a = getPosition(childClosestToEnd);
            } else {
                View childClosestToStart = getChildClosestToStart();
                savedState2.f4022a = getPosition(childClosestToStart);
                savedState2.f4023b = this.mOrientationHelper.a(childClosestToStart) - this.mOrientationHelper.b();
            }
        } else {
            savedState2.f4022a = -1;
        }
        return savedState2;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.mPendingSavedState = (SavedState) parcelable;
            requestLayout();
        }
    }

    public boolean canScrollHorizontally() {
        return this.mOrientation == 0;
    }

    public boolean canScrollVertically() {
        return this.mOrientation == 1;
    }

    public void setStackFromEnd(boolean z) {
        assertNotInLayoutOrScroll((String) null);
        if (this.mStackFromEnd != z) {
            this.mStackFromEnd = z;
            requestLayout();
        }
    }

    public boolean getStackFromEnd() {
        return this.mStackFromEnd;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setOrientation(int i2) {
        if (i2 == 0 || i2 == 1) {
            assertNotInLayoutOrScroll((String) null);
            if (i2 != this.mOrientation || this.mOrientationHelper == null) {
                this.mOrientationHelper = u.a(this, i2);
                this.mAnchorInfo.f4025a = this.mOrientationHelper;
                this.mOrientation = i2;
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:".concat(String.valueOf(i2)));
    }

    private void resolveShouldLayoutReverse() {
        boolean z = true;
        if (this.mOrientation == 1 || !isLayoutRTL()) {
            z = this.mReverseLayout;
        } else if (this.mReverseLayout) {
            z = false;
        }
        this.mShouldReverseLayout = z;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public void setReverseLayout(boolean z) {
        assertNotInLayoutOrScroll((String) null);
        if (z != this.mReverseLayout) {
            this.mReverseLayout = z;
            requestLayout();
        }
    }

    public View findViewByPosition(int i2) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int position = i2 - getPosition(getChildAt(0));
        if (position >= 0 && position < childCount) {
            View childAt = getChildAt(position);
            if (getPosition(childAt) == i2) {
                return childAt;
            }
        }
        return super.findViewByPosition(i2);
    }

    /* access modifiers changed from: protected */
    public void calculateExtraLayoutSpace(RecyclerView.s sVar, int[] iArr) {
        int i2;
        int extraLayoutSpace = getExtraLayoutSpace(sVar);
        if (this.mLayoutState.f4039f == -1) {
            i2 = 0;
        } else {
            i2 = extraLayoutSpace;
            extraLayoutSpace = 0;
        }
        iArr[0] = extraLayoutSpace;
        iArr[1] = i2;
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.s sVar, int i2) {
        p pVar = new p(recyclerView.getContext());
        pVar.setTargetPosition(i2);
        startSmoothScroll(pVar);
    }

    public PointF computeScrollVectorForPosition(int i2) {
        if (getChildCount() == 0) {
            return null;
        }
        boolean z = false;
        int i3 = 1;
        if (i2 < getPosition(getChildAt(0))) {
            z = true;
        }
        if (z != this.mShouldReverseLayout) {
            i3 = -1;
        }
        if (this.mOrientation == 0) {
            return new PointF((float) i3, 0.0f);
        }
        return new PointF(0.0f, (float) i3);
    }

    public void onLayoutChildren(RecyclerView.n nVar, RecyclerView.s sVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        View findViewByPosition;
        int i8;
        int i9;
        int i10 = -1;
        if (!(this.mPendingSavedState == null && this.mPendingScrollPosition == -1) && sVar.a() == 0) {
            removeAndRecycleAllViews(nVar);
            return;
        }
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null && savedState.a()) {
            this.mPendingScrollPosition = this.mPendingSavedState.f4022a;
        }
        ensureLayoutState();
        this.mLayoutState.f4034a = false;
        resolveShouldLayoutReverse();
        View focusedChild = getFocusedChild();
        if (!this.mAnchorInfo.f4029e || this.mPendingScrollPosition != -1 || this.mPendingSavedState != null) {
            this.mAnchorInfo.a();
            a aVar = this.mAnchorInfo;
            aVar.f4028d = this.mShouldReverseLayout ^ this.mStackFromEnd;
            updateAnchorInfoForLayout(nVar, sVar, aVar);
            this.mAnchorInfo.f4029e = true;
        } else if (focusedChild != null && (this.mOrientationHelper.a(focusedChild) >= this.mOrientationHelper.c() || this.mOrientationHelper.b(focusedChild) <= this.mOrientationHelper.b())) {
            this.mAnchorInfo.a(focusedChild, getPosition(focusedChild));
        }
        c cVar = this.mLayoutState;
        cVar.f4039f = cVar.k >= 0 ? 1 : -1;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(sVar, iArr);
        int max = Math.max(0, this.mReusableIntPair[0]) + this.mOrientationHelper.b();
        int max2 = Math.max(0, this.mReusableIntPair[1]) + this.mOrientationHelper.f();
        if (!(!sVar.f4096g || (i7 = this.mPendingScrollPosition) == -1 || this.mPendingScrollPositionOffset == Integer.MIN_VALUE || (findViewByPosition = findViewByPosition(i7)) == null)) {
            if (this.mShouldReverseLayout) {
                i8 = this.mOrientationHelper.c() - this.mOrientationHelper.b(findViewByPosition);
                i9 = this.mPendingScrollPositionOffset;
            } else {
                i9 = this.mOrientationHelper.a(findViewByPosition) - this.mOrientationHelper.b();
                i8 = this.mPendingScrollPositionOffset;
            }
            int i11 = i8 - i9;
            if (i11 > 0) {
                max += i11;
            } else {
                max2 -= i11;
            }
        }
        if (!this.mAnchorInfo.f4028d ? !this.mShouldReverseLayout : this.mShouldReverseLayout) {
            i10 = 1;
        }
        onAnchorReady(nVar, sVar, this.mAnchorInfo, i10);
        detachAndScrapAttachedViews(nVar);
        this.mLayoutState.m = resolveIsInfinite();
        this.mLayoutState.j = sVar.f4096g;
        this.mLayoutState.f4042i = 0;
        if (this.mAnchorInfo.f4028d) {
            updateLayoutStateToFillStart(this.mAnchorInfo);
            c cVar2 = this.mLayoutState;
            cVar2.f4041h = max;
            fill(nVar, cVar2, sVar, false);
            i3 = this.mLayoutState.f4035b;
            int i12 = this.mLayoutState.f4037d;
            if (this.mLayoutState.f4036c > 0) {
                max2 += this.mLayoutState.f4036c;
            }
            updateLayoutStateToFillEnd(this.mAnchorInfo);
            c cVar3 = this.mLayoutState;
            cVar3.f4041h = max2;
            cVar3.f4037d += this.mLayoutState.f4038e;
            fill(nVar, this.mLayoutState, sVar, false);
            i2 = this.mLayoutState.f4035b;
            if (this.mLayoutState.f4036c > 0) {
                int i13 = this.mLayoutState.f4036c;
                updateLayoutStateToFillStart(i12, i3);
                c cVar4 = this.mLayoutState;
                cVar4.f4041h = i13;
                fill(nVar, cVar4, sVar, false);
                i3 = this.mLayoutState.f4035b;
            }
        } else {
            updateLayoutStateToFillEnd(this.mAnchorInfo);
            c cVar5 = this.mLayoutState;
            cVar5.f4041h = max2;
            fill(nVar, cVar5, sVar, false);
            i2 = this.mLayoutState.f4035b;
            int i14 = this.mLayoutState.f4037d;
            if (this.mLayoutState.f4036c > 0) {
                max += this.mLayoutState.f4036c;
            }
            updateLayoutStateToFillStart(this.mAnchorInfo);
            c cVar6 = this.mLayoutState;
            cVar6.f4041h = max;
            cVar6.f4037d += this.mLayoutState.f4038e;
            fill(nVar, this.mLayoutState, sVar, false);
            i3 = this.mLayoutState.f4035b;
            if (this.mLayoutState.f4036c > 0) {
                int i15 = this.mLayoutState.f4036c;
                updateLayoutStateToFillEnd(i14, i2);
                c cVar7 = this.mLayoutState;
                cVar7.f4041h = i15;
                fill(nVar, cVar7, sVar, false);
                i2 = this.mLayoutState.f4035b;
            }
        }
        if (getChildCount() > 0) {
            if (this.mShouldReverseLayout ^ this.mStackFromEnd) {
                int fixLayoutEndGap = fixLayoutEndGap(i2, nVar, sVar, true);
                i6 = i3 + fixLayoutEndGap;
                i4 = i2 + fixLayoutEndGap;
                i5 = fixLayoutStartGap(i6, nVar, sVar, false);
            } else {
                int fixLayoutStartGap = fixLayoutStartGap(i3, nVar, sVar, true);
                i6 = i3 + fixLayoutStartGap;
                i4 = i2 + fixLayoutStartGap;
                i5 = fixLayoutEndGap(i4, nVar, sVar, false);
            }
            i3 = i6 + i5;
            i2 = i4 + i5;
        }
        layoutForPredictiveAnimations(nVar, sVar, i3, i2);
        if (!sVar.f4096g) {
            u uVar = this.mOrientationHelper;
            uVar.f4355b = uVar.e();
        } else {
            this.mAnchorInfo.a();
        }
        this.mLastStackFromEnd = this.mStackFromEnd;
    }

    public void onLayoutCompleted(RecyclerView.s sVar) {
        super.onLayoutCompleted(sVar);
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mAnchorInfo.a();
    }

    private void updateAnchorInfoForLayout(RecyclerView.n nVar, RecyclerView.s sVar, a aVar) {
        if (!updateAnchorFromPendingData(sVar, aVar) && !updateAnchorFromChildren(nVar, sVar, aVar)) {
            aVar.b();
            aVar.f4026b = this.mStackFromEnd ? sVar.a() - 1 : 0;
        }
    }

    private boolean updateAnchorFromChildren(RecyclerView.n nVar, RecyclerView.s sVar, a aVar) {
        View view;
        int i2;
        boolean z = false;
        if (getChildCount() == 0) {
            return false;
        }
        View focusedChild = getFocusedChild();
        if (focusedChild != null) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) focusedChild.getLayoutParams();
            if (!layoutParams.f4054c.isRemoved() && layoutParams.f4054c.getLayoutPosition() >= 0 && layoutParams.f4054c.getLayoutPosition() < sVar.a()) {
                aVar.a(focusedChild, getPosition(focusedChild));
                return true;
            }
        }
        if (this.mLastStackFromEnd != this.mStackFromEnd) {
            return false;
        }
        if (aVar.f4028d) {
            view = findReferenceChildClosestToEnd(nVar, sVar);
        } else {
            view = findReferenceChildClosestToStart(nVar, sVar);
        }
        if (view == null) {
            return false;
        }
        aVar.b(view, getPosition(view));
        if (!sVar.f4096g && supportsPredictiveItemAnimations()) {
            if (this.mOrientationHelper.a(view) >= this.mOrientationHelper.c() || this.mOrientationHelper.b(view) < this.mOrientationHelper.b()) {
                z = true;
            }
            if (z) {
                if (aVar.f4028d) {
                    i2 = this.mOrientationHelper.c();
                } else {
                    i2 = this.mOrientationHelper.b();
                }
                aVar.f4027c = i2;
            }
        }
        return true;
    }

    private int fixLayoutEndGap(int i2, RecyclerView.n nVar, RecyclerView.s sVar, boolean z) {
        int c2;
        int c3 = this.mOrientationHelper.c() - i2;
        if (c3 <= 0) {
            return 0;
        }
        int i3 = -scrollBy(-c3, nVar, sVar);
        int i4 = i2 + i3;
        if (!z || (c2 = this.mOrientationHelper.c() - i4) <= 0) {
            return i3;
        }
        this.mOrientationHelper.a(c2);
        return c2 + i3;
    }

    private int fixLayoutStartGap(int i2, RecyclerView.n nVar, RecyclerView.s sVar, boolean z) {
        int b2;
        int b3 = i2 - this.mOrientationHelper.b();
        if (b3 <= 0) {
            return 0;
        }
        int i3 = -scrollBy(b3, nVar, sVar);
        int i4 = i2 + i3;
        if (!z || (b2 = i4 - this.mOrientationHelper.b()) <= 0) {
            return i3;
        }
        this.mOrientationHelper.a(-b2);
        return i3 - b2;
    }

    private void updateLayoutStateToFillEnd(a aVar) {
        updateLayoutStateToFillEnd(aVar.f4026b, aVar.f4027c);
    }

    private void updateLayoutStateToFillEnd(int i2, int i3) {
        this.mLayoutState.f4036c = this.mOrientationHelper.c() - i3;
        this.mLayoutState.f4038e = this.mShouldReverseLayout ? -1 : 1;
        c cVar = this.mLayoutState;
        cVar.f4037d = i2;
        cVar.f4039f = 1;
        cVar.f4035b = i3;
        cVar.f4040g = Integer.MIN_VALUE;
    }

    private void updateLayoutStateToFillStart(a aVar) {
        updateLayoutStateToFillStart(aVar.f4026b, aVar.f4027c);
    }

    private void updateLayoutStateToFillStart(int i2, int i3) {
        this.mLayoutState.f4036c = i3 - this.mOrientationHelper.b();
        c cVar = this.mLayoutState;
        cVar.f4037d = i2;
        cVar.f4038e = this.mShouldReverseLayout ? 1 : -1;
        c cVar2 = this.mLayoutState;
        cVar2.f4039f = -1;
        cVar2.f4035b = i3;
        cVar2.f4040g = Integer.MIN_VALUE;
    }

    /* access modifiers changed from: protected */
    public boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    /* access modifiers changed from: package-private */
    public void ensureLayoutState() {
        if (this.mLayoutState == null) {
            this.mLayoutState = createLayoutState();
        }
    }

    /* access modifiers changed from: package-private */
    public c createLayoutState() {
        return new c();
    }

    public void scrollToPosition(int i2) {
        this.mPendingScrollPosition = i2;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.f4022a = -1;
        }
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i2, int i3) {
        this.mPendingScrollPosition = i2;
        this.mPendingScrollPositionOffset = i3;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.f4022a = -1;
        }
        requestLayout();
    }

    public int scrollHorizontallyBy(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        if (this.mOrientation == 1) {
            return 0;
        }
        return scrollBy(i2, nVar, sVar);
    }

    public int scrollVerticallyBy(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        if (this.mOrientation == 0) {
            return 0;
        }
        return scrollBy(i2, nVar, sVar);
    }

    public int computeHorizontalScrollOffset(RecyclerView.s sVar) {
        return computeScrollOffset(sVar);
    }

    public int computeVerticalScrollOffset(RecyclerView.s sVar) {
        return computeScrollOffset(sVar);
    }

    public int computeHorizontalScrollExtent(RecyclerView.s sVar) {
        return computeScrollExtent(sVar);
    }

    public int computeVerticalScrollExtent(RecyclerView.s sVar) {
        return computeScrollExtent(sVar);
    }

    public int computeHorizontalScrollRange(RecyclerView.s sVar) {
        return computeScrollRange(sVar);
    }

    public int computeVerticalScrollRange(RecyclerView.s sVar) {
        return computeScrollRange(sVar);
    }

    private int computeScrollOffset(RecyclerView.s sVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        u uVar = this.mOrientationHelper;
        View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true);
        return x.a(sVar, uVar, findFirstVisibleChildClosestToStart, findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    private int computeScrollExtent(RecyclerView.s sVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        u uVar = this.mOrientationHelper;
        View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true);
        return x.a(sVar, uVar, findFirstVisibleChildClosestToStart, findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private int computeScrollRange(RecyclerView.s sVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        u uVar = this.mOrientationHelper;
        View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true);
        return x.b(sVar, uVar, findFirstVisibleChildClosestToStart, findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.mSmoothScrollbarEnabled = z;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    private void updateLayoutState(int i2, int i3, boolean z, RecyclerView.s sVar) {
        int i4;
        this.mLayoutState.m = resolveIsInfinite();
        this.mLayoutState.f4039f = i2;
        int[] iArr = this.mReusableIntPair;
        boolean z2 = false;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(sVar, iArr);
        int max = Math.max(0, this.mReusableIntPair[0]);
        int max2 = Math.max(0, this.mReusableIntPair[1]);
        if (i2 == 1) {
            z2 = true;
        }
        this.mLayoutState.f4041h = z2 ? max2 : max;
        c cVar = this.mLayoutState;
        if (!z2) {
            max = max2;
        }
        cVar.f4042i = max;
        int i5 = -1;
        if (z2) {
            this.mLayoutState.f4041h += this.mOrientationHelper.f();
            View childClosestToEnd = getChildClosestToEnd();
            c cVar2 = this.mLayoutState;
            if (!this.mShouldReverseLayout) {
                i5 = 1;
            }
            cVar2.f4038e = i5;
            this.mLayoutState.f4037d = getPosition(childClosestToEnd) + this.mLayoutState.f4038e;
            this.mLayoutState.f4035b = this.mOrientationHelper.b(childClosestToEnd);
            i4 = this.mOrientationHelper.b(childClosestToEnd) - this.mOrientationHelper.c();
        } else {
            View childClosestToStart = getChildClosestToStart();
            this.mLayoutState.f4041h += this.mOrientationHelper.b();
            c cVar3 = this.mLayoutState;
            if (this.mShouldReverseLayout) {
                i5 = 1;
            }
            cVar3.f4038e = i5;
            this.mLayoutState.f4037d = getPosition(childClosestToStart) + this.mLayoutState.f4038e;
            this.mLayoutState.f4035b = this.mOrientationHelper.a(childClosestToStart);
            i4 = (-this.mOrientationHelper.a(childClosestToStart)) + this.mOrientationHelper.b();
        }
        c cVar4 = this.mLayoutState;
        cVar4.f4036c = i3;
        if (z) {
            cVar4.f4036c -= i4;
        }
        this.mLayoutState.f4040g = i4;
    }

    /* access modifiers changed from: package-private */
    public boolean resolveIsInfinite() {
        return this.mOrientationHelper.g() == 0 && this.mOrientationHelper.d() == 0;
    }

    /* access modifiers changed from: package-private */
    public void collectPrefetchPositionsForLayoutState(RecyclerView.s sVar, c cVar, RecyclerView.LayoutManager.a aVar) {
        int i2 = cVar.f4037d;
        if (i2 >= 0 && i2 < sVar.a()) {
            aVar.a(i2, Math.max(0, cVar.f4040g));
        }
    }

    public void collectInitialPrefetchPositions(int i2, RecyclerView.LayoutManager.a aVar) {
        int i3;
        boolean z;
        SavedState savedState = this.mPendingSavedState;
        int i4 = -1;
        if (savedState == null || !savedState.a()) {
            resolveShouldLayoutReverse();
            z = this.mShouldReverseLayout;
            i3 = this.mPendingScrollPosition;
            if (i3 == -1) {
                i3 = z ? i2 - 1 : 0;
            }
        } else {
            z = this.mPendingSavedState.f4024c;
            i3 = this.mPendingSavedState.f4022a;
        }
        if (!z) {
            i4 = 1;
        }
        for (int i5 = 0; i5 < this.mInitialPrefetchItemCount && i3 >= 0 && i3 < i2; i5++) {
            aVar.a(i3, 0);
            i3 += i4;
        }
    }

    public void setInitialPrefetchItemCount(int i2) {
        this.mInitialPrefetchItemCount = i2;
    }

    public int getInitialPrefetchItemCount() {
        return this.mInitialPrefetchItemCount;
    }

    public void collectAdjacentPrefetchPositions(int i2, int i3, RecyclerView.s sVar, RecyclerView.LayoutManager.a aVar) {
        if (this.mOrientation != 0) {
            i2 = i3;
        }
        if (getChildCount() != 0 && i2 != 0) {
            ensureLayoutState();
            updateLayoutState(i2 > 0 ? 1 : -1, Math.abs(i2), true, sVar);
            collectPrefetchPositionsForLayoutState(sVar, this.mLayoutState, aVar);
        }
    }

    /* access modifiers changed from: package-private */
    public int scrollBy(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        if (getChildCount() == 0 || i2 == 0) {
            return 0;
        }
        ensureLayoutState();
        this.mLayoutState.f4034a = true;
        int i3 = i2 > 0 ? 1 : -1;
        int abs = Math.abs(i2);
        updateLayoutState(i3, abs, true, sVar);
        int fill = this.mLayoutState.f4040g + fill(nVar, this.mLayoutState, sVar, false);
        if (fill < 0) {
            return 0;
        }
        if (abs > fill) {
            i2 = i3 * fill;
        }
        this.mOrientationHelper.a(-i2);
        this.mLayoutState.k = i2;
        return i2;
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    private void recycleChildren(RecyclerView.n nVar, int i2, int i3) {
        if (i2 != i3) {
            if (i3 > i2) {
                for (int i4 = i3 - 1; i4 >= i2; i4--) {
                    removeAndRecycleViewAt(i4, nVar);
                }
                return;
            }
            while (i2 > i3) {
                removeAndRecycleViewAt(i2, nVar);
                i2--;
            }
        }
    }

    private void recycleViewsFromStart(RecyclerView.n nVar, int i2, int i3) {
        if (i2 >= 0) {
            int i4 = i2 - i3;
            int childCount = getChildCount();
            if (this.mShouldReverseLayout) {
                int i5 = childCount - 1;
                for (int i6 = i5; i6 >= 0; i6--) {
                    View childAt = getChildAt(i6);
                    if (this.mOrientationHelper.b(childAt) > i4 || this.mOrientationHelper.c(childAt) > i4) {
                        recycleChildren(nVar, i5, i6);
                        return;
                    }
                }
                return;
            }
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt2 = getChildAt(i7);
                if (this.mOrientationHelper.b(childAt2) > i4 || this.mOrientationHelper.c(childAt2) > i4) {
                    recycleChildren(nVar, 0, i7);
                    return;
                }
            }
        }
    }

    private void recycleViewsFromEnd(RecyclerView.n nVar, int i2, int i3) {
        int childCount = getChildCount();
        if (i2 >= 0) {
            int d2 = (this.mOrientationHelper.d() - i2) + i3;
            if (this.mShouldReverseLayout) {
                for (int i4 = 0; i4 < childCount; i4++) {
                    View childAt = getChildAt(i4);
                    if (this.mOrientationHelper.a(childAt) < d2 || this.mOrientationHelper.d(childAt) < d2) {
                        recycleChildren(nVar, 0, i4);
                        return;
                    }
                }
                return;
            }
            int i5 = childCount - 1;
            for (int i6 = i5; i6 >= 0; i6--) {
                View childAt2 = getChildAt(i6);
                if (this.mOrientationHelper.a(childAt2) < d2 || this.mOrientationHelper.d(childAt2) < d2) {
                    recycleChildren(nVar, i5, i6);
                    return;
                }
            }
        }
    }

    private void recycleByLayoutState(RecyclerView.n nVar, c cVar) {
        if (cVar.f4034a && !cVar.m) {
            int i2 = cVar.f4040g;
            int i3 = cVar.f4042i;
            if (cVar.f4039f == -1) {
                recycleViewsFromEnd(nVar, i2, i3);
            } else {
                recycleViewsFromStart(nVar, i2, i3);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int fill(RecyclerView.n nVar, c cVar, RecyclerView.s sVar, boolean z) {
        int i2 = cVar.f4036c;
        if (cVar.f4040g != Integer.MIN_VALUE) {
            if (cVar.f4036c < 0) {
                cVar.f4040g += cVar.f4036c;
            }
            recycleByLayoutState(nVar, cVar);
        }
        int i3 = cVar.f4036c + cVar.f4041h;
        b bVar = this.mLayoutChunkResult;
        while (true) {
            if ((!cVar.m && i3 <= 0) || !cVar.a(sVar)) {
                break;
            }
            bVar.f4030a = 0;
            bVar.f4031b = false;
            bVar.f4032c = false;
            bVar.f4033d = false;
            layoutChunk(nVar, sVar, cVar, bVar);
            if (bVar.f4031b) {
                break;
            }
            cVar.f4035b += bVar.f4030a * cVar.f4039f;
            if (!bVar.f4032c || cVar.l != null || !sVar.f4096g) {
                cVar.f4036c -= bVar.f4030a;
                i3 -= bVar.f4030a;
            }
            if (cVar.f4040g != Integer.MIN_VALUE) {
                cVar.f4040g += bVar.f4030a;
                if (cVar.f4036c < 0) {
                    cVar.f4040g += cVar.f4036c;
                }
                recycleByLayoutState(nVar, cVar);
            }
            if (z && bVar.f4033d) {
                break;
            }
        }
        return i2 - cVar.f4036c;
    }

    /* access modifiers changed from: package-private */
    public void layoutChunk(RecyclerView.n nVar, RecyclerView.s sVar, c cVar, b bVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        View a2 = cVar.a(nVar);
        if (a2 == null) {
            bVar.f4031b = true;
            return;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) a2.getLayoutParams();
        if (cVar.l == null) {
            if (this.mShouldReverseLayout == (cVar.f4039f == -1)) {
                addView(a2);
            } else {
                addView(a2, 0);
            }
        } else {
            if (this.mShouldReverseLayout == (cVar.f4039f == -1)) {
                addDisappearingView(a2);
            } else {
                addDisappearingView(a2, 0);
            }
        }
        measureChildWithMargins(a2, 0, 0);
        bVar.f4030a = this.mOrientationHelper.e(a2);
        if (this.mOrientation == 1) {
            if (isLayoutRTL()) {
                i6 = getWidth() - getPaddingRight();
                i5 = i6 - this.mOrientationHelper.f(a2);
            } else {
                i5 = getPaddingLeft();
                i6 = this.mOrientationHelper.f(a2) + i5;
            }
            if (cVar.f4039f == -1) {
                int i7 = cVar.f4035b;
                i4 = cVar.f4035b - bVar.f4030a;
                i3 = i6;
                i2 = i7;
            } else {
                int i8 = cVar.f4035b;
                i2 = cVar.f4035b + bVar.f4030a;
                i3 = i6;
                i4 = i8;
            }
        } else {
            int paddingTop = getPaddingTop();
            int f2 = this.mOrientationHelper.f(a2) + paddingTop;
            if (cVar.f4039f == -1) {
                i4 = paddingTop;
                i3 = cVar.f4035b;
                i2 = f2;
                i5 = cVar.f4035b - bVar.f4030a;
            } else {
                int i9 = cVar.f4035b;
                i3 = cVar.f4035b + bVar.f4030a;
                i4 = paddingTop;
                i2 = f2;
                i5 = i9;
            }
        }
        layoutDecoratedWithMargins(a2, i5, i4, i3, i2);
        if (layoutParams.f4054c.isRemoved() || layoutParams.f4054c.isUpdated()) {
            bVar.f4032c = true;
        }
        bVar.f4033d = a2.hasFocusable();
    }

    /* access modifiers changed from: package-private */
    public boolean shouldMeasureTwice() {
        return (getHeightMode() == 1073741824 || getWidthMode() == 1073741824 || !hasFlexibleChildInBothOrientations()) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public int convertFocusDirectionToLayoutDirection(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 17 ? i2 != 33 ? i2 != 66 ? (i2 == 130 && this.mOrientation == 1) ? 1 : Integer.MIN_VALUE : this.mOrientation == 0 ? 1 : Integer.MIN_VALUE : this.mOrientation == 1 ? -1 : Integer.MIN_VALUE : this.mOrientation == 0 ? -1 : Integer.MIN_VALUE : (this.mOrientation != 1 && isLayoutRTL()) ? -1 : 1 : (this.mOrientation != 1 && isLayoutRTL()) ? 1 : -1;
    }

    private View getChildClosestToStart() {
        return getChildAt(this.mShouldReverseLayout ? getChildCount() - 1 : 0);
    }

    private View getChildClosestToEnd() {
        return getChildAt(this.mShouldReverseLayout ? 0 : getChildCount() - 1);
    }

    /* access modifiers changed from: package-private */
    public View findFirstVisibleChildClosestToStart(boolean z, boolean z2) {
        if (this.mShouldReverseLayout) {
            return findOneVisibleChild(getChildCount() - 1, -1, z, z2);
        }
        return findOneVisibleChild(0, getChildCount(), z, z2);
    }

    /* access modifiers changed from: package-private */
    public View findFirstVisibleChildClosestToEnd(boolean z, boolean z2) {
        if (this.mShouldReverseLayout) {
            return findOneVisibleChild(0, getChildCount(), z, z2);
        }
        return findOneVisibleChild(getChildCount() - 1, -1, z, z2);
    }

    private View findReferenceChildClosestToEnd(RecyclerView.n nVar, RecyclerView.s sVar) {
        if (this.mShouldReverseLayout) {
            return findFirstReferenceChild(nVar, sVar);
        }
        return findLastReferenceChild(nVar, sVar);
    }

    private View findReferenceChildClosestToStart(RecyclerView.n nVar, RecyclerView.s sVar) {
        if (this.mShouldReverseLayout) {
            return findLastReferenceChild(nVar, sVar);
        }
        return findFirstReferenceChild(nVar, sVar);
    }

    private View findFirstReferenceChild(RecyclerView.n nVar, RecyclerView.s sVar) {
        return findReferenceChild(nVar, sVar, 0, getChildCount(), sVar.a());
    }

    private View findLastReferenceChild(RecyclerView.n nVar, RecyclerView.s sVar) {
        return findReferenceChild(nVar, sVar, getChildCount() - 1, -1, sVar.a());
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
            if (position >= 0 && position < i4) {
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

    private View findPartiallyOrCompletelyInvisibleChildClosestToEnd() {
        if (this.mShouldReverseLayout) {
            return findFirstPartiallyOrCompletelyInvisibleChild();
        }
        return findLastPartiallyOrCompletelyInvisibleChild();
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToStart() {
        if (this.mShouldReverseLayout) {
            return findLastPartiallyOrCompletelyInvisibleChild();
        }
        return findFirstPartiallyOrCompletelyInvisibleChild();
    }

    private View findFirstPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(0, getChildCount());
    }

    private View findLastPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1);
    }

    public int findFirstVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), false, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), true, false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, false, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, true, false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    /* access modifiers changed from: package-private */
    public View findOneVisibleChild(int i2, int i3, boolean z, boolean z2) {
        ensureLayoutState();
        int i4 = UpiConstants.REQUEST_CODE_BANK_DETAIL;
        int i5 = z ? 24579 : UpiConstants.REQUEST_CODE_BANK_DETAIL;
        if (!z2) {
            i4 = 0;
        }
        if (this.mOrientation == 0) {
            return this.mHorizontalBoundCheck.a(i2, i3, i5, i4);
        }
        return this.mVerticalBoundCheck.a(i2, i3, i5, i4);
    }

    /* access modifiers changed from: package-private */
    public View findOnePartiallyOrCompletelyInvisibleChild(int i2, int i3) {
        int i4;
        int i5;
        ensureLayoutState();
        if ((i3 > i2 ? 1 : i3 < i2 ? (char) 65535 : 0) == 0) {
            return getChildAt(i2);
        }
        if (this.mOrientationHelper.a(getChildAt(i2)) < this.mOrientationHelper.b()) {
            i5 = 16644;
            i4 = 16388;
        } else {
            i5 = 4161;
            i4 = 4097;
        }
        if (this.mOrientation == 0) {
            return this.mHorizontalBoundCheck.a(i2, i3, i5, i4);
        }
        return this.mVerticalBoundCheck.a(i2, i3, i5, i4);
    }

    public View onFocusSearchFailed(View view, int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        int convertFocusDirectionToLayoutDirection;
        View view2;
        View view3;
        resolveShouldLayoutReverse();
        if (getChildCount() == 0 || (convertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i2)) == Integer.MIN_VALUE) {
            return null;
        }
        ensureLayoutState();
        updateLayoutState(convertFocusDirectionToLayoutDirection, (int) (((float) this.mOrientationHelper.e()) * MAX_SCROLL_FACTOR), false, sVar);
        c cVar = this.mLayoutState;
        cVar.f4040g = Integer.MIN_VALUE;
        cVar.f4034a = false;
        fill(nVar, cVar, sVar, true);
        if (convertFocusDirectionToLayoutDirection == -1) {
            view2 = findPartiallyOrCompletelyInvisibleChildClosestToStart();
        } else {
            view2 = findPartiallyOrCompletelyInvisibleChildClosestToEnd();
        }
        if (convertFocusDirectionToLayoutDirection == -1) {
            view3 = getChildClosestToStart();
        } else {
            view3 = getChildClosestToEnd();
        }
        if (!view3.hasFocusable()) {
            return view2;
        }
        if (view2 == null) {
            return null;
        }
        return view3;
    }

    private void logChildren() {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            StringBuilder sb = new StringBuilder("item ");
            sb.append(getPosition(childAt));
            sb.append(", coord:");
            sb.append(this.mOrientationHelper.a(childAt));
        }
    }

    /* access modifiers changed from: package-private */
    public void validateChildOrder() {
        new StringBuilder("validating child count ").append(getChildCount());
        if (getChildCount() > 0) {
            boolean z = false;
            int position = getPosition(getChildAt(0));
            int a2 = this.mOrientationHelper.a(getChildAt(0));
            if (this.mShouldReverseLayout) {
                int i2 = 1;
                while (i2 < getChildCount()) {
                    View childAt = getChildAt(i2);
                    int position2 = getPosition(childAt);
                    int a3 = this.mOrientationHelper.a(childAt);
                    if (position2 < position) {
                        logChildren();
                        StringBuilder sb = new StringBuilder("detected invalid position. loc invalid? ");
                        if (a3 < a2) {
                            z = true;
                        }
                        sb.append(z);
                        throw new RuntimeException(sb.toString());
                    } else if (a3 <= a2) {
                        i2++;
                    } else {
                        logChildren();
                        throw new RuntimeException("detected invalid location");
                    }
                }
                return;
            }
            int i3 = 1;
            while (i3 < getChildCount()) {
                View childAt2 = getChildAt(i3);
                int position3 = getPosition(childAt2);
                int a4 = this.mOrientationHelper.a(childAt2);
                if (position3 < position) {
                    logChildren();
                    StringBuilder sb2 = new StringBuilder("detected invalid position. loc invalid? ");
                    if (a4 < a2) {
                        z = true;
                    }
                    sb2.append(z);
                    throw new RuntimeException(sb2.toString());
                } else if (a4 >= a2) {
                    i3++;
                } else {
                    logChildren();
                    throw new RuntimeException("detected invalid location");
                }
            }
        }
    }

    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && this.mLastStackFromEnd == this.mStackFromEnd;
    }

    public void prepareForDrop(View view, View view2, int i2, int i3) {
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        ensureLayoutState();
        resolveShouldLayoutReverse();
        int position = getPosition(view);
        int position2 = getPosition(view2);
        char c2 = position < position2 ? (char) 1 : 65535;
        if (this.mShouldReverseLayout) {
            if (c2 == 1) {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.c() - (this.mOrientationHelper.a(view2) + this.mOrientationHelper.e(view)));
            } else {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.c() - this.mOrientationHelper.b(view2));
            }
        } else if (c2 == 65535) {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.a(view2));
        } else {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.b(view2) - this.mOrientationHelper.e(view));
        }
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        boolean f4034a = true;

        /* renamed from: b  reason: collision with root package name */
        int f4035b;

        /* renamed from: c  reason: collision with root package name */
        int f4036c;

        /* renamed from: d  reason: collision with root package name */
        int f4037d;

        /* renamed from: e  reason: collision with root package name */
        int f4038e;

        /* renamed from: f  reason: collision with root package name */
        int f4039f;

        /* renamed from: g  reason: collision with root package name */
        int f4040g;

        /* renamed from: h  reason: collision with root package name */
        int f4041h = 0;

        /* renamed from: i  reason: collision with root package name */
        int f4042i = 0;
        boolean j = false;
        int k;
        List<RecyclerView.v> l = null;
        boolean m;

        c() {
        }

        /* access modifiers changed from: package-private */
        public final boolean a(RecyclerView.s sVar) {
            int i2 = this.f4037d;
            return i2 >= 0 && i2 < sVar.a();
        }

        /* access modifiers changed from: package-private */
        public final View a(RecyclerView.n nVar) {
            if (this.l != null) {
                return a();
            }
            View c2 = nVar.c(this.f4037d);
            this.f4037d += this.f4038e;
            return c2;
        }

        private View a() {
            int size = this.l.size();
            int i2 = 0;
            while (i2 < size) {
                View view = this.l.get(i2).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (layoutParams.f4054c.isRemoved() || this.f4037d != layoutParams.f4054c.getLayoutPosition()) {
                    i2++;
                } else {
                    a(view);
                    return view;
                }
            }
            return null;
        }

        public final void a(View view) {
            View b2 = b(view);
            if (b2 == null) {
                this.f4037d = -1;
            } else {
                this.f4037d = ((RecyclerView.LayoutParams) b2.getLayoutParams()).f4054c.getLayoutPosition();
            }
        }

        private View b(View view) {
            int layoutPosition;
            int size = this.l.size();
            View view2 = null;
            int i2 = Integer.MAX_VALUE;
            for (int i3 = 0; i3 < size; i3++) {
                View view3 = this.l.get(i3).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view3.getLayoutParams();
                if (view3 != view && !layoutParams.f4054c.isRemoved() && (layoutPosition = (layoutParams.f4054c.getLayoutPosition() - this.f4037d) * this.f4038e) >= 0 && layoutPosition < i2) {
                    view2 = view3;
                    if (layoutPosition == 0) {
                        break;
                    }
                    i2 = layoutPosition;
                }
            }
            return view2;
        }
    }

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new SavedState[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        };

        /* renamed from: a  reason: collision with root package name */
        int f4022a;

        /* renamed from: b  reason: collision with root package name */
        int f4023b;

        /* renamed from: c  reason: collision with root package name */
        boolean f4024c;

        public int describeContents() {
            return 0;
        }

        public SavedState() {
        }

        SavedState(Parcel parcel) {
            this.f4022a = parcel.readInt();
            this.f4023b = parcel.readInt();
            this.f4024c = parcel.readInt() != 1 ? false : true;
        }

        public SavedState(SavedState savedState) {
            this.f4022a = savedState.f4022a;
            this.f4023b = savedState.f4023b;
            this.f4024c = savedState.f4024c;
        }

        /* access modifiers changed from: package-private */
        public final boolean a() {
            return this.f4022a >= 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f4022a);
            parcel.writeInt(this.f4023b);
            parcel.writeInt(this.f4024c ? 1 : 0);
        }
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        u f4025a;

        /* renamed from: b  reason: collision with root package name */
        int f4026b;

        /* renamed from: c  reason: collision with root package name */
        int f4027c;

        /* renamed from: d  reason: collision with root package name */
        boolean f4028d;

        /* renamed from: e  reason: collision with root package name */
        boolean f4029e;

        a() {
            a();
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            this.f4026b = -1;
            this.f4027c = Integer.MIN_VALUE;
            this.f4028d = false;
            this.f4029e = false;
        }

        /* access modifiers changed from: package-private */
        public final void b() {
            int i2;
            if (this.f4028d) {
                i2 = this.f4025a.c();
            } else {
                i2 = this.f4025a.b();
            }
            this.f4027c = i2;
        }

        public final String toString() {
            return "AnchorInfo{mPosition=" + this.f4026b + ", mCoordinate=" + this.f4027c + ", mLayoutFromEnd=" + this.f4028d + ", mValid=" + this.f4029e + '}';
        }

        public final void a(View view, int i2) {
            int a2 = this.f4025a.a();
            if (a2 >= 0) {
                b(view, i2);
                return;
            }
            this.f4026b = i2;
            if (this.f4028d) {
                int c2 = (this.f4025a.c() - a2) - this.f4025a.b(view);
                this.f4027c = this.f4025a.c() - c2;
                if (c2 > 0) {
                    int e2 = this.f4027c - this.f4025a.e(view);
                    int b2 = this.f4025a.b();
                    int min = e2 - (b2 + Math.min(this.f4025a.a(view) - b2, 0));
                    if (min < 0) {
                        this.f4027c += Math.min(c2, -min);
                        return;
                    }
                    return;
                }
                return;
            }
            int a3 = this.f4025a.a(view);
            int b3 = a3 - this.f4025a.b();
            this.f4027c = a3;
            if (b3 > 0) {
                int c3 = (this.f4025a.c() - Math.min(0, (this.f4025a.c() - a2) - this.f4025a.b(view))) - (a3 + this.f4025a.e(view));
                if (c3 < 0) {
                    this.f4027c -= Math.min(b3, -c3);
                }
            }
        }

        public final void b(View view, int i2) {
            if (this.f4028d) {
                this.f4027c = this.f4025a.b(view) + this.f4025a.a();
            } else {
                this.f4027c = this.f4025a.a(view);
            }
            this.f4026b = i2;
        }
    }

    protected static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f4030a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f4031b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f4032c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f4033d;

        protected b() {
        }
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public int getExtraLayoutSpace(RecyclerView.s sVar) {
        if (sVar.f4090a != -1) {
            return this.mOrientationHelper.e();
        }
        return 0;
    }

    private void layoutForPredictiveAnimations(RecyclerView.n nVar, RecyclerView.s sVar, int i2, int i3) {
        RecyclerView.n nVar2 = nVar;
        RecyclerView.s sVar2 = sVar;
        if (sVar2.k && getChildCount() != 0 && !sVar2.f4096g && supportsPredictiveItemAnimations()) {
            List<RecyclerView.v> list = nVar2.f4076d;
            int size = list.size();
            int position = getPosition(getChildAt(0));
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < size; i6++) {
                RecyclerView.v vVar = list.get(i6);
                if (!vVar.isRemoved()) {
                    char c2 = 1;
                    if ((vVar.getLayoutPosition() < position) != this.mShouldReverseLayout) {
                        c2 = 65535;
                    }
                    if (c2 == 65535) {
                        i4 += this.mOrientationHelper.e(vVar.itemView);
                    } else {
                        i5 += this.mOrientationHelper.e(vVar.itemView);
                    }
                }
            }
            this.mLayoutState.l = list;
            if (i4 > 0) {
                updateLayoutStateToFillStart(getPosition(getChildClosestToStart()), i2);
                c cVar = this.mLayoutState;
                cVar.f4041h = i4;
                cVar.f4036c = 0;
                cVar.a((View) null);
                fill(nVar2, this.mLayoutState, sVar2, false);
            }
            if (i5 > 0) {
                updateLayoutStateToFillEnd(getPosition(getChildClosestToEnd()), i3);
                c cVar2 = this.mLayoutState;
                cVar2.f4041h = i5;
                cVar2.f4036c = 0;
                cVar2.a((View) null);
                fill(nVar2, this.mLayoutState, sVar2, false);
            }
            this.mLayoutState.l = null;
        }
    }

    private boolean updateAnchorFromPendingData(RecyclerView.s sVar, a aVar) {
        int i2;
        int i3;
        boolean z = false;
        if (!sVar.f4096g && (i2 = this.mPendingScrollPosition) != -1) {
            if (i2 < 0 || i2 >= sVar.a()) {
                this.mPendingScrollPosition = -1;
                this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
            } else {
                aVar.f4026b = this.mPendingScrollPosition;
                SavedState savedState = this.mPendingSavedState;
                if (savedState != null && savedState.a()) {
                    aVar.f4028d = this.mPendingSavedState.f4024c;
                    if (aVar.f4028d) {
                        aVar.f4027c = this.mOrientationHelper.c() - this.mPendingSavedState.f4023b;
                    } else {
                        aVar.f4027c = this.mOrientationHelper.b() + this.mPendingSavedState.f4023b;
                    }
                    return true;
                } else if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) {
                    View findViewByPosition = findViewByPosition(this.mPendingScrollPosition);
                    if (findViewByPosition == null) {
                        if (getChildCount() > 0) {
                            if ((this.mPendingScrollPosition < getPosition(getChildAt(0))) == this.mShouldReverseLayout) {
                                z = true;
                            }
                            aVar.f4028d = z;
                        }
                        aVar.b();
                    } else if (this.mOrientationHelper.e(findViewByPosition) > this.mOrientationHelper.e()) {
                        aVar.b();
                        return true;
                    } else if (this.mOrientationHelper.a(findViewByPosition) - this.mOrientationHelper.b() < 0) {
                        aVar.f4027c = this.mOrientationHelper.b();
                        aVar.f4028d = false;
                        return true;
                    } else if (this.mOrientationHelper.c() - this.mOrientationHelper.b(findViewByPosition) < 0) {
                        aVar.f4027c = this.mOrientationHelper.c();
                        aVar.f4028d = true;
                        return true;
                    } else {
                        if (aVar.f4028d) {
                            i3 = this.mOrientationHelper.b(findViewByPosition) + this.mOrientationHelper.a();
                        } else {
                            i3 = this.mOrientationHelper.a(findViewByPosition);
                        }
                        aVar.f4027c = i3;
                    }
                    return true;
                } else {
                    boolean z2 = this.mShouldReverseLayout;
                    aVar.f4028d = z2;
                    if (z2) {
                        aVar.f4027c = this.mOrientationHelper.c() - this.mPendingScrollPositionOffset;
                    } else {
                        aVar.f4027c = this.mOrientationHelper.b() + this.mPendingScrollPositionOffset;
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
