package net.one97.paytm.nativesdk.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import androidx.databinding.i;
import net.one97.paytm.nativesdk.BR;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.paymethods.viewmodel.SelectedInstrumentSheetViewModel;

public class LytInstrumentSelectedSheetBindingImpl extends LytInstrumentSelectedSheetBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private OnClickListenerImpl mSelectedInstrumentSheetViewModelOnProceedToPayClickAndroidViewViewOnClickListener;
    private OnClickListenerImpl1 mSelectedInstrumentSheetViewModelOpenCashierSheetAndroidViewViewOnClickListener;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.tv_pay_using, 8);
        sViewsWithIds.put(R.id.ll_img_container, 9);
        sViewsWithIds.put(R.id.rl_down_arrow, 10);
        sViewsWithIds.put(R.id.lyt_bottom_lines, 11);
    }

    public LytInstrumentSelectedSheetBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 12, sIncludes, sViewsWithIds));
    }

    private LytInstrumentSelectedSheetBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 7, objArr[7], objArr[0], objArr[2], objArr[9], objArr[11], objArr[6], objArr[10], objArr[1], objArr[5], objArr[3], objArr[4], objArr[8]);
        this.mDirtyFlags = -1;
        this.btnLogin.setTag((Object) null);
        this.cvSelectedInstrument.setTag((Object) null);
        this.ivInstrumentSelected.setTag((Object) null);
        this.lytSignInButton.setTag((Object) null);
        this.rlSelectedInstrument.setTag((Object) null);
        this.tvInstrumentInfoMsg.setTag((Object) null);
        this.tvInstrumentName.setTag((Object) null);
        this.tvIntrumentBalance.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 128;
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
        if (BR.selectedInstrumentSheetViewModel != i2) {
            return false;
        }
        setSelectedInstrumentSheetViewModel((SelectedInstrumentSheetViewModel) obj);
        return true;
    }

    public void setSelectedInstrumentSheetViewModel(SelectedInstrumentSheetViewModel selectedInstrumentSheetViewModel) {
        updateRegistration(5, (h) selectedInstrumentSheetViewModel);
        this.mSelectedInstrumentSheetViewModel = selectedInstrumentSheetViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(BR.selectedInstrumentSheetViewModel);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return onChangeSelectedInstrumentSheetViewModelSelectedInstrumentBalance((i) obj, i3);
            case 1:
                return onChangeSelectedInstrumentSheetViewModelMSelectedInstrumentIconurl((i) obj, i3);
            case 2:
                return onChangeSelectedInstrumentSheetViewModelMPayButtonTitle((i) obj, i3);
            case 3:
                return onChangeSelectedInstrumentSheetViewModelMInsufficentMsgVisiblity((ObservableInt) obj, i3);
            case 4:
                return onChangeSelectedInstrumentSheetViewModelSelectedInstrumentName((i) obj, i3);
            case 5:
                return onChangeSelectedInstrumentSheetViewModel((SelectedInstrumentSheetViewModel) obj, i3);
            case 6:
                return onChangeSelectedInstrumentSheetViewModelShowInstrumentInfoMsg((ObservableBoolean) obj, i3);
            default:
                return false;
        }
    }

    private boolean onChangeSelectedInstrumentSheetViewModelSelectedInstrumentBalance(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeSelectedInstrumentSheetViewModelMSelectedInstrumentIconurl(i<Integer> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeSelectedInstrumentSheetViewModelMPayButtonTitle(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeSelectedInstrumentSheetViewModelMInsufficentMsgVisiblity(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeSelectedInstrumentSheetViewModelSelectedInstrumentName(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeSelectedInstrumentSheetViewModel(SelectedInstrumentSheetViewModel selectedInstrumentSheetViewModel, int i2) {
        if (i2 == BR._all) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i2 != BR.showInstrumentInfoMsg) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        }
    }

    private boolean onChangeSelectedInstrumentSheetViewModelShowInstrumentInfoMsg(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ba A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x011c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r31 = this;
            r1 = r31
            monitor-enter(r31)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x017e }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x017e }
            monitor-exit(r31)     // Catch:{ all -> 0x017e }
            net.one97.paytm.nativesdk.paymethods.viewmodel.SelectedInstrumentSheetViewModel r0 = r1.mSelectedInstrumentSheetViewModel
            r7 = 255(0xff, double:1.26E-321)
            long r7 = r7 & r2
            r9 = 176(0xb0, double:8.7E-322)
            r11 = 168(0xa8, double:8.3E-322)
            r13 = 160(0xa0, double:7.9E-322)
            r17 = 162(0xa2, double:8.0E-322)
            r19 = 161(0xa1, double:7.95E-322)
            r21 = 164(0xa4, double:8.1E-322)
            r6 = 0
            r23 = 0
            int r24 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r24 == 0) goto L_0x011e
            long r7 = r2 & r19
            int r24 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r24 == 0) goto L_0x003d
            if (r0 == 0) goto L_0x002f
            androidx.databinding.i r7 = r0.getSelectedInstrumentBalance()
            goto L_0x0031
        L_0x002f:
            r7 = r23
        L_0x0031:
            r1.updateRegistration((int) r6, (androidx.databinding.h) r7)
            if (r7 == 0) goto L_0x003d
            java.lang.Object r7 = r7.get()
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x003f
        L_0x003d:
            r7 = r23
        L_0x003f:
            long r24 = r2 & r17
            int r8 = (r24 > r4 ? 1 : (r24 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x0060
            if (r0 == 0) goto L_0x004a
            androidx.databinding.i<java.lang.Integer> r8 = r0.mSelectedInstrumentIconurl
            goto L_0x004c
        L_0x004a:
            r8 = r23
        L_0x004c:
            r6 = 1
            r1.updateRegistration((int) r6, (androidx.databinding.h) r8)
            if (r8 == 0) goto L_0x0059
            java.lang.Object r6 = r8.get()
            java.lang.Integer r6 = (java.lang.Integer) r6
            goto L_0x005b
        L_0x0059:
            r6 = r23
        L_0x005b:
            int r6 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Integer) r6)
            goto L_0x0061
        L_0x0060:
            r6 = 0
        L_0x0061:
            long r25 = r2 & r21
            int r8 = (r25 > r4 ? 1 : (r25 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x007b
            if (r0 == 0) goto L_0x006c
            androidx.databinding.i<java.lang.String> r8 = r0.mPayButtonTitle
            goto L_0x006e
        L_0x006c:
            r8 = r23
        L_0x006e:
            r15 = 2
            r1.updateRegistration((int) r15, (androidx.databinding.h) r8)
            if (r8 == 0) goto L_0x007b
            java.lang.Object r8 = r8.get()
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x007d
        L_0x007b:
            r8 = r23
        L_0x007d:
            long r15 = r2 & r11
            int r27 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r27 == 0) goto L_0x0095
            if (r0 == 0) goto L_0x0088
            androidx.databinding.ObservableInt r15 = r0.mInsufficentMsgVisiblity
            goto L_0x008a
        L_0x0088:
            r15 = r23
        L_0x008a:
            r11 = 3
            r1.updateRegistration((int) r11, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x0095
            int r11 = r15.get()
            goto L_0x0096
        L_0x0095:
            r11 = 0
        L_0x0096:
            long r15 = r2 & r9
            int r12 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x00b2
            if (r0 == 0) goto L_0x00a3
            androidx.databinding.i r12 = r0.getSelectedInstrumentName()
            goto L_0x00a5
        L_0x00a3:
            r12 = r23
        L_0x00a5:
            r15 = 4
            r1.updateRegistration((int) r15, (androidx.databinding.h) r12)
            if (r12 == 0) goto L_0x00b2
            java.lang.Object r12 = r12.get()
            java.lang.String r12 = (java.lang.String) r12
            goto L_0x00b4
        L_0x00b2:
            r12 = r23
        L_0x00b4:
            long r15 = r2 & r13
            int r28 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r28 == 0) goto L_0x00db
            if (r0 == 0) goto L_0x00db
            net.one97.paytm.nativesdk.databinding.LytInstrumentSelectedSheetBindingImpl$OnClickListenerImpl r15 = r1.mSelectedInstrumentSheetViewModelOnProceedToPayClickAndroidViewViewOnClickListener
            if (r15 != 0) goto L_0x00c7
            net.one97.paytm.nativesdk.databinding.LytInstrumentSelectedSheetBindingImpl$OnClickListenerImpl r15 = new net.one97.paytm.nativesdk.databinding.LytInstrumentSelectedSheetBindingImpl$OnClickListenerImpl
            r15.<init>()
            r1.mSelectedInstrumentSheetViewModelOnProceedToPayClickAndroidViewViewOnClickListener = r15
        L_0x00c7:
            net.one97.paytm.nativesdk.databinding.LytInstrumentSelectedSheetBindingImpl$OnClickListenerImpl r15 = r15.setValue(r0)
            net.one97.paytm.nativesdk.databinding.LytInstrumentSelectedSheetBindingImpl$OnClickListenerImpl1 r9 = r1.mSelectedInstrumentSheetViewModelOpenCashierSheetAndroidViewViewOnClickListener
            if (r9 != 0) goto L_0x00d6
            net.one97.paytm.nativesdk.databinding.LytInstrumentSelectedSheetBindingImpl$OnClickListenerImpl1 r9 = new net.one97.paytm.nativesdk.databinding.LytInstrumentSelectedSheetBindingImpl$OnClickListenerImpl1
            r9.<init>()
            r1.mSelectedInstrumentSheetViewModelOpenCashierSheetAndroidViewViewOnClickListener = r9
        L_0x00d6:
            net.one97.paytm.nativesdk.databinding.LytInstrumentSelectedSheetBindingImpl$OnClickListenerImpl1 r9 = r9.setValue(r0)
            goto L_0x00de
        L_0x00db:
            r9 = r23
            r15 = r9
        L_0x00de:
            r25 = 224(0xe0, double:1.107E-321)
            long r29 = r2 & r25
            int r10 = (r29 > r4 ? 1 : (r29 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x011c
            if (r0 == 0) goto L_0x00ec
            androidx.databinding.ObservableBoolean r23 = r0.getShowInstrumentInfoMsg()
        L_0x00ec:
            r0 = r23
            r13 = 6
            r1.updateRegistration((int) r13, (androidx.databinding.h) r0)
            if (r0 == 0) goto L_0x00f9
            boolean r0 = r0.get()
            goto L_0x00fa
        L_0x00f9:
            r0 = 0
        L_0x00fa:
            if (r10 == 0) goto L_0x0104
            if (r0 == 0) goto L_0x0101
            r13 = 512(0x200, double:2.53E-321)
            goto L_0x0103
        L_0x0101:
            r13 = 256(0x100, double:1.265E-321)
        L_0x0103:
            long r2 = r2 | r13
        L_0x0104:
            if (r0 == 0) goto L_0x010f
            android.widget.RelativeLayout r0 = r1.lytSignInButton
            android.content.res.Resources r0 = r0.getResources()
            int r10 = net.one97.paytm.nativesdk.R.dimen.margin_pay_button_from_info
            goto L_0x0117
        L_0x010f:
            android.widget.RelativeLayout r0 = r1.lytSignInButton
            android.content.res.Resources r0 = r0.getResources()
            int r10 = net.one97.paytm.nativesdk.R.dimen.margin_pay_button_from_balance
        L_0x0117:
            float r0 = r0.getDimension(r10)
            goto L_0x0127
        L_0x011c:
            r0 = 0
            goto L_0x0127
        L_0x011e:
            r7 = r23
            r8 = r7
            r9 = r8
            r12 = r9
            r15 = r12
            r0 = 0
            r6 = 0
            r11 = 0
        L_0x0127:
            long r13 = r2 & r21
            int r10 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x0132
            android.widget.TextView r10 = r1.btnLogin
            androidx.databinding.a.d.a((android.widget.TextView) r10, (java.lang.CharSequence) r8)
        L_0x0132:
            long r13 = r2 & r17
            int r8 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x013d
            android.widget.ImageView r8 = r1.ivInstrumentSelected
            net.one97.paytm.nativesdk.paymethods.viewmodel.SelectedInstrumentSheetViewModel.loadImage(r8, r6)
        L_0x013d:
            r13 = 224(0xe0, double:1.107E-321)
            long r13 = r13 & r2
            int r6 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0149
            android.widget.RelativeLayout r6 = r1.lytSignInButton
            net.one97.paytm.nativesdk.paymethods.viewmodel.SelectedInstrumentSheetViewModel.setTopMargin(r6, r0)
        L_0x0149:
            r13 = 160(0xa0, double:7.9E-322)
            long r13 = r13 & r2
            int r0 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x015a
            android.widget.RelativeLayout r0 = r1.lytSignInButton
            r0.setOnClickListener(r15)
            android.widget.RelativeLayout r0 = r1.rlSelectedInstrument
            r0.setOnClickListener(r9)
        L_0x015a:
            r8 = 168(0xa8, double:8.3E-322)
            long r8 = r8 & r2
            int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0166
            android.widget.TextView r0 = r1.tvInstrumentInfoMsg
            r0.setVisibility(r11)
        L_0x0166:
            r8 = 176(0xb0, double:8.7E-322)
            long r8 = r8 & r2
            int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0172
            android.widget.TextView r0 = r1.tvInstrumentName
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r12)
        L_0x0172:
            long r2 = r2 & r19
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x017d
            android.widget.TextView r0 = r1.tvIntrumentBalance
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r7)
        L_0x017d:
            return
        L_0x017e:
            r0 = move-exception
            monitor-exit(r31)     // Catch:{ all -> 0x017e }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.databinding.LytInstrumentSelectedSheetBindingImpl.executeBindings():void");
    }

    public static class OnClickListenerImpl implements View.OnClickListener {
        private SelectedInstrumentSheetViewModel value;

        public OnClickListenerImpl setValue(SelectedInstrumentSheetViewModel selectedInstrumentSheetViewModel) {
            this.value = selectedInstrumentSheetViewModel;
            if (selectedInstrumentSheetViewModel == null) {
                return null;
            }
            return this;
        }

        public void onClick(View view) {
            this.value.onProceedToPayClick(view);
        }
    }

    public static class OnClickListenerImpl1 implements View.OnClickListener {
        private SelectedInstrumentSheetViewModel value;

        public OnClickListenerImpl1 setValue(SelectedInstrumentSheetViewModel selectedInstrumentSheetViewModel) {
            this.value = selectedInstrumentSheetViewModel;
            if (selectedInstrumentSheetViewModel == null) {
                return null;
            }
            return this;
        }

        public void onClick(View view) {
            this.value.openCashierSheet(view);
        }
    }
}
