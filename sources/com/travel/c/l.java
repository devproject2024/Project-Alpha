package com.travel.c;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.q;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.R;
import com.travel.a;
import com.travel.booking.c.b;
import com.travel.booking.d.g;
import com.travel.booking.d.h;
import com.travel.booking.d.i;
import com.travel.booking.datamodel.BookingInfo;
import com.travel.booking.datamodel.CJRTravelBookingData;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m;

public final class l extends k {

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.b f22902e;

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f22903f = null;

    /* renamed from: g  reason: collision with root package name */
    private final ConstraintLayout f22904g;

    /* renamed from: h  reason: collision with root package name */
    private long f22905h;

    static {
        ViewDataBinding.b bVar = new ViewDataBinding.b(3);
        f22902e = bVar;
        bVar.a(0, new String[]{"layout_travel_booking_no_data"}, new int[]{2}, new int[]{R.layout.layout_travel_booking_no_data});
    }

    public l(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 3, f22902e, f22903f));
    }

    private l(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[2], objArr[1]);
        this.f22905h = -1;
        this.f22904g = objArr[0];
        this.f22904g.setTag((Object) null);
        this.f22899b.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f22905h = 8;
        }
        this.f22898a.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.f22898a.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean hasPendingBindings() {
        /*
            r6 = this;
            monitor-enter(r6)
            long r0 = r6.f22905h     // Catch:{ all -> 0x0018 }
            r2 = 0
            r4 = 1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x000c
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            return r4
        L_0x000c:
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            com.travel.c.m r0 = r6.f22898a
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
        throw new UnsupportedOperationException("Method not decompiled: com.travel.c.l.hasPendingBindings():boolean");
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.f21419d == i2) {
            a((CJRTravelBookingData) obj);
        } else if (a.f21417b != i2) {
            return false;
        } else {
            a((com.travel.booking.e.a) obj);
        }
        return true;
    }

    public final void a(CJRTravelBookingData cJRTravelBookingData) {
        this.f22900c = cJRTravelBookingData;
        synchronized (this) {
            this.f22905h |= 2;
        }
        notifyPropertyChanged(a.f21419d);
        super.requestRebind();
    }

    public final void a(com.travel.booking.e.a aVar) {
        this.f22901d = aVar;
        synchronized (this) {
            this.f22905h |= 4;
        }
        notifyPropertyChanged(a.f21417b);
        super.requestRebind();
    }

    public final void setLifecycleOwner(q qVar) {
        super.setLifecycleOwner(qVar);
        this.f22898a.setLifecycleOwner(qVar);
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return a(i3);
    }

    private boolean a(int i2) {
        if (i2 != a.f21416a) {
            return false;
        }
        synchronized (this) {
            this.f22905h |= 1;
        }
        return true;
    }

    public final void executeBindings() {
        long j;
        RecyclerView.a aVar;
        int i2;
        int i3;
        synchronized (this) {
            j = this.f22905h;
            this.f22905h = 0;
        }
        CJRTravelBookingData cJRTravelBookingData = this.f22900c;
        com.travel.booking.e.a aVar2 = this.f22901d;
        int i4 = 0;
        if (!((j & 14) == 0 || (j & 10) == 0)) {
            List<BookingInfo> bookingList = cJRTravelBookingData != null ? cJRTravelBookingData.getBookingList() : null;
            if (bookingList != null) {
                i3 = bookingList.size();
            } else {
                i3 = 0;
            }
            boolean z = i3 > 0;
            if (i2 != 0) {
                j |= z ? 32 : 16;
            }
            if (!z) {
                i4 = 8;
            }
        }
        if ((j & 10) != 0) {
            this.f22898a.a(cJRTravelBookingData);
            this.f22899b.setVisibility(i4);
        }
        if ((j & 14) != 0) {
            RecyclerView recyclerView = this.f22899b;
            k.c(recyclerView, "recyclerView");
            if (cJRTravelBookingData != null) {
                int i5 = b.f21476a[cJRTravelBookingData.getBookingType().ordinal()];
                if (i5 == 1) {
                    aVar = new i(cJRTravelBookingData.getBookingList(), aVar2);
                } else if (i5 == 2) {
                    aVar = new h(cJRTravelBookingData.getBookingList(), aVar2);
                } else if (i5 == 3) {
                    aVar = new g(cJRTravelBookingData.getBookingList(), aVar2);
                } else {
                    throw new m();
                }
                recyclerView.setAdapter(aVar);
            } else {
                recyclerView.setAdapter((RecyclerView.a) null);
            }
        }
        executeBindingsOn(this.f22898a);
    }
}
