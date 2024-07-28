package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.hotel4.viewmodel.PagerGalleryViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;

public final class bh extends bg implements b.a {

    /* renamed from: h  reason: collision with root package name */
    private static final ViewDataBinding.b f29254h = null;

    /* renamed from: i  reason: collision with root package name */
    private static final SparseIntArray f29255i;
    private final ConstraintLayout j;
    private final View.OnClickListener k;
    private long l;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f29255i = sparseIntArray;
        sparseIntArray.put(R.id.ll_title, 4);
        f29255i.put(R.id.tv_of, 5);
        f29255i.put(R.id.galleryListPager, 6);
    }

    public bh(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 7, f29254h, f29255i));
    }

    private bh(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[6], objArr[3], objArr[4], objArr[1], objArr[2], objArr[5]);
        this.l = -1;
        this.f29248b.setTag((Object) null);
        this.j = objArr[0];
        this.j.setTag((Object) null);
        this.f29250d.setTag((Object) null);
        this.f29251e.setTag((Object) null);
        setRootTag(view);
        this.k = new b(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.l = 8;
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
        a((PagerGalleryViewModel) obj);
        return true;
    }

    public final void a(PagerGalleryViewModel pagerGalleryViewModel) {
        this.f29253g = pagerGalleryViewModel;
        synchronized (this) {
            this.l |= 4;
        }
        notifyPropertyChanged(a.t);
        super.requestRebind();
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return b(i3);
        }
        if (i2 != 1) {
            return false;
        }
        return c(i3);
    }

    private boolean b(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.l |= 1;
        }
        return true;
    }

    private boolean c(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.l |= 2;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0040  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r14 = this;
            monitor-enter(r14)
            long r0 = r14.l     // Catch:{ all -> 0x0082 }
            r2 = 0
            r14.l = r2     // Catch:{ all -> 0x0082 }
            monitor-exit(r14)     // Catch:{ all -> 0x0082 }
            net.one97.paytm.hotel4.viewmodel.PagerGalleryViewModel r4 = r14.f29253g
            r5 = 15
            long r5 = r5 & r0
            r7 = 14
            r9 = 13
            r11 = 0
            int r12 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r12 == 0) goto L_0x005d
            long r5 = r0 & r9
            int r12 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r12 == 0) goto L_0x0039
            if (r4 == 0) goto L_0x0023
            androidx.lifecycle.y r5 = r4.getPagerGalleryCountIndex()
            goto L_0x0024
        L_0x0023:
            r5 = r11
        L_0x0024:
            r6 = 0
            r14.updateLiveDataRegistration(r6, r5)
            if (r5 == 0) goto L_0x0031
            java.lang.Object r5 = r5.getValue()
            java.lang.Integer r5 = (java.lang.Integer) r5
            goto L_0x0032
        L_0x0031:
            r5 = r11
        L_0x0032:
            if (r5 == 0) goto L_0x0039
            java.lang.String r5 = r5.toString()
            goto L_0x003a
        L_0x0039:
            r5 = r11
        L_0x003a:
            long r12 = r0 & r7
            int r6 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r6 == 0) goto L_0x005e
            if (r4 == 0) goto L_0x0047
            androidx.lifecycle.y r4 = r4.getPagerGalleryImageIndex()
            goto L_0x0048
        L_0x0047:
            r4 = r11
        L_0x0048:
            r6 = 1
            r14.updateLiveDataRegistration(r6, r4)
            if (r4 == 0) goto L_0x0055
            java.lang.Object r4 = r4.getValue()
            java.lang.Integer r4 = (java.lang.Integer) r4
            goto L_0x0056
        L_0x0055:
            r4 = r11
        L_0x0056:
            if (r4 == 0) goto L_0x005e
            java.lang.String r11 = r4.toString()
            goto L_0x005e
        L_0x005d:
            r5 = r11
        L_0x005e:
            r12 = 8
            long r12 = r12 & r0
            int r4 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x006c
            android.widget.ImageView r4 = r14.f29248b
            android.view.View$OnClickListener r6 = r14.k
            r4.setOnClickListener(r6)
        L_0x006c:
            long r6 = r0 & r7
            int r4 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0077
            android.widget.TextView r4 = r14.f29250d
            androidx.databinding.a.d.a((android.widget.TextView) r4, (java.lang.CharSequence) r11)
        L_0x0077:
            long r0 = r0 & r9
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0081
            android.widget.TextView r0 = r14.f29251e
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r5)
        L_0x0081:
            return
        L_0x0082:
            r0 = move-exception
            monitor-exit(r14)     // Catch:{ all -> 0x0082 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotels2.b.bh.executeBindings():void");
    }

    public final void a(int i2) {
        PagerGalleryViewModel pagerGalleryViewModel = this.f29253g;
        if (pagerGalleryViewModel != null) {
            pagerGalleryViewModel.closeGalleryPagerFragment();
        }
    }
}
