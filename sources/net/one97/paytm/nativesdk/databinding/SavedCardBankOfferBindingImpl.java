package net.one97.paytm.nativesdk.databinding;

import android.text.SpannableString;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import androidx.databinding.i;
import net.one97.paytm.nativesdk.BR;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.orflow.transaction.savedcard.BankOfferSavedCardViewModel;

public class SavedCardBankOfferBindingImpl extends SavedCardBankOfferBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private OnCheckedChangeListenerImpl mSaveCardModelOneClickChangedAndroidWidgetCompoundButtonOnCheckedChangeListener;
    private final LinearLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.llEmiView, 8);
        sViewsWithIds.put(R.id.tvEmiBankName, 9);
        sViewsWithIds.put(R.id.tvEmiPlanDetail, 10);
        sViewsWithIds.put(R.id.tvPlanTotalAmount, 11);
        sViewsWithIds.put(R.id.txtamount, 12);
        sViewsWithIds.put(R.id.iv_saved_card, 13);
        sViewsWithIds.put(R.id.tv_emi_availbale, 14);
        sViewsWithIds.put(R.id.pb_selectPlan, 15);
        sViewsWithIds.put(R.id.emi_details_layout, 16);
        sViewsWithIds.put(R.id.txt_emi_details, 17);
        sViewsWithIds.put(R.id.imgEmiCross, 18);
        sViewsWithIds.put(R.id.tv_total_amount, 19);
        sViewsWithIds.put(R.id.tv_change_plan, 20);
        sViewsWithIds.put(R.id.two_mode_auth_layout, 21);
        sViewsWithIds.put(R.id.rb_saved_card_atm_pin, 22);
        sViewsWithIds.put(R.id.txtAtmPinText, 23);
        sViewsWithIds.put(R.id.rb_saved_card_otp, 24);
        sViewsWithIds.put(R.id.txtOtpText, 25);
        sViewsWithIds.put(R.id.cvv_layout, 26);
        sViewsWithIds.put(R.id.etCvv, 27);
        sViewsWithIds.put(R.id.tvOneClickMsg, 28);
        sViewsWithIds.put(R.id.icon_vscpInfo, 29);
        sViewsWithIds.put(R.id.tvOneClickEnabled, 30);
        sViewsWithIds.put(R.id.tvOneClickDetail, 31);
        sViewsWithIds.put(R.id.txtErrMsg, 32);
        sViewsWithIds.put(R.id.tv_promo_message, 33);
        sViewsWithIds.put(R.id.tv_subventionOffer, 34);
    }

    public SavedCardBankOfferBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 35, sIncludes, sViewsWithIds));
    }

    private SavedCardBankOfferBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 8, objArr[4], objArr[26], objArr[16], objArr[27], objArr[29], objArr[18], objArr[13], objArr[8], objArr[3], objArr[15], objArr[1], objArr[22], objArr[24], objArr[5], objArr[2], objArr[7], objArr[6], objArr[20], objArr[14], objArr[9], objArr[10], objArr[31], objArr[30], objArr[28], objArr[11], objArr[33], objArr[34], objArr[19], objArr[21], objArr[23], objArr[17], objArr[32], objArr[25], objArr[12]);
        this.mDirtyFlags = -1;
        this.cbOneClick.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.oneClickContainer.setTag((Object) null);
        this.rbCardNumber.setTag((Object) null);
        this.textViewLowSuccess.setTag((Object) null);
        this.tvBankName.setTag((Object) null);
        this.tvBankOffer.setTag((Object) null);
        this.tvBankOfferApplicable.setTag((Object) null);
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
        if (BR.saveCardModel == i2) {
            setSaveCardModel((BankOfferSavedCardViewModel) obj);
        } else if (BR.view != i2) {
            return false;
        } else {
            setView((View) obj);
        }
        return true;
    }

    public void setSaveCardModel(BankOfferSavedCardViewModel bankOfferSavedCardViewModel) {
        updateRegistration(1, (h) bankOfferSavedCardViewModel);
        this.mSaveCardModel = bankOfferSavedCardViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.saveCardModel);
        super.requestRebind();
    }

    public void setView(View view) {
        this.mView = view;
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return onChangeSaveCardModelBankOfferText((i) obj, i3);
            case 1:
                return onChangeSaveCardModel((BankOfferSavedCardViewModel) obj, i3);
            case 2:
                return onChangeSaveCardModelLowSuccess((ObservableInt) obj, i3);
            case 3:
                return onChangeSaveCardModelBankName((i) obj, i3);
            case 4:
                return onChangeSaveCardModelCardNumber((i) obj, i3);
            case 5:
                return onChangeSaveCardModelShowVisaOneClick((ObservableInt) obj, i3);
            case 6:
                return onChangeSaveCardModelIsSingleVisaClickChecked((ObservableBoolean) obj, i3);
            case 7:
                return onChangeSaveCardModelOfferApplicableText((i) obj, i3);
            default:
                return false;
        }
    }

    private boolean onChangeSaveCardModelBankOfferText(i<SpannableString> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeSaveCardModel(BankOfferSavedCardViewModel bankOfferSavedCardViewModel, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeSaveCardModelLowSuccess(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeSaveCardModelBankName(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeSaveCardModelCardNumber(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeSaveCardModelShowVisaOneClick(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeSaveCardModelIsSingleVisaClickChecked(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeSaveCardModelOfferApplicableText(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:112:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a6 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x013e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r32 = this;
            r1 = r32
            monitor-enter(r32)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x015b }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x015b }
            monitor-exit(r32)     // Catch:{ all -> 0x015b }
            net.one97.paytm.nativesdk.orflow.transaction.savedcard.BankOfferSavedCardViewModel r0 = r1.mSaveCardModel
            r6 = 767(0x2ff, double:3.79E-321)
            long r6 = r6 & r2
            r10 = 530(0x212, double:2.62E-321)
            r12 = 522(0x20a, double:2.58E-321)
            r14 = 546(0x222, double:2.7E-321)
            r16 = 518(0x206, double:2.56E-321)
            r18 = 514(0x202, double:2.54E-321)
            r20 = 515(0x203, double:2.544E-321)
            r22 = 578(0x242, double:2.856E-321)
            r8 = 0
            int r24 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r24 == 0) goto L_0x00f7
            long r6 = r2 & r20
            int r24 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r24 == 0) goto L_0x003a
            if (r0 == 0) goto L_0x002d
            androidx.databinding.i<android.text.SpannableString> r6 = r0.bankOfferText
            goto L_0x002e
        L_0x002d:
            r6 = 0
        L_0x002e:
            r1.updateRegistration((int) r8, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x003a
            java.lang.Object r6 = r6.get()
            android.text.SpannableString r6 = (android.text.SpannableString) r6
            goto L_0x003b
        L_0x003a:
            r6 = 0
        L_0x003b:
            long r24 = r2 & r16
            int r7 = (r24 > r4 ? 1 : (r24 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x0052
            if (r0 == 0) goto L_0x0046
            androidx.databinding.ObservableInt r7 = r0.lowSuccess
            goto L_0x0047
        L_0x0046:
            r7 = 0
        L_0x0047:
            r8 = 2
            r1.updateRegistration((int) r8, (androidx.databinding.h) r7)
            if (r7 == 0) goto L_0x0052
            int r8 = r7.get()
            goto L_0x0053
        L_0x0052:
            r8 = 0
        L_0x0053:
            long r25 = r2 & r12
            int r7 = (r25 > r4 ? 1 : (r25 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x006d
            if (r0 == 0) goto L_0x005e
            androidx.databinding.i<java.lang.String> r7 = r0.bankName
            goto L_0x005f
        L_0x005e:
            r7 = 0
        L_0x005f:
            r9 = 3
            r1.updateRegistration((int) r9, (androidx.databinding.h) r7)
            if (r7 == 0) goto L_0x006d
            java.lang.Object r7 = r7.get()
            r9 = r7
            java.lang.String r9 = (java.lang.String) r9
            goto L_0x006e
        L_0x006d:
            r9 = 0
        L_0x006e:
            long r26 = r2 & r10
            int r7 = (r26 > r4 ? 1 : (r26 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x0087
            if (r0 == 0) goto L_0x0079
            androidx.databinding.i<java.lang.String> r7 = r0.cardNumber
            goto L_0x007a
        L_0x0079:
            r7 = 0
        L_0x007a:
            r10 = 4
            r1.updateRegistration((int) r10, (androidx.databinding.h) r7)
            if (r7 == 0) goto L_0x0087
            java.lang.Object r7 = r7.get()
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x0088
        L_0x0087:
            r7 = 0
        L_0x0088:
            long r10 = r2 & r14
            int r28 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r28 == 0) goto L_0x009f
            if (r0 == 0) goto L_0x0093
            androidx.databinding.ObservableInt r10 = r0.showVisaOneClick
            goto L_0x0094
        L_0x0093:
            r10 = 0
        L_0x0094:
            r11 = 5
            r1.updateRegistration((int) r11, (androidx.databinding.h) r10)
            if (r10 == 0) goto L_0x009f
            int r10 = r10.get()
            goto L_0x00a0
        L_0x009f:
            r10 = 0
        L_0x00a0:
            long r28 = r2 & r18
            int r11 = (r28 > r4 ? 1 : (r28 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x00b8
            if (r0 == 0) goto L_0x00b8
            net.one97.paytm.nativesdk.databinding.SavedCardBankOfferBindingImpl$OnCheckedChangeListenerImpl r11 = r1.mSaveCardModelOneClickChangedAndroidWidgetCompoundButtonOnCheckedChangeListener
            if (r11 != 0) goto L_0x00b3
            net.one97.paytm.nativesdk.databinding.SavedCardBankOfferBindingImpl$OnCheckedChangeListenerImpl r11 = new net.one97.paytm.nativesdk.databinding.SavedCardBankOfferBindingImpl$OnCheckedChangeListenerImpl
            r11.<init>()
            r1.mSaveCardModelOneClickChangedAndroidWidgetCompoundButtonOnCheckedChangeListener = r11
        L_0x00b3:
            net.one97.paytm.nativesdk.databinding.SavedCardBankOfferBindingImpl$OnCheckedChangeListenerImpl r11 = r11.setValue(r0)
            goto L_0x00b9
        L_0x00b8:
            r11 = 0
        L_0x00b9:
            long r28 = r2 & r22
            int r30 = (r28 > r4 ? 1 : (r28 == r4 ? 0 : -1))
            if (r30 == 0) goto L_0x00d4
            if (r0 == 0) goto L_0x00c4
            androidx.databinding.ObservableBoolean r12 = r0.isSingleVisaClickChecked
            goto L_0x00c5
        L_0x00c4:
            r12 = 0
        L_0x00c5:
            r13 = 6
            r1.updateRegistration((int) r13, (androidx.databinding.h) r12)
            if (r12 == 0) goto L_0x00d4
            boolean r12 = r12.get()
            r24 = r12
            r12 = 642(0x282, double:3.17E-321)
            goto L_0x00d8
        L_0x00d4:
            r12 = 642(0x282, double:3.17E-321)
            r24 = 0
        L_0x00d8:
            long r30 = r2 & r12
            int r12 = (r30 > r4 ? 1 : (r30 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x00f4
            if (r0 == 0) goto L_0x00e3
            androidx.databinding.i<java.lang.String> r0 = r0.offerApplicableText
            goto L_0x00e4
        L_0x00e3:
            r0 = 0
        L_0x00e4:
            r12 = 7
            r1.updateRegistration((int) r12, (androidx.databinding.h) r0)
            if (r0 == 0) goto L_0x00f4
            java.lang.Object r0 = r0.get()
            java.lang.String r0 = (java.lang.String) r0
            r12 = r0
            r0 = r24
            goto L_0x00ff
        L_0x00f4:
            r0 = r24
            goto L_0x00fe
        L_0x00f7:
            r0 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
        L_0x00fe:
            r12 = 0
        L_0x00ff:
            long r22 = r2 & r22
            int r13 = (r22 > r4 ? 1 : (r22 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x010a
            android.widget.CheckBox r13 = r1.cbOneClick
            androidx.databinding.a.a.a(r13, r0)
        L_0x010a:
            long r18 = r2 & r18
            int r0 = (r18 > r4 ? 1 : (r18 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0115
            android.widget.CheckBox r0 = r1.cbOneClick
            r0.setOnCheckedChangeListener(r11)
        L_0x0115:
            long r13 = r2 & r14
            int r0 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0120
            android.widget.RelativeLayout r0 = r1.oneClickContainer
            r0.setVisibility(r10)
        L_0x0120:
            r10 = 522(0x20a, double:2.58E-321)
            long r10 = r10 & r2
            int r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x012c
            android.widget.RadioButton r0 = r1.rbCardNumber
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r9)
        L_0x012c:
            long r9 = r2 & r16
            int r0 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0137
            android.widget.TextView r0 = r1.textViewLowSuccess
            r0.setVisibility(r8)
        L_0x0137:
            r8 = 530(0x212, double:2.62E-321)
            long r8 = r8 & r2
            int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0143
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvBankName
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r7)
        L_0x0143:
            long r7 = r2 & r20
            int r0 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x014e
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvBankOffer
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r6)
        L_0x014e:
            r6 = 642(0x282, double:3.17E-321)
            long r2 = r2 & r6
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x015a
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvBankOfferApplicable
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r12)
        L_0x015a:
            return
        L_0x015b:
            r0 = move-exception
            monitor-exit(r32)     // Catch:{ all -> 0x015b }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.databinding.SavedCardBankOfferBindingImpl.executeBindings():void");
    }

    public static class OnCheckedChangeListenerImpl implements CompoundButton.OnCheckedChangeListener {
        private BankOfferSavedCardViewModel value;

        public OnCheckedChangeListenerImpl setValue(BankOfferSavedCardViewModel bankOfferSavedCardViewModel) {
            this.value = bankOfferSavedCardViewModel;
            if (bankOfferSavedCardViewModel == null) {
                return null;
            }
            return this;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.value.oneClickChanged(compoundButton, z);
        }
    }
}
