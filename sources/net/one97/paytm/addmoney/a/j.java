package net.one97.paytm.addmoney.a;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import kotlin.g.b.k;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.towallet.c.d;

public final class j extends i {
    private static final ViewDataBinding.b aj = null;
    private static final SparseIntArray ak;
    private final FrameLayout al;
    private final ImageView am;
    private final TextView an;
    private final TextView ao;
    private final TextView ap;
    private final TextView aq;
    private final LinearLayout ar;
    private final TextView as;
    private final TextView at;
    private a au;
    private long av;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        ak = sparseIntArray;
        sparseIntArray.put(R.id.full_kyc_layout, 41);
        ak.put(R.id.view1, 42);
        ak.put(R.id.statusMsgTv, 43);
        ak.put(R.id.toTv, 44);
        ak.put(R.id.addedFromTitleTv, 45);
        ak.put(R.id.pendingIconImv, 46);
        ak.put(R.id.pendingTitleTv, 47);
        ak.put(R.id.pendingIcon2Imv, 48);
        ak.put(R.id.iv_addmoney_payment_done_to_paytm, 49);
        ak.put(R.id.iv_addmoney_pending_icon, 50);
        ak.put(R.id.tv_addmoney_pending_title, 51);
        ak.put(R.id.tv_addmoney_pending_subtitle, 52);
        ak.put(R.id.view4, 53);
        ak.put(R.id.failureIconImv, 54);
        ak.put(R.id.failureTitleTv, 55);
        ak.put(R.id.paymentDetailTitleTv, 56);
        ak.put(R.id.amountAddedTitleTv, 57);
        ak.put(R.id.seperator1, 58);
        ak.put(R.id.promocodeDetailTitleTv, 59);
        ak.put(R.id.SuccessBannerLargeCl, 60);
        ak.put(R.id.textview1, 61);
        ak.put(R.id.success, 62);
        ak.put(R.id.imv2, 63);
        ak.put(R.id.imv1, 64);
        ak.put(R.id.textview2, 65);
        ak.put(R.id.text2, 66);
        ak.put(R.id.cashBackContainerLl, 67);
    }

    public j(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 68, aj, ak));
    }

    private j(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[60], objArr[45], objArr[6], objArr[57], objArr[36], objArr[5], objArr[35], objArr[40], objArr[67], objArr[24], objArr[14], objArr[34], objArr[9], objArr[16], objArr[17], objArr[19], objArr[54], objArr[18], objArr[55], objArr[41], objArr[64], objArr[63], objArr[49], objArr[50], objArr[39], objArr[13], objArr[26], objArr[28], objArr[7], objArr[23], objArr[21], objArr[56], objArr[11], objArr[48], objArr[46], objArr[12], objArr[47], objArr[10], objArr[59], objArr[31], objArr[58], objArr[1], objArr[43], objArr[62], objArr[33], objArr[3], objArr[66], objArr[61], objArr[65], objArr[44], objArr[8], objArr[20], objArr[15], objArr[52], objArr[51], objArr[38], objArr[42], objArr[53], objArr[37]);
        this.av = -1;
        this.f48054c.setTag((Object) null);
        this.f48056e.setTag((Object) null);
        this.f48057f.setTag((Object) null);
        this.f48058g.setTag((Object) null);
        this.f48059h.setTag((Object) null);
        this.j.setTag((Object) null);
        this.k.setTag((Object) null);
        this.l.setTag((Object) null);
        this.m.setTag((Object) null);
        this.n.setTag((Object) null);
        this.o.setTag((Object) null);
        this.p.setTag((Object) null);
        this.r.setTag((Object) null);
        this.y.setTag((Object) null);
        this.al = objArr[0];
        this.al.setTag((Object) null);
        this.am = objArr[2];
        this.am.setTag((Object) null);
        this.an = objArr[22];
        this.an.setTag((Object) null);
        this.ao = objArr[25];
        this.ao.setTag((Object) null);
        this.ap = objArr[27];
        this.ap.setTag((Object) null);
        this.aq = objArr[29];
        this.aq.setTag((Object) null);
        this.ar = objArr[30];
        this.ar.setTag((Object) null);
        this.as = objArr[32];
        this.as.setTag((Object) null);
        this.at = objArr[4];
        this.at.setTag((Object) null);
        this.z.setTag((Object) null);
        this.A.setTag((Object) null);
        this.B.setTag((Object) null);
        this.C.setTag((Object) null);
        this.D.setTag((Object) null);
        this.E.setTag((Object) null);
        this.G.setTag((Object) null);
        this.J.setTag((Object) null);
        this.L.setTag((Object) null);
        this.N.setTag((Object) null);
        this.P.setTag((Object) null);
        this.S.setTag((Object) null);
        this.T.setTag((Object) null);
        this.Y.setTag((Object) null);
        this.Z.setTag((Object) null);
        this.aa.setTag((Object) null);
        this.ad.setTag((Object) null);
        this.ag.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.av = 131072;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.av != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (net.one97.paytm.addmoney.e.f48573d == i2) {
            a((net.one97.paytm.addmoney.towallet.c.a) obj);
        } else if (net.one97.paytm.addmoney.e.f48575f != i2) {
            return false;
        } else {
            a((d) obj);
        }
        return true;
    }

    public final void a(net.one97.paytm.addmoney.towallet.c.a aVar) {
        this.ai = aVar;
        synchronized (this) {
            this.av |= 32768;
        }
        notifyPropertyChanged(net.one97.paytm.addmoney.e.f48573d);
        super.requestRebind();
    }

    public final void a(d dVar) {
        this.ah = dVar;
        synchronized (this) {
            this.av |= 65536;
        }
        notifyPropertyChanged(net.one97.paytm.addmoney.e.f48575f);
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
            case 7:
                return h(i3);
            case 8:
                return i(i3);
            case 9:
                return j(i3);
            case 10:
                return k(i3);
            case 11:
                return l(i3);
            case 12:
                return m(i3);
            case 13:
                return n(i3);
            case 14:
                return o(i3);
            default:
                return false;
        }
    }

    private boolean a(int i2) {
        if (i2 != net.one97.paytm.addmoney.e.f48570a) {
            return false;
        }
        synchronized (this) {
            this.av |= 1;
        }
        return true;
    }

    private boolean b(int i2) {
        if (i2 != net.one97.paytm.addmoney.e.f48570a) {
            return false;
        }
        synchronized (this) {
            this.av |= 2;
        }
        return true;
    }

    private boolean c(int i2) {
        if (i2 != net.one97.paytm.addmoney.e.f48570a) {
            return false;
        }
        synchronized (this) {
            this.av |= 4;
        }
        return true;
    }

    private boolean d(int i2) {
        if (i2 != net.one97.paytm.addmoney.e.f48570a) {
            return false;
        }
        synchronized (this) {
            this.av |= 8;
        }
        return true;
    }

    private boolean e(int i2) {
        if (i2 != net.one97.paytm.addmoney.e.f48570a) {
            return false;
        }
        synchronized (this) {
            this.av |= 16;
        }
        return true;
    }

    private boolean f(int i2) {
        if (i2 != net.one97.paytm.addmoney.e.f48570a) {
            return false;
        }
        synchronized (this) {
            this.av |= 32;
        }
        return true;
    }

    private boolean g(int i2) {
        if (i2 != net.one97.paytm.addmoney.e.f48570a) {
            return false;
        }
        synchronized (this) {
            this.av |= 64;
        }
        return true;
    }

    private boolean h(int i2) {
        if (i2 != net.one97.paytm.addmoney.e.f48570a) {
            return false;
        }
        synchronized (this) {
            this.av |= 128;
        }
        return true;
    }

    private boolean i(int i2) {
        if (i2 != net.one97.paytm.addmoney.e.f48570a) {
            return false;
        }
        synchronized (this) {
            this.av |= 256;
        }
        return true;
    }

    private boolean j(int i2) {
        if (i2 != net.one97.paytm.addmoney.e.f48570a) {
            return false;
        }
        synchronized (this) {
            this.av |= 512;
        }
        return true;
    }

    private boolean k(int i2) {
        if (i2 != net.one97.paytm.addmoney.e.f48570a) {
            return false;
        }
        synchronized (this) {
            this.av |= 1024;
        }
        return true;
    }

    private boolean l(int i2) {
        if (i2 != net.one97.paytm.addmoney.e.f48570a) {
            return false;
        }
        synchronized (this) {
            this.av |= 2048;
        }
        return true;
    }

    private boolean m(int i2) {
        if (i2 != net.one97.paytm.addmoney.e.f48570a) {
            return false;
        }
        synchronized (this) {
            this.av |= 4096;
        }
        return true;
    }

    private boolean n(int i2) {
        if (i2 != net.one97.paytm.addmoney.e.f48570a) {
            return false;
        }
        synchronized (this) {
            this.av |= 8192;
        }
        return true;
    }

    private boolean o(int i2) {
        if (i2 != net.one97.paytm.addmoney.e.f48570a) {
            return false;
        }
        synchronized (this) {
            this.av |= 16384;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:132:0x01e7, code lost:
        if (r0 == null) goto L_0x01e9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0188  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x01a1  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x01c9  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x01de  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0220  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0239  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0248  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0261  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x0270  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x03c4  */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x03cd  */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x03d7  */
    /* JADX WARNING: Removed duplicated region for block: B:267:0x03e1  */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x03eb  */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x03f3  */
    /* JADX WARNING: Removed duplicated region for block: B:274:0x03fe  */
    /* JADX WARNING: Removed duplicated region for block: B:277:0x0411  */
    /* JADX WARNING: Removed duplicated region for block: B:279:0x0431  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:282:0x0468  */
    /* JADX WARNING: Removed duplicated region for block: B:285:0x049c  */
    /* JADX WARNING: Removed duplicated region for block: B:288:0x04b0  */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x04d2  */
    /* JADX WARNING: Removed duplicated region for block: B:294:0x04e6  */
    /* JADX WARNING: Removed duplicated region for block: B:297:0x04f5  */
    /* JADX WARNING: Removed duplicated region for block: B:300:0x0502  */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x0514  */
    /* JADX WARNING: Removed duplicated region for block: B:306:0x0521  */
    /* JADX WARNING: Removed duplicated region for block: B:309:0x0530  */
    /* JADX WARNING: Removed duplicated region for block: B:312:0x053f  */
    /* JADX WARNING: Removed duplicated region for block: B:315:0x054e  */
    /* JADX WARNING: Removed duplicated region for block: B:318:0x055b  */
    /* JADX WARNING: Removed duplicated region for block: B:327:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0160  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r59 = this;
            r1 = r59
            monitor-enter(r59)
            long r2 = r1.av     // Catch:{ all -> 0x056a }
            r4 = 0
            r1.av = r4     // Catch:{ all -> 0x056a }
            monitor-exit(r59)     // Catch:{ all -> 0x056a }
            net.one97.paytm.addmoney.towallet.c.a r0 = r1.ai
            net.one97.paytm.addmoney.towallet.c.d r6 = r1.ah
            r7 = 262143(0x3ffff, double:1.29516E-318)
            long r7 = r7 & r2
            r11 = 163856(0x28010, double:8.09556E-319)
            r13 = 163844(0x28004, double:8.09497E-319)
            r15 = 524288(0x80000, double:2.590327E-318)
            r17 = 163842(0x28002, double:8.09487E-319)
            r19 = 1048576(0x100000, double:5.180654E-318)
            r21 = 163841(0x28001, double:8.0948E-319)
            r23 = 229408(0x38020, double:1.133426E-318)
            r25 = 163848(0x28008, double:8.09517E-319)
            r9 = 1
            r10 = 0
            r29 = 0
            int r30 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r30 == 0) goto L_0x029b
            long r7 = r2 & r21
            int r30 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r30 == 0) goto L_0x004b
            if (r0 == 0) goto L_0x003d
            androidx.databinding.i<java.lang.String> r7 = r0.p
            goto L_0x003f
        L_0x003d:
            r7 = r29
        L_0x003f:
            r1.updateRegistration((int) r10, (androidx.databinding.h) r7)
            if (r7 == 0) goto L_0x004b
            java.lang.Object r7 = r7.get()
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x004d
        L_0x004b:
            r7 = r29
        L_0x004d:
            long r30 = r2 & r17
            int r8 = (r30 > r4 ? 1 : (r30 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x0066
            if (r0 == 0) goto L_0x0058
            androidx.databinding.i<java.lang.String> r8 = r0.f48838i
            goto L_0x005a
        L_0x0058:
            r8 = r29
        L_0x005a:
            r1.updateRegistration((int) r9, (androidx.databinding.h) r8)
            if (r8 == 0) goto L_0x0066
            java.lang.Object r8 = r8.get()
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x0068
        L_0x0066:
            r8 = r29
        L_0x0068:
            long r30 = r2 & r13
            int r32 = (r30 > r4 ? 1 : (r30 == r4 ? 0 : -1))
            if (r32 == 0) goto L_0x0098
            if (r0 == 0) goto L_0x0073
            androidx.databinding.i<java.lang.Boolean> r9 = r0.s
            goto L_0x0075
        L_0x0073:
            r9 = r29
        L_0x0075:
            r10 = 2
            r1.updateRegistration((int) r10, (androidx.databinding.h) r9)
            if (r9 == 0) goto L_0x0082
            java.lang.Object r9 = r9.get()
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            goto L_0x0084
        L_0x0082:
            r9 = r29
        L_0x0084:
            boolean r10 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r9)
            r9 = r10 ^ 1
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
            boolean r9 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r9)
            r58 = r10
            r10 = r9
            r9 = r58
            goto L_0x009a
        L_0x0098:
            r9 = 0
            r10 = 0
        L_0x009a:
            long r32 = r2 & r25
            int r34 = (r32 > r4 ? 1 : (r32 == r4 ? 0 : -1))
            if (r34 == 0) goto L_0x00c8
            if (r0 == 0) goto L_0x00a5
            androidx.databinding.i<java.lang.String> r13 = r0.j
            goto L_0x00a7
        L_0x00a5:
            r13 = r29
        L_0x00a7:
            r14 = 3
            r1.updateRegistration((int) r14, (androidx.databinding.h) r13)
            if (r13 == 0) goto L_0x00b4
            java.lang.Object r13 = r13.get()
            java.lang.String r13 = (java.lang.String) r13
            goto L_0x00b6
        L_0x00b4:
            r13 = r29
        L_0x00b6:
            if (r13 != 0) goto L_0x00ba
            r14 = 1
            goto L_0x00bb
        L_0x00ba:
            r14 = 0
        L_0x00bb:
            if (r34 == 0) goto L_0x00cb
            if (r14 == 0) goto L_0x00c5
            r34 = 2097152(0x200000, double:1.0361308E-317)
            long r2 = r2 | r34
            goto L_0x00cb
        L_0x00c5:
            long r2 = r2 | r19
            goto L_0x00cb
        L_0x00c8:
            r13 = r29
            r14 = 0
        L_0x00cb:
            long r34 = r2 & r11
            int r36 = (r34 > r4 ? 1 : (r34 == r4 ? 0 : -1))
            if (r36 == 0) goto L_0x00e5
            if (r0 == 0) goto L_0x00d6
            androidx.databinding.i<java.lang.String> r11 = r0.f48832c
            goto L_0x00d8
        L_0x00d6:
            r11 = r29
        L_0x00d8:
            r12 = 4
            r1.updateRegistration((int) r12, (androidx.databinding.h) r11)
            if (r11 == 0) goto L_0x00e5
            java.lang.Object r11 = r11.get()
            java.lang.String r11 = (java.lang.String) r11
            goto L_0x00e7
        L_0x00e5:
            r11 = r29
        L_0x00e7:
            long r36 = r2 & r23
            int r12 = (r36 > r4 ? 1 : (r36 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x0113
            if (r0 == 0) goto L_0x00f2
            androidx.databinding.i<java.lang.Boolean> r4 = r0.r
            goto L_0x00f4
        L_0x00f2:
            r4 = r29
        L_0x00f4:
            r5 = 5
            r1.updateRegistration((int) r5, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x0101
            java.lang.Object r4 = r4.get()
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            goto L_0x0103
        L_0x0101:
            r4 = r29
        L_0x0103:
            boolean r4 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r4)
            if (r12 == 0) goto L_0x0114
            if (r4 == 0) goto L_0x010d
            long r2 = r2 | r15
            goto L_0x0114
        L_0x010d:
            r38 = 262144(0x40000, double:1.295163E-318)
            long r2 = r2 | r38
            goto L_0x0114
        L_0x0113:
            r4 = 0
        L_0x0114:
            r27 = 163904(0x28040, double:8.09793E-319)
            long r38 = r2 & r27
            r36 = 0
            int r5 = (r38 > r36 ? 1 : (r38 == r36 ? 0 : -1))
            if (r5 == 0) goto L_0x0133
            if (r0 == 0) goto L_0x0124
            androidx.databinding.i<java.lang.String> r5 = r0.f48834e
            goto L_0x0126
        L_0x0124:
            r5 = r29
        L_0x0126:
            r12 = 6
            r1.updateRegistration((int) r12, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x0133
            java.lang.Object r5 = r5.get()
            java.lang.String r5 = (java.lang.String) r5
            goto L_0x0135
        L_0x0133:
            r5 = r29
        L_0x0135:
            r38 = 163968(0x28080, double:8.1011E-319)
            long r38 = r2 & r38
            r36 = 0
            int r12 = (r38 > r36 ? 1 : (r38 == r36 ? 0 : -1))
            if (r12 == 0) goto L_0x0154
            if (r0 == 0) goto L_0x0145
            androidx.databinding.i<java.lang.String> r12 = r0.q
            goto L_0x0147
        L_0x0145:
            r12 = r29
        L_0x0147:
            r15 = 7
            r1.updateRegistration((int) r15, (androidx.databinding.h) r12)
            if (r12 == 0) goto L_0x0154
            java.lang.Object r12 = r12.get()
            java.lang.String r12 = (java.lang.String) r12
            goto L_0x0156
        L_0x0154:
            r12 = r29
        L_0x0156:
            r15 = 164096(0x28100, double:8.1074E-319)
            long r15 = r15 & r2
            r36 = 0
            int r40 = (r15 > r36 ? 1 : (r15 == r36 ? 0 : -1))
            if (r40 == 0) goto L_0x0179
            if (r0 == 0) goto L_0x0167
            androidx.databinding.i<java.lang.String> r15 = r0.f48835f
            r16 = r4
            goto L_0x016b
        L_0x0167:
            r16 = r4
            r15 = r29
        L_0x016b:
            r4 = 8
            r1.updateRegistration((int) r4, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x017b
            java.lang.Object r4 = r15.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x017d
        L_0x0179:
            r16 = r4
        L_0x017b:
            r4 = r29
        L_0x017d:
            r40 = 164352(0x28200, double:8.12007E-319)
            long r40 = r2 & r40
            r36 = 0
            int r15 = (r40 > r36 ? 1 : (r40 == r36 ? 0 : -1))
            if (r15 == 0) goto L_0x01a1
            if (r0 == 0) goto L_0x018f
            androidx.databinding.i<java.lang.String> r15 = r0.t
            r40 = r4
            goto L_0x0193
        L_0x018f:
            r40 = r4
            r15 = r29
        L_0x0193:
            r4 = 9
            r1.updateRegistration((int) r4, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x01a3
            java.lang.Object r4 = r15.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x01a5
        L_0x01a1:
            r40 = r4
        L_0x01a3:
            r4 = r29
        L_0x01a5:
            r41 = 164864(0x28400, double:8.14536E-319)
            long r41 = r2 & r41
            r36 = 0
            int r15 = (r41 > r36 ? 1 : (r41 == r36 ? 0 : -1))
            if (r15 == 0) goto L_0x01c9
            if (r0 == 0) goto L_0x01b7
            androidx.databinding.i<java.lang.String> r15 = r0.k
            r41 = r4
            goto L_0x01bb
        L_0x01b7:
            r41 = r4
            r15 = r29
        L_0x01bb:
            r4 = 10
            r1.updateRegistration((int) r4, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x01cb
            java.lang.Object r4 = r15.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x01cd
        L_0x01c9:
            r41 = r4
        L_0x01cb:
            r4 = r29
        L_0x01cd:
            r42 = 163840(0x28000, double:8.09477E-319)
            long r42 = r2 & r42
            r36 = 0
            int r15 = (r42 > r36 ? 1 : (r42 == r36 ? 0 : -1))
            if (r15 == 0) goto L_0x01e9
            if (r0 == 0) goto L_0x01e9
            net.one97.paytm.addmoney.a.j$a r15 = r1.au
            if (r15 != 0) goto L_0x01e5
            net.one97.paytm.addmoney.a.j$a r15 = new net.one97.paytm.addmoney.a.j$a
            r15.<init>()
            r1.au = r15
        L_0x01e5:
            r15.f48061a = r0
            if (r0 != 0) goto L_0x01eb
        L_0x01e9:
            r15 = r29
        L_0x01eb:
            r42 = 165888(0x28800, double:8.19596E-319)
            long r42 = r2 & r42
            r36 = 0
            int r44 = (r42 > r36 ? 1 : (r42 == r36 ? 0 : -1))
            r42 = r4
            if (r44 == 0) goto L_0x0211
            if (r0 == 0) goto L_0x01ff
            androidx.databinding.i<java.lang.String> r4 = r0.l
            r43 = r5
            goto L_0x0203
        L_0x01ff:
            r43 = r5
            r4 = r29
        L_0x0203:
            r5 = 11
            r1.updateRegistration((int) r5, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x0213
            java.lang.Object r4 = r4.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0215
        L_0x0211:
            r43 = r5
        L_0x0213:
            r4 = r29
        L_0x0215:
            r44 = 167936(0x29000, double:8.29714E-319)
            long r44 = r2 & r44
            r36 = 0
            int r5 = (r44 > r36 ? 1 : (r44 == r36 ? 0 : -1))
            if (r5 == 0) goto L_0x0239
            if (r0 == 0) goto L_0x0227
            androidx.databinding.i<java.lang.String> r5 = r0.f48837h
            r44 = r4
            goto L_0x022b
        L_0x0227:
            r44 = r4
            r5 = r29
        L_0x022b:
            r4 = 12
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x023b
            java.lang.Object r4 = r5.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x023d
        L_0x0239:
            r44 = r4
        L_0x023b:
            r4 = r29
        L_0x023d:
            r45 = 172032(0x2a000, double:8.4995E-319)
            long r45 = r2 & r45
            r36 = 0
            int r5 = (r45 > r36 ? 1 : (r45 == r36 ? 0 : -1))
            if (r5 == 0) goto L_0x0261
            if (r0 == 0) goto L_0x024f
            androidx.databinding.i<java.lang.String> r5 = r0.o
            r45 = r4
            goto L_0x0253
        L_0x024f:
            r45 = r4
            r5 = r29
        L_0x0253:
            r4 = 13
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x0263
            java.lang.Object r4 = r5.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0265
        L_0x0261:
            r45 = r4
        L_0x0263:
            r4 = r29
        L_0x0265:
            r46 = 180224(0x2c000, double:8.90425E-319)
            long r46 = r2 & r46
            r36 = 0
            int r5 = (r46 > r36 ? 1 : (r46 == r36 ? 0 : -1))
            if (r5 == 0) goto L_0x0286
            if (r0 == 0) goto L_0x0275
            androidx.databinding.i<java.lang.String> r0 = r0.f48833d
            goto L_0x0277
        L_0x0275:
            r0 = r29
        L_0x0277:
            r5 = 14
            r1.updateRegistration((int) r5, (androidx.databinding.h) r0)
            if (r0 == 0) goto L_0x0286
            java.lang.Object r0 = r0.get()
            r29 = r0
            java.lang.String r29 = (java.lang.String) r29
        L_0x0286:
            r52 = r4
            r49 = r7
            r48 = r8
            r8 = r29
            r51 = r40
            r50 = r41
            r4 = r42
            r7 = r43
            r5 = r44
            r0 = r45
            goto L_0x02b4
        L_0x029b:
            r0 = r29
            r4 = r0
            r5 = r4
            r7 = r5
            r8 = r7
            r11 = r8
            r12 = r11
            r13 = r12
            r15 = r13
            r48 = r15
            r49 = r48
            r50 = r49
            r51 = r50
            r52 = r51
            r9 = 0
            r10 = 0
            r14 = 0
            r16 = 0
        L_0x02b4:
            r40 = 196608(0x30000, double:9.71373E-319)
            long r42 = r2 & r40
            r44 = 8388608(0x800000, double:4.144523E-317)
            r36 = 0
            int r29 = (r42 > r36 ? 1 : (r42 == r36 ? 0 : -1))
            if (r29 == 0) goto L_0x032a
            r42 = r8
            net.one97.paytm.addmoney.towallet.c.d r8 = net.one97.paytm.addmoney.towallet.c.d.SUCCESS_DETAIL
            if (r6 != r8) goto L_0x02cb
            r43 = 1
            goto L_0x02cd
        L_0x02cb:
            r43 = 0
        L_0x02cd:
            net.one97.paytm.addmoney.towallet.c.d r8 = net.one97.paytm.addmoney.towallet.c.d.PENDING
            if (r6 != r8) goto L_0x02d4
            r46 = 1
            goto L_0x02d6
        L_0x02d4:
            r46 = 0
        L_0x02d6:
            net.one97.paytm.addmoney.towallet.c.d r8 = net.one97.paytm.addmoney.towallet.c.d.SUCCESS_INITIAL
            r47 = r7
            if (r6 == r8) goto L_0x02de
            r8 = 1
            goto L_0x02df
        L_0x02de:
            r8 = 0
        L_0x02df:
            net.one97.paytm.addmoney.towallet.c.d r7 = net.one97.paytm.addmoney.towallet.c.d.FAILURE
            if (r6 != r7) goto L_0x02e6
            r53 = 1
            goto L_0x02e8
        L_0x02e6:
            r53 = 0
        L_0x02e8:
            net.one97.paytm.addmoney.towallet.c.d r7 = net.one97.paytm.addmoney.towallet.c.d.FULLFILMENT_PENDING
            if (r6 != r7) goto L_0x02ef
            r54 = 1
            goto L_0x02f1
        L_0x02ef:
            r54 = 0
        L_0x02f1:
            net.one97.paytm.addmoney.towallet.c.d r7 = net.one97.paytm.addmoney.towallet.c.d.SUCCESS_INITIAL
            if (r6 != r7) goto L_0x02f7
            r7 = 1
            goto L_0x02f8
        L_0x02f7:
            r7 = 0
        L_0x02f8:
            if (r29 == 0) goto L_0x0304
            if (r8 == 0) goto L_0x02ff
            long r2 = r2 | r44
            goto L_0x0304
        L_0x02ff:
            r55 = 4194304(0x400000, double:2.0722615E-317)
            long r2 = r2 | r55
        L_0x0304:
            long r55 = r2 & r40
            r36 = 0
            int r29 = (r55 > r36 ? 1 : (r55 == r36 ? 0 : -1))
            if (r29 == 0) goto L_0x0317
            if (r7 == 0) goto L_0x0312
            r55 = 134217728(0x8000000, double:6.63123685E-316)
            goto L_0x0315
        L_0x0312:
            r55 = 67108864(0x4000000, double:3.31561842E-316)
        L_0x0315:
            long r2 = r2 | r55
        L_0x0317:
            r29 = r8
            r8 = r43
            r43 = r5
            r5 = r54
            r58 = r46
            r46 = r9
            r9 = r53
            r53 = r10
            r10 = r58
            goto L_0x033b
        L_0x032a:
            r47 = r7
            r42 = r8
            r43 = r5
            r46 = r9
            r53 = r10
            r5 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r29 = 0
        L_0x033b:
            long r19 = r2 & r19
            r36 = 0
            int r54 = (r19 > r36 ? 1 : (r19 == r36 ? 0 : -1))
            r19 = r0
            if (r54 == 0) goto L_0x034c
            java.lang.String r0 = ""
            boolean r0 = r0.equals(r13)
            goto L_0x034d
        L_0x034c:
            r0 = 0
        L_0x034d:
            r38 = 524288(0x80000, double:2.590327E-318)
            long r38 = r2 & r38
            int r20 = (r38 > r36 ? 1 : (r38 == r36 ? 0 : -1))
            if (r20 == 0) goto L_0x0372
            r20 = r0
            net.one97.paytm.addmoney.towallet.c.d r0 = net.one97.paytm.addmoney.towallet.c.d.SUCCESS_INITIAL
            if (r6 == r0) goto L_0x035f
            r29 = 1
            goto L_0x0361
        L_0x035f:
            r29 = 0
        L_0x0361:
            long r38 = r2 & r40
            int r0 = (r38 > r36 ? 1 : (r38 == r36 ? 0 : -1))
            if (r0 == 0) goto L_0x0374
            if (r29 == 0) goto L_0x036c
            long r2 = r2 | r44
            goto L_0x0374
        L_0x036c:
            r38 = 4194304(0x400000, double:2.0722615E-317)
            long r2 = r2 | r38
            goto L_0x0374
        L_0x0372:
            r20 = r0
        L_0x0374:
            r0 = r29
            long r38 = r2 & r40
            int r29 = (r38 > r36 ? 1 : (r38 == r36 ? 0 : -1))
            if (r29 == 0) goto L_0x038a
            if (r7 == 0) goto L_0x0381
            r29 = 1
            goto L_0x0383
        L_0x0381:
            r29 = r8
        L_0x0383:
            r58 = r29
            r29 = r13
            r13 = r58
            goto L_0x038d
        L_0x038a:
            r29 = r13
            r13 = 0
        L_0x038d:
            long r38 = r2 & r23
            int r54 = (r38 > r36 ? 1 : (r38 == r36 ? 0 : -1))
            if (r54 == 0) goto L_0x039d
            if (r16 == 0) goto L_0x0398
            r16 = r0
            goto L_0x039a
        L_0x0398:
            r16 = 0
        L_0x039a:
            r57 = r16
            goto L_0x039f
        L_0x039d:
            r57 = 0
        L_0x039f:
            long r38 = r2 & r25
            int r16 = (r38 > r36 ? 1 : (r38 == r36 ? 0 : -1))
            if (r16 == 0) goto L_0x03bb
            if (r14 == 0) goto L_0x03a9
            r20 = 1
        L_0x03a9:
            if (r16 == 0) goto L_0x03b6
            if (r20 == 0) goto L_0x03b1
            r38 = 33554432(0x2000000, double:1.6578092E-316)
            goto L_0x03b4
        L_0x03b1:
            r38 = 16777216(0x1000000, double:8.289046E-317)
        L_0x03b4:
            long r2 = r2 | r38
        L_0x03b6:
            if (r20 == 0) goto L_0x03bb
            r14 = 8
            goto L_0x03bc
        L_0x03bb:
            r14 = 0
        L_0x03bc:
            long r38 = r2 & r44
            r36 = 0
            int r16 = (r38 > r36 ? 1 : (r38 == r36 ? 0 : -1))
            if (r16 == 0) goto L_0x03cd
            r16 = r14
            net.one97.paytm.addmoney.towallet.c.d r14 = net.one97.paytm.addmoney.towallet.c.d.SUCCESS_DETAIL
            if (r6 == r14) goto L_0x03cf
            r30 = 1
            goto L_0x03d1
        L_0x03cd:
            r16 = r14
        L_0x03cf:
            r30 = 0
        L_0x03d1:
            long r38 = r2 & r40
            int r6 = (r38 > r36 ? 1 : (r38 == r36 ? 0 : -1))
            if (r6 == 0) goto L_0x03e1
            if (r0 == 0) goto L_0x03dc
            r31 = r30
            goto L_0x03de
        L_0x03dc:
            r31 = 0
        L_0x03de:
            r14 = r31
            goto L_0x03e2
        L_0x03e1:
            r14 = 0
        L_0x03e2:
            r30 = 163968(0x28080, double:8.1011E-319)
            long r30 = r2 & r30
            int r20 = (r30 > r36 ? 1 : (r30 == r36 ? 0 : -1))
            if (r20 == 0) goto L_0x03f3
            r20 = r15
            android.widget.TextView r15 = r1.f48054c
            androidx.databinding.a.d.a((android.widget.TextView) r15, (java.lang.CharSequence) r12)
            goto L_0x03f5
        L_0x03f3:
            r20 = r15
        L_0x03f5:
            r30 = 164864(0x28400, double:8.14536E-319)
            long r30 = r2 & r30
            int r12 = (r30 > r36 ? 1 : (r30 == r36 ? 0 : -1))
            if (r12 == 0) goto L_0x0408
            android.widget.TextView r12 = r1.f48056e
            androidx.databinding.a.d.a((android.widget.TextView) r12, (java.lang.CharSequence) r4)
            android.widget.TextView r12 = r1.f48057f
            androidx.databinding.a.d.a((android.widget.TextView) r12, (java.lang.CharSequence) r4)
        L_0x0408:
            r30 = 163856(0x28010, double:8.09556E-319)
            long r30 = r2 & r30
            int r4 = (r30 > r36 ? 1 : (r30 == r36 ? 0 : -1))
            if (r4 == 0) goto L_0x042f
            android.widget.TextView r4 = r1.f48058g
            androidx.databinding.a.d.a((android.widget.TextView) r4, (java.lang.CharSequence) r11)
            android.widget.TextView r4 = r1.o
            androidx.databinding.a.d.a((android.widget.TextView) r4, (java.lang.CharSequence) r11)
            android.widget.TextView r4 = r1.an
            androidx.databinding.a.d.a((android.widget.TextView) r4, (java.lang.CharSequence) r11)
            android.widget.TextView r4 = r1.at
            androidx.databinding.a.d.a((android.widget.TextView) r4, (java.lang.CharSequence) r11)
            android.widget.TextView r4 = r1.G
            androidx.databinding.a.d.a((android.widget.TextView) r4, (java.lang.CharSequence) r11)
            android.widget.TextView r4 = r1.aa
            androidx.databinding.a.d.a((android.widget.TextView) r4, (java.lang.CharSequence) r11)
        L_0x042f:
            if (r6 == 0) goto L_0x045e
            android.widget.TextView r4 = r1.f48058g
            net.one97.paytm.addmoney.towallet.c.b.a(r4, r13)
            androidx.constraintlayout.widget.ConstraintLayout r4 = r1.k
            net.one97.paytm.addmoney.towallet.c.b.a(r4, r5)
            androidx.constraintlayout.widget.ConstraintLayout r4 = r1.n
            net.one97.paytm.addmoney.towallet.c.b.a(r4, r9)
            android.widget.ImageView r4 = r1.am
            net.one97.paytm.addmoney.towallet.c.b.a(r4, r8)
            android.widget.LinearLayout r4 = r1.B
            net.one97.paytm.addmoney.towallet.c.b.a(r4, r14)
            androidx.constraintlayout.widget.ConstraintLayout r4 = r1.L
            net.one97.paytm.addmoney.towallet.c.b.a(r4, r10)
            androidx.constraintlayout.widget.ConstraintLayout r4 = r1.P
            net.one97.paytm.addmoney.towallet.c.b.a(r4, r0)
            android.widget.LinearLayout r0 = r1.S
            net.one97.paytm.addmoney.towallet.c.b.a(r0, r7)
            androidx.constraintlayout.widget.ConstraintLayout r0 = r1.T
            net.one97.paytm.addmoney.towallet.c.b.a(r0, r8)
        L_0x045e:
            r4 = 163840(0x28000, double:8.09477E-319)
            long r4 = r4 & r2
            r6 = 0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x0492
            androidx.constraintlayout.widget.ConstraintLayout r0 = r1.f48059h
            r15 = r20
            r0.setOnClickListener(r15)
            android.widget.ImageView r0 = r1.j
            r0.setOnClickListener(r15)
            android.widget.ImageView r0 = r1.l
            r0.setOnClickListener(r15)
            android.widget.ImageView r0 = r1.y
            r0.setOnClickListener(r15)
            android.widget.TextView r0 = r1.z
            r0.setOnClickListener(r15)
            android.widget.TextView r0 = r1.Z
            r0.setOnClickListener(r15)
            android.widget.TextView r0 = r1.ad
            r0.setOnClickListener(r15)
            android.widget.TextView r0 = r1.ag
            r0.setOnClickListener(r15)
        L_0x0492:
            r4 = 167936(0x29000, double:8.29714E-319)
            long r4 = r4 & r2
            r6 = 0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x04a8
            android.widget.TextView r0 = r1.m
            r4 = r19
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
            android.widget.TextView r0 = r1.p
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
        L_0x04a8:
            r4 = 163844(0x28004, double:8.09497E-319)
            long r4 = r4 & r2
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x04c8
            android.widget.TextView r0 = r1.o
            r10 = r53
            net.one97.paytm.addmoney.towallet.c.b.a(r0, r10)
            android.widget.TextView r0 = r1.at
            net.one97.paytm.addmoney.towallet.c.b.a(r0, r10)
            androidx.constraintlayout.widget.ConstraintLayout r0 = r1.E
            r9 = r46
            net.one97.paytm.addmoney.towallet.c.b.a(r0, r9)
            android.widget.TextView r0 = r1.G
            net.one97.paytm.addmoney.towallet.c.b.a(r0, r10)
        L_0x04c8:
            r4 = 165888(0x28800, double:8.19596E-319)
            long r4 = r4 & r2
            r6 = 0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x04de
            android.widget.TextView r0 = r1.r
            r4 = r43
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
            android.widget.TextView r0 = r1.J
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
        L_0x04de:
            r4 = 163904(0x28040, double:8.09793E-319)
            long r4 = r4 & r2
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x04ed
            android.widget.TextView r0 = r1.ao
            r4 = r47
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
        L_0x04ed:
            r4 = 180224(0x2c000, double:8.90425E-319)
            long r4 = r4 & r2
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x04fc
            android.widget.TextView r0 = r1.ap
            r4 = r42
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
        L_0x04fc:
            long r4 = r2 & r17
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x050e
            android.widget.TextView r0 = r1.aq
            r8 = r48
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r8)
            android.widget.TextView r0 = r1.C
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r8)
        L_0x050e:
            long r4 = r2 & r23
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x051b
            android.widget.LinearLayout r0 = r1.ar
            r4 = r57
            net.one97.paytm.addmoney.towallet.c.b.a(r0, r4)
        L_0x051b:
            long r4 = r2 & r21
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x0528
            android.widget.TextView r0 = r1.as
            r4 = r49
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
        L_0x0528:
            r4 = 164352(0x28200, double:8.12007E-319)
            long r4 = r4 & r2
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x0537
            android.widget.TextView r0 = r1.A
            r4 = r50
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
        L_0x0537:
            r4 = 164096(0x28100, double:8.1074E-319)
            long r4 = r4 & r2
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x0546
            android.widget.TextView r0 = r1.D
            r4 = r51
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
        L_0x0546:
            r4 = 172032(0x2a000, double:8.4995E-319)
            long r4 = r4 & r2
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x0555
            android.widget.TextView r0 = r1.N
            r4 = r52
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
        L_0x0555:
            long r2 = r2 & r25
            int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x0569
            android.widget.TextView r0 = r1.Y
            r13 = r29
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r13)
            android.widget.TextView r0 = r1.Y
            r14 = r16
            r0.setVisibility(r14)
        L_0x0569:
            return
        L_0x056a:
            r0 = move-exception
            monitor-exit(r59)     // Catch:{ all -> 0x056a }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.addmoney.a.j.executeBindings():void");
    }

    public static class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        net.one97.paytm.addmoney.towallet.c.a f48061a;

        public final void onClick(View view) {
            net.one97.paytm.addmoney.towallet.c.a aVar = this.f48061a;
            k.c(view, "view");
            aVar.m.postValue(Integer.valueOf(view.getId()));
        }
    }
}
