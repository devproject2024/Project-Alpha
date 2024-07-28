package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.travel.flight.a;
import com.travel.flight.pojo.modifyBooking.CJRFlightMBPassenger;

public final class v extends u {

    /* renamed from: c  reason: collision with root package name */
    private static final ViewDataBinding.b f24032c = null;

    /* renamed from: d  reason: collision with root package name */
    private static final SparseIntArray f24033d = null;

    /* renamed from: e  reason: collision with root package name */
    private final ConstraintLayout f24034e;

    /* renamed from: f  reason: collision with root package name */
    private final TextView f24035f;

    /* renamed from: g  reason: collision with root package name */
    private long f24036g;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public v(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 3, f24032c, f24033d));
    }

    private v(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1]);
        this.f24036g = -1;
        this.f24030a.setTag((Object) null);
        this.f24034e = objArr[0];
        this.f24034e.setTag((Object) null);
        this.f24035f = objArr[2];
        this.f24035f.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f24036g = 2;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f24036g != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.P != i2) {
            return false;
        }
        this.f24031b = (CJRFlightMBPassenger) obj;
        synchronized (this) {
            this.f24036g |= 1;
        }
        notifyPropertyChanged(a.P);
        super.requestRebind();
        return true;
    }

    public final void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f24036g;
            this.f24036g = 0;
        }
        CJRFlightMBPassenger cJRFlightMBPassenger = this.f24031b;
        if ((j & 3) != 0) {
            com.travel.flight.flightticket.b.a.a(this.f24030a, cJRFlightMBPassenger);
            com.travel.flight.flightticket.b.a.a(this.f24035f, cJRFlightMBPassenger);
        }
    }
}
