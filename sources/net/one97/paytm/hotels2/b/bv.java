package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.hotel4.viewmodel.HotelBookingStatusViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;

public final class bv extends bu {
    private static final ViewDataBinding.b o = null;
    private static final SparseIntArray p;
    private final ConstraintLayout q;
    private long r;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p = sparseIntArray;
        sparseIntArray.put(R.id.v_line_divi, 8);
        p.put(R.id.tv_title, 9);
        p.put(R.id.iv_hotelRoomCard, 10);
        p.put(R.id.roomIcon, 11);
        p.put(R.id.v_line_one, 12);
        p.put(R.id.tv_total_text, 13);
    }

    public bv(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 14, o, p));
    }

    private bv(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[10], objArr[11], objArr[3], objArr[6], objArr[2], objArr[1], objArr[5], objArr[9], objArr[13], objArr[7], objArr[4], objArr[8], objArr[12]);
        this.r = -1;
        this.q = objArr[0];
        this.q.setTag((Object) null);
        this.f29300c.setTag((Object) null);
        this.f29301d.setTag((Object) null);
        this.f29302e.setTag((Object) null);
        this.f29303f.setTag((Object) null);
        this.f29304g.setTag((Object) null);
        this.j.setTag((Object) null);
        this.k.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.r = 4;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.r != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.y != i2) {
            return false;
        }
        a((HotelBookingStatusViewModel) obj);
        return true;
    }

    public final void a(HotelBookingStatusViewModel hotelBookingStatusViewModel) {
        this.n = hotelBookingStatusViewModel;
        synchronized (this) {
            this.r |= 2;
        }
        notifyPropertyChanged(a.y);
        super.requestRebind();
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return a(i3);
    }

    private boolean a(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.r |= 1;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r17 = this;
            r1 = r17
            monitor-enter(r17)
            long r2 = r1.r     // Catch:{ all -> 0x0094 }
            r4 = 0
            r1.r = r4     // Catch:{ all -> 0x0094 }
            monitor-exit(r17)     // Catch:{ all -> 0x0094 }
            net.one97.paytm.hotel4.viewmodel.HotelBookingStatusViewModel r0 = r1.n
            r6 = 7
            long r8 = r2 & r6
            r10 = 6
            r12 = 0
            r13 = 0
            int r14 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x0062
            long r8 = r2 & r10
            int r14 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x003b
            if (r0 == 0) goto L_0x0029
            java.lang.String r8 = r0.getTotalPrice()
            boolean r9 = r0.canShowTaxText()
            goto L_0x002b
        L_0x0029:
            r8 = r13
            r9 = 0
        L_0x002b:
            if (r14 == 0) goto L_0x0035
            if (r9 == 0) goto L_0x0032
            r14 = 16
            goto L_0x0034
        L_0x0032:
            r14 = 8
        L_0x0034:
            long r2 = r2 | r14
        L_0x0035:
            if (r9 == 0) goto L_0x0038
            goto L_0x003c
        L_0x0038:
            r9 = 8
            goto L_0x003d
        L_0x003b:
            r8 = r13
        L_0x003c:
            r9 = 0
        L_0x003d:
            if (r0 == 0) goto L_0x0044
            androidx.lifecycle.y r0 = r0.getMetaData()
            goto L_0x0045
        L_0x0044:
            r0 = r13
        L_0x0045:
            r1.updateLiveDataRegistration(r12, r0)
            if (r0 == 0) goto L_0x0051
            java.lang.Object r0 = r0.getValue()
            net.one97.paytm.hotel4.service.model.ordersummary.MetaData r0 = (net.one97.paytm.hotel4.service.model.ordersummary.MetaData) r0
            goto L_0x0052
        L_0x0051:
            r0 = r13
        L_0x0052:
            if (r0 == 0) goto L_0x005f
            java.lang.String r13 = r0.roomName
            java.lang.String r12 = r0.mealPlan
            r16 = r12
            r12 = r8
            r8 = r13
            r13 = r16
            goto L_0x0066
        L_0x005f:
            r12 = r8
            r8 = r13
            goto L_0x0066
        L_0x0062:
            r0 = r13
            r8 = r0
            r12 = r8
            r9 = 0
        L_0x0066:
            long r6 = r6 & r2
            int r14 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x007f
            androidx.recyclerview.widget.RecyclerView r6 = r1.f29300c
            net.one97.paytm.hotel4.utils.a.a((androidx.recyclerview.widget.RecyclerView) r6, (net.one97.paytm.hotel4.service.model.ordersummary.MetaData) r0)
            androidx.recyclerview.widget.RecyclerView r6 = r1.f29301d
            net.one97.paytm.hotel4.utils.a.b((androidx.recyclerview.widget.RecyclerView) r6, (net.one97.paytm.hotel4.service.model.ordersummary.MetaData) r0)
            android.widget.TextView r0 = r1.f29302e
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r13)
            android.widget.TextView r0 = r1.f29303f
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r8)
        L_0x007f:
            long r2 = r2 & r10
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0093
            android.widget.TextView r0 = r1.f29304g
            r0.setVisibility(r9)
            android.widget.TextView r0 = r1.j
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r12)
            android.view.View r0 = r1.k
            r0.setVisibility(r9)
        L_0x0093:
            return
        L_0x0094:
            r0 = move-exception
            monitor-exit(r17)     // Catch:{ all -> 0x0094 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotels2.b.bv.executeBindings():void");
    }
}
