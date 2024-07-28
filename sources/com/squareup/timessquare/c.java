package com.squareup.timessquare;

import android.view.ContextThemeWrapper;
import android.widget.TextView;

public final class c implements b {
    public final void a(CalendarCellView calendarCellView) {
        TextView textView = new TextView(new ContextThemeWrapper(calendarCellView.getContext(), R.style.CalendarCell_CalendarDate));
        textView.setDuplicateParentStateEnabled(true);
        calendarCellView.addView(textView);
        calendarCellView.setDayOfMonthTextView(textView);
    }
}
