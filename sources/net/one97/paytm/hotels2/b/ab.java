package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.lifecycle.q;
import androidx.lifecycle.y;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.Ratings;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem;
import net.one97.paytm.hotel4.viewmodel.DetailsViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;

public final class ab extends aa implements b.a {
    private static final ViewDataBinding.b u;
    private static final SparseIntArray v;
    private long A;
    private final LinearLayout w;
    private final go x;
    private final View.OnClickListener y;
    private final View.OnClickListener z;

    static {
        ViewDataBinding.b bVar = new ViewDataBinding.b(21);
        u = bVar;
        bVar.a(1, new String[]{"h4_details_image_selector"}, new int[]{8}, new int[]{R.layout.h4_details_image_selector});
        u.a(4, new String[]{"h4_details_header", "h4_details_cin_cout", "h4_details_amenities", "h4_details_address", "h4_details_about_hotel", "h4_details_policies", "h4_layout_similar_hotels"}, new int[]{9, 10, 11, 12, 13, 14, 15}, new int[]{R.layout.h4_details_header, R.layout.h4_details_cin_cout, R.layout.h4_details_amenities, R.layout.h4_details_address, R.layout.h4_details_about_hotel, R.layout.h4_details_policies, R.layout.h4_layout_similar_hotels});
        u.a(7, new String[]{"layout_details_screen_shimmer"}, new int[]{16}, new int[]{R.layout.layout_details_screen_shimmer});
        SparseIntArray sparseIntArray = new SparseIntArray();
        v = sparseIntArray;
        sparseIntArray.put(R.id.appBar, 17);
        v.put(R.id.toolbar, 18);
        v.put(R.id.backButton, 19);
        v.put(R.id.scrollView, 20);
    }

