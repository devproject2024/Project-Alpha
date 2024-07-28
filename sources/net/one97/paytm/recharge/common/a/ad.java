package net.one97.paytm.recharge.common.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.shopping.CJRCartProduct;
import net.one97.paytm.recharge.R;

public final class ad extends RecyclerView.a<ag> {

    /* renamed from: a  reason: collision with root package name */
    private final List<CJRCartProduct> f60468a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f60469b;

    /* renamed from: c  reason: collision with root package name */
    private final ah f60470c;

    public ad(List<? extends CJRCartProduct> list, Context context, ah ahVar) {
        k.c(list, "items");
        k.c(context, "context");
        k.c(ahVar, "displayType");
        this.f60468a = list;
        this.f60469b = context;
        this.f60470c = ahVar;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        ag agVar = (ag) vVar;
        k.c(agVar, "holder");
        agVar.a(this.f60468a.get(i2));
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        ag agVar;
        k.c(viewGroup, "parent");
        int i3 = ae.f60471a[this.f60470c.ordinal()];
        if (i3 == 1) {
            View inflate = LayoutInflater.from(this.f60469b).inflate(R.layout.payment_detail_view, viewGroup, false);
            k.a((Object) inflate, "LayoutInflater.from(cont…tail_view, parent, false)");
            agVar = new af(inflate, this.f60469b);
        } else if (i3 != 2) {
            View inflate2 = LayoutInflater.from(this.f60469b).inflate(R.layout.payment_detail_view, viewGroup, false);
            k.a((Object) inflate2, "LayoutInflater.from(cont…tail_view, parent, false)");
            agVar = new aa(inflate2, this.f60469b);
        } else {
            View inflate3 = LayoutInflater.from(this.f60469b).inflate(R.layout.coupon_order_detail_view, viewGroup, false);
            k.a((Object) inflate3, "LayoutInflater.from(cont…tail_view, parent, false)");
            agVar = new z(inflate3, this.f60469b);
        }
        return agVar;
    }

    public final int getItemCount() {
        return this.f60468a.size();
    }
}
