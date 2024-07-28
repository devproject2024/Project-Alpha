package net.one97.paytm.hotels2.b;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import com.travel.utils.l;
import net.one97.paytm.hotel4.viewmodel.filter.SRPFilterLocalityAndHotelChainItemViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;

public final class cn extends cm implements b.a {

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.b f29385f = null;

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f29386g;

    /* renamed from: h  reason: collision with root package name */
    private final ConstraintLayout f29387h;

    /* renamed from: i  reason: collision with root package name */
    private final TextView f29388i;
    private final View.OnClickListener j;
    private long k;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f29386g = sparseIntArray;
        sparseIntArray.put(R.id.divider1, 4);
    }

    public cn(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 5, f29385f, f29386g));
    }

    private cn(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[4], objArr[1], objArr[3]);
        this.k = -1;
        this.f29381b.setTag((Object) null);
        this.f29382c.setTag((Object) null);
        this.f29387h = objArr[0];
        this.f29387h.setTag((Object) null);
        this.f29388i = objArr[2];
        this.f29388i.setTag((Object) null);
        setRootTag(view);
        this.j = new b(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.k = 16;
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
        if (a.ai == i2) {
            a((Drawable) obj);
        } else if (a.f29088c != i2) {
            return false;
        } else {
            a((SRPFilterLocalityAndHotelChainItemViewModel) obj);
        }
        return true;
    }

    public final void a(Drawable drawable) {
        this.f29383d = drawable;
        synchronized (this) {
            this.k |= 4;
        }
        notifyPropertyChanged(a.ai);
        super.requestRebind();
    }

    public final void a(SRPFilterLocalityAndHotelChainItemViewModel sRPFilterLocalityAndHotelChainItemViewModel) {
        this.f29384e = sRPFilterLocalityAndHotelChainItemViewModel;
        synchronized (this) {
            this.k |= 8;
        }
        notifyPropertyChanged(a.f29088c);
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
            this.k |= 1;
        }
        return true;
    }

    private boolean c(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.k |= 2;
        }
        return true;
    }

    public final void executeBindings() {
        long j2;
        Drawable drawable;
        int i2;
        ImageView imageView;
        synchronized (this) {
            j2 = this.k;
            this.k = 0;
        }
        Drawable drawable2 = this.f29383d;
        SRPFilterLocalityAndHotelChainItemViewModel sRPFilterLocalityAndHotelChainItemViewModel = this.f29384e;
        String str = null;
        if ((27 & j2) != 0) {
            int i3 = ((j2 & 25) > 0 ? 1 : ((j2 & 25) == 0 ? 0 : -1));
            if (i3 != 0) {
                l<Boolean> isSelected = sRPFilterLocalityAndHotelChainItemViewModel != null ? sRPFilterLocalityAndHotelChainItemViewModel.isSelected() : null;
                updateLiveDataRegistration(0, isSelected);
                boolean safeUnbox = ViewDataBinding.safeUnbox(isSelected != null ? isSelected.getValue() : null);
                if (i3 != 0) {
                    j2 |= safeUnbox ? 64 : 32;
                }
                if (safeUnbox) {
                    imageView = this.f29382c;
                    i2 = R.drawable.h4_checkbox_button_selected;
                } else {
                    imageView = this.f29382c;
                    i2 = R.drawable.h4_check_box_default;
                }
                drawable = getDrawableFromResource(imageView, i2);
            } else {
                drawable = null;
            }
            if ((j2 & 26) != 0) {
                l<String> rangeText = sRPFilterLocalityAndHotelChainItemViewModel != null ? sRPFilterLocalityAndHotelChainItemViewModel.getRangeText() : null;
                updateLiveDataRegistration(1, rangeText);
                if (rangeText != null) {
                    str = rangeText.getValue();
                }
            }
        } else {
            drawable = null;
        }
        if ((20 & j2) != 0) {
            this.f29381b.setImageDrawable(drawable2);
        }
        if ((j2 & 25) != 0) {
            androidx.databinding.a.e.a((View) this.f29382c, drawable);
        }
        if ((16 & j2) != 0) {
            this.f29387h.setOnClickListener(this.j);
        }
        if ((j2 & 26) != 0) {
            d.a(this.f29388i, (CharSequence) str);
        }
    }

    public final void a(int i2) {
        SRPFilterLocalityAndHotelChainItemViewModel sRPFilterLocalityAndHotelChainItemViewModel = this.f29384e;
        if (sRPFilterLocalityAndHotelChainItemViewModel != null) {
            sRPFilterLocalityAndHotelChainItemViewModel.onFilterItemClick();
        }
    }
}
