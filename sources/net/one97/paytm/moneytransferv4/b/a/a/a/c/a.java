package net.one97.paytm.moneytransferv4.b.a.a.a.c;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import com.facebook.shimmer.ShimmerFrameLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.contacts.entities.beans.ContactsResponse;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransferv4.b.a.a.a.c.b;
import net.one97.paytm.moneytransferv4.b.a.a.d;
import net.one97.paytm.moneytransferv4.b.a.a.e;
import net.one97.paytm.moneytransferv4.b.a.a.f;
import net.one97.paytm.moneytransferv4.b.a.a.g;
import net.one97.paytm.upi.f;
import net.one97.paytm.upi.util.VerticalSpaceItemDecoration;

public final class a extends e<C1002a> {

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<ContactsResponse> f55187b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f55188c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f55189d;

    /* renamed from: e  reason: collision with root package name */
    private d f55190e;

    public final int getItemCount() {
        return 1;
    }

    public final /* synthetic */ void a(RecyclerView.v vVar, int i2) {
        b bVar;
        C1002a aVar = (C1002a) vVar;
        k.c(aVar, "holder");
        ArrayList<ContactsResponse> arrayList = this.f55187b;
        boolean z = false;
        if (!this.f55188c) {
            RecyclerView recyclerView = aVar.f55191a;
            k.a((Object) recyclerView, "recyclerView");
            Collection collection = arrayList;
            f.a((View) recyclerView, !(collection == null || collection.isEmpty()));
            f.a(aVar.f55193c, collection == null || collection.isEmpty());
            if (collection == null || collection.isEmpty()) {
                aVar.f55193c.a();
            } else {
                aVar.f55193c.b();
            }
            if (aVar.f55194d == null) {
                if (arrayList != null) {
                    aVar.f55194d = new b(aVar.f55196f);
                    RecyclerView recyclerView2 = aVar.f55191a;
                    k.a((Object) recyclerView2, "recyclerView");
                    recyclerView2.setAdapter(aVar.f55194d);
                    RecyclerView recyclerView3 = aVar.f55191a;
                    k.a((Object) recyclerView3, "recyclerView");
                    recyclerView3.setLayoutManager(new GridLayoutManager(aVar.f55195e.getContext(), 1));
                    b bVar2 = aVar.f55194d;
                    if (bVar2 != null) {
                        List<? extends ContactsResponse> list = arrayList;
                        k.c(list, "newList");
                        h.b a2 = h.a(new b.c(bVar2.f55198a, list));
                        k.a((Object) a2, "DiffUtil.calculateDiff(g…llBack(oldList, newList))");
                        bVar2.f55198a = list;
                        a2.a((RecyclerView.a) bVar2);
                    }
                    RecyclerView recyclerView4 = aVar.f55191a;
                    Resources system = Resources.getSystem();
                    k.a((Object) system, "Resources.getSystem()");
                    recyclerView4.addItemDecoration(new VerticalSpaceItemDecoration((int) (system.getDisplayMetrics().density * 8.0f)));
                }
            } else if (arrayList != null && (bVar = aVar.f55194d) != null) {
                List<? extends ContactsResponse> list2 = arrayList;
                k.c(list2, "newList");
                bVar.f55198a = list2;
                bVar.notifyItemRangeChanged(0, bVar.getItemCount(), new Object());
            }
        } else {
            Collection collection2 = arrayList;
            f.a(aVar.f55192b, !(collection2 == null || collection2.isEmpty()));
            RecyclerView recyclerView5 = aVar.f55191a;
            k.a((Object) recyclerView5, "recyclerView");
            f.a((View) recyclerView5, !(collection2 == null || collection2.isEmpty()));
            View view = aVar.f55193c;
            if (collection2 == null || collection2.isEmpty()) {
                z = true;
            }
            f.a(view, !z);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        f.a aVar = net.one97.paytm.moneytransferv4.b.a.a.f.f55348a;
        return new C1002a(f.a.a(viewGroup, g.WIDGET_TYPE_BENEFICIARIES.getId()), this.f55190e);
    }

    public final void a(d dVar) {
        k.c(dVar, "onWidgetClickListener");
        this.f55190e = dVar;
    }

    public final int a() {
        return g.WIDGET_TYPE_BENEFICIARIES.getId();
    }

    /* renamed from: net.one97.paytm.moneytransferv4.b.a.a.a.c.a$a  reason: collision with other inner class name */
    public static final class C1002a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final RecyclerView f55191a = ((RecyclerView) this.f55195e.findViewById(R.id.optionsRv));

        /* renamed from: b  reason: collision with root package name */
        final TextView f55192b;

        /* renamed from: c  reason: collision with root package name */
        final ShimmerFrameLayout f55193c;

        /* renamed from: d  reason: collision with root package name */
        b f55194d;

        /* renamed from: e  reason: collision with root package name */
        View f55195e;

        /* renamed from: f  reason: collision with root package name */
        d f55196f;

        /* renamed from: g  reason: collision with root package name */
        private Animation f55197g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1002a(View view, d dVar) {
            super(view);
            k.c(view, "view");
            this.f55195e = view;
            this.f55196f = dVar;
            View findViewById = this.f55195e.findViewById(R.id.titleTV);
            k.a((Object) findViewById, "view.findViewById(R.id.titleTV)");
            this.f55192b = (TextView) findViewById;
            View findViewById2 = this.f55195e.findViewById(R.id.shimmer);
            k.a((Object) findViewById2, "view.findViewById(R.id.shimmer)");
            this.f55193c = (ShimmerFrameLayout) findViewById2;
            this.f55197g = AnimationUtils.loadAnimation(this.f55195e.getContext(), R.anim.mt_shimmer_anim);
        }
    }
}
