package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.hotel4.viewmodel.filter.SRPFilterViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;

public final class ap extends ao implements b.a {

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.b f29172e = null;

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f29173f;

    /* renamed from: g  reason: collision with root package name */
    private final ConstraintLayout f29174g;

    /* renamed from: h  reason: collision with root package name */
    private final View.OnClickListener f29175h;

    /* renamed from: i  reason: collision with root package name */
    private long f29176i;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f29173f = sparseIntArray;
        sparseIntArray.put(R.id.right_arrow, 3);
    }

    public ap(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, f29172e, f29173f));
    }

    private ap(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[2], objArr[3], objArr[1]);
        this.f29176i = -1;
        this.f29168a.setTag((Object) null);
        this.f29174g = objArr[0];
        this.f29174g.setTag((Object) null);
        this.f29170c.setTag((Object) null);
        setRootTag(view);
        this.f29175h = new b(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f29176i = 4;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f29176i != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.f29088c != i2) {
            return false;
        }
        a((SRPFilterViewModel) obj);
        return true;
    }

    public final void a(SRPFilterViewModel sRPFilterViewModel) {
        this.f29171d = sRPFilterViewModel;
        synchronized (this) {
            this.f29176i |= 2;
        }
        notifyPropertyChanged(a.f29088c);
        super.requestRebind();
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return b(i3);
    }

    private boolean b(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.f29176i |= 1;
        }
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v2, resolved type: java.lang.Integer} */
    /* JADX WARNING: type inference failed for: r12v0 */
    /* JADX WARNING: type inference failed for: r12v1, types: [java.lang.CharSequence] */
    /* JADX WARNING: type inference failed for: r12v3, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r12v6 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r15 = this;
            monitor-enter(r15)
            long r0 = r15.f29176i     // Catch:{ all -> 0x0081 }
            r2 = 0
            r15.f29176i = r2     // Catch:{ all -> 0x0081 }
            monitor-exit(r15)     // Catch:{ all -> 0x0081 }
            net.one97.paytm.hotel4.viewmodel.filter.SRPFilterViewModel r4 = r15.f29171d
            r5 = 7
            long r7 = r0 & r5
            r9 = 6
            r11 = 0
            r12 = 0
            int r13 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r13 == 0) goto L_0x0057
            long r7 = r0 & r9
            int r14 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r14 == 0) goto L_0x0023
            if (r4 == 0) goto L_0x0023
            java.lang.String r7 = r4.getFilterLocalityTitle()
            goto L_0x0024
        L_0x0023:
            r7 = r12
        L_0x0024:
            if (r4 == 0) goto L_0x002b
            androidx.lifecycle.y r4 = r4.getFilterCountLocality()
            goto L_0x002c
        L_0x002b:
            r4 = r12
        L_0x002c:
            r15.updateLiveDataRegistration(r11, r4)
            if (r4 == 0) goto L_0x0038
            java.lang.Object r4 = r4.getValue()
            r12 = r4
            java.lang.Integer r12 = (java.lang.Integer) r12
        L_0x0038:
            int r4 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Integer) r12)
            if (r4 <= 0) goto L_0x0040
            r8 = 1
            goto L_0x0041
        L_0x0040:
            r8 = 0
        L_0x0041:
            java.lang.String r12 = java.lang.String.valueOf(r4)
            if (r13 == 0) goto L_0x004f
            if (r8 == 0) goto L_0x004c
            r13 = 16
            goto L_0x004e
        L_0x004c:
            r13 = 8
        L_0x004e:
            long r0 = r0 | r13
        L_0x004f:
            if (r8 == 0) goto L_0x0052
            goto L_0x0058
        L_0x0052:
            r4 = 8
            r11 = 8
            goto L_0x0058
        L_0x0057:
            r7 = r12
        L_0x0058:
            long r4 = r0 & r5
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 == 0) goto L_0x0068
            android.widget.TextView r4 = r15.f29168a
            androidx.databinding.a.d.a((android.widget.TextView) r4, (java.lang.CharSequence) r12)
            android.widget.TextView r4 = r15.f29168a
            r4.setVisibility(r11)
        L_0x0068:
            r4 = 4
            long r4 = r4 & r0
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 == 0) goto L_0x0076
            androidx.constraintlayout.widget.ConstraintLayout r4 = r15.f29174g
            android.view.View$OnClickListener r5 = r15.f29175h
            r4.setOnClickListener(r5)
        L_0x0076:
            long r0 = r0 & r9
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0080
            android.widget.TextView r0 = r15.f29170c
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r7)
        L_0x0080:
            return
        L_0x0081:
            r0 = move-exception
            monitor-exit(r15)     // Catch:{ all -> 0x0081 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotels2.b.ap.executeBindings():void");
    }

    public final void a(int i2) {
        SRPFilterViewModel sRPFilterViewModel = this.f29171d;
        if (sRPFilterViewModel != null) {
            sRPFilterViewModel.onScreenClick(sRPFilterViewModel.getFilterLocalityTitle());
        }
    }
}
