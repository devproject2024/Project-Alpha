package net.one97.paytm.feed.ui.feed.h.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.k;
import kotlin.o;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.a;
import net.one97.paytm.feed.b.au;
import net.one97.paytm.feed.repository.models.merchantstorefront.Brand;

public final class b extends RecyclerView.a<e<au, ? super Brand>> {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<Brand> f35067a = new ArrayList<>();

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        e eVar = (e) vVar;
        k.c(eVar, "holder");
        Brand brand = this.f35067a.get(i2);
        k.a((Object) brand, "result[position]");
        Brand brand2 = brand;
        k.c(brand2, "data");
        B b2 = eVar.f35068a;
        b2.setVariable(a.f33780g, brand2);
        b2.setVariable(a.f33778e, Integer.valueOf(i2));
        for (Map.Entry entry : ae.c(new o(Integer.valueOf(a.f33775b), new d())).entrySet()) {
            b2.setVariable(((Number) entry.getKey()).intValue(), entry.getValue());
        }
        eVar.f35068a.executePendingBindings();
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        com.google.android.play.core.splitcompat.a.a(viewGroup.getContext());
        com.google.android.play.core.splitcompat.a.b(viewGroup.getContext());
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (from == null) {
            k.a();
        }
        View inflate = from.inflate(R.layout.feed_merchant_storefront_item, viewGroup, false);
        k.a((Object) inflate, "view");
        return new e(inflate);
    }

    public final int getItemCount() {
        return this.f35067a.size();
    }

    public final long getItemId(int i2) {
        return (long) this.f35067a.get(i2).getContractId().hashCode();
    }
}
