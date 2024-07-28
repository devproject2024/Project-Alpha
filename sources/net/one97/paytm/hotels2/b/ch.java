package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.g.d;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.hotels2.a;

public final class ch extends cg {

    /* renamed from: d  reason: collision with root package name */
    private static final ViewDataBinding.b f29359d = null;

    /* renamed from: e  reason: collision with root package name */
    private static final SparseIntArray f29360e = null;

    /* renamed from: f  reason: collision with root package name */
    private final ConstraintLayout f29361f;

    /* renamed from: g  reason: collision with root package name */
    private long f29362g;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public ch(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 3, f29359d, f29360e));
    }

    private ch(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[2]);
        this.f29362g = -1;
        this.f29356a.setTag((Object) null);
        this.f29361f = objArr[0];
        this.f29361f.setTag((Object) null);
        this.f29357b.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f29362g = 2;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f29362g != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.aa != i2) {
            return false;
        }
        a((d) obj);
        return true;
    }

    public final void a(d<String, String> dVar) {
        this.f29358c = dVar;
        synchronized (this) {
            this.f29362g |= 1;
        }
        notifyPropertyChanged(a.aa);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j;
        String str;
        synchronized (this) {
            j = this.f29362g;
            this.f29362g = 0;
        }
        d dVar = this.f29358c;
        String str2 = null;
        int i2 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i2 == 0 || dVar == null) {
            str = null;
        } else {
            str2 = (String) dVar.f2964a;
            str = (String) dVar.f2965b;
        }
        if (i2 != 0) {
            androidx.databinding.a.d.a(this.f29356a, (CharSequence) str2);
            androidx.databinding.a.d.a(this.f29357b, (CharSequence) str);
        }
    }
}
