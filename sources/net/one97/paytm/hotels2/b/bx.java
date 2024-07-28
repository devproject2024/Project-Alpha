package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.hotel4.viewmodel.HotelBookingStatusViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;

public final class bx extends bw {

    /* renamed from: h  reason: collision with root package name */
    private static final ViewDataBinding.b f29314h = null;

    /* renamed from: i  reason: collision with root package name */
    private static final SparseIntArray f29315i;
    private final LinearLayout j;
    private final TextView k;
    private long l;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f29315i = sparseIntArray;
        sparseIntArray.put(R.id.constraint_2, 7);
    }

    public bx(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 8, f29314h, f29315i));
    }

    private bx(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[2], objArr[5], objArr[6], objArr[7], objArr[3]);
        this.l = -1;
        this.f29307a.setTag((Object) null);
        this.f29308b.setTag((Object) null);
        this.f29309c.setTag((Object) null);
        this.f29310d.setTag((Object) null);
        this.j = objArr[0];
        this.j.setTag((Object) null);
        this.k = objArr[4];
        this.k.setTag((Object) null);
        this.f29312f.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.l = 4;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.l != 0) {
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
        this.f29313g = hotelBookingStatusViewModel;
        synchronized (this) {
            this.l |= 2;
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
            this.l |= 1;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r14 = this;
            monitor-enter(r14)
            long r0 = r14.l     // Catch:{ all -> 0x007d }
            r2 = 0
            r14.l = r2     // Catch:{ all -> 0x007d }
            monitor-exit(r14)     // Catch:{ all -> 0x007d }
            net.one97.paytm.hotel4.viewmodel.HotelBookingStatusViewModel r4 = r14.f29313g
            r5 = 7
            long r5 = r5 & r0
            r7 = 6
            r9 = 0
            int r10 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r10 == 0) goto L_0x0052
            long r5 = r0 & r7
            int r11 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r11 == 0) goto L_0x0025
            if (r4 == 0) goto L_0x0025
            java.lang.String r5 = r4.getRoomNights()
            java.lang.String r6 = r4.getNightText()
            goto L_0x0027
        L_0x0025:
            r5 = r9
            r6 = r5
        L_0x0027:
            if (r4 == 0) goto L_0x002e
            androidx.lifecycle.y r4 = r4.getMetaData()
            goto L_0x002f
        L_0x002e:
            r4 = r9
        L_0x002f:
            r11 = 0
            r14.updateLiveDataRegistration(r11, r4)
            if (r4 == 0) goto L_0x003c
            java.lang.Object r4 = r4.getValue()
            net.one97.paytm.hotel4.service.model.ordersummary.MetaData r4 = (net.one97.paytm.hotel4.service.model.ordersummary.MetaData) r4
            goto L_0x003d
        L_0x003c:
            r4 = r9
        L_0x003d:
            if (r4 == 0) goto L_0x004f
            java.lang.String r9 = r4.getCheckOutTime()
            java.lang.String r11 = r4.getCheckInTime()
            java.lang.String r12 = r4.checkOutDate
            java.lang.String r4 = r4.checkInDate
            r13 = r9
            r9 = r4
            r4 = r13
            goto L_0x0057
        L_0x004f:
            r4 = r9
            r11 = r4
            goto L_0x0056
        L_0x0052:
            r4 = r9
            r5 = r4
            r6 = r5
            r11 = r6
        L_0x0056:
            r12 = r11
        L_0x0057:
            if (r10 == 0) goto L_0x006d
            android.widget.TextView r10 = r14.f29307a
            androidx.databinding.a.d.a((android.widget.TextView) r10, (java.lang.CharSequence) r9)
            android.widget.TextView r9 = r14.f29308b
            androidx.databinding.a.d.a((android.widget.TextView) r9, (java.lang.CharSequence) r11)
            android.widget.TextView r9 = r14.f29309c
            androidx.databinding.a.d.a((android.widget.TextView) r9, (java.lang.CharSequence) r12)
            android.widget.TextView r9 = r14.f29310d
            androidx.databinding.a.d.a((android.widget.TextView) r9, (java.lang.CharSequence) r4)
        L_0x006d:
            long r0 = r0 & r7
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x007c
            android.widget.TextView r0 = r14.k
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r6)
            android.widget.TextView r0 = r14.f29312f
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r5)
        L_0x007c:
            return
        L_0x007d:
            r0 = move-exception
            monitor-exit(r14)     // Catch:{ all -> 0x007d }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotels2.b.bx.executeBindings():void");
    }
}
