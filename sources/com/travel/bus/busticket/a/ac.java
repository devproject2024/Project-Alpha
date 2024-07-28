package com.travel.bus.busticket.a;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.o;
import androidx.fragment.app.q;
import com.travel.bus.pojo.busticket.TripBusDetailsItem;
import java.util.ArrayList;

public final class ac extends o {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<TripBusDetailsItem> f21562a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<TripBusDetailsItem> f21563b;

    /* renamed from: c  reason: collision with root package name */
    private long f21564c;

    /* renamed from: d  reason: collision with root package name */
    private long f21565d;

    /* renamed from: e  reason: collision with root package name */
    private final SparseArray<Fragment> f21566e = new SparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    private boolean f21567f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f21568g = false;

    public final CharSequence getPageTitle(int i2) {
        return "";
    }

    public ac(j jVar, ArrayList<TripBusDetailsItem> arrayList, ArrayList<TripBusDetailsItem> arrayList2, long j, long j2, boolean z) {
        super(jVar);
        this.f21562a = arrayList;
        this.f21563b = arrayList2;
        this.f21564c = j;
        this.f21565d = j2;
        this.f21568g = z;
    }

    public final Fragment getItem(int i2) {
        com.travel.bus.busticket.fragment.j jVar = new com.travel.bus.busticket.fragment.j();
        Bundle bundle = new Bundle();
        bundle.putBoolean("bus_is_social_distancing_intent", this.f21568g);
        if (i2 == 0) {
            ArrayList<TripBusDetailsItem> arrayList = this.f21562a;
            if (arrayList == null || arrayList.size() == 0) {
                ArrayList<TripBusDetailsItem> arrayList2 = this.f21563b;
                if (arrayList2 != null) {
                    bundle.putSerializable("intent_extra_select_seat_trip_list", arrayList2);
                    bundle.putSerializable("intent_extra_select_seat_row_count", Long.valueOf(this.f21565d));
                    bundle.putBoolean("intent_extra_select_seat_is_upper", true);
                    this.f21567f = true;
                    this.f21566e.put(i2, jVar);
                }
            } else {
                bundle.putSerializable("intent_extra_select_seat_trip_list", this.f21562a);
                bundle.putSerializable("intent_extra_select_seat_row_count", Long.valueOf(this.f21564c));
                bundle.putBoolean("intent_extra_select_seat_is_upper", false);
                this.f21567f = false;
            }
        } else {
            ArrayList<TripBusDetailsItem> arrayList3 = this.f21563b;
            if (arrayList3 != null && !this.f21567f) {
                bundle.putSerializable("intent_extra_select_seat_trip_list", arrayList3);
                bundle.putSerializable("intent_extra_select_seat_row_count", Long.valueOf(this.f21565d));
                bundle.putBoolean("intent_extra_select_seat_is_upper", true);
            }
        }
        jVar.setArguments(bundle);
        if (this.f21562a.size() != 0) {
            this.f21566e.put(i2, jVar);
        }
        return jVar;
    }

    public final void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        try {
            this.f21566e.remove(i2);
            viewGroup.removeView(((Fragment) obj).getView());
            if (i2 <= getCount()) {
                q a2 = ((Fragment) obj).getFragmentManager().a();
                a2.a((Fragment) obj);
                a2.b();
            }
        } catch (Exception e2) {
            com.paytm.utility.q.c(e2.getMessage());
        }
        super.destroyItem(viewGroup, i2, obj);
    }

    public final int getCount() {
        ArrayList<TripBusDetailsItem> arrayList = this.f21563b;
        return (arrayList == null || arrayList.size() <= 0 || this.f21562a.size() <= 0) ? 1 : 2;
    }

    public final Fragment a(int i2) {
        return this.f21566e.get(i2);
    }
}
