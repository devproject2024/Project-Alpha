package net.one97.paytm.nativesdk.databinding;

import android.graphics.Typeface;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.i;
import net.one97.paytm.nativesdk.BR;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.instruments.netbanking.adapter.NetBankingAdapter;

public class RowNetBankingLayoutBindingImpl extends RowNetBankingLayoutBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final TextView mboundView12;
    private final RelativeLayout mboundView6;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.tv_promo_message, 13);
        sViewsWithIds.put(R.id.procced, 14);
        sViewsWithIds.put(R.id.paysecurely, 15);
        sViewsWithIds.put(R.id.ltv_loading1, 16);
        sViewsWithIds.put(R.id.txt_successrate, 17);
        sViewsWithIds.put(R.id.llUpiCheckbox, 18);
        sViewsWithIds.put(R.id.cbUpiCheckbox, 19);
        sViewsWithIds.put(R.id.tvUpiCheckbox, 20);
        sViewsWithIds.put(R.id.fl_loader, 21);
        sViewsWithIds.put(R.id.ll_checkOffer, 22);
        sViewsWithIds.put(R.id.ltv_checkingOffer, 23);
        sViewsWithIds.put(R.id.ltv_loading, 24);
        sViewsWithIds.put(R.id.upiPayOption, 25);
        sViewsWithIds.put(R.id.upiIcon, 26);
        sViewsWithIds.put(R.id.upiPayText, 27);
        sViewsWithIds.put(R.id.iv_proceed_upi, 28);
    }

    public RowNetBankingLayoutBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 29, sIncludes, sViewsWithIds));
    }

    private RowNetBankingLayoutBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 16, objArr[10], objArr[19], objArr[21], objArr[1], objArr[3], objArr[28], objArr[22], objArr[18], objArr[23], objArr[24], objArr[16], objArr[15], objArr[14], objArr[7], objArr[8], objArr[9], objArr[5], objArr[11], objArr[13], objArr[20], objArr[4], objArr[2], objArr[17], objArr[26], objArr[25], objArr[27]);
        this.mDirtyFlags = -1;
        this.btnProceed.setTag((Object) null);
        this.imgBank.setTag((Object) null);
        this.imgTick.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.mboundView12 = objArr[12];
        this.mboundView12.setTag((Object) null);
        this.mboundView6 = objArr[6];
        this.mboundView6.setTag((Object) null);
        this.tvBankOffer.setTag((Object) null);
        this.tvCheckingOffers.setTag((Object) null);
        this.tvConvFee.setTag((Object) null);
        this.tvDisableErrorMessage.setTag((Object) null);
        this.tvProceedSecurely.setTag((Object) null);
        this.txtAmount.setTag((Object) null);
        this.txtBankName.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 524288;
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
        if (BR.typeface == i2) {
            setTypeface((Typeface) obj);
        } else if (BR.view == i2) {
            setView((View) obj);
        } else if (BR.netbanking != i2) {
            return false;
        } else {
            setNetbanking((NetBankingAdapter.NBItemViewModel) obj);
        }
        return true;
    }

    public void setTypeface(Typeface typeface) {
        this.mTypeface = typeface;
    }

    public void setView(View view) {
        this.mView = view;
    }

    public void setNetbanking(NetBankingAdapter.NBItemViewModel nBItemViewModel) {
        this.mNetbanking = nBItemViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 262144;
        }
        notifyPropertyChanged(BR.netbanking);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return onChangeNetbankingLoaderMsg((i) obj, i3);
            case 1:
                return onChangeNetbankingBankOfferText((i) obj, i3);
            case 2:
                return onChangeNetbankingIsGreenTickVisible((ObservableBoolean) obj, i3);
            case 3:
                return onChangeNetbankingCashBackText((i) obj, i3);
            case 4:
                return onChangeNetbankingDisableMessageVisibility((ObservableInt) obj, i3);
            case 5:
                return onChangeNetbankingLowSuccessVisibility((ObservableInt) obj, i3);
            case 6:
                return onChangeNetbankingPaySecurelyText((i) obj, i3);
            case 7:
                return onChangeNetbankingAmount((i) obj, i3);
            case 8:
                return onChangeNetbankingCashBackTextVisibility((ObservableInt) obj, i3);
            case 9:
                return onChangeNetbankingBankOfferVisibility((ObservableInt) obj, i3);
            case 10:
                return onChangeNetbankingBankSelectionProceedVisible((ObservableBoolean) obj, i3);
            case 11:
                return onChangeNetbankingConvFeeText((i) obj, i3);
            case 12:
                return onChangeNetbankingIconUrl((i) obj, i3);
            case 13:
                return onChangeNetbankingConvFeeTextVisibility((ObservableInt) obj, i3);
            case 14:
                return onChangeNetbankingChannelName((i) obj, i3);
            case 15:
                return onChangeNetbankingDisableMessage((i) obj, i3);
            default:
                return false;
        }
    }

    private boolean onChangeNetbankingLoaderMsg(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeNetbankingBankOfferText(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeNetbankingIsGreenTickVisible(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeNetbankingCashBackText(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeNetbankingDisableMessageVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeNetbankingLowSuccessVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeNetbankingPaySecurelyText(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeNetbankingAmount(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    private boolean onChangeNetbankingCashBackTextVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        return true;
    }

    private boolean onChangeNetbankingBankOfferVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        return true;
    }

    private boolean onChangeNetbankingBankSelectionProceedVisible(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1024;
        }
        return true;
    }

    private boolean onChangeNetbankingConvFeeText(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2048;
        }
        return true;
    }

    private boolean onChangeNetbankingIconUrl(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4096;
        }
        return true;
    }

    private boolean onChangeNetbankingConvFeeTextVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8192;
        }
        return true;
    }

    private boolean onChangeNetbankingChannelName(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16384;
        }
        return true;
    }

    private boolean onChangeNetbankingDisableMessage(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32768;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x01b8  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x01d8  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x01ff  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x021f  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0138  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r52 = this;
            r1 = r52
            monitor-enter(r52)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x0349 }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x0349 }
            monitor-exit(r52)     // Catch:{ all -> 0x0349 }
            net.one97.paytm.nativesdk.instruments.netbanking.adapter.NetBankingAdapter$NBItemViewModel r0 = r1.mNetbanking
            r6 = 851967(0xcffff, double:4.209276E-318)
            long r6 = r6 & r2
            r12 = 786464(0xc0020, double:3.88565E-318)
            r14 = 786448(0xc0010, double:3.88557E-318)
            r16 = 786688(0xc0100, double:3.886755E-318)
            r18 = 786440(0xc0008, double:3.88553E-318)
            r20 = 786436(0xc0004, double:3.88551E-318)
            r22 = 786434(0xc0002, double:3.8855E-318)
            r24 = 790528(0xc1000, double:3.905727E-318)
            r26 = 786433(0xc0001, double:3.885495E-318)
            r28 = 787456(0xc0400, double:3.89055E-318)
            r8 = 0
            int r32 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r32 == 0) goto L_0x0259
            long r6 = r2 & r26
            int r32 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r32 == 0) goto L_0x0048
            if (r0 == 0) goto L_0x003b
            androidx.databinding.i<java.lang.String> r6 = r0.loaderMsg
            goto L_0x003c
        L_0x003b:
            r6 = 0
        L_0x003c:
            r1.updateRegistration((int) r8, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x0048
            java.lang.Object r6 = r6.get()
            java.lang.String r6 = (java.lang.String) r6
            goto L_0x0049
        L_0x0048:
            r6 = 0
        L_0x0049:
            long r32 = r2 & r22
            int r7 = (r32 > r4 ? 1 : (r32 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x0062
            if (r0 == 0) goto L_0x0054
            androidx.databinding.i<java.lang.String> r7 = r0.bankOfferText
            goto L_0x0055
        L_0x0054:
            r7 = 0
        L_0x0055:
            r8 = 1
            r1.updateRegistration((int) r8, (androidx.databinding.h) r7)
            if (r7 == 0) goto L_0x0062
            java.lang.Object r7 = r7.get()
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x0063
        L_0x0062:
            r7 = 0
        L_0x0063:
            long r33 = r2 & r20
            int r35 = (r33 > r4 ? 1 : (r33 == r4 ? 0 : -1))
            if (r35 == 0) goto L_0x0098
            if (r0 == 0) goto L_0x006e
            androidx.databinding.ObservableBoolean r9 = r0.isGreenTickVisible
            goto L_0x006f
        L_0x006e:
            r9 = 0
        L_0x006f:
            r8 = 2
            r1.updateRegistration((int) r8, (androidx.databinding.h) r9)
            if (r9 == 0) goto L_0x007a
            boolean r8 = r9.get()
            goto L_0x007b
        L_0x007a:
            r8 = 0
        L_0x007b:
            if (r35 == 0) goto L_0x0092
            if (r8 == 0) goto L_0x0088
            r35 = 2097152(0x200000, double:1.0361308E-317)
            long r2 = r2 | r35
            r35 = 33554432(0x2000000, double:1.6578092E-316)
            goto L_0x0090
        L_0x0088:
            r35 = 1048576(0x100000, double:5.180654E-318)
            long r2 = r2 | r35
            r35 = 16777216(0x1000000, double:8.289046E-317)
        L_0x0090:
            long r2 = r2 | r35
        L_0x0092:
            if (r8 == 0) goto L_0x0095
            goto L_0x0099
        L_0x0095:
            r9 = 8
            goto L_0x009a
        L_0x0098:
            r8 = 0
        L_0x0099:
            r9 = 0
        L_0x009a:
            long r35 = r2 & r18
            int r37 = (r35 > r4 ? 1 : (r35 == r4 ? 0 : -1))
            if (r37 == 0) goto L_0x00b3
            if (r0 == 0) goto L_0x00a5
            androidx.databinding.i<java.lang.String> r10 = r0.cashBackText
            goto L_0x00a6
        L_0x00a5:
            r10 = 0
        L_0x00a6:
            r11 = 3
            r1.updateRegistration((int) r11, (androidx.databinding.h) r10)
            if (r10 == 0) goto L_0x00b3
            java.lang.Object r10 = r10.get()
            java.lang.String r10 = (java.lang.String) r10
            goto L_0x00b4
        L_0x00b3:
            r10 = 0
        L_0x00b4:
            long r37 = r2 & r14
            int r11 = (r37 > r4 ? 1 : (r37 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x00cb
            if (r0 == 0) goto L_0x00bf
            androidx.databinding.ObservableInt r11 = r0.disableMessageVisibility
            goto L_0x00c0
        L_0x00bf:
            r11 = 0
        L_0x00c0:
            r14 = 4
            r1.updateRegistration((int) r14, (androidx.databinding.h) r11)
            if (r11 == 0) goto L_0x00cb
            int r11 = r11.get()
            goto L_0x00cc
        L_0x00cb:
            r11 = 0
        L_0x00cc:
            long r14 = r2 & r12
            int r39 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r39 == 0) goto L_0x00e3
            if (r0 == 0) goto L_0x00d7
            androidx.databinding.ObservableInt r14 = r0.lowSuccessVisibility
            goto L_0x00d8
        L_0x00d7:
            r14 = 0
        L_0x00d8:
            r15 = 5
            r1.updateRegistration((int) r15, (androidx.databinding.h) r14)
            if (r14 == 0) goto L_0x00e3
            int r14 = r14.get()
            goto L_0x00e4
        L_0x00e3:
            r14 = 0
        L_0x00e4:
            r35 = 786496(0xc0040, double:3.885807E-318)
            long r39 = r2 & r35
            int r15 = (r39 > r4 ? 1 : (r39 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x0100
            if (r0 == 0) goto L_0x00f2
            androidx.databinding.i<java.lang.String> r15 = r0.paySecurelyText
            goto L_0x00f3
        L_0x00f2:
            r15 = 0
        L_0x00f3:
            r12 = 6
            r1.updateRegistration((int) r12, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x0100
            java.lang.Object r12 = r15.get()
            java.lang.String r12 = (java.lang.String) r12
            goto L_0x0101
        L_0x0100:
            r12 = 0
        L_0x0101:
            r41 = 786560(0xc0080, double:3.886123E-318)
            long r41 = r2 & r41
            int r13 = (r41 > r4 ? 1 : (r41 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x011d
            if (r0 == 0) goto L_0x010f
            androidx.databinding.i<java.lang.String> r13 = r0.amount
            goto L_0x0110
        L_0x010f:
            r13 = 0
        L_0x0110:
            r15 = 7
            r1.updateRegistration((int) r15, (androidx.databinding.h) r13)
            if (r13 == 0) goto L_0x011d
            java.lang.Object r13 = r13.get()
            java.lang.String r13 = (java.lang.String) r13
            goto L_0x011e
        L_0x011d:
            r13 = 0
        L_0x011e:
            long r41 = r2 & r16
            int r15 = (r41 > r4 ? 1 : (r41 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x0138
            if (r0 == 0) goto L_0x012b
            androidx.databinding.ObservableInt r15 = r0.cashBackTextVisibility
            r4 = 8
            goto L_0x012e
        L_0x012b:
            r4 = 8
            r15 = 0
        L_0x012e:
            r1.updateRegistration((int) r4, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x013a
            int r5 = r15.get()
            goto L_0x013b
        L_0x0138:
            r4 = 8
        L_0x013a:
            r5 = 0
        L_0x013b:
            r30 = 786944(0xc0200, double:3.88802E-318)
            long r43 = r2 & r30
            r41 = 0
            int r15 = (r43 > r41 ? 1 : (r43 == r41 ? 0 : -1))
            if (r15 == 0) goto L_0x0158
            if (r0 == 0) goto L_0x014b
            androidx.databinding.ObservableInt r15 = r0.bankOfferVisibility
            goto L_0x014c
        L_0x014b:
            r15 = 0
        L_0x014c:
            r4 = 9
            r1.updateRegistration((int) r4, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x0158
            int r4 = r15.get()
            goto L_0x0159
        L_0x0158:
            r4 = 0
        L_0x0159:
            long r43 = r2 & r28
            r41 = 0
            int r15 = (r43 > r41 ? 1 : (r43 == r41 ? 0 : -1))
            r43 = r4
            if (r15 == 0) goto L_0x018d
            if (r0 == 0) goto L_0x016a
            androidx.databinding.ObservableBoolean r4 = r0.bankSelectionProceedVisible
            r44 = r5
            goto L_0x016d
        L_0x016a:
            r44 = r5
            r4 = 0
        L_0x016d:
            r5 = 10
            r1.updateRegistration((int) r5, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x0179
            boolean r4 = r4.get()
            goto L_0x017a
        L_0x0179:
            r4 = 0
        L_0x017a:
            if (r15 == 0) goto L_0x0187
            if (r4 == 0) goto L_0x0182
            r45 = 8388608(0x800000, double:4.144523E-317)
            goto L_0x0185
        L_0x0182:
            r45 = 4194304(0x400000, double:2.0722615E-317)
        L_0x0185:
            long r2 = r2 | r45
        L_0x0187:
            if (r4 == 0) goto L_0x018a
            goto L_0x018f
        L_0x018a:
            r34 = 8
            goto L_0x0191
        L_0x018d:
            r44 = r5
        L_0x018f:
            r34 = 0
        L_0x0191:
            r4 = 788480(0xc0800, double:3.89561E-318)
            long r4 = r4 & r2
            r41 = 0
            int r15 = (r4 > r41 ? 1 : (r4 == r41 ? 0 : -1))
            if (r15 == 0) goto L_0x01af
            if (r0 == 0) goto L_0x01a0
            androidx.databinding.i<java.lang.String> r4 = r0.convFeeText
            goto L_0x01a1
        L_0x01a0:
            r4 = 0
        L_0x01a1:
            r5 = 11
            r1.updateRegistration((int) r5, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x01af
            java.lang.Object r4 = r4.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x01b0
        L_0x01af:
            r4 = 0
        L_0x01b0:
            long r45 = r2 & r24
            r41 = 0
            int r5 = (r45 > r41 ? 1 : (r45 == r41 ? 0 : -1))
            if (r5 == 0) goto L_0x01cc
            if (r0 == 0) goto L_0x01bd
            androidx.databinding.i<java.lang.String> r5 = r0.iconUrl
            goto L_0x01be
        L_0x01bd:
            r5 = 0
        L_0x01be:
            r15 = 12
            r1.updateRegistration((int) r15, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x01cc
            java.lang.Object r5 = r5.get()
            java.lang.String r5 = (java.lang.String) r5
            goto L_0x01cd
        L_0x01cc:
            r5 = 0
        L_0x01cd:
            r45 = 794624(0xc2000, double:3.925964E-318)
            long r45 = r2 & r45
            r41 = 0
            int r15 = (r45 > r41 ? 1 : (r45 == r41 ? 0 : -1))
            if (r15 == 0) goto L_0x01f0
            if (r0 == 0) goto L_0x01df
            androidx.databinding.ObservableInt r15 = r0.convFeeTextVisibility
            r45 = r4
            goto L_0x01e2
        L_0x01df:
            r45 = r4
            r15 = 0
        L_0x01e2:
            r4 = 13
            r1.updateRegistration((int) r4, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x01f2
            int r4 = r15.get()
            r32 = r4
            goto L_0x01f4
        L_0x01f0:
            r45 = r4
        L_0x01f2:
            r32 = 0
        L_0x01f4:
            r46 = 802816(0xc4000, double:3.96644E-318)
            long r46 = r2 & r46
            r41 = 0
            int r4 = (r46 > r41 ? 1 : (r46 == r41 ? 0 : -1))
            if (r4 == 0) goto L_0x0213
            if (r0 == 0) goto L_0x0204
            androidx.databinding.i<java.lang.String> r4 = r0.channelName
            goto L_0x0205
        L_0x0204:
            r4 = 0
        L_0x0205:
            r15 = 14
            r1.updateRegistration((int) r15, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x0213
            java.lang.Object r4 = r4.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0214
        L_0x0213:
            r4 = 0
        L_0x0214:
            r46 = 819200(0xc8000, double:4.047386E-318)
            long r46 = r2 & r46
            r41 = 0
            int r15 = (r46 > r41 ? 1 : (r46 == r41 ? 0 : -1))
            if (r15 == 0) goto L_0x0244
            if (r0 == 0) goto L_0x0224
            androidx.databinding.i<java.lang.String> r0 = r0.disableMessage
            goto L_0x0225
        L_0x0224:
            r0 = 0
        L_0x0225:
            r15 = 15
            r1.updateRegistration((int) r15, (androidx.databinding.h) r0)
            if (r0 == 0) goto L_0x0244
            java.lang.Object r0 = r0.get()
            java.lang.String r0 = (java.lang.String) r0
            r48 = r0
            r51 = r4
            r15 = r11
            r49 = r12
            r50 = r13
            r13 = r32
            r0 = r34
            r4 = r44
            r12 = r45
            goto L_0x0255
        L_0x0244:
            r51 = r4
            r15 = r11
            r49 = r12
            r50 = r13
            r13 = r32
            r0 = r34
            r4 = r44
            r12 = r45
            r48 = 0
        L_0x0255:
            r11 = r6
            r6 = r43
            goto L_0x026e
        L_0x0259:
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
            r48 = 0
            r49 = 0
            r50 = 0
            r51 = 0
        L_0x026e:
            long r28 = r2 & r28
            r32 = 0
            int r34 = (r28 > r32 ? 1 : (r28 == r32 ? 0 : -1))
            r28 = r15
            if (r34 == 0) goto L_0x027d
            android.widget.RelativeLayout r15 = r1.btnProceed
            r15.setVisibility(r0)
        L_0x027d:
            long r24 = r2 & r24
            int r0 = (r24 > r32 ? 1 : (r24 == r32 ? 0 : -1))
            if (r0 == 0) goto L_0x0288
            android.widget.ImageView r0 = r1.imgBank
            net.one97.paytm.nativesdk.instruments.netbanking.viewmodel.NetBankingViewModel.loadImage(r0, r5)
        L_0x0288:
            long r20 = r2 & r20
            int r0 = (r20 > r32 ? 1 : (r20 == r32 ? 0 : -1))
            if (r0 == 0) goto L_0x029d
            android.widget.ImageView r0 = r1.imgTick
            r0.setVisibility(r9)
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.txtAmount
            r0.setVisibility(r9)
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.txtBankName
            net.one97.paytm.nativesdk.instruments.netbanking.viewmodel.NBAdapterViewModel.setTextStyle(r0, r8)
        L_0x029d:
            long r8 = r2 & r18
            int r0 = (r8 > r32 ? 1 : (r8 == r32 ? 0 : -1))
            if (r0 == 0) goto L_0x02a8
            android.widget.TextView r0 = r1.mboundView12
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r10)
        L_0x02a8:
            long r8 = r2 & r16
            int r0 = (r8 > r32 ? 1 : (r8 == r32 ? 0 : -1))
            if (r0 == 0) goto L_0x02b3
            android.widget.TextView r0 = r1.mboundView12
            r0.setVisibility(r4)
        L_0x02b3:
            r4 = 786464(0xc0020, double:3.88565E-318)
            long r4 = r4 & r2
            int r0 = (r4 > r32 ? 1 : (r4 == r32 ? 0 : -1))
            if (r0 == 0) goto L_0x02c0
            android.widget.RelativeLayout r0 = r1.mboundView6
            r0.setVisibility(r14)
        L_0x02c0:
            long r4 = r2 & r22
            int r0 = (r4 > r32 ? 1 : (r4 == r32 ? 0 : -1))
            if (r0 == 0) goto L_0x02cb
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvBankOffer
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r7)
        L_0x02cb:
            r4 = 786944(0xc0200, double:3.88802E-318)
            long r4 = r4 & r2
            int r0 = (r4 > r32 ? 1 : (r4 == r32 ? 0 : -1))
            if (r0 == 0) goto L_0x02d8
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvBankOffer
            r0.setVisibility(r6)
        L_0x02d8:
            long r4 = r2 & r26
            int r0 = (r4 > r32 ? 1 : (r4 == r32 ? 0 : -1))
            if (r0 == 0) goto L_0x02e3
            android.widget.TextView r0 = r1.tvCheckingOffers
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r11)
        L_0x02e3:
            r4 = 788480(0xc0800, double:3.89561E-318)
            long r4 = r4 & r2
            int r0 = (r4 > r32 ? 1 : (r4 == r32 ? 0 : -1))
            if (r0 == 0) goto L_0x02f0
            android.widget.TextView r0 = r1.tvConvFee
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r12)
        L_0x02f0:
            r4 = 794624(0xc2000, double:3.925964E-318)
            long r4 = r4 & r2
            int r0 = (r4 > r32 ? 1 : (r4 == r32 ? 0 : -1))
            if (r0 == 0) goto L_0x02fd
            android.widget.TextView r0 = r1.tvConvFee
            r0.setVisibility(r13)
        L_0x02fd:
            r4 = 786448(0xc0010, double:3.88557E-318)
            long r4 = r4 & r2
            int r0 = (r4 > r32 ? 1 : (r4 == r32 ? 0 : -1))
            if (r0 == 0) goto L_0x030c
            android.widget.TextView r0 = r1.tvDisableErrorMessage
            r11 = r28
            r0.setVisibility(r11)
        L_0x030c:
            r4 = 819200(0xc8000, double:4.047386E-318)
            long r4 = r4 & r2
            int r0 = (r4 > r32 ? 1 : (r4 == r32 ? 0 : -1))
            if (r0 == 0) goto L_0x031b
            android.widget.TextView r0 = r1.tvDisableErrorMessage
            r4 = r48
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
        L_0x031b:
            r4 = 786496(0xc0040, double:3.885807E-318)
            long r4 = r4 & r2
            int r0 = (r4 > r32 ? 1 : (r4 == r32 ? 0 : -1))
            if (r0 == 0) goto L_0x032a
            android.widget.TextView r0 = r1.tvProceedSecurely
            r12 = r49
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r12)
        L_0x032a:
            r4 = 786560(0xc0080, double:3.886123E-318)
            long r4 = r4 & r2
            int r0 = (r4 > r32 ? 1 : (r4 == r32 ? 0 : -1))
            if (r0 == 0) goto L_0x0339
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.txtAmount
            r13 = r50
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r13)
        L_0x0339:
            r4 = 802816(0xc4000, double:3.96644E-318)
            long r2 = r2 & r4
            int r0 = (r2 > r32 ? 1 : (r2 == r32 ? 0 : -1))
            if (r0 == 0) goto L_0x0348
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.txtBankName
            r4 = r51
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
        L_0x0348:
            return
        L_0x0349:
            r0 = move-exception
            monitor-exit(r52)     // Catch:{ all -> 0x0349 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.databinding.RowNetBankingLayoutBindingImpl.executeBindings():void");
    }
}
