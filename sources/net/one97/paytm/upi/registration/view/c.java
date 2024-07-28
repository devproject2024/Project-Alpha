package net.one97.paytm.upi.registration.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.w;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.e.ad;

public final class c extends RecyclerView.a<b> {

    /* renamed from: a  reason: collision with root package name */
    List<? extends AccountProviderBody.AccountProvider> f68820a;

    /* renamed from: b  reason: collision with root package name */
    final a f68821b;

    public interface a {
        void a(int i2, AccountProviderBody.AccountProvider accountProvider);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        b bVar = (b) vVar;
        k.c(bVar, "holder");
        if (i2 != -1 && i2 < this.f68820a.size()) {
            AccountProviderBody.AccountProvider accountProvider = (AccountProviderBody.AccountProvider) this.f68820a.get(i2);
            k.c(accountProvider, "bankProvider");
            TextView textView = bVar.f68822a.f66742b;
            k.a((Object) textView, "binding.bankName");
            textView.setText(accountProvider.getAccountProvider());
            if (!TextUtils.isEmpty(accountProvider.getBankLogoUrl())) {
                w.a().a(accountProvider.getBankLogoUrl()).a(R.drawable.ic_paytm_payments_bank).b(R.drawable.ic_paytm_payments_bank).a(bVar.f68822a.f66741a);
            } else {
                bVar.f68822a.f66741a.setImageResource(R.drawable.ic_paytm_payments_bank);
            }
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        ad a2 = ad.a(LayoutInflater.from(viewGroup.getContext()), viewGroup);
        k.a((Object) a2, "UpiAccountProviderGridIt…, parent, false\n        )");
        return new b(this, a2);
    }

    public c(List<? extends AccountProviderBody.AccountProvider> list, a aVar) {
        k.c(list, "list");
        k.c(aVar, "listener");
        this.f68820a = list;
        this.f68821b = aVar;
    }

    public final int getItemCount() {
        return this.f68820a.size();
    }

    public final class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final ad f68822a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f68823b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(c cVar, ad adVar) {
            super(adVar.a());
            k.c(adVar, "binding");
            this.f68823b = cVar;
            this.f68822a = adVar;
            this.f68822a.a().setOnClickListener(new View.OnClickListener(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ b f68824a;

                {
                    this.f68824a = r1;
                }

                public final void onClick(View view) {
                    this.f68824a.f68823b.f68821b.a(this.f68824a.getLayoutPosition(), (AccountProviderBody.AccountProvider) this.f68824a.f68823b.f68820a.get(this.f68824a.getLayoutPosition()));
                }
            });
        }
    }
}
