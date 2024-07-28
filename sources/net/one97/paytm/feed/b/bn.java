package net.one97.paytm.feed.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import net.one97.paytm.feed.d.a.a;
import net.one97.paytm.feed.repository.models.CreatedBy;
import net.one97.paytm.feed.repository.models.generic.FeedGeneric;
import net.one97.paytm.feed.repository.models.generic.FeedGenericData;
import net.one97.paytm.feed.repository.models.nestedfeed.NestedFeed;

public final class bn extends bm implements a.C0556a {
    private static final ViewDataBinding.b j = null;
    private static final SparseIntArray k = null;
    private final ConstraintLayout l;
    private final View.OnClickListener m;
    private final View.OnClickListener n;
    private final View.OnClickListener o;
    private final View.OnClickListener p;
    private long q;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public bn(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 7, j, k));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private bn(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[3], objArr[2], objArr[4], objArr[1], objArr[5], objArr[6]);
        this.q = -1;
        this.f33966a.setTag((Object) null);
        this.f33967b.setTag((Object) null);
        this.f33968c.setTag((Object) null);
        this.f33969d.setTag((Object) null);
        this.f33970e.setTag((Object) null);
        this.l = objArr[0];
        this.l.setTag((Object) null);
        this.f33971f.setTag((Object) null);
        setRootTag(view);
        this.m = new a(this, 3);
        this.n = new a(this, 1);
        this.o = new a(this, 4);
        this.p = new a(this, 2);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.q = 8;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.q != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (net.one97.paytm.feed.a.f33776c == i2) {
            this.f33973h = (NestedFeed) obj;
            synchronized (this) {
                this.q |= 1;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33776c);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.f33780g == i2) {
            this.f33972g = (FeedGeneric) obj;
            synchronized (this) {
                this.q |= 2;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33780g);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.f33775b != i2) {
            return false;
        } else {
            this.f33974i = (net.one97.paytm.feed.ui.feed.m.e) obj;
            synchronized (this) {
                this.q |= 4;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33775b);
            super.requestRebind();
        }
        return true;
    }

    public final void executeBindings() {
        long j2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        CreatedBy createdBy;
        synchronized (this) {
            j2 = this.q;
            this.q = 0;
        }
        FeedGeneric feedGeneric = this.f33972g;
        int i2 = 0;
        int i3 = ((j2 & 10) > 0 ? 1 : ((j2 & 10) == 0 ? 0 : -1));
        if (i3 != 0) {
            FeedGenericData feedGenericData = feedGeneric != null ? feedGeneric.getFeedGenericData() : null;
            if (feedGenericData != null) {
                str4 = feedGenericData.getImageUrl();
                str6 = feedGenericData.getStreamUrl();
                str2 = feedGenericData.getCreatedAt();
                str = feedGenericData.getTitle();
                createdBy = feedGenericData.getCreatedBy();
            } else {
                createdBy = null;
                str4 = null;
                str6 = null;
                str2 = null;
                str = null;
            }
            boolean z = str6 == null;
            if (i3 != 0) {
                j2 |= z ? 32 : 16;
            }
            if (createdBy != null) {
                str3 = createdBy.getImageUrl();
                str5 = createdBy.getName();
            } else {
                str5 = null;
                str3 = null;
            }
            if (z) {
                i2 = 4;
            }
        } else {
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
        }
        if ((8 & j2) != 0) {
            this.f33966a.setOnClickListener(this.m);
            this.f33967b.setOnClickListener(this.p);
            this.f33968c.setOnClickListener(this.o);
            this.l.setOnClickListener(this.n);
        }
        if ((j2 & 10) != 0) {
            d.a(this.f33966a, (CharSequence) str2);
            d.a(this.f33967b, (CharSequence) str5);
            net.one97.paytm.feed.utility.a.c((ImageView) this.f33968c, str3);
            d.a(this.f33969d, (CharSequence) str);
            net.one97.paytm.feed.utility.a.a(this.f33970e, str4, (String) null, (String) null);
            this.f33971f.setVisibility(i2);
        }
    }

    public final void a(int i2, View view) {
        boolean z = false;
        if (i2 == 1) {
            net.one97.paytm.feed.ui.feed.m.e eVar = this.f33974i;
            NestedFeed nestedFeed = this.f33973h;
            FeedGeneric feedGeneric = this.f33972g;
            if (eVar != null) {
                z = true;
            }
            if (z) {
                net.one97.paytm.feed.ui.feed.m.e.a(getRoot().getContext(), feedGeneric, nestedFeed);
            }
        } else if (i2 == 2) {
            net.one97.paytm.feed.ui.feed.m.e eVar2 = this.f33974i;
            FeedGeneric feedGeneric2 = this.f33972g;
            if (eVar2 != null) {
                z = true;
            }
            if (z) {
                net.one97.paytm.feed.ui.feed.m.e.a(view, feedGeneric2);
            }
        } else if (i2 == 3) {
            net.one97.paytm.feed.ui.feed.m.e eVar3 = this.f33974i;
            FeedGeneric feedGeneric3 = this.f33972g;
            if (eVar3 != null) {
                z = true;
            }
            if (z) {
                net.one97.paytm.feed.ui.feed.m.e.a(view, feedGeneric3);
            }
        } else if (i2 == 4) {
            net.one97.paytm.feed.ui.feed.m.e eVar4 = this.f33974i;
            FeedGeneric feedGeneric4 = this.f33972g;
            if (eVar4 != null) {
                z = true;
            }
            if (z) {
                net.one97.paytm.feed.ui.feed.m.e.a(view, feedGeneric4);
            }
        }
    }
}
