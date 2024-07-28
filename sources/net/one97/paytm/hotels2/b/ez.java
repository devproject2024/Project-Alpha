package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.hotel4.viewmodel.SRPHeaderViewModel;
import net.one97.paytm.hotel4.viewmodel.SRPViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;

public final class ez extends ey implements b.a {
    private static final ViewDataBinding.b j = null;
    private static final SparseIntArray k;
    private final LinearLayout l;
    private final TextView m;
    private final LinearLayout n;
    private final TextView o;
    private final LinearLayout p;
    private final ImageView q;
    private final TextView r;
    private final View.OnClickListener s;
    private final View.OnClickListener t;
    private final View.OnClickListener u;
    private final View.OnClickListener v;
    private final View.OnClickListener w;
    private long x;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        k = sparseIntArray;
        sparseIntArray.put(R.id.header, 11);
        k.put(R.id.sub_header, 12);
        k.put(R.id.or, 13);
    }

    public ez(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 14, j, k));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private ez(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[5], objArr[11], objArr[1], objArr[3], objArr[2], objArr[13], objArr[12]);
        this.x = -1;
        this.f29670a.setTag((Object) null);
        this.f29672c.setTag((Object) null);
        this.f29673d.setTag((Object) null);
        this.l = objArr[0];
        this.l.setTag((Object) null);
        this.m = objArr[10];
        this.m.setTag((Object) null);
        this.n = objArr[4];
        this.n.setTag((Object) null);
        this.o = objArr[6];
        this.o.setTag((Object) null);
        this.p = objArr[7];
        this.p.setTag((Object) null);
        this.q = objArr[8];
        this.q.setTag((Object) null);
        this.r = objArr[9];
        this.r.setTag((Object) null);
        this.f29674e.setTag((Object) null);
        setRootTag(view);
        this.s = new b(this, 1);
        this.t = new b(this, 4);
        this.u = new b(this, 2);
        this.v = new b(this, 5);
        this.w = new b(this, 3);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.x = 16;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.x != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.I == i2) {
            a((SRPHeaderViewModel) obj);
        } else if (a.X != i2) {
            return false;
        } else {
            a((SRPViewModel) obj);
        }
        return true;
    }

    public final void a(SRPHeaderViewModel sRPHeaderViewModel) {
        this.f29677h = sRPHeaderViewModel;
        synchronized (this) {
            this.x |= 4;
        }
        notifyPropertyChanged(a.I);
        super.requestRebind();
    }

    public final void a(SRPViewModel sRPViewModel) {
        this.f29678i = sRPViewModel;
        synchronized (this) {
            this.x |= 8;
        }
        notifyPropertyChanged(a.X);
        super.requestRebind();
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return b(i3);
        }
        if (i2 != 1) {
            return false;
        }
        return c(i3);
    }

    private boolean b(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.x |= 1;
        }
        return true;
    }

    private boolean c(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.x |= 2;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0169  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r33 = this;
            r1 = r33
            monitor-enter(r33)
            long r2 = r1.x     // Catch:{ all -> 0x017a }
            r4 = 0
            r1.x = r4     // Catch:{ all -> 0x017a }
            monitor-exit(r33)     // Catch:{ all -> 0x017a }
            net.one97.paytm.hotel4.viewmodel.SRPHeaderViewModel r0 = r1.f29677h
            net.one97.paytm.hotel4.viewmodel.SRPViewModel r6 = r1.f29678i
            r7 = 20
            long r9 = r2 & r7
            int r12 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x001d
            if (r0 == 0) goto L_0x001d
            java.lang.String r0 = r0.getNoSearchResultURL()
            goto L_0x001e
        L_0x001d:
            r0 = 0
        L_0x001e:
            r9 = 27
            long r12 = r2 & r9
            r14 = 1024(0x400, double:5.06E-321)
            r16 = 64
            r18 = 512(0x200, double:2.53E-321)
            r20 = 32
            r22 = 8192(0x2000, double:4.0474E-320)
            r24 = 26
            r26 = 25
            r28 = 8
            r11 = 1
            r7 = 0
            int r8 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x00c8
            if (r6 == 0) goto L_0x003f
            com.travel.utils.l r8 = r6.getSrpFilterNoResultVisibility()
            goto L_0x0040
        L_0x003f:
            r8 = 0
        L_0x0040:
            r1.updateLiveDataRegistration(r7, r8)
            if (r8 == 0) goto L_0x004c
            java.lang.Object r8 = r8.getValue()
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            goto L_0x004d
        L_0x004c:
            r8 = 0
        L_0x004d:
            boolean r8 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r8)
            long r12 = r2 & r26
            int r29 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r29 == 0) goto L_0x005f
            if (r8 == 0) goto L_0x005c
            r12 = 4096(0x1000, double:2.0237E-320)
            goto L_0x005e
        L_0x005c:
            r12 = 2048(0x800, double:1.0118E-320)
        L_0x005e:
            long r2 = r2 | r12
        L_0x005f:
            if (r8 != r11) goto L_0x0063
            r12 = 1
            goto L_0x0064
        L_0x0063:
            r12 = 0
        L_0x0064:
            long r29 = r2 & r9
            int r13 = (r29 > r4 ? 1 : (r29 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x0073
            if (r12 == 0) goto L_0x0071
            r29 = 16384(0x4000, double:8.0948E-320)
            long r2 = r2 | r29
            goto L_0x0073
        L_0x0071:
            long r2 = r2 | r22
        L_0x0073:
            long r29 = r2 & r26
            int r13 = (r29 > r4 ? 1 : (r29 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x007f
            if (r8 == 0) goto L_0x007c
            goto L_0x007f
        L_0x007c:
            r8 = 8
            goto L_0x0080
        L_0x007f:
            r8 = 0
        L_0x0080:
            long r29 = r2 & r24
            int r13 = (r29 > r4 ? 1 : (r29 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x00c0
            if (r6 == 0) goto L_0x008f
            com.travel.utils.l r29 = r6.getSrpFilterSingleResultVisibility()
            r7 = r29
            goto L_0x0090
        L_0x008f:
            r7 = 0
        L_0x0090:
            r1.updateLiveDataRegistration(r11, r7)
            if (r7 == 0) goto L_0x009c
            java.lang.Object r30 = r7.getValue()
            java.lang.Boolean r30 = (java.lang.Boolean) r30
            goto L_0x009e
        L_0x009c:
            r30 = 0
        L_0x009e:
            boolean r31 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r30)
            if (r13 == 0) goto L_0x00ae
            if (r31 == 0) goto L_0x00aa
            long r2 = r2 | r16
            long r2 = r2 | r14
            goto L_0x00ae
        L_0x00aa:
            long r2 = r2 | r20
            long r2 = r2 | r18
        L_0x00ae:
            if (r31 == 0) goto L_0x00b2
            r13 = 0
            goto L_0x00b4
        L_0x00b2:
            r13 = 8
        L_0x00b4:
            if (r31 == 0) goto L_0x00b9
            r31 = 8
            goto L_0x00bb
        L_0x00b9:
            r31 = 0
        L_0x00bb:
            r32 = r8
            r8 = r31
            goto L_0x00d0
        L_0x00c0:
            r32 = r8
            r7 = 0
            r8 = 0
            r13 = 0
            r30 = 0
            goto L_0x00d0
        L_0x00c8:
            r7 = 0
            r8 = 0
            r12 = 0
            r13 = 0
            r30 = 0
            r32 = 0
        L_0x00d0:
            long r22 = r2 & r22
            int r31 = (r22 > r4 ? 1 : (r22 == r4 ? 0 : -1))
            if (r31 == 0) goto L_0x0101
            if (r6 == 0) goto L_0x00dc
            com.travel.utils.l r7 = r6.getSrpFilterSingleResultVisibility()
        L_0x00dc:
            r1.updateLiveDataRegistration(r11, r7)
            if (r7 == 0) goto L_0x00e9
            java.lang.Object r6 = r7.getValue()
            r30 = r6
            java.lang.Boolean r30 = (java.lang.Boolean) r30
        L_0x00e9:
            boolean r6 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r30)
            long r22 = r2 & r24
            int r7 = (r22 > r4 ? 1 : (r22 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x00fd
            if (r6 == 0) goto L_0x00f9
            long r2 = r2 | r16
            long r2 = r2 | r14
            goto L_0x00fd
        L_0x00f9:
            long r2 = r2 | r20
            long r2 = r2 | r18
        L_0x00fd:
            if (r6 != r11) goto L_0x0101
            r6 = 1
            goto L_0x0102
        L_0x0101:
            r6 = 0
        L_0x0102:
            long r14 = r2 & r9
            int r7 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x011a
            if (r12 == 0) goto L_0x010b
            r6 = 1
        L_0x010b:
            if (r7 == 0) goto L_0x0115
            if (r6 == 0) goto L_0x0112
            r11 = 256(0x100, double:1.265E-321)
            goto L_0x0114
        L_0x0112:
            r11 = 128(0x80, double:6.32E-322)
        L_0x0114:
            long r2 = r2 | r11
        L_0x0115:
            if (r6 == 0) goto L_0x011a
            r7 = 8
            goto L_0x011b
        L_0x011a:
            r7 = 0
        L_0x011b:
            r11 = 16
            long r11 = r11 & r2
            int r6 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0145
            android.widget.TextView r6 = r1.f29670a
            android.view.View$OnClickListener r11 = r1.u
            r6.setOnClickListener(r11)
            android.widget.TextView r6 = r1.f29673d
            android.view.View$OnClickListener r11 = r1.s
            r6.setOnClickListener(r11)
            android.widget.TextView r6 = r1.m
            android.view.View$OnClickListener r11 = r1.v
            r6.setOnClickListener(r11)
            android.widget.TextView r6 = r1.o
            android.view.View$OnClickListener r11 = r1.w
            r6.setOnClickListener(r11)
            android.widget.TextView r6 = r1.r
            android.view.View$OnClickListener r11 = r1.t
            r6.setOnClickListener(r11)
        L_0x0145:
            long r11 = r2 & r24
            int r6 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0155
            android.widget.ImageView r6 = r1.f29672c
            r6.setVisibility(r8)
            android.widget.LinearLayout r6 = r1.p
            r6.setVisibility(r13)
        L_0x0155:
            long r11 = r2 & r26
            int r6 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0162
            android.widget.LinearLayout r6 = r1.n
            r8 = r32
            r6.setVisibility(r8)
        L_0x0162:
            r11 = 20
            long r11 = r11 & r2
            int r6 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x016f
            android.widget.ImageView r6 = r1.q
            r8 = 0
            net.one97.paytm.hotel4.utils.a.a(r6, r0, r8, r8)
        L_0x016f:
            long r2 = r2 & r9
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0179
            android.widget.LinearLayout r0 = r1.f29674e
            r0.setVisibility(r7)
        L_0x0179:
            return
        L_0x017a:
            r0 = move-exception
            monitor-exit(r33)     // Catch:{ all -> 0x017a }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotels2.b.ez.executeBindings():void");
    }

    public final void a(int i2) {
        boolean z = false;
        if (i2 == 1) {
            SRPHeaderViewModel sRPHeaderViewModel = this.f29677h;
            if (sRPHeaderViewModel != null) {
                z = true;
            }
            if (z) {
                sRPHeaderViewModel.onEditClick();
            }
        } else if (i2 == 2) {
            SRPViewModel sRPViewModel = this.f29678i;
            if (sRPViewModel != null) {
                z = true;
            }
            if (z) {
                sRPViewModel.onFilterClick();
            }
        } else if (i2 == 3) {
            SRPViewModel sRPViewModel2 = this.f29678i;
            if (sRPViewModel2 != null) {
                z = true;
            }
            if (z) {
                sRPViewModel2.onSeeAllHotelsClick();
            }
        } else if (i2 == 4) {
            SRPViewModel sRPViewModel3 = this.f29678i;
            if (sRPViewModel3 != null) {
                z = true;
            }
            if (z) {
                sRPViewModel3.onFilterClick();
            }
        } else if (i2 == 5) {
            SRPViewModel sRPViewModel4 = this.f29678i;
            if (sRPViewModel4 != null) {
                z = true;
            }
            if (z) {
                sRPViewModel4.onSeeAllHotelsClick();
            }
        }
    }
}
