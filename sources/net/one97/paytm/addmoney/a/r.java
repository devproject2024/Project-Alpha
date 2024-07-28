package net.one97.paytm.addmoney.a;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.cvvHelp.d.a;

public final class r extends q {

    /* renamed from: g  reason: collision with root package name */
    private static final ViewDataBinding.b f48096g = null;

    /* renamed from: h  reason: collision with root package name */
    private static final SparseIntArray f48097h;

    /* renamed from: i  reason: collision with root package name */
    private final RelativeLayout f48098i;
    private long j;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f48097h = sparseIntArray;
        sparseIntArray.put(R.id.crossIV, 3);
        f48097h.put(R.id.iv_card_logo, 4);
        f48097h.put(R.id.btn_proceed, 5);
    }

    public r(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 6, f48096g, f48097h));
    }

    private r(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[5], objArr[3], objArr[4], objArr[1], objArr[2]);
        this.j = -1;
        this.f48098i = objArr[0];
        this.f48098i.setTag((Object) null);
        this.f48093d.setTag((Object) null);
        this.f48094e.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.j = 8;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.j != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (net.one97.paytm.addmoney.e.f48576g != i2) {
            return false;
        }
        a((a) obj);
        return true;
    }

    public final void a(a aVar) {
        this.f48095f = aVar;
        synchronized (this) {
            this.j |= 4;
        }
        notifyPropertyChanged(net.one97.paytm.addmoney.e.f48576g);
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
        if (i2 != net.one97.paytm.addmoney.e.f48570a) {
            return false;
        }
        synchronized (this) {
            this.j |= 1;
        }
        return true;
    }

    private boolean b(int i2) {
        if (i2 != net.one97.paytm.addmoney.e.f48570a) {
            return false;
        }
        synchronized (this) {
            this.j |= 2;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0036  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r14 = this;
            monitor-enter(r14)
            long r0 = r14.j     // Catch:{ all -> 0x0060 }
            r2 = 0
            r14.j = r2     // Catch:{ all -> 0x0060 }
            monitor-exit(r14)     // Catch:{ all -> 0x0060 }
            net.one97.paytm.addmoney.cvvHelp.d.a r4 = r14.f48095f
            r5 = 15
            long r5 = r5 & r0
            r7 = 13
            r9 = 14
            r11 = 0
            int r12 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r12 == 0) goto L_0x004a
            long r5 = r0 & r7
            int r12 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r12 == 0) goto L_0x002f
            if (r4 == 0) goto L_0x0021
            androidx.databinding.i<java.lang.String> r5 = r4.f48560b
            goto L_0x0022
        L_0x0021:
            r5 = r11
        L_0x0022:
            r6 = 0
            r14.updateRegistration((int) r6, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x002f
            java.lang.Object r5 = r5.get()
            java.lang.String r5 = (java.lang.String) r5
            goto L_0x0030
        L_0x002f:
            r5 = r11
        L_0x0030:
            long r12 = r0 & r9
            int r6 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r6 == 0) goto L_0x004b
            if (r4 == 0) goto L_0x003b
            androidx.databinding.i<java.lang.String> r4 = r4.f48559a
            goto L_0x003c
        L_0x003b:
            r4 = r11
        L_0x003c:
            r6 = 1
            r14.updateRegistration((int) r6, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x004b
            java.lang.Object r4 = r4.get()
            r11 = r4
            java.lang.String r11 = (java.lang.String) r11
            goto L_0x004b
        L_0x004a:
            r5 = r11
        L_0x004b:
            long r9 = r9 & r0
            int r4 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0055
            android.widget.TextView r4 = r14.f48093d
            androidx.databinding.a.d.a((android.widget.TextView) r4, (java.lang.CharSequence) r11)
        L_0x0055:
            long r0 = r0 & r7
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x005f
            com.paytm.utility.RoboTextView r0 = r14.f48094e
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r5)
        L_0x005f:
            return
        L_0x0060:
            r0 = move-exception
            monitor-exit(r14)     // Catch:{ all -> 0x0060 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.addmoney.a.r.executeBindings():void");
    }
}
