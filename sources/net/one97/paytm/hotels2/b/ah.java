package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import net.one97.paytm.hotel4.viewmodel.filter.SRPFilterViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;

public final class ah extends ag implements b.a {

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.b f29136f = null;

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f29137g;

    /* renamed from: h  reason: collision with root package name */
    private final ConstraintLayout f29138h;

    /* renamed from: i  reason: collision with root package name */
    private final TextView f29139i;
    private final View.OnClickListener j;
    private long k;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f29137g = sparseIntArray;
        sparseIntArray.put(R.id.amenities_list, 3);
    }

    public ah(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, f29136f, f29137g));
    }

    private ah(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[3], objArr[1]);
        this.k = -1;
        this.f29138h = objArr[0];
        this.f29138h.setTag((Object) null);
        this.f29139i = objArr[2];
        this.f29139i.setTag((Object) null);
        this.f29132b.setTag((Object) null);
        setRootTag(view);
        this.j = new b(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.k = 8;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.k != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.m == i2) {
            b((String) obj);
        } else if (a.f29090e == i2) {
            a((String) obj);
        } else if (a.f29088c != i2) {
            return false;
        } else {
            a((SRPFilterViewModel) obj);
        }
        return true;
    }

    public final void b(String str) {
        this.f29134d = str;
        synchronized (this) {
            this.k |= 1;
        }
        notifyPropertyChanged(a.m);
        super.requestRebind();
    }

    public final void a(String str) {
        this.f29133c = str;
        synchronized (this) {
            this.k |= 2;
        }
        notifyPropertyChanged(a.f29090e);
        super.requestRebind();
    }

    public final void a(SRPFilterViewModel sRPFilterViewModel) {
        this.f29135e = sRPFilterViewModel;
        synchronized (this) {
            this.k |= 4;
        }
        notifyPropertyChanged(a.f29088c);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j2;
        synchronized (this) {
            j2 = this.k;
            this.k = 0;
        }
        String str = this.f29134d;
        String str2 = this.f29133c;
        if ((9 & j2) != 0) {
            d.a(this.f29139i, (CharSequence) str);
        }
        if ((8 & j2) != 0) {
            this.f29139i.setOnClickListener(this.j);
        }
        if ((j2 & 10) != 0) {
            d.a(this.f29132b, (CharSequence) str2);
        }
    }

    public final void a(int i2) {
        String str = this.f29133c;
        SRPFilterViewModel sRPFilterViewModel = this.f29135e;
        if (sRPFilterViewModel != null) {
            sRPFilterViewModel.onScreenClick(str);
        }
    }
}
