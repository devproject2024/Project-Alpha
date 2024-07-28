package net.one97.paytm.feed.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.databinding.h;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.d.a.a;
import net.one97.paytm.feed.repository.models.CreatedBy;
import net.one97.paytm.feed.repository.models.FeedItem;
import net.one97.paytm.feed.repository.models.generic.FeedGeneric;
import net.one97.paytm.feed.repository.models.generic.FeedGenericData;

public final class x extends w implements a.C0556a {
    private static final ViewDataBinding.b s = null;
    private static final SparseIntArray t;
    private final View.OnClickListener u;
    private final View.OnClickListener v;
    private long w;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        t = sparseIntArray;
        sparseIntArray.put(R.id.main_media_frame, 7);
        t.put(R.id.playerView, 8);
        t.put(R.id.provider_follow, 9);
        t.put(R.id.likeShareContainer, 10);
        t.put(R.id.ivLike, 11);
        t.put(R.id.tvLike, 12);
        t.put(R.id.ivBookmark, 13);
        t.put(R.id.progressBar, 14);
    }

    public x(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 15, s, t));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private x(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[13], objArr[3], objArr[11], objArr[5], objArr[10], objArr[7], objArr[8], objArr[14], objArr[9], objArr[2], objArr[0], objArr[1], objArr[4], objArr[12], objArr[6]);
        this.w = -1;
        this.f34234b.setTag((Object) null);
        this.f34236d.setTag((Object) null);
        this.j.setTag((Object) null);
        this.k.setTag((Object) null);
        this.l.setTag((Object) null);
        this.m.setTag((Object) null);
        this.o.setTag((Object) null);
        setRootTag(view);
        this.u = new a(this, 1);
        this.v = new a(this, 2);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.w = 8;
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
        if (net.one97.paytm.feed.a.f33780g == i2) {
            this.p = (FeedGeneric) obj;
            synchronized (this) {
                this.w |= 2;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33780g);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.f33775b == i2) {
            this.q = (net.one97.paytm.feed.ui.feed.a) obj;
            synchronized (this) {
                this.w |= 4;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33775b);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.f33777d != i2) {
            return false;
        } else {
            net.one97.paytm.feed.ui.feed.d.a aVar = (net.one97.paytm.feed.ui.feed.d.a) obj;
            updateRegistration(0, (h) aVar);
            this.r = aVar;
            synchronized (this) {
                this.w |= 1;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33777d);
            super.requestRebind();
        }
        return true;
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return a(i3);
    }

    private boolean a(int i2) {
        if (i2 != net.one97.paytm.feed.a.f33774a) {
            return false;
        }
        synchronized (this) {
            this.w |= 1;
        }
        return true;
    }

    public final void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        Integer num;
        Integer num2;
        CreatedBy createdBy;
        synchronized (this) {
            j = this.w;
            this.w = 0;
        }
        FeedGeneric feedGeneric = this.p;
        String str4 = null;
        int i2 = ((10 & j) > 0 ? 1 : ((10 & j) == 0 ? 0 : -1));
        if (i2 != 0) {
            FeedGenericData feedGenericData = feedGeneric != null ? feedGeneric.getFeedGenericData() : null;
            if (feedGenericData != null) {
                num2 = feedGenericData.getShareCount();
                num = feedGenericData.getCommentCount();
                createdBy = feedGenericData.getCreatedBy();
            } else {
                createdBy = null;
                num2 = null;
                num = null;
            }
            str2 = num2 != null ? num2.toString() : null;
            str = num != null ? num.toString() : null;
            if (createdBy != null) {
                String imageUrl = createdBy.getImageUrl();
                str4 = createdBy.getName();
                str3 = imageUrl;
            } else {
                str3 = null;
            }
        } else {
            str3 = null;
            str2 = null;
            str = null;
        }
        if ((j & 8) != 0) {
            this.f34234b.setOnClickListener(this.u);
            this.f34236d.setOnClickListener(this.v);
        }
        if (i2 != 0) {
            d.a(this.j, (CharSequence) str4);
            net.one97.paytm.feed.utility.a.c((ImageView) this.l, str3);
            d.a(this.m, (CharSequence) str);
            d.a(this.o, (CharSequence) str2);
        }
    }

    public final void a(int i2, View view) {
        boolean z = false;
        if (i2 == 1) {
            net.one97.paytm.feed.ui.feed.a aVar = this.q;
            FeedGeneric feedGeneric = this.p;
            if (aVar != null) {
                z = true;
            }
            if (z) {
                net.one97.paytm.feed.ui.feed.a.a(view, (FeedItem) feedGeneric, true);
            }
        } else if (i2 == 2) {
            net.one97.paytm.feed.ui.feed.a aVar2 = this.q;
            net.one97.paytm.feed.ui.feed.d.a aVar3 = this.r;
            FeedGeneric feedGeneric2 = this.p;
            if (aVar2 != null) {
                z = true;
            }
            if (z) {
                aVar2.b(view, feedGeneric2, aVar3);
            }
        }
    }
}
