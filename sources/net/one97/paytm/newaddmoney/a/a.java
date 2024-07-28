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

public final class a extends RecyclerView.a<C1042a> {

    /* renamed from: a  reason: collision with root package name */
    final List<net.one97.paytm.newaddmoney.b.b> f55802a;

    /* renamed from: b  reason: collision with root package name */
    final b f55803b;

    public interface b {
        void a(net.one97.paytm.newaddmoney.b.b bVar);
    }

    public a(List<net.one97.paytm.newaddmoney.b.b> list, b bVar) {
        k.c(list, "list");
        k.c(bVar, "listener");
        this.f55802a = list;
        this.f55803b = bVar;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        C1042a aVar = (C1042a) vVar;
        k.c(aVar, "holder");
        net.one97.paytm.newaddmoney.b.b bVar = aVar.f55807d.f55802a.get(i2);
        aVar.f55804a.setImageResource(bVar.f55828b);
        aVar.f55805b.setText(bVar.f55827a);
        if (i2 == aVar.f55807d.f55802a.size() - 1) {
            aVar.f55806c.setVisibility(4);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.am_item_wallets, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(pare…m_wallets, parent, false)");
        return new C1042a(this, inflate);
    }

    /* renamed from: net.one97.paytm.newaddmoney.a.a$a  reason: collision with other inner class name */
    public final class C1042a extends RecyclerView.v implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        ImageView f55804a;

        /* renamed from: b  reason: collision with root package name */
        TextView f55805b;

        /* renamed from: c  reason: collision with root package name */
        View f55806c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ a f55807d;

        /* renamed from: e  reason: collision with root package name */
        private final View f55808e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1042a(a aVar, View view) {
            super(view);
            k.c(view, "view");
            this.f55807d = aVar;
            this.f55808e = view;
            View findViewById = this.f55808e.findViewById(R.id.iv_action);
            k.a((Object) findViewById, "view.findViewById(R.id.iv_action)");
            this.f55804a = (ImageView) findViewById;
            View findViewById2 = this.f55808e.findViewById(R.id.tv_title);
            k.a((Object) findViewById2, "view.findViewById(R.id.tv_title)");
            this.f55805b = (TextView) findViewById2;
            View findViewById3 = this.f55808e.findViewById(R.id.border);
            k.a((Object) findViewById3, "view.findViewById(R.id.border)");
            this.f55806c = findViewById3;
            this.f55808e.setOnClickListener(this);
        }

        public final void onClick(View view) {
            b bVar = this.f55807d.f55803b;
            if (bVar != null) {
                bVar.a(this.f55807d.f55802a.get(getAdapterPosition()));
            }
        }
    }

    public final int getItemCount() {
        return this.f55802a.size();
    }
}
