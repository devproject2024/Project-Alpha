package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.hotel4.viewmodel.DetailsViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;

public final class av extends au implements b.a {
    private static final ViewDataBinding.b j = null;
    private static final SparseIntArray k;
    private final ConstraintLayout l;
    private final View.OnClickListener m;
    private long n;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        k = sparseIntArray;
        sparseIntArray.put(R.id.cardView, 5);
        k.put(R.id.linearLayout, 6);
        k.put(R.id.backBtn, 7);
        k.put(R.id.tv_header, 8);
    }

    public av(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 9, j, k));
    }

    private av(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[7], objArr[5], objArr[1], objArr[2], objArr[4], objArr[6], objArr[3], objArr[8]);
        this.n = -1;
        this.f29195c.setTag((Object) null);
        this.f29196d.setTag((Object) null);
        this.f29197e.setTag((Object) null);
        this.l = objArr[0];
        this.l.setTag((Object) null);
        this.f29199g.setTag((Object) null);
        setRootTag(view);
        this.m = new b(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.n = 16;
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
        if (a.t != i2) {
            return false;
        }
        a((DetailsViewModel) obj);
        return true;
    }

    public final void a(DetailsViewModel detailsViewModel) {
        this.f29201i = detailsViewModel;
        synchronized (this) {
            this.n |= 8;
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
        if (i2 != 2) {
            return false;
        }
        return d(i3);
    }

    private boolean b(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.n |= 1;
        }
        return true;
    }

    private boolean c(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.n |= 2;
        }
        return true;
    }

    private boolean d(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.n |= 4;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r20 = this;
            r1 = r20
            monitor-enter(r20)
            long r2 = r1.n     // Catch:{ all -> 0x00c5 }
            r4 = 0
            r1.n = r4     // Catch:{ all -> 0x00c5 }
            monitor-exit(r20)     // Catch:{ all -> 0x00c5 }
            net.one97.paytm.hotel4.viewmodel.DetailsViewModel r0 = r1.f29201i
            r6 = 31
            long r6 = r6 & r2
            r8 = 26
            r10 = 28
            r12 = 25
            r14 = 0
            r15 = 0
            int r16 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x008f
            long r6 = r2 & r12
            int r16 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x0035
            if (r0 == 0) goto L_0x0028
            androidx.lifecycle.y r6 = r0.get_name()
            goto L_0x0029
        L_0x0028:
            r6 = r15
        L_0x0029:
            r1.updateLiveDataRegistration(r14, r6)
            if (r6 == 0) goto L_0x0035
            java.lang.Object r6 = r6.getValue()
            java.lang.String r6 = (java.lang.String) r6
            goto L_0x0036
        L_0x0035:
            r6 = r15
        L_0x0036:
            long r16 = r2 & r8
            r7 = 1
            int r18 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r18 == 0) goto L_0x0053
            if (r0 == 0) goto L_0x0046
            androidx.lifecycle.y r16 = r0.get_fullAddress()
            r14 = r16
            goto L_0x0047
        L_0x0046:
            r14 = r15
        L_0x0047:
            r1.updateLiveDataRegistration(r7, r14)
            if (r14 == 0) goto L_0x0053
            java.lang.Object r14 = r14.getValue()
            java.lang.String r14 = (java.lang.String) r14
            goto L_0x0054
        L_0x0053:
            r14 = r15
        L_0x0054:
            long r17 = r2 & r10
            int r19 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r19 == 0) goto L_0x0091
            if (r0 == 0) goto L_0x0061
            androidx.lifecycle.y r0 = r0.get_streetAddress()
            goto L_0x0062
        L_0x0061:
            r0 = r15
        L_0x0062:
            r7 = 2
            r1.updateLiveDataRegistration(r7, r0)
            if (r0 == 0) goto L_0x006f
            java.lang.Object r0 = r0.getValue()
            r15 = r0
            java.lang.String r15 = (java.lang.String) r15
        L_0x006f:
            if (r15 == 0) goto L_0x0076
            int r0 = r15.length()
            goto L_0x0077
        L_0x0076:
            r0 = 0
        L_0x0077:
            if (r0 <= 0) goto L_0x007c
            r17 = 1
            goto L_0x007e
        L_0x007c:
            r17 = 0
        L_0x007e:
            if (r19 == 0) goto L_0x0089
            if (r17 == 0) goto L_0x0085
            r18 = 64
            goto L_0x0087
        L_0x0085:
            r18 = 32
        L_0x0087:
            long r2 = r2 | r18
        L_0x0089:
            if (r17 == 0) goto L_0x008c
            goto L_0x0091
        L_0x008c:
            r0 = 8
            goto L_0x0092
        L_0x008f:
            r6 = r15
            r14 = r6
        L_0x0091:
            r0 = 0
        L_0x0092:
            long r12 = r12 & r2
            int r7 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x009c
            android.widget.TextView r7 = r1.f29195c
            androidx.databinding.a.d.a((android.widget.TextView) r7, (java.lang.CharSequence) r6)
        L_0x009c:
            long r6 = r2 & r10
            int r10 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x00ac
            android.widget.TextView r6 = r1.f29196d
            r6.setVisibility(r0)
            android.widget.TextView r0 = r1.f29196d
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r15)
        L_0x00ac:
            r6 = 16
            long r6 = r6 & r2
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00ba
            android.widget.ImageView r0 = r1.f29197e
            android.view.View$OnClickListener r6 = r1.m
            r0.setOnClickListener(r6)
        L_0x00ba:
            long r2 = r2 & r8
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00c4
            android.widget.TextView r0 = r1.f29199g
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r14)
        L_0x00c4:
            return
        L_0x00c5:
            r0 = move-exception
            monitor-exit(r20)     // Catch:{ all -> 0x00c5 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotels2.b.av.executeBindings():void");
    }

    public final void a(int i2) {
        DetailsViewModel detailsViewModel = this.f29201i;
        if (detailsViewModel != null) {
            detailsViewModel.openGoogleMap();
        }
    }
}
