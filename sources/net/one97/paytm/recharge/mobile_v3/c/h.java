package net.one97.paytm.recharge.mobile_v3.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import net.one97.paytm.recharge.R;

public final class h extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f63940a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f63941b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f63942c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(View view) {
        super(view);
        k.c(view, "itemView");
        this.f63940a = (ImageView) view.findViewById(R.id.radio_btn);
        this.f63941b = (TextView) view.findViewById(R.id.txt_product_type_name);
        this.f63942c = (TextView) view.findViewById(R.id.txt_product_type_description);
    }
}
