package com.business.merchant_payments.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import androidx.databinding.i;
import com.business.common_module.view.widget.CustomTextView;
import com.business.merchant_payments.BR;
import com.business.merchant_payments.R;
import com.business.merchant_payments.payment.viewmodel.RefundInitiatedViewModel;

public class MpRefundInitiatedNewBindingImpl extends MpRefundInitiatedNewBinding {
    public static final ViewDataBinding.b sIncludes = null;
    public static final SparseIntArray sViewsWithIds;
    public long mDirtyFlags;
    public final RelativeLayout mboundView0;
    public final CustomTextView mboundView3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.iv_close, 15);
        sViewsWithIds.put(R.id.tv_refund_status, 16);
        sViewsWithIds.put(R.id.lyt_refund_amount, 17);
        sViewsWithIds.put(R.id.status_image, 18);
        sViewsWithIds.put(R.id.refund_date_lyt, 19);
        sViewsWithIds.put(R.id.tv_payment_detail_header, 20);
        sViewsWithIds.put(R.id.tv_payment_amount_title, 21);
        sViewsWithIds.put(R.id.tv_order_id_title, 22);
        sViewsWithIds.put(R.id.tv_payment_date_title, 23);
        sViewsWithIds.put(R.id.tv_customer_id_title, 24);
    }

    public MpRefundInitiatedNewBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 25, sIncludes, sViewsWithIds));
    }

    public MpRefundInitiatedNewBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 9, objArr[1], objArr[10], objArr[15], objArr[17], objArr[19], objArr[18], objArr[8], objArr[9], objArr[24], objArr[14], objArr[13], objArr[12], objArr[11], objArr[6], objArr[22], objArr[5], objArr[21], objArr[7], objArr[23], objArr[20], objArr[2], objArr[4], objArr[16]);
        this.mDirtyFlags = -1;
        this.amount.setTag((Object) null);
        this.containerCc.setTag((Object) null);
        RelativeLayout relativeLayout = objArr[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag((Object) null);
        CustomTextView customTextView = objArr[3];
        this.mboundView3 = customTextView;
        customTextView.setTag((Object) null);
        this.tvCustomerDetailsHeader.setTag((Object) null);
        this.tvCustomerIdText.setTag((Object) null);
        this.tvEmailIdText.setTag((Object) null);
        this.tvEmailIdTitle.setTag((Object) null);
        this.tvMobileNoText.setTag((Object) null);
        this.tvMobileNoTitle.setTag((Object) null);
        this.tvOrderIdText.setTag((Object) null);
        this.tvPaymentAmountText.setTag((Object) null);
        this.tvPaymentDateText.setTag((Object) null);
        this.tvRefundDate.setTag((Object) null);
        this.tvRefundId.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 512;
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
        if (BR.refundInitiatedViewModel != i2) {
            return false;
        }
        setRefundInitiatedViewModel((RefundInitiatedViewModel) obj);
        return true;
    }

    public void setRefundInitiatedViewModel(RefundInitiatedViewModel refundInitiatedViewModel) {
        updateRegistration(8, (h) refundInitiatedViewModel);
        this.mRefundInitiatedViewModel = refundInitiatedViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        notifyPropertyChanged(BR.refundInitiatedViewModel);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return onChangeRefundInitiatedViewModelEmail((i) obj, i3);
            case 1:
                return onChangeRefundInitiatedViewModelOrderId((i) obj, i3);
            case 2:
                return onChangeRefundInitiatedViewModelPaymentDate((i) obj, i3);
            case 3:
                return onChangeRefundInitiatedViewModelCustId((i) obj, i3);
            case 4:
                return onChangeRefundInitiatedViewModelTxnAmount((i) obj, i3);
            case 5:
                return onChangeRefundInitiatedViewModelIsEmailVisible((ObservableBoolean) obj, i3);
            case 6:
                return onChangeRefundInitiatedViewModelIsMobileVisibile((ObservableBoolean) obj, i3);
            case 7:
                return onChangeRefundInitiatedViewModelIsRefIDVisibile((ObservableBoolean) obj, i3);
            case 8:
                return onChangeRefundInitiatedViewModel((RefundInitiatedViewModel) obj, i3);
            default:
                return false;
        }
    }

    private boolean onChangeRefundInitiatedViewModelEmail(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeRefundInitiatedViewModelOrderId(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeRefundInitiatedViewModelPaymentDate(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeRefundInitiatedViewModelCustId(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeRefundInitiatedViewModelTxnAmount(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeRefundInitiatedViewModelIsEmailVisible(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeRefundInitiatedViewModelIsMobileVisibile(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeRefundInitiatedViewModelIsRefIDVisibile(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    private boolean onChangeRefundInitiatedViewModel(RefundInitiatedViewModel refundInitiatedViewModel, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x022a  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0248  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0264  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0275  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0286  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0291  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x02a1  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x02ac  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x02bd  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x02c9  */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x02d6  */
    /* JADX WARNING: Removed duplicated region for block: B:200:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0122  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r47 = this;
            r1 = r47
            monitor-enter(r47)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x02dc }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x02dc }
            monitor-exit(r47)     // Catch:{ all -> 0x02dc }
            com.business.merchant_payments.payment.viewmodel.RefundInitiatedViewModel r0 = r1.mRefundInitiatedViewModel
            r6 = 1023(0x3ff, double:5.054E-321)
            long r6 = r6 & r2
            r8 = 776(0x308, double:3.834E-321)
            r10 = 5
            r11 = 770(0x302, double:3.804E-321)
            r13 = 768(0x300, double:3.794E-321)
            r17 = 769(0x301, double:3.8E-321)
            r19 = 832(0x340, double:4.11E-321)
            r21 = 800(0x320, double:3.953E-321)
            r23 = 864(0x360, double:4.27E-321)
            r25 = 772(0x304, double:3.814E-321)
            r27 = 8
            r15 = 0
            r16 = 0
            int r30 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r30 == 0) goto L_0x01c0
            long r6 = r2 & r17
            int r30 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r30 == 0) goto L_0x0042
            if (r0 == 0) goto L_0x0034
            androidx.databinding.i<java.lang.String> r6 = r0.email
            goto L_0x0036
        L_0x0034:
            r6 = r16
        L_0x0036:
            r1.updateRegistration((int) r15, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x0042
            java.lang.Object r6 = r6.get()
            java.lang.String r6 = (java.lang.String) r6
            goto L_0x0044
        L_0x0042:
            r6 = r16
        L_0x0044:
            long r30 = r2 & r13
            int r7 = (r30 > r4 ? 1 : (r30 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x005d
            if (r0 == 0) goto L_0x005d
            java.lang.String r7 = r0.getRefundId()
            java.lang.String r30 = r0.getRefundDate()
            android.text.Spannable r31 = r0.getRefundAmount()
            java.lang.String r32 = r0.getMobileNo()
            goto L_0x0065
        L_0x005d:
            r7 = r16
            r30 = r7
            r31 = r30
            r32 = r31
        L_0x0065:
            long r33 = r2 & r11
            r15 = 1
            int r35 = (r33 > r4 ? 1 : (r33 == r4 ? 0 : -1))
            if (r35 == 0) goto L_0x007f
            if (r0 == 0) goto L_0x0071
            androidx.databinding.i<java.lang.String> r11 = r0.orderId
            goto L_0x0073
        L_0x0071:
            r11 = r16
        L_0x0073:
            r1.updateRegistration((int) r15, (androidx.databinding.h) r11)
            if (r11 == 0) goto L_0x007f
            java.lang.Object r11 = r11.get()
            java.lang.String r11 = (java.lang.String) r11
            goto L_0x0081
        L_0x007f:
            r11 = r16
        L_0x0081:
            long r35 = r2 & r25
            int r12 = (r35 > r4 ? 1 : (r35 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x00af
            if (r0 == 0) goto L_0x008c
            androidx.databinding.i<java.lang.String> r13 = r0.paymentDate
            goto L_0x008e
        L_0x008c:
            r13 = r16
        L_0x008e:
            r14 = 2
            r1.updateRegistration((int) r14, (androidx.databinding.h) r13)
            if (r13 == 0) goto L_0x009b
            java.lang.Object r13 = r13.get()
            java.lang.String r13 = (java.lang.String) r13
            goto L_0x009d
        L_0x009b:
            r13 = r16
        L_0x009d:
            boolean r14 = android.text.TextUtils.isEmpty(r13)
            r14 = r14 ^ r15
            if (r12 == 0) goto L_0x00ad
            if (r14 == 0) goto L_0x00a9
            r37 = 8192(0x2000, double:4.0474E-320)
            goto L_0x00ab
        L_0x00a9:
            r37 = 4096(0x1000, double:2.0237E-320)
        L_0x00ab:
            long r2 = r2 | r37
        L_0x00ad:
            r15 = r14
            goto L_0x00b2
        L_0x00af:
            r13 = r16
            r15 = 0
        L_0x00b2:
            long r37 = r2 & r8
            int r12 = (r37 > r4 ? 1 : (r37 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x00cc
            if (r0 == 0) goto L_0x00bd
            androidx.databinding.i<java.lang.String> r12 = r0.custId
            goto L_0x00bf
        L_0x00bd:
            r12 = r16
        L_0x00bf:
            r14 = 3
            r1.updateRegistration((int) r14, (androidx.databinding.h) r12)
            if (r12 == 0) goto L_0x00cc
            java.lang.Object r12 = r12.get()
            java.lang.String r12 = (java.lang.String) r12
            goto L_0x00ce
        L_0x00cc:
            r12 = r16
        L_0x00ce:
            r37 = 784(0x310, double:3.873E-321)
            long r37 = r2 & r37
            int r14 = (r37 > r4 ? 1 : (r37 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x00ea
            if (r0 == 0) goto L_0x00db
            androidx.databinding.i<java.lang.String> r14 = r0.txnAmount
            goto L_0x00dd
        L_0x00db:
            r14 = r16
        L_0x00dd:
            r8 = 4
            r1.updateRegistration((int) r8, (androidx.databinding.h) r14)
            if (r14 == 0) goto L_0x00ea
            java.lang.Object r8 = r14.get()
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x00ec
        L_0x00ea:
            r8 = r16
        L_0x00ec:
            long r39 = r2 & r21
            int r9 = (r39 > r4 ? 1 : (r39 == r4 ? 0 : -1))
            if (r9 == 0) goto L_0x0117
            if (r0 == 0) goto L_0x00f7
            androidx.databinding.ObservableBoolean r14 = r0.isEmailVisible
            goto L_0x00f9
        L_0x00f7:
            r14 = r16
        L_0x00f9:
            r1.updateRegistration((int) r10, (androidx.databinding.h) r14)
            if (r14 == 0) goto L_0x0103
            boolean r39 = r14.get()
            goto L_0x0105
        L_0x0103:
            r39 = 0
        L_0x0105:
            if (r9 == 0) goto L_0x0112
            if (r39 == 0) goto L_0x010d
            r40 = 524288(0x80000, double:2.590327E-318)
            goto L_0x0110
        L_0x010d:
            r40 = 262144(0x40000, double:1.295163E-318)
        L_0x0110:
            long r2 = r2 | r40
        L_0x0112:
            if (r39 != 0) goto L_0x011b
            r9 = 8
            goto L_0x011c
        L_0x0117:
            r14 = r16
            r39 = 0
        L_0x011b:
            r9 = 0
        L_0x011c:
            long r40 = r2 & r23
            int r42 = (r40 > r4 ? 1 : (r40 == r4 ? 0 : -1))
            if (r42 == 0) goto L_0x0160
            if (r0 == 0) goto L_0x0127
            androidx.databinding.ObservableBoolean r10 = r0.isMobileVisibile
            goto L_0x0129
        L_0x0127:
            r10 = r16
        L_0x0129:
            r4 = 6
            r1.updateRegistration((int) r4, (androidx.databinding.h) r10)
            if (r10 == 0) goto L_0x0134
            boolean r4 = r10.get()
            goto L_0x0135
        L_0x0134:
            r4 = 0
        L_0x0135:
            if (r42 == 0) goto L_0x0142
            if (r4 == 0) goto L_0x013e
            r28 = 2048(0x800, double:1.0118E-320)
            long r2 = r2 | r28
            goto L_0x0142
        L_0x013e:
            r41 = 1024(0x400, double:5.06E-321)
            long r2 = r2 | r41
        L_0x0142:
            long r41 = r2 & r19
            r43 = 0
            int r5 = (r41 > r43 ? 1 : (r41 == r43 ? 0 : -1))
            if (r5 == 0) goto L_0x0155
            if (r4 == 0) goto L_0x0150
            r41 = 2097152(0x200000, double:1.0361308E-317)
            goto L_0x0153
        L_0x0150:
            r41 = 1048576(0x100000, double:5.180654E-318)
        L_0x0153:
            long r2 = r2 | r41
        L_0x0155:
            long r41 = r2 & r19
            int r5 = (r41 > r43 ? 1 : (r41 == r43 ? 0 : -1))
            if (r5 == 0) goto L_0x0163
            if (r4 != 0) goto L_0x0163
            r5 = 8
            goto L_0x0164
        L_0x0160:
            r43 = r4
            r4 = 0
        L_0x0163:
            r5 = 0
        L_0x0164:
            r41 = 896(0x380, double:4.427E-321)
            long r41 = r2 & r41
            int r10 = (r41 > r43 ? 1 : (r41 == r43 ? 0 : -1))
            if (r10 == 0) goto L_0x01a9
            r41 = r4
            if (r0 == 0) goto L_0x0175
            androidx.databinding.ObservableBoolean r4 = r0.isRefIDVisibile
            r42 = r5
            goto L_0x0179
        L_0x0175:
            r42 = r5
            r4 = r16
        L_0x0179:
            r5 = 7
            r1.updateRegistration((int) r5, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x0184
            boolean r4 = r4.get()
            goto L_0x0185
        L_0x0184:
            r4 = 0
        L_0x0185:
            if (r10 == 0) goto L_0x0192
            if (r4 == 0) goto L_0x018d
            r45 = 131072(0x20000, double:6.47582E-319)
            goto L_0x0190
        L_0x018d:
            r45 = 65536(0x10000, double:3.2379E-319)
        L_0x0190:
            long r2 = r2 | r45
        L_0x0192:
            r10 = r6
            r29 = r13
            r28 = r14
            r6 = r30
            if (r4 == 0) goto L_0x019c
            goto L_0x01b4
        L_0x019c:
            r4 = r31
            r5 = r32
            r30 = 2048(0x800, double:1.0118E-320)
            r14 = r8
            r13 = r11
            r11 = r42
            r8 = 8
            goto L_0x01d7
        L_0x01a9:
            r41 = r4
            r42 = r5
            r10 = r6
            r29 = r13
            r28 = r14
            r6 = r30
        L_0x01b4:
            r4 = r31
            r5 = r32
            r30 = 2048(0x800, double:1.0118E-320)
            r14 = r8
            r13 = r11
            r11 = r42
            r8 = 0
            goto L_0x01d7
        L_0x01c0:
            r4 = r16
            r5 = r4
            r6 = r5
            r7 = r6
            r10 = r7
            r12 = r10
            r13 = r12
            r14 = r13
            r28 = r14
            r29 = r28
            r8 = 0
            r9 = 0
            r11 = 0
            r15 = 0
            r30 = 2048(0x800, double:1.0118E-320)
            r39 = 0
            r41 = 0
        L_0x01d7:
            long r30 = r2 & r30
            r42 = 0
            int r32 = (r30 > r42 ? 1 : (r30 == r42 ? 0 : -1))
            if (r32 == 0) goto L_0x0206
            if (r0 == 0) goto L_0x01e4
            androidx.databinding.ObservableBoolean r0 = r0.isEmailVisible
            goto L_0x01e6
        L_0x01e4:
            r0 = r28
        L_0x01e6:
            r28 = r14
            r14 = 5
            r1.updateRegistration((int) r14, (androidx.databinding.h) r0)
            if (r0 == 0) goto L_0x01f2
            boolean r39 = r0.get()
        L_0x01f2:
            long r30 = r2 & r21
            r42 = 0
            int r0 = (r30 > r42 ? 1 : (r30 == r42 ? 0 : -1))
            if (r0 == 0) goto L_0x0208
            if (r39 == 0) goto L_0x0200
            r30 = 524288(0x80000, double:2.590327E-318)
            goto L_0x0203
        L_0x0200:
            r30 = 262144(0x40000, double:1.295163E-318)
        L_0x0203:
            long r2 = r2 | r30
            goto L_0x0208
        L_0x0206:
            r28 = r14
        L_0x0208:
            long r30 = r2 & r25
            r42 = 0
            int r0 = (r30 > r42 ? 1 : (r30 == r42 ? 0 : -1))
            if (r0 == 0) goto L_0x0222
            if (r15 != 0) goto L_0x021f
            com.business.common_module.view.widget.CustomTextView r0 = r1.tvPaymentDateText
            android.content.res.Resources r0 = r0.getResources()
            int r14 = com.business.merchant_payments.R.string.mp_dash
            java.lang.String r16 = r0.getString(r14)
            goto L_0x0222
        L_0x021f:
            r0 = r29
            goto L_0x0224
        L_0x0222:
            r0 = r16
        L_0x0224:
            long r14 = r2 & r23
            int r16 = (r14 > r42 ? 1 : (r14 == r42 ? 0 : -1))
            if (r16 == 0) goto L_0x023e
            if (r41 != 0) goto L_0x022e
            r39 = 0
        L_0x022e:
            if (r16 == 0) goto L_0x0239
            if (r39 == 0) goto L_0x0236
            r14 = 32768(0x8000, double:1.61895E-319)
            goto L_0x0238
        L_0x0236:
            r14 = 16384(0x4000, double:8.0948E-320)
        L_0x0238:
            long r2 = r2 | r14
        L_0x0239:
            if (r39 != 0) goto L_0x023e
            r14 = 8
            goto L_0x023f
        L_0x023e:
            r14 = 0
        L_0x023f:
            r15 = 768(0x300, double:3.794E-321)
            long r15 = r15 & r2
            r29 = 0
            int r27 = (r15 > r29 ? 1 : (r15 == r29 ? 0 : -1))
            if (r27 == 0) goto L_0x025c
            com.business.common_module.view.widget.CustomTextView r15 = r1.amount
            androidx.databinding.a.d.a((android.widget.TextView) r15, (java.lang.CharSequence) r4)
            com.business.common_module.view.widget.CustomTextView r4 = r1.tvMobileNoText
            androidx.databinding.a.d.a((android.widget.TextView) r4, (java.lang.CharSequence) r5)
            com.business.common_module.view.widget.CustomTextView r4 = r1.tvRefundDate
            androidx.databinding.a.d.a((android.widget.TextView) r4, (java.lang.CharSequence) r6)
            com.business.common_module.view.widget.CustomTextView r4 = r1.tvRefundId
            androidx.databinding.a.d.a((android.widget.TextView) r4, (java.lang.CharSequence) r7)
        L_0x025c:
            long r4 = r2 & r23
            r6 = 0
            int r15 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r15 == 0) goto L_0x026e
            android.widget.RelativeLayout r4 = r1.containerCc
            r4.setVisibility(r14)
            com.business.common_module.view.widget.CustomTextView r4 = r1.tvCustomerDetailsHeader
            r4.setVisibility(r14)
        L_0x026e:
            r4 = 896(0x380, double:4.427E-321)
            long r4 = r4 & r2
            int r14 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r14 == 0) goto L_0x027f
            com.business.common_module.view.widget.CustomTextView r4 = r1.mboundView3
            r4.setVisibility(r8)
            com.business.common_module.view.widget.CustomTextView r4 = r1.tvRefundId
            r4.setVisibility(r8)
        L_0x027f:
            r4 = 776(0x308, double:3.834E-321)
            long r4 = r4 & r2
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x028b
            com.business.common_module.view.widget.CustomTextView r4 = r1.tvCustomerIdText
            androidx.databinding.a.d.a((android.widget.TextView) r4, (java.lang.CharSequence) r12)
        L_0x028b:
            long r4 = r2 & r21
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x029b
            com.business.common_module.view.widget.CustomTextView r4 = r1.tvEmailIdText
            r4.setVisibility(r9)
            com.business.common_module.view.widget.CustomTextView r4 = r1.tvEmailIdTitle
            r4.setVisibility(r9)
        L_0x029b:
            long r4 = r2 & r17
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x02a6
            com.business.common_module.view.widget.CustomTextView r4 = r1.tvEmailIdText
            androidx.databinding.a.d.a((android.widget.TextView) r4, (java.lang.CharSequence) r10)
        L_0x02a6:
            long r4 = r2 & r19
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x02b6
            com.business.common_module.view.widget.CustomTextView r4 = r1.tvMobileNoText
            r4.setVisibility(r11)
            com.business.common_module.view.widget.CustomTextView r4 = r1.tvMobileNoTitle
            r4.setVisibility(r11)
        L_0x02b6:
            r4 = 770(0x302, double:3.804E-321)
            long r4 = r4 & r2
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x02c2
            com.business.common_module.view.widget.CustomTextView r4 = r1.tvOrderIdText
            androidx.databinding.a.d.a((android.widget.TextView) r4, (java.lang.CharSequence) r13)
        L_0x02c2:
            r4 = 784(0x310, double:3.873E-321)
            long r4 = r4 & r2
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x02d0
            com.business.common_module.view.widget.CustomTextView r4 = r1.tvPaymentAmountText
            r8 = r28
            androidx.databinding.a.d.a((android.widget.TextView) r4, (java.lang.CharSequence) r8)
        L_0x02d0:
            long r2 = r2 & r25
            int r4 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x02db
            com.business.common_module.view.widget.CustomTextView r2 = r1.tvPaymentDateText
            androidx.databinding.a.d.a((android.widget.TextView) r2, (java.lang.CharSequence) r0)
        L_0x02db:
            return
        L_0x02dc:
            r0 = move-exception
            monitor-exit(r47)     // Catch:{ all -> 0x02dc }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.databinding.MpRefundInitiatedNewBindingImpl.executeBindings():void");
    }
}
