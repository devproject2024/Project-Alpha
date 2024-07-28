package com.travel.booking.d;

import android.view.ViewGroup;
import androidx.lifecycle.ai;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.booking.datamodel.BookingInfo;
import java.util.List;

public final class g extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    private List<BookingInfo> f21481a = null;

    /* renamed from: b  reason: collision with root package name */
    private ai f21482b;

    public g(List<BookingInfo> list, ai aiVar) {
        this.f21481a = list;
        this.f21482b = aiVar;
    }

    public final int getItemViewType(int i2) {
        if (this.f21481a.get(i2).isBusBooking()) {
            return j.VIEW_TYPE_BUS_CANCELLED.ordinal();
        }
        if (this.f21481a.get(i2).isTrainBooking()) {
            return j.VIEW_TYPE_TRAIN_CANCELLED.ordinal();
        }
        if (this.f21481a.get(i2).isFlightBooking()) {
            return j.VIEW_TYPE_FLIGHT_CANCELLED.ordinal();
        }
        if (this.f21481a.get(i2).isHotelBooking()) {
            return j.VIEW_TYPE_HOTEL_CANCELLED.ordinal();
        }
        if (this.f21481a.get(i2).isCityBusBooking()) {
            return j.VIEW_TYPE_CITY_BUS_CANCELLED.ordinal();
        }
        return super.getItemViewType(i2);
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return f.a(i2, viewGroup);
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        ((a) vVar).a(this.f21481a.get(i2), this.f21482b);
    }

    public final int getItemCount() {
        List<BookingInfo> list = this.f21481a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
