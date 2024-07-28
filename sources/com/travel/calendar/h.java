package com.travel.calendar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.b;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.view.fragment.FilterPriceSliderFragment;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.squareup.timessquare.v3.CalendarCellView;
import com.travel.R;
import com.travel.model.CalendarDatePriceInfo;
import com.travel.model.CalendarHoliday;
import com.travel.utils.DottedProgressBarCalendar;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public final class h implements com.squareup.timessquare.v3.a {

    /* renamed from: a  reason: collision with root package name */
    private String f23023a = "FlightCalendarCellDecorator";

    /* renamed from: b  reason: collision with root package name */
    private Context f23024b;

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<String, CalendarDatePriceInfo> f23025c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f23026d;

    /* renamed from: e  reason: collision with root package name */
    private final Handler f23027e;

    /* renamed from: f  reason: collision with root package name */
    private final HashMap<String, CalendarHoliday> f23028f;

    /* renamed from: g  reason: collision with root package name */
    private Date f23029g;

    /* renamed from: h  reason: collision with root package name */
    private DottedProgressBarCalendar f23030h;

    public h(Context context, HashMap<String, CalendarDatePriceInfo> hashMap, boolean z, Handler handler, HashMap<String, CalendarHoliday> hashMap2) {
        this.f23024b = context;
        this.f23025c = hashMap;
        this.f23029g = Calendar.getInstance().getTime();
        this.f23026d = z;
        this.f23027e = handler;
        this.f23028f = hashMap2;
    }

    private static String a(String str) {
        while (str.length() > 1 && str.indexOf("0") == 0) {
            str = str.substring(1);
        }
        return str;
    }

    public static Date a(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        return instance.getTime();
    }

    private ColorStateList a(int i2) {
        Context context = this.f23024b;
        if (context == null) {
            return null;
        }
        return new ColorStateList(new int[][]{new int[]{16842919}, new int[]{-16842913}}, new int[]{b.c(context, R.color.white), i2});
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<DottedProgressBarCalendar> f23031a;

        /* renamed from: b  reason: collision with root package name */
        private final int f23032b;

        protected a(DottedProgressBarCalendar dottedProgressBarCalendar, int i2) {
            this.f23031a = new WeakReference<>(dottedProgressBarCalendar);
            this.f23032b = i2;
        }

        public final void run() {
            DottedProgressBarCalendar dottedProgressBarCalendar = (DottedProgressBarCalendar) this.f23031a.get();
            if (dottedProgressBarCalendar != null) {
                dottedProgressBarCalendar.setVisibility(this.f23032b);
            }
        }
    }

    public final void a(CalendarCellView calendarCellView, Date date) {
        String str;
        try {
            String a2 = a(new SimpleDateFormat("dd", Locale.ENGLISH).format(date));
            String format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(date);
            TextView textView = (TextView) calendarCellView.findViewById(R.id.flight_calendar_custom_date_cell);
            TextView textView2 = (TextView) calendarCellView.findViewById(R.id.flight_calendar_custom_price_cell);
            RelativeLayout relativeLayout = (RelativeLayout) calendarCellView.findViewById(R.id.flight_cell_lyt);
            this.f23030h = (DottedProgressBarCalendar) calendarCellView.findViewById(R.id.progressBar);
            calendarCellView.getFlightMarker().setVisibility(0);
            relativeLayout.setBackgroundResource(0);
            String str2 = null;
            calendarCellView.getDayOfMonthTextView().setTypeface((Typeface) null, 1);
            if ((date == null || this.f23029g == null || !a(date).before(a(this.f23029g))) && calendarCellView != null && calendarCellView.f45607a) {
                this.f23030h.setVisibility(0);
                this.f23030h.a();
            } else {
                this.f23030h.setVisibility(8);
            }
            if (!calendarCellView.isSelected()) {
                calendarCellView.getDayOfMonthTextView().setTextColor(this.f23024b.getResources().getColorStateList(R.color.calender_date_text_color));
                calendarCellView.getFlightMarker().setBackgroundColor(b.c(this.f23024b, R.color.calendar_fareCalender_line1));
            } else {
                calendarCellView.getDayOfMonthTextView().setTextColor(b.c(this.f23024b, R.color.white));
            }
            if (date != null && this.f23029g != null && a(date).before(a(this.f23029g)) && calendarCellView.f45607a) {
                calendarCellView.getDayOfMonthTextView().setTextColor(b.c(this.f23024b, R.color.calendar_fareCalender_line1));
                relativeLayout.setBackgroundResource(R.drawable.pre_rounded_rect_with_9dp_radius);
            }
            if (this.f23030h != null) {
                if (this.f23026d) {
                    this.f23030h.b();
                    this.f23030h.setVisibility(8);
                } else if (calendarCellView.f45607a) {
                    this.f23027e.post(new a(this.f23030h, 0));
                } else {
                    this.f23027e.post(new a(this.f23030h, 8));
                }
            }
            CalendarDatePriceInfo calendarDatePriceInfo = this.f23025c == null ? null : this.f23025c.get(format);
            CalendarHoliday calendarHoliday = this.f23028f == null ? null : this.f23028f.get(format);
            if (textView2 != null) {
                textView2.setText("");
            }
            if (!calendarCellView.f45607a) {
                calendarCellView.getDayOfMonthTextView().setTextColor(b.c(this.f23024b, R.color.white));
                calendarCellView.getFlightMarker().setBackgroundResource(0);
            } else if (textView != null) {
                textView.setText((CharSequence) null);
                textView.setText(a2);
                textView.setTag(date);
                if (textView2 != null) {
                    textView2.setVisibility(0);
                    if (!calendarCellView.isSelected()) {
                        calendarCellView.getPriceTextview().setTextColor(a(b.c(this.f23024b, R.color.hotel_grey)));
                    } else {
                        calendarCellView.getPriceTextview().setTextColor(b.c(this.f23024b, R.color.white));
                    }
                    if (calendarDatePriceInfo != null) {
                        str = calendarDatePriceInfo.getFare() != -1 ? String.valueOf(calendarDatePriceInfo.getFare()) : null;
                        if (!TextUtils.isEmpty(str)) {
                            if (str.length() > 3) {
                                str = str.substring(0, str.length() - 3) + AppConstants.COMMA + str.substring(str.length() - 3, str.length());
                            }
                        }
                        if (!TextUtils.isEmpty(str) && str.length() > 6) {
                            str = str.substring(0, str.length() - 6) + AppConstants.COMMA + str.substring(str.length() - 6, str.length());
                        }
                        if (!TextUtils.isEmpty(str)) {
                            str = FilterPriceSliderFragment.RUPEE_SYMBOL.concat(String.valueOf(str));
                            if (!calendarCellView.isSelected()) {
                                calendarCellView.getPriceTextview().setTextColor(a(Color.parseColor("#" + calendarDatePriceInfo.getColorCode())));
                                calendarCellView.getPriceTextview().setVisibility(0);
                            } else {
                                calendarCellView.getPriceTextview().setTextColor(b.c(this.f23024b, R.color.white));
                                if (calendarDatePriceInfo.getFare() == 0) {
                                    calendarCellView.getPriceTextview().setVisibility(4);
                                }
                            }
                        }
                    } else {
                        str = null;
                    }
                    textView2.setText((CharSequence) null);
                    textView2.setText(str);
                    textView2.setTag(date);
                }
                if (calendarCellView.getFlightMarker() != null) {
                    if (calendarHoliday != null) {
                        str2 = calendarHoliday.getName();
                    }
                    if (TextUtils.isEmpty(str2)) {
                        calendarCellView.getFlightMarker().setBackgroundResource(0);
                    } else {
                        calendarCellView.getFlightMarker().setBackgroundResource(R.drawable.pre_blue_circle);
                    }
                }
            }
        } catch (Exception e2) {
            System.out.println("exception FlightCalendarCellDecorator " + e2.getMessage());
            q.c(e2.getMessage());
        }
    }
}
