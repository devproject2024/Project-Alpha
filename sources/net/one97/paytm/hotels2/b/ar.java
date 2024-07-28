package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;

public final class ar extends aq {

    /* renamed from: d  reason: collision with root package name */
    private static final ViewDataBinding.b f29180d = null;

    /* renamed from: e  reason: collision with root package name */
    private static final SparseIntArray f29181e;

    /* renamed from: f  reason: collision with root package name */
    private final ConstraintLayout f29182f;

    /* renamed from: g  reason: collision with root package name */
    private long f29183g;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f29181e = sparseIntArray;
        sparseIntArray.put(R.id.flexboxlayout_price_range, 2);
    }

    public ar(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 3, f29180d, f29181e));
    }

    private ar(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[2], objArr[1]);
        this.f29183g = -1;
        this.f29182f = objArr[0];
        this.f29182f.setTag((Object) null);
        this.f29178b.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f29183g = 2;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f29183g != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.f29090e != i2) {
            return false;
        }
        a((String) obj);
        return true;
    }

    public final void a(String str) {
        this.f29179c = str;
        synchronized (this) {
            this.f29183g |= 1;
        }
        notifyPropertyChanged(a.f29090e);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f29183g;
            this.f29183g = 0;
        }
        String str = this.f29179c;
        if ((j & 3) != 0) {
            d.a(this.f29178b, (CharSequence) str);
        }
    }
}
