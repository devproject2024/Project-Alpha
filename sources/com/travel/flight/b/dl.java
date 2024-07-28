package com.travel.flight.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.flight.b;
import com.travel.flight.e.a.a;
import com.travel.flight.flightorder.j.f;
import com.travel.flight.pojo.CJRHotelOptions;

public final class dl extends dk implements a.C0456a {

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.b f23934f = null;

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f23935g = null;

    /* renamed from: h  reason: collision with root package name */
    private final FrameLayout f23936h;

    /* renamed from: i  reason: collision with root package name */
    private final View.OnClickListener f23937i;
    private long j;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public dl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, f23934f, f23935g));
    }

    private dl(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[3], objArr[1], objArr[2]);
        this.j = -1;
        this.f23929a.setTag((Object) null);
        this.f23936h = objArr[0];
        this.f23936h.setTag((Object) null);
        this.f23930b.setTag((Object) null);
        this.f23931c.setTag((Object) null);
        setRootTag(view);
        this.f23937i = new a(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.j = 4;
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
        if (com.travel.flight.a.y == i2) {
            a((f.a) obj);
        } else if (com.travel.flight.a.m != i2) {
            return false;
        } else {
            a((CJRHotelOptions) obj);
        }
        return true;
    }

    public final void a(f.a aVar) {
        this.f23933e = aVar;
        synchronized (this) {
            this.j |= 1;
        }
        notifyPropertyChanged(com.travel.flight.a.y);
        super.requestRebind();
    }

    public final void a(CJRHotelOptions cJRHotelOptions) {
        this.f23932d = cJRHotelOptions;
        synchronized (this) {
            this.j |= 2;
        }
        notifyPropertyChanged(com.travel.flight.a.m);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j2;
        synchronized (this) {
            j2 = this.j;
            this.j = 0;
        }
        String str = null;
        CJRHotelOptions cJRHotelOptions = this.f23932d;
        int i2 = ((6 & j2) > 0 ? 1 : ((6 & j2) == 0 ? 0 : -1));
        if (!(i2 == 0 || cJRHotelOptions == null)) {
            str = cJRHotelOptions.getWidgetTitle();
        }
        if (i2 != 0) {
            RecyclerView recyclerView = this.f23929a;
            recyclerView.setAdapter(new com.travel.flight.flightorder.a.a(cJRHotelOptions.getData()));
            recyclerView.addItemDecoration(new com.travel.flight.flightorder.b.a());
            d.a((TextView) this.f23930b, (CharSequence) str);
        }
        if ((j2 & 4) != 0) {
            this.f23931c.setOnClickListener(this.f23937i);
        }
    }

    public final void a(int i2, View view) {
        Context context;
        f.a aVar = this.f23933e;
        if ((aVar != null) && f.this.f24482b != null) {
            String allHotelsLink = f.this.f24482b.getAllHotelsLink();
            if (!TextUtils.isEmpty(allHotelsLink) && (context = f.this.f24481a.getRoot().getContext()) != null) {
                b.a();
                b.b().a(allHotelsLink, context, (String) null);
            }
        }
    }
}
