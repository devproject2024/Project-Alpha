package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import com.travel.flight.a;
import com.travel.flight.pojo.modifyBooking.CJRFlightMBImgNote;

public final class t extends s {

    /* renamed from: c  reason: collision with root package name */
    private static final ViewDataBinding.b f24025c = null;

    /* renamed from: d  reason: collision with root package name */
    private static final SparseIntArray f24026d = null;

    /* renamed from: e  reason: collision with root package name */
    private final ConstraintLayout f24027e;

    /* renamed from: f  reason: collision with root package name */
    private final TextView f24028f;

    /* renamed from: g  reason: collision with root package name */
    private long f24029g;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public t(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 3, f24025c, f24026d));
    }

    private t(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1]);
        this.f24029g = -1;
        this.f24023a.setTag((Object) null);
        this.f24027e = objArr[0];
        this.f24027e.setTag((Object) null);
        this.f24028f = objArr[2];
        this.f24028f.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f24029g = 2;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f24029g != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.F != i2) {
            return false;
        }
        this.f24024b = (CJRFlightMBImgNote) obj;
        synchronized (this) {
            this.f24029g |= 1;
        }
        notifyPropertyChanged(a.F);
        super.requestRebind();
        return true;
    }

    public final void executeBindings() {
        long j;
        String str;
        synchronized (this) {
            j = this.f24029g;
            this.f24029g = 0;
        }
        CJRFlightMBImgNote cJRFlightMBImgNote = this.f24024b;
        String str2 = null;
        int i2 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i2 == 0 || cJRFlightMBImgNote == null) {
            str = null;
        } else {
            str2 = cJRFlightMBImgNote.getText();
            str = cJRFlightMBImgNote.getImage();
        }
        if (i2 != 0) {
            com.travel.flight.flightticket.b.a.a(this.f24023a, str);
            d.a(this.f24028f, (CharSequence) str2);
        }
    }
}
