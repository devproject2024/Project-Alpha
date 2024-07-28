package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.q;
import net.one97.paytm.hotel4.viewmodel.filter.SRPFilterViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;

public final class et extends es implements b.a {
    private static final ViewDataBinding.b j;
    private static final SparseIntArray k = null;
    private final RelativeLayout l;
    private final ConstraintLayout m;
    private final TextView n;
    private final View.OnClickListener o;
    private long p;

    static {
        ViewDataBinding.b bVar = new ViewDataBinding.b(11);
        j = bVar;
        bVar.a(0, new String[]{"h4_srp_filter_header"}, new int[]{3}, new int[]{R.layout.h4_srp_filter_header});
        j.a(1, new String[]{"h4_filter_price_start_view", "h4_filter_price_start_view", "h4_filter_amenities_hotel_type_view", "h4_filter_amenities_hotel_type_view", "h4_filter_locality_view", "h4_filter_hotel_chain_view", "h4_filter_hotel_theme_view"}, new int[]{4, 5, 6, 7, 8, 9, 10}, new int[]{R.layout.h4_filter_price_start_view, R.layout.h4_filter_price_start_view, R.layout.h4_filter_amenities_hotel_type_view, R.layout.h4_filter_amenities_hotel_type_view, R.layout.h4_filter_locality_view, R.layout.h4_filter_hotel_chain_view, R.layout.h4_filter_hotel_theme_view});
    }

