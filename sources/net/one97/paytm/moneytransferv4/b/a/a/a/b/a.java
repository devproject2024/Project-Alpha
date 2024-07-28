package net.one97.paytm.moneytransferv4.b.a.a.a.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransferv4.b.a.a.d;
import net.one97.paytm.moneytransferv4.b.a.a.e;
import net.one97.paytm.moneytransferv4.b.a.a.g;

public final class a extends e<C1001a> {

    /* renamed from: b  reason: collision with root package name */
    d f55184b;

    public final int getItemCount() {
        return 1;
    }

    public final /* synthetic */ void a(RecyclerView.v vVar, int i2) {
        C1001a aVar = (C1001a) vVar;
        k.c(aVar, "holder");
        ((TextView) aVar.f55185a.findViewById(R.id.gotIt)).setOnClickListener(new b(this));
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mt_all_in_one_item_view, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(pare…item_view, parent, false)");
        return new C1001a(inflate);
    }

    public final int a() {
        return g.WIDGET_TYPE_ALL_IN_ONE.getId();
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f55186a;

        b(a aVar) {
            this.f55186a = aVar;
        }

        public final void onClick(View view) {
            d dVar = this.f55186a.f55184b;
            if (dVar == null) {
                k.a("onWidgetClickListener");
            }
            dVar.f();
        }
    }

    public final void a(d dVar) {
        k.c(dVar, "onWidgetClickListener");
        this.f55184b = dVar;
    }

    /* renamed from: net.one97.paytm.moneytransferv4.b.a.a.a.b.a$a  reason: collision with other inner class name */
    public static final class C1001a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final View f55185a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1001a(View view) {
            super(view);
            k.c(view, "view");
            this.f55185a = view;
        }
    }
}
