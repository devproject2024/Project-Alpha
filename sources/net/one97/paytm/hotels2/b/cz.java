package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.hotel4.viewmodel.ReviewViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;

public final class cz extends cy {
    private static final ViewDataBinding.b n = null;
    private static final SparseIntArray o;
    private final ConstraintLayout p;
    private long q;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        o = sparseIntArray;
        sparseIntArray.put(R.id.tv_title, 5);
        o.put(R.id.ti_name, 6);
        o.put(R.id.ti_lname, 7);
        o.put(R.id.ti_email, 8);
        o.put(R.id.ti_mobile, 9);
        o.put(R.id.tet_prefix_mobile, 10);
        o.put(R.id.line5, 11);
        o.put(R.id.line_one, 12);
    }

    public cz(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 13, n, o));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private cz(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[11], objArr[12], objArr[3], objArr[2], objArr[4], objArr[1], objArr[10], objArr[8], objArr[7], objArr[9], objArr[6], objArr[5]);
        this.q = -1;
        this.p = objArr[0];
        this.p.setTag((Object) null);
        this.f29432c.setTag((Object) null);
        this.f29433d.setTag((Object) null);
        this.f29434e.setTag((Object) null);
        this.f29435f.setTag((Object) null);
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
        if (a.t != i2) {
            return false;
        }
        a((ReviewViewModel) obj);
        return true;
    }

    public final void a(ReviewViewModel reviewViewModel) {
        this.m = reviewViewModel;
        synchronized (this) {
            this.q |= 16;
        }
        notifyPropertyChanged(a.t);
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
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.q |= 1;
        }
        return true;
    }

    private boolean b(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.q |= 2;
        }
        return true;
    }

    private boolean c(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.q |= 4;
        }
        return true;
    }

    private boolean d(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.q |= 8;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r21 = this;
            r1 = r21
            monitor-enter(r21)
            long r2 = r1.q     // Catch:{ all -> 0x00c8 }
            r4 = 0
            r1.q = r4     // Catch:{ all -> 0x00c8 }
            monitor-exit(r21)     // Catch:{ all -> 0x00c8 }
            net.one97.paytm.hotel4.viewmodel.ReviewViewModel r0 = r1.m
            r6 = 63
            long r6 = r6 & r2
            r8 = 50
            r10 = 56
            r12 = 49
            r14 = 52
            r16 = 0
            int r17 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r17 == 0) goto L_0x0097
            long r6 = r2 & r12
            int r17 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r17 == 0) goto L_0x0039
            if (r0 == 0) goto L_0x002a
            androidx.lifecycle.y r6 = r0.get_userName()
            goto L_0x002c
        L_0x002a:
            r6 = r16
        L_0x002c:
            r7 = 0
            r1.updateLiveDataRegistration(r7, r6)
            if (r6 == 0) goto L_0x0039
            java.lang.Object r6 = r6.getValue()
            java.lang.String r6 = (java.lang.String) r6
            goto L_0x003b
        L_0x0039:
            r6 = r16
        L_0x003b:
            long r17 = r2 & r8
            int r7 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x0057
            if (r0 == 0) goto L_0x0048
            androidx.lifecycle.y r7 = r0.get_userMobile()
            goto L_0x004a
        L_0x0048:
            r7 = r16
        L_0x004a:
            r12 = 1
            r1.updateLiveDataRegistration(r12, r7)
            if (r7 == 0) goto L_0x0057
            java.lang.Object r7 = r7.getValue()
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x0059
        L_0x0057:
            r7 = r16
        L_0x0059:
            long r12 = r2 & r14
            int r19 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r19 == 0) goto L_0x0075
            if (r0 == 0) goto L_0x0066
            androidx.lifecycle.y r12 = r0.get_userEmail()
            goto L_0x0068
        L_0x0066:
            r12 = r16
        L_0x0068:
            r13 = 2
            r1.updateLiveDataRegistration(r13, r12)
            if (r12 == 0) goto L_0x0075
            java.lang.Object r12 = r12.getValue()
            java.lang.String r12 = (java.lang.String) r12
            goto L_0x0077
        L_0x0075:
            r12 = r16
        L_0x0077:
            long r19 = r2 & r10
            int r13 = (r19 > r4 ? 1 : (r19 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x0094
            if (r0 == 0) goto L_0x0084
            androidx.lifecycle.y r0 = r0.get_userLName()
            goto L_0x0086
        L_0x0084:
            r0 = r16
        L_0x0086:
            r13 = 3
            r1.updateLiveDataRegistration(r13, r0)
            if (r0 == 0) goto L_0x0094
            java.lang.Object r0 = r0.getValue()
            r16 = r0
            java.lang.String r16 = (java.lang.String) r16
        L_0x0094:
            r0 = r16
            goto L_0x009c
        L_0x0097:
            r0 = r16
            r6 = r0
            r7 = r6
            r12 = r7
        L_0x009c:
            long r13 = r2 & r14
            int r15 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x00a7
            android.widget.EditText r13 = r1.f29432c
            androidx.databinding.a.d.a((android.widget.TextView) r13, (java.lang.CharSequence) r12)
        L_0x00a7:
            long r10 = r10 & r2
            int r12 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x00b1
            android.widget.EditText r10 = r1.f29433d
            androidx.databinding.a.d.a((android.widget.TextView) r10, (java.lang.CharSequence) r0)
        L_0x00b1:
            long r8 = r8 & r2
            int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00bb
            android.widget.EditText r0 = r1.f29434e
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r7)
        L_0x00bb:
            r7 = 49
            long r2 = r2 & r7
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00c7
            android.widget.EditText r0 = r1.f29435f
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r6)
        L_0x00c7:
            return
        L_0x00c8:
            r0 = move-exception
            monitor-exit(r21)     // Catch:{ all -> 0x00c8 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotels2.b.cz.executeBindings():void");
    }
}
