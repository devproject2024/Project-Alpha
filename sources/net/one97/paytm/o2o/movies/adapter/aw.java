package net.one97.paytm.o2o.movies.adapter;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import net.one97.paytm.o2o.movies.R;

public final class aw extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    final TextView f74488a;

    /* renamed from: b  reason: collision with root package name */
    final TextView f74489b;

    /* renamed from: c  reason: collision with root package name */
    final RelativeLayout f74490c;

    /* renamed from: d  reason: collision with root package name */
    private final View f74491d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public aw(View view) {
        super(view);
        k.c(view, "view");
        this.f74491d = view;
        View findViewById = this.itemView.findViewById(R.id.tabTextdate);
        if (findViewById == null) {
            k.a();
        }
        this.f74488a = (TextView) findViewById;
        View findViewById2 = this.itemView.findViewById(R.id.tabTextday);
        if (findViewById2 == null) {
            k.a();
        }
        this.f74489b = (TextView) findViewById2;
        View findViewById3 = this.itemView.findViewById(R.id.date_selection_lin_lay);
        if (findViewById3 == null) {
            k.a();
        }
        this.f74490c = (RelativeLayout) findViewById3;
    }
}
