package net.one97.paytm.vipcashback.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.view.fragment.FilterPriceSliderFragment;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.vipcashback.TransactionsItem;
import net.one97.paytm.vipcashback.R;
import net.one97.paytm.vipcashback.d.a;
import net.one97.paytm.vipcashback.f.d;

public final class f extends b {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<TransactionsItem> f20634a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f20635b;

    /* access modifiers changed from: protected */
    public final int a(int i2) {
        return 0;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(Context context, RecyclerView recyclerView, ArrayList<TransactionsItem> arrayList) {
        super(recyclerView);
        k.c(context, "context");
        k.c(recyclerView, "recyclerView");
        k.c(arrayList, "mArrayList");
        this.f20635b = context;
        this.f20634a = arrayList;
    }

    public final RecyclerView.v a(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "viewGroup");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.merchant_transaction_item, viewGroup, false);
        k.a((Object) inflate, "view");
        return new a(this, inflate);
    }

    public final void a(RecyclerView.v vVar, int i2) {
        k.c(vVar, "holder");
        a aVar = (a) vVar;
        TransactionsItem transactionsItem = this.f20634a.get(i2);
        k.a((Object) transactionsItem, "mArrayList[position]");
        TransactionsItem transactionsItem2 = transactionsItem;
        TextView textView = aVar.f20636a;
        textView.setText(FilterPriceSliderFragment.RUPEE_SYMBOL + transactionsItem2.getTransactionAmount());
        TextView textView2 = aVar.f20637b;
        d.a aVar2 = d.f20859a;
        textView2.setText(p.a(p.a(d.a.b(transactionsItem2.getTransactionTime(), "dd MMM yy, hh:mm a"), "am", "AM", false), "pm", "PM", false));
        aVar.f20638c.setText(transactionsItem2.getUserMobileNo());
        a.m.C0394a aVar3 = a.m.f20832a;
        if (p.a(a.m.f20834c, transactionsItem2.getStatus(), true)) {
            aVar.f20639d.setText(transactionsItem2.getStatus());
            aVar.f20639d.setVisibility(0);
            return;
        }
        aVar.f20639d.setVisibility(8);
    }

    public final int a() {
        return this.f20634a.size();
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f20636a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f20637b;

        /* renamed from: c  reason: collision with root package name */
        final TextView f20638c;

        /* renamed from: d  reason: collision with root package name */
        final TextView f20639d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ f f20640e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(f fVar, View view) {
            super(view);
            k.c(view, "view");
            this.f20640e = fVar;
            View findViewById = view.findViewById(R.id.tv_amount);
            if (findViewById != null) {
                this.f20636a = (TextView) findViewById;
                View findViewById2 = view.findViewById(R.id.tv_date);
                if (findViewById2 != null) {
                    this.f20637b = (TextView) findViewById2;
                    View findViewById3 = view.findViewById(R.id.tv_mobile_no);
                    if (findViewById3 != null) {
                        this.f20638c = (TextView) findViewById3;
                        View findViewById4 = view.findViewById(R.id.tv_status);
                        if (findViewById4 != null) {
                            this.f20639d = (TextView) findViewById4;
                            return;
                        }
                        throw new u("null cannot be cast to non-null type android.widget.TextView");
                    }
                    throw new u("null cannot be cast to non-null type android.widget.TextView");
                }
                throw new u("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
    }
}
