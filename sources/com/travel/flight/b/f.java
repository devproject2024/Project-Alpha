package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import com.travel.flight.R;
import com.travel.flight.a;

public final class f extends e {
    private static final ViewDataBinding.b n = null;
    private static final SparseIntArray o;
    private final FrameLayout p;
    private long q;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        o = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 8);
        o.put(R.id.prioritychecking_filter_close, 9);
        o.put(R.id.tv_filter, 10);
        o.put(R.id.progressparent, 11);
        o.put(R.id.progress, 12);
    }

    public f(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 13, n, o));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private f(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[7], objArr[6], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[9], objArr[12], objArr[11], objArr[8], objArr[10]);
        this.q = -1;
        this.f23963a.setTag((Object) null);
        this.f23964b.setTag((Object) null);
        this.p = objArr[0];
        this.p.setTag((Object) null);
        this.f23965c.setTag((Object) null);
        this.f23966d.setTag((Object) null);
        this.f23967e.setTag((Object) null);
        this.f23968f.setTag((Object) null);
        this.f23969g.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.q = 2;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.q != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.T != i2) {
            return false;
        }
        a((net.one97.paytmflight.common.entity.prioritycheckinentity.a) obj);
        return true;
    }

    public final void a(net.one97.paytmflight.common.entity.prioritycheckinentity.a aVar) {
        this.m = aVar;
        synchronized (this) {
            this.q |= 1;
        }
        notifyPropertyChanged(a.T);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j;
        int i2;
        String str;
        String str2;
        String str3;
        String str4;
        boolean z;
        long j2;
        long j3;
        synchronized (this) {
            j = this.q;
            this.q = 0;
        }
        net.one97.paytmflight.common.entity.prioritycheckinentity.a aVar = this.m;
        int i3 = 0;
        String str5 = null;
        int i4 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i4 != 0) {
            if (aVar != null) {
                str5 = aVar.f30022c;
                str3 = aVar.f30021b;
                z = aVar.f30020a;
                str2 = aVar.f30025f;
                str = aVar.f30023d;
                str4 = aVar.f30024e;
            } else {
                str4 = null;
                str3 = null;
                str2 = null;
                str = null;
                z = false;
            }
            if (i4 != 0) {
                if (z) {
                    j3 = j | 8;
                    j2 = 32;
                } else {
                    j3 = j | 4;
                    j2 = 16;
                }
                j = j3 | j2;
            }
            i2 = z ? 0 : 8;
            if (z) {
                i3 = 8;
            }
        } else {
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            i2 = 0;
        }
        if ((j & 3) != 0) {
            this.f23963a.setVisibility(i2);
            this.f23964b.setVisibility(i3);
            com.travel.flight.h.a.a(this.f23965c, str3);
            d.a(this.f23966d, (CharSequence) str5);
            d.a(this.f23967e, (CharSequence) str);
            d.a(this.f23968f, (CharSequence) str4);
            d.a(this.f23969g, (CharSequence) str2);
        }
    }
}
