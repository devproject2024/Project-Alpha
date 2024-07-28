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

public final class d extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    int f67299a;

    /* renamed from: b  reason: collision with root package name */
    final b<Integer, x> f67300b;

    public final int getItemCount() {
        return 31;
    }

    public d(int i2, b<? super Integer, x> bVar) {
        k.c(bVar, "dayClickListener");
        this.f67299a = i2;
        this.f67300b = bVar;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        if (aVar.getAdapterPosition() == aVar.f67302b.f67299a) {
            aVar.f67301a.f66726b.setCardBackgroundColor(f.c("#00aced"));
            aVar.f67301a.f66725a.setTextColor(-1);
        } else {
            aVar.f67301a.f66725a.setTextColor(f.c("#1d252d"));
            aVar.f67301a.f66726b.setCardBackgroundColor(-1);
        }
        TextView textView = aVar.f67301a.f66725a;
        k.a((Object) textView, "binding.dayNumber");
        textView.setText(String.valueOf(aVar.getAdapterPosition() + 1));
        aVar.f67301a.a().setOnClickListener(new a.C1369a(aVar));
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        aa a2 = aa.a(LayoutInflater.from(viewGroup.getContext()), viewGroup);
        k.a((Object) a2, "PaymentDayMandateItemVie….context), parent, false)");
        return new a(this, a2);
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final aa f67301a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f67302b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(d dVar, aa aaVar) {
            super(aaVar.a());
            k.c(aaVar, "binding");
            this.f67302b = dVar;
            this.f67301a = aaVar;
        }

        /* renamed from: net.one97.paytm.upi.mandate.p2p.a.d$a$a  reason: collision with other inner class name */
        static final class C1369a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f67303a;

            C1369a(a aVar) {
                this.f67303a = aVar;
            }

            public final void onClick(View view) {
                if (this.f67303a.getAdapterPosition() != this.f67303a.f67302b.f67299a) {
                    int i2 = this.f67303a.f67302b.f67299a;
                    this.f67303a.f67302b.f67299a = this.f67303a.getAdapterPosition();
                    this.f67303a.f67302b.notifyItemChanged(i2);
                    this.f67303a.f67302b.notifyItemChanged(this.f67303a.f67302b.f67299a);
                    this.f67303a.f67302b.f67300b.invoke(Integer.valueOf(this.f67303a.f67302b.f67299a));
                }
            }
        }
    }
}
