package net.one97.paytm.recharge.b;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import net.one97.paytm.recharge.a;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionProductModel;

public final class v extends u {

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.b f60387f = null;

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f60388g = null;

    /* renamed from: h  reason: collision with root package name */
    private long f60389h;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public v(e eVar, View[] viewArr) {
        this(eVar, viewArr, mapBindings(eVar, viewArr, 4, f60387f, f60388g));
    }

    private v(e eVar, View[] viewArr, Object[] objArr) {
        super(eVar, viewArr[0], objArr[3], objArr[0], objArr[1], objArr[2]);
        this.f60389h = -1;
        this.f60382a.setTag((Object) null);
        this.f60383b.setTag((Object) null);
        this.f60384c.setTag((Object) null);
        this.f60385d.setTag((Object) null);
        setRootTag(viewArr);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f60389h = 2;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f60389h != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.f60180a != i2) {
            return false;
        }
        a((CJRAutomaticSubscriptionItemModel) obj);
        return true;
    }

    public final void a(CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel) {
        this.f60386e = cJRAutomaticSubscriptionItemModel;
        synchronized (this) {
            this.f60389h |= 1;
        }
        notifyPropertyChanged(a.f60180a);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j;
        String str;
        boolean z;
        String str2;
        String str3;
        int i2;
        CJRAutomaticSubscriptionProductModel cJRAutomaticSubscriptionProductModel;
        synchronized (this) {
            j = this.f60389h;
            this.f60389h = 0;
        }
        CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel = this.f60386e;
        int i3 = 0;
        int i4 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i4 != 0) {
            if (cJRAutomaticSubscriptionItemModel != null) {
                cJRAutomaticSubscriptionProductModel = cJRAutomaticSubscriptionItemModel.getProduct();
                i2 = cJRAutomaticSubscriptionItemModel.getStatus();
                str = cJRAutomaticSubscriptionItemModel.getNickname();
            } else {
                cJRAutomaticSubscriptionProductModel = null;
                i2 = 0;
                str = null;
            }
            str2 = cJRAutomaticSubscriptionProductModel != null ? cJRAutomaticSubscriptionProductModel.getOperator() : null;
            boolean z2 = true;
            if (i2 != 1) {
                z2 = false;
            }
            z = TextUtils.isEmpty(str);
            if (i4 != 0) {
                j |= z2 ? 8 : 4;
            }
            if ((j & 3) != 0) {
                j = z ? j | 32 : j | 16;
            }
            if (z2) {
                i3 = 8;
            }
        } else {
            str2 = null;
            z = false;
            str = null;
        }
        if ((32 & j) == 0 || cJRAutomaticSubscriptionItemModel == null) {
            str3 = null;
        } else {
            str3 = cJRAutomaticSubscriptionItemModel.getRechargeNumber();
        }
        int i5 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i5 == 0) {
            str3 = null;
        } else if (!z) {
            str3 = str;
        }
        if (i5 != 0) {
            this.f60382a.setVisibility(i3);
            d.a(this.f60384c, (CharSequence) str3);
            d.a(this.f60385d, (CharSequence) str2);
        }
    }
}
