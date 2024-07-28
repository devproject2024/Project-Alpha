package com.squareup.timessquare.v2;

import android.view.ContextThemeWrapper;
import android.widget.TextView;
import com.squareup.timessquare.R;

public final class b implements a {
    public final void a(CalendarCellView calendarCellView) {
        TextView textView = new TextView(new ContextThemeWrapper(calendarCellView.getContext(), R.style.CalendarCell_CalendarDate));
        textView.setDuplicateParentStateEnabled(true);
        calendarCellView.addView(textView);
        calendarCellView.setDayOfMonthTextView(textView);
    }
}
