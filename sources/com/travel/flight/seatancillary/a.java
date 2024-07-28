package com.travel.flight.seatancillary;

import android.util.SparseArray;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.m;
import com.travel.flight.pojo.model.CJRTravellerSeatTransition;
import com.travel.flight.pojo.seatancillaryentity.availability.CJRSeatNotes;
import com.travel.flight.pojo.seatancillaryentity.skeleton.CJRSeatJourneyType;
import com.travel.flight.seatancillary.b.a;
import java.util.List;

public final class a extends m {

    /* renamed from: a  reason: collision with root package name */
    SparseArray<Fragment> f25461a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    private List<CJRSeatJourneyType> f25462b;

    /* renamed from: c  reason: collision with root package name */
    private List<CJRSeatJourneyType> f25463c;

    /* renamed from: d  reason: collision with root package name */
    private CJRTravellerSeatTransition f25464d;

    /* renamed from: e  reason: collision with root package name */
    private a.C0476a f25465e;

    /* renamed from: f  reason: collision with root package name */
    private CJRSeatNotes f25466f;

    public a(j jVar, List<CJRSeatJourneyType> list, List<CJRSeatJourneyType> list2, CJRTravellerSeatTransition cJRTravellerSeatTransition, a.C0476a aVar, CJRSeatNotes cJRSeatNotes) {
        super(jVar);
        this.f25462b = list;
        this.f25463c = list2;
        this.f25464d = cJRTravellerSeatTransition;
        this.f25465e = aVar;
        this.f25466f = cJRSeatNotes;
    }

    public final int getCount() {
        List<CJRSeatJourneyType> list = this.f25462b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final Fragment getItem(int i2) {
        e a2 = e.a(this.f25462b.get(i2), this.f25463c.get(i2), this.f25464d, this.f25465e, this.f25466f);
        this.f25461a.put(i2, a2);
        return a2;
    }

    public final CharSequence getPageTitle(int i2) {
        return this.f25462b.get(i2).getOrigin() + " - " + this.f25462b.get(i2).getDestination();
    }
}
