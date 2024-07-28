package net.one97.paytm.hotel4.view.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.hotel4.service.model.details.CJRRoom;
import net.one97.paytm.hotel4.service.model.ordersummary.MetaData;
import net.one97.paytm.hotel4.utils.e;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.b.ci;
import net.one97.paytm.hotels2.utils.CJRHotelsUtilsLib;

public final class i extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    private final List<CJRRoom> f28689a;

    /* renamed from: b  reason: collision with root package name */
    private final MetaData f28690b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f28691c;

    public i(List<CJRRoom> list, MetaData metaData, Context context) {
        k.c(list, "roomList");
        k.c(metaData, "metaData");
        k.c(context, "context");
        this.f28689a = list;
        this.f28690b = metaData;
        this.f28691c = context;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        CJRRoom cJRRoom = this.f28689a.get(i2);
        int i3 = this.f28690b.priceData.finalPrice;
        Integer num = this.f28690b.numNights;
        k.a((Object) num, "metaData.numNights");
        String a2 = CJRHotelsUtilsLib.a(String.valueOf(i3 * num.intValue()));
        k.a((Object) a2, "CJRHotelsUtilsLib.priceT…ta.numNights).toString())");
        cJRRoom.setRoomTitle("Room " + (i2 + 1));
        StringBuilder sb = new StringBuilder("(");
        Context context = this.f28691c;
        int i4 = R.string.hotels_room_detail_title_text1;
        sb.append(context.getString(i4, new Object[]{this.f28691c.getString(R.string.h4_hotels_rupees).toString() + CJRHotelsUtilsLib.a(String.valueOf(this.f28690b.priceData.finalPrice))}));
        sb.append(" for ");
        sb.append(this.f28690b.numNights);
        e eVar = e.f28642a;
        sb.append(e.a(" night", "", this.f28690b.numNights));
        sb.append(")");
        cJRRoom.setRoomDetails(sb.toString());
        cJRRoom.setRoomPrice(this.f28691c.getString(R.string.h4_hotels_rupees).toString() + a2);
        k.c(cJRRoom, "room");
        aVar.f28692a.a(cJRRoom);
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        ci a2 = ci.a(LayoutInflater.from(viewGroup.getContext()), viewGroup);
        k.a((Object) a2, "H4ListItemRoomPriceBindi….context), parent, false)");
        return new a(this, a2);
    }

    public final int getItemCount() {
        return this.f28689a.size();
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ci f28692a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ i f28693b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(i iVar, ci ciVar) {
            super(ciVar.getRoot());
            k.c(ciVar, "listItemRoomPriceBinding");
            this.f28693b = iVar;
            this.f28692a = ciVar;
        }
    }
}
