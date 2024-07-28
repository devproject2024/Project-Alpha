package net.one97.paytm.recharge.metro.d;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel;
import net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketQRItemModel;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.metro.d.p;
import net.one97.paytm.recharge.metro.f.c;

public class j extends p {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(View view, p.b bVar) {
        super(view, bVar);
        k.c(view, "itemView");
    }

    public void a(CJROrderSummaryProductDetail cJROrderSummaryProductDetail, List<? extends CJRActiveMetroTicketModel> list) {
        String str;
        CJROrderSummaryProductDetail cJROrderSummaryProductDetail2 = cJROrderSummaryProductDetail;
        List<? extends CJRActiveMetroTicketModel> list2 = list;
        k.c(list2, "ticketAndPass");
        Iterable iterable = list2;
        Collection arrayList = new ArrayList();
        for (Object next : iterable) {
            if (((CJRActiveMetroTicketModel) next).isPass()) {
                arrayList.add(next);
            }
        }
        List list3 = (List) arrayList;
        if (!list3.isEmpty()) {
            CJRActiveMetroTicketModel cJRActiveMetroTicketModel = (CJRActiveMetroTicketModel) list3.get(0);
            Collection arrayList2 = new ArrayList();
            Iterator it2 = iterable.iterator();
            while (true) {
                boolean z = true;
                if (!it2.hasNext()) {
                    break;
                }
                Object next2 = it2.next();
                if (((CJRActiveMetroTicketModel) next2).getQrCodes() == null) {
                    z = false;
                }
                if (z) {
                    arrayList2.add(next2);
                }
            }
            List list4 = (List) arrayList2;
            Collection arrayList3 = new ArrayList();
            for (Object next3 : iterable) {
                if (((CJRActiveMetroTicketModel) next3).getQrCodes() != null) {
                    arrayList3.add(next3);
                }
            }
            List<CJRActiveMetroTicketModel> list5 = (List) arrayList3;
            boolean z2 = false;
            for (CJRActiveMetroTicketModel cJRActiveMetroTicketModel2 : list5) {
                cJRActiveMetroTicketModel2.setBalanceAmount(cJRActiveMetroTicketModel.getBalanceAmount());
                cJRActiveMetroTicketModel2.setProductType(cJRActiveMetroTicketModel.getProductType());
                List<CJRActiveMetroTicketQRItemModel> qrCodes = cJRActiveMetroTicketModel2.getQrCodes();
                if (qrCodes != null) {
                    qrCodes.size();
                }
                List<CJRActiveMetroTicketQRItemModel> qrCodes2 = cJRActiveMetroTicketModel2.getQrCodes();
                if (qrCodes2 != null) {
                    for (CJRActiveMetroTicketQRItemModel cJRActiveMetroTicketQRItemModel : qrCodes2) {
                        if (!z2) {
                            k.a((Object) cJRActiveMetroTicketQRItemModel, "qr");
                            z2 = "ACTIVE".equals(cJRActiveMetroTicketQRItemModel.getStatus());
                        }
                    }
                }
            }
            TextView textView = this.f63521a;
            c.a aVar = net.one97.paytm.recharge.metro.f.c.f63576a;
            View view = this.itemView;
            k.a((Object) view, "itemView");
            Context context = view.getContext();
            k.a((Object) context, "itemView.context");
            textView.setText(c.a.a(context, cJRActiveMetroTicketModel.getProductType(), "", "", cJRActiveMetroTicketModel.getBalanceAmount(), false));
            this.f63522b.setText(cJRActiveMetroTicketModel.getExpiryTime());
            net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
            if (TextUtils.isEmpty(net.one97.paytm.recharge.di.helper.c.ai())) {
                str = "20";
            } else {
                net.one97.paytm.recharge.di.helper.c cVar2 = net.one97.paytm.recharge.di.helper.c.f62654a;
                str = net.one97.paytm.recharge.di.helper.c.ai();
            }
            Double d2 = null;
            if (cJROrderSummaryProductDetail2 != null) {
                TextView textView2 = this.f63524d;
                View view2 = this.itemView;
                k.a((Object) view2, "itemView");
                textView2.setText(view2.getContext().getString(R.string.metro_recharge));
                if (!(!list4.isEmpty()) || !z2) {
                    String balanceAmount = cJRActiveMetroTicketModel != null ? cJRActiveMetroTicketModel.getBalanceAmount() : null;
                    k.a((Object) balanceAmount, "pass?.balanceAmount");
                    int parseInt = Integer.parseInt(balanceAmount);
                    if (str == null) {
                        k.a();
                    }
                    if (parseInt <= Integer.parseInt(str)) {
                        this.f63524d.setEnabled(true);
                        this.f63524d.setTextColor(androidx.core.content.b.c(this.f63524d.getContext(), R.color.color_00b9f5));
                        this.f63524d.setOnClickListener(new a(this, cJROrderSummaryProductDetail2, cJRActiveMetroTicketModel));
                    }
                }
                this.f63524d.setEnabled(false);
                this.f63524d.setTextColor(androidx.core.content.b.c(this.f63524d.getContext(), R.color.gray_color));
                this.f63524d.setOnClickListener(new a(this, cJROrderSummaryProductDetail2, cJRActiveMetroTicketModel));
            } else {
                this.f63524d.setText("");
            }
            if (z2) {
                TextView textView3 = this.f63523c;
                View view3 = this.itemView;
                k.a((Object) view3, "itemView");
                textView3.setText(view3.getContext().getString(R.string.metro_view_tickets));
                this.f63523c.setOnClickListener(new b(this, cJROrderSummaryProductDetail2, list5));
                this.itemView.setOnClickListener(new c(this, cJROrderSummaryProductDetail2, list5));
                return;
            }
            View view4 = this.itemView;
            k.a((Object) view4, "itemView");
            view4.setClickable(false);
            View view5 = this.itemView;
            k.a((Object) view5, "itemView");
            view5.setEnabled(false);
            c.a aVar2 = net.one97.paytm.recharge.metro.f.c.f63576a;
            String expiryDate = cJRActiveMetroTicketModel.getExpiryDate();
            k.a((Object) expiryDate, "pass.expiryDate");
            if (c.a.c(expiryDate)) {
                TextView textView4 = this.f63523c;
                View view6 = this.itemView;
                k.a((Object) view6, "itemView");
                textView4.setText(view6.getContext().getString(R.string.metro_pass_expired_text));
                TextView textView5 = this.f63523c;
                View view7 = this.itemView;
                k.a((Object) view7, "itemView");
                textView5.setTextColor(view7.getContext().getColor(R.color.color_bmtc_ff4b55));
                return;
            }
            String balanceAmount2 = cJRActiveMetroTicketModel.getBalanceAmount();
            k.a((Object) balanceAmount2, "pass.balanceAmount");
            double parseDouble = Double.parseDouble(balanceAmount2);
            if (str != null) {
                d2 = Double.valueOf(Double.parseDouble(str));
            }
            if (d2 == null) {
                k.a();
            }
            if (parseDouble >= d2.doubleValue()) {
                TextView textView6 = this.f63523c;
                View view8 = this.itemView;
                k.a((Object) view8, "itemView");
                textView6.setText(view8.getContext().getString(R.string.metro_generate_tickets));
                this.f63523c.setOnClickListener(new d(this, cJROrderSummaryProductDetail2, cJRActiveMetroTicketModel));
                return;
            }
            this.f63523c.setVisibility(8);
        }
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f63493a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJROrderSummaryProductDetail f63494b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CJRActiveMetroTicketModel f63495c;

        a(j jVar, CJROrderSummaryProductDetail cJROrderSummaryProductDetail, CJRActiveMetroTicketModel cJRActiveMetroTicketModel) {
            this.f63493a = jVar;
            this.f63494b = cJROrderSummaryProductDetail;
            this.f63495c = cJRActiveMetroTicketModel;
        }

        public final void onClick(final View view) {
            k.a((Object) view, "it");
            view.setEnabled(false);
            p.b bVar = this.f63493a.f63526f;
            if (bVar != null) {
                bVar.a(this.f63494b, this.f63495c);
            }
            view.postDelayed(new Runnable() {
                public final void run() {
                    View view = view;
                    k.a((Object) view, "it");
                    view.setEnabled(true);
                }
            }, 500);
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f63497a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJROrderSummaryProductDetail f63498b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List f63499c;

        b(j jVar, CJROrderSummaryProductDetail cJROrderSummaryProductDetail, List list) {
            this.f63497a = jVar;
            this.f63498b = cJROrderSummaryProductDetail;
            this.f63499c = list;
        }

        public final void onClick(View view) {
            p.b bVar = this.f63497a.f63526f;
            if (bVar != null) {
                CJROrderSummaryProductDetail cJROrderSummaryProductDetail = this.f63498b;
                if (cJROrderSummaryProductDetail == null) {
                    k.a();
                }
                bVar.a(cJROrderSummaryProductDetail, this.f63499c, true);
            }
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f63500a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJROrderSummaryProductDetail f63501b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List f63502c;

        c(j jVar, CJROrderSummaryProductDetail cJROrderSummaryProductDetail, List list) {
            this.f63500a = jVar;
            this.f63501b = cJROrderSummaryProductDetail;
            this.f63502c = list;
        }

        public final void onClick(View view) {
            p.b bVar = this.f63500a.f63526f;
            if (bVar != null) {
                CJROrderSummaryProductDetail cJROrderSummaryProductDetail = this.f63501b;
                if (cJROrderSummaryProductDetail == null) {
                    k.a();
                }
                bVar.a(cJROrderSummaryProductDetail, this.f63502c, true);
            }
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f63503a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJROrderSummaryProductDetail f63504b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CJRActiveMetroTicketModel f63505c;

        d(j jVar, CJROrderSummaryProductDetail cJROrderSummaryProductDetail, CJRActiveMetroTicketModel cJRActiveMetroTicketModel) {
            this.f63503a = jVar;
            this.f63504b = cJROrderSummaryProductDetail;
            this.f63505c = cJRActiveMetroTicketModel;
        }

        public final void onClick(View view) {
            p.b bVar = this.f63503a.f63526f;
            if (bVar != null) {
                CJROrderSummaryProductDetail cJROrderSummaryProductDetail = this.f63504b;
                if (cJROrderSummaryProductDetail == null) {
                    k.a();
                }
                bVar.b(cJROrderSummaryProductDetail, this.f63505c);
            }
        }
    }
}
