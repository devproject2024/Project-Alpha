package com.business.merchant_payments.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CompoundButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.q;
import androidx.lifecycle.y;
import com.business.merchant_payments.BR;
import com.business.merchant_payments.R;
import com.business.merchant_payments.generated.callback.OnClickListener;
import com.business.merchant_payments.notificationsettings.BindingUtils;
import com.business.merchant_payments.notificationsettings.adapter.NotificationReceiverListAdapter;
import com.business.merchant_payments.notificationsettings.viewmodel.EmailAndSmsNotificationViewModel;

public class MpActivityEmailSmsNotificationBindingImpl extends MpActivityEmailSmsNotificationBinding implements OnClickListener.Listener {
    public static final ViewDataBinding.b sIncludes;
    public static final SparseIntArray sViewsWithIds;
    public final View.OnClickListener mCallback1;
    public final View.OnClickListener mCallback2;
    public long mDirtyFlags;
    public OnCheckedChangeListenerImpl1 mViewModelOnRefundsCheckChangeAndroidWidgetCompoundButtonOnCheckedChangeListener;
    public OnCheckedChangeListenerImpl mViewModelOnTransactionCheckChangeAndroidWidgetCompoundButtonOnCheckedChangeListener;
    public final ConstraintLayout mboundView0;
    public final ConstraintLayout mboundView1;
    public final Group mboundView5;

