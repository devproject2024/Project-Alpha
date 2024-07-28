package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.hotel4.viewmodel.SRPListItemViewModel;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;
import net.one97.paytm.upi.util.UpiConstants;

public final class fn extends fm implements b.a {

    /* renamed from: d  reason: collision with root package name */
    private static final ViewDataBinding.b f29733d = null;

    /* renamed from: e  reason: collision with root package name */
    private static final SparseIntArray f29734e = null;

    /* renamed from: f  reason: collision with root package name */
    private final ConstraintLayout f29735f;

    /* renamed from: g  reason: collision with root package name */
    private final View.OnClickListener f29736g;

    /* renamed from: h  reason: collision with root package name */
    private long f29737h;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public fn(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 2, f29733d, f29734e));
    }

    private fn(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1]);
        this.f29737h = -1;
        this.f29730a.setTag((Object) null);
        this.f29735f = objArr[0];
        this.f29735f.setTag((Object) null);
        setRootTag(view);
        this.f29736g = new b(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f29737h = 4;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f29737h != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.f29088c == i2) {
            a((SRPListItemViewModel) obj);
        } else if (a.ai != i2) {
            return false;
        } else {
            a((String) obj);
        }
        return true;
    }

    public final void a(SRPListItemViewModel sRPListItemViewModel) {
        this.f29732c = sRPListItemViewModel;
        synchronized (this) {
            this.f29737h |= 1;
        }
        notifyPropertyChanged(a.f29088c);
        super.requestRebind();
    }

    public final void a(String str) {
        this.f29731b = str;
        synchronized (this) {
            this.f29737h |= 2;
        }
        notifyPropertyChanged(a.ai);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f29737h;
            this.f29737h = 0;
        }
        String str = this.f29731b;
        if ((4 & j) != 0) {
            this.f29730a.setOnClickListener(this.f29736g);
        }
        if ((j & 6) != 0) {
            net.one97.paytm.hotel4.utils.a.a(this.f29730a, str, (com.paytm.utility.b.b.e) null, Integer.valueOf(UpiConstants.REQUEST_CODE_BANK_DETAIL));
        }
    }

    public final void a(int i2) {
        SRPListItemViewModel sRPListItemViewModel = this.f29732c;
        if (sRPListItemViewModel != null) {
            sRPListItemViewModel.onRecyclerItemClick();
        }
    }
}
