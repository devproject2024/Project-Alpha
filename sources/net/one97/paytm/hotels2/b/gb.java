package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.lifecycle.q;
import net.one97.paytm.hotel4.viewmodel.HotelSearchViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;
import net.one97.paytm.hotels2.c.a.c;

public final class gb extends ga implements b.a, c.a {
    private static final ViewDataBinding.b k;
    private static final SparseIntArray l;
    private final ConstraintLayout m;
    private final ImageView n;
    private final ImageView o;
    private final d.c p;
    private final View.OnClickListener q;
    private final View.OnClickListener r;
    private long s;

    static {
        ViewDataBinding.b bVar = new ViewDataBinding.b(12);
        k = bVar;
        bVar.a(0, new String[]{"hotels_near_me"}, new int[]{8}, new int[]{R.layout.hotels_near_me});
        SparseIntArray sparseIntArray = new SparseIntArray();
        l = sparseIntArray;
        sparseIntArray.put(R.id.lottieAnim, 9);
        l.put(R.id.divider1, 10);
        l.put(R.id.divider, 11);
    }

    public gb(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 12, k, l));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private gb(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[11], objArr[10], objArr[2], objArr[1], objArr[8], objArr[9], objArr[6], objArr[5], objArr[4]);
        this.s = -1;
        this.f29798c.setTag((Object) null);
        this.f29799d.setTag((Object) null);
        this.m = objArr[0];
        this.m.setTag((Object) null);
        this.n = objArr[3];
        this.n.setTag((Object) null);
        this.o = objArr[7];
        this.o.setTag((Object) null);
        this.f29802g.setTag((Object) null);
        this.f29803h.setTag((Object) null);
        this.f29804i.setTag((Object) null);
        setRootTag(view);
        this.p = new c(this);
        this.q = new b(this, 3);
        this.r = new b(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.s = 16;
        }
        this.f29800e.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.f29800e.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean hasPendingBindings() {
        /*
            r6 = this;
            monitor-enter(r6)
            long r0 = r6.s     // Catch:{ all -> 0x0018 }
            r2 = 0
            r4 = 1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x000c
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            return r4
        L_0x000c:
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            net.one97.paytm.hotels2.b.gm r0 = r6.f29800e
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
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotels2.b.gb.hasPendingBindings():boolean");
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.L != i2) {
            return false;
        }
        a((HotelSearchViewModel) obj);
        return true;
    }

    public final void a(HotelSearchViewModel hotelSearchViewModel) {
        this.j = hotelSearchViewModel;
        synchronized (this) {
            this.s |= 8;
        }
        notifyPropertyChanged(a.L);
        super.requestRebind();
    }

    public final void setLifecycleOwner(q qVar) {
        super.setLifecycleOwner(qVar);
        this.f29800e.setLifecycleOwner(qVar);
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
            this.s |= 1;
        }
        return true;
    }

    private boolean c(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.s |= 2;
        }
        return true;
    }

    private boolean d(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.s |= 4;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0096  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r19 = this;
            r1 = r19
            monitor-enter(r19)
            long r2 = r1.s     // Catch:{ all -> 0x010c }
            r4 = 0
            r1.s = r4     // Catch:{ all -> 0x010c }
            monitor-exit(r19)     // Catch:{ all -> 0x010c }
            net.one97.paytm.hotel4.viewmodel.HotelSearchViewModel r0 = r1.j
            r6 = 27
            long r6 = r6 & r2
            r8 = 24
            r10 = 26
            r12 = 25
            r14 = 0
            r15 = 0
            int r16 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x00ab
            long r6 = r2 & r12
            r16 = 8
            r12 = 1
            int r13 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x0053
            if (r0 == 0) goto L_0x002b
            com.travel.utils.l r6 = r0.isCrossButtonVisible()
            goto L_0x002c
        L_0x002b:
            r6 = r15
        L_0x002c:
            r1.updateLiveDataRegistration(r14, r6)
            if (r6 == 0) goto L_0x0038
            java.lang.Object r6 = r6.getValue()
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            goto L_0x0039
        L_0x0038:
            r6 = r15
        L_0x0039:
            boolean r6 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r6)
            if (r6 != r12) goto L_0x0041
            r6 = 1
            goto L_0x0042
        L_0x0041:
            r6 = 0
        L_0x0042:
            if (r13 == 0) goto L_0x004d
            if (r6 == 0) goto L_0x0049
            r17 = 256(0x100, double:1.265E-321)
            goto L_0x004b
        L_0x0049:
            r17 = 128(0x80, double:6.32E-322)
        L_0x004b:
            long r2 = r2 | r17
        L_0x004d:
            if (r6 == 0) goto L_0x0050
            goto L_0x0053
        L_0x0050:
            r6 = 8
            goto L_0x0054
        L_0x0053:
            r6 = 0
        L_0x0054:
            long r17 = r2 & r10
            int r7 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x0096
            if (r0 == 0) goto L_0x0061
            androidx.lifecycle.y r13 = r0.isNoresultViewVisible()
            goto L_0x0062
        L_0x0061:
            r13 = r15
        L_0x0062:
            r1.updateLiveDataRegistration(r12, r13)
            if (r13 == 0) goto L_0x006e
            java.lang.Object r13 = r13.getValue()
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            goto L_0x006f
        L_0x006e:
            r13 = r15
        L_0x006f:
            boolean r13 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r13)
            if (r13 != r12) goto L_0x0076
            goto L_0x0077
        L_0x0076:
            r12 = 0
        L_0x0077:
            if (r7 == 0) goto L_0x008a
            if (r12 == 0) goto L_0x0082
            r17 = 64
            long r2 = r2 | r17
            r17 = 1024(0x400, double:5.06E-321)
            goto L_0x0088
        L_0x0082:
            r17 = 32
            long r2 = r2 | r17
            r17 = 512(0x200, double:2.53E-321)
        L_0x0088:
            long r2 = r2 | r17
        L_0x008a:
            if (r12 == 0) goto L_0x008f
            r7 = 8
            goto L_0x0090
        L_0x008f:
            r7 = 0
        L_0x0090:
            if (r12 == 0) goto L_0x0094
            r16 = 0
        L_0x0094:
            r14 = r7
            goto L_0x0098
        L_0x0096:
            r16 = 0
        L_0x0098:
            long r12 = r2 & r8
            int r7 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x00a6
            if (r0 == 0) goto L_0x00a6
            java.lang.String r7 = r0.getNoSearchResultURL()
            r12 = r6
            goto L_0x00a8
        L_0x00a6:
            r12 = r6
            r7 = r15
        L_0x00a8:
            r6 = r16
            goto L_0x00ae
        L_0x00ab:
            r7 = r15
            r6 = 0
            r12 = 0
        L_0x00ae:
            r17 = 16
            long r17 = r2 & r17
            int r13 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x00d5
            android.widget.EditText r13 = r1.f29798c
            androidx.databinding.a.d$c r8 = r1.p
            androidx.databinding.a.d.a(r13, r8, r15, r15)
            android.widget.ImageButton r8 = r1.f29799d
            android.view.View$OnClickListener r9 = r1.r
            r8.setOnClickListener(r9)
            android.widget.ImageView r8 = r1.n
            android.view.View$OnClickListener r9 = r1.q
            r8.setOnClickListener(r9)
            androidx.recyclerview.widget.RecyclerView r8 = r1.f29803h
            net.one97.paytm.hotel4.utils.a.a((android.view.View) r8)
            androidx.recyclerview.widget.RecyclerView r8 = r1.f29804i
            net.one97.paytm.hotel4.utils.a.a((android.view.View) r8)
        L_0x00d5:
            long r8 = r2 & r10
            int r10 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x00e9
            net.one97.paytm.hotels2.b.gm r8 = r1.f29800e
            android.view.View r8 = r8.getRoot()
            r8.setVisibility(r14)
            android.widget.LinearLayout r8 = r1.f29802g
            r8.setVisibility(r6)
        L_0x00e9:
            r8 = 24
            long r8 = r8 & r2
            int r6 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x00fa
            net.one97.paytm.hotels2.b.gm r6 = r1.f29800e
            r6.a(r0)
            android.widget.ImageView r0 = r1.o
            net.one97.paytm.hotel4.utils.a.a(r0, r7, r15, r15)
        L_0x00fa:
            r6 = 25
            long r2 = r2 & r6
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0106
            android.widget.ImageView r0 = r1.n
            r0.setVisibility(r12)
        L_0x0106:
            net.one97.paytm.hotels2.b.gm r0 = r1.f29800e
            executeBindingsOn(r0)
            return
        L_0x010c:
            r0 = move-exception
            monitor-exit(r19)     // Catch:{ all -> 0x010c }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotels2.b.gb.executeBindings():void");
    }

    public final void a(CharSequence charSequence) {
        HotelSearchViewModel hotelSearchViewModel = this.j;
        if (hotelSearchViewModel != null) {
            hotelSearchViewModel.onSearchTextChanged(charSequence);
        }
    }

    public final void a(int i2) {
        boolean z = false;
        if (i2 == 1) {
            HotelSearchViewModel hotelSearchViewModel = this.j;
            if (hotelSearchViewModel != null) {
                z = true;
            }
            if (z) {
                hotelSearchViewModel.backPressed();
            }
        } else if (i2 == 3) {
            HotelSearchViewModel hotelSearchViewModel2 = this.j;
            if (hotelSearchViewModel2 != null) {
                z = true;
            }
            if (z) {
                hotelSearchViewModel2.clearAllClick();
            }
        }
    }
}