    public ab(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 21, u, v));
    }

    private ab(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[17], objArr[19], objArr[6], objArr[1], objArr[5], objArr[3], objArr[0], objArr[20], objArr[7], objArr[18], objArr[2], objArr[13], objArr[12], objArr[11], objArr[10], objArr[9], objArr[8], objArr[14], objArr[15]);
        this.A = -1;
        this.f29106c.setTag((Object) null);
        this.f29107d.setTag((Object) null);
        this.f29108e.setTag((Object) null);
        this.f29109f.setTag((Object) null);
        this.w = objArr[4];
        this.w.setTag((Object) null);
        this.x = objArr[16];
        setContainedBinding(this.x);
        this.f29110g.setTag((Object) null);
        this.f29112i.setTag((Object) null);
        this.k.setTag((Object) null);
        setRootTag(view);
        this.y = new b(this, 2);
        this.z = new b(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.A = 1024;
        }
        this.q.invalidateAll();
        this.p.invalidateAll();
        this.o.invalidateAll();
        this.n.invalidateAll();
        this.m.invalidateAll();
        this.l.invalidateAll();
        this.r.invalidateAll();
        this.s.invalidateAll();
        this.x.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r6.p.hasPendingBindings() == false) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
        if (r6.o.hasPendingBindings() == false) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002e, code lost:
        if (r6.n.hasPendingBindings() == false) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0030, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0037, code lost:
        if (r6.m.hasPendingBindings() == false) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0039, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0040, code lost:
        if (r6.l.hasPendingBindings() == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0042, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0049, code lost:
        if (r6.r.hasPendingBindings() == false) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004b, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0052, code lost:
        if (r6.s.hasPendingBindings() == false) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0054, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x005b, code lost:
        if (r6.x.hasPendingBindings() == false) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x005d, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x005e, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.q.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean hasPendingBindings() {
        /*
            r6 = this;
            monitor-enter(r6)
            long r0 = r6.A     // Catch:{ all -> 0x0060 }
            r2 = 0
            r4 = 1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x000c
            monitor-exit(r6)     // Catch:{ all -> 0x0060 }
            return r4
        L_0x000c:
            monitor-exit(r6)     // Catch:{ all -> 0x0060 }
            net.one97.paytm.hotels2.b.w r0 = r6.q
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0016
            return r4
        L_0x0016:
            net.one97.paytm.hotels2.b.u r0 = r6.p
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x001f
            return r4
        L_0x001f:
            net.one97.paytm.hotels2.b.s r0 = r6.o
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0028
            return r4
        L_0x0028:
            net.one97.paytm.hotels2.b.q r0 = r6.n
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0031
            return r4
        L_0x0031:
            net.one97.paytm.hotels2.b.o r0 = r6.m
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x003a
            return r4
        L_0x003a:
            net.one97.paytm.hotels2.b.m r0 = r6.l
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0043
            return r4
        L_0x0043:
            net.one97.paytm.hotels2.b.y r0 = r6.r
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x004c
            return r4
        L_0x004c:
            net.one97.paytm.hotels2.b.ca r0 = r6.s
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0055
            return r4
        L_0x0055:
            net.one97.paytm.hotels2.b.go r0 = r6.x
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
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotels2.b.ab.hasPendingBindings():boolean");
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.t != i2) {
            return false;
        }
        a((DetailsViewModel) obj);
        return true;
    }

    public final void a(DetailsViewModel detailsViewModel) {
        this.t = detailsViewModel;
        synchronized (this) {
            this.A |= 512;
        }
        notifyPropertyChanged(a.t);
        super.requestRebind();
    }

    public final void setLifecycleOwner(q qVar) {
        super.setLifecycleOwner(qVar);
        this.q.setLifecycleOwner(qVar);
        this.p.setLifecycleOwner(qVar);
        this.o.setLifecycleOwner(qVar);
        this.n.setLifecycleOwner(qVar);
        this.m.setLifecycleOwner(qVar);
        this.l.setLifecycleOwner(qVar);
        this.r.setLifecycleOwner(qVar);
        this.s.setLifecycleOwner(qVar);
        this.x.setLifecycleOwner(qVar);
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
            this.A |= 1;
        }
        return true;
    }

    private boolean c(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.A |= 2;
        }
        return true;
    }

    private boolean d(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.A |= 4;
        }
        return true;
    }

    private boolean e(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.A |= 8;
        }
        return true;
    }

    private boolean f(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.A |= 16;
        }
        return true;
    }

    private boolean g(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.A |= 32;
        }
        return true;
    }

    private boolean h(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.A |= 64;
        }
        return true;
    }

    private boolean i(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.A |= 128;
        }
        return true;
    }

    private boolean j(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.A |= 256;
        }
        return true;
    }

    public final void executeBindings() {
        long j;
        String str;
        Ratings ratings;
        synchronized (this) {
            j = this.A;
            this.A = 0;
        }
        DetailsViewModel detailsViewModel = this.t;
        String str2 = null;
        int i2 = ((1552 & j) > 0 ? 1 : ((1552 & j) == 0 ? 0 : -1));
        if (i2 != 0) {
            y<SRPDataItem> selectedData = detailsViewModel != null ? detailsViewModel.getSelectedData() : null;
            updateLiveDataRegistration(4, selectedData);
            SRPDataItem value = selectedData != null ? selectedData.getValue() : null;
            if (value != null) {
                ratings = value.getRatings();
                str = value.getName();
            } else {
                str = null;
                ratings = null;
            }
            if (ratings != null) {
                str2 = ratings.getStarRating();
            }
        } else {
            str = null;
        }
        if ((1024 & j) != 0) {
            this.f29106c.setOnClickListener(this.y);
            this.f29109f.setOnClickListener(this.z);
        }
        if (i2 != 0) {
            net.one97.paytm.hotel4.utils.a.b(this.f29108e, str2);
            d.a(this.k, (CharSequence) str);
        }
        if ((j & 1536) != 0) {
            this.l.a(detailsViewModel);
            this.m.a(detailsViewModel);
            this.n.a(detailsViewModel);
            this.o.a(detailsViewModel);
            this.p.a(detailsViewModel);
            this.q.a(detailsViewModel);
            this.r.a(detailsViewModel);
        }
        executeBindingsOn(this.q);
        executeBindingsOn(this.p);
        executeBindingsOn(this.o);
        executeBindingsOn(this.n);
        executeBindingsOn(this.m);
        executeBindingsOn(this.l);
        executeBindingsOn(this.r);
        executeBindingsOn(this.s);
        executeBindingsOn(this.x);
    }

    public final void a(int i2) {
        boolean z2 = false;
        if (i2 == 1) {
            DetailsViewModel detailsViewModel = this.t;
            if (detailsViewModel != null) {
                z2 = true;
            }
            if (z2) {
                detailsViewModel.onSharePressed();
            }
        } else if (i2 == 2) {
            DetailsViewModel detailsViewModel2 = this.t;
            if (detailsViewModel2 != null) {
                z2 = true;
            }
            if (z2) {
                detailsViewModel2.onSelectRoomPressed();
            }
        }
    }
}
