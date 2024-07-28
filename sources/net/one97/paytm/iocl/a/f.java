package net.one97.paytm.iocl.a;

import android.app.Activity;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import net.one97.paytm.iocl.R;
import net.one97.paytm.iocl.b.a.a;
import net.one97.paytm.transport.iocl.c.b;

public final class f extends e implements a.C0194a {

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.b f14106f = null;

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f14107g;

    /* renamed from: h  reason: collision with root package name */
    private final FrameLayout f14108h;

    /* renamed from: i  reason: collision with root package name */
    private final ImageView f14109i;
    private final ImageView j;
    private final ProgressBar k;
    private final View.OnClickListener l;
    private long m;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f14107g = sparseIntArray;
        sparseIntArray.put(R.id.iocl_screen_container, 6);
        f14107g.put(R.id.load_more_history_progress, 7);
    }

    public f(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 8, f14106f, f14107g));
    }

    private f(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[2], objArr[6], objArr[7], objArr[1]);
        this.m = -1;
        this.f14101a.setTag((Object) null);
        this.f14104d.setTag((Object) null);
        this.f14108h = objArr[0];
        this.f14108h.setTag((Object) null);
        this.f14109i = objArr[3];
        this.f14109i.setTag((Object) null);
        this.j = objArr[4];
        this.j.setTag((Object) null);
        this.k = objArr[5];
        this.k.setTag((Object) null);
        setRootTag(view);
        this.l = new a(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.m = 16;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.m != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (net.one97.paytm.iocl.a.f14081e != i2) {
            return false;
        }
        b bVar = (b) obj;
        updateRegistration(0, (h) bVar);
        this.f14105e = bVar;
        synchronized (this) {
            this.m |= 1;
        }
        notifyPropertyChanged(net.one97.paytm.iocl.a.f14081e);
        super.requestRebind();
        return true;
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return a(i3);
        }
        if (i2 == 1) {
            return b(i3);
        }
        if (i2 != 2) {
            return false;
        }
        return c(i3);
    }

    private boolean a(int i2) {
        if (i2 == net.one97.paytm.iocl.a.f14077a) {
            synchronized (this) {
                this.m |= 1;
            }
            return true;
        } else if (i2 != net.one97.paytm.iocl.a.f14082f) {
            return false;
        } else {
            synchronized (this) {
                this.m |= 8;
            }
            return true;
        }
    }

    private boolean b(int i2) {
        if (i2 != net.one97.paytm.iocl.a.f14077a) {
            return false;
        }
        synchronized (this) {
            this.m |= 2;
        }
        return true;
    }

    private boolean c(int i2) {
        if (i2 != net.one97.paytm.iocl.a.f14077a) {
            return false;
        }
        synchronized (this) {
            this.m |= 4;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00b9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r21 = this;
            r1 = r21
            monitor-enter(r21)
            long r2 = r1.m     // Catch:{ all -> 0x00f5 }
            r4 = 0
            r1.m = r4     // Catch:{ all -> 0x00f5 }
            monitor-exit(r21)     // Catch:{ all -> 0x00f5 }
            net.one97.paytm.transport.iocl.c.b r0 = r1.f14105e
            r6 = 31
            long r6 = r6 & r2
            r8 = 21
            r10 = 19
            r12 = 25
            int r15 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x00bb
            long r6 = r2 & r12
            r16 = 0
            int r17 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r17 == 0) goto L_0x0052
            if (r0 == 0) goto L_0x002c
            androidx.lifecycle.y<java.lang.Boolean> r6 = r0.f14295a
            java.lang.Object r6 = r6.getValue()
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            goto L_0x002e
        L_0x002c:
            r6 = r16
        L_0x002e:
            boolean r6 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r6)
            if (r17 == 0) goto L_0x0045
            if (r6 == 0) goto L_0x003d
            r17 = 64
            long r2 = r2 | r17
            r17 = 4096(0x1000, double:2.0237E-320)
            goto L_0x0043
        L_0x003d:
            r17 = 32
            long r2 = r2 | r17
            r17 = 2048(0x800, double:1.0118E-320)
        L_0x0043:
            long r2 = r2 | r17
        L_0x0045:
            if (r6 == 0) goto L_0x004a
            r7 = 8
            goto L_0x004b
        L_0x004a:
            r7 = 0
        L_0x004b:
            if (r6 == 0) goto L_0x004f
            r6 = 0
            goto L_0x0054
        L_0x004f:
            r6 = 8
            goto L_0x0054
        L_0x0052:
            r6 = 0
            r7 = 0
        L_0x0054:
            long r17 = r2 & r10
            int r19 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r19 == 0) goto L_0x0085
            if (r0 == 0) goto L_0x005f
            androidx.databinding.i<java.lang.Boolean> r14 = r0.f14301g
            goto L_0x0061
        L_0x005f:
            r14 = r16
        L_0x0061:
            r15 = 1
            r1.updateRegistration((int) r15, (androidx.databinding.h) r14)
            if (r14 == 0) goto L_0x006e
            java.lang.Object r14 = r14.get()
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            goto L_0x0070
        L_0x006e:
            r14 = r16
        L_0x0070:
            boolean r14 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r14)
            if (r19 == 0) goto L_0x007f
            if (r14 == 0) goto L_0x007b
            r19 = 1024(0x400, double:5.06E-321)
            goto L_0x007d
        L_0x007b:
            r19 = 512(0x200, double:2.53E-321)
        L_0x007d:
            long r2 = r2 | r19
        L_0x007f:
            if (r14 == 0) goto L_0x0082
            goto L_0x0085
        L_0x0082:
            r14 = 8
            goto L_0x0086
        L_0x0085:
            r14 = 0
        L_0x0086:
            long r19 = r2 & r8
            int r15 = (r19 > r4 ? 1 : (r19 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x00b9
            if (r0 == 0) goto L_0x0091
            androidx.databinding.i<java.lang.Boolean> r0 = r0.f14302h
            goto L_0x0093
        L_0x0091:
            r0 = r16
        L_0x0093:
            r8 = 2
            r1.updateRegistration((int) r8, (androidx.databinding.h) r0)
            if (r0 == 0) goto L_0x00a1
            java.lang.Object r0 = r0.get()
            r16 = r0
            java.lang.Boolean r16 = (java.lang.Boolean) r16
        L_0x00a1:
            boolean r0 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r16)
            if (r15 == 0) goto L_0x00af
            if (r0 == 0) goto L_0x00ac
            r8 = 256(0x100, double:1.265E-321)
            goto L_0x00ae
        L_0x00ac:
            r8 = 128(0x80, double:6.32E-322)
        L_0x00ae:
            long r2 = r2 | r8
        L_0x00af:
            if (r0 == 0) goto L_0x00b4
            r17 = 0
            goto L_0x00b6
        L_0x00b4:
            r17 = 8
        L_0x00b6:
            r0 = r17
            goto L_0x00bf
        L_0x00b9:
            r0 = 0
            goto L_0x00bf
        L_0x00bb:
            r0 = 0
            r6 = 0
            r7 = 0
            r14 = 0
        L_0x00bf:
            r8 = 16
            long r8 = r8 & r2
            int r15 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x00cd
            android.widget.ImageView r8 = r1.f14101a
            android.view.View$OnClickListener r9 = r1.l
            r8.setOnClickListener(r9)
        L_0x00cd:
            long r8 = r2 & r12
            int r12 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x00dd
            android.widget.LinearLayout r8 = r1.f14104d
            r8.setVisibility(r7)
            android.widget.ProgressBar r7 = r1.k
            r7.setVisibility(r6)
        L_0x00dd:
            long r6 = r2 & r10
            int r8 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x00e8
            android.widget.ImageView r6 = r1.f14109i
            r6.setVisibility(r14)
        L_0x00e8:
            r6 = 21
            long r2 = r2 & r6
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x00f4
            android.widget.ImageView r2 = r1.j
            r2.setVisibility(r0)
        L_0x00f4:
            return
        L_0x00f5:
            r0 = move-exception
            monitor-exit(r21)     // Catch:{ all -> 0x00f5 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.iocl.a.f.executeBindings():void");
    }

    public final void a(int i2, View view) {
        if ((this.f14105e != null) && view != null && view.getContext() != null) {
            ((Activity) view.getContext()).onBackPressed();
        }
    }
}
