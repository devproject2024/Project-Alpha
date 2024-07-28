package net.one97.paytm.moneytransferv4.b.a.a.a.f;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import net.one97.paytm.moneytransferv4.b.a.a.d;
import net.one97.paytm.moneytransferv4.b.a.a.e;
import net.one97.paytm.moneytransferv4.b.a.a.f;
import net.one97.paytm.moneytransferv4.b.a.a.g;

public final class a extends e<C1013a> {

    /* renamed from: b  reason: collision with root package name */
    private d f55290b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f55291c;

    public final int getItemCount() {
        return 1;
    }

    public final /* synthetic */ void a(RecyclerView.v vVar, int i2) {
        k.c((C1013a) vVar, "holder");
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        f.a aVar = f.f55348a;
        return new C1013a(f.a.a(viewGroup, g.WIDGET_TYPE_CONTACT_MOTIF.getId()));
    }

    public a(boolean z) {
        this.f55291c = z;
    }

    public final int a() {
        return g.WIDGET_TYPE_CONTACT_MOTIF.getId();
    }

    public final void a(d dVar) {
        k.c(dVar, "onWidgetClickListener");
        this.f55290b = dVar;
    }

    /* renamed from: net.one97.paytm.moneytransferv4.b.a.a.a.f.a$a  reason: collision with other inner class name */
    public static final class C1013a extends RecyclerView.v {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1013a(View view) {
            super(view);
            k.c(view, "itemView");
        }
    }
}
