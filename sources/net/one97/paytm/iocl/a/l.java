package net.one97.paytm.iocl.a;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.i;
import net.one97.paytm.iocl.R;
import net.one97.paytm.iocl.b.a.a;
import net.one97.paytm.transport.iocl.c.c;

public final class l extends k implements a.C0194a {
    private static final ViewDataBinding.b s = null;
    private static final SparseIntArray t;
    private final ConstraintLayout u;
    private final View.OnClickListener v;
    private final View.OnClickListener w;
    private long x;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        t = sparseIntArray;
        sparseIntArray.put(R.id.left_guideline, 3);
        t.put(R.id.right_guideline, 4);
        t.put(R.id.tv_dialog_create_account, 5);
        t.put(R.id.iv_dialog_close, 6);
        t.put(R.id.tv_type, 7);
        t.put(R.id.view_divider_1, 8);
        t.put(R.id.tv_date, 9);
        t.put(R.id.tv_start_date, 10);
        t.put(R.id.tv_to, 11);
        t.put(R.id.tv_end_date, 12);
        t.put(R.id.view_divider_start_date, 13);
        t.put(R.id.view_divider_end_date, 14);
        t.put(R.id.view_divider_horizontal, 15);
        t.put(R.id.tv_clear_all, 16);
        t.put(R.id.tv_apply, 17);
    }

    public l(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 18, s, t));
    }

    private l(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[2], objArr[6], objArr[3], objArr[4], objArr[17], objArr[16], objArr[9], objArr[5], objArr[12], objArr[10], objArr[11], objArr[7], objArr[8], objArr[14], objArr[15], objArr[13]);
        this.x = -1;
        this.f14127a.setTag((Object) null);
        this.f14128b.setTag((Object) null);
        this.u = objArr[0];
        this.u.setTag((Object) null);
        setRootTag(view);
        this.v = new a(this, 2);
        this.w = new a(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.x = 8;
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
        if (net.one97.paytm.iocl.a.f14080d != i2) {
            return false;
        }
        a((c) obj);
        return true;
    }

    public final void a(c cVar) {
        this.r = cVar;
        synchronized (this) {
            this.x |= 4;
        }
        notifyPropertyChanged(net.one97.paytm.iocl.a.f14080d);
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
        if (i2 != net.one97.paytm.iocl.a.f14077a) {
            return false;
        }
        synchronized (this) {
            this.x |= 1;
        }
        return true;
    }

    private boolean b(int i2) {
        if (i2 != net.one97.paytm.iocl.a.f14077a) {
            return false;
        }
        synchronized (this) {
            this.x |= 2;
        }
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v2, resolved type: java.lang.Boolean} */
    /* JADX WARNING: type inference failed for: r13v0 */
    /* JADX WARNING: type inference failed for: r13v1, types: [android.graphics.drawable.Drawable] */
    /* JADX WARNING: type inference failed for: r13v4 */
    /* JADX WARNING: type inference failed for: r13v9 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r17 = this;
            r1 = r17
            monitor-enter(r17)
            long r2 = r1.x     // Catch:{ all -> 0x00e7 }
            r4 = 0
            r1.x = r4     // Catch:{ all -> 0x00e7 }
            monitor-exit(r17)     // Catch:{ all -> 0x00e7 }
            net.one97.paytm.transport.iocl.c.c r0 = r1.r
            r6 = 15
            long r6 = r6 & r2
            r8 = 13
            r10 = 14
            r12 = 0
            r13 = 0
            int r14 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x00b1
            long r6 = r2 & r8
            int r14 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x0063
            if (r0 == 0) goto L_0x0024
            androidx.databinding.i<java.lang.Boolean> r6 = r0.f14305b
            goto L_0x0025
        L_0x0024:
            r6 = r13
        L_0x0025:
            r1.updateRegistration((int) r12, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x0031
            java.lang.Object r6 = r6.get()
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            goto L_0x0032
        L_0x0031:
            r6 = r13
        L_0x0032:
            boolean r6 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r6)
            if (r14 == 0) goto L_0x0046
            if (r6 == 0) goto L_0x0040
            r14 = 128(0x80, double:6.32E-322)
            long r2 = r2 | r14
            r14 = 512(0x200, double:2.53E-321)
            goto L_0x0045
        L_0x0040:
            r14 = 64
            long r2 = r2 | r14
            r14 = 256(0x100, double:1.265E-321)
        L_0x0045:
            long r2 = r2 | r14
        L_0x0046:
            android.widget.Button r7 = r1.f14128b
            if (r6 == 0) goto L_0x004d
            int r14 = net.one97.paytm.iocl.R.drawable.bg_btn_blue_cylindrical
            goto L_0x004f
        L_0x004d:
            int r14 = net.one97.paytm.iocl.R.drawable.bg_btn_white_cylindrical
        L_0x004f:
            android.graphics.drawable.Drawable r7 = getDrawableFromResource(r7, r14)
            if (r6 == 0) goto L_0x005a
            android.widget.Button r6 = r1.f14128b
            int r14 = net.one97.paytm.iocl.R.color.iocl_white
            goto L_0x005e
        L_0x005a:
            android.widget.Button r6 = r1.f14128b
            int r14 = net.one97.paytm.iocl.R.color.iocl_black
        L_0x005e:
            int r6 = getColorFromResource(r6, r14)
            goto L_0x0065
        L_0x0063:
            r7 = r13
            r6 = 0
        L_0x0065:
            long r14 = r2 & r10
            int r16 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x00b3
            if (r0 == 0) goto L_0x0070
            androidx.databinding.i<java.lang.Boolean> r0 = r0.f14304a
            goto L_0x0071
        L_0x0070:
            r0 = r13
        L_0x0071:
            r12 = 1
            r1.updateRegistration((int) r12, (androidx.databinding.h) r0)
            if (r0 == 0) goto L_0x007e
            java.lang.Object r0 = r0.get()
            r13 = r0
            java.lang.Boolean r13 = (java.lang.Boolean) r13
        L_0x007e:
            boolean r0 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r13)
            if (r16 == 0) goto L_0x0092
            if (r0 == 0) goto L_0x008c
            r12 = 32
            long r2 = r2 | r12
            r12 = 2048(0x800, double:1.0118E-320)
            goto L_0x0091
        L_0x008c:
            r12 = 16
            long r2 = r2 | r12
            r12 = 1024(0x400, double:5.06E-321)
        L_0x0091:
            long r2 = r2 | r12
        L_0x0092:
            android.widget.Button r12 = r1.f14127a
            if (r0 == 0) goto L_0x0099
            int r13 = net.one97.paytm.iocl.R.drawable.bg_btn_blue_cylindrical
            goto L_0x009b
        L_0x0099:
            int r13 = net.one97.paytm.iocl.R.drawable.bg_btn_white_cylindrical
        L_0x009b:
            android.graphics.drawable.Drawable r12 = getDrawableFromResource(r12, r13)
            r13 = r12
            if (r0 == 0) goto L_0x00a7
            android.widget.Button r0 = r1.f14127a
            int r12 = net.one97.paytm.iocl.R.color.iocl_white
            goto L_0x00ab
        L_0x00a7:
            android.widget.Button r0 = r1.f14127a
            int r12 = net.one97.paytm.iocl.R.color.iocl_black
        L_0x00ab:
            int r0 = getColorFromResource(r0, r12)
            r12 = r0
            goto L_0x00b3
        L_0x00b1:
            r7 = r13
            r6 = 0
        L_0x00b3:
            long r10 = r10 & r2
            int r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00c2
            android.widget.Button r0 = r1.f14127a
            androidx.databinding.a.e.a((android.view.View) r0, (android.graphics.drawable.Drawable) r13)
            android.widget.Button r0 = r1.f14127a
            r0.setTextColor(r12)
        L_0x00c2:
            r10 = 8
            long r10 = r10 & r2
            int r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00d7
            android.widget.Button r0 = r1.f14127a
            android.view.View$OnClickListener r10 = r1.w
            r0.setOnClickListener(r10)
            android.widget.Button r0 = r1.f14128b
            android.view.View$OnClickListener r10 = r1.v
            r0.setOnClickListener(r10)
        L_0x00d7:
            long r2 = r2 & r8
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00e6
            android.widget.Button r0 = r1.f14128b
            androidx.databinding.a.e.a((android.view.View) r0, (android.graphics.drawable.Drawable) r7)
            android.widget.Button r0 = r1.f14128b
            r0.setTextColor(r6)
        L_0x00e6:
            return
        L_0x00e7:
            r0 = move-exception
            monitor-exit(r17)     // Catch:{ all -> 0x00e7 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.iocl.a.l.executeBindings():void");
    }

    public final void a(int i2, View view) {
        boolean z = false;
        if (i2 == 1) {
            c cVar = this.r;
            if (cVar != null) {
                i<Boolean> iVar = cVar.f14304a;
                if (iVar != null) {
                    z = true;
                }
                if (z) {
                    cVar.a(Boolean.valueOf(!iVar.get().booleanValue()).booleanValue());
                }
            }
        } else if (i2 == 2) {
            c cVar2 = this.r;
            if (cVar2 != null) {
                i<Boolean> iVar2 = cVar2.f14305b;
                if (iVar2 != null) {
                    z = true;
                }
                if (z) {
                    cVar2.b(Boolean.valueOf(!iVar2.get().booleanValue()).booleanValue());
                }
            }
        }
    }
}
