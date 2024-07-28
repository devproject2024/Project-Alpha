package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import net.one97.paytm.hotels2.a;

public final class fz extends fy {

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.b f29785e = null;

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f29786f = null;

    /* renamed from: g  reason: collision with root package name */
    private final ConstraintLayout f29787g;

    /* renamed from: h  reason: collision with root package name */
    private long f29788h;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public fz(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 3, f29785e, f29786f));
    }

    private fz(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[2]);
        this.f29788h = -1;
        this.f29781a.setTag((Object) null);
        this.f29787g = objArr[0];
        this.f29787g.setTag((Object) null);
        this.f29782b.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f29788h = 4;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f29788h != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.J == i2) {
            a((String) obj);
        } else if (a.o != i2) {
            return false;
        } else {
            b((String) obj);
        }
        return true;
    }

    public final void a(String str) {
        this.f29783c = str;
        synchronized (this) {
            this.f29788h |= 1;
        }
        notifyPropertyChanged(a.J);
        super.requestRebind();
    }

    public final void b(String str) {
        this.f29784d = str;
        synchronized (this) {
            this.f29788h |= 2;
        }
        notifyPropertyChanged(a.o);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f29788h;
            this.f29788h = 0;
        }
        String str = this.f29783c;
        String str2 = this.f29784d;
        if ((5 & j) != 0) {
            net.one97.paytm.hotel4.utils.a.a(this.f29781a, str, (com.paytm.utility.b.b.e) null, (Integer) null);
        }
        if ((j & 6) != 0) {
            d.a(this.f29782b, (CharSequence) str2);
        }
    }
}
