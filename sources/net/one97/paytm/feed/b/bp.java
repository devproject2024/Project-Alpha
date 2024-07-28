package net.one97.paytm.feed.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.d.a.a;
import net.one97.paytm.feed.repository.models.CreatedBy;
import net.one97.paytm.feed.repository.models.generic.FeedGeneric;
import net.one97.paytm.feed.repository.models.generic.FeedGenericData;
import net.one97.paytm.feed.repository.models.nestedfeed.NestedFeed;

public final class bp extends bo implements a.C0556a {
    private static final ViewDataBinding.b l = null;
    private static final SparseIntArray m;
    private final ConstraintLayout n;
    private final View.OnClickListener o;
    private final View.OnClickListener p;
    private final View.OnClickListener q;
    private final View.OnClickListener r;
    private long s;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        m = sparseIntArray;
        sparseIntArray.put(R.id.imageView3, 7);
        m.put(R.id.centreview, 8);
    }

    public bp(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 9, l, m));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private bp(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[8], objArr[4], objArr[3], objArr[5], objArr[2], objArr[1], objArr[7], objArr[6]);
        this.s = -1;
        this.f33976b.setTag((Object) null);
        this.f33977c.setTag((Object) null);
        this.f33978d.setTag((Object) null);
        this.f33979e.setTag((Object) null);
        this.f33980f.setTag((Object) null);
        this.n = objArr[0];
        this.n.setTag((Object) null);
        this.f33982h.setTag((Object) null);
        setRootTag(view);
        this.o = new a(this, 1);
        this.p = new a(this, 3);
        this.q = new a(this, 4);
        this.r = new a(this, 2);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.s = 8;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.s != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (net.one97.paytm.feed.a.f33776c == i2) {
            this.k = (NestedFeed) obj;
            synchronized (this) {
                this.s |= 1;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33776c);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.f33780g == i2) {
            this.f33983i = (FeedGeneric) obj;
            synchronized (this) {
                this.s |= 2;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33780g);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.f33775b != i2) {
            return false;
        } else {
            this.j = (net.one97.paytm.feed.ui.feed.m.e) obj;
            synchronized (this) {
                this.s |= 4;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33775b);
            super.requestRebind();
        }
        return true;
    }

    public final void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        CreatedBy createdBy;
        synchronized (this) {
            j = this.s;
            this.s = 0;
        }
        FeedGeneric feedGeneric = this.f33983i;
        int i2 = 0;
        int i3 = ((j & 10) > 0 ? 1 : ((j & 10) == 0 ? 0 : -1));
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
                j |= z ? 32 : 16;
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
        if ((8 & j) != 0) {
            this.f33976b.setOnClickListener(this.p);
            this.f33977c.setOnClickListener(this.r);
            this.f33978d.setOnClickListener(this.q);
            this.n.setOnClickListener(this.o);
        }
        if ((j & 10) != 0) {
            d.a(this.f33976b, (CharSequence) str2);
            d.a(this.f33977c, (CharSequence) str5);
            net.one97.paytm.feed.utility.a.c((ImageView) this.f33978d, str3);
            d.a(this.f33979e, (CharSequence) str);
            net.one97.paytm.feed.utility.a.a(this.f33980f, str4, (String) null, (String) null);
            this.f33982h.setVisibility(i2);
        }
    }

    public final void a(int i2, View view) {
        boolean z = false;
        if (i2 == 1) {
            net.one97.paytm.feed.ui.feed.m.e eVar = this.j;
            NestedFeed nestedFeed = this.k;
            FeedGeneric feedGeneric = this.f33983i;
            if (eVar != null) {
                z = true;
            }
            if (z) {
                net.one97.paytm.feed.ui.feed.m.e.a(getRoot().getContext(), feedGeneric, nestedFeed);
            }
        } else if (i2 == 2) {
            net.one97.paytm.feed.ui.feed.m.e eVar2 = this.j;
            FeedGeneric feedGeneric2 = this.f33983i;
            if (eVar2 != null) {
                z = true;
            }
            if (z) {
                net.one97.paytm.feed.ui.feed.m.e.a(view, feedGeneric2);
            }
        } else if (i2 == 3) {
            net.one97.paytm.feed.ui.feed.m.e eVar3 = this.j;
            FeedGeneric feedGeneric3 = this.f33983i;
            if (eVar3 != null) {
                z = true;
            }
            if (z) {
                net.one97.paytm.feed.ui.feed.m.e.a(view, feedGeneric3);
            }
        } else if (i2 == 4) {
            net.one97.paytm.feed.ui.feed.m.e eVar4 = this.j;
            FeedGeneric feedGeneric4 = this.f33983i;
            if (eVar4 != null) {
                z = true;
            }
            if (z) {
                net.one97.paytm.feed.ui.feed.m.e.a(view, feedGeneric4);
            }
        }
    }
}
