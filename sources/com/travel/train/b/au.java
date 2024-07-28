package com.travel.train.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.squareup.timessquare.v4.CalendarCellView;
import com.squareup.timessquare.v4.b;
import com.travel.train.R;

public final class au implements b {
    public final void a(CalendarCellView calendarCellView) {
        View inflate = LayoutInflater.from(calendarCellView.getContext()).inflate(R.layout.pre_t_train_120_days_calender_custom_cell, (ViewGroup) null, false);
        calendarCellView.addView(inflate);
        calendarCellView.setDayOfMonthTextView((TextView) inflate.findViewById(R.id.train_calendar_custom_date_cell));
        calendarCellView.setFlightMarker(inflate.findViewById(R.id.train_holiday_marker));
    }
}
