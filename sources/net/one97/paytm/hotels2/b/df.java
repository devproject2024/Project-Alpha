package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.hotel4.viewmodel.ReviewViewModel;
import net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;

public final class df extends de {
    private static final ViewDataBinding.b m = null;
    private static final SparseIntArray n;
    private final ConstraintLayout o;
    private long p;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        n = sparseIntArray;
        sparseIntArray.put(R.id.v_line_divi, 3);
        n.put(R.id.tv_title, 4);
        n.put(R.id.rv_room_config, 5);
        n.put(R.id.v_line, 6);
        n.put(R.id.tv_tax, 7);
        n.put(R.id.rv_room_config_tax, 8);
        n.put(R.id.v_line_one, 9);
        n.put(R.id.tv_total_text, 10);
    }

    public df(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 11, m, n));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private df(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[5], objArr[8], objArr[1], objArr[7], objArr[4], objArr[10], objArr[2], objArr[6], objArr[3], objArr[9]);
        this.p = -1;
        this.o = objArr[0];
        this.o.setTag((Object) null);
        this.f29458c.setTag((Object) null);
        this.f29462g.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.p = 16;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.p != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.Q == i2) {
            a((RoomSelectionViewModel) obj);
        } else if (a.t != i2) {
            return false;
        } else {
            this.l = (ReviewViewModel) obj;
        }
        return true;
    }

    public final void a(RoomSelectionViewModel roomSelectionViewModel) {
        this.k = roomSelectionViewModel;
        synchronized (this) {
            this.p |= 4;
        }
        notifyPropertyChanged(a.Q);
        super.requestRebind();
    }

    public final void a(ReviewViewModel reviewViewModel) {
        this.l = reviewViewModel;
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
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.p |= 1;
        }
        return true;
    }

    private boolean b(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.p |= 2;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r17 = this;
            r1 = r17
            monitor-enter(r17)
            long r2 = r1.p     // Catch:{ all -> 0x0074 }
            r4 = 0
            r1.p = r4     // Catch:{ all -> 0x0074 }
            monitor-exit(r17)     // Catch:{ all -> 0x0074 }
            net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel r0 = r1.k
            r6 = 0
            r8 = 23
            long r8 = r8 & r2
            r10 = 22
            r12 = 21
            r14 = 0
            int r15 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x005e
            long r8 = r2 & r12
            int r15 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x0035
            if (r0 == 0) goto L_0x0027
            androidx.lifecycle.y r8 = r0.get_selectedRoomOptionTitle()
            goto L_0x0028
        L_0x0027:
            r8 = r14
        L_0x0028:
            r9 = 0
            r1.updateLiveDataRegistration(r9, r8)
            if (r8 == 0) goto L_0x0035
            java.lang.Object r8 = r8.getValue()
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x0036
        L_0x0035:
            r8 = r14
        L_0x0036:
            long r15 = r2 & r10
            int r9 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r9 == 0) goto L_0x005f
            if (r0 == 0) goto L_0x0043
            androidx.lifecycle.y r0 = r0.get_selectedRoomFinalPriceWithTax()
            goto L_0x0044
        L_0x0043:
            r0 = r14
        L_0x0044:
            r6 = 1
            r1.updateLiveDataRegistration(r6, r0)
            if (r0 == 0) goto L_0x0051
            java.lang.Object r0 = r0.getValue()
            r14 = r0
            java.lang.Double r14 = (java.lang.Double) r14
        L_0x0051:
            double r6 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Double) r14)
            java.lang.Double r0 = java.lang.Double.valueOf(r6)
            double r6 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Double) r0)
            goto L_0x005f
        L_0x005e:
            r8 = r14
        L_0x005f:
            long r12 = r12 & r2
            int r0 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0069
            android.widget.TextView r0 = r1.f29458c
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r8)
        L_0x0069:
            long r2 = r2 & r10
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0073
            android.widget.TextView r0 = r1.f29462g
            net.one97.paytm.hotel4.utils.a.a((android.widget.TextView) r0, (double) r6)
        L_0x0073:
            return
        L_0x0074:
            r0 = move-exception
            monitor-exit(r17)     // Catch:{ all -> 0x0074 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotels2.b.df.executeBindings():void");
    }
}
