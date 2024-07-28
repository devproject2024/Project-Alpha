package net.one97.paytm.nativesdk.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.nativesdk.BR;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.bank_mandate.dataModel.BankMandateSectionWrapper;

public class NativesdkBankMandateListProviderItemBindingImpl extends NativesdkBankMandateListProviderItemBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.iv_bm_bank_icon, 1);
        sViewsWithIds.put(R.id.tv_bank_name, 2);
    }

    public NativesdkBankMandateListProviderItemBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 3, sIncludes, sViewsWithIds));
    }

    private NativesdkBankMandateListProviderItemBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[1], objArr[2]);
        this.mDirtyFlags = -1;
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4;
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
        if (BR.view == i2) {
            setView((View) obj);
        } else if (BR.bank_mandate != i2) {
            return false;
        } else {
            setBankMandate((BankMandateSectionWrapper) obj);
        }
        return true;
    }

    public void setView(View view) {
        this.mView = view;
    }

    public void setBankMandate(BankMandateSectionWrapper bankMandateSectionWrapper) {
        this.mBankMandate = bankMandateSectionWrapper;
    }

    public void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0;
        }
    }
}
