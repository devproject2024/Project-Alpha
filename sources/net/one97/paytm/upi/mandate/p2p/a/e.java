package net.one97.paytm.upi.mandate.p2p.a;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import net.one97.paytm.upi.e.aa;
import net.one97.paytm.upi.f;

public final class e extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    final int f67304a;

    public final int getItemCount() {
        return 15;
    }

    public e(int i2) {
        this.f67304a = i2;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        if (aVar.getAdapterPosition() == aVar.f67306b.f67304a || (aVar.getAdapterPosition() == 14 && aVar.f67306b.f67304a == 15)) {
            aVar.f67305a.f66726b.setCardBackgroundColor(f.c("#00aced"));
            aVar.f67305a.f66725a.setTextColor(-1);
        } else {
            aVar.f67305a.f66725a.setTextColor(f.c("#1d252d"));
            aVar.f67305a.f66726b.setCardBackgroundColor(-1);
        }
        TextView textView = aVar.f67305a.f66725a;
        k.a((Object) textView, "binding.dayNumber");
        textView.setText(String.valueOf(aVar.getAdapterPosition() + 1));
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        aa a2 = aa.a(LayoutInflater.from(viewGroup.getContext()), viewGroup);
        k.a((Object) a2, "PaymentDayMandateItemVie….context), parent, false)");
        return new a(this, a2);
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final aa f67305a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ e f67306b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(e eVar, aa aaVar) {
            super(aaVar.a());
            k.c(aaVar, "binding");
            this.f67306b = eVar;
            this.f67305a = aaVar;
        }
    }
}
