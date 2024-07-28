package com.business.merchant_payments.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import androidx.lifecycle.y;
import com.business.merchant_payments.BR;
import com.business.merchant_payments.R;
import com.business.merchant_payments.generated.callback.OnClickListener;
import com.business.merchant_payments.notificationsettings.model.NotificationReceiverModel;
import com.business.merchant_payments.notificationsettings.viewmodel.EmailAndSmsNotificationViewModel;
import com.paytm.utility.RoboTextView;

public class MpEmailSmsListItemBindingImpl extends MpEmailSmsListItemBinding implements OnClickListener.Listener {
    public static final ViewDataBinding.b sIncludes = null;
    public static final SparseIntArray sViewsWithIds;
    public final View.OnClickListener mCallback9;
    public long mDirtyFlags;
    public final ConstraintLayout mboundView0;
    public final RoboTextView mboundView5;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.bg_circle, 7);
    }

    public MpEmailSmsListItemBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 8, sIncludes, sViewsWithIds));
    }

    public MpEmailSmsListItemBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 3, objArr[7], objArr[6], objArr[1], objArr[2], objArr[3], objArr[4]);
        this.mDirtyFlags = -1;
        this.btnRemoveReceiver.setTag((Object) null);
        this.contactImg.setTag((Object) null);
        ConstraintLayout constraintLayout = objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag((Object) null);
        RoboTextView roboTextView = objArr[5];
        this.mboundView5 = roboTextView;
        roboTextView.setTag((Object) null);
        this.tvEmailId.setTag((Object) null);
        this.tvPrimaryReceiver.setTag((Object) null);
        this.tvSecondaryReceiver.setTag((Object) null);
        setRootTag(view);
        this.mCallback9 = new OnClickListener(this, 1);
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
        if (BR.position == i2) {
            setPosition((Integer) obj);
        } else if (BR.itemColor == i2) {
            setItemColor((Integer) obj);
        } else if (BR.dataModel == i2) {
            setDataModel((NotificationReceiverModel) obj);
        } else if (BR.viewModel != i2) {
            return false;
        } else {
            setViewModel((EmailAndSmsNotificationViewModel) obj);
        }
        return true;
    }

    public void setPosition(Integer num) {
        this.mPosition = num;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(BR.position);
        super.requestRebind();
    }

    public void setItemColor(Integer num) {
        this.mItemColor = num;
    }

    public void setDataModel(NotificationReceiverModel notificationReceiverModel) {
        updateRegistration(0, (h) notificationReceiverModel);
        this.mDataModel = notificationReceiverModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.dataModel);
        super.requestRebind();
    }

    public void setViewModel(EmailAndSmsNotificationViewModel emailAndSmsNotificationViewModel) {
        this.mViewModel = emailAndSmsNotificationViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return onChangeDataModel((NotificationReceiverModel) obj, i3);
        }
        if (i2 == 1) {
            return onChangeViewModelIsMerchantAdmin((y) obj, i3);
        }
        if (i2 != 2) {
            return false;
        }
        return onChangeViewModelMNotificationType((y) obj, i3);
    }

    private boolean onChangeDataModel(NotificationReceiverModel notificationReceiverModel, int i2) {
        if (i2 == BR._all) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i2 == BR.primaryViewVisibility) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i2 == BR.receiver) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i2 != BR.removeButtonVisibility) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        }
    }

    private boolean onChangeViewModelIsMerchantAdmin(y<Boolean> yVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelMNotificationType(y<Integer> yVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0168  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r28 = this;
            r1 = r28
            monitor-enter(r28)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x0173 }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x0173 }
            monitor-exit(r28)     // Catch:{ all -> 0x0173 }
            com.business.merchant_payments.notificationsettings.model.NotificationReceiverModel r0 = r1.mDataModel
            com.business.merchant_payments.notificationsettings.viewmodel.EmailAndSmsNotificationViewModel r6 = r1.mViewModel
            r7 = 995(0x3e3, double:4.916E-321)
            long r7 = r7 & r2
            r11 = 641(0x281, double:3.167E-321)
            r13 = 2048(0x800, double:1.0118E-320)
            r15 = 513(0x201, double:2.535E-321)
            r17 = 803(0x323, double:3.967E-321)
            r19 = 0
            r9 = 0
            int r10 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x0088
            long r7 = r2 & r17
            int r10 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x0039
            if (r0 == 0) goto L_0x002d
            boolean r7 = r0.getRemoveButtonVisibility()
            goto L_0x002e
        L_0x002d:
            r7 = 0
        L_0x002e:
            if (r10 == 0) goto L_0x003a
            if (r7 == 0) goto L_0x0034
            long r2 = r2 | r13
            goto L_0x003a
        L_0x0034:
            r22 = 1024(0x400, double:5.06E-321)
            long r2 = r2 | r22
            goto L_0x003a
        L_0x0039:
            r7 = 0
        L_0x003a:
            long r22 = r2 & r15
            int r8 = (r22 > r4 ? 1 : (r22 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x005c
            if (r0 == 0) goto L_0x0047
            java.lang.String r8 = r0.getReceiverString()
            goto L_0x0049
        L_0x0047:
            r8 = r19
        L_0x0049:
            if (r8 == 0) goto L_0x0050
            char r8 = r8.charAt(r9)
            goto L_0x0051
        L_0x0050:
            r8 = 0
        L_0x0051:
            java.lang.String r8 = java.lang.String.valueOf(r8)
            if (r8 == 0) goto L_0x005c
            java.lang.String r8 = r8.toUpperCase()
            goto L_0x005e
        L_0x005c:
            r8 = r19
        L_0x005e:
            long r22 = r2 & r11
            int r10 = (r22 > r4 ? 1 : (r22 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x006b
            if (r0 == 0) goto L_0x006b
            java.lang.String r10 = r0.getReceiver()
            goto L_0x006d
        L_0x006b:
            r10 = r19
        L_0x006d:
            r20 = 577(0x241, double:2.85E-321)
            long r22 = r2 & r20
            int r24 = (r22 > r4 ? 1 : (r22 == r4 ? 0 : -1))
            if (r24 == 0) goto L_0x0084
            if (r0 == 0) goto L_0x007c
            boolean r0 = r0.getPrimaryViewVisibility()
            goto L_0x007d
        L_0x007c:
            r0 = 0
        L_0x007d:
            r22 = r0 ^ 1
            r9 = r10
            r10 = r8
            r8 = r22
            goto L_0x008e
        L_0x0084:
            r9 = r10
            r0 = 0
            r10 = r8
            goto L_0x008d
        L_0x0088:
            r9 = r19
            r10 = r9
            r0 = 0
            r7 = 0
        L_0x008d:
            r8 = 0
        L_0x008e:
            r23 = 548(0x224, double:2.707E-321)
            long r25 = r2 & r23
            r11 = 1
            int r12 = (r25 > r4 ? 1 : (r25 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x00e1
            if (r6 == 0) goto L_0x00a0
            androidx.lifecycle.y r25 = r6.getMNotificationType()
            r15 = r25
            goto L_0x00a2
        L_0x00a0:
            r15 = r19
        L_0x00a2:
            r4 = 2
            r1.updateLiveDataRegistration(r4, r15)
            if (r15 == 0) goto L_0x00af
            java.lang.Object r5 = r15.getValue()
            java.lang.Integer r5 = (java.lang.Integer) r5
            goto L_0x00b1
        L_0x00af:
            r5 = r19
        L_0x00b1:
            int r5 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Integer) r5)
            if (r5 != r4) goto L_0x00b9
            r4 = 1
            goto L_0x00ba
        L_0x00b9:
            r4 = 0
        L_0x00ba:
            if (r5 != r11) goto L_0x00be
            r5 = 1
            goto L_0x00bf
        L_0x00be:
            r5 = 0
        L_0x00bf:
            if (r12 == 0) goto L_0x00c9
            if (r4 == 0) goto L_0x00c6
            r15 = 8192(0x2000, double:4.0474E-320)
            goto L_0x00c8
        L_0x00c6:
            r15 = 4096(0x1000, double:2.0237E-320)
        L_0x00c8:
            long r2 = r2 | r15
        L_0x00c9:
            if (r4 == 0) goto L_0x00d4
            com.paytm.utility.RoboTextView r12 = r1.mboundView5
            android.content.res.Resources r12 = r12.getResources()
            int r15 = com.business.merchant_payments.R.string.mp_primary_number
            goto L_0x00dc
        L_0x00d4:
            com.paytm.utility.RoboTextView r12 = r1.mboundView5
            android.content.res.Resources r12 = r12.getResources()
            int r15 = com.business.merchant_payments.R.string.mp_primary_email_address
        L_0x00dc:
            java.lang.String r12 = r12.getString(r15)
            goto L_0x00e5
        L_0x00e1:
            r12 = r19
            r4 = 0
            r5 = 0
        L_0x00e5:
            long r13 = r13 & r2
            r15 = 0
            int r27 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r27 == 0) goto L_0x0107
            if (r6 == 0) goto L_0x00f3
            androidx.lifecycle.y r6 = r6.isMerchantAdmin()
            goto L_0x00f5
        L_0x00f3:
            r6 = r19
        L_0x00f5:
            r1.updateLiveDataRegistration(r11, r6)
            if (r6 == 0) goto L_0x0102
            java.lang.Object r6 = r6.getValue()
            r19 = r6
            java.lang.Boolean r19 = (java.lang.Boolean) r19
        L_0x0102:
            boolean r6 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r19)
            goto L_0x0108
        L_0x0107:
            r6 = 0
        L_0x0108:
            long r13 = r2 & r17
            r15 = 0
            int r11 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r11 == 0) goto L_0x0112
            if (r7 != 0) goto L_0x0113
        L_0x0112:
            r6 = 0
        L_0x0113:
            if (r11 == 0) goto L_0x011a
            com.paytm.utility.RoboTextView r7 = r1.btnRemoveReceiver
            com.business.merchant_payments.common.utility.DataBindingUtility.bindVisibility(r7, r6)
        L_0x011a:
            r6 = 512(0x200, double:2.53E-321)
            long r6 = r6 & r2
            r13 = 0
            int r11 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            if (r11 == 0) goto L_0x012a
            com.paytm.utility.RoboTextView r6 = r1.btnRemoveReceiver
            android.view.View$OnClickListener r7 = r1.mCallback9
            r6.setOnClickListener(r7)
        L_0x012a:
            long r6 = r2 & r23
            int r11 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            if (r11 == 0) goto L_0x013f
            android.widget.ImageView r6 = r1.contactImg
            com.business.merchant_payments.common.utility.DataBindingUtility.bindVisibility(r6, r4)
            com.paytm.utility.RoboTextView r4 = r1.mboundView5
            androidx.databinding.a.d.a((android.widget.TextView) r4, (java.lang.CharSequence) r12)
            com.paytm.utility.RoboTextView r4 = r1.tvEmailId
            com.business.merchant_payments.common.utility.DataBindingUtility.bindVisibility(r4, r5)
        L_0x013f:
            r4 = 577(0x241, double:2.85E-321)
            long r4 = r4 & r2
            int r6 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r6 == 0) goto L_0x0155
            com.paytm.utility.RoboTextView r4 = r1.mboundView5
            com.business.merchant_payments.common.utility.DataBindingUtility.bindVisibility(r4, r0)
            com.paytm.utility.RoboTextView r4 = r1.tvPrimaryReceiver
            com.business.merchant_payments.common.utility.DataBindingUtility.bindVisibility(r4, r0)
            com.paytm.utility.RoboTextView r0 = r1.tvSecondaryReceiver
            com.business.merchant_payments.common.utility.DataBindingUtility.bindVisibility(r0, r8)
        L_0x0155:
            r4 = 513(0x201, double:2.535E-321)
            long r4 = r4 & r2
            int r0 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r0 == 0) goto L_0x0161
            com.paytm.utility.RoboTextView r0 = r1.tvEmailId
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r10)
        L_0x0161:
            r4 = 641(0x281, double:3.167E-321)
            long r2 = r2 & r4
            int r0 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r0 == 0) goto L_0x0172
            com.paytm.utility.RoboTextView r0 = r1.tvPrimaryReceiver
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r9)
            com.paytm.utility.RoboTextView r0 = r1.tvSecondaryReceiver
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r9)
        L_0x0172:
            return
        L_0x0173:
            r0 = move-exception
            monitor-exit(r28)     // Catch:{ all -> 0x0173 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.databinding.MpEmailSmsListItemBindingImpl.executeBindings():void");
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        NotificationReceiverModel notificationReceiverModel = this.mDataModel;
        Integer num = this.mPosition;
        EmailAndSmsNotificationViewModel emailAndSmsNotificationViewModel = this.mViewModel;
        if (emailAndSmsNotificationViewModel != null) {
            emailAndSmsNotificationViewModel.removeSecondaryReceiver(notificationReceiverModel, num.intValue());
        }
    }
}
