package net.one97.paytm.nativesdk.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.q;
import net.one97.paytm.nativesdk.BR;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.bank_mandate.viewModel.SavedMandateViewModel;

public class SavedMandateLayoutBindingImpl extends SavedMandateLayoutBinding {
    private static final ViewDataBinding.b sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        ViewDataBinding.b bVar = new ViewDataBinding.b(6);
        sIncludes = bVar;
        bVar.a(0, new String[]{"bank_e_mandate_auth_using_view"}, new int[]{1}, new int[]{R.layout.bank_e_mandate_auth_using_view});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.rb_bank_name, 2);
        sViewsWithIds.put(R.id.txt_account, 3);
        sViewsWithIds.put(R.id.iv_saved_mandate_bank, 4);
        sViewsWithIds.put(R.id.btn_proceed_saved_mandate, 5);
    }

    public SavedMandateLayoutBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 6, sIncludes, sViewsWithIds));
    }

    private SavedMandateLayoutBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 1, objArr[5], objArr[0], objArr[1], objArr[4], objArr[2], objArr[3]);
        this.mDirtyFlags = -1;
        this.clMainSavedMandate.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8;
        }
        this.includeAuthUsingViewSaved.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.includeAuthUsingViewSaved.hasPendingBindings() == false) goto L_0x0016;
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
            net.one97.paytm.nativesdk.databinding.BankEMandateAuthUsingViewBinding r0 = r6.includeAuthUsingViewSaved
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
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.databinding.SavedMandateLayoutBindingImpl.hasPendingBindings():boolean");
    }

    public boolean setVariable(int i2, Object obj) {
        if (BR.model == i2) {
            setModel((SavedMandateViewModel) obj);
        } else if (BR.view != i2) {
            return false;
        } else {
            setView((View) obj);
        }
        return true;
    }

    public void setModel(SavedMandateViewModel savedMandateViewModel) {
        this.mModel = savedMandateViewModel;
    }

    public void setView(View view) {
        this.mView = view;
    }

    public void setLifecycleOwner(q qVar) {
        super.setLifecycleOwner(qVar);
        this.includeAuthUsingViewSaved.setLifecycleOwner(qVar);
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return onChangeIncludeAuthUsingViewSaved((BankEMandateAuthUsingViewBinding) obj, i3);
    }

    private boolean onChangeIncludeAuthUsingViewSaved(BankEMandateAuthUsingViewBinding bankEMandateAuthUsingViewBinding, int i2) {
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
        executeBindingsOn(this.includeAuthUsingViewSaved);
    }
}
