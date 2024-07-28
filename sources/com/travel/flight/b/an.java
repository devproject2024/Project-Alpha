package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.q;
import androidx.lifecycle.y;
import com.travel.flight.R;
import com.travel.flight.a;
import com.travel.flight.flightSRPV2.c.c;
import com.travel.flight.flightSRPV2.viewModel.IRTViewModel;
import com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel;
import com.travel.flight.pojo.flightticket.CJRIntlFlightList;
import java.util.List;

public final class an extends am {

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.b f23605f;

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f23606g;

    /* renamed from: h  reason: collision with root package name */
    private final ConstraintLayout f23607h;

    /* renamed from: i  reason: collision with root package name */
    private long f23608i;

    static {
        ViewDataBinding.b bVar = new ViewDataBinding.b(4);
        f23605f = bVar;
        bVar.a(0, new String[]{"layout_srp_bottom_strip_v2_irt"}, new int[]{2}, new int[]{R.layout.layout_srp_bottom_strip_v2_irt});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f23606g = sparseIntArray;
        sparseIntArray.put(R.id.pullToRefresh, 3);
    }

    public an(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, f23605f, f23606g));
    }

    private an(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[2], objArr[3], objArr[1]);
        this.f23608i = -1;
        this.f23607h = objArr[0];
        this.f23607h.setTag((Object) null);
        this.f23602c.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f23608i = 16;
        }
        this.f23600a.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.f23600a.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean hasPendingBindings() {
        /*
            r6 = this;
            monitor-enter(r6)
            long r0 = r6.f23608i     // Catch:{ all -> 0x0018 }
            r2 = 0
            r4 = 1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x000c
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            return r4
        L_0x000c:
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            com.travel.flight.b.bq r0 = r6.f23600a
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0016
            return r4
        L_0x0016:
            r0 = 0
            return r0
        L_0x0018:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.b.an.hasPendingBindings():boolean");
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.K == i2) {
            a((IRTViewModel) obj);
        } else if (a.s != i2) {
            return false;
        } else {
            this.f23603d = (SRPSharedViewModel) obj;
        }
        return true;
    }

    public final void a(IRTViewModel iRTViewModel) {
        this.f23604e = iRTViewModel;
        synchronized (this) {
            this.f23608i |= 4;
        }
        notifyPropertyChanged(a.K);
        super.requestRebind();
    }

    public final void a(SRPSharedViewModel sRPSharedViewModel) {
        this.f23603d = sRPSharedViewModel;
    }

    public final void setLifecycleOwner(q qVar) {
        super.setLifecycleOwner(qVar);
        this.f23600a.setLifecycleOwner(qVar);
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return a(i3);
        }
        if (i2 != 1) {
            return false;
        }
        return b(i3);
    }

    private boolean a(int i2) {
        if (i2 != a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.f23608i |= 1;
        }
        return true;
    }

    private boolean b(int i2) {
        if (i2 != a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.f23608i |= 2;
        }
        return true;
    }

    public final void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f23608i;
            this.f23608i = 0;
        }
        IRTViewModel iRTViewModel = this.f23604e;
        List list = null;
        int i2 = ((22 & j) > 0 ? 1 : ((22 & j) == 0 ? 0 : -1));
        if (i2 != 0) {
            y<List<CJRIntlFlightList>> intlFlightList = iRTViewModel != null ? iRTViewModel.getIntlFlightList() : null;
            updateLiveDataRegistration(1, intlFlightList);
            if (intlFlightList != null) {
                list = intlFlightList.getValue();
            }
        }
        if ((j & 20) != 0) {
            this.f23600a.a(iRTViewModel);
        }
        if (i2 != 0) {
            c.a(this.f23602c, iRTViewModel, (List<? extends CJRIntlFlightList>) list);
        }
        executeBindingsOn(this.f23600a);
    }
}
