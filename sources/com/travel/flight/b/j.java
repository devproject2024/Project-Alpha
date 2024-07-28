package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import androidx.databinding.i;
import com.travel.flight.R;
import com.travel.flight.e.a.a;
import com.travel.flight.flightSRPV2.a.d;
import com.travel.flight.utils.c;
import kotlin.g.b.k;

public final class j extends i implements a.C0456a {

    /* renamed from: g  reason: collision with root package name */
    private static final ViewDataBinding.b f23987g = null;

    /* renamed from: h  reason: collision with root package name */
    private static final SparseIntArray f23988h;

    /* renamed from: i  reason: collision with root package name */
    private final View.OnClickListener f23989i;
    private long j;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f23988h = sparseIntArray;
        sparseIntArray.put(R.id.txt_rupee_symbol, 4);
    }

    public j(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 5, f23987g, f23988h));
    }

    private j(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[0], objArr[2], objArr[3], objArr[4]);
        this.j = -1;
        this.f23981a.setTag((Object) null);
        this.f23982b.setTag((Object) null);
        this.f23983c.setTag((Object) null);
        this.f23984d.setTag((Object) null);
        setRootTag(view);
        this.f23989i = new a(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.j = 4;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.j != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (com.travel.flight.a.q != i2) {
            return false;
        }
        a((d) obj);
        return true;
    }

    public final void a(d dVar) {
        this.f23986f = dVar;
        synchronized (this) {
            this.j |= 2;
        }
        notifyPropertyChanged(com.travel.flight.a.q);
        super.requestRebind();
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
            this.j |= 1;
        }
        return true;
    }

    public final void executeBindings() {
        long j2;
        String str;
        String str2;
        String str3;
        i<Boolean> iVar;
        int i2;
        synchronized (this) {
            j2 = this.j;
            this.j = 0;
        }
        d dVar = this.f23986f;
        Boolean bool = null;
        int i3 = ((7 & j2) > 0 ? 1 : ((7 & j2) == 0 ? 0 : -1));
        if (i3 != 0) {
            if ((j2 & 6) != 0) {
                if (dVar != null) {
                    str3 = dVar.f24096b;
                    i2 = dVar.f24098d;
                    str = dVar.f24095a;
                } else {
                    str3 = null;
                    str = null;
                    i2 = 0;
                }
                str2 = c.h(String.valueOf(i2));
            } else {
                str3 = null;
                str2 = null;
                str = null;
            }
            if (dVar != null) {
                iVar = dVar.f24099e;
            } else {
                iVar = null;
            }
            updateRegistration(0, (h) iVar);
            if (iVar != null) {
                bool = iVar.get();
            }
        } else {
            str3 = null;
            str2 = null;
            str = null;
        }
        if ((6 & j2) != 0) {
            com.travel.flight.flightSRPV2.c.c.a(this.f23981a, str, getDrawableFromResource(this.f23981a, R.drawable.pre_f_defaultcarrier), getDrawableFromResource(this.f23981a, R.drawable.pre_f_defaultcarrier));
            androidx.databinding.a.d.a((TextView) this.f23983c, (CharSequence) str3);
            androidx.databinding.a.d.a(this.f23984d, (CharSequence) str2);
        }
        if (i3 != 0) {
            com.travel.flight.flightSRPV2.c.c.b((View) this.f23982b, bool);
        }
        if ((j2 & 4) != 0) {
            this.f23982b.setOnClickListener(this.f23989i);
        }
    }

    public final void a(int i2, View view) {
        d dVar = this.f23986f;
        if (dVar != null) {
            Boolean bool = dVar.f24099e.get();
            if (bool == null) {
                bool = Boolean.FALSE;
            }
            k.a((Object) bool, "isAirlineSelected.get() ?: false");
            dVar.f24099e.set(Boolean.valueOf(true ^ bool.booleanValue()));
        }
    }
}
