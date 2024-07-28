package net.one97.paytm.nativesdk.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.databinding.h;
import androidx.databinding.i;
import net.one97.paytm.nativesdk.BR;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.generated.callback.OnTextChanged;
import net.one97.paytm.nativesdk.otp.viewmodel.OtpViewModel;

public class FragmentVerifyOtpNativeBindingImpl extends FragmentVerifyOtpNativeBinding implements OnTextChanged.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final d.c mCallback3;
    private long mDirtyFlags;
    private OnClickListenerImpl mOtpViewholderHandleResendOtpClickAndroidViewViewOnClickListener;
    private final LinearLayout mboundView0;
    private final RelativeLayout mboundView5;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.tv_phoneNumber, 8);
        sViewsWithIds.put(R.id.dot_progress_bar, 9);
        sViewsWithIds.put(R.id.lyt_sign_in_button, 10);
        sViewsWithIds.put(R.id.btn_login, 11);
    }

    public FragmentVerifyOtpNativeBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 12, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private FragmentVerifyOtpNativeBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 7, objArr[11], objArr[9], objArr[3], objArr[10], objArr[2], objArr[7], objArr[8], objArr[6], objArr[4], objArr[1]);
        this.mDirtyFlags = -1;
        this.lytErrorOtpMsg.setTag((Object) null);
        this.lytValidatingOtp.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.mboundView5 = objArr[5];
        this.mboundView5.setTag((Object) null);
        this.pbProgress.setTag((Object) null);
        this.tvResendOtp.setTag((Object) null);
        this.txtErrorMsg.setTag((Object) null);
        this.txtPinEntry.setTag((Object) null);
        setRootTag(view);
        this.mCallback3 = new OnTextChanged(this, 1);
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
        if (BR.otpViewholder != i2) {
            return false;
        }
        setOtpViewholder((OtpViewModel) obj);
        return true;
    }

    public void setOtpViewholder(OtpViewModel otpViewModel) {
        updateRegistration(1, (h) otpViewModel);
        this.mOtpViewholder = otpViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.otpViewholder);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return onChangeOtpViewholderLytErrorMsgsVisblity((ObservableInt) obj, i3);
            case 1:
                return onChangeOtpViewholder((OtpViewModel) obj, i3);
            case 2:
                return onChangeOtpViewholderMOtp((i) obj, i3);
            case 3:
                return onChangeOtpViewholderMErrorMsg((i) obj, i3);
            case 4:
                return onChangeOtpViewholderProgressBarVisiblity((ObservableInt) obj, i3);
            case 5:
                return onChangeOtpViewholderOtpEdittextVisiblity((ObservableInt) obj, i3);
            case 6:
                return onChangeOtpViewholderValidatingOtpViewVisiblity((ObservableInt) obj, i3);
            default:
                return false;
        }
    }

    private boolean onChangeOtpViewholderLytErrorMsgsVisblity(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeOtpViewholder(OtpViewModel otpViewModel, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeOtpViewholderMOtp(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeOtpViewholderMErrorMsg(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeOtpViewholderProgressBarVisiblity(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeOtpViewholderOtpEdittextVisiblity(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeOtpViewholderValidatingOtpViewVisiblity(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0057 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00bd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r31 = this;
            r1 = r31
            monitor-enter(r31)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x0137 }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x0137 }
            monitor-exit(r31)     // Catch:{ all -> 0x0137 }
            net.one97.paytm.nativesdk.otp.viewmodel.OtpViewModel r0 = r1.mOtpViewholder
            r6 = 255(0xff, double:1.26E-321)
            long r6 = r6 & r2
            r8 = 138(0x8a, double:6.8E-322)
            r10 = 146(0x92, double:7.2E-322)
            r12 = 130(0x82, double:6.4E-322)
            r16 = 134(0x86, double:6.6E-322)
            r18 = 194(0xc2, double:9.6E-322)
            r20 = 131(0x83, double:6.47E-322)
            r14 = 0
            int r24 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r24 == 0) goto L_0x00d0
            long r6 = r2 & r20
            int r24 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r24 == 0) goto L_0x0036
            if (r0 == 0) goto L_0x002b
            androidx.databinding.ObservableInt r6 = r0.lytErrorMsgsVisblity
            goto L_0x002c
        L_0x002b:
            r6 = 0
        L_0x002c:
            r1.updateRegistration((int) r14, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x0036
            int r6 = r6.get()
            goto L_0x0037
        L_0x0036:
            r6 = 0
        L_0x0037:
            long r24 = r2 & r16
            int r7 = (r24 > r4 ? 1 : (r24 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x0050
            if (r0 == 0) goto L_0x0042
            androidx.databinding.i<java.lang.String> r7 = r0.mOtp
            goto L_0x0043
        L_0x0042:
            r7 = 0
        L_0x0043:
            r14 = 2
            r1.updateRegistration((int) r14, (androidx.databinding.h) r7)
            if (r7 == 0) goto L_0x0050
            java.lang.Object r7 = r7.get()
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x0051
        L_0x0050:
            r7 = 0
        L_0x0051:
            long r25 = r2 & r12
            int r14 = (r25 > r4 ? 1 : (r25 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x0069
            if (r0 == 0) goto L_0x0069
            net.one97.paytm.nativesdk.databinding.FragmentVerifyOtpNativeBindingImpl$OnClickListenerImpl r14 = r1.mOtpViewholderHandleResendOtpClickAndroidViewViewOnClickListener
            if (r14 != 0) goto L_0x0064
            net.one97.paytm.nativesdk.databinding.FragmentVerifyOtpNativeBindingImpl$OnClickListenerImpl r14 = new net.one97.paytm.nativesdk.databinding.FragmentVerifyOtpNativeBindingImpl$OnClickListenerImpl
            r14.<init>()
            r1.mOtpViewholderHandleResendOtpClickAndroidViewViewOnClickListener = r14
        L_0x0064:
            net.one97.paytm.nativesdk.databinding.FragmentVerifyOtpNativeBindingImpl$OnClickListenerImpl r14 = r14.setValue(r0)
            goto L_0x006a
        L_0x0069:
            r14 = 0
        L_0x006a:
            long r25 = r2 & r8
            int r27 = (r25 > r4 ? 1 : (r25 == r4 ? 0 : -1))
            if (r27 == 0) goto L_0x0084
            if (r0 == 0) goto L_0x0075
            androidx.databinding.i<java.lang.String> r15 = r0.mErrorMsg
            goto L_0x0076
        L_0x0075:
            r15 = 0
        L_0x0076:
            r8 = 3
            r1.updateRegistration((int) r8, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x0084
            java.lang.Object r8 = r15.get()
            r15 = r8
            java.lang.String r15 = (java.lang.String) r15
            goto L_0x0085
        L_0x0084:
            r15 = 0
        L_0x0085:
            long r8 = r2 & r10
            int r28 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r28 == 0) goto L_0x009c
            if (r0 == 0) goto L_0x0090
            androidx.databinding.ObservableInt r8 = r0.progressBarVisiblity
            goto L_0x0091
        L_0x0090:
            r8 = 0
        L_0x0091:
            r9 = 4
            r1.updateRegistration((int) r9, (androidx.databinding.h) r8)
            if (r8 == 0) goto L_0x009c
            int r8 = r8.get()
            goto L_0x009d
        L_0x009c:
            r8 = 0
        L_0x009d:
            r22 = 162(0xa2, double:8.0E-322)
            long r28 = r2 & r22
            int r9 = (r28 > r4 ? 1 : (r28 == r4 ? 0 : -1))
            if (r9 == 0) goto L_0x00b6
            if (r0 == 0) goto L_0x00aa
            androidx.databinding.ObservableInt r9 = r0.otpEdittextVisiblity
            goto L_0x00ab
        L_0x00aa:
            r9 = 0
        L_0x00ab:
            r12 = 5
            r1.updateRegistration((int) r12, (androidx.databinding.h) r9)
            if (r9 == 0) goto L_0x00b6
            int r9 = r9.get()
            goto L_0x00b7
        L_0x00b6:
            r9 = 0
        L_0x00b7:
            long r12 = r2 & r18
            int r30 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r30 == 0) goto L_0x00ce
            if (r0 == 0) goto L_0x00c2
            androidx.databinding.ObservableInt r0 = r0.validatingOtpViewVisiblity
            goto L_0x00c3
        L_0x00c2:
            r0 = 0
        L_0x00c3:
            r12 = 6
            r1.updateRegistration((int) r12, (androidx.databinding.h) r0)
            if (r0 == 0) goto L_0x00ce
            int r0 = r0.get()
            goto L_0x00d7
        L_0x00ce:
            r0 = 0
            goto L_0x00d7
        L_0x00d0:
            r0 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r14 = 0
            r15 = 0
        L_0x00d7:
            long r12 = r2 & r20
            int r20 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r20 == 0) goto L_0x00e2
            android.widget.LinearLayout r12 = r1.lytErrorOtpMsg
            r12.setVisibility(r6)
        L_0x00e2:
            long r12 = r2 & r18
            int r6 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x00ed
            android.widget.LinearLayout r6 = r1.lytValidatingOtp
            r6.setVisibility(r0)
        L_0x00ed:
            r12 = 162(0xa2, double:8.0E-322)
            long r12 = r12 & r2
            int r0 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00f9
            android.widget.RelativeLayout r0 = r1.mboundView5
            r0.setVisibility(r9)
        L_0x00f9:
            long r9 = r2 & r10
            int r0 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0104
            android.widget.ProgressBar r0 = r1.pbProgress
            r0.setVisibility(r8)
        L_0x0104:
            r8 = 130(0x82, double:6.4E-322)
            long r8 = r8 & r2
            int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0110
            android.widget.TextView r0 = r1.tvResendOtp
            r0.setOnClickListener(r14)
        L_0x0110:
            r8 = 138(0x8a, double:6.8E-322)
            long r8 = r8 & r2
            int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x011c
            android.widget.TextView r0 = r1.txtErrorMsg
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r15)
        L_0x011c:
            long r8 = r2 & r16
            int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0127
            net.one97.paytm.nativesdk.otp.view.PinEntryEditText r0 = r1.txtPinEntry
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r7)
        L_0x0127:
            r6 = 128(0x80, double:6.32E-322)
            long r2 = r2 & r6
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0136
            net.one97.paytm.nativesdk.otp.view.PinEntryEditText r0 = r1.txtPinEntry
            androidx.databinding.a.d$c r2 = r1.mCallback3
            r3 = 0
            androidx.databinding.a.d.a(r0, r2, r3, r3)
        L_0x0136:
            return
        L_0x0137:
            r0 = move-exception
            monitor-exit(r31)     // Catch:{ all -> 0x0137 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.databinding.FragmentVerifyOtpNativeBindingImpl.executeBindings():void");
    }

    public static class OnClickListenerImpl implements View.OnClickListener {
        private OtpViewModel value;

        public OnClickListenerImpl setValue(OtpViewModel otpViewModel) {
            this.value = otpViewModel;
            if (otpViewModel == null) {
                return null;
            }
            return this;
        }

        public void onClick(View view) {
            this.value.handleResendOtpClick(view);
        }
    }

    public final void _internalCallbackOnTextChanged(int i2, CharSequence charSequence, int i3, int i4, int i5) {
        OtpViewModel otpViewModel = this.mOtpViewholder;
        if (otpViewModel != null) {
            otpViewModel.onOtpReceived(getRoot().getContext(), charSequence);
        }
    }
}
