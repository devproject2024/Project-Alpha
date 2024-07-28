package net.one97.paytm.upi.util;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class VerticalSpaceItemDecoration extends RecyclerView.h {
    private final int mVerticalSpaceHeight;

    public VerticalSpaceItemDecoration(int i2) {
        this.mVerticalSpaceHeight = i2;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
        rect.bottom = this.mVerticalSpaceHeight;
    }
}
