package net.one97.paytm.recharge.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import com.paytm.utility.b;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.a;
import net.one97.paytm.recharge.model.CJRAutomaticSubscriptionHistory;

public final class h extends g {

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.b f60334e = null;

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f60335f = null;

    /* renamed from: g  reason: collision with root package name */
    private final ConstraintLayout f60336g;

    /* renamed from: h  reason: collision with root package name */
    private long f60337h;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public h(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, f60334e, f60335f));
    }

    private h(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[2], objArr[3]);
        this.f60337h = -1;
        this.f60336g = objArr[0];
        this.f60336g.setTag((Object) null);
        this.f60330a.setTag((Object) null);
        this.f60331b.setTag((Object) null);
        this.f60332c.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f60337h = 2;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f60337h != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.f60184e != i2) {
            return false;
        }
        this.f60333d = (CJRAutomaticSubscriptionHistory) obj;
        synchronized (this) {
            this.f60337h |= 1;
        }
        notifyPropertyChanged(a.f60184e);
        super.requestRebind();
        return true;
    }

    public final void executeBindings() {
        long j;
        String str;
        int i2;
        String str2;
        synchronized (this) {
            j = this.f60337h;
            this.f60337h = 0;
        }
        CJRAutomaticSubscriptionHistory cJRAutomaticSubscriptionHistory = this.f60333d;
        String str3 = null;
        int i3 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i3 != 0) {
            if (cJRAutomaticSubscriptionHistory != null) {
                str2 = cJRAutomaticSubscriptionHistory.getDate();
                i2 = cJRAutomaticSubscriptionHistory.getStatusColorCode();
                str3 = cJRAutomaticSubscriptionHistory.getPayAmount();
                str = cJRAutomaticSubscriptionHistory.getPayStatus();
            } else {
                str2 = null;
                str = null;
                i2 = 0;
            }
            str3 = this.f60331b.getResources().getString(R.string.currency_holder, new Object[]{b.L(str3)});
        } else {
            str2 = null;
            str = null;
            i2 = 0;
        }
        if (i3 != 0) {
            d.a(this.f60330a, (CharSequence) str2);
            d.a(this.f60331b, (CharSequence) str3);
            d.a(this.f60332c, (CharSequence) str);
            this.f60332c.setTextColor(i2);
        }
    }
}
