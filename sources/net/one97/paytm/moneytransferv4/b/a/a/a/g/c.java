package net.one97.paytm.moneytransferv4.b.a.a.a.g;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransferv4.b.a.a.a.g.e;

public final class c extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    final d f55303a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<Integer> f55304b;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        net.one97.paytm.moneytransferv4.e.a aVar;
        a aVar2 = (a) vVar;
        k.c(aVar2, "holder");
        e.a aVar3 = e.f55311a;
        if (i2 == 0) {
            aVar = new net.one97.paytm.moneytransferv4.e.a(net.one97.paytm.moneytransferv4.a.SELF_ACCOUNT_TRANSFER, "", R.string.mt_to_self_acc, R.drawable.mt_ic_self_acc);
        } else if (i2 == 1) {
            aVar = new net.one97.paytm.moneytransferv4.e.a(net.one97.paytm.moneytransferv4.a.SCAN_UPI_QR, "", R.string.mt_scan_upi_qr, R.drawable.mt_ic_scan_qr);
        } else if (i2 != 2) {
            aVar = i2 != 3 ? null : new net.one97.paytm.moneytransferv4.e.a(net.one97.paytm.moneytransferv4.a.CHECK_BALANCE, "", R.string.mt_balance_and_history, R.drawable.mt_ic_check_balanace);
        } else {
            aVar = new net.one97.paytm.moneytransferv4.e.a(net.one97.paytm.moneytransferv4.a.TO_BANK_ACC, "", R.string.mt_to_bank_acc, R.drawable.mt_ic_bank_acc);
        }
        if (aVar == null) {
            k.a();
        }
        k.c(aVar, "option");
        TextView textView = aVar2.f55305a;
        View view = aVar2.itemView;
        k.a((Object) view, "itemView");
        textView.setText(view.getContext().getString(aVar.f55402b));
        aVar2.f55306b.setImageResource(aVar.f55403c);
        aVar2.f55307c.setOnClickListener(new a.C1015a(aVar2, aVar));
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mt_v4_payment_options_item, viewGroup, false);
        k.a((Object) inflate, "view");
        return new a(this, inflate);
    }

    public /* synthetic */ c(d dVar) {
        this(dVar, kotlin.a.k.d(0, 1, 2, 3));
    }

    private c(d dVar, ArrayList<Integer> arrayList) {
        k.c(dVar, "onOptionsItemClick");
        k.c(arrayList, "optionsList");
        this.f55303a = dVar;
        this.f55304b = arrayList;
    }

    public final int getItemCount() {
        return this.f55304b.size();
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f55305a;

        /* renamed from: b  reason: collision with root package name */
        final AppCompatImageView f55306b;

        /* renamed from: c  reason: collision with root package name */
        final View f55307c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ c f55308d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(c cVar, View view) {
            super(view);
            k.c(view, "view");
            this.f55308d = cVar;
            this.f55307c = view;
            View findViewById = this.f55307c.findViewById(R.id.optionsItemTV);
            k.a((Object) findViewById, "view.findViewById(R.id.optionsItemTV)");
            this.f55305a = (TextView) findViewById;
            View findViewById2 = this.f55307c.findViewById(R.id.optionsImageView);
            k.a((Object) findViewById2, "view.findViewById(R.id.optionsImageView)");
            this.f55306b = (AppCompatImageView) findViewById2;
        }

        /* renamed from: net.one97.paytm.moneytransferv4.b.a.a.a.g.c$a$a  reason: collision with other inner class name */
        static final class C1015a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f55309a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ net.one97.paytm.moneytransferv4.e.a f55310b;

            C1015a(a aVar, net.one97.paytm.moneytransferv4.e.a aVar2) {
                this.f55309a = aVar;
                this.f55310b = aVar2;
            }

            public final void onClick(View view) {
                this.f55309a.f55308d.f55303a.a(this.f55310b.f55401a);
            }
        }
    }
}
