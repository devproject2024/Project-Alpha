package net.one97.paytm.recharge.common.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.w;
import net.one97.paytm.recharge.common.d.c;
import net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList;

public final class e extends RecyclerView.a<c> {

    /* renamed from: a  reason: collision with root package name */
    public final List<CJRBrowsePlanProductList> f60491a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f60492b;

    /* renamed from: c  reason: collision with root package name */
    private final w.b f60493c;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        c cVar = (c) vVar;
        k.c(cVar, "holder");
        cVar.a(this.f60491a.get(i2));
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "viewGroup");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.v3_browse_plan_search_adapter_layout, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(view…layout, viewGroup, false)");
        return new c(inflate, this.f60493c, this.f60491a, this.f60492b);
    }

    public e(List<? extends CJRBrowsePlanProductList> list, Object obj, w.b bVar) {
        k.c(list, "productList");
        k.c(obj, "eventCategory");
        k.c(bVar, "itemClickListner");
        this.f60491a = list;
        this.f60492b = obj;
        this.f60493c = bVar;
    }

    public final int getItemCount() {
        return this.f60491a.size();
    }
}
