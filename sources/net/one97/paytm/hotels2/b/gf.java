package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import net.one97.paytm.hotel4.viewmodel.SRPHeaderViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;

public final class gf extends ge implements b.a {

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.b f29819f = null;

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f29820g;

    /* renamed from: h  reason: collision with root package name */
    private final ConstraintLayout f29821h;

    /* renamed from: i  reason: collision with root package name */
    private final View.OnClickListener f29822i;
    private long j;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f29820g = sparseIntArray;
        sparseIntArray.put(R.id.h4_imageView, 4);
    }

    public gf(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 5, f29819f, f29820g));
    }

    private gf(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[4], objArr[2], objArr[1], objArr[3]);
        this.j = -1;
        this.f29815b.setTag((Object) null);
        this.f29821h = objArr[0];
        this.f29821h.setTag((Object) null);
        this.f29816c.setTag((Object) null);
        this.f29817d.setTag((Object) null);
        setRootTag(view);
        this.f29822i = new b(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.j = 2;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.j != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.P != i2) {
            return false;
        }
        a((SRPHeaderViewModel) obj);
        return true;
    }

    public final void a(SRPHeaderViewModel sRPHeaderViewModel) {
        this.f29818e = sRPHeaderViewModel;
        synchronized (this) {
            this.j |= 1;
        }
        notifyPropertyChanged(a.P);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j2;
        String str;
        synchronized (this) {
            j2 = this.j;
            this.j = 0;
        }
        SRPHeaderViewModel sRPHeaderViewModel = this.f29818e;
        String str2 = null;
        int i2 = ((3 & j2) > 0 ? 1 : ((3 & j2) == 0 ? 0 : -1));
        if (i2 == 0 || sRPHeaderViewModel == null) {
            str = null;
        } else {
            str2 = sRPHeaderViewModel.getSrpSubheaderText();
            str = sRPHeaderViewModel.getSrpHeaderText();
        }
        if ((j2 & 2) != 0) {
            this.f29815b.setOnClickListener(this.f29822i);
        }
        if (i2 != 0) {
            d.a(this.f29816c, (CharSequence) str);
            d.a(this.f29817d, (CharSequence) str2);
        }
    }

    public final void a(int i2) {
        SRPHeaderViewModel sRPHeaderViewModel = this.f29818e;
        if (sRPHeaderViewModel != null) {
            sRPHeaderViewModel.onEditClick();
        }
    }
}
