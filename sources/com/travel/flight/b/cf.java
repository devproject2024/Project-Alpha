package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import androidx.databinding.i;
import com.travel.flight.R;
import com.travel.flight.e.a.a;
import com.travel.flight.flightSRPV2.a.d;
import com.travel.flight.flightSRPV2.c.c;
import com.travel.flight.flightSRPV2.viewModel.FlightFilterViewModel;

public final class cf extends ce implements a.C0456a {
    private static final ViewDataBinding.b j = null;
    private static final SparseIntArray k = null;
    private final View.OnClickListener l;
    private long m;

    public cf(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 7, j, k));
    }

    private cf(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[3], objArr[5], objArr[6], objArr[0], objArr[1], objArr[2], objArr[4]);
        this.m = -1;
        this.f23796a.setTag((Object) null);
        this.f23797b.setTag((Object) null);
        this.f23798c.setTag((Object) null);
        this.f23799d.setTag((Object) null);
        this.f23800e.setTag((Object) null);
        this.f23801f.setTag((Object) null);
        this.f23802g.setTag((Object) null);
        setRootTag(view);
        this.l = new a(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.m = 8;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.m != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (com.travel.flight.a.A == i2) {
            this.f23804i = (FlightFilterViewModel) obj;
            synchronized (this) {
                this.m |= 2;
            }
            notifyPropertyChanged(com.travel.flight.a.A);
            super.requestRebind();
        } else if (com.travel.flight.a.q != i2) {
            return false;
        } else {
            this.f23803h = (d) obj;
            synchronized (this) {
                this.m |= 4;
            }
            notifyPropertyChanged(com.travel.flight.a.q);
            super.requestRebind();
        }
        return true;
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return a(i3);
    }

    private boolean a(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.m |= 1;
        }
        return true;
    }

    public final void executeBindings() {
        long j2;
        int i2;
        String str;
        String str2;
        int i3;
        String str3;
        i<Boolean> iVar;
        String str4;
        int i4;
        synchronized (this) {
            j2 = this.m;
            this.m = 0;
        }
        d dVar = this.f23803h;
        boolean z = false;
        if ((j2 & 13) != 0) {
            int i5 = ((j2 & 12) > 0 ? 1 : ((j2 & 12) == 0 ? 0 : -1));
            if (i5 != 0) {
                if (dVar != null) {
                    str2 = dVar.f24096b;
                    i4 = dVar.f24097c;
                    i2 = dVar.f24098d;
                    str4 = dVar.f24095a;
                } else {
                    str2 = null;
                    i4 = 0;
                    str4 = null;
                    i2 = 0;
                }
                String concat = "(".concat(String.valueOf(i4));
                boolean z2 = i2 > 0;
                if (i5 != 0) {
                    j2 |= z2 ? 32 : 16;
                }
                String str5 = concat + ")";
                i3 = z2 ? 0 : 8;
                String str6 = str4;
                str = str5;
                str3 = str6;
            } else {
                str3 = null;
                i3 = 0;
                str2 = null;
                str = null;
                i2 = 0;
            }
            if (dVar != null) {
                iVar = dVar.f24099e;
            } else {
                iVar = null;
            }
            updateRegistration(0, (h) iVar);
            z = ViewDataBinding.safeUnbox(iVar != null ? iVar.get() : null);
        } else {
            str3 = null;
            i3 = 0;
            str2 = null;
            str = null;
            i2 = 0;
        }
        if ((j2 & 12) != 0) {
            androidx.databinding.a.d.a(this.f23796a, (CharSequence) str);
            c.a(this.f23797b, i2);
            this.f23797b.setVisibility(i3);
            this.f23798c.setVisibility(i3);
            c.a(this.f23800e, str3, getDrawableFromResource(this.f23800e, R.drawable.pre_f_defaultcarrier), getDrawableFromResource(this.f23800e, R.drawable.pre_f_defaultcarrier));
            androidx.databinding.a.d.a(this.f23801f, (CharSequence) str2);
        }
        if ((8 & j2) != 0) {
            this.f23799d.setOnClickListener(this.l);
        }
        if ((j2 & 13) != 0) {
            androidx.databinding.a.a.a(this.f23802g, z);
        }
    }

    public final void a(int i2, View view) {
        d dVar = this.f23803h;
        FlightFilterViewModel flightFilterViewModel = this.f23804i;
        if (flightFilterViewModel != null) {
            flightFilterViewModel.onAirlineSelectionChange(dVar);
        }
    }
}
