package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import com.travel.flight.e.a.a;
import com.travel.flight.flightSRPV2.a.x;
import com.travel.flight.flightSRPV2.a.z;
import com.travel.flight.flightSRPV2.c.c;

public final class cp extends co implements a.C0456a {

    /* renamed from: h  reason: collision with root package name */
    private static final ViewDataBinding.b f23838h = null;

    /* renamed from: i  reason: collision with root package name */
    private static final SparseIntArray f23839i = null;
    private final View.OnClickListener j;
    private long k;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public cp(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, f23838h, f23839i));
    }

    private cp(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[0], objArr[3], objArr[1], objArr[2]);
        this.k = -1;
        this.f23831a.setTag((Object) null);
        this.f23832b.setTag((Object) null);
        this.f23833c.setTag((Object) null);
        this.f23834d.setTag((Object) null);
        setRootTag(view);
        this.j = new a(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.k = 8;
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
        if (com.travel.flight.a.R == i2) {
            a((z) obj);
        } else if (com.travel.flight.a.H == i2) {
            a((x) obj);
        } else if (com.travel.flight.a.Q != i2) {
            return false;
        } else {
            a((Integer) obj);
        }
        return true;
    }

    public final void a(z zVar) {
        this.f23836f = zVar;
        synchronized (this) {
            this.k |= 1;
        }
        notifyPropertyChanged(com.travel.flight.a.R);
        super.requestRebind();
    }

    public final void a(x xVar) {
        this.f23835e = xVar;
        synchronized (this) {
            this.k |= 2;
        }
        notifyPropertyChanged(com.travel.flight.a.H);
        super.requestRebind();
    }

    public final void a(Integer num) {
        this.f23837g = num;
        synchronized (this) {
            this.k |= 4;
        }
        notifyPropertyChanged(com.travel.flight.a.Q);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j2;
        synchronized (this) {
            j2 = this.k;
            this.k = 0;
        }
        String str = null;
        x xVar = this.f23835e;
        Integer num = this.f23837g;
        int i2 = 0;
        int i3 = ((10 & j2) > 0 ? 1 : ((10 & j2) == 0 ? 0 : -1));
        if (!(i3 == 0 || xVar == null)) {
            str = xVar.a();
        }
        int i4 = ((12 & j2) > 0 ? 1 : ((12 & j2) == 0 ? 0 : -1));
        if (i4 != 0) {
            i2 = ViewDataBinding.safeUnbox(num);
        }
        if (i4 != 0) {
            c.a(this.f23832b, i2);
        }
        if ((j2 & 8) != 0) {
            this.f23832b.setOnClickListener(this.j);
        }
        if (i3 != 0) {
            c.a(this.f23833c, xVar);
            d.a(this.f23834d, (CharSequence) str);
        }
    }

    public final void a(int i2, View view) {
        z zVar = this.f23836f;
        x xVar = this.f23835e;
        if (zVar != null) {
            zVar.removeOneWayFilter(xVar);
        }
    }
}
