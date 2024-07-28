package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.q;
import androidx.lifecycle.y;
import com.travel.flight.R;
import com.travel.flight.a;
import com.travel.flight.flightSRPV2.c.c;
import com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel;
import com.travel.flight.pojo.flightticket.CJRFlightSearchInput;
import com.travel.flight.pojo.flightticket.b;

public final class ar extends aq {

    /* renamed from: g  reason: collision with root package name */
    private static final ViewDataBinding.b f23624g;

    /* renamed from: h  reason: collision with root package name */
    private static final SparseIntArray f23625h;

    /* renamed from: i  reason: collision with root package name */
    private final RelativeLayout f23626i;
    private long j;

    static {
        ViewDataBinding.b bVar = new ViewDataBinding.b(6);
        f23624g = bVar;
        bVar.a(0, new String[]{"pre_f_flight_srp_v2_action_bar_loader_fragment"}, new int[]{3}, new int[]{R.layout.pre_f_flight_srp_v2_action_bar_loader_fragment});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f23625h = sparseIntArray;
        sparseIntArray.put(R.id.loading_anim, 4);
        f23625h.put(R.id.txt_hold_up, 5);
    }

    public ar(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 6, f23624g, f23625h));
    }

    private ar(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[3], objArr[4], objArr[2], objArr[1], objArr[5]);
        this.j = -1;
        this.f23626i = objArr[0];
        this.f23626i.setTag((Object) null);
        this.f23620c.setTag((Object) null);
        this.f23621d.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.j = 8;
        }
        this.f23618a.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.f23618a.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean hasPendingBindings() {
        /*
            r6 = this;
            monitor-enter(r6)
            long r0 = r6.j     // Catch:{ all -> 0x0018 }
            r2 = 0
            r4 = 1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x000c
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            return r4
        L_0x000c:
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            com.travel.flight.b.cs r0 = r6.f23618a
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
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.b.ar.hasPendingBindings():boolean");
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.f23479c != i2) {
            return false;
        }
        a((SRPSharedViewModel) obj);
        return true;
    }

    public final void a(SRPSharedViewModel sRPSharedViewModel) {
        this.f23623f = sRPSharedViewModel;
        synchronized (this) {
            this.j |= 4;
        }
        notifyPropertyChanged(a.f23479c);
        super.requestRebind();
    }

    public final void setLifecycleOwner(q qVar) {
        super.setLifecycleOwner(qVar);
        this.f23618a.setLifecycleOwner(qVar);
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
            this.j |= 1;
        }
        return true;
    }

    private boolean b(int i2) {
        if (i2 != a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.j |= 2;
        }
        return true;
    }

    public final void executeBindings() {
        long j2;
        String str;
        String str2;
        b bVar;
        b bVar2;
        synchronized (this) {
            j2 = this.j;
            this.j = 0;
        }
        SRPSharedViewModel sRPSharedViewModel = this.f23623f;
        String str3 = null;
        int i2 = ((14 & j2) > 0 ? 1 : ((14 & j2) == 0 ? 0 : -1));
        if (i2 != 0) {
            y<CJRFlightSearchInput> searchInput = sRPSharedViewModel != null ? sRPSharedViewModel.getSearchInput() : null;
            updateLiveDataRegistration(1, searchInput);
            CJRFlightSearchInput value = searchInput != null ? searchInput.getValue() : null;
            if (value != null) {
                bVar2 = value.getSource();
                bVar = value.getDestination();
                str2 = value.getSrpLoaderBanner();
            } else {
                str2 = null;
                bVar2 = null;
                bVar = null;
            }
            str = bVar2 != null ? bVar2.getCityName() : null;
            if (bVar != null) {
                str3 = bVar.getCityName();
            }
        } else {
            str2 = null;
            str = null;
        }
        if ((j2 & 12) != 0) {
            this.f23618a.a(sRPSharedViewModel);
        }
        if (i2 != 0) {
            c.a(this.f23620c, str2);
            c.b((TextView) this.f23621d, str, str3);
        }
        executeBindingsOn(this.f23618a);
    }
}
