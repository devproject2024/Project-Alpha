package net.one97.paytm.feed.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.feed.d.a.a;
import net.one97.paytm.feed.repository.models.generic.FeedGeneric;
import net.one97.paytm.feed.repository.models.generic.FeedGenericData;
import net.one97.paytm.feed.repository.models.nestedfeed.NestedFeed;

public final class f extends e implements a.C0556a {

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.b f34159f = null;

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f34160g = null;

    /* renamed from: h  reason: collision with root package name */
    private final ConstraintLayout f34161h;

    /* renamed from: i  reason: collision with root package name */
    private final View.OnClickListener f34162i;
    private long j;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public f(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 3, f34159f, f34160g));
    }

    private f(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[2]);
        this.j = -1;
        this.f34154a.setTag((Object) null);
        this.f34161h = objArr[0];
        this.f34161h.setTag((Object) null);
        this.f34155b.setTag((Object) null);
        setRootTag(view);
        this.f34162i = new a(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.j = 8;
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
            this.f34157d = (net.one97.paytm.feed.ui.feed.m.e) obj;
            synchronized (this) {
                this.j |= 1;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33775b);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.f33776c == i2) {
            this.f34158e = (NestedFeed) obj;
            synchronized (this) {
                this.j |= 2;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33776c);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.f33780g != i2) {
            return false;
        } else {
            this.f34156c = (FeedGeneric) obj;
            synchronized (this) {
                this.j |= 4;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33780g);
            super.requestRebind();
        }
        return true;
    }

    public final void executeBindings() {
        long j2;
        String str;
        String str2;
        synchronized (this) {
            j2 = this.j;
            this.j = 0;
        }
        FeedGeneric feedGeneric = this.f34156c;
        int i2 = 0;
        int i3 = ((j2 & 12) > 0 ? 1 : ((j2 & 12) == 0 ? 0 : -1));
        if (i3 != 0) {
            FeedGenericData feedGenericData = feedGeneric != null ? feedGeneric.getFeedGenericData() : null;
            if (feedGenericData != null) {
                str = feedGenericData.getImageUrl();
                str2 = feedGenericData.getStreamUrl();
            } else {
                str2 = null;
                str = null;
            }
            boolean z = str2 == null;
            if (i3 != 0) {
                j2 |= z ? 32 : 16;
            }
            if (z) {
                i2 = 4;
            }
        } else {
            str = null;
        }
        if ((8 & j2) != 0) {
            this.f34154a.setOnClickListener(this.f34162i);
        }
        if ((j2 & 12) != 0) {
            net.one97.paytm.feed.utility.a.a(this.f34154a, str, (String) null, (String) null);
            this.f34155b.setVisibility(i2);
        }
    }

    public final void a(int i2, View view) {
        net.one97.paytm.feed.ui.feed.m.e eVar = this.f34157d;
        NestedFeed nestedFeed = this.f34158e;
        FeedGeneric feedGeneric = this.f34156c;
        if (eVar != null) {
            net.one97.paytm.feed.ui.feed.m.e.a(getRoot().getContext(), feedGeneric, nestedFeed);
        }
    }
}
