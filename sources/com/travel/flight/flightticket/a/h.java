package com.travel.flight.flightticket.a;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.flight.flightticket.e.d;
import com.travel.flight.flightticket.e.f;
import com.travel.flight.flightticket.e.g;
import com.travel.flight.flightticket.j.m;
import com.travel.flight.pojo.modifyBooking.CJRFlightMBChargesBody;
import com.travel.flight.pojo.modifyBooking.CJRFlightMBImgNote;
import com.travel.flight.pojo.modifyBooking.CJRFlightMBPassenger;
import java.util.List;
import kotlin.g.b.k;

public final class h extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    private CJRFlightMBChargesBody f24658a;

    /* renamed from: b  reason: collision with root package name */
    private List<? extends Object> f24659b;

    public h(CJRFlightMBChargesBody cJRFlightMBChargesBody, List<? extends Object> list) {
        k.c(list, "mList");
        this.f24658a = cJRFlightMBChargesBody;
        this.f24659b = list;
    }

    public final int getItemViewType(int i2) {
        Object obj = this.f24659b.get(i2);
        if (obj instanceof f) {
            return ((f) obj).f24903a.getValue();
        }
        if (obj instanceof String) {
            return g.Note.getValue();
        }
        if (obj instanceof CJRFlightMBImgNote) {
            return g.ImgNote.getValue();
        }
        if (obj instanceof CJRFlightMBPassenger) {
            return g.Passenger.getValue();
        }
        return g.Empty.getValue();
    }

    public final int getItemCount() {
        return this.f24659b.size();
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        d dVar = d.f24900a;
        g.a aVar = g.Companion;
        return d.a(g.a.a(i2), viewGroup);
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        k.c(vVar, "holder");
        d dVar = d.f24900a;
        int itemViewType = vVar.getItemViewType();
        d.a(this.f24658a, this.f24659b.get(i2), itemViewType, (m) vVar);
    }

    public final void a(CJRFlightMBChargesBody cJRFlightMBChargesBody, List<? extends Object> list) {
        k.c(list, "list");
        this.f24658a = cJRFlightMBChargesBody;
        this.f24659b = list;
    }
}
