package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.hotel4.viewmodel.filter.SRPFilterViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;

public final class er extends eq implements b.a {

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.b f29639e = null;

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f29640f;

    /* renamed from: g  reason: collision with root package name */
    private final ConstraintLayout f29641g;

    /* renamed from: h  reason: collision with root package name */
    private final TextView f29642h;

    /* renamed from: i  reason: collision with root package name */
    private final View.OnClickListener f29643i;
    private final View.OnClickListener j;
    private long k;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f29640f = sparseIntArray;
        sparseIntArray.put(R.id.textView2, 4);
    }

    public er(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 5, f29639e, f29640f));
    }

    private er(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[4], objArr[3]);
        this.k = -1;
        this.f29635a.setTag((Object) null);
        this.f29641g = objArr[0];
        this.f29641g.setTag((Object) null);
        this.f29642h = objArr[2];
        this.f29642h.setTag((Object) null);
        this.f29637c.setTag((Object) null);
        setRootTag(view);
        this.f29643i = new b(this, 1);
        this.j = new b(this, 2);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.k = 4;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.k != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.t != i2) {
            return false;
        }
        a((SRPFilterViewModel) obj);
        return true;
    }

    public final void a(SRPFilterViewModel sRPFilterViewModel) {
        this.f29638d = sRPFilterViewModel;
        synchronized (this) {
            this.k |= 2;
        }
        notifyPropertyChanged(a.t);
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
            this.k |= 1;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r18 = this;
            r1 = r18
            monitor-enter(r18)
            long r2 = r1.k     // Catch:{ all -> 0x00c7 }
            r4 = 0
            r1.k = r4     // Catch:{ all -> 0x00c7 }
            monitor-exit(r18)     // Catch:{ all -> 0x00c7 }
            net.one97.paytm.hotel4.viewmodel.filter.SRPFilterViewModel r0 = r1.f29638d
            r6 = 7
            long r8 = r2 & r6
            r10 = 256(0x100, double:1.265E-321)
            r12 = 1
            r13 = 0
            r14 = 0
            int r15 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x0056
            if (r0 == 0) goto L_0x0020
            com.travel.utils.l r0 = r0.getFilterCount()
            goto L_0x0021
        L_0x0020:
            r0 = r13
        L_0x0021:
            r1.updateLiveDataRegistration(r14, r0)
            if (r0 == 0) goto L_0x002d
            java.lang.Object r0 = r0.getValue()
            java.lang.Integer r0 = (java.lang.Integer) r0
            goto L_0x002e
        L_0x002d:
            r0 = r13
        L_0x002e:
            int r0 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Integer) r0)
            if (r0 <= 0) goto L_0x0036
            r8 = 1
            goto L_0x0037
        L_0x0036:
            r8 = 0
        L_0x0037:
            if (r15 == 0) goto L_0x004b
            if (r8 == 0) goto L_0x0042
            r15 = 64
            long r2 = r2 | r15
            long r2 = r2 | r10
            r15 = 1024(0x400, double:5.06E-321)
            goto L_0x004a
        L_0x0042:
            r15 = 32
            long r2 = r2 | r15
            r15 = 128(0x80, double:6.32E-322)
            long r2 = r2 | r15
            r15 = 512(0x200, double:2.53E-321)
        L_0x004a:
            long r2 = r2 | r15
        L_0x004b:
            if (r8 == 0) goto L_0x004f
            r9 = 0
            goto L_0x0050
        L_0x004f:
            r9 = 4
        L_0x0050:
            if (r8 == 0) goto L_0x0053
            goto L_0x0059
        L_0x0053:
            r15 = 8
            goto L_0x005a
        L_0x0056:
            r0 = 0
            r8 = 0
            r9 = 0
        L_0x0059:
            r15 = 0
        L_0x005a:
            long r10 = r10 & r2
            int r16 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x008a
            java.lang.String r10 = java.lang.String.valueOf(r0)
            if (r0 != r12) goto L_0x0066
            goto L_0x0067
        L_0x0066:
            r12 = 0
        L_0x0067:
            if (r16 == 0) goto L_0x0072
            if (r12 == 0) goto L_0x006e
            r16 = 16
            goto L_0x0070
        L_0x006e:
            r16 = 8
        L_0x0070:
            long r2 = r2 | r16
        L_0x0072:
            android.widget.TextView r0 = r1.f29637c
            android.content.res.Resources r0 = r0.getResources()
            if (r12 == 0) goto L_0x007d
            int r11 = net.one97.paytm.hotels2.R.string.hotels_msg_filter_applied
            goto L_0x007f
        L_0x007d:
            int r11 = net.one97.paytm.hotels2.R.string.hotels_msg_filters_applied
        L_0x007f:
            java.lang.String r0 = r0.getString(r11)
            if (r10 == 0) goto L_0x008a
            java.lang.String r0 = r10.concat(r0)
            goto L_0x008b
        L_0x008a:
            r0 = r13
        L_0x008b:
            long r6 = r6 & r2
            int r10 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x00a0
            if (r8 == 0) goto L_0x0093
            goto L_0x009f
        L_0x0093:
            android.widget.TextView r0 = r1.f29637c
            android.content.res.Resources r0 = r0.getResources()
            int r6 = net.one97.paytm.hotels2.R.string.h4_empty
            java.lang.String r0 = r0.getString(r6)
        L_0x009f:
            r13 = r0
        L_0x00a0:
            r6 = 4
            long r2 = r2 & r6
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00b5
            android.widget.ImageView r0 = r1.f29635a
            android.view.View$OnClickListener r2 = r1.f29643i
            r0.setOnClickListener(r2)
            android.widget.TextView r0 = r1.f29642h
            android.view.View$OnClickListener r2 = r1.j
            r0.setOnClickListener(r2)
        L_0x00b5:
            if (r10 == 0) goto L_0x00c6
            android.widget.TextView r0 = r1.f29642h
            r0.setVisibility(r9)
            android.widget.TextView r0 = r1.f29637c
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r13)
            android.widget.TextView r0 = r1.f29637c
            r0.setVisibility(r15)
        L_0x00c6:
            return
        L_0x00c7:
            r0 = move-exception
            monitor-exit(r18)     // Catch:{ all -> 0x00c7 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotels2.b.er.executeBindings():void");
    }

    public final void a(int i2) {
        boolean z = false;
        if (i2 == 1) {
            SRPFilterViewModel sRPFilterViewModel = this.f29638d;
            if (sRPFilterViewModel != null) {
                z = true;
            }
            if (z) {
                sRPFilterViewModel.onBackClick();
            }
        } else if (i2 == 2) {
            SRPFilterViewModel sRPFilterViewModel2 = this.f29638d;
            if (sRPFilterViewModel2 != null) {
                z = true;
            }
            if (z) {
                sRPFilterViewModel2.onClearAllClick();
            }
        }
    }
}
