package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.travel.flight.R;
import com.travel.flight.e.a.a;
import com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel;

public final class ah extends ag implements a.C0456a {

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.b f23578f = null;

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f23579g;
    private final RelativeLayout A;
    private final TextView B;
    private final TextView C;
    private final ImageView D;
    private final RelativeLayout E;
    private final TextView F;
    private final ImageView G;
    private final ImageView H;
    private final RelativeLayout I;
    private final TextView J;
    private final ImageView K;
    private final TextView L;
    private final RelativeLayout M;
    private final View.OnClickListener N;
    private final View.OnClickListener O;
    private final View.OnClickListener P;
    private final View.OnClickListener Q;
    private final View.OnClickListener R;
    private final View.OnClickListener S;
    private final View.OnClickListener T;
    private final View.OnClickListener U;
    private final View.OnClickListener V;
    private final View.OnClickListener W;
    private final View.OnClickListener X;
    private long Y;

    /* renamed from: h  reason: collision with root package name */
    private final TextView f23580h;

    /* renamed from: i  reason: collision with root package name */
    private final ImageView f23581i;
    private final RelativeLayout j;
    private final TextView k;
    private final ImageView l;
    private final RelativeLayout m;
    private final TextView n;
    private final ImageView o;
    private final RelativeLayout p;
    private final TextView q;
    private final RelativeLayout r;
    private final ImageView s;
    private final TextView t;
    private final RelativeLayout u;
    private final TextView v;
    private final ImageView w;
    private final RelativeLayout x;
    private final TextView y;
    private final ImageView z;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f23579g = sparseIntArray;
        sparseIntArray.put(R.id.sort_lyt, 34);
        f23579g.put(R.id.transparent_padding, 35);
    }

    public ah(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 36, f23578f, f23579g));
    }

    private ah(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[0], objArr[34], objArr[35]);
        this.Y = -1;
        this.f23573a.setTag((Object) null);
        this.f23574b.setTag((Object) null);
        this.f23580h = objArr[10];
        this.f23580h.setTag((Object) null);
        this.f23581i = objArr[11];
        this.f23581i.setTag((Object) null);
        this.j = objArr[12];
        this.j.setTag((Object) null);
        this.k = objArr[13];
        this.k.setTag((Object) null);
        this.l = objArr[14];
        this.l.setTag((Object) null);
        this.m = objArr[15];
        this.m.setTag((Object) null);
        this.n = objArr[16];
        this.n.setTag((Object) null);
        this.o = objArr[17];
        this.o.setTag((Object) null);
        this.p = objArr[18];
        this.p.setTag((Object) null);
        this.q = objArr[19];
        this.q.setTag((Object) null);
        this.r = objArr[2];
        this.r.setTag((Object) null);
        this.s = objArr[20];
        this.s.setTag((Object) null);
        this.t = objArr[21];
        this.t.setTag((Object) null);
        this.u = objArr[22];
        this.u.setTag((Object) null);
        this.v = objArr[23];
        this.v.setTag((Object) null);
        this.w = objArr[24];
        this.w.setTag((Object) null);
        this.x = objArr[25];
        this.x.setTag((Object) null);
        this.y = objArr[26];
        this.y.setTag((Object) null);
        this.z = objArr[27];
        this.z.setTag((Object) null);
        this.A = objArr[28];
        this.A.setTag((Object) null);
        this.B = objArr[29];
        this.B.setTag((Object) null);
        this.C = objArr[3];
        this.C.setTag((Object) null);
        this.D = objArr[30];
        this.D.setTag((Object) null);
        this.E = objArr[31];
        this.E.setTag((Object) null);
        this.F = objArr[32];
        this.F.setTag((Object) null);
        this.G = objArr[33];
        this.G.setTag((Object) null);
        this.H = objArr[4];
        this.H.setTag((Object) null);
        this.I = objArr[5];
        this.I.setTag((Object) null);
        this.J = objArr[6];
        this.J.setTag((Object) null);
        this.K = objArr[7];
        this.K.setTag((Object) null);
        this.L = objArr[8];
        this.L.setTag((Object) null);
        this.M = objArr[9];
        this.M.setTag((Object) null);
        setRootTag(view);
        this.N = new a(this, 7);
        this.O = new a(this, 2);
        this.P = new a(this, 10);
        this.Q = new a(this, 8);
        this.R = new a(this, 3);
        this.S = new a(this, 11);
        this.T = new a(this, 9);
        this.U = new a(this, 5);
        this.V = new a(this, 4);
        this.W = new a(this, 6);
        this.X = new a(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.Y = 8;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.Y != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (com.travel.flight.a.j != i2) {
            return false;
        }
        a((SRPSharedViewModel) obj);
        return true;
    }

    public final void a(SRPSharedViewModel sRPSharedViewModel) {
        this.f23577e = sRPSharedViewModel;
        synchronized (this) {
            this.Y |= 4;
        }
        notifyPropertyChanged(com.travel.flight.a.j);
        super.requestRebind();
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
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.Y |= 1;
        }
        return true;
    }

    private boolean b(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.Y |= 2;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:169:0x0238  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x028c  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x0314  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0369  */
    /* JADX WARNING: Removed duplicated region for block: B:187:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r43 = this;
            r1 = r43
            monitor-enter(r43)
            long r2 = r1.Y     // Catch:{ all -> 0x0378 }
            r4 = 0
            r1.Y = r4     // Catch:{ all -> 0x0378 }
            monitor-exit(r43)     // Catch:{ all -> 0x0378 }
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r0 = r1.f23577e
            r6 = 15
            long r8 = r2 & r6
            r12 = 10
            r13 = 9
            r14 = 7
            r6 = 4
            r7 = 5
            r10 = 3
            r19 = 13
            r15 = 1
            r11 = 0
            int r22 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r22 == 0) goto L_0x0218
            if (r0 == 0) goto L_0x002b
            androidx.lifecycle.y r8 = r0.getIrtSortOption()
            androidx.lifecycle.y r0 = r0.getSearchInput()
            goto L_0x002d
        L_0x002b:
            r0 = 0
            r8 = 0
        L_0x002d:
            r1.updateLiveDataRegistration(r11, r8)
            r1.updateLiveDataRegistration(r15, r0)
            if (r8 == 0) goto L_0x003c
            java.lang.Object r8 = r8.getValue()
            com.travel.flight.flightSRPV2.a.ae r8 = (com.travel.flight.flightSRPV2.a.ae) r8
            goto L_0x003d
        L_0x003c:
            r8 = 0
        L_0x003d:
            if (r0 == 0) goto L_0x0046
            java.lang.Object r0 = r0.getValue()
            com.travel.flight.pojo.flightticket.CJRFlightSearchInput r0 = (com.travel.flight.pojo.flightticket.CJRFlightSearchInput) r0
            goto L_0x0047
        L_0x0046:
            r0 = 0
        L_0x0047:
            if (r8 == 0) goto L_0x004e
            int r8 = r8.a()
            goto L_0x004f
        L_0x004e:
            r8 = 0
        L_0x004f:
            if (r0 == 0) goto L_0x005a
            com.travel.flight.pojo.flightticket.b r9 = r0.getDestination()
            com.travel.flight.pojo.flightticket.b r0 = r0.getSource()
            goto L_0x005c
        L_0x005a:
            r0 = 0
            r9 = 0
        L_0x005c:
            long r22 = r2 & r19
            int r24 = (r22 > r4 ? 1 : (r22 == r4 ? 0 : -1))
            if (r24 == 0) goto L_0x018c
            if (r8 != r6) goto L_0x0067
            r22 = 1
            goto L_0x0069
        L_0x0067:
            r22 = 0
        L_0x0069:
            if (r8 != r12) goto L_0x006e
            r23 = 1
            goto L_0x0070
        L_0x006e:
            r23 = 0
        L_0x0070:
            if (r8 != r15) goto L_0x0075
            r25 = 1
            goto L_0x0077
        L_0x0075:
            r25 = 0
        L_0x0077:
            if (r8 != r13) goto L_0x007c
            r26 = 1
            goto L_0x007e
        L_0x007c:
            r26 = 0
        L_0x007e:
            r11 = 2
            if (r8 != r11) goto L_0x0083
            r11 = 1
            goto L_0x0084
        L_0x0083:
            r11 = 0
        L_0x0084:
            if (r8 != r10) goto L_0x0089
            r28 = 1
            goto L_0x008b
        L_0x0089:
            r28 = 0
        L_0x008b:
            if (r8 != r14) goto L_0x0090
            r29 = 1
            goto L_0x0092
        L_0x0090:
            r29 = 0
        L_0x0092:
            r15 = 8
            if (r8 != r7) goto L_0x0099
            r30 = 1
            goto L_0x009b
        L_0x0099:
            r30 = 0
        L_0x009b:
            r12 = 6
            if (r8 != r15) goto L_0x00a0
            r15 = 1
            goto L_0x00a1
        L_0x00a0:
            r15 = 0
        L_0x00a1:
            if (r8 != r12) goto L_0x00a5
            r12 = 1
            goto L_0x00a6
        L_0x00a5:
            r12 = 0
        L_0x00a6:
            if (r24 == 0) goto L_0x00b3
            if (r22 == 0) goto L_0x00ae
            r31 = 8388608(0x800000, double:4.144523E-317)
            goto L_0x00b1
        L_0x00ae:
            r31 = 4194304(0x400000, double:2.0722615E-317)
        L_0x00b1:
            long r2 = r2 | r31
        L_0x00b3:
            long r31 = r2 & r19
            int r24 = (r31 > r4 ? 1 : (r31 == r4 ? 0 : -1))
            if (r24 == 0) goto L_0x00c2
            if (r23 == 0) goto L_0x00be
            r31 = 512(0x200, double:2.53E-321)
            goto L_0x00c0
        L_0x00be:
            r31 = 256(0x100, double:1.265E-321)
        L_0x00c0:
            long r2 = r2 | r31
        L_0x00c2:
            long r31 = r2 & r19
            int r24 = (r31 > r4 ? 1 : (r31 == r4 ? 0 : -1))
            if (r24 == 0) goto L_0x00d1
            if (r25 == 0) goto L_0x00cd
            r31 = 128(0x80, double:6.32E-322)
            goto L_0x00cf
        L_0x00cd:
            r31 = 64
        L_0x00cf:
            long r2 = r2 | r31
        L_0x00d1:
            long r31 = r2 & r19
            int r24 = (r31 > r4 ? 1 : (r31 == r4 ? 0 : -1))
            if (r24 == 0) goto L_0x00e2
            if (r26 == 0) goto L_0x00dd
            r31 = 2097152(0x200000, double:1.0361308E-317)
            goto L_0x00e0
        L_0x00dd:
            r31 = 1048576(0x100000, double:5.180654E-318)
        L_0x00e0:
            long r2 = r2 | r31
        L_0x00e2:
            long r31 = r2 & r19
            int r24 = (r31 > r4 ? 1 : (r31 == r4 ? 0 : -1))
            if (r24 == 0) goto L_0x00f1
            if (r11 == 0) goto L_0x00ed
            r31 = 2048(0x800, double:1.0118E-320)
            goto L_0x00ef
        L_0x00ed:
            r31 = 1024(0x400, double:5.06E-321)
        L_0x00ef:
            long r2 = r2 | r31
        L_0x00f1:
            long r31 = r2 & r19
            int r24 = (r31 > r4 ? 1 : (r31 == r4 ? 0 : -1))
            if (r24 == 0) goto L_0x0102
            if (r28 == 0) goto L_0x00fd
            r31 = 131072(0x20000, double:6.47582E-319)
            goto L_0x0100
        L_0x00fd:
            r31 = 65536(0x10000, double:3.2379E-319)
        L_0x0100:
            long r2 = r2 | r31
        L_0x0102:
            long r31 = r2 & r19
            int r24 = (r31 > r4 ? 1 : (r31 == r4 ? 0 : -1))
            if (r24 == 0) goto L_0x0113
            if (r29 == 0) goto L_0x010e
            r31 = 524288(0x80000, double:2.590327E-318)
            goto L_0x0111
        L_0x010e:
            r31 = 262144(0x40000, double:1.295163E-318)
        L_0x0111:
            long r2 = r2 | r31
        L_0x0113:
            long r31 = r2 & r19
            int r24 = (r31 > r4 ? 1 : (r31 == r4 ? 0 : -1))
            if (r24 == 0) goto L_0x0123
            if (r30 == 0) goto L_0x011f
            r31 = 32768(0x8000, double:1.61895E-319)
            goto L_0x0121
        L_0x011f:
            r31 = 16384(0x4000, double:8.0948E-320)
        L_0x0121:
            long r2 = r2 | r31
        L_0x0123:
            long r31 = r2 & r19
            int r24 = (r31 > r4 ? 1 : (r31 == r4 ? 0 : -1))
            if (r24 == 0) goto L_0x0132
            if (r15 == 0) goto L_0x012e
            r31 = 8192(0x2000, double:4.0474E-320)
            goto L_0x0130
        L_0x012e:
            r31 = 4096(0x1000, double:2.0237E-320)
        L_0x0130:
            long r2 = r2 | r31
        L_0x0132:
            long r31 = r2 & r19
            int r24 = (r31 > r4 ? 1 : (r31 == r4 ? 0 : -1))
            if (r24 == 0) goto L_0x0141
            if (r12 == 0) goto L_0x013d
            r31 = 32
            goto L_0x013f
        L_0x013d:
            r31 = 16
        L_0x013f:
            long r2 = r2 | r31
        L_0x0141:
            if (r22 == 0) goto L_0x0146
            r22 = 0
            goto L_0x0148
        L_0x0146:
            r22 = 8
        L_0x0148:
            if (r23 == 0) goto L_0x014d
            r23 = 0
            goto L_0x014f
        L_0x014d:
            r23 = 8
        L_0x014f:
            if (r25 == 0) goto L_0x0154
            r24 = 0
            goto L_0x0156
        L_0x0154:
            r24 = 8
        L_0x0156:
            if (r26 == 0) goto L_0x015b
            r25 = 0
            goto L_0x015d
        L_0x015b:
            r25 = 8
        L_0x015d:
            if (r11 == 0) goto L_0x0161
            r11 = 0
            goto L_0x0163
        L_0x0161:
            r11 = 8
        L_0x0163:
            if (r28 == 0) goto L_0x0168
            r26 = 0
            goto L_0x016a
        L_0x0168:
            r26 = 8
        L_0x016a:
            if (r29 == 0) goto L_0x016f
            r28 = 0
            goto L_0x0171
        L_0x016f:
            r28 = 8
        L_0x0171:
            if (r30 == 0) goto L_0x0176
            r29 = 0
            goto L_0x0178
        L_0x0176:
            r29 = 8
        L_0x0178:
            if (r15 == 0) goto L_0x017c
            r15 = 0
            goto L_0x017e
        L_0x017c:
            r15 = 8
        L_0x017e:
            if (r12 == 0) goto L_0x0183
            r27 = 0
            goto L_0x0185
        L_0x0183:
            r27 = 8
        L_0x0185:
            r12 = r27
            r27 = r11
            r11 = r23
            goto L_0x019d
        L_0x018c:
            r11 = 0
            r12 = 0
            r15 = 0
            r22 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
        L_0x019d:
            if (r9 == 0) goto L_0x01a4
            java.lang.String r23 = r9.getShortCityName()
            goto L_0x01a6
        L_0x01a4:
            r23 = 0
        L_0x01a6:
            if (r0 == 0) goto L_0x01af
            java.lang.String r30 = r0.getShortCityName()
            r17 = 14
            goto L_0x01b3
        L_0x01af:
            r17 = 14
            r30 = 0
        L_0x01b3:
            long r31 = r2 & r17
            int r33 = (r31 > r4 ? 1 : (r31 == r4 ? 0 : -1))
            if (r33 == 0) goto L_0x01ff
            if (r9 == 0) goto L_0x01c0
            java.lang.String r9 = r9.getCityName()
            goto L_0x01c1
        L_0x01c0:
            r9 = 0
        L_0x01c1:
            if (r0 == 0) goto L_0x01e4
            java.lang.String r0 = r0.getCityName()
            r42 = r0
            r41 = r9
            r38 = r11
            r34 = r12
            r37 = r15
            r15 = r22
            r9 = r23
            r39 = r24
            r36 = r25
            r11 = r26
            r40 = r27
            r35 = r28
            r12 = r29
            r0 = r30
            goto L_0x0230
        L_0x01e4:
            r41 = r9
            r38 = r11
            r34 = r12
            r37 = r15
            r15 = r22
            r9 = r23
            r39 = r24
            r36 = r25
            r11 = r26
            r40 = r27
            r35 = r28
            r12 = r29
            r0 = r30
            goto L_0x022e
        L_0x01ff:
            r38 = r11
            r34 = r12
            r37 = r15
            r15 = r22
            r9 = r23
            r39 = r24
            r36 = r25
            r11 = r26
            r40 = r27
            r35 = r28
            r12 = r29
            r0 = r30
            goto L_0x022c
        L_0x0218:
            r0 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            r12 = 0
            r15 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r40 = 0
        L_0x022c:
            r41 = 0
        L_0x022e:
            r42 = 0
        L_0x0230:
            r22 = 8
            long r22 = r2 & r22
            int r21 = (r22 > r4 ? 1 : (r22 == r4 ? 0 : -1))
            if (r21 == 0) goto L_0x0285
            android.widget.LinearLayout r13 = r1.f23573a
            android.view.View$OnClickListener r14 = r1.X
            r13.setOnClickListener(r14)
            android.widget.RelativeLayout r13 = r1.j
            android.view.View$OnClickListener r14 = r1.U
            r13.setOnClickListener(r14)
            android.widget.RelativeLayout r13 = r1.m
            android.view.View$OnClickListener r14 = r1.W
            r13.setOnClickListener(r14)
            android.widget.RelativeLayout r13 = r1.p
            android.view.View$OnClickListener r14 = r1.N
            r13.setOnClickListener(r14)
            android.widget.RelativeLayout r13 = r1.r
            android.view.View$OnClickListener r14 = r1.O
            r13.setOnClickListener(r14)
            android.widget.RelativeLayout r13 = r1.u
            android.view.View$OnClickListener r14 = r1.Q
            r13.setOnClickListener(r14)
            android.widget.RelativeLayout r13 = r1.x
            android.view.View$OnClickListener r14 = r1.T
            r13.setOnClickListener(r14)
            android.widget.RelativeLayout r13 = r1.A
            android.view.View$OnClickListener r14 = r1.P
            r13.setOnClickListener(r14)
            android.widget.RelativeLayout r13 = r1.E
            android.view.View$OnClickListener r14 = r1.S
            r13.setOnClickListener(r14)
            android.widget.RelativeLayout r13 = r1.I
            android.view.View$OnClickListener r14 = r1.R
            r13.setOnClickListener(r14)
            android.widget.RelativeLayout r13 = r1.M
            android.view.View$OnClickListener r14 = r1.V
            r13.setOnClickListener(r14)
        L_0x0285:
            r13 = 15
            long r13 = r13 & r2
            int r16 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x030c
            android.widget.TextView r13 = r1.f23580h
            android.content.res.Resources r14 = r13.getResources()
            int r4 = com.travel.flight.R.string.early_take_off
            java.lang.String r4 = r14.getString(r4)
            com.travel.flight.flightSRPV2.c.c.a(r13, r10, r8, r0, r4)
            android.widget.TextView r4 = r1.k
            android.content.res.Resources r5 = r4.getResources()
            int r10 = com.travel.flight.R.string.landing_early
            java.lang.String r5 = r5.getString(r10)
            com.travel.flight.flightSRPV2.c.c.a(r4, r7, r8, r9, r5)
            android.widget.TextView r4 = r1.n
            android.content.res.Resources r5 = r4.getResources()
            int r7 = com.travel.flight.R.string.late_take_off
            java.lang.String r5 = r5.getString(r7)
            com.travel.flight.flightSRPV2.c.c.a(r4, r6, r8, r0, r5)
            android.widget.TextView r4 = r1.q
            android.content.res.Resources r5 = r4.getResources()
            int r6 = com.travel.flight.R.string.landing_late
            java.lang.String r5 = r5.getString(r6)
            r6 = 6
            com.travel.flight.flightSRPV2.c.c.a(r4, r6, r8, r9, r5)
            android.widget.TextView r4 = r1.v
            android.content.res.Resources r5 = r4.getResources()
            int r6 = com.travel.flight.R.string.early_take_off
            java.lang.String r5 = r5.getString(r6)
            r6 = 7
            com.travel.flight.flightSRPV2.c.c.a(r4, r6, r8, r9, r5)
            android.widget.TextView r4 = r1.y
            android.content.res.Resources r5 = r4.getResources()
            int r6 = com.travel.flight.R.string.landing_early
            java.lang.String r5 = r5.getString(r6)
            r6 = 9
            com.travel.flight.flightSRPV2.c.c.a(r4, r6, r8, r0, r5)
            android.widget.TextView r4 = r1.B
            android.content.res.Resources r5 = r4.getResources()
            int r6 = com.travel.flight.R.string.late_take_off
            java.lang.String r5 = r5.getString(r6)
            r6 = 8
            com.travel.flight.flightSRPV2.c.c.a(r4, r6, r8, r9, r5)
            android.widget.TextView r4 = r1.F
            android.content.res.Resources r5 = r4.getResources()
            int r6 = com.travel.flight.R.string.landing_late
            java.lang.String r5 = r5.getString(r6)
            r6 = 10
            com.travel.flight.flightSRPV2.c.c.a(r4, r6, r8, r0, r5)
        L_0x030c:
            long r4 = r2 & r19
            r6 = 0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x0360
            android.widget.ImageView r0 = r1.f23581i
            r0.setVisibility(r11)
            android.widget.ImageView r0 = r1.l
            r0.setVisibility(r12)
            android.widget.ImageView r0 = r1.o
            r0.setVisibility(r15)
            android.widget.ImageView r0 = r1.s
            r12 = r34
            r0.setVisibility(r12)
            android.widget.ImageView r0 = r1.w
            r4 = r35
            r0.setVisibility(r4)
            android.widget.ImageView r0 = r1.z
            r4 = r36
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.C
            r4 = 1
            com.travel.flight.flightSRPV2.c.c.a((android.widget.TextView) r0, (int) r4, (int) r8)
            android.widget.ImageView r0 = r1.D
            r15 = r37
            r0.setVisibility(r15)
            android.widget.ImageView r0 = r1.G
            r11 = r38
            r0.setVisibility(r11)
            android.widget.ImageView r0 = r1.H
            r4 = r39
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.J
            r4 = 2
            com.travel.flight.flightSRPV2.c.c.a((android.widget.TextView) r0, (int) r4, (int) r8)
            android.widget.ImageView r0 = r1.K
            r4 = r40
            r0.setVisibility(r4)
        L_0x0360:
            r4 = 14
            long r2 = r2 & r4
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0377
            android.widget.TextView r0 = r1.t
            r9 = r41
            r2 = r42
            com.travel.flight.flightSRPV2.c.c.a((android.widget.TextView) r0, (java.lang.String) r9, (java.lang.String) r2)
            android.widget.TextView r0 = r1.L
            com.travel.flight.flightSRPV2.c.c.a((android.widget.TextView) r0, (java.lang.String) r2, (java.lang.String) r9)
        L_0x0377:
            return
        L_0x0378:
            r0 = move-exception
            monitor-exit(r43)     // Catch:{ all -> 0x0378 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.b.ah.executeBindings():void");
    }

    public final void a(int i2, View view) {
        boolean z2 = false;
        boolean z3 = true;
        switch (i2) {
            case 1:
                SRPSharedViewModel sRPSharedViewModel = this.f23577e;
                if (sRPSharedViewModel != null) {
                    z2 = true;
                }
                if (z2) {
                    sRPSharedViewModel.onBackPressed();
                    return;
                }
                return;
            case 2:
                SRPSharedViewModel sRPSharedViewModel2 = this.f23577e;
                if (sRPSharedViewModel2 != null) {
                    z2 = true;
                }
                if (z2) {
                    sRPSharedViewModel2.onIRTSortOptionSelected(1, true);
                    return;
                }
                return;
            case 3:
                SRPSharedViewModel sRPSharedViewModel3 = this.f23577e;
                if (sRPSharedViewModel3 != null) {
                    z2 = true;
                }
                if (z2) {
                    sRPSharedViewModel3.onIRTSortOptionSelected(2, true);
                    return;
                }
                return;
            case 4:
                SRPSharedViewModel sRPSharedViewModel4 = this.f23577e;
                if (sRPSharedViewModel4 != null) {
                    z2 = true;
                }
                if (z2) {
                    sRPSharedViewModel4.onIRTSortOptionSelected(3, true);
                    return;
                }
                return;
            case 5:
                SRPSharedViewModel sRPSharedViewModel5 = this.f23577e;
                if (sRPSharedViewModel5 != null) {
                    z2 = true;
                }
                if (z2) {
                    sRPSharedViewModel5.onIRTSortOptionSelected(5, true);
                    return;
                }
                return;
            case 6:
                SRPSharedViewModel sRPSharedViewModel6 = this.f23577e;
                if (sRPSharedViewModel6 != null) {
                    z2 = true;
                }
                if (z2) {
                    sRPSharedViewModel6.onIRTSortOptionSelected(4, true);
                    return;
                }
                return;
            case 7:
                SRPSharedViewModel sRPSharedViewModel7 = this.f23577e;
                if (sRPSharedViewModel7 != null) {
                    z2 = true;
                }
                if (z2) {
                    sRPSharedViewModel7.onIRTSortOptionSelected(6, true);
                    return;
                }
                return;
            case 8:
                SRPSharedViewModel sRPSharedViewModel8 = this.f23577e;
                if (sRPSharedViewModel8 == null) {
                    z3 = false;
                }
                if (z3) {
                    sRPSharedViewModel8.onIRTSortOptionSelected(7, false);
                    return;
                }
                return;
            case 9:
                SRPSharedViewModel sRPSharedViewModel9 = this.f23577e;
                if (sRPSharedViewModel9 == null) {
                    z3 = false;
                }
                if (z3) {
                    sRPSharedViewModel9.onIRTSortOptionSelected(9, false);
                    return;
                }
                return;
            case 10:
                SRPSharedViewModel sRPSharedViewModel10 = this.f23577e;
                if (sRPSharedViewModel10 == null) {
                    z3 = false;
                }
                if (z3) {
                    sRPSharedViewModel10.onIRTSortOptionSelected(8, false);
                    return;
                }
                return;
            case 11:
                SRPSharedViewModel sRPSharedViewModel11 = this.f23577e;
                if (sRPSharedViewModel11 == null) {
                    z3 = false;
                }
                if (z3) {
                    sRPSharedViewModel11.onIRTSortOptionSelected(10, false);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
