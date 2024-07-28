package net.one97.paytm.o2o.movies.adapter;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import net.one97.paytm.o2o.movies.R;

public final class au extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    final TextView f74476a;

    /* renamed from: b  reason: collision with root package name */
    final TextView f74477b;

    /* renamed from: c  reason: collision with root package name */
    final RelativeLayout f74478c;

    /* renamed from: d  reason: collision with root package name */
    private final View f74479d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public au(View view) {
        super(view);
        k.c(view, "view");
        this.f74479d = view;
        View findViewById = this.itemView.findViewById(R.id.tabTextdate);
        if (findViewById == null) {
            k.a();
        }
        this.f74476a = (TextView) findViewById;
        View findViewById2 = this.itemView.findViewById(R.id.tabTextday);
        if (findViewById2 == null) {
            k.a();
        }
        this.f74477b = (TextView) findViewById2;
        View findViewById3 = this.itemView.findViewById(R.id.date_selection_lin_lay);
        if (findViewById3 == null) {
            k.a();
        }
        this.f74478c = (RelativeLayout) findViewById3;
    }
}
