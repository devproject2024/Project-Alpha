package com.paytmmall.clpartifact.databinding;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.databinding.h;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.modal.clpCommon.CJRStoreInfo;
import com.paytmmall.clpartifact.view.viewHolder.CLPMerchantBannerVHWithoutRV;
import com.paytmmall.clpartifact.view.viewHolder.CLPStoreBannerVHWithoutRV;
import com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder;

public class ItemMerchantBannerBindingImpl extends ItemMerchantBannerBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback2;
    private final View.OnClickListener mCallback3;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    public ItemMerchantBannerBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 6, sIncludes, sViewsWithIds));
    }

    private ItemMerchantBannerBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 2, objArr[1], objArr[5], objArr[2], objArr[4], objArr[3]);
        this.mDirtyFlags = -1;
        this.backButton.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.search.setTag((Object) null);
        this.storeImage.setTag((Object) null);
        this.txvLocation.setTag((Object) null);
        this.txvName.setTag((Object) null);
        setRootTag(view);
        this.mCallback2 = new OnClickListener(this, 1);
        this.mCallback3 = new OnClickListener(this, 2);
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
        if (BR.view == i2) {
            setView((com.paytmmall.clpartifact.modal.clpCommon.View) obj);
        } else if (BR.clickHandler != i2) {
            return false;
        } else {
            setClickHandler((CLPMerchantBannerVHWithoutRV) obj);
        }
        return true;
    }

    public void setView(com.paytmmall.clpartifact.modal.clpCommon.View view) {
        updateRegistration(0, (h) view);
        this.mView = view;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.view);
        super.requestRebind();
    }

    public void setClickHandler(CLPMerchantBannerVHWithoutRV cLPMerchantBannerVHWithoutRV) {
        this.mClickHandler = cLPMerchantBannerVHWithoutRV;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(BR.clickHandler);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return onChangeView((com.paytmmall.clpartifact.modal.clpCommon.View) obj, i3);
        }
        if (i2 != 1) {
            return false;
        }
        return onChangeViewGetStoreInfo((CJRStoreInfo) obj, i3);
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

    private boolean onChangeViewGetStoreInfo(CJRStoreInfo cJRStoreInfo, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    public void executeBindings() {
        long j;
        String str;
        CJRStoreInfo cJRStoreInfo;
        Context context;
        String str2;
        String str3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        com.paytmmall.clpartifact.modal.clpCommon.View view = this.mView;
        CLPMerchantBannerVHWithoutRV cLPMerchantBannerVHWithoutRV = this.mClickHandler;
        boolean z = false;
        if ((j & 15) != 0) {
            cJRStoreInfo = view != null ? view.getStoreInfo() : null;
            updateRegistration(1, (h) cJRStoreInfo);
            if (cLPMerchantBannerVHWithoutRV != null) {
                context = cLPMerchantBannerVHWithoutRV.getContext();
            } else {
                context = null;
            }
            int i2 = ((j & 11) > 0 ? 1 : ((j & 11) == 0 ? 0 : -1));
            if (i2 != 0) {
                if (cJRStoreInfo != null) {
                    z = true;
                }
                if (i2 != 0) {
                    j = z ? j | 32 | 128 : j | 16 | 64;
                }
            }
            str = cJRStoreInfo != null ? cJRStoreInfo.getLogoUrl() : null;
        } else {
            context = null;
            cJRStoreInfo = null;
            str = null;
        }
        String name = ((32 & j) == 0 || cJRStoreInfo == null) ? null : cJRStoreInfo.getName();
        if ((128 & j) == 0 || cJRStoreInfo == null) {
            str2 = null;
        } else {
            str2 = cJRStoreInfo.getCity();
        }
        int i3 = ((11 & j) > 0 ? 1 : ((11 & j) == 0 ? 0 : -1));
        if (i3 != 0) {
            if (!z) {
                name = "StoreName";
            }
            String str4 = name;
            if (!z) {
                str2 = "";
            }
            str3 = str4;
        } else {
            str2 = null;
            str3 = null;
        }
        if ((8 & j) != 0) {
            this.backButton.setOnClickListener(this.mCallback2);
            this.search.setOnClickListener(this.mCallback3);
        }
        if ((13 & j) != 0) {
            CLPStoreBannerVHWithoutRV.setBGColor(this.mboundView0, view, context);
        }
        if ((j & 15) != 0) {
            ClickableRVChildViewHolder.setImageUrl(this.storeImage, str, 0, false, false, 0, context);
        }
        if (i3 != 0) {
            d.a(this.txvLocation, (CharSequence) str2);
            d.a(this.txvName, (CharSequence) str3);
        }
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        boolean z = false;
        if (i2 == 1) {
            CLPMerchantBannerVHWithoutRV cLPMerchantBannerVHWithoutRV = this.mClickHandler;
            if (cLPMerchantBannerVHWithoutRV != null) {
                z = true;
            }
            if (z) {
                cLPMerchantBannerVHWithoutRV.handleBackPress(view);
            }
        } else if (i2 == 2) {
            com.paytmmall.clpartifact.modal.clpCommon.View view2 = this.mView;
            CLPMerchantBannerVHWithoutRV cLPMerchantBannerVHWithoutRV2 = this.mClickHandler;
            if (cLPMerchantBannerVHWithoutRV2 != null) {
                if (view2 != null) {
                    CJRStoreInfo storeInfo = view2.getStoreInfo();
                    if (storeInfo != null) {
                        z = true;
                    }
                    if (z) {
                        cLPMerchantBannerVHWithoutRV2.onSearchClick(view, storeInfo.getName());
                    }
                }
            }
        }
    }
}
