package net.one97.paytm.recharge.ordersummary.e;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.rxjava3.j.c;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.common.entity.shopping.CJRRefund;
import net.one97.paytm.common.entity.shopping.CJRTransactionDetails;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.model.CJROSActionResponseV2;
import net.one97.paytm.recharge.ordersummary.h.c;

public final class b extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    final net.one97.paytm.recharge.ordersummary.b.a f64258a;

    /* renamed from: b  reason: collision with root package name */
    final CJROrderedCart f64259b;

    /* renamed from: c  reason: collision with root package name */
    private final ImageView f64260c;

    /* renamed from: d  reason: collision with root package name */
    private final TextView f64261d;

    /* renamed from: e  reason: collision with root package name */
    private final RecyclerView f64262e;

    /* renamed from: f  reason: collision with root package name */
    private final LinearLayout f64263f;

    /* renamed from: g  reason: collision with root package name */
    private final TextView f64264g;

    /* renamed from: h  reason: collision with root package name */
    private final CJROSActionResponseV2 f64265h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f64266i;
    private final c<Object[]> j;
    private final net.one97.paytm.recharge.ordersummary.f.b k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(View view, net.one97.paytm.recharge.ordersummary.b.a aVar, CJROrderedCart cJROrderedCart, CJROSActionResponseV2 cJROSActionResponseV2, boolean z, c<Object[]> cVar, net.one97.paytm.recharge.ordersummary.f.b bVar) {
        super(view);
        k.c(view, "itemView");
        k.c(aVar, "viewModel");
        k.c(cJROrderedCart, "orderedItem");
        k.c(cVar, "titleTextObservable");
        k.c(bVar, "actionListener");
        this.f64258a = aVar;
        this.f64259b = cJROrderedCart;
        this.f64265h = cJROSActionResponseV2;
        this.f64266i = z;
        this.j = cVar;
        this.k = bVar;
        this.f64260c = (ImageView) view.findViewById(R.id.status_logo);
        this.f64261d = (TextView) view.findViewById(R.id.title);
        this.f64262e = (RecyclerView) view.findViewById(R.id.lyt_refund_items);
        this.f64263f = (LinearLayout) view.findViewById(R.id.lyt_refund_note);
        this.f64264g = (TextView) view.findViewById(R.id.refund_note);
    }

    public final void a() {
        this.f64260c.setImageResource(R.drawable.ic_os_status_success_type2);
        CJRRefund refund = this.f64259b.getRefund();
        if (refund == null) {
            k.a();
        }
        TextView textView = this.f64261d;
        k.a((Object) textView, "title");
        net.one97.paytm.recharge.ordersummary.b.a aVar = this.f64258a;
        View view = this.itemView;
        k.a((Object) view, "itemView");
        Context context = view.getContext();
        k.a((Object) context, "itemView.context");
        textView.setText(aVar.a(context, refund.isRefundInitiated()));
        RecyclerView recyclerView = this.f64262e;
        k.a((Object) recyclerView, "lytRefundItems");
        View view2 = this.itemView;
        k.a((Object) view2, "itemView");
        recyclerView.setLayoutManager(new LinearLayoutManager(view2.getContext()));
        RecyclerView recyclerView2 = this.f64262e;
        k.a((Object) recyclerView2, "lytRefundItems");
        recyclerView2.setAdapter(new C1264b(this, refund));
        net.one97.paytm.recharge.ordersummary.b.a aVar2 = this.f64258a;
        View view3 = this.itemView;
        k.a((Object) view3, "itemView");
        Context context2 = view3.getContext();
        k.a((Object) context2, "itemView.context");
        String a2 = aVar2.a(context2, refund);
        if (!TextUtils.isEmpty(a2)) {
            View view4 = this.itemView;
            k.a((Object) view4, "itemView");
            String string = view4.getContext().getString(R.string.v8_os_info_note);
            k.a((Object) string, "itemView.context.getStri…R.string.v8_os_info_note)");
            SpannableString spannableString = new SpannableString(string + ' ' + a2);
            View view5 = this.itemView;
            k.a((Object) view5, "itemView");
            spannableString.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(view5.getContext(), R.color.recharge_506d85)), 0, string.length(), 33);
            spannableString.setSpan(new StyleSpan(1), 0, string.length(), 33);
            TextView textView2 = this.f64264g;
            k.a((Object) textView2, "refundNote");
            textView2.setText(spannableString);
        }
        TextView textView3 = this.f64264g;
        k.a((Object) textView3, "refundNote");
        if (textView3.getVisibility() == 8) {
            LinearLayout linearLayout = this.f64263f;
            k.a((Object) linearLayout, "lytRefundNote");
            linearLayout.setVisibility(8);
        }
    }

    /* renamed from: net.one97.paytm.recharge.ordersummary.e.b$b  reason: collision with other inner class name */
    public static final class C1264b extends RecyclerView.a<a> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f64271a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJRRefund f64272b;

        C1264b(b bVar, CJRRefund cJRRefund) {
            this.f64271a = bVar;
            this.f64272b = cJRRefund;
        }

        public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
            a aVar = (a) vVar;
            k.c(aVar, "holder");
            CJRTransactionDetails cJRTransactionDetails = this.f64272b.getTransactionDetails().get(i2);
            k.a((Object) cJRTransactionDetails, "refundDetails.transactionDetails[position]");
            aVar.a(aVar, cJRTransactionDetails, this.f64272b);
        }

        public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
            k.c(viewGroup, "parent");
            View view = this.f64271a.itemView;
            k.a((Object) view, "itemView");
            View inflate = LayoutInflater.from(view.getContext()).inflate(R.layout.content_os_refund_status_list_item, viewGroup, false);
            k.a((Object) inflate, "LayoutInflater.from(item…list_item, parent, false)");
            return new a(inflate, this.f64271a.f64258a);
        }

        public final int getItemCount() {
            c.a aVar = net.one97.paytm.recharge.ordersummary.h.c.f64331a;
            CJRRefund refund = this.f64271a.f64259b.getRefund();
            k.a((Object) refund, "orderedItem.refund");
            c.a.a(refund);
            ArrayList<CJRTransactionDetails> transactionDetails = this.f64272b.getTransactionDetails();
            if (transactionDetails != null) {
                return transactionDetails.size();
            }
            return 0;
        }
    }

    public static final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        private final TextView f64267a;

        /* renamed from: b  reason: collision with root package name */
        private final TextView f64268b;

        /* renamed from: c  reason: collision with root package name */
        private final TextView f64269c;

        /* renamed from: d  reason: collision with root package name */
        private final net.one97.paytm.recharge.ordersummary.b.a f64270d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view, net.one97.paytm.recharge.ordersummary.b.a aVar) {
            super(view);
            k.c(view, "itemView");
            k.c(aVar, "viewModel");
            this.f64270d = aVar;
            this.f64267a = (TextView) view.findViewById(R.id.refund_detail_title);
            this.f64268b = (TextView) view.findViewById(R.id.refun_transaction_no);
            this.f64269c = (TextView) view.findViewById(R.id.refund_timestamp);
        }

        public final void a(a aVar, CJRTransactionDetails cJRTransactionDetails, CJRRefund cJRRefund) {
            k.c(aVar, "holder");
            k.c(cJRTransactionDetails, "transactionDetail");
            k.c(cJRRefund, "refundDetails");
            TextView textView = aVar.f64267a;
            k.a((Object) textView, "holder.title");
            net.one97.paytm.recharge.ordersummary.b.a aVar2 = this.f64270d;
            View view = this.itemView;
            k.a((Object) view, "itemView");
            Context context = view.getContext();
            k.a((Object) context, "itemView.context");
            textView.setText(aVar2.a(context, cJRTransactionDetails));
            net.one97.paytm.recharge.ordersummary.b.a aVar3 = this.f64270d;
            View view2 = this.itemView;
            k.a((Object) view2, "itemView");
            Context context2 = view2.getContext();
            k.a((Object) context2, "itemView.context");
            CharSequence b2 = aVar3.b(context2, cJRTransactionDetails);
            if (!TextUtils.isEmpty(b2)) {
                TextView textView2 = aVar.f64268b;
                textView2.setText(b2);
                textView2.setVisibility(0);
            }
            net.one97.paytm.recharge.ordersummary.b.a aVar4 = this.f64270d;
            View view3 = this.itemView;
            k.a((Object) view3, "itemView");
            Context context3 = view3.getContext();
            k.a((Object) context3, "itemView.context");
            CharSequence a2 = aVar4.a(context3, cJRTransactionDetails, cJRRefund);
            if (!TextUtils.isEmpty(a2)) {
                TextView textView3 = aVar.f64269c;
                textView3.setText(a2);
                textView3.setVisibility(0);
            }
        }
    }
}
