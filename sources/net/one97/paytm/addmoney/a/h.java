package net.one97.paytm.addmoney.a;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.b.a.a;

public final class h extends g implements a.C0846a {
    private static final ViewDataBinding.b A = null;
    private static final SparseIntArray B;
    private final RelativeLayout C;
    private final View.OnClickListener D;
    private final View.OnClickListener E;
    private final View.OnClickListener F;
    private long G;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        B = sparseIntArray;
        sparseIntArray.put(R.id.nested_scrollView, 7);
        B.put(R.id.tv_select_pay_options, 8);
        B.put(R.id.use_your_saved_card_heading, 9);
        B.put(R.id.recycler_view_cards, 10);
        B.put(R.id.radio_button, 11);
        B.put(R.id.new_add_card_ly, 12);
        B.put(R.id.add_card_layout, 13);
        B.put(R.id.card_layout, 14);
        B.put(R.id.tv_enter_card_number, 15);
        B.put(R.id.editText, 16);
        B.put(R.id.iv_clear, 17);
        B.put(R.id.iv_card_logo, 18);
        B.put(R.id.ll_expiry, 19);
        B.put(R.id.tv_expiry_validity, 20);
        B.put(R.id.et_expiry_validity, 21);
        B.put(R.id.ll_new_card_cvv, 22);
        B.put(R.id.tv_cvv_help, 23);
        B.put(R.id.et_new_card_cvv, 24);
        B.put(R.id.tv_low_success, 25);
    }

    public h(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 26, A, B));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private h(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[13], objArr[4], objArr[1], objArr[14], objArr[16], objArr[21], objArr[24], objArr[2], objArr[18], objArr[17], objArr[19], objArr[22], objArr[0], objArr[7], objArr[12], objArr[5], objArr[11], objArr[10], objArr[23], objArr[15], objArr[20], objArr[25], objArr[8], objArr[9], objArr[3]);
        this.G = -1;
        this.f48044b.setTag((Object) null);
        this.f48045c.setTag((Object) null);
        this.f48050h.setTag((Object) null);
        this.m.setTag((Object) null);
        this.C = objArr[6];
        this.C.setTag((Object) null);
        this.p.setTag((Object) null);
        this.y.setTag((Object) null);
        setRootTag(view);
        this.D = new a(this, 2);
        this.E = new a(this, 1);
        this.F = new a(this, 3);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.G = 2;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.G != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (net.one97.paytm.addmoney.e.f48572c != i2) {
            return false;
        }
        a((net.one97.paytm.autoaddmoney.c.a) obj);
        return true;
    }

    public final void a(net.one97.paytm.autoaddmoney.c.a aVar) {
        this.z = aVar;
        synchronized (this) {
            this.G |= 1;
        }
        notifyPropertyChanged(net.one97.paytm.addmoney.e.f48572c);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j;
        synchronized (this) {
            j = this.G;
            this.G = 0;
        }
        net.one97.paytm.autoaddmoney.c.a aVar = this.z;
        String str = null;
        int i2 = ((3 & j) > 0 ? 1 : ((3 & j) == 0 ? 0 : -1));
        if (!(i2 == 0 || aVar == null)) {
            str = net.one97.paytm.autoaddmoney.c.a.a();
        }
        if ((j & 2) != 0) {
            this.f48044b.setOnClickListener(this.F);
            this.f48050h.setOnClickListener(this.E);
            this.y.setOnClickListener(this.D);
        }
        if (i2 != 0) {
            d.a(this.p, (CharSequence) str);
        }
    }

    public final void a(int i2) {
        boolean z = false;
        if (i2 == 1) {
            net.one97.paytm.autoaddmoney.c.a aVar = this.z;
            if (aVar != null) {
                z = true;
            }
            if (z) {
                aVar.f49178f.setValue(new net.one97.paytm.autoaddmoney.a(Boolean.TRUE));
            }
        } else if (i2 == 2) {
            net.one97.paytm.autoaddmoney.c.a aVar2 = this.z;
            if (aVar2 != null) {
                z = true;
            }
            if (z) {
                aVar2.f49177e.setValue(new net.one97.paytm.autoaddmoney.a(Boolean.TRUE));
            }
        } else if (i2 == 3) {
            net.one97.paytm.autoaddmoney.c.a aVar3 = this.z;
            if (aVar3 != null) {
                z = true;
            }
            if (z) {
                aVar3.f49176d.setValue(new net.one97.paytm.autoaddmoney.a(Boolean.TRUE));
            }
        }
    }
}
