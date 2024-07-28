package net.one97.paytm.addmoney.a;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import kotlin.x;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.b.a.a;
import net.one97.paytm.autoaddmoney.c.b;

public final class f extends e implements a.C0846a {
    private static final SparseIntArray A;
    private static final ViewDataBinding.b z = null;
    private final CoordinatorLayout B;
    private final TextView C;
    private final View.OnClickListener D;
    private final View.OnClickListener E;
    private final View.OnClickListener F;
    private final View.OnClickListener G;
    private final View.OnClickListener H;
    private long I;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        A = sparseIntArray;
        sparseIntArray.put(R.id.app_bar, 6);
        A.put(R.id.collapsing_toolbar, 7);
        A.put(R.id.toolbar, 8);
        A.put(R.id.scroll_view, 9);
        A.put(R.id.layout_bal, 10);
        A.put(R.id.textView, 11);
        A.put(R.id.imageView3, 12);
        A.put(R.id.tv_wallet_balance, 13);
        A.put(R.id.tv_p2p_amount_add, 14);
        A.put(R.id.tv_am_desc, 15);
        A.put(R.id.desc_inner_divider, 16);
        A.put(R.id.desc_divider, 17);
        A.put(R.id.tv_linked_acc, 18);
        A.put(R.id.iv_bank_icon, 19);
        A.put(R.id.bank_name_tv, 20);
        A.put(R.id.tv_card_number, 21);
        A.put(R.id.pay_inner_divider, 22);
        A.put(R.id.pay_divider, 23);
        A.put(R.id.barrier, 24);
        A.put(R.id.cancel_divider, 25);
    }

    public f(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 26, z, A));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private f(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[6], objArr[20], objArr[24], objArr[2], objArr[25], objArr[7], objArr[4], objArr[17], objArr[16], objArr[12], objArr[1], objArr[19], objArr[10], objArr[23], objArr[22], objArr[9], objArr[11], objArr[8], objArr[15], objArr[3], objArr[21], objArr[18], objArr[14], objArr[13]);
        this.I = -1;
        this.f48037d.setTag((Object) null);
        this.f48040g.setTag((Object) null);
        this.k.setTag((Object) null);
        this.B = objArr[0];
        this.B.setTag((Object) null);
        this.C = objArr[5];
        this.C.setTag((Object) null);
        this.t.setTag((Object) null);
        setRootTag(view);
        this.D = new a(this, 4);
        this.E = new a(this, 3);
        this.F = new a(this, 2);
        this.G = new a(this, 1);
        this.H = new a(this, 5);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.I = 2;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.I != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (net.one97.paytm.addmoney.e.f48573d != i2) {
            return false;
        }
        a((b) obj);
        return true;
    }

    public final void a(b bVar) {
        this.y = bVar;
        synchronized (this) {
            this.I |= 1;
        }
        notifyPropertyChanged(net.one97.paytm.addmoney.e.f48573d);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j;
        synchronized (this) {
            j = this.I;
            this.I = 0;
        }
        if ((j & 2) != 0) {
            this.f48037d.setOnClickListener(this.F);
            this.f48040g.setOnClickListener(this.D);
            this.k.setOnClickListener(this.G);
            this.C.setOnClickListener(this.H);
            this.t.setOnClickListener(this.E);
        }
    }

    public final void a(int i2) {
        boolean z2 = false;
        if (i2 == 1) {
            b bVar = this.y;
            if (bVar != null) {
                z2 = true;
            }
            if (z2) {
                bVar.k.setValue(new net.one97.paytm.autoaddmoney.a(Boolean.FALSE));
            }
        } else if (i2 == 2) {
            b bVar2 = this.y;
            if (bVar2 != null) {
                z2 = true;
            }
            if (z2) {
                bVar2.f49196c.setValue(new net.one97.paytm.autoaddmoney.a(x.f47997a));
            }
        } else if (i2 == 3) {
            b bVar3 = this.y;
            if (bVar3 != null) {
                z2 = true;
            }
            if (z2) {
                bVar3.f49195b.setValue(new net.one97.paytm.autoaddmoney.a(x.f47997a));
            }
        } else if (i2 == 4) {
            b bVar4 = this.y;
            if (bVar4 != null) {
                z2 = true;
            }
            if (z2) {
                bVar4.f49202i.setValue(new net.one97.paytm.autoaddmoney.a(x.f47997a));
            }
        } else if (i2 == 5) {
            b bVar5 = this.y;
            if (bVar5 != null) {
                z2 = true;
            }
            if (z2) {
                bVar5.n.setValue(new net.one97.paytm.autoaddmoney.a(x.f47997a));
            }
        }
    }
}
