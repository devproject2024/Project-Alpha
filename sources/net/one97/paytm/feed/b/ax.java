package net.one97.paytm.feed.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.feed.a;

public final class ax extends aw {

    /* renamed from: b  reason: collision with root package name */
    private static final ViewDataBinding.b f33899b = null;

    /* renamed from: c  reason: collision with root package name */
    private static final SparseIntArray f33900c = null;

    /* renamed from: d  reason: collision with root package name */
    private final TextView f33901d;

    /* renamed from: e  reason: collision with root package name */
    private long f33902e;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public ax(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 1, f33899b, f33900c));
    }

    private ax(e eVar, View view, Object[] objArr) {
        super(eVar, view);
        this.f33902e = -1;
        this.f33901d = objArr[0];
        this.f33901d.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f33902e = 2;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f33902e != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.n != i2) {
            return false;
        }
        this.f33898a = (Boolean) obj;
        return true;
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f33902e = 0;
        }
    }
}
