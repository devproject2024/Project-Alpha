package net.one97.paytm.addmoney.a;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.addmoneysource.a.e.a;

public final class x extends w {
    private static final ViewDataBinding.b o = null;
    private static final SparseIntArray p;
    private final RelativeLayout q;
    private long r;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p = sparseIntArray;
        sparseIntArray.put(R.id.text_view_layout, 5);
        p.put(R.id.two_mode_auth_layout, 6);
        p.put(R.id.rb_saved_card_atm_pin, 7);
        p.put(R.id.rb_saved_card_otp, 8);
        p.put(R.id.cvv_layout, 9);
        p.put(R.id.etCvv, 10);
        p.put(R.id.btnProceed, 11);
        p.put(R.id.rl_bank_icon, 12);
        p.put(R.id.iv_saved_card, 13);
    }

    public x(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 14, o, p));
    }

    private x(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[11], objArr[9], objArr[10], objArr[13], objArr[1], objArr[7], objArr[8], objArr[12], objArr[5], objArr[2], objArr[3], objArr[4], objArr[6]);
        this.r = -1;
        this.q = objArr[0];
        this.q.setTag((Object) null);
        this.f48117e.setTag((Object) null);
        this.j.setTag((Object) null);
        this.k.setTag((Object) null);
        this.l.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.r = 32;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.r != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (net.one97.paytm.addmoney.e.f48574e != i2) {
            return false;
        }
        a((a) obj);
        return true;
    }

    public final void a(a aVar) {
        this.n = aVar;
        synchronized (this) {
            this.r |= 16;
        }
        notifyPropertyChanged(net.one97.paytm.addmoney.e.f48574e);
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
        if (i2 != 3) {
            return false;
        }
        return d(i3);
    }

    private boolean a(int i2) {
        if (i2 != net.one97.paytm.addmoney.e.f48570a) {
            return false;
        }
        synchronized (this) {
            this.r |= 1;
        }
        return true;
    }

    private boolean b(int i2) {
        if (i2 != net.one97.paytm.addmoney.e.f48570a) {
            return false;
        }
        synchronized (this) {
            this.r |= 2;
        }
        return true;
    }

    private boolean c(int i2) {
        if (i2 != net.one97.paytm.addmoney.e.f48570a) {
            return false;
        }
        synchronized (this) {
            this.r |= 4;
        }
        return true;
    }

    private boolean d(int i2) {
        if (i2 != net.one97.paytm.addmoney.e.f48570a) {
            return false;
        }
        synchronized (this) {
            this.r |= 8;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r22 = this;
            r1 = r22
            monitor-enter(r22)
            long r2 = r1.r     // Catch:{ all -> 0x00b1 }
            r4 = 0
            r1.r = r4     // Catch:{ all -> 0x00b1 }
            monitor-exit(r22)     // Catch:{ all -> 0x00b1 }
            net.one97.paytm.addmoney.addmoneysource.a.e.a r0 = r1.n
            r6 = 63
            long r6 = r6 & r2
            r10 = 52
            r12 = 50
            r14 = 49
            r8 = 0
            int r18 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r18 == 0) goto L_0x0081
            long r6 = r2 & r14
            int r18 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r18 == 0) goto L_0x0030
            if (r0 == 0) goto L_0x0025
            androidx.databinding.ObservableBoolean r6 = r0.f48180c
            goto L_0x0026
        L_0x0025:
            r6 = 0
        L_0x0026:
            r1.updateRegistration((int) r8, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x0030
            boolean r6 = r6.get()
            goto L_0x0031
        L_0x0030:
            r6 = 0
        L_0x0031:
            long r18 = r2 & r12
            int r7 = (r18 > r4 ? 1 : (r18 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x004a
            if (r0 == 0) goto L_0x003c
            androidx.databinding.i<java.lang.String> r7 = r0.f48179b
            goto L_0x003d
        L_0x003c:
            r7 = 0
        L_0x003d:
            r8 = 1
            r1.updateRegistration((int) r8, (androidx.databinding.h) r7)
            if (r7 == 0) goto L_0x004a
            java.lang.Object r7 = r7.get()
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x004b
        L_0x004a:
            r7 = 0
        L_0x004b:
            long r19 = r2 & r10
            int r8 = (r19 > r4 ? 1 : (r19 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x0065
            if (r0 == 0) goto L_0x0056
            androidx.databinding.i<java.lang.String> r8 = r0.f48178a
            goto L_0x0057
        L_0x0056:
            r8 = 0
        L_0x0057:
            r9 = 2
            r1.updateRegistration((int) r9, (androidx.databinding.h) r8)
            if (r8 == 0) goto L_0x0065
            java.lang.Object r8 = r8.get()
            r9 = r8
            java.lang.String r9 = (java.lang.String) r9
            goto L_0x0066
        L_0x0065:
            r9 = 0
        L_0x0066:
            r16 = 56
            long r20 = r2 & r16
            int r8 = (r20 > r4 ? 1 : (r20 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x007f
            if (r0 == 0) goto L_0x0073
            androidx.databinding.ObservableInt r0 = r0.f48182e
            goto L_0x0074
        L_0x0073:
            r0 = 0
        L_0x0074:
            r8 = 3
            r1.updateRegistration((int) r8, (androidx.databinding.h) r0)
            if (r0 == 0) goto L_0x007f
            int r8 = r0.get()
            goto L_0x0085
        L_0x007f:
            r8 = 0
            goto L_0x0085
        L_0x0081:
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
        L_0x0085:
            long r14 = r14 & r2
            int r0 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x008f
            android.widget.RadioButton r0 = r1.f48117e
            androidx.databinding.a.a.a(r0, r6)
        L_0x008f:
            long r12 = r12 & r2
            int r0 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0099
            com.paytm.utility.RoboTextView r0 = r1.j
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r7)
        L_0x0099:
            long r6 = r2 & r10
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00a4
            com.paytm.utility.RoboTextView r0 = r1.k
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r9)
        L_0x00a4:
            r6 = 56
            long r2 = r2 & r6
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00b0
            com.paytm.utility.RoboTextView r0 = r1.l
            r0.setVisibility(r8)
        L_0x00b0:
            return
        L_0x00b1:
            r0 = move-exception
            monitor-exit(r22)     // Catch:{ all -> 0x00b1 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.addmoney.a.x.executeBindings():void");
    }
}
