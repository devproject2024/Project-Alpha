package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.hotel4.viewmodel.DetailsViewModel;
import net.one97.paytm.hotel4.viewmodel.ReviewViewModel;
import net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;

public final class ct extends cs {
    private static final ViewDataBinding.b w = null;
    private static final SparseIntArray x;
    private long A;
    private final ConstraintLayout y;
    private final TextView z;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        x = sparseIntArray;
        sparseIntArray.put(R.id.line_bottom, 10);
        x.put(R.id.tv_checkin, 11);
        x.put(R.id.tv_checkout, 12);
        x.put(R.id.tv_night_moon_root, 13);
        x.put(R.id.cl_total_rooms, 14);
        x.put(R.id.tv_total_rooms, 15);
        x.put(R.id.cl_total_adults, 16);
        x.put(R.id.tv_total_adults, 17);
        x.put(R.id.cl_total_children, 18);
        x.put(R.id.tv_total_children, 19);
        x.put(R.id.line, 20);
    }

    public ct(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 21, w, x));
    }

    private ct(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[16], objArr[18], objArr[14], objArr[20], objArr[10], objArr[11], objArr[12], objArr[2], objArr[6], objArr[5], objArr[3], objArr[13], objArr[1], objArr[17], objArr[8], objArr[19], objArr[9], objArr[15], objArr[7]);
        this.A = -1;
        this.y = objArr[0];
        this.y.setTag((Object) null);
        this.z = objArr[4];
        this.z.setTag((Object) null);
        this.f29410h.setTag((Object) null);
        this.f29411i.setTag((Object) null);
        this.j.setTag((Object) null);
        this.k.setTag((Object) null);
        this.m.setTag((Object) null);
        this.o.setTag((Object) null);
        this.q.setTag((Object) null);
        this.s.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.A = 4096;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.A != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.O == i2) {
            a((ReviewViewModel) obj);
        } else if (a.Q == i2) {
            this.v = (RoomSelectionViewModel) obj;
        } else if (a.t != i2) {
            return false;
        } else {
            a((DetailsViewModel) obj);
        }
        return true;
    }

    public final void a(ReviewViewModel reviewViewModel) {
        this.u = reviewViewModel;
        synchronized (this) {
            this.A |= 512;
        }
        notifyPropertyChanged(a.O);
        super.requestRebind();
    }

    public final void a(RoomSelectionViewModel roomSelectionViewModel) {
        this.v = roomSelectionViewModel;
    }

    public final void a(DetailsViewModel detailsViewModel) {
        this.t = detailsViewModel;
        synchronized (this) {
            this.A |= 2048;
        }
        notifyPropertyChanged(a.t);
        super.requestRebind();
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return a(i3);
            case 1:
                return b(i3);
            case 2:
                return c(i3);
            case 3:
                return d(i3);
            case 4:
                return e(i3);
            case 5:
                return f(i3);
            case 6:
                return g(i3);
            case 7:
                return h(i3);
            case 8:
                return i(i3);
            default:
                return false;
        }
    }

    private boolean a(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.A |= 1;
        }
        return true;
    }

    private boolean b(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.A |= 2;
        }
        return true;
    }

    private boolean c(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.A |= 4;
        }
        return true;
    }

    private boolean d(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.A |= 8;
        }
        return true;
    }

    private boolean e(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.A |= 16;
        }
        return true;
    }

    private boolean f(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.A |= 32;
        }
        return true;
    }

    private boolean g(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.A |= 64;
        }
        return true;
    }

    private boolean h(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.A |= 128;
        }
        return true;
    }

    private boolean i(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.A |= 256;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x011a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r37 = this;
            r1 = r37
            monitor-enter(r37)
            long r2 = r1.A     // Catch:{ all -> 0x019f }
            r4 = 0
            r1.A = r4     // Catch:{ all -> 0x019f }
            monitor-exit(r37)     // Catch:{ all -> 0x019f }
            net.one97.paytm.hotel4.viewmodel.ReviewViewModel r0 = r1.u
            net.one97.paytm.hotel4.viewmodel.DetailsViewModel r6 = r1.t
            r7 = 4746(0x128a, double:2.345E-320)
            long r7 = r7 & r2
            r9 = 4736(0x1280, double:2.34E-320)
            r11 = 4616(0x1208, double:2.2806E-320)
            r13 = 4610(0x1202, double:2.2776E-320)
            int r16 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x0071
            long r7 = r2 & r13
            int r16 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x0036
            if (r0 == 0) goto L_0x0028
            androidx.lifecycle.y r7 = r0.getRoomCount()
            goto L_0x0029
        L_0x0028:
            r7 = 0
        L_0x0029:
            r8 = 1
            r1.updateLiveDataRegistration(r8, r7)
            if (r7 == 0) goto L_0x0036
            java.lang.Object r7 = r7.getValue()
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x0037
        L_0x0036:
            r7 = 0
        L_0x0037:
            long r16 = r2 & r11
            int r8 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x0053
            if (r0 == 0) goto L_0x0044
            androidx.lifecycle.y r8 = r0.getChildCount()
            goto L_0x0045
        L_0x0044:
            r8 = 0
        L_0x0045:
            r15 = 3
            r1.updateLiveDataRegistration(r15, r8)
            if (r8 == 0) goto L_0x0053
            java.lang.Object r8 = r8.getValue()
            r15 = r8
            java.lang.String r15 = (java.lang.String) r15
            goto L_0x0054
        L_0x0053:
            r15 = 0
        L_0x0054:
            long r17 = r2 & r9
            int r8 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x006f
            if (r0 == 0) goto L_0x0061
            androidx.lifecycle.y r0 = r0.getAdultCount()
            goto L_0x0062
        L_0x0061:
            r0 = 0
        L_0x0062:
            r8 = 7
            r1.updateLiveDataRegistration(r8, r0)
            if (r0 == 0) goto L_0x006f
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x0074
        L_0x006f:
            r0 = 0
            goto L_0x0074
        L_0x0071:
            r0 = 0
            r7 = 0
            r15 = 0
        L_0x0074:
            r17 = 6517(0x1975, double:3.22E-320)
            long r17 = r2 & r17
            r19 = 6176(0x1820, double:3.0513E-320)
            r21 = 6160(0x1810, double:3.0434E-320)
            r23 = 6400(0x1900, double:3.162E-320)
            r25 = 6208(0x1840, double:3.067E-320)
            r27 = 6145(0x1801, double:3.036E-320)
            r29 = 6148(0x1804, double:3.0375E-320)
            int r8 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x0132
            long r17 = r2 & r27
            int r8 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x00a3
            if (r6 == 0) goto L_0x0095
            androidx.lifecycle.y r8 = r6.get_cout()
            goto L_0x0096
        L_0x0095:
            r8 = 0
        L_0x0096:
            r13 = 0
            r1.updateLiveDataRegistration(r13, r8)
            if (r8 == 0) goto L_0x00a3
            java.lang.Object r8 = r8.getValue()
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x00a4
        L_0x00a3:
            r8 = 0
        L_0x00a4:
            long r13 = r2 & r29
            int r31 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r31 == 0) goto L_0x00bf
            if (r6 == 0) goto L_0x00b1
            androidx.lifecycle.y r13 = r6.get_nights_count_text()
            goto L_0x00b2
        L_0x00b1:
            r13 = 0
        L_0x00b2:
            r14 = 2
            r1.updateLiveDataRegistration(r14, r13)
            if (r13 == 0) goto L_0x00bf
            java.lang.Object r13 = r13.getValue()
            java.lang.String r13 = (java.lang.String) r13
            goto L_0x00c0
        L_0x00bf:
            r13 = 0
        L_0x00c0:
            long r31 = r2 & r21
            int r14 = (r31 > r4 ? 1 : (r31 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x00db
            if (r6 == 0) goto L_0x00cd
            androidx.lifecycle.y r14 = r6.get_nights_count()
            goto L_0x00ce
        L_0x00cd:
            r14 = 0
        L_0x00ce:
            r11 = 4
            r1.updateLiveDataRegistration(r11, r14)
            if (r14 == 0) goto L_0x00db
            java.lang.Object r11 = r14.getValue()
            java.lang.String r11 = (java.lang.String) r11
            goto L_0x00dc
        L_0x00db:
            r11 = 0
        L_0x00dc:
            long r33 = r2 & r19
            int r12 = (r33 > r4 ? 1 : (r33 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x00f7
            if (r6 == 0) goto L_0x00e9
            androidx.lifecycle.y r12 = r6.get_cin()
            goto L_0x00ea
        L_0x00e9:
            r12 = 0
        L_0x00ea:
            r14 = 5
            r1.updateLiveDataRegistration(r14, r12)
            if (r12 == 0) goto L_0x00f7
            java.lang.Object r12 = r12.getValue()
            java.lang.String r12 = (java.lang.String) r12
            goto L_0x00f8
        L_0x00f7:
            r12 = 0
        L_0x00f8:
            long r33 = r2 & r25
            int r14 = (r33 > r4 ? 1 : (r33 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x0113
            if (r6 == 0) goto L_0x0105
            androidx.lifecycle.y r14 = r6.get_cin_date()
            goto L_0x0106
        L_0x0105:
            r14 = 0
        L_0x0106:
            r9 = 6
            r1.updateLiveDataRegistration(r9, r14)
            if (r14 == 0) goto L_0x0113
            java.lang.Object r9 = r14.getValue()
            java.lang.String r9 = (java.lang.String) r9
            goto L_0x0114
        L_0x0113:
            r9 = 0
        L_0x0114:
            long r35 = r2 & r23
            int r10 = (r35 > r4 ? 1 : (r35 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x0130
            if (r6 == 0) goto L_0x0121
            androidx.lifecycle.y r6 = r6.get_cout_date()
            goto L_0x0122
        L_0x0121:
            r6 = 0
        L_0x0122:
            r10 = 8
            r1.updateLiveDataRegistration(r10, r6)
            if (r6 == 0) goto L_0x0130
            java.lang.Object r6 = r6.getValue()
            java.lang.String r6 = (java.lang.String) r6
            goto L_0x0138
        L_0x0130:
            r6 = 0
            goto L_0x0138
        L_0x0132:
            r6 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            r12 = 0
            r13 = 0
        L_0x0138:
            long r29 = r2 & r29
            int r10 = (r29 > r4 ? 1 : (r29 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x0143
            android.widget.TextView r10 = r1.z
            androidx.databinding.a.d.a((android.widget.TextView) r10, (java.lang.CharSequence) r13)
        L_0x0143:
            long r13 = r2 & r25
            int r10 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x014e
            android.widget.TextView r10 = r1.f29410h
            androidx.databinding.a.d.a((android.widget.TextView) r10, (java.lang.CharSequence) r9)
        L_0x014e:
            long r9 = r2 & r23
            int r13 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x0159
            android.widget.TextView r9 = r1.f29411i
            androidx.databinding.a.d.a((android.widget.TextView) r9, (java.lang.CharSequence) r6)
        L_0x0159:
            long r9 = r2 & r27
            int r6 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0164
            android.widget.TextView r6 = r1.j
            androidx.databinding.a.d.a((android.widget.TextView) r6, (java.lang.CharSequence) r8)
        L_0x0164:
            long r8 = r2 & r21
            int r6 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x016f
            android.widget.TextView r6 = r1.k
            androidx.databinding.a.d.a((android.widget.TextView) r6, (java.lang.CharSequence) r11)
        L_0x016f:
            long r8 = r2 & r19
            int r6 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x017a
            android.widget.TextView r6 = r1.m
            androidx.databinding.a.d.a((android.widget.TextView) r6, (java.lang.CharSequence) r12)
        L_0x017a:
            r8 = 4736(0x1280, double:2.34E-320)
            long r8 = r8 & r2
            int r6 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0186
            android.widget.TextView r6 = r1.o
            androidx.databinding.a.d.a((android.widget.TextView) r6, (java.lang.CharSequence) r0)
        L_0x0186:
            r8 = 4616(0x1208, double:2.2806E-320)
            long r8 = r8 & r2
            int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0192
            android.widget.TextView r0 = r1.q
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r15)
        L_0x0192:
            r8 = 4610(0x1202, double:2.2776E-320)
            long r2 = r2 & r8
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x019e
            android.widget.TextView r0 = r1.s
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r7)
        L_0x019e:
            return
        L_0x019f:
            r0 = move-exception
            monitor-exit(r37)     // Catch:{ all -> 0x019f }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotels2.b.ct.executeBindings():void");
    }
}
