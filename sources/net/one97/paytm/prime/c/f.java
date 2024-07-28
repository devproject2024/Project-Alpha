package net.one97.paytm.prime.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import net.one97.paytm.prime.R;
import net.one97.paytm.prime.g.c;

public final class f extends e {

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.b f59770f = null;

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f59771g;

    /* renamed from: h  reason: collision with root package name */
    private final ScrollView f59772h;

    /* renamed from: i  reason: collision with root package name */
    private final TextView f59773i;
    private final TextView j;
    private final TextView k;
    private final TextView l;
    private final TextView m;
    private final TextView n;
    private a o;
    private b p;
    private long q;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f59771g = sparseIntArray;
        sparseIntArray.put(R.id.img_prime_bg, 8);
        f59771g.put(R.id.ll_join_now_container, 9);
        f59771g.put(R.id.txt_offer_detail_title, 10);
    }

    public f(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 11, f59770f, f59771g));
    }

    private f(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[4], objArr[8], objArr[9], objArr[10]);
        this.q = -1;
        this.f59765a.setTag((Object) null);
        this.f59772h = objArr[0];
        this.f59772h.setTag((Object) null);
        this.f59773i = objArr[1];
        this.f59773i.setTag((Object) null);
        this.j = objArr[2];
        this.j.setTag((Object) null);
        this.k = objArr[3];
        this.k.setTag((Object) null);
        this.l = objArr[5];
        this.l.setTag((Object) null);
        this.m = objArr[6];
        this.m.setTag((Object) null);
        this.n = objArr[7];
        this.n.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.q = 32;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.q != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (net.one97.paytm.prime.a.f59735b != i2) {
            return false;
        }
        a((c) obj);
        return true;
    }

    public final void a(c cVar) {
        updateRegistration(3, (h) cVar);
        this.f59769e = cVar;
        synchronized (this) {
            this.q |= 8;
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
            this.q |= 1;
        }
        return true;
    }

    private boolean b(int i2) {
        if (i2 != net.one97.paytm.prime.a.f59734a) {
            return false;
        }
        synchronized (this) {
            this.q |= 2;
        }
        return true;
    }

    private boolean c(int i2) {
        if (i2 != net.one97.paytm.prime.a.f59734a) {
            return false;
        }
        synchronized (this) {
            this.q |= 4;
        }
        return true;
    }

    private boolean d(int i2) {
        if (i2 != net.one97.paytm.prime.a.f59734a) {
            return false;
        }
        synchronized (this) {
            this.q |= 8;
        }
        return true;
    }

    private boolean e(int i2) {
        if (i2 != net.one97.paytm.prime.a.f59734a) {
            return false;
        }
        synchronized (this) {
            this.q |= 16;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00a7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r25 = this;
            r1 = r25
            monitor-enter(r25)
            long r2 = r1.q     // Catch:{ all -> 0x010a }
            r4 = 0
            r1.q = r4     // Catch:{ all -> 0x010a }
            monitor-exit(r25)     // Catch:{ all -> 0x010a }
            net.one97.paytm.prime.g.c r0 = r1.f59769e
            r6 = 63
            long r6 = r6 & r2
            r8 = 56
            r10 = 42
            r12 = 41
            r14 = 40
            r16 = 44
            r18 = 0
            int r19 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r19 == 0) goto L_0x00bf
            long r6 = r2 & r14
            int r19 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r19 == 0) goto L_0x004a
            if (r0 == 0) goto L_0x004a
            net.one97.paytm.prime.c.f$a r6 = r1.o
            if (r6 != 0) goto L_0x0032
            net.one97.paytm.prime.c.f$a r6 = new net.one97.paytm.prime.c.f$a
            r6.<init>()
            r1.o = r6
        L_0x0032:
            r6.f59774a = r0
            if (r0 != 0) goto L_0x0038
            r6 = r18
        L_0x0038:
            net.one97.paytm.prime.c.f$b r7 = r1.p
            if (r7 != 0) goto L_0x0043
            net.one97.paytm.prime.c.f$b r7 = new net.one97.paytm.prime.c.f$b
            r7.<init>()
            r1.p = r7
        L_0x0043:
            r7.f59775a = r0
            if (r0 != 0) goto L_0x004d
            r7 = r18
            goto L_0x004d
        L_0x004a:
            r6 = r18
            r7 = r6
        L_0x004d:
            long r19 = r2 & r12
            int r21 = (r19 > r4 ? 1 : (r19 == r4 ? 0 : -1))
            if (r21 == 0) goto L_0x0067
            if (r0 == 0) goto L_0x0058
            androidx.databinding.i<java.lang.String> r14 = r0.f59808d
            goto L_0x005a
        L_0x0058:
            r14 = r18
        L_0x005a:
            r15 = 0
            r1.updateRegistration((int) r15, (androidx.databinding.h) r14)
            if (r14 == 0) goto L_0x0067
            java.lang.Object r14 = r14.get()
            java.lang.String r14 = (java.lang.String) r14
            goto L_0x0069
        L_0x0067:
            r14 = r18
        L_0x0069:
            long r21 = r2 & r10
            int r15 = (r21 > r4 ? 1 : (r21 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x0083
            if (r0 == 0) goto L_0x0074
            androidx.databinding.i<java.lang.String> r15 = r0.f59806b
            goto L_0x0076
        L_0x0074:
            r15 = r18
        L_0x0076:
            r10 = 1
            r1.updateRegistration((int) r10, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x0083
            java.lang.Object r10 = r15.get()
            java.lang.String r10 = (java.lang.String) r10
            goto L_0x0085
        L_0x0083:
            r10 = r18
        L_0x0085:
            long r23 = r2 & r16
            int r11 = (r23 > r4 ? 1 : (r23 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x009f
            if (r0 == 0) goto L_0x0090
            androidx.databinding.i<java.lang.String> r11 = r0.f59810f
            goto L_0x0092
        L_0x0090:
            r11 = r18
        L_0x0092:
            r15 = 2
            r1.updateRegistration((int) r15, (androidx.databinding.h) r11)
            if (r11 == 0) goto L_0x009f
            java.lang.Object r11 = r11.get()
            java.lang.String r11 = (java.lang.String) r11
            goto L_0x00a1
        L_0x009f:
            r11 = r18
        L_0x00a1:
            long r23 = r2 & r8
            int r15 = (r23 > r4 ? 1 : (r23 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x00bc
            if (r0 == 0) goto L_0x00ac
            androidx.databinding.i<java.lang.String> r0 = r0.f59807c
            goto L_0x00ae
        L_0x00ac:
            r0 = r18
        L_0x00ae:
            r15 = 4
            r1.updateRegistration((int) r15, (androidx.databinding.h) r0)
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
            r11 = r10
            r14 = r11
        L_0x00c6:
            long r15 = r2 & r16
            int r17 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r17 == 0) goto L_0x00d1
            android.widget.TextView r15 = r1.f59765a
            androidx.databinding.a.d.a((android.widget.TextView) r15, (java.lang.CharSequence) r11)
        L_0x00d1:
            long r11 = r2 & r12
            int r13 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x00dc
            android.widget.TextView r11 = r1.f59773i
            androidx.databinding.a.d.a((android.widget.TextView) r11, (java.lang.CharSequence) r14)
        L_0x00dc:
            r11 = 40
            long r11 = r11 & r2
            int r13 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x00f2
            android.widget.TextView r11 = r1.j
            r11.setOnClickListener(r6)
            android.widget.TextView r6 = r1.k
            r6.setOnClickListener(r7)
            android.widget.TextView r6 = r1.n
            r6.setOnClickListener(r7)
        L_0x00f2:
            long r6 = r2 & r8
            int r8 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x00fd
            android.widget.TextView r6 = r1.l
            androidx.databinding.a.d.a((android.widget.TextView) r6, (java.lang.CharSequence) r0)
        L_0x00fd:
            r6 = 42
            long r2 = r2 & r6
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0109
            android.widget.TextView r0 = r1.m
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r10)
        L_0x0109:
            return
        L_0x010a:
            r0 = move-exception
            monitor-exit(r25)     // Catch:{ all -> 0x010a }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.prime.c.f.executeBindings():void");
    }

    public static class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        c f59774a;

        public final void onClick(View view) {
            this.f59774a.f59805a.c();
        }
    }

    public static class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        c f59775a;

        public final void onClick(View view) {
            this.f59775a.f59805a.b();
        }
    }
}
