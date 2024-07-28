package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.travel.flight.R;
import com.travel.flight.e.a.a;
import com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel;

public final class ab extends aa implements a.C0456a {

    /* renamed from: h  reason: collision with root package name */
    private static final ViewDataBinding.b f23552h = null;

    /* renamed from: i  reason: collision with root package name */
    private static final SparseIntArray f23553i;
    private final ImageView A;
    private final RelativeLayout B;
    private final RelativeLayout C;
    private final TextView D;
    private final ImageView E;
    private final RelativeLayout F;
    private final TextView G;
    private final ImageView H;
    private final RelativeLayout I;
    private final TextView J;
    private final ImageView K;
    private final RelativeLayout L;
    private final TextView M;
    private final TextView N;
    private final ImageView O;
    private final ImageView P;
    private final RelativeLayout Q;
    private final TextView R;
    private final ImageView S;
    private final RelativeLayout T;
    private final View.OnClickListener U;
    private final View.OnClickListener V;
    private final View.OnClickListener W;
    private final View.OnClickListener X;
    private final View.OnClickListener Y;
    private final View.OnClickListener Z;
    private final View.OnClickListener aa;
    private final View.OnClickListener ab;
    private final View.OnClickListener ac;
    private final View.OnClickListener ad;
    private final View.OnClickListener ae;
    private final View.OnClickListener af;
    private final View.OnClickListener ag;
    private long ah;
    private final TextView j;
    private final ImageView k;
    private final RelativeLayout l;
    private final TextView m;
    private final ImageView n;
    private final RelativeLayout o;
    private final TextView p;
    private final ImageView q;
    private final RelativeLayout r;
    private final TextView s;
    private final ImageView t;
    private final LinearLayout u;
    private final RelativeLayout v;
    private final TextView w;
    private final ImageView x;
    private final RelativeLayout y;
    private final TextView z;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f23553i = sparseIntArray;
        sparseIntArray.put(R.id.sort_lyt, 41);
        f23553i.put(R.id.transparent_padding, 42);
    }

    public ab(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 43, f23552h, f23553i));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private ab(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[2], objArr[22], objArr[1], objArr[0], objArr[41], objArr[42]);
        this.ah = -1;
        this.f23545a.setTag((Object) null);
        this.f23546b.setTag((Object) null);
        this.f23547c.setTag((Object) null);
        this.f23548d.setTag((Object) null);
        this.j = objArr[10];
        this.j.setTag((Object) null);
        this.k = objArr[11];
        this.k.setTag((Object) null);
        this.l = objArr[12];
        this.l.setTag((Object) null);
        this.m = objArr[13];
        this.m.setTag((Object) null);
        this.n = objArr[14];
        this.n.setTag((Object) null);
        this.o = objArr[15];
        this.o.setTag((Object) null);
        this.p = objArr[16];
        this.p.setTag((Object) null);
        this.q = objArr[17];
        this.q.setTag((Object) null);
        this.r = objArr[18];
        this.r.setTag((Object) null);
        this.s = objArr[19];
        this.s.setTag((Object) null);
        this.t = objArr[20];
        this.t.setTag((Object) null);
        this.u = objArr[21];
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
        this.H = objArr[34];
        this.H.setTag((Object) null);
        this.I = objArr[35];
        this.I.setTag((Object) null);
        this.J = objArr[36];
        this.J.setTag((Object) null);
        this.K = objArr[37];
        this.K.setTag((Object) null);
        this.L = objArr[38];
        this.L.setTag((Object) null);
        this.M = objArr[39];
        this.M.setTag((Object) null);
        this.N = objArr[4];
        this.N.setTag((Object) null);
        this.O = objArr[40];
        this.O.setTag((Object) null);
        this.P = objArr[5];
        this.P.setTag((Object) null);
        this.Q = objArr[6];
        this.Q.setTag((Object) null);
        this.R = objArr[7];
        this.R.setTag((Object) null);
        this.S = objArr[8];
        this.S.setTag((Object) null);
        this.T = objArr[9];
        this.T.setTag((Object) null);
        setRootTag(view);
        this.U = new a(this, 2);
        this.V = new a(this, 10);
        this.W = new a(this, 9);
        this.X = new a(this, 5);
        this.Y = new a(this, 13);
        this.Z = new a(this, 11);
        this.aa = new a(this, 6);
        this.ab = new a(this, 12);
        this.ac = new a(this, 7);
        this.ad = new a(this, 3);
        this.ae = new a(this, 1);
        this.af = new a(this, 8);
        this.ag = new a(this, 4);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.ah = 16;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.ah != 0) {
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
        this.f23551g = sRPSharedViewModel;
        synchronized (this) {
            this.ah |= 8;
        }
        notifyPropertyChanged(com.travel.flight.a.j);
        super.requestRebind();
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return a(i3);
        }
        if (i2 == 1) {
            return b(i3);
        }
        if (i2 != 2) {
            return false;
        }
        return c(i3);
    }

    private boolean a(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.ah |= 1;
        }
        return true;
    }

    private boolean b(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.ah |= 2;
        }
        return true;
    }

    private boolean c(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.ah |= 4;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:175:0x01d5  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x01ea  */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x0208  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x0212  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0101  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r50 = this;
            r1 = r50
            monitor-enter(r50)
            long r2 = r1.ah     // Catch:{ all -> 0x039d }
            r4 = 0
            r1.ah = r4     // Catch:{ all -> 0x039d }
            monitor-exit(r50)     // Catch:{ all -> 0x039d }
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r0 = r1.f23551g
            r6 = 31
            long r6 = r6 & r2
            r12 = 6
            r13 = 5
            r14 = 4
            r15 = 3
            r10 = 2
            r18 = 26
            r20 = 25
            r11 = 1
            r8 = 0
            int r9 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r9 == 0) goto L_0x0262
            long r6 = r2 & r20
            int r24 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r24 == 0) goto L_0x00ef
            if (r0 == 0) goto L_0x002b
            androidx.lifecycle.y r6 = r0.getRoundTripOnwardSortOption()
            goto L_0x002c
        L_0x002b:
            r6 = 0
        L_0x002c:
            r1.updateLiveDataRegistration(r8, r6)
            if (r6 == 0) goto L_0x0038
            java.lang.Object r6 = r6.getValue()
            com.travel.flight.flightSRPV2.a.ae r6 = (com.travel.flight.flightSRPV2.a.ae) r6
            goto L_0x0039
        L_0x0038:
            r6 = 0
        L_0x0039:
            if (r6 == 0) goto L_0x0040
            int r6 = r6.a()
            goto L_0x0041
        L_0x0040:
            r6 = 0
        L_0x0041:
            if (r6 != r10) goto L_0x0045
            r7 = 1
            goto L_0x0046
        L_0x0045:
            r7 = 0
        L_0x0046:
            if (r6 != r11) goto L_0x004b
            r25 = 1
            goto L_0x004d
        L_0x004b:
            r25 = 0
        L_0x004d:
            if (r6 != r15) goto L_0x0052
            r26 = 1
            goto L_0x0054
        L_0x0052:
            r26 = 0
        L_0x0054:
            if (r6 != r14) goto L_0x0059
            r27 = 1
            goto L_0x005b
        L_0x0059:
            r27 = 0
        L_0x005b:
            if (r6 != r12) goto L_0x0060
            r28 = 1
            goto L_0x0062
        L_0x0060:
            r28 = 0
        L_0x0062:
            if (r6 != r13) goto L_0x0067
            r29 = 1
            goto L_0x0069
        L_0x0067:
            r29 = 0
        L_0x0069:
            if (r24 == 0) goto L_0x0076
            if (r7 == 0) goto L_0x0071
            r30 = 1048576(0x100000, double:5.180654E-318)
            goto L_0x0074
        L_0x0071:
            r30 = 524288(0x80000, double:2.590327E-318)
        L_0x0074:
            long r2 = r2 | r30
        L_0x0076:
            long r30 = r2 & r20
            int r24 = (r30 > r4 ? 1 : (r30 == r4 ? 0 : -1))
            if (r24 == 0) goto L_0x0085
            if (r25 == 0) goto L_0x0081
            r30 = 256(0x100, double:1.265E-321)
            goto L_0x0083
        L_0x0081:
            r30 = 128(0x80, double:6.32E-322)
        L_0x0083:
            long r2 = r2 | r30
        L_0x0085:
            long r30 = r2 & r20
            int r24 = (r30 > r4 ? 1 : (r30 == r4 ? 0 : -1))
            if (r24 == 0) goto L_0x0094
            if (r26 == 0) goto L_0x0090
            r30 = 64
            goto L_0x0092
        L_0x0090:
            r30 = 32
        L_0x0092:
            long r2 = r2 | r30
        L_0x0094:
            long r30 = r2 & r20
            int r24 = (r30 > r4 ? 1 : (r30 == r4 ? 0 : -1))
            if (r24 == 0) goto L_0x00a5
            if (r27 == 0) goto L_0x00a0
            r30 = 67108864(0x4000000, double:3.31561842E-316)
            goto L_0x00a3
        L_0x00a0:
            r30 = 33554432(0x2000000, double:1.6578092E-316)
        L_0x00a3:
            long r2 = r2 | r30
        L_0x00a5:
            long r30 = r2 & r20
            int r24 = (r30 > r4 ? 1 : (r30 == r4 ? 0 : -1))
            if (r24 == 0) goto L_0x00b6
            if (r28 == 0) goto L_0x00b1
            r30 = 1073741824(0x40000000, double:5.304989477E-315)
            goto L_0x00b4
        L_0x00b1:
            r30 = 536870912(0x20000000, double:2.652494739E-315)
        L_0x00b4:
            long r2 = r2 | r30
        L_0x00b6:
            long r30 = r2 & r20
            int r24 = (r30 > r4 ? 1 : (r30 == r4 ? 0 : -1))
            if (r24 == 0) goto L_0x00c7
            if (r29 == 0) goto L_0x00c2
            r30 = 4194304(0x400000, double:2.0722615E-317)
            goto L_0x00c5
        L_0x00c2:
            r30 = 2097152(0x200000, double:1.0361308E-317)
        L_0x00c5:
            long r2 = r2 | r30
        L_0x00c7:
            if (r7 == 0) goto L_0x00cb
            r7 = 0
            goto L_0x00cd
        L_0x00cb:
            r7 = 8
        L_0x00cd:
            if (r25 == 0) goto L_0x00d2
            r24 = 0
            goto L_0x00d4
        L_0x00d2:
            r24 = 8
        L_0x00d4:
            if (r26 == 0) goto L_0x00d9
            r25 = 0
            goto L_0x00db
        L_0x00d9:
            r25 = 8
        L_0x00db:
            if (r27 == 0) goto L_0x00e0
            r26 = 0
            goto L_0x00e2
        L_0x00e0:
            r26 = 8
        L_0x00e2:
            if (r28 == 0) goto L_0x00e7
            r27 = 0
            goto L_0x00e9
        L_0x00e7:
            r27 = 8
        L_0x00e9:
            if (r29 == 0) goto L_0x00ec
            goto L_0x00f9
        L_0x00ec:
            r28 = 8
            goto L_0x00fb
        L_0x00ef:
            r6 = 0
            r7 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
        L_0x00f9:
            r28 = 0
        L_0x00fb:
            long r29 = r2 & r18
            int r31 = (r29 > r4 ? 1 : (r29 == r4 ? 0 : -1))
            if (r31 == 0) goto L_0x01d5
            if (r0 == 0) goto L_0x010a
            androidx.lifecycle.y r29 = r0.getRoundTripReturnSortOption()
            r9 = r29
            goto L_0x010b
        L_0x010a:
            r9 = 0
        L_0x010b:
            r1.updateLiveDataRegistration(r11, r9)
            if (r9 == 0) goto L_0x0117
            java.lang.Object r9 = r9.getValue()
            com.travel.flight.flightSRPV2.a.ae r9 = (com.travel.flight.flightSRPV2.a.ae) r9
            goto L_0x0118
        L_0x0117:
            r9 = 0
        L_0x0118:
            if (r9 == 0) goto L_0x011f
            int r9 = r9.a()
            goto L_0x0120
        L_0x011f:
            r9 = 0
        L_0x0120:
            if (r9 != r12) goto L_0x0125
            r30 = 1
            goto L_0x0127
        L_0x0125:
            r30 = 0
        L_0x0127:
            if (r9 != r14) goto L_0x012c
            r32 = 1
            goto L_0x012e
        L_0x012c:
            r32 = 0
        L_0x012e:
            if (r9 != r15) goto L_0x0133
            r33 = 1
            goto L_0x0135
        L_0x0133:
            r33 = 0
        L_0x0135:
            if (r9 != r10) goto L_0x013a
            r34 = 1
            goto L_0x013c
        L_0x013a:
            r34 = 0
        L_0x013c:
            if (r9 != r11) goto L_0x0141
            r35 = 1
            goto L_0x0143
        L_0x0141:
            r35 = 0
        L_0x0143:
            if (r9 != r13) goto L_0x0148
            r36 = 1
            goto L_0x014a
        L_0x0148:
            r36 = 0
        L_0x014a:
            if (r31 == 0) goto L_0x0157
            if (r30 == 0) goto L_0x0152
            r37 = 65536(0x10000, double:3.2379E-319)
            goto L_0x0155
        L_0x0152:
            r37 = 32768(0x8000, double:1.61895E-319)
        L_0x0155:
            long r2 = r2 | r37
        L_0x0157:
            long r37 = r2 & r18
            int r31 = (r37 > r4 ? 1 : (r37 == r4 ? 0 : -1))
            if (r31 == 0) goto L_0x0168
            if (r32 == 0) goto L_0x0163
            r37 = 16777216(0x1000000, double:8.289046E-317)
            goto L_0x0166
        L_0x0163:
            r37 = 8388608(0x800000, double:4.144523E-317)
        L_0x0166:
            long r2 = r2 | r37
        L_0x0168:
            long r37 = r2 & r18
            int r31 = (r37 > r4 ? 1 : (r37 == r4 ? 0 : -1))
            if (r31 == 0) goto L_0x0179
            if (r33 == 0) goto L_0x0174
            r37 = 268435456(0x10000000, double:1.32624737E-315)
            goto L_0x0177
        L_0x0174:
            r37 = 134217728(0x8000000, double:6.63123685E-316)
        L_0x0177:
            long r2 = r2 | r37
        L_0x0179:
            long r37 = r2 & r18
            int r31 = (r37 > r4 ? 1 : (r37 == r4 ? 0 : -1))
            if (r31 == 0) goto L_0x018a
            if (r34 == 0) goto L_0x0185
            r37 = 262144(0x40000, double:1.295163E-318)
            goto L_0x0188
        L_0x0185:
            r37 = 131072(0x20000, double:6.47582E-319)
        L_0x0188:
            long r2 = r2 | r37
        L_0x018a:
            long r37 = r2 & r18
            int r31 = (r37 > r4 ? 1 : (r37 == r4 ? 0 : -1))
            if (r31 == 0) goto L_0x0199
            if (r35 == 0) goto L_0x0195
            r37 = 16384(0x4000, double:8.0948E-320)
            goto L_0x0197
        L_0x0195:
            r37 = 8192(0x2000, double:4.0474E-320)
        L_0x0197:
            long r2 = r2 | r37
        L_0x0199:
            long r37 = r2 & r18
            int r31 = (r37 > r4 ? 1 : (r37 == r4 ? 0 : -1))
            if (r31 == 0) goto L_0x01a8
            if (r36 == 0) goto L_0x01a4
            r37 = 4096(0x1000, double:2.0237E-320)
            goto L_0x01a6
        L_0x01a4:
            r37 = 2048(0x800, double:1.0118E-320)
        L_0x01a6:
            long r2 = r2 | r37
        L_0x01a8:
            if (r30 == 0) goto L_0x01ad
            r30 = 0
            goto L_0x01af
        L_0x01ad:
            r30 = 8
        L_0x01af:
            if (r32 == 0) goto L_0x01b4
            r31 = 0
            goto L_0x01b6
        L_0x01b4:
            r31 = 8
        L_0x01b6:
            if (r33 == 0) goto L_0x01bb
            r32 = 0
            goto L_0x01bd
        L_0x01bb:
            r32 = 8
        L_0x01bd:
            if (r34 == 0) goto L_0x01c2
            r33 = 0
            goto L_0x01c4
        L_0x01c2:
            r33 = 8
        L_0x01c4:
            if (r35 == 0) goto L_0x01c9
            r34 = 0
            goto L_0x01cb
        L_0x01c9:
            r34 = 8
        L_0x01cb:
            if (r36 == 0) goto L_0x01d0
            r35 = 0
            goto L_0x01d2
        L_0x01d0:
            r35 = 8
        L_0x01d2:
            r22 = 24
            goto L_0x01e4
        L_0x01d5:
            r9 = 0
            r22 = 24
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
        L_0x01e4:
            long r36 = r2 & r22
            int r38 = (r36 > r4 ? 1 : (r36 == r4 ? 0 : -1))
            if (r38 == 0) goto L_0x0208
            if (r0 == 0) goto L_0x01f1
            boolean r36 = r0.isRoundTrip()
            goto L_0x01f3
        L_0x01f1:
            r36 = 0
        L_0x01f3:
            if (r38 == 0) goto L_0x01fe
            if (r36 == 0) goto L_0x01fa
            r37 = 1024(0x400, double:5.06E-321)
            goto L_0x01fc
        L_0x01fa:
            r37 = 512(0x200, double:2.53E-321)
        L_0x01fc:
            long r2 = r2 | r37
        L_0x01fe:
            if (r36 == 0) goto L_0x0203
            r29 = 0
            goto L_0x0205
        L_0x0203:
            r29 = 8
        L_0x0205:
            r16 = 28
            goto L_0x020c
        L_0x0208:
            r16 = 28
            r29 = 0
        L_0x020c:
            long r36 = r2 & r16
            int r38 = (r36 > r4 ? 1 : (r36 == r4 ? 0 : -1))
            if (r38 == 0) goto L_0x0242
            if (r0 == 0) goto L_0x0219
            androidx.lifecycle.y r0 = r0.getSearchInput()
            goto L_0x021a
        L_0x0219:
            r0 = 0
        L_0x021a:
            r1.updateLiveDataRegistration(r10, r0)
            if (r0 == 0) goto L_0x0242
            java.lang.Object r0 = r0.getValue()
            com.travel.flight.pojo.flightticket.CJRFlightSearchInput r0 = (com.travel.flight.pojo.flightticket.CJRFlightSearchInput) r0
            r41 = r7
            r43 = r9
            r40 = r24
            r7 = r25
            r9 = r26
            r39 = r27
            r10 = r28
            r42 = r29
            r49 = r30
            r47 = r31
            r46 = r32
            r45 = r33
            r44 = r34
            r48 = r35
            goto L_0x025f
        L_0x0242:
            r41 = r7
            r43 = r9
            r40 = r24
            r7 = r25
            r9 = r26
            r39 = r27
            r10 = r28
            r42 = r29
            r49 = r30
            r47 = r31
            r46 = r32
            r45 = r33
            r44 = r34
            r48 = r35
            r0 = 0
        L_0x025f:
            r24 = 28
            goto L_0x027f
        L_0x0262:
            r0 = 0
            r6 = 0
            r7 = 0
            r9 = 0
            r10 = 0
            r24 = 28
            r39 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r44 = 0
            r45 = 0
            r46 = 0
            r47 = 0
            r48 = 0
            r49 = 0
        L_0x027f:
            long r24 = r2 & r24
            int r17 = (r24 > r4 ? 1 : (r24 == r4 ? 0 : -1))
            if (r17 == 0) goto L_0x028f
            android.widget.TextView r12 = r1.f23545a
            com.travel.flight.flightSRPV2.c.c.a((android.widget.TextView) r12, (com.travel.flight.pojo.flightticket.CJRFlightSearchInput) r0, (boolean) r11, (boolean) r11)
            android.widget.TextView r12 = r1.f23546b
            com.travel.flight.flightSRPV2.c.c.a((android.widget.TextView) r12, (com.travel.flight.pojo.flightticket.CJRFlightSearchInput) r0, (boolean) r8, (boolean) r11)
        L_0x028f:
            r24 = 16
            long r24 = r2 & r24
            int r0 = (r24 > r4 ? 1 : (r24 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x02f2
            android.widget.LinearLayout r0 = r1.f23547c
            android.view.View$OnClickListener r8 = r1.ae
            r0.setOnClickListener(r8)
            android.widget.RelativeLayout r0 = r1.l
            android.view.View$OnClickListener r8 = r1.X
            r0.setOnClickListener(r8)
            android.widget.RelativeLayout r0 = r1.o
            android.view.View$OnClickListener r8 = r1.aa
            r0.setOnClickListener(r8)
            android.widget.RelativeLayout r0 = r1.r
            android.view.View$OnClickListener r8 = r1.ac
            r0.setOnClickListener(r8)
            android.widget.RelativeLayout r0 = r1.v
            android.view.View$OnClickListener r8 = r1.af
            r0.setOnClickListener(r8)
            android.widget.RelativeLayout r0 = r1.y
            android.view.View$OnClickListener r8 = r1.W
            r0.setOnClickListener(r8)
            android.widget.RelativeLayout r0 = r1.B
            android.view.View$OnClickListener r8 = r1.V
            r0.setOnClickListener(r8)
            android.widget.RelativeLayout r0 = r1.C
            android.view.View$OnClickListener r8 = r1.U
            r0.setOnClickListener(r8)
            android.widget.RelativeLayout r0 = r1.F
            android.view.View$OnClickListener r8 = r1.Z
            r0.setOnClickListener(r8)
            android.widget.RelativeLayout r0 = r1.I
            android.view.View$OnClickListener r8 = r1.ab
            r0.setOnClickListener(r8)
            android.widget.RelativeLayout r0 = r1.L
            android.view.View$OnClickListener r8 = r1.Y
            r0.setOnClickListener(r8)
            android.widget.RelativeLayout r0 = r1.Q
            android.view.View$OnClickListener r8 = r1.ad
            r0.setOnClickListener(r8)
            android.widget.RelativeLayout r0 = r1.T
            android.view.View$OnClickListener r8 = r1.ag
            r0.setOnClickListener(r8)
        L_0x02f2:
            long r20 = r2 & r20
            int r0 = (r20 > r4 ? 1 : (r20 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x033c
            android.widget.TextView r0 = r1.j
            com.travel.flight.flightSRPV2.c.c.a((android.widget.TextView) r0, (int) r15, (int) r6)
            android.widget.ImageView r0 = r1.k
            r0.setVisibility(r7)
            android.widget.TextView r0 = r1.m
            com.travel.flight.flightSRPV2.c.c.a((android.widget.TextView) r0, (int) r14, (int) r6)
            android.widget.ImageView r0 = r1.n
            r0.setVisibility(r9)
            android.widget.TextView r0 = r1.p
            com.travel.flight.flightSRPV2.c.c.a((android.widget.TextView) r0, (int) r13, (int) r6)
            android.widget.ImageView r0 = r1.q
            r0.setVisibility(r10)
            android.widget.TextView r0 = r1.s
            r7 = 6
            com.travel.flight.flightSRPV2.c.c.a((android.widget.TextView) r0, (int) r7, (int) r6)
            android.widget.ImageView r0 = r1.t
            r8 = r39
            r0.setVisibility(r8)
            android.widget.TextView r0 = r1.N
            com.travel.flight.flightSRPV2.c.c.a((android.widget.TextView) r0, (int) r11, (int) r6)
            android.widget.ImageView r0 = r1.P
            r8 = r40
            r0.setVisibility(r8)
            android.widget.TextView r0 = r1.R
            r7 = 2
            com.travel.flight.flightSRPV2.c.c.a((android.widget.TextView) r0, (int) r7, (int) r6)
            android.widget.ImageView r0 = r1.S
            r7 = r41
            r0.setVisibility(r7)
        L_0x033c:
            r6 = 24
            long r6 = r6 & r2
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x034a
            android.widget.LinearLayout r0 = r1.u
            r8 = r42
            r0.setVisibility(r8)
        L_0x034a:
            long r2 = r2 & r18
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x039c
            android.widget.TextView r0 = r1.w
            r9 = r43
            com.travel.flight.flightSRPV2.c.c.a((android.widget.TextView) r0, (int) r11, (int) r9)
            android.widget.ImageView r0 = r1.x
            r8 = r44
            r0.setVisibility(r8)
            android.widget.TextView r0 = r1.z
            r2 = 2
            com.travel.flight.flightSRPV2.c.c.a((android.widget.TextView) r0, (int) r2, (int) r9)
            android.widget.ImageView r0 = r1.A
            r8 = r45
            r0.setVisibility(r8)
            android.widget.TextView r0 = r1.D
            com.travel.flight.flightSRPV2.c.c.a((android.widget.TextView) r0, (int) r15, (int) r9)
            android.widget.ImageView r0 = r1.E
            r8 = r46
            r0.setVisibility(r8)
            android.widget.TextView r0 = r1.G
            com.travel.flight.flightSRPV2.c.c.a((android.widget.TextView) r0, (int) r14, (int) r9)
            android.widget.ImageView r0 = r1.H
            r8 = r47
            r0.setVisibility(r8)
            android.widget.TextView r0 = r1.J
            com.travel.flight.flightSRPV2.c.c.a((android.widget.TextView) r0, (int) r13, (int) r9)
            android.widget.ImageView r0 = r1.K
            r8 = r48
            r0.setVisibility(r8)
            android.widget.TextView r0 = r1.M
            r2 = 6
            com.travel.flight.flightSRPV2.c.c.a((android.widget.TextView) r0, (int) r2, (int) r9)
            android.widget.ImageView r0 = r1.O
            r8 = r49
            r0.setVisibility(r8)
        L_0x039c:
            return
        L_0x039d:
            r0 = move-exception
            monitor-exit(r50)     // Catch:{ all -> 0x039d }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.b.ab.executeBindings():void");
    }

    public final void a(int i2, View view) {
        boolean z2 = false;
        boolean z3 = true;
        switch (i2) {
            case 1:
                SRPSharedViewModel sRPSharedViewModel = this.f23551g;
                if (sRPSharedViewModel != null) {
                    z2 = true;
                }
                if (z2) {
                    sRPSharedViewModel.onBackPressed();
                    return;
                }
                return;
            case 2:
                SRPSharedViewModel sRPSharedViewModel2 = this.f23551g;
                if (sRPSharedViewModel2 != null) {
                    z2 = true;
                }
                if (z2) {
                    sRPSharedViewModel2.onRoundTripSortOptionSelected(1, true);
                    return;
                }
                return;
            case 3:
                SRPSharedViewModel sRPSharedViewModel3 = this.f23551g;
                if (sRPSharedViewModel3 != null) {
                    z2 = true;
                }
                if (z2) {
                    sRPSharedViewModel3.onRoundTripSortOptionSelected(2, true);
                    return;
                }
                return;
            case 4:
                SRPSharedViewModel sRPSharedViewModel4 = this.f23551g;
                if (sRPSharedViewModel4 != null) {
                    z2 = true;
                }
                if (z2) {
                    sRPSharedViewModel4.onRoundTripSortOptionSelected(3, true);
                    return;
                }
                return;
            case 5:
                SRPSharedViewModel sRPSharedViewModel5 = this.f23551g;
                if (sRPSharedViewModel5 != null) {
                    z2 = true;
                }
                if (z2) {
                    sRPSharedViewModel5.onRoundTripSortOptionSelected(4, true);
                    return;
                }
                return;
            case 6:
                SRPSharedViewModel sRPSharedViewModel6 = this.f23551g;
                if (sRPSharedViewModel6 != null) {
                    z2 = true;
                }
                if (z2) {
                    sRPSharedViewModel6.onRoundTripSortOptionSelected(5, true);
                    return;
                }
                return;
            case 7:
                SRPSharedViewModel sRPSharedViewModel7 = this.f23551g;
                if (sRPSharedViewModel7 != null) {
                    z2 = true;
                }
                if (z2) {
                    sRPSharedViewModel7.onRoundTripSortOptionSelected(6, true);
                    return;
                }
                return;
            case 8:
                SRPSharedViewModel sRPSharedViewModel8 = this.f23551g;
                if (sRPSharedViewModel8 != null) {
                    sRPSharedViewModel8.onRoundTripSortOptionSelected(1, false);
                    return;
                }
                return;
            case 9:
                SRPSharedViewModel sRPSharedViewModel9 = this.f23551g;
                if (sRPSharedViewModel9 == null) {
                    z3 = false;
                }
                if (z3) {
                    sRPSharedViewModel9.onRoundTripSortOptionSelected(2, false);
                    return;
                }
                return;
            case 10:
                SRPSharedViewModel sRPSharedViewModel10 = this.f23551g;
                if (sRPSharedViewModel10 == null) {
                    z3 = false;
                }
                if (z3) {
                    sRPSharedViewModel10.onRoundTripSortOptionSelected(3, false);
                    return;
                }
                return;
            case 11:
                SRPSharedViewModel sRPSharedViewModel11 = this.f23551g;
                if (sRPSharedViewModel11 == null) {
                    z3 = false;
                }
                if (z3) {
                    sRPSharedViewModel11.onRoundTripSortOptionSelected(4, false);
                    return;
                }
                return;
            case 12:
                SRPSharedViewModel sRPSharedViewModel12 = this.f23551g;
                if (sRPSharedViewModel12 == null) {
                    z3 = false;
                }
                if (z3) {
                    sRPSharedViewModel12.onRoundTripSortOptionSelected(5, false);
                    return;
                }
                return;
            case 13:
                SRPSharedViewModel sRPSharedViewModel13 = this.f23551g;
                if (sRPSharedViewModel13 == null) {
                    z3 = false;
                }
                if (z3) {
                    sRPSharedViewModel13.onRoundTripSortOptionSelected(6, false);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
