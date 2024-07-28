package com.paytmmall.clpartifact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.n;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.view.adapter.SFHomeAdapter;
import com.paytmmall.clpartifact.view.viewmodel.SFHomeVM;
import com.paytmmall.clpartifact.view.viewmodel.SingleEventLiveData;

public class FragmentHomeBindingImpl extends FragmentHomeBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback11;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.common_toolbar, 6);
        sViewsWithIds.put(R.id.no_network, 4);
        sViewsWithIds.put(R.id.screenoverlay, 7);
        sViewsWithIds.put(R.id.floating_nav_container, 8);
    }

    public FragmentHomeBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 9, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private FragmentHomeBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 2, objArr[6], objArr[0], objArr[8], objArr[1], objArr[2], new n(objArr[4]), objArr[3], objArr[5], objArr[7]);
        this.mDirtyFlags = -1;
        this.container.setTag((Object) null);
        this.homeAppBar.setTag((Object) null);
        this.homeRv.setTag((Object) null);
        this.noNetwork.f3281e = this;
        this.progressLoader.setTag((Object) null);
        this.scanBtn.setTag((Object) null);
        setRootTag(view);
        this.mCallback11 = new OnClickListener(this, 1);
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
        if (BR.adapter == i2) {
            setAdapter((SFHomeAdapter) obj);
        } else if (BR.viewModel != i2) {
            return false;
        } else {
            setViewModel((SFHomeVM) obj);
        }
        return true;
    }

    public void setAdapter(SFHomeAdapter sFHomeAdapter) {
        this.mAdapter = sFHomeAdapter;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(BR.adapter);
        super.requestRebind();
    }

    public void setViewModel(SFHomeVM sFHomeVM) {
        this.mViewModel = sFHomeVM;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return onChangeViewModelNoNetworkLiveData((SingleEventLiveData) obj, i3);
        }
        if (i2 != 1) {
            return false;
        }
        return onChangeViewModelProgressLiveData((SingleEventLiveData) obj, i3);
    }

    private boolean onChangeViewModelNoNetworkLiveData(SingleEventLiveData<Integer> singleEventLiveData, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelProgressLiveData(SingleEventLiveData<Integer> singleEventLiveData, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r21 = this;
            r1 = r21
            monitor-enter(r21)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x00ea }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x00ea }
            monitor-exit(r21)     // Catch:{ all -> 0x00ea }
            com.paytmmall.clpartifact.view.adapter.SFHomeAdapter r0 = r1.mAdapter
            com.paytmmall.clpartifact.view.viewmodel.SFHomeVM r6 = r1.mViewModel
            r7 = 27
            long r7 = r7 & r2
            r9 = 26
            r11 = 25
            r15 = 64
            r13 = 1
            r14 = 0
            int r19 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r19 == 0) goto L_0x0042
            if (r6 == 0) goto L_0x0021
            r7 = 1
            goto L_0x0022
        L_0x0021:
            r7 = 0
        L_0x0022:
            long r19 = r2 & r11
            int r8 = (r19 > r4 ? 1 : (r19 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x0030
            if (r7 == 0) goto L_0x002c
            long r2 = r2 | r15
            goto L_0x0030
        L_0x002c:
            r19 = 32
            long r2 = r2 | r19
        L_0x0030:
            long r19 = r2 & r9
            int r8 = (r19 > r4 ? 1 : (r19 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x0043
            if (r7 == 0) goto L_0x003d
            r17 = 256(0x100, double:1.265E-321)
            long r2 = r2 | r17
            goto L_0x0043
        L_0x003d:
            r19 = 128(0x80, double:6.32E-322)
            long r2 = r2 | r19
            goto L_0x0043
        L_0x0042:
            r7 = 0
        L_0x0043:
            long r15 = r15 & r2
            r8 = 0
            int r19 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r19 == 0) goto L_0x005d
            if (r6 == 0) goto L_0x0050
            com.paytmmall.clpartifact.view.viewmodel.SingleEventLiveData r15 = r6.getNoNetworkLiveData()
            goto L_0x0051
        L_0x0050:
            r15 = r8
        L_0x0051:
            r1.updateLiveDataRegistration(r14, r15)
            if (r15 == 0) goto L_0x005d
            java.lang.Object r15 = r15.getValue()
            java.lang.Integer r15 = (java.lang.Integer) r15
            goto L_0x005e
        L_0x005d:
            r15 = r8
        L_0x005e:
            r16 = 256(0x100, double:1.265E-321)
            long r16 = r2 & r16
            int r18 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r18 == 0) goto L_0x007a
            if (r6 == 0) goto L_0x006d
            com.paytmmall.clpartifact.view.viewmodel.SingleEventLiveData r6 = r6.getProgressLiveData()
            goto L_0x006e
        L_0x006d:
            r6 = r8
        L_0x006e:
            r1.updateLiveDataRegistration(r13, r6)
            if (r6 == 0) goto L_0x007a
            java.lang.Object r6 = r6.getValue()
            java.lang.Integer r6 = (java.lang.Integer) r6
            goto L_0x007b
        L_0x007a:
            r6 = r8
        L_0x007b:
            long r11 = r11 & r2
            r16 = 8
            int r17 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r17 == 0) goto L_0x008f
            if (r7 == 0) goto L_0x0089
            int r8 = r15.intValue()
            goto L_0x008b
        L_0x0089:
            r8 = 8
        L_0x008b:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
        L_0x008f:
            long r9 = r9 & r2
            int r11 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x00a3
            if (r7 == 0) goto L_0x009a
            int r16 = r6.intValue()
        L_0x009a:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r16)
            int r6 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Integer) r6)
            goto L_0x00a4
        L_0x00a3:
            r6 = 0
        L_0x00a4:
            r9 = 20
            long r9 = r9 & r2
            int r7 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x00b0
            androidx.recyclerview.widget.RecyclerView r7 = r1.homeRv
            com.paytmmall.clpartifact.view.viewmodel.StoreRatingViewModel.bindRecyclerViewAdapter((androidx.recyclerview.widget.RecyclerView) r7, (androidx.recyclerview.widget.RecyclerView.a<?>) r0)
        L_0x00b0:
            if (r17 == 0) goto L_0x00c7
            androidx.databinding.n r0 = r1.noNetwork
            android.view.View r0 = r0.f3279c
            if (r0 == 0) goto L_0x00b9
            goto L_0x00ba
        L_0x00b9:
            r13 = 0
        L_0x00ba:
            if (r13 != 0) goto L_0x00c7
            androidx.databinding.n r0 = r1.noNetwork
            android.view.ViewStub r0 = r0.f3277a
            int r7 = r8.intValue()
            r0.setVisibility(r7)
        L_0x00c7:
            if (r11 == 0) goto L_0x00ce
            com.airbnb.lottie.LottieAnimationView r0 = r1.progressLoader
            r0.setVisibility(r6)
        L_0x00ce:
            r6 = 16
            long r2 = r2 & r6
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00dc
            android.widget.TextView r0 = r1.scanBtn
            android.view.View$OnClickListener r2 = r1.mCallback11
            r0.setOnClickListener(r2)
        L_0x00dc:
            androidx.databinding.n r0 = r1.noNetwork
            androidx.databinding.ViewDataBinding r0 = r0.f3278b
            if (r0 == 0) goto L_0x00e9
            androidx.databinding.n r0 = r1.noNetwork
            androidx.databinding.ViewDataBinding r0 = r0.f3278b
            executeBindingsOn(r0)
        L_0x00e9:
            return
        L_0x00ea:
            r0 = move-exception
            monitor-exit(r21)     // Catch:{ all -> 0x00ea }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.databinding.FragmentHomeBindingImpl.executeBindings():void");
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        SFHomeVM sFHomeVM = this.mViewModel;
        if (sFHomeVM != null) {
            sFHomeVM.setScanClick();
        }
    }
}
