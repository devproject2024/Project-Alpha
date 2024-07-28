package com.business.merchant_payments.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.databinding.g;
import androidx.databinding.h;
import androidx.databinding.i;
import com.business.merchant_payments.BR;
import com.business.merchant_payments.R;
import com.business.merchant_payments.generated.callback.OnClickListener;
import com.business.merchant_payments.payment.viewmodel.InitiateRefundViewModel;

public class MpInitiateRefundNewBindingImpl extends MpInitiateRefundNewBinding implements OnClickListener.Listener {
    public static final ViewDataBinding.b sIncludes = null;
    public static final SparseIntArray sViewsWithIds;
    public g etRefundAmountandroidTextAttrChanged;
    public final View.OnClickListener mCallback11;
    public long mDirtyFlags;
    public OnClickListenerImpl mInitiateRefundViewModelOnRefundCommissionCheckboxClickedAndroidViewViewOnClickListener;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.iv_close, 10);
        sViewsWithIds.put(R.id.tv_initiate_refund_title, 11);
        sViewsWithIds.put(R.id.tv_transaction_amount, 12);
    }

    public MpInitiateRefundNewBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 13, sIncludes, sViewsWithIds));
    }

    public MpInitiateRefundNewBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 5, objArr[3], objArr[9], objArr[0], objArr[5], objArr[4], objArr[10], objArr[7], objArr[6], objArr[8], objArr[1], objArr[11], objArr[2], objArr[12]);
        this.etRefundAmountandroidTextAttrChanged = new g() {
            public void onChange() {
                String a2 = d.a((TextView) MpInitiateRefundNewBindingImpl.this.etRefundAmount);
                InitiateRefundViewModel initiateRefundViewModel = MpInitiateRefundNewBindingImpl.this.mInitiateRefundViewModel;
                boolean z = true;
                if (initiateRefundViewModel != null) {
                    i<String> iVar = initiateRefundViewModel.amountText;
                    if (iVar == null) {
                        z = false;
                    }
                    if (z) {
                        iVar.set(a2);
                    }
                }
            }
        };
        this.mDirtyFlags = -1;
        this.amountLyt.setTag((Object) null);
        this.btnRefund.setTag((Object) null);
        this.coordinatorLayout.setTag((Object) null);
        this.errorText.setTag((Object) null);
        this.etRefundAmount.setTag((Object) null);
        this.maxRefundableSummary.setTag((Object) null);
        this.pleaseNote.setTag((Object) null);
        this.refundTvCommissionCheckbox.setTag((Object) null);
        this.tvAmount.setTag((Object) null);
        this.tvRefundMsg.setTag((Object) null);
        setRootTag(view);
        this.mCallback11 = new OnClickListener(this, 1);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 32;
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
        if (BR.initiateRefundViewModel != i2) {
            return false;
        }
        setInitiateRefundViewModel((InitiateRefundViewModel) obj);
        return true;
    }

    public void setInitiateRefundViewModel(InitiateRefundViewModel initiateRefundViewModel) {
        updateRegistration(3, (h) initiateRefundViewModel);
        this.mInitiateRefundViewModel = initiateRefundViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(BR.initiateRefundViewModel);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return onChangeInitiateRefundViewModelAmountText((i) obj, i3);
        }
        if (i2 == 1) {
            return onChangeInitiateRefundViewModelMTotalAmount((i) obj, i3);
        }
        if (i2 == 2) {
            return onChangeInitiateRefundViewModelErrorText((i) obj, i3);
        }
        if (i2 == 3) {
            return onChangeInitiateRefundViewModel((InitiateRefundViewModel) obj, i3);
        }
        if (i2 != 4) {
            return false;
        }
        return onChangeInitiateRefundViewModelMMaxRefundNote((i) obj, i3);
    }

    private boolean onChangeInitiateRefundViewModelAmountText(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeInitiateRefundViewModelMTotalAmount(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeInitiateRefundViewModelErrorText(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeInitiateRefundViewModel(InitiateRefundViewModel initiateRefundViewModel, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeInitiateRefundViewModelMMaxRefundNote(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0113  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r33 = this;
            r1 = r33
            monitor-enter(r33)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x01bd }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x01bd }
            monitor-exit(r33)     // Catch:{ all -> 0x01bd }
            com.business.merchant_payments.payment.viewmodel.InitiateRefundViewModel r0 = r1.mInitiateRefundViewModel
            r6 = 63
            long r6 = r6 & r2
            r11 = 44
            r13 = 1
            r14 = 40
            r16 = 42
            r18 = 1024(0x400, double:5.06E-321)
            r20 = 41
            r8 = 0
            int r10 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x0117
            long r6 = r2 & r20
            int r10 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x0037
            if (r0 == 0) goto L_0x002a
            androidx.databinding.i<java.lang.String> r6 = r0.amountText
            goto L_0x002b
        L_0x002a:
            r6 = 0
        L_0x002b:
            r1.updateRegistration((int) r8, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x0037
            java.lang.Object r6 = r6.get()
            java.lang.String r6 = (java.lang.String) r6
            goto L_0x0038
        L_0x0037:
            r6 = 0
        L_0x0038:
            long r24 = r2 & r16
            int r7 = (r24 > r4 ? 1 : (r24 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x0050
            if (r0 == 0) goto L_0x0043
            androidx.databinding.i<java.lang.String> r7 = r0.mTotalAmount
            goto L_0x0044
        L_0x0043:
            r7 = 0
        L_0x0044:
            r1.updateRegistration((int) r13, (androidx.databinding.h) r7)
            if (r7 == 0) goto L_0x0050
            java.lang.Object r7 = r7.get()
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x0051
        L_0x0050:
            r7 = 0
        L_0x0051:
            long r24 = r2 & r11
            int r10 = (r24 > r4 ? 1 : (r24 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x00a6
            if (r0 == 0) goto L_0x005c
            androidx.databinding.i<java.lang.String> r9 = r0.errorText
            goto L_0x005d
        L_0x005c:
            r9 = 0
        L_0x005d:
            r11 = 2
            r1.updateRegistration((int) r11, (androidx.databinding.h) r9)
            if (r9 == 0) goto L_0x006a
            java.lang.Object r9 = r9.get()
            java.lang.String r9 = (java.lang.String) r9
            goto L_0x006b
        L_0x006a:
            r9 = 0
        L_0x006b:
            boolean r11 = android.text.TextUtils.isEmpty(r9)
            if (r10 == 0) goto L_0x0082
            if (r11 == 0) goto L_0x007a
            r26 = 128(0x80, double:6.32E-322)
            long r2 = r2 | r26
            r26 = 512(0x200, double:2.53E-321)
            goto L_0x0080
        L_0x007a:
            r26 = 64
            long r2 = r2 | r26
            r26 = 256(0x100, double:1.265E-321)
        L_0x0080:
            long r2 = r2 | r26
        L_0x0082:
            if (r11 == 0) goto L_0x0087
            r10 = 8
            goto L_0x0088
        L_0x0087:
            r10 = 0
        L_0x0088:
            if (r11 == 0) goto L_0x0093
            android.widget.LinearLayout r11 = r1.amountLyt
            android.content.Context r11 = r11.getContext()
            int r12 = com.business.merchant_payments.R.drawable.mp_rectangle_rounded_corner
            goto L_0x009b
        L_0x0093:
            android.widget.LinearLayout r11 = r1.amountLyt
            android.content.Context r11 = r11.getContext()
            int r12 = com.business.merchant_payments.R.drawable.mp_error_round_bg
        L_0x009b:
            android.graphics.drawable.Drawable r11 = androidx.appcompat.a.a.a.b(r11, r12)
            r32 = r10
            r10 = r9
            r9 = r11
            r11 = r32
            goto L_0x00a9
        L_0x00a6:
            r9 = 0
            r10 = 0
            r11 = 0
        L_0x00a9:
            long r26 = r2 & r14
            int r12 = (r26 > r4 ? 1 : (r26 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x00d9
            if (r0 == 0) goto L_0x00c5
            com.business.merchant_payments.databinding.MpInitiateRefundNewBindingImpl$OnClickListenerImpl r14 = r1.mInitiateRefundViewModelOnRefundCommissionCheckboxClickedAndroidViewViewOnClickListener
            if (r14 != 0) goto L_0x00bc
            com.business.merchant_payments.databinding.MpInitiateRefundNewBindingImpl$OnClickListenerImpl r14 = new com.business.merchant_payments.databinding.MpInitiateRefundNewBindingImpl$OnClickListenerImpl
            r14.<init>()
            r1.mInitiateRefundViewModelOnRefundCommissionCheckboxClickedAndroidViewViewOnClickListener = r14
        L_0x00bc:
            com.business.merchant_payments.databinding.MpInitiateRefundNewBindingImpl$OnClickListenerImpl r14 = r14.setValue(r0)
            java.lang.String r15 = r0.getMobileNo()
            goto L_0x00c7
        L_0x00c5:
            r14 = 0
            r15 = 0
        L_0x00c7:
            boolean r28 = android.text.TextUtils.isEmpty(r15)
            if (r12 == 0) goto L_0x00d6
            if (r28 == 0) goto L_0x00d4
            r29 = 2048(0x800, double:1.0118E-320)
            long r2 = r2 | r29
            goto L_0x00d6
        L_0x00d4:
            long r2 = r2 | r18
        L_0x00d6:
            r22 = 56
            goto L_0x00df
        L_0x00d9:
            r14 = 0
            r15 = 0
            r22 = 56
            r28 = 0
        L_0x00df:
            long r29 = r2 & r22
            int r12 = (r29 > r4 ? 1 : (r29 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x0113
            if (r0 == 0) goto L_0x00ea
            androidx.databinding.i<java.lang.String> r0 = r0.mMaxRefundNote
            goto L_0x00eb
        L_0x00ea:
            r0 = 0
        L_0x00eb:
            r8 = 4
            r1.updateRegistration((int) r8, (androidx.databinding.h) r0)
            if (r0 == 0) goto L_0x00f8
            java.lang.Object r0 = r0.get()
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x00f9
        L_0x00f8:
            r0 = 0
        L_0x00f9:
            boolean r8 = android.text.TextUtils.isEmpty(r0)
            if (r12 == 0) goto L_0x0108
            if (r8 == 0) goto L_0x0104
            r30 = 8192(0x2000, double:4.0474E-320)
            goto L_0x0106
        L_0x0104:
            r30 = 4096(0x1000, double:2.0237E-320)
        L_0x0106:
            long r2 = r2 | r30
        L_0x0108:
            if (r8 == 0) goto L_0x010f
            r8 = r7
            r7 = r0
            r0 = 8
            goto L_0x0122
        L_0x010f:
            r8 = r7
            r7 = r0
            r0 = 0
            goto L_0x0122
        L_0x0113:
            r8 = r7
            r0 = 0
            r7 = 0
            goto L_0x0122
        L_0x0117:
            r0 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r14 = 0
            r15 = 0
            r28 = 0
        L_0x0122:
            long r18 = r2 & r18
            int r12 = (r18 > r4 ? 1 : (r18 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x013a
            com.business.common_module.view.widget.CustomTextView r12 = r1.tvRefundMsg
            android.content.res.Resources r12 = r12.getResources()
            int r4 = com.business.merchant_payments.R.string.mp_refund_msg
            java.lang.Object[] r5 = new java.lang.Object[r13]
            r13 = 0
            r5[r13] = r15
            java.lang.String r4 = r12.getString(r4, r5)
            goto L_0x013b
        L_0x013a:
            r4 = 0
        L_0x013b:
            r12 = 40
            long r12 = r12 & r2
            r18 = 0
            int r5 = (r12 > r18 ? 1 : (r12 == r18 ? 0 : -1))
            if (r5 == 0) goto L_0x0153
            if (r28 == 0) goto L_0x0154
            com.business.common_module.view.widget.CustomTextView r4 = r1.tvRefundMsg
            android.content.res.Resources r4 = r4.getResources()
            int r12 = com.business.merchant_payments.R.string.mp_refund_msg_text
            java.lang.String r4 = r4.getString(r12)
            goto L_0x0154
        L_0x0153:
            r4 = 0
        L_0x0154:
            r12 = 44
            long r12 = r12 & r2
            int r15 = (r12 > r18 ? 1 : (r12 == r18 ? 0 : -1))
            if (r15 == 0) goto L_0x016a
            android.widget.LinearLayout r12 = r1.amountLyt
            androidx.databinding.a.e.a((android.view.View) r12, (android.graphics.drawable.Drawable) r9)
            com.business.common_module.view.widget.CustomTextView r9 = r1.errorText
            androidx.databinding.a.d.a((android.widget.TextView) r9, (java.lang.CharSequence) r10)
            com.business.common_module.view.widget.CustomTextView r9 = r1.errorText
            r9.setVisibility(r11)
        L_0x016a:
            r9 = 32
            long r9 = r9 & r2
            r11 = 0
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 == 0) goto L_0x0182
            com.business.common_module.view.widget.CustomTextView r9 = r1.btnRefund
            android.view.View$OnClickListener r10 = r1.mCallback11
            r9.setOnClickListener(r10)
            com.business.common_module.view.widget.CustomTextInputEditText r9 = r1.etRefundAmount
            androidx.databinding.g r10 = r1.etRefundAmountandroidTextAttrChanged
            r13 = 0
            androidx.databinding.a.d.a(r9, r13, r13, r10)
        L_0x0182:
            long r9 = r2 & r20
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 == 0) goto L_0x018d
            com.business.common_module.view.widget.CustomTextInputEditText r9 = r1.etRefundAmount
            androidx.databinding.a.d.a((android.widget.TextView) r9, (java.lang.CharSequence) r6)
        L_0x018d:
            r9 = 56
            long r9 = r9 & r2
            int r6 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r6 == 0) goto L_0x01a3
            com.business.common_module.view.widget.CustomTextView r6 = r1.maxRefundableSummary
            r6.setVisibility(r0)
            com.business.common_module.view.widget.CustomTextView r6 = r1.maxRefundableSummary
            androidx.databinding.a.d.a((android.widget.TextView) r6, (java.lang.CharSequence) r7)
            com.business.common_module.view.widget.CustomTextView r6 = r1.pleaseNote
            r6.setVisibility(r0)
        L_0x01a3:
            if (r5 == 0) goto L_0x01af
            com.business.common_module.view.widget.CustomCheckBox r0 = r1.refundTvCommissionCheckbox
            r0.setOnClickListener(r14)
            com.business.common_module.view.widget.CustomTextView r0 = r1.tvRefundMsg
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
        L_0x01af:
            long r2 = r2 & r16
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x01bc
            com.business.common_module.view.widget.CustomTextView r0 = r1.tvAmount
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r8)
        L_0x01bc:
            return
        L_0x01bd:
            r0 = move-exception
            monitor-exit(r33)     // Catch:{ all -> 0x01bd }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.databinding.MpInitiateRefundNewBindingImpl.executeBindings():void");
    }

    public static class OnClickListenerImpl implements View.OnClickListener {
        public InitiateRefundViewModel value;

        public OnClickListenerImpl setValue(InitiateRefundViewModel initiateRefundViewModel) {
            this.value = initiateRefundViewModel;
            if (initiateRefundViewModel == null) {
                return null;
            }
            return this;
        }

        public void onClick(View view) {
            this.value.onRefundCommissionCheckboxClicked(view);
        }
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        InitiateRefundViewModel initiateRefundViewModel = this.mInitiateRefundViewModel;
        if (initiateRefundViewModel != null) {
            initiateRefundViewModel.onClickRefundRequest();
        }
    }
}
