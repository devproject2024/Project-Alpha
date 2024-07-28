package net.one97.paytm.recharge.mobile_v3.c;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import net.one97.paytm.recharge.R;

public final class g extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f63939a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(View view) {
        super(view);
        k.c(view, "itemView");
        this.f63939a = (TextView) view.findViewById(R.id.txt_description);
    }
}
