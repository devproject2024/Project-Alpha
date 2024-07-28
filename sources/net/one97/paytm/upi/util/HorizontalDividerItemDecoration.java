package net.one97.paytm.upi.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.content.b;
import androidx.recyclerview.widget.RecyclerView;
import net.one97.paytm.upi.R;

public class HorizontalDividerItemDecoration extends RecyclerView.h {
    private int leftMargin;
    private Context mContext;
    private Drawable mDivider;

    public HorizontalDividerItemDecoration(Context context) {
        this.mContext = context;
        this.mDivider = b.a(this.mContext, R.drawable.upi_passbook_item_divider_decoration);
    }

    public HorizontalDividerItemDecoration(Context context, Drawable drawable, int i2) {
        this.mContext = context;
        this.mDivider = drawable;
        this.leftMargin = i2;
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            this.mDivider.setBounds(this.leftMargin + paddingLeft, bottom, width, this.mDivider.getIntrinsicHeight() + bottom);
            this.mDivider.draw(canvas);
        }
    }
}
