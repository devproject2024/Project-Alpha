package net.one97.paytm.recharge.common.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.d.d;
import net.one97.paytm.recharge.common.d.e;
import net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList;

public final class w extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<CJRBrowsePlanProductList> f60705a;

    /* renamed from: b  reason: collision with root package name */
    private final int f60706b;

    /* renamed from: c  reason: collision with root package name */
    private final int f60707c = 1;

    /* renamed from: d  reason: collision with root package name */
    private final b f60708d;

    public interface b {
        void a(CJRBrowsePlanProductList cJRBrowsePlanProductList);

        void b(CJRBrowsePlanProductList cJRBrowsePlanProductList);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        CJRBrowsePlanProductList cJRBrowsePlanProductList = this.f60705a.get(i2);
        k.a((Object) cJRBrowsePlanProductList, "productList[position]");
        aVar.a(i2, cJRBrowsePlanProductList);
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        a aVar;
        k.c(viewGroup, "viewGroup");
        if (i2 == this.f60706b) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.browse_plan_adapter_layout, viewGroup, false);
            k.a((Object) inflate, "LayoutInflater.from(view…layout, viewGroup, false)");
            aVar = new d(inflate, this.f60708d, this.f60705a);
        } else {
            View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.browse_plan_adapter_layout, viewGroup, false);
            k.a((Object) inflate2, "LayoutInflater.from(view…layout, viewGroup, false)");
            aVar = new e(inflate2, this.f60708d, this.f60705a);
        }
        return aVar;
    }

    public w(ArrayList<CJRBrowsePlanProductList> arrayList, b bVar) {
        k.c(arrayList, "productList");
        k.c(bVar, "itemClickListner");
        this.f60705a = arrayList;
        this.f60708d = bVar;
    }

    public final int getItemCount() {
        return this.f60705a.size();
    }

    public final int getItemViewType(int i2) {
        CJRBrowsePlanProductList cJRBrowsePlanProductList = this.f60705a.get(i2);
        k.a((Object) cJRBrowsePlanProductList, "productList[position]");
        String productType = cJRBrowsePlanProductList.getProductType();
        if (productType == null || !p.a(productType, "topup", true)) {
            return this.f60707c;
        }
        return this.f60706b;
    }

    public static abstract class a extends RecyclerView.v {
        public abstract void a(int i2, CJRBrowsePlanProductList cJRBrowsePlanProductList);

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            k.c(view, "itemView");
        }
    }
}
