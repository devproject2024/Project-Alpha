package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.hotel4.viewmodel.DetailsViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;

public final class t extends s {
    private static final ViewDataBinding.b k = null;
    private static final SparseIntArray l;
    private final ConstraintLayout m;
    private final TextView n;
    private long o;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        l = sparseIntArray;
        sparseIntArray.put(R.id.tv_checkin, 7);
        l.put(R.id.tv_checkout, 8);
        l.put(R.id.tv_night_moon_root, 9);
        l.put(R.id.rv_bullet_list, 10);
    }

    public t(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 11, k, l));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private t(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[10], objArr[7], objArr[8], objArr[2], objArr[6], objArr[5], objArr[3], objArr[9], objArr[1]);
        this.o = -1;
        this.m = objArr[0];
        this.m.setTag((Object) null);
        this.n = objArr[4];
        this.n.setTag((Object) null);
        this.f29936d.setTag((Object) null);
        this.f29937e.setTag((Object) null);
        this.f29938f.setTag((Object) null);
        this.f29939g.setTag((Object) null);
        this.f29941i.setTag((Object) null);
        View view2 = view;
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.o = 128;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.o != 0) {
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
            this.o |= 64;
        }
        notifyPropertyChanged(a.t);
        super.requestRebind();
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
            this.o |= 1;
        }
        return true;
    }

    private boolean b(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.o |= 2;
        }
        return true;
    }

    private boolean c(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.o |= 4;
        }
        return true;
    }

    private boolean d(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.o |= 8;
        }
        return true;
    }

    private boolean e(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.o |= 16;
        }
        return true;
    }

    private boolean f(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.o |= 32;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00bd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r27 = this;
            r1 = r27
            monitor-enter(r27)
            long r2 = r1.o     // Catch:{ all -> 0x0123 }
            r4 = 0
            r1.o = r4     // Catch:{ all -> 0x0123 }
            monitor-exit(r27)     // Catch:{ all -> 0x0123 }
            net.one97.paytm.hotel4.viewmodel.DetailsViewModel r0 = r1.j
            r6 = 255(0xff, double:1.26E-321)
            long r6 = r6 & r2
            r8 = 200(0xc8, double:9.9E-322)
            r10 = 196(0xc4, double:9.7E-322)
            r14 = 208(0xd0, double:1.03E-321)
            r16 = 193(0xc1, double:9.54E-322)
            r18 = 194(0xc2, double:9.6E-322)
            r20 = 0
            int r21 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r21 == 0) goto L_0x00d7
            long r6 = r2 & r16
            int r21 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r21 == 0) goto L_0x003b
            if (r0 == 0) goto L_0x002c
            androidx.lifecycle.y r6 = r0.get_cout()
            goto L_0x002e
        L_0x002c:
            r6 = r20
        L_0x002e:
            r7 = 0
            r1.updateLiveDataRegistration(r7, r6)
            if (r6 == 0) goto L_0x003b
            java.lang.Object r6 = r6.getValue()
            java.lang.String r6 = (java.lang.String) r6
            goto L_0x003d
        L_0x003b:
            r6 = r20
        L_0x003d:
            long r21 = r2 & r18
            int r7 = (r21 > r4 ? 1 : (r21 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x0059
            if (r0 == 0) goto L_0x004a
            androidx.lifecycle.y r7 = r0.get_nights_count_text()
            goto L_0x004c
        L_0x004a:
            r7 = r20
        L_0x004c:
            r12 = 1
            r1.updateLiveDataRegistration(r12, r7)
            if (r7 == 0) goto L_0x0059
            java.lang.Object r7 = r7.getValue()
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x005b
        L_0x0059:
            r7 = r20
        L_0x005b:
            long r12 = r2 & r10
            int r23 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r23 == 0) goto L_0x0077
            if (r0 == 0) goto L_0x0068
            androidx.lifecycle.y r12 = r0.get_nights_count()
            goto L_0x006a
        L_0x0068:
            r12 = r20
        L_0x006a:
            r13 = 2
            r1.updateLiveDataRegistration(r13, r12)
            if (r12 == 0) goto L_0x0077
            java.lang.Object r12 = r12.getValue()
            java.lang.String r12 = (java.lang.String) r12
            goto L_0x0079
        L_0x0077:
            r12 = r20
        L_0x0079:
            long r23 = r2 & r8
            int r13 = (r23 > r4 ? 1 : (r23 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x0095
            if (r0 == 0) goto L_0x0086
            androidx.lifecycle.y r13 = r0.get_cin()
            goto L_0x0088
        L_0x0086:
            r13 = r20
        L_0x0088:
            r8 = 3
            r1.updateLiveDataRegistration(r8, r13)
            if (r13 == 0) goto L_0x0095
            java.lang.Object r8 = r13.getValue()
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x0097
        L_0x0095:
            r8 = r20
        L_0x0097:
            long r25 = r2 & r14
            int r9 = (r25 > r4 ? 1 : (r25 == r4 ? 0 : -1))
            if (r9 == 0) goto L_0x00b3
            if (r0 == 0) goto L_0x00a4
            androidx.lifecycle.y r9 = r0.get_cin_date()
            goto L_0x00a6
        L_0x00a4:
            r9 = r20
        L_0x00a6:
            r13 = 4
            r1.updateLiveDataRegistration(r13, r9)
            if (r9 == 0) goto L_0x00b3
            java.lang.Object r9 = r9.getValue()
            java.lang.String r9 = (java.lang.String) r9
            goto L_0x00b5
        L_0x00b3:
            r9 = r20
        L_0x00b5:
            r21 = 224(0xe0, double:1.107E-321)
            long r25 = r2 & r21
            int r13 = (r25 > r4 ? 1 : (r25 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x00d4
            if (r0 == 0) goto L_0x00c4
            androidx.lifecycle.y r0 = r0.get_cout_date()
            goto L_0x00c6
        L_0x00c4:
            r0 = r20
        L_0x00c6:
            r13 = 5
            r1.updateLiveDataRegistration(r13, r0)
            if (r0 == 0) goto L_0x00d4
            java.lang.Object r0 = r0.getValue()
            r20 = r0
            java.lang.String r20 = (java.lang.String) r20
        L_0x00d4:
            r0 = r20
            goto L_0x00de
        L_0x00d7:
            r0 = r20
            r6 = r0
            r7 = r6
            r8 = r7
            r9 = r8
            r12 = r9
        L_0x00de:
            long r18 = r2 & r18
            int r13 = (r18 > r4 ? 1 : (r18 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x00e9
            android.widget.TextView r13 = r1.n
            androidx.databinding.a.d.a((android.widget.TextView) r13, (java.lang.CharSequence) r7)
        L_0x00e9:
            long r13 = r2 & r14
            int r7 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x00f4
            android.widget.TextView r7 = r1.f29936d
            androidx.databinding.a.d.a((android.widget.TextView) r7, (java.lang.CharSequence) r9)
        L_0x00f4:
            r13 = 224(0xe0, double:1.107E-321)
            long r13 = r13 & r2
            int r7 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x0100
            android.widget.TextView r7 = r1.f29937e
            androidx.databinding.a.d.a((android.widget.TextView) r7, (java.lang.CharSequence) r0)
        L_0x0100:
            long r13 = r2 & r16
            int r0 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x010b
            android.widget.TextView r0 = r1.f29938f
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r6)
        L_0x010b:
            long r6 = r2 & r10
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0116
            android.widget.TextView r0 = r1.f29939g
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r12)
        L_0x0116:
            r6 = 200(0xc8, double:9.9E-322)
            long r2 = r2 & r6
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0122
            android.widget.TextView r0 = r1.f29941i
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r8)
        L_0x0122:
            return
        L_0x0123:
            r0 = move-exception
            monitor-exit(r27)     // Catch:{ all -> 0x0123 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotels2.b.t.executeBindings():void");
    }
}
