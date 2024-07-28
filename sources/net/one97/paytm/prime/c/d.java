package net.one97.paytm.prime.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import net.one97.paytm.prime.R;

public final class d extends c {

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.b f59759f = null;

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f59760g;

    /* renamed from: h  reason: collision with root package name */
    private final ScrollView f59761h;

    /* renamed from: i  reason: collision with root package name */
    private final TextView f59762i;
    private final TextView j;
    private final TextView k;
    private final TextView l;
    private final TextView m;
    private a n;
    private b o;
    private long p;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f59760g = sparseIntArray;
        sparseIntArray.put(R.id.img_prime_bg, 7);
        f59760g.put(R.id.ll_join_now_container, 8);
        f59760g.put(R.id.txt_offer_detail_title, 9);
    }

    public d(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 10, f59759f, f59760g));
    }

    private d(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[3], objArr[7], objArr[8], objArr[9]);
        this.p = -1;
        this.f59754a.setTag((Object) null);
        this.f59761h = objArr[0];
        this.f59761h.setTag((Object) null);
        this.f59762i = objArr[1];
        this.f59762i.setTag((Object) null);
        this.j = objArr[2];
        this.j.setTag((Object) null);
        this.k = objArr[4];
        this.k.setTag((Object) null);
        this.l = objArr[5];
        this.l.setTag((Object) null);
        this.m = objArr[6];
        this.m.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.p = 32;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.p != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (net.one97.paytm.prime.a.f59735b != i2) {
            return false;
        }
        a((net.one97.paytm.prime.g.b) obj);
        return true;
    }

    public final void a(net.one97.paytm.prime.g.b bVar) {
        updateRegistration(3, (h) bVar);
        this.f59758e = bVar;
        synchronized (this) {
            this.p |= 8;
        }
        notifyPropertyChanged(net.one97.paytm.prime.a.f59735b);
        super.requestRebind();
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return a(i3);
        }
        if (i2 == 1) {
            return b(i3);
        }
        if (i2 == 2) {
            return c(i3);
        }
        if (i2 == 3) {
            return d(i3);
        }
        if (i2 != 4) {
            return false;
        }
        return e(i3);
    }

    private boolean a(int i2) {
        if (i2 != net.one97.paytm.prime.a.f59734a) {
            return false;
        }
        synchronized (this) {
            this.p |= 1;
        }
        return true;
    }

    private boolean b(int i2) {
        if (i2 != net.one97.paytm.prime.a.f59734a) {
            return false;
        }
        synchronized (this) {
            this.p |= 2;
        }
        return true;
    }

    private boolean c(int i2) {
        if (i2 != net.one97.paytm.prime.a.f59734a) {
            return false;
        }
        synchronized (this) {
            this.p |= 4;
        }
        return true;
    }

    private boolean d(int i2) {
        if (i2 != net.one97.paytm.prime.a.f59734a) {
            return false;
        }
        synchronized (this) {
            this.p |= 8;
        }
        return true;
    }

    private boolean e(int i2) {
        if (i2 != net.one97.paytm.prime.a.f59734a) {
            return false;
        }
        synchronized (this) {
            this.p |= 16;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0079 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00a7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r25 = this;
            r1 = r25
            monitor-enter(r25)
            long r2 = r1.p     // Catch:{ all -> 0x0104 }
            r4 = 0
            r1.p = r4     // Catch:{ all -> 0x0104 }
            monitor-exit(r25)     // Catch:{ all -> 0x0104 }
            net.one97.paytm.prime.g.b r0 = r1.f59758e
            r6 = 63
            long r6 = r6 & r2
            r8 = 56
            r10 = 40
            r12 = 42
            r14 = 41
            r16 = 44
            r18 = 0
            int r19 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r19 == 0) goto L_0x00bf
            long r6 = r2 & r14
            int r19 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r19 == 0) goto L_0x0039
            if (r0 == 0) goto L_0x002a
            androidx.databinding.i<java.lang.String> r6 = r0.f59801d
            goto L_0x002c
        L_0x002a:
            r6 = r18
        L_0x002c:
            r7 = 0
            r1.updateRegistration((int) r7, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x0039
            java.lang.Object r6 = r6.get()
            java.lang.String r6 = (java.lang.String) r6
            goto L_0x003b
        L_0x0039:
            r6 = r18
        L_0x003b:
            long r19 = r2 & r12
            int r7 = (r19 > r4 ? 1 : (r19 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x0055
            if (r0 == 0) goto L_0x0046
            androidx.databinding.i<java.lang.String> r7 = r0.f59799b
            goto L_0x0048
        L_0x0046:
            r7 = r18
        L_0x0048:
            r12 = 1
            r1.updateRegistration((int) r12, (androidx.databinding.h) r7)
            if (r7 == 0) goto L_0x0055
            java.lang.Object r7 = r7.get()
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x0057
        L_0x0055:
            r7 = r18
        L_0x0057:
            long r12 = r2 & r16
            int r21 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r21 == 0) goto L_0x0071
            if (r0 == 0) goto L_0x0062
            androidx.databinding.i<java.lang.String> r12 = r0.f59803f
            goto L_0x0064
        L_0x0062:
            r12 = r18
        L_0x0064:
            r13 = 2
            r1.updateRegistration((int) r13, (androidx.databinding.h) r12)
            if (r12 == 0) goto L_0x0071
            java.lang.Object r12 = r12.get()
            java.lang.String r12 = (java.lang.String) r12
            goto L_0x0073
        L_0x0071:
            r12 = r18
        L_0x0073:
            long r21 = r2 & r10
            int r13 = (r21 > r4 ? 1 : (r21 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x009e
            if (r0 == 0) goto L_0x009e
            net.one97.paytm.prime.c.d$a r13 = r1.n
            if (r13 != 0) goto L_0x0086
            net.one97.paytm.prime.c.d$a r13 = new net.one97.paytm.prime.c.d$a
            r13.<init>()
            r1.n = r13
        L_0x0086:
            r13.f59763a = r0
            if (r0 != 0) goto L_0x008c
            r13 = r18
        L_0x008c:
            net.one97.paytm.prime.c.d$b r10 = r1.o
            if (r10 != 0) goto L_0x0097
            net.one97.paytm.prime.c.d$b r10 = new net.one97.paytm.prime.c.d$b
            r10.<init>()
            r1.o = r10
        L_0x0097:
            r10.f59764a = r0
            if (r0 != 0) goto L_0x00a1
            r10 = r18
            goto L_0x00a1
        L_0x009e:
            r10 = r18
            r13 = r10
        L_0x00a1:
            long r23 = r2 & r8
            int r11 = (r23 > r4 ? 1 : (r23 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x00bc
            if (r0 == 0) goto L_0x00ac
            androidx.databinding.i<java.lang.String> r0 = r0.f59800c
            goto L_0x00ae
        L_0x00ac:
            r0 = r18
        L_0x00ae:
            r11 = 4
            r1.updateRegistration((int) r11, (androidx.databinding.h) r0)
            if (r0 == 0) goto L_0x00bc
            java.lang.Object r0 = r0.get()
            r18 = r0
            java.lang.String r18 = (java.lang.String) r18
        L_0x00bc:
            r0 = r18
            goto L_0x00c6
        L_0x00bf:
            r0 = r18
            r6 = r0
            r7 = r6
            r10 = r7
            r12 = r10
            r13 = r12
        L_0x00c6:
            long r16 = r2 & r16
            int r11 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x00d1
            android.widget.TextView r11 = r1.f59754a
            androidx.databinding.a.d.a((android.widget.TextView) r11, (java.lang.CharSequence) r12)
        L_0x00d1:
            long r11 = r2 & r14
            int r14 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x00dc
            android.widget.TextView r11 = r1.f59762i
            androidx.databinding.a.d.a((android.widget.TextView) r11, (java.lang.CharSequence) r6)
        L_0x00dc:
            r11 = 40
            long r11 = r11 & r2
            int r6 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x00ed
            android.widget.TextView r6 = r1.j
            r6.setOnClickListener(r13)
            android.widget.TextView r6 = r1.m
            r6.setOnClickListener(r10)
        L_0x00ed:
            long r8 = r8 & r2
            int r6 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x00f7
            android.widget.TextView r6 = r1.k
            androidx.databinding.a.d.a((android.widget.TextView) r6, (java.lang.CharSequence) r0)
        L_0x00f7:
            r8 = 42
            long r2 = r2 & r8
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0103
            android.widget.TextView r0 = r1.l
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r7)
        L_0x0103:
            return
        L_0x0104:
            r0 = move-exception
            monitor-exit(r25)     // Catch:{ all -> 0x0104 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.prime.c.d.executeBindings():void");
    }

    public static class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        net.one97.paytm.prime.g.b f59763a;

        public final void onClick(View view) {
            this.f59763a.f59798a.a();
        }
    }

    public static class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        net.one97.paytm.prime.g.b f59764a;

        public final void onClick(View view) {
            this.f59764a.f59798a.b();
        }
    }
}
