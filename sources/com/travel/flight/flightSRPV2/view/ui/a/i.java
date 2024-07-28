package com.travel.flight.flightSRPV2.view.ui.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.flight.R;
import com.travel.flight.b.ca;
import com.travel.flight.pojo.Item;
import com.travel.flight.pojo.PaymentDetail;
import com.travel.flight.utils.m;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;

public final class i extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    int f24197a;

    /* renamed from: b  reason: collision with root package name */
    final List<PaymentDetail> f24198b;

    public i(List<PaymentDetail> list) {
        k.c(list, "paymentDetails");
        this.f24198b = list;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        PaymentDetail paymentDetail = aVar.f24200b.f24198b.get(i2);
        aVar.f24199a.a(aVar.f24200b.f24198b.get(i2));
        aVar.f24199a.f23780a.setOnClickListener(new a.C0458a(aVar, paymentDetail));
        aVar.a(paymentDetail);
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        ca a2 = ca.a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_review_payment_detail, viewGroup, false));
        k.a((Object) a2, "ListItemReviewPaymentDet…t_detail, parent, false))");
        return new a(this, a2);
    }

    public final int getItemCount() {
        return this.f24198b.size();
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final ca f24199a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ i f24200b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(i iVar, ca caVar) {
            super(caVar.getRoot());
            k.c(caVar, "listItemReviewPaymentDetailBinding");
            this.f24200b = iVar;
            this.f24199a = caVar;
        }

        /* renamed from: com.travel.flight.flightSRPV2.view.ui.a.i$a$a  reason: collision with other inner class name */
        static final class C0458a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f24201a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ PaymentDetail f24202b;

            C0458a(a aVar, PaymentDetail paymentDetail) {
                this.f24201a = aVar;
                this.f24202b = paymentDetail;
            }

            public final void onClick(View view) {
                this.f24201a.a(this.f24202b);
            }
        }

        /* access modifiers changed from: package-private */
        public final void a(PaymentDetail paymentDetail) {
            paymentDetail.updateItems();
            if (paymentDetail.haveValidHeader()) {
                if (paymentDetail.getItemsExpanded()) {
                    RecyclerView recyclerView = this.f24199a.f23781b;
                    k.a((Object) recyclerView, "listItemReviewPaymentDet…Binding.itemsRecyclerView");
                    recyclerView.setAdapter((RecyclerView.a) null);
                } else if (this.f24200b.f24197a != 0) {
                    ArrayList arrayList = new ArrayList(0);
                    List<Item> items = paymentDetail.getItems();
                    if (items == null) {
                        k.a();
                    }
                    arrayList.addAll(items);
                    m.a(this.f24199a.f23781b, (List<Item>) arrayList);
                }
                this.f24200b.f24197a = 1;
                paymentDetail.setItemsExpanded(!paymentDetail.getItemsExpanded());
                return;
            }
            ArrayList arrayList2 = new ArrayList(0);
            List<Item> items2 = paymentDetail.getItems();
            if (items2 == null) {
                k.a();
            }
            arrayList2.addAll(items2);
            m.a(this.f24199a.f23781b, (List<Item>) arrayList2);
        }
    }
}
