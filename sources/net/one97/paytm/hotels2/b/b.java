package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.q;
import net.one97.paytm.hotel4.service.model.ordersummary.CancelRefundData;
import net.one97.paytm.hotel4.viewmodel.CancelOrderViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;

public final class b extends a implements b.a {
    private static final ViewDataBinding.b u;
    private static final SparseIntArray v;
    private final View.OnClickListener A;
    private final View.OnClickListener B;
    private final View.OnClickListener C;
    private long D;
    private final ConstraintLayout w;
    private final k x;
    private final TextView y;
    private final TextView z;

    static {
        ViewDataBinding.b bVar = new ViewDataBinding.b(22);
        u = bVar;
        bVar.a(2, new String[]{"h4_cancel_order_summary_dates_lyout", "h4_cancel_order_room_details", "h4_cancel_order_refund_summary"}, new int[]{10, 11, 12}, new int[]{R.layout.h4_cancel_order_summary_dates_lyout, R.layout.h4_cancel_order_room_details, R.layout.h4_cancel_order_refund_summary});
        u.a(7, new String[]{"h4_cancel_order_reason"}, new int[]{13}, new int[]{R.layout.h4_cancel_order_reason});
        u.a(9, new String[]{"h4_cancel_order_paymentdetails"}, new int[]{14}, new int[]{R.layout.h4_cancel_order_paymentdetails});
        SparseIntArray sparseIntArray = new SparseIntArray();
        v = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 15);
        v.put(R.id.textView2, 16);
        v.put(R.id.line, 17);
        v.put(R.id.iv_hotelCard, 18);
        v.put(R.id.line_bottom, 19);
        v.put(R.id.lottieAnim, 20);
        v.put(R.id.fragment_container, 21);
    }

    public b(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 22, u, v));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private b(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[14], objArr[13], objArr[12], objArr[11], objArr[21], objArr[1], objArr[3], objArr[18], objArr[17], objArr[19], objArr[7], objArr[2], objArr[9], objArr[20], objArr[16], objArr[15], objArr[5], objArr[4]);
        this.D = -1;
        this.f29100f.setTag((Object) null);
        this.f29101g.setTag((Object) null);
        this.k.setTag((Object) null);
        this.l.setTag((Object) null);
        this.m.setTag((Object) null);
        this.w = objArr[0];
        this.w.setTag((Object) null);
        this.x = objArr[10];
        setContainedBinding(this.x);
        this.y = objArr[6];
        this.y.setTag((Object) null);
        this.z = objArr[8];
        this.z.setTag((Object) null);
        this.q.setTag((Object) null);
        this.r.setTag((Object) null);
        setRootTag(view);
        this.A = new net.one97.paytm.hotels2.c.a.b(this, 1);
        this.B = new net.one97.paytm.hotels2.c.a.b(this, 3);
        this.C = new net.one97.paytm.hotels2.c.a.b(this, 2);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.D = 128;
        }
        this.x.invalidateAll();
        this.f29098d.invalidateAll();
        this.f29097c.invalidateAll();
        this.f29096b.invalidateAll();
        this.f29095a.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r6.f29098d.hasPendingBindings() == false) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
        if (r6.f29097c.hasPendingBindings() == false) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002e, code lost:
        if (r6.f29096b.hasPendingBindings() == false) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0030, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0037, code lost:
        if (r6.f29095a.hasPendingBindings() == false) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0039, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003a, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.x.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean hasPendingBindings() {
        /*
            r6 = this;
            monitor-enter(r6)
            long r0 = r6.D     // Catch:{ all -> 0x003c }
            r2 = 0
            r4 = 1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x000c
            monitor-exit(r6)     // Catch:{ all -> 0x003c }
            return r4
        L_0x000c:
            monitor-exit(r6)     // Catch:{ all -> 0x003c }
            net.one97.paytm.hotels2.b.k r0 = r6.x
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0016
            return r4
        L_0x0016:
            net.one97.paytm.hotels2.b.i r0 = r6.f29098d
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x001f
            return r4
        L_0x001f:
            net.one97.paytm.hotels2.b.g r0 = r6.f29097c
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0028
            return r4
        L_0x0028:
            net.one97.paytm.hotels2.b.e r0 = r6.f29096b
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0031
            return r4
        L_0x0031:
            net.one97.paytm.hotels2.b.c r0 = r6.f29095a
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x003a
            return r4
        L_0x003a:
            r0 = 0
            return r0
        L_0x003c:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x003c }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotels2.b.b.hasPendingBindings():boolean");
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.s == i2) {
            a((CancelOrderViewModel) obj);
        } else if (a.D != i2) {
            return false;
        } else {
            a((CancelRefundData) obj);
        }
        return true;
    }

    public final void a(CancelOrderViewModel cancelOrderViewModel) {
        this.s = cancelOrderViewModel;
        synchronized (this) {
            this.D |= 32;
        }
        notifyPropertyChanged(a.s);
        super.requestRebind();
    }

    public final void a(CancelRefundData cancelRefundData) {
        this.t = cancelRefundData;
        synchronized (this) {
            this.D |= 64;
        }
        notifyPropertyChanged(a.D);
        super.requestRebind();
    }

    public final void setLifecycleOwner(q qVar) {
        super.setLifecycleOwner(qVar);
        this.x.setLifecycleOwner(qVar);
        this.f29098d.setLifecycleOwner(qVar);
        this.f29097c.setLifecycleOwner(qVar);
        this.f29096b.setLifecycleOwner(qVar);
        this.f29095a.setLifecycleOwner(qVar);
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
        if (i2 == 3) {
            return e(i3);
        }
        if (i2 != 4) {
            return false;
        }
        return f(i3);
    }

    private boolean b(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.D |= 1;
        }
        return true;
    }

    private boolean c(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.D |= 2;
        }
        return true;
    }

    private boolean d(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.D |= 4;
        }
        return true;
    }

    private boolean e(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.D |= 8;
        }
        return true;
    }

    private boolean f(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.D |= 16;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00e1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r21 = this;
            r1 = r21
            monitor-enter(r21)
            long r2 = r1.D     // Catch:{ all -> 0x010b }
            r4 = 0
            r1.D = r4     // Catch:{ all -> 0x010b }
            monitor-exit(r21)     // Catch:{ all -> 0x010b }
            net.one97.paytm.hotel4.viewmodel.CancelOrderViewModel r0 = r1.s
            net.one97.paytm.hotel4.service.model.ordersummary.CancelRefundData r6 = r1.t
            r7 = 161(0xa1, double:7.95E-322)
            long r9 = r2 & r7
            r11 = 160(0xa0, double:7.9E-322)
            r13 = 0
            int r15 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x0056
            long r9 = r2 & r11
            int r15 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x0026
            if (r0 == 0) goto L_0x0026
            java.lang.String r9 = r0.getHotelAddress()
            goto L_0x0027
        L_0x0026:
            r9 = 0
        L_0x0027:
            if (r0 == 0) goto L_0x002e
            androidx.lifecycle.y r10 = r0.getMetaData()
            goto L_0x002f
        L_0x002e:
            r10 = 0
        L_0x002f:
            r1.updateLiveDataRegistration(r13, r10)
            if (r10 == 0) goto L_0x003b
            java.lang.Object r10 = r10.getValue()
            net.one97.paytm.hotel4.service.model.ordersummary.MetaData r10 = (net.one97.paytm.hotel4.service.model.ordersummary.MetaData) r10
            goto L_0x003c
        L_0x003b:
            r10 = 0
        L_0x003c:
            if (r10 == 0) goto L_0x0043
            net.one97.paytm.hotel4.service.model.details.PaytmImages r15 = r10.paytmImages
            java.lang.String r14 = r10.name
            goto L_0x0045
        L_0x0043:
            r14 = 0
            r15 = 0
        L_0x0045:
            if (r15 == 0) goto L_0x004c
            java.util.List r15 = r15.getFull()
            goto L_0x004d
        L_0x004c:
            r15 = 0
        L_0x004d:
            if (r15 == 0) goto L_0x0059
            java.lang.Object r15 = r15.get(r13)
            java.lang.String r15 = (java.lang.String) r15
            goto L_0x005a
        L_0x0056:
            r9 = 0
            r10 = 0
            r14 = 0
        L_0x0059:
            r15 = 0
        L_0x005a:
            r16 = 192(0xc0, double:9.5E-322)
            long r18 = r2 & r16
            int r20 = (r18 > r4 ? 1 : (r18 == r4 ? 0 : -1))
            if (r20 == 0) goto L_0x0079
            if (r6 == 0) goto L_0x0067
            r18 = 1
            goto L_0x0069
        L_0x0067:
            r18 = 0
        L_0x0069:
            if (r20 == 0) goto L_0x0074
            if (r18 == 0) goto L_0x0070
            r19 = 512(0x200, double:2.53E-321)
            goto L_0x0072
        L_0x0070:
            r19 = 256(0x100, double:1.265E-321)
        L_0x0072:
            long r2 = r2 | r19
        L_0x0074:
            if (r18 == 0) goto L_0x0077
            goto L_0x0079
        L_0x0077:
            r13 = 8
        L_0x0079:
            long r11 = r11 & r2
            int r18 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r18 == 0) goto L_0x0092
            net.one97.paytm.hotels2.b.c r11 = r1.f29095a
            r11.a(r0)
            net.one97.paytm.hotels2.b.e r11 = r1.f29096b
            r11.a(r0)
            net.one97.paytm.hotels2.b.k r11 = r1.x
            r11.a(r0)
            android.widget.TextView r0 = r1.q
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r9)
        L_0x0092:
            long r11 = r2 & r16
            int r0 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00a6
            net.one97.paytm.hotels2.b.g r0 = r1.f29097c
            android.view.View r0 = r0.getRoot()
            r0.setVisibility(r13)
            net.one97.paytm.hotels2.b.g r0 = r1.f29097c
            r0.a((net.one97.paytm.hotel4.service.model.ordersummary.CancelRefundData) r6)
        L_0x00a6:
            r11 = 128(0x80, double:6.32E-322)
            long r11 = r11 & r2
            int r0 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00dc
            net.one97.paytm.hotels2.b.g r0 = r1.f29097c
            android.view.View r6 = r21.getRoot()
            android.content.res.Resources r6 = r6.getResources()
            int r9 = net.one97.paytm.hotels2.R.string.h4_empty
            java.lang.String r6 = r6.getString(r9)
            r0.a((java.lang.String) r6)
            net.one97.paytm.hotels2.b.g r0 = r1.f29097c
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            r0.a((java.lang.Boolean) r6)
            android.widget.ImageView r0 = r1.f29100f
            android.view.View$OnClickListener r6 = r1.A
            r0.setOnClickListener(r6)
            android.widget.TextView r0 = r1.y
            android.view.View$OnClickListener r6 = r1.C
            r0.setOnClickListener(r6)
            android.widget.TextView r0 = r1.z
            android.view.View$OnClickListener r6 = r1.B
            r0.setOnClickListener(r6)
        L_0x00dc:
            long r2 = r2 & r7
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00f1
            net.one97.paytm.hotels2.b.i r0 = r1.f29098d
            r0.a(r10)
            android.widget.ImageView r0 = r1.f29101g
            r2 = 0
            net.one97.paytm.hotel4.utils.a.a(r0, r15, r2, r2)
            android.widget.TextView r0 = r1.r
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r14)
        L_0x00f1:
            net.one97.paytm.hotels2.b.k r0 = r1.x
            executeBindingsOn(r0)
            net.one97.paytm.hotels2.b.i r0 = r1.f29098d
            executeBindingsOn(r0)
            net.one97.paytm.hotels2.b.g r0 = r1.f29097c
            executeBindingsOn(r0)
            net.one97.paytm.hotels2.b.e r0 = r1.f29096b
            executeBindingsOn(r0)
            net.one97.paytm.hotels2.b.c r0 = r1.f29095a
            executeBindingsOn(r0)
            return
        L_0x010b:
            r0 = move-exception
            monitor-exit(r21)     // Catch:{ all -> 0x010b }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotels2.b.b.executeBindings():void");
    }

    public final void a(int i2) {
        boolean z2 = false;
        if (i2 == 1) {
            CancelOrderViewModel cancelOrderViewModel = this.s;
            if (cancelOrderViewModel != null) {
                z2 = true;
            }
            if (z2) {
                cancelOrderViewModel.closeScreen();
            }
        } else if (i2 == 2) {
            CancelOrderViewModel cancelOrderViewModel2 = this.s;
            if (cancelOrderViewModel2 != null) {
                z2 = true;
            }
            if (z2) {
                cancelOrderViewModel2.cancellationPolicyClickHandler();
            }
        } else if (i2 == 3) {
            CancelOrderViewModel cancelOrderViewModel3 = this.s;
            if (cancelOrderViewModel3 != null) {
                z2 = true;
            }
            if (z2) {
                cancelOrderViewModel3.cancelBookingClicked();
            }
        }
    }
}
