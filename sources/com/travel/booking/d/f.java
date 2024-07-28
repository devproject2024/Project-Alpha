package com.travel.booking.d;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.R;

public final class f {
    public static RecyclerView.v a(int i2, ViewGroup viewGroup) {
        if (i2 == j.VIEW_TYPE_BUS_CANCELLED.ordinal()) {
            return new b(androidx.databinding.f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.row_mybooking_bus_upcoming, viewGroup, false));
        }
        if (i2 == j.VIEW_TYPE_BUS_COMPLETED.ordinal()) {
            return new b(androidx.databinding.f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.row_mybooking_bus_upcoming, viewGroup, false));
        }
        if (i2 == j.VIEW_TYPE_BUS_UPCOMING.ordinal()) {
            return new b(androidx.databinding.f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.row_mybooking_bus_upcoming, viewGroup, false));
        }
        if (i2 == j.VIEW_TYPE_TRAIN_CANCELLED.ordinal()) {
            return new e(androidx.databinding.f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.row_mybooking_train_upcoming, viewGroup, false));
        }
        if (i2 == j.VIEW_TYPE_TRAIN_COMPLETED.ordinal()) {
            return new e(androidx.databinding.f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.row_mybooking_train_upcoming, viewGroup, false));
        }
        if (i2 == j.VIEW_TYPE_TRAIN_UPCOMING.ordinal()) {
            return new e(androidx.databinding.f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.row_mybooking_train_upcoming, viewGroup, false));
        }
        if (i2 == j.VIEW_TYPE_FLIGHT_CANCELLED.ordinal()) {
            return new c(androidx.databinding.f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.row_mybooking_flight_upcoming, viewGroup, false));
        }
        if (i2 == j.VIEW_TYPE_FLIGHT_COMPLETED.ordinal()) {
            return new c(androidx.databinding.f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.row_mybooking_flight_upcoming, viewGroup, false));
        }
        if (i2 == j.VIEW_TYPE_FLIGHT_UPCOMING.ordinal()) {
            return new c(androidx.databinding.f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.row_mybooking_flight_upcoming, viewGroup, false));
        }
        if (i2 == j.VIEW_TYPE_HOTEL_UPCOMING.ordinal()) {
            return new d(androidx.databinding.f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.row_mybooking_hotel_upcoming, viewGroup, false));
        }
        if (i2 == j.VIEW_TYPE_HOTEL_CANCELLED.ordinal()) {
            return new d(androidx.databinding.f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.row_mybooking_hotel_upcoming, viewGroup, false));
        }
        if (i2 == j.VIEW_TYPE_HOTEL_COMPLETED.ordinal()) {
            return new d(androidx.databinding.f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.row_mybooking_hotel_upcoming, viewGroup, false));
        }
        if (i2 == j.VIEW_TYPE_CITY_BUS_UPCOMING.ordinal() || i2 == j.VIEW_TYPE_CITY_BUS_COMPLETED.ordinal() || i2 == j.VIEW_TYPE_CITY_BUS_CANCELLED.ordinal()) {
            return new d(androidx.databinding.f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.row_mybooking_city_bus_upcoming, viewGroup, false));
        }
        return null;
    }
}
