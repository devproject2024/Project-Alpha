package net.one97.paytm.hotels2.b;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import com.travel.utils.l;
import net.one97.paytm.hotel4.viewmodel.filter.SRPFilterItemViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;

public final class ev extends eu implements b.a {

    /* renamed from: b  reason: collision with root package name */
    private static final ViewDataBinding.b f29654b = null;

    /* renamed from: c  reason: collision with root package name */
    private static final SparseIntArray f29655c = null;

    /* renamed from: d  reason: collision with root package name */
    private final LinearLayout f29656d;

    /* renamed from: e  reason: collision with root package name */
    private final ConstraintLayout f29657e;

    /* renamed from: f  reason: collision with root package name */
    private final TextView f29658f;

    /* renamed from: g  reason: collision with root package name */
    private final View.OnClickListener f29659g;

    /* renamed from: h  reason: collision with root package name */
    private long f29660h;

    public ev(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 3, f29654b, f29655c));
    }

    private ev(e eVar, View view, Object[] objArr) {
        super(eVar, view);
        this.f29660h = -1;
        this.f29656d = objArr[0];
        this.f29656d.setTag((Object) null);
        this.f29657e = objArr[1];
        this.f29657e.setTag((Object) null);
        this.f29658f = objArr[2];
        this.f29658f.setTag((Object) null);
        setRootTag(view);
        this.f29659g = new b(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f29660h = 8;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f29660h != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.u != i2) {
            return false;
        }
        a((SRPFilterItemViewModel) obj);
        return true;
    }

    public final void a(SRPFilterItemViewModel sRPFilterItemViewModel) {
        this.f29653a = sRPFilterItemViewModel;
        synchronized (this) {
            this.f29660h |= 4;
        }
        notifyPropertyChanged(a.u);
        super.requestRebind();
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return b(i3);
        }
        if (i2 != 1) {
            return false;
        }
        return c(i3);
    }

    private boolean b(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.f29660h |= 1;
        }
        return true;
    }

    private boolean c(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.f29660h |= 2;
        }
        return true;
    }

    public final void executeBindings() {
        long j;
        Drawable drawable;
        int i2;
        ConstraintLayout constraintLayout;
        synchronized (this) {
            j = this.f29660h;
            this.f29660h = 0;
        }
        SRPFilterItemViewModel sRPFilterItemViewModel = this.f29653a;
        String str = null;
        if ((15 & j) != 0) {
            int i3 = ((j & 13) > 0 ? 1 : ((j & 13) == 0 ? 0 : -1));
            if (i3 != 0) {
                l<Boolean> isSelected = sRPFilterItemViewModel != null ? sRPFilterItemViewModel.isSelected() : null;
                updateLiveDataRegistration(0, isSelected);
                boolean safeUnbox = ViewDataBinding.safeUnbox(isSelected != null ? isSelected.getValue() : null);
                if (i3 != 0) {
                    j |= safeUnbox ? 32 : 16;
                }
                if (safeUnbox) {
                    constraintLayout = this.f29657e;
                    i2 = R.drawable.h4_bg_selected_blue_round;
                } else {
                    constraintLayout = this.f29657e;
                    i2 = R.drawable.h4_bg_detail_night;
                }
                drawable = getDrawableFromResource(constraintLayout, i2);
            } else {
                drawable = null;
            }
            if ((j & 14) != 0) {
                l<String> rangeText = sRPFilterItemViewModel != null ? sRPFilterItemViewModel.getRangeText() : null;
                updateLiveDataRegistration(1, rangeText);
                if (rangeText != null) {
                    str = rangeText.getValue();
                }
            }
        } else {
            drawable = null;
        }
        if ((8 & j) != 0) {
            this.f29656d.setOnClickListener(this.f29659g);
        }
        if ((13 & j) != 0) {
            androidx.databinding.a.e.a((View) this.f29657e, drawable);
        }
        if ((j & 14) != 0) {
            d.a(this.f29658f, (CharSequence) str);
        }
    }

    public final void a(int i2) {
        SRPFilterItemViewModel sRPFilterItemViewModel = this.f29653a;
        if (sRPFilterItemViewModel != null) {
            sRPFilterItemViewModel.onFilterItemClick();
        }
    }
}
