package com.business.merchant_payments.databinding;

import android.text.Editable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.databinding.g;
import androidx.databinding.i;
import com.business.common_module.view.widget.CustomTextInputLayout;
import com.business.common_module.view.widget.CustomTextView;
import com.business.merchant_payments.BR;
import com.business.merchant_payments.R;
import com.business.merchant_payments.notificationsettings.viewmodel.AddMobileViewModel;

public class MpAddMobileActivityBindingImpl extends MpAddMobileActivityBinding {
    public static final ViewDataBinding.b sIncludes = null;
    public static final SparseIntArray sViewsWithIds;
    public g etAddress1androidTextAttrChanged;
    public long mDirtyFlags;
    public AfterTextChangedImpl mViewModelAfterInputChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged;
    public final CustomTextView mboundView1;
    public final TextView mboundView2;
    public final LinearLayout mboundView3;
    public final CustomTextInputLayout mboundView4;
    public final CustomTextView mboundView6;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.layout_bank_header_bar, 7);
        sViewsWithIds.put(R.id.back, 8);
        sViewsWithIds.put(R.id.button, 9);
        sViewsWithIds.put(R.id.button_text, 10);
    }

    public MpAddMobileActivityBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 11, sIncludes, sViewsWithIds));
    }

    public MpAddMobileActivityBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 7, objArr[8], objArr[9], objArr[10], objArr[0], objArr[5], objArr[7]);
        this.etAddress1androidTextAttrChanged = new g() {
            public void onChange() {
                String a2 = d.a((TextView) MpAddMobileActivityBindingImpl.this.etAddress1);
                AddMobileViewModel addMobileViewModel = MpAddMobileActivityBindingImpl.this.mViewModel;
                boolean z = true;
                if (addMobileViewModel != null) {
                    i<String> iVar = addMobileViewModel.mInput;
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
        this.coordinatorLayout.setTag((Object) null);
        this.etAddress1.setTag((Object) null);
        CustomTextView customTextView = objArr[1];
        this.mboundView1 = customTextView;
        customTextView.setTag((Object) null);
        TextView textView = objArr[2];
        this.mboundView2 = textView;
        textView.setTag((Object) null);
        LinearLayout linearLayout = objArr[3];
        this.mboundView3 = linearLayout;
        linearLayout.setTag((Object) null);
        CustomTextInputLayout customTextInputLayout = objArr[4];
        this.mboundView4 = customTextInputLayout;
        customTextInputLayout.setTag((Object) null);
        CustomTextView customTextView2 = objArr[6];
        this.mboundView6 = customTextView2;
        customTextView2.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 256;
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
        setViewModel((AddMobileViewModel) obj);
        return true;
    }

    public void setViewModel(AddMobileViewModel addMobileViewModel) {
        this.mViewModel = addMobileViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return onChangeViewModelMTitle((i) obj, i3);
            case 1:
                return onChangeViewModelMInputError((i) obj, i3);
            case 2:
                return onChangeViewModelMInput((i) obj, i3);
            case 3:
                return onChangeViewModelMInputHint((i) obj, i3);
            case 4:
                return onChangeViewModelMInputType((ObservableInt) obj, i3);
            case 5:
                return onChangeViewModelMSubTitle((i) obj, i3);
            case 6:
                return onChangeViewModelMInputMaxLength((ObservableInt) obj, i3);
            default:
                return false;
        }
    }

    private boolean onChangeViewModelMTitle(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelMInputError(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelMInput(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelMInputHint(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeViewModelMInputType(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeViewModelMSubTitle(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeViewModelMInputMaxLength(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00fe A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0117  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r36 = this;
            r1 = r36
            monitor-enter(r36)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x01a7 }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x01a7 }
            monitor-exit(r36)     // Catch:{ all -> 0x01a7 }
            com.business.merchant_payments.notificationsettings.viewmodel.AddMobileViewModel r0 = r1.mViewModel
            r6 = 511(0x1ff, double:2.525E-321)
            long r6 = r6 & r2
            r10 = 392(0x188, double:1.937E-321)
            r14 = 388(0x184, double:1.917E-321)
            r12 = 3
            r17 = 448(0x1c0, double:2.213E-321)
            r19 = 386(0x182, double:1.907E-321)
            r21 = 400(0x190, double:1.976E-321)
            r23 = 385(0x181, double:1.9E-321)
            r13 = 0
            int r9 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r9 == 0) goto L_0x012a
            long r6 = r2 & r23
            int r9 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r9 == 0) goto L_0x0039
            if (r0 == 0) goto L_0x002c
            androidx.databinding.i<java.lang.String> r6 = r0.mTitle
            goto L_0x002d
        L_0x002c:
            r6 = 0
        L_0x002d:
            r1.updateRegistration((int) r13, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x0039
            java.lang.Object r6 = r6.get()
            java.lang.String r6 = (java.lang.String) r6
            goto L_0x003a
        L_0x0039:
            r6 = 0
        L_0x003a:
            long r27 = r2 & r19
            int r7 = (r27 > r4 ? 1 : (r27 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x008c
            if (r0 == 0) goto L_0x0045
            androidx.databinding.i<java.lang.String> r9 = r0.mInputError
            goto L_0x0046
        L_0x0045:
            r9 = 0
        L_0x0046:
            r13 = 1
            r1.updateRegistration((int) r13, (androidx.databinding.h) r9)
            if (r9 == 0) goto L_0x0053
            java.lang.Object r9 = r9.get()
            java.lang.String r9 = (java.lang.String) r9
            goto L_0x0054
        L_0x0053:
            r9 = 0
        L_0x0054:
            boolean r13 = android.text.TextUtils.isEmpty(r9)
            if (r7 == 0) goto L_0x006b
            if (r13 == 0) goto L_0x0063
            r28 = 1024(0x400, double:5.06E-321)
            long r2 = r2 | r28
            r28 = 4096(0x1000, double:2.0237E-320)
            goto L_0x0069
        L_0x0063:
            r28 = 512(0x200, double:2.53E-321)
            long r2 = r2 | r28
            r28 = 2048(0x800, double:1.0118E-320)
        L_0x0069:
            long r2 = r2 | r28
        L_0x006b:
            if (r13 == 0) goto L_0x0076
            android.widget.LinearLayout r7 = r1.mboundView3
            android.content.Context r7 = r7.getContext()
            int r8 = com.business.merchant_payments.R.drawable.mp_rectangle_rounded_corner
            goto L_0x007e
        L_0x0076:
            android.widget.LinearLayout r7 = r1.mboundView3
            android.content.Context r7 = r7.getContext()
            int r8 = com.business.merchant_payments.R.drawable.mp_error_round_bg
        L_0x007e:
            android.graphics.drawable.Drawable r7 = androidx.appcompat.a.a.a.b(r7, r8)
            if (r13 == 0) goto L_0x008a
            r8 = 8
            r8 = r7
            r13 = 8
            goto L_0x008f
        L_0x008a:
            r8 = r7
            goto L_0x008e
        L_0x008c:
            r8 = 0
            r9 = 0
        L_0x008e:
            r13 = 0
        L_0x008f:
            long r29 = r2 & r14
            int r7 = (r29 > r4 ? 1 : (r29 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x00a8
            if (r0 == 0) goto L_0x009a
            androidx.databinding.i<java.lang.String> r7 = r0.mInput
            goto L_0x009b
        L_0x009a:
            r7 = 0
        L_0x009b:
            r14 = 2
            r1.updateRegistration((int) r14, (androidx.databinding.h) r7)
            if (r7 == 0) goto L_0x00a8
            java.lang.Object r7 = r7.get()
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x00a9
        L_0x00a8:
            r7 = 0
        L_0x00a9:
            long r14 = r2 & r10
            int r31 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r31 == 0) goto L_0x00c1
            if (r0 == 0) goto L_0x00b4
            androidx.databinding.i<java.lang.String> r14 = r0.mInputHint
            goto L_0x00b5
        L_0x00b4:
            r14 = 0
        L_0x00b5:
            r1.updateRegistration((int) r12, (androidx.databinding.h) r14)
            if (r14 == 0) goto L_0x00c1
            java.lang.Object r14 = r14.get()
            java.lang.String r14 = (java.lang.String) r14
            goto L_0x00c2
        L_0x00c1:
            r14 = 0
        L_0x00c2:
            long r31 = r2 & r21
            int r15 = (r31 > r4 ? 1 : (r31 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x00d9
            if (r0 == 0) goto L_0x00cd
            androidx.databinding.ObservableInt r15 = r0.mInputType
            goto L_0x00ce
        L_0x00cd:
            r15 = 0
        L_0x00ce:
            r10 = 4
            r1.updateRegistration((int) r10, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x00d9
            int r10 = r15.get()
            goto L_0x00da
        L_0x00d9:
            r10 = 0
        L_0x00da:
            r25 = 416(0x1a0, double:2.055E-321)
            long r33 = r2 & r25
            int r11 = (r33 > r4 ? 1 : (r33 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x00f5
            if (r0 == 0) goto L_0x00e7
            androidx.databinding.i<java.lang.String> r11 = r0.mSubTitle
            goto L_0x00e8
        L_0x00e7:
            r11 = 0
        L_0x00e8:
            r15 = 5
            r1.updateRegistration((int) r15, (androidx.databinding.h) r11)
            if (r11 == 0) goto L_0x00f5
            java.lang.Object r11 = r11.get()
            java.lang.String r11 = (java.lang.String) r11
            goto L_0x00f6
        L_0x00f5:
            r11 = 0
        L_0x00f6:
            r15 = 384(0x180, double:1.897E-321)
            long r33 = r2 & r15
            int r15 = (r33 > r4 ? 1 : (r33 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x0110
            if (r0 == 0) goto L_0x0110
            com.business.merchant_payments.databinding.MpAddMobileActivityBindingImpl$AfterTextChangedImpl r15 = r1.mViewModelAfterInputChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged
            if (r15 != 0) goto L_0x010b
            com.business.merchant_payments.databinding.MpAddMobileActivityBindingImpl$AfterTextChangedImpl r15 = new com.business.merchant_payments.databinding.MpAddMobileActivityBindingImpl$AfterTextChangedImpl
            r15.<init>()
            r1.mViewModelAfterInputChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged = r15
        L_0x010b:
            com.business.merchant_payments.databinding.MpAddMobileActivityBindingImpl$AfterTextChangedImpl r15 = r15.setValue(r0)
            goto L_0x0111
        L_0x0110:
            r15 = 0
        L_0x0111:
            long r33 = r2 & r17
            int r35 = (r33 > r4 ? 1 : (r33 == r4 ? 0 : -1))
            if (r35 == 0) goto L_0x0128
            if (r0 == 0) goto L_0x011c
            androidx.databinding.ObservableInt r0 = r0.mInputMaxLength
            goto L_0x011d
        L_0x011c:
            r0 = 0
        L_0x011d:
            r12 = 6
            r1.updateRegistration((int) r12, (androidx.databinding.h) r0)
            if (r0 == 0) goto L_0x0128
            int r0 = r0.get()
            goto L_0x0134
        L_0x0128:
            r0 = 0
            goto L_0x0134
        L_0x012a:
            r0 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r13 = 0
            r14 = 0
            r15 = 0
        L_0x0134:
            long r21 = r2 & r21
            int r12 = (r21 > r4 ? 1 : (r21 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x0146
            int r12 = androidx.databinding.ViewDataBinding.getBuildSdkInt()
            r4 = 3
            if (r12 < r4) goto L_0x0146
            com.google.android.material.textfield.TextInputEditText r4 = r1.etAddress1
            r4.setInputType(r10)
        L_0x0146:
            long r4 = r2 & r17
            r17 = 0
            int r10 = (r4 > r17 ? 1 : (r4 == r17 ? 0 : -1))
            if (r10 == 0) goto L_0x0153
            com.google.android.material.textfield.TextInputEditText r4 = r1.etAddress1
            androidx.databinding.a.d.a((android.widget.TextView) r4, (int) r0)
        L_0x0153:
            r4 = 388(0x184, double:1.917E-321)
            long r4 = r4 & r2
            int r0 = (r4 > r17 ? 1 : (r4 == r17 ? 0 : -1))
            if (r0 == 0) goto L_0x015f
            com.google.android.material.textfield.TextInputEditText r0 = r1.etAddress1
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r7)
        L_0x015f:
            r4 = 384(0x180, double:1.897E-321)
            long r4 = r4 & r2
            int r0 = (r4 > r17 ? 1 : (r4 == r17 ? 0 : -1))
            if (r0 == 0) goto L_0x016e
            com.google.android.material.textfield.TextInputEditText r0 = r1.etAddress1
            androidx.databinding.g r4 = r1.etAddress1androidTextAttrChanged
            r5 = 0
            androidx.databinding.a.d.a(r0, r5, r15, r4)
        L_0x016e:
            long r4 = r2 & r23
            int r0 = (r4 > r17 ? 1 : (r4 == r17 ? 0 : -1))
            if (r0 == 0) goto L_0x0179
            com.business.common_module.view.widget.CustomTextView r0 = r1.mboundView1
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r6)
        L_0x0179:
            r4 = 416(0x1a0, double:2.055E-321)
            long r4 = r4 & r2
            int r0 = (r4 > r17 ? 1 : (r4 == r17 ? 0 : -1))
            if (r0 == 0) goto L_0x0185
            android.widget.TextView r0 = r1.mboundView2
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r11)
        L_0x0185:
            long r4 = r2 & r19
            int r0 = (r4 > r17 ? 1 : (r4 == r17 ? 0 : -1))
            if (r0 == 0) goto L_0x019a
            android.widget.LinearLayout r0 = r1.mboundView3
            androidx.databinding.a.e.a((android.view.View) r0, (android.graphics.drawable.Drawable) r8)
            com.business.common_module.view.widget.CustomTextView r0 = r1.mboundView6
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r9)
            com.business.common_module.view.widget.CustomTextView r0 = r1.mboundView6
            r0.setVisibility(r13)
        L_0x019a:
            r4 = 392(0x188, double:1.937E-321)
            long r2 = r2 & r4
            int r0 = (r2 > r17 ? 1 : (r2 == r17 ? 0 : -1))
            if (r0 == 0) goto L_0x01a6
            com.business.common_module.view.widget.CustomTextInputLayout r0 = r1.mboundView4
            r0.setHint(r14)
        L_0x01a6:
            return
        L_0x01a7:
            r0 = move-exception
            monitor-exit(r36)     // Catch:{ all -> 0x01a7 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.databinding.MpAddMobileActivityBindingImpl.executeBindings():void");
    }

    public static class AfterTextChangedImpl implements d.a {
        public AddMobileViewModel value;

        public AfterTextChangedImpl setValue(AddMobileViewModel addMobileViewModel) {
            this.value = addMobileViewModel;
            if (addMobileViewModel == null) {
                return null;
            }
            return this;
        }

        public void afterTextChanged(Editable editable) {
            this.value.afterInputChanged(editable);
        }
    }
}
