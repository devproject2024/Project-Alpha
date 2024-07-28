package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.lifecycle.y;
import net.one97.paytm.hotel4.service.model.ordersummary.MetaData;
import net.one97.paytm.hotel4.viewmodel.CancelOrderViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;

public final class l extends k {

    /* renamed from: h  reason: collision with root package name */
    private static final ViewDataBinding.b f29904h = null;

    /* renamed from: i  reason: collision with root package name */
    private static final SparseIntArray f29905i;
    private final LinearLayout j;
    private final TextView k;
    private long l;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f29905i = sparseIntArray;
        sparseIntArray.put(R.id.constraint_2, 7);
    }

    public l(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 8, f29904h, f29905i));
    }

    private l(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[2], objArr[5], objArr[6], objArr[7], objArr[3]);
        this.l = -1;
        this.f29897a.setTag((Object) null);
        this.f29898b.setTag((Object) null);
        this.f29899c.setTag((Object) null);
        this.f29900d.setTag((Object) null);
        this.j = objArr[0];
        this.j.setTag((Object) null);
        this.k = objArr[4];
        this.k.setTag((Object) null);
        this.f29902f.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.l = 4;
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
        if (a.s != i2) {
            return false;
        }
        a((CancelOrderViewModel) obj);
        return true;
    }

    public final void a(CancelOrderViewModel cancelOrderViewModel) {
        this.f29903g = cancelOrderViewModel;
        synchronized (this) {
            this.l |= 2;
        }
        notifyPropertyChanged(a.s);
        super.requestRebind();
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return a(i3);
    }

    private boolean a(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.l |= 1;
        }
        return true;
    }

    public final void executeBindings() {
        long j2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Integer num;
        synchronized (this) {
            j2 = this.l;
            this.l = 0;
        }
        CancelOrderViewModel cancelOrderViewModel = this.f29903g;
        String str6 = null;
        int i2 = ((7 & j2) > 0 ? 1 : ((7 & j2) == 0 ? 0 : -1));
        if (i2 != 0) {
            y<MetaData> metaData = cancelOrderViewModel != null ? cancelOrderViewModel.getMetaData() : null;
            updateLiveDataRegistration(0, metaData);
            MetaData value = metaData != null ? metaData.getValue() : null;
            if (value != null) {
                str4 = value.getCheckInTime();
                num = value.numNights;
                str2 = value.checkOutDate;
                str = value.getCheckOutTime();
                str5 = value.checkInDate;
            } else {
                str5 = null;
                str4 = null;
                num = null;
                str2 = null;
                str = null;
            }
            str3 = String.valueOf(ViewDataBinding.safeUnbox(num));
            if (!((j2 & 6) == 0 || cancelOrderViewModel == null)) {
                str6 = cancelOrderViewModel.getNightText();
            }
        } else {
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
        }
        if (i2 != 0) {
            d.a(this.f29897a, (CharSequence) str5);
            d.a(this.f29898b, (CharSequence) str4);
            d.a(this.f29899c, (CharSequence) str2);
            d.a(this.f29900d, (CharSequence) str);
            d.a(this.f29902f, (CharSequence) str3);
        }
        if ((j2 & 6) != 0) {
            d.a(this.k, (CharSequence) str6);
        }
    }
}
