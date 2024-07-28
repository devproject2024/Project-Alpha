package net.one97.paytm.feed.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.d.a.a;
import net.one97.paytm.feed.repository.models.generic.FeedGeneric;
import net.one97.paytm.feed.repository.models.generic.FeedGenericData;
import net.one97.paytm.feed.repository.models.nestedfeed.NestedFeed;

public final class bb extends ba implements a.C0556a {
    private static final ViewDataBinding.b j = null;
    private static final SparseIntArray k;
    private final ConstraintLayout l;
    private final View.OnClickListener m;
    private long n;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        k = sparseIntArray;
        sparseIntArray.put(R.id.view2, 6);
    }

    public bb(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 7, j, k));
    }

    private bb(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[3], objArr[1], objArr[2], objArr[5], objArr[6], objArr[4]);
        this.n = -1;
        this.f33916a.setTag((Object) null);
        this.f33917b.setTag((Object) null);
        this.l = objArr[0];
        this.l.setTag((Object) null);
        this.f33918c.setTag((Object) null);
        this.f33919d.setTag((Object) null);
        this.f33921f.setTag((Object) null);
        setRootTag(view);
        this.m = new a(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.n = 8;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.n != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (net.one97.paytm.feed.a.f33776c == i2) {
            this.f33924i = (NestedFeed) obj;
            synchronized (this) {
                this.n |= 1;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33776c);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.f33780g == i2) {
            this.f33922g = (FeedGeneric) obj;
            synchronized (this) {
                this.n |= 2;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33780g);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.f33775b != i2) {
            return false;
        } else {
            this.f33923h = (net.one97.paytm.feed.ui.feed.m.e) obj;
            synchronized (this) {
                this.n |= 4;
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
        int i2;
        String str3;
        String str4;
        String str5;
        synchronized (this) {
            j2 = this.n;
            this.n = 0;
        }
        FeedGeneric feedGeneric = this.f33922g;
        int i3 = 0;
        int i4 = ((j2 & 10) > 0 ? 1 : ((j2 & 10) == 0 ? 0 : -1));
        if (i4 != 0) {
            FeedGenericData feedGenericData = feedGeneric != null ? feedGeneric.getFeedGenericData() : null;
            if (feedGenericData != null) {
                str4 = feedGenericData.getImageUrl();
                str3 = feedGenericData.getCtaImageUrl();
                str2 = feedGenericData.getCtaDisplayText();
                str = feedGenericData.getDescription();
                str5 = feedGenericData.getTitle();
            } else {
                str5 = null;
                str4 = null;
                str3 = null;
                str2 = null;
                str = null;
            }
            boolean z = true;
            boolean z2 = str3 == null;
            if (str2 != null) {
                z = false;
            }
            if (i4 != 0) {
                j2 |= z2 ? 32 : 16;
            }
            if ((j2 & 10) != 0) {
                j2 |= z ? 128 : 64;
            }
            int i5 = z2 ? 4 : 0;
            if (z) {
                i3 = 8;
            }
            int i6 = i5;
            i2 = i3;
            i3 = i6;
        } else {
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            i2 = 0;
        }
        if ((10 & j2) != 0) {
            d.a(this.f33916a, (CharSequence) str);
            net.one97.paytm.feed.utility.a.a(this.f33917b, str4, (String) null, (String) null);
            d.a(this.f33918c, (CharSequence) str5);
            this.f33919d.setVisibility(i3);
            net.one97.paytm.feed.utility.a.a(this.f33919d, str3, (String) null, (String) null);
            d.a(this.f33921f, (CharSequence) str2);
            this.f33921f.setVisibility(i2);
        }
        if ((j2 & 8) != 0) {
            this.l.setOnClickListener(this.m);
        }
    }

    public final void a(int i2, View view) {
        net.one97.paytm.feed.ui.feed.m.e eVar = this.f33923h;
        NestedFeed nestedFeed = this.f33924i;
        FeedGeneric feedGeneric = this.f33922g;
        if (eVar != null) {
            net.one97.paytm.feed.ui.feed.m.e.a(getRoot().getContext(), feedGeneric, nestedFeed);
        }
    }
}
