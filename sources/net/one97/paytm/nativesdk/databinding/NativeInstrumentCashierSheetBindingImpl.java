package net.one97.paytm.nativesdk.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.nativesdk.BR;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.paymethods.viewmodel.InstrumentSheetViewModel;

public class NativeInstrumentCashierSheetBindingImpl extends NativeInstrumentCashierSheetBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;

    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.cl_bank_offers, 2);
        sViewsWithIds.put(R.id.scrollView, 3);
        sViewsWithIds.put(R.id.ll_mainView, 4);
        sViewsWithIds.put(R.id.logo_toolbar, 5);
        sViewsWithIds.put(R.id.iv_back_arrow, 6);
        sViewsWithIds.put(R.id.iv_merchantLogo, 7);
        sViewsWithIds.put(R.id.main_toolbar, 8);
        sViewsWithIds.put(R.id.txt_title, 9);
        sViewsWithIds.put(R.id.txt_amount, 10);
        sViewsWithIds.put(R.id.tv_subs_zero_amount_label, 11);
        sViewsWithIds.put(R.id.txt_order_detail, 12);
        sViewsWithIds.put(R.id.ivDownArrow, 13);
        sViewsWithIds.put(R.id.custom_header_toolbar, 14);
        sViewsWithIds.put(R.id.ll_pg_instruments, 15);
        sViewsWithIds.put(R.id.v_emptyView, 16);
        sViewsWithIds.put(R.id.lyt_bottom_lines, 17);
        sViewsWithIds.put(R.id.iv_footer_logos, 18);
        sViewsWithIds.put(R.id.dot_progress_bar, 19);
        sViewsWithIds.put(R.id.sticky_toolbar, 20);
    }

    public NativeInstrumentCashierSheetBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 21, sIncludes, sViewsWithIds));
    }

    private NativeInstrumentCashierSheetBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[2], objArr[14], objArr[19], objArr[1], objArr[6], objArr[13], objArr[18], objArr[7], objArr[4], objArr[15], objArr[5], objArr[17], objArr[8], objArr[3], objArr[20], objArr[11], objArr[10], objArr[12], objArr[9], objArr[16]);
        this.mDirtyFlags = -1;
        this.instrumentsContainer.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
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
        if (BR.instrumentSheetViewModel != i2) {
            return false;
        }
        setInstrumentSheetViewModel((InstrumentSheetViewModel) obj);
        return true;
    }

    public void setInstrumentSheetViewModel(InstrumentSheetViewModel instrumentSheetViewModel) {
        this.mInstrumentSheetViewModel = instrumentSheetViewModel;
    }

    public void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0;
        }
    }
}
