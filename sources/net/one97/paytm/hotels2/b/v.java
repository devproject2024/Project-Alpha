package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.lifecycle.y;
import java.util.List;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.PriceData;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem;
import net.one97.paytm.hotel4.viewmodel.DetailsViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;

public final class v extends u implements b.a {
    private static final ViewDataBinding.b j = null;
    private static final SparseIntArray k;
    private final ConstraintLayout l;
    private final View.OnClickListener m;
    private long n;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        k = sparseIntArray;
        sparseIntArray.put(R.id.tv_no_night, 7);
        k.put(R.id.tv_discount, 8);
    }

    public v(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 9, j, k));
    }

    private v(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[3], objArr[2], objArr[5], objArr[6], objArr[8], objArr[7], objArr[4], objArr[1]);
        this.n = -1;
        this.f29942a.setTag((Object) null);
        this.l = objArr[0];
        this.l.setTag((Object) null);
        this.f29943b.setTag((Object) null);
        this.f29944c.setTag((Object) null);
        this.f29945d.setTag((Object) null);
        this.f29948g.setTag((Object) null);
        this.f29949h.setTag((Object) null);
        setRootTag(view);
        this.m = new b(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.n = 16;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.n != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.t != i2) {
            return false;
        }
        a((DetailsViewModel) obj);
        return true;
    }

    public final void a(DetailsViewModel detailsViewModel) {
        this.f29950i = detailsViewModel;
        synchronized (this) {
            this.n |= 8;
        }
        notifyPropertyChanged(a.t);
        super.requestRebind();
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return b(i3);
        }
        if (i2 == 1) {
            return c(i3);
        }
        if (i2 != 2) {
            return false;
        }
        return d(i3);
    }

    private boolean b(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.n |= 1;
        }
        return true;
    }

    private boolean c(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.n |= 2;
        }
        return true;
    }

    private boolean d(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.n |= 4;
        }
        return true;
    }

    public final void executeBindings() {
        long j2;
        double d2;
        String str;
        String str2;
        double d3;
        int i2;
        int i3;
        String str3;
        double d4;
        PriceData priceData;
        List<String> list;
        double d5;
        double d6;
        int i4;
        synchronized (this) {
            j2 = this.n;
            this.n = 0;
        }
        DetailsViewModel detailsViewModel = this.f29950i;
        int i5 = 0;
        if ((31 & j2) != 0) {
            if ((j2 & 25) != 0) {
                y<Integer> yVar = detailsViewModel != null ? detailsViewModel.get_originalPrice_visibility() : null;
                updateLiveDataRegistration(0, yVar);
                i3 = ViewDataBinding.safeUnbox(yVar != null ? yVar.getValue() : null);
            } else {
                i3 = 0;
            }
            int i6 = ((j2 & 26) > 0 ? 1 : ((j2 & 26) == 0 ? 0 : -1));
            if (i6 != 0) {
                y<SRPDataItem> selectedData = detailsViewModel != null ? detailsViewModel.getSelectedData() : null;
                boolean z = true;
                updateLiveDataRegistration(1, selectedData);
                SRPDataItem value = selectedData != null ? selectedData.getValue() : null;
                if (value != null) {
                    str = value.getName();
                    priceData = value.getPriceData();
                    list = value.getPromos();
                } else {
                    str = null;
                    list = null;
                    priceData = null;
                }
                if (priceData != null) {
                    d6 = priceData.getOriginalPrice();
                    d5 = priceData.getFinalPrice();
                } else {
                    d6 = 0.0d;
                    d5 = 0.0d;
                }
                String str4 = list != null ? (String) getFromList(list, 0) : null;
                if (str4 != null) {
                    i4 = str4.length();
                } else {
                    i4 = 0;
                }
                if (i4 <= 0) {
                    z = false;
                }
                if (i6 != 0) {
                    j2 |= z ? 64 : 32;
                }
                if (!z) {
                    i5 = 4;
                }
                i2 = i5;
                str2 = str4;
                d2 = d6;
                d4 = d5;
            } else {
                i2 = 0;
                str2 = null;
                str = null;
                d2 = 0.0d;
                d4 = 0.0d;
            }
            if ((j2 & 28) != 0) {
                y<String> yVar2 = detailsViewModel != null ? detailsViewModel.get_streetAddress() : null;
                updateLiveDataRegistration(2, yVar2);
                if (yVar2 != null) {
                    str3 = yVar2.getValue();
                    d3 = d4;
                }
            }
            d3 = d4;
            str3 = null;
        } else {
            str3 = null;
            i3 = 0;
            i2 = 0;
            d3 = 0.0d;
            str2 = null;
            str = null;
            d2 = 0.0d;
        }
        if ((j2 & 16) != 0) {
            this.f29942a.setOnClickListener(this.m);
            net.one97.paytm.hotel4.utils.a.a(this.f29944c);
        }
        if ((j2 & 28) != 0) {
            d.a(this.f29943b, (CharSequence) str3);
        }
        if ((26 & j2) != 0) {
            net.one97.paytm.hotel4.utils.a.a(this.f29944c, d2);
            this.f29945d.setVisibility(i2);
            d.a(this.f29945d, (CharSequence) str2);
            net.one97.paytm.hotel4.utils.a.a(this.f29948g, d3);
            d.a(this.f29949h, (CharSequence) str);
        }
        if ((j2 & 25) != 0) {
            this.f29944c.setVisibility(i3);
        }
    }

    public final void a(int i2) {
        DetailsViewModel detailsViewModel = this.f29950i;
        if (detailsViewModel != null) {
            detailsViewModel.openFullMapFragment();
        }
    }
}
