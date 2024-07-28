package net.one97.paytm.feed.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import kotlin.g.b.k;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.d.a.a;
import net.one97.paytm.feed.e.b;
import net.one97.paytm.feed.repository.models.recommendedapps.RecommendedApps;
import net.one97.paytm.feed.ui.feed.l.d;

public final class db extends da implements a.C0556a {
    private static final ViewDataBinding.b s = null;
    private static final SparseIntArray t;
    private final View.OnClickListener u;
    private final View.OnClickListener v;
    private long w;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        t = sparseIntArray;
        sparseIntArray.put(R.id.app_rating_icon, 10);
        t.put(R.id.category, 11);
    }

    public db(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 12, s, t));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private db(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[5], objArr[3], objArr[4], objArr[10], objArr[8], objArr[11], objArr[0], objArr[9], objArr[7], objArr[1], objArr[2], objArr[6]);
        this.w = -1;
        this.f34128a.setTag((Object) null);
        this.f34129b.setTag((Object) null);
        this.f34130c.setTag((Object) null);
        this.f34132e.setTag((Object) null);
        this.f34134g.setTag((Object) null);
        this.f34135h.setTag((Object) null);
        this.f34136i.setTag((Object) null);
        this.j.setTag((Object) null);
        this.k.setTag((Object) null);
        this.l.setTag((Object) null);
        setRootTag(view);
        this.u = new a(this, 1);
        this.v = new a(this, 2);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.w = 64;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.w != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (net.one97.paytm.feed.a.F == i2) {
            this.o = (String) obj;
            synchronized (this) {
                this.w |= 1;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.F);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.f33781h == i2) {
            this.r = (String) obj;
            synchronized (this) {
                this.w |= 2;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33781h);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.f33780g == i2) {
            this.m = (RecommendedApps) obj;
            synchronized (this) {
                this.w |= 4;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33780g);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.f33782i == i2) {
            this.p = (Integer) obj;
            synchronized (this) {
                this.w |= 8;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33782i);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.f33775b == i2) {
            this.n = (d) obj;
            synchronized (this) {
                this.w |= 16;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33775b);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.v != i2) {
            return false;
        } else {
            this.q = (String) obj;
            synchronized (this) {
                this.w |= 32;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.v);
            super.requestRebind();
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r26 = this;
            r1 = r26
            monitor-enter(r26)
            long r2 = r1.w     // Catch:{ all -> 0x0128 }
            r4 = 0
            r1.w = r4     // Catch:{ all -> 0x0128 }
            monitor-exit(r26)     // Catch:{ all -> 0x0128 }
            java.lang.String r0 = r1.o
            java.lang.String r6 = r1.r
            net.one97.paytm.feed.repository.models.recommendedapps.RecommendedApps r7 = r1.m
            java.lang.Integer r8 = r1.p
            java.lang.String r9 = r1.q
            r10 = 66
            long r12 = r2 & r10
            int r15 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x0031
            if (r6 == 0) goto L_0x0020
            r6 = 1
            goto L_0x0021
        L_0x0020:
            r6 = 0
        L_0x0021:
            if (r15 == 0) goto L_0x002b
            if (r6 == 0) goto L_0x0028
            r12 = 256(0x100, double:1.265E-321)
            goto L_0x002a
        L_0x0028:
            r12 = 128(0x80, double:6.32E-322)
        L_0x002a:
            long r2 = r2 | r12
        L_0x002b:
            if (r6 == 0) goto L_0x002e
            goto L_0x0031
        L_0x002e:
            r6 = 8
            goto L_0x0032
        L_0x0031:
            r6 = 0
        L_0x0032:
            r12 = 100
            long r12 = r12 & r2
            r15 = 68
            r14 = 0
            int r18 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r18 == 0) goto L_0x00a9
            long r12 = r2 & r15
            int r19 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r19 == 0) goto L_0x007e
            if (r7 == 0) goto L_0x0065
            java.lang.String r12 = r7.getTitle()
            java.lang.String r13 = r7.getImageUrl()
            java.lang.String r17 = r7.getPackageName()
            java.lang.String r19 = r7.getDescription()
            java.lang.String r20 = r7.getType()
            r24 = r17
            r17 = r12
            r12 = r24
            r25 = r20
            r20 = r13
            r13 = r25
            goto L_0x006d
        L_0x0065:
            r12 = r14
            r13 = r12
            r17 = r13
            r19 = r17
            r20 = r19
        L_0x006d:
            int r21 = net.one97.paytm.feed.utility.b.b(r19)
            android.view.View r22 = r26.getRoot()
            android.content.Context r10 = r22.getContext()
            java.lang.String r10 = net.one97.paytm.feed.utility.b.a((android.content.Context) r10, (java.lang.String) r12, (java.lang.String) r13)
            goto L_0x0087
        L_0x007e:
            r10 = r14
            r17 = r10
            r19 = r17
            r20 = r19
            r21 = 0
        L_0x0087:
            if (r7 == 0) goto L_0x0092
            java.lang.String r11 = r7.getDownloads()
            java.lang.String r7 = r7.getRating()
            goto L_0x0094
        L_0x0092:
            r7 = r14
            r11 = r7
        L_0x0094:
            java.lang.String r11 = net.one97.paytm.feed.utility.b.a((java.lang.Object) r11, (java.lang.String) r9)
            java.lang.String r7 = net.one97.paytm.feed.utility.b.a((java.lang.Object) r7, (java.lang.String) r9)
            r23 = r7
            r12 = r10
            r13 = r11
            r11 = r17
            r7 = r19
            r10 = r20
            r9 = r21
            goto L_0x00b1
        L_0x00a9:
            r7 = r14
            r10 = r7
            r11 = r10
            r12 = r11
            r13 = r12
            r23 = r13
            r9 = 0
        L_0x00b1:
            long r15 = r15 & r2
            int r17 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r17 == 0) goto L_0x00cf
            android.widget.TextView r15 = r1.f34128a
            androidx.databinding.a.d.a((android.widget.TextView) r15, (java.lang.CharSequence) r7)
            android.widget.TextView r7 = r1.f34128a
            r7.setVisibility(r9)
            android.widget.ImageView r7 = r1.f34129b
            net.one97.paytm.feed.utility.a.a(r7, r10, r14, r14)
            android.widget.TextView r7 = r1.f34130c
            androidx.databinding.a.d.a((android.widget.TextView) r7, (java.lang.CharSequence) r11)
            android.widget.TextView r7 = r1.f34135h
            androidx.databinding.a.d.a((android.widget.TextView) r7, (java.lang.CharSequence) r12)
        L_0x00cf:
            r9 = 64
            long r9 = r9 & r2
            int r7 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x00ed
            android.widget.TextView r7 = r1.f34132e
            java.lang.String r9 = net.one97.paytm.feed.utility.b.a()
            net.one97.paytm.feed.utility.a.b((android.widget.TextView) r7, (java.lang.String) r9)
            android.widget.TextView r7 = r1.f34135h
            android.view.View$OnClickListener r9 = r1.v
            r7.setOnClickListener(r9)
            android.widget.TextView r7 = r1.k
            android.view.View$OnClickListener r9 = r1.u
            r7.setOnClickListener(r9)
        L_0x00ed:
            r9 = 72
            long r9 = r9 & r2
            int r7 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x0101
            android.widget.RelativeLayout r7 = r1.f34134g
            int r8 = r8.intValue()
            android.graphics.drawable.ColorDrawable r8 = androidx.databinding.a.b.a(r8)
            androidx.databinding.a.e.a((android.view.View) r7, (android.graphics.drawable.Drawable) r8)
        L_0x0101:
            if (r18 == 0) goto L_0x010f
            android.widget.TextView r7 = r1.f34136i
            androidx.databinding.a.d.a((android.widget.TextView) r7, (java.lang.CharSequence) r13)
            android.widget.TextView r7 = r1.l
            r14 = r23
            androidx.databinding.a.d.a((android.widget.TextView) r7, (java.lang.CharSequence) r14)
        L_0x010f:
            r7 = 65
            long r7 = r7 & r2
            int r9 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r9 == 0) goto L_0x011b
            android.widget.TextView r7 = r1.j
            androidx.databinding.a.d.a((android.widget.TextView) r7, (java.lang.CharSequence) r0)
        L_0x011b:
            r7 = 66
            long r2 = r2 & r7
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0127
            android.widget.TextView r0 = r1.k
            r0.setVisibility(r6)
        L_0x0127:
            return
        L_0x0128:
            r0 = move-exception
            monitor-exit(r26)     // Catch:{ all -> 0x0128 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.b.db.executeBindings():void");
    }

    public final void a(int i2, View view) {
        boolean z = false;
        if (i2 == 1) {
            d dVar = this.n;
            String str = this.r;
            if (dVar != null) {
                z = true;
            }
            if (z) {
                k.c(view, "view");
                if (str != null) {
                    b bVar = b.f34268c;
                    b.d(view.getContext(), str);
                }
            }
        } else if (i2 == 2) {
            d dVar2 = this.n;
            RecommendedApps recommendedApps = this.m;
            if (dVar2 != null) {
                z = true;
            }
            if (z) {
                d.a(view, recommendedApps);
            }
        }
    }
}
