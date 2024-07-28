package com.travel.calendar;

import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.m;
import com.paytm.utility.q;
import com.travel.calendar.c;
import com.travel.model.CalendarHolidayList;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;

public final class b extends m {

    /* renamed from: a  reason: collision with root package name */
    private String f22986a;

    /* renamed from: b  reason: collision with root package name */
    private final SparseArray<Fragment> f22987b;

    /* renamed from: c  reason: collision with root package name */
    private final List<String> f22988c;

    /* renamed from: d  reason: collision with root package name */
    private final CalendarHolidayList f22989d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f22990e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f22991f;

    /* renamed from: g  reason: collision with root package name */
    private String f22992g;

    /* renamed from: h  reason: collision with root package name */
    private String f22993h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(j jVar, List<String> list, CalendarHolidayList calendarHolidayList, boolean z, String str, String str2) {
        super(jVar);
        k.c(jVar, "fm");
        k.c(list, "mTitles");
        this.f22989d = calendarHolidayList;
        this.f22991f = z;
        this.f22992g = str;
        this.f22993h = str2;
        this.f22986a = "CJRCalendarFragmentAdapter";
        this.f22987b = new SparseArray<>();
        this.f22988c = new ArrayList();
        this.f22988c.clear();
        this.f22988c.addAll(list);
    }

    public final Fragment getItem(int i2) {
        c cVar;
        if (i2 == 0) {
            c.a aVar = c.f22999a;
            cVar = c.a.a(i2, e.CHECKIN_CALENDAR, this.f22990e, this.f22991f, this.f22992g, this.f22993h);
        } else if (i2 != 1) {
            c.a aVar2 = c.f22999a;
            cVar = c.a.a(i2, e.CHECKIN_CALENDAR, this.f22990e, this.f22991f, this.f22992g, this.f22993h);
        } else {
            c.a aVar3 = c.f22999a;
            cVar = c.a.a(i2, e.CHECKOUT_CALENDAR, this.f22990e, this.f22991f, this.f22992g, this.f22993h);
        }
        this.f22987b.put(i2, cVar);
        return cVar;
    }

    public final int getCount() {
        return this.f22988c.size();
    }

    public final void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        k.c(viewGroup, "container");
        k.c(obj, "object");
        try {
            this.f22987b.remove(i2);
            viewGroup.removeView(((Fragment) obj).getView());
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.c(e2.getMessage());
            }
        }
        super.destroyItem(viewGroup, i2, obj);
    }
}
