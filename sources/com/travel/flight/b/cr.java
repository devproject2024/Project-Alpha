package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.travel.flight.e.a.a;
import com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel;

public final class cr extends cq implements a.C0456a {
    private static final ViewDataBinding.b l = null;
    private static final SparseIntArray m = null;
    private final ConstraintLayout n;
    private final View.OnClickListener o;
    private final View.OnClickListener p;
    private final View.OnClickListener q;
    private final View.OnClickListener r;
    private final View.OnClickListener s;
    private final View.OnClickListener t;
    private final View.OnClickListener u;
    private final View.OnClickListener v;
    private final View.OnClickListener w;
    private final View.OnClickListener x;
    private long y;

    public cr(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 11, l, m));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private cr(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[4], objArr[1], objArr[10], objArr[7], objArr[9], objArr[8], objArr[6], objArr[3], objArr[5], objArr[2]);
        this.y = -1;
        this.f23840a.setTag((Object) null);
        this.f23841b.setTag((Object) null);
        this.f23842c.setTag((Object) null);
        this.f23843d.setTag((Object) null);
        this.f23844e.setTag((Object) null);
        this.f23845f.setTag((Object) null);
        this.f23846g.setTag((Object) null);
        this.n = objArr[0];
        this.n.setTag((Object) null);
        this.f23847h.setTag((Object) null);
        this.f23848i.setTag((Object) null);
        this.j.setTag((Object) null);
        setRootTag(view);
        this.o = new a(this, 7);
        this.p = new a(this, 3);
        this.q = new a(this, 8);
        this.r = new a(this, 1);
        this.s = new a(this, 9);
        this.t = new a(this, 5);
        this.u = new a(this, 4);
        this.v = new a(this, 10);
        this.w = new a(this, 6);
        this.x = new a(this, 2);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.y = 256;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.y != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (com.travel.flight.a.f23479c != i2) {
            return false;
        }
        a((SRPSharedViewModel) obj);
        return true;
    }

    public final void a(SRPSharedViewModel sRPSharedViewModel) {
        this.k = sRPSharedViewModel;
        synchronized (this) {
            this.y |= 128;
        }
        notifyPropertyChanged(com.travel.flight.a.f23479c);
        super.requestRebind();
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return a(i3);
            case 1:
                return b(i3);
            case 2:
                return c(i3);
            case 3:
                return d(i3);
            case 4:
                return e(i3);
            case 5:
                return f(i3);
            case 6:
                return g(i3);
            default:
                return false;
        }
    }

    private boolean a(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.y |= 1;
        }
        return true;
    }

    private boolean b(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.y |= 2;
        }
        return true;
    }

    private boolean c(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.y |= 4;
        }
        return true;
    }

    private boolean d(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.y |= 8;
        }
        return true;
    }

    private boolean e(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.y |= 16;
        }
        return true;
    }

    private boolean f(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.y |= 32;
        }
        return true;
    }

    private boolean g(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.y |= 64;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:126:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0196  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x019f  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01c5  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x01e9  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0236  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0241  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x024d  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x0263  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x026a  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0275  */
    /* JADX WARNING: Removed duplicated region for block: B:180:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0121  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r36 = this;
            r1 = r36
            monitor-enter(r36)
            long r2 = r1.y     // Catch:{ all -> 0x0280 }
            r4 = 0
            r1.y = r4     // Catch:{ all -> 0x0280 }
            monitor-exit(r36)     // Catch:{ all -> 0x0280 }
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r0 = r1.k
            r6 = 511(0x1ff, double:2.525E-321)
            long r6 = r6 & r2
            r10 = 400(0x190, double:1.976E-321)
            r12 = 424(0x1a8, double:2.095E-321)
            r14 = 388(0x184, double:1.917E-321)
            r16 = 1024(0x400, double:5.06E-321)
            r18 = 385(0x181, double:1.9E-321)
            r20 = 2048(0x800, double:1.0118E-320)
            r22 = 8
            r23 = 386(0x182, double:1.907E-321)
            r8 = 1
            r9 = 0
            int r27 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r27 == 0) goto L_0x0152
            long r6 = r2 & r18
            int r27 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r27 == 0) goto L_0x0057
            if (r0 == 0) goto L_0x0032
            androidx.lifecycle.y r6 = r0.getShowSortFilterIcon()
            goto L_0x0033
        L_0x0032:
            r6 = 0
        L_0x0033:
            r1.updateLiveDataRegistration(r9, r6)
            if (r6 == 0) goto L_0x003f
            java.lang.Object r6 = r6.getValue()
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            goto L_0x0040
        L_0x003f:
            r6 = 0
        L_0x0040:
            boolean r6 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r6)
            if (r27 == 0) goto L_0x0051
            if (r6 == 0) goto L_0x004c
            r27 = 262144(0x40000, double:1.295163E-318)
            goto L_0x004f
        L_0x004c:
            r27 = 131072(0x20000, double:6.47582E-319)
        L_0x004f:
            long r2 = r2 | r27
        L_0x0051:
            if (r6 == 0) goto L_0x0054
            goto L_0x0057
        L_0x0054:
            r6 = 8
            goto L_0x0058
        L_0x0057:
            r6 = 0
        L_0x0058:
            long r27 = r2 & r23
            int r7 = (r27 > r4 ? 1 : (r27 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x0085
            if (r0 == 0) goto L_0x0067
            androidx.lifecycle.y r27 = r0.isFareAlertSelectable()
            r9 = r27
            goto L_0x0068
        L_0x0067:
            r9 = 0
        L_0x0068:
            r1.updateLiveDataRegistration(r8, r9)
            if (r9 == 0) goto L_0x0074
            java.lang.Object r9 = r9.getValue()
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            goto L_0x0075
        L_0x0074:
            r9 = 0
        L_0x0075:
            boolean r9 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r9)
            if (r7 == 0) goto L_0x0086
            if (r9 == 0) goto L_0x0080
            long r2 = r2 | r16
            goto L_0x0086
        L_0x0080:
            r28 = 512(0x200, double:2.53E-321)
            long r2 = r2 | r28
            goto L_0x0086
        L_0x0085:
            r9 = 0
        L_0x0086:
            long r28 = r2 & r14
            int r7 = (r28 > r4 ? 1 : (r28 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x00a7
            if (r0 == 0) goto L_0x0093
            androidx.lifecycle.y r7 = r0.isFareAlertSelected()
            goto L_0x0094
        L_0x0093:
            r7 = 0
        L_0x0094:
            r14 = 2
            r1.updateLiveDataRegistration(r14, r7)
            if (r7 == 0) goto L_0x00a1
            java.lang.Object r7 = r7.getValue()
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            goto L_0x00a2
        L_0x00a1:
            r7 = 0
        L_0x00a2:
            boolean r7 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r7)
            goto L_0x00a8
        L_0x00a7:
            r7 = 0
        L_0x00a8:
            long r14 = r2 & r12
            int r30 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r30 == 0) goto L_0x00dd
            if (r0 == 0) goto L_0x00b5
            androidx.lifecycle.y r14 = r0.getOnwardFilterList()
            goto L_0x00b6
        L_0x00b5:
            r14 = 0
        L_0x00b6:
            r15 = 3
            r1.updateLiveDataRegistration(r15, r14)
            if (r14 == 0) goto L_0x00c3
            java.lang.Object r14 = r14.getValue()
            java.util.List r14 = (java.util.List) r14
            goto L_0x00c4
        L_0x00c3:
            r14 = 0
        L_0x00c4:
            if (r14 == 0) goto L_0x00cb
            int r14 = r14.size()
            goto L_0x00cc
        L_0x00cb:
            r14 = 0
        L_0x00cc:
            if (r14 <= 0) goto L_0x00d0
            r14 = 1
            goto L_0x00d1
        L_0x00d0:
            r14 = 0
        L_0x00d1:
            if (r30 == 0) goto L_0x00de
            if (r14 == 0) goto L_0x00da
            r30 = 4096(0x1000, double:2.0237E-320)
            long r2 = r2 | r30
            goto L_0x00de
        L_0x00da:
            long r2 = r2 | r20
            goto L_0x00de
        L_0x00dd:
            r14 = 0
        L_0x00de:
            long r30 = r2 & r10
            int r15 = (r30 > r4 ? 1 : (r30 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x0116
            if (r0 == 0) goto L_0x00eb
            androidx.lifecycle.y r15 = r0.getSearchInput()
            goto L_0x00ec
        L_0x00eb:
            r15 = 0
        L_0x00ec:
            r10 = 4
            r1.updateLiveDataRegistration(r10, r15)
            if (r15 == 0) goto L_0x00f9
            java.lang.Object r10 = r15.getValue()
            com.travel.flight.pojo.flightticket.CJRFlightSearchInput r10 = (com.travel.flight.pojo.flightticket.CJRFlightSearchInput) r10
            goto L_0x00fa
        L_0x00f9:
            r10 = 0
        L_0x00fa:
            if (r10 == 0) goto L_0x0105
            com.travel.flight.pojo.flightticket.b r11 = r10.getDestination()
            com.travel.flight.pojo.flightticket.b r15 = r10.getSource()
            goto L_0x0107
        L_0x0105:
            r11 = 0
            r15 = 0
        L_0x0107:
            if (r11 == 0) goto L_0x010e
            java.lang.String r11 = r11.getCityName()
            goto L_0x010f
        L_0x010e:
            r11 = 0
        L_0x010f:
            if (r15 == 0) goto L_0x0118
            java.lang.String r15 = r15.getCityName()
            goto L_0x0119
        L_0x0116:
            r10 = 0
            r11 = 0
        L_0x0118:
            r15 = 0
        L_0x0119:
            r25 = 448(0x1c0, double:2.213E-321)
            long r32 = r2 & r25
            int r34 = (r32 > r4 ? 1 : (r32 == r4 ? 0 : -1))
            if (r34 == 0) goto L_0x0150
            if (r0 == 0) goto L_0x012a
            androidx.lifecycle.y r32 = r0.getShowFareCalenderIcon()
            r12 = r32
            goto L_0x012b
        L_0x012a:
            r12 = 0
        L_0x012b:
            r13 = 6
            r1.updateLiveDataRegistration(r13, r12)
            if (r12 == 0) goto L_0x0138
            java.lang.Object r12 = r12.getValue()
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            goto L_0x0139
        L_0x0138:
            r12 = 0
        L_0x0139:
            boolean r12 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r12)
            if (r34 == 0) goto L_0x014a
            if (r12 == 0) goto L_0x0145
            r34 = 65536(0x10000, double:3.2379E-319)
            goto L_0x0148
        L_0x0145:
            r34 = 32768(0x8000, double:1.61895E-319)
        L_0x0148:
            long r2 = r2 | r34
        L_0x014a:
            if (r12 == 0) goto L_0x014d
            goto L_0x0150
        L_0x014d:
            r12 = 8
            goto L_0x015a
        L_0x0150:
            r12 = 0
            goto L_0x015a
        L_0x0152:
            r6 = 0
            r7 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r14 = 0
            r15 = 0
        L_0x015a:
            long r20 = r2 & r20
            int r13 = (r20 > r4 ? 1 : (r20 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x0182
            if (r0 == 0) goto L_0x0167
            androidx.lifecycle.y r13 = r0.getReturnFilterList()
            goto L_0x0168
        L_0x0167:
            r13 = 0
        L_0x0168:
            r8 = 5
            r1.updateLiveDataRegistration(r8, r13)
            if (r13 == 0) goto L_0x0175
            java.lang.Object r8 = r13.getValue()
            java.util.List r8 = (java.util.List) r8
            goto L_0x0176
        L_0x0175:
            r8 = 0
        L_0x0176:
            if (r8 == 0) goto L_0x017d
            int r8 = r8.size()
            goto L_0x017e
        L_0x017d:
            r8 = 0
        L_0x017e:
            if (r8 <= 0) goto L_0x0182
            r8 = 1
            goto L_0x0183
        L_0x0182:
            r8 = 0
        L_0x0183:
            long r16 = r2 & r16
            int r13 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x0196
            if (r0 == 0) goto L_0x0190
            boolean r13 = r0.isRoundTrip()
            goto L_0x0191
        L_0x0190:
            r13 = 0
        L_0x0191:
            r16 = 1
            r13 = r13 ^ 1
            goto L_0x0199
        L_0x0196:
            r16 = 1
            r13 = 0
        L_0x0199:
            long r20 = r2 & r23
            int r17 = (r20 > r4 ? 1 : (r20 == r4 ? 0 : -1))
            if (r17 == 0) goto L_0x01b4
            if (r9 == 0) goto L_0x01a2
            goto L_0x01a3
        L_0x01a2:
            r13 = 0
        L_0x01a3:
            if (r17 == 0) goto L_0x01ae
            if (r13 == 0) goto L_0x01aa
            r20 = 16384(0x4000, double:8.0948E-320)
            goto L_0x01ac
        L_0x01aa:
            r20 = 8192(0x2000, double:4.0474E-320)
        L_0x01ac:
            long r2 = r2 | r20
        L_0x01ae:
            if (r13 == 0) goto L_0x01b1
            goto L_0x01b4
        L_0x01b1:
            r9 = 8
            goto L_0x01b5
        L_0x01b4:
            r9 = 0
        L_0x01b5:
            r20 = 424(0x1a8, double:2.095E-321)
            long r20 = r2 & r20
            int r13 = (r20 > r4 ? 1 : (r20 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x01c5
            if (r14 == 0) goto L_0x01c0
            goto L_0x01c2
        L_0x01c0:
            r16 = r8
        L_0x01c2:
            r8 = r16
            goto L_0x01c6
        L_0x01c5:
            r8 = 0
        L_0x01c6:
            r16 = 400(0x190, double:1.976E-321)
            long r16 = r2 & r16
            int r14 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x01e2
            android.widget.ImageView r14 = r1.f23840a
            com.travel.flight.flightSRPV2.viewModel.SRPModifyViewModel.setRouteHeader(r14, r10)
            com.paytm.utility.RoboTextView r14 = r1.f23847h
            com.travel.flight.flightSRPV2.c.c.a((android.widget.TextView) r14, (com.travel.flight.pojo.flightticket.CJRFlightSearchInput) r10)
            com.paytm.utility.RoboTextView r10 = r1.f23848i
            androidx.databinding.a.d.a((android.widget.TextView) r10, (java.lang.CharSequence) r11)
            com.paytm.utility.RoboTextView r10 = r1.j
            androidx.databinding.a.d.a((android.widget.TextView) r10, (java.lang.CharSequence) r15)
        L_0x01e2:
            r10 = 256(0x100, double:1.265E-321)
            long r10 = r10 & r2
            int r14 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x022f
            android.widget.ImageView r10 = r1.f23840a
            android.view.View$OnClickListener r11 = r1.u
            r10.setOnClickListener(r11)
            android.widget.ImageView r10 = r1.f23841b
            android.view.View$OnClickListener r11 = r1.r
            r10.setOnClickListener(r11)
            android.widget.ImageView r10 = r1.f23842c
            android.view.View$OnClickListener r11 = r1.v
            r10.setOnClickListener(r11)
            android.widget.ImageView r10 = r1.f23843d
            android.view.View$OnClickListener r11 = r1.o
            r10.setOnClickListener(r11)
            android.widget.ImageView r10 = r1.f23844e
            android.view.View$OnClickListener r11 = r1.s
            r10.setOnClickListener(r11)
            android.widget.ImageView r10 = r1.f23845f
            android.view.View$OnClickListener r11 = r1.q
            r10.setOnClickListener(r11)
            android.widget.ImageView r10 = r1.f23846g
            android.view.View$OnClickListener r11 = r1.w
            r10.setOnClickListener(r11)
            com.paytm.utility.RoboTextView r10 = r1.f23847h
            android.view.View$OnClickListener r11 = r1.p
            r10.setOnClickListener(r11)
            com.paytm.utility.RoboTextView r10 = r1.f23848i
            android.view.View$OnClickListener r11 = r1.t
            r10.setOnClickListener(r11)
            com.paytm.utility.RoboTextView r10 = r1.j
            android.view.View$OnClickListener r11 = r1.x
            r10.setOnClickListener(r11)
        L_0x022f:
            r10 = 388(0x184, double:1.917E-321)
            long r10 = r10 & r2
            int r14 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x023b
            android.widget.ImageView r10 = r1.f23842c
            com.travel.flight.flightSRPV2.c.c.a((android.widget.ImageView) r10, (boolean) r7)
        L_0x023b:
            long r10 = r2 & r23
            int r7 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x0246
            android.widget.ImageView r7 = r1.f23842c
            r7.setVisibility(r9)
        L_0x0246:
            r9 = 384(0x180, double:1.897E-321)
            long r9 = r9 & r2
            int r7 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x025c
            android.widget.ImageView r7 = r1.f23843d
            com.travel.flight.flightSRPV2.c.c.a((android.widget.ImageView) r7, (com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel) r0)
            android.widget.ImageView r7 = r1.f23845f
            com.travel.flight.flightSRPV2.c.c.b((android.widget.ImageView) r7, (com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel) r0)
            android.widget.ImageView r7 = r1.f23846g
            com.travel.flight.flightSRPV2.c.c.c((android.widget.ImageView) r7, (com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel) r0)
        L_0x025c:
            r9 = 448(0x1c0, double:2.213E-321)
            long r9 = r9 & r2
            int r0 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0268
            android.widget.ImageView r0 = r1.f23843d
            r0.setVisibility(r12)
        L_0x0268:
            if (r13 == 0) goto L_0x026f
            android.widget.ImageView r0 = r1.f23844e
            com.travel.flight.flightSRPV2.c.c.b((android.widget.ImageView) r0, (boolean) r8)
        L_0x026f:
            long r2 = r2 & r18
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x027f
            android.widget.ImageView r0 = r1.f23844e
            r0.setVisibility(r6)
            android.widget.ImageView r0 = r1.f23845f
            r0.setVisibility(r6)
        L_0x027f:
            return
        L_0x0280:
            r0 = move-exception
            monitor-exit(r36)     // Catch:{ all -> 0x0280 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.b.cr.executeBindings():void");
    }

    public final void a(int i2, View view) {
        boolean z = false;
        switch (i2) {
            case 1:
                SRPSharedViewModel sRPSharedViewModel = this.k;
                if (sRPSharedViewModel != null) {
                    z = true;
                }
                if (z) {
                    sRPSharedViewModel.onBackPressedMain();
                    return;
                }
                return;
            case 2:
                SRPSharedViewModel sRPSharedViewModel2 = this.k;
                if (sRPSharedViewModel2 != null) {
                    z = true;
                }
                if (z) {
                    sRPSharedViewModel2.onSRPModifyRequested();
                    return;
                }
                return;
            case 3:
                SRPSharedViewModel sRPSharedViewModel3 = this.k;
                if (sRPSharedViewModel3 != null) {
                    z = true;
                }
                if (z) {
                    sRPSharedViewModel3.onSRPModifyRequested();
                    return;
                }
                return;
            case 4:
                SRPSharedViewModel sRPSharedViewModel4 = this.k;
                if (sRPSharedViewModel4 != null) {
                    z = true;
                }
                if (z) {
                    sRPSharedViewModel4.onSRPModifyRequested();
                    return;
                }
                return;
            case 5:
                SRPSharedViewModel sRPSharedViewModel5 = this.k;
                if (sRPSharedViewModel5 != null) {
                    z = true;
                }
                if (z) {
                    sRPSharedViewModel5.onSRPModifyRequested();
                    return;
                }
                return;
            case 6:
                SRPSharedViewModel sRPSharedViewModel6 = this.k;
                if (sRPSharedViewModel6 != null) {
                    z = true;
                }
                if (z) {
                    sRPSharedViewModel6.onSRPModifyRequested();
                    return;
                }
                return;
            case 7:
                SRPSharedViewModel sRPSharedViewModel7 = this.k;
                if (sRPSharedViewModel7 != null) {
                    z = true;
                }
                if (z && view != null) {
                    view.getContext();
                    sRPSharedViewModel7.openCalendar(view.getContext(), true);
                    return;
                }
                return;
            case 8:
                SRPSharedViewModel sRPSharedViewModel8 = this.k;
                if (sRPSharedViewModel8 != null) {
                    z = true;
                }
                if (z) {
                    sRPSharedViewModel8.onSortOptionsRequested(!sRPSharedViewModel8.isRoundTrip());
                    return;
                }
                return;
            case 9:
                SRPSharedViewModel sRPSharedViewModel9 = this.k;
                if (sRPSharedViewModel9 != null) {
                    z = true;
                }
                if (z) {
                    sRPSharedViewModel9.onFilterOptionsRequested();
                    return;
                }
                return;
            case 10:
                SRPSharedViewModel sRPSharedViewModel10 = this.k;
                if (sRPSharedViewModel10 != null) {
                    z = true;
                }
                if (z) {
                    sRPSharedViewModel10.toggleFareAlert();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
