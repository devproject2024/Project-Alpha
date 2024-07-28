package net.one97.paytm.hotels2.b;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SortKeysItem;
import net.one97.paytm.hotel4.viewmodel.SRPSortListItemViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;

public final class el extends ek implements b.a {

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.b f29613f = null;

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f29614g;

    /* renamed from: h  reason: collision with root package name */
    private final ConstraintLayout f29615h;

    /* renamed from: i  reason: collision with root package name */
    private final View.OnClickListener f29616i;
    private long j;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f29614g = sparseIntArray;
        sparseIntArray.put(R.id.divider1, 3);
        f29614g.put(R.id.sort_sub_text, 4);
    }

    public el(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 5, f29613f, f29614g));
    }

    private el(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[3], objArr[2], objArr[4], objArr[1]);
        this.j = -1;
        this.f29609b.setTag((Object) null);
        this.f29615h = objArr[0];
        this.f29615h.setTag((Object) null);
        this.f29611d.setTag((Object) null);
        setRootTag(view);
        this.f29616i = new b(this, 1);
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
        if (a.f29088c != i2) {
            return false;
        }
        a((SRPSortListItemViewModel) obj);
        return true;
    }

    public final void a(SRPSortListItemViewModel sRPSortListItemViewModel) {
        this.f29612e = sRPSortListItemViewModel;
        synchronized (this) {
            this.j |= 1;
        }
        notifyPropertyChanged(a.f29088c);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j2;
        int i2;
        int i3;
        SortKeysItem sortKeysItem;
        long j3;
        long j4;
        synchronized (this) {
            j2 = this.j;
            this.j = 0;
        }
        SRPSortListItemViewModel sRPSortListItemViewModel = this.f29612e;
        String str = null;
        int i4 = 0;
        int i5 = ((j2 & 3) > 0 ? 1 : ((j2 & 3) == 0 ? 0 : -1));
        if (i5 != 0) {
            if (sRPSortListItemViewModel != null) {
                i2 = sRPSortListItemViewModel.isSelected();
                sortKeysItem = sRPSortListItemViewModel.getSortKeysItem();
            } else {
                sortKeysItem = null;
                i2 = 0;
            }
            if (i2 == 0) {
                i4 = 1;
            }
            if (i5 != 0) {
                if (i4 != 0) {
                    j4 = j2 | 8;
                    j3 = 32;
                } else {
                    j4 = j2 | 4;
                    j3 = 16;
                }
                j2 = j4 | j3;
            }
            if (sortKeysItem != null) {
                str = sortKeysItem.getName();
            }
            i3 = getColorFromResource(this.f29611d, i4 != 0 ? R.color.color_00aced : R.color.color_222222);
            i4 = getColorFromResource(this.f29615h, i4 != 0 ? R.color.color_e5f6fd : R.color.hotel_white);
        } else {
            i3 = 0;
            i2 = 0;
        }
        if ((3 & j2) != 0) {
            this.f29609b.setVisibility(i2);
            androidx.databinding.a.e.a((View) this.f29615h, (Drawable) androidx.databinding.a.b.a(i4));
            d.a(this.f29611d, (CharSequence) str);
            this.f29611d.setTextColor(i3);
        }
        if ((j2 & 2) != 0) {
            this.f29615h.setOnClickListener(this.f29616i);
        }
    }

    public final void a(int i2) {
        SRPSortListItemViewModel sRPSortListItemViewModel = this.f29612e;
        if (sRPSortListItemViewModel != null) {
            sRPSortListItemViewModel.onRecyclerItemClick();
        }
    }
}
