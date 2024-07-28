package net.one97.paytm.recharge.presentation.f;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;

public abstract class f extends RecyclerView.v {
    public abstract <T> void a(T t);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(View view) {
        super(view);
        k.c(view, "itemView");
    }
}
