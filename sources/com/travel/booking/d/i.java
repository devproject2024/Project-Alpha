package com.travel.booking.d;

import android.view.ViewGroup;
import androidx.lifecycle.ai;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.booking.datamodel.BookingInfo;
import java.util.List;

public final class i extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    private List<BookingInfo> f21485a = null;

    /* renamed from: b  reason: collision with root package name */
    private ai f21486b;

    public i(List<BookingInfo> list, ai aiVar) {
        this.f21485a = list;
        this.f21486b = aiVar;
    }

    public final int getItemViewType(int i2) {
        if (this.f21485a.get(i2).isBusBooking()) {
            return j.VIEW_TYPE_BUS_UPCOMING.ordinal();
        }
        if (this.f21485a.get(i2).isTrainBooking()) {
            return j.VIEW_TYPE_TRAIN_UPCOMING.ordinal();
        }
        if (this.f21485a.get(i2).isFlightBooking()) {
            return j.VIEW_TYPE_FLIGHT_UPCOMING.ordinal();
        }
        if (this.f21485a.get(i2).isHotelBooking()) {
            return j.VIEW_TYPE_HOTEL_UPCOMING.ordinal();
        }
        if (this.f21485a.get(i2).isCityBusBooking()) {
            return j.VIEW_TYPE_CITY_BUS_UPCOMING.ordinal();
        }
        return super.getItemViewType(i2);
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return f.a(i2, viewGroup);
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        ((a) vVar).a(this.f21485a.get(i2), this.f21486b);
    }

    public final int getItemCount() {
        List<BookingInfo> list = this.f21485a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
