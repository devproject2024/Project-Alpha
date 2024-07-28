package com.business.merchant_payments.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.q;
import com.business.merchant_payments.BR;
import com.business.merchant_payments.R;
import com.business.merchant_payments.newhome.QrViewModel;
import com.business.merchant_payments.nonetwork.NoNetworkViewModel;

public class MpQrViewBindingImpl extends MpQrViewBinding {
    public static final ViewDataBinding.b sIncludes;
    public static final SparseIntArray sViewsWithIds;
    public long mDirtyFlags;
    public final View mboundView3;

    static {
        ViewDataBinding.b bVar = new ViewDataBinding.b(7);
        sIncludes = bVar;
        bVar.a(0, new String[]{"mp_profile_qr_pager_item_layout"}, new int[]{4}, new int[]{R.layout.mp_profile_qr_pager_item_layout});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.rl_order_qr_code, 5);
        sViewsWithIds.put(R.id.rl_share_my_qr, 6);
    }

    public MpQrViewBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 7, sIncludes, sViewsWithIds));
    }

    public MpQrViewBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 3, objArr[4], objArr[2], objArr[0], objArr[1], objArr[5], objArr[6]);
        this.mDirtyFlags = -1;
        View view2 = objArr[3];
        this.mboundView3 = view2;
        view2.setTag((Object) null);
        this.rlActivateQr.setTag((Object) null);
        this.rlContainer.setTag((Object) null);
        this.rlDownloadMyQr.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16;
        }
        this.qrContainer.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.qrContainer.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasPendingBindings() {
        /*
            r6 = this;
            monitor-enter(r6)
            long r0 = r6.mDirtyFlags     // Catch:{ all -> 0x0018 }
            r2 = 0
            r4 = 1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x000c
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            return r4
        L_0x000c:
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            com.business.merchant_payments.databinding.MpProfileQrPagerItemLayoutBinding r0 = r6.qrContainer
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0016
            return r4
        L_0x0016:
            r0 = 0
            return r0
        L_0x0018:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.databinding.MpQrViewBindingImpl.hasPendingBindings():boolean");
    }

    public boolean setVariable(int i2, Object obj) {
        if (BR.model == i2) {
            setModel((QrViewModel) obj);
        } else if (BR.noNetworkViewModel != i2) {
            return false;
        } else {
            setNoNetworkViewModel((NoNetworkViewModel) obj);
        }
        return true;
    }

    public void setModel(QrViewModel qrViewModel) {
        this.mModel = qrViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(BR.model);
        super.requestRebind();
    }

    public void setNoNetworkViewModel(NoNetworkViewModel noNetworkViewModel) {
        this.mNoNetworkViewModel = noNetworkViewModel;
    }

    public void setLifecycleOwner(q qVar) {
        super.setLifecycleOwner(qVar);
        this.qrContainer.setLifecycleOwner(qVar);
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return onChangeNoNetworkViewModel((NoNetworkViewModel) obj, i3);
        }
        if (i2 == 1) {
            return onChangeQrContainer((MpProfileQrPagerItemLayoutBinding) obj, i3);
        }
        if (i2 != 2) {
            return false;
        }
        return onChangeModelIsP4BClient((ObservableBoolean) obj, i3);
    }

    private boolean onChangeNoNetworkViewModel(NoNetworkViewModel noNetworkViewModel, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeQrContainer(MpProfileQrPagerItemLayoutBinding mpProfileQrPagerItemLayoutBinding, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeModelIsP4BClient(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0058  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r17 = this;
            r1 = r17
            monitor-enter(r17)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x007d }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x007d }
            monitor-exit(r17)     // Catch:{ all -> 0x007d }
            com.business.merchant_payments.newhome.QrViewModel r0 = r1.mModel
            r6 = 0
            r7 = 28
            long r9 = r2 & r7
            r11 = 8
            r12 = 24
            r14 = 0
            int r15 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x005b
            long r9 = r2 & r12
            int r15 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x0037
            if (r0 == 0) goto L_0x0027
            boolean r9 = r0.isEDCFlavour()
            goto L_0x0028
        L_0x0027:
            r9 = 0
        L_0x0028:
            if (r15 == 0) goto L_0x0032
            if (r9 == 0) goto L_0x002f
            r15 = 256(0x100, double:1.265E-321)
            goto L_0x0031
        L_0x002f:
            r15 = 128(0x80, double:6.32E-322)
        L_0x0031:
            long r2 = r2 | r15
        L_0x0032:
            if (r9 == 0) goto L_0x0037
            r9 = 8
            goto L_0x0038
        L_0x0037:
            r9 = 0
        L_0x0038:
            if (r0 == 0) goto L_0x003c
            androidx.databinding.ObservableBoolean r6 = r0.isP4BClient
        L_0x003c:
            r0 = 2
            r1.updateRegistration((int) r0, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x0047
            boolean r0 = r6.get()
            goto L_0x0048
        L_0x0047:
            r0 = 0
        L_0x0048:
            long r15 = r2 & r7
            int r6 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0056
            if (r0 == 0) goto L_0x0053
            r15 = 64
            goto L_0x0055
        L_0x0053:
            r15 = 32
        L_0x0055:
            long r2 = r2 | r15
        L_0x0056:
            if (r0 == 0) goto L_0x005d
            r14 = 8
            goto L_0x005d
        L_0x005b:
            r0 = 0
            r9 = 0
        L_0x005d:
            long r6 = r2 & r7
            int r8 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x006d
            android.view.View r6 = r1.mboundView3
            com.business.merchant_payments.common.utility.DataBindingUtility.bindVisibility(r6, r0)
            android.widget.TextView r0 = r1.rlDownloadMyQr
            r0.setVisibility(r14)
        L_0x006d:
            long r2 = r2 & r12
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0077
            android.widget.TextView r0 = r1.rlActivateQr
            r0.setVisibility(r9)
        L_0x0077:
            com.business.merchant_payments.databinding.MpProfileQrPagerItemLayoutBinding r0 = r1.qrContainer
            androidx.databinding.ViewDataBinding.executeBindingsOn(r0)
            return
        L_0x007d:
            r0 = move-exception
            monitor-exit(r17)     // Catch:{ all -> 0x007d }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.databinding.MpQrViewBindingImpl.executeBindings():void");
    }
}
