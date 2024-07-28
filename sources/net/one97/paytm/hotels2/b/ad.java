package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.hotel4.service.model.GuestAndRoomCountDetails;
import net.one97.paytm.hotel4.viewmodel.EditSearchViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;

public final class ad extends ac implements b.a {
    private static final ViewDataBinding.b l = null;
    private static final SparseIntArray m;
    private final ConstraintLayout n;
    private final View.OnClickListener o;
    private final View.OnClickListener p;
    private long q;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        m = sparseIntArray;
        sparseIntArray.put(R.id.parent_count_plus, 8);
        m.put(R.id.parent_count_minus, 9);
    }

    public ad(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 10, l, m));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private ad(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[6], objArr[7], objArr[3], objArr[4], objArr[5], objArr[1], objArr[2], objArr[9], objArr[8]);
        this.q = -1;
        this.f29113a.setTag((Object) null);
        this.f29114b.setTag((Object) null);
        this.f29115c.setTag((Object) null);
        this.f29116d.setTag((Object) null);
        this.f29117e.setTag((Object) null);
        this.f29118f.setTag((Object) null);
        this.f29119g.setTag((Object) null);
        this.n = objArr[0];
        this.n.setTag((Object) null);
        setRootTag(view);
        this.o = new b(this, 1);
        this.p = new b(this, 2);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.q = 32;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.q != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.f29094i == i2) {
            a((GuestAndRoomCountDetails) obj);
        } else if (a.f29088c != i2) {
            return false;
        } else {
            a((EditSearchViewModel) obj);
        }
        return true;
    }

    public final void a(GuestAndRoomCountDetails guestAndRoomCountDetails) {
        this.k = guestAndRoomCountDetails;
        synchronized (this) {
            this.q |= 8;
        }
        notifyPropertyChanged(a.f29094i);
        super.requestRebind();
    }

    public final void a(EditSearchViewModel editSearchViewModel) {
        this.j = editSearchViewModel;
        synchronized (this) {
            this.q |= 16;
        }
        notifyPropertyChanged(a.f29088c);
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
            this.q |= 1;
        }
        return true;
    }

    private boolean c(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.q |= 2;
        }
        return true;
    }

    private boolean d(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.q |= 4;
        }
        return true;
    }

    /* JADX WARNING: type inference failed for: r7v0, types: [java.lang.CharSequence] */
    /* JADX WARNING: type inference failed for: r7v2 */
    /* JADX WARNING: type inference failed for: r7v4 */
    /* JADX WARNING: type inference failed for: r16v4, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00ec  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r24 = this;
            r1 = r24
            monitor-enter(r24)
            long r2 = r1.q     // Catch:{ all -> 0x0181 }
            r4 = 0
            r1.q = r4     // Catch:{ all -> 0x0181 }
            monitor-exit(r24)     // Catch:{ all -> 0x0181 }
            net.one97.paytm.hotel4.service.model.GuestAndRoomCountDetails r0 = r1.k
            r6 = 47
            long r6 = r6 & r2
            r10 = 41
            r12 = 42
            r14 = 40
            r16 = 0
            r8 = 0
            int r9 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r9 == 0) goto L_0x011b
            long r6 = r2 & r14
            int r17 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r17 == 0) goto L_0x0047
            if (r0 == 0) goto L_0x0031
            java.lang.String r6 = r0.getHeading()
            boolean r7 = r0.getSetSubHeadingVisible()
            java.lang.String r18 = r0.getSubHeading()
            goto L_0x0036
        L_0x0031:
            r6 = r16
            r18 = r6
            r7 = 0
        L_0x0036:
            if (r17 == 0) goto L_0x0041
            if (r7 == 0) goto L_0x003d
            r19 = 2048(0x800, double:1.0118E-320)
            goto L_0x003f
        L_0x003d:
            r19 = 1024(0x400, double:5.06E-321)
        L_0x003f:
            long r2 = r2 | r19
        L_0x0041:
            if (r7 == 0) goto L_0x0044
            goto L_0x004b
        L_0x0044:
            r7 = 8
            goto L_0x004c
        L_0x0047:
            r6 = r16
            r18 = r6
        L_0x004b:
            r7 = 0
        L_0x004c:
            long r19 = r2 & r10
            int r17 = (r19 > r4 ? 1 : (r19 == r4 ? 0 : -1))
            if (r17 == 0) goto L_0x0094
            if (r0 == 0) goto L_0x005b
            androidx.lifecycle.y r19 = r0.getShowDisabledPlus()
            r9 = r19
            goto L_0x005d
        L_0x005b:
            r9 = r16
        L_0x005d:
            r1.updateLiveDataRegistration(r8, r9)
            if (r9 == 0) goto L_0x0069
            java.lang.Object r9 = r9.getValue()
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            goto L_0x006b
        L_0x0069:
            r9 = r16
        L_0x006b:
            if (r9 == 0) goto L_0x0072
            boolean r9 = r9.booleanValue()
            goto L_0x0073
        L_0x0072:
            r9 = 0
        L_0x0073:
            if (r17 == 0) goto L_0x0086
            if (r9 == 0) goto L_0x007e
            r20 = 128(0x80, double:6.32E-322)
            long r2 = r2 | r20
            r20 = 8192(0x2000, double:4.0474E-320)
            goto L_0x0084
        L_0x007e:
            r20 = 64
            long r2 = r2 | r20
            r20 = 4096(0x1000, double:2.0237E-320)
        L_0x0084:
            long r2 = r2 | r20
        L_0x0086:
            if (r9 == 0) goto L_0x008b
            r17 = 8
            goto L_0x008d
        L_0x008b:
            r17 = 0
        L_0x008d:
            if (r9 == 0) goto L_0x0091
            r9 = 0
            goto L_0x0097
        L_0x0091:
            r9 = 8
            goto L_0x0097
        L_0x0094:
            r9 = 0
            r17 = 0
        L_0x0097:
            long r20 = r2 & r12
            int r22 = (r20 > r4 ? 1 : (r20 == r4 ? 0 : -1))
            if (r22 == 0) goto L_0x00e1
            if (r0 == 0) goto L_0x00a6
            androidx.lifecycle.y r20 = r0.getShowDisableMinus()
            r8 = r20
            goto L_0x00a8
        L_0x00a6:
            r8 = r16
        L_0x00a8:
            r14 = 1
            r1.updateLiveDataRegistration(r14, r8)
            if (r8 == 0) goto L_0x00b5
            java.lang.Object r8 = r8.getValue()
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            goto L_0x00b7
        L_0x00b5:
            r8 = r16
        L_0x00b7:
            if (r8 == 0) goto L_0x00be
            boolean r8 = r8.booleanValue()
            goto L_0x00bf
        L_0x00be:
            r8 = 0
        L_0x00bf:
            if (r22 == 0) goto L_0x00d0
            if (r8 == 0) goto L_0x00ca
            r14 = 512(0x200, double:2.53E-321)
            long r2 = r2 | r14
            r14 = 32768(0x8000, double:1.61895E-319)
            goto L_0x00cf
        L_0x00ca:
            r14 = 256(0x100, double:1.265E-321)
            long r2 = r2 | r14
            r14 = 16384(0x4000, double:8.0948E-320)
        L_0x00cf:
            long r2 = r2 | r14
        L_0x00d0:
            if (r8 == 0) goto L_0x00d5
            r14 = 8
            goto L_0x00d6
        L_0x00d5:
            r14 = 0
        L_0x00d6:
            if (r8 == 0) goto L_0x00db
            r19 = 0
            goto L_0x00dd
        L_0x00db:
            r19 = 8
        L_0x00dd:
            r8 = r14
            r14 = 44
            goto L_0x00e6
        L_0x00e1:
            r8 = 0
            r14 = 44
            r19 = 0
        L_0x00e6:
            long r21 = r2 & r14
            int r14 = (r21 > r4 ? 1 : (r21 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x010f
            if (r0 == 0) goto L_0x00f3
            androidx.lifecycle.y r0 = r0.getCount()
            goto L_0x00f5
        L_0x00f3:
            r0 = r16
        L_0x00f5:
            r14 = 2
            r1.updateLiveDataRegistration(r14, r0)
            if (r0 == 0) goto L_0x0103
            java.lang.Object r0 = r0.getValue()
            r16 = r0
            java.lang.Integer r16 = (java.lang.Integer) r16
        L_0x0103:
            if (r16 == 0) goto L_0x010a
            int r0 = r16.intValue()
            goto L_0x010b
        L_0x010a:
            r0 = 0
        L_0x010b:
            java.lang.String r16 = java.lang.String.valueOf(r0)
        L_0x010f:
            r14 = r6
            r23 = r7
            r7 = r16
            r6 = r17
            r15 = r18
            r0 = r19
            goto L_0x0125
        L_0x011b:
            r7 = r16
            r14 = r7
            r15 = r14
            r0 = 0
            r6 = 0
            r8 = 0
            r9 = 0
            r23 = 0
        L_0x0125:
            r17 = 32
            long r17 = r2 & r17
            int r16 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x013b
            androidx.constraintlayout.widget.ConstraintLayout r10 = r1.f29113a
            android.view.View$OnClickListener r11 = r1.p
            r10.setOnClickListener(r11)
            androidx.constraintlayout.widget.ConstraintLayout r10 = r1.f29115c
            android.view.View$OnClickListener r11 = r1.o
            r10.setOnClickListener(r11)
        L_0x013b:
            long r10 = r2 & r12
            int r12 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x014b
            androidx.constraintlayout.widget.ConstraintLayout r10 = r1.f29113a
            r10.setVisibility(r8)
            androidx.constraintlayout.widget.ConstraintLayout r8 = r1.f29114b
            r8.setVisibility(r0)
        L_0x014b:
            r10 = 41
            long r10 = r10 & r2
            int r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x015c
            androidx.constraintlayout.widget.ConstraintLayout r0 = r1.f29115c
            r0.setVisibility(r6)
            androidx.constraintlayout.widget.ConstraintLayout r0 = r1.f29116d
            r0.setVisibility(r9)
        L_0x015c:
            r8 = 44
            long r8 = r8 & r2
            int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0168
            android.widget.TextView r0 = r1.f29117e
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r7)
        L_0x0168:
            r6 = 40
            long r2 = r2 & r6
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0180
            android.widget.TextView r0 = r1.f29118f
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r14)
            android.widget.TextView r0 = r1.f29119g
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r15)
            android.widget.TextView r0 = r1.f29119g
            r7 = r23
            r0.setVisibility(r7)
        L_0x0180:
            return
        L_0x0181:
            r0 = move-exception
            monitor-exit(r24)     // Catch:{ all -> 0x0181 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotels2.b.ad.executeBindings():void");
    }

    public final void a(int i2) {
        boolean z = false;
        if (i2 == 1) {
            EditSearchViewModel editSearchViewModel = this.j;
            GuestAndRoomCountDetails guestAndRoomCountDetails = this.k;
            if (editSearchViewModel != null) {
                if (guestAndRoomCountDetails != null) {
                    z = true;
                }
                if (z) {
                    editSearchViewModel.increaseCount(guestAndRoomCountDetails.getTag());
                }
            }
        } else if (i2 == 2) {
            EditSearchViewModel editSearchViewModel2 = this.j;
            GuestAndRoomCountDetails guestAndRoomCountDetails2 = this.k;
            if (editSearchViewModel2 != null) {
                if (guestAndRoomCountDetails2 != null) {
                    z = true;
                }
                if (z) {
                    editSearchViewModel2.decreaseCount(guestAndRoomCountDetails2.getTag());
                }
            }
        }
    }
}
