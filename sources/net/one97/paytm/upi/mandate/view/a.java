package net.one97.paytm.upi.mandate.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import net.one97.paytm.upi.R;

public final class a extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    final TextView f67506a;

    /* renamed from: b  reason: collision with root package name */
    final ImageView f67507b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(View view) {
        super(view);
        k.c(view, "itemView");
        View findViewById = view.findViewById(R.id.banner_txn_msg);
        k.a((Object) findViewById, "itemView.findViewById(R.id.banner_txn_msg)");
        this.f67506a = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.ivCloseBanner);
        k.a((Object) findViewById2, "itemView.findViewById(R.id.ivCloseBanner)");
        this.f67507b = (ImageView) findViewById2;
    }
}
