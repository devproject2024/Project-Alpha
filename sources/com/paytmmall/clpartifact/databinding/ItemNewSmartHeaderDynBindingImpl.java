package com.paytmmall.clpartifact.databinding;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.view.viewHolder.CLPNewSmartHeaderVH;
import com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder;
import com.paytmmall.clpartifact.view.viewHolder.SmartIconHeaderV2RootVH;

public class ItemNewSmartHeaderDynBindingImpl extends ItemNewSmartHeaderDynBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback56;
    private final View.OnClickListener mCallback57;
    private long mDirtyFlags;

    public ItemNewSmartHeaderDynBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, sIncludes, sViewsWithIds));
    }

    private ItemNewSmartHeaderDynBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 1, objArr[2], objArr[3], objArr[0], objArr[1]);
        this.mDirtyFlags = -1;
        this.gridImage1.setTag((Object) null);
        this.gridText1.setTag((Object) null);
        this.iconContainer.setTag((Object) null);
        this.imageContainer1.setTag((Object) null);
        setRootTag(view);
        this.mCallback56 = new OnClickListener(this, 1);
        this.mCallback57 = new OnClickListener(this, 2);
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
        if (BR.item == i2) {
            setItem((Item) obj);
        } else if (BR.handler == i2) {
            setHandler((CLPNewSmartHeaderVH) obj);
        } else if (BR.position != i2) {
            return false;
        } else {
            setPosition((Integer) obj);
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

    public void setHandler(CLPNewSmartHeaderVH cLPNewSmartHeaderVH) {
        this.mHandler = cLPNewSmartHeaderVH;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.handler);
        super.requestRebind();
    }

    public void setPosition(Integer num) {
        this.mPosition = num;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(BR.position);
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
        Context context;
        int i2;
        String str;
        boolean z;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Item item = this.mItem;
        CLPNewSmartHeaderVH cLPNewSmartHeaderVH = this.mHandler;
        Integer num = this.mPosition;
        String str2 = null;
        int i3 = 0;
        if ((j & 15) != 0) {
            String imageUrl = item != null ? item.getImageUrl() : null;
            Context context2 = cLPNewSmartHeaderVH != null ? cLPNewSmartHeaderVH.getContext() : null;
            int staticImages = SmartIconHeaderV2RootVH.getStaticImages(item, ViewDataBinding.safeUnbox(num));
            int i4 = ((j & 9) > 0 ? 1 : ((j & 9) == 0 ? 0 : -1));
            if (i4 != 0) {
                if (item != null) {
                    str2 = item.getName();
                }
                if (str2 != null) {
                    z = str2.isEmpty();
                } else {
                    z = false;
                }
                if (i4 != 0) {
                    j |= z ? 32 : 16;
                }
                if (z) {
                    i3 = 8;
                }
            }
            context = context2;
            i2 = staticImages;
            str = imageUrl;
        } else {
            str = null;
            context = null;
            i2 = 0;
        }
        if ((j & 9) != 0) {
            this.gridImage1.setVisibility(i3);
            this.gridText1.setVisibility(i3);
            this.gridText1.setText(str2);
            this.iconContainer.setVisibility(i3);
            this.imageContainer1.setVisibility(i3);
        }
        if ((j & 15) != 0) {
            ClickableRVChildViewHolder.setImageUrl(this.gridImage1, str, 0, false, false, i2, context);
        }
        if ((j & 8) != 0) {
            this.gridText1.setOnClickListener(this.mCallback57);
            this.imageContainer1.setOnClickListener(this.mCallback56);
        }
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        boolean z = false;
        if (i2 == 1) {
            CLPNewSmartHeaderVH cLPNewSmartHeaderVH = this.mHandler;
            Item item = this.mItem;
            Integer num = this.mPosition;
            if (item != null) {
                String name = item.getName();
                if ((name != null) && !name.isEmpty()) {
                    if (cLPNewSmartHeaderVH != null) {
                        z = true;
                    }
                    if (z) {
                        cLPNewSmartHeaderVH.handleDeepLink(item, num.intValue());
                    }
                }
            }
        } else if (i2 == 2) {
            CLPNewSmartHeaderVH cLPNewSmartHeaderVH2 = this.mHandler;
            Item item2 = this.mItem;
            Integer num2 = this.mPosition;
            if (item2 != null) {
                String name2 = item2.getName();
                if ((name2 != null) && !name2.isEmpty()) {
                    if (cLPNewSmartHeaderVH2 != null) {
                        z = true;
                    }
                    if (z) {
                        cLPNewSmartHeaderVH2.handleDeepLink(item2, num2.intValue());
                    }
                }
            }
        }
    }
}
