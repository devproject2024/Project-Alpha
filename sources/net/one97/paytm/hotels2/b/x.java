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

public final class x extends w implements b.a {
    private static final ViewDataBinding.b k = null;
    private static final SparseIntArray l;
    private final ConstraintLayout m;
    private final View.OnClickListener n;
    private final View.OnClickListener o;
    private final View.OnClickListener p;
    private final View.OnClickListener q;
    private final View.OnClickListener r;
    private final View.OnClickListener s;
    private final View.OnClickListener t;
    private long u;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        l = sparseIntArray;
        sparseIntArray.put(R.id.iv_header_overlay, 9);
    }

    public x(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 10, k, l));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private x(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[2], objArr[4], objArr[1], objArr[9], objArr[3], objArr[5], objArr[7], objArr[8], objArr[6]);
        this.u = -1;
        this.f29951a.setTag((Object) null);
        this.f29952b.setTag((Object) null);
        this.f29953c.setTag((Object) null);
        this.f29955e.setTag((Object) null);
        this.f29956f.setTag((Object) null);
        this.f29957g.setTag((Object) null);
        this.f29958h.setTag((Object) null);
        this.f29959i.setTag((Object) null);
        this.m = objArr[0];
        this.m.setTag((Object) null);
        setRootTag(view);
        this.n = new b(this, 5);
        this.o = new b(this, 1);
        this.p = new b(this, 6);
        this.q = new b(this, 2);
        this.r = new b(this, 7);
        this.s = new b(this, 3);
        this.t = new b(this, 4);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.u = 1024;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.u != 0) {
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
        this.j = detailsViewModel;
        synchronized (this) {
            this.u |= 512;
        }
        notifyPropertyChanged(a.t);
        super.requestRebind();
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return b(i3);
            case 1:
                return c(i3);
            case 2:
                return d(i3);
            case 3:
                return e(i3);
            case 4:
                return f(i3);
            case 5:
                return g(i3);
            case 6:
                return h(i3);
            case 7:
                return i(i3);
            case 8:
                return j(i3);
            default:
                return false;
        }
    }

    private boolean b(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.u |= 1;
        }
        return true;
    }

    private boolean c(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.u |= 2;
        }
        return true;
    }

    private boolean d(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.u |= 4;
        }
        return true;
    }

    private boolean e(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.u |= 8;
        }
        return true;
    }

    private boolean f(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.u |= 16;
        }
        return true;
    }

    private boolean g(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.u |= 32;
        }
        return true;
    }

    private boolean h(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.u |= 64;
        }
        return true;
    }

    private boolean i(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.u |= 128;
        }
        return true;
    }

    private boolean j(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.u |= 256;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0124  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r38 = this;
            r1 = r38
            monitor-enter(r38)
            long r2 = r1.u     // Catch:{ all -> 0x0204 }
            r4 = 0
            r1.u = r4     // Catch:{ all -> 0x0204 }
            monitor-exit(r38)     // Catch:{ all -> 0x0204 }
            net.one97.paytm.hotel4.viewmodel.DetailsViewModel r0 = r1.j
            r6 = 2047(0x7ff, double:1.0114E-320)
            long r6 = r6 & r2
            r10 = 1600(0x640, double:7.905E-321)
            r14 = 1552(0x610, double:7.67E-321)
            r16 = 1544(0x608, double:7.63E-321)
            r18 = 1540(0x604, double:7.61E-321)
            r20 = 1538(0x602, double:7.6E-321)
            r22 = 1568(0x620, double:7.747E-321)
            r24 = 1537(0x601, double:7.594E-321)
            r12 = 0
            int r28 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r28 == 0) goto L_0x013c
            long r6 = r2 & r24
            int r28 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r28 == 0) goto L_0x0042
            if (r0 == 0) goto L_0x002f
            androidx.lifecycle.y r6 = r0.get_image1_visibility()
            goto L_0x0030
        L_0x002f:
            r6 = 0
        L_0x0030:
            r1.updateLiveDataRegistration(r12, r6)
            if (r6 == 0) goto L_0x003c
            java.lang.Object r6 = r6.getValue()
            java.lang.Integer r6 = (java.lang.Integer) r6
            goto L_0x003d
        L_0x003c:
            r6 = 0
        L_0x003d:
            int r6 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Integer) r6)
            goto L_0x0043
        L_0x0042:
            r6 = 0
        L_0x0043:
            long r28 = r2 & r20
            int r7 = (r28 > r4 ? 1 : (r28 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x005f
            if (r0 == 0) goto L_0x0050
            androidx.lifecycle.y r7 = r0.get_image2_url()
            goto L_0x0051
        L_0x0050:
            r7 = 0
        L_0x0051:
            r13 = 1
            r1.updateLiveDataRegistration(r13, r7)
            if (r7 == 0) goto L_0x005f
            java.lang.Object r7 = r7.getValue()
            r13 = r7
            java.lang.String r13 = (java.lang.String) r13
            goto L_0x0060
        L_0x005f:
            r13 = 0
        L_0x0060:
            long r29 = r2 & r18
            int r7 = (r29 > r4 ? 1 : (r29 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x0081
            if (r0 == 0) goto L_0x006d
            androidx.lifecycle.y r7 = r0.get_image3_visibility()
            goto L_0x006e
        L_0x006d:
            r7 = 0
        L_0x006e:
            r12 = 2
            r1.updateLiveDataRegistration(r12, r7)
            if (r7 == 0) goto L_0x007b
            java.lang.Object r7 = r7.getValue()
            java.lang.Integer r7 = (java.lang.Integer) r7
            goto L_0x007c
        L_0x007b:
            r7 = 0
        L_0x007c:
            int r12 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Integer) r7)
            goto L_0x0082
        L_0x0081:
            r12 = 0
        L_0x0082:
            long r30 = r2 & r16
            int r7 = (r30 > r4 ? 1 : (r30 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x009d
            if (r0 == 0) goto L_0x008f
            androidx.lifecycle.y r7 = r0.get_image1_url()
            goto L_0x0090
        L_0x008f:
            r7 = 0
        L_0x0090:
            r8 = 3
            r1.updateLiveDataRegistration(r8, r7)
            if (r7 == 0) goto L_0x009d
            java.lang.Object r7 = r7.getValue()
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x009e
        L_0x009d:
            r7 = 0
        L_0x009e:
            long r8 = r2 & r14
            int r32 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r32 == 0) goto L_0x00b9
            if (r0 == 0) goto L_0x00ab
            androidx.lifecycle.y r8 = r0.get_imageCount()
            goto L_0x00ac
        L_0x00ab:
            r8 = 0
        L_0x00ac:
            r9 = 4
            r1.updateLiveDataRegistration(r9, r8)
            if (r8 == 0) goto L_0x00b9
            java.lang.Object r8 = r8.getValue()
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x00ba
        L_0x00b9:
            r8 = 0
        L_0x00ba:
            long r32 = r2 & r22
            int r9 = (r32 > r4 ? 1 : (r32 == r4 ? 0 : -1))
            if (r9 == 0) goto L_0x00d5
            if (r0 == 0) goto L_0x00c7
            androidx.lifecycle.y r9 = r0.get_image0_url()
            goto L_0x00c8
        L_0x00c7:
            r9 = 0
        L_0x00c8:
            r14 = 5
            r1.updateLiveDataRegistration(r14, r9)
            if (r9 == 0) goto L_0x00d5
            java.lang.Object r9 = r9.getValue()
            java.lang.String r9 = (java.lang.String) r9
            goto L_0x00d6
        L_0x00d5:
            r9 = 0
        L_0x00d6:
            long r14 = r2 & r10
            int r34 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r34 == 0) goto L_0x00f7
            if (r0 == 0) goto L_0x00e3
            androidx.lifecycle.y r14 = r0.get_imageCount_visibility()
            goto L_0x00e4
        L_0x00e3:
            r14 = 0
        L_0x00e4:
            r15 = 6
            r1.updateLiveDataRegistration(r15, r14)
            if (r14 == 0) goto L_0x00f1
            java.lang.Object r14 = r14.getValue()
            java.lang.Integer r14 = (java.lang.Integer) r14
            goto L_0x00f2
        L_0x00f1:
            r14 = 0
        L_0x00f2:
            int r14 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Integer) r14)
            goto L_0x00f8
        L_0x00f7:
            r14 = 0
        L_0x00f8:
            r30 = 1664(0x680, double:8.22E-321)
            long r34 = r2 & r30
            int r15 = (r34 > r4 ? 1 : (r34 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x011b
            if (r0 == 0) goto L_0x0107
            androidx.lifecycle.y r15 = r0.get_image2_visibility()
            goto L_0x0108
        L_0x0107:
            r15 = 0
        L_0x0108:
            r10 = 7
            r1.updateLiveDataRegistration(r10, r15)
            if (r15 == 0) goto L_0x0115
            java.lang.Object r10 = r15.getValue()
            java.lang.Integer r10 = (java.lang.Integer) r10
            goto L_0x0116
        L_0x0115:
            r10 = 0
        L_0x0116:
            int r10 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Integer) r10)
            goto L_0x011c
        L_0x011b:
            r10 = 0
        L_0x011c:
            r26 = 1792(0x700, double:8.854E-321)
            long r36 = r2 & r26
            int r11 = (r36 > r4 ? 1 : (r36 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x013a
            if (r0 == 0) goto L_0x012b
            androidx.lifecycle.y r0 = r0.get_image3_url()
            goto L_0x012c
        L_0x012b:
            r0 = 0
        L_0x012c:
            r11 = 8
            r1.updateLiveDataRegistration(r11, r0)
            if (r0 == 0) goto L_0x013a
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x0145
        L_0x013a:
            r0 = 0
            goto L_0x0145
        L_0x013c:
            r0 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r12 = 0
            r13 = 0
            r14 = 0
        L_0x0145:
            r36 = 1024(0x400, double:5.06E-321)
            long r36 = r2 & r36
            int r11 = (r36 > r4 ? 1 : (r36 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x017e
            android.widget.ImageView r11 = r1.f29951a
            android.view.View$OnClickListener r15 = r1.q
            r11.setOnClickListener(r15)
            android.widget.ImageView r11 = r1.f29952b
            android.view.View$OnClickListener r15 = r1.t
            r11.setOnClickListener(r15)
            android.widget.ImageView r11 = r1.f29953c
            android.view.View$OnClickListener r15 = r1.o
            r11.setOnClickListener(r15)
            android.widget.ImageView r11 = r1.f29955e
            android.view.View$OnClickListener r15 = r1.s
            r11.setOnClickListener(r15)
            android.widget.ImageView r11 = r1.f29956f
            android.view.View$OnClickListener r15 = r1.n
            r11.setOnClickListener(r15)
            android.widget.ImageView r11 = r1.f29957g
            android.view.View$OnClickListener r15 = r1.r
            r11.setOnClickListener(r15)
            android.widget.ImageView r11 = r1.f29959i
            android.view.View$OnClickListener r15 = r1.p
            r11.setOnClickListener(r15)
        L_0x017e:
            long r22 = r2 & r22
            int r11 = (r22 > r4 ? 1 : (r22 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x0191
            android.widget.ImageView r11 = r1.f29953c
            com.paytm.utility.b.b.e r15 = com.paytm.utility.b.b.e.HIGH
            r22 = 0
            java.lang.Integer r4 = java.lang.Integer.valueOf(r22)
            net.one97.paytm.hotel4.utils.a.a(r11, r9, r15, r4)
        L_0x0191:
            long r4 = r2 & r24
            r22 = 0
            int r9 = (r4 > r22 ? 1 : (r4 == r22 ? 0 : -1))
            if (r9 == 0) goto L_0x019e
            android.widget.ImageView r4 = r1.f29956f
            r4.setVisibility(r6)
        L_0x019e:
            long r4 = r2 & r16
            r6 = 320(0x140, float:4.48E-43)
            int r9 = (r4 > r22 ? 1 : (r4 == r22 ? 0 : -1))
            if (r9 == 0) goto L_0x01b1
            android.widget.ImageView r4 = r1.f29956f
            com.paytm.utility.b.b.e r5 = com.paytm.utility.b.b.e.HIGH
            java.lang.Integer r9 = java.lang.Integer.valueOf(r6)
            net.one97.paytm.hotel4.utils.a.a(r4, r7, r5, r9)
        L_0x01b1:
            long r4 = r2 & r18
            int r7 = (r4 > r22 ? 1 : (r4 == r22 ? 0 : -1))
            if (r7 == 0) goto L_0x01bc
            android.widget.ImageView r4 = r1.f29957g
            r4.setVisibility(r12)
        L_0x01bc:
            r4 = 1792(0x700, double:8.854E-321)
            long r4 = r4 & r2
            int r7 = (r4 > r22 ? 1 : (r4 == r22 ? 0 : -1))
            if (r7 == 0) goto L_0x01ce
            android.widget.ImageView r4 = r1.f29957g
            com.paytm.utility.b.b.e r5 = com.paytm.utility.b.b.e.HIGH
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            net.one97.paytm.hotel4.utils.a.a(r4, r0, r5, r7)
        L_0x01ce:
            r4 = 1552(0x610, double:7.67E-321)
            long r4 = r4 & r2
            int r0 = (r4 > r22 ? 1 : (r4 == r22 ? 0 : -1))
            if (r0 == 0) goto L_0x01da
            android.widget.TextView r0 = r1.f29958h
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r8)
        L_0x01da:
            r4 = 1600(0x640, double:7.905E-321)
            long r4 = r4 & r2
            int r0 = (r4 > r22 ? 1 : (r4 == r22 ? 0 : -1))
            if (r0 == 0) goto L_0x01e6
            android.widget.TextView r0 = r1.f29958h
            r0.setVisibility(r14)
        L_0x01e6:
            r4 = 1664(0x680, double:8.22E-321)
            long r4 = r4 & r2
            int r0 = (r4 > r22 ? 1 : (r4 == r22 ? 0 : -1))
            if (r0 == 0) goto L_0x01f2
            android.widget.ImageView r0 = r1.f29959i
            r0.setVisibility(r10)
        L_0x01f2:
            long r2 = r2 & r20
            int r0 = (r2 > r22 ? 1 : (r2 == r22 ? 0 : -1))
            if (r0 == 0) goto L_0x0203
            android.widget.ImageView r0 = r1.f29959i
            com.paytm.utility.b.b.e r2 = com.paytm.utility.b.b.e.HIGH
            java.lang.Integer r3 = java.lang.Integer.valueOf(r6)
            net.one97.paytm.hotel4.utils.a.a(r0, r13, r2, r3)
        L_0x0203:
            return
        L_0x0204:
            r0 = move-exception
            monitor-exit(r38)     // Catch:{ all -> 0x0204 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotels2.b.x.executeBindings():void");
    }

    public final void a(int i2) {
        boolean z = true;
        switch (i2) {
            case 1:
                DetailsViewModel detailsViewModel = this.j;
                if (detailsViewModel == null) {
                    z = false;
                }
                if (z) {
                    detailsViewModel.onGalleryPressed();
                    return;
                }
                return;
            case 2:
                DetailsViewModel detailsViewModel2 = this.j;
                if (detailsViewModel2 == null) {
                    z = false;
                }
                if (z) {
                    detailsViewModel2.onBackPressed();
                    return;
                }
                return;
            case 3:
                DetailsViewModel detailsViewModel3 = this.j;
                if (detailsViewModel3 == null) {
                    z = false;
                }
                if (z) {
                    detailsViewModel3.onSharePressed();
                    return;
                }
                return;
            case 4:
                DetailsViewModel detailsViewModel4 = this.j;
                if (detailsViewModel4 == null) {
                    z = false;
                }
                if (z) {
                    detailsViewModel4.onFavPressed();
                    return;
                }
                return;
            case 5:
                DetailsViewModel detailsViewModel5 = this.j;
                if (detailsViewModel5 == null) {
                    z = false;
                }
                if (z) {
                    detailsViewModel5.onGalleryPressed();
                    return;
                }
                return;
            case 6:
                DetailsViewModel detailsViewModel6 = this.j;
                if (detailsViewModel6 == null) {
                    z = false;
                }
                if (z) {
                    detailsViewModel6.onGalleryPressed();
                    return;
                }
                return;
            case 7:
                DetailsViewModel detailsViewModel7 = this.j;
                if (detailsViewModel7 == null) {
                    z = false;
                }
                if (z) {
                    detailsViewModel7.onGalleryPressed();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
