package net.one97.paytm.feed.ui.feed.j;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.v;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.b.c;
import net.one97.paytm.feed.repository.models.nestedfeed.NestedFeed;
import net.one97.paytm.feed.ui.base.b;

public final class a extends b<c, NestedFeed, Object> {

    /* renamed from: b  reason: collision with root package name */
    RecyclerView f35080b = ((RecyclerView) this.f35083e.findViewById(R.id.feed_banner_recyclerview));

    /* renamed from: c  reason: collision with root package name */
    private net.one97.paytm.feed.ui.feed.a.a f35081c;

    /* renamed from: d  reason: collision with root package name */
    private LinearLayoutManager f35082d;

    /* renamed from: e  reason: collision with root package name */
    private final View f35083e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(View view) {
        super(view);
        k.c(view, "view");
        this.f35083e = view;
        C0582a aVar = new C0582a(this);
        new v();
        RecyclerView recyclerView = this.f35080b;
        if (recyclerView != null) {
            recyclerView.setItemAnimator((RecyclerView.f) null);
            this.f35082d = new LinearLayoutManager(recyclerView.getContext(), 0, false);
            recyclerView.setLayoutManager(this.f35082d);
            this.f35081c = new net.one97.paytm.feed.ui.feed.a.a(net.one97.paytm.feed.utility.k.POSTER.getType());
            recyclerView.setAdapter(this.f35081c);
            aVar.attachToRecyclerView(recyclerView);
            recyclerView.setHasFixedSize(true);
        }
    }

    /* renamed from: net.one97.paytm.feed.ui.feed.j.a$a  reason: collision with other inner class name */
    public static final class C0582a extends v {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f35084a;

        C0582a(a aVar) {
            this.f35084a = aVar;
        }

        public final int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View view) {
            k.c(layoutManager, "layoutManager");
            k.c(view, "targetView");
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            RecyclerView recyclerView = this.f35084a.f35080b;
            Integer valueOf = recyclerView != null ? Integer.valueOf(recyclerView.getChildAdapterPosition(view)) : null;
            if (valueOf == null || valueOf.intValue() != 0) {
                int itemCount = linearLayoutManager.getItemCount() - 1;
                if (valueOf == null || valueOf.intValue() != itemCount) {
                    int left = view.getLeft() + (view.getWidth() / 2);
                    RecyclerView recyclerView2 = this.f35084a.f35080b;
                    return new int[]{left - (recyclerView2 != null ? recyclerView2.getWidth() / 2 : 0), 0};
                }
            }
            return super.calculateDistanceToFinalSnap(layoutManager, view);
        }
    }

    public final void a(NestedFeed nestedFeed) {
        k.c(nestedFeed, "data");
        c cVar = (c) this.f34872a;
        cVar.setVariable(net.one97.paytm.feed.a.f33779f, nestedFeed.getNestedFeedData().getTitle());
        for (Map.Entry entry : new HashMap().entrySet()) {
            cVar.setVariable(((Number) entry.getKey()).intValue(), entry.getValue());
        }
        net.one97.paytm.feed.ui.feed.a.a aVar = this.f35081c;
        if (aVar != null) {
            aVar.a(nestedFeed);
        }
    }
}
