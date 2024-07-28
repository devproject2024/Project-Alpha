package com.travel.train.helper;

import android.content.Context;
import android.graphics.Color;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.squareup.timessquare.v4.a;
import com.travel.train.model.searchResult.CalendarData;
import com.travel.train.model.trainticket.CJRTrainHoliday;
import java.util.Date;
import java.util.HashMap;

public final class p implements a {

    /* renamed from: a  reason: collision with root package name */
    private final Context f27438a;

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<String, CJRTrainHoliday> f27439b;

    /* renamed from: c  reason: collision with root package name */
    private int f27440c;

    /* renamed from: d  reason: collision with root package name */
    private Date f27441d;

    /* renamed from: e  reason: collision with root package name */
    private String f27442e;

    /* renamed from: f  reason: collision with root package name */
    private Boolean f27443f;

    /* renamed from: g  reason: collision with root package name */
    private String f27444g;

    /* renamed from: h  reason: collision with root package name */
    private Boolean f27445h;

    /* renamed from: i  reason: collision with root package name */
    private HashMap<String, CalendarData> f27446i;

    public p(Context context, HashMap<String, CJRTrainHoliday> hashMap, Date date, int i2, String str, Boolean bool, HashMap<String, CalendarData> hashMap2, String str2, Boolean bool2) {
        this.f27438a = context;
        this.f27441d = date;
        this.f27439b = hashMap;
        this.f27440c = i2;
        this.f27442e = str;
        this.f27443f = bool;
        this.f27444g = str2;
        this.f27445h = bool2;
        this.f27446i = hashMap2;
    }

    private void a(RelativeLayout relativeLayout, TextView textView, CalendarData calendarData) {
        if (this.f27444g == null) {
            textView.setVisibility(0);
            textView.setText(calendarData.getStatus());
            relativeLayout.setBackgroundColor(Color.parseColor(calendarData.getBackground_color()));
            textView.setTextColor(Color.parseColor(calendarData.getText_colour()));
        } else if (calendarData.getClassTypeCalendar().equals(this.f27444g)) {
            textView.setVisibility(0);
            textView.setText(calendarData.getStatus());
            relativeLayout.setBackgroundColor(Color.parseColor(calendarData.getBackground_color()));
            textView.setTextColor(Color.parseColor(calendarData.getText_colour()));
        }
    }

