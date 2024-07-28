package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.q;
import net.one97.paytm.hotel4.viewmodel.DetailsViewModel;
import net.one97.paytm.hotel4.viewmodel.GalleryViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;

public final class bd extends bc implements b.a {

    /* renamed from: g  reason: collision with root package name */
    private static final ViewDataBinding.b f29235g;

    /* renamed from: h  reason: collision with root package name */
    private static final SparseIntArray f29236h;

    /* renamed from: i  reason: collision with root package name */
    private final ConstraintLayout f29237i;
    private final View.OnClickListener j;
    private long k;

    static {
        ViewDataBinding.b bVar = new ViewDataBinding.b(5);
        f29235g = bVar;
        bVar.a(0, new String[]{"h4_gallery_header"}, new int[]{2}, new int[]{R.layout.h4_gallery_header});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f29236h = sparseIntArray;
        sparseIntArray.put(R.id.viewPager, 3);
        f29236h.put(R.id.pager_header, 4);
    }

    public bd(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 5, f29235g, f29236h));
    }

    private bd(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[4], objArr[2], objArr[3]);
        this.k = -1;
        this.f29229a.setTag((Object) null);
        this.f29237i = objArr[0];
        this.f29237i.setTag((Object) null);
        setRootTag(view);
        this.j = new b(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.k = 8;
        }
        this.f29231c.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.f29231c.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean hasPendingBindings() {
        /*
            r6 = this;
            monitor-enter(r6)
            long r0 = r6.k     // Catch:{ all -> 0x0018 }
            r2 = 0
            r4 = 1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x000c
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            return r4
        L_0x000c:
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            net.one97.paytm.hotels2.b.be r0 = r6.f29231c
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0016
            return r4
        L_0x0016:
            r0 = 0
            return r0
        L_0x0018:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotels2.b.bd.hasPendingBindings():boolean");
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.n == i2) {
            a((DetailsViewModel) obj);
        } else if (a.t != i2) {
            return false;
        } else {
            a((GalleryViewModel) obj);
        }
        return true;
    }

    public final void a(DetailsViewModel detailsViewModel) {
        this.f29234f = detailsViewModel;
        synchronized (this) {
            this.k |= 2;
        }
        notifyPropertyChanged(a.n);
        super.requestRebind();
    }

    public final void a(GalleryViewModel galleryViewModel) {
        this.f29233e = galleryViewModel;
        synchronized (this) {
            this.k |= 4;
        }
        notifyPropertyChanged(a.t);
        super.requestRebind();
    }

    public final void setLifecycleOwner(q qVar) {
        super.setLifecycleOwner(qVar);
        this.f29231c.setLifecycleOwner(qVar);
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return b(i3);
    }

    private boolean b(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.k |= 1;
        }
        return true;
    }

    public final void executeBindings() {
        long j2;
        synchronized (this) {
            j2 = this.k;
            this.k = 0;
        }
        DetailsViewModel detailsViewModel = this.f29234f;
        GalleryViewModel galleryViewModel = this.f29233e;
        if ((8 & j2) != 0) {
            this.f29229a.setOnClickListener(this.j);
        }
        if ((12 & j2) != 0) {
            this.f29231c.a(galleryViewModel);
        }
        if ((j2 & 10) != 0) {
            this.f29231c.a(detailsViewModel);
        }
        executeBindingsOn(this.f29231c);
    }

    public final void a(int i2) {
        GalleryViewModel galleryViewModel = this.f29233e;
        if (galleryViewModel != null) {
            galleryViewModel.onSelectRoomPressed();
        }
    }
}
