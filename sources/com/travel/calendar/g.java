package com.travel.calendar;

import android.app.Application;
import androidx.databinding.i;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.travel.common.a.c;
import com.travel.model.CalendarDatePriceInfo;
import com.travel.model.CalendarHolidayList;
import com.travel.utils.f;
import com.travel.utils.l;
import com.travel.utils.m;
import java.util.Date;
import java.util.HashMap;
import kotlin.g.b.k;

public final class g extends androidx.lifecycle.a {
    public m A;
    String B;
    boolean C;
    private final y<Date> D = new y<>();
    private y<Date> E = new y<>();
    private final y<CalendarHolidayList> F = new y<>();
    private final i<String> G = new i<>();

    /* renamed from: a  reason: collision with root package name */
    String f23013a = "CommonCalendarViewModel";

    /* renamed from: b  reason: collision with root package name */
    final LiveData<Date> f23014b = this.D;

    /* renamed from: c  reason: collision with root package name */
    final LiveData<Date> f23015c = this.E;

    /* renamed from: d  reason: collision with root package name */
    final LiveData<CalendarHolidayList> f23016d = this.F;

    /* renamed from: e  reason: collision with root package name */
    final l f23017e = new l();

    /* renamed from: f  reason: collision with root package name */
    public c f23018f;

    /* renamed from: g  reason: collision with root package name */
    public f f23019g;

    /* renamed from: h  reason: collision with root package name */
    int f23020h = -1;

    /* renamed from: i  reason: collision with root package name */
    boolean f23021i;
    boolean j;
    boolean k;
    CalendarHolidayList l;
    String m;
    String n;
    boolean o;
    HashMap<String, CalendarDatePriceInfo> p = new HashMap<>();
    String q;
    String r = "";
    Date s;
    Date t;
    String u;
    String v;
    long w = -1;
    boolean x;
    int y = -1;
    String z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(Application application) {
        super(application);
        k.c(application, "application");
    }

    public final c a() {
        c cVar = this.f23018f;
        if (cVar == null) {
            k.a("verticalType");
        }
        return cVar;
    }

    public final f b() {
        f fVar = this.f23019g;
        if (fVar == null) {
            k.a("calendarType");
        }
        return fVar;
    }

    public final void a(String str) {
        k.c(str, "<set-?>");
        this.r = str;
    }

    public final void a(Date date) {
        this.s = date;
        this.E.setValue(date);
    }

    public final void b(Date date) {
        k.c(date, "checkInDate");
        this.t = date;
        this.D.setValue(date);
    }

    public final void a(CalendarHolidayList calendarHolidayList) {
        k.c(calendarHolidayList, "holidayList");
        this.l = calendarHolidayList;
        this.F.setValue(calendarHolidayList);
    }

    public static final class a implements b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f23022a;

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            k.c(networkCustomError, "networkCustomError");
        }

        a(g gVar) {
            this.f23022a = gVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            if (iJRPaytmDataModel instanceof CalendarHolidayList) {
                this.f23022a.a((CalendarHolidayList) iJRPaytmDataModel);
            }
        }
    }
}
