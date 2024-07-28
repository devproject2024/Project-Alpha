package net.one97.paytm.recharge.presentation.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.g.b.k;
import net.one97.paytm.recharge.automatic.R;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel;
import net.one97.paytm.recharge.presentation.d.a;
import net.one97.paytm.recharge.presentation.d.b;

public final class e extends RecyclerView.a<net.one97.paytm.recharge.presentation.f.e> {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<CJRAutomaticSubscriptionItemModel> f64599a;

    /* renamed from: b  reason: collision with root package name */
    private final b f64600b;

    /* renamed from: c  reason: collision with root package name */
    private a f64601c;

    public e(ArrayList<CJRAutomaticSubscriptionItemModel> arrayList, b bVar, a aVar) {
        k.c(arrayList, "subscriptionItemList");
        k.c(aVar, "activateClickListener");
        this.f64599a = arrayList;
        this.f64600b = bVar;
        this.f64601c = aVar;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        net.one97.paytm.recharge.presentation.f.e eVar = (net.one97.paytm.recharge.presentation.f.e) vVar;
        k.c(eVar, "holder");
        eVar.a(this.f64599a.get(i2));
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_subscription_item, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(pare…tion_item, parent, false)");
        return new net.one97.paytm.recharge.presentation.f.e(inflate, this.f64600b, this.f64601c);
    }

    public final int getItemCount() {
        Collection collection = this.f64599a;
        if (collection == null || collection.isEmpty()) {
            return 0;
        }
        return this.f64599a.size();
    }

    public final void a(ArrayList<CJRAutomaticSubscriptionItemModel> arrayList) {
        if (arrayList == null) {
            this.f64599a.clear();
        } else {
            this.f64599a = arrayList;
        }
        notifyDataSetChanged();
    }
}
