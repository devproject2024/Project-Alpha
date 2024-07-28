package net.one97.paytm.vipcashback.widget;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.q;

public final class WrapLinearLayoutManager extends LinearLayoutManager {
    public WrapLinearLayoutManager(Context context) {
        super(context);
    }

    public final void onLayoutChildren(RecyclerView.n nVar, RecyclerView.s sVar) {
        try {
            super.onLayoutChildren(nVar, sVar);
        } catch (Exception unused) {
            q.b("IOOBE in RecyclerView");
        }
    }
}
