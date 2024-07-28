package com.paytm.business.merchantprofile.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.q;
import com.paytm.business.merchantprofile.BR;
import com.paytm.business.merchantprofile.R;

public class PrProfileReactivateBindingImpl extends PrProfileReactivateBinding {
    public static final ViewDataBinding.b sIncludes;
    public static final SparseIntArray sViewsWithIds;
    public long mDirtyFlags;

    public boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        ViewDataBinding.b bVar = new ViewDataBinding.b(6);
        sIncludes = bVar;
        bVar.a(0, new String[]{"pr_view_edit_change_in_progress_new"}, new int[]{1}, new int[]{R.layout.pr_view_edit_change_in_progress_new});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.tvAccountStatus, 2);
        sViewsWithIds.put(R.id.tvStatusMsg, 3);
        sViewsWithIds.put(R.id.shimmer_deactivate, 4);
        sViewsWithIds.put(R.id.tv_deactivate_account, 5);
    }

    public PrProfileReactivateBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 6, sIncludes, sViewsWithIds));
    }

    public PrProfileReactivateBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 1, objArr[0], objArr[4], objArr[2], objArr[5], objArr[3], objArr[1]);
        this.mDirtyFlags = -1;
        this.llDeactivate.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2;
        }
        this.viewDisplayDeactivationStatus.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.viewDisplayDeactivationStatus.hasPendingBindings() == false) goto L_0x0016;
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
            com.paytm.business.merchantprofile.databinding.PrViewEditChangeInProgressNewBinding r0 = r6.viewDisplayDeactivationStatus
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
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.business.merchantprofile.databinding.PrProfileReactivateBindingImpl.hasPendingBindings():boolean");
    }

    public void setLifecycleOwner(q qVar) {
        super.setLifecycleOwner(qVar);
        this.viewDisplayDeactivationStatus.setLifecycleOwner(qVar);
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return onChangeViewDisplayDeactivationStatus((PrViewEditChangeInProgressNewBinding) obj, i3);
    }

    private boolean onChangeViewDisplayDeactivationStatus(PrViewEditChangeInProgressNewBinding prViewEditChangeInProgressNewBinding, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    public void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0;
        }
        ViewDataBinding.executeBindingsOn(this.viewDisplayDeactivationStatus);
    }
}
