package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import com.travel.flight.a;
import com.travel.flight.pojo.flightticket.CJRFlightDetailsItem;

public final class dp extends Cdo {

    /* renamed from: d  reason: collision with root package name */
    private static final ViewDataBinding.b f23950d = null;

    /* renamed from: e  reason: collision with root package name */
    private static final SparseIntArray f23951e = null;

    /* renamed from: f  reason: collision with root package name */
    private final LinearLayout f23952f;

    /* renamed from: g  reason: collision with root package name */
    private long f23953g;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public dp(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 3, f23950d, f23951e));
    }

    private dp(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[2]);
        this.f23953g = -1;
        this.f23952f = objArr[0];
        this.f23952f.setTag((Object) null);
        this.f23947a.setTag((Object) null);
        this.f23948b.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f23953g = 2;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f23953g != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.x != i2) {
            return false;
        }
        this.f23949c = (CJRFlightDetailsItem) obj;
        synchronized (this) {
            this.f23953g |= 1;
        }
        notifyPropertyChanged(a.x);
        super.requestRebind();
        return true;
    }

    public final void executeBindings() {
        long j;
        Boolean bool;
        synchronized (this) {
            j = this.f23953g;
            this.f23953g = 0;
        }
        CJRFlightDetailsItem cJRFlightDetailsItem = this.f23949c;
        int i2 = 0;
        String str = null;
        int i3 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i3 != 0) {
            if (cJRFlightDetailsItem != null) {
                str = cJRFlightDetailsItem.getHeaderText();
                bool = cJRFlightDetailsItem.getShowIsFarePerAdult();
            } else {
                bool = null;
            }
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            if (i3 != 0) {
                j |= safeUnbox ? 8 : 4;
            }
            if (!safeUnbox) {
                i2 = 8;
            }
        }
        if ((j & 3) != 0) {
            d.a(this.f23947a, (CharSequence) str);
            this.f23948b.setVisibility(i2);
        }
    }
}
