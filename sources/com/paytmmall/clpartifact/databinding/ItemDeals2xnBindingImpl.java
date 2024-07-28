package com.paytmmall.clpartifact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.view.viewHolder.CLPDealsVH;
import com.paytmmall.clpartifact.view.viewmodel.VoucherVHViewModel;

public class ItemDeals2xnBindingImpl extends ItemDeals2xnBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback106;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final ImageView mboundView2;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.header, 3);
        sViewsWithIds.put(R.id.deals_text, 4);
    }

    public ItemDeals2xnBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 5, sIncludes, sViewsWithIds));
    }

    private ItemDeals2xnBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 3, objArr[4], objArr[3], objArr[1]);
        this.mDirtyFlags = -1;
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.mboundView2 = objArr[2];
        this.mboundView2.setTag((Object) null);
        this.vouchers.setTag((Object) null);
        setRootTag(view);
        this.mCallback106 = new OnClickListener(this, 1);
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
        if (BR.view == i2) {
            setView((com.paytmmall.clpartifact.modal.clpCommon.View) obj);
        } else if (BR.clickHandler == i2) {
            setClickHandler((CLPDealsVH) obj);
        } else if (BR.viewModel != i2) {
            return false;
        } else {
            setViewModel((VoucherVHViewModel) obj);
        }
        return true;
    }

    public void setView(com.paytmmall.clpartifact.modal.clpCommon.View view) {
        this.mView = view;
    }

    public void setClickHandler(CLPDealsVH cLPDealsVH) {
        this.mClickHandler = cLPDealsVH;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(BR.clickHandler);
        super.requestRebind();
    }

    public void setViewModel(VoucherVHViewModel voucherVHViewModel) {
        updateRegistration(2, (h) voucherVHViewModel);
        this.mViewModel = voucherVHViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return onChangeView((com.paytmmall.clpartifact.modal.clpCommon.View) obj, i3);
        }
        if (i2 == 1) {
            return onChangeViewModelGetSlider((ObservableInt) obj, i3);
        }
        if (i2 != 2) {
            return false;
        }
        return onChangeViewModel((VoucherVHViewModel) obj, i3);
    }

    private boolean onChangeView(com.paytmmall.clpartifact.modal.clpCommon.View view, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelGetSlider(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModel(VoucherVHViewModel voucherVHViewModel, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    public void executeBindings() {
        long j;
        RecyclerView.k kVar;
        RecyclerView.a<?> aVar;
        RecyclerView.l lVar;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        CLPDealsVH cLPDealsVH = this.mClickHandler;
        int i2 = 0;
        VoucherVHViewModel voucherVHViewModel = this.mViewModel;
        ObservableInt observableInt = null;
        int i3 = ((24 & j) > 0 ? 1 : ((24 & j) == 0 ? 0 : -1));
        if (i3 == 0 || cLPDealsVH == null) {
            lVar = null;
            aVar = null;
            kVar = null;
        } else {
            aVar = cLPDealsVH.getAdapter();
            kVar = cLPDealsVH.getOnTouchListener();
            lVar = cLPDealsVH.getOnScrollListener();
        }
        int i4 = ((22 & j) > 0 ? 1 : ((22 & j) == 0 ? 0 : -1));
        if (i4 != 0) {
            if (voucherVHViewModel != null) {
                observableInt = voucherVHViewModel.getSlider();
            }
            updateRegistration(1, (h) observableInt);
            if (observableInt != null) {
                i2 = observableInt.get();
            }
        }
        if ((j & 16) != 0) {
            this.mboundView2.setOnClickListener(this.mCallback106);
        }
        if (i4 != 0) {
            this.mboundView2.setVisibility(i2);
        }
        if (i3 != 0) {
            CLPDealsVH.bindRecyclerViewAdapter(this.vouchers, aVar, lVar, kVar);
        }
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        CLPDealsVH cLPDealsVH = this.mClickHandler;
        if (cLPDealsVH != null) {
            cLPDealsVH.scrollToTop(this.vouchers);
        }
    }
}
