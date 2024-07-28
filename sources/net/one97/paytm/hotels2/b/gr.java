package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.hotel4.viewmodel.ErrorViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;

public final class gr extends gq implements b.a {

    /* renamed from: i  reason: collision with root package name */
    private static final ViewDataBinding.b f29876i = null;
    private static final SparseIntArray j;
    private final ConstraintLayout k;
    private final View l;
    private final View m;
    private final View.OnClickListener n;
    private final View.OnClickListener o;
    private long p;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        j = sparseIntArray;
        sparseIntArray.put(R.id.image_view, 9);
    }

    public gr(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 10, f29876i, j));
    }

    private gr(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[9], objArr[1], objArr[4], objArr[8], objArr[2], objArr[3], objArr[6]);
        this.p = -1;
        this.f29869b.setTag((Object) null);
        this.k = objArr[0];
        this.k.setTag((Object) null);
        this.l = objArr[5];
        this.l.setTag((Object) null);
        this.m = objArr[7];
        this.m.setTag((Object) null);
        this.f29870c.setTag((Object) null);
        this.f29871d.setTag((Object) null);
        this.f29872e.setTag((Object) null);
        this.f29873f.setTag((Object) null);
        this.f29874g.setTag((Object) null);
        setRootTag(view);
        this.n = new b(this, 2);
        this.o = new b(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.p = 256;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.p != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.T != i2) {
            return false;
        }
        a((ErrorViewModel) obj);
        return true;
    }

    public final void a(ErrorViewModel errorViewModel) {
        this.f29875h = errorViewModel;
        synchronized (this) {
            this.p |= 128;
        }
        notifyPropertyChanged(a.T);
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
            default:
                return false;
        }
    }

    private boolean b(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.p |= 1;
        }
        return true;
    }

    private boolean c(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.p |= 2;
        }
        return true;
    }

    private boolean d(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.p |= 4;
        }
        return true;
    }

    private boolean e(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.p |= 8;
        }
        return true;
    }

    private boolean f(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.p |= 16;
        }
        return true;
    }

    private boolean g(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.p |= 32;
        }
        return true;
    }

    private boolean h(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.p |= 64;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x011b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r29 = this;
            r1 = r29
            monitor-enter(r29)
            long r2 = r1.p     // Catch:{ all -> 0x01d4 }
            r4 = 0
            r1.p = r4     // Catch:{ all -> 0x01d4 }
            monitor-exit(r29)     // Catch:{ all -> 0x01d4 }
            net.one97.paytm.hotel4.viewmodel.ErrorViewModel r0 = r1.f29875h
            r6 = 511(0x1ff, double:2.525E-321)
            long r6 = r6 & r2
            r10 = 392(0x188, double:1.937E-321)
            r12 = 400(0x190, double:1.976E-321)
            r14 = 388(0x184, double:1.917E-321)
            r16 = 448(0x1c0, double:2.213E-321)
            r18 = 385(0x181, double:1.9E-321)
            r20 = 386(0x182, double:1.907E-321)
            r8 = 0
            int r22 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r22 == 0) goto L_0x0158
            long r6 = r2 & r18
            r22 = 8
            int r23 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r23 == 0) goto L_0x0052
            if (r0 == 0) goto L_0x002f
            androidx.lifecycle.y r6 = r0.getShowActionButton2()
            goto L_0x0030
        L_0x002f:
            r6 = 0
        L_0x0030:
            r1.updateLiveDataRegistration(r8, r6)
            if (r6 == 0) goto L_0x003c
            java.lang.Object r6 = r6.getValue()
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            goto L_0x003d
        L_0x003c:
            r6 = 0
        L_0x003d:
            boolean r6 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r6)
            if (r23 == 0) goto L_0x004c
            if (r6 == 0) goto L_0x0048
            r23 = 1024(0x400, double:5.06E-321)
            goto L_0x004a
        L_0x0048:
            r23 = 512(0x200, double:2.53E-321)
        L_0x004a:
            long r2 = r2 | r23
        L_0x004c:
            if (r6 == 0) goto L_0x004f
            goto L_0x0052
        L_0x004f:
            r6 = 8
            goto L_0x0053
        L_0x0052:
            r6 = 0
        L_0x0053:
            long r23 = r2 & r20
            int r7 = (r23 > r4 ? 1 : (r23 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x0087
            if (r0 == 0) goto L_0x0062
            androidx.lifecycle.y r23 = r0.getShowCloseButton()
            r8 = r23
            goto L_0x0063
        L_0x0062:
            r8 = 0
        L_0x0063:
            r9 = 1
            r1.updateLiveDataRegistration(r9, r8)
            if (r8 == 0) goto L_0x0071
            java.lang.Object r8 = r8.getValue()
            r9 = r8
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            goto L_0x0072
        L_0x0071:
            r9 = 0
        L_0x0072:
            boolean r8 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r9)
            if (r7 == 0) goto L_0x0081
            if (r8 == 0) goto L_0x007d
            r25 = 4096(0x1000, double:2.0237E-320)
            goto L_0x007f
        L_0x007d:
            r25 = 2048(0x800, double:1.0118E-320)
        L_0x007f:
            long r2 = r2 | r25
        L_0x0081:
            if (r8 == 0) goto L_0x0084
            goto L_0x0087
        L_0x0084:
            r8 = 8
            goto L_0x0088
        L_0x0087:
            r8 = 0
        L_0x0088:
            long r25 = r2 & r14
            int r7 = (r25 > r4 ? 1 : (r25 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x00a4
            if (r0 == 0) goto L_0x0095
            androidx.lifecycle.y r9 = r0.getMessage()
            goto L_0x0096
        L_0x0095:
            r9 = 0
        L_0x0096:
            r7 = 2
            r1.updateLiveDataRegistration(r7, r9)
            if (r9 == 0) goto L_0x00a4
            java.lang.Object r7 = r9.getValue()
            r9 = r7
            java.lang.String r9 = (java.lang.String) r9
            goto L_0x00a5
        L_0x00a4:
            r9 = 0
        L_0x00a5:
            long r25 = r2 & r10
            int r7 = (r25 > r4 ? 1 : (r25 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x00c0
            if (r0 == 0) goto L_0x00b2
            androidx.lifecycle.y r7 = r0.getTitle()
            goto L_0x00b3
        L_0x00b2:
            r7 = 0
        L_0x00b3:
            r14 = 3
            r1.updateLiveDataRegistration(r14, r7)
            if (r7 == 0) goto L_0x00c0
            java.lang.Object r7 = r7.getValue()
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x00c1
        L_0x00c0:
            r7 = 0
        L_0x00c1:
            long r14 = r2 & r12
            r10 = 4
            int r11 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x00f5
            if (r0 == 0) goto L_0x00cf
            androidx.lifecycle.y r14 = r0.getShowActionButton1()
            goto L_0x00d0
        L_0x00cf:
            r14 = 0
        L_0x00d0:
            r1.updateLiveDataRegistration(r10, r14)
            if (r14 == 0) goto L_0x00dc
            java.lang.Object r14 = r14.getValue()
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            goto L_0x00dd
        L_0x00dc:
            r14 = 0
        L_0x00dd:
            boolean r14 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r14)
            if (r11 == 0) goto L_0x00ee
            if (r14 == 0) goto L_0x00e9
            r27 = 65536(0x10000, double:3.2379E-319)
            goto L_0x00ec
        L_0x00e9:
            r27 = 32768(0x8000, double:1.61895E-319)
        L_0x00ec:
            long r2 = r2 | r27
        L_0x00ee:
            if (r14 == 0) goto L_0x00f2
            r22 = 0
        L_0x00f2:
            r14 = 416(0x1a0, double:2.055E-321)
            goto L_0x00f9
        L_0x00f5:
            r14 = 416(0x1a0, double:2.055E-321)
            r22 = 0
        L_0x00f9:
            long r27 = r2 & r14
            int r11 = (r27 > r4 ? 1 : (r27 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x0114
            if (r0 == 0) goto L_0x0106
            androidx.lifecycle.y r11 = r0.getActionButton2Text()
            goto L_0x0107
        L_0x0106:
            r11 = 0
        L_0x0107:
            r14 = 5
            r1.updateLiveDataRegistration(r14, r11)
            if (r11 == 0) goto L_0x0114
            java.lang.Object r11 = r11.getValue()
            java.lang.String r11 = (java.lang.String) r11
            goto L_0x0115
        L_0x0114:
            r11 = 0
        L_0x0115:
            long r14 = r2 & r16
            int r27 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r27 == 0) goto L_0x0150
            if (r0 == 0) goto L_0x0122
            androidx.lifecycle.y r0 = r0.getActionButton1Text()
            goto L_0x0123
        L_0x0122:
            r0 = 0
        L_0x0123:
            r14 = 6
            r1.updateLiveDataRegistration(r14, r0)
            if (r0 == 0) goto L_0x0130
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x0131
        L_0x0130:
            r0 = 0
        L_0x0131:
            boolean r14 = android.text.TextUtils.isEmpty(r0)
            if (r27 == 0) goto L_0x0140
            if (r14 == 0) goto L_0x013c
            r27 = 16384(0x4000, double:8.0948E-320)
            goto L_0x013e
        L_0x013c:
            r27 = 8192(0x2000, double:4.0474E-320)
        L_0x013e:
            long r2 = r2 | r27
        L_0x0140:
            if (r14 == 0) goto L_0x0145
            r23 = 4
            goto L_0x0147
        L_0x0145:
            r23 = 0
        L_0x0147:
            r10 = r7
            r14 = r9
            r7 = r22
            r9 = r6
            r6 = r0
            r0 = r23
            goto L_0x0160
        L_0x0150:
            r10 = r7
            r14 = r9
            r7 = r22
            r0 = 0
            r9 = r6
            r6 = 0
            goto L_0x0160
        L_0x0158:
            r0 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r14 = 0
        L_0x0160:
            long r20 = r2 & r20
            int r15 = (r20 > r4 ? 1 : (r20 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x016b
            android.widget.ImageView r15 = r1.f29869b
            r15.setVisibility(r8)
        L_0x016b:
            long r15 = r2 & r16
            int r8 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x0185
            android.view.View r8 = r1.l
            r8.setVisibility(r0)
            android.view.View r8 = r1.m
            r8.setVisibility(r0)
            android.widget.TextView r8 = r1.f29870c
            androidx.databinding.a.d.a((android.widget.TextView) r8, (java.lang.CharSequence) r6)
            android.widget.TextView r6 = r1.f29874g
            r6.setVisibility(r0)
        L_0x0185:
            r15 = 256(0x100, double:1.265E-321)
            long r15 = r15 & r2
            int r0 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x019a
            android.widget.TextView r0 = r1.f29870c
            android.view.View$OnClickListener r6 = r1.o
            r0.setOnClickListener(r6)
            android.widget.TextView r0 = r1.f29871d
            android.view.View$OnClickListener r6 = r1.n
            r0.setOnClickListener(r6)
        L_0x019a:
            long r12 = r12 & r2
            int r0 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x01a4
            android.widget.TextView r0 = r1.f29870c
            r0.setVisibility(r7)
        L_0x01a4:
            long r6 = r2 & r18
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x01af
            android.widget.TextView r0 = r1.f29871d
            r0.setVisibility(r9)
        L_0x01af:
            r6 = 416(0x1a0, double:2.055E-321)
            long r6 = r6 & r2
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x01bb
            android.widget.TextView r0 = r1.f29871d
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r11)
        L_0x01bb:
            r6 = 392(0x188, double:1.937E-321)
            long r6 = r6 & r2
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x01c7
            android.widget.TextView r0 = r1.f29872e
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r10)
        L_0x01c7:
            r6 = 388(0x184, double:1.917E-321)
            long r2 = r2 & r6
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x01d3
            android.widget.TextView r0 = r1.f29873f
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r14)
        L_0x01d3:
            return
        L_0x01d4:
            r0 = move-exception
            monitor-exit(r29)     // Catch:{ all -> 0x01d4 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotels2.b.gr.executeBindings():void");
    }

    public final void a(int i2) {
        boolean z = false;
        if (i2 == 1) {
            ErrorViewModel errorViewModel = this.f29875h;
            if (errorViewModel != null) {
                z = true;
            }
            if (z) {
                errorViewModel.clicked(errorViewModel.getAction1());
            }
        } else if (i2 == 2) {
            ErrorViewModel errorViewModel2 = this.f29875h;
            if (errorViewModel2 != null) {
                z = true;
            }
            if (z) {
                errorViewModel2.clicked(errorViewModel2.getAction2());
            }
        }
    }
}
