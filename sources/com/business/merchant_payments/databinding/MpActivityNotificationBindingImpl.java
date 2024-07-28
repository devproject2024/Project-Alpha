package com.business.merchant_payments.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CompoundButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.q;
import androidx.lifecycle.y;
import com.business.merchant_payments.BR;
import com.business.merchant_payments.R;
import com.business.merchant_payments.generated.callback.OnClickListener;
import com.paytm.business.c.a.a;
import kotlin.g.b.k;

public class MpActivityNotificationBindingImpl extends MpActivityNotificationBinding implements OnClickListener.Listener {
    public static final ViewDataBinding.b sIncludes;
    public static final SparseIntArray sViewsWithIds;
    public final View.OnClickListener mCallback5;
    public final View.OnClickListener mCallback6;
    public final View.OnClickListener mCallback7;
    public long mDirtyFlags;
    public OnCheckedChangeListenerImpl1 mViewmodelOnEmailAlertCheckChangeAndroidWidgetCompoundButtonOnCheckedChangeListener;
    public OnCheckedChangeListenerImpl mViewmodelOnSmsAlertCheckChangeAndroidWidgetCompoundButtonOnCheckedChangeListener;
    public final ConstraintLayout mboundView0;

    static {
        ViewDataBinding.b bVar = new ViewDataBinding.b(7);
        sIncludes = bVar;
        int i2 = R.layout.mp_notification_item_view;
        bVar.a(0, new String[]{"mp_toolbar_notification", "mp_notification_item_view", "mp_notification_item_view"}, new int[]{1, 2, 3}, new int[]{R.layout.mp_toolbar_notification, i2, i2});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.sms_settings_overlay, 4);
        sViewsWithIds.put(R.id.email_settings_overlay, 5);
        sViewsWithIds.put(R.id.notification_settings_overlay, 6);
    }

    public MpActivityNotificationBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 7, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MpActivityNotificationBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 7, objArr[5], objArr[6], objArr[4], objArr[1], objArr[3], objArr[2]);
        this.mDirtyFlags = -1;
        ConstraintLayout constraintLayout = objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag((Object) null);
        setRootTag(view);
        this.mCallback6 = new OnClickListener(this, 2);
        this.mCallback7 = new OnClickListener(this, 3);
        this.mCallback5 = new OnClickListener(this, 1);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 256;
        }
        this.toolbar.invalidateAll();
        this.viewSms.invalidateAll();
        this.viewEmail.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r6.viewSms.hasPendingBindings() == false) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
        if (r6.viewEmail.hasPendingBindings() == false) goto L_0x0028;
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
            com.business.merchant_payments.databinding.MpNotificationItemViewBinding r0 = r6.viewSms
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x001f
            return r4
        L_0x001f:
            com.business.merchant_payments.databinding.MpNotificationItemViewBinding r0 = r6.viewEmail
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
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.databinding.MpActivityNotificationBindingImpl.hasPendingBindings():boolean");
    }

    public boolean setVariable(int i2, Object obj) {
        if (BR.viewmodel != i2) {
            return false;
        }
        setViewmodel((a) obj);
        return true;
    }

    public void setViewmodel(a aVar) {
        this.mViewmodel = aVar;
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        notifyPropertyChanged(BR.viewmodel);
        super.requestRebind();
    }

    public void setLifecycleOwner(q qVar) {
        super.setLifecycleOwner(qVar);
        this.toolbar.setLifecycleOwner(qVar);
        this.viewSms.setLifecycleOwner(qVar);
        this.viewEmail.setLifecycleOwner(qVar);
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return onChangeViewmodelIsEmailAlertOn((y) obj, i3);
            case 1:
                return onChangeToolbar((MpToolbarNotificationBinding) obj, i3);
            case 2:
                return onChangeViewSms((MpNotificationItemViewBinding) obj, i3);
            case 3:
                return onChangeViewmodelSmsAlertMobileNumbers((y) obj, i3);
            case 4:
                return onChangeViewmodelIsSmsAlertOn((y) obj, i3);
            case 5:
                return onChangeViewEmail((MpNotificationItemViewBinding) obj, i3);
            case 6:
                return onChangeViewmodelEmailAlertIds((y) obj, i3);
            default:
                return false;
        }
    }

    private boolean onChangeViewmodelIsEmailAlertOn(y<Boolean> yVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeToolbar(MpToolbarNotificationBinding mpToolbarNotificationBinding, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewSms(MpNotificationItemViewBinding mpNotificationItemViewBinding, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeViewmodelSmsAlertMobileNumbers(y<String> yVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeViewmodelIsSmsAlertOn(y<Boolean> yVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeViewEmail(MpNotificationItemViewBinding mpNotificationItemViewBinding, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeViewmodelEmailAlertIds(y<String> yVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x019f  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01c5  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01cc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r27 = this;
            r1 = r27
            monitor-enter(r27)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x01e1 }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x01e1 }
            monitor-exit(r27)     // Catch:{ all -> 0x01e1 }
            com.paytm.business.c.a.a r0 = r1.mViewmodel
            r6 = 473(0x1d9, double:2.337E-321)
            long r6 = r6 & r2
            r8 = 400(0x190, double:1.976E-321)
            r12 = 384(0x180, double:1.897E-321)
            r14 = 385(0x181, double:1.9E-321)
            r16 = 392(0x188, double:1.937E-321)
            r10 = 0
            int r20 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r20 == 0) goto L_0x00e2
            long r6 = r2 & r14
            int r20 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r20 == 0) goto L_0x0036
            if (r0 == 0) goto L_0x0029
            androidx.lifecycle.y r6 = r0.d()
            goto L_0x002a
        L_0x0029:
            r6 = 0
        L_0x002a:
            r1.updateLiveDataRegistration(r10, r6)
            if (r6 == 0) goto L_0x0036
            java.lang.Object r6 = r6.getValue()
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            goto L_0x0037
        L_0x0036:
            r6 = 0
        L_0x0037:
            long r20 = r2 & r12
            int r7 = (r20 > r4 ? 1 : (r20 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x005e
            if (r0 == 0) goto L_0x005e
            com.business.merchant_payments.databinding.MpActivityNotificationBindingImpl$OnCheckedChangeListenerImpl r7 = r1.mViewmodelOnSmsAlertCheckChangeAndroidWidgetCompoundButtonOnCheckedChangeListener
            if (r7 != 0) goto L_0x004a
            com.business.merchant_payments.databinding.MpActivityNotificationBindingImpl$OnCheckedChangeListenerImpl r7 = new com.business.merchant_payments.databinding.MpActivityNotificationBindingImpl$OnCheckedChangeListenerImpl
            r7.<init>()
            r1.mViewmodelOnSmsAlertCheckChangeAndroidWidgetCompoundButtonOnCheckedChangeListener = r7
        L_0x004a:
            com.business.merchant_payments.databinding.MpActivityNotificationBindingImpl$OnCheckedChangeListenerImpl r7 = r7.setValue(r0)
            com.business.merchant_payments.databinding.MpActivityNotificationBindingImpl$OnCheckedChangeListenerImpl1 r10 = r1.mViewmodelOnEmailAlertCheckChangeAndroidWidgetCompoundButtonOnCheckedChangeListener
            if (r10 != 0) goto L_0x0059
            com.business.merchant_payments.databinding.MpActivityNotificationBindingImpl$OnCheckedChangeListenerImpl1 r10 = new com.business.merchant_payments.databinding.MpActivityNotificationBindingImpl$OnCheckedChangeListenerImpl1
            r10.<init>()
            r1.mViewmodelOnEmailAlertCheckChangeAndroidWidgetCompoundButtonOnCheckedChangeListener = r10
        L_0x0059:
            com.business.merchant_payments.databinding.MpActivityNotificationBindingImpl$OnCheckedChangeListenerImpl1 r10 = r10.setValue(r0)
            goto L_0x0060
        L_0x005e:
            r7 = 0
            r10 = 0
        L_0x0060:
            long r21 = r2 & r16
            int r23 = (r21 > r4 ? 1 : (r21 == r4 ? 0 : -1))
            if (r23 == 0) goto L_0x008e
            if (r0 == 0) goto L_0x006f
            androidx.lifecycle.y r21 = r0.e()
            r11 = r21
            goto L_0x0070
        L_0x006f:
            r11 = 0
        L_0x0070:
            r14 = 3
            r1.updateLiveDataRegistration(r14, r11)
            if (r11 == 0) goto L_0x007d
            java.lang.Object r11 = r11.getValue()
            java.lang.String r11 = (java.lang.String) r11
            goto L_0x007e
        L_0x007d:
            r11 = 0
        L_0x007e:
            boolean r14 = android.text.TextUtils.isEmpty(r11)
            if (r23 == 0) goto L_0x0090
            if (r14 == 0) goto L_0x0089
            r22 = 1024(0x400, double:5.06E-321)
            goto L_0x008b
        L_0x0089:
            r22 = 512(0x200, double:2.53E-321)
        L_0x008b:
            long r2 = r2 | r22
            goto L_0x0090
        L_0x008e:
            r11 = 0
            r14 = 0
        L_0x0090:
            long r22 = r2 & r8
            int r15 = (r22 > r4 ? 1 : (r22 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x00ab
            if (r0 == 0) goto L_0x009d
            androidx.lifecycle.y r15 = r0.c()
            goto L_0x009e
        L_0x009d:
            r15 = 0
        L_0x009e:
            r8 = 4
            r1.updateLiveDataRegistration(r8, r15)
            if (r15 == 0) goto L_0x00ab
            java.lang.Object r8 = r15.getValue()
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            goto L_0x00ac
        L_0x00ab:
            r8 = 0
        L_0x00ac:
            r18 = 448(0x1c0, double:2.213E-321)
            long r24 = r2 & r18
            int r9 = (r24 > r4 ? 1 : (r24 == r4 ? 0 : -1))
            if (r9 == 0) goto L_0x00df
            if (r0 == 0) goto L_0x00bb
            androidx.lifecycle.y r0 = r0.f()
            goto L_0x00bc
        L_0x00bb:
            r0 = 0
        L_0x00bc:
            r15 = 6
            r1.updateLiveDataRegistration(r15, r0)
            if (r0 == 0) goto L_0x00c9
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x00ca
        L_0x00c9:
            r0 = 0
        L_0x00ca:
            boolean r15 = android.text.TextUtils.isEmpty(r0)
            if (r9 == 0) goto L_0x00d9
            if (r15 == 0) goto L_0x00d5
            r24 = 4096(0x1000, double:2.0237E-320)
            goto L_0x00d7
        L_0x00d5:
            r24 = 2048(0x800, double:1.0118E-320)
        L_0x00d7:
            long r2 = r2 | r24
        L_0x00d9:
            r26 = r11
            r11 = r0
            r0 = r26
            goto L_0x00ea
        L_0x00df:
            r0 = r11
            r11 = 0
            goto L_0x00e9
        L_0x00e2:
            r0 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r10 = 0
            r11 = 0
            r14 = 0
        L_0x00e9:
            r15 = 0
        L_0x00ea:
            long r16 = r2 & r16
            int r9 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r9 == 0) goto L_0x0101
            if (r14 == 0) goto L_0x0102
            android.view.View r0 = r27.getRoot()
            android.content.res.Resources r0 = r0.getResources()
            int r14 = com.business.merchant_payments.R.string.mp_add_number_to_receive_updates
            java.lang.String r0 = r0.getString(r14)
            goto L_0x0102
        L_0x0101:
            r0 = 0
        L_0x0102:
            r16 = 448(0x1c0, double:2.213E-321)
            long r16 = r2 & r16
            int r14 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x011b
            if (r15 == 0) goto L_0x011c
            android.view.View r11 = r27.getRoot()
            android.content.res.Resources r11 = r11.getResources()
            int r15 = com.business.merchant_payments.R.string.mp_add_email_for_updates
            java.lang.String r11 = r11.getString(r15)
            goto L_0x011c
        L_0x011b:
            r11 = 0
        L_0x011c:
            r15 = 256(0x100, double:1.265E-321)
            long r15 = r15 & r2
            int r17 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r17 == 0) goto L_0x0197
            com.business.merchant_payments.databinding.MpToolbarNotificationBinding r15 = r1.toolbar
            android.view.View$OnClickListener r4 = r1.mCallback5
            r15.setBackButtonClick(r4)
            com.business.merchant_payments.databinding.MpToolbarNotificationBinding r4 = r1.toolbar
            android.view.View r5 = r27.getRoot()
            android.content.res.Resources r5 = r5.getResources()
            int r15 = com.business.merchant_payments.R.string.mp_notifications
            java.lang.String r5 = r5.getString(r15)
            r4.setTitle(r5)
            com.business.merchant_payments.databinding.MpNotificationItemViewBinding r4 = r1.viewEmail
            android.view.View r5 = r27.getRoot()
            android.content.Context r5 = r5.getContext()
            int r15 = com.business.merchant_payments.R.drawable.mp_ic_email
            android.graphics.drawable.Drawable r5 = androidx.appcompat.a.a.a.b(r5, r15)
            r4.setIcon(r5)
            com.business.merchant_payments.databinding.MpNotificationItemViewBinding r4 = r1.viewEmail
            android.view.View$OnClickListener r5 = r1.mCallback7
            r4.setOnClickAction(r5)
            com.business.merchant_payments.databinding.MpNotificationItemViewBinding r4 = r1.viewEmail
            android.view.View r5 = r27.getRoot()
            android.content.res.Resources r5 = r5.getResources()
            int r15 = com.business.merchant_payments.R.string.mp_on_email
            java.lang.String r5 = r5.getString(r15)
            r4.setTitle(r5)
            com.business.merchant_payments.databinding.MpNotificationItemViewBinding r4 = r1.viewSms
            android.view.View r5 = r27.getRoot()
            android.content.Context r5 = r5.getContext()
            int r15 = com.business.merchant_payments.R.drawable.mp_ic_sms
            android.graphics.drawable.Drawable r5 = androidx.appcompat.a.a.a.b(r5, r15)
            r4.setIcon(r5)
            com.business.merchant_payments.databinding.MpNotificationItemViewBinding r4 = r1.viewSms
            android.view.View$OnClickListener r5 = r1.mCallback6
            r4.setOnClickAction(r5)
            com.business.merchant_payments.databinding.MpNotificationItemViewBinding r4 = r1.viewSms
            android.view.View r5 = r27.getRoot()
            android.content.res.Resources r5 = r5.getResources()
            int r15 = com.business.merchant_payments.R.string.mp_on_sms
            java.lang.String r5 = r5.getString(r15)
            r4.setTitle(r5)
        L_0x0197:
            long r4 = r2 & r12
            r12 = 0
            int r15 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r15 == 0) goto L_0x01a9
            com.business.merchant_payments.databinding.MpNotificationItemViewBinding r4 = r1.viewEmail
            r4.setCheckChangeListener(r10)
            com.business.merchant_payments.databinding.MpNotificationItemViewBinding r4 = r1.viewSms
            r4.setCheckChangeListener(r7)
        L_0x01a9:
            r4 = 385(0x181, double:1.9E-321)
            long r4 = r4 & r2
            int r7 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r7 == 0) goto L_0x01b5
            com.business.merchant_payments.databinding.MpNotificationItemViewBinding r4 = r1.viewEmail
            r4.setIsChecked(r6)
        L_0x01b5:
            if (r14 == 0) goto L_0x01bc
            com.business.merchant_payments.databinding.MpNotificationItemViewBinding r4 = r1.viewEmail
            r4.setSubtitle(r11)
        L_0x01bc:
            r4 = 400(0x190, double:1.976E-321)
            long r2 = r2 & r4
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x01ca
            com.business.merchant_payments.databinding.MpNotificationItemViewBinding r2 = r1.viewSms
            r2.setIsChecked(r8)
        L_0x01ca:
            if (r9 == 0) goto L_0x01d1
            com.business.merchant_payments.databinding.MpNotificationItemViewBinding r2 = r1.viewSms
            r2.setSubtitle(r0)
        L_0x01d1:
            com.business.merchant_payments.databinding.MpToolbarNotificationBinding r0 = r1.toolbar
            androidx.databinding.ViewDataBinding.executeBindingsOn(r0)
            com.business.merchant_payments.databinding.MpNotificationItemViewBinding r0 = r1.viewSms
            androidx.databinding.ViewDataBinding.executeBindingsOn(r0)
            com.business.merchant_payments.databinding.MpNotificationItemViewBinding r0 = r1.viewEmail
            androidx.databinding.ViewDataBinding.executeBindingsOn(r0)
            return
        L_0x01e1:
            r0 = move-exception
            monitor-exit(r27)     // Catch:{ all -> 0x01e1 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.databinding.MpActivityNotificationBindingImpl.executeBindings():void");
    }

    public static class OnCheckedChangeListenerImpl implements CompoundButton.OnCheckedChangeListener {
        public a value;

        public OnCheckedChangeListenerImpl setValue(a aVar) {
            this.value = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            a aVar = this.value;
            k.d(compoundButton, "buttonView");
            if (compoundButton.isPressed()) {
                compoundButton.setPressed(false);
                if (!aVar.f42671i) {
                    aVar.b().setValue(11);
                    aVar.j();
                } else if (z) {
                    aVar.a(z, 2);
                } else {
                    aVar.b().setValue(8);
                }
            }
        }
    }

    public static class OnCheckedChangeListenerImpl1 implements CompoundButton.OnCheckedChangeListener {
        public a value;

        public OnCheckedChangeListenerImpl1 setValue(a aVar) {
            this.value = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            a aVar = this.value;
            k.d(compoundButton, "buttonView");
            if (compoundButton.isPressed()) {
                compoundButton.setPressed(false);
                if (!aVar.f42671i) {
                    aVar.b().setValue(11);
                    aVar.j();
                } else if (z) {
                    aVar.a(z, 1);
                } else {
                    aVar.b().setValue(7);
                }
            }
        }
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        boolean z = false;
        if (i2 == 1) {
            a aVar = this.mViewmodel;
            if (aVar != null) {
                z = true;
            }
            if (z) {
                aVar.b().setValue(4);
            }
        } else if (i2 == 2) {
            a aVar2 = this.mViewmodel;
            if (aVar2 != null) {
                z = true;
            }
            if (z && k.a((Object) aVar2.c().getValue(), (Object) Boolean.TRUE)) {
                aVar2.b().setValue(2);
            }
        } else if (i2 == 3) {
            a aVar3 = this.mViewmodel;
            if ((aVar3 != null) && k.a((Object) aVar3.d().getValue(), (Object) Boolean.TRUE)) {
                CharSequence value = aVar3.f().getValue();
                if (value == null || value.length() == 0) {
                    z = true;
                }
                if (z) {
                    aVar3.b().setValue(5);
                } else {
                    aVar3.b().setValue(1);
                }
            }
        }
    }
}
