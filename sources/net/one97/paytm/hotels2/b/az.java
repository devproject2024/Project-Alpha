package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import net.one97.paytm.hotel4.viewmodel.SRPHeaderViewModel;
import net.one97.paytm.hotel4.viewmodel.SRPViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;

public final class az extends ay implements b.a {

    /* renamed from: i  reason: collision with root package name */
    private static final ViewDataBinding.b f29219i = null;
    private static final SparseIntArray j;
    private final ConstraintLayout k;
    private final View.OnClickListener l;
    private long m;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        j = sparseIntArray;
        sparseIntArray.put(R.id.cardView, 4);
        j.put(R.id.layout, 5);
        j.put(R.id.hotelsList, 6);
    }

    public az(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 7, f29219i, j));
    }

    private az(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[4], objArr[2], objArr[3], objArr[6], objArr[5]);
        this.m = -1;
        this.f29211a.setTag((Object) null);
        this.f29213c.setTag((Object) null);
        this.f29214d.setTag((Object) null);
        this.k = objArr[0];
        this.k.setTag((Object) null);
        setRootTag(view);
        this.l = new b(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.m = 4;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.m != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.X == i2) {
            a((SRPViewModel) obj);
        } else if (a.E != i2) {
            return false;
        } else {
            a((SRPHeaderViewModel) obj);
        }
        return true;
    }

    public final void a(SRPViewModel sRPViewModel) {
        this.f29217g = sRPViewModel;
        synchronized (this) {
            this.m |= 1;
        }
        notifyPropertyChanged(a.X);
        super.requestRebind();
    }

    public final void a(SRPHeaderViewModel sRPHeaderViewModel) {
        this.f29218h = sRPHeaderViewModel;
        synchronized (this) {
            this.m |= 2;
        }
        notifyPropertyChanged(a.E);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j2;
        String str;
        synchronized (this) {
            j2 = this.m;
            this.m = 0;
        }
        SRPHeaderViewModel sRPHeaderViewModel = this.f29218h;
        String str2 = null;
        int i2 = ((6 & j2) > 0 ? 1 : ((6 & j2) == 0 ? 0 : -1));
        if (i2 == 0 || sRPHeaderViewModel == null) {
            str = null;
        } else {
            str2 = sRPHeaderViewModel.getSrpHeaderText();
            str = sRPHeaderViewModel.getSrpSubheaderText();
        }
        if ((j2 & 4) != 0) {
            this.f29211a.setOnClickListener(this.l);
        }
        if (i2 != 0) {
            d.a(this.f29213c, (CharSequence) str2);
            d.a(this.f29214d, (CharSequence) str);
        }
    }

    public final void a(int i2) {
        SRPViewModel sRPViewModel = this.f29217g;
        if (sRPViewModel != null) {
            sRPViewModel.onBackPressedSRPMap();
        }
    }
}