    private static String a(String str) {
        while (str.length() > 1 && str.indexOf("0") == 0) {
            str = str.substring(1);
        }
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x019b A[Catch:{ Exception -> 0x01f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x019d A[Catch:{ Exception -> 0x01f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01aa A[Catch:{ Exception -> 0x01f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01c2 A[Catch:{ Exception -> 0x01f5 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.squareup.timessquare.v4.CalendarCellView r17, java.util.Date r18) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            r2 = r18
            java.text.SimpleDateFormat r3 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x01f5 }
            java.lang.String r4 = "dd"
            java.util.Locale r5 = java.util.Locale.ENGLISH     // Catch:{ Exception -> 0x01f5 }
            r3.<init>(r4, r5)     // Catch:{ Exception -> 0x01f5 }
            java.lang.String r3 = r3.format(r2)     // Catch:{ Exception -> 0x01f5 }
            java.lang.String r3 = a(r3)     // Catch:{ Exception -> 0x01f5 }
            java.text.SimpleDateFormat r4 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x01f5 }
            java.lang.String r5 = "yyyy-MM-dd"
            java.util.Locale r6 = java.util.Locale.ENGLISH     // Catch:{ Exception -> 0x01f5 }
            r4.<init>(r5, r6)     // Catch:{ Exception -> 0x01f5 }
            java.lang.String r4 = r4.format(r2)     // Catch:{ Exception -> 0x01f5 }
            java.text.SimpleDateFormat r5 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x01f5 }
            java.lang.String r6 = "yyyyMMdd"
            java.util.Locale r7 = java.util.Locale.ENGLISH     // Catch:{ Exception -> 0x01f5 }
            r5.<init>(r6, r7)     // Catch:{ Exception -> 0x01f5 }
            java.lang.String r5 = r5.format(r2)     // Catch:{ Exception -> 0x01f5 }
            int r6 = com.travel.train.R.id.train_calendar_custom_date_cell     // Catch:{ Exception -> 0x01f5 }
            android.view.View r6 = r0.findViewById(r6)     // Catch:{ Exception -> 0x01f5 }
            android.widget.TextView r6 = (android.widget.TextView) r6     // Catch:{ Exception -> 0x01f5 }
            int r7 = com.travel.train.R.id.lyt_train_cell     // Catch:{ Exception -> 0x01f5 }
            android.view.View r7 = r0.findViewById(r7)     // Catch:{ Exception -> 0x01f5 }
            android.widget.RelativeLayout r7 = (android.widget.RelativeLayout) r7     // Catch:{ Exception -> 0x01f5 }
            int r8 = com.travel.train.R.id.availability_text     // Catch:{ Exception -> 0x01f5 }
            android.view.View r8 = r0.findViewById(r8)     // Catch:{ Exception -> 0x01f5 }
            android.widget.TextView r8 = (android.widget.TextView) r8     // Catch:{ Exception -> 0x01f5 }
            int r9 = com.travel.train.R.id.refresh_icon     // Catch:{ Exception -> 0x01f5 }
            android.view.View r9 = r0.findViewById(r9)     // Catch:{ Exception -> 0x01f5 }
            android.widget.ImageView r9 = (android.widget.ImageView) r9     // Catch:{ Exception -> 0x01f5 }
            android.view.View r10 = r17.getFlightMarker()     // Catch:{ Exception -> 0x01f5 }
            r11 = 0
            r10.setVisibility(r11)     // Catch:{ Exception -> 0x01f5 }
            r7.setBackgroundResource(r11)     // Catch:{ Exception -> 0x01f5 }
            java.lang.String r10 = ""
            r8.setText(r10)     // Catch:{ Exception -> 0x01f5 }
            r10 = 8
            r9.setVisibility(r10)     // Catch:{ Exception -> 0x01f5 }
            android.widget.TextView r12 = r17.getDayOfMonthTextView()     // Catch:{ Exception -> 0x01f5 }
            r13 = 1
            r14 = 0
            r12.setTypeface(r14, r13)     // Catch:{ Exception -> 0x01f5 }
            boolean r12 = r17.isSelected()     // Catch:{ Exception -> 0x01f5 }
            if (r12 != 0) goto L_0x009a
            android.widget.TextView r12 = r17.getDayOfMonthTextView()     // Catch:{ Exception -> 0x01f5 }
            android.content.Context r15 = r1.f27438a     // Catch:{ Exception -> 0x01f5 }
            android.content.res.Resources r15 = r15.getResources()     // Catch:{ Exception -> 0x01f5 }
            int r14 = com.travel.train.R.color.train_flight_calender_date_text_color_new     // Catch:{ Exception -> 0x01f5 }
            android.content.res.ColorStateList r14 = r15.getColorStateList(r14)     // Catch:{ Exception -> 0x01f5 }
            r12.setTextColor(r14)     // Catch:{ Exception -> 0x01f5 }
            android.view.View r12 = r17.getFlightMarker()     // Catch:{ Exception -> 0x01f5 }
            android.content.Context r14 = r1.f27438a     // Catch:{ Exception -> 0x01f5 }
            int r15 = com.travel.train.R.color.fareCalender_line1     // Catch:{ Exception -> 0x01f5 }
            int r14 = androidx.core.content.b.c(r14, r15)     // Catch:{ Exception -> 0x01f5 }
            r12.setBackgroundColor(r14)     // Catch:{ Exception -> 0x01f5 }
            goto L_0x00ae
        L_0x009a:
            int r12 = com.travel.train.R.drawable.pre_t_train_round_rectangle_blue_filled     // Catch:{ Exception -> 0x01f5 }
            r7.setBackgroundResource(r12)     // Catch:{ Exception -> 0x01f5 }
            android.widget.TextView r12 = r17.getDayOfMonthTextView()     // Catch:{ Exception -> 0x01f5 }
            android.content.Context r14 = r1.f27438a     // Catch:{ Exception -> 0x01f5 }
            int r15 = com.travel.train.R.color.white     // Catch:{ Exception -> 0x01f5 }
            int r14 = androidx.core.content.b.c(r14, r15)     // Catch:{ Exception -> 0x01f5 }
            r12.setTextColor(r14)     // Catch:{ Exception -> 0x01f5 }
        L_0x00ae:
            java.lang.String r12 = r1.f27442e     // Catch:{ Exception -> 0x01f5 }
            boolean r12 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x01f5 }
            if (r12 != 0) goto L_0x00c6
            java.lang.String r12 = r1.f27442e     // Catch:{ Exception -> 0x01f5 }
            int r14 = r18.getDay()     // Catch:{ Exception -> 0x01f5 }
            char r12 = r12.charAt(r14)     // Catch:{ Exception -> 0x01f5 }
            r14 = 78
            if (r12 != r14) goto L_0x00c6
            r12 = 1
            goto L_0x00c7
        L_0x00c6:
            r12 = 0
        L_0x00c7:
            java.util.Date r14 = r1.f27441d     // Catch:{ Exception -> 0x01f5 }
            int r15 = r1.f27440c     // Catch:{ Exception -> 0x01f5 }
            java.util.Date r14 = com.travel.train.j.i.a((java.util.Date) r14, (int) r15)     // Catch:{ Exception -> 0x01f5 }
            if (r2 == 0) goto L_0x00e5
            java.util.Date r15 = r1.f27441d     // Catch:{ Exception -> 0x01f5 }
            if (r15 == 0) goto L_0x00e5
            java.util.Date r15 = com.travel.train.j.i.a((java.util.Date) r18)     // Catch:{ Exception -> 0x01f5 }
            java.util.Date r11 = r1.f27441d     // Catch:{ Exception -> 0x01f5 }
            java.util.Date r11 = com.travel.train.j.i.a((java.util.Date) r11)     // Catch:{ Exception -> 0x01f5 }
            boolean r11 = r15.before(r11)     // Catch:{ Exception -> 0x01f5 }
            if (r11 != 0) goto L_0x0159
        L_0x00e5:
            java.util.Date r11 = com.travel.train.j.i.a((java.util.Date) r18)     // Catch:{ Exception -> 0x01f5 }
            java.util.Date r14 = com.travel.train.j.i.a((java.util.Date) r14)     // Catch:{ Exception -> 0x01f5 }
            boolean r11 = r11.after(r14)     // Catch:{ Exception -> 0x01f5 }
            if (r11 != 0) goto L_0x0159
            if (r12 == 0) goto L_0x00f6
            goto L_0x0159
        L_0x00f6:
            boolean r11 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x01f5 }
            if (r11 != 0) goto L_0x0144
            boolean r11 = r0.f45661a     // Catch:{ Exception -> 0x01f5 }
            if (r11 == 0) goto L_0x0144
            java.lang.Boolean r11 = r1.f27443f     // Catch:{ Exception -> 0x01f5 }
            boolean r11 = r11.booleanValue()     // Catch:{ Exception -> 0x01f5 }
            if (r11 == 0) goto L_0x0144
            java.util.HashMap<java.lang.String, com.travel.train.model.searchResult.CalendarData> r11 = r1.f27446i     // Catch:{ Exception -> 0x01f5 }
            boolean r11 = r11.containsKey(r5)     // Catch:{ Exception -> 0x01f5 }
            if (r11 == 0) goto L_0x011a
            java.util.HashMap<java.lang.String, com.travel.train.model.searchResult.CalendarData> r11 = r1.f27446i     // Catch:{ Exception -> 0x01f5 }
            java.lang.Object r5 = r11.get(r5)     // Catch:{ Exception -> 0x01f5 }
            r14 = r5
            com.travel.train.model.searchResult.CalendarData r14 = (com.travel.train.model.searchResult.CalendarData) r14     // Catch:{ Exception -> 0x01f5 }
            goto L_0x011b
        L_0x011a:
            r14 = 0
        L_0x011b:
            if (r14 == 0) goto L_0x013d
            r9.setVisibility(r10)     // Catch:{ Exception -> 0x01f5 }
            java.lang.Boolean r5 = r1.f27445h     // Catch:{ Exception -> 0x01f5 }
            boolean r5 = r5.booleanValue()     // Catch:{ Exception -> 0x01f5 }
            if (r5 != 0) goto L_0x012c
            r1.a(r7, r8, r14)     // Catch:{ Exception -> 0x01f5 }
            goto L_0x0144
        L_0x012c:
            int r5 = r14.getAvailability_type()     // Catch:{ Exception -> 0x01f5 }
            if (r5 == r13) goto L_0x0139
            int r5 = r14.getAvailability_type()     // Catch:{ Exception -> 0x01f5 }
            r9 = 2
            if (r5 != r9) goto L_0x0144
        L_0x0139:
            r1.a(r7, r8, r14)     // Catch:{ Exception -> 0x01f5 }
            goto L_0x0144
        L_0x013d:
            r8.setVisibility(r10)     // Catch:{ Exception -> 0x01f5 }
            r5 = 0
            r9.setVisibility(r5)     // Catch:{ Exception -> 0x01f5 }
        L_0x0144:
            android.widget.TextView r5 = r17.getDayOfMonthTextView()     // Catch:{ Exception -> 0x01f5 }
            android.content.Context r9 = r1.f27438a     // Catch:{ Exception -> 0x01f5 }
            android.content.res.Resources r9 = r9.getResources()     // Catch:{ Exception -> 0x01f5 }
            int r10 = com.travel.train.R.color.train_flight_calender_date_text_color_new     // Catch:{ Exception -> 0x01f5 }
            android.content.res.ColorStateList r9 = r9.getColorStateList(r10)     // Catch:{ Exception -> 0x01f5 }
            r5.setTextColor(r9)     // Catch:{ Exception -> 0x01f5 }
            r5 = 0
            goto L_0x016c
        L_0x0159:
            android.widget.TextView r5 = r17.getDayOfMonthTextView()     // Catch:{ Exception -> 0x01f5 }
            android.content.Context r9 = r1.f27438a     // Catch:{ Exception -> 0x01f5 }
            int r10 = com.travel.train.R.color.fareCalender_line1     // Catch:{ Exception -> 0x01f5 }
            int r9 = androidx.core.content.b.c(r9, r10)     // Catch:{ Exception -> 0x01f5 }
            r5.setTextColor(r9)     // Catch:{ Exception -> 0x01f5 }
            r5 = 0
            r0.setClickable(r5)     // Catch:{ Exception -> 0x01f5 }
        L_0x016c:
            boolean r9 = r17.isSelected()     // Catch:{ Exception -> 0x01f5 }
            if (r9 == 0) goto L_0x0197
            java.lang.Boolean r9 = r1.f27443f     // Catch:{ Exception -> 0x01f5 }
            boolean r9 = r9.booleanValue()     // Catch:{ Exception -> 0x01f5 }
            if (r9 == 0) goto L_0x0197
            r7.setBackgroundResource(r5)     // Catch:{ Exception -> 0x01f5 }
            android.widget.TextView r5 = r17.getDayOfMonthTextView()     // Catch:{ Exception -> 0x01f5 }
            android.content.Context r7 = r1.f27438a     // Catch:{ Exception -> 0x01f5 }
            int r9 = com.travel.train.R.color.white     // Catch:{ Exception -> 0x01f5 }
            int r7 = androidx.core.content.b.c(r7, r9)     // Catch:{ Exception -> 0x01f5 }
            r5.setTextColor(r7)     // Catch:{ Exception -> 0x01f5 }
            android.content.Context r5 = r1.f27438a     // Catch:{ Exception -> 0x01f5 }
            int r7 = com.travel.train.R.color.white     // Catch:{ Exception -> 0x01f5 }
            int r5 = androidx.core.content.b.c(r5, r7)     // Catch:{ Exception -> 0x01f5 }
            r8.setTextColor(r5)     // Catch:{ Exception -> 0x01f5 }
        L_0x0197:
            java.util.HashMap<java.lang.String, com.travel.train.model.trainticket.CJRTrainHoliday> r5 = r1.f27439b     // Catch:{ Exception -> 0x01f5 }
            if (r5 != 0) goto L_0x019d
            r14 = 0
            goto L_0x01a6
        L_0x019d:
            java.util.HashMap<java.lang.String, com.travel.train.model.trainticket.CJRTrainHoliday> r5 = r1.f27439b     // Catch:{ Exception -> 0x01f5 }
            java.lang.Object r4 = r5.get(r4)     // Catch:{ Exception -> 0x01f5 }
            r14 = r4
            com.travel.train.model.trainticket.CJRTrainHoliday r14 = (com.travel.train.model.trainticket.CJRTrainHoliday) r14     // Catch:{ Exception -> 0x01f5 }
        L_0x01a6:
            boolean r4 = r0.f45661a     // Catch:{ Exception -> 0x01f5 }
            if (r4 != 0) goto L_0x01c2
            android.widget.TextView r2 = r17.getDayOfMonthTextView()     // Catch:{ Exception -> 0x01f5 }
            android.content.Context r3 = r1.f27438a     // Catch:{ Exception -> 0x01f5 }
            int r4 = com.travel.train.R.color.white     // Catch:{ Exception -> 0x01f5 }
            int r3 = androidx.core.content.b.c(r3, r4)     // Catch:{ Exception -> 0x01f5 }
            r2.setTextColor(r3)     // Catch:{ Exception -> 0x01f5 }
            android.view.View r0 = r17.getFlightMarker()     // Catch:{ Exception -> 0x01f5 }
            r2 = 0
            r0.setBackgroundResource(r2)     // Catch:{ Exception -> 0x01f5 }
            return
        L_0x01c2:
            if (r6 == 0) goto L_0x01f4
            r4 = 0
            r6.setText(r4)     // Catch:{ Exception -> 0x01f5 }
            r6.setText(r3)     // Catch:{ Exception -> 0x01f5 }
            r6.setTag(r2)     // Catch:{ Exception -> 0x01f5 }
            android.view.View r2 = r17.getFlightMarker()     // Catch:{ Exception -> 0x01f5 }
            if (r2 == 0) goto L_0x01f4
            if (r14 == 0) goto L_0x01db
            java.lang.String r14 = r14.getName()     // Catch:{ Exception -> 0x01f5 }
            goto L_0x01dc
        L_0x01db:
            r14 = r4
        L_0x01dc:
            boolean r2 = android.text.TextUtils.isEmpty(r14)     // Catch:{ Exception -> 0x01f5 }
            if (r2 == 0) goto L_0x01eb
            android.view.View r0 = r17.getFlightMarker()     // Catch:{ Exception -> 0x01f5 }
            r2 = 0
            r0.setBackgroundResource(r2)     // Catch:{ Exception -> 0x01f5 }
            return
        L_0x01eb:
            android.view.View r0 = r17.getFlightMarker()     // Catch:{ Exception -> 0x01f5 }
            int r2 = com.travel.train.R.drawable.pre_t_train_blue_circle     // Catch:{ Exception -> 0x01f5 }
            r0.setBackgroundResource(r2)     // Catch:{ Exception -> 0x01f5 }
        L_0x01f4:
            return
        L_0x01f5:
            r0 = move-exception
            java.io.PrintStream r2 = java.lang.System.out
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "exception FlightCalendarCellDecorator "
            r3.<init>(r4)
            java.lang.String r0 = r0.getMessage()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.println(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.helper.p.a(com.squareup.timessquare.v4.CalendarCellView, java.util.Date):void");
    }
}
