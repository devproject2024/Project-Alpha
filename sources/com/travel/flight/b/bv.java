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

public final class bv extends bu {

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.b f23752f = null;

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f23753g;

    /* renamed from: h  reason: collision with root package name */
    private final ConstraintLayout f23754h;

    /* renamed from: i  reason: collision with root package name */
    private long f23755i;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f23753g = sparseIntArray;
        sparseIntArray.put(R.id.genterText, 4);
    }

    public bv(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 5, f23752f, f23753g));
    }

    private bv(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[4], objArr[2], objArr[3]);
        this.f23755i = -1;
        this.f23747a.setTag((Object) null);
        this.f23754h = objArr[0];
        this.f23754h.setTag((Object) null);
        this.f23749c.setTag((Object) null);
        this.f23750d.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f23755i = 2;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f23755i != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.P != i2) {
            return false;
        }
        a((CJRFlightMBPassenger) obj);
        return true;
    }

    public final void a(CJRFlightMBPassenger cJRFlightMBPassenger) {
        this.f23751e = cJRFlightMBPassenger;
        synchronized (this) {
            this.f23755i |= 1;
        }
        notifyPropertyChanged(a.P);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j;
        String str;
        synchronized (this) {
            j = this.f23755i;
            this.f23755i = 0;
        }
        CJRFlightMBPassenger cJRFlightMBPassenger = this.f23751e;
        String str2 = null;
        int i2 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i2 == 0 || cJRFlightMBPassenger == null) {
            str = null;
        } else {
            str2 = cJRFlightMBPassenger.getLastname();
            str = cJRFlightMBPassenger.getFormattedFirstName();
        }
        if (i2 != 0) {
            com.travel.flight.flightticket.b.a.b(this.f23747a, cJRFlightMBPassenger);
            d.a(this.f23749c, (CharSequence) str);
            d.a(this.f23750d, (CharSequence) str2);
        }
    }
}
