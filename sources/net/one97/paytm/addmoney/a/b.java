package net.one97.paytm.addmoney.a;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import androidx.databinding.i;
import kotlin.g.b.k;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.towallet.c.c;
import net.one97.paytm.addmoney.towallet.c.d;

public final class b extends a {
    private static final ViewDataBinding.b C = null;
    private static final SparseIntArray D;
    private final RelativeLayout E;
    private final TextView F;
    private a G;
    private long H;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        D = sparseIntArray;
        sparseIntArray.put(R.id.stub, 13);
        D.put(R.id.lyt_bottom_tab_bar, 14);
        D.put(R.id.scrollView, 15);
        D.put(R.id.scrollViewContainer, 16);
        D.put(R.id.fl_adv, 17);
        D.put(R.id.addMoneyImv, 18);
        D.put(R.id.addMoneyTv, 19);
        D.put(R.id.sendMoneyImv, 20);
        D.put(R.id.sendMoneyTv, 21);
        D.put(R.id.passbookImv, 22);
        D.put(R.id.viewPassbookTv, 23);
        D.put(R.id.cstHelpImv, 24);
        D.put(R.id.cstHelpTv, 25);
        D.put(R.id.deals_fragment_container, 26);
        D.put(R.id.sealOfTrustImv, 27);
    }

    public b(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 28, C, D));
    }

    private b(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[18], objArr[19], objArr[2], objArr[12], objArr[24], objArr[25], objArr[26], objArr[17], objArr[9], objArr[14], objArr[22], objArr[5], objArr[8], objArr[6], objArr[7], objArr[15], objArr[16], objArr[27], objArr[20], objArr[21], objArr[3], objArr[13], objArr[1], objArr[23], objArr[4], objArr[10]);
        this.H = -1;
        this.f48015c.setTag((Object) null);
        this.f48016d.setTag((Object) null);
        this.f48021i.setTag((Object) null);
        this.E = objArr[0];
        this.E.setTag((Object) null);
        this.F = objArr[11];
        this.F.setTag((Object) null);
        this.l.setTag((Object) null);
        this.m.setTag((Object) null);
        this.n.setTag((Object) null);
        this.o.setTag((Object) null);
        this.u.setTag((Object) null);
        this.w.setTag((Object) null);
        this.y.setTag((Object) null);
        this.z.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.H = 8;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.H != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (net.one97.paytm.addmoney.e.f48571b == i2) {
            a((c) obj);
        } else if (net.one97.paytm.addmoney.e.f48575f != i2) {
            return false;
        } else {
            a((d) obj);
        }
        return true;
    }

    public final void a(c cVar) {
        this.B = cVar;
        synchronized (this) {
            this.H |= 2;
        }
        notifyPropertyChanged(net.one97.paytm.addmoney.e.f48571b);
        super.requestRebind();
    }

    public final void a(d dVar) {
        this.A = dVar;
        synchronized (this) {
            this.H |= 4;
        }
        notifyPropertyChanged(net.one97.paytm.addmoney.e.f48575f);
        super.requestRebind();
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return a(i3);
    }

    private boolean a(int i2) {
        if (i2 != net.one97.paytm.addmoney.e.f48570a) {
            return false;
        }
        synchronized (this) {
            this.H |= 1;
        }
        return true;
    }

    public final void executeBindings() {
        long j;
        String str;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        i<String> iVar;
        synchronized (this) {
            j = this.H;
            this.H = 0;
        }
        c cVar = this.B;
        d dVar = this.A;
        a aVar = null;
        if ((j & 11) != 0) {
            if (cVar != null) {
                iVar = cVar.f48842b;
            } else {
                iVar = null;
            }
            updateRegistration(0, (h) iVar);
            str = iVar != null ? iVar.get() : null;
            if (!((j & 10) == 0 || cVar == null)) {
                a aVar2 = this.G;
                if (aVar2 == null) {
                    aVar2 = new a();
                    this.G = aVar2;
                }
                aVar2.f48022a = cVar;
                if (cVar != null) {
                    aVar = aVar2;
                }
            }
        } else {
            str = null;
        }
        int i2 = ((j & 12) > 0 ? 1 : ((j & 12) == 0 ? 0 : -1));
        if (i2 != 0) {
            z5 = dVar == d.SUCCESS_DETAIL;
            z = dVar == d.LOADING;
            z4 = dVar == d.SUCCESS_INITIAL;
            z3 = dVar != d.INITIAL;
            z2 = dVar != d.SUCCESS_INITIAL;
            if (i2 != 0) {
                j = z ? j | 32 : j | 16;
            }
            if ((j & 12) != 0) {
                j |= z4 ? 128 : 64;
            }
        } else {
            z5 = false;
            z4 = false;
            z3 = false;
            z2 = false;
            z = false;
        }
        boolean z6 = (j & 16) != 0 && dVar == d.INITIAL;
        int i3 = ((12 & j) > 0 ? 1 : ((12 & j) == 0 ? 0 : -1));
        boolean z7 = i3 != 0 ? z4 ? true : z5 : false;
        boolean z8 = i3 != 0 ? z ? true : z6 : false;
        if ((10 & j) != 0) {
            this.f48015c.setOnClickListener(aVar);
            this.l.setOnClickListener(aVar);
            this.m.setOnClickListener(aVar);
            this.n.setOnClickListener(aVar);
            this.o.setOnClickListener(aVar);
            this.u.setOnClickListener(aVar);
        }
        if (i3 != 0) {
            net.one97.paytm.addmoney.towallet.c.b.a(this.f48021i, z8);
            net.one97.paytm.addmoney.towallet.c.b.a(this.F, z3);
            net.one97.paytm.addmoney.towallet.c.b.a(this.l, z7);
            net.one97.paytm.addmoney.towallet.c.b.a(this.o, z7);
            net.one97.paytm.addmoney.towallet.c.b.a(this.u, z5);
            net.one97.paytm.addmoney.towallet.c.b.a(this.w, z2);
            net.one97.paytm.addmoney.towallet.c.b.a(this.z, z3);
        }
        if ((j & 11) != 0) {
            androidx.databinding.a.d.a(this.y, (CharSequence) str);
        }
    }

    public static class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        c f48022a;

        public final void onClick(View view) {
            c cVar = this.f48022a;
            k.c(view, "view");
            cVar.f48846f.postValue(Integer.valueOf(view.getId()));
        }
    }
}
