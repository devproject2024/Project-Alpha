package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import com.travel.flight.R;
import com.travel.flight.a;
import com.travel.flight.pojo.modifyBooking.CJRFlightMBImgNote;
import com.travel.flight.pojo.modifyBooking.CJRFlightMBImportant;
import java.util.List;

public final class p extends o {

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.b f24013f = null;

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f24014g;

    /* renamed from: h  reason: collision with root package name */
    private final ConstraintLayout f24015h;

    /* renamed from: i  reason: collision with root package name */
    private long f24016i;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f24014g = sparseIntArray;
        sparseIntArray.put(R.id.left_guideline, 3);
        f24014g.put(R.id.right_guideline, 4);
    }

    public p(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 5, f24013f, f24014g));
    }

    private p(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[3], objArr[2], objArr[4], objArr[1]);
        this.f24016i = -1;
        this.f24015h = objArr[0];
        this.f24015h.setTag((Object) null);
        this.f24009b.setTag((Object) null);
        this.f24011d.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f24016i = 2;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f24016i != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.I != i2) {
            return false;
        }
        this.f24012e = (CJRFlightMBImportant) obj;
        synchronized (this) {
            this.f24016i |= 1;
        }
        notifyPropertyChanged(a.I);
        super.requestRebind();
        return true;
    }

    public final void executeBindings() {
        long j;
        List<CJRFlightMBImgNote> list;
        synchronized (this) {
            j = this.f24016i;
            this.f24016i = 0;
        }
        CJRFlightMBImportant cJRFlightMBImportant = this.f24012e;
        String str = null;
        int i2 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i2 == 0 || cJRFlightMBImportant == null) {
            list = null;
        } else {
            str = cJRFlightMBImportant.getTitle();
            list = cJRFlightMBImportant.getNotes();
        }
        if (i2 != 0) {
            com.travel.flight.flightticket.b.a.a(this.f24009b, (List<? extends Object>) list);
            d.a(this.f24011d, (CharSequence) str);
        }
    }
}
