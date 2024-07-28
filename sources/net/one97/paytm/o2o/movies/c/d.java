package net.one97.paytm.o2o.movies.c;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.adapter.y;
import net.one97.paytm.o2o.movies.d.j;

public final class d extends RecyclerView.v implements j {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f74960a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f74961b;

    /* renamed from: c  reason: collision with root package name */
    private final y.i f74962c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(Context context, View view, y.i iVar) {
        super(view);
        k.c(context, "mContext");
        k.c(view, "itemView");
        k.c(iVar, "mClickListener");
        this.f74961b = context;
        this.f74962c = iVar;
        this.f74960a = (RecyclerView) view.findViewById(R.id.rv_movie_summary_catalog);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006f, code lost:
        r6 = (r6 = (r6 = (r6 = (r6 = r6.getMovieSummaryCatalog()).getPage()).get(0)).getViews()).get(0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r5, net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem r6) {
        /*
            r4 = this;
            if (r6 != 0) goto L_0x0003
            return
        L_0x0003:
            net.one97.paytm.orders.datamodel.CJRMovieSummaryCatalogV2Item r6 = r6.getmSummaryCatalogItem()     // Catch:{ Exception -> 0x0093 }
            android.widget.LinearLayout$LayoutParams r0 = new android.widget.LinearLayout$LayoutParams     // Catch:{ Exception -> 0x0093 }
            r1 = -1
            r2 = -2
            r0.<init>(r1, r2)     // Catch:{ Exception -> 0x0093 }
            r1 = 10
            android.content.Context r2 = r4.f74961b     // Catch:{ Exception -> 0x0093 }
            int r1 = net.one97.paytm.o2o.movies.utils.n.a((int) r1, (android.content.Context) r2)     // Catch:{ Exception -> 0x0093 }
            r2 = 0
            r0.setMargins(r2, r1, r2, r2)     // Catch:{ Exception -> 0x0093 }
            androidx.recyclerview.widget.LinearLayoutManager r0 = new androidx.recyclerview.widget.LinearLayoutManager     // Catch:{ Exception -> 0x0093 }
            android.content.Context r1 = r4.f74961b     // Catch:{ Exception -> 0x0093 }
            r0.<init>(r1, r2, r2)     // Catch:{ Exception -> 0x0093 }
            androidx.recyclerview.widget.RecyclerView r1 = r4.f74960a     // Catch:{ Exception -> 0x0093 }
            if (r1 != 0) goto L_0x0028
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0093 }
        L_0x0028:
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r0     // Catch:{ Exception -> 0x0093 }
            r1.setLayoutManager(r0)     // Catch:{ Exception -> 0x0093 }
            r0 = 12
            android.content.Context r1 = r4.f74961b     // Catch:{ Exception -> 0x0093 }
            int r0 = net.one97.paytm.o2o.movies.utils.n.a((int) r0, (android.content.Context) r1)     // Catch:{ Exception -> 0x0093 }
            androidx.recyclerview.widget.RecyclerView r1 = r4.f74960a     // Catch:{ Exception -> 0x0093 }
            if (r1 != 0) goto L_0x003c
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0093 }
        L_0x003c:
            net.one97.paytm.o2o.movies.c.d$a r3 = new net.one97.paytm.o2o.movies.c.d$a     // Catch:{ Exception -> 0x0093 }
            r3.<init>(r0)     // Catch:{ Exception -> 0x0093 }
            androidx.recyclerview.widget.RecyclerView$h r3 = (androidx.recyclerview.widget.RecyclerView.h) r3     // Catch:{ Exception -> 0x0093 }
            r1.addItemDecoration(r3)     // Catch:{ Exception -> 0x0093 }
            androidx.recyclerview.widget.RecyclerView r0 = r4.f74960a     // Catch:{ Exception -> 0x0093 }
            if (r0 != 0) goto L_0x004d
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0093 }
        L_0x004d:
            r1 = 1
            r0.setHasFixedSize(r1)     // Catch:{ Exception -> 0x0093 }
            net.one97.paytm.o2o.movies.adapter.t r0 = new net.one97.paytm.o2o.movies.adapter.t     // Catch:{ Exception -> 0x0093 }
            if (r6 == 0) goto L_0x007c
            net.one97.paytm.common.entity.movies.search.CJRMovieSummaryCatalogV2 r6 = r6.getMovieSummaryCatalog()     // Catch:{ Exception -> 0x0093 }
            if (r6 == 0) goto L_0x007c
            java.util.List r6 = r6.getPage()     // Catch:{ Exception -> 0x0093 }
            if (r6 == 0) goto L_0x007c
            java.lang.Object r6 = r6.get(r2)     // Catch:{ Exception -> 0x0093 }
            net.one97.paytm.common.entity.movies.search.CJRMovieSummaryCatalogV2Page r6 = (net.one97.paytm.common.entity.movies.search.CJRMovieSummaryCatalogV2Page) r6     // Catch:{ Exception -> 0x0093 }
            if (r6 == 0) goto L_0x007c
            java.util.List r6 = r6.getViews()     // Catch:{ Exception -> 0x0093 }
            if (r6 == 0) goto L_0x007c
            java.lang.Object r6 = r6.get(r2)     // Catch:{ Exception -> 0x0093 }
            net.one97.paytm.common.entity.movies.search.CJRMovieSummaryCatalogV2View r6 = (net.one97.paytm.common.entity.movies.search.CJRMovieSummaryCatalogV2View) r6     // Catch:{ Exception -> 0x0093 }
            if (r6 == 0) goto L_0x007c
            java.util.List r6 = r6.getItems()     // Catch:{ Exception -> 0x0093 }
            goto L_0x007d
        L_0x007c:
            r6 = 0
        L_0x007d:
            if (r5 != 0) goto L_0x0082
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0093 }
        L_0x0082:
            net.one97.paytm.o2o.movies.adapter.y$i r1 = r4.f74962c     // Catch:{ Exception -> 0x0093 }
            r0.<init>(r6, r5, r1)     // Catch:{ Exception -> 0x0093 }
            androidx.recyclerview.widget.RecyclerView r5 = r4.f74960a     // Catch:{ Exception -> 0x0093 }
            if (r5 != 0) goto L_0x008e
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0093 }
        L_0x008e:
            androidx.recyclerview.widget.RecyclerView$a r0 = (androidx.recyclerview.widget.RecyclerView.a) r0     // Catch:{ Exception -> 0x0093 }
            r5.setAdapter(r0)     // Catch:{ Exception -> 0x0093 }
        L_0x0093:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.c.d.a(android.content.Context, net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem):void");
    }

    public static final class a extends RecyclerView.h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f74963a;

        a(int i2) {
            this.f74963a = i2;
        }

        public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
            k.c(rect, "outRect");
            k.c(view, "view");
            k.c(recyclerView, "parent");
            k.c(sVar, "state");
            super.getItemOffsets(rect, view, recyclerView, sVar);
            rect.right = this.f74963a;
        }
    }
}
