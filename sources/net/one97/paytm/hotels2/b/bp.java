package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.q;
import net.one97.paytm.hotel4.viewmodel.HotelBookingStatusViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;

public final class bp extends bo implements b.a {
    private static final ViewDataBinding.b Q;
    private static final SparseIntArray R;
    private final ConstraintLayout S;
    private final LinearLayout T;
    private final View U;
    private final LinearLayout V;
    private final LinearLayout W;
    private final gs X;
    private final LinearLayout Y;
    private final View.OnClickListener Z;
    private final View.OnClickListener aa;
    private final View.OnClickListener ab;
    private final View.OnClickListener ac;
    private final View.OnClickListener ad;
    private long ae;

    static {
        ViewDataBinding.b bVar = new ViewDataBinding.b(48);
        Q = bVar;
        bVar.a(4, new String[]{"h4_layout_order_summary_dates"}, new int[]{23}, new int[]{R.layout.h4_layout_order_summary_dates});
        Q.a(11, new String[]{"h4_layout_hotel_summary_payment_details", "h4_layout_order_summary_policy_tnc"}, new int[]{24, 25}, new int[]{R.layout.h4_layout_hotel_summary_payment_details, R.layout.h4_layout_order_summary_policy_tnc});
        Q.a(22, new String[]{"layout_hotel_booking_shimmer"}, new int[]{26}, new int[]{R.layout.layout_hotel_booking_shimmer});
        SparseIntArray sparseIntArray = new SparseIntArray();
        R = sparseIntArray;
        sparseIntArray.put(R.id.appBar, 27);
        R.put(R.id.collapsingToolbar, 28);
        R.put(R.id.topBackground, 29);
        R.put(R.id.topBackgroundImage, 30);
        R.put(R.id.backButton, 31);
        R.put(R.id.headerImage, 32);
        R.put(R.id.toolbar, 33);
        R.put(R.id.nestedView, 34);
        R.put(R.id.line, 35);
        R.put(R.id.iv_hotelCard, 36);
        R.put(R.id.line_bottom, 37);
        R.put(R.id.hotelIcon2, 38);
        R.put(R.id.tv_total_text, 39);
        R.put(R.id.store_front_container, 40);
        R.put(R.id.separator, 41);
        R.put(R.id.bottomButtons, 42);
        R.put(R.id.saveVoucherImage, 43);
        R.put(R.id.emailVoucherImage, 44);
        R.put(R.id.callImage, 45);
        R.put(R.id.cancelImage, 46);
        R.put(R.id.fragment_container, 47);
    }

