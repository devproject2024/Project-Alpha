package com.travel.calendar.b;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.b;
import com.squareup.timessquare.v3.CalendarCellView;
import com.travel.R;
import com.travel.calendar.h;
import com.travel.model.CalendarHoliday;
import com.travel.utils.g;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public final class a implements com.squareup.timessquare.v3.a {

    /* renamed from: a  reason: collision with root package name */
    private final Context f22994a;

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<String, CalendarHoliday> f22995b;

    /* renamed from: c  reason: collision with root package name */
    private int f22996c;

    /* renamed from: d  reason: collision with root package name */
    private Date f22997d;

    /* renamed from: e  reason: collision with root package name */
    private String f22998e;

    public a(Context context, HashMap<String, CalendarHoliday> hashMap, Date date, int i2, String str) {
        this.f22994a = context;
        this.f22997d = date;
        this.f22995b = hashMap;
        this.f22996c = i2;
        this.f22998e = str;
    }

    private static String a(String str) {
        while (str.length() > 1 && str.indexOf("0") == 0) {
            str = str.substring(1);
        }
        return str;
    }

    public final void a(CalendarCellView calendarCellView, Date date) {
        try {
            String a2 = a(new SimpleDateFormat("dd", Locale.ENGLISH).format(date));
            String format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(date);
            TextView textView = (TextView) calendarCellView.findViewById(R.id.train_calendar_custom_date_cell);
            RelativeLayout relativeLayout = (RelativeLayout) calendarCellView.findViewById(R.id.lyt_train_cell);
            calendarCellView.getFlightMarker().setVisibility(0);
            relativeLayout.setBackgroundResource(0);
            boolean z = true;
            String str = null;
            calendarCellView.getDayOfMonthTextView().setTypeface((Typeface) null, 1);
            if (!calendarCellView.isSelected()) {
                calendarCellView.getDayOfMonthTextView().setTextColor(this.f22994a.getResources().getColorStateList(R.color.train_calendar_cell_date_color));
                calendarCellView.getFlightMarker().setBackgroundColor(b.c(this.f22994a, R.color.calendar_fareCalender_line1));
            } else {
                relativeLayout.setBackgroundResource(R.drawable.pre_round_cornered_blue_stroke_10dp);
                calendarCellView.getDayOfMonthTextView().setTextColor(b.c(this.f22994a, R.color.white));
            }
            if (TextUtils.isEmpty(this.f22998e) || this.f22998e.charAt(date.getDay()) != 'N') {
                z = false;
            }
            Date a3 = g.a(this.f22997d, this.f22996c);
            if (!(date == null || this.f22997d == null || !h.a(date).before(h.a(this.f22997d))) || h.a(date).after(h.a(a3)) || z) {
                calendarCellView.getDayOfMonthTextView().setTextColor(b.c(this.f22994a, R.color.calendar_fareCalender_line1));
                calendarCellView.setClickable(false);
            }
            CalendarHoliday calendarHoliday = this.f22995b == null ? null : this.f22995b.get(format);
            if (!calendarCellView.f45607a) {
                calendarCellView.getDayOfMonthTextView().setTextColor(b.c(this.f22994a, R.color.white));
                calendarCellView.getFlightMarker().setBackgroundResource(0);
            } else if (textView != null) {
                textView.setText((CharSequence) null);
                textView.setText(a2);
                textView.setTag(date);
                if (!TextUtils.isEmpty(a2) && !calendarCellView.isSelected()) {
                    relativeLayout.setBackgroundResource(R.drawable.pre_tc_train_rect_grey_stroke_6dp);
                }
                if (calendarCellView.getFlightMarker() != null) {
                    if (calendarHoliday != null) {
                        str = calendarHoliday.getName();
                    }
                    if (TextUtils.isEmpty(str)) {
                        calendarCellView.getFlightMarker().setBackgroundResource(0);
                    } else {
                        calendarCellView.getFlightMarker().setBackgroundResource(R.drawable.pre_blue_circle);
                    }
                }
            }
        } catch (Exception e2) {
            PrintStream printStream = System.out;
            printStream.println("exception FlightCalendarCellDecorator " + e2.getMessage());
        }
    }
}
