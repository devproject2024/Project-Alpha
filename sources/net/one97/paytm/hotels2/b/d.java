package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.hotel4.viewmodel.CancelOrderViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;

public final class d extends c implements b.a {
    private static final ViewDataBinding.b k = null;
    private static final SparseIntArray l;
    private final RelativeLayout m;
    private final View.OnClickListener n;
    private long o;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        l = sparseIntArray;
        sparseIntArray.put(R.id.iv_hotelRoomCard, 7);
        l.put(R.id.v_line_one, 8);
        l.put(R.id.tv_total_text, 9);
    }

    public d(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 10, k, l));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private d(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[7], objArr[2], objArr[5], objArr[4], objArr[9], objArr[6], objArr[3], objArr[8]);
        this.o = -1;
        this.f29324a.setTag((Object) null);
        this.m = objArr[0];
        this.m.setTag((Object) null);
        this.f29326c.setTag((Object) null);
        this.f29327d.setTag((Object) null);
        this.f29328e.setTag((Object) null);
        this.f29330g.setTag((Object) null);
        this.f29331h.setTag((Object) null);
        setRootTag(view);
        this.n = new b(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.o = 4;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.o != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.W != i2) {
            return false;
        }
        a((CancelOrderViewModel) obj);
        return true;
    }

    public final void a(CancelOrderViewModel cancelOrderViewModel) {
        this.j = cancelOrderViewModel;
        synchronized (this) {
            this.o |= 2;
        }
        notifyPropertyChanged(a.W);
        super.requestRebind();
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return b(i3);
    }

    private boolean b(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.o |= 1;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0048  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r15 = this;
            monitor-enter(r15)
            long r0 = r15.o     // Catch:{ all -> 0x0085 }
            r2 = 0
            r15.o = r2     // Catch:{ all -> 0x0085 }
            monitor-exit(r15)     // Catch:{ all -> 0x0085 }
            net.one97.paytm.hotel4.viewmodel.CancelOrderViewModel r4 = r15.j
            r5 = 7
            long r7 = r0 & r5
            r9 = 6
            r11 = 0
            r12 = 0
            int r13 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r13 == 0) goto L_0x0050
            long r7 = r0 & r9
            int r13 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r13 == 0) goto L_0x0039
            if (r4 == 0) goto L_0x0027
            boolean r7 = r4.canShowTaxText()
            java.lang.String r8 = r4.getTotalPrice()
            goto L_0x0029
        L_0x0027:
            r8 = r11
            r7 = 0
        L_0x0029:
            if (r13 == 0) goto L_0x0033
            if (r7 == 0) goto L_0x0030
            r13 = 16
            goto L_0x0032
        L_0x0030:
            r13 = 8
        L_0x0032:
            long r0 = r0 | r13
        L_0x0033:
            if (r7 == 0) goto L_0x0036
            goto L_0x003a
        L_0x0036:
            r7 = 8
            goto L_0x003b
        L_0x0039:
            r8 = r11
        L_0x003a:
            r7 = 0
        L_0x003b:
            if (r4 == 0) goto L_0x0042
            androidx.lifecycle.y r4 = r4.getMetaData()
            goto L_0x0043
        L_0x0042:
            r4 = r11
        L_0x0043:
            r15.updateLiveDataRegistration(r12, r4)
            if (r4 == 0) goto L_0x0052
            java.lang.Object r4 = r4.getValue()
            r11 = r4
            net.one97.paytm.hotel4.service.model.ordersummary.MetaData r11 = (net.one97.paytm.hotel4.service.model.ordersummary.MetaData) r11
            goto L_0x0052
        L_0x0050:
            r8 = r11
            r7 = 0
        L_0x0052:
            r12 = 4
            long r12 = r12 & r0
            int r4 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0060
            android.widget.ImageView r4 = r15.f29324a
            android.view.View$OnClickListener r12 = r15.n
            r4.setOnClickListener(r12)
        L_0x0060:
            long r4 = r0 & r5
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 == 0) goto L_0x0070
            androidx.recyclerview.widget.RecyclerView r4 = r15.f29326c
            net.one97.paytm.hotel4.utils.a.a((androidx.recyclerview.widget.RecyclerView) r4, (net.one97.paytm.hotel4.service.model.ordersummary.MetaData) r11)
            androidx.recyclerview.widget.RecyclerView r4 = r15.f29327d
            net.one97.paytm.hotel4.utils.a.b((androidx.recyclerview.widget.RecyclerView) r4, (net.one97.paytm.hotel4.service.model.ordersummary.MetaData) r11)
        L_0x0070:
            long r0 = r0 & r9
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0084
            android.widget.TextView r0 = r15.f29328e
            r0.setVisibility(r7)
            android.widget.TextView r0 = r15.f29330g
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r8)
            android.view.View r0 = r15.f29331h
            r0.setVisibility(r7)
        L_0x0084:
            return
        L_0x0085:
            r0 = move-exception
            monitor-exit(r15)     // Catch:{ all -> 0x0085 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotels2.b.d.executeBindings():void");
    }

    public final void a(int i2) {
        CancelOrderViewModel cancelOrderViewModel = this.j;
        if (cancelOrderViewModel != null) {
            cancelOrderViewModel.closePaymentDetailsClickHandler();
        }
    }
}
