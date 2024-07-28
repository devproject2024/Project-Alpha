package net.one97.paytm.nativesdk.databinding;

import android.text.Editable;
import android.text.SpannableString;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.databinding.h;
import androidx.databinding.i;
import net.one97.paytm.nativesdk.BR;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.orflow.transaction.newcard.BankOffersNewCardViewModel;
import net.one97.paytm.nativesdk.widget.RoboTextView;

public class NewCardBankOffersBindingImpl extends NewCardBankOffersBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private OnCheckedChangeListenerImpl mDebitCardModelCheckBoxChangedAndroidWidgetCompoundButtonOnCheckedChangeListener;
    private OnClickListenerImpl1 mDebitCardModelCrossClickedAndroidViewViewOnClickListener;
    private AfterTextChangedImpl1 mDebitCardModelCvvBeforeTextChangeAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged;
    private AfterTextChangedImpl mDebitCardModelExpiryBeforeTextChangeAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged;
    private OnClickListenerImpl mDebitCardModelHelpClickedAndroidViewViewOnClickListener;
    private OnCheckedChangeListenerImpl1 mDebitCardModelOneClickChangedAndroidWidgetCompoundButtonOnCheckedChangeListener;
    private long mDirtyFlags;
    private final LinearLayout mboundView14;
    private final CheckBox mboundView15;
    private final LinearLayout mboundView3;
    private final RoboTextView mboundView7;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.newCardContainer, 19);
        sViewsWithIds.put(R.id.tv_enter_card_number, 20);
        sViewsWithIds.put(R.id.etCardNumber, 21);
        sViewsWithIds.put(R.id.iv_card_logo, 22);
        sViewsWithIds.put(R.id.tvExipary, 23);
        sViewsWithIds.put(R.id.tvCvv, 24);
        sViewsWithIds.put(R.id.tv_emi_availbale, 25);
        sViewsWithIds.put(R.id.pb_selectPlan, 26);
        sViewsWithIds.put(R.id.emi_details_layout, 27);
        sViewsWithIds.put(R.id.txt_emi_details, 28);
        sViewsWithIds.put(R.id.imgEmiCross, 29);
        sViewsWithIds.put(R.id.tv_total_amount, 30);
        sViewsWithIds.put(R.id.tv_change_plan, 31);
        sViewsWithIds.put(R.id.otpTopLayout, 32);
        sViewsWithIds.put(R.id.otp_cvv_layout, 33);
        sViewsWithIds.put(R.id.txtErrMsg, 34);
        sViewsWithIds.put(R.id.tv_subventionOffer, 35);
    }

    public NewCardBankOffersBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 36, sIncludes, sViewsWithIds));
    }

    private NewCardBankOffersBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 12, objArr[11], objArr[27], objArr[21], objArr[5], objArr[2], objArr[16], objArr[9], objArr[29], objArr[22], objArr[1], objArr[19], objArr[8], objArr[33], objArr[32], objArr[26], objArr[0], objArr[18], objArr[31], objArr[24], objArr[4], objArr[25], objArr[20], objArr[23], objArr[10], objArr[12], objArr[13], objArr[17], objArr[6], objArr[35], objArr[30], objArr[28], objArr[34]);
        this.mDirtyFlags = -1;
        this.cbOneClick.setTag((Object) null);
        this.etCvv.setTag((Object) null);
        this.etExpiryValidity.setTag((Object) null);
        this.etOtpCVV.setTag((Object) null);
        this.iconVscpInfo.setTag((Object) null);
        this.ivCross.setTag((Object) null);
        this.mboundView14 = objArr[14];
        this.mboundView14.setTag((Object) null);
        this.mboundView15 = objArr[15];
        this.mboundView15.setTag((Object) null);
        this.mboundView3 = objArr[3];
        this.mboundView3.setTag((Object) null);
        this.mboundView7 = objArr[7];
        this.mboundView7.setTag((Object) null);
        this.oneClickContainer.setTag((Object) null);
        this.toplayout.setTag((Object) null);
        this.tvBankOffer.setTag((Object) null);
        this.tvCvvHelp.setTag((Object) null);
        this.tvOneClickEnabled.setTag((Object) null);
        this.tvOneClickMsg.setTag((Object) null);
        this.tvOneClickViewDetails.setTag((Object) null);
        this.tvOtpCvvHelp.setTag((Object) null);
        this.tvPromoMessage.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8192;
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
        if (BR.view == i2) {
            setView((View) obj);
        } else if (BR.debitCardModel != i2) {
            return false;
        } else {
            setDebitCardModel((BankOffersNewCardViewModel) obj);
        }
        return true;
    }

    public void setView(View view) {
        this.mView = view;
    }

    public void setDebitCardModel(BankOffersNewCardViewModel bankOffersNewCardViewModel) {
        updateRegistration(1, (h) bankOffersNewCardViewModel);
        this.mDebitCardModel = bankOffersNewCardViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.debitCardModel);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return onChangeDebitCardModelIsVisaCardEnrolled((ObservableBoolean) obj, i3);
            case 1:
                return onChangeDebitCardModel((BankOffersNewCardViewModel) obj, i3);
            case 2:
                return onChangeDebitCardModelAddMoneySaveCardVisibility((ObservableBoolean) obj, i3);
            case 3:
                return onChangeDebitCardModelBankOfferText((i) obj, i3);
            case 4:
                return onChangeDebitCardModelLowSuccessRateVisibility((ObservableInt) obj, i3);
            case 5:
                return onChangeDebitCardModelLowSuccessRateText((i) obj, i3);
            case 6:
                return onChangeDebitCardModelSavedCardCheckValue((ObservableBoolean) obj, i3);
            case 7:
                return onChangeDebitCardModelPromoCodeVisibility((ObservableInt) obj, i3);
            case 8:
                return onChangeDebitCardModelNewCardCVVVisibility((ObservableInt) obj, i3);
            case 9:
                return onChangeDebitCardModelShowVisaOneClick((ObservableInt) obj, i3);
            case 10:
                return onChangeDebitCardModelPromoCodeText((i) obj, i3);
            case 11:
                return onChangeDebitCardModelIsSingleVisaClickChecked((ObservableBoolean) obj, i3);
            default:
                return false;
        }
    }

    private boolean onChangeDebitCardModelIsVisaCardEnrolled(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeDebitCardModel(BankOffersNewCardViewModel bankOffersNewCardViewModel, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeDebitCardModelAddMoneySaveCardVisibility(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeDebitCardModelBankOfferText(i<SpannableString> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeDebitCardModelLowSuccessRateVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeDebitCardModelLowSuccessRateText(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeDebitCardModelSavedCardCheckValue(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeDebitCardModelPromoCodeVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    private boolean onChangeDebitCardModelNewCardCVVVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        return true;
    }

    private boolean onChangeDebitCardModelShowVisaOneClick(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        return true;
    }

    private boolean onChangeDebitCardModelPromoCodeText(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1024;
        }
        return true;
    }

    private boolean onChangeDebitCardModelIsSingleVisaClickChecked(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2048;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x01a1  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01db  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x01e8  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x01fe  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x020b  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0223  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x022e  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0150  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r56 = this;
            r1 = r56
            monitor-enter(r56)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x0359 }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x0359 }
            monitor-exit(r56)     // Catch:{ all -> 0x0359 }
            net.one97.paytm.nativesdk.orflow.transaction.newcard.BankOffersNewCardViewModel r0 = r1.mDebitCardModel
            r6 = 12287(0x2fff, double:6.0706E-320)
            long r6 = r6 & r2
            r16 = 8258(0x2042, double:4.08E-320)
            r18 = 8202(0x200a, double:4.0523E-320)
            r20 = 8198(0x2006, double:4.0504E-320)
            r22 = 8194(0x2002, double:4.0484E-320)
            r24 = 10242(0x2802, double:5.06E-320)
            r26 = 8195(0x2003, double:4.049E-320)
            r12 = 0
            int r30 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r30 == 0) goto L_0x0262
            long r6 = r2 & r26
            int r31 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r31 == 0) goto L_0x006a
            if (r0 == 0) goto L_0x002b
            androidx.databinding.ObservableBoolean r6 = r0.isVisaCardEnrolled_
            goto L_0x002c
        L_0x002b:
            r6 = 0
        L_0x002c:
            r1.updateRegistration((int) r12, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x0036
            boolean r6 = r6.get()
            goto L_0x0037
        L_0x0036:
            r6 = 0
        L_0x0037:
            r7 = r6 ^ 1
            r12 = 1
            if (r6 != r12) goto L_0x003d
            goto L_0x003e
        L_0x003d:
            r12 = 0
        L_0x003e:
            if (r31 == 0) goto L_0x004b
            if (r7 == 0) goto L_0x0046
            r33 = 131072(0x20000, double:6.47582E-319)
            goto L_0x0049
        L_0x0046:
            r33 = 65536(0x10000, double:3.2379E-319)
        L_0x0049:
            long r2 = r2 | r33
        L_0x004b:
            long r33 = r2 & r26
            int r6 = (r33 > r4 ? 1 : (r33 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x005c
            if (r12 == 0) goto L_0x0057
            r33 = 2097152(0x200000, double:1.0361308E-317)
            goto L_0x005a
        L_0x0057:
            r33 = 1048576(0x100000, double:5.180654E-318)
        L_0x005a:
            long r2 = r2 | r33
        L_0x005c:
            if (r7 == 0) goto L_0x0061
            r6 = 8
            goto L_0x0062
        L_0x0061:
            r6 = 0
        L_0x0062:
            if (r12 == 0) goto L_0x0067
            r7 = 8
            goto L_0x0068
        L_0x0067:
            r7 = 0
        L_0x0068:
            r12 = r7
            goto L_0x006c
        L_0x006a:
            r6 = 0
            r12 = 0
        L_0x006c:
            long r33 = r2 & r22
            int r7 = (r33 > r4 ? 1 : (r33 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x00d4
            if (r0 == 0) goto L_0x00d4
            net.one97.paytm.nativesdk.databinding.NewCardBankOffersBindingImpl$OnCheckedChangeListenerImpl r7 = r1.mDebitCardModelCheckBoxChangedAndroidWidgetCompoundButtonOnCheckedChangeListener
            if (r7 != 0) goto L_0x007f
            net.one97.paytm.nativesdk.databinding.NewCardBankOffersBindingImpl$OnCheckedChangeListenerImpl r7 = new net.one97.paytm.nativesdk.databinding.NewCardBankOffersBindingImpl$OnCheckedChangeListenerImpl
            r7.<init>()
            r1.mDebitCardModelCheckBoxChangedAndroidWidgetCompoundButtonOnCheckedChangeListener = r7
        L_0x007f:
            net.one97.paytm.nativesdk.databinding.NewCardBankOffersBindingImpl$OnCheckedChangeListenerImpl r7 = r7.setValue(r0)
            net.one97.paytm.nativesdk.databinding.NewCardBankOffersBindingImpl$AfterTextChangedImpl r13 = r1.mDebitCardModelExpiryBeforeTextChangeAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged
            if (r13 != 0) goto L_0x008e
            net.one97.paytm.nativesdk.databinding.NewCardBankOffersBindingImpl$AfterTextChangedImpl r13 = new net.one97.paytm.nativesdk.databinding.NewCardBankOffersBindingImpl$AfterTextChangedImpl
            r13.<init>()
            r1.mDebitCardModelExpiryBeforeTextChangeAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged = r13
        L_0x008e:
            net.one97.paytm.nativesdk.databinding.NewCardBankOffersBindingImpl$AfterTextChangedImpl r13 = r13.setValue(r0)
            net.one97.paytm.nativesdk.databinding.NewCardBankOffersBindingImpl$OnClickListenerImpl r8 = r1.mDebitCardModelHelpClickedAndroidViewViewOnClickListener
            if (r8 != 0) goto L_0x009d
            net.one97.paytm.nativesdk.databinding.NewCardBankOffersBindingImpl$OnClickListenerImpl r8 = new net.one97.paytm.nativesdk.databinding.NewCardBankOffersBindingImpl$OnClickListenerImpl
            r8.<init>()
            r1.mDebitCardModelHelpClickedAndroidViewViewOnClickListener = r8
        L_0x009d:
            net.one97.paytm.nativesdk.databinding.NewCardBankOffersBindingImpl$OnClickListenerImpl r8 = r8.setValue(r0)
            net.one97.paytm.nativesdk.databinding.NewCardBankOffersBindingImpl$AfterTextChangedImpl1 r9 = r1.mDebitCardModelCvvBeforeTextChangeAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged
            if (r9 != 0) goto L_0x00ac
            net.one97.paytm.nativesdk.databinding.NewCardBankOffersBindingImpl$AfterTextChangedImpl1 r9 = new net.one97.paytm.nativesdk.databinding.NewCardBankOffersBindingImpl$AfterTextChangedImpl1
            r9.<init>()
            r1.mDebitCardModelCvvBeforeTextChangeAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged = r9
        L_0x00ac:
            net.one97.paytm.nativesdk.databinding.NewCardBankOffersBindingImpl$AfterTextChangedImpl1 r9 = r9.setValue(r0)
            net.one97.paytm.nativesdk.databinding.NewCardBankOffersBindingImpl$OnCheckedChangeListenerImpl1 r10 = r1.mDebitCardModelOneClickChangedAndroidWidgetCompoundButtonOnCheckedChangeListener
            if (r10 != 0) goto L_0x00bb
            net.one97.paytm.nativesdk.databinding.NewCardBankOffersBindingImpl$OnCheckedChangeListenerImpl1 r10 = new net.one97.paytm.nativesdk.databinding.NewCardBankOffersBindingImpl$OnCheckedChangeListenerImpl1
            r10.<init>()
            r1.mDebitCardModelOneClickChangedAndroidWidgetCompoundButtonOnCheckedChangeListener = r10
        L_0x00bb:
            net.one97.paytm.nativesdk.databinding.NewCardBankOffersBindingImpl$OnCheckedChangeListenerImpl1 r10 = r10.setValue(r0)
            net.one97.paytm.nativesdk.databinding.NewCardBankOffersBindingImpl$OnClickListenerImpl1 r11 = r1.mDebitCardModelCrossClickedAndroidViewViewOnClickListener
            if (r11 != 0) goto L_0x00ca
            net.one97.paytm.nativesdk.databinding.NewCardBankOffersBindingImpl$OnClickListenerImpl1 r11 = new net.one97.paytm.nativesdk.databinding.NewCardBankOffersBindingImpl$OnClickListenerImpl1
            r11.<init>()
            r1.mDebitCardModelCrossClickedAndroidViewViewOnClickListener = r11
        L_0x00ca:
            net.one97.paytm.nativesdk.databinding.NewCardBankOffersBindingImpl$OnClickListenerImpl1 r11 = r11.setValue(r0)
            r55 = r13
            r13 = r7
            r7 = r55
            goto L_0x00da
        L_0x00d4:
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r13 = 0
        L_0x00da:
            long r37 = r2 & r20
            int r39 = (r37 > r4 ? 1 : (r37 == r4 ? 0 : -1))
            if (r39 == 0) goto L_0x0115
            if (r0 == 0) goto L_0x00e5
            androidx.databinding.ObservableBoolean r14 = r0.addMoneySaveCardVisibility
            goto L_0x00e6
        L_0x00e5:
            r14 = 0
        L_0x00e6:
            r15 = 2
            r1.updateRegistration((int) r15, (androidx.databinding.h) r14)
            if (r14 == 0) goto L_0x00f1
            boolean r14 = r14.get()
            goto L_0x00f2
        L_0x00f1:
            r14 = 0
        L_0x00f2:
            if (r39 == 0) goto L_0x0108
            if (r14 == 0) goto L_0x00ff
            r39 = 32768(0x8000, double:1.61895E-319)
            long r2 = r2 | r39
            r39 = 524288(0x80000, double:2.590327E-318)
            goto L_0x0106
        L_0x00ff:
            r39 = 16384(0x4000, double:8.0948E-320)
            long r2 = r2 | r39
            r39 = 262144(0x40000, double:1.295163E-318)
        L_0x0106:
            long r2 = r2 | r39
        L_0x0108:
            if (r14 == 0) goto L_0x010d
            r15 = 8
            goto L_0x010e
        L_0x010d:
            r15 = 0
        L_0x010e:
            if (r14 == 0) goto L_0x0112
            r14 = 0
            goto L_0x0117
        L_0x0112:
            r14 = 8
            goto L_0x0117
        L_0x0115:
            r14 = 0
            r15 = 0
        L_0x0117:
            long r39 = r2 & r18
            int r41 = (r39 > r4 ? 1 : (r39 == r4 ? 0 : -1))
            if (r41 == 0) goto L_0x0130
            if (r0 == 0) goto L_0x0122
            androidx.databinding.i<android.text.SpannableString> r4 = r0.bankOfferText
            goto L_0x0123
        L_0x0122:
            r4 = 0
        L_0x0123:
            r5 = 3
            r1.updateRegistration((int) r5, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x0130
            java.lang.Object r4 = r4.get()
            android.text.SpannableString r4 = (android.text.SpannableString) r4
            goto L_0x0131
        L_0x0130:
            r4 = 0
        L_0x0131:
            r37 = 8210(0x2012, double:4.0563E-320)
            long r41 = r2 & r37
            r39 = 0
            int r5 = (r41 > r39 ? 1 : (r41 == r39 ? 0 : -1))
            if (r5 == 0) goto L_0x0150
            if (r0 == 0) goto L_0x0142
            androidx.databinding.ObservableInt r5 = r0.lowSuccessRateVisibility
            r41 = r4
            goto L_0x0145
        L_0x0142:
            r41 = r4
            r5 = 0
        L_0x0145:
            r4 = 4
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x0152
            int r4 = r5.get()
            goto L_0x0153
        L_0x0150:
            r41 = r4
        L_0x0152:
            r4 = 0
        L_0x0153:
            r35 = 8226(0x2022, double:4.064E-320)
            long r42 = r2 & r35
            r39 = 0
            int r5 = (r42 > r39 ? 1 : (r42 == r39 ? 0 : -1))
            if (r5 == 0) goto L_0x0174
            if (r0 == 0) goto L_0x0164
            androidx.databinding.i<java.lang.String> r5 = r0.lowSuccessRateText
            r42 = r4
            goto L_0x0167
        L_0x0164:
            r42 = r4
            r5 = 0
        L_0x0167:
            r4 = 5
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x0176
            java.lang.Object r4 = r5.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0177
        L_0x0174:
            r42 = r4
        L_0x0176:
            r4 = 0
        L_0x0177:
            long r43 = r2 & r16
            r39 = 0
            int r5 = (r43 > r39 ? 1 : (r43 == r39 ? 0 : -1))
            if (r5 == 0) goto L_0x0194
            if (r0 == 0) goto L_0x0186
            androidx.databinding.ObservableBoolean r5 = r0.savedCardCheckValue
            r43 = r4
            goto L_0x0189
        L_0x0186:
            r43 = r4
            r5 = 0
        L_0x0189:
            r4 = 6
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x0196
            boolean r4 = r5.get()
            goto L_0x0197
        L_0x0194:
            r43 = r4
        L_0x0196:
            r4 = 0
        L_0x0197:
            r33 = 8322(0x2082, double:4.1116E-320)
            long r44 = r2 & r33
            r39 = 0
            int r5 = (r44 > r39 ? 1 : (r44 == r39 ? 0 : -1))
            if (r5 == 0) goto L_0x01b6
            if (r0 == 0) goto L_0x01a8
            androidx.databinding.ObservableInt r5 = r0.promoCodeVisibility
            r44 = r4
            goto L_0x01ab
        L_0x01a8:
            r44 = r4
            r5 = 0
        L_0x01ab:
            r4 = 7
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x01b8
            int r4 = r5.get()
            goto L_0x01b9
        L_0x01b6:
            r44 = r4
        L_0x01b8:
            r4 = 0
        L_0x01b9:
            r28 = 8450(0x2102, double:4.175E-320)
            long r45 = r2 & r28
            r39 = 0
            int r5 = (r45 > r39 ? 1 : (r45 == r39 ? 0 : -1))
            if (r5 == 0) goto L_0x01db
            if (r0 == 0) goto L_0x01cc
            androidx.databinding.ObservableInt r5 = r0.newCardCVVVisibility
            r31 = r4
            r4 = 8
            goto L_0x01d1
        L_0x01cc:
            r31 = r4
            r4 = 8
            r5 = 0
        L_0x01d1:
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x01dd
            int r4 = r5.get()
            goto L_0x01de
        L_0x01db:
            r31 = r4
        L_0x01dd:
            r4 = 0
        L_0x01de:
            r45 = 8706(0x2202, double:4.3013E-320)
            long r45 = r2 & r45
            r39 = 0
            int r5 = (r45 > r39 ? 1 : (r45 == r39 ? 0 : -1))
            if (r5 == 0) goto L_0x01fe
            if (r0 == 0) goto L_0x01ef
            androidx.databinding.ObservableInt r5 = r0.showVisaOneClick
            r45 = r4
            goto L_0x01f2
        L_0x01ef:
            r45 = r4
            r5 = 0
        L_0x01f2:
            r4 = 9
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x0200
            int r4 = r5.get()
            goto L_0x0201
        L_0x01fe:
            r45 = r4
        L_0x0200:
            r4 = 0
        L_0x0201:
            r46 = 9218(0x2402, double:4.5543E-320)
            long r46 = r2 & r46
            r39 = 0
            int r5 = (r46 > r39 ? 1 : (r46 == r39 ? 0 : -1))
            if (r5 == 0) goto L_0x0223
            if (r0 == 0) goto L_0x0212
            androidx.databinding.i<java.lang.String> r5 = r0.promoCodeText
            r46 = r4
            goto L_0x0215
        L_0x0212:
            r46 = r4
            r5 = 0
        L_0x0215:
            r4 = 10
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x0225
            java.lang.Object r4 = r5.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0226
        L_0x0223:
            r46 = r4
        L_0x0225:
            r4 = 0
        L_0x0226:
            long r47 = r2 & r24
            r39 = 0
            int r5 = (r47 > r39 ? 1 : (r47 == r39 ? 0 : -1))
            if (r5 == 0) goto L_0x0250
            if (r0 == 0) goto L_0x0233
            androidx.databinding.ObservableBoolean r0 = r0.isSingleVisaClickChecked
            goto L_0x0234
        L_0x0233:
            r0 = 0
        L_0x0234:
            r5 = 11
            r1.updateRegistration((int) r5, (androidx.databinding.h) r0)
            if (r0 == 0) goto L_0x0250
            boolean r0 = r0.get()
            r53 = r4
            r54 = r31
            r52 = r41
            r50 = r42
            r49 = r43
            r4 = r44
            r5 = r45
            r51 = r46
            goto L_0x027b
        L_0x0250:
            r53 = r4
            r54 = r31
            r52 = r41
            r50 = r42
            r49 = r43
            r4 = r44
            r5 = r45
            r51 = r46
            r0 = 0
            goto L_0x027b
        L_0x0262:
            r0 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r49 = 0
            r50 = 0
            r51 = 0
            r52 = 0
            r53 = 0
            r54 = 0
        L_0x027b:
            long r26 = r2 & r26
            r31 = 0
            int r41 = (r26 > r31 ? 1 : (r26 == r31 ? 0 : -1))
            r26 = r5
            if (r41 == 0) goto L_0x029e
            android.widget.CheckBox r5 = r1.cbOneClick
            r5.setVisibility(r12)
            android.widget.ImageView r5 = r1.iconVscpInfo
            r5.setVisibility(r6)
            android.widget.TextView r5 = r1.tvOneClickEnabled
            r5.setVisibility(r6)
            android.widget.TextView r5 = r1.tvOneClickMsg
            r5.setVisibility(r12)
            android.widget.TextView r5 = r1.tvOneClickViewDetails
            r5.setVisibility(r12)
        L_0x029e:
            long r5 = r2 & r24
            r24 = 0
            int r12 = (r5 > r24 ? 1 : (r5 == r24 ? 0 : -1))
            if (r12 == 0) goto L_0x02ab
            android.widget.CheckBox r5 = r1.cbOneClick
            androidx.databinding.a.a.a(r5, r0)
        L_0x02ab:
            long r5 = r2 & r22
            int r0 = (r5 > r24 ? 1 : (r5 == r24 ? 0 : -1))
            if (r0 == 0) goto L_0x02da
            android.widget.CheckBox r0 = r1.cbOneClick
            r0.setOnCheckedChangeListener(r10)
            android.widget.EditText r0 = r1.etCvv
            r5 = 0
            androidx.databinding.a.d.a(r0, r5, r9, r5)
            android.widget.EditText r0 = r1.etExpiryValidity
            androidx.databinding.a.d.a(r0, r5, r7, r5)
            android.widget.EditText r0 = r1.etOtpCVV
            androidx.databinding.a.d.a(r0, r5, r9, r5)
            android.widget.ImageView r0 = r1.ivCross
            r0.setOnClickListener(r11)
            android.widget.CheckBox r0 = r1.mboundView15
            r0.setOnCheckedChangeListener(r13)
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvCvvHelp
            r0.setOnClickListener(r8)
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvOtpCvvHelp
            r0.setOnClickListener(r8)
        L_0x02da:
            long r5 = r2 & r20
            r7 = 0
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x02ec
            android.widget.LinearLayout r0 = r1.mboundView14
            r0.setVisibility(r15)
            android.widget.CheckBox r0 = r1.mboundView15
            r0.setVisibility(r14)
        L_0x02ec:
            long r5 = r2 & r16
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x02f7
            android.widget.CheckBox r0 = r1.mboundView15
            androidx.databinding.a.a.a(r0, r4)
        L_0x02f7:
            r4 = 8450(0x2102, double:4.175E-320)
            long r4 = r4 & r2
            int r0 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x0305
            android.widget.LinearLayout r0 = r1.mboundView3
            r4 = r26
            r0.setVisibility(r4)
        L_0x0305:
            r4 = 8226(0x2022, double:4.064E-320)
            long r4 = r4 & r2
            int r0 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x0313
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.mboundView7
            r4 = r49
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
        L_0x0313:
            r4 = 8210(0x2012, double:4.0563E-320)
            long r4 = r4 & r2
            int r0 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x0321
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.mboundView7
            r4 = r50
            r0.setVisibility(r4)
        L_0x0321:
            r4 = 8706(0x2202, double:4.3013E-320)
            long r4 = r4 & r2
            int r0 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x032f
            android.widget.RelativeLayout r0 = r1.oneClickContainer
            r4 = r51
            r0.setVisibility(r4)
        L_0x032f:
            long r4 = r2 & r18
            int r0 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x033c
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvBankOffer
            r4 = r52
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
        L_0x033c:
            r4 = 9218(0x2402, double:4.5543E-320)
            long r4 = r4 & r2
            int r0 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x034a
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvPromoMessage
            r4 = r53
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
        L_0x034a:
            r4 = 8322(0x2082, double:4.1116E-320)
            long r2 = r2 & r4
            int r0 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x0358
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvPromoMessage
            r2 = r54
            r0.setVisibility(r2)
        L_0x0358:
            return
        L_0x0359:
            r0 = move-exception
            monitor-exit(r56)     // Catch:{ all -> 0x0359 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.databinding.NewCardBankOffersBindingImpl.executeBindings():void");
    }

    public static class OnCheckedChangeListenerImpl implements CompoundButton.OnCheckedChangeListener {
        private BankOffersNewCardViewModel value;

        public OnCheckedChangeListenerImpl setValue(BankOffersNewCardViewModel bankOffersNewCardViewModel) {
            this.value = bankOffersNewCardViewModel;
            if (bankOffersNewCardViewModel == null) {
                return null;
            }
            return this;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.value.checkBoxChanged(compoundButton, z);
        }
    }

    public static class AfterTextChangedImpl implements d.a {
        private BankOffersNewCardViewModel value;

        public AfterTextChangedImpl setValue(BankOffersNewCardViewModel bankOffersNewCardViewModel) {
            this.value = bankOffersNewCardViewModel;
            if (bankOffersNewCardViewModel == null) {
                return null;
            }
            return this;
        }

        public void afterTextChanged(Editable editable) {
            this.value.expiryBeforeTextChange(editable);
        }
    }

    public static class OnClickListenerImpl implements View.OnClickListener {
        private BankOffersNewCardViewModel value;

        public OnClickListenerImpl setValue(BankOffersNewCardViewModel bankOffersNewCardViewModel) {
            this.value = bankOffersNewCardViewModel;
            if (bankOffersNewCardViewModel == null) {
                return null;
            }
            return this;
        }

        public void onClick(View view) {
            this.value.helpClicked(view);
        }
    }

    public static class AfterTextChangedImpl1 implements d.a {
        private BankOffersNewCardViewModel value;

        public AfterTextChangedImpl1 setValue(BankOffersNewCardViewModel bankOffersNewCardViewModel) {
            this.value = bankOffersNewCardViewModel;
            if (bankOffersNewCardViewModel == null) {
                return null;
            }
            return this;
        }

        public void afterTextChanged(Editable editable) {
            this.value.cvvBeforeTextChange(editable);
        }
    }

    public static class OnCheckedChangeListenerImpl1 implements CompoundButton.OnCheckedChangeListener {
        private BankOffersNewCardViewModel value;

        public OnCheckedChangeListenerImpl1 setValue(BankOffersNewCardViewModel bankOffersNewCardViewModel) {
            this.value = bankOffersNewCardViewModel;
            if (bankOffersNewCardViewModel == null) {
                return null;
            }
            return this;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.value.oneClickChanged(compoundButton, z);
        }
    }

    public static class OnClickListenerImpl1 implements View.OnClickListener {
        private BankOffersNewCardViewModel value;

        public OnClickListenerImpl1 setValue(BankOffersNewCardViewModel bankOffersNewCardViewModel) {
            this.value = bankOffersNewCardViewModel;
            if (bankOffersNewCardViewModel == null) {
                return null;
            }
            return this;
        }

        public void onClick(View view) {
            this.value.crossClicked(view);
        }
    }
}
