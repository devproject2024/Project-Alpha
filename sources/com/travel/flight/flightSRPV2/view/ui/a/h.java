package com.travel.flight.flightSRPV2.view.ui.a;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.flight.b.bu;
import com.travel.flight.pojo.modifyBooking.CJRFlightMBPassenger;
import java.util.List;
import kotlin.g.b.k;

public final class h extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    private final List<CJRFlightMBPassenger> f24194a;

    public h(List<CJRFlightMBPassenger> list) {
        k.c(list, "passengerList");
        this.f24194a = list;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        aVar.f24195a.a(this.f24194a.get(i2));
        TextView textView = aVar.f24195a.f23748b;
        k.a((Object) textView, "holder.listItemModifyTic…avellerBinding.genterText");
        textView.setText(this.f24194a.get(i2).getGenderType() + " " + (i2 + 1));
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        bu a2 = bu.a(LayoutInflater.from(viewGroup.getContext()), viewGroup);
        k.a((Object) a2, "ListItemModifyTicketTrav….context), parent, false)");
        return new a(this, a2);
    }

    public final int getItemCount() {
        return this.f24194a.size();
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final bu f24195a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ h f24196b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(h hVar, bu buVar) {
            super(buVar.getRoot());
            k.c(buVar, "listItemModifyTicketTravellerBinding");
            this.f24196b = hVar;
            this.f24195a = buVar;
        }
    }
}
