package net.one97.paytm.nativesdk.databinding;

import android.text.Editable;
import android.text.SpannableString;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.databinding.h;
import androidx.databinding.i;
import net.one97.paytm.nativesdk.BR;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.instruments.upicollect.viewmodel.UpiCollectViewModelNew;

public class UpiCollectLayoutNewBindingImpl extends UpiCollectLayoutNewBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private OnClickListenerImpl1 mUpiCollectModelBhimUpiClickedAndroidViewViewOnClickListener;
    private OnClickListenerImpl mUpiCollectModelCheckBankOffersClickAndroidViewViewOnClickListener;
    private OnClickListenerImpl5 mUpiCollectModelHowItWorksClickedAndroidViewViewOnClickListener;
    private OnClickListenerImpl4 mUpiCollectModelProceedToPayAndroidViewViewOnClickListener;
    private OnClickListenerImpl2 mUpiCollectModelProceedToPayUpiAndroidViewViewOnClickListener;
    private OnClickListenerImpl3 mUpiCollectModelVerifyVPAAndroidViewViewOnClickListener;
    private AfterTextChangedImpl mUpiCollectModelVpaAddressBeforeTextChangeAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged;
    private final LinearLayout mboundView0;
    private final TextView mboundView12;
    private final RelativeLayout mboundView13;
    private final ImageView mboundView21;
    private final TextView mboundView29;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.et_dummy, 30);
        sViewsWithIds.put(R.id.txtBhimUpi, 31);
        sViewsWithIds.put(R.id.tv_promotion, 32);
        sViewsWithIds.put(R.id.ivRightArrow, 33);
        sViewsWithIds.put(R.id.disableClickViewUpi, 34);
        sViewsWithIds.put(R.id.tvError, 35);
        sViewsWithIds.put(R.id.tv_select_upi_app, 36);
        sViewsWithIds.put(R.id.rv_upiApps, 37);
        sViewsWithIds.put(R.id.fl_loader1, 38);
        sViewsWithIds.put(R.id.ltv_getOffers1, 39);
        sViewsWithIds.put(R.id.ltv_loading1, 40);
        sViewsWithIds.put(R.id.tv_or, 41);
        sViewsWithIds.put(R.id.tv_enter_upi_vpa, 42);
        sViewsWithIds.put(R.id.llVerifyVpaContainer, 43);
        sViewsWithIds.put(R.id.txtErrorMsg, 44);
        sViewsWithIds.put(R.id.tv_vpa_desc, 45);
        sViewsWithIds.put(R.id.tv_checkForOffers, 46);
        sViewsWithIds.put(R.id.ltv_getOffers, 47);
        sViewsWithIds.put(R.id.ltv_loading, 48);
    }

    public UpiCollectLayoutNewBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 49, sIncludes, sViewsWithIds));
    }

    private UpiCollectLayoutNewBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 29, objArr[27], objArr[10], objArr[1], objArr[34], objArr[30], objArr[15], objArr[23], objArr[38], objArr[33], objArr[17], objArr[20], objArr[24], objArr[7], objArr[5], objArr[43], objArr[47], objArr[39], objArr[48], objArr[40], objArr[28], objArr[11], objArr[2], objArr[37], objArr[14], objArr[22], objArr[46], objArr[25], objArr[8], objArr[26], objArr[9], objArr[19], objArr[6], objArr[42], objArr[35], objArr[41], objArr[32], objArr[36], objArr[16], objArr[45], objArr[31], objArr[44], objArr[4], objArr[3], objArr[18]);
        this.mDirtyFlags = -1;
        this.btnProceed.setTag((Object) null);
        this.btnProceed2.setTag((Object) null);
        this.cardTextLayout.setTag((Object) null);
        this.etUpiAddress.setTag((Object) null);
        this.flLoader.setTag((Object) null);
        this.ivVerified.setTag((Object) null);
        this.llCheckForOffers.setTag((Object) null);
        this.llCheckOffer.setTag((Object) null);
        this.llCheckOffer1.setTag((Object) null);
        this.llUpiIntent.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.mboundView12 = objArr[12];
        this.mboundView12.setTag((Object) null);
        this.mboundView13 = objArr[13];
        this.mboundView13.setTag((Object) null);
        this.mboundView21 = objArr[21];
        this.mboundView21.setTag((Object) null);
        this.mboundView29 = objArr[29];
        this.mboundView29.setTag((Object) null);
        this.paysecurely.setTag((Object) null);
        this.paysecurely2.setTag((Object) null);
        this.radioButton.setTag((Object) null);
        this.topLayout.setTag((Object) null);
        this.tvBankOffer.setTag((Object) null);
        this.tvCheckingOffers.setTag((Object) null);
        this.tvCheckingOffers1.setTag((Object) null);
        this.tvConvFee.setTag((Object) null);
        this.tvConvFee1.setTag((Object) null);
        this.tvDisableErrorMessageCollect.setTag((Object) null);
        this.tvDisableErrorMessageIntent.setTag((Object) null);
        this.tvVerifyVpa.setTag((Object) null);
        this.txtHowItWorks.setTag((Object) null);
        this.txtamount.setTag((Object) null);
        this.verifyProgressbar.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1073741824;
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
        } else if (BR.upiCollectModel != i2) {
            return false;
        } else {
            setUpiCollectModel((UpiCollectViewModelNew) obj);
        }
        return true;
    }

    public void setView(View view) {
        this.mView = view;
    }

    public void setUpiCollectModel(UpiCollectViewModelNew upiCollectViewModelNew) {
        updateRegistration(9, (h) upiCollectViewModelNew);
        this.mUpiCollectModel = upiCollectViewModelNew;
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        notifyPropertyChanged(BR.upiCollectModel);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return onChangeUpiCollectModelDisableMessageCollectVisibility((ObservableInt) obj, i3);
            case 1:
                return onChangeUpiCollectModelRadioChecked((ObservableBoolean) obj, i3);
            case 2:
                return onChangeUpiCollectModelUpiIntentSeparatorVisibility((ObservableInt) obj, i3);
            case 3:
                return onChangeUpiCollectModelCollectLoaderVisibility((ObservableInt) obj, i3);
            case 4:
                return onChangeUpiCollectModelIntentConvFeeTextVisibility((ObservableInt) obj, i3);
            case 5:
                return onChangeUpiCollectModelHowItWorksVisibility((ObservableInt) obj, i3);
            case 6:
                return onChangeUpiCollectModelTagImageVisibility((ObservableInt) obj, i3);
            case 7:
                return onChangeUpiCollectModelVerifiedProgressVisibility((ObservableInt) obj, i3);
            case 8:
                return onChangeUpiCollectModelBankOfferVisibility((ObservableInt) obj, i3);
            case 9:
                return onChangeUpiCollectModel((UpiCollectViewModelNew) obj, i3);
            case 10:
                return onChangeUpiCollectModelVerifiedIconVisibility((ObservableInt) obj, i3);
            case 11:
                return onChangeUpiCollectModelIntentLoaderVisibility((ObservableInt) obj, i3);
            case 12:
                return onChangeUpiCollectModelDisableMessage((i) obj, i3);
            case 13:
                return onChangeUpiCollectModelCollectConvFeeTextVisibility((ObservableInt) obj, i3);
            case 14:
                return onChangeUpiCollectModelCashBackTextVisibility((ObservableInt) obj, i3);
            case 15:
                return onChangeUpiCollectModelAmount((i) obj, i3);
            case 16:
                return onChangeUpiCollectModelIntentConvFeeText((i) obj, i3);
            case 17:
                return onChangeUpiCollectModelPaySecurelyText((i) obj, i3);
            case 18:
                return onChangeUpiCollectModelVerifyTextVisibility((ObservableInt) obj, i3);
            case 19:
                return onChangeUpiCollectModelCollectLoaderMsg((i) obj, i3);
            case 20:
                return onChangeUpiCollectModelCashBackText((i) obj, i3);
            case 21:
                return onChangeUpiCollectModelCollectConvFeeText((i) obj, i3);
            case 22:
                return onChangeUpiCollectModelBankOfferText((i) obj, i3);
            case 23:
                return onChangeUpiCollectModelUpiCollectVisibility((ObservableInt) obj, i3);
            case 24:
                return onChangeUpiCollectModelIsVerifyClickable((ObservableBoolean) obj, i3);
            case 25:
                return onChangeUpiCollectModelCheckOfferVisibility((ObservableInt) obj, i3);
            case 26:
                return onChangeUpiCollectModelDisableMessageIntentVisibility((ObservableInt) obj, i3);
            case 27:
                return onChangeUpiCollectModelIntentLoaderMsg((i) obj, i3);
            case 28:
                return onChangeUpiCollectModelVpaInputLayoutVisibility((ObservableInt) obj, i3);
            default:
                return false;
        }
    }

    private boolean onChangeUpiCollectModelDisableMessageCollectVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeUpiCollectModelRadioChecked(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeUpiCollectModelUpiIntentSeparatorVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeUpiCollectModelCollectLoaderVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeUpiCollectModelIntentConvFeeTextVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeUpiCollectModelHowItWorksVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeUpiCollectModelTagImageVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeUpiCollectModelVerifiedProgressVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    private boolean onChangeUpiCollectModelBankOfferVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        return true;
    }

    private boolean onChangeUpiCollectModel(UpiCollectViewModelNew upiCollectViewModelNew, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        return true;
    }

    private boolean onChangeUpiCollectModelVerifiedIconVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1024;
        }
        return true;
    }

    private boolean onChangeUpiCollectModelIntentLoaderVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2048;
        }
        return true;
    }

    private boolean onChangeUpiCollectModelDisableMessage(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4096;
        }
        return true;
    }

    private boolean onChangeUpiCollectModelCollectConvFeeTextVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8192;
        }
        return true;
    }

    private boolean onChangeUpiCollectModelCashBackTextVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16384;
        }
        return true;
    }

    private boolean onChangeUpiCollectModelAmount(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32768;
        }
        return true;
    }

    private boolean onChangeUpiCollectModelIntentConvFeeText(i<SpannableString> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 65536;
        }
        return true;
    }

    private boolean onChangeUpiCollectModelPaySecurelyText(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 131072;
        }
        return true;
    }

    private boolean onChangeUpiCollectModelVerifyTextVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 262144;
        }
        return true;
    }

    private boolean onChangeUpiCollectModelCollectLoaderMsg(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 524288;
        }
        return true;
    }

    private boolean onChangeUpiCollectModelCashBackText(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1048576;
        }
        return true;
    }

    private boolean onChangeUpiCollectModelCollectConvFeeText(i<SpannableString> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2097152;
        }
        return true;
    }

    private boolean onChangeUpiCollectModelBankOfferText(i<SpannableString> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4194304;
        }
        return true;
    }

    private boolean onChangeUpiCollectModelUpiCollectVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8388608;
        }
        return true;
    }

    private boolean onChangeUpiCollectModelIsVerifyClickable(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16777216;
        }
        return true;
    }

    private boolean onChangeUpiCollectModelCheckOfferVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 33554432;
        }
        return true;
    }

    private boolean onChangeUpiCollectModelDisableMessageIntentVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 67108864;
        }
        return true;
    }

    private boolean onChangeUpiCollectModelIntentLoaderMsg(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 134217728;
        }
        return true;
    }

    private boolean onChangeUpiCollectModelVpaInputLayoutVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 268435456;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0180  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x01a3  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01bb  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01cb  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x01e1  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x01ef  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0205  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0213  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x023e  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x024e  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0266  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0274  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x028e  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x029f  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x02b5  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x02c3  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x02db  */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x02e9  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x0301  */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x030f  */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x0327  */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x0335  */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x034b  */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x0359  */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x0371  */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x037f  */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x0397  */
    /* JADX WARNING: Removed duplicated region for block: B:249:0x03a5  */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x03bd  */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x03cb  */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x03e3  */
    /* JADX WARNING: Removed duplicated region for block: B:269:0x03f1  */
    /* JADX WARNING: Removed duplicated region for block: B:275:0x0407  */
    /* JADX WARNING: Removed duplicated region for block: B:279:0x0415  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005e A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:285:0x042b  */
    /* JADX WARNING: Removed duplicated region for block: B:289:0x0439  */
    /* JADX WARNING: Removed duplicated region for block: B:295:0x044f  */
    /* JADX WARNING: Removed duplicated region for block: B:299:0x045d  */
    /* JADX WARNING: Removed duplicated region for block: B:305:0x0475  */
    /* JADX WARNING: Removed duplicated region for block: B:309:0x0483  */
    /* JADX WARNING: Removed duplicated region for block: B:315:0x04cd  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x015d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r86 = this;
            r1 = r86
            monitor-enter(r86)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x078f }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x078f }
            monitor-exit(r86)     // Catch:{ all -> 0x078f }
            net.one97.paytm.nativesdk.instruments.upicollect.viewmodel.UpiCollectViewModelNew r0 = r1.mUpiCollectModel
            r6 = 1610612735(0x5fffffff, double:7.95748421E-315)
            long r6 = r6 & r2
            r15 = 1073742340(0x40000204, double:5.304992027E-315)
            r19 = 1073742336(0x40000200, double:5.304992007E-315)
            r21 = 1073742338(0x40000202, double:5.304992017E-315)
            r23 = 1073742337(0x40000201, double:5.30499201E-315)
            r25 = 8589934592(0x200000000, double:4.243991582E-314)
            r27 = 1073750536(0x40002208, double:5.30503252E-315)
            r12 = 1
            r11 = 0
            int r14 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x0506
            long r6 = r2 & r23
            int r14 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x0040
            if (r0 == 0) goto L_0x0035
            androidx.databinding.ObservableInt r6 = r0.disableMessageCollectVisibility
            goto L_0x0036
        L_0x0035:
            r6 = 0
        L_0x0036:
            r1.updateRegistration((int) r11, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x0040
            int r6 = r6.get()
            goto L_0x0041
        L_0x0040:
            r6 = 0
        L_0x0041:
            long r32 = r2 & r21
            int r7 = (r32 > r4 ? 1 : (r32 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x0057
            if (r0 == 0) goto L_0x004c
            androidx.databinding.ObservableBoolean r7 = r0.radioChecked
            goto L_0x004d
        L_0x004c:
            r7 = 0
        L_0x004d:
            r1.updateRegistration((int) r12, (androidx.databinding.h) r7)
            if (r7 == 0) goto L_0x0057
            boolean r7 = r7.get()
            goto L_0x0058
        L_0x0057:
            r7 = 0
        L_0x0058:
            long r32 = r2 & r19
            int r14 = (r32 > r4 ? 1 : (r32 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x00c1
            if (r0 == 0) goto L_0x00c1
            net.one97.paytm.nativesdk.databinding.UpiCollectLayoutNewBindingImpl$OnClickListenerImpl r14 = r1.mUpiCollectModelCheckBankOffersClickAndroidViewViewOnClickListener
            if (r14 != 0) goto L_0x006b
            net.one97.paytm.nativesdk.databinding.UpiCollectLayoutNewBindingImpl$OnClickListenerImpl r14 = new net.one97.paytm.nativesdk.databinding.UpiCollectLayoutNewBindingImpl$OnClickListenerImpl
            r14.<init>()
            r1.mUpiCollectModelCheckBankOffersClickAndroidViewViewOnClickListener = r14
        L_0x006b:
            net.one97.paytm.nativesdk.databinding.UpiCollectLayoutNewBindingImpl$OnClickListenerImpl r14 = r14.setValue(r0)
            net.one97.paytm.nativesdk.databinding.UpiCollectLayoutNewBindingImpl$OnClickListenerImpl1 r11 = r1.mUpiCollectModelBhimUpiClickedAndroidViewViewOnClickListener
            if (r11 != 0) goto L_0x007a
            net.one97.paytm.nativesdk.databinding.UpiCollectLayoutNewBindingImpl$OnClickListenerImpl1 r11 = new net.one97.paytm.nativesdk.databinding.UpiCollectLayoutNewBindingImpl$OnClickListenerImpl1
            r11.<init>()
            r1.mUpiCollectModelBhimUpiClickedAndroidViewViewOnClickListener = r11
        L_0x007a:
            net.one97.paytm.nativesdk.databinding.UpiCollectLayoutNewBindingImpl$OnClickListenerImpl1 r11 = r11.setValue(r0)
            net.one97.paytm.nativesdk.databinding.UpiCollectLayoutNewBindingImpl$AfterTextChangedImpl r12 = r1.mUpiCollectModelVpaAddressBeforeTextChangeAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged
            if (r12 != 0) goto L_0x0089
            net.one97.paytm.nativesdk.databinding.UpiCollectLayoutNewBindingImpl$AfterTextChangedImpl r12 = new net.one97.paytm.nativesdk.databinding.UpiCollectLayoutNewBindingImpl$AfterTextChangedImpl
            r12.<init>()
            r1.mUpiCollectModelVpaAddressBeforeTextChangeAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged = r12
        L_0x0089:
            net.one97.paytm.nativesdk.databinding.UpiCollectLayoutNewBindingImpl$AfterTextChangedImpl r12 = r12.setValue(r0)
            net.one97.paytm.nativesdk.databinding.UpiCollectLayoutNewBindingImpl$OnClickListenerImpl2 r13 = r1.mUpiCollectModelProceedToPayUpiAndroidViewViewOnClickListener
            if (r13 != 0) goto L_0x0098
            net.one97.paytm.nativesdk.databinding.UpiCollectLayoutNewBindingImpl$OnClickListenerImpl2 r13 = new net.one97.paytm.nativesdk.databinding.UpiCollectLayoutNewBindingImpl$OnClickListenerImpl2
            r13.<init>()
            r1.mUpiCollectModelProceedToPayUpiAndroidViewViewOnClickListener = r13
        L_0x0098:
            net.one97.paytm.nativesdk.databinding.UpiCollectLayoutNewBindingImpl$OnClickListenerImpl2 r13 = r13.setValue(r0)
            net.one97.paytm.nativesdk.databinding.UpiCollectLayoutNewBindingImpl$OnClickListenerImpl4 r8 = r1.mUpiCollectModelProceedToPayAndroidViewViewOnClickListener
            if (r8 != 0) goto L_0x00a7
            net.one97.paytm.nativesdk.databinding.UpiCollectLayoutNewBindingImpl$OnClickListenerImpl4 r8 = new net.one97.paytm.nativesdk.databinding.UpiCollectLayoutNewBindingImpl$OnClickListenerImpl4
            r8.<init>()
            r1.mUpiCollectModelProceedToPayAndroidViewViewOnClickListener = r8
        L_0x00a7:
            net.one97.paytm.nativesdk.databinding.UpiCollectLayoutNewBindingImpl$OnClickListenerImpl4 r8 = r8.setValue(r0)
            net.one97.paytm.nativesdk.databinding.UpiCollectLayoutNewBindingImpl$OnClickListenerImpl5 r9 = r1.mUpiCollectModelHowItWorksClickedAndroidViewViewOnClickListener
            if (r9 != 0) goto L_0x00b6
            net.one97.paytm.nativesdk.databinding.UpiCollectLayoutNewBindingImpl$OnClickListenerImpl5 r9 = new net.one97.paytm.nativesdk.databinding.UpiCollectLayoutNewBindingImpl$OnClickListenerImpl5
            r9.<init>()
            r1.mUpiCollectModelHowItWorksClickedAndroidViewViewOnClickListener = r9
        L_0x00b6:
            net.one97.paytm.nativesdk.databinding.UpiCollectLayoutNewBindingImpl$OnClickListenerImpl5 r9 = r9.setValue(r0)
            r85 = r9
            r9 = r8
            r8 = r13
            r13 = r85
            goto L_0x00c7
        L_0x00c1:
            r8 = 0
            r9 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
        L_0x00c7:
            long r35 = r2 & r15
            int r10 = (r35 > r4 ? 1 : (r35 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x00de
            if (r0 == 0) goto L_0x00d2
            androidx.databinding.ObservableInt r10 = r0.upiIntentSeparatorVisibility
            goto L_0x00d3
        L_0x00d2:
            r10 = 0
        L_0x00d3:
            r15 = 2
            r1.updateRegistration((int) r15, (androidx.databinding.h) r10)
            if (r10 == 0) goto L_0x00de
            int r10 = r10.get()
            goto L_0x00df
        L_0x00de:
            r10 = 0
        L_0x00df:
            long r15 = r2 & r27
            int r37 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r37 == 0) goto L_0x010a
            if (r0 == 0) goto L_0x00ea
            androidx.databinding.ObservableInt r15 = r0.collectLoaderVisibility
            goto L_0x00eb
        L_0x00ea:
            r15 = 0
        L_0x00eb:
            r4 = 3
            r1.updateRegistration((int) r4, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x00f6
            int r4 = r15.get()
            goto L_0x00f7
        L_0x00f6:
            r4 = 0
        L_0x00f7:
            if (r4 != 0) goto L_0x00fb
            r5 = 1
            goto L_0x00fc
        L_0x00fb:
            r5 = 0
        L_0x00fc:
            if (r37 == 0) goto L_0x010c
            if (r5 == 0) goto L_0x0107
            r15 = 17179869184(0x400000000, double:8.4879831639E-314)
            long r2 = r2 | r15
            goto L_0x010c
        L_0x0107:
            long r2 = r2 | r25
            goto L_0x010c
        L_0x010a:
            r4 = 0
            r5 = 0
        L_0x010c:
            r15 = 1073742352(0x40000210, double:5.304992086E-315)
            long r40 = r2 & r15
            r15 = 0
            int r37 = (r40 > r15 ? 1 : (r40 == r15 ? 0 : -1))
            if (r37 == 0) goto L_0x012c
            if (r0 == 0) goto L_0x011e
            androidx.databinding.ObservableInt r15 = r0.intentConvFeeTextVisibility
            r16 = r4
            goto L_0x0121
        L_0x011e:
            r16 = r4
            r15 = 0
        L_0x0121:
            r4 = 4
            r1.updateRegistration((int) r4, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x012e
            int r4 = r15.get()
            goto L_0x012f
        L_0x012c:
            r16 = r4
        L_0x012e:
            r4 = 0
        L_0x012f:
            r40 = 1073742368(0x40000220, double:5.304992165E-315)
            long r40 = r2 & r40
            r37 = 0
            int r15 = (r40 > r37 ? 1 : (r40 == r37 ? 0 : -1))
            if (r15 == 0) goto L_0x014f
            if (r0 == 0) goto L_0x0141
            androidx.databinding.ObservableInt r15 = r0.howItWorksVisibility
            r37 = r4
            goto L_0x0144
        L_0x0141:
            r37 = r4
            r15 = 0
        L_0x0144:
            r4 = 5
            r1.updateRegistration((int) r4, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x0151
            int r4 = r15.get()
            goto L_0x0152
        L_0x014f:
            r37 = r4
        L_0x0151:
            r4 = 0
        L_0x0152:
            r40 = 1073742400(0x40000240, double:5.304992323E-315)
            long r40 = r2 & r40
            r38 = 0
            int r15 = (r40 > r38 ? 1 : (r40 == r38 ? 0 : -1))
            if (r15 == 0) goto L_0x0172
            if (r0 == 0) goto L_0x0164
            androidx.databinding.ObservableInt r15 = r0.tagImageVisibility
            r40 = r4
            goto L_0x0167
        L_0x0164:
            r40 = r4
            r15 = 0
        L_0x0167:
            r4 = 6
            r1.updateRegistration((int) r4, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x0174
            int r4 = r15.get()
            goto L_0x0175
        L_0x0172:
            r40 = r4
        L_0x0174:
            r4 = 0
        L_0x0175:
            r41 = 1073742464(0x40000280, double:5.30499264E-315)
            long r41 = r2 & r41
            r38 = 0
            int r15 = (r41 > r38 ? 1 : (r41 == r38 ? 0 : -1))
            if (r15 == 0) goto L_0x0195
            if (r0 == 0) goto L_0x0187
            androidx.databinding.ObservableInt r15 = r0.verifiedProgressVisibility
            r41 = r4
            goto L_0x018a
        L_0x0187:
            r41 = r4
            r15 = 0
        L_0x018a:
            r4 = 7
            r1.updateRegistration((int) r4, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x0197
            int r4 = r15.get()
            goto L_0x0198
        L_0x0195:
            r41 = r4
        L_0x0197:
            r4 = 0
        L_0x0198:
            r42 = 1073742592(0x40000300, double:5.30499327E-315)
            long r42 = r2 & r42
            r38 = 0
            int r15 = (r42 > r38 ? 1 : (r42 == r38 ? 0 : -1))
            if (r15 == 0) goto L_0x01bb
            if (r0 == 0) goto L_0x01ac
            androidx.databinding.ObservableInt r15 = r0.bankOfferVisibility
            r34 = r4
            r4 = 8
            goto L_0x01b1
        L_0x01ac:
            r34 = r4
            r4 = 8
            r15 = 0
        L_0x01b1:
            r1.updateRegistration((int) r4, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x01bf
            int r15 = r15.get()
            goto L_0x01c0
        L_0x01bb:
            r34 = r4
            r4 = 8
        L_0x01bf:
            r15 = 0
        L_0x01c0:
            r30 = 1073743360(0x40000600, double:5.304997066E-315)
            long r42 = r2 & r30
            r38 = 0
            int r44 = (r42 > r38 ? 1 : (r42 == r38 ? 0 : -1))
            if (r44 == 0) goto L_0x01e1
            if (r0 == 0) goto L_0x01d2
            androidx.databinding.ObservableInt r4 = r0.verifiedIconVisibility
            r43 = r5
            goto L_0x01d5
        L_0x01d2:
            r43 = r5
            r4 = 0
        L_0x01d5:
            r5 = 10
            r1.updateRegistration((int) r5, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x01e3
            int r4 = r4.get()
            goto L_0x01e4
        L_0x01e1:
            r43 = r5
        L_0x01e3:
            r4 = 0
        L_0x01e4:
            r44 = 1073744384(0x40000a00, double:5.305002125E-315)
            long r44 = r2 & r44
            r38 = 0
            int r5 = (r44 > r38 ? 1 : (r44 == r38 ? 0 : -1))
            if (r5 == 0) goto L_0x0205
            if (r0 == 0) goto L_0x01f6
            androidx.databinding.ObservableInt r5 = r0.intentLoaderVisibility
            r44 = r4
            goto L_0x01f9
        L_0x01f6:
            r44 = r4
            r5 = 0
        L_0x01f9:
            r4 = 11
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x0207
            int r4 = r5.get()
            goto L_0x0208
        L_0x0205:
            r44 = r4
        L_0x0207:
            r4 = 0
        L_0x0208:
            r45 = 1090519552(0x41000200, double:5.38788247E-315)
            long r45 = r2 & r45
            r38 = 0
            int r5 = (r45 > r38 ? 1 : (r45 == r38 ? 0 : -1))
            if (r5 == 0) goto L_0x023e
            if (r0 == 0) goto L_0x022b
            net.one97.paytm.nativesdk.databinding.UpiCollectLayoutNewBindingImpl$OnClickListenerImpl3 r5 = r1.mUpiCollectModelVerifyVPAAndroidViewViewOnClickListener
            if (r5 != 0) goto L_0x0220
            net.one97.paytm.nativesdk.databinding.UpiCollectLayoutNewBindingImpl$OnClickListenerImpl3 r5 = new net.one97.paytm.nativesdk.databinding.UpiCollectLayoutNewBindingImpl$OnClickListenerImpl3
            r5.<init>()
            r1.mUpiCollectModelVerifyVPAAndroidViewViewOnClickListener = r5
        L_0x0220:
            net.one97.paytm.nativesdk.databinding.UpiCollectLayoutNewBindingImpl$OnClickListenerImpl3 r5 = r5.setValue(r0)
            r45 = r4
            androidx.databinding.ObservableBoolean r4 = r0.isVerifyClickable
            r46 = r5
            goto L_0x0230
        L_0x022b:
            r45 = r4
            r4 = 0
            r46 = 0
        L_0x0230:
            r5 = 24
            r1.updateRegistration((int) r5, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x023c
            boolean r4 = r4.get()
            goto L_0x0243
        L_0x023c:
            r4 = 0
            goto L_0x0243
        L_0x023e:
            r45 = r4
            r4 = 0
            r46 = 0
        L_0x0243:
            r47 = 1073746432(0x40001200, double:5.305012244E-315)
            long r47 = r2 & r47
            r38 = 0
            int r5 = (r47 > r38 ? 1 : (r47 == r38 ? 0 : -1))
            if (r5 == 0) goto L_0x0266
            if (r0 == 0) goto L_0x0255
            androidx.databinding.i<java.lang.String> r5 = r0.disableMessage
            r47 = r4
            goto L_0x0258
        L_0x0255:
            r47 = r4
            r5 = 0
        L_0x0258:
            r4 = 12
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x0268
            java.lang.Object r4 = r5.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0269
        L_0x0266:
            r47 = r4
        L_0x0268:
            r4 = 0
        L_0x0269:
            r48 = 1073750528(0x40002200, double:5.30503248E-315)
            long r48 = r2 & r48
            r38 = 0
            int r5 = (r48 > r38 ? 1 : (r48 == r38 ? 0 : -1))
            if (r5 == 0) goto L_0x028e
            if (r0 == 0) goto L_0x027d
            androidx.databinding.ObservableInt r5 = r0.collectConvFeeTextVisibility
            r48 = r4
            r4 = 13
            goto L_0x0282
        L_0x027d:
            r48 = r4
            r4 = 13
            r5 = 0
        L_0x0282:
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x028c
            int r4 = r5.get()
            goto L_0x0292
        L_0x028c:
            r4 = 0
            goto L_0x0292
        L_0x028e:
            r48 = r4
            r4 = 0
            r5 = 0
        L_0x0292:
            r49 = 1073758720(0x40004200, double:5.305072955E-315)
            long r49 = r2 & r49
            r38 = 0
            int r51 = (r49 > r38 ? 1 : (r49 == r38 ? 0 : -1))
            r49 = r4
            if (r51 == 0) goto L_0x02b5
            if (r0 == 0) goto L_0x02a6
            androidx.databinding.ObservableInt r4 = r0.cashBackTextVisibility
            r50 = r5
            goto L_0x02a9
        L_0x02a6:
            r50 = r5
            r4 = 0
        L_0x02a9:
            r5 = 14
            r1.updateRegistration((int) r5, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x02b7
            int r4 = r4.get()
            goto L_0x02b8
        L_0x02b5:
            r50 = r5
        L_0x02b7:
            r4 = 0
        L_0x02b8:
            r51 = 1073775104(0x40008200, double:5.3051539E-315)
            long r51 = r2 & r51
            r38 = 0
            int r5 = (r51 > r38 ? 1 : (r51 == r38 ? 0 : -1))
            if (r5 == 0) goto L_0x02db
            if (r0 == 0) goto L_0x02ca
            androidx.databinding.i<java.lang.String> r5 = r0.amount
            r51 = r4
            goto L_0x02cd
        L_0x02ca:
            r51 = r4
            r5 = 0
        L_0x02cd:
            r4 = 15
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x02dd
            java.lang.Object r4 = r5.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x02de
        L_0x02db:
            r51 = r4
        L_0x02dd:
            r4 = 0
        L_0x02de:
            r52 = 1073807872(0x40010200, double:5.3053158E-315)
            long r52 = r2 & r52
            r38 = 0
            int r5 = (r52 > r38 ? 1 : (r52 == r38 ? 0 : -1))
            if (r5 == 0) goto L_0x0301
            if (r0 == 0) goto L_0x02f0
            androidx.databinding.i<android.text.SpannableString> r5 = r0.intentConvFeeText
            r52 = r4
            goto L_0x02f3
        L_0x02f0:
            r52 = r4
            r5 = 0
        L_0x02f3:
            r4 = 16
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x0303
            java.lang.Object r4 = r5.get()
            android.text.SpannableString r4 = (android.text.SpannableString) r4
            goto L_0x0304
        L_0x0301:
            r52 = r4
        L_0x0303:
            r4 = 0
        L_0x0304:
            r53 = 1073873408(0x40020200, double:5.30563959E-315)
            long r53 = r2 & r53
            r38 = 0
            int r5 = (r53 > r38 ? 1 : (r53 == r38 ? 0 : -1))
            if (r5 == 0) goto L_0x0327
            if (r0 == 0) goto L_0x0316
            androidx.databinding.i<java.lang.String> r5 = r0.paySecurelyText
            r53 = r4
            goto L_0x0319
        L_0x0316:
            r53 = r4
            r5 = 0
        L_0x0319:
            r4 = 17
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x0329
            java.lang.Object r4 = r5.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x032a
        L_0x0327:
            r53 = r4
        L_0x0329:
            r4 = 0
        L_0x032a:
            r54 = 1074004480(0x40040200, double:5.30628717E-315)
            long r54 = r2 & r54
            r38 = 0
            int r5 = (r54 > r38 ? 1 : (r54 == r38 ? 0 : -1))
            if (r5 == 0) goto L_0x034b
            if (r0 == 0) goto L_0x033c
            androidx.databinding.ObservableInt r5 = r0.verifyTextVisibility
            r54 = r4
            goto L_0x033f
        L_0x033c:
            r54 = r4
            r5 = 0
        L_0x033f:
            r4 = 18
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x034d
            int r4 = r5.get()
            goto L_0x034e
        L_0x034b:
            r54 = r4
        L_0x034d:
            r4 = 0
        L_0x034e:
            r55 = 1074266624(0x40080200, double:5.307582334E-315)
            long r55 = r2 & r55
            r38 = 0
            int r5 = (r55 > r38 ? 1 : (r55 == r38 ? 0 : -1))
            if (r5 == 0) goto L_0x0371
            if (r0 == 0) goto L_0x0360
            androidx.databinding.i<java.lang.String> r5 = r0.collectLoaderMsg
            r55 = r4
            goto L_0x0363
        L_0x0360:
            r55 = r4
            r5 = 0
        L_0x0363:
            r4 = 19
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x0373
            java.lang.Object r4 = r5.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0374
        L_0x0371:
            r55 = r4
        L_0x0373:
            r4 = 0
        L_0x0374:
            r56 = 1074790912(0x40100200, double:5.31017266E-315)
            long r56 = r2 & r56
            r38 = 0
            int r5 = (r56 > r38 ? 1 : (r56 == r38 ? 0 : -1))
            if (r5 == 0) goto L_0x0397
            if (r0 == 0) goto L_0x0386
            androidx.databinding.i<java.lang.String> r5 = r0.cashBackText
            r56 = r4
            goto L_0x0389
        L_0x0386:
            r56 = r4
            r5 = 0
        L_0x0389:
            r4 = 20
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x0399
            java.lang.Object r4 = r5.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x039a
        L_0x0397:
            r56 = r4
        L_0x0399:
            r4 = 0
        L_0x039a:
            r57 = 1075839488(0x40200200, double:5.315353315E-315)
            long r57 = r2 & r57
            r38 = 0
            int r5 = (r57 > r38 ? 1 : (r57 == r38 ? 0 : -1))
            if (r5 == 0) goto L_0x03bd
            if (r0 == 0) goto L_0x03ac
            androidx.databinding.i<android.text.SpannableString> r5 = r0.collectConvFeeText
            r57 = r4
            goto L_0x03af
        L_0x03ac:
            r57 = r4
            r5 = 0
        L_0x03af:
            r4 = 21
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x03bf
            java.lang.Object r4 = r5.get()
            android.text.SpannableString r4 = (android.text.SpannableString) r4
            goto L_0x03c0
        L_0x03bd:
            r57 = r4
        L_0x03bf:
            r4 = 0
        L_0x03c0:
            r58 = 1077936640(0x40400200, double:5.32571462E-315)
            long r58 = r2 & r58
            r38 = 0
            int r5 = (r58 > r38 ? 1 : (r58 == r38 ? 0 : -1))
            if (r5 == 0) goto L_0x03e3
            if (r0 == 0) goto L_0x03d2
            androidx.databinding.i r5 = r0.bankOfferText
            r58 = r4
            goto L_0x03d5
        L_0x03d2:
            r58 = r4
            r5 = 0
        L_0x03d5:
            r4 = 22
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x03e5
            java.lang.Object r4 = r5.get()
            android.text.SpannableString r4 = (android.text.SpannableString) r4
            goto L_0x03e6
        L_0x03e3:
            r58 = r4
        L_0x03e5:
            r4 = 0
        L_0x03e6:
            r59 = 1082130944(0x40800200, double:5.346437237E-315)
            long r59 = r2 & r59
            r38 = 0
            int r5 = (r59 > r38 ? 1 : (r59 == r38 ? 0 : -1))
            if (r5 == 0) goto L_0x0407
            if (r0 == 0) goto L_0x03f8
            androidx.databinding.ObservableInt r5 = r0.upiCollectVisibility
            r59 = r4
            goto L_0x03fb
        L_0x03f8:
            r59 = r4
            r5 = 0
        L_0x03fb:
            r4 = 23
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x0409
            int r4 = r5.get()
            goto L_0x040a
        L_0x0407:
            r59 = r4
        L_0x0409:
            r4 = 0
        L_0x040a:
            r17 = 1107296768(0x42000200, double:5.47077293E-315)
            long r60 = r2 & r17
            r38 = 0
            int r5 = (r60 > r38 ? 1 : (r60 == r38 ? 0 : -1))
            if (r5 == 0) goto L_0x042b
            if (r0 == 0) goto L_0x041c
            androidx.databinding.ObservableInt r5 = r0.checkOfferVisibility
            r60 = r4
            goto L_0x041f
        L_0x041c:
            r60 = r4
            r5 = 0
        L_0x041f:
            r4 = 25
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x042d
            int r4 = r5.get()
            goto L_0x042e
        L_0x042b:
            r60 = r4
        L_0x042d:
            r4 = 0
        L_0x042e:
            r61 = 1140851200(0x44000200, double:5.63655385E-315)
            long r61 = r2 & r61
            r38 = 0
            int r5 = (r61 > r38 ? 1 : (r61 == r38 ? 0 : -1))
            if (r5 == 0) goto L_0x044f
            if (r0 == 0) goto L_0x0440
            androidx.databinding.ObservableInt r5 = r0.disableMessageIntentVisibility
            r61 = r4
            goto L_0x0443
        L_0x0440:
            r61 = r4
            r5 = 0
        L_0x0443:
            r4 = 26
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x0451
            int r4 = r5.get()
            goto L_0x0452
        L_0x044f:
            r61 = r4
        L_0x0451:
            r4 = 0
        L_0x0452:
            r62 = 1207960064(0x48000200, double:5.96811569E-315)
            long r62 = r2 & r62
            r38 = 0
            int r5 = (r62 > r38 ? 1 : (r62 == r38 ? 0 : -1))
            if (r5 == 0) goto L_0x0475
            if (r0 == 0) goto L_0x0464
            androidx.databinding.i<java.lang.String> r5 = r0.intentLoaderMsg
            r62 = r4
            goto L_0x0467
        L_0x0464:
            r62 = r4
            r5 = 0
        L_0x0467:
            r4 = 27
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x0477
            java.lang.Object r4 = r5.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0478
        L_0x0475:
            r62 = r4
        L_0x0477:
            r4 = 0
        L_0x0478:
            r63 = 1342177792(0x50000200, double:6.631239376E-315)
            long r63 = r2 & r63
            r38 = 0
            int r5 = (r63 > r38 ? 1 : (r63 == r38 ? 0 : -1))
            if (r5 == 0) goto L_0x04cd
            if (r0 == 0) goto L_0x048a
            androidx.databinding.ObservableInt r5 = r0.vpaInputLayoutVisibility
            r63 = r2
            goto L_0x048d
        L_0x048a:
            r63 = r2
            r5 = 0
        L_0x048d:
            r2 = 28
            r1.updateRegistration((int) r2, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x04cf
            int r2 = r5.get()
            r72 = r4
            r76 = r6
            r67 = r7
            r70 = r15
            r84 = r34
            r75 = r37
            r82 = r40
            r65 = r41
            r3 = r44
            r5 = r45
            r80 = r46
            r81 = r47
            r77 = r48
            r83 = r52
            r74 = r53
            r66 = r54
            r79 = r55
            r71 = r56
            r7 = r57
            r73 = r58
            r69 = r59
            r68 = r60
            r4 = r61
            r78 = r62
            r6 = r2
            r15 = r10
            r2 = r16
            goto L_0x0503
        L_0x04cd:
            r63 = r2
        L_0x04cf:
            r72 = r4
            r76 = r6
            r67 = r7
            r70 = r15
            r2 = r16
            r84 = r34
            r75 = r37
            r82 = r40
            r65 = r41
            r3 = r44
            r5 = r45
            r80 = r46
            r81 = r47
            r77 = r48
            r83 = r52
            r74 = r53
            r66 = r54
            r79 = r55
            r71 = r56
            r7 = r57
            r73 = r58
            r69 = r59
            r68 = r60
            r4 = r61
            r78 = r62
            r6 = 0
            r15 = r10
        L_0x0503:
            r10 = r51
            goto L_0x0544
        L_0x0506:
            r63 = r2
            r2 = 0
            r3 = 0
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
            r43 = 0
            r49 = 0
            r50 = 0
            r65 = 0
            r66 = 0
            r67 = 0
            r68 = 0
            r69 = 0
            r70 = 0
            r71 = 0
            r72 = 0
            r73 = 0
            r74 = 0
            r75 = 0
            r76 = 0
            r77 = 0
            r78 = 0
            r79 = 0
            r80 = 0
            r81 = 0
            r82 = 0
            r83 = 0
            r84 = 0
        L_0x0544:
            long r25 = r63 & r25
            r37 = 0
            int r16 = (r25 > r37 ? 1 : (r25 == r37 ? 0 : -1))
            if (r16 == 0) goto L_0x056a
            if (r0 == 0) goto L_0x0553
            androidx.databinding.ObservableInt r0 = r0.collectConvFeeTextVisibility
            r16 = r15
            goto L_0x0557
        L_0x0553:
            r16 = r15
            r0 = r50
        L_0x0557:
            r15 = 13
            r1.updateRegistration((int) r15, (androidx.databinding.h) r0)
            if (r0 == 0) goto L_0x0562
            int r49 = r0.get()
        L_0x0562:
            if (r49 != 0) goto L_0x0566
            r0 = 1
            goto L_0x0567
        L_0x0566:
            r0 = 0
        L_0x0567:
            r15 = r49
            goto L_0x056f
        L_0x056a:
            r16 = r15
            r15 = r49
            r0 = 0
        L_0x056f:
            long r25 = r63 & r27
            r37 = 0
            int r29 = (r25 > r37 ? 1 : (r25 == r37 ? 0 : -1))
            if (r29 == 0) goto L_0x0595
            if (r43 == 0) goto L_0x057a
            r0 = 1
        L_0x057a:
            if (r29 == 0) goto L_0x058b
            if (r0 == 0) goto L_0x0584
            r25 = 4294967296(0x100000000, double:2.121995791E-314)
            goto L_0x0589
        L_0x0584:
            r25 = 2147483648(0x80000000, double:1.0609978955E-314)
        L_0x0589:
            long r63 = r63 | r25
        L_0x058b:
            if (r0 == 0) goto L_0x0590
            r32 = 0
            goto L_0x0592
        L_0x0590:
            r32 = 8
        L_0x0592:
            r0 = r32
            goto L_0x0596
        L_0x0595:
            r0 = 0
        L_0x0596:
            long r19 = r63 & r19
            r25 = 0
            int r29 = (r19 > r25 ? 1 : (r19 == r25 ? 0 : -1))
            r19 = r15
            if (r29 == 0) goto L_0x05bf
            android.widget.RelativeLayout r15 = r1.btnProceed
            r15.setOnClickListener(r9)
            android.widget.RelativeLayout r9 = r1.btnProceed2
            r9.setOnClickListener(r8)
            android.widget.RelativeLayout r8 = r1.cardTextLayout
            r8.setOnClickListener(r11)
            android.widget.EditText r8 = r1.etUpiAddress
            r9 = 0
            androidx.databinding.a.d.a(r8, r9, r12, r9)
            android.widget.LinearLayout r8 = r1.llCheckForOffers
            r8.setOnClickListener(r14)
            net.one97.paytm.nativesdk.widget.RoboTextView r8 = r1.txtHowItWorks
            r8.setOnClickListener(r13)
        L_0x05bf:
            long r8 = r63 & r27
            r11 = 0
            int r13 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r13 == 0) goto L_0x05cc
            android.widget.FrameLayout r8 = r1.flLoader
            r8.setVisibility(r0)
        L_0x05cc:
            r8 = 1073743360(0x40000600, double:5.304997066E-315)
            long r8 = r63 & r8
            int r0 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x05da
            android.widget.ImageView r0 = r1.ivVerified
            r0.setVisibility(r3)
        L_0x05da:
            r8 = 1107296768(0x42000200, double:5.47077293E-315)
            long r8 = r63 & r8
            int r0 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x05e8
            android.widget.LinearLayout r0 = r1.llCheckForOffers
            r0.setVisibility(r4)
        L_0x05e8:
            r3 = 1073742344(0x40000208, double:5.304992047E-315)
            long r3 = r63 & r3
            int r0 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x05f6
            android.widget.LinearLayout r0 = r1.llCheckOffer
            r0.setVisibility(r2)
        L_0x05f6:
            r2 = 1073744384(0x40000a00, double:5.305002125E-315)
            long r2 = r63 & r2
            int r0 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x0604
            android.widget.LinearLayout r0 = r1.llCheckOffer1
            r0.setVisibility(r5)
        L_0x0604:
            r2 = 1342177792(0x50000200, double:6.631239376E-315)
            long r2 = r63 & r2
            int r0 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x0612
            android.widget.LinearLayout r0 = r1.llUpiIntent
            r0.setVisibility(r6)
        L_0x0612:
            r2 = 1074790912(0x40100200, double:5.31017266E-315)
            long r2 = r63 & r2
            int r0 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x0625
            android.widget.TextView r0 = r1.mboundView12
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r7)
            android.widget.TextView r0 = r1.mboundView29
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r7)
        L_0x0625:
            r2 = 1073758720(0x40004200, double:5.305072955E-315)
            long r2 = r63 & r2
            int r0 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x0638
            android.widget.TextView r0 = r1.mboundView12
            r0.setVisibility(r10)
            android.widget.TextView r0 = r1.mboundView29
            r0.setVisibility(r10)
        L_0x0638:
            r2 = 1073742340(0x40000204, double:5.304992027E-315)
            long r2 = r63 & r2
            int r0 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x0648
            android.widget.RelativeLayout r0 = r1.mboundView13
            r10 = r16
            r0.setVisibility(r10)
        L_0x0648:
            r2 = 1073742400(0x40000240, double:5.304992323E-315)
            long r2 = r63 & r2
            int r0 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x0658
            android.widget.ImageView r0 = r1.mboundView21
            r2 = r65
            r0.setVisibility(r2)
        L_0x0658:
            r2 = 1073873408(0x40020200, double:5.30563959E-315)
            long r2 = r63 & r2
            int r0 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x066d
            android.widget.TextView r0 = r1.paysecurely
            r2 = r66
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r2)
            android.widget.TextView r0 = r1.paysecurely2
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r2)
        L_0x066d:
            long r2 = r63 & r21
            int r0 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x067a
            android.widget.RadioButton r0 = r1.radioButton
            r7 = r67
            androidx.databinding.a.a.a(r0, r7)
        L_0x067a:
            r2 = 1082130944(0x40800200, double:5.346437237E-315)
            long r2 = r63 & r2
            int r0 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x068a
            android.widget.RelativeLayout r0 = r1.topLayout
            r2 = r68
            r0.setVisibility(r2)
        L_0x068a:
            r2 = 1077936640(0x40400200, double:5.32571462E-315)
            long r2 = r63 & r2
            int r0 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x069a
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvBankOffer
            r2 = r69
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r2)
        L_0x069a:
            r2 = 1073742592(0x40000300, double:5.30499327E-315)
            long r2 = r63 & r2
            int r0 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x06aa
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvBankOffer
            r15 = r70
            r0.setVisibility(r15)
        L_0x06aa:
            r2 = 1074266624(0x40080200, double:5.307582334E-315)
            long r2 = r63 & r2
            int r0 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x06ba
            android.widget.TextView r0 = r1.tvCheckingOffers
            r2 = r71
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r2)
        L_0x06ba:
            r2 = 1207960064(0x48000200, double:5.96811569E-315)
            long r2 = r63 & r2
            int r0 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x06ca
            android.widget.TextView r0 = r1.tvCheckingOffers1
            r4 = r72
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
        L_0x06ca:
            r2 = 1075839488(0x40200200, double:5.315353315E-315)
            long r2 = r63 & r2
            int r0 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x06da
            android.widget.TextView r0 = r1.tvConvFee
            r2 = r73
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r2)
        L_0x06da:
            r2 = 1073750528(0x40002200, double:5.30503248E-315)
            long r2 = r63 & r2
            int r0 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x06ea
            android.widget.TextView r0 = r1.tvConvFee
            r2 = r19
            r0.setVisibility(r2)
        L_0x06ea:
            r2 = 1073807872(0x40010200, double:5.3053158E-315)
            long r2 = r63 & r2
            int r0 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x06fa
            android.widget.TextView r0 = r1.tvConvFee1
            r2 = r74
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r2)
        L_0x06fa:
            r2 = 1073742352(0x40000210, double:5.304992086E-315)
            long r2 = r63 & r2
            int r0 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x070a
            android.widget.TextView r0 = r1.tvConvFee1
            r2 = r75
            r0.setVisibility(r2)
        L_0x070a:
            long r2 = r63 & r23
            int r0 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x0717
            android.widget.TextView r0 = r1.tvDisableErrorMessageCollect
            r6 = r76
            r0.setVisibility(r6)
        L_0x0717:
            r2 = 1073746432(0x40001200, double:5.305012244E-315)
            long r2 = r63 & r2
            int r0 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x072c
            android.widget.TextView r0 = r1.tvDisableErrorMessageCollect
            r2 = r77
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r2)
            android.widget.TextView r0 = r1.tvDisableErrorMessageIntent
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r2)
        L_0x072c:
            r2 = 1140851200(0x44000200, double:5.63655385E-315)
            long r2 = r63 & r2
            int r0 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x073c
            android.widget.TextView r0 = r1.tvDisableErrorMessageIntent
            r2 = r78
            r0.setVisibility(r2)
        L_0x073c:
            r2 = 1074004480(0x40040200, double:5.30628717E-315)
            long r2 = r63 & r2
            int r0 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x074c
            android.widget.TextView r0 = r1.tvVerifyVpa
            r2 = r79
            r0.setVisibility(r2)
        L_0x074c:
            r2 = 1090519552(0x41000200, double:5.38788247E-315)
            long r2 = r63 & r2
            int r0 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x075e
            android.widget.TextView r0 = r1.tvVerifyVpa
            r2 = r80
            r3 = r81
            androidx.databinding.a.e.a(r0, r2, r3)
        L_0x075e:
            r2 = 1073742368(0x40000220, double:5.304992165E-315)
            long r2 = r63 & r2
            int r0 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x076e
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.txtHowItWorks
            r2 = r82
            r0.setVisibility(r2)
        L_0x076e:
            r2 = 1073775104(0x40008200, double:5.3051539E-315)
            long r2 = r63 & r2
            int r0 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x077e
            android.widget.TextView r0 = r1.txtamount
            r2 = r83
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r2)
        L_0x077e:
            r2 = 1073742464(0x40000280, double:5.30499264E-315)
            long r2 = r63 & r2
            int r0 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x078e
            android.widget.ProgressBar r0 = r1.verifyProgressbar
            r2 = r84
            r0.setVisibility(r2)
        L_0x078e:
            return
        L_0x078f:
            r0 = move-exception
            monitor-exit(r86)     // Catch:{ all -> 0x078f }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.databinding.UpiCollectLayoutNewBindingImpl.executeBindings():void");
    }

    public static class OnClickListenerImpl implements View.OnClickListener {
        private UpiCollectViewModelNew value;

        public OnClickListenerImpl setValue(UpiCollectViewModelNew upiCollectViewModelNew) {
            this.value = upiCollectViewModelNew;
            if (upiCollectViewModelNew == null) {
                return null;
            }
            return this;
        }

        public void onClick(View view) {
            this.value.checkBankOffersClick(view);
        }
    }

    public static class OnClickListenerImpl1 implements View.OnClickListener {
        private UpiCollectViewModelNew value;

        public OnClickListenerImpl1 setValue(UpiCollectViewModelNew upiCollectViewModelNew) {
            this.value = upiCollectViewModelNew;
            if (upiCollectViewModelNew == null) {
                return null;
            }
            return this;
        }

        public void onClick(View view) {
            this.value.bhimUpiClicked(view);
        }
    }

    public static class AfterTextChangedImpl implements d.a {
        private UpiCollectViewModelNew value;

        public AfterTextChangedImpl setValue(UpiCollectViewModelNew upiCollectViewModelNew) {
            this.value = upiCollectViewModelNew;
            if (upiCollectViewModelNew == null) {
                return null;
            }
            return this;
        }

        public void afterTextChanged(Editable editable) {
            this.value.vpaAddressBeforeTextChange(editable);
        }
    }

    public static class OnClickListenerImpl2 implements View.OnClickListener {
        private UpiCollectViewModelNew value;

        public OnClickListenerImpl2 setValue(UpiCollectViewModelNew upiCollectViewModelNew) {
            this.value = upiCollectViewModelNew;
            if (upiCollectViewModelNew == null) {
                return null;
            }
            return this;
        }

        public void onClick(View view) {
            this.value.proceedToPayUpi(view);
        }
    }

    public static class OnClickListenerImpl3 implements View.OnClickListener {
        private UpiCollectViewModelNew value;

        public OnClickListenerImpl3 setValue(UpiCollectViewModelNew upiCollectViewModelNew) {
            this.value = upiCollectViewModelNew;
            if (upiCollectViewModelNew == null) {
                return null;
            }
            return this;
        }

        public void onClick(View view) {
            this.value.verifyVPA(view);
        }
    }

    public static class OnClickListenerImpl4 implements View.OnClickListener {
        private UpiCollectViewModelNew value;

        public OnClickListenerImpl4 setValue(UpiCollectViewModelNew upiCollectViewModelNew) {
            this.value = upiCollectViewModelNew;
            if (upiCollectViewModelNew == null) {
                return null;
            }
            return this;
        }

        public void onClick(View view) {
            this.value.proceedToPay(view);
        }
    }

    public static class OnClickListenerImpl5 implements View.OnClickListener {
        private UpiCollectViewModelNew value;

        public OnClickListenerImpl5 setValue(UpiCollectViewModelNew upiCollectViewModelNew) {
            this.value = upiCollectViewModelNew;
            if (upiCollectViewModelNew == null) {
                return null;
            }
            return this;
        }

        public void onClick(View view) {
            this.value.howItWorksClicked(view);
        }
    }
}
