package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.hotel4.service.model.ordersummary.CancelRefundData;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;

public final class h extends g {

    /* renamed from: h  reason: collision with root package name */
    private static final ViewDataBinding.b f29886h = null;

    /* renamed from: i  reason: collision with root package name */
    private static final SparseIntArray f29887i;
    private final LinearLayout j;
    private final TextView k;
    private final TextView l;
    private final TextView m;
    private long n;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f29887i = sparseIntArray;
        sparseIntArray.put(R.id.line_bottom, 6);
        f29887i.put(R.id.amount_paid, 7);
    }

    public h(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 8, f29886h, f29887i));
    }

    private h(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[7], objArr[6], objArr[1], objArr[4]);
        this.n = -1;
        this.j = objArr[0];
        this.j.setTag((Object) null);
        this.k = objArr[2];
        this.k.setTag((Object) null);
        this.l = objArr[3];
        this.l.setTag((Object) null);
        this.m = objArr[5];
        this.m.setTag((Object) null);
        this.f29791c.setTag((Object) null);
        this.f29792d.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.n = 8;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.n != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.D == i2) {
            a((CancelRefundData) obj);
        } else if (a.p == i2) {
            a((Boolean) obj);
        } else if (a.Z != i2) {
            return false;
        } else {
            a((String) obj);
        }
        return true;
    }

    public final void a(CancelRefundData cancelRefundData) {
        this.f29794f = cancelRefundData;
        synchronized (this) {
            this.n |= 1;
        }
        notifyPropertyChanged(a.D);
        super.requestRebind();
    }

    public final void a(Boolean bool) {
        this.f29795g = bool;
        synchronized (this) {
            this.n |= 2;
        }
        notifyPropertyChanged(a.p);
        super.requestRebind();
    }

    public final void a(String str) {
        this.f29793e = str;
        synchronized (this) {
            this.n |= 4;
        }
        notifyPropertyChanged(a.Z);
        super.requestRebind();
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r22 = this;
            r1 = r22
            monitor-enter(r22)
            long r2 = r1.n     // Catch:{ all -> 0x00b8 }
            r4 = 0
            r1.n = r4     // Catch:{ all -> 0x00b8 }
            monitor-exit(r22)     // Catch:{ all -> 0x00b8 }
            net.one97.paytm.hotel4.service.model.ordersummary.CancelRefundData r0 = r1.f29794f
            java.lang.Boolean r6 = r1.f29795g
            java.lang.String r7 = r1.f29793e
            r8 = 9
            long r10 = r2 & r8
            r12 = 0
            r13 = 0
            int r14 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x003c
            if (r0 == 0) goto L_0x0029
            java.lang.String r10 = r0.getTotalAmount()
            java.lang.String r11 = r0.getCancellationCharges()
            java.lang.String r14 = r0.getRefundAmount()
            goto L_0x002c
        L_0x0029:
            r10 = r12
            r11 = r10
            r14 = r11
        L_0x002c:
            if (r0 == 0) goto L_0x003c
            java.lang.String r12 = r0.getFormatedPrice(r10, r13)
            r10 = 1
            java.lang.String r10 = r0.getFormatedPrice(r11, r10)
            java.lang.String r0 = r0.getFormatedPrice(r14, r13)
            goto L_0x003e
        L_0x003c:
            r0 = r12
            r10 = r0
        L_0x003e:
            r14 = 10
            long r16 = r2 & r14
            int r18 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r18 == 0) goto L_0x005b
            boolean r6 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r6)
            if (r18 == 0) goto L_0x0055
            if (r6 == 0) goto L_0x0051
            r16 = 32
            goto L_0x0053
        L_0x0051:
            r16 = 16
        L_0x0053:
            long r2 = r2 | r16
        L_0x0055:
            if (r6 == 0) goto L_0x0058
            goto L_0x005b
        L_0x0058:
            r6 = 8
            goto L_0x005c
        L_0x005b:
            r6 = 0
        L_0x005c:
            r16 = 12
            long r18 = r2 & r16
            int r20 = (r18 > r4 ? 1 : (r18 == r4 ? 0 : -1))
            if (r20 == 0) goto L_0x0088
            if (r7 == 0) goto L_0x0077
            android.widget.TextView r11 = r1.m
            android.content.res.Resources r11 = r11.getResources()
            int r13 = net.one97.paytm.hotels2.R.string.h4_empty
            java.lang.String r11 = r11.getString(r13)
            boolean r13 = r7.equals(r11)
            goto L_0x0078
        L_0x0077:
            r13 = 0
        L_0x0078:
            if (r20 == 0) goto L_0x0083
            if (r13 == 0) goto L_0x007f
            r20 = 128(0x80, double:6.32E-322)
            goto L_0x0081
        L_0x007f:
            r20 = 64
        L_0x0081:
            long r2 = r2 | r20
        L_0x0083:
            if (r13 == 0) goto L_0x0088
            r13 = 8
            goto L_0x0089
        L_0x0088:
            r13 = 0
        L_0x0089:
            long r8 = r8 & r2
            int r11 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x009d
            android.widget.TextView r8 = r1.k
            androidx.databinding.a.d.a((android.widget.TextView) r8, (java.lang.CharSequence) r12)
            android.widget.TextView r8 = r1.l
            androidx.databinding.a.d.a((android.widget.TextView) r8, (java.lang.CharSequence) r10)
            android.widget.TextView r8 = r1.f29792d
            androidx.databinding.a.d.a((android.widget.TextView) r8, (java.lang.CharSequence) r0)
        L_0x009d:
            long r8 = r2 & r16
            int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00ad
            android.widget.TextView r0 = r1.m
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r7)
            android.widget.TextView r0 = r1.m
            r0.setVisibility(r13)
        L_0x00ad:
            long r2 = r2 & r14
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00b7
            android.widget.ImageView r0 = r1.f29791c
            r0.setVisibility(r6)
        L_0x00b7:
            return
        L_0x00b8:
            r0 = move-exception
            monitor-exit(r22)     // Catch:{ all -> 0x00b8 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotels2.b.h.executeBindings():void");
    }
}
