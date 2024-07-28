package com.business.merchant_payments.databinding;

import android.graphics.Bitmap;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import androidx.databinding.i;
import androidx.lifecycle.q;
import com.business.merchant_payments.BR;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.utility.DataBindingUtility;
import com.business.merchant_payments.newhome.ManageQrViewHandler;

public class MpProfileQrPagerItemLayoutBindingImpl extends MpProfileQrPagerItemLayoutBinding {
    public static final ViewDataBinding.b sIncludes;
    public static final SparseIntArray sViewsWithIds;
    public long mDirtyFlags;
    public final FrameLayout mboundView1;

    static {
        ViewDataBinding.b bVar = new ViewDataBinding.b(14);
        sIncludes = bVar;
        bVar.a(1, new String[]{"mp_layout_verify_qr_popup"}, new int[]{3}, new int[]{R.layout.mp_layout_verify_qr_popup});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.back_button, 4);
        sViewsWithIds.put(R.id.iv_all_in_one, 5);
        sViewsWithIds.put(R.id.barrier, 6);
        sViewsWithIds.put(R.id.cardView, 7);
        sViewsWithIds.put(R.id.qr_dummy_image, 8);
        sViewsWithIds.put(R.id.qr_shimmer, 9);
        sViewsWithIds.put(R.id.ll_retry, 10);
        sViewsWithIds.put(R.id.ll_no_permission, 11);
        sViewsWithIds.put(R.id.bottom_line_1, 12);
        sViewsWithIds.put(R.id.bottom_line_2, 13);
    }

    public MpProfileQrPagerItemLayoutBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 14, sIncludes, sViewsWithIds));
    }

    public MpProfileQrPagerItemLayoutBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 4, objArr[4], objArr[6], objArr[12], objArr[13], objArr[7], objArr[5], objArr[11], objArr[10], objArr[8], objArr[2], objArr[0], objArr[9], objArr[3]);
        this.mDirtyFlags = -1;
        FrameLayout frameLayout = objArr[1];
        this.mboundView1 = frameLayout;
        frameLayout.setTag((Object) null);
        this.qrImage.setTag((Object) null);
        this.qrParent.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16;
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
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.databinding.MpProfileQrPagerItemLayoutBindingImpl.hasPendingBindings():boolean");
    }

    public boolean setVariable(int i2, Object obj) {
        if (BR.viewModel != i2) {
            return false;
        }
        setViewModel((ManageQrViewHandler.QrPageItemViewModelNew) obj);
        return true;
    }

    public void setViewModel(ManageQrViewHandler.QrPageItemViewModelNew qrPageItemViewModelNew) {
        updateRegistration(3, (h) qrPageItemViewModelNew);
        this.mViewModel = qrPageItemViewModelNew;
        synchronized (this) {
            this.mDirtyFlags |= 8;
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
            return onChangeVerifyQrPopupContainer((MpLayoutVerifyQrPopupBinding) obj, i3);
        }
        if (i2 == 2) {
            return onChangeViewModelQrImage((i) obj, i3);
        }
        if (i2 != 3) {
            return false;
        }
        return onChangeViewModel((ManageQrViewHandler.QrPageItemViewModelNew) obj, i3);
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

    private boolean onChangeVerifyQrPopupContainer(MpLayoutVerifyQrPopupBinding mpLayoutVerifyQrPopupBinding, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelQrImage(i<Bitmap> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeViewModel(ManageQrViewHandler.QrPageItemViewModelNew qrPageItemViewModelNew, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        ManageQrViewHandler.QrPageItemViewModelNew qrPageItemViewModelNew = this.mViewModel;
        boolean z = false;
        Bitmap bitmap = null;
        if ((29 & j) != 0) {
            if ((j & 25) != 0) {
                ObservableBoolean observableBoolean = qrPageItemViewModelNew != null ? qrPageItemViewModelNew.showVerifyQrPopup : null;
                updateRegistration(0, (h) observableBoolean);
                if (observableBoolean != null) {
                    z = observableBoolean.get();
                }
            }
            if ((j & 28) != 0) {
                i<Bitmap> iVar = qrPageItemViewModelNew != null ? qrPageItemViewModelNew.qrImage : null;
                updateRegistration(2, (h) iVar);
                if (iVar != null) {
                    bitmap = iVar.get();
                }
            }
        }
        if ((j & 28) != 0) {
            DataBindingUtility.bitmapSrc(this.qrImage, bitmap);
        }
        if ((j & 25) != 0) {
            this.verifyQrPopupContainer.setShowVerifyQrPopup(Boolean.valueOf(z));
        }
        ViewDataBinding.executeBindingsOn(this.verifyQrPopupContainer);
    }
}
