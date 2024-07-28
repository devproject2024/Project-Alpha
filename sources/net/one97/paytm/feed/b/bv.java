package net.one97.paytm.feed.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import kotlin.g.b.k;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.d.a.a;
import net.one97.paytm.feed.repository.models.recommendedapps.FeedRecommendedApps;
import net.one97.paytm.feed.repository.models.recommendedapps.FeedRecommendedAppsData;
import net.one97.paytm.feed.utility.b;

public final class bv extends bu implements a.C0556a {

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.b f34004f = null;

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f34005g;

    /* renamed from: h  reason: collision with root package name */
    private final RelativeLayout f34006h;

    /* renamed from: i  reason: collision with root package name */
    private final View.OnClickListener f34007i;
    private long j;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34005g = sparseIntArray;
        sparseIntArray.put(R.id.feed_recommended_recyclerview, 3);
    }

    public bv(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, f34004f, f34005g));
    }

    private bv(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[3], objArr[2]);
        this.j = -1;
        this.f33999a.setTag((Object) null);
        this.f34001c.setTag((Object) null);
        this.f34006h = objArr[0];
        this.f34006h.setTag((Object) null);
        setRootTag(view);
        this.f34007i = new a(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.j = 4;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.j != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (net.one97.paytm.feed.a.f33775b == i2) {
            this.f34003e = (net.one97.paytm.feed.ui.feed.a) obj;
            synchronized (this) {
                this.j |= 1;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33775b);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.f33780g != i2) {
            return false;
        } else {
            this.f34002d = (FeedRecommendedApps) obj;
            synchronized (this) {
                this.j |= 2;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33780g);
            super.requestRebind();
        }
        return true;
    }

    public final void executeBindings() {
        long j2;
        String str;
        synchronized (this) {
            j2 = this.j;
            this.j = 0;
        }
        FeedRecommendedApps feedRecommendedApps = this.f34002d;
        int i2 = 0;
        String str2 = null;
        int i3 = ((j2 & 6) > 0 ? 1 : ((j2 & 6) == 0 ? 0 : -1));
        if (i3 != 0) {
            FeedRecommendedAppsData feedRecommendedAppsData = feedRecommendedApps != null ? feedRecommendedApps.getFeedRecommendedAppsData() : null;
            if (feedRecommendedAppsData != null) {
                str2 = feedRecommendedAppsData.getViewAllUrl();
                str = feedRecommendedAppsData.getTitle();
            } else {
                str = null;
            }
            boolean z = str2 != null;
            if (i3 != 0) {
                j2 |= z ? 16 : 8;
            }
            if (!z) {
                i2 = 8;
            }
        } else {
            str = null;
        }
        if ((6 & j2) != 0) {
            d.a(this.f33999a, (CharSequence) str);
            this.f34001c.setVisibility(i2);
        }
        if ((j2 & 4) != 0) {
            this.f34001c.setOnClickListener(this.f34007i);
            net.one97.paytm.feed.utility.a.a(this.f34001c, b.a());
        }
    }

    public final void a(int i2, View view) {
        net.one97.paytm.feed.ui.feed.a aVar = this.f34003e;
        FeedRecommendedApps feedRecommendedApps = this.f34002d;
        boolean z = true;
        if (aVar != null) {
            if (feedRecommendedApps != null) {
                FeedRecommendedAppsData feedRecommendedAppsData = feedRecommendedApps.getFeedRecommendedAppsData();
                if (feedRecommendedAppsData == null) {
                    z = false;
                }
                if (z) {
                    String viewAllUrl = feedRecommendedAppsData.getViewAllUrl();
                    k.c(view, "view");
                    if (viewAllUrl != null) {
                        net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
                        net.one97.paytm.feed.e.b.d(view.getContext(), viewAllUrl);
                    }
                }
            }
        }
    }
}
