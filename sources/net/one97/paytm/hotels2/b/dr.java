package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.q;
import androidx.lifecycle.y;
import net.one97.paytm.hotel4.viewmodel.DetailsViewModel;
import net.one97.paytm.hotel4.viewmodel.ReviewViewModel;
import net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;

public final class dr extends dq {
    private static final ViewDataBinding.b p;
    private static final SparseIntArray q;
    private final ConstraintLayout r;
    private long s;

    static {
        ViewDataBinding.b bVar = new ViewDataBinding.b(13);
        p = bVar;
        bVar.a(0, new String[]{"h4_rb_header", "h4_rb_process_pay"}, new int[]{3, 11}, new int[]{R.layout.h4_rb_header, R.layout.h4_rb_process_pay});
        p.a(2, new String[]{"h4_rb_hotel_detailes", "h4_rb_cin_cout", "h4_rb_guest_details", "h4_rb_room_detailes", "h4_rb_promo_code", "h4_rb_gst", "h4_rb_payment_summenry"}, new int[]{4, 5, 6, 7, 8, 9, 10}, new int[]{R.layout.h4_rb_hotel_detailes, R.layout.h4_rb_cin_cout, R.layout.h4_rb_guest_details, R.layout.h4_rb_room_detailes, R.layout.h4_rb_promo_code, R.layout.h4_rb_gst, R.layout.h4_rb_payment_summenry});
        SparseIntArray sparseIntArray = new SparseIntArray();
        q = sparseIntArray;
        sparseIntArray.put(R.id.lottieAnim, 12);
    }

