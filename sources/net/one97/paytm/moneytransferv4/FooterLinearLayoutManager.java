package net.one97.paytm.moneytransferv4;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import kotlin.u;

public final class FooterLinearLayoutManager extends LinearLayoutManager {
    public final void layoutDecoratedWithMargins(View view, int i2, int i3, int i4, int i5) {
        k.c(view, "child");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        } else if (((RecyclerView.LayoutParams) layoutParams).a() < getItemCount() - 1) {
            super.layoutDecoratedWithMargins(view, i2, i3, i4, i5);
        } else {
            int height = getHeight() - getPaddingBottom();
            if (i5 < height) {
                int i6 = height - i5;
                super.layoutDecoratedWithMargins(view, i2, i3 + i6, i4, i5 + i6);
                return;
            }
            super.layoutDecoratedWithMargins(view, i2, i3, i4, i5);
        }
    }
}
