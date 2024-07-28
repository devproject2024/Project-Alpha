package net.one97.paytm.nativesdk.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import androidx.databinding.i;
import net.one97.paytm.nativesdk.BR;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.instruments.aoa_wallet.viewmodel.AOAWalletViewModel;

public class AoaWalletLayoutBindingImpl extends AoaWalletLayoutBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private OnClickListenerImpl1 mAoaWalletViewModelAoaWalletClickedAndroidViewViewOnClickListener;
    private OnClickListenerImpl mAoaWalletViewModelProceedToPayAndroidViewViewOnClickListener;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.ivRightArrow, 7);
        sViewsWithIds.put(R.id.tv_bank_offer_error, 8);
        sViewsWithIds.put(R.id.paysecurely, 9);
    }

    public AoaWalletLayoutBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 10, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private AoaWalletLayoutBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 5, objArr[6], objArr[1], objArr[7], objArr[9], objArr[2], objArr[5], objArr[8], objArr[3], objArr[4]);
        this.mDirtyFlags = -1;
        this.btnProceed.setTag((Object) null);
        this.cardTextLayout.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.radioButton.setTag((Object) null);
        this.topLayout.setTag((Object) null);
        this.tvCod.setTag((Object) null);
        this.txtamount.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 64;
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
        } else if (BR.aoaWalletViewModel != i2) {
            return false;
        } else {
            setAoaWalletViewModel((AOAWalletViewModel) obj);
        }
        return true;
    }

    public void setView(View view) {
        this.mView = view;
    }

    public void setAoaWalletViewModel(AOAWalletViewModel aOAWalletViewModel) {
        updateRegistration(4, (h) aOAWalletViewModel);
        this.mAoaWalletViewModel = aOAWalletViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(BR.aoaWalletViewModel);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return onChangeAoaWalletViewModelVpaInputLayoutVisiblity((ObservableInt) obj, i3);
        }
        if (i2 == 1) {
            return onChangeAoaWalletViewModelAoaWalletDisplayName((i) obj, i3);
        }
        if (i2 == 2) {
            return onChangeAoaWalletViewModelAmount((i) obj, i3);
        }
        if (i2 == 3) {
            return onChangeAoaWalletViewModelRadioChecked((ObservableBoolean) obj, i3);
        }
        if (i2 != 4) {
            return false;
        }
        return onChangeAoaWalletViewModel((AOAWalletViewModel) obj, i3);
    }

    private boolean onChangeAoaWalletViewModelVpaInputLayoutVisiblity(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeAoaWalletViewModelAoaWalletDisplayName(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeAoaWalletViewModelAmount(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeAoaWalletViewModelRadioChecked(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeAoaWalletViewModel(AOAWalletViewModel aOAWalletViewModel, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00bb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r27 = this;
            r1 = r27
            monitor-enter(r27)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x011a }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x011a }
            monitor-exit(r27)     // Catch:{ all -> 0x011a }
            net.one97.paytm.nativesdk.instruments.aoa_wallet.viewmodel.AOAWalletViewModel r0 = r1.mAoaWalletViewModel
            r6 = 95
            long r6 = r6 & r2
            r8 = 84
            r10 = 82
            r14 = 81
            r16 = 80
            r12 = 0
            int r20 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r20 == 0) goto L_0x00ce
            long r6 = r2 & r14
            int r20 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r20 == 0) goto L_0x0032
            if (r0 == 0) goto L_0x0027
            androidx.databinding.ObservableInt r6 = r0.vpaInputLayoutVisiblity
            goto L_0x0028
        L_0x0027:
            r6 = 0
        L_0x0028:
            r1.updateRegistration((int) r12, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x0032
            int r6 = r6.get()
            goto L_0x0033
        L_0x0032:
            r6 = 0
        L_0x0033:
            long r20 = r2 & r16
            int r7 = (r20 > r4 ? 1 : (r20 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x005a
            if (r0 == 0) goto L_0x005a
            net.one97.paytm.nativesdk.databinding.AoaWalletLayoutBindingImpl$OnClickListenerImpl r7 = r1.mAoaWalletViewModelProceedToPayAndroidViewViewOnClickListener
            if (r7 != 0) goto L_0x0046
            net.one97.paytm.nativesdk.databinding.AoaWalletLayoutBindingImpl$OnClickListenerImpl r7 = new net.one97.paytm.nativesdk.databinding.AoaWalletLayoutBindingImpl$OnClickListenerImpl
            r7.<init>()
            r1.mAoaWalletViewModelProceedToPayAndroidViewViewOnClickListener = r7
        L_0x0046:
            net.one97.paytm.nativesdk.databinding.AoaWalletLayoutBindingImpl$OnClickListenerImpl r7 = r7.setValue(r0)
            net.one97.paytm.nativesdk.databinding.AoaWalletLayoutBindingImpl$OnClickListenerImpl1 r12 = r1.mAoaWalletViewModelAoaWalletClickedAndroidViewViewOnClickListener
            if (r12 != 0) goto L_0x0055
            net.one97.paytm.nativesdk.databinding.AoaWalletLayoutBindingImpl$OnClickListenerImpl1 r12 = new net.one97.paytm.nativesdk.databinding.AoaWalletLayoutBindingImpl$OnClickListenerImpl1
            r12.<init>()
            r1.mAoaWalletViewModelAoaWalletClickedAndroidViewViewOnClickListener = r12
        L_0x0055:
            net.one97.paytm.nativesdk.databinding.AoaWalletLayoutBindingImpl$OnClickListenerImpl1 r12 = r12.setValue(r0)
            goto L_0x005c
        L_0x005a:
            r7 = 0
            r12 = 0
        L_0x005c:
            long r21 = r2 & r10
            r13 = 1
            int r23 = (r21 > r4 ? 1 : (r21 == r4 ? 0 : -1))
            if (r23 == 0) goto L_0x0075
            if (r0 == 0) goto L_0x0068
            androidx.databinding.i<java.lang.String> r10 = r0.aoaWalletDisplayName
            goto L_0x0069
        L_0x0068:
            r10 = 0
        L_0x0069:
            r1.updateRegistration((int) r13, (androidx.databinding.h) r10)
            if (r10 == 0) goto L_0x0075
            java.lang.Object r10 = r10.get()
            java.lang.String r10 = (java.lang.String) r10
            goto L_0x0076
        L_0x0075:
            r10 = 0
        L_0x0076:
            long r23 = r2 & r8
            int r11 = (r23 > r4 ? 1 : (r23 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x00b1
            if (r0 == 0) goto L_0x0081
            androidx.databinding.i<java.lang.String> r13 = r0.amount
            goto L_0x0082
        L_0x0081:
            r13 = 0
        L_0x0082:
            r8 = 2
            r1.updateRegistration((int) r8, (androidx.databinding.h) r13)
            if (r13 == 0) goto L_0x0090
            java.lang.Object r8 = r13.get()
            r13 = r8
            java.lang.String r13 = (java.lang.String) r13
            goto L_0x0091
        L_0x0090:
            r13 = 0
        L_0x0091:
            if (r13 == 0) goto L_0x0098
            int r8 = r13.length()
            goto L_0x0099
        L_0x0098:
            r8 = 0
        L_0x0099:
            if (r8 <= 0) goto L_0x009e
            r23 = 1
            goto L_0x00a0
        L_0x009e:
            r23 = 0
        L_0x00a0:
            if (r11 == 0) goto L_0x00aa
            if (r23 == 0) goto L_0x00a7
            r8 = 256(0x100, double:1.265E-321)
            goto L_0x00a9
        L_0x00a7:
            r8 = 128(0x80, double:6.32E-322)
        L_0x00a9:
            long r2 = r2 | r8
        L_0x00aa:
            if (r23 == 0) goto L_0x00ae
            r8 = 0
            goto L_0x00b3
        L_0x00ae:
            r8 = 8
            goto L_0x00b3
        L_0x00b1:
            r8 = 0
            r13 = 0
        L_0x00b3:
            r18 = 88
            long r25 = r2 & r18
            int r9 = (r25 > r4 ? 1 : (r25 == r4 ? 0 : -1))
            if (r9 == 0) goto L_0x00cc
            if (r0 == 0) goto L_0x00c0
            androidx.databinding.ObservableBoolean r0 = r0.radioChecked
            goto L_0x00c1
        L_0x00c0:
            r0 = 0
        L_0x00c1:
            r9 = 3
            r1.updateRegistration((int) r9, (androidx.databinding.h) r0)
            if (r0 == 0) goto L_0x00cc
            boolean r0 = r0.get()
            goto L_0x00d5
        L_0x00cc:
            r0 = 0
            goto L_0x00d5
        L_0x00ce:
            r0 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r10 = 0
            r12 = 0
            r13 = 0
        L_0x00d5:
            long r16 = r2 & r16
            int r9 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r9 == 0) goto L_0x00e5
            android.widget.RelativeLayout r9 = r1.btnProceed
            r9.setOnClickListener(r7)
            android.widget.RelativeLayout r7 = r1.cardTextLayout
            r7.setOnClickListener(r12)
        L_0x00e5:
            r11 = 88
            long r11 = r11 & r2
            int r7 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x00f1
            android.widget.RadioButton r7 = r1.radioButton
            androidx.databinding.a.a.a(r7, r0)
        L_0x00f1:
            long r11 = r2 & r14
            int r0 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00fc
            android.widget.RelativeLayout r0 = r1.topLayout
            r0.setVisibility(r6)
        L_0x00fc:
            r6 = 82
            long r6 = r6 & r2
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0108
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvCod
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r10)
        L_0x0108:
            r6 = 84
            long r2 = r2 & r6
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0119
            android.widget.TextView r0 = r1.txtamount
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r13)
            android.widget.TextView r0 = r1.txtamount
            r0.setVisibility(r8)
        L_0x0119:
            return
        L_0x011a:
            r0 = move-exception
            monitor-exit(r27)     // Catch:{ all -> 0x011a }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.databinding.AoaWalletLayoutBindingImpl.executeBindings():void");
    }

    public static class OnClickListenerImpl implements View.OnClickListener {
        private AOAWalletViewModel value;

        public OnClickListenerImpl setValue(AOAWalletViewModel aOAWalletViewModel) {
            this.value = aOAWalletViewModel;
            if (aOAWalletViewModel == null) {
                return null;
            }
            return this;
        }

        public void onClick(View view) {
            this.value.proceedToPay(view);
        }
    }

    public static class OnClickListenerImpl1 implements View.OnClickListener {
        private AOAWalletViewModel value;

        public OnClickListenerImpl1 setValue(AOAWalletViewModel aOAWalletViewModel) {
            this.value = aOAWalletViewModel;
            if (aOAWalletViewModel == null) {
                return null;
            }
            return this;
        }

        public void onClick(View view) {
            this.value.aoaWalletClicked(view);
        }
    }
}
