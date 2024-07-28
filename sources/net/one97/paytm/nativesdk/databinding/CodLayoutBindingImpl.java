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
import net.one97.paytm.nativesdk.instruments.cod.viewmodel.CodViewModel;

public class CodLayoutBindingImpl extends CodLayoutBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private OnClickListenerImpl1 mCodViewModelCodClickedAndroidViewViewOnClickListener;
    private OnClickListenerImpl mCodViewModelProceedToPayAndroidViewViewOnClickListener;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.ivRightArrow, 7);
        sViewsWithIds.put(R.id.tv_bank_offer_error, 8);
        sViewsWithIds.put(R.id.tv_remainingAmtTxt, 9);
        sViewsWithIds.put(R.id.ivPaysecurely, 10);
        sViewsWithIds.put(R.id.paysecurely, 11);
        sViewsWithIds.put(R.id.ltv_loading, 12);
    }

    public CodLayoutBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 13, sIncludes, sViewsWithIds));
    }

    private CodLayoutBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 5, objArr[6], objArr[1], objArr[10], objArr[7], objArr[12], objArr[11], objArr[2], objArr[5], objArr[8], objArr[3], objArr[9], objArr[4]);
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
        if (BR.codViewModel == i2) {
            setCodViewModel((CodViewModel) obj);
        } else if (BR.view != i2) {
            return false;
        } else {
            setView((View) obj);
        }
        return true;
    }

    public void setCodViewModel(CodViewModel codViewModel) {
        updateRegistration(4, (h) codViewModel);
        this.mCodViewModel = codViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(BR.codViewModel);
        super.requestRebind();
    }

    public void setView(View view) {
        this.mView = view;
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return onChangeCodViewModelCodDisplayName((i) obj, i3);
        }
        if (i2 == 1) {
            return onChangeCodViewModelVpaInputLayoutVisiblity((ObservableInt) obj, i3);
        }
        if (i2 == 2) {
            return onChangeCodViewModelRadioChecked((ObservableBoolean) obj, i3);
        }
        if (i2 == 3) {
            return onChangeCodViewModelAmount((i) obj, i3);
        }
        if (i2 != 4) {
            return false;
        }
        return onChangeCodViewModel((CodViewModel) obj, i3);
    }

    private boolean onChangeCodViewModelCodDisplayName(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeCodViewModelVpaInputLayoutVisiblity(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeCodViewModelRadioChecked(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeCodViewModelAmount(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeCodViewModel(CodViewModel codViewModel, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0053 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00d4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r28 = this;
            r1 = r28
            monitor-enter(r28)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x0123 }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x0123 }
            monitor-exit(r28)     // Catch:{ all -> 0x0123 }
            net.one97.paytm.nativesdk.instruments.cod.viewmodel.CodViewModel r0 = r1.mCodViewModel
            r6 = 95
            long r6 = r6 & r2
            r10 = 82
            r12 = 84
            r14 = 81
            r16 = 80
            r8 = 0
            int r20 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r20 == 0) goto L_0x00d7
            long r6 = r2 & r14
            int r20 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r20 == 0) goto L_0x0034
            if (r0 == 0) goto L_0x0027
            androidx.databinding.i<java.lang.String> r6 = r0.codDisplayName
            goto L_0x0028
        L_0x0027:
            r6 = 0
        L_0x0028:
            r1.updateRegistration((int) r8, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x0034
            java.lang.Object r6 = r6.get()
            java.lang.String r6 = (java.lang.String) r6
            goto L_0x0035
        L_0x0034:
            r6 = 0
        L_0x0035:
            long r20 = r2 & r10
            r7 = 1
            int r22 = (r20 > r4 ? 1 : (r20 == r4 ? 0 : -1))
            if (r22 == 0) goto L_0x004c
            if (r0 == 0) goto L_0x0041
            androidx.databinding.ObservableInt r8 = r0.vpaInputLayoutVisiblity
            goto L_0x0042
        L_0x0041:
            r8 = 0
        L_0x0042:
            r1.updateRegistration((int) r7, (androidx.databinding.h) r8)
            if (r8 == 0) goto L_0x004c
            int r8 = r8.get()
            goto L_0x004d
        L_0x004c:
            r8 = 0
        L_0x004d:
            long r21 = r2 & r16
            int r23 = (r21 > r4 ? 1 : (r21 == r4 ? 0 : -1))
            if (r23 == 0) goto L_0x0079
            if (r0 == 0) goto L_0x0079
            net.one97.paytm.nativesdk.databinding.CodLayoutBindingImpl$OnClickListenerImpl r7 = r1.mCodViewModelProceedToPayAndroidViewViewOnClickListener
            if (r7 != 0) goto L_0x0060
            net.one97.paytm.nativesdk.databinding.CodLayoutBindingImpl$OnClickListenerImpl r7 = new net.one97.paytm.nativesdk.databinding.CodLayoutBindingImpl$OnClickListenerImpl
            r7.<init>()
            r1.mCodViewModelProceedToPayAndroidViewViewOnClickListener = r7
        L_0x0060:
            net.one97.paytm.nativesdk.databinding.CodLayoutBindingImpl$OnClickListenerImpl r7 = r7.setValue(r0)
            net.one97.paytm.nativesdk.databinding.CodLayoutBindingImpl$OnClickListenerImpl1 r9 = r1.mCodViewModelCodClickedAndroidViewViewOnClickListener
            if (r9 != 0) goto L_0x006f
            net.one97.paytm.nativesdk.databinding.CodLayoutBindingImpl$OnClickListenerImpl1 r9 = new net.one97.paytm.nativesdk.databinding.CodLayoutBindingImpl$OnClickListenerImpl1
            r9.<init>()
            r1.mCodViewModelCodClickedAndroidViewViewOnClickListener = r9
        L_0x006f:
            net.one97.paytm.nativesdk.databinding.CodLayoutBindingImpl$OnClickListenerImpl1 r9 = r9.setValue(r0)
            r27 = r9
            r9 = r7
            r7 = r27
            goto L_0x007b
        L_0x0079:
            r7 = 0
            r9 = 0
        L_0x007b:
            long r23 = r2 & r12
            int r25 = (r23 > r4 ? 1 : (r23 == r4 ? 0 : -1))
            if (r25 == 0) goto L_0x0092
            if (r0 == 0) goto L_0x0086
            androidx.databinding.ObservableBoolean r14 = r0.radioChecked
            goto L_0x0087
        L_0x0086:
            r14 = 0
        L_0x0087:
            r15 = 2
            r1.updateRegistration((int) r15, (androidx.databinding.h) r14)
            if (r14 == 0) goto L_0x0092
            boolean r14 = r14.get()
            goto L_0x0093
        L_0x0092:
            r14 = 0
        L_0x0093:
            r18 = 88
            long r25 = r2 & r18
            int r15 = (r25 > r4 ? 1 : (r25 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x00d4
            if (r0 == 0) goto L_0x00a0
            androidx.databinding.i<java.lang.String> r0 = r0.amount
            goto L_0x00a1
        L_0x00a0:
            r0 = 0
        L_0x00a1:
            r10 = 3
            r1.updateRegistration((int) r10, (androidx.databinding.h) r0)
            if (r0 == 0) goto L_0x00ae
            java.lang.Object r0 = r0.get()
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x00af
        L_0x00ae:
            r0 = 0
        L_0x00af:
            if (r0 == 0) goto L_0x00b6
            int r10 = r0.length()
            goto L_0x00b7
        L_0x00b6:
            r10 = 0
        L_0x00b7:
            if (r10 <= 0) goto L_0x00bc
            r21 = 1
            goto L_0x00be
        L_0x00bc:
            r21 = 0
        L_0x00be:
            if (r15 == 0) goto L_0x00c8
            if (r21 == 0) goto L_0x00c5
            r10 = 256(0x100, double:1.265E-321)
            goto L_0x00c7
        L_0x00c5:
            r10 = 128(0x80, double:6.32E-322)
        L_0x00c7:
            long r2 = r2 | r10
        L_0x00c8:
            if (r21 == 0) goto L_0x00cd
            r20 = 0
            goto L_0x00d1
        L_0x00cd:
            r10 = 8
            r20 = 8
        L_0x00d1:
            r10 = r20
            goto L_0x00de
        L_0x00d4:
            r0 = 0
            r10 = 0
            goto L_0x00de
        L_0x00d7:
            r0 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r14 = 0
        L_0x00de:
            long r15 = r2 & r16
            int r11 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x00ee
            android.widget.RelativeLayout r11 = r1.btnProceed
            r11.setOnClickListener(r9)
            android.widget.RelativeLayout r9 = r1.cardTextLayout
            r9.setOnClickListener(r7)
        L_0x00ee:
            long r11 = r2 & r12
            int r7 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x00f9
            android.widget.RadioButton r7 = r1.radioButton
            androidx.databinding.a.a.a(r7, r14)
        L_0x00f9:
            r11 = 82
            long r11 = r11 & r2
            int r7 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x0105
            android.widget.RelativeLayout r7 = r1.topLayout
            r7.setVisibility(r8)
        L_0x0105:
            r7 = 81
            long r7 = r7 & r2
            int r9 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r9 == 0) goto L_0x0111
            net.one97.paytm.nativesdk.widget.RoboTextView r7 = r1.tvCod
            androidx.databinding.a.d.a((android.widget.TextView) r7, (java.lang.CharSequence) r6)
        L_0x0111:
            r6 = 88
            long r2 = r2 & r6
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0122
            android.widget.TextView r2 = r1.txtamount
            androidx.databinding.a.d.a((android.widget.TextView) r2, (java.lang.CharSequence) r0)
            android.widget.TextView r0 = r1.txtamount
            r0.setVisibility(r10)
        L_0x0122:
            return
        L_0x0123:
            r0 = move-exception
            monitor-exit(r28)     // Catch:{ all -> 0x0123 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.databinding.CodLayoutBindingImpl.executeBindings():void");
    }

    public static class OnClickListenerImpl implements View.OnClickListener {
        private CodViewModel value;

        public OnClickListenerImpl setValue(CodViewModel codViewModel) {
            this.value = codViewModel;
            if (codViewModel == null) {
                return null;
            }
            return this;
        }

        public void onClick(View view) {
            this.value.proceedToPay(view);
        }
    }

    public static class OnClickListenerImpl1 implements View.OnClickListener {
        private CodViewModel value;

        public OnClickListenerImpl1 setValue(CodViewModel codViewModel) {
            this.value = codViewModel;
            if (codViewModel == null) {
                return null;
            }
            return this;
        }

        public void onClick(View view) {
            this.value.codClicked(view);
        }
    }
}
