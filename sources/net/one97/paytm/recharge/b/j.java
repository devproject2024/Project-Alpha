package net.one97.paytm.recharge.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import com.paytm.utility.b;
import net.one97.paytm.common.entity.shopping.CJROrderList;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.a;

public final class j extends i {
    private static final ViewDataBinding.b j = null;
    private static final SparseIntArray k = null;
    private long l;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public j(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, j, k));
    }

    private j(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[2], objArr[1], objArr[0], objArr[3]);
        this.l = -1;
        this.f60338a.setTag((Object) null);
        this.f60339b.setTag((Object) null);
        this.f60340c.setTag((Object) null);
        this.f60341d.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.l = 32;
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
        if (a.f60180a == i2) {
            this.f60346i = (CJROrderList) obj;
            synchronized (this) {
                this.l |= 1;
            }
            notifyPropertyChanged(a.f60180a);
            super.requestRebind();
        } else if (a.f60186g == i2) {
            this.f60344g = (String) obj;
        } else if (a.f60185f == i2) {
            this.f60345h = (String) obj;
        } else if (a.f60182c == i2) {
            this.f60342e = (String) obj;
        } else if (a.f60183d != i2) {
            return false;
        } else {
            this.f60343f = (String) obj;
        }
        return true;
    }

    public final void executeBindings() {
        long j2;
        String str;
        String str2;
        synchronized (this) {
            j2 = this.l;
            this.l = 0;
        }
        CJROrderList cJROrderList = this.f60346i;
        String str3 = null;
        int i2 = ((j2 & 33) > 0 ? 1 : ((j2 & 33) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (cJROrderList != null) {
                str2 = cJROrderList.getDate();
                str3 = cJROrderList.getAmount();
                str = cJROrderList.getStatus();
            } else {
                str2 = null;
                str = null;
            }
            str3 = this.f60338a.getResources().getString(R.string.currency_holder, new Object[]{b.L(str3)});
        } else {
            str2 = null;
            str = null;
        }
        if (i2 != 0) {
            d.a(this.f60338a, (CharSequence) str3);
            d.a(this.f60339b, (CharSequence) str2);
            d.a(this.f60341d, (CharSequence) str);
        }
    }
}
