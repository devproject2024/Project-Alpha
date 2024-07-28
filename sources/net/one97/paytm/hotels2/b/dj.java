package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.hotel4.viewmodel.ReviewViewModel;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;

public final class dj extends di implements b.a {

    /* renamed from: d  reason: collision with root package name */
    private static final ViewDataBinding.b f29477d = null;

    /* renamed from: e  reason: collision with root package name */
    private static final SparseIntArray f29478e = null;

    /* renamed from: f  reason: collision with root package name */
    private final ConstraintLayout f29479f;

    /* renamed from: g  reason: collision with root package name */
    private final TextView f29480g;

    /* renamed from: h  reason: collision with root package name */
    private final View.OnClickListener f29481h;

    /* renamed from: i  reason: collision with root package name */
    private long f29482i;

    public dj(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, f29477d, f29478e));
    }

    private dj(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[3]);
        this.f29482i = -1;
        this.f29479f = objArr[0];
        this.f29479f.setTag((Object) null);
        this.f29480g = objArr[2];
        this.f29480g.setTag((Object) null);
        this.f29474a.setTag((Object) null);
        this.f29475b.setTag((Object) null);
        setRootTag(view);
        this.f29481h = new b(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f29482i = 32;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f29482i != 0) {
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
        this.f29476c = reviewViewModel;
        synchronized (this) {
            this.f29482i |= 16;
        }
        notifyPropertyChanged(a.t);
        super.requestRebind();
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return b(i3);
        }
        if (i2 == 1) {
            return c(i3);
        }
        if (i2 == 2) {
            return d(i3);
        }
        if (i2 != 3) {
            return false;
        }
        return e(i3);
    }

    private boolean b(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.f29482i |= 1;
        }
        return true;
    }

    private boolean c(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.f29482i |= 2;
        }
        return true;
    }

    private boolean d(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.f29482i |= 4;
        }
        return true;
    }

    private boolean e(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.f29482i |= 8;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r21 = this;
            r1 = r21
            monitor-enter(r21)
            long r2 = r1.f29482i     // Catch:{ all -> 0x010c }
            r4 = 0
            r1.f29482i = r4     // Catch:{ all -> 0x010c }
            monitor-exit(r21)     // Catch:{ all -> 0x010c }
            net.one97.paytm.hotel4.viewmodel.ReviewViewModel r0 = r1.f29476c
            r6 = 63
            long r6 = r6 & r2
            r10 = 52
            r12 = 50
            r14 = 49
            r8 = 0
            int r16 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x00cc
            long r6 = r2 & r14
            int r16 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x0034
            if (r0 == 0) goto L_0x0027
            androidx.lifecycle.y r6 = r0.get_promoCodeApplyCode()
            goto L_0x0028
        L_0x0027:
            r6 = 0
        L_0x0028:
            r1.updateLiveDataRegistration(r8, r6)
            if (r6 == 0) goto L_0x0034
            java.lang.Object r6 = r6.getValue()
            java.lang.String r6 = (java.lang.String) r6
            goto L_0x0035
        L_0x0034:
            r6 = 0
        L_0x0035:
            long r16 = r2 & r12
            int r7 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x0050
            if (r0 == 0) goto L_0x0042
            androidx.lifecycle.y r7 = r0.get_promoCodeApplyText()
            goto L_0x0043
        L_0x0042:
            r7 = 0
        L_0x0043:
            r8 = 1
            r1.updateLiveDataRegistration(r8, r7)
            if (r7 == 0) goto L_0x0050
            java.lang.Object r7 = r7.getValue()
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x0051
        L_0x0050:
            r7 = 0
        L_0x0051:
            long r17 = r2 & r10
            int r8 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x0088
            if (r0 == 0) goto L_0x0060
            androidx.lifecycle.y r17 = r0.get_promoCodeApplyCashBackVisibility()
            r9 = r17
            goto L_0x0061
        L_0x0060:
            r9 = 0
        L_0x0061:
            r12 = 2
            r1.updateLiveDataRegistration(r12, r9)
            if (r9 == 0) goto L_0x006e
            java.lang.Object r9 = r9.getValue()
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            goto L_0x006f
        L_0x006e:
            r9 = 0
        L_0x006f:
            boolean r9 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r9)
            if (r8 == 0) goto L_0x007d
            if (r9 == 0) goto L_0x007a
            r12 = 128(0x80, double:6.32E-322)
            goto L_0x007c
        L_0x007a:
            r12 = 64
        L_0x007c:
            long r2 = r2 | r12
        L_0x007d:
            if (r9 == 0) goto L_0x0082
            r16 = 0
            goto L_0x0085
        L_0x0082:
            r8 = 4
            r16 = 4
        L_0x0085:
            r8 = r16
            goto L_0x0089
        L_0x0088:
            r8 = 0
        L_0x0089:
            r12 = 56
            long r19 = r2 & r12
            int r9 = (r19 > r4 ? 1 : (r19 == r4 ? 0 : -1))
            if (r9 == 0) goto L_0x00cf
            if (r0 == 0) goto L_0x0098
            androidx.lifecycle.y r9 = r0.get_promoCodeApplyCashBack()
            goto L_0x0099
        L_0x0098:
            r9 = 0
        L_0x0099:
            r0 = 3
            r1.updateLiveDataRegistration(r0, r9)
            if (r9 == 0) goto L_0x00a7
            java.lang.Object r0 = r9.getValue()
            r9 = r0
            java.lang.String r9 = (java.lang.String) r9
            goto L_0x00a8
        L_0x00a7:
            r9 = 0
        L_0x00a8:
            if (r9 == 0) goto L_0x00af
            java.lang.String r9 = r9.toString()
            goto L_0x00b0
        L_0x00af:
            r9 = 0
        L_0x00b0:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            android.widget.TextView r12 = r1.f29474a
            android.content.res.Resources r12 = r12.getResources()
            int r13 = net.one97.paytm.hotels2.R.string.h4_hotels_rupees
            java.lang.String r12 = r12.getString(r13)
            r0.append(r12)
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            goto L_0x00d0
        L_0x00cc:
            r6 = 0
            r7 = 0
            r8 = 0
        L_0x00cf:
            r9 = 0
        L_0x00d0:
            r12 = 32
            long r12 = r12 & r2
            int r0 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00de
            android.widget.TextView r0 = r1.f29480g
            android.view.View$OnClickListener r12 = r1.f29481h
            r0.setOnClickListener(r12)
        L_0x00de:
            long r12 = r2 & r14
            int r0 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00e9
            android.widget.TextView r0 = r1.f29480g
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r6)
        L_0x00e9:
            long r10 = r10 & r2
            int r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00f3
            android.widget.TextView r0 = r1.f29474a
            r0.setVisibility(r8)
        L_0x00f3:
            r10 = 56
            long r10 = r10 & r2
            int r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00ff
            android.widget.TextView r0 = r1.f29474a
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r9)
        L_0x00ff:
            r8 = 50
            long r2 = r2 & r8
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x010b
            android.widget.TextView r0 = r1.f29475b
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r7)
        L_0x010b:
            return
        L_0x010c:
            r0 = move-exception
            monitor-exit(r21)     // Catch:{ all -> 0x010c }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotels2.b.dj.executeBindings():void");
    }

    public final void a(int i2) {
        ReviewViewModel reviewViewModel = this.f29476c;
        if (reviewViewModel != null) {
            reviewViewModel.onClearPromoCodePressed();
        }
    }
}
