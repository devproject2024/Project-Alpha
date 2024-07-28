package net.one97.paytm.nativesdk.databinding;

import android.text.SpannableString;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import androidx.databinding.i;
import net.one97.paytm.nativesdk.BR;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.instruments.savedCard.viewmodel.SavedCardViewModel;

public class SaveCardLayout2BindingImpl extends SaveCardLayout2Binding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private OnCheckedChangeListenerImpl mSaveCardModelOneClickChangedAndroidWidgetCompoundButtonOnCheckedChangeListener;
    private final LinearLayout mboundView0;
    private final View mboundView12;
    private final FrameLayout mboundView13;
    private final TextView mboundView18;
    private final View mboundView23;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.tv_promotion, 24);
        sViewsWithIds.put(R.id.iv_saved_card, 25);
        sViewsWithIds.put(R.id.tv_emi_availbale, 26);
        sViewsWithIds.put(R.id.pb_selectPlan, 27);
        sViewsWithIds.put(R.id.emi_details_layout, 28);
        sViewsWithIds.put(R.id.txt_emi_details, 29);
        sViewsWithIds.put(R.id.imgEmiCross, 30);
        sViewsWithIds.put(R.id.tv_total_amount, 31);
        sViewsWithIds.put(R.id.tv_change_plan, 32);
        sViewsWithIds.put(R.id.cvv_layout, 33);
        sViewsWithIds.put(R.id.etCvv, 34);
        sViewsWithIds.put(R.id.txtErrMsg, 35);
        sViewsWithIds.put(R.id.tvOneClickMsg, 36);
        sViewsWithIds.put(R.id.icon_vscpInfo, 37);
        sViewsWithIds.put(R.id.tvOneClickEnabled, 38);
        sViewsWithIds.put(R.id.tvOneClickDetail, 39);
        sViewsWithIds.put(R.id.tv_promo_message, 40);
        sViewsWithIds.put(R.id.llUpiCheckbox, 41);
        sViewsWithIds.put(R.id.cbUpiCheckbox, 42);
        sViewsWithIds.put(R.id.tvUpiCheckbox, 43);
        sViewsWithIds.put(R.id.ltv_getOffers, 44);
        sViewsWithIds.put(R.id.btnProceed, 45);
        sViewsWithIds.put(R.id.ivPaysecurely, 46);
        sViewsWithIds.put(R.id.ltv_loading, 47);
        sViewsWithIds.put(R.id.upiPayOption, 48);
        sViewsWithIds.put(R.id.upiIcon, 49);
        sViewsWithIds.put(R.id.upiPayText, 50);
        sViewsWithIds.put(R.id.iv_proceed_upi_forward, 51);
    }

    public SaveCardLayout2BindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 52, sIncludes, sViewsWithIds));
    }

    private SaveCardLayout2BindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 24, objArr[45], objArr[6], objArr[42], objArr[33], objArr[28], objArr[34], objArr[37], objArr[30], objArr[46], objArr[51], objArr[25], objArr[14], objArr[8], objArr[19], objArr[41], objArr[44], objArr[47], objArr[5], objArr[17], objArr[27], objArr[1], objArr[7], objArr[9], objArr[20], objArr[3], objArr[10], objArr[4], objArr[21], objArr[32], objArr[15], objArr[16], objArr[26], objArr[39], objArr[38], objArr[36], objArr[40], objArr[24], objArr[11], objArr[22], objArr[31], objArr[43], objArr[29], objArr[35], objArr[2], objArr[49], objArr[48], objArr[50]);
        this.mDirtyFlags = -1;
        this.cbOneClick.setTag((Object) null);
        this.llCheckOffer.setTag((Object) null);
        this.llOfferView.setTag((Object) null);
        this.llOfferViewBottom.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.mboundView12 = objArr[12];
        this.mboundView12.setTag((Object) null);
        this.mboundView13 = objArr[13];
        this.mboundView13.setTag((Object) null);
        this.mboundView18 = objArr[18];
        this.mboundView18.setTag((Object) null);
        this.mboundView23 = objArr[23];
        this.mboundView23.setTag((Object) null);
        this.oneClickContainer.setTag((Object) null);
        this.paysecurely.setTag((Object) null);
        this.rbCardNumber.setTag((Object) null);
        this.textViewLowSuccess.setTag((Object) null);
        this.tvAppliedOffers.setTag((Object) null);
        this.tvAppliedOffersBottom.setTag((Object) null);
        this.tvBankName.setTag((Object) null);
        this.tvBankOffer.setTag((Object) null);
        this.tvBankOfferApplicable.setTag((Object) null);
        this.tvBankOfferBottom.setTag((Object) null);
        this.tvCheckingOffers.setTag((Object) null);
        this.tvConvFee.setTag((Object) null);
        this.tvSubventionOffer.setTag((Object) null);
        this.tvSubventionOfferBottom.setTag((Object) null);
        this.txtamount.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 33554432;
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
        } else if (BR.saveCardModel != i2) {
            return false;
        } else {
            setSaveCardModel((SavedCardViewModel) obj);
        }
        return true;
    }

    public void setView(View view) {
        this.mView = view;
    }

    public void setSaveCardModel(SavedCardViewModel savedCardViewModel) {
        updateRegistration(13, (h) savedCardViewModel);
        this.mSaveCardModel = savedCardViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 8192;
        }
        notifyPropertyChanged(BR.saveCardModel);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return onChangeSaveCardModelOfferApplicationVisibility((ObservableInt) obj, i3);
            case 1:
                return onChangeSaveCardModelCashBackTextVisibility((ObservableInt) obj, i3);
            case 2:
                return onChangeSaveCardModelLowSuccess((ObservableInt) obj, i3);
            case 3:
                return onChangeSaveCardModelLoaderMsg((i) obj, i3);
            case 4:
                return onChangeSaveCardModelBankName((i) obj, i3);
            case 5:
                return onChangeSaveCardModelCardNumber((i) obj, i3);
            case 6:
                return onChangeSaveCardModelSubventionOfferVisibility((ObservableInt) obj, i3);
            case 7:
                return onChangeSaveCardModelShowVisaOneClick((ObservableInt) obj, i3);
            case 8:
                return onChangeSaveCardModelLoaderVisibility((ObservableInt) obj, i3);
            case 9:
                return onChangeSaveCardModelAmount((i) obj, i3);
            case 10:
                return onChangeSaveCardModelConvFeeText((i) obj, i3);
            case 11:
                return onChangeSaveCardModelBankOfferText((i) obj, i3);
            case 12:
                return onChangeSaveCardModelPaySecurelyText((i) obj, i3);
            case 13:
                return onChangeSaveCardModel((SavedCardViewModel) obj, i3);
            case 14:
                return onChangeSaveCardModelConvFeeTextGravity((ObservableInt) obj, i3);
            case 15:
                return onChangeSaveCardModelBankOfferBottomText((i) obj, i3);
            case 16:
                return onChangeSaveCardModelBankOfferVisibility((ObservableInt) obj, i3);
            case 17:
                return onChangeSaveCardModelConvFeeTextVisibility((ObservableInt) obj, i3);
            case 18:
                return onChangeSaveCardModelCashBackText((i) obj, i3);
            case 19:
                return onChangeSaveCardModelIsSingleVisaClickChecked((ObservableBoolean) obj, i3);
            case 20:
                return onChangeSaveCardModelAppliedOffersVisibility((ObservableInt) obj, i3);
            case 21:
                return onChangeSaveCardModelOfferApplicableText((i) obj, i3);
            case 22:
                return onChangeSaveCardModelBankOfferBottomVisibility((ObservableInt) obj, i3);
            case 23:
                return onChangeSaveCardModelSubventionOfferText((i) obj, i3);
            default:
                return false;
        }
    }

    private boolean onChangeSaveCardModelOfferApplicationVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeSaveCardModelCashBackTextVisibility(ObservableInt observableInt, int i2) {
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

    private boolean onChangeSaveCardModelLoaderMsg(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeSaveCardModelBankName(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeSaveCardModelCardNumber(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeSaveCardModelSubventionOfferVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeSaveCardModelShowVisaOneClick(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    private boolean onChangeSaveCardModelLoaderVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        return true;
    }

    private boolean onChangeSaveCardModelAmount(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        return true;
    }

    private boolean onChangeSaveCardModelConvFeeText(i<SpannableString> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1024;
        }
        return true;
    }

    private boolean onChangeSaveCardModelBankOfferText(i<SpannableString> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2048;
        }
        return true;
    }

    private boolean onChangeSaveCardModelPaySecurelyText(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4096;
        }
        return true;
    }

    private boolean onChangeSaveCardModel(SavedCardViewModel savedCardViewModel, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8192;
        }
        return true;
    }

    private boolean onChangeSaveCardModelConvFeeTextGravity(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16384;
        }
        return true;
    }

    private boolean onChangeSaveCardModelBankOfferBottomText(i<SpannableString> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32768;
        }
        return true;
    }

    private boolean onChangeSaveCardModelBankOfferVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 65536;
        }
        return true;
    }

    private boolean onChangeSaveCardModelConvFeeTextVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 131072;
        }
        return true;
    }

    private boolean onChangeSaveCardModelCashBackText(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 262144;
        }
        return true;
    }

    private boolean onChangeSaveCardModelIsSingleVisaClickChecked(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 524288;
        }
        return true;
    }

    private boolean onChangeSaveCardModelAppliedOffersVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1048576;
        }
        return true;
    }

    private boolean onChangeSaveCardModelOfferApplicableText(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2097152;
        }
        return true;
    }

    private boolean onChangeSaveCardModelBankOfferBottomVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4194304;
        }
        return true;
    }

    private boolean onChangeSaveCardModelSubventionOfferText(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8388608;
        }
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v7, resolved type: androidx.databinding.ObservableInt} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v13, resolved type: androidx.databinding.ObservableInt} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v14, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v9, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v16, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v17, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v20, resolved type: androidx.databinding.ObservableInt} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v21, resolved type: androidx.databinding.ObservableInt} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v23, resolved type: androidx.databinding.ObservableInt} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0181  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0190  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x01b8  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x01d1  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01e0  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x01f9  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0208  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x021f  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x022d  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0246  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0254  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x0281  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0290  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x02a7  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x02b9  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x02d2  */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x02e1  */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x02f8  */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x0306  */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x031d  */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x032b  */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x0344  */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x0352  */
    /* JADX WARNING: Removed duplicated region for block: B:249:0x037d  */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x038c  */
    /* JADX WARNING: Removed duplicated region for block: B:258:0x03a7  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:283:0x0453  */
    /* JADX WARNING: Removed duplicated region for block: B:293:0x046d  */
    /* JADX WARNING: Removed duplicated region for block: B:296:0x0478  */
    /* JADX WARNING: Removed duplicated region for block: B:307:0x0499  */
    /* JADX WARNING: Removed duplicated region for block: B:310:0x04a4  */
    /* JADX WARNING: Removed duplicated region for block: B:322:0x04c9  */
    /* JADX WARNING: Removed duplicated region for block: B:333:0x04ea  */
    /* JADX WARNING: Removed duplicated region for block: B:336:0x04f8  */
    /* JADX WARNING: Removed duplicated region for block: B:337:0x0500  */
    /* JADX WARNING: Removed duplicated region for block: B:340:0x050b  */
    /* JADX WARNING: Removed duplicated region for block: B:343:0x0519  */
    /* JADX WARNING: Removed duplicated region for block: B:346:0x0524  */
    /* JADX WARNING: Removed duplicated region for block: B:349:0x052f  */
    /* JADX WARNING: Removed duplicated region for block: B:352:0x053d  */
    /* JADX WARNING: Removed duplicated region for block: B:355:0x0559  */
    /* JADX WARNING: Removed duplicated region for block: B:358:0x0567  */
    /* JADX WARNING: Removed duplicated region for block: B:361:0x0575  */
    /* JADX WARNING: Removed duplicated region for block: B:364:0x0583  */
    /* JADX WARNING: Removed duplicated region for block: B:367:0x0591  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:370:0x059f  */
    /* JADX WARNING: Removed duplicated region for block: B:373:0x05ad  */
    /* JADX WARNING: Removed duplicated region for block: B:376:0x05bb  */
    /* JADX WARNING: Removed duplicated region for block: B:379:0x05c9  */
    /* JADX WARNING: Removed duplicated region for block: B:382:0x05d9  */
    /* JADX WARNING: Removed duplicated region for block: B:385:0x05e9  */
    /* JADX WARNING: Removed duplicated region for block: B:388:0x05f6  */
    /* JADX WARNING: Removed duplicated region for block: B:391:0x0606  */
    /* JADX WARNING: Removed duplicated region for block: B:394:0x0616  */
    /* JADX WARNING: Removed duplicated region for block: B:397:0x0626  */
    /* JADX WARNING: Removed duplicated region for block: B:400:0x0636  */
    /* JADX WARNING: Removed duplicated region for block: B:403:0x0646  */
    /* JADX WARNING: Removed duplicated region for block: B:406:0x0656  */
    /* JADX WARNING: Removed duplicated region for block: B:409:0x0666  */
    /* JADX WARNING: Removed duplicated region for block: B:412:0x067b  */
    /* JADX WARNING: Removed duplicated region for block: B:415:0x0690  */
    /* JADX WARNING: Removed duplicated region for block: B:424:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0117 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0131  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r69 = this;
            r1 = r69
            monitor-enter(r69)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x0698 }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x0698 }
            monitor-exit(r69)     // Catch:{ all -> 0x0698 }
            net.one97.paytm.nativesdk.instruments.savedCard.viewmodel.SavedCardViewModel r0 = r1.mSaveCardModel
            r6 = 50331647(0x2ffffff, double:2.48671377E-316)
            long r6 = r6 & r2
            r11 = 33562628(0x2002004, double:1.65821415E-316)
            r13 = 6
            r14 = 33562626(0x2002002, double:1.65821405E-316)
            r16 = 4294967296(0x100000000, double:2.121995791E-314)
            r18 = 33562625(0x2002001, double:1.658214E-316)
            r20 = 33693952(0x2022100, double:1.6647024E-316)
            r22 = 37756992(0x2402040, double:1.86544326E-316)
            r24 = 33628224(0x2012040, double:1.661455E-316)
            r8 = 1
            r9 = 0
            r29 = 0
            int r30 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r30 == 0) goto L_0x03ce
            long r6 = r2 & r18
            int r30 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r30 == 0) goto L_0x0047
            if (r0 == 0) goto L_0x003b
            androidx.databinding.ObservableInt r6 = r0.offerApplicationVisibility
            goto L_0x003d
        L_0x003b:
            r6 = r29
        L_0x003d:
            r1.updateRegistration((int) r9, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x0047
            int r6 = r6.get()
            goto L_0x0048
        L_0x0047:
            r6 = 0
        L_0x0048:
            long r30 = r2 & r14
            int r7 = (r30 > r4 ? 1 : (r30 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x005f
            if (r0 == 0) goto L_0x0053
            androidx.databinding.ObservableInt r7 = r0.cashBackTextVisibility
            goto L_0x0055
        L_0x0053:
            r7 = r29
        L_0x0055:
            r1.updateRegistration((int) r8, (androidx.databinding.h) r7)
            if (r7 == 0) goto L_0x005f
            int r7 = r7.get()
            goto L_0x0060
        L_0x005f:
            r7 = 0
        L_0x0060:
            long r30 = r2 & r11
            int r32 = (r30 > r4 ? 1 : (r30 == r4 ? 0 : -1))
            if (r32 == 0) goto L_0x0079
            if (r0 == 0) goto L_0x006b
            androidx.databinding.ObservableInt r8 = r0.lowSuccess
            goto L_0x006d
        L_0x006b:
            r8 = r29
        L_0x006d:
            r9 = 2
            r1.updateRegistration((int) r9, (androidx.databinding.h) r8)
            if (r8 == 0) goto L_0x0079
            int r8 = r8.get()
            r9 = r8
            goto L_0x007a
        L_0x0079:
            r9 = 0
        L_0x007a:
            r32 = 33562632(0x2002008, double:1.65821435E-316)
            long r32 = r2 & r32
            int r8 = (r32 > r4 ? 1 : (r32 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x0097
            if (r0 == 0) goto L_0x0088
            androidx.databinding.i<java.lang.String> r8 = r0.loaderMsg
            goto L_0x008a
        L_0x0088:
            r8 = r29
        L_0x008a:
            r11 = 3
            r1.updateRegistration((int) r11, (androidx.databinding.h) r8)
            if (r8 == 0) goto L_0x0097
            java.lang.Object r8 = r8.get()
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x0099
        L_0x0097:
            r8 = r29
        L_0x0099:
            r11 = 33562640(0x2002010, double:1.65821474E-316)
            long r11 = r11 & r2
            int r34 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r34 == 0) goto L_0x00b5
            if (r0 == 0) goto L_0x00a6
            androidx.databinding.i<java.lang.String> r11 = r0.bankName
            goto L_0x00a8
        L_0x00a6:
            r11 = r29
        L_0x00a8:
            r12 = 4
            r1.updateRegistration((int) r12, (androidx.databinding.h) r11)
            if (r11 == 0) goto L_0x00b5
            java.lang.Object r11 = r11.get()
            java.lang.String r11 = (java.lang.String) r11
            goto L_0x00b7
        L_0x00b5:
            r11 = r29
        L_0x00b7:
            r34 = 33562656(0x2002020, double:1.65821553E-316)
            long r34 = r2 & r34
            int r12 = (r34 > r4 ? 1 : (r34 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x00d4
            if (r0 == 0) goto L_0x00c5
            androidx.databinding.i<java.lang.String> r12 = r0.cardNumber
            goto L_0x00c7
        L_0x00c5:
            r12 = r29
        L_0x00c7:
            r14 = 5
            r1.updateRegistration((int) r14, (androidx.databinding.h) r12)
            if (r12 == 0) goto L_0x00d4
            java.lang.Object r12 = r12.get()
            java.lang.String r12 = (java.lang.String) r12
            goto L_0x00d6
        L_0x00d4:
            r12 = r29
        L_0x00d6:
            r14 = 33562688(0x2002040, double:1.6582171E-316)
            long r14 = r14 & r2
            int r36 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r36 == 0) goto L_0x00ef
            if (r0 == 0) goto L_0x00e3
            androidx.databinding.ObservableInt r14 = r0.subventionOfferVisibility
            goto L_0x00e5
        L_0x00e3:
            r14 = r29
        L_0x00e5:
            r1.updateRegistration((int) r13, (androidx.databinding.h) r14)
            if (r14 == 0) goto L_0x00f1
            int r15 = r14.get()
            goto L_0x00f2
        L_0x00ef:
            r14 = r29
        L_0x00f1:
            r15 = 0
        L_0x00f2:
            r36 = 33562752(0x2002080, double:1.65822027E-316)
            long r36 = r2 & r36
            int r38 = (r36 > r4 ? 1 : (r36 == r4 ? 0 : -1))
            if (r38 == 0) goto L_0x010d
            if (r0 == 0) goto L_0x0100
            androidx.databinding.ObservableInt r13 = r0.showVisaOneClick
            goto L_0x0102
        L_0x0100:
            r13 = r29
        L_0x0102:
            r10 = 7
            r1.updateRegistration((int) r10, (androidx.databinding.h) r13)
            if (r13 == 0) goto L_0x010d
            int r10 = r13.get()
            goto L_0x010e
        L_0x010d:
            r10 = 0
        L_0x010e:
            r38 = 33562624(0x2002000, double:1.65821395E-316)
            long r38 = r2 & r38
            int r13 = (r38 > r4 ? 1 : (r38 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x0129
            if (r0 == 0) goto L_0x0129
            net.one97.paytm.nativesdk.databinding.SaveCardLayout2BindingImpl$OnCheckedChangeListenerImpl r13 = r1.mSaveCardModelOneClickChangedAndroidWidgetCompoundButtonOnCheckedChangeListener
            if (r13 != 0) goto L_0x0124
            net.one97.paytm.nativesdk.databinding.SaveCardLayout2BindingImpl$OnCheckedChangeListenerImpl r13 = new net.one97.paytm.nativesdk.databinding.SaveCardLayout2BindingImpl$OnCheckedChangeListenerImpl
            r13.<init>()
            r1.mSaveCardModelOneClickChangedAndroidWidgetCompoundButtonOnCheckedChangeListener = r13
        L_0x0124:
            net.one97.paytm.nativesdk.databinding.SaveCardLayout2BindingImpl$OnCheckedChangeListenerImpl r13 = r13.setValue(r0)
            goto L_0x012b
        L_0x0129:
            r13 = r29
        L_0x012b:
            long r38 = r2 & r20
            int r40 = (r38 > r4 ? 1 : (r38 == r4 ? 0 : -1))
            if (r40 == 0) goto L_0x0159
            if (r0 == 0) goto L_0x0136
            androidx.databinding.ObservableInt r4 = r0.loaderVisibility
            goto L_0x0138
        L_0x0136:
            r4 = r29
        L_0x0138:
            r5 = 8
            r1.updateRegistration((int) r5, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x0144
            int r4 = r4.get()
            goto L_0x0145
        L_0x0144:
            r4 = 0
        L_0x0145:
            if (r4 != 0) goto L_0x0149
            r5 = 1
            goto L_0x014a
        L_0x0149:
            r5 = 0
        L_0x014a:
            if (r40 == 0) goto L_0x015b
            if (r5 == 0) goto L_0x0156
            r40 = 8589934592(0x200000000, double:4.243991582E-314)
            long r2 = r2 | r40
            goto L_0x015b
        L_0x0156:
            long r2 = r2 | r16
            goto L_0x015b
        L_0x0159:
            r4 = 0
            r5 = 0
        L_0x015b:
            r40 = 33563136(0x2002200, double:1.65823925E-316)
            long r40 = r2 & r40
            r38 = 0
            int r42 = (r40 > r38 ? 1 : (r40 == r38 ? 0 : -1))
            r40 = r4
            if (r42 == 0) goto L_0x0181
            if (r0 == 0) goto L_0x016f
            androidx.databinding.i<java.lang.String> r4 = r0.amount
            r41 = r5
            goto L_0x0173
        L_0x016f:
            r41 = r5
            r4 = r29
        L_0x0173:
            r5 = 9
            r1.updateRegistration((int) r5, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x0183
            java.lang.Object r4 = r4.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0185
        L_0x0181:
            r41 = r5
        L_0x0183:
            r4 = r29
        L_0x0185:
            r42 = 33563648(0x2002400, double:1.65826454E-316)
            long r42 = r2 & r42
            r38 = 0
            int r5 = (r42 > r38 ? 1 : (r42 == r38 ? 0 : -1))
            if (r5 == 0) goto L_0x01a9
            if (r0 == 0) goto L_0x0197
            androidx.databinding.i<android.text.SpannableString> r5 = r0.convFeeText
            r42 = r4
            goto L_0x019b
        L_0x0197:
            r42 = r4
            r5 = r29
        L_0x019b:
            r4 = 10
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x01ab
            java.lang.Object r4 = r5.get()
            android.text.SpannableString r4 = (android.text.SpannableString) r4
            goto L_0x01ad
        L_0x01a9:
            r42 = r4
        L_0x01ab:
            r4 = r29
        L_0x01ad:
            r43 = 33564672(0x2002800, double:1.65831513E-316)
            long r43 = r2 & r43
            r38 = 0
            int r5 = (r43 > r38 ? 1 : (r43 == r38 ? 0 : -1))
            if (r5 == 0) goto L_0x01d1
            if (r0 == 0) goto L_0x01bf
            androidx.databinding.i r5 = r0.bankOfferText
            r43 = r4
            goto L_0x01c3
        L_0x01bf:
            r43 = r4
            r5 = r29
        L_0x01c3:
            r4 = 11
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x01d3
            java.lang.Object r4 = r5.get()
            android.text.SpannableString r4 = (android.text.SpannableString) r4
            goto L_0x01d5
        L_0x01d1:
            r43 = r4
        L_0x01d3:
            r4 = r29
        L_0x01d5:
            r44 = 33566720(0x2003000, double:1.6584163E-316)
            long r44 = r2 & r44
            r38 = 0
            int r5 = (r44 > r38 ? 1 : (r44 == r38 ? 0 : -1))
            if (r5 == 0) goto L_0x01f9
            if (r0 == 0) goto L_0x01e7
            androidx.databinding.i<java.lang.String> r5 = r0.paySecurelyText
            r44 = r4
            goto L_0x01eb
        L_0x01e7:
            r44 = r4
            r5 = r29
        L_0x01eb:
            r4 = 12
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x01fb
            java.lang.Object r4 = r5.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x01fd
        L_0x01f9:
            r44 = r4
        L_0x01fb:
            r4 = r29
        L_0x01fd:
            r45 = 33579008(0x2006000, double:1.65902343E-316)
            long r45 = r2 & r45
            r38 = 0
            int r5 = (r45 > r38 ? 1 : (r45 == r38 ? 0 : -1))
            if (r5 == 0) goto L_0x021f
            if (r0 == 0) goto L_0x020f
            androidx.databinding.ObservableInt r5 = r0.convFeeTextGravity
            r45 = r4
            goto L_0x0213
        L_0x020f:
            r45 = r4
            r5 = r29
        L_0x0213:
            r4 = 14
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x0221
            int r4 = r5.get()
            goto L_0x0222
        L_0x021f:
            r45 = r4
        L_0x0221:
            r4 = 0
        L_0x0222:
            r46 = 33595392(0x200a000, double:1.6598329E-316)
            long r46 = r2 & r46
            r38 = 0
            int r5 = (r46 > r38 ? 1 : (r46 == r38 ? 0 : -1))
            if (r5 == 0) goto L_0x0246
            if (r0 == 0) goto L_0x0234
            androidx.databinding.i r5 = r0.bankOfferBottomText
            r46 = r4
            goto L_0x0238
        L_0x0234:
            r46 = r4
            r5 = r29
        L_0x0238:
            r4 = 15
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x0248
            java.lang.Object r4 = r5.get()
            android.text.SpannableString r4 = (android.text.SpannableString) r4
            goto L_0x024a
        L_0x0246:
            r46 = r4
        L_0x0248:
            r4 = r29
        L_0x024a:
            long r47 = r2 & r24
            r38 = 0
            int r5 = (r47 > r38 ? 1 : (r47 == r38 ? 0 : -1))
            r47 = r4
            if (r5 == 0) goto L_0x0281
            if (r0 == 0) goto L_0x025b
            androidx.databinding.ObservableInt r4 = r0.bankOfferVisibility
            r48 = r6
            goto L_0x025f
        L_0x025b:
            r48 = r6
            r4 = r29
        L_0x025f:
            r6 = 16
            r1.updateRegistration((int) r6, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x026b
            int r4 = r4.get()
            goto L_0x026c
        L_0x026b:
            r4 = 0
        L_0x026c:
            if (r4 != 0) goto L_0x0270
            r6 = 1
            goto L_0x0271
        L_0x0270:
            r6 = 0
        L_0x0271:
            if (r5 == 0) goto L_0x0285
            if (r6 == 0) goto L_0x027b
            r49 = 134217728(0x8000000, double:6.63123685E-316)
            long r2 = r2 | r49
            goto L_0x0285
        L_0x027b:
            r27 = 67108864(0x4000000, double:3.31561842E-316)
            long r2 = r2 | r27
            goto L_0x0285
        L_0x0281:
            r48 = r6
            r4 = 0
            r6 = 0
        L_0x0285:
            r49 = 33693696(0x2022000, double:1.66468977E-316)
            long r49 = r2 & r49
            r38 = 0
            int r5 = (r49 > r38 ? 1 : (r49 == r38 ? 0 : -1))
            if (r5 == 0) goto L_0x02a7
            if (r0 == 0) goto L_0x0297
            androidx.databinding.ObservableInt r5 = r0.convFeeTextVisibility
            r49 = r4
            goto L_0x029b
        L_0x0297:
            r49 = r4
            r5 = r29
        L_0x029b:
            r4 = 17
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x02ab
            int r4 = r5.get()
            goto L_0x02ac
        L_0x02a7:
            r49 = r4
            r5 = r29
        L_0x02ab:
            r4 = 0
        L_0x02ac:
            r50 = 33824768(0x2042000, double:1.6711656E-316)
            long r50 = r2 & r50
            r38 = 0
            int r52 = (r50 > r38 ? 1 : (r50 == r38 ? 0 : -1))
            r50 = r4
            if (r52 == 0) goto L_0x02d2
            if (r0 == 0) goto L_0x02c0
            androidx.databinding.i<java.lang.String> r4 = r0.cashBackText
            r51 = r5
            goto L_0x02c4
        L_0x02c0:
            r51 = r5
            r4 = r29
        L_0x02c4:
            r5 = 18
            r1.updateRegistration((int) r5, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x02d4
            java.lang.Object r4 = r4.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x02d6
        L_0x02d2:
            r51 = r5
        L_0x02d4:
            r4 = r29
        L_0x02d6:
            r52 = 34086912(0x2082000, double:1.6841172E-316)
            long r52 = r2 & r52
            r38 = 0
            int r5 = (r52 > r38 ? 1 : (r52 == r38 ? 0 : -1))
            if (r5 == 0) goto L_0x02f8
            if (r0 == 0) goto L_0x02e8
            androidx.databinding.ObservableBoolean r5 = r0.isSingleVisaClickChecked
            r52 = r4
            goto L_0x02ec
        L_0x02e8:
            r52 = r4
            r5 = r29
        L_0x02ec:
            r4 = 19
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x02fa
            boolean r4 = r5.get()
            goto L_0x02fb
        L_0x02f8:
            r52 = r4
        L_0x02fa:
            r4 = 0
        L_0x02fb:
            r53 = 34611200(0x2102000, double:1.7100205E-316)
            long r53 = r2 & r53
            r38 = 0
            int r5 = (r53 > r38 ? 1 : (r53 == r38 ? 0 : -1))
            if (r5 == 0) goto L_0x031d
            if (r0 == 0) goto L_0x030d
            androidx.databinding.ObservableInt r5 = r0.appliedOffersVisibility
            r53 = r4
            goto L_0x0311
        L_0x030d:
            r53 = r4
            r5 = r29
        L_0x0311:
            r4 = 20
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x031f
            int r4 = r5.get()
            goto L_0x0320
        L_0x031d:
            r53 = r4
        L_0x031f:
            r4 = 0
        L_0x0320:
            r54 = 35659776(0x2202000, double:1.76182703E-316)
            long r54 = r2 & r54
            r38 = 0
            int r5 = (r54 > r38 ? 1 : (r54 == r38 ? 0 : -1))
            if (r5 == 0) goto L_0x0344
            if (r0 == 0) goto L_0x0332
            androidx.databinding.i<java.lang.String> r5 = r0.offerApplicableText
            r54 = r4
            goto L_0x0336
        L_0x0332:
            r54 = r4
            r5 = r29
        L_0x0336:
            r4 = 21
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x0346
            java.lang.Object r4 = r5.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0348
        L_0x0344:
            r54 = r4
        L_0x0346:
            r4 = r29
        L_0x0348:
            long r55 = r2 & r22
            r38 = 0
            int r5 = (r55 > r38 ? 1 : (r55 == r38 ? 0 : -1))
            r55 = r4
            if (r5 == 0) goto L_0x037d
            if (r0 == 0) goto L_0x0359
            androidx.databinding.ObservableInt r4 = r0.bankOfferBottomVisibility
            r56 = r6
            goto L_0x035d
        L_0x0359:
            r56 = r6
            r4 = r29
        L_0x035d:
            r6 = 22
            r1.updateRegistration((int) r6, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x0369
            int r4 = r4.get()
            goto L_0x036a
        L_0x0369:
            r4 = 0
        L_0x036a:
            if (r4 != 0) goto L_0x036e
            r6 = 1
            goto L_0x036f
        L_0x036e:
            r6 = 0
        L_0x036f:
            if (r5 == 0) goto L_0x0381
            if (r6 == 0) goto L_0x0377
            r57 = 536870912(0x20000000, double:2.652494739E-315)
            goto L_0x037a
        L_0x0377:
            r57 = 268435456(0x10000000, double:1.32624737E-315)
        L_0x037a:
            long r2 = r2 | r57
            goto L_0x0381
        L_0x037d:
            r56 = r6
            r4 = 0
            r6 = 0
        L_0x0381:
            r57 = 41951232(0x2802000, double:2.07266625E-316)
            long r57 = r2 & r57
            r38 = 0
            int r5 = (r57 > r38 ? 1 : (r57 == r38 ? 0 : -1))
            if (r5 == 0) goto L_0x03a7
            if (r0 == 0) goto L_0x0393
            androidx.databinding.i<java.lang.String> r5 = r0.subventionOfferText
            r57 = r2
            goto L_0x0397
        L_0x0393:
            r57 = r2
            r5 = r29
        L_0x0397:
            r2 = 23
            r1.updateRegistration((int) r2, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x03a9
            java.lang.Object r2 = r5.get()
            r29 = r2
            java.lang.String r29 = (java.lang.String) r29
            goto L_0x03a9
        L_0x03a7:
            r57 = r2
        L_0x03a9:
            r62 = r4
            r63 = r8
            r66 = r29
            r2 = r40
            r67 = r42
            r64 = r43
            r8 = r45
            r65 = r46
            r61 = r47
            r60 = r48
            r5 = r52
            r3 = r53
            r4 = r54
            r59 = r55
            r29 = r14
            r40 = r15
            r14 = r44
            r15 = r49
            goto L_0x03fb
        L_0x03ce:
            r57 = r2
            r5 = r29
            r8 = r5
            r11 = r8
            r12 = r11
            r13 = r12
            r14 = r13
            r51 = r14
            r59 = r51
            r61 = r59
            r63 = r61
            r64 = r63
            r66 = r64
            r67 = r66
            r2 = 0
            r3 = 0
            r4 = 0
            r6 = 0
            r7 = 0
            r9 = 0
            r10 = 0
            r15 = 0
            r40 = 0
            r41 = 0
            r50 = 0
            r56 = 0
            r60 = 0
            r62 = 0
            r65 = 0
        L_0x03fb:
            r42 = 603979776(0x24000000, double:2.98405658E-315)
            long r42 = r57 & r42
            r38 = 0
            int r44 = (r42 > r38 ? 1 : (r42 == r38 ? 0 : -1))
            if (r44 == 0) goto L_0x043f
            r42 = r15
            if (r0 == 0) goto L_0x040d
            androidx.databinding.ObservableInt r15 = r0.subventionOfferVisibility
            goto L_0x040f
        L_0x040d:
            r15 = r29
        L_0x040f:
            r29 = r14
            r14 = 6
            r1.updateRegistration((int) r14, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x041b
            int r40 = r15.get()
        L_0x041b:
            r14 = r40
            r27 = 67108864(0x4000000, double:3.31561842E-316)
            long r27 = r57 & r27
            r38 = 0
            int r15 = (r27 > r38 ? 1 : (r27 == r38 ? 0 : -1))
            if (r15 == 0) goto L_0x042c
            if (r14 != 0) goto L_0x042c
            r15 = 1
            goto L_0x042d
        L_0x042c:
            r15 = 0
        L_0x042d:
            r27 = 536870912(0x20000000, double:2.652494739E-315)
            long r27 = r57 & r27
            int r36 = (r27 > r38 ? 1 : (r27 == r38 ? 0 : -1))
            r27 = r15
            r15 = 8
            if (r36 == 0) goto L_0x044b
            if (r14 != r15) goto L_0x044b
            r28 = 1
            goto L_0x044d
        L_0x043f:
            r29 = r14
            r42 = r15
            r15 = 8
            r38 = 0
            r14 = r40
            r27 = 0
        L_0x044b:
            r28 = 0
        L_0x044d:
            long r16 = r57 & r16
            int r36 = (r16 > r38 ? 1 : (r16 == r38 ? 0 : -1))
            if (r36 == 0) goto L_0x046d
            if (r0 == 0) goto L_0x0458
            androidx.databinding.ObservableInt r0 = r0.convFeeTextVisibility
            goto L_0x045a
        L_0x0458:
            r0 = r51
        L_0x045a:
            r15 = 17
            r1.updateRegistration((int) r15, (androidx.databinding.h) r0)
            if (r0 == 0) goto L_0x0465
            int r50 = r0.get()
        L_0x0465:
            if (r50 != 0) goto L_0x0469
            r0 = 1
            goto L_0x046a
        L_0x0469:
            r0 = 0
        L_0x046a:
            r15 = r50
            goto L_0x0470
        L_0x046d:
            r15 = r50
            r0 = 0
        L_0x0470:
            long r16 = r57 & r24
            r38 = 0
            int r26 = (r16 > r38 ? 1 : (r16 == r38 ? 0 : -1))
            if (r26 == 0) goto L_0x0499
            if (r56 == 0) goto L_0x047c
            r27 = 1
        L_0x047c:
            if (r26 == 0) goto L_0x048b
            if (r27 == 0) goto L_0x0486
            r16 = 2147483648(0x80000000, double:1.0609978955E-314)
            goto L_0x0489
        L_0x0486:
            r16 = 1073741824(0x40000000, double:5.304989477E-315)
        L_0x0489:
            long r57 = r57 | r16
        L_0x048b:
            if (r27 == 0) goto L_0x0490
            r16 = 0
            goto L_0x0492
        L_0x0490:
            r16 = 8
        L_0x0492:
            r68 = r16
            r16 = r0
            r0 = r68
            goto L_0x049c
        L_0x0499:
            r16 = r0
            r0 = 0
        L_0x049c:
            long r26 = r57 & r22
            r38 = 0
            int r17 = (r26 > r38 ? 1 : (r26 == r38 ? 0 : -1))
            if (r17 == 0) goto L_0x04c0
            if (r6 == 0) goto L_0x04a7
            goto L_0x04a9
        L_0x04a7:
            r28 = 0
        L_0x04a9:
            if (r17 == 0) goto L_0x04ba
            if (r28 == 0) goto L_0x04b3
            r26 = 34359738368(0x800000000, double:1.69759663277E-313)
            goto L_0x04b8
        L_0x04b3:
            r26 = 17179869184(0x400000000, double:8.4879831639E-314)
        L_0x04b8:
            long r57 = r57 | r26
        L_0x04ba:
            if (r28 == 0) goto L_0x04bd
            goto L_0x04c0
        L_0x04bd:
            r6 = 8
            goto L_0x04c1
        L_0x04c0:
            r6 = 0
        L_0x04c1:
            long r26 = r57 & r20
            r38 = 0
            int r17 = (r26 > r38 ? 1 : (r26 == r38 ? 0 : -1))
            if (r17 == 0) goto L_0x04ea
            if (r41 == 0) goto L_0x04cd
            r16 = 1
        L_0x04cd:
            if (r17 == 0) goto L_0x04de
            if (r16 == 0) goto L_0x04d7
            r26 = 137438953472(0x2000000000, double:6.7903865311E-313)
            goto L_0x04dc
        L_0x04d7:
            r26 = 68719476736(0x1000000000, double:3.39519326554E-313)
        L_0x04dc:
            long r57 = r57 | r26
        L_0x04de:
            if (r16 == 0) goto L_0x04e3
            r31 = 0
            goto L_0x04e5
        L_0x04e3:
            r31 = 8
        L_0x04e5:
            r16 = r14
            r14 = r31
            goto L_0x04ed
        L_0x04ea:
            r16 = r14
            r14 = 0
        L_0x04ed:
            r26 = 34086912(0x2082000, double:1.6841172E-316)
            long r26 = r57 & r26
            r30 = 0
            int r17 = (r26 > r30 ? 1 : (r26 == r30 ? 0 : -1))
            if (r17 == 0) goto L_0x0500
            r17 = r15
            android.widget.CheckBox r15 = r1.cbOneClick
            androidx.databinding.a.a.a(r15, r3)
            goto L_0x0502
        L_0x0500:
            r17 = r15
        L_0x0502:
            r26 = 33562624(0x2002000, double:1.65821395E-316)
            long r26 = r57 & r26
            int r3 = (r26 > r30 ? 1 : (r26 == r30 ? 0 : -1))
            if (r3 == 0) goto L_0x0510
            android.widget.CheckBox r3 = r1.cbOneClick
            r3.setOnCheckedChangeListener(r13)
        L_0x0510:
            r26 = 33562880(0x2002100, double:1.6582266E-316)
            long r26 = r57 & r26
            int r3 = (r26 > r30 ? 1 : (r26 == r30 ? 0 : -1))
            if (r3 == 0) goto L_0x051e
            android.widget.LinearLayout r3 = r1.llCheckOffer
            r3.setVisibility(r2)
        L_0x051e:
            long r2 = r57 & r24
            int r13 = (r2 > r30 ? 1 : (r2 == r30 ? 0 : -1))
            if (r13 == 0) goto L_0x0529
            android.widget.RelativeLayout r2 = r1.llOfferView
            r2.setVisibility(r0)
        L_0x0529:
            long r2 = r57 & r22
            int r0 = (r2 > r30 ? 1 : (r2 == r30 ? 0 : -1))
            if (r0 == 0) goto L_0x0534
            android.widget.RelativeLayout r0 = r1.llOfferViewBottom
            r0.setVisibility(r6)
        L_0x0534:
            r2 = 34611200(0x2102000, double:1.7100205E-316)
            long r2 = r57 & r2
            int r0 = (r2 > r30 ? 1 : (r2 == r30 ? 0 : -1))
            if (r0 == 0) goto L_0x0551
            android.view.View r0 = r1.mboundView12
            r0.setVisibility(r4)
            android.view.View r0 = r1.mboundView23
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.tvAppliedOffers
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.tvAppliedOffersBottom
            r0.setVisibility(r4)
        L_0x0551:
            long r2 = r57 & r20
            r20 = 0
            int r0 = (r2 > r20 ? 1 : (r2 == r20 ? 0 : -1))
            if (r0 == 0) goto L_0x055e
            android.widget.FrameLayout r0 = r1.mboundView13
            r0.setVisibility(r14)
        L_0x055e:
            r2 = 33824768(0x2042000, double:1.6711656E-316)
            long r2 = r57 & r2
            int r0 = (r2 > r20 ? 1 : (r2 == r20 ? 0 : -1))
            if (r0 == 0) goto L_0x056c
            android.widget.TextView r0 = r1.mboundView18
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r5)
        L_0x056c:
            r2 = 33562626(0x2002002, double:1.65821405E-316)
            long r2 = r57 & r2
            int r0 = (r2 > r20 ? 1 : (r2 == r20 ? 0 : -1))
            if (r0 == 0) goto L_0x057a
            android.widget.TextView r0 = r1.mboundView18
            r0.setVisibility(r7)
        L_0x057a:
            r2 = 33562752(0x2002080, double:1.65822027E-316)
            long r2 = r57 & r2
            int r0 = (r2 > r20 ? 1 : (r2 == r20 ? 0 : -1))
            if (r0 == 0) goto L_0x0588
            android.widget.RelativeLayout r0 = r1.oneClickContainer
            r0.setVisibility(r10)
        L_0x0588:
            r2 = 33566720(0x2003000, double:1.6584163E-316)
            long r2 = r57 & r2
            int r0 = (r2 > r20 ? 1 : (r2 == r20 ? 0 : -1))
            if (r0 == 0) goto L_0x0596
            android.widget.TextView r0 = r1.paysecurely
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r8)
        L_0x0596:
            r2 = 33562640(0x2002010, double:1.65821474E-316)
            long r2 = r57 & r2
            int r0 = (r2 > r20 ? 1 : (r2 == r20 ? 0 : -1))
            if (r0 == 0) goto L_0x05a4
            android.widget.RadioButton r0 = r1.rbCardNumber
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r11)
        L_0x05a4:
            r2 = 33562628(0x2002004, double:1.65821415E-316)
            long r2 = r57 & r2
            int r0 = (r2 > r20 ? 1 : (r2 == r20 ? 0 : -1))
            if (r0 == 0) goto L_0x05b2
            android.widget.TextView r0 = r1.textViewLowSuccess
            r0.setVisibility(r9)
        L_0x05b2:
            r2 = 33562656(0x2002020, double:1.65821553E-316)
            long r2 = r57 & r2
            int r0 = (r2 > r20 ? 1 : (r2 == r20 ? 0 : -1))
            if (r0 == 0) goto L_0x05c0
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvBankName
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r12)
        L_0x05c0:
            r2 = 33564672(0x2002800, double:1.65831513E-316)
            long r2 = r57 & r2
            int r0 = (r2 > r20 ? 1 : (r2 == r20 ? 0 : -1))
            if (r0 == 0) goto L_0x05d0
            android.widget.TextView r0 = r1.tvBankOffer
            r2 = r29
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r2)
        L_0x05d0:
            r2 = 33628160(0x2012000, double:1.66145186E-316)
            long r2 = r57 & r2
            int r0 = (r2 > r20 ? 1 : (r2 == r20 ? 0 : -1))
            if (r0 == 0) goto L_0x05e0
            android.widget.TextView r0 = r1.tvBankOffer
            r2 = r42
            r0.setVisibility(r2)
        L_0x05e0:
            r2 = 35659776(0x2202000, double:1.76182703E-316)
            long r2 = r57 & r2
            int r0 = (r2 > r20 ? 1 : (r2 == r20 ? 0 : -1))
            if (r0 == 0) goto L_0x05f0
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvBankOfferApplicable
            r2 = r59
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r2)
        L_0x05f0:
            long r2 = r57 & r18
            int r0 = (r2 > r20 ? 1 : (r2 == r20 ? 0 : -1))
            if (r0 == 0) goto L_0x05fd
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvBankOfferApplicable
            r2 = r60
            r0.setVisibility(r2)
        L_0x05fd:
            r2 = 33595392(0x200a000, double:1.6598329E-316)
            long r2 = r57 & r2
            int r0 = (r2 > r20 ? 1 : (r2 == r20 ? 0 : -1))
            if (r0 == 0) goto L_0x060d
            android.widget.TextView r0 = r1.tvBankOfferBottom
            r2 = r61
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r2)
        L_0x060d:
            r2 = 37756928(0x2402000, double:1.8654401E-316)
            long r2 = r57 & r2
            int r0 = (r2 > r20 ? 1 : (r2 == r20 ? 0 : -1))
            if (r0 == 0) goto L_0x061d
            android.widget.TextView r0 = r1.tvBankOfferBottom
            r4 = r62
            r0.setVisibility(r4)
        L_0x061d:
            r2 = 33562632(0x2002008, double:1.65821435E-316)
            long r2 = r57 & r2
            int r0 = (r2 > r20 ? 1 : (r2 == r20 ? 0 : -1))
            if (r0 == 0) goto L_0x062d
            android.widget.TextView r0 = r1.tvCheckingOffers
            r8 = r63
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r8)
        L_0x062d:
            r2 = 33563648(0x2002400, double:1.65826454E-316)
            long r2 = r57 & r2
            int r0 = (r2 > r20 ? 1 : (r2 == r20 ? 0 : -1))
            if (r0 == 0) goto L_0x063d
            android.widget.TextView r0 = r1.tvConvFee
            r2 = r64
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r2)
        L_0x063d:
            r2 = 33579008(0x2006000, double:1.65902343E-316)
            long r2 = r57 & r2
            int r0 = (r2 > r20 ? 1 : (r2 == r20 ? 0 : -1))
            if (r0 == 0) goto L_0x064d
            android.widget.TextView r0 = r1.tvConvFee
            r2 = r65
            r0.setGravity(r2)
        L_0x064d:
            r2 = 33693696(0x2022000, double:1.66468977E-316)
            long r2 = r57 & r2
            int r0 = (r2 > r20 ? 1 : (r2 == r20 ? 0 : -1))
            if (r0 == 0) goto L_0x065d
            android.widget.TextView r0 = r1.tvConvFee
            r2 = r17
            r0.setVisibility(r2)
        L_0x065d:
            r2 = 33562688(0x2002040, double:1.6582171E-316)
            long r2 = r57 & r2
            int r0 = (r2 > r20 ? 1 : (r2 == r20 ? 0 : -1))
            if (r0 == 0) goto L_0x0672
            android.widget.TextView r0 = r1.tvSubventionOffer
            r14 = r16
            r0.setVisibility(r14)
            android.widget.TextView r0 = r1.tvSubventionOfferBottom
            r0.setVisibility(r14)
        L_0x0672:
            r2 = 41951232(0x2802000, double:2.07266625E-316)
            long r2 = r57 & r2
            int r0 = (r2 > r20 ? 1 : (r2 == r20 ? 0 : -1))
            if (r0 == 0) goto L_0x0687
            android.widget.TextView r0 = r1.tvSubventionOffer
            r2 = r66
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r2)
            android.widget.TextView r0 = r1.tvSubventionOfferBottom
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r2)
        L_0x0687:
            r2 = 33563136(0x2002200, double:1.65823925E-316)
            long r2 = r57 & r2
            int r0 = (r2 > r20 ? 1 : (r2 == r20 ? 0 : -1))
            if (r0 == 0) goto L_0x0697
            android.widget.TextView r0 = r1.txtamount
            r2 = r67
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r2)
        L_0x0697:
            return
        L_0x0698:
            r0 = move-exception
            monitor-exit(r69)     // Catch:{ all -> 0x0698 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.databinding.SaveCardLayout2BindingImpl.executeBindings():void");
    }

    public static class OnCheckedChangeListenerImpl implements CompoundButton.OnCheckedChangeListener {
        private SavedCardViewModel value;

        public OnCheckedChangeListenerImpl setValue(SavedCardViewModel savedCardViewModel) {
            this.value = savedCardViewModel;
            if (savedCardViewModel == null) {
                return null;
            }
            return this;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.value.oneClickChanged(compoundButton, z);
        }
    }
}
