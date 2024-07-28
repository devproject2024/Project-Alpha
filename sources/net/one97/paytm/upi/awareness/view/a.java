package net.one97.paytm.upi.awareness.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.List;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.upi.AccountProviderBody;

public final class a extends RecyclerView.a<C1342a> {

    /* renamed from: a  reason: collision with root package name */
    List<net.one97.paytm.upi.awareness.b.a> f66574a;

    /* renamed from: b  reason: collision with root package name */
    b f66575b;

    public interface b {
        void a(AccountProviderBody.AccountProvider accountProvider);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        final C1342a aVar = (C1342a) vVar;
        aVar.f66579b.setText(this.f66574a.get(i2).f66532b.getAccountProvider());
        if (this.f66574a.get(i2).f66531a > 0) {
            aVar.f66578a.setImageResource(this.f66574a.get(i2).f66531a);
        } else {
            aVar.f66578a.getContext();
            ImageView imageView = aVar.f66578a;
            String bankLogoUrl = this.f66574a.get(i2).f66532b.getBankLogoUrl();
            if (imageView != null) {
                if (!TextUtils.isEmpty(bankLogoUrl)) {
                    w.a().a(bankLogoUrl).a(R.drawable.ic_paytm_payments_bank).b(R.drawable.ic_paytm_payments_bank).a(imageView, (e) null);
                } else {
                    imageView.setImageResource(R.drawable.ic_paytm_payments_bank);
                }
            }
        }
        aVar.itemView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (a.this.f66575b != null) {
                    a.this.f66575b.a(a.this.f66574a.get(aVar.getAdapterPosition()).f66532b);
                }
            }
        });
    }

    public a(List<net.one97.paytm.upi.awareness.b.a> list, b bVar) {
        this.f66574a = list;
        this.f66575b = bVar;
    }

    public final int getItemCount() {
        List<net.one97.paytm.upi.awareness.b.a> list = this.f66574a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    /* renamed from: net.one97.paytm.upi.awareness.view.a$a  reason: collision with other inner class name */
    public static class C1342a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ImageView f66578a;

        /* renamed from: b  reason: collision with root package name */
        TextView f66579b;

        public C1342a(View view) {
            super(view);
            this.f66578a = (ImageView) view.findViewById(R.id.iv_bank);
            this.f66579b = (TextView) view.findViewById(R.id.tv_bank);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new C1342a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_fav_bank, viewGroup, false));
    }
}
