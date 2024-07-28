package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class q extends z {

    /* renamed from: a  reason: collision with root package name */
    private u f4348a;

    /* renamed from: b  reason: collision with root package name */
    private u f4349b;

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

    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i2, int i3) {
        int itemCount;
        View findSnapView;
        int position;
        int i4;
        PointF computeScrollVectorForPosition;
        int i5;
        int i6;
        if (!(layoutManager instanceof RecyclerView.r.b) || (itemCount = layoutManager.getItemCount()) == 0 || (findSnapView = findSnapView(layoutManager)) == null || (position = layoutManager.getPosition(findSnapView)) == -1 || (computeScrollVectorForPosition = ((RecyclerView.r.b) layoutManager).computeScrollVectorForPosition(i4)) == null) {
            return -1;
        }
        if (layoutManager.canScrollHorizontally()) {
            i5 = a(layoutManager, b(layoutManager), i2, 0);
            if (computeScrollVectorForPosition.x < 0.0f) {
                i5 = -i5;
            }
        } else {
            i5 = 0;
        }
        if (layoutManager.canScrollVertically()) {
            i6 = a(layoutManager, a(layoutManager), 0, i3);
            if (computeScrollVectorForPosition.y < 0.0f) {
                i6 = -i6;
            }
        } else {
            i6 = 0;
        }
        if (layoutManager.canScrollVertically()) {
            i5 = i6;
        }
        if (i5 == 0) {
            return -1;
        }
        int i7 = position + i5;
        if (i7 < 0) {
            i7 = 0;
        }
        return i7 >= itemCount ? itemCount - 1 : i7;
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

    private static int a(View view, u uVar) {
        return (uVar.a(view) + (uVar.e(view) / 2)) - (uVar.b() + (uVar.e() / 2));
    }

    private int a(RecyclerView.LayoutManager layoutManager, u uVar, int i2, int i3) {
        int[] calculateScrollDistance = calculateScrollDistance(i2, i3);
        float b2 = b(layoutManager, uVar);
        if (b2 <= 0.0f) {
            return 0;
        }
        return Math.round(((float) (Math.abs(calculateScrollDistance[0]) > Math.abs(calculateScrollDistance[1]) ? calculateScrollDistance[0] : calculateScrollDistance[1])) / b2);
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

    private static float b(RecyclerView.LayoutManager layoutManager, u uVar) {
        int max;
        int childCount = layoutManager.getChildCount();
        if (childCount == 0) {
            return 1.0f;
        }
        View view = null;
        View view2 = null;
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = layoutManager.getChildAt(i4);
            int position = layoutManager.getPosition(childAt);
            if (position != -1) {
                if (position < i2) {
                    view = childAt;
                    i2 = position;
                }
                if (position > i3) {
                    view2 = childAt;
                    i3 = position;
                }
            }
        }
        if (view == null || view2 == null || (max = Math.max(uVar.b(view), uVar.b(view2)) - Math.min(uVar.a(view), uVar.a(view2))) == 0) {
            return 1.0f;
        }
        return (((float) max) * 1.0f) / ((float) ((i3 - i2) + 1));
    }

    private u a(RecyclerView.LayoutManager layoutManager) {
        u uVar = this.f4348a;
        if (uVar == null || uVar.f4354a != layoutManager) {
            this.f4348a = u.b(layoutManager);
        }
        return this.f4348a;
    }

    private u b(RecyclerView.LayoutManager layoutManager) {
        u uVar = this.f4349b;
        if (uVar == null || uVar.f4354a != layoutManager) {
            this.f4349b = u.a(layoutManager);
        }
        return this.f4349b;
    }
}
