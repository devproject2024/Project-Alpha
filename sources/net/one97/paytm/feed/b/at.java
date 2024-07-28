package net.one97.paytm.feed.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.a;
import net.one97.paytm.feed.repository.models.merchantstorefront.FeedMerchantStoreFront;
import net.one97.paytm.feed.repository.models.merchantstorefront.FeedMerchantStoreFrontData;
import net.one97.paytm.feed.ui.feed.h.b.c;

public final class at extends as {

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.b f33885e = null;

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f33886f;

    /* renamed from: g  reason: collision with root package name */
    private final LinearLayout f33887g;

    /* renamed from: h  reason: collision with root package name */
    private long f33888h;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33886f = sparseIntArray;
        sparseIntArray.put(R.id.merchant_recyclerview, 2);
    }

    public at(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 3, f33885e, f33886f));
    }

    private at(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[2]);
        this.f33888h = -1;
        this.f33887g = objArr[0];
        this.f33887g.setTag((Object) null);
        this.f33881a.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f33888h = 4;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f33888h != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.f33775b == i2) {
            this.f33884d = (c) obj;
        } else if (a.f33780g != i2) {
            return false;
        } else {
            this.f33883c = (FeedMerchantStoreFront) obj;
            synchronized (this) {
                this.f33888h |= 2;
            }
            notifyPropertyChanged(a.f33780g);
            super.requestRebind();
        }
        return true;
    }

    public final void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f33888h;
            this.f33888h = 0;
        }
        FeedMerchantStoreFront feedMerchantStoreFront = this.f33883c;
        String str = null;
        int i2 = ((j & 6) > 0 ? 1 : ((j & 6) == 0 ? 0 : -1));
        if (i2 != 0) {
            FeedMerchantStoreFrontData feedMerchantStoreFrontData = feedMerchantStoreFront != null ? feedMerchantStoreFront.getFeedMerchantStoreFrontData() : null;
            if (feedMerchantStoreFrontData != null) {
                str = feedMerchantStoreFrontData.getTitle();
            }
        }
        if (i2 != 0) {
            d.a(this.f33881a, (CharSequence) str);
        }
    }
}
