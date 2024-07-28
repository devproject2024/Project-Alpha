package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.travel.flight.R;
import com.travel.flight.e.a.a;
import com.travel.flight.flightticket.e.f;
import com.travel.flight.pojo.modifyBooking.CJRFlightMBChargesBody;
import com.travel.flight.pojo.modifyBooking.CJRFlightMBChargesRoot;
import com.travel.flight.pojo.modifyBooking.CJRFlightMBRoute;
import java.util.List;

public final class b extends a implements a.C0456a {
    private static final ViewDataBinding.b k = null;
    private static final SparseIntArray l;
    private final ConstraintLayout m;
    private final NestedScrollView n;
    private final View.OnClickListener o;
    private final View.OnClickListener p;
    private long q;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        l = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 7);
        l.put(R.id.header_text, 8);
    }

    public b(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 9, k, l));
    }

    private b(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[8], objArr[4], objArr[6], objArr[3], objArr[7], objArr[5]);
        this.q = -1;
        this.f23536a.setTag((Object) null);
        this.m = objArr[0];
        this.m.setTag((Object) null);
        this.n = objArr[2];
        this.n.setTag((Object) null);
        this.f23538c.setTag((Object) null);
        this.f23539d.setTag((Object) null);
        this.f23540e.setTag((Object) null);
        this.f23542g.setTag((Object) null);
        setRootTag(view);
        this.o = new a(this, 1);
        this.p = new a(this, 2);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.q = 16;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.q != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (com.travel.flight.a.D == i2) {
            a((CJRFlightMBChargesRoot) obj);
        } else if (com.travel.flight.a.f23483g == i2) {
            a((List<f>) (List) obj);
        } else if (com.travel.flight.a.f23479c != i2) {
            return false;
        } else {
            a((com.travel.flight.flightticket.k.b) obj);
        }
        return true;
    }

    public final void a(CJRFlightMBChargesRoot cJRFlightMBChargesRoot) {
        this.f23544i = cJRFlightMBChargesRoot;
        synchronized (this) {
            this.q |= 2;
        }
        notifyPropertyChanged(com.travel.flight.a.D);
        super.requestRebind();
    }

    public final void a(List<f> list) {
        this.j = list;
        synchronized (this) {
            this.q |= 4;
        }
        notifyPropertyChanged(com.travel.flight.a.f23483g);
        super.requestRebind();
    }

    public final void a(com.travel.flight.flightticket.k.b bVar) {
        this.f23543h = bVar;
        synchronized (this) {
            this.q |= 8;
        }
        notifyPropertyChanged(com.travel.flight.a.f23479c);
        super.requestRebind();
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return a(i3);
    }

    private boolean a(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.q |= 1;
        }
        return true;
    }

    public final void executeBindings() {
        long j;
        String str;
        int i2;
        int i3;
        int i4;
        y<Boolean> yVar;
        int i5;
        String str2;
        CJRFlightMBRoute cJRFlightMBRoute;
        Boolean bool;
        long j2;
        long j3;
        synchronized (this) {
            j = this.q;
            this.q = 0;
        }
        CJRFlightMBChargesRoot cJRFlightMBChargesRoot = this.f23544i;
        List list = this.j;
        com.travel.flight.flightticket.k.b bVar = this.f23543h;
        if ((j & 22) == 0 || (j & 18) == 0) {
            i4 = 0;
            i3 = 0;
            i2 = 0;
            str = null;
        } else {
            CJRFlightMBChargesBody body = cJRFlightMBChargesRoot != null ? cJRFlightMBChargesRoot.getBody() : null;
            if (body != null) {
                cJRFlightMBRoute = body.getOnwardItem();
                str2 = body.getStatic_body();
                bool = body.is_modifiable();
            } else {
                bool = null;
                cJRFlightMBRoute = null;
                str2 = null;
            }
            boolean z = cJRFlightMBRoute != null;
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            if (i5 != 0) {
                j |= z ? 1024 : 512;
            }
            if ((j & 18) != 0) {
                if (safeUnbox) {
                    j3 = j | 64;
                    j2 = 256;
                } else {
                    j3 = j | 32;
                    j2 = 128;
                }
                j = j3 | j2;
            }
            int i6 = 8;
            int i7 = z ? 0 : 8;
            int i8 = safeUnbox ? 0 : 8;
            if (!safeUnbox) {
                i6 = 0;
            }
            i4 = i7;
            i2 = i6;
            str = str2;
            i3 = i8;
        }
        int i9 = ((j & 25) > 0 ? 1 : ((j & 25) == 0 ? 0 : -1));
        if (i9 != 0) {
            if (bVar != null) {
                yVar = bVar.f();
            } else {
                yVar = null;
            }
            updateLiveDataRegistration(0, yVar);
            if (yVar != null) {
                yVar.getValue();
            }
        } else {
            yVar = null;
        }
        if ((16 & j) != 0) {
            this.f23536a.setOnClickListener(this.o);
            this.f23538c.setOnClickListener(this.p);
        }
        if ((j & 18) != 0) {
            this.n.setVisibility(i3);
            this.f23538c.setVisibility(i3);
            this.f23540e.setVisibility(i4);
            this.f23542g.setVisibility(i2);
            com.travel.flight.flightticket.b.a.a(this.f23542g, str);
        }
        if (i9 != 0) {
            com.travel.flight.flightticket.b.a.a(this.f23539d, (LiveData<Boolean>) yVar);
        }
        if ((j & 22) != 0) {
            com.travel.flight.flightticket.b.a.a(this.f23540e, cJRFlightMBChargesRoot, list);
        }
    }

    public final void a(int i2, View view) {
        boolean z = false;
        if (i2 == 1) {
            com.travel.flight.flightticket.k.b bVar = this.f23543h;
            if (bVar != null) {
                z = true;
            }
            if (z) {
                bVar.e().setValue(null);
            }
        } else if (i2 == 2) {
            com.travel.flight.flightticket.k.b bVar2 = this.f23543h;
            if (bVar2 != null) {
                z = true;
            }
            if (z) {
                bVar2.g().setValue(null);
            }
        }
    }
}
