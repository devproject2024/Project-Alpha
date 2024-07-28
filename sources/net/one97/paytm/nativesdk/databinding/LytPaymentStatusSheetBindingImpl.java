package net.one97.paytm.nativesdk.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import androidx.databinding.i;
import net.one97.paytm.nativesdk.BR;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.transcation.viewmodel.TranscationStatusViewmodel;

public class LytPaymentStatusSheetBindingImpl extends LytPaymentStatusSheetBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.icon_transcation_status, 4);
        sViewsWithIds.put(R.id.dot_progress_bar, 5);
        sViewsWithIds.put(R.id.lyt_bottom_lines, 6);
    }

    public LytPaymentStatusSheetBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 7, sIncludes, sViewsWithIds));
    }

    private LytPaymentStatusSheetBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 4, objArr[5], objArr[4], objArr[6], objArr[2], objArr[3], objArr[1]);
        this.mDirtyFlags = -1;
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.txtAmount.setTag((Object) null);
        this.txtDecimalAmt.setTag((Object) null);
        this.txtTranscationStatus.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16;
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
        if (BR.transcationViewModel != i2) {
            return false;
        }
        setTranscationViewModel((TranscationStatusViewmodel) obj);
        return true;
    }

    public void setTranscationViewModel(TranscationStatusViewmodel transcationStatusViewmodel) {
        updateRegistration(1, (h) transcationStatusViewmodel);
        this.mTranscationViewModel = transcationStatusViewmodel;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.transcationViewModel);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return onChangeTranscationViewModelDecimalAmount((i) obj, i3);
        }
        if (i2 == 1) {
            return onChangeTranscationViewModel((TranscationStatusViewmodel) obj, i3);
        }
        if (i2 == 2) {
            return onChangeTranscationViewModelTranscationStatus((i) obj, i3);
        }
        if (i2 != 3) {
            return false;
        }
        return onChangeTranscationViewModelRsAmount((i) obj, i3);
    }

    private boolean onChangeTranscationViewModelDecimalAmount(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeTranscationViewModel(TranscationStatusViewmodel transcationStatusViewmodel, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeTranscationViewModelTranscationStatus(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeTranscationViewModelRsAmount(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0054  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r18 = this;
            r1 = r18
            monitor-enter(r18)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x0089 }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x0089 }
            monitor-exit(r18)     // Catch:{ all -> 0x0089 }
            net.one97.paytm.nativesdk.transcation.viewmodel.TranscationStatusViewmodel r0 = r1.mTranscationViewModel
            r6 = 31
            long r6 = r6 & r2
            r8 = 22
            r10 = 19
            r12 = 26
            r14 = 0
            int r15 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x0068
            long r6 = r2 & r10
            int r15 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x0033
            if (r0 == 0) goto L_0x0025
            androidx.databinding.i<java.lang.String> r6 = r0.decimalAmount
            goto L_0x0026
        L_0x0025:
            r6 = r14
        L_0x0026:
            r7 = 0
            r1.updateRegistration((int) r7, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x0033
            java.lang.Object r6 = r6.get()
            java.lang.String r6 = (java.lang.String) r6
            goto L_0x0034
        L_0x0033:
            r6 = r14
        L_0x0034:
            long r15 = r2 & r8
            int r7 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x004d
            if (r0 == 0) goto L_0x003f
            androidx.databinding.i<java.lang.String> r7 = r0.transcationStatus
            goto L_0x0040
        L_0x003f:
            r7 = r14
        L_0x0040:
            r15 = 2
            r1.updateRegistration((int) r15, (androidx.databinding.h) r7)
            if (r7 == 0) goto L_0x004d
            java.lang.Object r7 = r7.get()
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x004e
        L_0x004d:
            r7 = r14
        L_0x004e:
            long r15 = r2 & r12
            int r17 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r17 == 0) goto L_0x006a
            if (r0 == 0) goto L_0x0059
            androidx.databinding.i<java.lang.String> r0 = r0.rsAmount
            goto L_0x005a
        L_0x0059:
            r0 = r14
        L_0x005a:
            r15 = 3
            r1.updateRegistration((int) r15, (androidx.databinding.h) r0)
            if (r0 == 0) goto L_0x006a
            java.lang.Object r0 = r0.get()
            r14 = r0
            java.lang.String r14 = (java.lang.String) r14
            goto L_0x006a
        L_0x0068:
            r6 = r14
            r7 = r6
        L_0x006a:
            long r12 = r12 & r2
            int r0 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0074
            android.widget.TextView r0 = r1.txtAmount
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r14)
        L_0x0074:
            long r10 = r10 & r2
            int r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x007e
            android.widget.TextView r0 = r1.txtDecimalAmt
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r6)
        L_0x007e:
            long r2 = r2 & r8
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0088
            android.widget.TextView r0 = r1.txtTranscationStatus
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r7)
        L_0x0088:
            return
        L_0x0089:
            r0 = move-exception
            monitor-exit(r18)     // Catch:{ all -> 0x0089 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.databinding.LytPaymentStatusSheetBindingImpl.executeBindings():void");
    }
}
