package net.one97.paytm.moneytransferv4.b.a.a.a.g;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransferv4.b.a.a.d;
import net.one97.paytm.moneytransferv4.b.a.a.e;
import net.one97.paytm.moneytransferv4.b.a.a.f;
import net.one97.paytm.moneytransferv4.b.a.a.g;

public final class f extends e<a> {

    /* renamed from: b  reason: collision with root package name */
    private d f55312b;

    public final int getItemCount() {
        return 1;
    }

    public final /* synthetic */ void a(RecyclerView.v vVar, int i2) {
        k.c((a) vVar, "holder");
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        f.a aVar = net.one97.paytm.moneytransferv4.b.a.a.f.f55348a;
        View a2 = f.a.a(viewGroup, g.WIDGET_TYPE_PAYMENT_OPTIONS.getId());
        d dVar = this.f55312b;
        if (dVar == null) {
            k.a();
        }
        return new a(a2, dVar);
    }

    public final int a() {
        return g.WIDGET_TYPE_PAYMENT_OPTIONS.getId();
    }

    public final void a(d dVar) {
        k.c(dVar, "onWidgetClickListener");
        this.f55312b = dVar;
    }

    public static final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        public FrameLayout f55313a;

        /* renamed from: b  reason: collision with root package name */
        private View f55314b;

        /* renamed from: c  reason: collision with root package name */
        private d f55315c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view, d dVar) {
            super(view);
            k.c(view, "view");
            k.c(dVar, "onWidgetClickListener");
            this.f55314b = view;
            this.f55315c = dVar;
            View findViewById = this.f55314b.findViewById(R.id.fragment_container);
            k.a((Object) findViewById, "view.findViewById(R.id.fragment_container)");
            this.f55313a = (FrameLayout) findViewById;
        }
    }
}
