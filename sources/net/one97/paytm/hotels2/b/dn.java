package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.hotel4.service.model.promocode.PromocodeDataItem;
import net.one97.paytm.hotel4.viewmodel.ReviewViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;

public final class dn extends dm implements b.a {

    /* renamed from: i  reason: collision with root package name */
    private static final ViewDataBinding.b f29500i = null;
    private static final SparseIntArray j;
    private final View.OnClickListener k;
    private long l;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        j = sparseIntArray;
        sparseIntArray.put(R.id.iv_radio_button, 1);
        j.put(R.id.tv_terms, 2);
        j.put(R.id.tv_offer_name, 3);
        j.put(R.id.tv_cashback, 4);
    }

    public dn(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 5, f29500i, j));
    }

    private dn(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[0], objArr[4], objArr[3], objArr[2]);
        this.l = -1;
        this.f29493b.setTag((Object) null);
        setRootTag(view);
        this.k = new b(this, 1);
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
        if (a.U == i2) {
            a((Boolean) obj);
        } else if (a.ah == i2) {
            a((PromocodeDataItem) obj);
        } else if (a.f29088c != i2) {
            return false;
        } else {
            a((ReviewViewModel) obj);
        }
        return true;
    }

    public final void a(Boolean bool) {
        this.f29498g = bool;
        synchronized (this) {
            this.l |= 1;
        }
        notifyPropertyChanged(a.U);
        super.requestRebind();
    }

    public final void a(PromocodeDataItem promocodeDataItem) {
        this.f29497f = promocodeDataItem;
        synchronized (this) {
            this.l |= 2;
        }
        notifyPropertyChanged(a.ah);
        super.requestRebind();
    }

    public final void a(ReviewViewModel reviewViewModel) {
        this.f29499h = reviewViewModel;
        synchronized (this) {
            this.l |= 4;
        }
        notifyPropertyChanged(a.f29088c);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j2;
        synchronized (this) {
            j2 = this.l;
            this.l = 0;
        }
        if ((j2 & 8) != 0) {
            this.f29493b.setOnClickListener(this.k);
        }
    }

    public final void a(int i2) {
        Boolean bool = this.f29498g;
        PromocodeDataItem promocodeDataItem = this.f29497f;
        ReviewViewModel reviewViewModel = this.f29499h;
        if (reviewViewModel != null) {
            reviewViewModel.onPromoCodeClick(promocodeDataItem, bool.booleanValue());
        }
    }
}
