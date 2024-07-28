package net.one97.paytm.nativesdk.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.nativesdk.BR;
import net.one97.paytm.nativesdk.instruments.netbanking.modal.SectionWrapper;

public class NativesdkItemBankSectionBindingImpl extends NativesdkItemBankSectionBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public NativesdkItemBankSectionBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 2, sIncludes, sViewsWithIds));
    }

    private NativesdkItemBankSectionBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[1]);
        this.mDirtyFlags = -1;
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.tvSectionLabel.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2;
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
        if (BR.section != i2) {
            return false;
        }
        setSection((SectionWrapper) obj);
        return true;
    }

    public void setSection(SectionWrapper sectionWrapper) {
        this.mSection = sectionWrapper;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.section);
        super.requestRebind();
    }

    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        SectionWrapper sectionWrapper = this.mSection;
        String str = null;
        int i2 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (!(i2 == 0 || sectionWrapper == null)) {
            str = sectionWrapper.getParentSection();
        }
        if (i2 != 0) {
            this.tvSectionLabel.setText(str);
        }
    }
}
