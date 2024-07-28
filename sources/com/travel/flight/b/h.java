package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.travel.flight.R;
import com.travel.flight.e.a.a;
import com.travel.flight.flightSRPV2.viewModel.NoFlightsFoundViewModel;

public final class h extends g implements a.C0456a {

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.b f23976e = null;

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f23977f;

    /* renamed from: g  reason: collision with root package name */
    private final LinearLayout f23978g;

    /* renamed from: h  reason: collision with root package name */
    private final View.OnClickListener f23979h;

    /* renamed from: i  reason: collision with root package name */
    private long f23980i;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f23977f = sparseIntArray;
        sparseIntArray.put(R.id.img_no_flight_available, 3);
    }

    public h(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, f23976e, f23977f));
    }

    private h(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[2], objArr[3], objArr[1]);
        this.f23980i = -1;
        this.f23972a.setTag((Object) null);
        this.f23978g = objArr[0];
        this.f23978g.setTag((Object) null);
        this.f23974c.setTag((Object) null);
        setRootTag(view);
        this.f23979h = new a(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f23980i = 8;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f23980i != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (com.travel.flight.a.f23479c != i2) {
            return false;
        }
        a((NoFlightsFoundViewModel) obj);
        return true;
    }

    public final void a(NoFlightsFoundViewModel noFlightsFoundViewModel) {
        this.f23975d = noFlightsFoundViewModel;
        synchronized (this) {
            this.f23980i |= 4;
        }
        notifyPropertyChanged(com.travel.flight.a.f23479c);
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
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.f23980i |= 1;
        }
        return true;
    }

    private boolean b(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.f23980i |= 2;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0038  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r14 = this;
            monitor-enter(r14)
            long r0 = r14.f23980i     // Catch:{ all -> 0x0072 }
            r2 = 0
            r14.f23980i = r2     // Catch:{ all -> 0x0072 }
            monitor-exit(r14)     // Catch:{ all -> 0x0072 }
            com.travel.flight.flightSRPV2.viewModel.NoFlightsFoundViewModel r4 = r14.f23975d
            r5 = 15
            long r5 = r5 & r0
            r7 = 14
            r9 = 13
            r11 = 0
            int r12 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r12 == 0) goto L_0x004e
            long r5 = r0 & r9
            int r12 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r12 == 0) goto L_0x0031
            if (r4 == 0) goto L_0x0023
            androidx.lifecycle.y r5 = r4.getActionText()
            goto L_0x0024
        L_0x0023:
            r5 = r11
        L_0x0024:
            r6 = 0
            r14.updateLiveDataRegistration(r6, r5)
            if (r5 == 0) goto L_0x0031
            java.lang.Object r5 = r5.getValue()
            java.lang.Integer r5 = (java.lang.Integer) r5
            goto L_0x0032
        L_0x0031:
            r5 = r11
        L_0x0032:
            long r12 = r0 & r7
            int r6 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r6 == 0) goto L_0x004f
            if (r4 == 0) goto L_0x003f
            androidx.lifecycle.y r4 = r4.getSubText()
            goto L_0x0040
        L_0x003f:
            r4 = r11
        L_0x0040:
            r6 = 1
            r14.updateLiveDataRegistration(r6, r4)
            if (r4 == 0) goto L_0x004f
            java.lang.Object r4 = r4.getValue()
            r11 = r4
            java.lang.Integer r11 = (java.lang.Integer) r11
            goto L_0x004f
        L_0x004e:
            r5 = r11
        L_0x004f:
            long r9 = r9 & r0
            int r4 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0059
            android.widget.Button r4 = r14.f23972a
            com.travel.flight.flightSRPV2.c.c.b((android.widget.TextView) r4, (java.lang.Integer) r5)
        L_0x0059:
            r4 = 8
            long r4 = r4 & r0
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 == 0) goto L_0x0067
            android.widget.Button r4 = r14.f23972a
            android.view.View$OnClickListener r5 = r14.f23979h
            r4.setOnClickListener(r5)
        L_0x0067:
            long r0 = r0 & r7
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0071
            android.widget.TextView r0 = r14.f23974c
            com.travel.flight.flightSRPV2.c.c.b((android.widget.TextView) r0, (java.lang.Integer) r11)
        L_0x0071:
            return
        L_0x0072:
            r0 = move-exception
            monitor-exit(r14)     // Catch:{ all -> 0x0072 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.b.h.executeBindings():void");
    }

    public final void a(int i2, View view) {
        NoFlightsFoundViewModel noFlightsFoundViewModel = this.f23975d;
        if (noFlightsFoundViewModel != null) {
            noFlightsFoundViewModel.onActionPerform();
        }
    }
}
