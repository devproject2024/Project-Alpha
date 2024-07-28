package net.one97.paytm.nativesdk.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import net.one97.paytm.nativesdk.BR;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.instruments.netbanking.viewmodel.AllNetBankingListViewModel;

public class NativeSdkNetbankingBankListBindingImpl extends NativeSdkNetbankingBankListBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private OnClickListenerImpl mAllNetBankingViewModelOnCloseAndroidViewViewOnClickListener;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final FrameLayout mboundView2;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.list_empty_layout_container, 5);
        sViewsWithIds.put(R.id.tv_toolbar_title, 6);
        sViewsWithIds.put(R.id.imgSearch, 7);
        sViewsWithIds.put(R.id.searchView, 8);
        sViewsWithIds.put(R.id.img_edt_cross, 9);
    }

    public NativeSdkNetbankingBankListBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 10, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private NativeSdkNetbankingBankListBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 3, objArr[9], objArr[7], objArr[1], objArr[5], objArr[4], objArr[3], objArr[8], objArr[6]);
        this.mDirtyFlags = -1;
        this.ivBackArrow.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.mboundView2 = objArr[2];
        this.mboundView2.setTag((Object) null);
        this.pbProgress.setTag((Object) null);
        this.rvBankList.setTag((Object) null);
        View view2 = view;
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8;
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
        if (BR.allNetBankingViewModel != i2) {
            return false;
        }
        setAllNetBankingViewModel((AllNetBankingListViewModel) obj);
        return true;
    }

    public void setAllNetBankingViewModel(AllNetBankingListViewModel allNetBankingListViewModel) {
        updateRegistration(0, (h) allNetBankingListViewModel);
        this.mAllNetBankingViewModel = allNetBankingListViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.allNetBankingViewModel);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return onChangeAllNetBankingViewModel((AllNetBankingListViewModel) obj, i3);
        }
        if (i2 == 1) {
            return onChangeAllNetBankingViewModelNetbakingRecyclerVisiblity((ObservableInt) obj, i3);
        }
        if (i2 != 2) {
            return false;
        }
        return onChangeAllNetBankingViewModelProgressBarVisiblity((ObservableInt) obj, i3);
    }

    private boolean onChangeAllNetBankingViewModel(AllNetBankingListViewModel allNetBankingListViewModel, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeAllNetBankingViewModelNetbakingRecyclerVisiblity(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeAllNetBankingViewModelProgressBarVisiblity(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r19 = this;
            r1 = r19
            monitor-enter(r19)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x0083 }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x0083 }
            monitor-exit(r19)     // Catch:{ all -> 0x0083 }
            net.one97.paytm.nativesdk.instruments.netbanking.viewmodel.AllNetBankingListViewModel r0 = r1.mAllNetBankingViewModel
            r6 = 15
            long r6 = r6 & r2
            r8 = 13
            r10 = 11
            r12 = 9
            r14 = 0
            r15 = 0
            int r16 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x0061
            long r6 = r2 & r10
            int r16 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x0032
            if (r0 == 0) goto L_0x0026
            androidx.databinding.ObservableInt r6 = r0.netbakingRecyclerVisiblity
            goto L_0x0027
        L_0x0026:
            r6 = r15
        L_0x0027:
            r7 = 1
            r1.updateRegistration((int) r7, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x0032
            int r6 = r6.get()
            goto L_0x0033
        L_0x0032:
            r6 = 0
        L_0x0033:
            long r16 = r2 & r12
            int r7 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x004b
            if (r0 == 0) goto L_0x004b
            net.one97.paytm.nativesdk.databinding.NativeSdkNetbankingBankListBindingImpl$OnClickListenerImpl r7 = r1.mAllNetBankingViewModelOnCloseAndroidViewViewOnClickListener
            if (r7 != 0) goto L_0x0046
            net.one97.paytm.nativesdk.databinding.NativeSdkNetbankingBankListBindingImpl$OnClickListenerImpl r7 = new net.one97.paytm.nativesdk.databinding.NativeSdkNetbankingBankListBindingImpl$OnClickListenerImpl
            r7.<init>()
            r1.mAllNetBankingViewModelOnCloseAndroidViewViewOnClickListener = r7
        L_0x0046:
            net.one97.paytm.nativesdk.databinding.NativeSdkNetbankingBankListBindingImpl$OnClickListenerImpl r7 = r7.setValue(r0)
            goto L_0x004c
        L_0x004b:
            r7 = r15
        L_0x004c:
            long r16 = r2 & r8
            int r18 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r18 == 0) goto L_0x0063
            if (r0 == 0) goto L_0x0056
            androidx.databinding.ObservableInt r15 = r0.progressBarVisiblity
        L_0x0056:
            r0 = 2
            r1.updateRegistration((int) r0, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x0063
            int r14 = r15.get()
            goto L_0x0063
        L_0x0061:
            r7 = r15
            r6 = 0
        L_0x0063:
            long r12 = r12 & r2
            int r0 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x006d
            android.widget.ImageView r0 = r1.ivBackArrow
            r0.setOnClickListener(r7)
        L_0x006d:
            long r7 = r2 & r8
            int r0 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0078
            android.widget.ProgressBar r0 = r1.pbProgress
            r0.setVisibility(r14)
        L_0x0078:
            long r2 = r2 & r10
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0082
            net.one97.paytm.nativesdk.instruments.netbanking.view.IndexFastScrollRecyclerView r0 = r1.rvBankList
            r0.setVisibility(r6)
        L_0x0082:
            return
        L_0x0083:
            r0 = move-exception
            monitor-exit(r19)     // Catch:{ all -> 0x0083 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.databinding.NativeSdkNetbankingBankListBindingImpl.executeBindings():void");
    }

    public static class OnClickListenerImpl implements View.OnClickListener {
        private AllNetBankingListViewModel value;

        public OnClickListenerImpl setValue(AllNetBankingListViewModel allNetBankingListViewModel) {
            this.value = allNetBankingListViewModel;
            if (allNetBankingListViewModel == null) {
                return null;
            }
            return this;
        }

        public void onClick(View view) {
            this.value.onClose(view);
        }
    }
}
