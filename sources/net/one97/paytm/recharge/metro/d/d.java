package net.one97.paytm.recharge.metro.d;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2;
import net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder;

public abstract class d extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    a f63456a;

    public interface a {
        void a();

        void a(int i2);

        void a(CJRUtilityVariantV2 cJRUtilityVariantV2, List<? extends CJRActiveMetroTicketModel> list);

        void a(CJRUtilityVariantV2 cJRUtilityVariantV2, List<? extends CJRActiveMetroTicketModel> list, boolean z);

        void a(CJRUtilityVariantV2 cJRUtilityVariantV2, List<? extends CJRActiveMetroTicketModel> list, boolean z, boolean z2);

        void a(CJRMetroQRFrequentOrder cJRMetroQRFrequentOrder);
    }

    public abstract void a(CJRUtilityVariantV2 cJRUtilityVariantV2, List<? extends CJRActiveMetroTicketModel> list, Context context);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(View view, a aVar) {
        super(view);
        k.c(view, "itemView");
        this.f63456a = aVar;
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f63457a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f63458b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CJRUtilityVariantV2 f63459c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f63460d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ boolean f63461e;

        b(d dVar, List list, CJRUtilityVariantV2 cJRUtilityVariantV2, boolean z, boolean z2) {
            this.f63457a = dVar;
            this.f63458b = list;
            this.f63459c = cJRUtilityVariantV2;
            this.f63460d = z;
            this.f63461e = z2;
        }

        public final void onClick(View view) {
            k.c(view, "view");
            Collection arrayList = new ArrayList();
            Iterator it2 = this.f63458b.iterator();
            while (true) {
                boolean z = true;
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                if (((CJRActiveMetroTicketModel) next).getQrCodes() == null) {
                    z = false;
                }
                if (z) {
                    arrayList.add(next);
                }
            }
            List list = (List) arrayList;
            if (!list.isEmpty()) {
                view.setEnabled(false);
                a aVar = this.f63457a.f63456a;
                if (aVar != null) {
                    aVar.a(this.f63459c, list, this.f63460d, this.f63461e);
                }
                view.postDelayed(new a(view), 500);
            }
        }

        static final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ View f63462a;

            a(View view) {
                this.f63462a = view;
            }

            public final void run() {
                this.f63462a.setEnabled(true);
            }
        }
    }

    public final View.OnClickListener a(CJRUtilityVariantV2 cJRUtilityVariantV2, List<? extends CJRActiveMetroTicketModel> list, boolean z, boolean z2) {
        k.c(cJRUtilityVariantV2, "variant");
        k.c(list, "ticketAndPass");
        return new b(this, list, cJRUtilityVariantV2, z, z2);
    }
}
