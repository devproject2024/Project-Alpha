package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.lifecycle.y;
import com.travel.flight.R;
import com.travel.flight.e.a.a;
import com.travel.flight.flightSRPV2.viewModel.DRTListViewModel;

public final class bj extends bi implements a.C0456a {
    private static final ViewDataBinding.b l = null;
    private static final SparseIntArray m;
    private final View.OnClickListener n;
    private long o;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        m = sparseIntArray;
        sparseIntArray.put(R.id.view_top_shadow, 5);
        m.put(R.id.flight_price_lyt, 6);
        m.put(R.id.rupees_text, 7);
        m.put(R.id.rupees_text_special_price, 8);
        m.put(R.id.fare_for_one_adult_text, 9);
    }

    public bj(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 10, l, m));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private bj(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[3], objArr[9], objArr[6], objArr[1], objArr[0], objArr[4], objArr[2], objArr[7], objArr[8], objArr[5]);
        this.o = -1;
        this.f23697a.setTag((Object) null);
        this.f23700d.setTag((Object) null);
        this.f23701e.setTag((Object) null);
        this.f23702f.setTag((Object) null);
        this.f23703g.setTag((Object) null);
        setRootTag(view);
        this.n = new a(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.o = 8;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.o != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (com.travel.flight.a.f23479c != i2) {
            return false;
        }
        a((DRTListViewModel) obj);
        return true;
    }

    public final void a(DRTListViewModel dRTListViewModel) {
        this.k = dRTListViewModel;
        synchronized (this) {
            this.o |= 4;
        }
        notifyPropertyChanged(com.travel.flight.a.f23479c);
        super.requestRebind();
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return a(i3);
        }
        if (i2 != 1) {
            return false;
        }
        return b(i3);
    }

    private boolean a(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.o |= 1;
        }
        return true;
    }

    private boolean b(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.o |= 2;
        }
        return true;
    }

    public final void executeBindings() {
        long j;
        boolean z;
        String str;
        String str2;
        y<String> yVar;
        int i2;
        synchronized (this) {
            j = this.o;
            this.o = 0;
        }
        DRTListViewModel dRTListViewModel = this.k;
        String str3 = null;
        int i3 = ((j & 15) > 0 ? 1 : ((j & 15) == 0 ? 0 : -1));
        if (i3 != 0) {
            if ((j & 13) != 0) {
                yVar = dRTListViewModel != null ? dRTListViewModel.getFlightPrice() : null;
                updateLiveDataRegistration(0, yVar);
                str2 = yVar != null ? yVar.getValue() : null;
            } else {
                yVar = null;
                str2 = null;
            }
            y<String> discountedFlightPrice = dRTListViewModel != null ? dRTListViewModel.getDiscountedFlightPrice() : null;
            z = true;
            updateLiveDataRegistration(1, discountedFlightPrice);
            if (discountedFlightPrice != null) {
                str = discountedFlightPrice.getValue();
            } else {
                str = null;
            }
            if (str == null) {
                z = false;
            }
            if (i3 != 0) {
                j = z ? j | 32 : j | 16;
            }
            if ((j & 14) != 0) {
                j |= z ? 128 : 64;
            }
            i2 = ((j & 14) == 0 || z) ? 0 : 8;
        } else {
            yVar = null;
            str2 = null;
            str = null;
            i2 = 0;
            z = false;
        }
        if ((16 & j) != 0) {
            if (dRTListViewModel != null) {
                yVar = dRTListViewModel.getFlightPrice();
            }
            updateLiveDataRegistration(0, yVar);
            if (yVar != null) {
                str2 = yVar.getValue();
            }
        }
        int i4 = ((15 & j) > 0 ? 1 : ((15 & j) == 0 ? 0 : -1));
        if (i4 != 0) {
            str3 = z ? str : str2;
        }
        String str4 = str3;
        if ((13 & j) != 0) {
            d.a((TextView) this.f23697a, (CharSequence) str2);
        }
        if (i4 != 0) {
            d.a((TextView) this.f23700d, (CharSequence) str4);
        }
        if ((8 & j) != 0) {
            this.f23702f.setOnClickListener(this.n);
        }
        if ((j & 14) != 0) {
            this.f23703g.setVisibility(i2);
        }
    }

    public final void a(int i2, View view) {
        DRTListViewModel dRTListViewModel = this.k;
        if (dRTListViewModel != null) {
            dRTListViewModel.proceedToBook();
        }
    }
}
