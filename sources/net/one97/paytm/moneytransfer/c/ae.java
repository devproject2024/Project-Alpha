package net.one97.paytm.moneytransfer.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.a;
import net.one97.paytm.upi.common.upi.UpiPendingRequestModel;

public final class ae extends ad {
    private static final ViewDataBinding.b r = null;
    private static final SparseIntArray s;
    private final LinearLayout t;
    private long u;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        s = sparseIntArray;
        sparseIntArray.put(R.id.header, 7);
        s.put(R.id.root, 8);
        s.put(R.id.receiver_rounded_bg, 9);
        s.put(R.id.initials, 10);
        s.put(R.id.guideline_view_all, 11);
        s.put(R.id.view_all_request, 12);
        s.put(R.id.arrow, 13);
        s.put(R.id.paddedView, 14);
    }

    public ae(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 15, r, s));
    }

    private ae(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[5], objArr[13], objArr[11], objArr[7], objArr[10], objArr[4], objArr[14], objArr[1], objArr[2], objArr[9], objArr[3], objArr[8], objArr[6], objArr[12]);
        this.u = -1;
        this.f53618a.setTag((Object) null);
        this.t = objArr[0];
        this.t.setTag((Object) null);
        this.f53623f.setTag((Object) null);
        this.f53625h.setTag((Object) null);
        this.f53626i.setTag((Object) null);
        this.k.setTag((Object) null);
        this.m.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.u = 8;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.u != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.f53529a == i2) {
            this.p = (Integer) obj;
            synchronized (this) {
                this.u |= 1;
            }
            notifyPropertyChanged(a.f53529a);
            super.requestRebind();
        } else if (a.f53530b == i2) {
            this.q = (Boolean) obj;
            synchronized (this) {
                this.u |= 2;
            }
            notifyPropertyChanged(a.f53530b);
            super.requestRebind();
        } else if (a.f53531c != i2) {
            return false;
        } else {
            this.o = (UpiPendingRequestModel) obj;
            synchronized (this) {
                this.u |= 4;
            }
            notifyPropertyChanged(a.f53531c);
            super.requestRebind();
        }
        return true;
    }

    public final void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        synchronized (this) {
            j = this.u;
            this.u = 0;
        }
        Integer num = this.p;
        Boolean bool = this.q;
        UpiPendingRequestModel upiPendingRequestModel = this.o;
        int i2 = 0;
        String str5 = null;
        if ((j & 13) != 0) {
            ViewDataBinding.safeUnbox(num);
            if (upiPendingRequestModel != null) {
                str4 = upiPendingRequestModel.getLogoUrl();
                str2 = upiPendingRequestModel.getPayeeName();
            } else {
                str4 = null;
                str2 = null;
            }
            if ((j & 12) != 0) {
                if (upiPendingRequestModel != null) {
                    String note = upiPendingRequestModel.getNote();
                    String payeeVa = upiPendingRequestModel.getPayeeVa();
                    str = upiPendingRequestModel.getAmount();
                    str3 = note;
                    str5 = payeeVa;
                } else {
                    str3 = null;
                    str = null;
                }
                str5 = String.format(this.k.getResources().getString(R.string.money_transfer_upi_id_placeholder), new Object[]{str5});
            } else {
                str3 = null;
                str = null;
            }
        } else {
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
        }
        int i3 = ((j & 10) > 0 ? 1 : ((j & 10) == 0 ? 0 : -1));
        if (i3 != 0) {
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            if (i3 != 0) {
                j |= safeUnbox ? 32 : 16;
            }
            if (!safeUnbox) {
                i2 = 8;
            }
        }
        if ((12 & j) != 0) {
            net.one97.paytm.moneytransferv4.g.a.c(this.f53618a, str);
            net.one97.paytm.moneytransferv4.g.a.b(this.f53623f, str3);
            net.one97.paytm.moneytransferv4.g.a.a(this.f53626i, str2);
            d.a(this.k, (CharSequence) str5);
        }
        if ((13 & j) != 0) {
            net.one97.paytm.moneytransferv4.g.a.a(this.f53625h, this.f53622e, str4, str2);
        }
        if ((j & 10) != 0) {
            this.m.setVisibility(i2);
        }
    }
}
