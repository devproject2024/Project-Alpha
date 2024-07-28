package net.one97.paytm.hotel4.view.a;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.utils.t;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem;
import net.one97.paytm.hotel4.view.a.a;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.b.ck;

public final class x extends com.travel.customViews.a {

    /* renamed from: a  reason: collision with root package name */
    a f28757a;

    /* renamed from: b  reason: collision with root package name */
    private ck f28758b;

    /* renamed from: c  reason: collision with root package name */
    private final List<SRPDataItem> f28759c;

    public interface a {
        void a(SRPDataItem sRPDataItem, int i2);
    }

    public x(List<SRPDataItem> list) {
        k.c(list, "hotelsList");
        this.f28759c = list;
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        ck a2 = ck.a(t.a(viewGroup, R.layout.h4_list_item_similar_hotels));
        k.a((Object) a2, "H4ListItemSimilarHotelsB…ist_item_similar_hotels))");
        this.f28758b = a2;
        ck ckVar = this.f28758b;
        if (ckVar == null) {
            k.a("itemBinding");
        }
        return new b(this, ckVar);
    }

    public final int getItemCount() {
        return Math.min(this.f28759c.size(), 6);
    }

    public final int a() {
        return Math.min(this.f28759c.size(), 6);
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        k.c(vVar, "holder");
        b bVar = (b) vVar;
        SRPDataItem sRPDataItem = this.f28759c.get(i2);
        k.c(sRPDataItem, "hotel");
        bVar.f28760a.a(sRPDataItem);
        bVar.f28760a.f29373c.setOnClickListener(new b.a(bVar, sRPDataItem, i2));
        a aVar = new a(sRPDataItem.getAmenitiesList());
        RecyclerView recyclerView = bVar.f28760a.f29372b;
        if (recyclerView == null) {
            k.a();
        }
        k.a((Object) recyclerView, "binding.amelitiesList!!");
        RecyclerView recyclerView2 = bVar.f28760a.f29372b;
        k.a((Object) recyclerView2, "binding.amelitiesList");
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView2.getContext(), 0, false));
        RecyclerView recyclerView3 = bVar.f28760a.f29372b;
        k.a((Object) recyclerView3, "binding.amelitiesList");
        recyclerView3.setAdapter(aVar);
        aVar.f28667a = new b.C0504b(bVar, sRPDataItem, i2);
    }

    public final void a(a aVar) {
        k.c(aVar, "hotelClickListener");
        this.f28757a = aVar;
    }

    public final class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final ck f28760a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x f28761b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(x xVar, ck ckVar) {
            super(ckVar.getRoot());
            k.c(ckVar, "binding");
            this.f28761b = xVar;
            this.f28760a = ckVar;
        }

        static final class a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f28762a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ SRPDataItem f28763b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ int f28764c;

            a(b bVar, SRPDataItem sRPDataItem, int i2) {
                this.f28762a = bVar;
                this.f28763b = sRPDataItem;
                this.f28764c = i2;
            }

            public final void onClick(View view) {
                a aVar = this.f28762a.f28761b.f28757a;
                if (aVar == null) {
                    k.a();
                }
                aVar.a(this.f28763b, this.f28764c);
            }
        }

        /* renamed from: net.one97.paytm.hotel4.view.a.x$b$b  reason: collision with other inner class name */
        public static final class C0504b implements a.b {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f28765a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ SRPDataItem f28766b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ int f28767c;

            C0504b(b bVar, SRPDataItem sRPDataItem, int i2) {
                this.f28765a = bVar;
                this.f28766b = sRPDataItem;
                this.f28767c = i2;
            }

            public final void a() {
                a aVar = this.f28765a.f28761b.f28757a;
                if (aVar == null) {
                    k.a();
                }
                aVar.a(this.f28766b, this.f28767c);
            }
        }
    }
}
