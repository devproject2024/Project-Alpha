package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import net.one97.paytm.hotel4.viewmodel.SRPHeaderViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;

public final class gj extends gi {

    /* renamed from: g  reason: collision with root package name */
    private static final ViewDataBinding.b f29838g = null;

    /* renamed from: h  reason: collision with root package name */
    private static final SparseIntArray f29839h;

    /* renamed from: i  reason: collision with root package name */
    private final ConstraintLayout f29840i;
    private final TextView j;
    private long k;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f29839h = sparseIntArray;
        sparseIntArray.put(R.id.header, 3);
        f29839h.put(R.id.h4_imageView, 4);
        f29839h.put(R.id.loading_text, 5);
        f29839h.put(R.id.lottieAnim, 6);
    }

    public gj(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 7, f29838g, f29839h));
    }

    private gj(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[4], objArr[3], objArr[5], objArr[6], objArr[1]);
        this.k = -1;
        this.f29840i = objArr[0];
        this.f29840i.setTag((Object) null);
        this.j = objArr[2];
        this.j.setTag((Object) null);
        this.f29836e.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.k = 2;
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
        if (a.q != i2) {
            return false;
        }
        a((SRPHeaderViewModel) obj);
        return true;
    }

    public final void a(SRPHeaderViewModel sRPHeaderViewModel) {
        this.f29837f = sRPHeaderViewModel;
        synchronized (this) {
            this.k |= 1;
        }
        notifyPropertyChanged(a.q);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j2;
        String str;
        synchronized (this) {
            j2 = this.k;
            this.k = 0;
        }
        SRPHeaderViewModel sRPHeaderViewModel = this.f29837f;
        String str2 = null;
        int i2 = ((j2 & 3) > 0 ? 1 : ((j2 & 3) == 0 ? 0 : -1));
        if (i2 == 0 || sRPHeaderViewModel == null) {
            str = null;
        } else {
            str2 = sRPHeaderViewModel.getDateText();
            str = sRPHeaderViewModel.getSrpLoaderHeaderText();
        }
        if (i2 != 0) {
            d.a(this.j, (CharSequence) str2);
            d.a(this.f29836e, (CharSequence) str);
        }
    }
}
