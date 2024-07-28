package net.one97.paytm.hotels2.b;

import android.content.res.ColorStateList;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import com.travel.utils.l;
import net.one97.paytm.hotel4.viewmodel.filter.SRPFilterItemViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;

public final class fj extends fi implements b.a {

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.b f29716e = null;

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f29717f = null;

    /* renamed from: g  reason: collision with root package name */
    private final ConstraintLayout f29718g;

    /* renamed from: h  reason: collision with root package name */
    private final ImageView f29719h;

    /* renamed from: i  reason: collision with root package name */
    private final View.OnClickListener f29720i;
    private long j;

    public fj(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, f29716e, f29717f));
    }

    private fj(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[3], objArr[1]);
        this.j = -1;
        this.f29712a.setTag((Object) null);
        this.f29713b.setTag((Object) null);
        this.f29718g = objArr[0];
        this.f29718g.setTag((Object) null);
        this.f29719h = objArr[2];
        this.f29719h.setTag((Object) null);
        setRootTag(view);
        this.f29720i = new b(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.j = 16;
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
        if (a.J == i2) {
            a((String) obj);
        } else if (a.u != i2) {
            return false;
        } else {
            a((SRPFilterItemViewModel) obj);
        }
        return true;
    }

    public final void a(String str) {
        this.f29714c = str;
        synchronized (this) {
            this.j |= 4;
        }
        notifyPropertyChanged(a.J);
        super.requestRebind();
    }

    public final void a(SRPFilterItemViewModel sRPFilterItemViewModel) {
        this.f29715d = sRPFilterItemViewModel;
        synchronized (this) {
            this.j |= 8;
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
            this.j |= 1;
        }
        return true;
    }

    private boolean c(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.j |= 2;
        }
        return true;
    }

    public final void executeBindings() {
        long j2;
        int i2;
        int i3;
        int i4;
        String str;
        long j3;
        long j4;
        synchronized (this) {
            j2 = this.j;
            this.j = 0;
        }
        String str2 = this.f29714c;
        SRPFilterItemViewModel sRPFilterItemViewModel = this.f29715d;
        if ((27 & j2) != 0) {
            int i5 = ((j2 & 25) > 0 ? 1 : ((j2 & 25) == 0 ? 0 : -1));
            if (i5 != 0) {
                l<Boolean> isSelected = sRPFilterItemViewModel != null ? sRPFilterItemViewModel.isSelected() : null;
                updateLiveDataRegistration(0, isSelected);
                boolean safeUnbox = ViewDataBinding.safeUnbox(isSelected != null ? isSelected.getValue() : null);
                if (i5 != 0) {
                    if (safeUnbox) {
                        j4 = j2 | 64 | 256;
                        j3 = 1024;
                    } else {
                        j4 = j2 | 32 | 128;
                        j3 = 512;
                    }
                    j2 = j4 | j3;
                }
                int colorFromResource = getColorFromResource(this.f29712a, safeUnbox ? R.color.color_00aced : R.color.color_506d85);
                int colorFromResource2 = safeUnbox ? getColorFromResource(this.f29713b, R.color.color_00aced) : getColorFromResource(this.f29713b, R.color.color_506d85);
                i4 = safeUnbox ? 0 : 8;
                i2 = colorFromResource2;
                i3 = colorFromResource;
            } else {
                i4 = 0;
                i3 = 0;
                i2 = 0;
            }
            if ((j2 & 26) != 0) {
                l<String> rangeText = sRPFilterItemViewModel != null ? sRPFilterItemViewModel.getRangeText() : null;
                updateLiveDataRegistration(1, rangeText);
                if (rangeText != null) {
                    str = rangeText.getValue();
                }
            }
            str = null;
        } else {
            str = null;
            i4 = 0;
            i3 = 0;
            i2 = 0;
        }
        if ((26 & j2) != 0) {
            d.a(this.f29712a, (CharSequence) str);
        }
        if ((j2 & 25) != 0) {
            this.f29712a.setTextColor(i3);
            this.f29719h.setVisibility(i4);
            if (getBuildSdkInt() >= 21) {
                this.f29713b.setImageTintList(ColorStateList.valueOf(i2));
            }
        }
        if ((20 & j2) != 0) {
            net.one97.paytm.hotel4.utils.a.a(this.f29713b, str2, (com.paytm.utility.b.b.e) null, (Integer) null);
        }
        if ((j2 & 16) != 0) {
            this.f29718g.setOnClickListener(this.f29720i);
        }
    }

    public final void a(int i2) {
        SRPFilterItemViewModel sRPFilterItemViewModel = this.f29715d;
        if (sRPFilterItemViewModel != null) {
            sRPFilterItemViewModel.onFilterItemClick();
        }
    }
}
