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
import net.one97.paytm.hotels2.c.a.b;
import net.one97.paytm.hotels2.c.a.d;

public final class dp extends Cdo implements b.a, d.a {
    private static final ViewDataBinding.b u = null;
    private static final SparseIntArray v;
    private final ConstraintLayout w;
    private final View.OnClickListener x;
    private final Runnable y;
    private long z;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        v = sparseIntArray;
        sparseIntArray.put(R.id.tv_title, 8);
        v.put(R.id.iv_hotelRoomCard, 9);
        v.put(R.id.iv_hotel_room, 10);
        v.put(R.id.iv_map, 11);
        v.put(R.id.tv_room_meals_plan, 12);
        v.put(R.id.tv_options_refund, 13);
        v.put(R.id.tv_options_no_refund, 14);
        v.put(R.id.tv_room_optn_one, 15);
        v.put(R.id.tv_room_optn_two, 16);
        v.put(R.id.tv_room_optn_three, 17);
        v.put(R.id.line_one, 18);
    }

    public dp(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 19, u, v));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private dp(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[10], objArr[9], objArr[11], objArr[18], objArr[3], objArr[14], objArr[13], objArr[7], objArr[5], objArr[4], objArr[12], objArr[2], objArr[15], objArr[17], objArr[16], objArr[6], objArr[8]);
        this.z = -1;
        this.f29501a.setTag((Object) null);
        this.w = objArr[0];
        this.w.setTag((Object) null);
        this.f29506f.setTag((Object) null);
        this.f29509i.setTag((Object) null);
        this.j.setTag((Object) null);
        this.k.setTag((Object) null);
        this.m.setTag((Object) null);
        this.q.setTag((Object) null);
        setRootTag(view);
        this.x = new b(this, 2);
        this.y = new d(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.z = 128;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.z != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.F == i2) {
            a((ReviewViewModel) obj);
        } else if (a.Q != i2) {
            return false;
        } else {
            a((RoomSelectionViewModel) obj);
        }
        return true;
    }

    public final void a(ReviewViewModel reviewViewModel) {
        this.t = reviewViewModel;
        synchronized (this) {
            this.z |= 32;
        }
        notifyPropertyChanged(a.F);
        super.requestRebind();
    }

    public final void a(RoomSelectionViewModel roomSelectionViewModel) {
        this.s = roomSelectionViewModel;
        synchronized (this) {
            this.z |= 64;
        }
        notifyPropertyChanged(a.Q);
        super.requestRebind();
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return c(i3);
        }
        if (i2 == 1) {
            return d(i3);
        }
        if (i2 == 2) {
            return e(i3);
        }
        if (i2 == 3) {
            return f(i3);
        }
        if (i2 != 4) {
            return false;
        }
        return g(i3);
    }

    private boolean c(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.z |= 1;
        }
        return true;
    }

    private boolean d(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.z |= 2;
        }
        return true;
    }

    private boolean e(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.z |= 4;
        }
        return true;
    }

    private boolean f(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.z |= 8;
        }
        return true;
    }

    private boolean g(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.z |= 16;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r26 = this;
            r1 = r26
            monitor-enter(r26)
            long r2 = r1.z     // Catch:{ all -> 0x0110 }
            r4 = 0
            r1.z = r4     // Catch:{ all -> 0x0110 }
            monitor-exit(r26)     // Catch:{ all -> 0x0110 }
            net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel r0 = r1.s
            r8 = 223(0xdf, double:1.1E-321)
            long r8 = r8 & r2
            r10 = 208(0xd0, double:1.03E-321)
            r12 = 196(0xc4, double:9.7E-322)
            r14 = 194(0xc2, double:9.6E-322)
            r16 = 200(0xc8, double:9.9E-322)
            r18 = 193(0xc1, double:9.54E-322)
            r20 = 0
            int r21 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r21 == 0) goto L_0x00b9
            long r8 = r2 & r18
            int r21 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r21 == 0) goto L_0x003b
            if (r0 == 0) goto L_0x002c
            androidx.lifecycle.y r8 = r0.get_selectedRoomOptionTitle()
            goto L_0x002e
        L_0x002c:
            r8 = r20
        L_0x002e:
            r9 = 0
            r1.updateLiveDataRegistration(r9, r8)
            if (r8 == 0) goto L_0x003b
            java.lang.Object r8 = r8.getValue()
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x003d
        L_0x003b:
            r8 = r20
        L_0x003d:
            long r21 = r2 & r14
            int r9 = (r21 > r4 ? 1 : (r21 == r4 ? 0 : -1))
            if (r9 == 0) goto L_0x0059
            if (r0 == 0) goto L_0x004a
            androidx.lifecycle.y r9 = r0.get_selectedRoomNightTitle()
            goto L_0x004c
        L_0x004a:
            r9 = r20
        L_0x004c:
            r6 = 1
            r1.updateLiveDataRegistration(r6, r9)
            if (r9 == 0) goto L_0x0059
            java.lang.Object r6 = r9.getValue()
            java.lang.String r6 = (java.lang.String) r6
            goto L_0x005b
        L_0x0059:
            r6 = r20
        L_0x005b:
            long r23 = r2 & r12
            int r7 = (r23 > r4 ? 1 : (r23 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x0077
            if (r0 == 0) goto L_0x0068
            androidx.lifecycle.y r7 = r0.get_bedType()
            goto L_0x006a
        L_0x0068:
            r7 = r20
        L_0x006a:
            r9 = 2
            r1.updateLiveDataRegistration(r9, r7)
            if (r7 == 0) goto L_0x0077
            java.lang.Object r7 = r7.getValue()
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x0079
        L_0x0077:
            r7 = r20
        L_0x0079:
            long r23 = r2 & r16
            int r9 = (r23 > r4 ? 1 : (r23 == r4 ? 0 : -1))
            if (r9 == 0) goto L_0x0095
            if (r0 == 0) goto L_0x0086
            androidx.lifecycle.y r9 = r0.get_selectedRoomTitle()
            goto L_0x0088
        L_0x0086:
            r9 = r20
        L_0x0088:
            r12 = 3
            r1.updateLiveDataRegistration(r12, r9)
            if (r9 == 0) goto L_0x0095
            java.lang.Object r9 = r9.getValue()
            java.lang.String r9 = (java.lang.String) r9
            goto L_0x0097
        L_0x0095:
            r9 = r20
        L_0x0097:
            long r12 = r2 & r10
            int r25 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r25 == 0) goto L_0x00be
            if (r0 == 0) goto L_0x00a4
            androidx.lifecycle.y r0 = r0.get_selectedRoomPrice()
            goto L_0x00a6
        L_0x00a4:
            r0 = r20
        L_0x00a6:
            r12 = 4
            r1.updateLiveDataRegistration(r12, r0)
            if (r0 == 0) goto L_0x00b4
            java.lang.Object r0 = r0.getValue()
            r20 = r0
            java.lang.Double r20 = (java.lang.Double) r20
        L_0x00b4:
            double r12 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Double) r20)
            goto L_0x00c0
        L_0x00b9:
            r6 = r20
            r7 = r6
            r8 = r7
            r9 = r8
        L_0x00be:
            r12 = 0
        L_0x00c0:
            r20 = 128(0x80, double:6.32E-322)
            long r20 = r2 & r20
            int r0 = (r20 > r4 ? 1 : (r20 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00d6
            android.widget.TextView r0 = r1.f29501a
            java.lang.Runnable r10 = r1.y
            net.one97.paytm.hotel4.utils.g.a(r0, r10)
            android.widget.TextView r0 = r1.f29509i
            android.view.View$OnClickListener r10 = r1.x
            r0.setOnClickListener(r10)
        L_0x00d6:
            long r10 = r2 & r16
            int r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00e1
            android.widget.TextView r0 = r1.f29506f
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r9)
        L_0x00e1:
            long r9 = r2 & r14
            int r0 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00ec
            android.widget.TextView r0 = r1.j
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r6)
        L_0x00ec:
            r9 = 196(0xc4, double:9.7E-322)
            long r9 = r9 & r2
            int r0 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00f8
            android.widget.TextView r0 = r1.k
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r7)
        L_0x00f8:
            long r6 = r2 & r18
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0103
            android.widget.TextView r0 = r1.m
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r8)
        L_0x0103:
            r6 = 208(0xd0, double:1.03E-321)
            long r2 = r2 & r6
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x010f
            android.widget.TextView r0 = r1.q
            net.one97.paytm.hotel4.utils.a.a((android.widget.TextView) r0, (double) r12)
        L_0x010f:
            return
        L_0x0110:
            r0 = move-exception
            monitor-exit(r26)     // Catch:{ all -> 0x0110 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotels2.b.dp.executeBindings():void");
    }

    public final void a(int i2) {
        RoomSelectionViewModel roomSelectionViewModel = this.s;
        if (roomSelectionViewModel != null) {
            roomSelectionViewModel.onInclusionsPressedReviewScreen();
        }
    }

    public final void b(int i2) {
        ReviewViewModel reviewViewModel = this.t;
        if (reviewViewModel != null) {
            reviewViewModel.showCancellationPolicy();
        }
    }
}
