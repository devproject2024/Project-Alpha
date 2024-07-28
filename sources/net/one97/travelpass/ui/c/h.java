package net.one97.travelpass.ui.c;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.one97.travelpass.a.c;
import com.one97.travelpass.a.d;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.travelpass.R;

public final class h extends RecyclerView.v implements d {

    /* renamed from: a  reason: collision with root package name */
    RecyclerView f30648a;

    /* renamed from: b  reason: collision with root package name */
    public int f30649b;

    /* renamed from: c  reason: collision with root package name */
    public int f30650c;

    /* renamed from: d  reason: collision with root package name */
    public RecyclerView.l f30651d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f30652e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(View view) {
        super(view);
        if (view == null) {
            k.a();
        }
        this.f30652e = true;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_tabs);
        if (recyclerView != null) {
            this.f30648a = recyclerView;
            return;
        }
        throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
    }

    public final void a(Context context, int i2, j jVar, c cVar) {
        k.c(jVar, "viewHolderModel");
        k.c(cVar, "itemClickListener");
        ArrayList<j> a2 = jVar.a();
        k.a((Object) a2, "viewHolderModel.viewHolderData");
        net.one97.travelpass.a.c cVar2 = new net.one97.travelpass.a.c(context, a2, cVar);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 0, false);
        RecyclerView recyclerView = this.f30648a;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
        }
        RecyclerView recyclerView2 = this.f30648a;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(cVar2);
        }
        StringBuilder sb = new StringBuilder("scroll changes ... inside updateViewHolder scrollPositionX ");
        sb.append(this.f30649b);
        sb.append(" scrollPositionY ");
        sb.append(this.f30650c);
        RecyclerView recyclerView3 = this.f30648a;
        if (recyclerView3 != null) {
            recyclerView3.setOnScrollListener(this.f30651d);
        }
        if (this.f30652e) {
            this.f30652e = false;
            RecyclerView recyclerView4 = this.f30648a;
            if (recyclerView4 != null) {
                recyclerView4.smoothScrollToPosition(jVar.p());
                return;
            }
            return;
        }
        RecyclerView recyclerView5 = this.f30648a;
        if (recyclerView5 != null) {
            recyclerView5.post(new a(this));
        }
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f30653a;

        a(h hVar) {
            this.f30653a = hVar;
        }

        public final void run() {
            RecyclerView recyclerView = this.f30653a.f30648a;
            if (recyclerView != null) {
                recyclerView.scrollBy(this.f30653a.f30649b, this.f30653a.f30650c);
            }
        }
    }
}
