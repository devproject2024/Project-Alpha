package net.one97.paytm.recharge.metro.d;

import android.view.View;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail;
import net.one97.paytm.recharge.metro.d.p;
import net.one97.paytm.recharge.metro.f.c;

public final class i extends j {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(View view, p.b bVar) {
        super(view, bVar);
        k.c(view, "itemView");
    }

    public final void a(CJROrderSummaryProductDetail cJROrderSummaryProductDetail, List<? extends CJRActiveMetroTicketModel> list) {
        List list2;
        k.c(list, "ticketAndPass");
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
        final /* synthetic */ i f63491a;

        a(i iVar) {
            this.f63491a = iVar;
        }

        public final void onClick(View view) {
            p.b bVar = this.f63491a.f63526f;
            if (bVar != null) {
                View view2 = this.f63491a.itemView;
                k.a((Object) view2, "itemView");
                bVar.a(view2, this.f63491a.getAdapterPosition());
            }
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f63492a;

        b(i iVar) {
            this.f63492a = iVar;
        }

        public final void onClick(View view) {
            p.b bVar = this.f63492a.f63526f;
            if (bVar != null) {
                View view2 = this.f63492a.itemView;
                k.a((Object) view2, "itemView");
                bVar.a(view2, this.f63492a.getAdapterPosition());
            }
        }
    }
}
