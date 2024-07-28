package net.one97.paytm.moneytransferv4.b.a.a.a.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransferv4.b.a.a.d;
import net.one97.paytm.moneytransferv4.b.a.a.e;
import net.one97.paytm.moneytransferv4.b.a.a.f;
import net.one97.paytm.moneytransferv4.b.a.a.g;

public final class a extends e<C1000a> {

    /* renamed from: b  reason: collision with root package name */
    d f55182b;

    public final int getItemCount() {
        return 1;
    }

    public final /* synthetic */ void a(RecyclerView.v vVar, int i2) {
        C1000a aVar = (C1000a) vVar;
        k.c(aVar, "holder");
        ((TextView) aVar.itemView.findViewById(R.id.addbank)).setOnClickListener(new b(this));
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        f.a aVar = f.f55348a;
        return new C1000a(f.a.a(viewGroup, g.WIDGET_TYPE_ADD_BANK.getId()));
    }

    public final int a() {
        return g.WIDGET_TYPE_ADD_BANK.getId();
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f55183a;

        b(a aVar) {
            this.f55183a = aVar;
        }

        public final void onClick(View view) {
            d dVar = this.f55183a.f55182b;
            if (dVar == null) {
                k.a("onWidgetClickListener");
            }
            dVar.g();
        }
    }

    public final void a(d dVar) {
        k.c(dVar, "onWidgetClickListener");
        this.f55182b = dVar;
    }

    /* renamed from: net.one97.paytm.moneytransferv4.b.a.a.a.a.a$a  reason: collision with other inner class name */
    public static final class C1000a extends RecyclerView.v {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1000a(View view) {
            super(view);
            k.c(view, "itemView");
        }
    }
}
