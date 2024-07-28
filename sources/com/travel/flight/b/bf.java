package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import com.travel.flight.R;
import com.travel.flight.a;
import com.travel.flight.pojo.Card;
import com.travel.flight.pojo.FlightBookingRefundDetails;
import java.util.List;

public final class bf extends be {

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.b f23686f = null;

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f23687g;

    /* renamed from: h  reason: collision with root package name */
    private final CardView f23688h;

    /* renamed from: i  reason: collision with root package name */
    private long f23689i;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f23687g = sparseIntArray;
        sparseIntArray.put(R.id.checkImage, 3);
        f23687g.put(R.id.separator, 4);
    }

    public bf(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 5, f23686f, f23687g));
    }

    private bf(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[3], objArr[1], objArr[2], objArr[4]);
        this.f23689i = -1;
        this.f23688h = objArr[0];
        this.f23688h.setTag((Object) null);
        this.f23682b.setTag((Object) null);
        this.f23683c.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f23689i = 2;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f23689i != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.t != i2) {
            return false;
        }
        a((FlightBookingRefundDetails) obj);
        return true;
    }

    public final void a(FlightBookingRefundDetails flightBookingRefundDetails) {
        this.f23685e = flightBookingRefundDetails;
        synchronized (this) {
            this.f23689i |= 1;
        }
        notifyPropertyChanged(a.t);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j;
        String str;
        synchronized (this) {
            j = this.f23689i;
            this.f23689i = 0;
        }
        FlightBookingRefundDetails flightBookingRefundDetails = this.f23685e;
        List<Card> list = null;
        int i2 = 0;
        int i3 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i3 != 0) {
            if (flightBookingRefundDetails != null) {
                list = flightBookingRefundDetails.getCards();
                str = flightBookingRefundDetails.getHeader();
            } else {
                str = null;
            }
            boolean z = flightBookingRefundDetails == null;
            if (i3 != 0) {
                j |= z ? 8 : 4;
            }
            if (z) {
                i2 = 8;
            }
        } else {
            str = null;
        }
        if ((j & 3) != 0) {
            this.f23688h.setVisibility(i2);
            d.a(this.f23682b, (CharSequence) str);
            com.travel.flight.utils.a.b(this.f23683c, list);
        }
    }
}
