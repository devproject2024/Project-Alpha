package net.one97.paytm.hotel4.view.a;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.core.g.d;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.hotels2.b.cg;

public final class y extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    private final List<d<String, String>> f28768a;

    public y(List<? extends d<String, String>> list) {
        k.c(list, "pairList");
        this.f28768a = list;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        d dVar = this.f28768a.get(i2);
        k.c(dVar, "pair");
        aVar.f28769a.a(dVar);
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        cg a2 = cg.a(LayoutInflater.from(viewGroup.getContext()), viewGroup);
        k.a((Object) a2, "H4ListItemPairBinding.in….context), parent, false)");
        return new a(this, a2);
    }

    public final int getItemCount() {
        return this.f28768a.size();
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        cg f28769a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ y f28770b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(y yVar, cg cgVar) {
            super(cgVar.getRoot());
            k.c(cgVar, "listItemPairBinding");
            this.f28770b = yVar;
            this.f28769a = cgVar;
        }
    }
}
