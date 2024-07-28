package com.business.merchant_payments.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.q;
import androidx.lifecycle.y;
import com.business.merchant_payments.BR;
import com.business.merchant_payments.R;
import com.business.merchant_payments.generated.callback.OnClickListener;
import com.business.merchant_payments.homepagedialogs.PaymentNotificationData;
import com.business.merchant_payments.homepagedialogs.PaymentNotificationFragment;
import com.business.merchant_payments.payment.model.PaymentsTransactionModel;

public class MpPaymentNotificationBottomsheetBindingImpl extends MpPaymentNotificationBottomsheetBinding implements OnClickListener.Listener {
    public static final ViewDataBinding.b sIncludes;
    public static final SparseIntArray sViewsWithIds;
    public final View.OnClickListener mCallback3;
    public final View.OnClickListener mCallback4;
    public long mDirtyFlags;
    public final ConstraintLayout mboundView0;
    public final ConstraintLayout mboundView1;

    static {
        ViewDataBinding.b bVar = new ViewDataBinding.b(9);
        sIncludes = bVar;
        bVar.a(1, new String[]{"mp_payments_transaction_item"}, new int[]{4}, new int[]{R.layout.mp_payments_transaction_item});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.card_view, 5);
        sViewsWithIds.put(R.id.padding_top, 6);
        sViewsWithIds.put(R.id.title, 7);
        sViewsWithIds.put(R.id.padding_bottom, 8);
    }

    public MpPaymentNotificationBottomsheetBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 9, sIncludes, sViewsWithIds));
    }

    public MpPaymentNotificationBottomsheetBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 2, objArr[5], objArr[2], objArr[3], objArr[8], objArr[6], objArr[7], objArr[4]);
        this.mDirtyFlags = -1;
        this.clickable.setTag((Object) null);
        this.close.setTag((Object) null);
        ConstraintLayout constraintLayout = objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag((Object) null);
        ConstraintLayout constraintLayout2 = objArr[1];
        this.mboundView1 = constraintLayout2;
        constraintLayout2.setTag((Object) null);
        setRootTag(view);
        this.mCallback3 = new OnClickListener(this, 1);
        this.mCallback4 = new OnClickListener(this, 2);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8;
        }
        this.transactionLayout.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.transactionLayout.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasPendingBindings() {
        /*
            r6 = this;
            monitor-enter(r6)
            long r0 = r6.mDirtyFlags     // Catch:{ all -> 0x0018 }
            r2 = 0
            r4 = 1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x000c
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            return r4
        L_0x000c:
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            com.business.merchant_payments.databinding.MpPaymentsTransactionItemBinding r0 = r6.transactionLayout
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
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.databinding.MpPaymentNotificationBottomsheetBindingImpl.hasPendingBindings():boolean");
    }

    public boolean setVariable(int i2, Object obj) {
        if (BR.listener != i2) {
            return false;
        }
        setListener((PaymentNotificationFragment.PaymentNotificationFragmentListener) obj);
        return true;
    }

    public void setListener(PaymentNotificationFragment.PaymentNotificationFragmentListener paymentNotificationFragmentListener) {
        this.mListener = paymentNotificationFragmentListener;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(BR.listener);
        super.requestRebind();
    }

    public void setLifecycleOwner(q qVar) {
        super.setLifecycleOwner(qVar);
        this.transactionLayout.setLifecycleOwner(qVar);
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return onChangeListenerData((y) obj, i3);
        }
        if (i2 != 1) {
            return false;
        }
        return onChangeTransactionLayout((MpPaymentsTransactionItemBinding) obj, i3);
    }

    private boolean onChangeListenerData(y<PaymentNotificationData> yVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeTransactionLayout(MpPaymentsTransactionItemBinding mpPaymentsTransactionItemBinding, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        PaymentNotificationFragment.PaymentNotificationFragmentListener paymentNotificationFragmentListener = this.mListener;
        PaymentsTransactionModel paymentsTransactionModel = null;
        int i2 = ((13 & j) > 0 ? 1 : ((13 & j) == 0 ? 0 : -1));
        if (i2 != 0) {
            y<PaymentNotificationData> data = paymentNotificationFragmentListener != null ? paymentNotificationFragmentListener.getData() : null;
            updateLiveDataRegistration(0, data);
            PaymentNotificationData value = data != null ? data.getValue() : null;
            if (value != null) {
                paymentsTransactionModel = value.getPaymentsTransactionModel();
            }
        }
        if ((j & 8) != 0) {
            this.clickable.setOnClickListener(this.mCallback3);
            this.close.setOnClickListener(this.mCallback4);
        }
        if (i2 != 0) {
            this.transactionLayout.setModel(paymentsTransactionModel);
        }
        ViewDataBinding.executeBindingsOn(this.transactionLayout);
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        boolean z = false;
        if (i2 == 1) {
            PaymentNotificationFragment.PaymentNotificationFragmentListener paymentNotificationFragmentListener = this.mListener;
            if (paymentNotificationFragmentListener != null) {
                z = true;
            }
            if (z) {
                paymentNotificationFragmentListener.onPaymentNotificationClick();
            }
        } else if (i2 == 2) {
            PaymentNotificationFragment.PaymentNotificationFragmentListener paymentNotificationFragmentListener2 = this.mListener;
            if (paymentNotificationFragmentListener2 != null) {
                z = true;
            }
            if (z) {
                paymentNotificationFragmentListener2.onClose();
            }
        }
    }
}
