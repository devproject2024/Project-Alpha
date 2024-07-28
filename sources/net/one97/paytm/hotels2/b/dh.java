package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.hotel4.viewmodel.ReviewViewModel;
import net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;

public final class dh extends dg implements b.a {

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.b f29470f = null;

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f29471g = null;

    /* renamed from: h  reason: collision with root package name */
    private final View.OnClickListener f29472h;

    /* renamed from: i  reason: collision with root package name */
    private long f29473i;

    public dh(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 3, f29470f, f29471g));
    }

    private dh(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[0], objArr[2]);
        this.f29473i = -1;
        this.f29465a.setTag((Object) null);
        this.f29466b.setTag((Object) null);
        this.f29467c.setTag((Object) null);
        setRootTag(view);
        this.f29472h = new b(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f29473i = 64;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f29473i != 0) {
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
            a((ReviewViewModel) obj);
        }
        return true;
    }

    public final void a(RoomSelectionViewModel roomSelectionViewModel) {
        this.f29468d = roomSelectionViewModel;
        synchronized (this) {
            this.f29473i |= 16;
        }
        notifyPropertyChanged(a.Q);
        super.requestRebind();
    }

    public final void a(ReviewViewModel reviewViewModel) {
        this.f29469e = reviewViewModel;
        synchronized (this) {
            this.f29473i |= 32;
        }
        notifyPropertyChanged(a.t);
        super.requestRebind();
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return b(i3);
        }
        if (i2 == 1) {
            return c(i3);
        }
        if (i2 == 2) {
            return d(i3);
        }
        if (i2 != 3) {
            return false;
        }
        return e(i3);
    }

    private boolean b(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.f29473i |= 1;
        }
        return true;
    }

    private boolean c(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.f29473i |= 2;
        }
        return true;
    }

    private boolean d(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.f29473i |= 4;
        }
        return true;
    }

    private boolean e(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.f29473i |= 8;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r25 = this;
            r1 = r25
            monitor-enter(r25)
            long r2 = r1.f29473i     // Catch:{ all -> 0x0104 }
            r4 = 0
            r1.f29473i = r4     // Catch:{ all -> 0x0104 }
            monitor-exit(r25)     // Catch:{ all -> 0x0104 }
            net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel r0 = r1.f29468d
            r6 = 0
            net.one97.paytm.hotel4.viewmodel.ReviewViewModel r8 = r1.f29469e
            r9 = 82
            long r11 = r2 & r9
            r13 = 1
            int r15 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x0032
            if (r0 == 0) goto L_0x0020
            androidx.lifecycle.y r0 = r0.get_selectedRoomFinalPriceWithTax()
            goto L_0x0021
        L_0x0020:
            r0 = 0
        L_0x0021:
            r1.updateLiveDataRegistration(r13, r0)
            if (r0 == 0) goto L_0x002d
            java.lang.Object r0 = r0.getValue()
            java.lang.Double r0 = (java.lang.Double) r0
            goto L_0x002e
        L_0x002d:
            r0 = 0
        L_0x002e:
            double r6 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Double) r0)
        L_0x0032:
            r11 = 109(0x6d, double:5.4E-322)
            long r11 = r11 & r2
            r15 = 104(0x68, double:5.14E-322)
            r17 = 100
            r19 = 97
            r0 = 0
            int r21 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r21 == 0) goto L_0x00c6
            long r11 = r2 & r19
            int r21 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r21 == 0) goto L_0x0070
            if (r8 == 0) goto L_0x004d
            androidx.lifecycle.y r11 = r8.get_promoCodeApplyCashBackVisibility()
            goto L_0x004e
        L_0x004d:
            r11 = 0
        L_0x004e:
            r1.updateLiveDataRegistration(r0, r11)
            if (r11 == 0) goto L_0x005a
            java.lang.Object r11 = r11.getValue()
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            goto L_0x005b
        L_0x005a:
            r11 = 0
        L_0x005b:
            boolean r11 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r11)
            if (r21 == 0) goto L_0x006a
            if (r11 == 0) goto L_0x0066
            r21 = 1024(0x400, double:5.06E-321)
            goto L_0x0068
        L_0x0066:
            r21 = 512(0x200, double:2.53E-321)
        L_0x0068:
            long r2 = r2 | r21
        L_0x006a:
            if (r11 == 0) goto L_0x006d
            goto L_0x0070
        L_0x006d:
            r11 = 8
            goto L_0x0071
        L_0x0070:
            r11 = 0
        L_0x0071:
            long r21 = r2 & r17
            int r12 = (r21 > r4 ? 1 : (r21 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x00a9
            if (r8 == 0) goto L_0x0080
            androidx.lifecycle.y r21 = r8.getProcessToPayTapped()
            r0 = r21
            goto L_0x0081
        L_0x0080:
            r0 = 0
        L_0x0081:
            r14 = 2
            r1.updateLiveDataRegistration(r14, r0)
            if (r0 == 0) goto L_0x008f
            java.lang.Object r0 = r0.getValue()
            r14 = r0
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            goto L_0x0090
        L_0x008f:
            r14 = 0
        L_0x0090:
            boolean r0 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r14)
            if (r0 != r13) goto L_0x0099
            r21 = 1
            goto L_0x009b
        L_0x0099:
            r21 = 0
        L_0x009b:
            if (r12 == 0) goto L_0x00a6
            if (r21 == 0) goto L_0x00a2
            r23 = 256(0x100, double:1.265E-321)
            goto L_0x00a4
        L_0x00a2:
            r23 = 128(0x80, double:6.32E-322)
        L_0x00a4:
            long r2 = r2 | r23
        L_0x00a6:
            r0 = r21 ^ 1
            goto L_0x00aa
        L_0x00a9:
            r0 = 0
        L_0x00aa:
            long r12 = r2 & r15
            int r14 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x00c8
            if (r8 == 0) goto L_0x00b7
            androidx.lifecycle.y r14 = r8.get_promoCodePTPText()
            goto L_0x00b8
        L_0x00b7:
            r14 = 0
        L_0x00b8:
            r8 = 3
            r1.updateLiveDataRegistration(r8, r14)
            if (r14 == 0) goto L_0x00c8
            java.lang.Object r8 = r14.getValue()
            r14 = r8
            java.lang.String r14 = (java.lang.String) r14
            goto L_0x00c9
        L_0x00c6:
            r0 = 0
            r11 = 0
        L_0x00c8:
            r14 = 0
        L_0x00c9:
            long r8 = r2 & r9
            int r10 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x00d4
            android.widget.TextView r8 = r1.f29465a
            net.one97.paytm.hotel4.utils.a.b((android.widget.TextView) r8, (double) r6)
        L_0x00d4:
            long r6 = r2 & r17
            int r8 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x00df
            android.widget.LinearLayout r6 = r1.f29466b
            r6.setEnabled(r0)
        L_0x00df:
            r6 = 64
            long r6 = r6 & r2
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00ed
            android.widget.LinearLayout r0 = r1.f29466b
            android.view.View$OnClickListener r6 = r1.f29472h
            r0.setOnClickListener(r6)
        L_0x00ed:
            long r6 = r2 & r15
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00f8
            android.widget.TextView r0 = r1.f29467c
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r14)
        L_0x00f8:
            long r2 = r2 & r19
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0103
            android.widget.TextView r0 = r1.f29467c
            r0.setVisibility(r11)
        L_0x0103:
            return
        L_0x0104:
            r0 = move-exception
            monitor-exit(r25)     // Catch:{ all -> 0x0104 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotels2.b.dh.executeBindings():void");
    }

    public final void a(int i2) {
        ReviewViewModel reviewViewModel = this.f29469e;
        if (reviewViewModel != null) {
            reviewViewModel.onProcessToPayPressed();
        }
    }
}
