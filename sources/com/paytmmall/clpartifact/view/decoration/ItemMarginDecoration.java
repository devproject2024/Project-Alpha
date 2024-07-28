package com.paytmmall.clpartifact.view.decoration;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.paytmmall.clpartifact.R;

public class ItemMarginDecoration extends BaseLayoutMargin {
    public /* bridge */ /* synthetic */ int getSpacing() {
        return super.getSpacing();
    }

    public /* bridge */ /* synthetic */ int getSpanCount() {
        return super.getSpanCount();
    }

    public ItemMarginDecoration(int i2) {
        super(1, i2);
    }

    public ItemMarginDecoration(int i2, int i3) {
        super(i2, i3);
    }

    public void setPadding(RecyclerView recyclerView, int i2) {
        super.setPadding(recyclerView, i2);
    }

    public void setPadding(RecyclerView recyclerView, int i2, int i3, int i4, int i5) {
        super.setPadding(recyclerView, i2, i3, i4, i5);
    }

    public void setOnClickLayoutMarginItemListener(OnClickLayoutMarginItemListener onClickLayoutMarginItemListener) {
        super.setOnClickLayoutMarginItemListener(onClickLayoutMarginItemListener);
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
        boolean z;
        int i2;
        int i3;
        int orientation;
        boolean reverseLayout;
        int i4;
        View view2 = view;
        RecyclerView recyclerView2 = recyclerView;
        super.getItemOffsets(rect, view, recyclerView, sVar);
        boolean z2 = recyclerView.getContext().getResources().getBoolean(R.bool.is_right_to_left);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int spanCount = childAdapterPosition % getSpanCount();
        if (recyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager) {
            orientation = ((StaggeredGridLayoutManager) recyclerView.getLayoutManager()).f4110e;
            reverseLayout = ((StaggeredGridLayoutManager) recyclerView.getLayoutManager()).f4111f;
            i4 = ((StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams()).b();
        } else if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
            orientation = ((GridLayoutManager) recyclerView.getLayoutManager()).getOrientation();
            reverseLayout = ((GridLayoutManager) recyclerView.getLayoutManager()).getReverseLayout();
            i4 = ((GridLayoutManager.LayoutParams) view.getLayoutParams()).f4016a;
            if (z2 && orientation == 1) {
                i4 = (getSpanCount() - i4) - 1;
            }
        } else {
            if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                i2 = ((LinearLayoutManager) recyclerView.getLayoutManager()).getOrientation();
                z = ((LinearLayoutManager) recyclerView.getLayoutManager()).getReverseLayout();
                childAdapterPosition = recyclerView.getChildAdapterPosition(view);
                i3 = 0;
            } else {
                i3 = spanCount;
                i2 = 1;
                z = false;
            }
            int a2 = (z2 || i2 != 0) ? childAdapterPosition : (sVar.a() - childAdapterPosition) - 1;
            setupClickLayoutMarginItem(recyclerView.getContext(), view, a2, i3, sVar);
            calculateMargin(rect, a2, i3, sVar.a(), i2, z, z2);
        }
        i2 = orientation;
        z = reverseLayout;
        i3 = i4;
        if (z2) {
        }
        setupClickLayoutMarginItem(recyclerView.getContext(), view, a2, i3, sVar);
        calculateMargin(rect, a2, i3, sVar.a(), i2, z, z2);
    }
}
