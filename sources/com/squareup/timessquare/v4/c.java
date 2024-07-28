package com.squareup.timessquare.v4;

import android.view.ContextThemeWrapper;
import android.widget.TextView;
import com.squareup.timessquare.R;

public final class c implements b {
    public final void a(CalendarCellView calendarCellView) {
        TextView textView = new TextView(new ContextThemeWrapper(calendarCellView.getContext(), R.style.CalendarCell_CalendarDate));
        textView.setDuplicateParentStateEnabled(true);
        calendarCellView.addView(textView);
        calendarCellView.setDayOfMonthTextView(textView);
    }
}
