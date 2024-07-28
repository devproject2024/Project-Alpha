package net.one97.paytm.nativesdk.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.i;
import net.one97.paytm.nativesdk.BR;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.instruments.netbanking.modal.SectionWrapper;
import net.one97.paytm.nativesdk.instruments.netbanking.viewmodel.NBAdapterViewModel;

public class NativesdkItemBankProviderListBindingImpl extends NativesdkItemBankProviderListBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.bank_logo_layout, 4);
        sViewsWithIds.put(R.id.iv_bank_icon, 5);
        sViewsWithIds.put(R.id.tv_bank_name, 6);
        sViewsWithIds.put(R.id.procced, 7);
        sViewsWithIds.put(R.id.txt_successrate, 8);
    }

    public NativesdkItemBankProviderListBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 9, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private NativesdkItemBankProviderListBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 4, objArr[4], objArr[1], objArr[5], objArr[7], objArr[3], objArr[6], objArr[2], objArr[8]);
        this.mDirtyFlags = -1;
        this.imgGreenTick.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.rlBankInfo.setTag((Object) null);
        this.tvDisableErrorMessage.setTag((Object) null);
        View view2 = view;
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 64;
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
        if (BR.f55771a == i2) {
            setA((NBAdapterViewModel) obj);
        } else if (BR.view == i2) {
            setView((View) obj);
        } else if (BR.netbanking != i2) {
            return false;
        } else {
            setNetbanking((SectionWrapper) obj);
        }
        return true;
    }

    public void setA(NBAdapterViewModel nBAdapterViewModel) {
        this.mA = nBAdapterViewModel;
    }

    public void setView(View view) {
        this.mView = view;
    }

    public void setNetbanking(SectionWrapper sectionWrapper) {
        this.mNetbanking = sectionWrapper;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(BR.netbanking);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return onChangeA((NBAdapterViewModel) obj, i3);
        }
        if (i2 == 1) {
            return onChangeNetbankingDisableMessageVisibility((ObservableInt) obj, i3);
        }
        if (i2 == 2) {
            return onChangeNetbankingGreenTickVisible((ObservableBoolean) obj, i3);
        }
        if (i2 != 3) {
            return false;
        }
        return onChangeNetbankingDisableMessage((i) obj, i3);
    }

    private boolean onChangeA(NBAdapterViewModel nBAdapterViewModel, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeNetbankingDisableMessageVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeNetbankingGreenTickVisible(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeNetbankingDisableMessage(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0080  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r22 = this;
            r1 = r22
            monitor-enter(r22)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x00cc }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x00cc }
            monitor-exit(r22)     // Catch:{ all -> 0x00cc }
            net.one97.paytm.nativesdk.instruments.netbanking.modal.SectionWrapper r0 = r1.mNetbanking
            r6 = 110(0x6e, double:5.43E-322)
            long r6 = r6 & r2
            r8 = 104(0x68, double:5.14E-322)
            r10 = 96
            r12 = 98
            r14 = 100
            r16 = 0
            r17 = 0
            int r18 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r18 == 0) goto L_0x0098
            long r6 = r2 & r12
            int r18 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r18 == 0) goto L_0x0037
            if (r0 == 0) goto L_0x002a
            androidx.databinding.ObservableInt r6 = r0.disableMessageVisibility
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
            long r18 = r2 & r14
            int r7 = (r18 > r4 ? 1 : (r18 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x0062
            if (r0 == 0) goto L_0x0043
            androidx.databinding.ObservableBoolean r12 = r0.greenTickVisible
            goto L_0x0045
        L_0x0043:
            r12 = r17
        L_0x0045:
            r13 = 2
            r1.updateRegistration((int) r13, (androidx.databinding.h) r12)
            if (r12 == 0) goto L_0x0050
            boolean r12 = r12.get()
            goto L_0x0051
        L_0x0050:
            r12 = 0
        L_0x0051:
            if (r7 == 0) goto L_0x005c
            if (r12 == 0) goto L_0x0058
            r20 = 256(0x100, double:1.265E-321)
            goto L_0x005a
        L_0x0058:
            r20 = 128(0x80, double:6.32E-322)
        L_0x005a:
            long r2 = r2 | r20
        L_0x005c:
            if (r12 == 0) goto L_0x005f
            goto L_0x0062
        L_0x005f:
            r7 = 8
            goto L_0x0063
        L_0x0062:
            r7 = 0
        L_0x0063:
            long r12 = r2 & r10
            int r20 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r20 == 0) goto L_0x007a
            if (r0 == 0) goto L_0x0070
            net.one97.paytm.nativesdk.instruments.netbanking.modal.PayChannelOptions r12 = r0.getChildSections()
            goto L_0x0072
        L_0x0070:
            r12 = r17
        L_0x0072:
            if (r12 == 0) goto L_0x007a
            boolean r12 = r12.isProceedVisible()
            r16 = r12
        L_0x007a:
            long r12 = r2 & r8
            int r20 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r20 == 0) goto L_0x0095
            if (r0 == 0) goto L_0x0085
            androidx.databinding.i<java.lang.String> r0 = r0.disableMessage
            goto L_0x0087
        L_0x0085:
            r0 = r17
        L_0x0087:
            r12 = 3
            r1.updateRegistration((int) r12, (androidx.databinding.h) r0)
            if (r0 == 0) goto L_0x0095
            java.lang.Object r0 = r0.get()
            r17 = r0
            java.lang.String r17 = (java.lang.String) r17
        L_0x0095:
            r0 = r17
            goto L_0x009c
        L_0x0098:
            r0 = r17
            r6 = 0
            r7 = 0
        L_0x009c:
            long r12 = r2 & r14
            int r14 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x00a7
            android.widget.ImageView r12 = r1.imgGreenTick
            r12.setVisibility(r7)
        L_0x00a7:
            long r10 = r10 & r2
            int r7 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x00b5
            android.widget.RelativeLayout r7 = r1.rlBankInfo
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r16)
            net.one97.paytm.nativesdk.instruments.netbanking.viewmodel.NBAdapterViewModel.setVisibility(r7, r10)
        L_0x00b5:
            r10 = 98
            long r10 = r10 & r2
            int r7 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x00c1
            android.widget.TextView r7 = r1.tvDisableErrorMessage
            r7.setVisibility(r6)
        L_0x00c1:
            long r2 = r2 & r8
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x00cb
            android.widget.TextView r2 = r1.tvDisableErrorMessage
            androidx.databinding.a.d.a((android.widget.TextView) r2, (java.lang.CharSequence) r0)
        L_0x00cb:
            return
        L_0x00cc:
            r0 = move-exception
            monitor-exit(r22)     // Catch:{ all -> 0x00cc }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.databinding.NativesdkItemBankProviderListBindingImpl.executeBindings():void");
    }
}
