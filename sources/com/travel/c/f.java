package com.travel.c;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import com.travel.R;
import com.travel.a;

public final class f extends e {

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.b f22876e;

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f22877f;

    /* renamed from: g  reason: collision with root package name */
    private final ConstraintLayout f22878g;

    /* renamed from: h  reason: collision with root package name */
    private long f22879h;

    static {
        ViewDataBinding.b bVar = new ViewDataBinding.b(4);
        f22876e = bVar;
        bVar.a(0, new String[]{"action_bar_travel_bookings"}, new int[]{2}, new int[]{R.layout.action_bar_travel_bookings});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f22877f = sparseIntArray;
        sparseIntArray.put(R.id.view_pager, 3);
    }

    public f(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, f22876e, f22877f));
    }

    private f(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[2], objArr[1], objArr[3]);
        this.f22879h = -1;
        this.f22878g = objArr[0];
        this.f22878g.setTag((Object) null);
        this.f22873b.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f22879h = 8;
        }
        this.f22872a.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.f22872a.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean hasPendingBindings() {
        /*
            r6 = this;
            monitor-enter(r6)
            long r0 = r6.f22879h     // Catch:{ all -> 0x0018 }
            r2 = 0
            r4 = 1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x000c
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            return r4
        L_0x000c:
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            com.travel.c.a r0 = r6.f22872a
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
        throw new UnsupportedOperationException("Method not decompiled: com.travel.c.f.hasPendingBindings():boolean");
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.f21417b != i2) {
            return false;
        }
        a((com.travel.booking.e.a) obj);
        return true;
    }

    public final void a(com.travel.booking.e.a aVar) {
        this.f22875d = aVar;
        synchronized (this) {
            this.f22879h |= 4;
        }
        notifyPropertyChanged(a.f21417b);
        super.requestRebind();
    }

    public final void setLifecycleOwner(q qVar) {
        super.setLifecycleOwner(qVar);
        this.f22872a.setLifecycleOwner(qVar);
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
        if (i2 != a.f21416a) {
            return false;
        }
        synchronized (this) {
            this.f22879h |= 1;
        }
        return true;
    }

    private boolean b(int i2) {
        if (i2 != a.f21416a) {
            return false;
        }
        synchronized (this) {
            this.f22879h |= 2;
        }
        return true;
    }

    public final void executeBindings() {
        long j;
        LiveData<Boolean> liveData;
        synchronized (this) {
            j = this.f22879h;
            this.f22879h = 0;
        }
        com.travel.booking.e.a aVar = this.f22875d;
        Boolean bool = null;
        int i2 = 0;
        int i3 = ((j & 14) > 0 ? 1 : ((j & 14) == 0 ? 0 : -1));
        if (i3 != 0) {
            liveData = aVar != null ? aVar.a() : null;
            updateLiveDataRegistration(1, liveData);
            if (liveData != null) {
                bool = liveData.getValue();
            }
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            if (i3 != 0) {
                j |= safeUnbox ? 32 : 16;
            }
            if (!safeUnbox) {
                i2 = 8;
            }
        } else {
            liveData = null;
        }
        if ((14 & j) != 0) {
            this.f22872a.getRoot().setVisibility(i2);
            com.travel.booking.e.a.a(this.f22873b, liveData);
        }
        if ((j & 12) != 0) {
            this.f22872a.a(aVar);
        }
        executeBindingsOn(this.f22872a);
    }
}
