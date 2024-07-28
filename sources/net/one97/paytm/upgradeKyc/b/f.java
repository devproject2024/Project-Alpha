package net.one97.paytm.upgradeKyc.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.aj;
import androidx.lifecycle.y;
import kotlin.d.d;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.aotp.b.c;
import net.one97.paytm.upgradeKyc.e.a.a;
import net.one97.paytm.upgradeKyc.kycV3.b.b;

public final class f extends e implements a.C1305a {
    private static final ViewDataBinding.b k = null;
    private static final SparseIntArray l;
    private final View.OnClickListener m;
    private final View.OnClickListener n;
    private final View.OnClickListener o;
    private long p;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        l = sparseIntArray;
        sparseIntArray.put(R.id.footer, 4);
        l.put(R.id.aotp_premature_icon, 5);
        l.put(R.id.heading_tv, 6);
        l.put(R.id.wallet_validity, 7);
        l.put(R.id.kyc_loader, 8);
    }

    public f(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 9, k, l));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private f(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[5], objArr[3], objArr[1], objArr[4], objArr[6], objArr[8], objArr[0], objArr[2], objArr[7]);
        this.p = -1;
        this.f65588b.setTag((Object) null);
        this.f65589c.setTag((Object) null);
        this.f65593g.setTag((Object) null);
        this.f65594h.setTag((Object) null);
        setRootTag(view);
        this.m = new a(this, 3);
        this.n = new a(this, 1);
        this.o = new a(this, 2);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.p = 2;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.p != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (net.one97.paytm.upgradeKyc.a.f65185a != i2) {
            return false;
        }
        a((c) obj);
        return true;
    }

    public final void a(c cVar) {
        this.j = cVar;
        synchronized (this) {
            this.p |= 1;
        }
        notifyPropertyChanged(net.one97.paytm.upgradeKyc.a.f65185a);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j;
        synchronized (this) {
            j = this.p;
            this.p = 0;
        }
        if ((j & 2) != 0) {
            this.f65588b.setOnClickListener(this.m);
            this.f65589c.setOnClickListener(this.n);
            this.f65594h.setOnClickListener(this.o);
        }
    }

    public final void a(int i2) {
        boolean z = false;
        if (i2 == 1) {
            c cVar = this.j;
            if (cVar != null) {
                z = true;
            }
            if (z) {
                y<b<Object>> yVar = cVar.f65566a;
                b.a aVar = b.f66167d;
                yVar.setValue(b.a.a(net.one97.paytm.upgradeKyc.aotp.a.SHOW_TNC));
            }
        } else if (i2 == 2) {
            c cVar2 = this.j;
            if (cVar2 != null) {
                z = true;
            }
            if (z) {
                Job unused = BuildersKt__Builders_commonKt.launch$default(aj.a(cVar2), (kotlin.d.f) null, (CoroutineStart) null, new c.d(cVar2, (d) null), 3, (Object) null);
            }
        } else if (i2 == 3) {
            c cVar3 = this.j;
            if (cVar3 != null) {
                z = true;
            }
            if (z) {
                y<b<Object>> yVar2 = cVar3.f65566a;
                b.a aVar2 = b.f66167d;
                yVar2.setValue(b.a.a(net.one97.paytm.upgradeKyc.aotp.a.TRY_USING_DIFFERENT_METHOD));
            }
        }
    }
}
