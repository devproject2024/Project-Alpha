package net.one97.paytm.iocl.a;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.databinding.g;
import androidx.databinding.h;
import androidx.databinding.i;
import net.one97.paytm.iocl.R;
import net.one97.paytm.iocl.b.a.a;

public final class r extends q implements a.C0194a {
    private static final ViewDataBinding.b n = null;
    private static final SparseIntArray o;
    private final View.OnClickListener p;
    private final View.OnClickListener q;
    private g r;
    private g s;
    private g t;
    private g u;
    private long v;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        o = sparseIntArray;
        sparseIntArray.put(R.id.tv_header, 10);
        o.put(R.id.iv_tip, 11);
    }

    public r(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 12, n, o));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private r(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[9], objArr[4], objArr[6], objArr[8], objArr[2], objArr[11], objArr[0], objArr[3], objArr[5], objArr[10], objArr[7], objArr[1]);
        this.r = new g() {
            public final void onChange() {
                String a2 = d.a((TextView) r.this.f14159b);
                net.one97.paytm.transport.iocl_v1.c.d dVar = r.this.m;
                boolean z = true;
                if (dVar != null) {
                    i<String> iVar = dVar.k;
                    if (iVar == null) {
                        z = false;
                    }
                    if (z) {
                        iVar.set(a2);
                    }
                }
            }
        };
        this.s = new g() {
            public final void onChange() {
                String a2 = d.a((TextView) r.this.f14160c);
                net.one97.paytm.transport.iocl_v1.c.d dVar = r.this.m;
                boolean z = true;
                if (dVar != null) {
                    i<String> iVar = dVar.m;
                    if (iVar == null) {
                        z = false;
                    }
                    if (z) {
                        iVar.set(a2);
                    }
                }
            }
        };
        this.t = new g() {
            public final void onChange() {
                String a2 = d.a((TextView) r.this.f14161d);
                net.one97.paytm.transport.iocl_v1.c.d dVar = r.this.m;
                boolean z = true;
                if (dVar != null) {
                    i<String> iVar = dVar.f14445i;
                    if (iVar == null) {
                        z = false;
                    }
                    if (z) {
                        iVar.set(a2);
                    }
                }
            }
        };
        this.u = new g() {
            public final void onChange() {
                String a2 = d.a((TextView) r.this.f14162e);
                net.one97.paytm.transport.iocl_v1.c.d dVar = r.this.m;
                boolean z = true;
                if (dVar != null) {
                    i<String> iVar = dVar.f14443g;
                    if (iVar == null) {
                        z = false;
                    }
                    if (z) {
                        iVar.set(a2);
                    }
                }
            }
        };
        this.v = -1;
        this.f14158a.setTag((Object) null);
        this.f14159b.setTag((Object) null);
        this.f14160c.setTag((Object) null);
        this.f14161d.setTag((Object) null);
        this.f14162e.setTag((Object) null);
        this.f14164g.setTag((Object) null);
        this.f14165h.setTag((Object) null);
        this.f14166i.setTag((Object) null);
        this.k.setTag((Object) null);
        this.l.setTag((Object) null);
        setRootTag(view);
        this.p = new a(this, 2);
        this.q = new a(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.v = 512;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.v != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (net.one97.paytm.iocl.a.f14078b != i2) {
            return false;
        }
        a((net.one97.paytm.transport.iocl_v1.c.d) obj);
        return true;
    }

    public final void a(net.one97.paytm.transport.iocl_v1.c.d dVar) {
        updateRegistration(0, (h) dVar);
        this.m = dVar;
        synchronized (this) {
            this.v |= 1;
        }
        notifyPropertyChanged(net.one97.paytm.iocl.a.f14078b);
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
            default:
                return false;
        }
    }

    private boolean a(int i2) {
        if (i2 != net.one97.paytm.iocl.a.f14077a) {
            return false;
        }
        synchronized (this) {
            this.v |= 1;
        }
        return true;
    }

    private boolean b(int i2) {
        if (i2 != net.one97.paytm.iocl.a.f14077a) {
            return false;
        }
        synchronized (this) {
            this.v |= 2;
        }
        return true;
    }

    private boolean c(int i2) {
        if (i2 != net.one97.paytm.iocl.a.f14077a) {
            return false;
        }
        synchronized (this) {
            this.v |= 4;
        }
        return true;
    }

    private boolean d(int i2) {
        if (i2 != net.one97.paytm.iocl.a.f14077a) {
            return false;
        }
        synchronized (this) {
            this.v |= 8;
        }
        return true;
    }

    private boolean e(int i2) {
        if (i2 != net.one97.paytm.iocl.a.f14077a) {
            return false;
        }
        synchronized (this) {
            this.v |= 16;
        }
        return true;
    }

    private boolean f(int i2) {
        if (i2 != net.one97.paytm.iocl.a.f14077a) {
            return false;
        }
        synchronized (this) {
            this.v |= 32;
        }
        return true;
    }

    private boolean g(int i2) {
        if (i2 != net.one97.paytm.iocl.a.f14077a) {
            return false;
        }
        synchronized (this) {
            this.v |= 64;
        }
        return true;
    }

    private boolean h(int i2) {
        if (i2 != net.one97.paytm.iocl.a.f14077a) {
            return false;
        }
        synchronized (this) {
            this.v |= 128;
        }
        return true;
    }

    private boolean i(int i2) {
        if (i2 != net.one97.paytm.iocl.a.f14077a) {
            return false;
        }
        synchronized (this) {
            this.v |= 256;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00df  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r33 = this;
            r1 = r33
            monitor-enter(r33)
            long r2 = r1.v     // Catch:{ all -> 0x018d }
            r4 = 0
            r1.v = r4     // Catch:{ all -> 0x018d }
            monitor-exit(r33)     // Catch:{ all -> 0x018d }
            net.one97.paytm.transport.iocl_v1.c.d r0 = r1.m
            r6 = 1023(0x3ff, double:5.054E-321)
            long r6 = r6 & r2
            r8 = 641(0x281, double:3.167E-321)
            r12 = 545(0x221, double:2.693E-321)
            r14 = 529(0x211, double:2.614E-321)
            r16 = 521(0x209, double:2.574E-321)
            r18 = 517(0x205, double:2.554E-321)
            r20 = 577(0x241, double:2.85E-321)
            r22 = 515(0x203, double:2.544E-321)
            int r11 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x00f5
            long r6 = r2 & r22
            int r11 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x003a
            if (r0 == 0) goto L_0x002c
            androidx.databinding.i<java.lang.String> r6 = r0.m
            goto L_0x002d
        L_0x002c:
            r6 = 0
        L_0x002d:
            r7 = 1
            r1.updateRegistration((int) r7, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x003a
            java.lang.Object r6 = r6.get()
            java.lang.String r6 = (java.lang.String) r6
            goto L_0x003b
        L_0x003a:
            r6 = 0
        L_0x003b:
            long r26 = r2 & r18
            int r7 = (r26 > r4 ? 1 : (r26 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x0054
            if (r0 == 0) goto L_0x0046
            androidx.databinding.i<java.lang.String> r7 = r0.j
            goto L_0x0047
        L_0x0046:
            r7 = 0
        L_0x0047:
            r11 = 2
            r1.updateRegistration((int) r11, (androidx.databinding.h) r7)
            if (r7 == 0) goto L_0x0054
            java.lang.Object r7 = r7.get()
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x0055
        L_0x0054:
            r7 = 0
        L_0x0055:
            long r26 = r2 & r16
            int r11 = (r26 > r4 ? 1 : (r26 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x006e
            if (r0 == 0) goto L_0x0060
            androidx.databinding.i<java.lang.String> r11 = r0.f14445i
            goto L_0x0061
        L_0x0060:
            r11 = 0
        L_0x0061:
            r10 = 3
            r1.updateRegistration((int) r10, (androidx.databinding.h) r11)
            if (r11 == 0) goto L_0x006e
            java.lang.Object r10 = r11.get()
            java.lang.String r10 = (java.lang.String) r10
            goto L_0x006f
        L_0x006e:
            r10 = 0
        L_0x006f:
            long r27 = r2 & r14
            int r11 = (r27 > r4 ? 1 : (r27 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x0088
            if (r0 == 0) goto L_0x007a
            androidx.databinding.i<java.lang.String> r11 = r0.f14443g
            goto L_0x007b
        L_0x007a:
            r11 = 0
        L_0x007b:
            r14 = 4
            r1.updateRegistration((int) r14, (androidx.databinding.h) r11)
            if (r11 == 0) goto L_0x0088
            java.lang.Object r11 = r11.get()
            java.lang.String r11 = (java.lang.String) r11
            goto L_0x0089
        L_0x0088:
            r11 = 0
        L_0x0089:
            long r14 = r2 & r12
            int r29 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r29 == 0) goto L_0x00a2
            if (r0 == 0) goto L_0x0094
            androidx.databinding.i<java.lang.String> r14 = r0.l
            goto L_0x0095
        L_0x0094:
            r14 = 0
        L_0x0095:
            r15 = 5
            r1.updateRegistration((int) r15, (androidx.databinding.h) r14)
            if (r14 == 0) goto L_0x00a2
            java.lang.Object r14 = r14.get()
            java.lang.String r14 = (java.lang.String) r14
            goto L_0x00a3
        L_0x00a2:
            r14 = 0
        L_0x00a3:
            long r29 = r2 & r20
            int r15 = (r29 > r4 ? 1 : (r29 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x00bc
            if (r0 == 0) goto L_0x00ae
            androidx.databinding.i<java.lang.String> r15 = r0.k
            goto L_0x00af
        L_0x00ae:
            r15 = 0
        L_0x00af:
            r12 = 6
            r1.updateRegistration((int) r12, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x00bc
            java.lang.Object r12 = r15.get()
            java.lang.String r12 = (java.lang.String) r12
            goto L_0x00bd
        L_0x00bc:
            r12 = 0
        L_0x00bd:
            long r31 = r2 & r8
            int r13 = (r31 > r4 ? 1 : (r31 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x00d6
            if (r0 == 0) goto L_0x00c8
            androidx.databinding.i<java.lang.String> r13 = r0.f14444h
            goto L_0x00c9
        L_0x00c8:
            r13 = 0
        L_0x00c9:
            r15 = 7
            r1.updateRegistration((int) r15, (androidx.databinding.h) r13)
            if (r13 == 0) goto L_0x00d6
            java.lang.Object r13 = r13.get()
            java.lang.String r13 = (java.lang.String) r13
            goto L_0x00d7
        L_0x00d6:
            r13 = 0
        L_0x00d7:
            r24 = 769(0x301, double:3.8E-321)
            long r31 = r2 & r24
            int r15 = (r31 > r4 ? 1 : (r31 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x00f3
            if (r0 == 0) goto L_0x00e4
            androidx.databinding.i<java.lang.String> r0 = r0.n
            goto L_0x00e5
        L_0x00e4:
            r0 = 0
        L_0x00e5:
            r15 = 8
            r1.updateRegistration((int) r15, (androidx.databinding.h) r0)
            if (r0 == 0) goto L_0x00f3
            java.lang.Object r0 = r0.get()
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x00fd
        L_0x00f3:
            r0 = 0
            goto L_0x00fd
        L_0x00f5:
            r0 = 0
            r6 = 0
            r7 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
        L_0x00fd:
            r31 = 512(0x200, double:2.53E-321)
            long r31 = r2 & r31
            int r15 = (r31 > r4 ? 1 : (r31 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x0130
            android.widget.Button r15 = r1.f14158a
            android.view.View$OnClickListener r8 = r1.p
            r15.setOnClickListener(r8)
            androidx.appcompat.widget.AppCompatEditText r8 = r1.f14159b
            android.view.View$OnClickListener r9 = r1.q
            r8.setOnClickListener(r9)
            androidx.appcompat.widget.AppCompatEditText r8 = r1.f14159b
            androidx.databinding.g r9 = r1.r
            r15 = 0
            androidx.databinding.a.d.a(r8, r15, r15, r9)
            androidx.appcompat.widget.AppCompatEditText r8 = r1.f14160c
            androidx.databinding.g r9 = r1.s
            androidx.databinding.a.d.a(r8, r15, r15, r9)
            androidx.appcompat.widget.AppCompatEditText r8 = r1.f14161d
            androidx.databinding.g r9 = r1.t
            androidx.databinding.a.d.a(r8, r15, r15, r9)
            androidx.appcompat.widget.AppCompatEditText r8 = r1.f14162e
            androidx.databinding.g r9 = r1.u
            androidx.databinding.a.d.a(r8, r15, r15, r9)
        L_0x0130:
            long r8 = r2 & r20
            int r15 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x013b
            androidx.appcompat.widget.AppCompatEditText r8 = r1.f14159b
            androidx.databinding.a.d.a((android.widget.TextView) r8, (java.lang.CharSequence) r12)
        L_0x013b:
            long r8 = r2 & r22
            int r12 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x0146
            androidx.appcompat.widget.AppCompatEditText r8 = r1.f14160c
            androidx.databinding.a.d.a((android.widget.TextView) r8, (java.lang.CharSequence) r6)
        L_0x0146:
            long r8 = r2 & r16
            int r6 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0151
            androidx.appcompat.widget.AppCompatEditText r6 = r1.f14161d
            androidx.databinding.a.d.a((android.widget.TextView) r6, (java.lang.CharSequence) r10)
        L_0x0151:
            r8 = 529(0x211, double:2.614E-321)
            long r8 = r8 & r2
            int r6 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x015d
            androidx.appcompat.widget.AppCompatEditText r6 = r1.f14162e
            androidx.databinding.a.d.a((android.widget.TextView) r6, (java.lang.CharSequence) r11)
        L_0x015d:
            r8 = 545(0x221, double:2.693E-321)
            long r8 = r8 & r2
            int r6 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0169
            com.google.android.material.textfield.TextInputLayout r6 = r1.f14165h
            net.one97.paytm.transport.iocl_v1.c.d.a(r6, r14)
        L_0x0169:
            r8 = 769(0x301, double:3.8E-321)
            long r8 = r8 & r2
            int r6 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0175
            com.google.android.material.textfield.TextInputLayout r6 = r1.f14166i
            net.one97.paytm.transport.iocl_v1.c.d.a(r6, r0)
        L_0x0175:
            long r8 = r2 & r18
            int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0180
            com.google.android.material.textfield.TextInputLayout r0 = r1.k
            net.one97.paytm.transport.iocl_v1.c.d.a(r0, r7)
        L_0x0180:
            r6 = 641(0x281, double:3.167E-321)
            long r2 = r2 & r6
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x018c
            com.google.android.material.textfield.TextInputLayout r0 = r1.l
            net.one97.paytm.transport.iocl_v1.c.d.a(r0, r13)
        L_0x018c:
            return
        L_0x018d:
            r0 = move-exception
            monitor-exit(r33)     // Catch:{ all -> 0x018d }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.iocl.a.r.executeBindings():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r6, android.view.View r7) {
        /*
            r5 = this;
            r7 = 1
            r0 = 0
            if (r6 == r7) goto L_0x019b
            r1 = 2
            if (r6 == r1) goto L_0x0009
            goto L_0x01a8
        L_0x0009:
            net.one97.paytm.transport.iocl_v1.c.d r6 = r5.m
            if (r6 == 0) goto L_0x000f
            r1 = 1
            goto L_0x0010
        L_0x000f:
            r1 = 0
        L_0x0010:
            if (r1 == 0) goto L_0x01a8
            android.app.Application r1 = r6.getApplication()
            boolean r1 = com.paytm.utility.b.c((android.content.Context) r1)
            if (r1 == 0) goto L_0x017c
            androidx.databinding.i<java.lang.String> r1 = r6.f14443g
            java.lang.Object r1 = r1.get()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x003d
            androidx.databinding.i<java.lang.String> r1 = r6.f14444h
            android.app.Application r3 = r6.getApplication()
            int r4 = net.one97.paytm.iocl.R.string.empty_user_name_iocl
            java.lang.String r3 = r3.getString(r4)
            r1.set(r3)
        L_0x003b:
            r1 = 0
            goto L_0x007f
        L_0x003d:
            androidx.databinding.i<java.lang.String> r1 = r6.f14443g
            java.lang.Object r1 = r1.get()
            java.lang.String r1 = (java.lang.String) r1
            boolean r1 = net.one97.paytm.transport.iocl_v1.c.d.a(r1)
            if (r1 != 0) goto L_0x005b
            androidx.databinding.i<java.lang.String> r1 = r6.f14444h
            android.app.Application r3 = r6.getApplication()
            int r4 = net.one97.paytm.iocl.R.string.user_name_regex_not_valid
            java.lang.String r3 = r3.getString(r4)
            r1.set(r3)
            goto L_0x003b
        L_0x005b:
            androidx.databinding.i<java.lang.String> r1 = r6.f14443g
            java.lang.Object r1 = r1.get()
            java.lang.String r1 = (java.lang.String) r1
            boolean r1 = net.one97.paytm.transport.iocl_v1.c.d.b(r1)
            if (r1 != 0) goto L_0x0079
            androidx.databinding.i<java.lang.String> r1 = r6.f14444h
            android.app.Application r3 = r6.getApplication()
            int r4 = net.one97.paytm.iocl.R.string.user_name_regex_for_space_not_valid
            java.lang.String r3 = r3.getString(r4)
            r1.set(r3)
            goto L_0x003b
        L_0x0079:
            androidx.databinding.i<java.lang.String> r1 = r6.f14444h
            r1.set(r2)
            r1 = 1
        L_0x007f:
            androidx.databinding.i<java.lang.String> r3 = r6.k
            java.lang.Object r3 = r3.get()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L_0x009e
            androidx.databinding.i<java.lang.String> r1 = r6.l
            android.app.Application r3 = r6.getApplication()
            int r4 = net.one97.paytm.iocl.R.string.empty_dob_iocl
            java.lang.String r3 = r3.getString(r4)
            r1.set(r3)
            r1 = 0
            goto L_0x00a3
        L_0x009e:
            androidx.databinding.i<java.lang.String> r3 = r6.l
            r3.set(r2)
        L_0x00a3:
            androidx.databinding.i<java.lang.String> r3 = r6.m
            java.lang.Object r3 = r3.get()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L_0x00c2
            androidx.databinding.i<java.lang.String> r1 = r6.n
            android.app.Application r3 = r6.getApplication()
            int r4 = net.one97.paytm.iocl.R.string.empty_gender_iocl
            java.lang.String r3 = r3.getString(r4)
            r1.set(r3)
            r1 = 0
            goto L_0x00c7
        L_0x00c2:
            androidx.databinding.i<java.lang.String> r3 = r6.n
            r3.set(r2)
        L_0x00c7:
            androidx.databinding.i<java.lang.String> r3 = r6.f14445i
            java.lang.Object r3 = r3.get()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L_0x00e5
            androidx.databinding.i<java.lang.String> r1 = r6.j
            android.app.Application r2 = r6.getApplication()
            int r3 = net.one97.paytm.iocl.R.string.empty_pincode_iocl
            java.lang.String r2 = r2.getString(r3)
            r1.set(r2)
            goto L_0x0116
        L_0x00e5:
            androidx.databinding.i<java.lang.String> r3 = r6.f14445i
            java.lang.Object r3 = r3.get()
            if (r3 == 0) goto L_0x0110
            androidx.databinding.i<java.lang.String> r3 = r6.f14445i
            java.lang.Object r3 = r3.get()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r3 = r3.trim()
            int r3 = r3.length()
            r4 = 6
            if (r3 >= r4) goto L_0x0110
            androidx.databinding.i<java.lang.String> r1 = r6.j
            android.app.Application r2 = r6.getApplication()
            int r3 = net.one97.paytm.iocl.R.string.min_pincode
            java.lang.String r2 = r2.getString(r3)
            r1.set(r2)
            goto L_0x0116
        L_0x0110:
            androidx.databinding.i<java.lang.String> r0 = r6.j
            r0.set(r2)
            r0 = r1
        L_0x0116:
            if (r0 == 0) goto L_0x019a
            androidx.lifecycle.y<java.lang.Boolean> r0 = r6.f14433a
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            r0.setValue(r1)
            net.one97.paytm.transport.iocl_v1.data.b r0 = new net.one97.paytm.transport.iocl_v1.data.b
            r0.<init>()
            r0.f14455a = r7
            net.one97.paytm.transport.iocl_v1.data.User r7 = new net.one97.paytm.transport.iocl_v1.data.User
            r7.<init>()
            androidx.databinding.i<java.lang.String> r1 = r6.f14445i
            java.lang.Object r1 = r1.get()
            java.lang.String r1 = (java.lang.String) r1
            r7.setPincode(r1)
            androidx.databinding.i<java.lang.String> r1 = r6.k
            java.lang.Object r1 = r1.get()
            java.lang.String r1 = (java.lang.String) r1
            r7.setDob(r1)
            androidx.databinding.i<java.lang.String> r1 = r6.m
            java.lang.Object r1 = r1.get()
            java.lang.String r1 = (java.lang.String) r1
            r7.setGender(r1)
            android.app.Application r1 = r6.getApplication()
            java.lang.String r1 = com.paytm.utility.b.l((android.content.Context) r1)
            r7.setMobile(r1)
            androidx.databinding.i<java.lang.String> r1 = r6.f14443g
            java.lang.Object r1 = r1.get()
            java.lang.String r1 = (java.lang.String) r1
            r7.setName(r1)
            r0.f14456b = r7
            androidx.fragment.app.FragmentActivity r7 = r6.f14442f
            boolean r7 = com.paytm.utility.b.r((android.content.Context) r7)
            if (r7 == 0) goto L_0x0174
            android.app.Application r7 = r6.getApplication()
            net.one97.paytm.transport.iocl_v1.b.b.a((android.content.Context) r7, (net.one97.paytm.transport.iocl_v1.data.b) r0, (com.paytm.network.listener.b) r6)
            return
        L_0x0174:
            androidx.fragment.app.FragmentActivity r6 = r6.f14442f
            net.one97.paytm.transport.iocl_v1.activity.IOCLBaseActivity r6 = (net.one97.paytm.transport.iocl_v1.activity.IOCLBaseActivity) r6
            r6.f()
            return
        L_0x017c:
            androidx.fragment.app.FragmentActivity r7 = r6.f14442f
            if (r7 == 0) goto L_0x019a
            androidx.fragment.app.FragmentActivity r7 = r6.f14442f
            net.one97.paytm.transport.iocl_v1.activity.IOCLBaseActivity r7 = (net.one97.paytm.transport.iocl_v1.activity.IOCLBaseActivity) r7
            android.app.Application r1 = r6.getApplication()
            int r2 = net.one97.paytm.iocl.R.string.iocl_no_internet
            r1.getString(r2)
            android.app.Application r6 = r6.getApplication()
            int r1 = net.one97.paytm.iocl.R.string.iocl_no_connection
            java.lang.String r6 = r6.getString(r1)
            com.paytm.utility.b.a((android.content.Context) r7, (java.lang.String) r6, (boolean) r0)
        L_0x019a:
            return
        L_0x019b:
            net.one97.paytm.transport.iocl_v1.c.d r6 = r5.m
            if (r6 == 0) goto L_0x01a0
            goto L_0x01a1
        L_0x01a0:
            r7 = 0
        L_0x01a1:
            if (r7 == 0) goto L_0x01a8
            net.one97.paytm.transport.iocl_v1.a.e$a r6 = r6.o
            r6.a()
        L_0x01a8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.iocl.a.r.a(int, android.view.View):void");
    }
}
