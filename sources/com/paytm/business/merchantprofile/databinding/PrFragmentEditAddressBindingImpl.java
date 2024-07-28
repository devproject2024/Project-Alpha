package com.paytm.business.merchantprofile.databinding;

import android.text.Editable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.databinding.g;
import androidx.databinding.i;
import com.business.common_module.view.widget.CustomTextView;
import com.paytm.business.merchantprofile.BR;
import com.paytm.business.merchantprofile.R;
import com.paytm.business.merchantprofile.generated.callback.OnClickListener;
import com.paytm.business.merchantprofile.viewmodel.EditAddressViewModel;

public class PrFragmentEditAddressBindingImpl extends PrFragmentEditAddressBinding implements OnClickListener.Listener {
    public static final ViewDataBinding.b sIncludes = null;
    public static final SparseIntArray sViewsWithIds;
    public g etAddress1androidTextAttrChanged;
    public g etAddress2androidTextAttrChanged;
    public g etAddress3androidTextAttrChanged;
    public g etCityandroidTextAttrChanged;
    public g etPincodeandroidTextAttrChanged;
    public final View.OnClickListener mCallback2;
    public long mDirtyFlags;
    public AfterTextChangedImpl1 mViewModelAfterAddressLine1ChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged;
    public AfterTextChangedImpl2 mViewModelAfterAddressLine2ChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged;
    public AfterTextChangedImpl3 mViewModelAfterAddressLine3ChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged;
    public AfterTextChangedImpl mViewModelAfterCityChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged;
    public AfterTextChangedImpl4 mViewModelAfterPinCodeChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged;
    public final NestedScrollView mboundView0;
    public final CustomTextView mboundView1;
    public final CustomTextView mboundView10;
    public final LinearLayout mboundView11;
    public final CustomTextView mboundView13;
    public final LinearLayout mboundView14;
    public final CustomTextView mboundView16;
    public final LinearLayout mboundView2;
    public final CustomTextView mboundView4;
    public final LinearLayout mboundView5;
    public final CustomTextView mboundView7;
    public final LinearLayout mboundView8;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.rl_cross, 18);
        sViewsWithIds.put(R.id.iv_cross, 19);
        sViewsWithIds.put(R.id.parent_container, 20);
        sViewsWithIds.put(R.id.tv_state, 21);
        sViewsWithIds.put(R.id.state_spinner, 22);
    }

    public PrFragmentEditAddressBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 23, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PrFragmentEditAddressBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 12, objArr[3], objArr[6], objArr[9], objArr[15], objArr[12], objArr[19], objArr[20], objArr[18], objArr[22], objArr[17], objArr[21]);
        this.etAddress1androidTextAttrChanged = new g() {
            public void onChange() {
                String a2 = d.a((TextView) PrFragmentEditAddressBindingImpl.this.etAddress1);
                EditAddressViewModel editAddressViewModel = PrFragmentEditAddressBindingImpl.this.mViewModel;
                boolean z = true;
                if (editAddressViewModel != null) {
                    i<String> iVar = editAddressViewModel.mAddressLine1;
                    if (iVar == null) {
                        z = false;
                    }
                    if (z) {
                        iVar.set(a2);
                    }
                }
            }
        };
        this.etAddress2androidTextAttrChanged = new g() {
            public void onChange() {
                String a2 = d.a((TextView) PrFragmentEditAddressBindingImpl.this.etAddress2);
                EditAddressViewModel editAddressViewModel = PrFragmentEditAddressBindingImpl.this.mViewModel;
                boolean z = true;
                if (editAddressViewModel != null) {
                    i<String> iVar = editAddressViewModel.mAddressLine2;
                    if (iVar == null) {
                        z = false;
                    }
                    if (z) {
                        iVar.set(a2);
                    }
                }
            }
        };
        this.etAddress3androidTextAttrChanged = new g() {
            public void onChange() {
                String a2 = d.a((TextView) PrFragmentEditAddressBindingImpl.this.etAddress3);
                EditAddressViewModel editAddressViewModel = PrFragmentEditAddressBindingImpl.this.mViewModel;
                boolean z = true;
                if (editAddressViewModel != null) {
                    i<String> iVar = editAddressViewModel.mAddressLine3;
                    if (iVar == null) {
                        z = false;
                    }
                    if (z) {
                        iVar.set(a2);
                    }
                }
            }
        };
        this.etCityandroidTextAttrChanged = new g() {
            public void onChange() {
                String a2 = d.a((TextView) PrFragmentEditAddressBindingImpl.this.etCity);
                EditAddressViewModel editAddressViewModel = PrFragmentEditAddressBindingImpl.this.mViewModel;
                boolean z = true;
                if (editAddressViewModel != null) {
                    i<String> iVar = editAddressViewModel.mCity;
                    if (iVar == null) {
                        z = false;
                    }
                    if (z) {
                        iVar.set(a2);
                    }
                }
            }
        };
        this.etPincodeandroidTextAttrChanged = new g() {
            public void onChange() {
                String a2 = d.a((TextView) PrFragmentEditAddressBindingImpl.this.etPincode);
                EditAddressViewModel editAddressViewModel = PrFragmentEditAddressBindingImpl.this.mViewModel;
                boolean z = true;
                if (editAddressViewModel != null) {
                    i<String> iVar = editAddressViewModel.mPinCode;
                    if (iVar == null) {
                        z = false;
                    }
                    if (z) {
                        iVar.set(a2);
                    }
                }
            }
        };
        this.mDirtyFlags = -1;
        this.etAddress1.setTag((Object) null);
        this.etAddress2.setTag((Object) null);
        this.etAddress3.setTag((Object) null);
        this.etCity.setTag((Object) null);
        this.etPincode.setTag((Object) null);
        NestedScrollView nestedScrollView = objArr[0];
        this.mboundView0 = nestedScrollView;
        nestedScrollView.setTag((Object) null);
        CustomTextView customTextView = objArr[1];
        this.mboundView1 = customTextView;
        customTextView.setTag((Object) null);
        CustomTextView customTextView2 = objArr[10];
        this.mboundView10 = customTextView2;
        customTextView2.setTag((Object) null);
        LinearLayout linearLayout = objArr[11];
        this.mboundView11 = linearLayout;
        linearLayout.setTag((Object) null);
        CustomTextView customTextView3 = objArr[13];
        this.mboundView13 = customTextView3;
        customTextView3.setTag((Object) null);
        LinearLayout linearLayout2 = objArr[14];
        this.mboundView14 = linearLayout2;
        linearLayout2.setTag((Object) null);
        CustomTextView customTextView4 = objArr[16];
        this.mboundView16 = customTextView4;
        customTextView4.setTag((Object) null);
        LinearLayout linearLayout3 = objArr[2];
        this.mboundView2 = linearLayout3;
        linearLayout3.setTag((Object) null);
        CustomTextView customTextView5 = objArr[4];
        this.mboundView4 = customTextView5;
        customTextView5.setTag((Object) null);
        LinearLayout linearLayout4 = objArr[5];
        this.mboundView5 = linearLayout4;
        linearLayout4.setTag((Object) null);
        CustomTextView customTextView6 = objArr[7];
        this.mboundView7 = customTextView6;
        customTextView6.setTag((Object) null);
        LinearLayout linearLayout5 = objArr[8];
        this.mboundView8 = linearLayout5;
        linearLayout5.setTag((Object) null);
        this.tvContinue.setTag((Object) null);
        setRootTag(view);
        this.mCallback2 = new OnClickListener(this, 1);
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
        if (BR.viewModel != i2) {
            return false;
        }
        setViewModel((EditAddressViewModel) obj);
        return true;
    }

    public void setViewModel(EditAddressViewModel editAddressViewModel) {
        this.mViewModel = editAddressViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 4096;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return onChangeViewModelMPinCodeError((i) obj, i3);
            case 1:
                return onChangeViewModelMAddressLine2((i) obj, i3);
            case 2:
                return onChangeViewModelMPinCode((i) obj, i3);
            case 3:
                return onChangeViewModelMCTAText((i) obj, i3);
            case 4:
                return onChangeViewModelMAddressLine1((i) obj, i3);
            case 5:
                return onChangeViewModelMAddressLine3((i) obj, i3);
            case 6:
                return onChangeViewModelMTitle((i) obj, i3);
            case 7:
                return onChangeViewModelMCity((i) obj, i3);
            case 8:
                return onChangeViewModelMAddressLine1Error((i) obj, i3);
            case 9:
                return onChangeViewModelMAddressLine2Error((i) obj, i3);
            case 10:
                return onChangeViewModelMAddressLine3Error((i) obj, i3);
            case 11:
                return onChangeViewModelMCityError((i) obj, i3);
            default:
                return false;
        }
    }

    private boolean onChangeViewModelMPinCodeError(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelMAddressLine2(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelMPinCode(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelMCTAText(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeViewModelMAddressLine1(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeViewModelMAddressLine3(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeViewModelMTitle(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeViewModelMCity(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    private boolean onChangeViewModelMAddressLine1Error(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        return true;
    }

    private boolean onChangeViewModelMAddressLine2Error(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        return true;
    }

    private boolean onChangeViewModelMAddressLine3Error(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1024;
        }
        return true;
    }

    private boolean onChangeViewModelMCityError(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2048;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01b1  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01be  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0219  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x022c  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x028a  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x029a  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x0304  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0319  */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x039e  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0178  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r74 = this;
            r1 = r74
            monitor-enter(r74)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x051a }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x051a }
            monitor-exit(r74)     // Catch:{ all -> 0x051a }
            com.paytm.business.merchantprofile.viewmodel.EditAddressViewModel r0 = r1.mViewModel
            r6 = 16383(0x3fff, double:8.0943E-320)
            long r6 = r6 & r2
            r16 = 12416(0x3080, double:6.1343E-320)
            r18 = 12292(0x3004, double:6.073E-320)
            r20 = 12320(0x3020, double:6.087E-320)
            r22 = 12290(0x3002, double:6.072E-320)
            r24 = 12288(0x3000, double:6.071E-320)
            r26 = 12304(0x3010, double:6.079E-320)
            r28 = 12289(0x3001, double:6.0716E-320)
            r8 = 0
            int r32 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r32 == 0) goto L_0x03cb
            long r6 = r2 & r28
            int r33 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r33 == 0) goto L_0x0077
            if (r0 == 0) goto L_0x002d
            androidx.databinding.i<java.lang.String> r6 = r0.mPinCodeError
            goto L_0x002e
        L_0x002d:
            r6 = 0
        L_0x002e:
            r1.updateRegistration((int) r8, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x003a
            java.lang.Object r6 = r6.get()
            java.lang.String r6 = (java.lang.String) r6
            goto L_0x003b
        L_0x003a:
            r6 = 0
        L_0x003b:
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            if (r33 == 0) goto L_0x0056
            if (r7 == 0) goto L_0x004c
            r33 = 8388608(0x800000, double:4.144523E-317)
            long r2 = r2 | r33
            r33 = 134217728(0x8000000, double:6.63123685E-316)
            goto L_0x0054
        L_0x004c:
            r33 = 4194304(0x400000, double:2.0722615E-317)
            long r2 = r2 | r33
            r33 = 67108864(0x4000000, double:3.31561842E-316)
        L_0x0054:
            long r2 = r2 | r33
        L_0x0056:
            if (r7 == 0) goto L_0x005b
            r33 = 8
            goto L_0x005d
        L_0x005b:
            r33 = 0
        L_0x005d:
            if (r7 == 0) goto L_0x0068
            android.widget.LinearLayout r7 = r1.mboundView11
            android.content.Context r7 = r7.getContext()
            int r8 = com.paytm.business.merchantprofile.R.drawable.pr_rectangle_rounded_corner
            goto L_0x0070
        L_0x0068:
            android.widget.LinearLayout r7 = r1.mboundView11
            android.content.Context r7 = r7.getContext()
            int r8 = com.paytm.business.merchantprofile.R.drawable.pr_error_round_bg
        L_0x0070:
            android.graphics.drawable.Drawable r7 = androidx.appcompat.a.a.a.b(r7, r8)
            r8 = r33
            goto L_0x007a
        L_0x0077:
            r6 = 0
            r7 = 0
            r8 = 0
        L_0x007a:
            long r35 = r2 & r22
            int r33 = (r35 > r4 ? 1 : (r35 == r4 ? 0 : -1))
            if (r33 == 0) goto L_0x0093
            if (r0 == 0) goto L_0x0085
            androidx.databinding.i<java.lang.String> r10 = r0.mAddressLine2
            goto L_0x0086
        L_0x0085:
            r10 = 0
        L_0x0086:
            r11 = 1
            r1.updateRegistration((int) r11, (androidx.databinding.h) r10)
            if (r10 == 0) goto L_0x0093
            java.lang.Object r10 = r10.get()
            java.lang.String r10 = (java.lang.String) r10
            goto L_0x0094
        L_0x0093:
            r10 = 0
        L_0x0094:
            long r37 = r2 & r24
            int r11 = (r37 > r4 ? 1 : (r37 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x00ed
            if (r0 == 0) goto L_0x00ed
            com.paytm.business.merchantprofile.databinding.PrFragmentEditAddressBindingImpl$AfterTextChangedImpl r11 = r1.mViewModelAfterCityChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged
            if (r11 != 0) goto L_0x00a7
            com.paytm.business.merchantprofile.databinding.PrFragmentEditAddressBindingImpl$AfterTextChangedImpl r11 = new com.paytm.business.merchantprofile.databinding.PrFragmentEditAddressBindingImpl$AfterTextChangedImpl
            r11.<init>()
            r1.mViewModelAfterCityChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged = r11
        L_0x00a7:
            com.paytm.business.merchantprofile.databinding.PrFragmentEditAddressBindingImpl$AfterTextChangedImpl r11 = r11.setValue(r0)
            com.paytm.business.merchantprofile.databinding.PrFragmentEditAddressBindingImpl$AfterTextChangedImpl1 r9 = r1.mViewModelAfterAddressLine1ChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged
            if (r9 != 0) goto L_0x00b6
            com.paytm.business.merchantprofile.databinding.PrFragmentEditAddressBindingImpl$AfterTextChangedImpl1 r9 = new com.paytm.business.merchantprofile.databinding.PrFragmentEditAddressBindingImpl$AfterTextChangedImpl1
            r9.<init>()
            r1.mViewModelAfterAddressLine1ChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged = r9
        L_0x00b6:
            com.paytm.business.merchantprofile.databinding.PrFragmentEditAddressBindingImpl$AfterTextChangedImpl1 r9 = r9.setValue(r0)
            com.paytm.business.merchantprofile.databinding.PrFragmentEditAddressBindingImpl$AfterTextChangedImpl2 r12 = r1.mViewModelAfterAddressLine2ChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged
            if (r12 != 0) goto L_0x00c5
            com.paytm.business.merchantprofile.databinding.PrFragmentEditAddressBindingImpl$AfterTextChangedImpl2 r12 = new com.paytm.business.merchantprofile.databinding.PrFragmentEditAddressBindingImpl$AfterTextChangedImpl2
            r12.<init>()
            r1.mViewModelAfterAddressLine2ChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged = r12
        L_0x00c5:
            com.paytm.business.merchantprofile.databinding.PrFragmentEditAddressBindingImpl$AfterTextChangedImpl2 r12 = r12.setValue(r0)
            com.paytm.business.merchantprofile.databinding.PrFragmentEditAddressBindingImpl$AfterTextChangedImpl3 r13 = r1.mViewModelAfterAddressLine3ChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged
            if (r13 != 0) goto L_0x00d4
            com.paytm.business.merchantprofile.databinding.PrFragmentEditAddressBindingImpl$AfterTextChangedImpl3 r13 = new com.paytm.business.merchantprofile.databinding.PrFragmentEditAddressBindingImpl$AfterTextChangedImpl3
            r13.<init>()
            r1.mViewModelAfterAddressLine3ChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged = r13
        L_0x00d4:
            com.paytm.business.merchantprofile.databinding.PrFragmentEditAddressBindingImpl$AfterTextChangedImpl3 r13 = r13.setValue(r0)
            com.paytm.business.merchantprofile.databinding.PrFragmentEditAddressBindingImpl$AfterTextChangedImpl4 r14 = r1.mViewModelAfterPinCodeChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged
            if (r14 != 0) goto L_0x00e3
            com.paytm.business.merchantprofile.databinding.PrFragmentEditAddressBindingImpl$AfterTextChangedImpl4 r14 = new com.paytm.business.merchantprofile.databinding.PrFragmentEditAddressBindingImpl$AfterTextChangedImpl4
            r14.<init>()
            r1.mViewModelAfterPinCodeChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged = r14
        L_0x00e3:
            com.paytm.business.merchantprofile.databinding.PrFragmentEditAddressBindingImpl$AfterTextChangedImpl4 r14 = r14.setValue(r0)
            r73 = r11
            r11 = r9
            r9 = r73
            goto L_0x00f2
        L_0x00ed:
            r9 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
        L_0x00f2:
            long r41 = r2 & r18
            int r15 = (r41 > r4 ? 1 : (r41 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x010b
            if (r0 == 0) goto L_0x00fd
            androidx.databinding.i<java.lang.String> r15 = r0.mPinCode
            goto L_0x00fe
        L_0x00fd:
            r15 = 0
        L_0x00fe:
            r4 = 2
            r1.updateRegistration((int) r4, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x010b
            java.lang.Object r4 = r15.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x010c
        L_0x010b:
            r4 = 0
        L_0x010c:
            r39 = 12296(0x3008, double:6.075E-320)
            long r43 = r2 & r39
            r41 = 0
            int r5 = (r43 > r41 ? 1 : (r43 == r41 ? 0 : -1))
            if (r5 == 0) goto L_0x0129
            if (r0 == 0) goto L_0x011b
            androidx.databinding.i<java.lang.String> r5 = r0.mCTAText
            goto L_0x011c
        L_0x011b:
            r5 = 0
        L_0x011c:
            r15 = 3
            r1.updateRegistration((int) r15, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x0129
            java.lang.Object r5 = r5.get()
            java.lang.String r5 = (java.lang.String) r5
            goto L_0x012a
        L_0x0129:
            r5 = 0
        L_0x012a:
            long r43 = r2 & r26
            r41 = 0
            int r15 = (r43 > r41 ? 1 : (r43 == r41 ? 0 : -1))
            if (r15 == 0) goto L_0x0149
            if (r0 == 0) goto L_0x0139
            androidx.databinding.i<java.lang.String> r15 = r0.mAddressLine1
            r43 = r4
            goto L_0x013c
        L_0x0139:
            r43 = r4
            r15 = 0
        L_0x013c:
            r4 = 4
            r1.updateRegistration((int) r4, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x014b
            java.lang.Object r4 = r15.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x014c
        L_0x0149:
            r43 = r4
        L_0x014b:
            r4 = 0
        L_0x014c:
            long r44 = r2 & r20
            r41 = 0
            int r15 = (r44 > r41 ? 1 : (r44 == r41 ? 0 : -1))
            if (r15 == 0) goto L_0x016b
            if (r0 == 0) goto L_0x015b
            androidx.databinding.i<java.lang.String> r15 = r0.mAddressLine3
            r44 = r4
            goto L_0x015e
        L_0x015b:
            r44 = r4
            r15 = 0
        L_0x015e:
            r4 = 5
            r1.updateRegistration((int) r4, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x016d
            java.lang.Object r4 = r15.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x016e
        L_0x016b:
            r44 = r4
        L_0x016d:
            r4 = 0
        L_0x016e:
            r37 = 12352(0x3040, double:6.1027E-320)
            long r45 = r2 & r37
            r41 = 0
            int r15 = (r45 > r41 ? 1 : (r45 == r41 ? 0 : -1))
            if (r15 == 0) goto L_0x018f
            if (r0 == 0) goto L_0x017f
            androidx.databinding.i<java.lang.String> r15 = r0.mTitle
            r45 = r4
            goto L_0x0182
        L_0x017f:
            r45 = r4
            r15 = 0
        L_0x0182:
            r4 = 6
            r1.updateRegistration((int) r4, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x0191
            java.lang.Object r4 = r15.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0192
        L_0x018f:
            r45 = r4
        L_0x0191:
            r4 = 0
        L_0x0192:
            long r46 = r2 & r16
            r41 = 0
            int r15 = (r46 > r41 ? 1 : (r46 == r41 ? 0 : -1))
            if (r15 == 0) goto L_0x01b1
            if (r0 == 0) goto L_0x01a1
            androidx.databinding.i<java.lang.String> r15 = r0.mCity
            r46 = r4
            goto L_0x01a4
        L_0x01a1:
            r46 = r4
            r15 = 0
        L_0x01a4:
            r4 = 7
            r1.updateRegistration((int) r4, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x01b3
            java.lang.Object r4 = r15.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x01b4
        L_0x01b1:
            r46 = r4
        L_0x01b3:
            r4 = 0
        L_0x01b4:
            r47 = 12544(0x3100, double:6.1976E-320)
            long r47 = r2 & r47
            r41 = 0
            int r15 = (r47 > r41 ? 1 : (r47 == r41 ? 0 : -1))
            if (r15 == 0) goto L_0x0219
            r47 = r4
            if (r0 == 0) goto L_0x01c7
            androidx.databinding.i<java.lang.String> r4 = r0.mAddressLine1Error
            r33 = r5
            goto L_0x01ca
        L_0x01c7:
            r33 = r5
            r4 = 0
        L_0x01ca:
            r5 = 8
            r1.updateRegistration((int) r5, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x01d8
            java.lang.Object r4 = r4.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x01d9
        L_0x01d8:
            r4 = 0
        L_0x01d9:
            boolean r48 = android.text.TextUtils.isEmpty(r4)
            if (r15 == 0) goto L_0x01f3
            if (r48 == 0) goto L_0x01ea
            r49 = 32768(0x8000, double:1.61895E-319)
            long r2 = r2 | r49
            r49 = 131072(0x20000, double:6.47582E-319)
            goto L_0x01f1
        L_0x01ea:
            r49 = 16384(0x4000, double:8.0948E-320)
            long r2 = r2 | r49
            r49 = 65536(0x10000, double:3.2379E-319)
        L_0x01f1:
            long r2 = r2 | r49
        L_0x01f3:
            if (r48 == 0) goto L_0x01f8
            r15 = 8
            goto L_0x01f9
        L_0x01f8:
            r15 = 0
        L_0x01f9:
            if (r48 == 0) goto L_0x020a
            android.widget.LinearLayout r5 = r1.mboundView2
            android.content.Context r5 = r5.getContext()
            r49 = r2
            int r2 = com.paytm.business.merchantprofile.R.drawable.pr_rectangle_rounded_corner
            android.graphics.drawable.Drawable r2 = androidx.appcompat.a.a.a.b(r5, r2)
            goto L_0x0222
        L_0x020a:
            r49 = r2
            android.widget.LinearLayout r2 = r1.mboundView2
            android.content.Context r2 = r2.getContext()
            int r3 = com.paytm.business.merchantprofile.R.drawable.pr_error_round_bg
            android.graphics.drawable.Drawable r2 = androidx.appcompat.a.a.a.b(r2, r3)
            goto L_0x0222
        L_0x0219:
            r47 = r4
            r33 = r5
            r49 = r2
            r2 = 0
            r4 = 0
            r15 = 0
        L_0x0222:
            r51 = 12800(0x3200, double:6.324E-320)
            long r51 = r49 & r51
            r41 = 0
            int r3 = (r51 > r41 ? 1 : (r51 == r41 ? 0 : -1))
            if (r3 == 0) goto L_0x028a
            if (r0 == 0) goto L_0x0233
            androidx.databinding.i<java.lang.String> r5 = r0.mAddressLine2Error
            r51 = r2
            goto L_0x0236
        L_0x0233:
            r51 = r2
            r5 = 0
        L_0x0236:
            r2 = 9
            r1.updateRegistration((int) r2, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x0244
            java.lang.Object r2 = r5.get()
            java.lang.String r2 = (java.lang.String) r2
            goto L_0x0245
        L_0x0244:
            r2 = 0
        L_0x0245:
            boolean r5 = android.text.TextUtils.isEmpty(r2)
            if (r3 == 0) goto L_0x0262
            if (r5 == 0) goto L_0x0258
            r52 = 536870912(0x20000000, double:2.652494739E-315)
            long r49 = r49 | r52
            r52 = 2147483648(0x80000000, double:1.0609978955E-314)
            goto L_0x0260
        L_0x0258:
            r52 = 268435456(0x10000000, double:1.32624737E-315)
            long r49 = r49 | r52
            r52 = 1073741824(0x40000000, double:5.304989477E-315)
        L_0x0260:
            long r49 = r49 | r52
        L_0x0262:
            if (r5 == 0) goto L_0x0273
            android.widget.LinearLayout r3 = r1.mboundView5
            android.content.Context r3 = r3.getContext()
            r52 = r2
            int r2 = com.paytm.business.merchantprofile.R.drawable.pr_rectangle_rounded_corner
            android.graphics.drawable.Drawable r2 = androidx.appcompat.a.a.a.b(r3, r2)
            goto L_0x0281
        L_0x0273:
            r52 = r2
            android.widget.LinearLayout r2 = r1.mboundView5
            android.content.Context r2 = r2.getContext()
            int r3 = com.paytm.business.merchantprofile.R.drawable.pr_error_round_bg
            android.graphics.drawable.Drawable r2 = androidx.appcompat.a.a.a.b(r2, r3)
        L_0x0281:
            if (r5 == 0) goto L_0x0286
            r3 = 8
            goto L_0x0287
        L_0x0286:
            r3 = 0
        L_0x0287:
            r35 = 13312(0x3400, double:6.577E-320)
            goto L_0x0292
        L_0x028a:
            r51 = r2
            r2 = 0
            r3 = 0
            r35 = 13312(0x3400, double:6.577E-320)
            r52 = 0
        L_0x0292:
            long r53 = r49 & r35
            r41 = 0
            int r5 = (r53 > r41 ? 1 : (r53 == r41 ? 0 : -1))
            if (r5 == 0) goto L_0x0304
            r53 = r2
            if (r0 == 0) goto L_0x02a3
            androidx.databinding.i<java.lang.String> r2 = r0.mAddressLine3Error
            r54 = r3
            goto L_0x02a6
        L_0x02a3:
            r54 = r3
            r2 = 0
        L_0x02a6:
            r3 = 10
            r1.updateRegistration((int) r3, (androidx.databinding.h) r2)
            if (r2 == 0) goto L_0x02b4
            java.lang.Object r2 = r2.get()
            java.lang.String r2 = (java.lang.String) r2
            goto L_0x02b5
        L_0x02b4:
            r2 = 0
        L_0x02b5:
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r5 == 0) goto L_0x02d4
            if (r3 == 0) goto L_0x02c8
            r55 = 2097152(0x200000, double:1.0361308E-317)
            long r49 = r49 | r55
            r55 = 8589934592(0x200000000, double:4.243991582E-314)
            goto L_0x02d2
        L_0x02c8:
            r55 = 1048576(0x100000, double:5.180654E-318)
            long r49 = r49 | r55
            r55 = 4294967296(0x100000000, double:2.121995791E-314)
        L_0x02d2:
            long r49 = r49 | r55
        L_0x02d4:
            if (r3 == 0) goto L_0x02e5
            android.widget.LinearLayout r5 = r1.mboundView8
            android.content.Context r5 = r5.getContext()
            r55 = r2
            int r2 = com.paytm.business.merchantprofile.R.drawable.pr_rectangle_rounded_corner
            android.graphics.drawable.Drawable r2 = androidx.appcompat.a.a.a.b(r5, r2)
            goto L_0x02f3
        L_0x02e5:
            r55 = r2
            android.widget.LinearLayout r2 = r1.mboundView8
            android.content.Context r2 = r2.getContext()
            int r5 = com.paytm.business.merchantprofile.R.drawable.pr_error_round_bg
            android.graphics.drawable.Drawable r2 = androidx.appcompat.a.a.a.b(r2, r5)
        L_0x02f3:
            r5 = r2
            if (r3 == 0) goto L_0x02fd
            r2 = r49
            r30 = 14336(0x3800, double:7.083E-320)
            r49 = 8
            goto L_0x0311
        L_0x02fd:
            r2 = r49
            r30 = 14336(0x3800, double:7.083E-320)
            r49 = 0
            goto L_0x0311
        L_0x0304:
            r53 = r2
            r54 = r3
            r2 = r49
            r5 = 0
            r30 = 14336(0x3800, double:7.083E-320)
            r49 = 0
            r55 = 0
        L_0x0311:
            long r56 = r2 & r30
            r41 = 0
            int r50 = (r56 > r41 ? 1 : (r56 == r41 ? 0 : -1))
            if (r50 == 0) goto L_0x039e
            if (r0 == 0) goto L_0x0320
            androidx.databinding.i<java.lang.String> r0 = r0.mCityError
            r56 = r4
            goto L_0x0323
        L_0x0320:
            r56 = r4
            r0 = 0
        L_0x0323:
            r4 = 11
            r1.updateRegistration((int) r4, (androidx.databinding.h) r0)
            if (r0 == 0) goto L_0x0331
            java.lang.Object r0 = r0.get()
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x0332
        L_0x0331:
            r0 = 0
        L_0x0332:
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            if (r50 == 0) goto L_0x034d
            if (r4 == 0) goto L_0x0343
            r57 = 524288(0x80000, double:2.590327E-318)
            long r2 = r2 | r57
            r57 = 33554432(0x2000000, double:1.6578092E-316)
            goto L_0x034b
        L_0x0343:
            r57 = 262144(0x40000, double:1.295163E-318)
            long r2 = r2 | r57
            r57 = 16777216(0x1000000, double:8.289046E-317)
        L_0x034b:
            long r2 = r2 | r57
        L_0x034d:
            if (r4 == 0) goto L_0x0352
            r48 = 8
            goto L_0x0354
        L_0x0352:
            r48 = 0
        L_0x0354:
            if (r4 == 0) goto L_0x0365
            android.widget.LinearLayout r4 = r1.mboundView14
            android.content.Context r4 = r4.getContext()
            r50 = r0
            int r0 = com.paytm.business.merchantprofile.R.drawable.pr_rectangle_rounded_corner
            android.graphics.drawable.Drawable r0 = androidx.appcompat.a.a.a.b(r4, r0)
            goto L_0x0373
        L_0x0365:
            r50 = r0
            android.widget.LinearLayout r0 = r1.mboundView14
            android.content.Context r0 = r0.getContext()
            int r4 = com.paytm.business.merchantprofile.R.drawable.pr_error_round_bg
            android.graphics.drawable.Drawable r0 = androidx.appcompat.a.a.a.b(r0, r4)
        L_0x0373:
            r63 = r0
            r59 = r5
            r61 = r6
            r60 = r7
            r62 = r8
            r68 = r15
            r72 = r33
            r6 = r43
            r0 = r44
            r4 = r45
            r7 = r46
            r5 = r47
            r65 = r48
            r15 = r49
            r64 = r50
            r66 = r51
            r70 = r52
            r69 = r53
            r71 = r54
            r8 = r55
            r67 = r56
            goto L_0x03f4
        L_0x039e:
            r56 = r4
            r59 = r5
            r61 = r6
            r60 = r7
            r62 = r8
            r68 = r15
            r72 = r33
            r6 = r43
            r0 = r44
            r4 = r45
            r7 = r46
            r5 = r47
            r15 = r49
            r66 = r51
            r70 = r52
            r69 = r53
            r71 = r54
            r8 = r55
            r67 = r56
            r63 = 0
            r64 = 0
            r65 = 0
            goto L_0x03f4
        L_0x03cb:
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
            r59 = 0
            r60 = 0
            r61 = 0
            r62 = 0
            r63 = 0
            r64 = 0
            r65 = 0
            r66 = 0
            r67 = 0
            r68 = 0
            r69 = 0
            r70 = 0
            r71 = 0
            r72 = 0
        L_0x03f4:
            long r26 = r2 & r26
            r33 = 0
            int r41 = (r26 > r33 ? 1 : (r26 == r33 ? 0 : -1))
            r26 = r15
            if (r41 == 0) goto L_0x0403
            com.business.common_module.view.widget.CustomTextInputEditText r15 = r1.etAddress1
            androidx.databinding.a.d.a((android.widget.TextView) r15, (java.lang.CharSequence) r0)
        L_0x0403:
            long r24 = r2 & r24
            int r0 = (r24 > r33 ? 1 : (r24 == r33 ? 0 : -1))
            if (r0 == 0) goto L_0x0430
            com.business.common_module.view.widget.CustomTextInputEditText r0 = r1.etAddress1
            androidx.databinding.g r15 = r1.etAddress1androidTextAttrChanged
            r24 = r8
            r8 = 0
            androidx.databinding.a.d.a(r0, r8, r11, r15)
            com.business.common_module.view.widget.CustomTextInputEditText r0 = r1.etAddress2
            androidx.databinding.g r11 = r1.etAddress2androidTextAttrChanged
            androidx.databinding.a.d.a(r0, r8, r12, r11)
            com.business.common_module.view.widget.CustomTextInputEditText r0 = r1.etAddress3
            androidx.databinding.g r11 = r1.etAddress3androidTextAttrChanged
            androidx.databinding.a.d.a(r0, r8, r13, r11)
            com.business.common_module.view.widget.CustomTextInputEditText r0 = r1.etCity
            androidx.databinding.g r11 = r1.etCityandroidTextAttrChanged
            androidx.databinding.a.d.a(r0, r8, r9, r11)
            com.business.common_module.view.widget.CustomTextInputEditText r0 = r1.etPincode
            androidx.databinding.g r9 = r1.etPincodeandroidTextAttrChanged
            androidx.databinding.a.d.a(r0, r8, r14, r9)
            goto L_0x0432
        L_0x0430:
            r24 = r8
        L_0x0432:
            long r8 = r2 & r22
            r11 = 0
            int r0 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x043f
            com.business.common_module.view.widget.CustomTextInputEditText r0 = r1.etAddress2
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r10)
        L_0x043f:
            long r8 = r2 & r20
            int r0 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x044a
            com.business.common_module.view.widget.CustomTextInputEditText r0 = r1.etAddress3
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
        L_0x044a:
            long r8 = r2 & r16
            int r0 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x0455
            com.business.common_module.view.widget.CustomTextInputEditText r0 = r1.etCity
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r5)
        L_0x0455:
            long r4 = r2 & r18
            int r0 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x0460
            com.business.common_module.view.widget.CustomTextInputEditText r0 = r1.etPincode
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r6)
        L_0x0460:
            r4 = 12352(0x3040, double:6.1027E-320)
            long r4 = r4 & r2
            int r0 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x046c
            com.business.common_module.view.widget.CustomTextView r0 = r1.mboundView1
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r7)
        L_0x046c:
            r4 = 13312(0x3400, double:6.577E-320)
            long r4 = r4 & r2
            int r0 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x0488
            com.business.common_module.view.widget.CustomTextView r0 = r1.mboundView10
            r4 = r24
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
            com.business.common_module.view.widget.CustomTextView r0 = r1.mboundView10
            r4 = r26
            r0.setVisibility(r4)
            android.widget.LinearLayout r0 = r1.mboundView8
            r5 = r59
            androidx.databinding.a.e.a((android.view.View) r0, (android.graphics.drawable.Drawable) r5)
        L_0x0488:
            long r4 = r2 & r28
            int r0 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x04a3
            android.widget.LinearLayout r0 = r1.mboundView11
            r7 = r60
            androidx.databinding.a.e.a((android.view.View) r0, (android.graphics.drawable.Drawable) r7)
            com.business.common_module.view.widget.CustomTextView r0 = r1.mboundView13
            r6 = r61
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r6)
            com.business.common_module.view.widget.CustomTextView r0 = r1.mboundView13
            r8 = r62
            r0.setVisibility(r8)
        L_0x04a3:
            r4 = 14336(0x3800, double:7.083E-320)
            long r4 = r4 & r2
            int r0 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x04bf
            android.widget.LinearLayout r0 = r1.mboundView14
            r4 = r63
            androidx.databinding.a.e.a((android.view.View) r0, (android.graphics.drawable.Drawable) r4)
            com.business.common_module.view.widget.CustomTextView r0 = r1.mboundView16
            r4 = r64
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
            com.business.common_module.view.widget.CustomTextView r0 = r1.mboundView16
            r4 = r65
            r0.setVisibility(r4)
        L_0x04bf:
            r4 = 12544(0x3100, double:6.1976E-320)
            long r4 = r4 & r2
            r6 = 0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x04dd
            android.widget.LinearLayout r0 = r1.mboundView2
            r4 = r66
            androidx.databinding.a.e.a((android.view.View) r0, (android.graphics.drawable.Drawable) r4)
            com.business.common_module.view.widget.CustomTextView r0 = r1.mboundView4
            r4 = r67
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
            com.business.common_module.view.widget.CustomTextView r0 = r1.mboundView4
            r15 = r68
            r0.setVisibility(r15)
        L_0x04dd:
            r4 = 12800(0x3200, double:6.324E-320)
            long r4 = r4 & r2
            r6 = 0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x04fb
            android.widget.LinearLayout r0 = r1.mboundView5
            r4 = r69
            androidx.databinding.a.e.a((android.view.View) r0, (android.graphics.drawable.Drawable) r4)
            com.business.common_module.view.widget.CustomTextView r0 = r1.mboundView7
            r4 = r70
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
            com.business.common_module.view.widget.CustomTextView r0 = r1.mboundView7
            r4 = r71
            r0.setVisibility(r4)
        L_0x04fb:
            r4 = 8192(0x2000, double:4.0474E-320)
            long r4 = r4 & r2
            r6 = 0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x050b
            com.business.common_module.view.widget.CustomTextView r0 = r1.tvContinue
            android.view.View$OnClickListener r4 = r1.mCallback2
            r0.setOnClickListener(r4)
        L_0x050b:
            r4 = 12296(0x3008, double:6.075E-320)
            long r2 = r2 & r4
            int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x0519
            com.business.common_module.view.widget.CustomTextView r0 = r1.tvContinue
            r2 = r72
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r2)
        L_0x0519:
            return
        L_0x051a:
            r0 = move-exception
            monitor-exit(r74)     // Catch:{ all -> 0x051a }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.business.merchantprofile.databinding.PrFragmentEditAddressBindingImpl.executeBindings():void");
    }

    public static class AfterTextChangedImpl implements d.a {
        public EditAddressViewModel value;

        public AfterTextChangedImpl setValue(EditAddressViewModel editAddressViewModel) {
            this.value = editAddressViewModel;
            if (editAddressViewModel == null) {
                return null;
            }
            return this;
        }

        public void afterTextChanged(Editable editable) {
            this.value.afterCityChanged(editable);
        }
    }

    public static class AfterTextChangedImpl1 implements d.a {
        public EditAddressViewModel value;

        public AfterTextChangedImpl1 setValue(EditAddressViewModel editAddressViewModel) {
            this.value = editAddressViewModel;
            if (editAddressViewModel == null) {
                return null;
            }
            return this;
        }

        public void afterTextChanged(Editable editable) {
            this.value.afterAddressLine1Changed(editable);
        }
    }

    public static class AfterTextChangedImpl2 implements d.a {
        public EditAddressViewModel value;

        public AfterTextChangedImpl2 setValue(EditAddressViewModel editAddressViewModel) {
            this.value = editAddressViewModel;
            if (editAddressViewModel == null) {
                return null;
            }
            return this;
        }

        public void afterTextChanged(Editable editable) {
            this.value.afterAddressLine2Changed(editable);
        }
    }

    public static class AfterTextChangedImpl3 implements d.a {
        public EditAddressViewModel value;

        public AfterTextChangedImpl3 setValue(EditAddressViewModel editAddressViewModel) {
            this.value = editAddressViewModel;
            if (editAddressViewModel == null) {
                return null;
            }
            return this;
        }

        public void afterTextChanged(Editable editable) {
            this.value.afterAddressLine3Changed(editable);
        }
    }

    public static class AfterTextChangedImpl4 implements d.a {
        public EditAddressViewModel value;

        public AfterTextChangedImpl4 setValue(EditAddressViewModel editAddressViewModel) {
            this.value = editAddressViewModel;
            if (editAddressViewModel == null) {
                return null;
            }
            return this;
        }

        public void afterTextChanged(Editable editable) {
            this.value.afterPinCodeChanged(editable);
        }
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        EditAddressViewModel editAddressViewModel = this.mViewModel;
        if (editAddressViewModel != null) {
            editAddressViewModel.onContinue();
        }
    }
}
