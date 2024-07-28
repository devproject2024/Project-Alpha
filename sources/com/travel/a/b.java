package com.travel.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.squareup.timessquare.v3.CalendarCellView;
import com.travel.R;
import kotlin.g.b.k;
import kotlin.u;

public final class b implements com.squareup.timessquare.v3.b {
    public final void a(CalendarCellView calendarCellView) {
        k.c(calendarCellView, "parent");
        View inflate = LayoutInflater.from(calendarCellView.getContext()).inflate(R.layout.pre_calender_custom_cell, (ViewGroup) null, false);
        calendarCellView.addView(inflate);
        View findViewById = inflate.findViewById(R.id.flight_calendar_custom_date_cell);
        if (findViewById != null) {
            calendarCellView.setDayOfMonthTextView((TextView) findViewById);
            View findViewById2 = inflate.findViewById(R.id.flight_calendar_custom_price_cell);
            if (findViewById2 != null) {
                calendarCellView.setPriceTextView((TextView) findViewById2);
                calendarCellView.setFlightMarker(inflate.findViewById(R.id.flight_holiday_marker));
                return;
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
        throw new u("null cannot be cast to non-null type android.widget.TextView");
    }
}
