package net.one97.paytm.nativesdk.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.q;
import net.one97.paytm.nativesdk.BR;
import net.one97.paytm.nativesdk.R;

public class BankEMandateNewAcBindingImpl extends BankEMandateNewAcBinding {
    private static final ViewDataBinding.b sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    public boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        ViewDataBinding.b bVar = new ViewDataBinding.b(22);
        sIncludes = bVar;
        bVar.a(0, new String[]{"bank_e_mandate_auth_using_view"}, new int[]{1}, new int[]{R.layout.bank_e_mandate_auth_using_view});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.rb_bank_e_mandate, 2);
        sViewsWithIds.put(R.id.cl_bank_mandate_bank_select, 3);
        sViewsWithIds.put(R.id.rv_grid_bank_list, 4);
        sViewsWithIds.put(R.id.cl_select_all_other_bank, 5);
        sViewsWithIds.put(R.id.view_other_bank_1, 6);
        sViewsWithIds.put(R.id.tv_bank_mandate_select_other_bank, 7);
        sViewsWithIds.put(R.id.view_other_bank_2, 8);
        sViewsWithIds.put(R.id.iv_navigate_select_other_banks, 9);
        sViewsWithIds.put(R.id.cl_bank_mandate_bank_form, 10);
        sViewsWithIds.put(R.id.iv_bank_mandate_selected_logo, 11);
        sViewsWithIds.put(R.id.tv_bank_mandate_selected_bank, 12);
        sViewsWithIds.put(R.id.tv_bank_mandate_change, 13);
        sViewsWithIds.put(R.id.til_enter_name, 14);
        sViewsWithIds.put(R.id.ti_et_name, 15);
        sViewsWithIds.put(R.id.til_enter_bank_ac, 16);
        sViewsWithIds.put(R.id.ti_et_bank_ac, 17);
        sViewsWithIds.put(R.id.til_enter_ifsc, 18);
        sViewsWithIds.put(R.id.ti_et_ifsc, 19);
        sViewsWithIds.put(R.id.tv_bank_mandate_find_ifsc, 20);
        sViewsWithIds.put(R.id.btn_proceed_mandate, 21);
    }

    public BankEMandateNewAcBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 22, sIncludes, sViewsWithIds));
    }

    private BankEMandateNewAcBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 1, objArr[21], objArr[10], objArr[3], objArr[0], objArr[5], objArr[1], objArr[11], objArr[9], objArr[2], objArr[4], objArr[17], objArr[19], objArr[15], objArr[16], objArr[18], objArr[14], objArr[13], objArr[20], objArr[7], objArr[12], objArr[6], objArr[8]);
        this.mDirtyFlags = -1;
        this.clMainBankMandate.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2;
        }
        this.includeAuthUsingView.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.includeAuthUsingView.hasPendingBindings() == false) goto L_0x0016;
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
            net.one97.paytm.nativesdk.databinding.BankEMandateAuthUsingViewBinding r0 = r6.includeAuthUsingView
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
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.databinding.BankEMandateNewAcBindingImpl.hasPendingBindings():boolean");
    }

    public void setLifecycleOwner(q qVar) {
        super.setLifecycleOwner(qVar);
        this.includeAuthUsingView.setLifecycleOwner(qVar);
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return onChangeIncludeAuthUsingView((BankEMandateAuthUsingViewBinding) obj, i3);
    }

    private boolean onChangeIncludeAuthUsingView(BankEMandateAuthUsingViewBinding bankEMandateAuthUsingViewBinding, int i2) {
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
        executeBindingsOn(this.includeAuthUsingView);
    }
}
