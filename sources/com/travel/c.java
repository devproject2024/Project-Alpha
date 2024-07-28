package com.travel;

import android.content.Context;
import android.content.Intent;
import com.business.merchant_payments.common.utility.AppConstants;
import com.travel.calendar.AJRCommonCalendarActivity;
import com.travel.utils.f;
import kotlin.g.b.k;
import kotlin.m.p;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final Intent f22822a = new Intent(this.f22823b, AJRCommonCalendarActivity.class);

    /* renamed from: b  reason: collision with root package name */
    private final Context f22823b;

    /* renamed from: c  reason: collision with root package name */
    private final com.travel.common.a.c f22824c;

    /* renamed from: d  reason: collision with root package name */
    private final f f22825d;

    public c(Context context, com.travel.common.a.c cVar, f fVar) {
        k.c(context, "context");
        k.c(cVar, "verticalType");
        k.c(fVar, "calendarType");
        this.f22823b = context;
        this.f22824c = cVar;
        this.f22825d = fVar;
    }

    public final c a(String str) {
        k.c(str, "selectedDate");
        this.f22822a.putExtra("BOOK_DATE", str);
        return this;
    }

    public final c b(String str) {
        CharSequence charSequence = str;
        if (!(charSequence == null || p.a(charSequence))) {
            this.f22822a.putExtra("CITY_NAME", str);
        }
        return this;
    }

    public final c c(String str) {
        this.f22822a.putExtra(AppConstants.EXTRA_FIRST_TITLE, str);
        return this;
    }

    public final c a(int i2) {
        this.f22822a.putExtra("MAX_INTERVAL_BETWEEN_START_END", i2);
        return this;
    }

    public final c d(String str) {
        k.c(str, "url");
        this.f22822a.putExtra("HOLIDAY_URL", str);
        return this;
    }

    public final c a(long j) {
        this.f22822a.putExtra("INTENT_EXTRA_SELECTED_DATE_TIME", j);
        return this;
    }

    public final c e(String str) {
        this.f22822a.putExtra("INTENT_EXTRA_UPDATED_RETURN_DATE", str);
        return this;
    }

    public final c a() {
        this.f22822a.putExtra("INTENT_SELECT_SINGLE_DATE", true);
        return this;
    }

    public final c a(boolean z) {
        this.f22822a.putExtra("INTENT_HIDE_BOTTOM_LAYOUT", z);
        return this;
    }

    public final c b(int i2) {
        this.f22822a.putExtra("INTENT_MAX_ADVANCE_BOOKING_ALLOWED_IN_DAYS", i2);
        return this;
    }

    public final c f(String str) {
        this.f22822a.putExtra("intent_extra_fare_disclaimer", str);
        return this;
    }

    public final c b(boolean z) {
        this.f22822a.putExtra("FLIGHT_FARE_API_CALLED", z);
        return this;
    }

    public final c c(boolean z) {
        this.f22822a.putExtra("intent_extra_need_to_show_fare", z);
        return this;
    }

    public final c g(String str) {
        this.f22822a.putExtra("intent_extra_running_on_for_train", str);
        return this;
    }

    public final Intent b() {
        this.f22822a.putExtra("INTENT_FROM_WHICH_VERICAL", this.f22824c);
        this.f22822a.putExtra("Intent_Extra_Calendar_Type", this.f22825d);
        return this.f22822a;
    }
}
