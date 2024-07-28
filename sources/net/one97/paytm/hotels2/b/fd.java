package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import net.one97.paytm.hotels2.a;

public final class fd extends fc {

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.b f29693e = null;

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f29694f = null;

    /* renamed from: g  reason: collision with root package name */
    private final ConstraintLayout f29695g;

    /* renamed from: h  reason: collision with root package name */
    private long f29696h;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public fd(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 3, f29693e, f29694f));
    }

    private fd(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[2]);
        this.f29696h = -1;
        this.f29689a.setTag((Object) null);
        this.f29695g = objArr[0];
        this.f29695g.setTag((Object) null);
        this.f29690b.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f29696h = 4;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f29696h != 0) {
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
        this.f29691c = str;
        synchronized (this) {
            this.f29696h |= 1;
        }
        notifyPropertyChanged(a.J);
        super.requestRebind();
    }

    public final void b(String str) {
        this.f29692d = str;
        synchronized (this) {
            this.f29696h |= 2;
        }
        notifyPropertyChanged(a.o);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f29696h;
            this.f29696h = 0;
        }
        String str = this.f29691c;
        String str2 = this.f29692d;
        if ((5 & j) != 0) {
            net.one97.paytm.hotel4.utils.a.a(this.f29689a, str, (com.paytm.utility.b.b.e) null, (Integer) null);
        }
        if ((j & 6) != 0) {
            d.a(this.f29690b, (CharSequence) str2);
        }
    }
}