    static {
        ViewDataBinding.b bVar = new ViewDataBinding.b(12);
        sIncludes = bVar;
        bVar.a(0, new String[]{"mp_toolbar_notification"}, new int[]{7}, new int[]{R.layout.mp_toolbar_notification});
        int i2 = R.layout.mp_receive_for_item_view;
        sIncludes.a(1, new String[]{"mp_receive_for_item_view", "mp_receive_for_item_view"}, new int[]{8, 9}, new int[]{i2, i2});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.bg_payment_msg, 10);
        sViewsWithIds.put(R.id.bg_receive_for, 11);
    }

    public MpActivityEmailSmsNotificationBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 12, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MpActivityEmailSmsNotificationBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 11, objArr[10], objArr[11], objArr[3], objArr[2], objArr[9], objArr[4], objArr[7], objArr[8], objArr[6]);
        this.mDirtyFlags = -1;
        this.btnAddNew.setTag((Object) null);
        ConstraintLayout constraintLayout = objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag((Object) null);
        ConstraintLayout constraintLayout2 = objArr[1];
        this.mboundView1 = constraintLayout2;
        constraintLayout2.setTag((Object) null);
        Group group = objArr[5];
        this.mboundView5 = group;
        group.setTag((Object) null);
        this.paymentMsg.setTag((Object) null);
        this.rvReceiver.setTag((Object) null);
        this.tvReceiveFor.setTag((Object) null);
        setRootTag(view);
        this.mCallback2 = new OnClickListener(this, 2);
        this.mCallback1 = new OnClickListener(this, 1);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16384;
        }
        this.toolbar.invalidateAll();
        this.transactionView.invalidateAll();
        this.refundView.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r6.transactionView.hasPendingBindings() == false) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
        if (r6.refundView.hasPendingBindings() == false) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0028, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.toolbar.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasPendingBindings() {
        /*
            r6 = this;
            monitor-enter(r6)
            long r0 = r6.mDirtyFlags     // Catch:{ all -> 0x002a }
            r2 = 0
            r4 = 1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x000c
            monitor-exit(r6)     // Catch:{ all -> 0x002a }
            return r4
        L_0x000c:
            monitor-exit(r6)     // Catch:{ all -> 0x002a }
            com.business.merchant_payments.databinding.MpToolbarNotificationBinding r0 = r6.toolbar
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0016
            return r4
        L_0x0016:
            com.business.merchant_payments.databinding.MpReceiveForItemViewBinding r0 = r6.transactionView
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x001f
            return r4
        L_0x001f:
            com.business.merchant_payments.databinding.MpReceiveForItemViewBinding r0 = r6.refundView
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0028
            return r4
        L_0x0028:
            r0 = 0
            return r0
        L_0x002a:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x002a }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.databinding.MpActivityEmailSmsNotificationBindingImpl.hasPendingBindings():boolean");
    }

    public boolean setVariable(int i2, Object obj) {
        if (BR.bindingUtils == i2) {
            setBindingUtils((BindingUtils.Companion) obj);
        } else if (BR.adapter == i2) {
            setAdapter((NotificationReceiverListAdapter) obj);
        } else if (BR.viewModel != i2) {
            return false;
        } else {
            setViewModel((EmailAndSmsNotificationViewModel) obj);
        }
        return true;
    }

    public void setBindingUtils(BindingUtils.Companion companion) {
        this.mBindingUtils = companion;
        synchronized (this) {
            this.mDirtyFlags |= 2048;
        }
        notifyPropertyChanged(BR.bindingUtils);
        super.requestRebind();
    }

    public void setAdapter(NotificationReceiverListAdapter notificationReceiverListAdapter) {
        this.mAdapter = notificationReceiverListAdapter;
        synchronized (this) {
            this.mDirtyFlags |= 4096;
        }
        notifyPropertyChanged(BR.adapter);
        super.requestRebind();
    }

    public void setViewModel(EmailAndSmsNotificationViewModel emailAndSmsNotificationViewModel) {
        this.mViewModel = emailAndSmsNotificationViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 8192;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    public void setLifecycleOwner(q qVar) {
        super.setLifecycleOwner(qVar);
        this.toolbar.setLifecycleOwner(qVar);
        this.transactionView.setLifecycleOwner(qVar);
        this.refundView.setLifecycleOwner(qVar);
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return onChangeViewModelMReceiverMsgId((y) obj, i3);
            case 1:
                return onChangeViewModelMNotificationResId((y) obj, i3);
            case 2:
                return onChangeViewModelIsRefundSettingsEnabled((y) obj, i3);
            case 3:
                return onChangeRefundView((MpReceiveForItemViewBinding) obj, i3);
            case 4:
                return onChangeViewModelIsMerchantAdmin((y) obj, i3);
            case 5:
                return onChangeViewModelIsTransactionSettingsEnabled((y) obj, i3);
            case 6:
                return onChangeToolbar((MpToolbarNotificationBinding) obj, i3);
            case 7:
                return onChangeViewModelMMaxSecondaryNumbers((y) obj, i3);
            case 8:
                return onChangeTransactionView((MpReceiveForItemViewBinding) obj, i3);
            case 9:
                return onChangeViewModelMNotificationType((y) obj, i3);
            case 10:
                return onChangeViewModelIsShowAddNewButton((y) obj, i3);
            default:
                return false;
        }
    }

    private boolean onChangeViewModelMReceiverMsgId(y<Integer> yVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelMNotificationResId(y<Integer> yVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelIsRefundSettingsEnabled(y<Boolean> yVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeRefundView(MpReceiveForItemViewBinding mpReceiveForItemViewBinding, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeViewModelIsMerchantAdmin(y<Boolean> yVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeViewModelIsTransactionSettingsEnabled(y<Boolean> yVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeToolbar(MpToolbarNotificationBinding mpToolbarNotificationBinding, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeViewModelMMaxSecondaryNumbers(y<Integer> yVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    private boolean onChangeTransactionView(MpReceiveForItemViewBinding mpReceiveForItemViewBinding, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        return true;
    }

    private boolean onChangeViewModelMNotificationType(y<Integer> yVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        return true;
    }

    private boolean onChangeViewModelIsShowAddNewButton(y<Boolean> yVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1024;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x021a  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0237  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0240  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0264  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0270  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0275  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0283  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0291  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x02a6  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x02ad  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x02ba  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x02ca  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x02d6  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x02f5  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0302  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01b4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r43 = this;
            r1 = r43
            monitor-enter(r43)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x0319 }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x0319 }
            monitor-exit(r43)     // Catch:{ all -> 0x0319 }
            com.business.merchant_payments.notificationsettings.BindingUtils$Companion r0 = r1.mBindingUtils
            com.business.merchant_payments.notificationsettings.adapter.NotificationReceiverListAdapter r6 = r1.mAdapter
            com.business.merchant_payments.notificationsettings.viewmodel.EmailAndSmsNotificationViewModel r7 = r1.mViewModel
            r8 = 26626(0x6802, double:1.3155E-319)
            long r10 = r2 & r8
            r16 = 27265(0x6a81, double:1.34707E-319)
            r18 = 24608(0x6020, double:1.2158E-319)
            r20 = 65536(0x10000, double:3.2379E-319)
            r22 = 24580(0x6004, double:1.2144E-319)
            r24 = 262144(0x40000, double:1.295163E-318)
            r26 = 24576(0x6000, double:1.2142E-319)
            r8 = 1
            r9 = 0
            r28 = 0
            int r29 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            r10 = 28343(0x6eb7, double:1.40033E-319)
            long r10 = r10 & r2
            int r30 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r30 == 0) goto L_0x01c4
            long r10 = r2 & r26
            int r30 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r30 == 0) goto L_0x0056
            if (r7 == 0) goto L_0x0056
            com.business.merchant_payments.databinding.MpActivityEmailSmsNotificationBindingImpl$OnCheckedChangeListenerImpl r10 = r1.mViewModelOnTransactionCheckChangeAndroidWidgetCompoundButtonOnCheckedChangeListener
            if (r10 != 0) goto L_0x0042
            com.business.merchant_payments.databinding.MpActivityEmailSmsNotificationBindingImpl$OnCheckedChangeListenerImpl r10 = new com.business.merchant_payments.databinding.MpActivityEmailSmsNotificationBindingImpl$OnCheckedChangeListenerImpl
            r10.<init>()
            r1.mViewModelOnTransactionCheckChangeAndroidWidgetCompoundButtonOnCheckedChangeListener = r10
        L_0x0042:
            com.business.merchant_payments.databinding.MpActivityEmailSmsNotificationBindingImpl$OnCheckedChangeListenerImpl r10 = r10.setValue(r7)
            com.business.merchant_payments.databinding.MpActivityEmailSmsNotificationBindingImpl$OnCheckedChangeListenerImpl1 r11 = r1.mViewModelOnRefundsCheckChangeAndroidWidgetCompoundButtonOnCheckedChangeListener
            if (r11 != 0) goto L_0x0051
            com.business.merchant_payments.databinding.MpActivityEmailSmsNotificationBindingImpl$OnCheckedChangeListenerImpl1 r11 = new com.business.merchant_payments.databinding.MpActivityEmailSmsNotificationBindingImpl$OnCheckedChangeListenerImpl1
            r11.<init>()
            r1.mViewModelOnRefundsCheckChangeAndroidWidgetCompoundButtonOnCheckedChangeListener = r11
        L_0x0051:
            com.business.merchant_payments.databinding.MpActivityEmailSmsNotificationBindingImpl$OnCheckedChangeListenerImpl1 r11 = r11.setValue(r7)
            goto L_0x0059
        L_0x0056:
            r10 = r28
            r11 = r10
        L_0x0059:
            if (r29 == 0) goto L_0x00d8
            if (r7 == 0) goto L_0x0064
            androidx.lifecycle.y r29 = r7.getMNotificationResId()
            r14 = r29
            goto L_0x0066
        L_0x0064:
            r14 = r28
        L_0x0066:
            r1.updateLiveDataRegistration(r8, r14)
            if (r14 == 0) goto L_0x0072
            java.lang.Object r14 = r14.getValue()
            java.lang.Integer r14 = (java.lang.Integer) r14
            goto L_0x0074
        L_0x0072:
            r14 = r28
        L_0x0074:
            int r14 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Integer) r14)
            if (r0 == 0) goto L_0x007f
            java.lang.String r14 = r0.string(r14)
            goto L_0x0081
        L_0x007f:
            r14 = r28
        L_0x0081:
            android.view.View r15 = r43.getRoot()
            android.content.res.Resources r15 = r15.getResources()
            int r12 = com.business.merchant_payments.R.string.mp_for_transactions
            java.lang.String r12 = r15.getString(r12)
            java.lang.Object[] r13 = new java.lang.Object[r8]
            r13[r9] = r14
            java.lang.String r12 = java.lang.String.format(r12, r13)
            com.paytm.utility.RoboTextView r13 = r1.tvReceiveFor
            android.content.res.Resources r13 = r13.getResources()
            int r15 = com.business.merchant_payments.R.string.mp_receive_for
            java.lang.String r13 = r13.getString(r15)
            java.lang.Object[] r15 = new java.lang.Object[r8]
            r15[r9] = r14
            java.lang.String r13 = java.lang.String.format(r13, r15)
            android.view.View r15 = r43.getRoot()
            android.content.res.Resources r15 = r15.getResources()
            int r4 = com.business.merchant_payments.R.string.mp_placeholder_notifications
            java.lang.String r4 = r15.getString(r4)
            java.lang.Object[] r5 = new java.lang.Object[r8]
            r5[r9] = r14
            java.lang.String r4 = java.lang.String.format(r4, r5)
            android.view.View r5 = r43.getRoot()
            android.content.res.Resources r5 = r5.getResources()
            int r15 = com.business.merchant_payments.R.string.mp_for_refunds
            java.lang.String r5 = r5.getString(r15)
            java.lang.Object[] r15 = new java.lang.Object[r8]
            r15[r9] = r14
            java.lang.String r5 = java.lang.String.format(r5, r15)
            goto L_0x00dd
        L_0x00d8:
            r4 = r28
            r5 = r4
            r12 = r5
            r13 = r12
        L_0x00dd:
            long r14 = r2 & r22
            r8 = 2
            r33 = 0
            int r35 = (r14 > r33 ? 1 : (r14 == r33 ? 0 : -1))
            if (r35 == 0) goto L_0x00fb
            if (r7 == 0) goto L_0x00ed
            androidx.lifecycle.y r14 = r7.isRefundSettingsEnabled()
            goto L_0x00ef
        L_0x00ed:
            r14 = r28
        L_0x00ef:
            r1.updateLiveDataRegistration(r8, r14)
            if (r14 == 0) goto L_0x00fb
            java.lang.Object r14 = r14.getValue()
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            goto L_0x00fd
        L_0x00fb:
            r14 = r28
        L_0x00fd:
            long r35 = r2 & r18
            r33 = 0
            int r15 = (r35 > r33 ? 1 : (r35 == r33 ? 0 : -1))
            if (r15 == 0) goto L_0x011b
            if (r7 == 0) goto L_0x010c
            androidx.lifecycle.y r15 = r7.isTransactionSettingsEnabled()
            goto L_0x010e
        L_0x010c:
            r15 = r28
        L_0x010e:
            r9 = 5
            r1.updateLiveDataRegistration(r9, r15)
            if (r15 == 0) goto L_0x011b
            java.lang.Object r9 = r15.getValue()
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            goto L_0x011d
        L_0x011b:
            r9 = r28
        L_0x011d:
            long r36 = r2 & r16
            r33 = 0
            int r15 = (r36 > r33 ? 1 : (r36 == r33 ? 0 : -1))
            if (r15 == 0) goto L_0x0169
            if (r7 == 0) goto L_0x0130
            androidx.lifecycle.y r36 = r7.getMNotificationType()
            r37 = r4
            r8 = r36
            goto L_0x0134
        L_0x0130:
            r37 = r4
            r8 = r28
        L_0x0134:
            r4 = 9
            r1.updateLiveDataRegistration(r4, r8)
            if (r8 == 0) goto L_0x0142
            java.lang.Object r4 = r8.getValue()
            java.lang.Integer r4 = (java.lang.Integer) r4
            goto L_0x0144
        L_0x0142:
            r4 = r28
        L_0x0144:
            int r4 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Integer) r4)
            r8 = 2
            if (r4 != r8) goto L_0x014d
            r8 = 1
            goto L_0x014e
        L_0x014d:
            r8 = 0
        L_0x014e:
            if (r15 == 0) goto L_0x015a
            if (r8 == 0) goto L_0x0155
            long r2 = r2 | r20
            goto L_0x015a
        L_0x0155:
            r38 = 32768(0x8000, double:1.61895E-319)
            long r2 = r2 | r38
        L_0x015a:
            r31 = 25088(0x6200, double:1.2395E-319)
            long r38 = r2 & r31
            r33 = 0
            int r15 = (r38 > r33 ? 1 : (r38 == r33 ? 0 : -1))
            if (r15 == 0) goto L_0x016e
            r15 = 2
            if (r4 == r15) goto L_0x016e
            r4 = 1
            goto L_0x016f
        L_0x0169:
            r37 = r4
            r33 = 0
            r8 = 0
        L_0x016e:
            r4 = 0
        L_0x016f:
            r29 = 25616(0x6410, double:1.2656E-319)
            long r38 = r2 & r29
            int r15 = (r38 > r33 ? 1 : (r38 == r33 ? 0 : -1))
            if (r15 == 0) goto L_0x01b4
            if (r7 == 0) goto L_0x0186
            androidx.lifecycle.y r36 = r7.isShowAddNewButton()
            r38 = r5
            r42 = r36
            r36 = r4
            r4 = r42
            goto L_0x018c
        L_0x0186:
            r36 = r4
            r38 = r5
            r4 = r28
        L_0x018c:
            r5 = 10
            r1.updateLiveDataRegistration(r5, r4)
            if (r4 == 0) goto L_0x019a
            java.lang.Object r4 = r4.getValue()
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            goto L_0x019c
        L_0x019a:
            r4 = r28
        L_0x019c:
            boolean r4 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r4)
            if (r15 == 0) goto L_0x01ac
            if (r4 == 0) goto L_0x01a7
            long r2 = r2 | r24
            goto L_0x01ac
        L_0x01a7:
            r39 = 131072(0x20000, double:6.47582E-319)
            long r2 = r2 | r39
        L_0x01ac:
            r41 = r9
            r15 = r13
            r5 = r36
            r9 = r38
            goto L_0x01c0
        L_0x01b4:
            r36 = r4
            r38 = r5
            r41 = r9
            r15 = r13
            r5 = r36
            r9 = r38
            r4 = 0
        L_0x01c0:
            r13 = r12
            r12 = r37
            goto L_0x01d1
        L_0x01c4:
            r9 = r28
            r10 = r9
            r11 = r10
            r12 = r11
            r13 = r12
            r14 = r13
            r15 = r14
            r41 = r15
            r4 = 0
            r5 = 0
            r8 = 0
        L_0x01d1:
            r36 = 98304(0x18000, double:4.85686E-319)
            long r36 = r2 & r36
            r33 = 0
            int r38 = (r36 > r33 ? 1 : (r36 == r33 ? 0 : -1))
            if (r38 == 0) goto L_0x020c
            if (r7 == 0) goto L_0x01ec
            androidx.lifecycle.y r36 = r7.getMReceiverMsgId()
            r37 = r15
            r15 = 0
            r42 = r36
            r36 = r6
            r6 = r42
            goto L_0x01f3
        L_0x01ec:
            r36 = r6
            r37 = r15
            r6 = r28
            r15 = 0
        L_0x01f3:
            r1.updateLiveDataRegistration(r15, r6)
            if (r6 == 0) goto L_0x01ff
            java.lang.Object r6 = r6.getValue()
            java.lang.Integer r6 = (java.lang.Integer) r6
            goto L_0x0201
        L_0x01ff:
            r6 = r28
        L_0x0201:
            int r6 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Integer) r6)
            if (r0 == 0) goto L_0x0210
            java.lang.String r0 = r0.string(r6)
            goto L_0x0212
        L_0x020c:
            r36 = r6
            r37 = r15
        L_0x0210:
            r0 = r28
        L_0x0212:
            long r24 = r2 & r24
            r33 = 0
            int r6 = (r24 > r33 ? 1 : (r24 == r33 ? 0 : -1))
            if (r6 == 0) goto L_0x0237
            if (r7 == 0) goto L_0x0221
            androidx.lifecycle.y r6 = r7.isMerchantAdmin()
            goto L_0x0223
        L_0x0221:
            r6 = r28
        L_0x0223:
            r15 = 4
            r1.updateLiveDataRegistration(r15, r6)
            if (r6 == 0) goto L_0x0230
            java.lang.Object r6 = r6.getValue()
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            goto L_0x0232
        L_0x0230:
            r6 = r28
        L_0x0232:
            boolean r6 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r6)
            goto L_0x0238
        L_0x0237:
            r6 = 0
        L_0x0238:
            long r20 = r2 & r20
            r24 = 0
            int r15 = (r20 > r24 ? 1 : (r20 == r24 ? 0 : -1))
            if (r15 == 0) goto L_0x0264
            if (r7 == 0) goto L_0x0247
            androidx.lifecycle.y r7 = r7.getMMaxSecondaryNumbers()
            goto L_0x0249
        L_0x0247:
            r7 = r28
        L_0x0249:
            r15 = 7
            r1.updateLiveDataRegistration(r15, r7)
            if (r7 == 0) goto L_0x0256
            java.lang.Object r7 = r7.getValue()
            java.lang.Integer r7 = (java.lang.Integer) r7
            goto L_0x0258
        L_0x0256:
            r7 = r28
        L_0x0258:
            r15 = 1
            java.lang.Object[] r15 = new java.lang.Object[r15]
            r20 = 0
            r15[r20] = r7
            java.lang.String r7 = java.lang.String.format(r0, r15)
            goto L_0x0268
        L_0x0264:
            r20 = 0
            r7 = r28
        L_0x0268:
            long r15 = r2 & r16
            r24 = 0
            int r17 = (r15 > r24 ? 1 : (r15 == r24 ? 0 : -1))
            if (r17 == 0) goto L_0x0275
            if (r8 != 0) goto L_0x0273
            goto L_0x0277
        L_0x0273:
            r0 = r7
            goto L_0x0277
        L_0x0275:
            r0 = r28
        L_0x0277:
            r7 = 25616(0x6410, double:1.2656E-319)
            long r7 = r7 & r2
            int r15 = (r7 > r24 ? 1 : (r7 == r24 ? 0 : -1))
            if (r15 == 0) goto L_0x0280
            if (r4 != 0) goto L_0x0281
        L_0x0280:
            r6 = 0
        L_0x0281:
            if (r15 == 0) goto L_0x0288
            com.paytm.utility.RoboTextView r4 = r1.btnAddNew
            com.business.merchant_payments.common.utility.DataBindingUtility.bindVisibility(r4, r6)
        L_0x0288:
            r6 = 16384(0x4000, double:8.0948E-320)
            long r6 = r6 & r2
            r15 = 0
            int r4 = (r6 > r15 ? 1 : (r6 == r15 ? 0 : -1))
            if (r4 == 0) goto L_0x029f
            com.paytm.utility.RoboTextView r4 = r1.btnAddNew
            android.view.View$OnClickListener r6 = r1.mCallback2
            r4.setOnClickListener(r6)
            com.business.merchant_payments.databinding.MpToolbarNotificationBinding r4 = r1.toolbar
            android.view.View$OnClickListener r6 = r1.mCallback1
            r4.setBackButtonClick(r6)
        L_0x029f:
            r6 = 25088(0x6200, double:1.2395E-319)
            long r6 = r6 & r2
            int r4 = (r6 > r15 ? 1 : (r6 == r15 ? 0 : -1))
            if (r4 == 0) goto L_0x02ab
            androidx.constraintlayout.widget.Group r4 = r1.mboundView5
            com.business.merchant_payments.common.utility.DataBindingUtility.bindVisibility(r4, r5)
        L_0x02ab:
            if (r17 == 0) goto L_0x02b2
            com.paytm.utility.RoboTextView r4 = r1.paymentMsg
            androidx.databinding.a.d.a((android.widget.TextView) r4, (java.lang.CharSequence) r0)
        L_0x02b2:
            long r4 = r2 & r26
            r6 = 0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x02c4
            com.business.merchant_payments.databinding.MpReceiveForItemViewBinding r0 = r1.refundView
            r0.setCheckChangeListener(r11)
            com.business.merchant_payments.databinding.MpReceiveForItemViewBinding r0 = r1.transactionView
            r0.setCheckChangeListener(r10)
        L_0x02c4:
            long r4 = r2 & r22
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x02cf
            com.business.merchant_payments.databinding.MpReceiveForItemViewBinding r0 = r1.refundView
            r0.setIsChecked(r14)
        L_0x02cf:
            r4 = 26626(0x6802, double:1.3155E-319)
            long r4 = r4 & r2
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x02ec
            com.business.merchant_payments.databinding.MpReceiveForItemViewBinding r0 = r1.refundView
            r0.setMsg(r9)
            com.business.merchant_payments.databinding.MpToolbarNotificationBinding r0 = r1.toolbar
            r0.setTitle(r12)
            com.business.merchant_payments.databinding.MpReceiveForItemViewBinding r0 = r1.transactionView
            r0.setMsg(r13)
            com.paytm.utility.RoboTextView r0 = r1.tvReceiveFor
            r13 = r37
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r13)
        L_0x02ec:
            r4 = 20480(0x5000, double:1.01185E-319)
            long r4 = r4 & r2
            r6 = 0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x02fc
            androidx.recyclerview.widget.RecyclerView r0 = r1.rvReceiver
            r4 = r36
            r0.setAdapter(r4)
        L_0x02fc:
            long r2 = r2 & r18
            int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x0309
            com.business.merchant_payments.databinding.MpReceiveForItemViewBinding r0 = r1.transactionView
            r9 = r41
            r0.setIsChecked(r9)
        L_0x0309:
            com.business.merchant_payments.databinding.MpToolbarNotificationBinding r0 = r1.toolbar
            androidx.databinding.ViewDataBinding.executeBindingsOn(r0)
            com.business.merchant_payments.databinding.MpReceiveForItemViewBinding r0 = r1.transactionView
            androidx.databinding.ViewDataBinding.executeBindingsOn(r0)
            com.business.merchant_payments.databinding.MpReceiveForItemViewBinding r0 = r1.refundView
            androidx.databinding.ViewDataBinding.executeBindingsOn(r0)
            return
        L_0x0319:
            r0 = move-exception
            monitor-exit(r43)     // Catch:{ all -> 0x0319 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.databinding.MpActivityEmailSmsNotificationBindingImpl.executeBindings():void");
    }

    public static class OnCheckedChangeListenerImpl implements CompoundButton.OnCheckedChangeListener {
        public EmailAndSmsNotificationViewModel value;

        public OnCheckedChangeListenerImpl setValue(EmailAndSmsNotificationViewModel emailAndSmsNotificationViewModel) {
            this.value = emailAndSmsNotificationViewModel;
            if (emailAndSmsNotificationViewModel == null) {
                return null;
            }
            return this;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.value.onTransactionCheckChange(compoundButton, z);
        }
    }

    public static class OnCheckedChangeListenerImpl1 implements CompoundButton.OnCheckedChangeListener {
        public EmailAndSmsNotificationViewModel value;

        public OnCheckedChangeListenerImpl1 setValue(EmailAndSmsNotificationViewModel emailAndSmsNotificationViewModel) {
            this.value = emailAndSmsNotificationViewModel;
            if (emailAndSmsNotificationViewModel == null) {
                return null;
            }
            return this;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.value.onRefundsCheckChange(compoundButton, z);
        }
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        boolean z = false;
        if (i2 == 1) {
            EmailAndSmsNotificationViewModel emailAndSmsNotificationViewModel = this.mViewModel;
            if (emailAndSmsNotificationViewModel != null) {
                z = true;
            }
            if (z) {
                emailAndSmsNotificationViewModel.onBackButtonPress();
            }
        } else if (i2 == 2) {
            EmailAndSmsNotificationViewModel emailAndSmsNotificationViewModel2 = this.mViewModel;
            if (emailAndSmsNotificationViewModel2 != null) {
                z = true;
            }
            if (z) {
                emailAndSmsNotificationViewModel2.addReceiver();
            }
        }
    }
}
