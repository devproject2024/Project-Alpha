package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import com.travel.flight.R;
import com.travel.flight.e.a.a;
import com.travel.flight.flightSRPV2.viewModel.DRTListViewModel;
import com.travel.flight.pojo.flightticket.CJRDiscountedStrip;
import com.travel.flight.utils.c;
import java.util.ArrayList;

public final class ax extends aw implements a.C0456a {

    /* renamed from: i  reason: collision with root package name */
    private static final ViewDataBinding.b f23653i = null;
    private static final SparseIntArray j;
    private final View.OnClickListener k;
    private long l;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        j = sparseIntArray;
        sparseIntArray.put(R.id.txt_rupee_symbol, 4);
    }

    public ax(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 5, f23653i, j));
    }

    private ax(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[0], objArr[2], objArr[3], objArr[4]);
        this.l = -1;
        this.f23645a.setTag((Object) null);
        this.f23646b.setTag((Object) null);
        this.f23647c.setTag((Object) null);
        this.f23648d.setTag((Object) null);
        setRootTag(view);
        this.k = new a(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.l = 8;
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
        if (com.travel.flight.a.n == i2) {
            this.f23652h = (ArrayList) obj;
            synchronized (this) {
                this.l |= 1;
            }
            notifyPropertyChanged(com.travel.flight.a.n);
            super.requestRebind();
        } else if (com.travel.flight.a.J == i2) {
            this.f23651g = (CJRDiscountedStrip) obj;
            synchronized (this) {
                this.l |= 2;
            }
            notifyPropertyChanged(com.travel.flight.a.J);
            super.requestRebind();
        } else if (com.travel.flight.a.f23479c != i2) {
            return false;
        } else {
            this.f23650f = (DRTListViewModel) obj;
            synchronized (this) {
                this.l |= 4;
            }
            notifyPropertyChanged(com.travel.flight.a.f23479c);
            super.requestRebind();
        }
        return true;
    }

    public final void executeBindings() {
        long j2;
        String str;
        String str2;
        synchronized (this) {
            j2 = this.l;
            this.l = 0;
        }
        ArrayList arrayList = this.f23652h;
        CJRDiscountedStrip cJRDiscountedStrip = this.f23651g;
        String str3 = null;
        int i2 = ((11 & j2) > 0 ? 1 : ((11 & j2) == 0 ? 0 : -1));
        if (i2 == 0 || (j2 & 10) == 0) {
            str2 = null;
            str = null;
        } else {
            if (cJRDiscountedStrip != null) {
                str2 = cJRDiscountedStrip.getAirlineCode();
                str = cJRDiscountedStrip.getAirline();
                str3 = cJRDiscountedStrip.getDisplayPrice();
            } else {
                str2 = null;
                str = null;
            }
            str3 = c.h(str3);
        }
        if ((10 & j2) != 0) {
            com.travel.flight.flightSRPV2.c.c.a(this.f23645a, str2, getDrawableFromResource(this.f23645a, R.drawable.pre_f_defaultcarrier), getDrawableFromResource(this.f23645a, R.drawable.pre_f_defaultcarrier));
            d.a((TextView) this.f23647c, (CharSequence) str);
            d.a(this.f23648d, (CharSequence) str3);
        }
        if ((j2 & 8) != 0) {
            this.f23646b.setOnClickListener(this.k);
        }
        if (i2 != 0) {
            DRTListViewModel.setBackgroundOfItemLayout(this.f23646b, cJRDiscountedStrip, arrayList);
        }
    }

    public final void a(int i2, View view) {
        CJRDiscountedStrip cJRDiscountedStrip = this.f23651g;
        DRTListViewModel dRTListViewModel = this.f23650f;
        if (dRTListViewModel != null) {
            dRTListViewModel.onDiscountStripItemClick(cJRDiscountedStrip);
        }
    }
}
