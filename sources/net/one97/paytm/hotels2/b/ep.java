package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.hotel4.viewmodel.SRPHeaderViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;

public final class ep extends eo implements b.a {

    /* renamed from: h  reason: collision with root package name */
    private static final ViewDataBinding.b f29633h = null;

    /* renamed from: i  reason: collision with root package name */
    private static final SparseIntArray f29634i;
    private final LinearLayout j;
    private final View.OnClickListener k;
    private long l;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f29634i = sparseIntArray;
        sparseIntArray.put(R.id.no_message, 3);
        f29634i.put(R.id.header, 4);
        f29634i.put(R.id.sub_header, 5);
        f29634i.put(R.id.or, 6);
    }

    public ep(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 7, f29633h, f29634i));
    }

    private ep(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[2], objArr[4], objArr[1], objArr[3], objArr[6], objArr[5]);
        this.l = -1;
        this.f29626a.setTag((Object) null);
        this.f29628c.setTag((Object) null);
        this.j = objArr[0];
        this.j.setTag((Object) null);
        setRootTag(view);
        this.k = new b(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.l = 2;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.l != 0) {
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
        this.f29632g = sRPHeaderViewModel;
        synchronized (this) {
            this.l |= 1;
        }
        notifyPropertyChanged(a.q);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j2;
        synchronized (this) {
            j2 = this.l;
            this.l = 0;
        }
        SRPHeaderViewModel sRPHeaderViewModel = this.f29632g;
        int i2 = ((3 & j2) > 0 ? 1 : ((3 & j2) == 0 ? 0 : -1));
        String errorURL = (i2 == 0 || sRPHeaderViewModel == null) ? null : sRPHeaderViewModel.getErrorURL();
        if ((j2 & 2) != 0) {
            this.f29626a.setOnClickListener(this.k);
        }
        if (i2 != 0) {
            net.one97.paytm.hotel4.utils.a.a(this.f29628c, errorURL, (com.paytm.utility.b.b.e) null, (Integer) null);
        }
    }

    public final void a(int i2) {
        SRPHeaderViewModel sRPHeaderViewModel = this.f29632g;
        if (sRPHeaderViewModel != null) {
            sRPHeaderViewModel.onEditClick();
        }
    }
}
