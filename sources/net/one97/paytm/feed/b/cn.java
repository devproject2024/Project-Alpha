package net.one97.paytm.feed.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import net.one97.paytm.feed.d.a.a;
import net.one97.paytm.feed.repository.models.generic.FeedGeneric;
import net.one97.paytm.feed.repository.models.generic.FeedGenericData;
import net.one97.paytm.feed.repository.models.nestedfeed.NestedFeed;

public final class cn extends cm implements a.C0556a {

    /* renamed from: h  reason: collision with root package name */
    private static final ViewDataBinding.b f34070h = null;

    /* renamed from: i  reason: collision with root package name */
    private static final SparseIntArray f34071i = null;
    private final ConstraintLayout j;
    private final View.OnClickListener k;
    private long l;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public cn(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 5, f34070h, f34071i));
    }

    private cn(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[4], objArr[3], objArr[1], objArr[2]);
        this.l = -1;
        this.f34063a.setTag((Object) null);
        this.j = objArr[0];
        this.j.setTag((Object) null);
        this.f34064b.setTag((Object) null);
        this.f34065c.setTag((Object) null);
        this.f34066d.setTag((Object) null);
        setRootTag(view);
        this.k = new a(this, 1);
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
        if (net.one97.paytm.feed.a.f33775b == i2) {
            this.f34068f = (net.one97.paytm.feed.ui.feed.m.e) obj;
            synchronized (this) {
                this.l |= 1;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33775b);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.f33776c == i2) {
            this.f34069g = (NestedFeed) obj;
            synchronized (this) {
                this.l |= 2;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33776c);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.f33780g != i2) {
            return false;
        } else {
            this.f34067e = (FeedGeneric) obj;
            synchronized (this) {
                this.l |= 4;
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
        Integer num;
        String str3;
        synchronized (this) {
            j2 = this.l;
            this.l = 0;
        }
        FeedGeneric feedGeneric = this.f34067e;
        int i2 = 0;
        int i3 = ((j2 & 12) > 0 ? 1 : ((j2 & 12) == 0 ? 0 : -1));
        if (i3 != 0) {
            FeedGenericData feedGenericData = feedGeneric != null ? feedGeneric.getFeedGenericData() : null;
            if (feedGenericData != null) {
                num = feedGenericData.getDuration();
                str2 = feedGenericData.getImageUrl();
                str = feedGenericData.getDescription();
                str3 = feedGenericData.getTitle();
            } else {
                str3 = null;
                num = null;
                str2 = null;
                str = null;
            }
            boolean z = num == null;
            if (i3 != 0) {
                j2 |= z ? 32 : 16;
            }
            if (z) {
                i2 = 8;
            }
        } else {
            str3 = null;
            num = null;
            str2 = null;
            str = null;
        }
        if ((12 & j2) != 0) {
            this.f34063a.setVisibility(i2);
            net.one97.paytm.feed.utility.a.a(this.f34063a, num);
            d.a(this.f34064b, (CharSequence) str);
            net.one97.paytm.feed.utility.a.a(this.f34065c, str2, (String) null, (String) null);
            d.a(this.f34066d, (CharSequence) str3);
        }
        if ((j2 & 8) != 0) {
            this.j.setOnClickListener(this.k);
        }
    }

    public final void a(int i2, View view) {
        net.one97.paytm.feed.ui.feed.m.e eVar = this.f34068f;
        NestedFeed nestedFeed = this.f34069g;
        FeedGeneric feedGeneric = this.f34067e;
        if (eVar != null) {
            net.one97.paytm.feed.ui.feed.m.e.a(getRoot().getContext(), feedGeneric, nestedFeed);
        }
    }
}
