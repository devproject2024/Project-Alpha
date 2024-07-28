package net.one97.paytm.o2o.movies.adapter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import net.one97.paytm.o2o.movies.adapter.aj;
import net.one97.paytm.o2o.movies.adapter.y;
import net.one97.paytm.o2o.movies.c.b;
import net.one97.paytm.o2o.movies.c.c;
import net.one97.paytm.o2o.movies.c.d;
import net.one97.paytm.o2o.movies.c.e;
import net.one97.paytm.o2o.movies.c.f;
import net.one97.paytm.o2o.movies.c.g;
import net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem;
import net.one97.paytm.o2o.movies.d.i;
import net.one97.paytm.o2o.movies.d.j;
import net.one97.paytm.orders.a.a;

public final class ag extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<CJRSummaryItem> f74312a;

    /* renamed from: b  reason: collision with root package name */
    i f74313b;

    /* renamed from: c  reason: collision with root package name */
    Context f74314c;

    /* renamed from: d  reason: collision with root package name */
    String f74315d = null;

    /* renamed from: e  reason: collision with root package name */
    public aj.a f74316e;

    /* renamed from: f  reason: collision with root package name */
    public y.i f74317f;

    /* renamed from: g  reason: collision with root package name */
    public c f74318g;

    public ag(i iVar, FragmentActivity fragmentActivity, ArrayList<CJRSummaryItem> arrayList) {
        this.f74313b = iVar;
        this.f74314c = fragmentActivity;
        this.f74312a = arrayList;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        a fromIndex = a.fromIndex(i2);
        Context context = this.f74314c;
        i iVar = this.f74313b;
        aj.a aVar = this.f74316e;
        y.i iVar2 = this.f74317f;
        int i3 = e.AnonymousClass1.f74964a[fromIndex.ordinal()];
        if (i3 == 1) {
            return new net.one97.paytm.o2o.movies.c.a(context, e.a(viewGroup, fromIndex), iVar);
        }
        if (i3 == 2) {
            return new g(context, e.a(viewGroup, fromIndex), iVar);
        }
        if (i3 == 3) {
            return new c(context, e.a(viewGroup, fromIndex), iVar);
        }
        if (i3 == 4) {
            return new f(context, e.a(viewGroup, fromIndex), iVar, aVar);
        }
        if (i3 != 5) {
            return new b(context, e.a(viewGroup, fromIndex), iVar);
        }
        return new d(context, e.a(viewGroup, fromIndex), iVar2);
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        ArrayList<CJRSummaryItem> arrayList = this.f74312a;
        if (arrayList != null && arrayList.size() > 0) {
            j jVar = (j) vVar;
            jVar.a(this.f74314c, this.f74312a.get(i2));
            if (jVar instanceof c) {
                this.f74318g = (c) jVar;
            }
        }
    }

    public final int getItemCount() {
        ArrayList<CJRSummaryItem> arrayList = this.f74312a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final int getItemViewType(int i2) {
        ArrayList<CJRSummaryItem> arrayList = this.f74312a;
        a fromName = a.fromName(((arrayList == null || arrayList.size() <= 0) ? null : this.f74312a.get(i2)).getLayout());
        if (fromName == null) {
            return -1;
        }
        return fromName.getIndex();
    }
}
