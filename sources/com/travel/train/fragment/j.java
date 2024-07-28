package com.travel.train.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.n;
import com.paytm.utility.q;
import com.squareup.timessquare.v4.CalendarPickerView;
import com.travel.train.R;
import com.travel.train.j.i;
import com.travel.train.j.o;
import com.travel.train.j.r;
import com.travel.train.k.b;
import com.travel.train.model.searchResult.CalendarData;
import com.travel.train.model.trainticket.CJRTrainHoliday;
import com.travel.train.model.trainticket.CJRTrainHolidayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import kotlin.g.b.k;
import kotlin.m.p;

public final class j extends am implements CalendarPickerView.h, r.a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f27027a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private String f27028b;

    /* renamed from: c  reason: collision with root package name */
    private String f27029c;

    /* renamed from: d  reason: collision with root package name */
    private String f27030d;

    /* renamed from: e  reason: collision with root package name */
    private Date f27031e;

    /* renamed from: f  reason: collision with root package name */
    private Date f27032f;

    /* renamed from: g  reason: collision with root package name */
    private long f27033g;

    /* renamed from: h  reason: collision with root package name */
    private Locale f27034h;

    /* renamed from: i  reason: collision with root package name */
    private String f27035i;
    private CJRTrainHolidayList j;
    private Date k;
    private int l = 124;
    private String m;
    private b n;
    private boolean o;
    private List<CalendarData> p;
    private String q;
    private Boolean r = Boolean.FALSE;
    private HashMap<String, CalendarData> s;
    private final String t = "FJRTrain120DaysCalendarView";
    private HashMap u;

    private View a(int i2) {
        if (this.u == null) {
            this.u = new HashMap();
        }
        View view = (View) this.u.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.u.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.pre_t_train_120_days_calendar_layout, viewGroup, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:210:0x04e5 A[Catch:{ Exception -> 0x0519 }] */
    /* JADX WARNING: Removed duplicated region for block: B:238:? A[Catch:{ Exception -> 0x0519 }, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r20, android.os.Bundle r21) {
        /*
            r19 = this;
            r1 = r19
            java.lang.String r0 = "view"
            r2 = r20
            kotlin.g.b.k.c(r2, r0)
            super.onViewCreated(r20, r21)
            android.os.Bundle r0 = r19.getArguments()
            r2 = 1
            if (r0 == 0) goto L_0x002d
            java.lang.String r3 = "running_on"
            boolean r0 = r0.containsKey(r3)
            if (r0 != r2) goto L_0x002d
            android.os.Bundle r0 = r19.getArguments()
            if (r0 != 0) goto L_0x0025
            kotlin.g.b.k.a()
        L_0x0025:
            java.lang.Object r0 = r0.get(r3)
            java.lang.String r0 = (java.lang.String) r0
            r1.m = r0
        L_0x002d:
            android.os.Bundle r0 = r19.getArguments()
            java.lang.String r3 = "date"
            if (r0 == 0) goto L_0x005b
            boolean r0 = r0.containsKey(r3)
            if (r0 != r2) goto L_0x005b
            android.os.Bundle r0 = r19.getArguments()
            if (r0 != 0) goto L_0x0044
            kotlin.g.b.k.a()
        L_0x0044:
            java.lang.Object r0 = r0.get(r3)
            if (r0 == 0) goto L_0x0053
            java.lang.Long r0 = (java.lang.Long) r0
            long r4 = r0.longValue()
            r1.f27033g = r4
            goto L_0x005b
        L_0x0053:
            kotlin.u r0 = new kotlin.u
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.Long"
            r0.<init>(r2)
            throw r0
        L_0x005b:
            android.os.Bundle r0 = r19.getArguments()
            r4 = 0
            if (r0 == 0) goto L_0x006a
            java.lang.String r5 = "selected_date"
            java.lang.Object r0 = r0.get(r5)
            goto L_0x006b
        L_0x006a:
            r0 = r4
        L_0x006b:
            java.lang.String r0 = (java.lang.String) r0
            r1.f27035i = r0
            android.os.Bundle r0 = r19.getArguments()
            if (r0 == 0) goto L_0x007c
            java.lang.String r5 = "extra_intent_holiday_list"
            java.lang.Object r0 = r0.get(r5)
            goto L_0x007d
        L_0x007c:
            r0 = r4
        L_0x007d:
            com.travel.train.model.trainticket.CJRTrainHolidayList r0 = (com.travel.train.model.trainticket.CJRTrainHolidayList) r0
            r1.j = r0
            android.os.Bundle r0 = r19.getArguments()
            java.lang.String r5 = "for_120_days"
            if (r0 == 0) goto L_0x0092
            boolean r0 = r0.containsKey(r5)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x0093
        L_0x0092:
            r0 = r4
        L_0x0093:
            if (r0 != 0) goto L_0x0098
            kotlin.g.b.k.a()
        L_0x0098:
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x00bd
            android.os.Bundle r0 = r19.getArguments()
            if (r0 == 0) goto L_0x00a9
            java.lang.Object r0 = r0.get(r5)
            goto L_0x00aa
        L_0x00a9:
            r0 = r4
        L_0x00aa:
            if (r0 == 0) goto L_0x00b5
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1.o = r0
            goto L_0x00bd
        L_0x00b5:
            kotlin.u r0 = new kotlin.u
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.Boolean"
            r0.<init>(r2)
            throw r0
        L_0x00bd:
            android.os.Bundle r0 = r19.getArguments()
            java.lang.String r5 = "calendar_data_list"
            if (r0 == 0) goto L_0x00ce
            boolean r0 = r0.containsKey(r5)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x00cf
        L_0x00ce:
            r0 = r4
        L_0x00cf:
            if (r0 != 0) goto L_0x00d4
            kotlin.g.b.k.a()
        L_0x00d4:
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0144
            android.os.Bundle r0 = r19.getArguments()
            if (r0 == 0) goto L_0x00e5
            java.lang.Object r0 = r0.get(r5)
            goto L_0x00e6
        L_0x00e5:
            r0 = r4
        L_0x00e6:
            if (r0 == 0) goto L_0x013c
            com.travel.train.model.searchResult.Body r0 = (com.travel.train.model.searchResult.Body) r0
            java.util.List r0 = r0.getCalendar()
            r1.p = r0
            java.util.List<com.travel.train.model.searchResult.CalendarData> r0 = r1.p
            if (r0 == 0) goto L_0x0144
            if (r0 == 0) goto L_0x00ff
            int r0 = r0.size()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0100
        L_0x00ff:
            r0 = r4
        L_0x0100:
            if (r0 != 0) goto L_0x0105
            kotlin.g.b.k.a()
        L_0x0105:
            int r0 = r0.intValue()
            if (r0 <= 0) goto L_0x0144
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r1.s = r0
            java.util.List<com.travel.train.model.searchResult.CalendarData> r0 = r1.p
            if (r0 != 0) goto L_0x0119
            kotlin.g.b.k.a()
        L_0x0119:
            java.util.Iterator r0 = r0.iterator()
        L_0x011d:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x0144
            java.lang.Object r5 = r0.next()
            com.travel.train.model.searchResult.CalendarData r5 = (com.travel.train.model.searchResult.CalendarData) r5
            if (r5 == 0) goto L_0x011d
            java.lang.String r6 = r5.getDateCalendar()
            if (r6 == 0) goto L_0x011d
            java.util.HashMap<java.lang.String, com.travel.train.model.searchResult.CalendarData> r7 = r1.s
            if (r7 != 0) goto L_0x0138
            kotlin.g.b.k.a()
        L_0x0138:
            r7.put(r6, r5)
            goto L_0x011d
        L_0x013c:
            kotlin.u r0 = new kotlin.u
            java.lang.String r2 = "null cannot be cast to non-null type com.travel.train.model.searchResult.Body"
            r0.<init>(r2)
            throw r0
        L_0x0144:
            android.os.Bundle r0 = r19.getArguments()
            java.lang.String r5 = "calendar_class"
            if (r0 == 0) goto L_0x0155
            boolean r0 = r0.containsKey(r5)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x0156
        L_0x0155:
            r0 = r4
        L_0x0156:
            if (r0 != 0) goto L_0x015b
            kotlin.g.b.k.a()
        L_0x015b:
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x016f
            android.os.Bundle r0 = r19.getArguments()
            if (r0 == 0) goto L_0x016c
            java.lang.String r0 = r0.getString(r5)
            goto L_0x016d
        L_0x016c:
            r0 = r4
        L_0x016d:
            r1.q = r0
        L_0x016f:
            android.os.Bundle r0 = r19.getArguments()
            java.lang.String r5 = "is_available_only"
            if (r0 == 0) goto L_0x0180
            boolean r0 = r0.containsKey(r5)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x0181
        L_0x0180:
            r0 = r4
        L_0x0181:
            if (r0 != 0) goto L_0x0186
            kotlin.g.b.k.a()
        L_0x0186:
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x019e
            android.os.Bundle r0 = r19.getArguments()
            if (r0 == 0) goto L_0x019b
            boolean r0 = r0.getBoolean(r5)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x019c
        L_0x019b:
            r0 = r4
        L_0x019c:
            r1.r = r0
        L_0x019e:
            java.util.Locale r0 = new java.util.Locale
            java.lang.String r5 = com.paytm.utility.n.a()
            r0.<init>(r5)
            r1.f27034h = r0
            long r5 = r1.f27033g
            r7 = 0
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x01df
            java.lang.String r0 = r1.f27035i
            if (r0 == 0) goto L_0x01df
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x01df
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch:{ ParseException -> 0x01d6 }
            java.lang.String r5 = "dd MMMM yy"
            java.util.Locale r6 = r1.f27034h     // Catch:{ ParseException -> 0x01d6 }
            r0.<init>(r5, r6)     // Catch:{ ParseException -> 0x01d6 }
            java.lang.String r5 = r1.f27035i     // Catch:{ ParseException -> 0x01d6 }
            java.util.Date r0 = r0.parse(r5)     // Catch:{ ParseException -> 0x01d6 }
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)     // Catch:{ ParseException -> 0x01d6 }
            long r5 = r0.getTime()     // Catch:{ ParseException -> 0x01d6 }
            r1.f27033g = r5     // Catch:{ ParseException -> 0x01d6 }
            goto L_0x01f3
        L_0x01d6:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.c(r0)
            goto L_0x01f3
        L_0x01df:
            java.lang.String r0 = r1.f27035i
            if (r0 == 0) goto L_0x01f3
            androidx.fragment.app.FragmentActivity r0 = r19.getActivity()
            android.app.Activity r0 = (android.app.Activity) r0
            java.lang.String r3 = r1.f27035i
            java.util.Locale r5 = r1.f27034h
            java.util.Date r0 = com.travel.train.j.i.a((android.app.Activity) r0, (java.lang.String) r3, (java.util.Locale) r5)
            r1.f27032f = r0
        L_0x01f3:
            androidx.fragment.app.FragmentActivity r0 = r19.getActivity()
            if (r0 == 0) goto L_0x0236
            com.travel.train.k.g r3 = new com.travel.train.k.g
            com.travel.train.k.g$a r5 = new com.travel.train.k.g$a
            com.travel.train.k.g$b r6 = com.travel.train.k.g.b.SEARCHBYTRAIN
            r5.<init>(r6)
            com.travel.train.a.a$a r6 = com.travel.train.a.a.f25797a
            com.travel.train.a.a.a r9 = new com.travel.train.a.a.a
            androidx.fragment.app.FragmentActivity r10 = r19.getActivity()
            if (r10 != 0) goto L_0x020f
            kotlin.g.b.k.a()
        L_0x020f:
            java.lang.String r11 = "activity!!"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r11)
            android.content.Context r10 = (android.content.Context) r10
            r9.<init>(r10)
            com.travel.train.a.a.b r9 = (com.travel.train.a.a.b) r9
            com.travel.train.a.a r6 = r6.a(r9)
            com.travel.train.k.g$a r5 = r5.a(r6)
            r3.<init>(r5)
            androidx.lifecycle.al$b r3 = (androidx.lifecycle.al.b) r3
            androidx.lifecycle.al r0 = androidx.lifecycle.am.a((androidx.fragment.app.FragmentActivity) r0, (androidx.lifecycle.al.b) r3)
            java.lang.Class<com.travel.train.k.b> r3 = com.travel.train.k.b.class
            androidx.lifecycle.ai r0 = r0.a(r3)
            com.travel.train.k.b r0 = (com.travel.train.k.b) r0
            r1.n = r0
        L_0x0236:
            androidx.fragment.app.FragmentActivity r0 = r19.getActivity()
            android.content.Context r0 = (android.content.Context) r0
            int r0 = com.paytm.utility.b.g((android.content.Context) r0)
            int r3 = com.travel.train.R.id.selected_date
            android.view.View r3 = r1.a((int) r3)
            com.paytm.utility.RoboTextView r3 = (com.paytm.utility.RoboTextView) r3
            r5 = 0
            if (r3 == 0) goto L_0x0250
            int r6 = r0 / 2
            r3.setPadding(r5, r6, r5, r0)
        L_0x0250:
            java.lang.String r0 = "E MMM dd HH:mm:ss Z yyyy"
            r1.f27028b = r0
            java.lang.String r0 = "EEE, dd MMM"
            r1.f27029c = r0
            com.travel.train.b r0 = com.travel.train.b.a()
            java.lang.String r3 = "TrainController.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            com.travel.common.a r0 = com.travel.train.b.b()
            java.lang.String r3 = "TrainController.getInstance().trainEventListener"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            java.lang.String r0 = r0.f()
            r3 = r0
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0282
            java.lang.String r3 = "maxAdvanceBookingDays"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            int r0 = java.lang.Integer.parseInt(r0)
            r1.l = r0
        L_0x0282:
            int r0 = r1.l
            r3 = 30
            int r0 = r0 / r3
            java.util.Calendar r6 = java.util.Calendar.getInstance()
            r9 = 2
            r6.add(r9, r0)
            r0 = 5
            r6.set(r0, r3)
            java.util.Calendar r3 = java.util.Calendar.getInstance()
            r3.add(r9, r5)
            r3.set(r0, r2)
            long r9 = r1.f27033g
            int r0 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x02b4
            boolean r0 = r19.a()
            if (r0 == 0) goto L_0x02b4
            java.util.Date r0 = new java.util.Date
            r0.<init>()
            long r9 = r1.f27033g
            r0.setTime(r9)
            goto L_0x02b9
        L_0x02b4:
            java.util.Date r0 = new java.util.Date
            r0.<init>()
        L_0x02b9:
            r1.f27032f = r0
            boolean r0 = r1.o
            if (r0 == 0) goto L_0x02ed
            int r0 = com.travel.train.R.id.calendar_view
            android.view.View r0 = r1.a((int) r0)
            com.squareup.timessquare.v4.CalendarPickerView r0 = (com.squareup.timessquare.v4.CalendarPickerView) r0
            if (r0 == 0) goto L_0x02e2
            java.lang.String r5 = "lastYear"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)
            java.util.Date r3 = r3.getTime()
            java.lang.String r5 = "nextYear"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r5)
            java.util.Date r5 = r6.getTime()
            java.util.Locale r6 = java.util.Locale.ENGLISH
            com.squareup.timessquare.v4.CalendarPickerView$e r0 = r0.a((java.util.Date) r3, (java.util.Date) r5, (java.util.Locale) r6)
            goto L_0x02e3
        L_0x02e2:
            r0 = r4
        L_0x02e3:
            if (r0 != 0) goto L_0x02e8
            kotlin.g.b.k.a()
        L_0x02e8:
            com.squareup.timessquare.v4.CalendarPickerView$j r3 = com.squareup.timessquare.v4.CalendarPickerView.j.SINGLE
            r0.a((com.squareup.timessquare.v4.CalendarPickerView.j) r3)
        L_0x02ed:
            com.travel.train.model.trainticket.CJRTrainHolidayList r0 = r1.j
            java.lang.String r3 = "Calendar.getInstance()"
            if (r0 != 0) goto L_0x0363
            int r0 = com.travel.train.R.id.calendar_view
            android.view.View r0 = r1.a((int) r0)
            com.squareup.timessquare.v4.CalendarPickerView r0 = (com.squareup.timessquare.v4.CalendarPickerView) r0
            if (r0 == 0) goto L_0x0307
            com.travel.train.b.au r5 = new com.travel.train.b.au
            r5.<init>()
            com.squareup.timessquare.v4.b r5 = (com.squareup.timessquare.v4.b) r5
            r0.setCustomDayView(r5)
        L_0x0307:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r0 = (java.util.List) r0
            com.travel.train.helper.p r5 = new com.travel.train.helper.p
            androidx.fragment.app.FragmentActivity r6 = r19.getActivity()
            r10 = r6
            android.content.Context r10 = (android.content.Context) r10
            java.util.HashMap r11 = r19.b()
            java.util.Calendar r6 = java.util.Calendar.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r3)
            java.util.Date r12 = r6.getTime()
            int r13 = r1.l
            java.lang.String r14 = r1.m
            boolean r3 = r1.o
            java.lang.Boolean r15 = java.lang.Boolean.valueOf(r3)
            java.util.HashMap<java.lang.String, com.travel.train.model.searchResult.CalendarData> r3 = r1.s
            java.lang.String r6 = r1.q
            java.lang.Boolean r9 = r1.r
            r18 = r9
            r9 = r5
            r16 = r3
            r17 = r6
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r0.add(r5)
            int r3 = com.travel.train.R.id.calendar_view
            android.view.View r3 = r1.a((int) r3)
            com.squareup.timessquare.v4.CalendarPickerView r3 = (com.squareup.timessquare.v4.CalendarPickerView) r3
            if (r3 == 0) goto L_0x0350
            r3.setDecorators(r0)
        L_0x0350:
            int r0 = com.travel.train.R.id.calendar_view
            android.view.View r0 = r1.a((int) r0)
            com.squareup.timessquare.v4.CalendarPickerView r0 = (com.squareup.timessquare.v4.CalendarPickerView) r0
            if (r0 == 0) goto L_0x03de
            java.util.Map r3 = r19.c()
            r0.setHolidayList(r3)
            goto L_0x03de
        L_0x0363:
            int r0 = com.travel.train.R.id.calendar_view
            android.view.View r0 = r1.a((int) r0)
            com.squareup.timessquare.v4.CalendarPickerView r0 = (com.squareup.timessquare.v4.CalendarPickerView) r0
            if (r0 == 0) goto L_0x0377
            com.travel.train.b.au r5 = new com.travel.train.b.au
            r5.<init>()
            com.squareup.timessquare.v4.b r5 = (com.squareup.timessquare.v4.b) r5
            r0.setCustomDayView(r5)
        L_0x0377:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r0 = (java.util.List) r0
            com.travel.train.helper.p r5 = new com.travel.train.helper.p
            androidx.fragment.app.FragmentActivity r6 = r19.getActivity()
            r10 = r6
            android.content.Context r10 = (android.content.Context) r10
            java.util.HashMap r11 = r19.b()
            java.util.Calendar r6 = java.util.Calendar.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r3)
            java.util.Date r12 = r6.getTime()
            int r13 = r1.l
            java.lang.String r14 = r1.m
            boolean r3 = r1.o
            java.lang.Boolean r15 = java.lang.Boolean.valueOf(r3)
            java.util.HashMap<java.lang.String, com.travel.train.model.searchResult.CalendarData> r3 = r1.s
            java.lang.String r6 = r1.q
            java.lang.Boolean r9 = r1.r
            r18 = r9
            r9 = r5
            r16 = r3
            r17 = r6
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r0.add(r5)
            int r3 = com.travel.train.R.id.calendar_view
            android.view.View r3 = r1.a((int) r3)
            com.squareup.timessquare.v4.CalendarPickerView r3 = (com.squareup.timessquare.v4.CalendarPickerView) r3
            if (r3 == 0) goto L_0x03c0
            r3.setDecorators(r0)
        L_0x03c0:
            int r0 = com.travel.train.R.id.calendar_view
            android.view.View r0 = r1.a((int) r0)
            com.squareup.timessquare.v4.CalendarPickerView r0 = (com.squareup.timessquare.v4.CalendarPickerView) r0
            if (r0 == 0) goto L_0x03d1
            java.util.Map r3 = r19.c()
            r0.setHolidayList(r3)
        L_0x03d1:
            int r0 = com.travel.train.R.id.calendar_view
            android.view.View r0 = r1.a((int) r0)
            com.squareup.timessquare.v4.CalendarPickerView r0 = (com.squareup.timessquare.v4.CalendarPickerView) r0
            if (r0 == 0) goto L_0x03de
            r0.setFromFlight(r2)
        L_0x03de:
            int r0 = com.travel.train.R.id.calendar_view
            android.view.View r0 = r1.a((int) r0)
            com.squareup.timessquare.v4.CalendarPickerView r0 = (com.squareup.timessquare.v4.CalendarPickerView) r0
            if (r0 == 0) goto L_0x03ee
            r3 = r1
            com.squareup.timessquare.v4.CalendarPickerView$h r3 = (com.squareup.timessquare.v4.CalendarPickerView.h) r3
            r0.setOnDateSelectedListener(r3)
        L_0x03ee:
            java.util.Locale r0 = r1.f27034h     // Catch:{ Exception -> 0x0519 }
            java.util.Calendar r0 = java.util.Calendar.getInstance(r0)     // Catch:{ Exception -> 0x0519 }
            java.text.SimpleDateFormat r3 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x0519 }
            java.lang.String r5 = "EEE, dd MMMM"
            java.util.Locale r6 = r1.f27034h     // Catch:{ Exception -> 0x0519 }
            r3.<init>(r5, r6)     // Catch:{ Exception -> 0x0519 }
            java.lang.String r5 = "today"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)     // Catch:{ Exception -> 0x0519 }
            java.util.Date r5 = r0.getTime()     // Catch:{ Exception -> 0x0519 }
            java.lang.String r3 = r3.format(r5)     // Catch:{ Exception -> 0x0519 }
            r1.f27030d = r3     // Catch:{ Exception -> 0x0519 }
            java.util.Date r0 = r0.getTime()     // Catch:{ Exception -> 0x0519 }
            r1.f27031e = r0     // Catch:{ Exception -> 0x0519 }
            boolean r0 = r1.o     // Catch:{ Exception -> 0x0519 }
            r3 = 8
            if (r0 == 0) goto L_0x0432
            int r0 = com.travel.train.R.id.selected_date     // Catch:{ Exception -> 0x0519 }
            android.view.View r0 = r1.a((int) r0)     // Catch:{ Exception -> 0x0519 }
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0     // Catch:{ Exception -> 0x0519 }
            if (r0 == 0) goto L_0x0426
            r0.setVisibility(r3)     // Catch:{ Exception -> 0x0519 }
        L_0x0426:
            int r0 = com.travel.train.R.id.selected_date_ul     // Catch:{ Exception -> 0x0519 }
            android.view.View r0 = r1.a((int) r0)     // Catch:{ Exception -> 0x0519 }
            if (r0 == 0) goto L_0x0431
            r0.setVisibility(r3)     // Catch:{ Exception -> 0x0519 }
        L_0x0431:
            return
        L_0x0432:
            long r5 = r1.f27033g     // Catch:{ Exception -> 0x0519 }
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x04eb
            java.util.Date r0 = new java.util.Date     // Catch:{ Exception -> 0x0519 }
            r0.<init>()     // Catch:{ Exception -> 0x0519 }
            long r5 = r1.f27033g     // Catch:{ Exception -> 0x0519 }
            r0.setTime(r5)     // Catch:{ Exception -> 0x0519 }
            java.lang.String r3 = com.paytm.utility.n.a()     // Catch:{ Exception -> 0x0519 }
            java.lang.String r5 = "hi"
            boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r5, (boolean) r2)     // Catch:{ Exception -> 0x0519 }
            if (r3 != 0) goto L_0x04d0
            java.lang.String r3 = com.paytm.utility.n.a()     // Catch:{ Exception -> 0x0519 }
            java.lang.String r5 = "ta"
            boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r5, (boolean) r2)     // Catch:{ Exception -> 0x0519 }
            if (r3 != 0) goto L_0x04d0
            java.lang.String r3 = com.paytm.utility.n.a()     // Catch:{ Exception -> 0x0519 }
            java.lang.String r5 = "te"
            boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r5, (boolean) r2)     // Catch:{ Exception -> 0x0519 }
            if (r3 != 0) goto L_0x04d0
            java.lang.String r3 = com.paytm.utility.n.a()     // Catch:{ Exception -> 0x0519 }
            java.lang.String r5 = "kn"
            boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r5, (boolean) r2)     // Catch:{ Exception -> 0x0519 }
            if (r3 != 0) goto L_0x04d0
            java.lang.String r3 = com.paytm.utility.n.a()     // Catch:{ Exception -> 0x0519 }
            java.lang.String r5 = "pa"
            boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r5, (boolean) r2)     // Catch:{ Exception -> 0x0519 }
            if (r3 != 0) goto L_0x04d0
            java.lang.String r3 = com.paytm.utility.n.a()     // Catch:{ Exception -> 0x0519 }
            java.lang.String r5 = "mr"
            boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r5, (boolean) r2)     // Catch:{ Exception -> 0x0519 }
            if (r3 != 0) goto L_0x04d0
            java.lang.String r3 = com.paytm.utility.n.a()     // Catch:{ Exception -> 0x0519 }
            java.lang.String r5 = "gu"
            boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r5, (boolean) r2)     // Catch:{ Exception -> 0x0519 }
            if (r3 != 0) goto L_0x04d0
            java.lang.String r3 = com.paytm.utility.n.a()     // Catch:{ Exception -> 0x0519 }
            java.lang.String r5 = "bn"
            boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r5, (boolean) r2)     // Catch:{ Exception -> 0x0519 }
            if (r3 != 0) goto L_0x04d0
            java.lang.String r3 = com.paytm.utility.n.a()     // Catch:{ Exception -> 0x0519 }
            java.lang.String r5 = "or"
            boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r5, (boolean) r2)     // Catch:{ Exception -> 0x0519 }
            if (r3 != 0) goto L_0x04d0
            java.lang.String r3 = com.paytm.utility.n.a()     // Catch:{ Exception -> 0x0519 }
            java.lang.String r5 = "ml"
            boolean r2 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r5, (boolean) r2)     // Catch:{ Exception -> 0x0519 }
            if (r2 == 0) goto L_0x04bd
            goto L_0x04d0
        L_0x04bd:
            androidx.fragment.app.FragmentActivity r2 = r19.getActivity()     // Catch:{ Exception -> 0x0519 }
            android.app.Activity r2 = (android.app.Activity) r2     // Catch:{ Exception -> 0x0519 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0519 }
            java.lang.String r3 = r1.f27028b     // Catch:{ Exception -> 0x0519 }
            java.lang.String r5 = r1.f27029c     // Catch:{ Exception -> 0x0519 }
            java.lang.String r0 = com.travel.train.j.i.a((android.app.Activity) r2, (java.lang.String) r0, (java.lang.String) r3, (java.lang.String) r5)     // Catch:{ Exception -> 0x0519 }
            goto L_0x04db
        L_0x04d0:
            r19.getActivity()     // Catch:{ Exception -> 0x0519 }
            java.lang.String r0 = r1.f27029c     // Catch:{ Exception -> 0x0519 }
            long r2 = r1.f27033g     // Catch:{ Exception -> 0x0519 }
            java.lang.String r0 = com.paytm.utility.b.a((java.lang.String) r0, (long) r2)     // Catch:{ Exception -> 0x0519 }
        L_0x04db:
            int r2 = com.travel.train.R.id.selected_date     // Catch:{ Exception -> 0x0519 }
            android.view.View r2 = r1.a((int) r2)     // Catch:{ Exception -> 0x0519 }
            com.paytm.utility.RoboTextView r2 = (com.paytm.utility.RoboTextView) r2     // Catch:{ Exception -> 0x0519 }
            if (r2 == 0) goto L_0x04ea
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x0519 }
            r2.setText(r0)     // Catch:{ Exception -> 0x0519 }
        L_0x04ea:
            return
        L_0x04eb:
            java.lang.String r0 = r1.f27030d     // Catch:{ Exception -> 0x0519 }
            if (r0 == 0) goto L_0x050b
            java.lang.String r0 = r1.f27030d     // Catch:{ Exception -> 0x0519 }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x0519 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0519 }
            if (r0 != 0) goto L_0x050b
            int r0 = com.travel.train.R.id.selected_date     // Catch:{ Exception -> 0x0519 }
            android.view.View r0 = r1.a((int) r0)     // Catch:{ Exception -> 0x0519 }
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0     // Catch:{ Exception -> 0x0519 }
            if (r0 == 0) goto L_0x050a
            java.lang.String r2 = r1.f27030d     // Catch:{ Exception -> 0x0519 }
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x0519 }
            r0.setText(r2)     // Catch:{ Exception -> 0x0519 }
        L_0x050a:
            return
        L_0x050b:
            int r0 = com.travel.train.R.id.selected_date     // Catch:{ Exception -> 0x0519 }
            android.view.View r0 = r1.a((int) r0)     // Catch:{ Exception -> 0x0519 }
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0     // Catch:{ Exception -> 0x0519 }
            if (r0 == 0) goto L_0x0518
            r0.setVisibility(r3)     // Catch:{ Exception -> 0x0519 }
        L_0x0518:
            return
        L_0x0519:
            r0 = move-exception
            boolean r2 = com.paytm.utility.b.v
            if (r2 == 0) goto L_0x0525
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.c(r0)
        L_0x0525:
            androidx.fragment.app.FragmentActivity r0 = r19.getActivity()
            android.app.Activity r0 = (android.app.Activity) r0
            androidx.fragment.app.FragmentActivity r2 = r19.getActivity()
            if (r2 == 0) goto L_0x0535
            java.lang.String r4 = r2.getLocalClassName()
        L_0x0535:
            com.paytm.utility.b.a((android.app.Activity) r0, (java.lang.String) r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.j.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    private final boolean a() {
        try {
            Calendar instance = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMMM yy", this.f27034h);
            k.a((Object) instance, "thisYr");
            String format = simpleDateFormat.format(instance.getTime());
            k.a((Object) format, "originalFormat.format(thisYr.time)");
            Date parse = simpleDateFormat.parse(format);
            k.a((Object) parse, "originalFormat.parse(todaydateValue)");
            Calendar instance2 = Calendar.getInstance();
            instance2.add(1, 1);
            k.a((Object) instance2, "nextYr");
            String format2 = simpleDateFormat.format(instance2.getTime());
            k.a((Object) format2, "originalFormat.format(nextYr.time)");
            Date parse2 = simpleDateFormat.parse(format2);
            k.a((Object) parse2, "originalFormat.parse(nextYrdateValue)");
            Date parse3 = simpleDateFormat.parse(this.f27035i);
            k.a((Object) parse3, "originalFormat.parse(selectedDateWithYear)");
            if (!parse3.after(parse) || !parse3.before(parse2)) {
                return false;
            }
            return true;
        } catch (ParseException e2) {
            if (com.paytm.utility.b.v) {
                q.c(e2.getMessage());
            }
            Activity activity = getActivity();
            FragmentActivity activity2 = getActivity();
            com.paytm.utility.b.a(activity, activity2 != null ? activity2.getLocalClassName() : null);
            return false;
        }
    }

    public final void a(Date date) {
        String str;
        String str2;
        Date date2;
        String str3;
        Date date3 = date;
        if (date3 == null) {
            Activity activity = getActivity();
            FragmentActivity activity2 = getActivity();
            com.paytm.utility.b.a(activity, activity2 != null ? activity2.getLocalClassName() : null);
        } else {
            this.k = date3;
        }
        if ((date3 == null || !p.a(n.a(), "hi", true)) && !p.a(n.a(), "ta", true) && !p.a(n.a(), "te", true) && !p.a(n.a(), "kn", true) && !p.a(n.a(), "pa", true) && !p.a(n.a(), "mr", true) && !p.a(n.a(), "gu", true) && !p.a(n.a(), "bn", true) && !p.a(n.a(), "or", true) && !p.a(n.a(), "ml", true)) {
            str = i.a(getActivity(), date3 != null ? date.toString() : null, this.f27028b, this.f27029c);
            k.a((Object) str, "CJRTrainDateUtils.format…nputFormat, outputFormat)");
        } else {
            Long valueOf = date3 != null ? Long.valueOf(date.getTime()) : null;
            if (valueOf == null) {
                k.a();
            }
            this.f27033g = valueOf.longValue();
            getActivity();
            str = com.paytm.utility.b.a(this.f27029c, this.f27033g);
            k.a((Object) str, "CJRAppCommonUtility.conv… mPreviouslySelectedDate)");
        }
        RoboTextView roboTextView = (RoboTextView) a(R.id.selected_date);
        if (roboTextView != null) {
            roboTextView.setText(str);
        }
        o.a("train_homepage", (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, "depart_date_selected", "/trains", getActivity(), (Map<String, Object>) null);
        if (i.a(this.f27031e, date3, TimeUnit.DAYS) >= ((long) this.l)) {
            String string = getResources().getString(R.string.train_msg_proper_date);
            k.a((Object) string, "resources.getString(R.st…ng.train_msg_proper_date)");
            com.paytm.utility.b.b((Context) getActivity(), "", string);
            return;
        }
        if (p.a(n.a(), "hi", true) || p.a(n.a(), "ta", true) || p.a(n.a(), "te", true) || p.a(n.a(), "kn", true) || p.a(n.a(), "pa", true) || p.a(n.a(), "mr", true) || p.a(n.a(), "gu", true) || p.a(n.a(), "bn", true) || p.a(n.a(), "or", true) || p.a(n.a(), "ml", true)) {
            date2 = date;
            str2 = com.paytm.utility.b.a(date2, "dd MMM yy");
            k.a((Object) str2, "CJRAppCommonUtility.conv…RAIN_DISPLAY_DATE_FORMAT)");
        } else {
            String a2 = i.a((Activity) getActivity(), String.valueOf(date), this.f27028b, "dd MMM yy");
            k.a((Object) a2, "CJRTrainDateUtils.format…RAIN_DISPLAY_DATE_FORMAT)");
            str2 = a2;
            date2 = date;
        }
        if (p.a(n.a(), "hi", true) || p.a(n.a(), "ta", true) || p.a(n.a(), "te", true) || p.a(n.a(), "kn", true) || p.a(n.a(), "pa", true) || p.a(n.a(), "mr", true) || p.a(n.a(), "gu", true) || p.a(n.a(), "bn", true) || p.a(n.a(), "or", true) || p.a(n.a(), "ml", true)) {
            str3 = com.paytm.utility.b.a(date2, "dd MMMM, EEE");
            k.a((Object) str3, "CJRAppCommonUtility.conv…REEN_DISPLAY_DATE_FORMAT)");
        } else {
            str3 = i.a((Activity) getActivity(), String.valueOf(date), this.f27028b, "dd MMMM, EEE");
            k.a((Object) str3, "CJRTrainDateUtils.format…REEN_DISPLAY_DATE_FORMAT)");
        }
        Intent intent = new Intent();
        intent.putExtra("intent_extra_selected_train_journey_date", str2);
        intent.putExtra("intent_extra_selected_train_display_date", str3);
        intent.putExtra("intent_extra_selected_train_date", date2 != null ? Long.valueOf(date.getTime()) : null);
        intent.putExtra("intent_extra_is_date_selected", true);
        b bVar = this.n;
        if (bVar != null) {
            bVar.f27625e.postValue(str2);
        }
    }

    private HashMap<String, CJRTrainHoliday> b() {
        HashMap<String, CJRTrainHoliday> hashMap = new HashMap<>();
        CJRTrainHolidayList cJRTrainHolidayList = this.j;
        if (cJRTrainHolidayList != null) {
            if (cJRTrainHolidayList == null) {
                k.a();
            }
            if (cJRTrainHolidayList.getHolidayList() != null) {
                CJRTrainHolidayList cJRTrainHolidayList2 = this.j;
                if (cJRTrainHolidayList2 == null) {
                    k.a();
                }
                if (cJRTrainHolidayList2.getHolidayList().size() > 0) {
                    CJRTrainHolidayList cJRTrainHolidayList3 = this.j;
                    if (cJRTrainHolidayList3 == null) {
                        k.a();
                    }
                    ArrayList<CJRTrainHoliday> holidayList = cJRTrainHolidayList3.getHolidayList();
                    k.a((Object) holidayList, "mTrainHolidayListMap!!.holidayList");
                    int size = holidayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        String date = holidayList.get(i2).getDate();
                        k.a((Object) date, "holidayList[i].getDate()");
                        CJRTrainHoliday cJRTrainHoliday = holidayList.get(i2);
                        k.a((Object) cJRTrainHoliday, "holidayList[i]");
                        hashMap.put(date, cJRTrainHoliday);
                    }
                }
            }
        }
        return hashMap;
    }

    private final Map<Date, String> c() {
        TreeMap treeMap = new TreeMap();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        CJRTrainHolidayList cJRTrainHolidayList = this.j;
        if (cJRTrainHolidayList != null) {
            if (cJRTrainHolidayList == null) {
                k.a();
            }
            if (cJRTrainHolidayList.getHolidayList() != null) {
                CJRTrainHolidayList cJRTrainHolidayList2 = this.j;
                if (cJRTrainHolidayList2 == null) {
                    k.a();
                }
                if (cJRTrainHolidayList2.getHolidayList().size() > 0) {
                    CJRTrainHolidayList cJRTrainHolidayList3 = this.j;
                    if (cJRTrainHolidayList3 == null) {
                        k.a();
                    }
                    ArrayList<CJRTrainHoliday> holidayList = cJRTrainHolidayList3.getHolidayList();
                    k.a((Object) holidayList, "mTrainHolidayListMap!!.holidayList");
                    int size = holidayList.size();
                    Date date = null;
                    for (int i2 = 0; i2 < size; i2++) {
                        try {
                            date = simpleDateFormat.parse(holidayList.get(i2).getDate());
                        } catch (ParseException e2) {
                            q.c(e2.getMessage());
                        }
                        if (date == null) {
                            k.a();
                        }
                        treeMap.put(date, holidayList.get(i2).getName());
                    }
                }
            }
        }
        return treeMap;
    }

    public final boolean onBackPressed() {
        return super.onBackPressed();
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.u;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
