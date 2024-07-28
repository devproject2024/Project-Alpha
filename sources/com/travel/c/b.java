package com.travel.c;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import com.travel.R;
import com.travel.e.a.a;

public final class b extends a implements a.C0453a {

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.b f22858e = null;

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f22859f;

    /* renamed from: g  reason: collision with root package name */
    private final ConstraintLayout f22860g;

    /* renamed from: h  reason: collision with root package name */
    private final View.OnClickListener f22861h;

    /* renamed from: i  reason: collision with root package name */
    private long f22862i;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f22859f = sparseIntArray;
        sparseIntArray.put(R.id.image_view_paytm_travel, 3);
    }

    public b(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, f22858e, f22859f));
    }

    private b(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[3], objArr[2]);
        this.f22862i = -1;
        this.f22826a.setTag((Object) null);
        this.f22860g = objArr[0];
        this.f22860g.setTag((Object) null);
        this.f22828c.setTag((Object) null);
        setRootTag(view);
        this.f22861h = new a(this);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f22862i = 4;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f22862i != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (com.travel.a.f21417b != i2) {
            return false;
        }
        a((com.travel.booking.e.a) obj);
        return true;
    }

    public final void a(com.travel.booking.e.a aVar) {
        this.f22829d = aVar;
        synchronized (this) {
            this.f22862i |= 2;
        }
        notifyPropertyChanged(com.travel.a.f21417b);
        super.requestRebind();
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return a(i3);
    }

    private boolean a(int i2) {
        if (i2 != com.travel.a.f21416a) {
            return false;
        }
        synchronized (this) {
            this.f22862i |= 1;
        }
        return true;
    }

    public final void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f22862i;
            this.f22862i = 0;
        }
        com.travel.booking.e.a aVar = this.f22829d;
        int i2 = 0;
        int i3 = ((j & 7) > 0 ? 1 : ((j & 7) == 0 ? 0 : -1));
        if (i3 != 0) {
            Boolean bool = null;
            LiveData<Boolean> a2 = aVar != null ? aVar.a() : null;
            updateLiveDataRegistration(0, a2);
            if (a2 != null) {
                bool = a2.getValue();
            }
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            if (i3 != 0) {
                j |= safeUnbox ? 16 : 8;
            }
            if (!safeUnbox) {
                i2 = 8;
            }
        }
        if ((4 & j) != 0) {
            this.f22826a.setOnClickListener(this.f22861h);
        }
        if ((j & 7) != 0) {
            this.f22828c.setVisibility(i2);
        }
    }

    public final void a() {
        com.travel.booking.e.a aVar = this.f22829d;
        if (aVar != null) {
            aVar.f21489b.postValue(null);
        }
    }
}
