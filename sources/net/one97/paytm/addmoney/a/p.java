package net.one97.paytm.addmoney.a;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.newaddmoney.c.a;

public final class p extends o {

    /* renamed from: g  reason: collision with root package name */
    private static final ViewDataBinding.b f48087g = null;

    /* renamed from: h  reason: collision with root package name */
    private static final SparseIntArray f48088h;

    /* renamed from: i  reason: collision with root package name */
    private long f48089i;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f48088h = sparseIntArray;
        sparseIntArray.put(R.id.nested_scrollView, 2);
        f48088h.put(R.id.tv_select_pay_options, 3);
        f48088h.put(R.id.layout_cards, 4);
    }

    public p(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 5, f48087g, f48088h));
    }

    private p(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[4], objArr[0], objArr[2], objArr[3]);
        this.f48089i = -1;
        this.f48081a.setTag((Object) null);
        this.f48083c.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f48089i = 2;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f48089i != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (net.one97.paytm.addmoney.e.f48572c != i2) {
            return false;
        }
        this.f48086f = (a) obj;
        return true;
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f48089i = 0;
        }
    }
}
