package com.business.merchant_payments.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.business.merchant_payments.BR;
import com.business.merchant_payments.payment.model.PaymentsShowMoreModel;

public class MpPaymentsShowMoreLayoutBindingImpl extends MpPaymentsShowMoreLayoutBinding {
    public static final ViewDataBinding.b sIncludes = null;
    public static final SparseIntArray sViewsWithIds = null;
    public long mDirtyFlags;
    public final ConstraintLayout mboundView0;

    public MpPaymentsShowMoreLayoutBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 4, sIncludes, sViewsWithIds));
    }

    public MpPaymentsShowMoreLayoutBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 2, objArr[3], objArr[2], objArr[1]);
        this.mDirtyFlags = -1;
        this.animationView.setTag((Object) null);
        ConstraintLayout constraintLayout = objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag((Object) null);
        this.showLessBtn.setTag((Object) null);
        this.showMoreBtn.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8;
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
        setModel((PaymentsShowMoreModel) obj);
        return true;
    }

    public void setModel(PaymentsShowMoreModel paymentsShowMoreModel) {
        this.mModel = paymentsShowMoreModel;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(BR.model);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return onChangeModelShowMoreButtonProgressState((ObservableBoolean) obj, i3);
        }
        if (i2 != 1) {
            return false;
        }
        return onChangeModelShowMoreButtonState((ObservableBoolean) obj, i3);
    }

    private boolean onChangeModelShowMoreButtonProgressState(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeModelShowMoreButtonState(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r15 = this;
            monitor-enter(r15)
            long r0 = r15.mDirtyFlags     // Catch:{ all -> 0x0071 }
            r2 = 0
            r15.mDirtyFlags = r2     // Catch:{ all -> 0x0071 }
            monitor-exit(r15)     // Catch:{ all -> 0x0071 }
            com.business.merchant_payments.payment.model.PaymentsShowMoreModel r4 = r15.mModel
            r5 = 15
            long r7 = r0 & r5
            r9 = 13
            r11 = 0
            int r12 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r12 == 0) goto L_0x0054
            r7 = 0
            if (r4 == 0) goto L_0x0021
            androidx.databinding.ObservableBoolean r7 = r4.getShowMoreButtonProgressState()
            androidx.databinding.ObservableBoolean r8 = r4.getShowMoreButtonState()
            goto L_0x0022
        L_0x0021:
            r8 = r7
        L_0x0022:
            r15.updateRegistration((int) r11, (androidx.databinding.h) r7)
            r12 = 1
            r15.updateRegistration((int) r12, (androidx.databinding.h) r8)
            long r12 = r0 & r9
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 == 0) goto L_0x0046
            if (r7 == 0) goto L_0x0036
            boolean r12 = r7.get()
            goto L_0x0037
        L_0x0036:
            r12 = 0
        L_0x0037:
            if (r14 == 0) goto L_0x0041
            if (r12 == 0) goto L_0x003e
            r13 = 32
            goto L_0x0040
        L_0x003e:
            r13 = 16
        L_0x0040:
            long r0 = r0 | r13
        L_0x0041:
            if (r12 != 0) goto L_0x0046
            r12 = 8
            goto L_0x0047
        L_0x0046:
            r12 = 0
        L_0x0047:
            if (r4 == 0) goto L_0x0052
            int r11 = r4.shouldShowLess(r8, r7)
            int r4 = r4.shouldShowMore(r8, r7)
            goto L_0x0056
        L_0x0052:
            r4 = 0
            goto L_0x0056
        L_0x0054:
            r4 = 0
            r12 = 0
        L_0x0056:
            long r7 = r0 & r9
            int r9 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r9 == 0) goto L_0x0061
            com.airbnb.lottie.LottieAnimationView r7 = r15.animationView
            r7.setVisibility(r12)
        L_0x0061:
            long r0 = r0 & r5
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x0070
            android.widget.TextView r0 = r15.showLessBtn
            r0.setVisibility(r11)
            android.widget.TextView r0 = r15.showMoreBtn
            r0.setVisibility(r4)
        L_0x0070:
            return
        L_0x0071:
            r0 = move-exception
            monitor-exit(r15)     // Catch:{ all -> 0x0071 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.databinding.MpPaymentsShowMoreLayoutBindingImpl.executeBindings():void");
    }
}
