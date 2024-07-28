package net.one97.paytm.recharge.common.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.w;
import net.one97.paytm.recharge.common.d.e;
import net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList;

public final class f extends RecyclerView.a<e> {

    /* renamed from: a  reason: collision with root package name */
    public final List<CJRBrowsePlanProductList> f60494a;

    /* renamed from: b  reason: collision with root package name */
    private final w.b f60495b;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        e eVar = (e) vVar;
        k.c(eVar, "holder");
        eVar.a(i2, this.f60494a.get(i2));
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "viewGroup");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.browse_plan_adapter_layout, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(view…layout, viewGroup, false)");
        return new e(inflate, this.f60495b, this.f60494a);
    }

    public f(List<? extends CJRBrowsePlanProductList> list, w.b bVar) {
        k.c(list, "productList");
        k.c(bVar, "itemClickListner");
        this.f60494a = list;
        this.f60495b = bVar;
    }

    public final int getItemCount() {
        return this.f60494a.size();
    }
}
