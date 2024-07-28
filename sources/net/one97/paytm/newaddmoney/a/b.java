package net.one97.paytm.newaddmoney.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.utils.n;

public final class b extends RecyclerView.a<C1043b> {

    /* renamed from: a  reason: collision with root package name */
    final List<net.one97.paytm.newaddmoney.b.a> f55809a;

    /* renamed from: b  reason: collision with root package name */
    final a f55810b;

    public interface a {
        void a(int i2);
    }

    public b(List<net.one97.paytm.newaddmoney.b.a> list, a aVar) {
        k.c(list, "list");
        k.c(aVar, "listener");
        this.f55809a = list;
        this.f55810b = aVar;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        int i3;
        C1043b bVar = (C1043b) vVar;
        k.c(bVar, "holder");
        net.one97.paytm.newaddmoney.b.a aVar = bVar.f55814d.f55809a.get(i2);
        bVar.f55812b.setText(aVar.f55819b);
        TextView textView = bVar.f55813c;
        View view = bVar.itemView;
        k.a((Object) view, "itemView");
        textView.setText(view.getContext().getString(R.string.am_balance, new Object[]{com.paytm.utility.b.S(String.valueOf(aVar.f55820c))}));
        ImageView imageView = bVar.f55811a;
        int i4 = aVar.f55821d;
        if (i4 == n.PAYTM_WALLET.getValue()) {
            i3 = R.drawable.ic_wallet_bal_copy;
        } else if (i4 == n.FOOD_WALLET.getValue()) {
            i3 = R.drawable.am_ic_food_wallet;
        } else if (i4 == n.GIFT_CARDS.getValue()) {
            i3 = R.drawable.am_ic_gift_wallet;
        } else if (i4 == n.TOLL.getValue()) {
            i3 = R.drawable.am_ic_toll_wallet;
        } else if (i4 == n.GIFT_VOUCHER.getValue()) {
            i3 = R.drawable.uam_ic_gift_voucher;
        } else if (i4 == n.ALLOWALANCE_WALLET.getValue()) {
            i3 = R.drawable.am_allowance_wallet;
        } else if (i4 == n.REMITTANCE.getValue()) {
            i3 = R.drawable.am_remittence_wallet;
        } else if (i4 == n.FUEL_WALLET.getValue()) {
            i3 = R.drawable.am_fuel_subwallet;
        } else if (i4 == n.COMMUNICATION_WALLET.getValue()) {
            i3 = R.drawable.am_communication_wallet;
        } else {
            i3 = R.drawable.am_default_wallet;
        }
        imageView.setImageResource(i3);
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_wallet_balances, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(pare…_balances, parent, false)");
        return new C1043b(this, inflate);
    }

    /* renamed from: net.one97.paytm.newaddmoney.a.b$b  reason: collision with other inner class name */
    public final class C1043b extends RecyclerView.v implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        ImageView f55811a;

        /* renamed from: b  reason: collision with root package name */
        TextView f55812b;

        /* renamed from: c  reason: collision with root package name */
        TextView f55813c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ b f55814d;

        /* renamed from: e  reason: collision with root package name */
        private final View f55815e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1043b(b bVar, View view) {
            super(view);
            k.c(view, "view");
            this.f55814d = bVar;
            this.f55815e = view;
            View findViewById = this.f55815e.findViewById(R.id.icon_subwallet);
            k.a((Object) findViewById, "view.findViewById(R.id.icon_subwallet)");
            this.f55811a = (ImageView) findViewById;
            View findViewById2 = this.f55815e.findViewById(R.id.tv_subwallet);
            k.a((Object) findViewById2, "view.findViewById(R.id.tv_subwallet)");
            this.f55812b = (TextView) findViewById2;
            View findViewById3 = this.f55815e.findViewById(R.id.tv_subwallet_balance);
            k.a((Object) findViewById3, "view.findViewById(R.id.tv_subwallet_balance)");
            this.f55813c = (TextView) findViewById3;
            this.f55815e.setOnClickListener(this);
        }

        public final void onClick(View view) {
            a aVar = this.f55814d.f55810b;
            if (aVar != null) {
                aVar.a(getAdapterPosition());
            }
        }
    }

    public final int getItemCount() {
        return this.f55809a.size();
    }
}
