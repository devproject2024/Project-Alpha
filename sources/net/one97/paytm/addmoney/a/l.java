package net.one97.paytm.addmoney.a;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import net.one97.paytm.addmoney.R;

public final class l extends k {
    private static final ViewDataBinding.b R = null;
    private static final SparseIntArray S;
    private a T;
    private long U;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        S = sparseIntArray;
        sparseIntArray.put(R.id.expanded_balance, 9);
        S.put(R.id.iv_back_arrow, 10);
        S.put(R.id.head_container_top, 11);
        S.put(R.id.tv_addmoney_top, 12);
        S.put(R.id.head_border, 13);
        S.put(R.id.head_container, 14);
        S.put(R.id.tv_addmoney, 15);
        S.put(R.id.wallet_loader, 16);
        S.put(R.id.bal_barier, 17);
        S.put(R.id.label_am, 18);
        S.put(R.id.offer_container, 19);
        S.put(R.id.rs_tv, 20);
        S.put(R.id.promo_layout, 21);
        S.put(R.id.tv_applied_coupon_text, 22);
        S.put(R.id.remove_coupon, 23);
        S.put(R.id.offer_details_text, 24);
        S.put(R.id.apply_promo_text, 25);
        S.put(R.id.promo_apply_message, 26);
        S.put(R.id.amw_amount_et_underline_view, 27);
        S.put(R.id.promo_bar, 28);
        S.put(R.id.proceed_cl, 29);
        S.put(R.id.choose_text_heading, 30);
        S.put(R.id.choose_option, 31);
        S.put(R.id.info, 32);
        S.put(R.id.proceed, 33);
        S.put(R.id.loader_container, 34);
        S.put(R.id.view_loader, 35);
        S.put(R.id.rv_wallet_usage, 36);
        S.put(R.id.barrie_1, 37);
        S.put(R.id.rv_manage_wallet, 38);
        S.put(R.id.bottom_1, 39);
        S.put(R.id.bottom_2, 40);
        S.put(R.id.action_group, 41);
    }

    public l(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 42, R, S));
    }

    private l(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[41], objArr[27], objArr[5], objArr[25], objArr[17], objArr[37], objArr[39], objArr[40], objArr[31], objArr[30], objArr[9], objArr[13], objArr[14], objArr[11], objArr[32], objArr[10], objArr[4], objArr[18], objArr[34], objArr[1], objArr[19], objArr[24], objArr[33], objArr[29], objArr[26], objArr[28], objArr[21], objArr[23], objArr[20], objArr[38], objArr[36], objArr[0], objArr[15], objArr[12], objArr[6], objArr[22], objArr[7], objArr[8], objArr[3], objArr[2], objArr[35], objArr[16]);
        this.U = -1;
        this.f48064c.setTag((Object) null);
        this.q.setTag((Object) null);
        this.t.setTag((Object) null);
        this.F.setTag((Object) null);
        this.I.setTag((Object) null);
        this.K.setTag((Object) null);
        this.L.setTag((Object) null);
        this.M.setTag((Object) null);
        this.N.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.U = 256;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.U != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (net.one97.paytm.addmoney.e.f48571b != i2) {
            return false;
        }
        a((net.one97.paytm.newaddmoney.c.a) obj);
        return true;
    }

    public final void a(net.one97.paytm.newaddmoney.c.a aVar) {
        this.Q = aVar;
        synchronized (this) {
            this.U |= 128;
        }
        notifyPropertyChanged(net.one97.paytm.addmoney.e.f48571b);
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
        if (i2 != net.one97.paytm.addmoney.e.f48570a) {
            return false;
        }
        synchronized (this) {
            this.U |= 1;
        }
        return true;
    }

    private boolean b(int i2) {
        if (i2 != net.one97.paytm.addmoney.e.f48570a) {
            return false;
        }
        synchronized (this) {
            this.U |= 2;
        }
        return true;
    }

    private boolean c(int i2) {
        if (i2 != net.one97.paytm.addmoney.e.f48570a) {
            return false;
        }
        synchronized (this) {
            this.U |= 4;
        }
        return true;
    }

    private boolean d(int i2) {
        if (i2 != net.one97.paytm.addmoney.e.f48570a) {
            return false;
        }
        synchronized (this) {
            this.U |= 8;
        }
        return true;
    }

    private boolean e(int i2) {
        if (i2 != net.one97.paytm.addmoney.e.f48570a) {
            return false;
        }
        synchronized (this) {
            this.U |= 16;
        }
        return true;
    }

    private boolean f(int i2) {
        if (i2 != net.one97.paytm.addmoney.e.f48570a) {
            return false;
        }
        synchronized (this) {
            this.U |= 32;
        }
        return true;
    }

    private boolean g(int i2) {
        if (i2 != net.one97.paytm.addmoney.e.f48570a) {
            return false;
        }
        synchronized (this) {
            this.U |= 64;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x009f, code lost:
        if (r0 == null) goto L_0x00a1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00fd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r34 = this;
            r1 = r34
            monitor-enter(r34)
            long r2 = r1.U     // Catch:{ all -> 0x016d }
            r4 = 0
            r1.U = r4     // Catch:{ all -> 0x016d }
            monitor-exit(r34)     // Catch:{ all -> 0x016d }
            net.one97.paytm.newaddmoney.c.a r0 = r1.Q
            r6 = 511(0x1ff, double:2.525E-321)
            long r6 = r6 & r2
            r10 = 392(0x188, double:1.937E-321)
            r12 = 388(0x184, double:1.917E-321)
            r14 = 400(0x190, double:1.976E-321)
            r16 = 386(0x182, double:1.907E-321)
            r18 = 448(0x1c0, double:2.213E-321)
            r20 = 385(0x181, double:1.9E-321)
            r22 = 384(0x180, double:1.897E-321)
            r8 = 0
            r9 = 0
            int r26 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r26 == 0) goto L_0x00ff
            long r6 = r2 & r20
            int r26 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r26 == 0) goto L_0x003b
            if (r0 == 0) goto L_0x002e
            androidx.databinding.i<java.lang.String> r6 = r0.m
            goto L_0x002f
        L_0x002e:
            r6 = r9
        L_0x002f:
            r1.updateRegistration((int) r8, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x003b
            java.lang.Object r6 = r6.get()
            java.lang.String r6 = (java.lang.String) r6
            goto L_0x003c
        L_0x003b:
            r6 = r9
        L_0x003c:
            long r26 = r2 & r16
            int r7 = (r26 > r4 ? 1 : (r26 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x0055
            if (r0 == 0) goto L_0x0047
            androidx.databinding.i<java.lang.String> r7 = r0.f55836f
            goto L_0x0048
        L_0x0047:
            r7 = r9
        L_0x0048:
            r8 = 1
            r1.updateRegistration((int) r8, (androidx.databinding.h) r7)
            if (r7 == 0) goto L_0x0055
            java.lang.Object r7 = r7.get()
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x0056
        L_0x0055:
            r7 = r9
        L_0x0056:
            long r27 = r2 & r12
            int r8 = (r27 > r4 ? 1 : (r27 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x006f
            if (r0 == 0) goto L_0x0061
            androidx.databinding.i<java.lang.String> r8 = r0.D
            goto L_0x0062
        L_0x0061:
            r8 = r9
        L_0x0062:
            r12 = 2
            r1.updateRegistration((int) r12, (androidx.databinding.h) r8)
            if (r8 == 0) goto L_0x006f
            java.lang.Object r8 = r8.get()
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x0070
        L_0x006f:
            r8 = r9
        L_0x0070:
            long r12 = r2 & r10
            int r29 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r29 == 0) goto L_0x0089
            if (r0 == 0) goto L_0x007b
            androidx.databinding.i<java.lang.String> r12 = r0.l
            goto L_0x007c
        L_0x007b:
            r12 = r9
        L_0x007c:
            r13 = 3
            r1.updateRegistration((int) r13, (androidx.databinding.h) r12)
            if (r12 == 0) goto L_0x0089
            java.lang.Object r12 = r12.get()
            java.lang.String r12 = (java.lang.String) r12
            goto L_0x008a
        L_0x0089:
            r12 = r9
        L_0x008a:
            long r29 = r2 & r22
            int r13 = (r29 > r4 ? 1 : (r29 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x00a1
            if (r0 == 0) goto L_0x00a1
            net.one97.paytm.addmoney.a.l$a r13 = r1.T
            if (r13 != 0) goto L_0x009d
            net.one97.paytm.addmoney.a.l$a r13 = new net.one97.paytm.addmoney.a.l$a
            r13.<init>()
            r1.T = r13
        L_0x009d:
            r13.f48071a = r0
            if (r0 != 0) goto L_0x00a2
        L_0x00a1:
            r13 = r9
        L_0x00a2:
            long r29 = r2 & r14
            int r31 = (r29 > r4 ? 1 : (r29 == r4 ? 0 : -1))
            if (r31 == 0) goto L_0x00c1
            if (r0 == 0) goto L_0x00ad
            androidx.databinding.i<java.lang.Integer> r10 = r0.C
            goto L_0x00ae
        L_0x00ad:
            r10 = r9
        L_0x00ae:
            r11 = 4
            r1.updateRegistration((int) r11, (androidx.databinding.h) r10)
            if (r10 == 0) goto L_0x00bb
            java.lang.Object r10 = r10.get()
            java.lang.Integer r10 = (java.lang.Integer) r10
            goto L_0x00bc
        L_0x00bb:
            r10 = r9
        L_0x00bc:
            int r10 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Integer) r10)
            goto L_0x00c2
        L_0x00c1:
            r10 = 0
        L_0x00c2:
            r24 = 416(0x1a0, double:2.055E-321)
            long r31 = r2 & r24
            int r11 = (r31 > r4 ? 1 : (r31 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x00dd
            if (r0 == 0) goto L_0x00cf
            androidx.databinding.i<java.lang.String> r11 = r0.n
            goto L_0x00d0
        L_0x00cf:
            r11 = r9
        L_0x00d0:
            r14 = 5
            r1.updateRegistration((int) r14, (androidx.databinding.h) r11)
            if (r11 == 0) goto L_0x00dd
            java.lang.Object r11 = r11.get()
            java.lang.String r11 = (java.lang.String) r11
            goto L_0x00de
        L_0x00dd:
            r11 = r9
        L_0x00de:
            long r14 = r2 & r18
            int r33 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r33 == 0) goto L_0x00fd
            if (r0 == 0) goto L_0x00e9
            androidx.databinding.i<java.lang.Integer> r0 = r0.E
            goto L_0x00ea
        L_0x00e9:
            r0 = r9
        L_0x00ea:
            r14 = 6
            r1.updateRegistration((int) r14, (androidx.databinding.h) r0)
            if (r0 == 0) goto L_0x00f7
            java.lang.Object r0 = r0.get()
            java.lang.Integer r0 = (java.lang.Integer) r0
            goto L_0x00f8
        L_0x00f7:
            r0 = r9
        L_0x00f8:
            int r0 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Integer) r0)
            goto L_0x0107
        L_0x00fd:
            r0 = 0
            goto L_0x0107
        L_0x00ff:
            r6 = r9
            r7 = r6
            r8 = r7
            r11 = r8
            r12 = r11
            r13 = r12
            r0 = 0
            r10 = 0
        L_0x0107:
            long r14 = r2 & r22
            int r22 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r22 == 0) goto L_0x0112
            net.one97.paytm.addmoney.utils.CustomAmountTextInputEditText r14 = r1.f48064c
            androidx.databinding.a.d.a(r14, r13, r9, r9)
        L_0x0112:
            long r13 = r2 & r18
            int r9 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r9 == 0) goto L_0x011d
            android.view.View r9 = r1.k
            r9.setVisibility(r0)
        L_0x011d:
            r13 = 400(0x190, double:1.976E-321)
            long r13 = r13 & r2
            int r0 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0132
            int r0 = getBuildSdkInt()
            r9 = 11
            if (r0 < r9) goto L_0x0132
            android.widget.ImageView r0 = r1.q
            float r9 = (float) r10
            r0.setRotation(r9)
        L_0x0132:
            r9 = 392(0x188, double:1.937E-321)
            long r9 = r9 & r2
            int r0 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x013e
            android.widget.TextView r0 = r1.I
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r12)
        L_0x013e:
            long r9 = r2 & r20
            int r0 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0149
            android.widget.TextView r0 = r1.K
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r6)
        L_0x0149:
            r9 = 416(0x1a0, double:2.055E-321)
            long r9 = r9 & r2
            int r0 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0155
            android.widget.TextView r0 = r1.L
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r11)
        L_0x0155:
            r9 = 388(0x184, double:1.917E-321)
            long r9 = r9 & r2
            int r0 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0161
            android.widget.TextView r0 = r1.M
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r8)
        L_0x0161:
            long r2 = r2 & r16
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x016c
            android.widget.TextView r0 = r1.N
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r7)
        L_0x016c:
            return
        L_0x016d:
            r0 = move-exception
            monitor-exit(r34)     // Catch:{ all -> 0x016d }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.addmoney.a.l.executeBindings():void");
    }

    public static class a implements d.c {

        /* renamed from: a  reason: collision with root package name */
        net.one97.paytm.newaddmoney.c.a f48071a;

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            net.one97.paytm.newaddmoney.c.a.a(charSequence);
        }
    }
}
