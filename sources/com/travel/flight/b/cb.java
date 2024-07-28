package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.travel.flight.R;
import com.travel.flight.a;
import com.travel.flight.pojo.Header;
import com.travel.flight.pojo.PaymentDetail;
import com.travel.flight.utils.m;

public final class cb extends ca {

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.b f23785f = null;

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f23786g;

    /* renamed from: h  reason: collision with root package name */
    private final ConstraintLayout f23787h;

    /* renamed from: i  reason: collision with root package name */
    private final TextView f23788i;
    private long j;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f23786g = sparseIntArray;
        sparseIntArray.put(R.id.separator, 4);
        f23786g.put(R.id.itemsRecyclerView, 5);
    }

    public cb(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 6, f23785f, f23786g));
    }

    private cb(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[2], objArr[5], objArr[4], objArr[1]);
        this.j = -1;
        this.f23780a.setTag((Object) null);
        this.f23787h = objArr[0];
        this.f23787h.setTag((Object) null);
        this.f23788i = objArr[3];
        this.f23788i.setTag((Object) null);
        this.f23783d.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.j = 2;
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
        if (a.o != i2) {
            return false;
        }
        a((PaymentDetail) obj);
        return true;
    }

    public final void a(PaymentDetail paymentDetail) {
        this.f23784e = paymentDetail;
        synchronized (this) {
            this.j |= 1;
        }
        notifyPropertyChanged(a.o);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j2;
        Header header;
        boolean z;
        synchronized (this) {
            j2 = this.j;
            this.j = 0;
        }
        PaymentDetail paymentDetail = this.f23784e;
        Integer num = null;
        int i2 = 0;
        int i3 = ((j2 & 3) > 0 ? 1 : ((j2 & 3) == 0 ? 0 : -1));
        if (i3 != 0) {
            if (paymentDetail != null) {
                header = paymentDetail.getHeader();
                z = paymentDetail.haveValidHeader();
            } else {
                header = null;
                z = false;
            }
            if (header != null) {
                num = header.getPrice();
            }
            boolean z2 = !z;
            if (i3 != 0) {
                j2 |= z2 ? 8 : 4;
            }
            if (z2) {
                i2 = 8;
            }
        } else {
            header = null;
        }
        if ((j2 & 3) != 0) {
            this.f23780a.setVisibility(i2);
            m.a(this.f23788i, num);
            this.f23788i.setVisibility(i2);
            m.a(this.f23783d, header);
            this.f23783d.setVisibility(i2);
        }
    }
}
