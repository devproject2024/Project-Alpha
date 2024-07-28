package net.one97.paytm.feed.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.feed.d.a.a;
import net.one97.paytm.feed.repository.models.recommendedapps.RecommendedApps;
import net.one97.paytm.feed.ui.feed.l.d;

public final class br extends bq implements a.C0556a {

    /* renamed from: i  reason: collision with root package name */
    private static final ViewDataBinding.b f33992i = null;
    private static final SparseIntArray j = null;
    private final ConstraintLayout k;
    private final View.OnClickListener l;
    private long m;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public br(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 7, f33992i, j));
    }

    private br(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[5], objArr[1], objArr[2], objArr[3], objArr[6], objArr[4]);
        this.m = -1;
        this.f33984a.setTag((Object) null);
        this.f33985b.setTag((Object) null);
        this.f33986c.setTag((Object) null);
        this.f33987d.setTag((Object) null);
        this.f33988e.setTag((Object) null);
        this.k = objArr[0];
        this.k.setTag((Object) null);
        this.f33989f.setTag((Object) null);
        setRootTag(view);
        this.l = new a(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.m = 4;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.m != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (net.one97.paytm.feed.a.f33775b == i2) {
            this.f33991h = (d) obj;
            synchronized (this) {
                this.m |= 1;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33775b);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.f33780g != i2) {
            return false;
        } else {
            this.f33990g = (RecommendedApps) obj;
            synchronized (this) {
                this.m |= 2;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33780g);
            super.requestRebind();
        }
        return true;
    }

    public final void executeBindings() {
        long j2;
        String str;
        int i2;
        String str2;
        String str3;
        String str4;
        synchronized (this) {
            j2 = this.m;
            this.m = 0;
        }
        RecommendedApps recommendedApps = this.f33990g;
        int i3 = 0;
        int i4 = ((j2 & 6) > 0 ? 1 : ((j2 & 6) == 0 ? 0 : -1));
        if (i4 != 0) {
            if (recommendedApps != null) {
                str2 = recommendedApps.getTitle();
                str4 = recommendedApps.getAppSize();
                str = recommendedApps.getImageUrl();
                str3 = recommendedApps.getRating();
            } else {
                str3 = null;
                str2 = null;
                str4 = null;
                str = null;
            }
            boolean z = true;
            boolean z2 = str4 != null;
            if (str3 == null) {
                z = false;
            }
            if (i4 != 0) {
                j2 |= z2 ? 64 : 32;
            }
            if ((j2 & 6) != 0) {
                j2 |= z ? 16 : 8;
            }
            i2 = z2 ? 0 : 8;
            if (!z) {
                i3 = 8;
            }
        } else {
            str3 = null;
            str2 = null;
            str = null;
            i2 = 0;
        }
        if ((6 & j2) != 0) {
            this.f33984a.setVisibility(i2);
            net.one97.paytm.feed.utility.a.a(this.f33985b, str, (String) null, (String) null);
            androidx.databinding.a.d.a(this.f33986c, (CharSequence) str2);
            this.f33987d.setVisibility(i3);
            this.f33988e.setVisibility(i2);
            androidx.databinding.a.d.a(this.f33989f, (CharSequence) str3);
            this.f33989f.setVisibility(i3);
        }
        if ((j2 & 4) != 0) {
            this.k.setOnClickListener(this.l);
        }
    }

    public final void a(int i2, View view) {
        d dVar = this.f33991h;
        RecommendedApps recommendedApps = this.f33990g;
        if (dVar != null) {
            d.a(view, recommendedApps);
        }
    }
}