    public dr(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 13, p, q));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private dr(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[11], objArr[12], objArr[0], objArr[1], objArr[10], objArr[5], objArr[9], objArr[6], objArr[3], objArr[4], objArr[8], objArr[7]);
        this.s = -1;
        this.r = objArr[2];
        this.r.setTag((Object) null);
        this.f29512c.setTag((Object) null);
        this.f29513d.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.s = 8192;
        }
        this.f29518i.invalidateAll();
        this.j.invalidateAll();
        this.f29515f.invalidateAll();
        this.f29517h.invalidateAll();
        this.l.invalidateAll();
        this.k.invalidateAll();
        this.f29516g.invalidateAll();
        this.f29514e.invalidateAll();
        this.f29510a.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r6.j.hasPendingBindings() == false) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
        if (r6.f29515f.hasPendingBindings() == false) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002e, code lost:
        if (r6.f29517h.hasPendingBindings() == false) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0030, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0037, code lost:
        if (r6.l.hasPendingBindings() == false) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0039, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0040, code lost:
        if (r6.k.hasPendingBindings() == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0042, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0049, code lost:
        if (r6.f29516g.hasPendingBindings() == false) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004b, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0052, code lost:
        if (r6.f29514e.hasPendingBindings() == false) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0054, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x005b, code lost:
        if (r6.f29510a.hasPendingBindings() == false) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x005d, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x005e, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.f29518i.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean hasPendingBindings() {
        /*
            r6 = this;
            monitor-enter(r6)
            long r0 = r6.s     // Catch:{ all -> 0x0060 }
            r2 = 0
            r4 = 1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x000c
            monitor-exit(r6)     // Catch:{ all -> 0x0060 }
            return r4
        L_0x000c:
            monitor-exit(r6)     // Catch:{ all -> 0x0060 }
            net.one97.paytm.hotels2.b.da r0 = r6.f29518i
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0016
            return r4
        L_0x0016:
            net.one97.paytm.hotels2.b.dc r0 = r6.j
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x001f
            return r4
        L_0x001f:
            net.one97.paytm.hotels2.b.cs r0 = r6.f29515f
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0028
            return r4
        L_0x0028:
            net.one97.paytm.hotels2.b.cy r0 = r6.f29517h
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0031
            return r4
        L_0x0031:
            net.one97.paytm.hotels2.b.do r0 = r6.l
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x003a
            return r4
        L_0x003a:
            net.one97.paytm.hotels2.b.dk r0 = r6.k
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0043
            return r4
        L_0x0043:
            net.one97.paytm.hotels2.b.cu r0 = r6.f29516g
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x004c
            return r4
        L_0x004c:
            net.one97.paytm.hotels2.b.de r0 = r6.f29514e
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0055
            return r4
        L_0x0055:
            net.one97.paytm.hotels2.b.dg r0 = r6.f29510a
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x005e
            return r4
        L_0x005e:
            r0 = 0
            return r0
        L_0x0060:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0060 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotels2.b.dr.hasPendingBindings():boolean");
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.v == i2) {
            a((DetailsViewModel) obj);
        } else if (a.Q == i2) {
            a((RoomSelectionViewModel) obj);
        } else if (a.t != i2) {
            return false;
        } else {
            a((ReviewViewModel) obj);
        }
        return true;
    }

    public final void a(DetailsViewModel detailsViewModel) {
        this.n = detailsViewModel;
        synchronized (this) {
            this.s |= 1024;
        }
        notifyPropertyChanged(a.v);
        super.requestRebind();
    }

    public final void a(RoomSelectionViewModel roomSelectionViewModel) {
        this.o = roomSelectionViewModel;
        synchronized (this) {
            this.s |= 2048;
        }
        notifyPropertyChanged(a.Q);
        super.requestRebind();
    }

    public final void a(ReviewViewModel reviewViewModel) {
        this.m = reviewViewModel;
        synchronized (this) {
            this.s |= 4096;
        }
        notifyPropertyChanged(a.t);
        super.requestRebind();
    }

    public final void setLifecycleOwner(q qVar) {
        super.setLifecycleOwner(qVar);
        this.f29518i.setLifecycleOwner(qVar);
        this.j.setLifecycleOwner(qVar);
        this.f29515f.setLifecycleOwner(qVar);
        this.f29517h.setLifecycleOwner(qVar);
        this.l.setLifecycleOwner(qVar);
        this.k.setLifecycleOwner(qVar);
        this.f29516g.setLifecycleOwner(qVar);
        this.f29514e.setLifecycleOwner(qVar);
        this.f29510a.setLifecycleOwner(qVar);
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
            case 9:
                return j(i3);
            default:
                return false;
        }
    }

    private boolean a(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.s |= 1;
        }
        return true;
    }

    private boolean b(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.s |= 2;
        }
        return true;
    }

    private boolean c(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.s |= 4;
        }
        return true;
    }

    private boolean d(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.s |= 8;
        }
        return true;
    }

    private boolean e(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.s |= 16;
        }
        return true;
    }

    private boolean f(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.s |= 32;
        }
        return true;
    }

    private boolean g(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.s |= 64;
        }
        return true;
    }

    private boolean h(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.s |= 128;
        }
        return true;
    }

    private boolean i(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.s |= 256;
        }
        return true;
    }

    private boolean j(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.s |= 512;
        }
        return true;
    }

    public final void executeBindings() {
        long j;
        synchronized (this) {
            j = this.s;
            this.s = 0;
        }
        DetailsViewModel detailsViewModel = this.n;
        RoomSelectionViewModel roomSelectionViewModel = this.o;
        ReviewViewModel reviewViewModel = this.m;
        int i2 = 0;
        int i3 = ((j & 12296) > 0 ? 1 : ((j & 12296) == 0 ? 0 : -1));
        if (i3 != 0) {
            Boolean bool = null;
            y<Boolean> yVar = reviewViewModel != null ? reviewViewModel.get_hotelGSTEnabled() : null;
            updateLiveDataRegistration(3, yVar);
            if (yVar != null) {
                bool = yVar.getValue();
            }
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            if (i3 != 0) {
                j |= safeUnbox ? 32768 : 16384;
            }
            if (!safeUnbox) {
                i2 = 8;
            }
        }
        if ((10240 & j) != 0) {
            this.f29510a.a(roomSelectionViewModel);
            this.f29514e.a(roomSelectionViewModel);
            this.f29515f.a(roomSelectionViewModel);
            this.l.a(roomSelectionViewModel);
        }
        if ((12288 & j) != 0) {
            this.f29510a.a(reviewViewModel);
            this.f29514e.a(reviewViewModel);
            this.f29515f.a(reviewViewModel);
            this.f29516g.a(reviewViewModel);
            this.f29517h.a(reviewViewModel);
            this.f29518i.a(reviewViewModel);
            this.j.a(reviewViewModel);
            this.k.a(reviewViewModel);
            this.l.a(reviewViewModel);
        }
        if ((8192 & j) != 0) {
            net.one97.paytm.hotel4.utils.a.a((View) this.f29513d);
        }
        if ((9216 & j) != 0) {
            this.f29515f.a(detailsViewModel);
        }
        if ((j & 12296) != 0) {
            this.f29516g.getRoot().setVisibility(i2);
        }
        executeBindingsOn(this.f29518i);
        executeBindingsOn(this.j);
        executeBindingsOn(this.f29515f);
        executeBindingsOn(this.f29517h);
        executeBindingsOn(this.l);
        executeBindingsOn(this.k);
        executeBindingsOn(this.f29516g);
        executeBindingsOn(this.f29514e);
        executeBindingsOn(this.f29510a);
    }
}
