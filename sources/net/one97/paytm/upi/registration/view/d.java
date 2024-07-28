package net.one97.paytm.upi.registration.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.w;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.e.ad;

public final class d extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    List<? extends AccountProviderBody.AccountProvider> f68825a;

    /* renamed from: b  reason: collision with root package name */
    final b f68826b;

    public interface b {
        void a();

        void a(AccountProviderBody.AccountProvider accountProvider);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        if (i2 != -1 && i2 < this.f68825a.size()) {
            AccountProviderBody.AccountProvider accountProvider = (AccountProviderBody.AccountProvider) this.f68825a.get(i2);
            k.c(accountProvider, "bankProvider");
            String accountProvider2 = accountProvider.getAccountProvider();
            ImageView imageView = aVar.f68827a.f66741a;
            k.a((Object) imageView, "binding.bankImage");
            if (accountProvider2.equals(imageView.getContext().getString(R.string.upi_others))) {
                aVar.f68827a.f66741a.setImageResource(R.drawable.upi_other_bank);
                aVar.f68827a.f66741a.setPadding(24, 0, 24, 0);
            } else if (!TextUtils.isEmpty(accountProvider.getBankLogoUrl())) {
                w.a().a(accountProvider.getBankLogoUrl()).a(R.drawable.ic_paytm_payments_bank).b(R.drawable.ic_paytm_payments_bank).a(aVar.f68827a.f66741a);
            } else {
                aVar.f68827a.f66741a.setImageResource(R.drawable.ic_paytm_payments_bank);
            }
            TextView textView = aVar.f68827a.f66742b;
            k.a((Object) textView, "binding.bankName");
            textView.setText(accountProvider.getAccountProvider());
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        ad a2 = ad.a(LayoutInflater.from(viewGroup.getContext()), viewGroup);
        k.a((Object) a2, "UpiAccountProviderGridIt…, parent, false\n        )");
        return new a(this, a2);
    }

    public d(List<? extends AccountProviderBody.AccountProvider> list, b bVar) {
        k.c(list, "list");
        k.c(bVar, "listener");
        this.f68825a = list;
        this.f68826b = bVar;
    }

    public final int getItemCount() {
        return this.f68825a.size();
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final ad f68827a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f68828b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(d dVar, ad adVar) {
            super(adVar.a());
            k.c(adVar, "binding");
            this.f68828b = dVar;
            this.f68827a = adVar;
            this.f68827a.a().setOnClickListener(new View.OnClickListener(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ a f68829a;

                {
                    this.f68829a = r1;
                }

                public final void onClick(View view) {
                    AccountProviderBody.AccountProvider accountProvider = (AccountProviderBody.AccountProvider) this.f68829a.f68828b.f68825a.get(this.f68829a.getLayoutPosition());
                    String accountProvider2 = accountProvider.getAccountProvider();
                    ImageView imageView = this.f68829a.f68827a.f66741a;
                    k.a((Object) imageView, "binding.bankImage");
                    if (accountProvider2.equals(imageView.getContext().getString(R.string.upi_others))) {
                        this.f68829a.f68828b.f68826b.a();
                        return;
                    }
                    b bVar = this.f68829a.f68828b.f68826b;
                    this.f68829a.getLayoutPosition();
                    bVar.a(accountProvider);
                }
            });
        }
    }
}
