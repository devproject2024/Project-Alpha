package com.business.merchant_payments.databinding;

import android.graphics.Bitmap;
import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import androidx.databinding.i;
import androidx.lifecycle.q;
import com.business.merchant_payments.BR;
import com.business.merchant_payments.R;
import com.business.merchant_payments.newhome.QrViewModel;
import com.business.merchant_payments.nonetwork.NoNetworkViewModel;
import com.business.merchant_payments.qr.ManageQrViewHandlerNew;

public class MpQrViewNewBindingImpl extends MpQrViewNewBinding {
    public static final ViewDataBinding.b sIncludes;
    public static final SparseIntArray sViewsWithIds;
    public long mDirtyFlags;
    public final ConstraintLayout mboundView0;
    public final View mboundView5;

    static {
        ViewDataBinding.b bVar = new ViewDataBinding.b(27);
        sIncludes = bVar;
        bVar.a(1, new String[]{"mp_layout_verify_qr_popup"}, new int[]{6}, new int[]{R.layout.mp_layout_verify_qr_popup});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.iv_all_in_one, 7);
        sViewsWithIds.put(R.id.paytm_logo, 8);
        sViewsWithIds.put(R.id.accepted_here, 9);
        sViewsWithIds.put(R.id.pay_using_paytm_or_any_other_upi_app, 10);
        sViewsWithIds.put(R.id.wallet_icon, 11);
        sViewsWithIds.put(R.id.wallet_upi_icon, 12);
        sViewsWithIds.put(R.id.gpay_icon, 13);
        sViewsWithIds.put(R.id.phone_pe_icon, 14);
        sViewsWithIds.put(R.id.qr_container, 15);
        sViewsWithIds.put(R.id.qr_dummy_image, 16);
        sViewsWithIds.put(R.id.qr_shimmer, 17);
        sViewsWithIds.put(R.id.ll_retry, 18);
        sViewsWithIds.put(R.id.ll_no_permission, 19);
        sViewsWithIds.put(R.id.powered_by, 20);
        sViewsWithIds.put(R.id.ppbl_icon, 21);
        sViewsWithIds.put(R.id.bottom_line_1, 22);
        sViewsWithIds.put(R.id.bottom_line_2, 23);
        sViewsWithIds.put(R.id.qr_options, 24);
        sViewsWithIds.put(R.id.rl_order_qr_code, 25);
        sViewsWithIds.put(R.id.rl_share_my_qr, 26);
    }

    public MpQrViewNewBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 27, sIncludes, sViewsWithIds));
    }

    public MpQrViewNewBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 6, objArr[9], objArr[22], objArr[23], objArr[1], objArr[13], objArr[7], objArr[19], objArr[18], objArr[10], objArr[8], objArr[14], objArr[20], objArr[21], objArr[15], objArr[16], objArr[2], objArr[24], objArr[17], objArr[4], objArr[3], objArr[25], objArr[26], objArr[6], objArr[11], objArr[12]);
        this.mDirtyFlags = -1;
        this.cardView.setTag((Object) null);
        ConstraintLayout constraintLayout = objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag((Object) null);
        View view2 = objArr[5];
        this.mboundView5 = view2;
        view2.setTag((Object) null);
        this.qrImage.setTag((Object) null);
        this.rlActivateQr.setTag((Object) null);
        this.rlDownloadMyQr.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 128;
        }
        this.verifyQrPopupContainer.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.verifyQrPopupContainer.hasPendingBindings() == false) goto L_0x0016;
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
            com.business.merchant_payments.databinding.MpLayoutVerifyQrPopupBinding r0 = r6.verifyQrPopupContainer
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
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.databinding.MpQrViewNewBindingImpl.hasPendingBindings():boolean");
    }

    public boolean setVariable(int i2, Object obj) {
        if (BR.model == i2) {
            setModel((QrViewModel) obj);
        } else if (BR.noNetworkViewModel == i2) {
            setNoNetworkViewModel((NoNetworkViewModel) obj);
        } else if (BR.viewModel != i2) {
            return false;
        } else {
            setViewModel((ManageQrViewHandlerNew.QrPageItemViewModel) obj);
        }
        return true;
    }

    public void setModel(QrViewModel qrViewModel) {
        this.mModel = qrViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(BR.model);
        super.requestRebind();
    }

    public void setNoNetworkViewModel(NoNetworkViewModel noNetworkViewModel) {
        this.mNoNetworkViewModel = noNetworkViewModel;
    }

    public void setViewModel(ManageQrViewHandlerNew.QrPageItemViewModel qrPageItemViewModel) {
        updateRegistration(4, (h) qrPageItemViewModel);
        this.mViewModel = qrPageItemViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    public void setLifecycleOwner(q qVar) {
        super.setLifecycleOwner(qVar);
        this.verifyQrPopupContainer.setLifecycleOwner(qVar);
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return onChangeViewModelShowVerifyQrPopup((ObservableBoolean) obj, i3);
        }
        if (i2 == 1) {
            return onChangeNoNetworkViewModel((NoNetworkViewModel) obj, i3);
        }
        if (i2 == 2) {
            return onChangeVerifyQrPopupContainer((MpLayoutVerifyQrPopupBinding) obj, i3);
        }
        if (i2 == 3) {
            return onChangeViewModelQrImage((i) obj, i3);
        }
        if (i2 == 4) {
            return onChangeViewModel((ManageQrViewHandlerNew.QrPageItemViewModel) obj, i3);
        }
        if (i2 != 5) {
            return false;
        }
        return onChangeModelIsP4BClient((ObservableBoolean) obj, i3);
    }

    private boolean onChangeViewModelShowVerifyQrPopup(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeNoNetworkViewModel(NoNetworkViewModel noNetworkViewModel, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeVerifyQrPopupContainer(MpLayoutVerifyQrPopupBinding mpLayoutVerifyQrPopupBinding, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelQrImage(i<Bitmap> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeViewModel(ManageQrViewHandlerNew.QrPageItemViewModel qrPageItemViewModel, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeModelIsP4BClient(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x005c, code lost:
        if (r0 == false) goto L_0x0061;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0053  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r22 = this;
            r1 = r22
            monitor-enter(r22)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x00d7 }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x00d7 }
            monitor-exit(r22)     // Catch:{ all -> 0x00d7 }
            com.business.merchant_payments.newhome.QrViewModel r0 = r1.mModel
            com.business.merchant_payments.qr.ManageQrViewHandlerNew$QrPageItemViewModel r6 = r1.mViewModel
            r7 = 224(0xe0, double:1.107E-321)
            long r9 = r2 & r7
            r11 = 8
            r12 = 192(0xc0, double:9.5E-322)
            r14 = 0
            r15 = 0
            int r16 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x005f
            long r9 = r2 & r12
            int r16 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x003a
            if (r0 == 0) goto L_0x0029
            boolean r9 = r0.isEDCFlavour()
            goto L_0x002a
        L_0x0029:
            r9 = 0
        L_0x002a:
            if (r16 == 0) goto L_0x0035
            if (r9 == 0) goto L_0x0031
            r16 = 2048(0x800, double:1.0118E-320)
            goto L_0x0033
        L_0x0031:
            r16 = 1024(0x400, double:5.06E-321)
        L_0x0033:
            long r2 = r2 | r16
        L_0x0035:
            if (r9 == 0) goto L_0x003a
            r9 = 8
            goto L_0x003b
        L_0x003a:
            r9 = 0
        L_0x003b:
            if (r0 == 0) goto L_0x0040
            androidx.databinding.ObservableBoolean r0 = r0.isP4BClient
            goto L_0x0041
        L_0x0040:
            r0 = r14
        L_0x0041:
            r10 = 5
            r1.updateRegistration((int) r10, (androidx.databinding.h) r0)
            if (r0 == 0) goto L_0x004c
            boolean r0 = r0.get()
            goto L_0x004d
        L_0x004c:
            r0 = 0
        L_0x004d:
            long r16 = r2 & r7
            int r10 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x005c
            if (r0 == 0) goto L_0x0058
            r16 = 512(0x200, double:2.53E-321)
            goto L_0x005a
        L_0x0058:
            r16 = 256(0x100, double:1.265E-321)
        L_0x005a:
            long r2 = r2 | r16
        L_0x005c:
            if (r0 == 0) goto L_0x0061
            goto L_0x0062
        L_0x005f:
            r0 = 0
            r9 = 0
        L_0x0061:
            r11 = 0
        L_0x0062:
            r16 = 153(0x99, double:7.56E-322)
            long r16 = r2 & r16
            r18 = 152(0x98, double:7.5E-322)
            r20 = 145(0x91, double:7.16E-322)
            int r10 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x009c
            long r16 = r2 & r20
            int r10 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x0083
            if (r6 == 0) goto L_0x0079
            androidx.databinding.ObservableBoolean r10 = r6.showVerifyQrPopup
            goto L_0x007a
        L_0x0079:
            r10 = r14
        L_0x007a:
            r1.updateRegistration((int) r15, (androidx.databinding.h) r10)
            if (r10 == 0) goto L_0x0083
            boolean r15 = r10.get()
        L_0x0083:
            long r16 = r2 & r18
            int r10 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x009c
            if (r6 == 0) goto L_0x008e
            androidx.databinding.i<android.graphics.Bitmap> r6 = r6.qrImage
            goto L_0x008f
        L_0x008e:
            r6 = r14
        L_0x008f:
            r10 = 3
            r1.updateRegistration((int) r10, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x009c
            java.lang.Object r6 = r6.get()
            r14 = r6
            android.graphics.Bitmap r14 = (android.graphics.Bitmap) r14
        L_0x009c:
            long r6 = r2 & r7
            int r8 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x00ac
            android.view.View r6 = r1.mboundView5
            com.business.merchant_payments.common.utility.DataBindingUtility.bindVisibility(r6, r0)
            androidx.appcompat.widget.AppCompatTextView r0 = r1.rlDownloadMyQr
            r0.setVisibility(r11)
        L_0x00ac:
            long r6 = r2 & r18
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00b7
            android.widget.ImageView r0 = r1.qrImage
            com.business.merchant_payments.common.utility.DataBindingUtility.bitmapSrc(r0, r14)
        L_0x00b7:
            long r6 = r2 & r12
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00c2
            androidx.appcompat.widget.AppCompatTextView r0 = r1.rlActivateQr
            r0.setVisibility(r9)
        L_0x00c2:
            long r2 = r2 & r20
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00d1
            com.business.merchant_payments.databinding.MpLayoutVerifyQrPopupBinding r0 = r1.verifyQrPopupContainer
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r15)
            r0.setShowVerifyQrPopup(r2)
        L_0x00d1:
            com.business.merchant_payments.databinding.MpLayoutVerifyQrPopupBinding r0 = r1.verifyQrPopupContainer
            androidx.databinding.ViewDataBinding.executeBindingsOn(r0)
            return
        L_0x00d7:
            r0 = move-exception
            monitor-exit(r22)     // Catch:{ all -> 0x00d7 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.databinding.MpQrViewNewBindingImpl.executeBindings():void");
    }
}
