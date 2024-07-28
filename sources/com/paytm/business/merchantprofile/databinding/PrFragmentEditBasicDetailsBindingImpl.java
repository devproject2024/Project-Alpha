package com.paytm.business.merchantprofile.databinding;

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
import com.paytm.business.merchantprofile.BR;
import com.paytm.business.merchantprofile.R;
import com.paytm.business.merchantprofile.generated.callback.OnClickListener;
import com.paytm.business.merchantprofile.viewmodel.EditBasicDetailsViewModel;

public class PrFragmentEditBasicDetailsBindingImpl extends PrFragmentEditBasicDetailsBinding implements OnClickListener.Listener {
    public static final ViewDataBinding.b sIncludes = null;
    public static final SparseIntArray sViewsWithIds;
    public g etInputandroidTextAttrChanged;
    public final View.OnClickListener mCallback3;
    public final View.OnClickListener mCallback4;
    public long mDirtyFlags;
    public AfterTextChangedImpl mViewModelAfterInputChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged;
    public final CustomTextView mboundView2;
    public final CustomTextView mboundView3;
    public final LinearLayout mboundView4;
    public final CustomTextInputLayout mboundView5;
    public final CustomTextView mboundView7;
    public final CustomTextView mboundView8;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.rl_cross, 9);
        sViewsWithIds.put(R.id.rl_middle_container, 10);
    }

    public PrFragmentEditBasicDetailsBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 11, sIncludes, sViewsWithIds));
    }

    public PrFragmentEditBasicDetailsBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 7, objArr[0], objArr[6], objArr[1], objArr[9], objArr[10]);
        this.etInputandroidTextAttrChanged = new g() {
            public void onChange() {
                String a2 = d.a((TextView) PrFragmentEditBasicDetailsBindingImpl.this.etInput);
                EditBasicDetailsViewModel editBasicDetailsViewModel = PrFragmentEditBasicDetailsBindingImpl.this.mViewModel;
                boolean z = true;
                if (editBasicDetailsViewModel != null) {
                    i<String> iVar = editBasicDetailsViewModel.mInput;
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
        this.etInput.setTag((Object) null);
        this.ivCross.setTag((Object) null);
        CustomTextView customTextView = objArr[2];
        this.mboundView2 = customTextView;
        customTextView.setTag((Object) null);
        CustomTextView customTextView2 = objArr[3];
        this.mboundView3 = customTextView2;
        customTextView2.setTag((Object) null);
        LinearLayout linearLayout = objArr[4];
        this.mboundView4 = linearLayout;
        linearLayout.setTag((Object) null);
        CustomTextInputLayout customTextInputLayout = objArr[5];
        this.mboundView5 = customTextInputLayout;
        customTextInputLayout.setTag((Object) null);
        CustomTextView customTextView3 = objArr[7];
        this.mboundView7 = customTextView3;
        customTextView3.setTag((Object) null);
        CustomTextView customTextView4 = objArr[8];
        this.mboundView8 = customTextView4;
        customTextView4.setTag((Object) null);
        setRootTag(view);
        this.mCallback4 = new OnClickListener(this, 2);
        this.mCallback3 = new OnClickListener(this, 1);
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
        setViewModel((EditBasicDetailsViewModel) obj);
        return true;
    }

    public void setViewModel(EditBasicDetailsViewModel editBasicDetailsViewModel) {
        this.mViewModel = editBasicDetailsViewModel;
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
    /* JADX WARNING: Removed duplicated region for block: B:38:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0100 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0119  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r36 = this;
            r1 = r36
            monitor-enter(r36)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x01c5 }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x01c5 }
            monitor-exit(r36)     // Catch:{ all -> 0x01c5 }
            com.paytm.business.merchantprofile.viewmodel.EditBasicDetailsViewModel r0 = r1.mViewModel
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
            if (r9 == 0) goto L_0x012c
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
            if (r7 == 0) goto L_0x008e
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
            if (r13 == 0) goto L_0x0070
            r7 = 8
            goto L_0x0071
        L_0x0070:
            r7 = 0
        L_0x0071:
            if (r13 == 0) goto L_0x0080
            android.widget.LinearLayout r13 = r1.mboundView4
            android.content.Context r13 = r13.getContext()
            int r8 = com.paytm.business.merchantprofile.R.drawable.pr_rectangle_rounded_corner
            android.graphics.drawable.Drawable r8 = androidx.appcompat.a.a.a.b(r13, r8)
            goto L_0x008c
        L_0x0080:
            android.widget.LinearLayout r8 = r1.mboundView4
            android.content.Context r8 = r8.getContext()
            int r13 = com.paytm.business.merchantprofile.R.drawable.pr_error_round_bg
            android.graphics.drawable.Drawable r8 = androidx.appcompat.a.a.a.b(r8, r13)
        L_0x008c:
            r13 = r7
            goto L_0x0091
        L_0x008e:
            r8 = 0
            r9 = 0
            r13 = 0
        L_0x0091:
            long r29 = r2 & r14
            int r7 = (r29 > r4 ? 1 : (r29 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x00aa
            if (r0 == 0) goto L_0x009c
            androidx.databinding.i<java.lang.String> r7 = r0.mInput
            goto L_0x009d
        L_0x009c:
            r7 = 0
        L_0x009d:
            r14 = 2
            r1.updateRegistration((int) r14, (androidx.databinding.h) r7)
            if (r7 == 0) goto L_0x00aa
            java.lang.Object r7 = r7.get()
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x00ab
        L_0x00aa:
            r7 = 0
        L_0x00ab:
            long r14 = r2 & r10
            int r31 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r31 == 0) goto L_0x00c3
            if (r0 == 0) goto L_0x00b6
            androidx.databinding.i<java.lang.String> r14 = r0.mInputHint
            goto L_0x00b7
        L_0x00b6:
            r14 = 0
        L_0x00b7:
            r1.updateRegistration((int) r12, (androidx.databinding.h) r14)
            if (r14 == 0) goto L_0x00c3
            java.lang.Object r14 = r14.get()
            java.lang.String r14 = (java.lang.String) r14
            goto L_0x00c4
        L_0x00c3:
            r14 = 0
        L_0x00c4:
            long r31 = r2 & r21
            int r15 = (r31 > r4 ? 1 : (r31 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x00db
            if (r0 == 0) goto L_0x00cf
            androidx.databinding.ObservableInt r15 = r0.mInputType
            goto L_0x00d0
        L_0x00cf:
            r15 = 0
        L_0x00d0:
            r10 = 4
            r1.updateRegistration((int) r10, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x00db
            int r10 = r15.get()
            goto L_0x00dc
        L_0x00db:
            r10 = 0
        L_0x00dc:
            r25 = 416(0x1a0, double:2.055E-321)
            long r33 = r2 & r25
            int r11 = (r33 > r4 ? 1 : (r33 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x00f7
            if (r0 == 0) goto L_0x00e9
            androidx.databinding.i<java.lang.String> r11 = r0.mSubTitle
            goto L_0x00ea
        L_0x00e9:
            r11 = 0
        L_0x00ea:
            r15 = 5
            r1.updateRegistration((int) r15, (androidx.databinding.h) r11)
            if (r11 == 0) goto L_0x00f7
            java.lang.Object r11 = r11.get()
            java.lang.String r11 = (java.lang.String) r11
            goto L_0x00f8
        L_0x00f7:
            r11 = 0
        L_0x00f8:
            r15 = 384(0x180, double:1.897E-321)
            long r33 = r2 & r15
            int r15 = (r33 > r4 ? 1 : (r33 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x0112
            if (r0 == 0) goto L_0x0112
            com.paytm.business.merchantprofile.databinding.PrFragmentEditBasicDetailsBindingImpl$AfterTextChangedImpl r15 = r1.mViewModelAfterInputChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged
            if (r15 != 0) goto L_0x010d
            com.paytm.business.merchantprofile.databinding.PrFragmentEditBasicDetailsBindingImpl$AfterTextChangedImpl r15 = new com.paytm.business.merchantprofile.databinding.PrFragmentEditBasicDetailsBindingImpl$AfterTextChangedImpl
            r15.<init>()
            r1.mViewModelAfterInputChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged = r15
        L_0x010d:
            com.paytm.business.merchantprofile.databinding.PrFragmentEditBasicDetailsBindingImpl$AfterTextChangedImpl r15 = r15.setValue(r0)
            goto L_0x0113
        L_0x0112:
            r15 = 0
        L_0x0113:
            long r33 = r2 & r17
            int r35 = (r33 > r4 ? 1 : (r33 == r4 ? 0 : -1))
            if (r35 == 0) goto L_0x012a
            if (r0 == 0) goto L_0x011e
            androidx.databinding.ObservableInt r0 = r0.mInputMaxLength
            goto L_0x011f
        L_0x011e:
            r0 = 0
        L_0x011f:
            r12 = 6
            r1.updateRegistration((int) r12, (androidx.databinding.h) r0)
            if (r0 == 0) goto L_0x012a
            int r0 = r0.get()
            goto L_0x0136
        L_0x012a:
            r0 = 0
            goto L_0x0136
        L_0x012c:
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
        L_0x0136:
            long r21 = r2 & r21
            int r12 = (r21 > r4 ? 1 : (r21 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x0148
            int r12 = androidx.databinding.ViewDataBinding.getBuildSdkInt()
            r4 = 3
            if (r12 < r4) goto L_0x0148
            com.business.common_module.view.widget.CustomTextInputEditText r4 = r1.etInput
            r4.setInputType(r10)
        L_0x0148:
            long r4 = r2 & r17
            r17 = 0
            int r10 = (r4 > r17 ? 1 : (r4 == r17 ? 0 : -1))
            if (r10 == 0) goto L_0x0155
            com.business.common_module.view.widget.CustomTextInputEditText r4 = r1.etInput
            androidx.databinding.a.d.a((android.widget.TextView) r4, (int) r0)
        L_0x0155:
            r4 = 388(0x184, double:1.917E-321)
            long r4 = r4 & r2
            int r0 = (r4 > r17 ? 1 : (r4 == r17 ? 0 : -1))
            if (r0 == 0) goto L_0x0161
            com.business.common_module.view.widget.CustomTextInputEditText r0 = r1.etInput
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r7)
        L_0x0161:
            r4 = 384(0x180, double:1.897E-321)
            long r4 = r4 & r2
            int r0 = (r4 > r17 ? 1 : (r4 == r17 ? 0 : -1))
            if (r0 == 0) goto L_0x0170
            com.business.common_module.view.widget.CustomTextInputEditText r0 = r1.etInput
            androidx.databinding.g r4 = r1.etInputandroidTextAttrChanged
            r5 = 0
            androidx.databinding.a.d.a(r0, r5, r15, r4)
        L_0x0170:
            r4 = 256(0x100, double:1.265E-321)
            long r4 = r4 & r2
            int r0 = (r4 > r17 ? 1 : (r4 == r17 ? 0 : -1))
            if (r0 == 0) goto L_0x0185
            android.widget.ImageView r0 = r1.ivCross
            android.view.View$OnClickListener r4 = r1.mCallback3
            r0.setOnClickListener(r4)
            com.business.common_module.view.widget.CustomTextView r0 = r1.mboundView8
            android.view.View$OnClickListener r4 = r1.mCallback4
            r0.setOnClickListener(r4)
        L_0x0185:
            long r4 = r2 & r23
            int r0 = (r4 > r17 ? 1 : (r4 == r17 ? 0 : -1))
            if (r0 == 0) goto L_0x0190
            com.business.common_module.view.widget.CustomTextView r0 = r1.mboundView2
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r6)
        L_0x0190:
            r4 = 416(0x1a0, double:2.055E-321)
            long r4 = r4 & r2
            int r0 = (r4 > r17 ? 1 : (r4 == r17 ? 0 : -1))
            if (r0 == 0) goto L_0x019c
            com.business.common_module.view.widget.CustomTextView r0 = r1.mboundView3
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r11)
        L_0x019c:
            long r4 = r2 & r19
            int r0 = (r4 > r17 ? 1 : (r4 == r17 ? 0 : -1))
            if (r0 == 0) goto L_0x01b6
            android.widget.LinearLayout r0 = r1.mboundView4
            androidx.databinding.a.e.a((android.view.View) r0, (android.graphics.drawable.Drawable) r8)
            com.business.common_module.view.widget.CustomTextInputLayout r0 = r1.mboundView5
            com.paytm.business.merchantprofile.common.utility.DataBindingUtility.errorText(r0, r9)
            com.business.common_module.view.widget.CustomTextView r0 = r1.mboundView7
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r9)
            com.business.common_module.view.widget.CustomTextView r0 = r1.mboundView7
            r0.setVisibility(r13)
        L_0x01b6:
            r4 = 392(0x188, double:1.937E-321)
            long r2 = r2 & r4
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x01c4
            com.business.common_module.view.widget.CustomTextInputLayout r0 = r1.mboundView5
            r0.setHint(r14)
        L_0x01c4:
            return
        L_0x01c5:
            r0 = move-exception
            monitor-exit(r36)     // Catch:{ all -> 0x01c5 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.business.merchantprofile.databinding.PrFragmentEditBasicDetailsBindingImpl.executeBindings():void");
    }

    public static class AfterTextChangedImpl implements d.a {
        public EditBasicDetailsViewModel value;

        public AfterTextChangedImpl setValue(EditBasicDetailsViewModel editBasicDetailsViewModel) {
            this.value = editBasicDetailsViewModel;
            if (editBasicDetailsViewModel == null) {
                return null;
            }
            return this;
        }

        public void afterTextChanged(Editable editable) {
            this.value.afterInputChanged(editable);
        }
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        boolean z = false;
        if (i2 == 1) {
            EditBasicDetailsViewModel editBasicDetailsViewModel = this.mViewModel;
            if (editBasicDetailsViewModel != null) {
                z = true;
            }
            if (z) {
                editBasicDetailsViewModel.onClose();
            }
        } else if (i2 == 2) {
            EditBasicDetailsViewModel editBasicDetailsViewModel2 = this.mViewModel;
            if (editBasicDetailsViewModel2 != null) {
                z = true;
            }
            if (z) {
                editBasicDetailsViewModel2.onContinue();
            }
        }
    }
}
