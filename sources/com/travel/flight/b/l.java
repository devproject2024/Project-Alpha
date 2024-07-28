package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.travel.flight.R;
import com.travel.flight.a;
import com.travel.flight.pojo.modifyBooking.CJRFlightMBCharge;
import com.travel.flight.pojo.modifyBooking.CJRFlightMBChargesBody;

public final class l extends k {
    private static final ViewDataBinding.b k = null;
    private static final SparseIntArray l;
    private final ConstraintLayout m;
    private long n;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        l = sparseIntArray;
        sparseIntArray.put(R.id.left_guideline, 7);
        l.put(R.id.right_guideline, 8);
    }

    public l(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 9, k, l));
    }

    private l(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[2], objArr[5], objArr[3], objArr[7], objArr[6], objArr[8], objArr[4], objArr[1]);
        this.n = -1;
        this.f23990a.setTag((Object) null);
        this.f23991b.setTag((Object) null);
        this.f23992c.setTag((Object) null);
        this.m = objArr[0];
        this.m.setTag((Object) null);
        this.f23994e.setTag((Object) null);
        this.f23996g.setTag((Object) null);
        this.f23997h.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.n = 4;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.n != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.w == i2) {
            this.f23998i = (CJRFlightMBChargesBody) obj;
            synchronized (this) {
                this.n |= 1;
            }
            notifyPropertyChanged(a.w);
            super.requestRebind();
        } else if (a.L != i2) {
            return false;
        } else {
            this.j = (CJRFlightMBCharge) obj;
            synchronized (this) {
                this.n |= 2;
            }
            notifyPropertyChanged(a.L);
            super.requestRebind();
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00b4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r25 = this;
            r1 = r25
            monitor-enter(r25)
            long r2 = r1.n     // Catch:{ all -> 0x0103 }
            r4 = 0
            r1.n = r4     // Catch:{ all -> 0x0103 }
            monitor-exit(r25)     // Catch:{ all -> 0x0103 }
            com.travel.flight.pojo.modifyBooking.CJRFlightMBChargesBody r0 = r1.f23998i
            com.travel.flight.pojo.modifyBooking.CJRFlightMBCharge r6 = r1.j
            r7 = 7
            long r9 = r2 & r7
            r11 = 6
            r13 = 0
            r14 = 0
            int r15 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x00ba
            if (r0 == 0) goto L_0x0021
            java.lang.Boolean r0 = r0.getCp_enabled()
            goto L_0x0022
        L_0x0021:
            r0 = r13
        L_0x0022:
            if (r6 == 0) goto L_0x002d
            com.travel.flight.pojo.modifyBooking.CJRFlightMBTravelerCharges r9 = r6.getAdult()
            com.travel.flight.pojo.modifyBooking.CJRFlightMBTravelerCharges r10 = r6.getInfant()
            goto L_0x002f
        L_0x002d:
            r9 = r13
            r10 = r9
        L_0x002f:
            long r15 = r2 & r11
            r17 = 8
            r18 = 1
            int r19 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r19 == 0) goto L_0x004f
            if (r10 == 0) goto L_0x003d
            r15 = 1
            goto L_0x003e
        L_0x003d:
            r15 = 0
        L_0x003e:
            if (r19 == 0) goto L_0x0049
            if (r15 == 0) goto L_0x0045
            r19 = 64
            goto L_0x0047
        L_0x0045:
            r19 = 32
        L_0x0047:
            long r2 = r2 | r19
        L_0x0049:
            if (r15 == 0) goto L_0x004c
            goto L_0x004f
        L_0x004c:
            r15 = 8
            goto L_0x0050
        L_0x004f:
            r15 = 0
        L_0x0050:
            long r19 = r2 & r11
            int r16 = (r19 > r4 ? 1 : (r19 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x00b4
            if (r6 == 0) goto L_0x0065
            java.util.List r13 = r6.getNotes()
            java.lang.String r19 = r6.getTitle()
            java.util.List r6 = r6.getInfo()
            goto L_0x0068
        L_0x0065:
            r6 = r13
            r19 = r6
        L_0x0068:
            if (r13 == 0) goto L_0x006f
            int r20 = r13.size()
            goto L_0x0071
        L_0x006f:
            r20 = 0
        L_0x0071:
            if (r6 == 0) goto L_0x0078
            int r21 = r6.size()
            goto L_0x007a
        L_0x0078:
            r21 = 0
        L_0x007a:
            if (r20 <= 0) goto L_0x007f
            r20 = 1
            goto L_0x0081
        L_0x007f:
            r20 = 0
        L_0x0081:
            if (r21 <= 0) goto L_0x0084
            goto L_0x0086
        L_0x0084:
            r18 = 0
        L_0x0086:
            if (r16 == 0) goto L_0x0091
            if (r20 == 0) goto L_0x008d
            r21 = 16
            goto L_0x008f
        L_0x008d:
            r21 = 8
        L_0x008f:
            long r2 = r2 | r21
        L_0x0091:
            long r21 = r2 & r11
            int r16 = (r21 > r4 ? 1 : (r21 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x00a0
            if (r18 == 0) goto L_0x009c
            r21 = 256(0x100, double:1.265E-321)
            goto L_0x009e
        L_0x009c:
            r21 = 128(0x80, double:6.32E-322)
        L_0x009e:
            long r2 = r2 | r21
        L_0x00a0:
            if (r20 == 0) goto L_0x00a5
            r16 = 0
            goto L_0x00a7
        L_0x00a5:
            r16 = 8
        L_0x00a7:
            if (r18 == 0) goto L_0x00aa
            goto L_0x00ac
        L_0x00aa:
            r14 = 8
        L_0x00ac:
            r23 = r6
            r6 = r14
            r14 = r16
            r24 = r19
            goto L_0x00c3
        L_0x00b4:
            r23 = r13
            r24 = r23
            r6 = 0
            goto L_0x00c3
        L_0x00ba:
            r0 = r13
            r9 = r0
            r10 = r9
            r23 = r10
            r24 = r23
            r6 = 0
            r15 = 0
        L_0x00c3:
            long r7 = r7 & r2
            int r16 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x00d6
            android.widget.TextView r7 = r1.f23990a
            java.lang.String r8 = "adult"
            com.travel.flight.flightticket.b.a.a(r7, r9, r8, r0)
            android.widget.TextView r7 = r1.f23992c
            java.lang.String r8 = "infant"
            com.travel.flight.flightticket.b.a.a(r7, r10, r8, r0)
        L_0x00d6:
            long r2 = r2 & r11
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0102
            android.view.View r0 = r1.f23991b
            r0.setVisibility(r14)
            android.widget.TextView r0 = r1.f23992c
            r0.setVisibility(r15)
            androidx.recyclerview.widget.RecyclerView r0 = r1.f23994e
            r0.setVisibility(r14)
            androidx.recyclerview.widget.RecyclerView r0 = r1.f23994e
            com.travel.flight.flightticket.b.a.a((androidx.recyclerview.widget.RecyclerView) r0, (java.util.List<? extends java.lang.Object>) r13)
            androidx.recyclerview.widget.RecyclerView r0 = r1.f23996g
            r0.setVisibility(r6)
            androidx.recyclerview.widget.RecyclerView r0 = r1.f23996g
            r13 = r23
            com.travel.flight.flightticket.b.a.a((androidx.recyclerview.widget.RecyclerView) r0, (java.util.List<? extends java.lang.Object>) r13)
            android.widget.TextView r0 = r1.f23997h
            r13 = r24
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r13)
        L_0x0102:
            return
        L_0x0103:
            r0 = move-exception
            monitor-exit(r25)     // Catch:{ all -> 0x0103 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.b.l.executeBindings():void");
    }
}