    public bp(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 48, Q, R));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private bp(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[27], objArr[31], objArr[2], objArr[3], objArr[42], objArr[20], objArr[45], objArr[21], objArr[46], objArr[12], objArr[28], objArr[19], objArr[44], objArr[47], objArr[10], objArr[32], objArr[38], objArr[6], objArr[5], objArr[36], objArr[35], objArr[37], objArr[34], objArr[23], objArr[1], objArr[24], objArr[18], objArr[43], objArr[41], objArr[22], objArr[40], objArr[9], objArr[25], objArr[33], objArr[29], objArr[30], objArr[15], objArr[8], objArr[7], objArr[17], objArr[39]);
        this.ae = -1;
        this.f29274c.setTag((Object) null);
        this.f29275d.setTag((Object) null);
        this.f29277f.setTag((Object) null);
        this.f29279h.setTag((Object) null);
        this.j.setTag((Object) null);
        this.l.setTag((Object) null);
        this.o.setTag((Object) null);
        this.r.setTag((Object) null);
        this.s.setTag((Object) null);
        this.S = objArr[0];
        this.S.setTag((Object) null);
        this.T = objArr[11];
        this.T.setTag((Object) null);
        this.U = objArr[13];
        this.U.setTag((Object) null);
        this.V = objArr[14];
        this.V.setTag((Object) null);
        this.W = objArr[16];
        this.W.setTag((Object) null);
        this.X = objArr[26];
        setContainedBinding(this.X);
        this.Y = objArr[4];
        this.Y.setTag((Object) null);
        this.y.setTag((Object) null);
        this.A.setTag((Object) null);
        this.D.setTag((Object) null);
        this.F.setTag((Object) null);
        this.K.setTag((Object) null);
        this.L.setTag((Object) null);
        this.M.setTag((Object) null);
        this.N.setTag((Object) null);
        setRootTag(view);
        this.Z = new b(this, 4);
        this.aa = new b(this, 1);
        this.ab = new b(this, 2);
        this.ac = new b(this, 5);
        this.ad = new b(this, 3);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.ae = 256;
        }
        this.x.invalidateAll();
        this.z.invalidateAll();
        this.G.invalidateAll();
        this.X.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r6.z.hasPendingBindings() == false) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
        if (r6.G.hasPendingBindings() == false) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002e, code lost:
        if (r6.X.hasPendingBindings() == false) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0030, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
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
            long r0 = r6.ae     // Catch:{ all -> 0x0033 }
            r2 = 0
            r4 = 1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x000c
            monitor-exit(r6)     // Catch:{ all -> 0x0033 }
            return r4
        L_0x000c:
            monitor-exit(r6)     // Catch:{ all -> 0x0033 }
            net.one97.paytm.hotels2.b.bw r0 = r6.x
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0016
            return r4
        L_0x0016:
            net.one97.paytm.hotels2.b.bu r0 = r6.z
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x001f
            return r4
        L_0x001f:
            net.one97.paytm.hotels2.b.by r0 = r6.G
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0028
            return r4
        L_0x0028:
            net.one97.paytm.hotels2.b.gs r0 = r6.X
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0031
            return r4
        L_0x0031:
            r0 = 0
            return r0
        L_0x0033:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0033 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotels2.b.bp.hasPendingBindings():boolean");
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.y != i2) {
            return false;
        }
        a((HotelBookingStatusViewModel) obj);
        return true;
    }

    public final void a(HotelBookingStatusViewModel hotelBookingStatusViewModel) {
        this.P = hotelBookingStatusViewModel;
        synchronized (this) {
            this.ae |= 128;
        }
        notifyPropertyChanged(a.y);
        super.requestRebind();
    }

    public final void setLifecycleOwner(q qVar) {
        super.setLifecycleOwner(qVar);
        this.x.setLifecycleOwner(qVar);
        this.z.setLifecycleOwner(qVar);
        this.G.setLifecycleOwner(qVar);
        this.X.setLifecycleOwner(qVar);
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return b(i3);
            case 1:
                return c(i3);
            case 2:
                return d(i3);
            case 3:
                return e(i3);
            case 4:
                return f(i3);
            case 5:
                return g(i3);
            case 6:
                return h(i3);
            default:
                return false;
        }
    }

    private boolean b(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.ae |= 1;
        }
        return true;
    }

    private boolean c(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.ae |= 2;
        }
        return true;
    }

    private boolean d(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.ae |= 4;
        }
        return true;
    }

    private boolean e(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.ae |= 8;
        }
        return true;
    }

    private boolean f(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.ae |= 16;
        }
        return true;
    }

    private boolean g(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.ae |= 32;
        }
        return true;
    }

    private boolean h(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.ae |= 64;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x012e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r41 = this;
            r1 = r41
            monitor-enter(r41)
            long r2 = r1.ae     // Catch:{ all -> 0x0280 }
            r4 = 0
            r1.ae = r4     // Catch:{ all -> 0x0280 }
            monitor-exit(r41)     // Catch:{ all -> 0x0280 }
            net.one97.paytm.hotel4.viewmodel.HotelBookingStatusViewModel r0 = r1.P
            r6 = 429(0x1ad, double:2.12E-321)
            long r6 = r6 & r2
            r10 = 392(0x188, double:1.937E-321)
            r12 = 388(0x184, double:1.917E-321)
            r14 = 385(0x181, double:1.9E-321)
            r16 = 384(0x180, double:1.897E-321)
            r8 = 0
            int r20 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r20 == 0) goto L_0x01a2
            long r6 = r2 & r14
            int r20 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r20 == 0) goto L_0x0046
            if (r0 == 0) goto L_0x0029
            androidx.lifecycle.y r6 = r0.getOrderSummary()
            goto L_0x002a
        L_0x0029:
            r6 = 0
        L_0x002a:
            r1.updateLiveDataRegistration(r8, r6)
            if (r6 == 0) goto L_0x0036
            java.lang.Object r6 = r6.getValue()
            net.one97.paytm.hotel4.service.model.OrderSummary r6 = (net.one97.paytm.hotel4.service.model.OrderSummary) r6
            goto L_0x0037
        L_0x0036:
            r6 = 0
        L_0x0037:
            if (r6 == 0) goto L_0x003e
            net.one97.paytm.common.entity.shopping.CJROrderSummaryRefundToBank r6 = r6.getRefund()
            goto L_0x003f
        L_0x003e:
            r6 = 0
        L_0x003f:
            if (r6 == 0) goto L_0x0046
            java.lang.String r6 = r6.getMessage()
            goto L_0x0047
        L_0x0046:
            r6 = 0
        L_0x0047:
            long r20 = r2 & r16
            int r22 = (r20 > r4 ? 1 : (r20 == r4 ? 0 : -1))
            if (r22 == 0) goto L_0x009c
            if (r0 == 0) goto L_0x006c
            boolean r20 = r0.canShowCancellationPolicy()
            java.lang.String r21 = r0.getGuestCount()
            java.lang.String r23 = r0.getCancellationPolicy()
            java.lang.String r24 = r0.getCustomerName()
            java.lang.String r25 = r0.getBookingId()
            java.lang.String r26 = r0.getOrderStatus()
            java.lang.String r27 = r0.getHotelAddress()
            goto L_0x007a
        L_0x006c:
            r20 = 0
            r21 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
        L_0x007a:
            if (r22 == 0) goto L_0x008d
            if (r20 == 0) goto L_0x0085
            r28 = 1024(0x400, double:5.06E-321)
            long r2 = r2 | r28
            r28 = 16384(0x4000, double:8.0948E-320)
            goto L_0x008b
        L_0x0085:
            r28 = 512(0x200, double:2.53E-321)
            long r2 = r2 | r28
            r28 = 8192(0x2000, double:4.0474E-320)
        L_0x008b:
            long r2 = r2 | r28
        L_0x008d:
            if (r20 == 0) goto L_0x0092
            r22 = 8
            goto L_0x0094
        L_0x0092:
            r22 = 0
        L_0x0094:
            if (r20 == 0) goto L_0x0099
            r20 = 0
            goto L_0x00ac
        L_0x0099:
            r20 = 8
            goto L_0x00ac
        L_0x009c:
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
        L_0x00ac:
            long r28 = r2 & r12
            r30 = 1
            int r31 = (r28 > r4 ? 1 : (r28 == r4 ? 0 : -1))
            if (r31 == 0) goto L_0x00ec
            if (r0 == 0) goto L_0x00bd
            androidx.lifecycle.y r28 = r0.getCashBackPrice()
            r7 = r28
            goto L_0x00be
        L_0x00bd:
            r7 = 0
        L_0x00be:
            r12 = 2
            r1.updateLiveDataRegistration(r12, r7)
            if (r7 == 0) goto L_0x00cb
            java.lang.Object r7 = r7.getValue()
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x00cc
        L_0x00cb:
            r7 = 0
        L_0x00cc:
            if (r7 == 0) goto L_0x00d3
            int r12 = r7.length()
            goto L_0x00d4
        L_0x00d3:
            r12 = 0
        L_0x00d4:
            if (r12 <= 0) goto L_0x00d8
            r12 = 1
            goto L_0x00d9
        L_0x00d8:
            r12 = 0
        L_0x00d9:
            if (r31 == 0) goto L_0x00e6
            if (r12 == 0) goto L_0x00e1
            r32 = 65536(0x10000, double:3.2379E-319)
            goto L_0x00e4
        L_0x00e1:
            r32 = 32768(0x8000, double:1.61895E-319)
        L_0x00e4:
            long r2 = r2 | r32
        L_0x00e6:
            if (r12 == 0) goto L_0x00e9
            goto L_0x00ed
        L_0x00e9:
            r12 = 8
            goto L_0x00ee
        L_0x00ec:
            r7 = 0
        L_0x00ed:
            r12 = 0
        L_0x00ee:
            long r32 = r2 & r10
            int r13 = (r32 > r4 ? 1 : (r32 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x0124
            if (r0 == 0) goto L_0x00fb
            androidx.lifecycle.y r13 = r0.getMetaData()
            goto L_0x00fc
        L_0x00fb:
            r13 = 0
        L_0x00fc:
            r9 = 3
            r1.updateLiveDataRegistration(r9, r13)
            if (r13 == 0) goto L_0x0109
            java.lang.Object r9 = r13.getValue()
            net.one97.paytm.hotel4.service.model.ordersummary.MetaData r9 = (net.one97.paytm.hotel4.service.model.ordersummary.MetaData) r9
            goto L_0x010a
        L_0x0109:
            r9 = 0
        L_0x010a:
            if (r9 == 0) goto L_0x0111
            net.one97.paytm.hotel4.service.model.details.PaytmImages r13 = r9.paytmImages
            java.lang.String r9 = r9.name
            goto L_0x0113
        L_0x0111:
            r9 = 0
            r13 = 0
        L_0x0113:
            if (r13 == 0) goto L_0x011a
            java.util.List r13 = r13.getFull()
            goto L_0x011b
        L_0x011a:
            r13 = 0
        L_0x011b:
            if (r13 == 0) goto L_0x0125
            java.lang.Object r13 = r13.get(r8)
            java.lang.String r13 = (java.lang.String) r13
            goto L_0x0126
        L_0x0124:
            r9 = 0
        L_0x0125:
            r13 = 0
        L_0x0126:
            r18 = 416(0x1a0, double:2.055E-321)
            long r32 = r2 & r18
            int r31 = (r32 > r4 ? 1 : (r32 == r4 ? 0 : -1))
            if (r31 == 0) goto L_0x0183
            if (r0 == 0) goto L_0x0137
            androidx.lifecycle.y r32 = r0.getCashBackText()
            r8 = r32
            goto L_0x0138
        L_0x0137:
            r8 = 0
        L_0x0138:
            r10 = 5
            r1.updateLiveDataRegistration(r10, r8)
            if (r8 == 0) goto L_0x0145
            java.lang.Object r8 = r8.getValue()
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x0146
        L_0x0145:
            r8 = 0
        L_0x0146:
            if (r8 == 0) goto L_0x014d
            int r10 = r8.length()
            goto L_0x014e
        L_0x014d:
            r10 = 0
        L_0x014e:
            if (r10 <= 0) goto L_0x0151
            goto L_0x0153
        L_0x0151:
            r30 = 0
        L_0x0153:
            if (r31 == 0) goto L_0x015d
            if (r30 == 0) goto L_0x015a
            r10 = 4096(0x1000, double:2.0237E-320)
            goto L_0x015c
        L_0x015a:
            r10 = 2048(0x800, double:1.0118E-320)
        L_0x015c:
            long r2 = r2 | r10
        L_0x015d:
            if (r30 == 0) goto L_0x0162
            r32 = 0
            goto L_0x0164
        L_0x0162:
            r32 = 8
        L_0x0164:
            r34 = r6
            r40 = r7
            r38 = r8
            r36 = r9
            r39 = r12
            r35 = r13
            r8 = r20
            r9 = r21
            r10 = r22
            r7 = r23
            r12 = r24
            r6 = r25
            r11 = r26
            r13 = r27
            r37 = r32
            goto L_0x01b8
        L_0x0183:
            r34 = r6
            r40 = r7
            r36 = r9
            r39 = r12
            r35 = r13
            r8 = r20
            r9 = r21
            r10 = r22
            r7 = r23
            r12 = r24
            r6 = r25
            r11 = r26
            r13 = r27
            r37 = 0
            r38 = 0
            goto L_0x01b8
        L_0x01a2:
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r40 = 0
        L_0x01b8:
            long r16 = r2 & r16
            int r20 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r20 == 0) goto L_0x01f0
            android.widget.TextView r4 = r1.f29274c
            androidx.databinding.a.d.a((android.widget.TextView) r4, (java.lang.CharSequence) r6)
            android.widget.TextView r4 = r1.j
            androidx.databinding.a.d.a((android.widget.TextView) r4, (java.lang.CharSequence) r7)
            android.widget.TextView r4 = r1.j
            r4.setVisibility(r8)
            android.widget.TextView r4 = r1.o
            androidx.databinding.a.d.a((android.widget.TextView) r4, (java.lang.CharSequence) r9)
            android.view.View r4 = r1.U
            r4.setVisibility(r10)
            net.one97.paytm.hotels2.b.bw r4 = r1.x
            r4.a(r0)
            android.widget.TextView r4 = r1.y
            androidx.databinding.a.d.a((android.widget.TextView) r4, (java.lang.CharSequence) r11)
            net.one97.paytm.hotels2.b.bu r4 = r1.z
            r4.a(r0)
            android.widget.TextView r0 = r1.F
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r12)
            android.widget.TextView r0 = r1.L
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r13)
        L_0x01f0:
            long r4 = r2 & r14
            r6 = 0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x01ff
            android.widget.TextView r0 = r1.f29275d
            r4 = r34
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
        L_0x01ff:
            r4 = 256(0x100, double:1.265E-321)
            long r4 = r4 & r2
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x0229
            android.widget.LinearLayout r0 = r1.f29277f
            android.view.View$OnClickListener r4 = r1.Z
            r0.setOnClickListener(r4)
            android.widget.LinearLayout r0 = r1.f29279h
            android.view.View$OnClickListener r4 = r1.ac
            r0.setOnClickListener(r4)
            android.widget.LinearLayout r0 = r1.l
            android.view.View$OnClickListener r4 = r1.ad
            r0.setOnClickListener(r4)
            android.widget.ImageView r0 = r1.r
            android.view.View$OnClickListener r4 = r1.aa
            r0.setOnClickListener(r4)
            android.widget.LinearLayout r0 = r1.A
            android.view.View$OnClickListener r4 = r1.ab
            r0.setOnClickListener(r4)
        L_0x0229:
            r4 = 392(0x188, double:1.937E-321)
            long r4 = r4 & r2
            r6 = 0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x0241
            android.widget.ImageView r0 = r1.s
            r13 = r35
            r4 = 0
            net.one97.paytm.hotel4.utils.a.a(r0, r13, r4, r4)
            android.widget.TextView r0 = r1.M
            r9 = r36
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r9)
        L_0x0241:
            r4 = 416(0x1a0, double:2.055E-321)
            long r4 = r4 & r2
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x0256
            android.widget.LinearLayout r0 = r1.V
            r4 = r37
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.K
            r8 = r38
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r8)
        L_0x0256:
            r4 = 388(0x184, double:1.917E-321)
            long r2 = r2 & r4
            int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x026b
            android.widget.LinearLayout r0 = r1.W
            r12 = r39
            r0.setVisibility(r12)
            android.widget.TextView r0 = r1.N
            r7 = r40
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r7)
        L_0x026b:
            net.one97.paytm.hotels2.b.bw r0 = r1.x
            executeBindingsOn(r0)
            net.one97.paytm.hotels2.b.bu r0 = r1.z
            executeBindingsOn(r0)
            net.one97.paytm.hotels2.b.by r0 = r1.G
            executeBindingsOn(r0)
            net.one97.paytm.hotels2.b.gs r0 = r1.X
            executeBindingsOn(r0)
            return
        L_0x0280:
            r0 = move-exception
            monitor-exit(r41)     // Catch:{ all -> 0x0280 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotels2.b.bp.executeBindings():void");
    }

    public final void a(int i2) {
        boolean z = false;
        if (i2 == 1) {
            HotelBookingStatusViewModel hotelBookingStatusViewModel = this.P;
            if (hotelBookingStatusViewModel != null) {
                z = true;
            }
            if (z) {
                hotelBookingStatusViewModel.openGoogleMap();
            }
        } else if (i2 == 2) {
            HotelBookingStatusViewModel hotelBookingStatusViewModel2 = this.P;
            if (hotelBookingStatusViewModel2 != null) {
                z = true;
            }
            if (z) {
                hotelBookingStatusViewModel2.saveVoucher();
            }
        } else if (i2 == 3) {
            HotelBookingStatusViewModel hotelBookingStatusViewModel3 = this.P;
            if (hotelBookingStatusViewModel3 != null) {
                z = true;
            }
            if (z) {
                hotelBookingStatusViewModel3.emailVoucher();
            }
        } else if (i2 == 4) {
            HotelBookingStatusViewModel hotelBookingStatusViewModel4 = this.P;
            if (hotelBookingStatusViewModel4 != null) {
                z = true;
            }
            if (z) {
                hotelBookingStatusViewModel4.callHotel();
            }
        } else if (i2 == 5) {
            HotelBookingStatusViewModel hotelBookingStatusViewModel5 = this.P;
            if (hotelBookingStatusViewModel5 != null) {
                z = true;
            }
            if (z) {
                hotelBookingStatusViewModel5.cancelBooking();
            }
        }
    }
}
