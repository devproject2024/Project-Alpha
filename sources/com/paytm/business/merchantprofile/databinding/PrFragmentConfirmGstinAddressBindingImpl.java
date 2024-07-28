package com.paytm.business.merchantprofile.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.i;
import com.business.common_module.view.widget.CustomTextView;
import com.paytm.business.merchantprofile.BR;
import com.paytm.business.merchantprofile.R;
import com.paytm.business.merchantprofile.generated.callback.OnClickListener;
import com.paytm.business.merchantprofile.viewmodel.ConfirmGstinAddressViewModel;

public class PrFragmentConfirmGstinAddressBindingImpl extends PrFragmentConfirmGstinAddressBinding implements OnClickListener.Listener {
    public static final ViewDataBinding.b sIncludes = null;
    public static final SparseIntArray sViewsWithIds;
    public final View.OnClickListener mCallback7;
    public long mDirtyFlags;
    public final RelativeLayout mboundView0;
    public final CustomTextView mboundView1;
    public final CustomTextView mboundView2;
    public final CustomTextView mboundView3;
    public final CustomTextView mboundView4;
    public final CustomTextView mboundView5;
    public final CustomTextView mboundView6;
    public final CustomTextView mboundView7;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.rl_cross, 8);
        sViewsWithIds.put(R.id.iv_cross, 9);
    }

    public PrFragmentConfirmGstinAddressBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 10, sIncludes, sViewsWithIds));
    }

    public PrFragmentConfirmGstinAddressBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 6, objArr[9], objArr[8]);
        this.mDirtyFlags = -1;
        RelativeLayout relativeLayout = objArr[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag((Object) null);
        CustomTextView customTextView = objArr[1];
        this.mboundView1 = customTextView;
        customTextView.setTag((Object) null);
        CustomTextView customTextView2 = objArr[2];
        this.mboundView2 = customTextView2;
        customTextView2.setTag((Object) null);
        CustomTextView customTextView3 = objArr[3];
        this.mboundView3 = customTextView3;
        customTextView3.setTag((Object) null);
        CustomTextView customTextView4 = objArr[4];
        this.mboundView4 = customTextView4;
        customTextView4.setTag((Object) null);
        CustomTextView customTextView5 = objArr[5];
        this.mboundView5 = customTextView5;
        customTextView5.setTag((Object) null);
        CustomTextView customTextView6 = objArr[6];
        this.mboundView6 = customTextView6;
        customTextView6.setTag((Object) null);
        CustomTextView customTextView7 = objArr[7];
        this.mboundView7 = customTextView7;
        customTextView7.setTag((Object) null);
        setRootTag(view);
        this.mCallback7 = new OnClickListener(this, 1);
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
        if (BR.viewModel != i2) {
            return false;
        }
        setViewModel((ConfirmGstinAddressViewModel) obj);
        return true;
    }

    public void setViewModel(ConfirmGstinAddressViewModel confirmGstinAddressViewModel) {
        this.mViewModel = confirmGstinAddressViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return onChangeViewModelMDocNameVisibility((ObservableInt) obj, i3);
        }
        if (i2 == 1) {
            return onChangeViewModelMGstin((i) obj, i3);
        }
        if (i2 == 2) {
            return onChangeViewModelMGstinVisibility((ObservableInt) obj, i3);
        }
        if (i2 == 3) {
            return onChangeViewModelMAddress((i) obj, i3);
        }
        if (i2 == 4) {
            return onChangeViewModelMDocName((i) obj, i3);
        }
        if (i2 != 5) {
            return false;
        }
        return onChangeViewModelMAddressVisibility((ObservableInt) obj, i3);
    }

    private boolean onChangeViewModelMDocNameVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelMGstin(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelMGstinVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelMAddress(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeViewModelMDocName(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeViewModelMAddressVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r28 = this;
            r1 = r28
            monitor-enter(r28)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x011d }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x011d }
            monitor-exit(r28)     // Catch:{ all -> 0x011d }
            com.paytm.business.merchantprofile.viewmodel.ConfirmGstinAddressViewModel r0 = r1.mViewModel
            r6 = 255(0xff, double:1.26E-321)
            long r6 = r6 & r2
            r10 = 200(0xc8, double:9.9E-322)
            r12 = 208(0xd0, double:1.03E-321)
            r14 = 194(0xc2, double:9.6E-322)
            r16 = 193(0xc1, double:9.54E-322)
            r18 = 196(0xc4, double:9.7E-322)
            r8 = 0
            int r22 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r22 == 0) goto L_0x00b6
            long r6 = r2 & r16
            int r22 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r22 == 0) goto L_0x0034
            if (r0 == 0) goto L_0x0029
            androidx.databinding.ObservableInt r6 = r0.mDocNameVisibility
            goto L_0x002a
        L_0x0029:
            r6 = 0
        L_0x002a:
            r1.updateRegistration((int) r8, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x0034
            int r6 = r6.get()
            goto L_0x0035
        L_0x0034:
            r6 = 0
        L_0x0035:
            long r22 = r2 & r14
            int r7 = (r22 > r4 ? 1 : (r22 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x004e
            if (r0 == 0) goto L_0x0040
            androidx.databinding.i<java.lang.String> r7 = r0.mGstin
            goto L_0x0041
        L_0x0040:
            r7 = 0
        L_0x0041:
            r8 = 1
            r1.updateRegistration((int) r8, (androidx.databinding.h) r7)
            if (r7 == 0) goto L_0x004e
            java.lang.Object r7 = r7.get()
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x004f
        L_0x004e:
            r7 = 0
        L_0x004f:
            long r23 = r2 & r18
            int r8 = (r23 > r4 ? 1 : (r23 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x0066
            if (r0 == 0) goto L_0x005a
            androidx.databinding.ObservableInt r8 = r0.mGstinVisibility
            goto L_0x005b
        L_0x005a:
            r8 = 0
        L_0x005b:
            r9 = 2
            r1.updateRegistration((int) r9, (androidx.databinding.h) r8)
            if (r8 == 0) goto L_0x0066
            int r8 = r8.get()
            goto L_0x0067
        L_0x0066:
            r8 = 0
        L_0x0067:
            long r24 = r2 & r10
            int r9 = (r24 > r4 ? 1 : (r24 == r4 ? 0 : -1))
            if (r9 == 0) goto L_0x0080
            if (r0 == 0) goto L_0x0072
            androidx.databinding.i<java.lang.String> r9 = r0.mAddress
            goto L_0x0073
        L_0x0072:
            r9 = 0
        L_0x0073:
            r10 = 3
            r1.updateRegistration((int) r10, (androidx.databinding.h) r9)
            if (r9 == 0) goto L_0x0080
            java.lang.Object r9 = r9.get()
            java.lang.String r9 = (java.lang.String) r9
            goto L_0x0081
        L_0x0080:
            r9 = 0
        L_0x0081:
            long r10 = r2 & r12
            int r26 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r26 == 0) goto L_0x009a
            if (r0 == 0) goto L_0x008c
            androidx.databinding.i<java.lang.String> r10 = r0.mDocName
            goto L_0x008d
        L_0x008c:
            r10 = 0
        L_0x008d:
            r11 = 4
            r1.updateRegistration((int) r11, (androidx.databinding.h) r10)
            if (r10 == 0) goto L_0x009a
            java.lang.Object r10 = r10.get()
            java.lang.String r10 = (java.lang.String) r10
            goto L_0x009b
        L_0x009a:
            r10 = 0
        L_0x009b:
            r20 = 224(0xe0, double:1.107E-321)
            long r26 = r2 & r20
            int r11 = (r26 > r4 ? 1 : (r26 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x00b4
            if (r0 == 0) goto L_0x00a8
            androidx.databinding.ObservableInt r0 = r0.mAddressVisibility
            goto L_0x00a9
        L_0x00a8:
            r0 = 0
        L_0x00a9:
            r11 = 5
            r1.updateRegistration((int) r11, (androidx.databinding.h) r0)
            if (r0 == 0) goto L_0x00b4
            int r0 = r0.get()
            goto L_0x00bc
        L_0x00b4:
            r0 = 0
            goto L_0x00bc
        L_0x00b6:
            r0 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
        L_0x00bc:
            long r18 = r2 & r18
            int r11 = (r18 > r4 ? 1 : (r18 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x00cc
            com.business.common_module.view.widget.CustomTextView r11 = r1.mboundView1
            r11.setVisibility(r8)
            com.business.common_module.view.widget.CustomTextView r11 = r1.mboundView2
            r11.setVisibility(r8)
        L_0x00cc:
            long r14 = r14 & r2
            int r8 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x00d6
            com.business.common_module.view.widget.CustomTextView r8 = r1.mboundView2
            androidx.databinding.a.d.a((android.widget.TextView) r8, (java.lang.CharSequence) r7)
        L_0x00d6:
            long r7 = r2 & r16
            int r11 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x00e6
            com.business.common_module.view.widget.CustomTextView r7 = r1.mboundView3
            r7.setVisibility(r6)
            com.business.common_module.view.widget.CustomTextView r7 = r1.mboundView4
            r7.setVisibility(r6)
        L_0x00e6:
            long r6 = r2 & r12
            int r8 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x00f1
            com.business.common_module.view.widget.CustomTextView r6 = r1.mboundView4
            androidx.databinding.a.d.a((android.widget.TextView) r6, (java.lang.CharSequence) r10)
        L_0x00f1:
            r6 = 224(0xe0, double:1.107E-321)
            long r6 = r6 & r2
            int r8 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x0102
            com.business.common_module.view.widget.CustomTextView r6 = r1.mboundView5
            r6.setVisibility(r0)
            com.business.common_module.view.widget.CustomTextView r6 = r1.mboundView6
            r6.setVisibility(r0)
        L_0x0102:
            r6 = 200(0xc8, double:9.9E-322)
            long r6 = r6 & r2
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x010e
            com.business.common_module.view.widget.CustomTextView r0 = r1.mboundView6
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r9)
        L_0x010e:
            r6 = 128(0x80, double:6.32E-322)
            long r2 = r2 & r6
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x011c
            com.business.common_module.view.widget.CustomTextView r0 = r1.mboundView7
            android.view.View$OnClickListener r2 = r1.mCallback7
            r0.setOnClickListener(r2)
        L_0x011c:
            return
        L_0x011d:
            r0 = move-exception
            monitor-exit(r28)     // Catch:{ all -> 0x011d }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.business.merchantprofile.databinding.PrFragmentConfirmGstinAddressBindingImpl.executeBindings():void");
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        ConfirmGstinAddressViewModel confirmGstinAddressViewModel = this.mViewModel;
        if (confirmGstinAddressViewModel != null) {
            confirmGstinAddressViewModel.onContinue();
        }
    }
}