    public et(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 11, j, k));
    }

    private et(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[6], objArr[3], objArr[9], objArr[8], objArr[10], objArr[7], objArr[4], objArr[5]);
        this.p = -1;
        this.l = objArr[0];
        this.l.setTag((Object) null);
        this.m = objArr[1];
        this.m.setTag((Object) null);
        this.n = objArr[2];
        this.n.setTag((Object) null);
        setRootTag(view);
        this.o = new b(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.p = 131072;
        }
        this.f29645b.invalidateAll();
        this.f29650g.invalidateAll();
        this.f29651h.invalidateAll();
        this.f29644a.invalidateAll();
        this.f29649f.invalidateAll();
        this.f29647d.invalidateAll();
        this.f29646c.invalidateAll();
        this.f29648e.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r6.f29650g.hasPendingBindings() == false) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
        if (r6.f29651h.hasPendingBindings() == false) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002e, code lost:
        if (r6.f29644a.hasPendingBindings() == false) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0030, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0037, code lost:
        if (r6.f29649f.hasPendingBindings() == false) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0039, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0040, code lost:
        if (r6.f29647d.hasPendingBindings() == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0042, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0049, code lost:
        if (r6.f29646c.hasPendingBindings() == false) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004b, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0052, code lost:
        if (r6.f29648e.hasPendingBindings() == false) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0054, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0055, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.f29645b.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean hasPendingBindings() {
        /*
            r6 = this;
            monitor-enter(r6)
            long r0 = r6.p     // Catch:{ all -> 0x0057 }
            r2 = 0
            r4 = 1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x000c
            monitor-exit(r6)     // Catch:{ all -> 0x0057 }
            return r4
        L_0x000c:
            monitor-exit(r6)     // Catch:{ all -> 0x0057 }
            net.one97.paytm.hotels2.b.eq r0 = r6.f29645b
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0016
            return r4
        L_0x0016:
            net.one97.paytm.hotels2.b.aq r0 = r6.f29650g
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x001f
            return r4
        L_0x001f:
            net.one97.paytm.hotels2.b.aq r0 = r6.f29651h
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0028
            return r4
        L_0x0028:
            net.one97.paytm.hotels2.b.ag r0 = r6.f29644a
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0031
            return r4
        L_0x0031:
            net.one97.paytm.hotels2.b.ag r0 = r6.f29649f
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x003a
            return r4
        L_0x003a:
            net.one97.paytm.hotels2.b.ao r0 = r6.f29647d
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0043
            return r4
        L_0x0043:
            net.one97.paytm.hotels2.b.ai r0 = r6.f29646c
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x004c
            return r4
        L_0x004c:
            net.one97.paytm.hotels2.b.ak r0 = r6.f29648e
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0055
            return r4
        L_0x0055:
            r0 = 0
            return r0
        L_0x0057:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0057 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotels2.b.et.hasPendingBindings():boolean");
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.f29088c != i2) {
            return false;
        }
        a((SRPFilterViewModel) obj);
        return true;
    }

    public final void a(SRPFilterViewModel sRPFilterViewModel) {
        this.f29652i = sRPFilterViewModel;
        synchronized (this) {
            this.p |= 65536;
        }
        notifyPropertyChanged(a.f29088c);
        super.requestRebind();
    }

    public final void setLifecycleOwner(q qVar) {
        super.setLifecycleOwner(qVar);
        this.f29645b.setLifecycleOwner(qVar);
        this.f29650g.setLifecycleOwner(qVar);
        this.f29651h.setLifecycleOwner(qVar);
        this.f29644a.setLifecycleOwner(qVar);
        this.f29649f.setLifecycleOwner(qVar);
        this.f29647d.setLifecycleOwner(qVar);
        this.f29646c.setLifecycleOwner(qVar);
        this.f29648e.setLifecycleOwner(qVar);
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
            case 7:
                return i(i3);
            case 8:
                return j(i3);
            case 9:
                return k(i3);
            case 10:
                return l(i3);
            case 11:
                return m(i3);
            case 12:
                return n(i3);
            case 13:
                return o(i3);
            case 14:
                return p(i3);
            case 15:
                return q(i3);
            default:
                return false;
        }
    }

    private boolean b(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.p |= 1;
        }
        return true;
    }

    private boolean c(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.p |= 2;
        }
        return true;
    }

    private boolean d(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.p |= 4;
        }
        return true;
    }

    private boolean e(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.p |= 8;
        }
        return true;
    }

    private boolean f(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.p |= 16;
        }
        return true;
    }

    private boolean g(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.p |= 32;
        }
        return true;
    }

    private boolean h(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.p |= 64;
        }
        return true;
    }

    private boolean i(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.p |= 128;
        }
        return true;
    }

    private boolean j(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.p |= 256;
        }
        return true;
    }

    private boolean k(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.p |= 512;
        }
        return true;
    }

    private boolean l(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.p |= 1024;
        }
        return true;
    }

    private boolean m(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.p |= 2048;
        }
        return true;
    }

    private boolean n(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.p |= 4096;
        }
        return true;
    }

    private boolean o(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.p |= 8192;
        }
        return true;
    }

    private boolean p(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.p |= 16384;
        }
        return true;
    }

    private boolean q(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.p |= 32768;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:116:0x0188  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01c9  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0204  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00a9 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0147  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r43 = this;
            r1 = r43
            monitor-enter(r43)
            long r2 = r1.p     // Catch:{ all -> 0x030b }
            r4 = 0
            r1.p = r4     // Catch:{ all -> 0x030b }
            monitor-exit(r43)     // Catch:{ all -> 0x030b }
            net.one97.paytm.hotel4.viewmodel.filter.SRPFilterViewModel r0 = r1.f29652i
            r6 = 248350(0x3ca1e, double:1.22701E-318)
            long r6 = r6 & r2
            r12 = 197120(0x30200, double:9.739E-319)
            r16 = 196616(0x30008, double:9.7141E-319)
            r18 = 196624(0x30010, double:9.7145E-319)
            r20 = 196608(0x30000, double:9.71373E-319)
            r22 = 196610(0x30002, double:9.7138E-319)
            r24 = 196612(0x30004, double:9.7139E-319)
            r26 = 0
            r27 = 0
            int r28 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r28 == 0) goto L_0x020e
            long r6 = r2 & r22
            r10 = 1
            int r11 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x0046
            if (r0 == 0) goto L_0x0038
            androidx.lifecycle.y r6 = r0.getHotelTypeShowMoreLessText()
            goto L_0x003a
        L_0x0038:
            r6 = r27
        L_0x003a:
            r1.updateLiveDataRegistration(r10, r6)
            if (r6 == 0) goto L_0x0046
            java.lang.Object r6 = r6.getValue()
            java.lang.String r6 = (java.lang.String) r6
            goto L_0x0048
        L_0x0046:
            r6 = r27
        L_0x0048:
            long r30 = r2 & r24
            int r7 = (r30 > r4 ? 1 : (r30 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x0064
            if (r0 == 0) goto L_0x0055
            androidx.lifecycle.y r7 = r0.getAmenitiesShowMoreLessText()
            goto L_0x0057
        L_0x0055:
            r7 = r27
        L_0x0057:
            r11 = 2
            r1.updateLiveDataRegistration(r11, r7)
            if (r7 == 0) goto L_0x0064
            java.lang.Object r7 = r7.getValue()
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x0066
        L_0x0064:
            r7 = r27
        L_0x0066:
            long r30 = r2 & r16
            int r32 = (r30 > r4 ? 1 : (r30 == r4 ? 0 : -1))
            if (r32 == 0) goto L_0x00a2
            if (r0 == 0) goto L_0x0075
            androidx.lifecycle.y r30 = r0.getStartRaitingsVisibility()
            r11 = r30
            goto L_0x0077
        L_0x0075:
            r11 = r27
        L_0x0077:
            r8 = 3
            r1.updateLiveDataRegistration(r8, r11)
            if (r11 == 0) goto L_0x0084
            java.lang.Object r8 = r11.getValue()
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            goto L_0x0086
        L_0x0084:
            r8 = r27
        L_0x0086:
            boolean r8 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r8)
            if (r8 != r10) goto L_0x008e
            r8 = 1
            goto L_0x008f
        L_0x008e:
            r8 = 0
        L_0x008f:
            if (r32 == 0) goto L_0x009c
            if (r8 == 0) goto L_0x0097
            r31 = 524288(0x80000, double:2.590327E-318)
            goto L_0x009a
        L_0x0097:
            r31 = 262144(0x40000, double:1.295163E-318)
        L_0x009a:
            long r2 = r2 | r31
        L_0x009c:
            if (r8 == 0) goto L_0x009f
            goto L_0x00a2
        L_0x009f:
            r8 = 8
            goto L_0x00a3
        L_0x00a2:
            r8 = 0
        L_0x00a3:
            long r31 = r2 & r20
            int r9 = (r31 > r4 ? 1 : (r31 == r4 ? 0 : -1))
            if (r9 == 0) goto L_0x00bc
            if (r0 == 0) goto L_0x00bc
            java.lang.String r9 = r0.getFilterStartRatingTitle()
            java.lang.String r11 = r0.getFilterPriceRangeTitle()
            java.lang.String r31 = r0.getFilterAmenitiesTitle()
            java.lang.String r32 = r0.getFilterHotelTypeTitle()
            goto L_0x00c3
        L_0x00bc:
            r9 = r27
            r11 = r9
            r31 = r11
            r32 = r31
        L_0x00c3:
            long r35 = r2 & r18
            int r37 = (r35 > r4 ? 1 : (r35 == r4 ? 0 : -1))
            if (r37 == 0) goto L_0x00ff
            if (r0 == 0) goto L_0x00d2
            androidx.lifecycle.y r35 = r0.getAmenitiesVisibility()
            r14 = r35
            goto L_0x00d4
        L_0x00d2:
            r14 = r27
        L_0x00d4:
            r15 = 4
            r1.updateLiveDataRegistration(r15, r14)
            if (r14 == 0) goto L_0x00e1
            java.lang.Object r14 = r14.getValue()
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            goto L_0x00e3
        L_0x00e1:
            r14 = r27
        L_0x00e3:
            boolean r14 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r14)
            if (r14 != r10) goto L_0x00eb
            r14 = 1
            goto L_0x00ec
        L_0x00eb:
            r14 = 0
        L_0x00ec:
            if (r37 == 0) goto L_0x00f9
            if (r14 == 0) goto L_0x00f4
            r37 = 536870912(0x20000000, double:2.652494739E-315)
            goto L_0x00f7
        L_0x00f4:
            r37 = 268435456(0x10000000, double:1.32624737E-315)
        L_0x00f7:
            long r2 = r2 | r37
        L_0x00f9:
            if (r14 == 0) goto L_0x00fc
            goto L_0x00ff
        L_0x00fc:
            r14 = 8
            goto L_0x0100
        L_0x00ff:
            r14 = 0
        L_0x0100:
            long r37 = r2 & r12
            int r15 = (r37 > r4 ? 1 : (r37 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x013d
            if (r0 == 0) goto L_0x010f
            androidx.lifecycle.y r37 = r0.getHoteLocalityVisibility()
            r12 = r37
            goto L_0x0111
        L_0x010f:
            r12 = r27
        L_0x0111:
            r13 = 9
            r1.updateLiveDataRegistration(r13, r12)
            if (r12 == 0) goto L_0x011f
            java.lang.Object r12 = r12.getValue()
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            goto L_0x0121
        L_0x011f:
            r12 = r27
        L_0x0121:
            boolean r12 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r12)
            if (r12 != r10) goto L_0x0129
            r12 = 1
            goto L_0x012a
        L_0x0129:
            r12 = 0
        L_0x012a:
            if (r15 == 0) goto L_0x0137
            if (r12 == 0) goto L_0x0132
            r39 = 134217728(0x8000000, double:6.63123685E-316)
            goto L_0x0135
        L_0x0132:
            r39 = 67108864(0x4000000, double:3.31561842E-316)
        L_0x0135:
            long r2 = r2 | r39
        L_0x0137:
            if (r12 == 0) goto L_0x013a
            goto L_0x013d
        L_0x013a:
            r12 = 8
            goto L_0x013e
        L_0x013d:
            r12 = 0
        L_0x013e:
            r35 = 198656(0x30800, double:9.8149E-319)
            long r39 = r2 & r35
            int r13 = (r39 > r4 ? 1 : (r39 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x017c
            if (r0 == 0) goto L_0x014e
            androidx.lifecycle.y r15 = r0.getHotelChainVisibility()
            goto L_0x0150
        L_0x014e:
            r15 = r27
        L_0x0150:
            r4 = 11
            r1.updateLiveDataRegistration(r4, r15)
            if (r15 == 0) goto L_0x015e
            java.lang.Object r4 = r15.getValue()
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            goto L_0x0160
        L_0x015e:
            r4 = r27
        L_0x0160:
            boolean r4 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r4)
            if (r4 != r10) goto L_0x0168
            r4 = 1
            goto L_0x0169
        L_0x0168:
            r4 = 0
        L_0x0169:
            if (r13 == 0) goto L_0x0176
            if (r4 == 0) goto L_0x0171
            r41 = 8388608(0x800000, double:4.144523E-317)
            goto L_0x0174
        L_0x0171:
            r41 = 4194304(0x400000, double:2.0722615E-317)
        L_0x0174:
            long r2 = r2 | r41
        L_0x0176:
            if (r4 == 0) goto L_0x0179
            goto L_0x017c
        L_0x0179:
            r4 = 8
            goto L_0x017d
        L_0x017c:
            r4 = 0
        L_0x017d:
            r33 = 212992(0x34000, double:1.05232E-318)
            long r41 = r2 & r33
            r39 = 0
            int r5 = (r41 > r39 ? 1 : (r41 == r39 ? 0 : -1))
            if (r5 == 0) goto L_0x01bd
            if (r0 == 0) goto L_0x018f
            androidx.lifecycle.y r13 = r0.getPropertyTypeVisibility()
            goto L_0x0191
        L_0x018f:
            r13 = r27
        L_0x0191:
            r15 = 14
            r1.updateLiveDataRegistration(r15, r13)
            if (r13 == 0) goto L_0x019f
            java.lang.Object r13 = r13.getValue()
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            goto L_0x01a1
        L_0x019f:
            r13 = r27
        L_0x01a1:
            boolean r13 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r13)
            if (r13 != r10) goto L_0x01a9
            r13 = 1
            goto L_0x01aa
        L_0x01a9:
            r13 = 0
        L_0x01aa:
            if (r5 == 0) goto L_0x01b7
            if (r13 == 0) goto L_0x01b2
            r41 = 2097152(0x200000, double:1.0361308E-317)
            goto L_0x01b5
        L_0x01b2:
            r41 = 1048576(0x100000, double:5.180654E-318)
        L_0x01b5:
            long r2 = r2 | r41
        L_0x01b7:
            if (r13 == 0) goto L_0x01ba
            goto L_0x01bd
        L_0x01ba:
            r5 = 8
            goto L_0x01be
        L_0x01bd:
            r5 = 0
        L_0x01be:
            r28 = 229376(0x38000, double:1.13327E-318)
            long r41 = r2 & r28
            r39 = 0
            int r13 = (r41 > r39 ? 1 : (r41 == r39 ? 0 : -1))
            if (r13 == 0) goto L_0x0204
            if (r0 == 0) goto L_0x01d0
            androidx.lifecycle.y r15 = r0.getHoteThemeVisibility()
            goto L_0x01d2
        L_0x01d0:
            r15 = r27
        L_0x01d2:
            r10 = 15
            r1.updateLiveDataRegistration(r10, r15)
            if (r15 == 0) goto L_0x01e1
            java.lang.Object r10 = r15.getValue()
            r27 = r10
            java.lang.Boolean r27 = (java.lang.Boolean) r27
        L_0x01e1:
            boolean r10 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r27)
            r15 = 1
            if (r10 != r15) goto L_0x01e9
            goto L_0x01ea
        L_0x01e9:
            r15 = 0
        L_0x01ea:
            if (r13 == 0) goto L_0x01f7
            if (r15 == 0) goto L_0x01f2
            r41 = 33554432(0x2000000, double:1.6578092E-316)
            goto L_0x01f5
        L_0x01f2:
            r41 = 16777216(0x1000000, double:8.289046E-317)
        L_0x01f5:
            long r2 = r2 | r41
        L_0x01f7:
            if (r15 == 0) goto L_0x01fa
            goto L_0x01fc
        L_0x01fa:
            r26 = 8
        L_0x01fc:
            r13 = r5
            r10 = r6
            r15 = r8
            r8 = r26
            r5 = r32
            goto L_0x020a
        L_0x0204:
            r13 = r5
            r10 = r6
            r15 = r8
            r5 = r32
            r8 = 0
        L_0x020a:
            r6 = r4
            r4 = r31
            goto L_0x021b
        L_0x020e:
            r4 = r27
            r5 = r4
            r7 = r5
            r9 = r7
            r10 = r9
            r11 = r10
            r6 = 0
            r8 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
        L_0x021b:
            long r24 = r2 & r24
            r26 = 0
            int r30 = (r24 > r26 ? 1 : (r24 == r26 ? 0 : -1))
            r24 = r15
            if (r30 == 0) goto L_0x022a
            net.one97.paytm.hotels2.b.ag r15 = r1.f29644a
            r15.b(r7)
        L_0x022a:
            long r20 = r2 & r20
            int r7 = (r20 > r26 ? 1 : (r20 == r26 ? 0 : -1))
            if (r7 == 0) goto L_0x0262
            net.one97.paytm.hotels2.b.ag r7 = r1.f29644a
            r7.a((java.lang.String) r4)
            net.one97.paytm.hotels2.b.ag r4 = r1.f29644a
            r4.a((net.one97.paytm.hotel4.viewmodel.filter.SRPFilterViewModel) r0)
            net.one97.paytm.hotels2.b.eq r4 = r1.f29645b
            r4.a(r0)
            net.one97.paytm.hotels2.b.ai r4 = r1.f29646c
            r4.a(r0)
            net.one97.paytm.hotels2.b.ao r4 = r1.f29647d
            r4.a(r0)
            net.one97.paytm.hotels2.b.ak r4 = r1.f29648e
            r4.a(r0)
            net.one97.paytm.hotels2.b.ag r4 = r1.f29649f
            r4.a((java.lang.String) r5)
            net.one97.paytm.hotels2.b.ag r4 = r1.f29649f
            r4.a((net.one97.paytm.hotel4.viewmodel.filter.SRPFilterViewModel) r0)
            net.one97.paytm.hotels2.b.aq r0 = r1.f29650g
            r0.a(r11)
            net.one97.paytm.hotels2.b.aq r0 = r1.f29651h
            r0.a(r9)
        L_0x0262:
            long r4 = r2 & r18
            r18 = 0
            int r0 = (r4 > r18 ? 1 : (r4 == r18 ? 0 : -1))
            if (r0 == 0) goto L_0x0273
            net.one97.paytm.hotels2.b.ag r0 = r1.f29644a
            android.view.View r0 = r0.getRoot()
            r0.setVisibility(r14)
        L_0x0273:
            r4 = 198656(0x30800, double:9.8149E-319)
            long r4 = r4 & r2
            int r0 = (r4 > r18 ? 1 : (r4 == r18 ? 0 : -1))
            if (r0 == 0) goto L_0x0284
            net.one97.paytm.hotels2.b.ai r0 = r1.f29646c
            android.view.View r0 = r0.getRoot()
            r0.setVisibility(r6)
        L_0x0284:
            r4 = 197120(0x30200, double:9.739E-319)
            long r4 = r4 & r2
            int r0 = (r4 > r18 ? 1 : (r4 == r18 ? 0 : -1))
            if (r0 == 0) goto L_0x0295
            net.one97.paytm.hotels2.b.ao r0 = r1.f29647d
            android.view.View r0 = r0.getRoot()
            r0.setVisibility(r12)
        L_0x0295:
            r4 = 229376(0x38000, double:1.13327E-318)
            long r4 = r4 & r2
            int r0 = (r4 > r18 ? 1 : (r4 == r18 ? 0 : -1))
            if (r0 == 0) goto L_0x02a6
            net.one97.paytm.hotels2.b.ak r0 = r1.f29648e
            android.view.View r0 = r0.getRoot()
            r0.setVisibility(r8)
        L_0x02a6:
            long r4 = r2 & r22
            int r0 = (r4 > r18 ? 1 : (r4 == r18 ? 0 : -1))
            if (r0 == 0) goto L_0x02b1
            net.one97.paytm.hotels2.b.ag r0 = r1.f29649f
            r0.b(r10)
        L_0x02b1:
            r4 = 212992(0x34000, double:1.05232E-318)
            long r4 = r4 & r2
            int r0 = (r4 > r18 ? 1 : (r4 == r18 ? 0 : -1))
            if (r0 == 0) goto L_0x02c2
            net.one97.paytm.hotels2.b.ag r0 = r1.f29649f
            android.view.View r0 = r0.getRoot()
            r0.setVisibility(r13)
        L_0x02c2:
            r4 = 131072(0x20000, double:6.47582E-319)
            long r4 = r4 & r2
            int r0 = (r4 > r18 ? 1 : (r4 == r18 ? 0 : -1))
            if (r0 == 0) goto L_0x02d1
            android.widget.TextView r0 = r1.n
            android.view.View$OnClickListener r4 = r1.o
            r0.setOnClickListener(r4)
        L_0x02d1:
            long r2 = r2 & r16
            int r0 = (r2 > r18 ? 1 : (r2 == r18 ? 0 : -1))
            if (r0 == 0) goto L_0x02e2
            net.one97.paytm.hotels2.b.aq r0 = r1.f29651h
            android.view.View r0 = r0.getRoot()
            r8 = r24
            r0.setVisibility(r8)
        L_0x02e2:
            net.one97.paytm.hotels2.b.eq r0 = r1.f29645b
            executeBindingsOn(r0)
            net.one97.paytm.hotels2.b.aq r0 = r1.f29650g
            executeBindingsOn(r0)
            net.one97.paytm.hotels2.b.aq r0 = r1.f29651h
            executeBindingsOn(r0)
            net.one97.paytm.hotels2.b.ag r0 = r1.f29644a
            executeBindingsOn(r0)
            net.one97.paytm.hotels2.b.ag r0 = r1.f29649f
            executeBindingsOn(r0)
            net.one97.paytm.hotels2.b.ao r0 = r1.f29647d
            executeBindingsOn(r0)
            net.one97.paytm.hotels2.b.ai r0 = r1.f29646c
            executeBindingsOn(r0)
            net.one97.paytm.hotels2.b.ak r0 = r1.f29648e
            executeBindingsOn(r0)
            return
        L_0x030b:
            r0 = move-exception
            monitor-exit(r43)     // Catch:{ all -> 0x030b }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotels2.b.et.executeBindings():void");
    }

    public final void a(int i2) {
        SRPFilterViewModel sRPFilterViewModel = this.f29652i;
        if (sRPFilterViewModel != null) {
            sRPFilterViewModel.filterApplyClick();
        }
    }
}
