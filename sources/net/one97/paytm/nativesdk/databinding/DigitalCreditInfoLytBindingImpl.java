package net.one97.paytm.nativesdk.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import androidx.databinding.i;
import net.one97.paytm.nativesdk.BR;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.generated.callback.OnClickListener;
import net.one97.paytm.nativesdk.instruments.digitalCredit.viewmodel.DigitalCreditViewModel;

public class DigitalCreditInfoLytBindingImpl extends DigitalCreditInfoLytBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback1;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.ll_instrument_info, 4);
        sViewsWithIds.put(R.id.rb_cardNumber, 5);
    }

    public DigitalCreditInfoLytBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 6, sIncludes, sViewsWithIds));
    }

    private DigitalCreditInfoLytBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 5, objArr[4], objArr[3], objArr[5], objArr[1], objArr[2]);
        this.mDirtyFlags = -1;
        this.lytFetchPaymentBankBalance.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.txtPrimaryInfo.setTag((Object) null);
        this.txtSecondaryInfo.setTag((Object) null);
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
        if (BR.digitalCreditModel != i2) {
            return false;
        }
        setDigitalCreditModel((DigitalCreditViewModel) obj);
        return true;
    }

    public void setDigitalCreditModel(DigitalCreditViewModel digitalCreditViewModel) {
        updateRegistration(0, (h) digitalCreditViewModel);
        this.mDigitalCreditModel = digitalCreditViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.digitalCreditModel);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return onChangeDigitalCreditModel((DigitalCreditViewModel) obj, i3);
        }
        if (i2 == 1) {
            return onChangeDigitalCreditModelFetchBalanceMsgVisiblity((ObservableInt) obj, i3);
        }
        if (i2 == 2) {
            return onChangeDigitalCreditModelMSecondaryInformation((i) obj, i3);
        }
        if (i2 == 3) {
            return onChangeDigitalCreditModelMPrimaryInformation((i) obj, i3);
        }
        if (i2 != 4) {
            return false;
        }
        return onChangeDigitalCreditModelBalanceTxtVisiblity((ObservableInt) obj, i3);
    }

    private boolean onChangeDigitalCreditModel(DigitalCreditViewModel digitalCreditViewModel, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeDigitalCreditModelFetchBalanceMsgVisiblity(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeDigitalCreditModelMSecondaryInformation(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeDigitalCreditModelMPrimaryInformation(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeDigitalCreditModelBalanceTxtVisiblity(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0076  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r22 = this;
            r1 = r22
            monitor-enter(r22)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x00cb }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x00cb }
            monitor-exit(r22)     // Catch:{ all -> 0x00cb }
            net.one97.paytm.nativesdk.instruments.digitalCredit.viewmodel.DigitalCreditViewModel r0 = r1.mDigitalCreditModel
            r6 = 63
            long r6 = r6 & r2
            r8 = 49
            r10 = 41
            r12 = 37
            r14 = 35
            r16 = 0
            r17 = 0
            int r18 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r18 == 0) goto L_0x008c
            long r6 = r2 & r14
            int r18 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r18 == 0) goto L_0x0037
            if (r0 == 0) goto L_0x002a
            androidx.databinding.ObservableInt r6 = r0.fetchBalanceMsgVisiblity
            goto L_0x002c
        L_0x002a:
            r6 = r17
        L_0x002c:
            r7 = 1
            r1.updateRegistration((int) r7, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x0037
            int r6 = r6.get()
            goto L_0x0038
        L_0x0037:
            r6 = 0
        L_0x0038:
            long r18 = r2 & r12
            int r7 = (r18 > r4 ? 1 : (r18 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x0052
            if (r0 == 0) goto L_0x0043
            androidx.databinding.i<java.lang.String> r7 = r0.mSecondaryInformation
            goto L_0x0045
        L_0x0043:
            r7 = r17
        L_0x0045:
            r12 = 2
            r1.updateRegistration((int) r12, (androidx.databinding.h) r7)
            if (r7 == 0) goto L_0x0052
            java.lang.Object r7 = r7.get()
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x0054
        L_0x0052:
            r7 = r17
        L_0x0054:
            long r12 = r2 & r10
            int r20 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r20 == 0) goto L_0x006e
            if (r0 == 0) goto L_0x005f
            androidx.databinding.i<java.lang.String> r12 = r0.mPrimaryInformation
            goto L_0x0061
        L_0x005f:
            r12 = r17
        L_0x0061:
            r13 = 3
            r1.updateRegistration((int) r13, (androidx.databinding.h) r12)
            if (r12 == 0) goto L_0x006e
            java.lang.Object r12 = r12.get()
            java.lang.String r12 = (java.lang.String) r12
            goto L_0x0070
        L_0x006e:
            r12 = r17
        L_0x0070:
            long r20 = r2 & r8
            int r13 = (r20 > r4 ? 1 : (r20 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x008a
            if (r0 == 0) goto L_0x007b
            androidx.databinding.ObservableInt r0 = r0.balanceTxtVisiblity
            goto L_0x007d
        L_0x007b:
            r0 = r17
        L_0x007d:
            r13 = 4
            r1.updateRegistration((int) r13, (androidx.databinding.h) r0)
            if (r0 == 0) goto L_0x008a
            int r16 = r0.get()
            r0 = r16
            goto L_0x0091
        L_0x008a:
            r0 = 0
            goto L_0x0091
        L_0x008c:
            r7 = r17
            r12 = r7
            r0 = 0
            r6 = 0
        L_0x0091:
            long r13 = r2 & r14
            int r15 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x009c
            android.widget.LinearLayout r13 = r1.lytFetchPaymentBankBalance
            r13.setVisibility(r6)
        L_0x009c:
            r13 = 32
            long r13 = r13 & r2
            int r6 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x00aa
            android.widget.LinearLayout r6 = r1.mboundView0
            android.view.View$OnClickListener r13 = r1.mCallback1
            r6.setOnClickListener(r13)
        L_0x00aa:
            long r10 = r10 & r2
            int r6 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x00b4
            android.widget.TextView r6 = r1.txtPrimaryInfo
            androidx.databinding.a.d.a((android.widget.TextView) r6, (java.lang.CharSequence) r12)
        L_0x00b4:
            r10 = 37
            long r10 = r10 & r2
            int r6 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x00c0
            net.one97.paytm.nativesdk.widget.RoboTextView r6 = r1.txtSecondaryInfo
            androidx.databinding.a.d.a((android.widget.TextView) r6, (java.lang.CharSequence) r7)
        L_0x00c0:
            long r2 = r2 & r8
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x00ca
            net.one97.paytm.nativesdk.widget.RoboTextView r2 = r1.txtSecondaryInfo
            r2.setVisibility(r0)
        L_0x00ca:
            return
        L_0x00cb:
            r0 = move-exception
            monitor-exit(r22)     // Catch:{ all -> 0x00cb }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.databinding.DigitalCreditInfoLytBindingImpl.executeBindings():void");
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        DigitalCreditViewModel digitalCreditViewModel = this.mDigitalCreditModel;
        if (digitalCreditViewModel != null) {
            digitalCreditViewModel.payMethodSelected(view);
        }
    }
}
