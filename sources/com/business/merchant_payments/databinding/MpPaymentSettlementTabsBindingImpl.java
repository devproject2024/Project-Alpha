package com.business.merchant_payments.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.business.merchant_payments.BR;
import com.business.merchant_payments.newhome.AcceptPaymentViewModel;

public class MpPaymentSettlementTabsBindingImpl extends MpPaymentSettlementTabsBinding {
    public static final ViewDataBinding.b sIncludes = null;
    public static final SparseIntArray sViewsWithIds = null;
    public long mDirtyFlags;

    public MpPaymentSettlementTabsBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 3, sIncludes, sViewsWithIds));
    }

    public MpPaymentSettlementTabsBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 1, objArr[1], objArr[2], objArr[0]);
        this.mDirtyFlags = -1;
        this.paymentsTab.setTag((Object) null);
        this.settlementsTab.setTag((Object) null);
        this.tabs.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i2, Object obj) {
        if (BR.model != i2) {
            return false;
        }
        setModel((AcceptPaymentViewModel) obj);
        return true;
    }

    public void setModel(AcceptPaymentViewModel acceptPaymentViewModel) {
        this.mModel = acceptPaymentViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.model);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return onChangeModelIsPaymentsTabSelected((ObservableBoolean) obj, i3);
    }

    private boolean onChangeModelIsPaymentsTabSelected(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: androidx.databinding.ObservableBoolean} */
    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r9v1, types: [android.graphics.drawable.Drawable] */
    /* JADX WARNING: type inference failed for: r9v3 */
    /* JADX WARNING: type inference failed for: r9v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r11 = this;
            monitor-enter(r11)
            long r0 = r11.mDirtyFlags     // Catch:{ all -> 0x0074 }
            r2 = 0
            r11.mDirtyFlags = r2     // Catch:{ all -> 0x0074 }
            monitor-exit(r11)     // Catch:{ all -> 0x0074 }
            com.business.merchant_payments.newhome.AcceptPaymentViewModel r4 = r11.mModel
            r5 = 7
            long r7 = r0 & r5
            r9 = 0
            int r10 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r10 == 0) goto L_0x0063
            if (r4 == 0) goto L_0x0019
            androidx.databinding.ObservableBoolean r9 = r4.isPaymentsTabSelected()
        L_0x0019:
            r4 = 0
            r11.updateRegistration((int) r4, (androidx.databinding.h) r9)
            if (r9 == 0) goto L_0x0023
            boolean r4 = r9.get()
        L_0x0023:
            if (r10 == 0) goto L_0x0033
            if (r4 == 0) goto L_0x002d
            r7 = 16
            long r0 = r0 | r7
            r7 = 64
            goto L_0x0032
        L_0x002d:
            r7 = 8
            long r0 = r0 | r7
            r7 = 32
        L_0x0032:
            long r0 = r0 | r7
        L_0x0033:
            if (r4 == 0) goto L_0x003e
            android.widget.TextView r7 = r11.settlementsTab
            android.content.Context r7 = r7.getContext()
            int r8 = com.business.merchant_payments.R.drawable.mp_rectangle_transparent_5
            goto L_0x0046
        L_0x003e:
            android.widget.TextView r7 = r11.settlementsTab
            android.content.Context r7 = r7.getContext()
            int r8 = com.business.merchant_payments.R.drawable.mp_rectangle_ffffff_5
        L_0x0046:
            android.graphics.drawable.Drawable r7 = androidx.appcompat.a.a.a.b(r7, r8)
            r9 = r7
            if (r4 == 0) goto L_0x0056
            android.widget.TextView r4 = r11.paymentsTab
            android.content.Context r4 = r4.getContext()
            int r7 = com.business.merchant_payments.R.drawable.mp_rectangle_ffffff_5
            goto L_0x005e
        L_0x0056:
            android.widget.TextView r4 = r11.paymentsTab
            android.content.Context r4 = r4.getContext()
            int r7 = com.business.merchant_payments.R.drawable.mp_rectangle_transparent_5
        L_0x005e:
            android.graphics.drawable.Drawable r4 = androidx.appcompat.a.a.a.b(r4, r7)
            goto L_0x0064
        L_0x0063:
            r4 = r9
        L_0x0064:
            long r0 = r0 & r5
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x0073
            android.widget.TextView r0 = r11.paymentsTab
            androidx.databinding.a.e.a((android.view.View) r0, (android.graphics.drawable.Drawable) r4)
            android.widget.TextView r0 = r11.settlementsTab
            androidx.databinding.a.e.a((android.view.View) r0, (android.graphics.drawable.Drawable) r9)
        L_0x0073:
            return
        L_0x0074:
            r0 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x0074 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.databinding.MpPaymentSettlementTabsBindingImpl.executeBindings():void");
    }
}
