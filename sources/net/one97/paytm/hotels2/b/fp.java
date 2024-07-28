package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import net.one97.paytm.hotels2.a;

public final class fp extends fo {

    /* renamed from: d  reason: collision with root package name */
    private static final ViewDataBinding.b f29741d = null;

    /* renamed from: e  reason: collision with root package name */
    private static final SparseIntArray f29742e = null;

    /* renamed from: f  reason: collision with root package name */
    private final ConstraintLayout f29743f;

    /* renamed from: g  reason: collision with root package name */
    private final TextView f29744g;

    /* renamed from: h  reason: collision with root package name */
    private long f29745h;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public fp(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 3, f29741d, f29742e));
    }

    private fp(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1]);
        this.f29745h = -1;
        this.f29738a.setTag((Object) null);
        this.f29743f = objArr[0];
        this.f29743f.setTag((Object) null);
        this.f29744g = objArr[2];
        this.f29744g.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f29745h = 4;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f29745h != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.ai == i2) {
            a((String) obj);
        } else if (a.o != i2) {
            return false;
        } else {
            b((String) obj);
        }
        return true;
    }

    public final void a(String str) {
        this.f29739b = str;
        synchronized (this) {
            this.f29745h |= 1;
        }
        notifyPropertyChanged(a.ai);
        super.requestRebind();
    }

    public final void b(String str) {
        this.f29740c = str;
        synchronized (this) {
            this.f29745h |= 2;
        }
        notifyPropertyChanged(a.o);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f29745h;
            this.f29745h = 0;
        }
        String str = this.f29739b;
        String str2 = this.f29740c;
        if ((5 & j) != 0) {
            net.one97.paytm.hotel4.utils.a.a(this.f29738a, str, (com.paytm.utility.b.b.e) null, (Integer) null);
        }
        if ((j & 6) != 0) {
            d.a(this.f29744g, (CharSequence) str2);
        }
    }
}
