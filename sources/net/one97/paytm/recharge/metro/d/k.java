package net.one97.paytm.recharge.metro.d;

import android.view.View;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail;
import net.one97.paytm.recharge.metro.d.p;
import net.one97.paytm.recharge.metro.f.c;

public final class k extends l {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(View view, p.b bVar) {
        super(view, bVar);
        kotlin.g.b.k.c(view, "itemView");
    }

    public final void a(CJROrderSummaryProductDetail cJROrderSummaryProductDetail, List<? extends CJRActiveMetroTicketModel> list) {
        List list2;
        kotlin.g.b.k.c(list, "ticketAndPass");
        c.a aVar = c.f63576a;
        List h2 = c.f63584i;
        if (h2 != null) {
            Collection arrayList = new ArrayList();
            for (Object next : h2) {
                if (Long.valueOf(((CJRActiveMetroTicketModel) list.get(0)).getProductId()).equals(Long.valueOf(((CJRActiveMetroTicketModel) next).getProductId()))) {
                    arrayList.add(next);
                }
            }
            list2 = (List) arrayList;
        } else {
            list2 = null;
        }
        if (list2 != null && (!list2.isEmpty()) && list2.size() >= 2) {
            super.a(cJROrderSummaryProductDetail, list2);
            this.f63523c.setOnClickListener(new a(this));
            this.itemView.setOnClickListener(new b(this));
        }
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k f63506a;

        a(k kVar) {
            this.f63506a = kVar;
        }

        public final void onClick(View view) {
            p.b bVar = this.f63506a.f63526f;
            if (bVar != null) {
                View view2 = this.f63506a.itemView;
                kotlin.g.b.k.a((Object) view2, "itemView");
                bVar.a(view2, this.f63506a.getAdapterPosition());
            }
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k f63507a;

        b(k kVar) {
            this.f63507a = kVar;
        }

        public final void onClick(View view) {
            p.b bVar = this.f63507a.f63526f;
            if (bVar != null) {
                View view2 = this.f63507a.itemView;
                kotlin.g.b.k.a((Object) view2, "itemView");
                bVar.a(view2, this.f63507a.getAdapterPosition());
            }
        }
    }
}
