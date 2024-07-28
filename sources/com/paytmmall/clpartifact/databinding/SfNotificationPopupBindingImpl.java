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
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder;
import com.paytmmall.clpartifact.widgets.component.SFNotificationPopup;

public class SfNotificationPopupBindingImpl extends SfNotificationPopupBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback39;
    private final View.OnClickListener mCallback40;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_top, 6);
        sViewsWithIds.put(R.id.guideline_bottom, 7);
        sViewsWithIds.put(R.id.guideline_start, 8);
        sViewsWithIds.put(R.id.guideline_end, 9);
    }

    public SfNotificationPopupBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 10, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private SfNotificationPopupBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 1, objArr[1], objArr[7], objArr[9], objArr[8], objArr[6], objArr[5], objArr[4], objArr[3], objArr[2]);
        this.mDirtyFlags = -1;
        this.grpLayout.setTag((Object) null);
        this.imgDismiss.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.viewImg.setTag((Object) null);
        this.viewSubtitle.setTag((Object) null);
        this.viewTitle.setTag((Object) null);
        setRootTag(view);
        this.mCallback39 = new OnClickListener(this, 1);
        this.mCallback40 = new OnClickListener(this, 2);
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
        if (BR.item == i2) {
            setItem((Item) obj);
        } else if (BR.clickhandler != i2) {
            return false;
        } else {
            setClickhandler((SFNotificationPopup) obj);
        }
        return true;
    }

    public void setItem(Item item) {
        updateRegistration(0, (h) item);
        this.mItem = item;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.item);
        super.requestRebind();
    }

    public void setClickhandler(SFNotificationPopup sFNotificationPopup) {
        this.mClickhandler = sFNotificationPopup;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.clickhandler);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return onChangeItem((Item) obj, i3);
    }

    private boolean onChangeItem(Item item, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    public void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Item item = this.mItem;
        int i2 = ((5 & j) > 0 ? 1 : ((5 & j) == 0 ? 0 : -1));
        if (i2 == 0 || item == null) {
            str3 = null;
            str2 = null;
            str = null;
        } else {
            String imageUrl = item.getImageUrl();
            str2 = item.getItemSubtitle();
            str3 = item.getTitle();
            str = imageUrl;
        }
        if ((j & 4) != 0) {
            this.grpLayout.setOnClickListener(this.mCallback39);
            this.imgDismiss.setOnClickListener(this.mCallback40);
        }
        if (i2 != 0) {
            ClickableRVChildViewHolder.setImageUrl(this.viewImg, str, 0, false, false, 0, (Context) null);
            d.a(this.viewSubtitle, (CharSequence) str2);
            d.a(this.viewTitle, (CharSequence) str3);
        }
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        boolean z = false;
        if (i2 == 1) {
            Item item = this.mItem;
            SFNotificationPopup sFNotificationPopup = this.mClickhandler;
            if (sFNotificationPopup != null) {
                z = true;
            }
            if (z) {
                sFNotificationPopup.handleDeeplink(item);
            }
        } else if (i2 == 2) {
            SFNotificationPopup sFNotificationPopup2 = this.mClickhandler;
            if (sFNotificationPopup2 != null) {
                z = true;
            }
            if (z) {
                sFNotificationPopup2.dismissWidget();
            }
        }
    }
}
