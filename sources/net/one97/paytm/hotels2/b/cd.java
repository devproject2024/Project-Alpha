package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.hotels2.a;

public final class cd extends cc {

    /* renamed from: d  reason: collision with root package name */
    private static final ViewDataBinding.b f29342d = null;

    /* renamed from: e  reason: collision with root package name */
    private static final SparseIntArray f29343e = null;

    /* renamed from: f  reason: collision with root package name */
    private final LinearLayout f29344f;

    /* renamed from: g  reason: collision with root package name */
    private final ImageView f29345g;

    /* renamed from: h  reason: collision with root package name */
    private long f29346h;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public cd(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 3, f29342d, f29343e));
    }

    private cd(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1]);
        this.f29346h = -1;
        this.f29339a.setTag((Object) null);
        this.f29344f = objArr[0];
        this.f29344f.setTag((Object) null);
        this.f29345g = objArr[2];
        this.f29345g.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f29346h = 4;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f29346h != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.M == i2) {
            a((String) obj);
        } else if (a.ac != i2) {
            return false;
        } else {
            b((String) obj);
        }
        return true;
    }

    public final void a(String str) {
        this.f29340b = str;
        synchronized (this) {
            this.f29346h |= 1;
        }
        notifyPropertyChanged(a.M);
        super.requestRebind();
    }

    public final void b(String str) {
        this.f29341c = str;
        synchronized (this) {
            this.f29346h |= 2;
        }
        notifyPropertyChanged(a.ac);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f29346h;
            this.f29346h = 0;
        }
        String str = this.f29340b;
        String str2 = this.f29341c;
        if ((5 & j) != 0) {
            net.one97.paytm.hotel4.utils.a.a(this.f29339a, str);
        }
        if ((j & 6) != 0) {
            net.one97.paytm.hotel4.utils.a.a(this.f29345g, str2);
        }
    }
}
