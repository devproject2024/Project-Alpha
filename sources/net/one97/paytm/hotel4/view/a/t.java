package net.one97.paytm.hotel4.view.a;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem;
import net.one97.paytm.hotel4.view.a.a;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.b.ce;

public final class t extends com.travel.customViews.a {

    /* renamed from: a  reason: collision with root package name */
    public a f28734a;

    /* renamed from: b  reason: collision with root package name */
    private ce f28735b;

    /* renamed from: c  reason: collision with root package name */
    private final List<SRPDataItem> f28736c;

    public interface a {
        void a(SRPDataItem sRPDataItem);
    }

    public t(List<SRPDataItem> list) {
        k.c(list, "hotelsList");
        this.f28736c = list;
        String.valueOf(this.f28736c.size());
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        ce a2 = ce.a(com.travel.utils.t.a(viewGroup, R.layout.h4_list_item_map_hotels));
        k.a((Object) a2, "H4ListItemMapHotelsBindi…h4_list_item_map_hotels))");
        this.f28735b = a2;
        ce ceVar = this.f28735b;
        if (ceVar == null) {
            k.a("itemBinding");
        }
        return new b(this, ceVar);
    }

    public final int getItemCount() {
        return this.f28736c.size();
    }

    public final int a() {
        return this.f28736c.size();
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        k.c(vVar, "holder");
        b bVar = (b) vVar;
        SRPDataItem sRPDataItem = this.f28736c.get(i2);
        k.c(sRPDataItem, "hotel");
        bVar.f28737a.a(sRPDataItem);
        bVar.f28737a.f29349c.setOnClickListener(new b.a(bVar, sRPDataItem));
        a aVar = new a(sRPDataItem.getAmenitiesList());
        RecyclerView recyclerView = bVar.f28737a.f29348b;
        if (recyclerView == null) {
            k.a();
        }
        k.a((Object) recyclerView, "binding.amelitiesList!!");
        RecyclerView recyclerView2 = bVar.f28737a.f29348b;
        k.a((Object) recyclerView2, "binding.amelitiesList");
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView2.getContext(), 0, false));
        RecyclerView recyclerView3 = bVar.f28737a.f29348b;
        k.a((Object) recyclerView3, "binding.amelitiesList");
        recyclerView3.setAdapter(aVar);
        aVar.f28667a = new b.C0503b(bVar, sRPDataItem);
    }

    public final class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final ce f28737a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ t f28738b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(t tVar, ce ceVar) {
            super(ceVar.getRoot());
            k.c(ceVar, "binding");
            this.f28738b = tVar;
            this.f28737a = ceVar;
        }

        static final class a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f28739a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ SRPDataItem f28740b;

            a(b bVar, SRPDataItem sRPDataItem) {
                this.f28739a = bVar;
                this.f28740b = sRPDataItem;
            }

            public final void onClick(View view) {
                a aVar = this.f28739a.f28738b.f28734a;
                if (aVar == null) {
                    k.a();
                }
                aVar.a(this.f28740b);
            }
        }

        /* renamed from: net.one97.paytm.hotel4.view.a.t$b$b  reason: collision with other inner class name */
        public static final class C0503b implements a.b {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f28741a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ SRPDataItem f28742b;

            C0503b(b bVar, SRPDataItem sRPDataItem) {
                this.f28741a = bVar;
                this.f28742b = sRPDataItem;
            }

            public final void a() {
                a aVar = this.f28741a.f28738b.f28734a;
                if (aVar == null) {
                    k.a();
                }
                aVar.a(this.f28742b);
            }
        }
    }
}
