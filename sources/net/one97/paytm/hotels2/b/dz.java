package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.q;
import net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;

public final class dz extends dy {
    private static final ViewDataBinding.b j;
    private static final SparseIntArray k;
    private final ConstraintLayout l;
    private long m;

    static {
        ViewDataBinding.b bVar = new ViewDataBinding.b(8);
        j = bVar;
        bVar.a(0, new String[]{"h4_room_selection_header", "h4_room_selected_popup", "h4_room_selection_continue"}, new int[]{2, 3, 4}, new int[]{R.layout.h4_room_selection_header, R.layout.h4_room_selected_popup, R.layout.h4_room_selection_continue});
        SparseIntArray sparseIntArray = new SparseIntArray();
        k = sparseIntArray;
        sparseIntArray.put(R.id.lottieAnim, 5);
        k.put(R.id.room_options_recycleview, 6);
        k.put(R.id.ll_room_type_sticky_header, 7);
    }

    public dz(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 8, j, k));
    }

    private dz(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[7], objArr[5], objArr[6], objArr[3], objArr[1], objArr[4], objArr[2]);
        this.m = -1;
        this.l = objArr[0];
        this.l.setTag((Object) null);
        this.f29550e.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.m = 256;
        }
        this.f29552g.invalidateAll();
        this.f29549d.invalidateAll();
        this.f29551f.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r6.f29549d.hasPendingBindings() == false) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
        if (r6.f29551f.hasPendingBindings() == false) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0028, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.f29552g.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean hasPendingBindings() {
        /*
            r6 = this;
            monitor-enter(r6)
            long r0 = r6.m     // Catch:{ all -> 0x002a }
            r2 = 0
            r4 = 1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x000c
            monitor-exit(r6)     // Catch:{ all -> 0x002a }
            return r4
        L_0x000c:
            monitor-exit(r6)     // Catch:{ all -> 0x002a }
            net.one97.paytm.hotels2.b.dw r0 = r6.f29552g
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0016
            return r4
        L_0x0016:
            net.one97.paytm.hotels2.b.ds r0 = r6.f29549d
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x001f
            return r4
        L_0x001f:
            net.one97.paytm.hotels2.b.du r0 = r6.f29551f
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0028
            return r4
        L_0x0028:
            r0 = 0
            return r0
        L_0x002a:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x002a }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotels2.b.dz.hasPendingBindings():boolean");
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.ae == i2) {
            this.f29554i = (Boolean) obj;
        } else if (a.t != i2) {
            return false;
        } else {
            a((RoomSelectionViewModel) obj);
        }
        return true;
    }

    public final void a(RoomSelectionViewModel roomSelectionViewModel) {
        this.f29553h = roomSelectionViewModel;
        synchronized (this) {
            this.m |= 128;
        }
        notifyPropertyChanged(a.t);
        super.requestRebind();
    }

    public final void setLifecycleOwner(q qVar) {
        super.setLifecycleOwner(qVar);
        this.f29552g.setLifecycleOwner(qVar);
        this.f29549d.setLifecycleOwner(qVar);
        this.f29551f.setLifecycleOwner(qVar);
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return a(i3);
        }
        if (i2 == 1) {
            return b(i3);
        }
        if (i2 == 2) {
            return c(i3);
        }
        if (i2 == 3) {
            return d(i3);
        }
        if (i2 == 4) {
            return e(i3);
        }
        if (i2 != 5) {
            return false;
        }
        return f(i3);
    }

    private boolean a(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.m |= 1;
        }
        return true;
    }

    private boolean b(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.m |= 2;
        }
        return true;
    }

    private boolean c(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.m |= 4;
        }
        return true;
    }

    private boolean d(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.m |= 8;
        }
        return true;
    }

    private boolean e(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.m |= 16;
        }
        return true;
    }

    private boolean f(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.m |= 32;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r22 = this;
            r1 = r22
            monitor-enter(r22)
            long r2 = r1.m     // Catch:{ all -> 0x00f6 }
            r4 = 0
            r1.m = r4     // Catch:{ all -> 0x00f6 }
            monitor-exit(r22)     // Catch:{ all -> 0x00f6 }
            net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel r0 = r1.f29553h
            r6 = 425(0x1a9, double:2.1E-321)
            long r6 = r6 & r2
            r8 = 416(0x1a0, double:2.055E-321)
            r10 = 385(0x181, double:1.9E-321)
            r12 = 392(0x188, double:1.937E-321)
            r14 = 0
            int r16 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x00a3
            long r6 = r2 & r10
            int r16 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x0034
            if (r0 == 0) goto L_0x0027
            androidx.lifecycle.y r6 = r0.get_roomTypeCount()
            goto L_0x0028
        L_0x0027:
            r6 = 0
        L_0x0028:
            r1.updateLiveDataRegistration(r14, r6)
            if (r6 == 0) goto L_0x0034
            java.lang.Object r6 = r6.getValue()
            java.lang.String r6 = (java.lang.String) r6
            goto L_0x0035
        L_0x0034:
            r6 = 0
        L_0x0035:
            long r16 = r2 & r12
            int r18 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r18 == 0) goto L_0x0068
            if (r0 == 0) goto L_0x0044
            androidx.lifecycle.y r16 = r0.get_roomSelectedPopUp()
            r7 = r16
            goto L_0x0045
        L_0x0044:
            r7 = 0
        L_0x0045:
            r14 = 3
            r1.updateLiveDataRegistration(r14, r7)
            if (r7 == 0) goto L_0x0052
            java.lang.Object r7 = r7.getValue()
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            goto L_0x0053
        L_0x0052:
            r7 = 0
        L_0x0053:
            boolean r7 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r7)
            if (r18 == 0) goto L_0x0062
            if (r7 == 0) goto L_0x005e
            r18 = 1024(0x400, double:5.06E-321)
            goto L_0x0060
        L_0x005e:
            r18 = 512(0x200, double:2.53E-321)
        L_0x0060:
            long r2 = r2 | r18
        L_0x0062:
            if (r7 == 0) goto L_0x0065
            goto L_0x0068
        L_0x0065:
            r14 = 8
            goto L_0x0069
        L_0x0068:
            r14 = 0
        L_0x0069:
            long r18 = r2 & r8
            int r7 = (r18 > r4 ? 1 : (r18 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x00a1
            if (r0 == 0) goto L_0x0078
            androidx.lifecycle.y r18 = r0.get_selectedRoomDataContinue()
            r15 = r18
            goto L_0x0079
        L_0x0078:
            r15 = 0
        L_0x0079:
            r8 = 5
            r1.updateLiveDataRegistration(r8, r15)
            if (r15 == 0) goto L_0x0087
            java.lang.Object r8 = r15.getValue()
            r15 = r8
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            goto L_0x0088
        L_0x0087:
            r15 = 0
        L_0x0088:
            boolean r8 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r15)
            if (r7 == 0) goto L_0x0097
            if (r8 == 0) goto L_0x0093
            r20 = 4096(0x1000, double:2.0237E-320)
            goto L_0x0095
        L_0x0093:
            r20 = 2048(0x800, double:1.0118E-320)
        L_0x0095:
            long r2 = r2 | r20
        L_0x0097:
            if (r8 == 0) goto L_0x009c
            r16 = 0
            goto L_0x009e
        L_0x009c:
            r16 = 8
        L_0x009e:
            r7 = r16
            goto L_0x00a6
        L_0x00a1:
            r7 = 0
            goto L_0x00a6
        L_0x00a3:
            r6 = 0
            r7 = 0
            r14 = 0
        L_0x00a6:
            long r8 = r2 & r12
            int r12 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x00b5
            net.one97.paytm.hotels2.b.ds r8 = r1.f29549d
            android.view.View r8 = r8.getRoot()
            r8.setVisibility(r14)
        L_0x00b5:
            r8 = 384(0x180, double:1.897E-321)
            long r8 = r8 & r2
            int r12 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x00cb
            net.one97.paytm.hotels2.b.ds r8 = r1.f29549d
            r8.a(r0)
            net.one97.paytm.hotels2.b.du r8 = r1.f29551f
            r8.a(r0)
            net.one97.paytm.hotels2.b.dw r8 = r1.f29552g
            r8.a(r0)
        L_0x00cb:
            long r8 = r2 & r10
            int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00d6
            android.widget.TextView r0 = r1.f29550e
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r6)
        L_0x00d6:
            r8 = 416(0x1a0, double:2.055E-321)
            long r2 = r2 & r8
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00e6
            net.one97.paytm.hotels2.b.du r0 = r1.f29551f
            android.view.View r0 = r0.getRoot()
            r0.setVisibility(r7)
        L_0x00e6:
            net.one97.paytm.hotels2.b.dw r0 = r1.f29552g
            executeBindingsOn(r0)
            net.one97.paytm.hotels2.b.ds r0 = r1.f29549d
            executeBindingsOn(r0)
            net.one97.paytm.hotels2.b.du r0 = r1.f29551f
            executeBindingsOn(r0)
            return
        L_0x00f6:
            r0 = move-exception
            monitor-exit(r22)     // Catch:{ all -> 0x00f6 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotels2.b.dz.executeBindings():void");
    }
}
