package net.one97.paytm.upi.mandate.p2p.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.a.b;
import kotlin.g.b.k;
import kotlin.x;
import net.one97.paytm.upi.e.aa;
import net.one97.paytm.upi.f;

public final class a extends RecyclerView.a<C1365a> {

    /* renamed from: a  reason: collision with root package name */
    int f67281a;

    /* renamed from: b  reason: collision with root package name */
    final b<Integer, x> f67282b;

    public final int getItemCount() {
        return 16;
    }

    public a(int i2, b<? super Integer, x> bVar) {
        k.c(bVar, "dayClickListener");
        this.f67281a = i2;
        this.f67282b = bVar;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        C1365a aVar = (C1365a) vVar;
        k.c(aVar, "holder");
        if (aVar.getAdapterPosition() == aVar.f67284b.f67281a) {
            aVar.f67283a.f66726b.setCardBackgroundColor(f.c("#00aced"));
            aVar.f67283a.f66725a.setTextColor(-1);
        } else {
            aVar.f67283a.f66725a.setTextColor(f.c("#1d252d"));
            aVar.f67283a.f66726b.setCardBackgroundColor(-1);
        }
        TextView textView = aVar.f67283a.f66725a;
        k.a((Object) textView, "binding.dayNumber");
        textView.setText(String.valueOf(aVar.getAdapterPosition() + 1));
        aVar.f67283a.a().setOnClickListener(new C1365a.C1366a(aVar));
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        aa a2 = aa.a(LayoutInflater.from(viewGroup.getContext()), viewGroup);
        k.a((Object) a2, "PaymentDayMandateItemVie….context), parent, false)");
        return new C1365a(this, a2);
    }

    /* renamed from: net.one97.paytm.upi.mandate.p2p.a.a$a  reason: collision with other inner class name */
    public final class C1365a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final aa f67283a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f67284b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1365a(a aVar, aa aaVar) {
            super(aaVar.a());
            k.c(aaVar, "binding");
            this.f67284b = aVar;
            this.f67283a = aaVar;
        }

        /* renamed from: net.one97.paytm.upi.mandate.p2p.a.a$a$a  reason: collision with other inner class name */
        static final class C1366a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C1365a f67285a;

            C1366a(C1365a aVar) {
                this.f67285a = aVar;
            }

            public final void onClick(View view) {
                if (this.f67285a.getAdapterPosition() != this.f67285a.f67284b.f67281a) {
                    int i2 = this.f67285a.f67284b.f67281a;
                    this.f67285a.f67284b.f67281a = this.f67285a.getAdapterPosition();
                    this.f67285a.f67284b.notifyItemChanged(i2);
                    this.f67285a.f67284b.notifyItemChanged(this.f67285a.f67284b.f67281a);
                    this.f67285a.f67284b.f67282b.invoke(Integer.valueOf(this.f67285a.f67284b.f67281a));
                }
            }
        }
    }
}
