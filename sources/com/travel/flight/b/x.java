package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import com.travel.flight.R;
import com.travel.flight.a;
import com.travel.flight.pojo.modifyBooking.CJRFlightMBPassenger;
import com.travel.flight.pojo.modifyBooking.CJRFlightMBPassengerDetails;
import java.util.List;

public final class x extends w {

    /* renamed from: h  reason: collision with root package name */
    private static final ViewDataBinding.b f24044h = null;

    /* renamed from: i  reason: collision with root package name */
    private static final SparseIntArray f24045i;
    private final ConstraintLayout j;
    private long k;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f24045i = sparseIntArray;
        sparseIntArray.put(R.id.left_guideline, 4);
        f24045i.put(R.id.right_guideline, 5);
        f24045i.put(R.id.divider_traveler, 6);
    }

    public x(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 7, f24044h, f24045i));
    }

    private x(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[6], objArr[4], objArr[3], objArr[5], objArr[1], objArr[2]);
        this.k = -1;
        this.j = objArr[0];
        this.j.setTag((Object) null);
        this.f24039c.setTag((Object) null);
        this.f24041e.setTag((Object) null);
        this.f24042f.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.k = 2;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.k != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.E != i2) {
            return false;
        }
        this.f24043g = (CJRFlightMBPassengerDetails) obj;
        synchronized (this) {
            this.k |= 1;
        }
        notifyPropertyChanged(a.E);
        super.requestRebind();
        return true;
    }

    public final void executeBindings() {
        long j2;
        String str;
        List<CJRFlightMBPassenger> list;
        int i2;
        synchronized (this) {
            j2 = this.k;
            this.k = 0;
        }
        CJRFlightMBPassengerDetails cJRFlightMBPassengerDetails = this.f24043g;
        List<String> list2 = null;
        int i3 = 0;
        int i4 = ((j2 & 3) > 0 ? 1 : ((j2 & 3) == 0 ? 0 : -1));
        if (i4 != 0) {
            if (cJRFlightMBPassengerDetails != null) {
                List<CJRFlightMBPassenger> passenger_details = cJRFlightMBPassengerDetails.getPassenger_details();
                str = cJRFlightMBPassengerDetails.getTitle();
                List<CJRFlightMBPassenger> list3 = passenger_details;
                list2 = cJRFlightMBPassengerDetails.getNotes();
                list = list3;
            } else {
                list = null;
                str = null;
            }
            if (list2 != null) {
                i2 = list2.size();
            } else {
                i2 = 0;
            }
            boolean z = i2 > 0;
            if (i4 != 0) {
                j2 |= z ? 8 : 4;
            }
            if (!z) {
                i3 = 8;
            }
        } else {
            list = null;
            str = null;
        }
        if ((j2 & 3) != 0) {
            this.f24039c.setVisibility(i3);
            com.travel.flight.flightticket.b.a.a(this.f24039c, (List<? extends Object>) list2);
            d.a(this.f24041e, (CharSequence) str);
            com.travel.flight.flightticket.b.a.a(this.f24042f, (List<? extends Object>) list);
        }
    }
}
