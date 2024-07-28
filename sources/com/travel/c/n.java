package com.travel.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import com.travel.a;
import com.travel.booking.c.a;
import com.travel.booking.datamodel.BookingInfo;
import com.travel.booking.datamodel.CJRTravelBookingData;
import java.util.List;
import kotlin.g.b.k;

public final class n extends m {

    /* renamed from: c  reason: collision with root package name */
    private static final ViewDataBinding.b f22908c = null;

    /* renamed from: d  reason: collision with root package name */
    private static final SparseIntArray f22909d = null;

    /* renamed from: e  reason: collision with root package name */
    private final ConstraintLayout f22910e;

    /* renamed from: f  reason: collision with root package name */
    private final TextView f22911f;

    /* renamed from: g  reason: collision with root package name */
    private final ImageView f22912g;

    /* renamed from: h  reason: collision with root package name */
    private long f22913h;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public n(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, f22908c, f22909d));
    }

    private n(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1]);
        this.f22913h = -1;
        this.f22910e = objArr[0];
        this.f22910e.setTag((Object) null);
        this.f22911f = objArr[2];
        this.f22911f.setTag((Object) null);
        this.f22912g = objArr[3];
        this.f22912g.setTag((Object) null);
        this.f22906a.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f22913h = 2;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f22913h != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.f21419d != i2) {
            return false;
        }
        a((CJRTravelBookingData) obj);
        return true;
    }

    public final void a(CJRTravelBookingData cJRTravelBookingData) {
        this.f22907b = cJRTravelBookingData;
        synchronized (this) {
            this.f22913h |= 1;
        }
        notifyPropertyChanged(a.f21419d);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j;
        String str;
        String str2;
        List<BookingInfo> list;
        int i2;
        synchronized (this) {
            j = this.f22913h;
            this.f22913h = 0;
        }
        CJRTravelBookingData cJRTravelBookingData = this.f22907b;
        String str3 = null;
        int i3 = 0;
        int i4 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i4 != 0) {
            if (cJRTravelBookingData != null) {
                str3 = cJRTravelBookingData.getUrl();
                list = cJRTravelBookingData.getBookingList();
                str = cJRTravelBookingData.getNoDataHeader();
                str2 = cJRTravelBookingData.getNoDataSubHeader();
            } else {
                str2 = null;
                list = null;
                str = null;
            }
            if (list != null) {
                i2 = list.size();
            } else {
                i2 = 0;
            }
            boolean z = i2 == 0;
            if (i4 != 0) {
                j |= z ? 8 : 4;
            }
            if (!z) {
                i3 = 8;
            }
        } else {
            str2 = null;
            str = null;
        }
        if ((j & 3) != 0) {
            this.f22910e.setVisibility(i3);
            TextView textView = this.f22911f;
            k.c(textView, "textView");
            textView.setPaintFlags(textView.getPaintFlags() | 8);
            textView.setText(str2);
            textView.setOnClickListener(a.b.f21475a);
            com.travel.booking.c.a.a(this.f22912g, str3);
            d.a(this.f22906a, (CharSequence) str);
        }
    }
}
