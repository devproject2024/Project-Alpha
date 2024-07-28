package net.one97.paytm.moneytransferv4.b.a.a.a.h;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import net.one97.paytm.moneytransferv4.b.a.a.d;
import net.one97.paytm.moneytransferv4.b.a.a.e;
import net.one97.paytm.moneytransferv4.b.a.a.f;
import net.one97.paytm.moneytransferv4.b.a.a.g;

public final class a extends e<C1016a> {

    /* renamed from: b  reason: collision with root package name */
    d f55316b;

    public final int getItemCount() {
        return 1;
    }

    public final /* synthetic */ void a(RecyclerView.v vVar, int i2) {
        C1016a aVar = (C1016a) vVar;
        k.c(aVar, "holder");
        aVar.itemView.setOnClickListener(new b(this));
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        f.a aVar = f.f55348a;
        return new C1016a(f.a.a(viewGroup, g.WIDGET_TYPE_SEARCH.getId()));
    }

    public final int a() {
        return g.WIDGET_TYPE_SEARCH.getId();
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f55317a;

        b(a aVar) {
            this.f55317a = aVar;
        }

        public final void onClick(View view) {
            d dVar = this.f55317a.f55316b;
            if (dVar != null) {
                dVar.c();
            }
        }
    }

    /* renamed from: net.one97.paytm.moneytransferv4.b.a.a.a.h.a$a  reason: collision with other inner class name */
    public static final class C1016a extends RecyclerView.v {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1016a(View view) {
            super(view);
            k.c(view, "view");
        }
    }

    public final void a(d dVar) {
        k.c(dVar, "onWidgetClickListener");
        this.f55316b = dVar;
    }
}
