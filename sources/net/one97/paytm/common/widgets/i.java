package net.one97.paytm.common.widgets;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public final class i extends RecyclerView.h {

    /* renamed from: a  reason: collision with root package name */
    private int f49918a;

    /* renamed from: b  reason: collision with root package name */
    private int f49919b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f49920c;

    public i(int i2, int i3, boolean z) {
        this.f49918a = i2;
        this.f49919b = i3;
        this.f49920c = z;
    }

    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
        int i2 = ((GridLayoutManager.LayoutParams) view.getLayoutParams()).f4016a;
        int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
        if (this.f49920c) {
            int i3 = this.f49919b;
            int i4 = this.f49918a;
            rect.left = i3 - ((i2 * i3) / i4);
            rect.right = ((i2 + 1) * i3) / i4;
            if (childLayoutPosition < i4) {
                rect.top = i3;
            }
            rect.bottom = this.f49919b;
            return;
        }
        int i5 = this.f49919b;
        int i6 = this.f49918a;
        rect.left = (i2 * i5) / i6;
        rect.right = i5 - (((i2 + 1) * i5) / i6);
        if (childLayoutPosition >= i6) {
            rect.top = i5;
        }
    }
}
