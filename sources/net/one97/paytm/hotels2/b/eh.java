package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.hotel4.viewmodel.DetailsViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;

public final class eh extends eg {

    /* renamed from: h  reason: collision with root package name */
    private static final ViewDataBinding.b f29597h = null;

    /* renamed from: i  reason: collision with root package name */
    private static final SparseIntArray f29598i;
    private final ConstraintLayout j;
    private long k;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f29598i = sparseIntArray;
        sparseIntArray.put(R.id.tv_title, 1);
        f29598i.put(R.id.tv_sub_title, 2);
        f29598i.put(R.id.v_line, 3);
        f29598i.put(R.id.rv_amnts, 4);
        f29598i.put(R.id.tv_amenities_view_all, 5);
        f29598i.put(R.id.v_cell_divider, 6);
    }

    public eh(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 7, f29597h, f29598i));
    }

    private eh(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[4], objArr[5], objArr[2], objArr[1], objArr[6], objArr[3]);
        this.k = -1;
        this.j = objArr[0];
        this.j.setTag((Object) null);
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
        if (a.t != i2) {
            return false;
        }
        this.f29596g = (DetailsViewModel) obj;
        return true;
    }

    public final void a(DetailsViewModel detailsViewModel) {
        this.f29596g = detailsViewModel;
    }

    public final void executeBindings() {
        synchronized (this) {
            this.k = 0;
        }
    }
}
