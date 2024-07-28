package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class v extends z {

    /* renamed from: a  reason: collision with root package name */
    private u f4357a;

    /* renamed from: b  reason: collision with root package name */
    private u f4358b;

    public int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View view) {
        int[] iArr = new int[2];
        if (layoutManager.canScrollHorizontally()) {
            iArr[0] = a(view, b(layoutManager));
        } else {
            iArr[0] = 0;
        }
        if (layoutManager.canScrollVertically()) {
            iArr[1] = a(view, a(layoutManager));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.canScrollVertically()) {
            return a(layoutManager, a(layoutManager));
        }
        if (layoutManager.canScrollHorizontally()) {
            return a(layoutManager, b(layoutManager));
        }
        return null;
    }

    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i2, int i3) {
        u uVar;
        PointF computeScrollVectorForPosition;
        int itemCount = layoutManager.getItemCount();
        if (itemCount == 0) {
            return -1;
        }
        if (layoutManager.canScrollVertically()) {
            uVar = a(layoutManager);
        } else if (layoutManager.canScrollHorizontally()) {
            uVar = b(layoutManager);
        } else {
            uVar = null;
        }
        if (uVar == null) {
            return -1;
        }
        int i4 = Integer.MIN_VALUE;
        int i5 = Integer.MAX_VALUE;
        int childCount = layoutManager.getChildCount();
        boolean z = false;
        View view = null;
        View view2 = null;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = layoutManager.getChildAt(i6);
            if (childAt != null) {
                int a2 = a(childAt, uVar);
                if (a2 <= 0 && a2 > i4) {
                    view2 = childAt;
                    i4 = a2;
                }
                if (a2 >= 0 && a2 < i5) {
                    view = childAt;
                    i5 = a2;
                }
            }
        }
        int i7 = 1;
        boolean z2 = !layoutManager.canScrollHorizontally() ? i3 > 0 : i2 > 0;
        if (z2 && view != null) {
            return layoutManager.getPosition(view);
        }
        if (!z2 && view2 != null) {
            return layoutManager.getPosition(view2);
        }
        if (z2) {
            view = view2;
        }
        if (view == null) {
            return -1;
        }
        int position = layoutManager.getPosition(view);
        int itemCount2 = layoutManager.getItemCount();
        if ((layoutManager instanceof RecyclerView.r.b) && (computeScrollVectorForPosition = ((RecyclerView.r.b) layoutManager).computeScrollVectorForPosition(itemCount2 - 1)) != null && (computeScrollVectorForPosition.x < 0.0f || computeScrollVectorForPosition.y < 0.0f)) {
            z = true;
        }
        if (z == z2) {
            i7 = -1;
        }
        int i8 = position + i7;
        if (i8 < 0 || i8 >= itemCount) {
            return -1;
        }
        return i8;
    }

    /* access modifiers changed from: protected */
    public p createSnapScroller(RecyclerView.LayoutManager layoutManager) {
        if (!(layoutManager instanceof RecyclerView.r.b)) {
            return null;
        }
        return new p(this.mRecyclerView.getContext()) {
            /* access modifiers changed from: protected */
            public final void onTargetFound(View view, RecyclerView.s sVar, RecyclerView.r.a aVar) {
                v vVar = v.this;
                int[] calculateDistanceToFinalSnap = vVar.calculateDistanceToFinalSnap(vVar.mRecyclerView.getLayoutManager(), view);
                int i2 = calculateDistanceToFinalSnap[0];
                int i3 = calculateDistanceToFinalSnap[1];
                int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i2), Math.abs(i3)));
                if (calculateTimeForDeceleration > 0) {
                    aVar.a(i2, i3, calculateTimeForDeceleration, this.mDecelerateInterpolator);
                }
            }

            /* access modifiers changed from: protected */
            public final float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return 100.0f / ((float) displayMetrics.densityDpi);
            }

            /* access modifiers changed from: protected */
            public final int calculateTimeForScrolling(int i2) {
                return Math.min(100, super.calculateTimeForScrolling(i2));
            }
        };
    }

    private static int a(View view, u uVar) {
        return (uVar.a(view) + (uVar.e(view) / 2)) - (uVar.b() + (uVar.e() / 2));
    }

    private static View a(RecyclerView.LayoutManager layoutManager, u uVar) {
        int childCount = layoutManager.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        int b2 = uVar.b() + (uVar.e() / 2);
        int i2 = Integer.MAX_VALUE;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = layoutManager.getChildAt(i3);
            int abs = Math.abs((uVar.a(childAt) + (uVar.e(childAt) / 2)) - b2);
            if (abs < i2) {
                view = childAt;
                i2 = abs;
            }
        }
        return view;
    }

    private u a(RecyclerView.LayoutManager layoutManager) {
        u uVar = this.f4357a;
        if (uVar == null || uVar.f4354a != layoutManager) {
            this.f4357a = u.b(layoutManager);
        }
        return this.f4357a;
    }

    private u b(RecyclerView.LayoutManager layoutManager) {
        u uVar = this.f4358b;
        if (uVar == null || uVar.f4354a != layoutManager) {
            this.f4358b = u.a(layoutManager);
        }
        return this.f4358b;
    }
}
