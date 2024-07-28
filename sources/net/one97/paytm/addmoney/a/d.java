package net.one97.paytm.addmoney.a;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.databinding.g;
import kotlin.g.b.k;
import kotlin.x;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.b.a.a;
import net.one97.paytm.autoaddmoney.c.c;

public final class d extends c implements a.C0846a {
    private static final ViewDataBinding.b C = null;
    private static final SparseIntArray D;
    private final RelativeLayout E;
    private final View.OnClickListener F;
    private final View.OnClickListener G;
    private a H;
    private b I;
    private long J;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        D = sparseIntArray;
        sparseIntArray.put(R.id.app_bar, 5);
        D.put(R.id.collapsing_toolbar, 6);
        D.put(R.id.expandedImage, 7);
        D.put(R.id.toolbar, 8);
        D.put(R.id.scroll_view, 9);
        D.put(R.id.auto_addmoney, 10);
        D.put(R.id.automatic_add_descr, 11);
        D.put(R.id.amount_tv, 12);
        D.put(R.id.min_rs_tv, 13);
        D.put(R.id.view2, 14);
        D.put(R.id.error_txt1, 15);
        D.put(R.id.barrier, 16);
        D.put(R.id.amount_tv_add, 17);
        D.put(R.id.auto_rs_tv, 18);
        D.put(R.id.view3, 19);
        D.put(R.id.error_txt2, 20);
        D.put(R.id.barrier1, 21);
        D.put(R.id.rv_topup_sug, 22);
        D.put(R.id.bottom_view, 23);
        D.put(R.id.text_terms_heading, 24);
        D.put(R.id.proceed_layout, 25);
        D.put(R.id.loader_container, 26);
        D.put(R.id.view_loader, 27);
    }

    public d(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 28, C, D));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private d(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[12], objArr[17], objArr[5], objArr[10], objArr[18], objArr[11], objArr[16], objArr[21], objArr[23], objArr[6], objArr[2], objArr[3], objArr[15], objArr[20], objArr[7], objArr[1], objArr[26], objArr[13], objArr[25], objArr[22], objArr[9], objArr[24], objArr[8], objArr[4], objArr[14], objArr[19], objArr[27]);
        this.J = -1;
        this.k.setTag((Object) null);
        this.l.setTag((Object) null);
        this.p.setTag((Object) null);
        this.E = objArr[0];
        this.E.setTag((Object) null);
        this.x.setTag((Object) null);
        setRootTag(view);
        this.F = new net.one97.paytm.addmoney.b.a.a(this, 2);
        this.G = new net.one97.paytm.addmoney.b.a.a(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.J = 2;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.J != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (net.one97.paytm.addmoney.e.f48573d != i2) {
            return false;
        }
        a((c) obj);
        return true;
    }

    public final void a(c cVar) {
        this.B = cVar;
        synchronized (this) {
            this.J |= 1;
        }
        notifyPropertyChanged(net.one97.paytm.addmoney.e.f48573d);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j;
        b bVar;
        a aVar;
        synchronized (this) {
            j = this.J;
            this.J = 0;
        }
        c cVar = this.B;
        int i2 = ((3 & j) > 0 ? 1 : ((3 & j) == 0 ? 0 : -1));
        if (i2 == 0 || cVar == null) {
            aVar = null;
            bVar = null;
        } else {
            aVar = this.H;
            if (aVar == null) {
                aVar = new a();
                this.H = aVar;
            }
            aVar.f48032a = cVar;
            if (cVar == null) {
                aVar = null;
            }
            bVar = this.I;
            if (bVar == null) {
                bVar = new b();
                this.I = bVar;
            }
            bVar.f48033a = cVar;
            if (cVar == null) {
                bVar = null;
            }
        }
        if (i2 != 0) {
            androidx.databinding.a.d.a(this.k, bVar, (d.a) null, (g) null);
            androidx.databinding.a.d.a(this.l, aVar, (d.a) null, (g) null);
        }
        if ((j & 2) != 0) {
            this.p.setOnClickListener(this.G);
            this.x.setOnClickListener(this.F);
        }
    }

    public static class a implements d.c {

        /* renamed from: a  reason: collision with root package name */
        c f48032a;

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            c cVar = this.f48032a;
            k.c(charSequence, "s");
            cVar.f49210d.setValue(Boolean.TRUE);
        }
    }

    public static class b implements d.c {

        /* renamed from: a  reason: collision with root package name */
        c f48033a;

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            c cVar = this.f48033a;
            k.c(charSequence, "s");
            cVar.f49211e.setValue(Boolean.TRUE);
        }
    }

    public final void a(int i2) {
        boolean z = false;
        if (i2 == 1) {
            c cVar = this.B;
            if (cVar != null) {
                z = true;
            }
            if (z) {
                cVar.l.setValue(new net.one97.paytm.autoaddmoney.a(Boolean.FALSE));
            }
        } else if (i2 == 2) {
            c cVar2 = this.B;
            if (cVar2 != null) {
                z = true;
            }
            if (z) {
                cVar2.f49213g.setValue(new net.one97.paytm.autoaddmoney.a(x.f47997a));
            }
        }
    }
}
