package net.one97.paytm.vipcashback.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.q;

public class WrapContentLinearLayoutManager extends LinearLayoutManager {
    public WrapContentLinearLayoutManager(Context context) {
        super(context);
    }

    public WrapContentLinearLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }

    public void onLayoutChildren(RecyclerView.n nVar, RecyclerView.s sVar) {
        try {
            super.onLayoutChildren(nVar, sVar);
        } catch (IndexOutOfBoundsException unused) {
            q.b("java.lang.IndexOutOfBoundsException: Inconsistency detected. Invalid view holder adapter positionViewHolder");
        }
    }
}
