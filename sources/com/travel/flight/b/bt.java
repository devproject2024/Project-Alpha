package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import com.travel.flight.R;
import com.travel.flight.a;
import com.travel.flight.flightSRPV2.a.ag;
import com.travel.flight.flightSRPV2.c.c;

public final class bt extends bs {

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.b f23743e = null;

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f23744f;

    /* renamed from: g  reason: collision with root package name */
    private final LinearLayout f23745g;

    /* renamed from: h  reason: collision with root package name */
    private long f23746h;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f23744f = sparseIntArray;
        sparseIntArray.put(R.id.img_view_close, 3);
    }

    public bt(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, f23743e, f23744f));
    }

    private bt(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[3], objArr[1], objArr[2]);
        this.f23746h = -1;
        this.f23740b.setTag((Object) null);
        this.f23745g = objArr[0];
        this.f23745g.setTag((Object) null);
        this.f23741c.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f23746h = 2;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f23746h != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.B != i2) {
            return false;
        }
        a((ag) obj);
        return true;
    }

    public final void a(ag agVar) {
        this.f23742d = agVar;
        synchronized (this) {
            this.f23746h |= 1;
        }
        notifyPropertyChanged(a.B);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j;
        String str;
        synchronized (this) {
            j = this.f23746h;
            this.f23746h = 0;
        }
        ag agVar = this.f23742d;
        String str2 = null;
        int i2 = 0;
        int i3 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i3 != 0) {
            if (agVar != null) {
                String str3 = agVar.f24087a;
                str2 = agVar.f24088b;
                str = str3;
            } else {
                str = null;
            }
            boolean z = str2 != null;
            if (i3 != 0) {
                j |= z ? 8 : 4;
            }
            if (!z) {
                i2 = 8;
            }
        } else {
            str = null;
        }
        if ((j & 3) != 0) {
            c.b(this.f23740b, str2);
            this.f23740b.setVisibility(i2);
            d.a(this.f23741c, (CharSequence) str);
        }
    }
}
