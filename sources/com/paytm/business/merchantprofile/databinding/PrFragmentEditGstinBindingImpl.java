package com.paytm.business.merchantprofile.databinding;

import android.text.Editable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.databinding.g;
import androidx.databinding.i;
import com.business.common_module.view.widget.CustomTextView;
import com.paytm.business.merchantprofile.BR;
import com.paytm.business.merchantprofile.R;
import com.paytm.business.merchantprofile.generated.callback.OnClickListener;
import com.paytm.business.merchantprofile.viewmodel.EditGstinViewModel;

public class PrFragmentEditGstinBindingImpl extends PrFragmentEditGstinBinding implements OnClickListener.Listener {
    public static final ViewDataBinding.b sIncludes = null;
    public static final SparseIntArray sViewsWithIds;
    public g etGstinandroidTextAttrChanged;
    public final View.OnClickListener mCallback1;
    public long mDirtyFlags;
    public AfterTextChangedImpl mViewModelAfterGstinChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged;
    public final RelativeLayout mboundView0;
    public final CustomTextView mboundView2;
    public final CustomTextView mboundView3;
    public final LinearLayout mboundView4;
    public final CustomTextView mboundView6;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.rl_cross, 7);
        sViewsWithIds.put(R.id.text_input_account_number, 8);
        sViewsWithIds.put(R.id.add_edit_gstin_save, 9);
    }

    public PrFragmentEditGstinBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 10, sIncludes, sViewsWithIds));
    }

    public PrFragmentEditGstinBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 4, objArr[9], objArr[5], objArr[1], objArr[7], objArr[8]);
        this.etGstinandroidTextAttrChanged = new g() {
            public void onChange() {
                String a2 = d.a((TextView) PrFragmentEditGstinBindingImpl.this.etGstin);
                EditGstinViewModel editGstinViewModel = PrFragmentEditGstinBindingImpl.this.mViewModel;
                boolean z = true;
                if (editGstinViewModel != null) {
                    i<String> iVar = editGstinViewModel.mGstin;
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
        this.etGstin.setTag((Object) null);
        this.ivCross.setTag((Object) null);
        RelativeLayout relativeLayout = objArr[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag((Object) null);
        CustomTextView customTextView = objArr[2];
        this.mboundView2 = customTextView;
        customTextView.setTag((Object) null);
        CustomTextView customTextView2 = objArr[3];
        this.mboundView3 = customTextView2;
        customTextView2.setTag((Object) null);
        LinearLayout linearLayout = objArr[4];
        this.mboundView4 = linearLayout;
        linearLayout.setTag((Object) null);
        CustomTextView customTextView3 = objArr[6];
        this.mboundView6 = customTextView3;
        customTextView3.setTag((Object) null);
        setRootTag(view);
        this.mCallback1 = new OnClickListener(this, 1);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 32;
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
        setViewModel((EditGstinViewModel) obj);
        return true;
    }

    public void setViewModel(EditGstinViewModel editGstinViewModel) {
        this.mViewModel = editGstinViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return onChangeViewModelMTitle((i) obj, i3);
        }
        if (i2 == 1) {
            return onChangeViewModelMGstin((i) obj, i3);
        }
        if (i2 == 2) {
            return onChangeViewModelMGstinError((i) obj, i3);
        }
        if (i2 != 3) {
            return false;
        }
        return onChangeViewModelMSubTitle((i) obj, i3);
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

    private boolean onChangeViewModelMGstin(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelMGstinError(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelMSubTitle(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0055 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ca  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r26 = this;
            r1 = r26
            monitor-enter(r26)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x013d }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x013d }
            monitor-exit(r26)     // Catch:{ all -> 0x013d }
            com.paytm.business.merchantprofile.viewmodel.EditGstinViewModel r0 = r1.mViewModel
            r6 = 63
            long r6 = r6 & r2
            r10 = 52
            r12 = 48
            r14 = 50
            r16 = 49
            r8 = 0
            int r20 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r20 == 0) goto L_0x00e3
            long r6 = r2 & r16
            int r20 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r20 == 0) goto L_0x0034
            if (r0 == 0) goto L_0x0027
            androidx.databinding.i<java.lang.String> r6 = r0.mTitle
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
            long r20 = r2 & r14
            int r7 = (r20 > r4 ? 1 : (r20 == r4 ? 0 : -1))
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
            long r21 = r2 & r12
            int r8 = (r21 > r4 ? 1 : (r21 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x0067
            if (r0 == 0) goto L_0x0067
            com.paytm.business.merchantprofile.databinding.PrFragmentEditGstinBindingImpl$AfterTextChangedImpl r8 = r1.mViewModelAfterGstinChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged
            if (r8 != 0) goto L_0x0062
            com.paytm.business.merchantprofile.databinding.PrFragmentEditGstinBindingImpl$AfterTextChangedImpl r8 = new com.paytm.business.merchantprofile.databinding.PrFragmentEditGstinBindingImpl$AfterTextChangedImpl
            r8.<init>()
            r1.mViewModelAfterGstinChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged = r8
        L_0x0062:
            com.paytm.business.merchantprofile.databinding.PrFragmentEditGstinBindingImpl$AfterTextChangedImpl r8 = r8.setValue(r0)
            goto L_0x0068
        L_0x0067:
            r8 = 0
        L_0x0068:
            long r21 = r2 & r10
            int r23 = (r21 > r4 ? 1 : (r21 == r4 ? 0 : -1))
            if (r23 == 0) goto L_0x00be
            if (r0 == 0) goto L_0x0073
            androidx.databinding.i<java.lang.String> r10 = r0.mGstinError
            goto L_0x0074
        L_0x0073:
            r10 = 0
        L_0x0074:
            r11 = 2
            r1.updateRegistration((int) r11, (androidx.databinding.h) r10)
            if (r10 == 0) goto L_0x0081
            java.lang.Object r10 = r10.get()
            java.lang.String r10 = (java.lang.String) r10
            goto L_0x0082
        L_0x0081:
            r10 = 0
        L_0x0082:
            boolean r11 = android.text.TextUtils.isEmpty(r10)
            if (r23 == 0) goto L_0x0099
            if (r11 == 0) goto L_0x0091
            r23 = 128(0x80, double:6.32E-322)
            long r2 = r2 | r23
            r23 = 512(0x200, double:2.53E-321)
            goto L_0x0097
        L_0x0091:
            r23 = 64
            long r2 = r2 | r23
            r23 = 256(0x100, double:1.265E-321)
        L_0x0097:
            long r2 = r2 | r23
        L_0x0099:
            if (r11 == 0) goto L_0x009e
            r20 = 8
            goto L_0x00a0
        L_0x009e:
            r20 = 0
        L_0x00a0:
            if (r11 == 0) goto L_0x00af
            android.widget.LinearLayout r11 = r1.mboundView4
            android.content.Context r11 = r11.getContext()
            int r9 = com.paytm.business.merchantprofile.R.drawable.pr_rectangle_rounded_corner
            android.graphics.drawable.Drawable r9 = androidx.appcompat.a.a.a.b(r11, r9)
            goto L_0x00bb
        L_0x00af:
            android.widget.LinearLayout r9 = r1.mboundView4
            android.content.Context r9 = r9.getContext()
            int r11 = com.paytm.business.merchantprofile.R.drawable.pr_error_round_bg
            android.graphics.drawable.Drawable r9 = androidx.appcompat.a.a.a.b(r9, r11)
        L_0x00bb:
            r18 = 56
            goto L_0x00c4
        L_0x00be:
            r9 = 0
            r10 = 0
            r18 = 56
            r20 = 0
        L_0x00c4:
            long r24 = r2 & r18
            int r11 = (r24 > r4 ? 1 : (r24 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x00df
            if (r0 == 0) goto L_0x00cf
            androidx.databinding.i<java.lang.String> r0 = r0.mSubTitle
            goto L_0x00d0
        L_0x00cf:
            r0 = 0
        L_0x00d0:
            r11 = 3
            r1.updateRegistration((int) r11, (androidx.databinding.h) r0)
            if (r0 == 0) goto L_0x00df
            java.lang.Object r0 = r0.get()
            java.lang.String r0 = (java.lang.String) r0
            r11 = r20
            goto L_0x00ea
        L_0x00df:
            r11 = r20
            r0 = 0
            goto L_0x00ea
        L_0x00e3:
            r0 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
        L_0x00ea:
            long r14 = r14 & r2
            int r20 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r20 == 0) goto L_0x00f4
            com.business.common_module.view.widget.CustomTextInputEditText r14 = r1.etGstin
            androidx.databinding.a.d.a((android.widget.TextView) r14, (java.lang.CharSequence) r7)
        L_0x00f4:
            long r12 = r12 & r2
            int r7 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x0101
            com.business.common_module.view.widget.CustomTextInputEditText r7 = r1.etGstin
            androidx.databinding.g r12 = r1.etGstinandroidTextAttrChanged
            r13 = 0
            androidx.databinding.a.d.a(r7, r13, r8, r12)
        L_0x0101:
            r7 = 32
            long r7 = r7 & r2
            int r12 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x010f
            android.widget.ImageView r7 = r1.ivCross
            android.view.View$OnClickListener r8 = r1.mCallback1
            r7.setOnClickListener(r8)
        L_0x010f:
            long r7 = r2 & r16
            int r12 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x011a
            com.business.common_module.view.widget.CustomTextView r7 = r1.mboundView2
            androidx.databinding.a.d.a((android.widget.TextView) r7, (java.lang.CharSequence) r6)
        L_0x011a:
            r6 = 56
            long r6 = r6 & r2
            int r8 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x0126
            com.business.common_module.view.widget.CustomTextView r6 = r1.mboundView3
            androidx.databinding.a.d.a((android.widget.TextView) r6, (java.lang.CharSequence) r0)
        L_0x0126:
            r6 = 52
            long r2 = r2 & r6
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x013c
            android.widget.LinearLayout r0 = r1.mboundView4
            androidx.databinding.a.e.a((android.view.View) r0, (android.graphics.drawable.Drawable) r9)
            com.business.common_module.view.widget.CustomTextView r0 = r1.mboundView6
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r10)
            com.business.common_module.view.widget.CustomTextView r0 = r1.mboundView6
            r0.setVisibility(r11)
        L_0x013c:
            return
        L_0x013d:
            r0 = move-exception
            monitor-exit(r26)     // Catch:{ all -> 0x013d }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.business.merchantprofile.databinding.PrFragmentEditGstinBindingImpl.executeBindings():void");
    }

    public static class AfterTextChangedImpl implements d.a {
        public EditGstinViewModel value;

        public AfterTextChangedImpl setValue(EditGstinViewModel editGstinViewModel) {
            this.value = editGstinViewModel;
            if (editGstinViewModel == null) {
                return null;
            }
            return this;
        }

        public void afterTextChanged(Editable editable) {
            this.value.afterGstinChanged(editable);
        }
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        EditGstinViewModel editGstinViewModel = this.mViewModel;
        if (editGstinViewModel != null) {
            editGstinViewModel.onClose();
        }
    }
}
