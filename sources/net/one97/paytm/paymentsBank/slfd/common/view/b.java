package net.one97.paytm.paymentsBank.slfd.common.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.slfd.common.a.b;

public final class b extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    public final d f19001a;

    /* renamed from: b  reason: collision with root package name */
    private final b.a f19002b;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        this.f19002b.a(aVar, i2);
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        return new a(from != null ? from.inflate(R.layout.intresttable_item, viewGroup, false) : null);
    }

    public b(b.a aVar, d dVar) {
        k.c(aVar, "presenter");
        k.c(dVar, "context");
        this.f19002b = aVar;
        this.f19001a = dVar;
    }

    public final int getItemCount() {
        return this.f19002b.c();
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        public final TextView f19003a;

        /* renamed from: b  reason: collision with root package name */
        public final TextView f19004b;

        /* renamed from: c  reason: collision with root package name */
        public final RelativeLayout f19005c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            if (view == null) {
                k.a();
            }
            TextView textView = (TextView) view.findViewById(R.id.tv_duration);
            if (textView != null) {
                this.f19003a = textView;
                TextView textView2 = (TextView) view.findViewById(R.id.tv_intrest_rate);
                if (textView2 != null) {
                    this.f19004b = textView2;
                    RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rv_wrapper);
                    if (relativeLayout != null) {
                        this.f19005c = relativeLayout;
                        return;
                    }
                    throw new u("null cannot be cast to non-null type android.widget.RelativeLayout");
                }
                throw new u("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
    }
}
