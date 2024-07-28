package net.one97.paytm.nativesdk.databinding;

import android.text.SpannableString;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import androidx.databinding.i;
import net.one97.paytm.nativesdk.BR;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.instruments.wallet.viewmodel.WalletViewModel;
import net.one97.paytm.nativesdk.widget.RoboTextView;

public class WalletLytInstrumentInfoBindingImpl extends WalletLytInstrumentInfoBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private OnCheckedChangeListenerImpl mWalletViewModelOnWalletCheckChangedAndroidWidgetCompoundButtonOnCheckedChangeListener;
    private OnClickListenerImpl mWalletViewModelProceedClickedAndroidViewViewOnClickListener;
    private final TextView mboundView16;
    private final RoboTextView mboundView7;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.ll_wallet_select_container, 20);
        sViewsWithIds.put(R.id.ll_instrument_info, 21);
        sViewsWithIds.put(R.id.ll_walletBalance, 22);
        sViewsWithIds.put(R.id.ltv_getOffers, 23);
        sViewsWithIds.put(R.id.ltv_loading, 24);
    }

    public WalletLytInstrumentInfoBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 25, sIncludes, sViewsWithIds));
    }

    private WalletLytInstrumentInfoBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 23, objArr[6], objArr[14], objArr[10], objArr[11], objArr[21], objArr[22], objArr[20], objArr[0], objArr[23], objArr[24], objArr[15], objArr[1], objArr[9], objArr[12], objArr[13], objArr[18], objArr[3], objArr[17], objArr[8], objArr[2], objArr[5], objArr[4], objArr[19]);
        this.mDirtyFlags = -1;
        this.addPayHybridLayout.setTag((Object) null);
        this.btnProceed.setTag((Object) null);
        this.flLoader.setTag((Object) null);
        this.llCheckOffer.setTag((Object) null);
        this.llWalletView.setTag((Object) null);
        this.mboundView16 = objArr[16];
        this.mboundView16.setTag((Object) null);
        this.mboundView7 = objArr[7];
        this.mboundView7.setTag((Object) null);
        this.paysecurely.setTag((Object) null);
        this.rbCardNumber.setTag((Object) null);
        this.tvBankOffer.setTag((Object) null);
        this.tvCheckingOffers.setTag((Object) null);
        this.tvConvFee.setTag((Object) null);
        this.tvSendOtp.setTag((Object) null);
        this.tvWalletBalance.setTag((Object) null);
        this.tvWalletOtpTc.setTag((Object) null);
        this.txtAmount.setTag((Object) null);
        this.txtPrimaryInfo.setTag((Object) null);
        this.txtSecondaryInfo.setTag((Object) null);
        this.txtamount.setTag((Object) null);
        this.walletOtpView.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16777216;
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
        } else if (BR.walletViewModel != i2) {
            return false;
        } else {
            setWalletViewModel((WalletViewModel) obj);
        }
        return true;
    }

    public void setView(View view) {
        this.mView = view;
    }

    public void setWalletViewModel(WalletViewModel walletViewModel) {
        updateRegistration(21, (h) walletViewModel);
        this.mWalletViewModel = walletViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 2097152;
        }
        notifyPropertyChanged(BR.walletViewModel);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return onChangeWalletViewModelAddPayHybridAmountText((i) obj, i3);
            case 1:
                return onChangeWalletViewModelWalletBalance((i) obj, i3);
            case 2:
                return onChangeWalletViewModelAvailableVisibilityBalance((ObservableInt) obj, i3);
            case 3:
                return onChangeWalletViewModelConvFeeTextVisibility((ObservableInt) obj, i3);
            case 4:
                return onChangeWalletViewModelMPrimaryInformation((i) obj, i3);
            case 5:
                return onChangeWalletViewModelPaySecurelyText((i) obj, i3);
            case 6:
                return onChangeWalletViewModelProceedVisible((ObservableInt) obj, i3);
            case 7:
                return onChangeWalletViewModelWalletBalanceVisibility((ObservableInt) obj, i3);
            case 8:
                return onChangeWalletViewModelConvFeeText((i) obj, i3);
            case 9:
                return onChangeWalletViewModelCashBackText((i) obj, i3);
            case 10:
                return onChangeWalletViewModelLoaderMsg((i) obj, i3);
            case 11:
                return onChangeWalletViewModelMSecondaryInformation((i) obj, i3);
            case 12:
                return onChangeWalletViewModelWalletSendOtpButtVisibility((ObservableInt) obj, i3);
            case 13:
                return onChangeWalletViewModelBankOfferVisibility((ObservableInt) obj, i3);
            case 14:
                return onChangeWalletViewModelAddPayHybridText((i) obj, i3);
            case 15:
                return onChangeWalletViewModelAmount((i) obj, i3);
            case 16:
                return onChangeWalletViewModelBankOfferText((i) obj, i3);
            case 17:
                return onChangeWalletViewModelLoaderVisibility((ObservableInt) obj, i3);
            case 18:
                return onChangeWalletViewModelWalletOtpTxtVisibility((ObservableInt) obj, i3);
            case 19:
                return onChangeWalletViewModelAddPayHybridLayoutVisibility((ObservableInt) obj, i3);
            case 20:
                return onChangeWalletViewModelCashBackTextVisibility((ObservableInt) obj, i3);
            case 21:
                return onChangeWalletViewModel((WalletViewModel) obj, i3);
            case 22:
                return onChangeWalletViewModelOtpViewVisibilty((ObservableInt) obj, i3);
            default:
                return false;
        }
    }

    private boolean onChangeWalletViewModelAddPayHybridAmountText(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeWalletViewModelWalletBalance(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeWalletViewModelAvailableVisibilityBalance(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeWalletViewModelConvFeeTextVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeWalletViewModelMPrimaryInformation(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeWalletViewModelPaySecurelyText(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeWalletViewModelProceedVisible(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeWalletViewModelWalletBalanceVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    private boolean onChangeWalletViewModelConvFeeText(i<SpannableString> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        return true;
    }

    private boolean onChangeWalletViewModelCashBackText(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        return true;
    }

    private boolean onChangeWalletViewModelLoaderMsg(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1024;
        }
        return true;
    }

    private boolean onChangeWalletViewModelMSecondaryInformation(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2048;
        }
        return true;
    }

    private boolean onChangeWalletViewModelWalletSendOtpButtVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4096;
        }
        return true;
    }

    private boolean onChangeWalletViewModelBankOfferVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8192;
        }
        return true;
    }

    private boolean onChangeWalletViewModelAddPayHybridText(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16384;
        }
        return true;
    }

    private boolean onChangeWalletViewModelAmount(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32768;
        }
        return true;
    }

    private boolean onChangeWalletViewModelBankOfferText(i<SpannableString> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 65536;
        }
        return true;
    }

    private boolean onChangeWalletViewModelLoaderVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 131072;
        }
        return true;
    }

    private boolean onChangeWalletViewModelWalletOtpTxtVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 262144;
        }
        return true;
    }

    private boolean onChangeWalletViewModelAddPayHybridLayoutVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 524288;
        }
        return true;
    }

    private boolean onChangeWalletViewModelCashBackTextVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1048576;
        }
        return true;
    }

    private boolean onChangeWalletViewModel(WalletViewModel walletViewModel, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2097152;
        }
        return true;
    }

    private boolean onChangeWalletViewModelOtpViewVisibilty(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4194304;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x01cb  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01e1  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x01ef  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x0205  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0213  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x022b  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x023b  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x0274  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x0283  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x029b  */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x02a8  */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x02d1  */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x02e0  */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x02f6  */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x0301  */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x0317  */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x0325  */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x033b  */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x0349  */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x0385  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b6 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x014b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r67 = this;
            r1 = r67
            monitor-enter(r67)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x0596 }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x0596 }
            monitor-exit(r67)     // Catch:{ all -> 0x0596 }
            net.one97.paytm.nativesdk.instruments.wallet.viewmodel.WalletViewModel r0 = r1.mWalletViewModel
            r6 = 25165823(0x17fffff, double:1.24335686E-316)
            long r6 = r6 & r2
            r10 = 18874376(0x1200008, double:9.325181E-317)
            r14 = 18874372(0x1200004, double:9.325179E-317)
            r8 = 3
            r18 = 19398656(0x1280000, double:9.5842095E-317)
            r20 = 18874370(0x1200002, double:9.325178E-317)
            r22 = 18874369(0x1200001, double:9.3251773E-317)
            r24 = 536870912(0x20000000, double:2.652494739E-315)
            r26 = 19005448(0x1220008, double:9.389939E-317)
            r9 = 1
            r12 = 0
            int r29 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r29 == 0) goto L_0x03b1
            long r6 = r2 & r22
            int r29 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r29 == 0) goto L_0x0044
            if (r0 == 0) goto L_0x0037
            androidx.databinding.i<java.lang.String> r6 = r0.addPayHybridAmountText
            goto L_0x0038
        L_0x0037:
            r6 = 0
        L_0x0038:
            r1.updateRegistration((int) r12, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x0044
            java.lang.Object r6 = r6.get()
            java.lang.String r6 = (java.lang.String) r6
            goto L_0x0045
        L_0x0044:
            r6 = 0
        L_0x0045:
            long r29 = r2 & r20
            int r7 = (r29 > r4 ? 1 : (r29 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x005d
            if (r0 == 0) goto L_0x0050
            androidx.databinding.i<java.lang.String> r7 = r0.walletBalance
            goto L_0x0051
        L_0x0050:
            r7 = 0
        L_0x0051:
            r1.updateRegistration((int) r9, (androidx.databinding.h) r7)
            if (r7 == 0) goto L_0x005d
            java.lang.Object r7 = r7.get()
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x005e
        L_0x005d:
            r7 = 0
        L_0x005e:
            long r29 = r2 & r14
            int r31 = (r29 > r4 ? 1 : (r29 == r4 ? 0 : -1))
            if (r31 == 0) goto L_0x0076
            if (r0 == 0) goto L_0x0069
            androidx.databinding.ObservableInt r9 = r0.availableVisibilityBalance
            goto L_0x006a
        L_0x0069:
            r9 = 0
        L_0x006a:
            r12 = 2
            r1.updateRegistration((int) r12, (androidx.databinding.h) r9)
            if (r9 == 0) goto L_0x0076
            int r9 = r9.get()
            r12 = r9
            goto L_0x0077
        L_0x0076:
            r12 = 0
        L_0x0077:
            long r31 = r2 & r10
            int r9 = (r31 > r4 ? 1 : (r31 == r4 ? 0 : -1))
            if (r9 == 0) goto L_0x008d
            if (r0 == 0) goto L_0x0082
            androidx.databinding.ObservableInt r9 = r0.convFeeTextVisibility
            goto L_0x0083
        L_0x0082:
            r9 = 0
        L_0x0083:
            r1.updateRegistration((int) r8, (androidx.databinding.h) r9)
            if (r9 == 0) goto L_0x008e
            int r31 = r9.get()
            goto L_0x0090
        L_0x008d:
            r9 = 0
        L_0x008e:
            r31 = 0
        L_0x0090:
            r32 = 18874384(0x1200010, double:9.3251847E-317)
            long r32 = r2 & r32
            int r34 = (r32 > r4 ? 1 : (r32 == r4 ? 0 : -1))
            if (r34 == 0) goto L_0x00ac
            if (r0 == 0) goto L_0x009e
            androidx.databinding.i<java.lang.String> r13 = r0.mPrimaryInformation
            goto L_0x009f
        L_0x009e:
            r13 = 0
        L_0x009f:
            r14 = 4
            r1.updateRegistration((int) r14, (androidx.databinding.h) r13)
            if (r13 == 0) goto L_0x00ac
            java.lang.Object r13 = r13.get()
            java.lang.String r13 = (java.lang.String) r13
            goto L_0x00ad
        L_0x00ac:
            r13 = 0
        L_0x00ad:
            r14 = 18874368(0x1200000, double:9.325177E-317)
            long r35 = r2 & r14
            int r14 = (r35 > r4 ? 1 : (r35 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x00d7
            if (r0 == 0) goto L_0x00d7
            net.one97.paytm.nativesdk.databinding.WalletLytInstrumentInfoBindingImpl$OnCheckedChangeListenerImpl r14 = r1.mWalletViewModelOnWalletCheckChangedAndroidWidgetCompoundButtonOnCheckedChangeListener
            if (r14 != 0) goto L_0x00c3
            net.one97.paytm.nativesdk.databinding.WalletLytInstrumentInfoBindingImpl$OnCheckedChangeListenerImpl r14 = new net.one97.paytm.nativesdk.databinding.WalletLytInstrumentInfoBindingImpl$OnCheckedChangeListenerImpl
            r14.<init>()
            r1.mWalletViewModelOnWalletCheckChangedAndroidWidgetCompoundButtonOnCheckedChangeListener = r14
        L_0x00c3:
            net.one97.paytm.nativesdk.databinding.WalletLytInstrumentInfoBindingImpl$OnCheckedChangeListenerImpl r14 = r14.setValue(r0)
            net.one97.paytm.nativesdk.databinding.WalletLytInstrumentInfoBindingImpl$OnClickListenerImpl r15 = r1.mWalletViewModelProceedClickedAndroidViewViewOnClickListener
            if (r15 != 0) goto L_0x00d2
            net.one97.paytm.nativesdk.databinding.WalletLytInstrumentInfoBindingImpl$OnClickListenerImpl r15 = new net.one97.paytm.nativesdk.databinding.WalletLytInstrumentInfoBindingImpl$OnClickListenerImpl
            r15.<init>()
            r1.mWalletViewModelProceedClickedAndroidViewViewOnClickListener = r15
        L_0x00d2:
            net.one97.paytm.nativesdk.databinding.WalletLytInstrumentInfoBindingImpl$OnClickListenerImpl r15 = r15.setValue(r0)
            goto L_0x00d9
        L_0x00d7:
            r14 = 0
            r15 = 0
        L_0x00d9:
            r35 = 18874400(0x1200020, double:9.3251926E-317)
            long r35 = r2 & r35
            int r37 = (r35 > r4 ? 1 : (r35 == r4 ? 0 : -1))
            if (r37 == 0) goto L_0x00f5
            if (r0 == 0) goto L_0x00e7
            androidx.databinding.i<java.lang.String> r10 = r0.paySecurelyText
            goto L_0x00e8
        L_0x00e7:
            r10 = 0
        L_0x00e8:
            r11 = 5
            r1.updateRegistration((int) r11, (androidx.databinding.h) r10)
            if (r10 == 0) goto L_0x00f5
            java.lang.Object r10 = r10.get()
            java.lang.String r10 = (java.lang.String) r10
            goto L_0x00f6
        L_0x00f5:
            r10 = 0
        L_0x00f6:
            r16 = 18874432(0x1200040, double:9.3252084E-317)
            long r37 = r2 & r16
            int r11 = (r37 > r4 ? 1 : (r37 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x0110
            if (r0 == 0) goto L_0x0104
            androidx.databinding.ObservableInt r11 = r0.proceedVisible
            goto L_0x0105
        L_0x0104:
            r11 = 0
        L_0x0105:
            r8 = 6
            r1.updateRegistration((int) r8, (androidx.databinding.h) r11)
            if (r11 == 0) goto L_0x0110
            int r8 = r11.get()
            goto L_0x0111
        L_0x0110:
            r8 = 0
        L_0x0111:
            r38 = 18874496(0x1200080, double:9.32524E-317)
            long r38 = r2 & r38
            int r11 = (r38 > r4 ? 1 : (r38 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x012b
            if (r0 == 0) goto L_0x011f
            androidx.databinding.ObservableInt r11 = r0.walletBalanceVisibility
            goto L_0x0120
        L_0x011f:
            r11 = 0
        L_0x0120:
            r4 = 7
            r1.updateRegistration((int) r4, (androidx.databinding.h) r11)
            if (r11 == 0) goto L_0x012b
            int r4 = r11.get()
            goto L_0x012c
        L_0x012b:
            r4 = 0
        L_0x012c:
            r40 = 18874624(0x1200100, double:9.3253033E-317)
            long r40 = r2 & r40
            r38 = 0
            int r5 = (r40 > r38 ? 1 : (r40 == r38 ? 0 : -1))
            if (r5 == 0) goto L_0x014b
            if (r0 == 0) goto L_0x013c
            androidx.databinding.i<android.text.SpannableString> r5 = r0.convFeeText
            goto L_0x013d
        L_0x013c:
            r5 = 0
        L_0x013d:
            r11 = 8
            r1.updateRegistration((int) r11, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x014d
            java.lang.Object r5 = r5.get()
            android.text.SpannableString r5 = (android.text.SpannableString) r5
            goto L_0x014e
        L_0x014b:
            r11 = 8
        L_0x014d:
            r5 = 0
        L_0x014e:
            r40 = 18874880(0x1200200, double:9.32543E-317)
            long r40 = r2 & r40
            r38 = 0
            int r28 = (r40 > r38 ? 1 : (r40 == r38 ? 0 : -1))
            if (r28 == 0) goto L_0x0171
            if (r0 == 0) goto L_0x0160
            androidx.databinding.i<java.lang.String> r11 = r0.cashBackText
            r40 = r4
            goto L_0x0163
        L_0x0160:
            r40 = r4
            r11 = 0
        L_0x0163:
            r4 = 9
            r1.updateRegistration((int) r4, (androidx.databinding.h) r11)
            if (r11 == 0) goto L_0x0173
            java.lang.Object r4 = r11.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0174
        L_0x0171:
            r40 = r4
        L_0x0173:
            r4 = 0
        L_0x0174:
            r41 = 18875392(0x1200400, double:9.3256827E-317)
            long r41 = r2 & r41
            r38 = 0
            int r11 = (r41 > r38 ? 1 : (r41 == r38 ? 0 : -1))
            if (r11 == 0) goto L_0x0197
            if (r0 == 0) goto L_0x0186
            androidx.databinding.i<java.lang.String> r11 = r0.loaderMsg
            r41 = r4
            goto L_0x0189
        L_0x0186:
            r41 = r4
            r11 = 0
        L_0x0189:
            r4 = 10
            r1.updateRegistration((int) r4, (androidx.databinding.h) r11)
            if (r11 == 0) goto L_0x0199
            java.lang.Object r4 = r11.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x019a
        L_0x0197:
            r41 = r4
        L_0x0199:
            r4 = 0
        L_0x019a:
            r42 = 18876416(0x1200800, double:9.3261887E-317)
            long r42 = r2 & r42
            r38 = 0
            int r11 = (r42 > r38 ? 1 : (r42 == r38 ? 0 : -1))
            if (r11 == 0) goto L_0x01bd
            if (r0 == 0) goto L_0x01ac
            androidx.databinding.i<java.lang.String> r11 = r0.mSecondaryInformation
            r42 = r4
            goto L_0x01af
        L_0x01ac:
            r42 = r4
            r11 = 0
        L_0x01af:
            r4 = 11
            r1.updateRegistration((int) r4, (androidx.databinding.h) r11)
            if (r11 == 0) goto L_0x01bf
            java.lang.Object r4 = r11.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x01c0
        L_0x01bd:
            r42 = r4
        L_0x01bf:
            r4 = 0
        L_0x01c0:
            r43 = 18878464(0x1201000, double:9.3272005E-317)
            long r43 = r2 & r43
            r38 = 0
            int r11 = (r43 > r38 ? 1 : (r43 == r38 ? 0 : -1))
            if (r11 == 0) goto L_0x01e1
            if (r0 == 0) goto L_0x01d2
            androidx.databinding.ObservableInt r11 = r0.walletSendOtpButtVisibility
            r43 = r4
            goto L_0x01d5
        L_0x01d2:
            r43 = r4
            r11 = 0
        L_0x01d5:
            r4 = 12
            r1.updateRegistration((int) r4, (androidx.databinding.h) r11)
            if (r11 == 0) goto L_0x01e3
            int r4 = r11.get()
            goto L_0x01e4
        L_0x01e1:
            r43 = r4
        L_0x01e3:
            r4 = 0
        L_0x01e4:
            r44 = 18882560(0x1202000, double:9.329224E-317)
            long r44 = r2 & r44
            r38 = 0
            int r11 = (r44 > r38 ? 1 : (r44 == r38 ? 0 : -1))
            if (r11 == 0) goto L_0x0205
            if (r0 == 0) goto L_0x01f6
            androidx.databinding.ObservableInt r11 = r0.bankOfferVisibility
            r44 = r4
            goto L_0x01f9
        L_0x01f6:
            r44 = r4
            r11 = 0
        L_0x01f9:
            r4 = 13
            r1.updateRegistration((int) r4, (androidx.databinding.h) r11)
            if (r11 == 0) goto L_0x0207
            int r4 = r11.get()
            goto L_0x0208
        L_0x0205:
            r44 = r4
        L_0x0207:
            r4 = 0
        L_0x0208:
            r45 = 18890752(0x1204000, double:9.3332716E-317)
            long r45 = r2 & r45
            r38 = 0
            int r11 = (r45 > r38 ? 1 : (r45 == r38 ? 0 : -1))
            if (r11 == 0) goto L_0x022b
            if (r0 == 0) goto L_0x021a
            androidx.databinding.i<java.lang.String> r11 = r0.addPayHybridText
            r45 = r4
            goto L_0x021d
        L_0x021a:
            r45 = r4
            r11 = 0
        L_0x021d:
            r4 = 14
            r1.updateRegistration((int) r4, (androidx.databinding.h) r11)
            if (r11 == 0) goto L_0x022d
            java.lang.Object r4 = r11.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x022e
        L_0x022b:
            r45 = r4
        L_0x022d:
            r4 = 0
        L_0x022e:
            r46 = 18907136(0x1208000, double:9.3413664E-317)
            long r46 = r2 & r46
            r38 = 0
            int r11 = (r46 > r38 ? 1 : (r46 == r38 ? 0 : -1))
            r46 = r4
            if (r11 == 0) goto L_0x0274
            if (r0 == 0) goto L_0x0242
            androidx.databinding.i<java.lang.String> r4 = r0.amount
            r47 = r5
            goto L_0x0245
        L_0x0242:
            r47 = r5
            r4 = 0
        L_0x0245:
            r5 = 15
            r1.updateRegistration((int) r5, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x0253
            java.lang.Object r4 = r4.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0254
        L_0x0253:
            r4 = 0
        L_0x0254:
            if (r4 == 0) goto L_0x025b
            int r5 = r4.length()
            goto L_0x025c
        L_0x025b:
            r5 = 0
        L_0x025c:
            if (r5 <= 0) goto L_0x0260
            r5 = 1
            goto L_0x0261
        L_0x0260:
            r5 = 0
        L_0x0261:
            if (r11 == 0) goto L_0x026e
            if (r5 == 0) goto L_0x0269
            r48 = 268435456(0x10000000, double:1.32624737E-315)
            goto L_0x026c
        L_0x0269:
            r48 = 134217728(0x8000000, double:6.63123685E-316)
        L_0x026c:
            long r2 = r2 | r48
        L_0x026e:
            if (r5 == 0) goto L_0x0271
            goto L_0x0277
        L_0x0271:
            r5 = 8
            goto L_0x0278
        L_0x0274:
            r47 = r5
            r4 = 0
        L_0x0277:
            r5 = 0
        L_0x0278:
            r48 = 18939904(0x1210000, double:9.357556E-317)
            long r48 = r2 & r48
            r38 = 0
            int r11 = (r48 > r38 ? 1 : (r48 == r38 ? 0 : -1))
            if (r11 == 0) goto L_0x029b
            if (r0 == 0) goto L_0x028a
            androidx.databinding.i<android.text.SpannableString> r11 = r0.bankOfferText
            r48 = r4
            goto L_0x028d
        L_0x028a:
            r48 = r4
            r11 = 0
        L_0x028d:
            r4 = 16
            r1.updateRegistration((int) r4, (androidx.databinding.h) r11)
            if (r11 == 0) goto L_0x029d
            java.lang.Object r4 = r11.get()
            android.text.SpannableString r4 = (android.text.SpannableString) r4
            goto L_0x029e
        L_0x029b:
            r48 = r4
        L_0x029d:
            r4 = 0
        L_0x029e:
            long r49 = r2 & r26
            r38 = 0
            int r11 = (r49 > r38 ? 1 : (r49 == r38 ? 0 : -1))
            r49 = r4
            if (r11 == 0) goto L_0x02d1
            if (r0 == 0) goto L_0x02af
            androidx.databinding.ObservableInt r4 = r0.loaderVisibility
            r50 = r5
            goto L_0x02b2
        L_0x02af:
            r50 = r5
            r4 = 0
        L_0x02b2:
            r5 = 17
            r1.updateRegistration((int) r5, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x02be
            int r4 = r4.get()
            goto L_0x02bf
        L_0x02be:
            r4 = 0
        L_0x02bf:
            if (r4 != 0) goto L_0x02c3
            r5 = 1
            goto L_0x02c4
        L_0x02c3:
            r5 = 0
        L_0x02c4:
            if (r11 == 0) goto L_0x02d5
            if (r5 == 0) goto L_0x02ce
            r51 = 1073741824(0x40000000, double:5.304989477E-315)
            long r2 = r2 | r51
            goto L_0x02d5
        L_0x02ce:
            long r2 = r2 | r24
            goto L_0x02d5
        L_0x02d1:
            r50 = r5
            r4 = 0
            r5 = 0
        L_0x02d5:
            r51 = 19136512(0x1240000, double:9.454693E-317)
            long r51 = r2 & r51
            r38 = 0
            int r11 = (r51 > r38 ? 1 : (r51 == r38 ? 0 : -1))
            if (r11 == 0) goto L_0x02f6
            if (r0 == 0) goto L_0x02e7
            androidx.databinding.ObservableInt r11 = r0.walletOtpTxtVisibility
            r51 = r4
            goto L_0x02ea
        L_0x02e7:
            r51 = r4
            r11 = 0
        L_0x02ea:
            r4 = 18
            r1.updateRegistration((int) r4, (androidx.databinding.h) r11)
            if (r11 == 0) goto L_0x02f8
            int r4 = r11.get()
            goto L_0x02f9
        L_0x02f6:
            r51 = r4
        L_0x02f8:
            r4 = 0
        L_0x02f9:
            long r52 = r2 & r18
            r38 = 0
            int r11 = (r52 > r38 ? 1 : (r52 == r38 ? 0 : -1))
            if (r11 == 0) goto L_0x0317
            if (r0 == 0) goto L_0x0308
            androidx.databinding.ObservableInt r11 = r0.addPayHybridLayoutVisibility
            r52 = r4
            goto L_0x030b
        L_0x0308:
            r52 = r4
            r11 = 0
        L_0x030b:
            r4 = 19
            r1.updateRegistration((int) r4, (androidx.databinding.h) r11)
            if (r11 == 0) goto L_0x0319
            int r4 = r11.get()
            goto L_0x031a
        L_0x0317:
            r52 = r4
        L_0x0319:
            r4 = 0
        L_0x031a:
            r53 = 19922944(0x1300000, double:9.843242E-317)
            long r53 = r2 & r53
            r38 = 0
            int r11 = (r53 > r38 ? 1 : (r53 == r38 ? 0 : -1))
            if (r11 == 0) goto L_0x033b
            if (r0 == 0) goto L_0x032c
            androidx.databinding.ObservableInt r11 = r0.cashBackTextVisibility
            r53 = r4
            goto L_0x032f
        L_0x032c:
            r53 = r4
            r11 = 0
        L_0x032f:
            r4 = 20
            r1.updateRegistration((int) r4, (androidx.databinding.h) r11)
            if (r11 == 0) goto L_0x033d
            int r4 = r11.get()
            goto L_0x033e
        L_0x033b:
            r53 = r4
        L_0x033d:
            r4 = 0
        L_0x033e:
            r54 = 23068672(0x1600000, double:1.13974383E-316)
            long r54 = r2 & r54
            r38 = 0
            int r11 = (r54 > r38 ? 1 : (r54 == r38 ? 0 : -1))
            if (r11 == 0) goto L_0x0385
            if (r0 == 0) goto L_0x0350
            androidx.databinding.ObservableInt r11 = r0.otpViewVisibilty
            r54 = r2
            goto L_0x0353
        L_0x0350:
            r54 = r2
            r11 = 0
        L_0x0353:
            r2 = 22
            r1.updateRegistration((int) r2, (androidx.databinding.h) r11)
            if (r11 == 0) goto L_0x0387
            int r2 = r11.get()
            r66 = r2
            r60 = r6
            r57 = r7
            r32 = r9
            r63 = r12
            r61 = r13
            r58 = r40
            r13 = r42
            r62 = r43
            r56 = r44
            r12 = r45
            r7 = r46
            r9 = r47
            r64 = r48
            r11 = r49
            r65 = r50
            r3 = r51
            r59 = r52
            r2 = r53
            goto L_0x03ad
        L_0x0385:
            r54 = r2
        L_0x0387:
            r60 = r6
            r57 = r7
            r32 = r9
            r63 = r12
            r61 = r13
            r58 = r40
            r13 = r42
            r62 = r43
            r56 = r44
            r12 = r45
            r7 = r46
            r9 = r47
            r64 = r48
            r11 = r49
            r65 = r50
            r3 = r51
            r59 = r52
            r2 = r53
            r66 = 0
        L_0x03ad:
            r6 = r4
            r4 = r41
            goto L_0x03db
        L_0x03b1:
            r54 = r2
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
            r31 = 0
            r32 = 0
            r56 = 0
            r57 = 0
            r58 = 0
            r59 = 0
            r60 = 0
            r61 = 0
            r62 = 0
            r63 = 0
            r64 = 0
            r65 = 0
            r66 = 0
        L_0x03db:
            long r24 = r54 & r24
            r38 = 0
            int r40 = (r24 > r38 ? 1 : (r24 == r38 ? 0 : -1))
            if (r40 == 0) goto L_0x0401
            if (r0 == 0) goto L_0x03ea
            androidx.databinding.ObservableInt r0 = r0.convFeeTextVisibility
            r24 = r9
            goto L_0x03ee
        L_0x03ea:
            r24 = r9
            r0 = r32
        L_0x03ee:
            r9 = 3
            r1.updateRegistration((int) r9, (androidx.databinding.h) r0)
            if (r0 == 0) goto L_0x03f8
            int r31 = r0.get()
        L_0x03f8:
            if (r31 != 0) goto L_0x03fc
            r0 = 1
            goto L_0x03fd
        L_0x03fc:
            r0 = 0
        L_0x03fd:
            r9 = r0
            r0 = r31
            goto L_0x0406
        L_0x0401:
            r24 = r9
            r0 = r31
            r9 = 0
        L_0x0406:
            long r31 = r54 & r26
            r37 = 0
            int r25 = (r31 > r37 ? 1 : (r31 == r37 ? 0 : -1))
            if (r25 == 0) goto L_0x042c
            if (r5 == 0) goto L_0x0413
            r29 = 1
            goto L_0x0415
        L_0x0413:
            r29 = r9
        L_0x0415:
            if (r25 == 0) goto L_0x0422
            if (r29 == 0) goto L_0x041d
            r31 = 67108864(0x4000000, double:3.31561842E-316)
            goto L_0x0420
        L_0x041d:
            r31 = 33554432(0x2000000, double:1.6578092E-316)
        L_0x0420:
            long r54 = r54 | r31
        L_0x0422:
            if (r29 == 0) goto L_0x0427
            r30 = 0
            goto L_0x0429
        L_0x0427:
            r30 = 8
        L_0x0429:
            r5 = r30
            goto L_0x042d
        L_0x042c:
            r5 = 0
        L_0x042d:
            long r18 = r54 & r18
            r29 = 0
            int r9 = (r18 > r29 ? 1 : (r18 == r29 ? 0 : -1))
            if (r9 == 0) goto L_0x043a
            android.widget.RelativeLayout r9 = r1.addPayHybridLayout
            r9.setVisibility(r2)
        L_0x043a:
            r18 = 18874368(0x1200000, double:9.325177E-317)
            long r18 = r54 & r18
            int r2 = (r18 > r29 ? 1 : (r18 == r29 ? 0 : -1))
            if (r2 == 0) goto L_0x044d
            android.widget.RelativeLayout r2 = r1.btnProceed
            r2.setOnClickListener(r15)
            android.widget.CheckBox r2 = r1.rbCardNumber
            r2.setOnCheckedChangeListener(r14)
        L_0x044d:
            r14 = 18874432(0x1200040, double:9.3252084E-317)
            long r14 = r54 & r14
            int r2 = (r14 > r29 ? 1 : (r14 == r29 ? 0 : -1))
            if (r2 == 0) goto L_0x045b
            android.widget.RelativeLayout r2 = r1.btnProceed
            r2.setVisibility(r8)
        L_0x045b:
            long r8 = r54 & r26
            int r2 = (r8 > r29 ? 1 : (r8 == r29 ? 0 : -1))
            if (r2 == 0) goto L_0x0466
            android.widget.FrameLayout r2 = r1.flLoader
            r2.setVisibility(r5)
        L_0x0466:
            r8 = 19005440(0x1220000, double:9.389935E-317)
            long r8 = r54 & r8
            int r2 = (r8 > r29 ? 1 : (r8 == r29 ? 0 : -1))
            if (r2 == 0) goto L_0x0474
            android.widget.LinearLayout r2 = r1.llCheckOffer
            r2.setVisibility(r3)
        L_0x0474:
            r2 = 18874880(0x1200200, double:9.32543E-317)
            long r2 = r54 & r2
            int r5 = (r2 > r29 ? 1 : (r2 == r29 ? 0 : -1))
            if (r5 == 0) goto L_0x0482
            android.widget.TextView r2 = r1.mboundView16
            androidx.databinding.a.d.a((android.widget.TextView) r2, (java.lang.CharSequence) r4)
        L_0x0482:
            r2 = 19922944(0x1300000, double:9.843242E-317)
            long r2 = r54 & r2
            int r4 = (r2 > r29 ? 1 : (r2 == r29 ? 0 : -1))
            if (r4 == 0) goto L_0x0490
            android.widget.TextView r2 = r1.mboundView16
            r2.setVisibility(r6)
        L_0x0490:
            r2 = 18890752(0x1204000, double:9.3332716E-317)
            long r2 = r54 & r2
            int r4 = (r2 > r29 ? 1 : (r2 == r29 ? 0 : -1))
            if (r4 == 0) goto L_0x049e
            net.one97.paytm.nativesdk.widget.RoboTextView r2 = r1.mboundView7
            androidx.databinding.a.d.a((android.widget.TextView) r2, (java.lang.CharSequence) r7)
        L_0x049e:
            r2 = 18874400(0x1200020, double:9.3251926E-317)
            long r2 = r54 & r2
            int r4 = (r2 > r29 ? 1 : (r2 == r29 ? 0 : -1))
            if (r4 == 0) goto L_0x04ac
            android.widget.TextView r2 = r1.paysecurely
            androidx.databinding.a.d.a((android.widget.TextView) r2, (java.lang.CharSequence) r10)
        L_0x04ac:
            r2 = 18939904(0x1210000, double:9.357556E-317)
            long r2 = r54 & r2
            int r4 = (r2 > r29 ? 1 : (r2 == r29 ? 0 : -1))
            if (r4 == 0) goto L_0x04ba
            net.one97.paytm.nativesdk.widget.RoboTextView r2 = r1.tvBankOffer
            androidx.databinding.a.d.a((android.widget.TextView) r2, (java.lang.CharSequence) r11)
        L_0x04ba:
            r2 = 18882560(0x1202000, double:9.329224E-317)
            long r2 = r54 & r2
            int r4 = (r2 > r29 ? 1 : (r2 == r29 ? 0 : -1))
            if (r4 == 0) goto L_0x04c8
            net.one97.paytm.nativesdk.widget.RoboTextView r2 = r1.tvBankOffer
            r2.setVisibility(r12)
        L_0x04c8:
            r2 = 18875392(0x1200400, double:9.3256827E-317)
            long r2 = r54 & r2
            int r4 = (r2 > r29 ? 1 : (r2 == r29 ? 0 : -1))
            if (r4 == 0) goto L_0x04d6
            android.widget.TextView r2 = r1.tvCheckingOffers
            androidx.databinding.a.d.a((android.widget.TextView) r2, (java.lang.CharSequence) r13)
        L_0x04d6:
            r2 = 18874624(0x1200100, double:9.3253033E-317)
            long r2 = r54 & r2
            int r4 = (r2 > r29 ? 1 : (r2 == r29 ? 0 : -1))
            if (r4 == 0) goto L_0x04e6
            android.widget.TextView r2 = r1.tvConvFee
            r3 = r24
            androidx.databinding.a.d.a((android.widget.TextView) r2, (java.lang.CharSequence) r3)
        L_0x04e6:
            r2 = 18874376(0x1200008, double:9.325181E-317)
            long r2 = r54 & r2
            int r4 = (r2 > r29 ? 1 : (r2 == r29 ? 0 : -1))
            if (r4 == 0) goto L_0x04f4
            android.widget.TextView r2 = r1.tvConvFee
            r2.setVisibility(r0)
        L_0x04f4:
            r2 = 18878464(0x1201000, double:9.3272005E-317)
            long r2 = r54 & r2
            int r0 = (r2 > r29 ? 1 : (r2 == r29 ? 0 : -1))
            if (r0 == 0) goto L_0x0504
            android.widget.TextView r0 = r1.tvSendOtp
            r2 = r56
            r0.setVisibility(r2)
        L_0x0504:
            long r2 = r54 & r20
            int r0 = (r2 > r29 ? 1 : (r2 == r29 ? 0 : -1))
            if (r0 == 0) goto L_0x0511
            android.widget.TextView r0 = r1.tvWalletBalance
            r7 = r57
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r7)
        L_0x0511:
            r2 = 18874496(0x1200080, double:9.32524E-317)
            long r2 = r54 & r2
            int r0 = (r2 > r29 ? 1 : (r2 == r29 ? 0 : -1))
            if (r0 == 0) goto L_0x0521
            android.widget.TextView r0 = r1.tvWalletBalance
            r2 = r58
            r0.setVisibility(r2)
        L_0x0521:
            r2 = 19136512(0x1240000, double:9.454693E-317)
            long r2 = r54 & r2
            int r0 = (r2 > r29 ? 1 : (r2 == r29 ? 0 : -1))
            if (r0 == 0) goto L_0x0531
            android.widget.TextView r0 = r1.tvWalletOtpTc
            r2 = r59
            r0.setVisibility(r2)
        L_0x0531:
            long r2 = r54 & r22
            int r0 = (r2 > r29 ? 1 : (r2 == r29 ? 0 : -1))
            if (r0 == 0) goto L_0x053e
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.txtAmount
            r6 = r60
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r6)
        L_0x053e:
            r2 = 18874384(0x1200010, double:9.3251847E-317)
            long r2 = r54 & r2
            int r0 = (r2 > r29 ? 1 : (r2 == r29 ? 0 : -1))
            if (r0 == 0) goto L_0x054e
            android.widget.TextView r0 = r1.txtPrimaryInfo
            r13 = r61
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r13)
        L_0x054e:
            r2 = 18876416(0x1200800, double:9.3261887E-317)
            long r2 = r54 & r2
            int r0 = (r2 > r29 ? 1 : (r2 == r29 ? 0 : -1))
            if (r0 == 0) goto L_0x055e
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.txtSecondaryInfo
            r2 = r62
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r2)
        L_0x055e:
            r2 = 18874372(0x1200004, double:9.325179E-317)
            long r2 = r54 & r2
            int r0 = (r2 > r29 ? 1 : (r2 == r29 ? 0 : -1))
            if (r0 == 0) goto L_0x056e
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.txtSecondaryInfo
            r12 = r63
            r0.setVisibility(r12)
        L_0x056e:
            r2 = 18907136(0x1208000, double:9.3413664E-317)
            long r2 = r54 & r2
            int r0 = (r2 > r29 ? 1 : (r2 == r29 ? 0 : -1))
            if (r0 == 0) goto L_0x0585
            android.widget.TextView r0 = r1.txtamount
            r2 = r64
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r2)
            android.widget.TextView r0 = r1.txtamount
            r2 = r65
            r0.setVisibility(r2)
        L_0x0585:
            r2 = 23068672(0x1600000, double:1.13974383E-316)
            long r2 = r54 & r2
            int r0 = (r2 > r29 ? 1 : (r2 == r29 ? 0 : -1))
            if (r0 == 0) goto L_0x0595
            net.one97.paytm.nativesdk.instruments.wallet.view.OtpView r0 = r1.walletOtpView
            r2 = r66
            r0.setVisibility(r2)
        L_0x0595:
            return
        L_0x0596:
            r0 = move-exception
            monitor-exit(r67)     // Catch:{ all -> 0x0596 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.databinding.WalletLytInstrumentInfoBindingImpl.executeBindings():void");
    }

    public static class OnCheckedChangeListenerImpl implements CompoundButton.OnCheckedChangeListener {
        private WalletViewModel value;

        public OnCheckedChangeListenerImpl setValue(WalletViewModel walletViewModel) {
            this.value = walletViewModel;
            if (walletViewModel == null) {
                return null;
            }
            return this;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.value.onWalletCheckChanged(compoundButton, z);
        }
    }

    public static class OnClickListenerImpl implements View.OnClickListener {
        private WalletViewModel value;

        public OnClickListenerImpl setValue(WalletViewModel walletViewModel) {
            this.value = walletViewModel;
            if (walletViewModel == null) {
                return null;
            }
            return this;
        }

        public void onClick(View view) {
            this.value.proceedClicked(view);
        }
    }
}
