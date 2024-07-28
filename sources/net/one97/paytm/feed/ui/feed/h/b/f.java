package net.one97.paytm.feed.ui.feed.h.b;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.a;
import net.one97.paytm.feed.b.as;
import net.one97.paytm.feed.repository.models.merchantstorefront.Brand;
import net.one97.paytm.feed.repository.models.merchantstorefront.FeedMerchantStoreFront;
import net.one97.paytm.feed.ui.base.b;

public final class f extends b<as, FeedMerchantStoreFront, g> {

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f35070b;

    /* renamed from: c  reason: collision with root package name */
    private b f35071c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(View view) {
        super(view);
        k.c(view, "view");
        this.f35070b = (RecyclerView) view.findViewById(R.id.merchant_recyclerview);
        new q();
        RecyclerView recyclerView = this.f35070b;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
            recyclerView.addItemDecoration(new a(recyclerView.getContext(), R.dimen.feed_merchant_storefront_item_offset));
            this.f35071c = new b();
            b bVar = this.f35071c;
            if (bVar == null) {
                k.a();
            }
            bVar.setHasStableIds(true);
            recyclerView.setAdapter(this.f35071c);
        }
    }

    public final void a(FeedMerchantStoreFront feedMerchantStoreFront, int i2) {
        k.c(feedMerchantStoreFront, "data");
        as asVar = (as) this.f34872a;
        asVar.setVariable(a.f33780g, feedMerchantStoreFront);
        asVar.setVariable(a.f33778e, Integer.valueOf(i2));
        for (Map.Entry entry : new HashMap().entrySet()) {
            asVar.setVariable(((Number) entry.getKey()).intValue(), entry.getValue());
        }
        ((as) this.f34872a).executePendingBindings();
        b bVar = this.f35071c;
        if (bVar != null) {
            List<Brand> brands = feedMerchantStoreFront.getFeedMerchantStoreFrontData().getBrands();
            if (brands != null) {
                ArrayList arrayList = (ArrayList) brands;
                k.c(arrayList, "data");
                bVar.f35067a.clear();
                bVar.f35067a.addAll(arrayList);
                bVar.notifyDataSetChanged();
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.collections.ArrayList<net.one97.paytm.feed.repository.models.merchantstorefront.Brand> /* = java.util.ArrayList<net.one97.paytm.feed.repository.models.merchantstorefront.Brand> */");
        }
    }
}
