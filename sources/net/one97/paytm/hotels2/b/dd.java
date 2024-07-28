package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.hotel4.viewmodel.ReviewViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;

public final class dd extends dc {

    /* renamed from: i  reason: collision with root package name */
    private static final ViewDataBinding.b f29455i = null;
    private static final SparseIntArray j;
    private final ConstraintLayout k;
    private long l;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        j = sparseIntArray;
        sparseIntArray.put(R.id.line_top, 4);
        j.put(R.id.iv_hotelCard, 5);
        j.put(R.id.iv_hotel, 6);
        j.put(R.id.iv_map, 7);
    }

    public dd(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 8, f29455i, j));
    }

    private dd(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[6], objArr[5], objArr[7], objArr[4], objArr[3], objArr[1], objArr[2]);
        this.l = -1;
        this.k = objArr[0];
        this.k.setTag((Object) null);
        this.f29451e.setTag((Object) null);
        this.f29452f.setTag((Object) null);
        this.f29453g.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.l = 16;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.l != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.t != i2) {
            return false;
        }
        a((ReviewViewModel) obj);
        return true;
    }

    public final void a(ReviewViewModel reviewViewModel) {
        this.f29454h = reviewViewModel;
        synchronized (this) {
            this.l |= 8;
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
        if (i2 != 2) {
            return false;
        }
        return c(i3);
    }

    private boolean a(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.l |= 1;
        }
        return true;
    }

    private boolean b(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.l |= 2;
        }
        return true;
    }

    private boolean c(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.l |= 4;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0058  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r18 = this;
            r1 = r18
            monitor-enter(r18)
            long r2 = r1.l     // Catch:{ all -> 0x009e }
            r4 = 0
            r1.l = r4     // Catch:{ all -> 0x009e }
            monitor-exit(r18)     // Catch:{ all -> 0x009e }
            net.one97.paytm.hotel4.viewmodel.ReviewViewModel r0 = r1.f29454h
            r6 = 31
            long r6 = r6 & r2
            r8 = 28
            r10 = 26
            r12 = 25
            r14 = 0
            int r15 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x007d
            long r6 = r2 & r12
            int r15 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x0035
            if (r0 == 0) goto L_0x0027
            androidx.lifecycle.y r6 = r0.get_hotelFullAddress()
            goto L_0x0028
        L_0x0027:
            r6 = r14
        L_0x0028:
            r7 = 0
            r1.updateLiveDataRegistration(r7, r6)
            if (r6 == 0) goto L_0x0035
            java.lang.Object r6 = r6.getValue()
            java.lang.String r6 = (java.lang.String) r6
            goto L_0x0036
        L_0x0035:
            r6 = r14
        L_0x0036:
            long r15 = r2 & r10
            int r7 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x0051
            if (r0 == 0) goto L_0x0043
            androidx.lifecycle.y r7 = r0.get_hotelName()
            goto L_0x0044
        L_0x0043:
            r7 = r14
        L_0x0044:
            r15 = 1
            r1.updateLiveDataRegistration(r15, r7)
            if (r7 == 0) goto L_0x0051
            java.lang.Object r7 = r7.getValue()
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x0052
        L_0x0051:
            r7 = r14
        L_0x0052:
            long r15 = r2 & r8
            int r17 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r17 == 0) goto L_0x007f
            if (r0 == 0) goto L_0x005f
            androidx.lifecycle.y r0 = r0.getSelectedData()
            goto L_0x0060
        L_0x005f:
            r0 = r14
        L_0x0060:
            r15 = 2
            r1.updateLiveDataRegistration(r15, r0)
            if (r0 == 0) goto L_0x006d
            java.lang.Object r0 = r0.getValue()
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem r0 = (net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem) r0
            goto L_0x006e
        L_0x006d:
            r0 = r14
        L_0x006e:
            if (r0 == 0) goto L_0x0075
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.Ratings r0 = r0.getRatings()
            goto L_0x0076
        L_0x0075:
            r0 = r14
        L_0x0076:
            if (r0 == 0) goto L_0x007f
            java.lang.String r14 = r0.getStarRating()
            goto L_0x007f
        L_0x007d:
            r6 = r14
            r7 = r6
        L_0x007f:
            long r12 = r12 & r2
            int r0 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0089
            android.widget.TextView r0 = r1.f29451e
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r6)
        L_0x0089:
            long r10 = r10 & r2
            int r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0093
            android.widget.TextView r0 = r1.f29452f
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r7)
        L_0x0093:
            long r2 = r2 & r8
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x009d
            android.widget.TextView r0 = r1.f29453g
            net.one97.paytm.hotel4.utils.a.b((android.widget.TextView) r0, (java.lang.String) r14)
        L_0x009d:
            return
        L_0x009e:
            r0 = move-exception
            monitor-exit(r18)     // Catch:{ all -> 0x009e }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotels2.b.dd.executeBindings():void");
    }
}
