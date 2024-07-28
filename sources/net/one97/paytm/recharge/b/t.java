package net.one97.paytm.recharge.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.lifecycle.q;
import com.paytm.utility.b;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.a;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel;

public final class t extends s {

    /* renamed from: c  reason: collision with root package name */
    private static final ViewDataBinding.b f60375c;

    /* renamed from: d  reason: collision with root package name */
    private static final SparseIntArray f60376d = null;

    /* renamed from: e  reason: collision with root package name */
    private final CardView f60377e;

    /* renamed from: f  reason: collision with root package name */
    private final ConstraintLayout f60378f;

    /* renamed from: g  reason: collision with root package name */
    private final u f60379g;

    /* renamed from: h  reason: collision with root package name */
    private final TextView f60380h;

    /* renamed from: i  reason: collision with root package name */
    private long f60381i;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        ViewDataBinding.b bVar = new ViewDataBinding.b(5);
        f60375c = bVar;
        bVar.a(1, new String[]{"utility_automatic_list_item_header"}, new int[]{4}, new int[]{R.layout.utility_automatic_list_item_header});
    }

    public t(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 5, f60375c, f60376d));
    }

    private t(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[2]);
        this.f60381i = -1;
        this.f60373a.setTag((Object) null);
        this.f60377e = objArr[0];
        this.f60377e.setTag((Object) null);
        this.f60378f = objArr[1];
        this.f60378f.setTag((Object) null);
        this.f60379g = objArr[4];
        setContainedBinding(this.f60379g);
        this.f60380h = objArr[3];
        this.f60380h.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f60381i = 2;
        }
        this.f60379g.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.f60379g.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean hasPendingBindings() {
        /*
            r6 = this;
            monitor-enter(r6)
            long r0 = r6.f60381i     // Catch:{ all -> 0x0018 }
            r2 = 0
            r4 = 1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x000c
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            return r4
        L_0x000c:
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            net.one97.paytm.recharge.b.u r0 = r6.f60379g
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0016
            return r4
        L_0x0016:
            r0 = 0
            return r0
        L_0x0018:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.b.t.hasPendingBindings():boolean");
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.f60180a != i2) {
            return false;
        }
        this.f60374b = (CJRAutomaticSubscriptionItemModel) obj;
        synchronized (this) {
            this.f60381i |= 1;
        }
        notifyPropertyChanged(a.f60180a);
        super.requestRebind();
        return true;
    }

    public final void setLifecycleOwner(q qVar) {
        super.setLifecycleOwner(qVar);
        this.f60379g.setLifecycleOwner(qVar);
    }

    public final void executeBindings() {
        long j;
        String str;
        String str2;
        synchronized (this) {
            j = this.f60381i;
            this.f60381i = 0;
        }
        CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel = this.f60374b;
        String str3 = null;
        int i2 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (cJRAutomaticSubscriptionItemModel != null) {
                str3 = cJRAutomaticSubscriptionItemModel.getPaymentDate();
                str2 = cJRAutomaticSubscriptionItemModel.getDueAmt();
            } else {
                str2 = null;
            }
            String g2 = b.g(str3, this.f60380h.getResources().getString(R.string.automatic_payment_history_due_date_sql_format), this.f60380h.getResources().getString(R.string.automatic_payment_history_due_date_display_format));
            String L = b.L(str2);
            str = this.f60380h.getResources().getString(R.string.pay_date_date, new Object[]{g2});
            str3 = this.f60373a.getResources().getString(R.string.due_amount_amount, new Object[]{L});
        } else {
            str = null;
        }
        if (i2 != 0) {
            d.a((TextView) this.f60373a, (CharSequence) str3);
            this.f60379g.a(cJRAutomaticSubscriptionItemModel);
            d.a(this.f60380h, (CharSequence) str);
        }
        executeBindingsOn(this.f60379g);
    }
}
