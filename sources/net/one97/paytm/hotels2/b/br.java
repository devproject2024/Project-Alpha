package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.hotel4.viewmodel.SRPViewModel;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;

public final class br extends bq implements b.a {

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.b f29286f = null;

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f29287g = null;

    /* renamed from: h  reason: collision with root package name */
    private final LinearLayout f29288h;

    /* renamed from: i  reason: collision with root package name */
    private final ConstraintLayout f29289i;
    private final TextView j;
    private final View.OnClickListener k;
    private long l;

    public br(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 7, f29286f, f29287g));
    }

    private br(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[3], objArr[1], objArr[2], objArr[4]);
        this.l = -1;
        this.f29281a.setTag((Object) null);
        this.f29282b.setTag((Object) null);
        this.f29283c.setTag((Object) null);
        this.f29288h = objArr[0];
        this.f29288h.setTag((Object) null);
        this.f29289i = objArr[5];
        this.f29289i.setTag((Object) null);
        this.j = objArr[6];
        this.j.setTag((Object) null);
        this.f29284d.setTag((Object) null);
        setRootTag(view);
        this.k = new b(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.l = 32;
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
        if (a.f29088c != i2) {
            return false;
        }
        a((SRPViewModel) obj);
        return true;
    }

    public final void a(SRPViewModel sRPViewModel) {
        this.f29285e = sRPViewModel;
        synchronized (this) {
            this.l |= 16;
        }
        notifyPropertyChanged(a.f29088c);
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
            this.l |= 1;
        }
        return true;
    }

    private boolean c(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.l |= 2;
        }
        return true;
    }

    private boolean d(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.l |= 4;
        }
        return true;
    }

    private boolean e(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.l |= 8;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005a A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r25 = this;
            r1 = r25
            monitor-enter(r25)
            long r2 = r1.l     // Catch:{ all -> 0x00ff }
            r4 = 0
            r1.l = r4     // Catch:{ all -> 0x00ff }
            monitor-exit(r25)     // Catch:{ all -> 0x00ff }
            net.one97.paytm.hotel4.viewmodel.SRPViewModel r0 = r1.f29285e
            r6 = 63
            long r6 = r6 & r2
            r8 = 52
            r12 = 48
            r14 = 49
            r16 = 50
            r10 = 0
            r11 = 0
            int r20 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r20 == 0) goto L_0x00b2
            long r6 = r2 & r14
            int r20 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r20 == 0) goto L_0x0037
            if (r0 == 0) goto L_0x002a
            com.travel.utils.l r6 = r0.getSoldOutHotelName()
            goto L_0x002b
        L_0x002a:
            r6 = r11
        L_0x002b:
            r1.updateLiveDataRegistration(r10, r6)
            if (r6 == 0) goto L_0x0037
            java.lang.Object r6 = r6.getValue()
            java.lang.String r6 = (java.lang.String) r6
            goto L_0x0038
        L_0x0037:
            r6 = r11
        L_0x0038:
            long r20 = r2 & r16
            int r7 = (r20 > r4 ? 1 : (r20 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x0053
            if (r0 == 0) goto L_0x0045
            com.travel.utils.l r7 = r0.getSoldOutLocality()
            goto L_0x0046
        L_0x0045:
            r7 = r11
        L_0x0046:
            r10 = 1
            r1.updateLiveDataRegistration(r10, r7)
            if (r7 == 0) goto L_0x0053
            java.lang.Object r7 = r7.getValue()
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x0054
        L_0x0053:
            r7 = r11
        L_0x0054:
            long r21 = r2 & r12
            int r10 = (r21 > r4 ? 1 : (r21 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x0061
            if (r0 == 0) goto L_0x0061
            java.lang.String r10 = r0.getHotelBuleImageUrl()
            goto L_0x0062
        L_0x0061:
            r10 = r11
        L_0x0062:
            long r21 = r2 & r8
            int r23 = (r21 > r4 ? 1 : (r21 == r4 ? 0 : -1))
            if (r23 == 0) goto L_0x007f
            if (r0 == 0) goto L_0x0071
            com.travel.utils.l r21 = r0.getSoldOutImageUrl()
            r8 = r21
            goto L_0x0072
        L_0x0071:
            r8 = r11
        L_0x0072:
            r9 = 2
            r1.updateLiveDataRegistration(r9, r8)
            if (r8 == 0) goto L_0x007f
            java.lang.Object r8 = r8.getValue()
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x0080
        L_0x007f:
            r8 = r11
        L_0x0080:
            r18 = 56
            long r23 = r2 & r18
            int r9 = (r23 > r4 ? 1 : (r23 == r4 ? 0 : -1))
            if (r9 == 0) goto L_0x00b6
            if (r0 == 0) goto L_0x008f
            com.travel.utils.l r0 = r0.isHotelSoldOutMessageVisible()
            goto L_0x0090
        L_0x008f:
            r0 = r11
        L_0x0090:
            r14 = 3
            r1.updateLiveDataRegistration(r14, r0)
            if (r0 == 0) goto L_0x009d
            java.lang.Object r0 = r0.getValue()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            goto L_0x009e
        L_0x009d:
            r0 = r11
        L_0x009e:
            boolean r0 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r0)
            if (r9 == 0) goto L_0x00ac
            if (r0 == 0) goto L_0x00a9
            r14 = 128(0x80, double:6.32E-322)
            goto L_0x00ab
        L_0x00a9:
            r14 = 64
        L_0x00ab:
            long r2 = r2 | r14
        L_0x00ac:
            if (r0 == 0) goto L_0x00af
            goto L_0x00b6
        L_0x00af:
            r0 = 8
            goto L_0x00b7
        L_0x00b2:
            r6 = r11
            r7 = r6
            r8 = r7
            r10 = r8
        L_0x00b6:
            r0 = 0
        L_0x00b7:
            long r14 = r2 & r16
            int r9 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r9 == 0) goto L_0x00c2
            android.widget.TextView r9 = r1.f29281a
            androidx.databinding.a.d.a((android.widget.TextView) r9, (java.lang.CharSequence) r7)
        L_0x00c2:
            long r12 = r12 & r2
            int r7 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x00cc
            android.widget.ImageView r7 = r1.f29282b
            net.one97.paytm.hotel4.utils.a.a(r7, r10, r11, r11)
        L_0x00cc:
            r9 = 49
            long r9 = r9 & r2
            int r7 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x00d8
            android.widget.TextView r7 = r1.f29283c
            androidx.databinding.a.d.a((android.widget.TextView) r7, (java.lang.CharSequence) r6)
        L_0x00d8:
            r6 = 56
            long r6 = r6 & r2
            int r9 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r9 == 0) goto L_0x00e4
            androidx.constraintlayout.widget.ConstraintLayout r6 = r1.f29289i
            r6.setVisibility(r0)
        L_0x00e4:
            r6 = 32
            long r6 = r6 & r2
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00f2
            android.widget.TextView r0 = r1.j
            android.view.View$OnClickListener r6 = r1.k
            r0.setOnClickListener(r6)
        L_0x00f2:
            r6 = 52
            long r2 = r2 & r6
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00fe
            android.widget.ImageView r0 = r1.f29284d
            net.one97.paytm.hotel4.utils.a.a(r0, r8, r11, r11)
        L_0x00fe:
            return
        L_0x00ff:
            r0 = move-exception
            monitor-exit(r25)     // Catch:{ all -> 0x00ff }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotels2.b.br.executeBindings():void");
    }

    public final void a(int i2) {
        SRPViewModel sRPViewModel = this.f29285e;
        if (sRPViewModel != null) {
            sRPViewModel.hideSoldOut();
        }
    }
}
