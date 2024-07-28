package net.one97.paytm.upi.registration.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.List;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.util.CustomDialog;
import net.one97.paytm.upi.util.UpiAppUtils;

public final class a extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    List<UpiBaseDataModel> f68787a;

    /* renamed from: b  reason: collision with root package name */
    c f68788b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f68789c;

    public interface c {
        void b(AccountProviderBody.AccountProvider accountProvider);
    }

    public a(Context context, c cVar) {
        this.f68789c = LayoutInflater.from(context);
        this.f68788b = cVar;
    }

    public final RecyclerView.v onCreateViewHolder(final ViewGroup viewGroup, int i2) {
        View inflate = this.f68789c.inflate(R.layout.upi_item_bank_provider_list, viewGroup, false);
        final b bVar = new b(inflate);
        inflate.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                int adapterPosition = bVar.getAdapterPosition();
                if (adapterPosition != -1 && a.this.f68788b != null) {
                    if (UpiAppUtils.isNetworkAvailable(viewGroup.getContext())) {
                        a.this.f68788b.b((AccountProviderBody.AccountProvider) a.this.f68787a.get(adapterPosition));
                    } else {
                        CustomDialog.showAlert(viewGroup.getContext(), viewGroup.getContext().getResources().getString(R.string.no_connection), viewGroup.getContext().getResources().getString(R.string.no_internet));
                    }
                }
            }
        });
        return bVar;
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        if (vVar instanceof b) {
            b bVar = (b) vVar;
            AccountProviderBody.AccountProvider accountProvider = (AccountProviderBody.AccountProvider) this.f68787a.get(vVar.getAdapterPosition());
            bVar.f68796a.setText(accountProvider.getAccountProvider());
            if (bVar.f68797b == null) {
                return;
            }
            if (!TextUtils.isEmpty(accountProvider.getBankLogoUrl())) {
                w.a().a(accountProvider.getBankLogoUrl()).a(R.drawable.ic_paytm_payments_bank).b(R.drawable.ic_paytm_payments_bank).a(bVar.f68797b, (e) null);
            } else {
                bVar.f68797b.setImageResource(R.drawable.ic_paytm_payments_bank);
            }
        }
    }

    public final int getItemCount() {
        List<UpiBaseDataModel> list = this.f68787a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public static class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f68796a;

        /* renamed from: b  reason: collision with root package name */
        ImageView f68797b;

        /* renamed from: c  reason: collision with root package name */
        private Context f68798c;

        public b(View view) {
            super(view);
            this.f68798c = view.getContext();
            this.f68796a = (TextView) view.findViewById(R.id.tv_bank_name);
            this.f68797b = (ImageView) view.findViewById(R.id.iv_bank_icon);
        }
    }

    /* renamed from: net.one97.paytm.upi.registration.view.a$a  reason: collision with other inner class name */
    class C1395a extends h.a {

        /* renamed from: b  reason: collision with root package name */
        private List<UpiBaseDataModel> f68794b;

        /* renamed from: c  reason: collision with root package name */
        private List<UpiBaseDataModel> f68795c;

        public C1395a(List<UpiBaseDataModel> list, List<UpiBaseDataModel> list2) {
            this.f68794b = list;
            this.f68795c = list2;
        }

        public final int getOldListSize() {
            return this.f68794b.size();
        }

        public final int getNewListSize() {
            return this.f68795c.size();
        }

        public final boolean areItemsTheSame(int i2, int i3) {
            return ((AccountProviderBody.AccountProvider) this.f68794b.get(i2)).getIin().equals(((AccountProviderBody.AccountProvider) this.f68795c.get(i3)).getIin());
        }

        public final boolean areContentsTheSame(int i2, int i3) {
            return ((AccountProviderBody.AccountProvider) this.f68794b.get(i2)).getAccountProvider().equals(((AccountProviderBody.AccountProvider) this.f68795c.get(i3)).getAccountProvider());
        }

        public final Object getChangePayload(int i2, int i3) {
            return super.getChangePayload(i2, i3);
        }
    }
}
