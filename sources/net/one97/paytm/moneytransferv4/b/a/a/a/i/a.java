package net.one97.paytm.moneytransferv4.b.a.a.a.i;

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

public final class a extends e<C1017a> {

    /* renamed from: b  reason: collision with root package name */
    private final String f55318b;

    public final void a(d dVar) {
        k.c(dVar, "onWidgetClickListener");
    }

    public final int getItemCount() {
        return 1;
    }

    public final /* synthetic */ void a(RecyclerView.v vVar, int i2) {
        C1017a aVar = (C1017a) vVar;
        k.c(aVar, "holder");
        aVar.f55319a.setText(this.f55318b);
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        f.a aVar = f.f55348a;
        return new C1017a(f.a.a(viewGroup, g.WIDGET_TYPE_TITLE.getId()));
    }

    public a(String str) {
        this.f55318b = str;
    }

    public final int a() {
        return g.WIDGET_TYPE_TITLE.getId();
    }

    /* renamed from: net.one97.paytm.moneytransferv4.b.a.a.a.i.a$a  reason: collision with other inner class name */
    public static final class C1017a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f55319a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1017a(View view) {
            super(view);
            k.c(view, "view");
            View findViewById = view.findViewById(R.id.titleTV);
            k.a((Object) findViewById, "view.findViewById(R.id.titleTV)");
            this.f55319a = (TextView) findViewById;
        }
    }
}
