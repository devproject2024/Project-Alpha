package net.one97.paytm.recharge.common.a;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.shopping.CJRCartProduct;

public abstract class ag extends RecyclerView.v {
    public abstract void a(CJRCartProduct cJRCartProduct);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ag(View view) {
        super(view);
        k.c(view, "itemView");
    }
}
