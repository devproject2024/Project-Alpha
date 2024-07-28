package net.one97.paytm.g;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.paytm_finance.R;

public final class f extends e {

    /* renamed from: g  reason: collision with root package name */
    private static final ViewDataBinding.b f50498g = null;

    /* renamed from: h  reason: collision with root package name */
    private static final SparseIntArray f50499h;

    /* renamed from: i  reason: collision with root package name */
    private final RelativeLayout f50500i;
    private long j;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f50499h = sparseIntArray;
        sparseIntArray.put(R.id.iv_icon, 1);
        f50499h.put(R.id.tv_download_percent, 2);
        f50499h.put(R.id.tv_title, 3);
        f50499h.put(R.id.tv_retry, 4);
        f50499h.put(R.id.pb_download, 5);
        f50499h.put(R.id.tv_failed, 6);
    }

    public f(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 7, f50498g, f50499h));
    }

    private f(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[5], objArr[2], objArr[6], objArr[4], objArr[3]);
        this.j = -1;
        this.f50500i = objArr[0];
        this.f50500i.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.j = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.j != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.j = 0;
        }
    }
}
