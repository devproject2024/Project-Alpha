package net.one97.paytm.paymentsBank.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.w;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.storefront.model.StoreFrontItem;
import net.one97.paytm.paymentsBank.storefront.model.StoreFrontViews;

public final class g extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    final Context f17321a;

    /* renamed from: b  reason: collision with root package name */
    final List<StoreFrontViews> f17322b;

    public g(Context context, List<StoreFrontViews> list) {
        k.c(context, "context");
        k.c(list, "mOfferList");
        this.f17321a = context;
        this.f17322b = list;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        StoreFrontViews storeFrontViews = this.f17322b.get(0);
        List<StoreFrontItem> list = null;
        List<StoreFrontItem> items = storeFrontViews != null ? storeFrontViews.getItems() : null;
        if (items == null) {
            k.a();
        }
        if (i2 < items.size()) {
            StoreFrontViews storeFrontViews2 = this.f17322b.get(0);
            List<StoreFrontItem> items2 = storeFrontViews2 != null ? storeFrontViews2.getItems() : null;
            if (items2 == null) {
                k.a();
            }
            StoreFrontItem storeFrontItem = items2.get(i2);
            if (storeFrontItem == null) {
                k.a();
            }
            if (!TextUtils.isEmpty(storeFrontItem.getImageUrl())) {
                StoreFrontViews storeFrontViews3 = this.f17322b.get(0);
                if (storeFrontViews3 != null) {
                    list = storeFrontViews3.getItems();
                }
                if (list == null) {
                    k.a();
                }
                StoreFrontItem storeFrontItem2 = list.get(i2);
                if (storeFrontItem2 == null) {
                    k.a();
                }
                w.a().a(storeFrontItem2.getImageUrl()).a(aVar.f17323a);
            }
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f17321a).inflate(R.layout.item_whats_new, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(cont…whats_new, parent, false)");
        a aVar = new a(inflate);
        aVar.itemView.setOnClickListener(new b(this, aVar));
        return aVar;
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f17324a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f17325b;

        b(g gVar, a aVar) {
            this.f17324a = gVar;
            this.f17325b = aVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0013, code lost:
            r3 = (r3 = r3.getItems()).get(r2.f17325b.getAdapterPosition());
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r3) {
            /*
                r2 = this;
                net.one97.paytm.paymentsBank.a.g r3 = r2.f17324a
                java.util.List<net.one97.paytm.paymentsBank.storefront.model.StoreFrontViews> r3 = r3.f17322b
                r0 = 0
                java.lang.Object r3 = r3.get(r0)
                net.one97.paytm.paymentsBank.storefront.model.StoreFrontViews r3 = (net.one97.paytm.paymentsBank.storefront.model.StoreFrontViews) r3
                if (r3 == 0) goto L_0x0026
                java.util.List r3 = r3.getItems()
                if (r3 == 0) goto L_0x0026
                net.one97.paytm.paymentsBank.a.g$a r0 = r2.f17325b
                int r0 = r0.getAdapterPosition()
                java.lang.Object r3 = r3.get(r0)
                net.one97.paytm.paymentsBank.storefront.model.StoreFrontItem r3 = (net.one97.paytm.paymentsBank.storefront.model.StoreFrontItem) r3
                if (r3 == 0) goto L_0x0026
                java.lang.String r3 = r3.getUrl()
                goto L_0x0027
            L_0x0026:
                r3 = 0
            L_0x0027:
                net.one97.paytm.paymentsBank.h.a r0 = net.one97.paytm.paymentsBank.utils.o.a()
                net.one97.paytm.paymentsBank.a.g r1 = r2.f17324a
                android.content.Context r1 = r1.f17321a
                r0.checkDeepLink(r1, r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.a.g.b.onClick(android.view.View):void");
        }
    }

    public final int getItemCount() {
        StoreFrontViews storeFrontViews = this.f17322b.get(0);
        List<StoreFrontItem> items = storeFrontViews != null ? storeFrontViews.getItems() : null;
        if (items == null) {
            k.a();
        }
        return items.size();
    }

    public static final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final ImageView f17323a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            k.c(view, "view");
            this.f17323a = (ImageView) view.findViewById(R.id.img_item_whats_new);
        }
    }
}
