package net.one97.paytm.nativesdk.databinding;

import android.text.Editable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.databinding.h;
import androidx.databinding.i;
import net.one97.paytm.nativesdk.BR;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.pincvv.viewmodel.PinCvvModel;

public class CvvPinLayoutBindingImpl extends CvvPinLayoutBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private OnClickListenerImpl mPincvvmodelCrossClickedAndroidViewViewOnClickListener;
    private AfterTextChangedImpl mPincvvmodelPinWatcherAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged;
    private final LinearLayout mboundView0;
    private final ImageView mboundView1;
    private final ImageView mboundView3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.tv_pay_using, 8);
        sViewsWithIds.put(R.id.rl_selected_instrument, 9);
        sViewsWithIds.put(R.id.rl_selected_instrument_image, 10);
        sViewsWithIds.put(R.id.iv_selected_instrument_image, 11);
        sViewsWithIds.put(R.id.rl_down_arrow, 12);
        sViewsWithIds.put(R.id.dot_progress_bar, 13);
    }

    public CvvPinLayoutBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 14, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private CvvPinLayoutBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 7, objArr[13], objArr[6], objArr[11], objArr[7], objArr[12], objArr[9], objArr[10], objArr[5], objArr[4], objArr[2], objArr[8]);
        this.mDirtyFlags = -1;
        this.etPincvv.setTag((Object) null);
        this.lytValidatingOtp.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.mboundView1 = objArr[1];
        this.mboundView1.setTag((Object) null);
        this.mboundView3 = objArr[3];
        this.mboundView3.setTag((Object) null);
        this.titleTxt.setTag((Object) null);
        this.tvInstrumentBalance.setTag((Object) null);
        this.tvInstrumentName.setTag((Object) null);
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
        if (BR.pincvvmodel != i2) {
            return false;
        }
        setPincvvmodel((PinCvvModel) obj);
        return true;
    }

    public void setPincvvmodel(PinCvvModel pinCvvModel) {
        updateRegistration(2, (h) pinCvvModel);
        this.mPincvvmodel = pinCvvModel;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(BR.pincvvmodel);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return onChangePincvvmodelPinSize((ObservableInt) obj, i3);
            case 1:
                return onChangePincvvmodelCvvOrPinTitle((i) obj, i3);
            case 2:
                return onChangePincvvmodel((PinCvvModel) obj, i3);
            case 3:
                return onChangePincvvmodelTitle((i) obj, i3);
            case 4:
                return onChangePincvvmodelCvvVisiblity((ObservableInt) obj, i3);
            case 5:
                return onChangePincvvmodelLoaderVisiblity((ObservableInt) obj, i3);
            case 6:
                return onChangePincvvmodelSubTitle((i) obj, i3);
            default:
                return false;
        }
    }

    private boolean onChangePincvvmodelPinSize(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangePincvvmodelCvvOrPinTitle(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangePincvvmodel(PinCvvModel pinCvvModel, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangePincvvmodelTitle(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangePincvvmodelCvvVisiblity(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangePincvvmodelLoaderVisiblity(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangePincvvmodelSubTitle(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00d1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r32 = this;
            r1 = r32
            monitor-enter(r32)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x014f }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x014f }
            monitor-exit(r32)     // Catch:{ all -> 0x014f }
            net.one97.paytm.nativesdk.pincvv.viewmodel.PinCvvModel r0 = r1.mPincvvmodel
            r6 = 255(0xff, double:1.26E-321)
            long r6 = r6 & r2
            r10 = 140(0x8c, double:6.9E-322)
            r12 = 164(0xa4, double:8.1E-322)
            r14 = 134(0x86, double:6.6E-322)
            r16 = 148(0x94, double:7.3E-322)
            r18 = 132(0x84, double:6.5E-322)
            r20 = 133(0x85, double:6.57E-322)
            r8 = 0
            int r24 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r24 == 0) goto L_0x00eb
            long r6 = r2 & r18
            int r24 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r24 == 0) goto L_0x0047
            if (r0 == 0) goto L_0x0047
            net.one97.paytm.nativesdk.databinding.CvvPinLayoutBindingImpl$AfterTextChangedImpl r6 = r1.mPincvvmodelPinWatcherAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged
            if (r6 != 0) goto L_0x0033
            net.one97.paytm.nativesdk.databinding.CvvPinLayoutBindingImpl$AfterTextChangedImpl r6 = new net.one97.paytm.nativesdk.databinding.CvvPinLayoutBindingImpl$AfterTextChangedImpl
            r6.<init>()
            r1.mPincvvmodelPinWatcherAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged = r6
        L_0x0033:
            net.one97.paytm.nativesdk.databinding.CvvPinLayoutBindingImpl$AfterTextChangedImpl r6 = r6.setValue(r0)
            net.one97.paytm.nativesdk.databinding.CvvPinLayoutBindingImpl$OnClickListenerImpl r7 = r1.mPincvvmodelCrossClickedAndroidViewViewOnClickListener
            if (r7 != 0) goto L_0x0042
            net.one97.paytm.nativesdk.databinding.CvvPinLayoutBindingImpl$OnClickListenerImpl r7 = new net.one97.paytm.nativesdk.databinding.CvvPinLayoutBindingImpl$OnClickListenerImpl
            r7.<init>()
            r1.mPincvvmodelCrossClickedAndroidViewViewOnClickListener = r7
        L_0x0042:
            net.one97.paytm.nativesdk.databinding.CvvPinLayoutBindingImpl$OnClickListenerImpl r7 = r7.setValue(r0)
            goto L_0x0049
        L_0x0047:
            r6 = 0
            r7 = 0
        L_0x0049:
            long r24 = r2 & r20
            int r26 = (r24 > r4 ? 1 : (r24 == r4 ? 0 : -1))
            if (r26 == 0) goto L_0x005f
            if (r0 == 0) goto L_0x0054
            androidx.databinding.ObservableInt r9 = r0.pinSize
            goto L_0x0055
        L_0x0054:
            r9 = 0
        L_0x0055:
            r1.updateRegistration((int) r8, (androidx.databinding.h) r9)
            if (r9 == 0) goto L_0x005f
            int r9 = r9.get()
            goto L_0x0060
        L_0x005f:
            r9 = 0
        L_0x0060:
            long r25 = r2 & r14
            int r27 = (r25 > r4 ? 1 : (r25 == r4 ? 0 : -1))
            if (r27 == 0) goto L_0x0079
            if (r0 == 0) goto L_0x006b
            androidx.databinding.i<java.lang.String> r8 = r0.cvvOrPinTitle
            goto L_0x006c
        L_0x006b:
            r8 = 0
        L_0x006c:
            r14 = 1
            r1.updateRegistration((int) r14, (androidx.databinding.h) r8)
            if (r8 == 0) goto L_0x0079
            java.lang.Object r8 = r8.get()
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x007a
        L_0x0079:
            r8 = 0
        L_0x007a:
            long r14 = r2 & r10
            int r28 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r28 == 0) goto L_0x0093
            if (r0 == 0) goto L_0x0085
            androidx.databinding.i<java.lang.String> r14 = r0.title
            goto L_0x0086
        L_0x0085:
            r14 = 0
        L_0x0086:
            r15 = 3
            r1.updateRegistration((int) r15, (androidx.databinding.h) r14)
            if (r14 == 0) goto L_0x0093
            java.lang.Object r14 = r14.get()
            java.lang.String r14 = (java.lang.String) r14
            goto L_0x0094
        L_0x0093:
            r14 = 0
        L_0x0094:
            long r28 = r2 & r16
            int r15 = (r28 > r4 ? 1 : (r28 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x00ab
            if (r0 == 0) goto L_0x009f
            androidx.databinding.ObservableInt r15 = r0.cvvVisiblity
            goto L_0x00a0
        L_0x009f:
            r15 = 0
        L_0x00a0:
            r10 = 4
            r1.updateRegistration((int) r10, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x00ab
            int r10 = r15.get()
            goto L_0x00ac
        L_0x00ab:
            r10 = 0
        L_0x00ac:
            long r30 = r2 & r12
            int r11 = (r30 > r4 ? 1 : (r30 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x00c7
            if (r0 == 0) goto L_0x00b7
            androidx.databinding.ObservableInt r11 = r0.loaderVisiblity
            goto L_0x00b8
        L_0x00b7:
            r11 = 0
        L_0x00b8:
            r15 = 5
            r1.updateRegistration((int) r15, (androidx.databinding.h) r11)
            if (r11 == 0) goto L_0x00c7
            int r11 = r11.get()
            r25 = r11
            r22 = 196(0xc4, double:9.7E-322)
            goto L_0x00cb
        L_0x00c7:
            r22 = 196(0xc4, double:9.7E-322)
            r25 = 0
        L_0x00cb:
            long r30 = r2 & r22
            int r11 = (r30 > r4 ? 1 : (r30 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x00e7
            if (r0 == 0) goto L_0x00d6
            androidx.databinding.i<java.lang.String> r0 = r0.subTitle
            goto L_0x00d7
        L_0x00d6:
            r0 = 0
        L_0x00d7:
            r11 = 6
            r1.updateRegistration((int) r11, (androidx.databinding.h) r0)
            if (r0 == 0) goto L_0x00e7
            java.lang.Object r0 = r0.get()
            java.lang.String r0 = (java.lang.String) r0
            r11 = r0
            r0 = r25
            goto L_0x00f3
        L_0x00e7:
            r0 = r25
            r11 = 0
            goto L_0x00f3
        L_0x00eb:
            r0 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r14 = 0
        L_0x00f3:
            long r20 = r2 & r20
            int r15 = (r20 > r4 ? 1 : (r20 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x00fe
            net.one97.paytm.nativesdk.otp.view.PinEntryEditText r15 = r1.etPincvv
            androidx.databinding.a.d.a((android.widget.TextView) r15, (int) r9)
        L_0x00fe:
            long r15 = r2 & r16
            int r9 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r9 == 0) goto L_0x0109
            net.one97.paytm.nativesdk.otp.view.PinEntryEditText r9 = r1.etPincvv
            r9.setVisibility(r10)
        L_0x0109:
            long r9 = r2 & r18
            int r15 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x011f
            net.one97.paytm.nativesdk.otp.view.PinEntryEditText r9 = r1.etPincvv
            r10 = 0
            androidx.databinding.a.d.a(r9, r10, r6, r10)
            android.widget.ImageView r6 = r1.mboundView1
            r6.setOnClickListener(r7)
            android.widget.ImageView r6 = r1.mboundView3
            r6.setOnClickListener(r7)
        L_0x011f:
            long r6 = r2 & r12
            int r9 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r9 == 0) goto L_0x012a
            android.widget.LinearLayout r6 = r1.lytValidatingOtp
            r6.setVisibility(r0)
        L_0x012a:
            r6 = 134(0x86, double:6.6E-322)
            long r6 = r6 & r2
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0136
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.titleTxt
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r8)
        L_0x0136:
            r6 = 196(0xc4, double:9.7E-322)
            long r6 = r6 & r2
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0142
            android.widget.TextView r0 = r1.tvInstrumentBalance
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r11)
        L_0x0142:
            r6 = 140(0x8c, double:6.9E-322)
            long r2 = r2 & r6
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x014e
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvInstrumentName
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r14)
        L_0x014e:
            return
        L_0x014f:
            r0 = move-exception
            monitor-exit(r32)     // Catch:{ all -> 0x014f }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.databinding.CvvPinLayoutBindingImpl.executeBindings():void");
    }

    public static class AfterTextChangedImpl implements d.a {
        private PinCvvModel value;

        public AfterTextChangedImpl setValue(PinCvvModel pinCvvModel) {
            this.value = pinCvvModel;
            if (pinCvvModel == null) {
                return null;
            }
            return this;
        }

        public void afterTextChanged(Editable editable) {
            this.value.pinWatcher(editable);
        }
    }

    public static class OnClickListenerImpl implements View.OnClickListener {
        private PinCvvModel value;

        public OnClickListenerImpl setValue(PinCvvModel pinCvvModel) {
            this.value = pinCvvModel;
            if (pinCvvModel == null) {
                return null;
            }
            return this;
        }

        public void onClick(View view) {
            this.value.crossClicked(view);
        }
    }
}
