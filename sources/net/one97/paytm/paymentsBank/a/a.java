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
import kotlin.g.b.x;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.storefront.model.StoreFrontItem;
import net.one97.paytm.paymentsBank.storefront.model.StoreFrontViews;

public final class a extends RecyclerView.a<C0260a> {

    /* renamed from: a  reason: collision with root package name */
    final Context f17281a;

    /* renamed from: b  reason: collision with root package name */
    final List<StoreFrontViews> f17282b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f17283c;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        C0260a aVar = (C0260a) vVar;
        k.c(aVar, "holder");
        StoreFrontViews storeFrontViews = this.f17282b.get(0);
        List<StoreFrontItem> list = null;
        List<StoreFrontItem> items = storeFrontViews != null ? storeFrontViews.getItems() : null;
        if (items == null) {
            k.a();
        }
        if (i2 < items.size()) {
            StoreFrontViews storeFrontViews2 = this.f17282b.get(0);
            List<StoreFrontItem> items2 = storeFrontViews2 != null ? storeFrontViews2.getItems() : null;
            if (items2 == null) {
                k.a();
            }
            StoreFrontItem storeFrontItem = items2.get(i2);
            if (storeFrontItem == null) {
                k.a();
            }
            if (!TextUtils.isEmpty(storeFrontItem.getImageUrl())) {
                StoreFrontViews storeFrontViews3 = this.f17282b.get(0);
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
                w.a().a(storeFrontItem2.getImageUrl()).a(aVar.f17284a);
            }
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        x.e eVar = new x.e();
        eVar.element = null;
        View inflate = LayoutInflater.from(this.f17281a).inflate(R.layout.item_bank_offers, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(cont…  false\n                )");
        eVar.element = new C0260a(inflate, this.f17283c);
        ((C0260a) eVar.element).itemView.setOnClickListener(new b(this, eVar));
        return (C0260a) eVar.element;
    }

    public a(Context context, List<StoreFrontViews> list, boolean z) {
        k.c(context, "context");
        k.c(list, "mOfferList");
        this.f17281a = context;
        this.f17282b = list;
        this.f17283c = z;
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f17285a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f17286b;

        b(a aVar, x.e eVar) {
            this.f17285a = aVar;
            this.f17286b = eVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0013, code lost:
            r3 = (r3 = r3.getItems()).get(((net.one97.paytm.paymentsBank.a.a.C0260a) r2.f17286b.element).getAdapterPosition());
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r3) {
            /*
                r2 = this;
                net.one97.paytm.paymentsBank.a.a r3 = r2.f17285a
                java.util.List<net.one97.paytm.paymentsBank.storefront.model.StoreFrontViews> r3 = r3.f17282b
                r0 = 0
                java.lang.Object r3 = r3.get(r0)
                net.one97.paytm.paymentsBank.storefront.model.StoreFrontViews r3 = (net.one97.paytm.paymentsBank.storefront.model.StoreFrontViews) r3
                if (r3 == 0) goto L_0x002a
                java.util.List r3 = r3.getItems()
                if (r3 == 0) goto L_0x002a
                kotlin.g.b.x$e r0 = r2.f17286b
                T r0 = r0.element
                net.one97.paytm.paymentsBank.a.a$a r0 = (net.one97.paytm.paymentsBank.a.a.C0260a) r0
                int r0 = r0.getAdapterPosition()
                java.lang.Object r3 = r3.get(r0)
                net.one97.paytm.paymentsBank.storefront.model.StoreFrontItem r3 = (net.one97.paytm.paymentsBank.storefront.model.StoreFrontItem) r3
                if (r3 == 0) goto L_0x002a
                java.lang.String r3 = r3.getUrl()
                goto L_0x002b
            L_0x002a:
                r3 = 0
            L_0x002b:
                net.one97.paytm.paymentsBank.h.a r0 = net.one97.paytm.paymentsBank.utils.o.a()
                net.one97.paytm.paymentsBank.a.a r1 = r2.f17285a
                android.content.Context r1 = r1.f17281a
                r0.checkDeepLink(r1, r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.a.a.b.onClick(android.view.View):void");
        }
    }

    public final int getItemCount() {
        StoreFrontViews storeFrontViews = this.f17282b.get(0);
        List<StoreFrontItem> items = storeFrontViews != null ? storeFrontViews.getItems() : null;
        if (items == null) {
            k.a();
        }
        return items.size();
    }

    /* renamed from: net.one97.paytm.paymentsBank.a.a$a  reason: collision with other inner class name */
    public static final class C0260a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ImageView f17284a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0260a(View view, boolean z) {
            super(view);
            k.c(view, "view");
            if (z) {
                ImageView imageView = (ImageView) view.findViewById(R.id.img_item_bank_offers);
                k.a((Object) imageView, "view.img_item_bank_offers");
                this.f17284a = imageView;
                return;
            }
            ImageView imageView2 = (ImageView) view.findViewById(R.id.img_item_whats_new);
            k.a((Object) imageView2, "view.img_item_whats_new");
            this.f17284a = imageView2;
        }
    }
}
