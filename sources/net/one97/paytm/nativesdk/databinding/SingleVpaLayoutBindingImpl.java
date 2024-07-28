package net.one97.paytm.nativesdk.databinding;

import android.text.SpannableString;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import androidx.databinding.i;
import net.one97.paytm.nativesdk.BR;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.instruments.upipush.viewmodel.UpiPushViewModel;

public class SingleVpaLayoutBindingImpl extends SingleVpaLayoutBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;
    private final FrameLayout mboundView3;
    private final TextView mboundView8;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.vpa_top_layout, 9);
        sViewsWithIds.put(R.id.rb_bank_name, 10);
        sViewsWithIds.put(R.id.tv_promotion, 11);
        sViewsWithIds.put(R.id.txt_account, 12);
        sViewsWithIds.put(R.id.txt_vpa, 13);
        sViewsWithIds.put(R.id.llCheckBalanceContainer, 14);
        sViewsWithIds.put(R.id.tvCheckBalance, 15);
        sViewsWithIds.put(R.id.tvFetchingBalance, 16);
        sViewsWithIds.put(R.id.ltv_loading_checkbalance, 17);
        sViewsWithIds.put(R.id.tvInsufficientBalance, 18);
        sViewsWithIds.put(R.id.ltv_getOffers, 19);
        sViewsWithIds.put(R.id.btnProceed, 20);
        sViewsWithIds.put(R.id.ltv_loading, 21);
    }

    public SingleVpaLayoutBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 22, sIncludes, sViewsWithIds));
    }

    private SingleVpaLayoutBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 11, objArr[20], objArr[14], objArr[5], objArr[19], objArr[21], objArr[17], objArr[7], objArr[10], objArr[2], objArr[15], objArr[6], objArr[4], objArr[16], objArr[18], objArr[11], objArr[12], objArr[13], objArr[1], objArr[9]);
        this.mDirtyFlags = -1;
        this.llCheckOffer.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.mboundView3 = objArr[3];
        this.mboundView3.setTag((Object) null);
        this.mboundView8 = objArr[8];
        this.mboundView8.setTag((Object) null);
        this.paysecurely.setTag((Object) null);
        this.tvBankOffer.setTag((Object) null);
        this.tvCheckingOffers.setTag((Object) null);
        this.tvConvFee.setTag((Object) null);
        this.txtamount.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4096;
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
        if (BR.model == i2) {
            setModel((UpiPushViewModel) obj);
        } else if (BR.view != i2) {
            return false;
        } else {
            setView((View) obj);
        }
        return true;
    }

    public void setModel(UpiPushViewModel upiPushViewModel) {
        updateRegistration(0, (h) upiPushViewModel);
        this.mModel = upiPushViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.model);
        super.requestRebind();
    }

    public void setView(View view) {
        this.mView = view;
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return onChangeModel((UpiPushViewModel) obj, i3);
            case 1:
                return onChangeModelConvFeeText((i) obj, i3);
            case 2:
                return onChangeModelBankOfferText((i) obj, i3);
            case 3:
                return onChangeModelLoaderMsg((i) obj, i3);
            case 4:
                return onChangeModelLoaderVisibility((ObservableInt) obj, i3);
            case 5:
                return onChangeModelCashBackText((i) obj, i3);
            case 6:
                return onChangeModelCashBackTextVisibility((ObservableInt) obj, i3);
            case 7:
                return onChangeModelPaySecurelyText((i) obj, i3);
            case 8:
                return onChangeModelBankOfferVisibility((ObservableInt) obj, i3);
            case 9:
                return onChangeModelAmount((i) obj, i3);
            case 10:
                return onChangeModelConvFeeTextVisibility((ObservableInt) obj, i3);
            default:
                return false;
        }
    }

    private boolean onChangeModel(UpiPushViewModel upiPushViewModel, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeModelConvFeeText(i<SpannableString> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeModelBankOfferText(i<SpannableString> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeModelLoaderMsg(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeModelLoaderVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeModelCashBackText(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeModelCashBackTextVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeModelPaySecurelyText(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    private boolean onChangeModelBankOfferVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        return true;
    }

    private boolean onChangeModelAmount(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        return true;
    }

    private boolean onChangeModelConvFeeTextVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1024;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0185  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x01a1  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x01cf  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x01db  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x01e6  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x01f2  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x01fd  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0208  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0214  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0220  */
    /* JADX WARNING: Removed duplicated region for block: B:173:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x013e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r40 = this;
            r1 = r40
            monitor-enter(r40)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x0226 }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x0226 }
            monitor-exit(r40)     // Catch:{ all -> 0x0226 }
            net.one97.paytm.nativesdk.instruments.upipush.viewmodel.UpiPushViewModel r0 = r1.mModel
            r6 = 6143(0x17ff, double:3.035E-320)
            long r6 = r6 & r2
            r13 = 4161(0x1041, double:2.056E-320)
            r15 = 4129(0x1021, double:2.04E-320)
            r17 = 4105(0x1009, double:2.028E-320)
            r19 = 4101(0x1005, double:2.026E-320)
            r21 = 4099(0x1003, double:2.025E-320)
            r23 = 8192(0x2000, double:4.0474E-320)
            r25 = 5137(0x1411, double:2.538E-320)
            r10 = 1
            r28 = 0
            r29 = 0
            int r30 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r30 == 0) goto L_0x0154
            long r6 = r2 & r21
            int r30 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r30 == 0) goto L_0x003f
            if (r0 == 0) goto L_0x0031
            androidx.databinding.i<android.text.SpannableString> r6 = r0.convFeeText
            goto L_0x0033
        L_0x0031:
            r6 = r29
        L_0x0033:
            r1.updateRegistration((int) r10, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x003f
            java.lang.Object r6 = r6.get()
            android.text.SpannableString r6 = (android.text.SpannableString) r6
            goto L_0x0041
        L_0x003f:
            r6 = r29
        L_0x0041:
            long r30 = r2 & r19
            int r7 = (r30 > r4 ? 1 : (r30 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x005b
            if (r0 == 0) goto L_0x004c
            androidx.databinding.i r7 = r0.bankOfferText
            goto L_0x004e
        L_0x004c:
            r7 = r29
        L_0x004e:
            r10 = 2
            r1.updateRegistration((int) r10, (androidx.databinding.h) r7)
            if (r7 == 0) goto L_0x005b
            java.lang.Object r7 = r7.get()
            android.text.SpannableString r7 = (android.text.SpannableString) r7
            goto L_0x005d
        L_0x005b:
            r7 = r29
        L_0x005d:
            long r31 = r2 & r17
            int r10 = (r31 > r4 ? 1 : (r31 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x0077
            if (r0 == 0) goto L_0x0068
            androidx.databinding.i<java.lang.String> r10 = r0.loaderMsg
            goto L_0x006a
        L_0x0068:
            r10 = r29
        L_0x006a:
            r8 = 3
            r1.updateRegistration((int) r8, (androidx.databinding.h) r10)
            if (r10 == 0) goto L_0x0077
            java.lang.Object r8 = r10.get()
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x0079
        L_0x0077:
            r8 = r29
        L_0x0079:
            long r9 = r2 & r25
            int r33 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r33 == 0) goto L_0x00a3
            if (r0 == 0) goto L_0x0084
            androidx.databinding.ObservableInt r9 = r0.loaderVisibility
            goto L_0x0086
        L_0x0084:
            r9 = r29
        L_0x0086:
            r10 = 4
            r1.updateRegistration((int) r10, (androidx.databinding.h) r9)
            if (r9 == 0) goto L_0x0091
            int r9 = r9.get()
            goto L_0x0092
        L_0x0091:
            r9 = 0
        L_0x0092:
            if (r9 != 0) goto L_0x0096
            r10 = 1
            goto L_0x0097
        L_0x0096:
            r10 = 0
        L_0x0097:
            if (r33 == 0) goto L_0x00a5
            if (r10 == 0) goto L_0x00a0
            r33 = 16384(0x4000, double:8.0948E-320)
            long r2 = r2 | r33
            goto L_0x00a5
        L_0x00a0:
            long r2 = r2 | r23
            goto L_0x00a5
        L_0x00a3:
            r9 = 0
            r10 = 0
        L_0x00a5:
            long r33 = r2 & r15
            int r35 = (r33 > r4 ? 1 : (r33 == r4 ? 0 : -1))
            if (r35 == 0) goto L_0x00bf
            if (r0 == 0) goto L_0x00b0
            androidx.databinding.i<java.lang.String> r15 = r0.cashBackText
            goto L_0x00b2
        L_0x00b0:
            r15 = r29
        L_0x00b2:
            r11 = 5
            r1.updateRegistration((int) r11, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x00bf
            java.lang.Object r11 = r15.get()
            java.lang.String r11 = (java.lang.String) r11
            goto L_0x00c1
        L_0x00bf:
            r11 = r29
        L_0x00c1:
            long r15 = r2 & r13
            int r12 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x00d9
            if (r0 == 0) goto L_0x00cc
            androidx.databinding.ObservableInt r12 = r0.cashBackTextVisibility
            goto L_0x00ce
        L_0x00cc:
            r12 = r29
        L_0x00ce:
            r15 = 6
            r1.updateRegistration((int) r15, (androidx.databinding.h) r12)
            if (r12 == 0) goto L_0x00d9
            int r12 = r12.get()
            goto L_0x00da
        L_0x00d9:
            r12 = 0
        L_0x00da:
            r15 = 4225(0x1081, double:2.0874E-320)
            long r36 = r2 & r15
            int r15 = (r36 > r4 ? 1 : (r36 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x00f6
            if (r0 == 0) goto L_0x00e7
            androidx.databinding.i<java.lang.String> r15 = r0.paySecurelyText
            goto L_0x00e9
        L_0x00e7:
            r15 = r29
        L_0x00e9:
            r13 = 7
            r1.updateRegistration((int) r13, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x00f6
            java.lang.Object r13 = r15.get()
            java.lang.String r13 = (java.lang.String) r13
            goto L_0x00f8
        L_0x00f6:
            r13 = r29
        L_0x00f8:
            r14 = 4353(0x1101, double:2.1507E-320)
            long r38 = r2 & r14
            int r14 = (r38 > r4 ? 1 : (r38 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x0113
            if (r0 == 0) goto L_0x0105
            androidx.databinding.ObservableInt r14 = r0.bankOfferVisibility
            goto L_0x0107
        L_0x0105:
            r14 = r29
        L_0x0107:
            r15 = 8
            r1.updateRegistration((int) r15, (androidx.databinding.h) r14)
            if (r14 == 0) goto L_0x0115
            int r14 = r14.get()
            goto L_0x0116
        L_0x0113:
            r15 = 8
        L_0x0115:
            r14 = 0
        L_0x0116:
            r38 = 4609(0x1201, double:2.277E-320)
            long r38 = r2 & r38
            int r16 = (r38 > r4 ? 1 : (r38 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x0133
            if (r0 == 0) goto L_0x0123
            androidx.databinding.i<java.lang.String> r15 = r0.amount
            goto L_0x0125
        L_0x0123:
            r15 = r29
        L_0x0125:
            r4 = 9
            r1.updateRegistration((int) r4, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x0133
            java.lang.Object r4 = r15.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0135
        L_0x0133:
            r4 = r29
        L_0x0135:
            r15 = 5121(0x1401, double:2.53E-320)
            long r15 = r15 & r2
            r38 = 0
            int r5 = (r15 > r38 ? 1 : (r15 == r38 ? 0 : -1))
            if (r5 == 0) goto L_0x0151
            if (r0 == 0) goto L_0x0143
            androidx.databinding.ObservableInt r5 = r0.convFeeTextVisibility
            goto L_0x0145
        L_0x0143:
            r5 = r29
        L_0x0145:
            r15 = 10
            r1.updateRegistration((int) r15, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x0160
            int r15 = r5.get()
            goto L_0x0161
        L_0x0151:
            r5 = r29
            goto L_0x0160
        L_0x0154:
            r4 = r29
            r5 = r4
            r6 = r5
            r7 = r6
            r8 = r7
            r11 = r8
            r13 = r11
            r9 = 0
            r10 = 0
            r12 = 0
            r14 = 0
        L_0x0160:
            r15 = 0
        L_0x0161:
            long r23 = r2 & r23
            r38 = 0
            int r16 = (r23 > r38 ? 1 : (r23 == r38 ? 0 : -1))
            if (r16 == 0) goto L_0x017c
            if (r0 == 0) goto L_0x016d
            androidx.databinding.ObservableInt r5 = r0.convFeeTextVisibility
        L_0x016d:
            r0 = 10
            r1.updateRegistration((int) r0, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x0178
            int r15 = r5.get()
        L_0x0178:
            if (r15 != 0) goto L_0x017c
            r0 = 1
            goto L_0x017d
        L_0x017c:
            r0 = 0
        L_0x017d:
            long r23 = r2 & r25
            r38 = 0
            int r5 = (r23 > r38 ? 1 : (r23 == r38 ? 0 : -1))
            if (r5 == 0) goto L_0x01a1
            if (r10 == 0) goto L_0x018a
            r30 = 1
            goto L_0x018c
        L_0x018a:
            r30 = r0
        L_0x018c:
            if (r5 == 0) goto L_0x0199
            if (r30 == 0) goto L_0x0194
            r23 = 65536(0x10000, double:3.2379E-319)
            goto L_0x0197
        L_0x0194:
            r23 = 32768(0x8000, double:1.61895E-319)
        L_0x0197:
            long r2 = r2 | r23
        L_0x0199:
            if (r30 == 0) goto L_0x019c
            goto L_0x019e
        L_0x019c:
            r28 = 8
        L_0x019e:
            r0 = r28
            goto L_0x01a2
        L_0x01a1:
            r0 = 0
        L_0x01a2:
            r23 = 4113(0x1011, double:2.032E-320)
            long r23 = r2 & r23
            r27 = 0
            int r5 = (r23 > r27 ? 1 : (r23 == r27 ? 0 : -1))
            if (r5 == 0) goto L_0x01b1
            android.widget.LinearLayout r5 = r1.llCheckOffer
            r5.setVisibility(r9)
        L_0x01b1:
            long r9 = r2 & r25
            int r5 = (r9 > r27 ? 1 : (r9 == r27 ? 0 : -1))
            if (r5 == 0) goto L_0x01bc
            android.widget.FrameLayout r5 = r1.mboundView3
            r5.setVisibility(r0)
        L_0x01bc:
            r9 = 4129(0x1021, double:2.04E-320)
            long r9 = r9 & r2
            int r0 = (r9 > r27 ? 1 : (r9 == r27 ? 0 : -1))
            if (r0 == 0) goto L_0x01c8
            android.widget.TextView r0 = r1.mboundView8
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r11)
        L_0x01c8:
            r9 = 4161(0x1041, double:2.056E-320)
            long r9 = r9 & r2
            int r0 = (r9 > r27 ? 1 : (r9 == r27 ? 0 : -1))
            if (r0 == 0) goto L_0x01d4
            android.widget.TextView r0 = r1.mboundView8
            r0.setVisibility(r12)
        L_0x01d4:
            r9 = 4225(0x1081, double:2.0874E-320)
            long r9 = r9 & r2
            int r0 = (r9 > r27 ? 1 : (r9 == r27 ? 0 : -1))
            if (r0 == 0) goto L_0x01e0
            android.widget.TextView r0 = r1.paysecurely
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r13)
        L_0x01e0:
            long r9 = r2 & r19
            int r0 = (r9 > r27 ? 1 : (r9 == r27 ? 0 : -1))
            if (r0 == 0) goto L_0x01eb
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvBankOffer
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r7)
        L_0x01eb:
            r9 = 4353(0x1101, double:2.1507E-320)
            long r9 = r9 & r2
            int r0 = (r9 > r27 ? 1 : (r9 == r27 ? 0 : -1))
            if (r0 == 0) goto L_0x01f7
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvBankOffer
            r0.setVisibility(r14)
        L_0x01f7:
            long r9 = r2 & r17
            int r0 = (r9 > r27 ? 1 : (r9 == r27 ? 0 : -1))
            if (r0 == 0) goto L_0x0202
            android.widget.TextView r0 = r1.tvCheckingOffers
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r8)
        L_0x0202:
            long r7 = r2 & r21
            int r0 = (r7 > r27 ? 1 : (r7 == r27 ? 0 : -1))
            if (r0 == 0) goto L_0x020d
            android.widget.TextView r0 = r1.tvConvFee
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r6)
        L_0x020d:
            r5 = 5121(0x1401, double:2.53E-320)
            long r5 = r5 & r2
            int r0 = (r5 > r27 ? 1 : (r5 == r27 ? 0 : -1))
            if (r0 == 0) goto L_0x0219
            android.widget.TextView r0 = r1.tvConvFee
            r0.setVisibility(r15)
        L_0x0219:
            r5 = 4609(0x1201, double:2.277E-320)
            long r2 = r2 & r5
            int r0 = (r2 > r27 ? 1 : (r2 == r27 ? 0 : -1))
            if (r0 == 0) goto L_0x0225
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.txtamount
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
        L_0x0225:
            return
        L_0x0226:
            r0 = move-exception
            monitor-exit(r40)     // Catch:{ all -> 0x0226 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.databinding.SingleVpaLayoutBindingImpl.executeBindings():void");
    }
}
