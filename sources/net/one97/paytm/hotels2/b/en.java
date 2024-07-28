package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.hotel4.viewmodel.SRPViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;

public final class en extends em implements b.a {
    private static final ViewDataBinding.b t = null;
    private static final SparseIntArray u;
    private final ConstraintLayout v;
    private final View.OnClickListener w;
    private final View.OnClickListener x;
    private final View.OnClickListener y;
    private long z;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        u = sparseIntArray;
        sparseIntArray.put(R.id.ll_txt_sort_header, 7);
        u.put(R.id.ic_txt_sort_header, 8);
        u.put(R.id.txt_sort_header, 9);
        u.put(R.id.dot_txt_sort_header, 10);
        u.put(R.id.sort_divider, 11);
        u.put(R.id.ll_txt_filter_header, 12);
        u.put(R.id.ic_txt_filter_header, 13);
        u.put(R.id.txt_filter_header, 14);
        u.put(R.id.filter_divider, 15);
        u.put(R.id.ll_txt_map_header, 16);
        u.put(R.id.ic_txt_map_header, 17);
        u.put(R.id.txt_map_header, 18);
    }

    public en(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 19, t, u));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private en(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[5], objArr[10], objArr[15], objArr[3], objArr[13], objArr[17], objArr[8], objArr[12], objArr[16], objArr[7], objArr[6], objArr[11], objArr[1], objArr[14], objArr[4], objArr[18], objArr[9], objArr[2]);
        this.z = -1;
        this.f29617a.setTag((Object) null);
        this.f29620d.setTag((Object) null);
        this.k.setTag((Object) null);
        this.v = objArr[0];
        this.v.setTag((Object) null);
        this.m.setTag((Object) null);
        this.o.setTag((Object) null);
        this.r.setTag((Object) null);
        setRootTag(view);
        this.w = new b(this, 3);
        this.x = new b(this, 1);
        this.y = new b(this, 2);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.z = 16;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.z != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.X != i2) {
            return false;
        }
        a((SRPViewModel) obj);
        return true;
    }

    public final void a(SRPViewModel sRPViewModel) {
        this.s = sRPViewModel;
        synchronized (this) {
            this.z |= 8;
        }
        notifyPropertyChanged(a.X);
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
            this.z |= 1;
        }
        return true;
    }

    private boolean c(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.z |= 2;
        }
        return true;
    }

    private boolean d(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.z |= 4;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r20 = this;
            r1 = r20
            monitor-enter(r20)
            long r2 = r1.z     // Catch:{ all -> 0x00e0 }
            r4 = 0
            r1.z = r4     // Catch:{ all -> 0x00e0 }
            monitor-exit(r20)     // Catch:{ all -> 0x00e0 }
            net.one97.paytm.hotel4.viewmodel.SRPViewModel r0 = r1.s
            r6 = 31
            long r6 = r6 & r2
            r8 = 28
            r10 = 26
            r12 = 25
            r14 = 0
            int r16 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x009f
            long r6 = r2 & r12
            r15 = 1
            int r17 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r17 == 0) goto L_0x004f
            if (r0 == 0) goto L_0x0028
            androidx.lifecycle.y r6 = r0.getFilterCount()
            goto L_0x0029
        L_0x0028:
            r6 = 0
        L_0x0029:
            r1.updateLiveDataRegistration(r14, r6)
            if (r6 == 0) goto L_0x0035
            java.lang.Object r6 = r6.getValue()
            java.lang.Integer r6 = (java.lang.Integer) r6
            goto L_0x0036
        L_0x0035:
            r6 = 0
        L_0x0036:
            int r6 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Integer) r6)
            if (r6 <= 0) goto L_0x003e
            r6 = 1
            goto L_0x003f
        L_0x003e:
            r6 = 0
        L_0x003f:
            if (r17 == 0) goto L_0x004a
            if (r6 == 0) goto L_0x0046
            r17 = 64
            goto L_0x0048
        L_0x0046:
            r17 = 32
        L_0x0048:
            long r2 = r2 | r17
        L_0x004a:
            if (r6 == 0) goto L_0x004d
            goto L_0x004f
        L_0x004d:
            r6 = 4
            goto L_0x0050
        L_0x004f:
            r6 = 0
        L_0x0050:
            long r17 = r2 & r10
            int r7 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x006a
            if (r0 == 0) goto L_0x005d
            androidx.lifecycle.y r7 = r0.getSortSelectedName()
            goto L_0x005e
        L_0x005d:
            r7 = 0
        L_0x005e:
            r1.updateLiveDataRegistration(r15, r7)
            if (r7 == 0) goto L_0x006a
            java.lang.Object r7 = r7.getValue()
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x006b
        L_0x006a:
            r7 = 0
        L_0x006b:
            long r17 = r2 & r8
            int r19 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r19 == 0) goto L_0x00a1
            if (r0 == 0) goto L_0x0078
            androidx.lifecycle.y r0 = r0.getHotelCount()
            goto L_0x0079
        L_0x0078:
            r0 = 0
        L_0x0079:
            r10 = 2
            r1.updateLiveDataRegistration(r10, r0)
            if (r0 == 0) goto L_0x0088
            java.lang.Object r0 = r0.getValue()
            java.lang.Integer r0 = (java.lang.Integer) r0
            r16 = r0
            goto L_0x008a
        L_0x0088:
            r16 = 0
        L_0x008a:
            android.widget.TextView r0 = r1.o
            android.content.res.Resources r0 = r0.getResources()
            int r10 = net.one97.paytm.hotels2.R.string.hotel_count
            java.lang.String r0 = r0.getString(r10)
            java.lang.Object[] r10 = new java.lang.Object[r15]
            r10[r14] = r16
            java.lang.String r15 = java.lang.String.format(r0, r10)
            goto L_0x00a2
        L_0x009f:
            r6 = 0
            r7 = 0
        L_0x00a1:
            r15 = 0
        L_0x00a2:
            long r10 = r2 & r12
            int r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00ad
            android.widget.ImageView r0 = r1.f29617a
            r0.setVisibility(r6)
        L_0x00ad:
            r10 = 16
            long r10 = r10 & r2
            int r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00c9
            androidx.constraintlayout.widget.ConstraintLayout r0 = r1.f29620d
            android.view.View$OnClickListener r6 = r1.y
            r0.setOnClickListener(r6)
            androidx.constraintlayout.widget.ConstraintLayout r0 = r1.k
            android.view.View$OnClickListener r6 = r1.w
            r0.setOnClickListener(r6)
            androidx.constraintlayout.widget.ConstraintLayout r0 = r1.m
            android.view.View$OnClickListener r6 = r1.x
            r0.setOnClickListener(r6)
        L_0x00c9:
            long r8 = r8 & r2
            int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00d3
            android.widget.TextView r0 = r1.o
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r15)
        L_0x00d3:
            r8 = 26
            long r2 = r2 & r8
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00df
            android.widget.TextView r0 = r1.r
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r7)
        L_0x00df:
            return
        L_0x00e0:
            r0 = move-exception
            monitor-exit(r20)     // Catch:{ all -> 0x00e0 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotels2.b.en.executeBindings():void");
    }

    public final void a(int i2) {
        boolean z2 = false;
        if (i2 == 1) {
            SRPViewModel sRPViewModel = this.s;
            if (sRPViewModel != null) {
                z2 = true;
            }
            if (z2) {
                sRPViewModel.onSortClick();
            }
        } else if (i2 == 2) {
            SRPViewModel sRPViewModel2 = this.s;
            if (sRPViewModel2 != null) {
                z2 = true;
            }
            if (z2) {
                sRPViewModel2.onFilterClick();
            }
        } else if (i2 == 3) {
            SRPViewModel sRPViewModel3 = this.s;
            if (sRPViewModel3 != null) {
                z2 = true;
            }
            if (z2) {
                sRPViewModel3.onMapClick();
            }
        }
    }
}
