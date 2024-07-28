package com.paytmmall.clpartifact.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.modal.stores.CJRStoreList;
import com.paytmmall.clpartifact.view.viewHolder.StoreListViewHolder;

public class FragmentItemBindingImpl extends FragmentItemBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback43;
    private final View.OnClickListener mCallback44;
    private final View.OnClickListener mCallback45;
    private final View.OnClickListener mCallback46;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public FragmentItemBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 8, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private FragmentItemBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[4], objArr[7], objArr[6], objArr[3], objArr[2], objArr[1], objArr[5]);
        this.mDirtyFlags = -1;
        this.Addresstxt.setTag((Object) null);
        this.call.setTag((Object) null);
        this.direction.setTag((Object) null);
        this.directiontxt.setTag((Object) null);
        this.map.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.name.setTag((Object) null);
        this.timetxt.setTag((Object) null);
        setRootTag(view);
        this.mCallback43 = new OnClickListener(this, 1);
        this.mCallback44 = new OnClickListener(this, 2);
        this.mCallback45 = new OnClickListener(this, 3);
        this.mCallback46 = new OnClickListener(this, 4);
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
            setItem((CJRStoreList) obj);
        } else if (BR.handler != i2) {
            return false;
        } else {
            setHandler((StoreListViewHolder) obj);
        }
        return true;
    }

    public void setItem(CJRStoreList cJRStoreList) {
        this.mItem = cJRStoreList;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.item);
        super.requestRebind();
    }

    public void setHandler(StoreListViewHolder storeListViewHolder) {
        this.mHandler = storeListViewHolder;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.handler);
        super.requestRebind();
    }

    public void executeBindings() {
        long j;
        int i2;
        String str;
        String str2;
        int i3;
        String str3;
        int i4;
        int i5;
        String str4;
        String str5;
        String str6;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        CJRStoreList cJRStoreList = this.mItem;
        String str7 = null;
        int i6 = 0;
        int i7 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i7 != 0) {
            if (cJRStoreList != null) {
                str7 = cJRStoreList.getOpeningTime();
                str5 = cJRStoreList.getContact();
                str3 = cJRStoreList.getDistance();
                str4 = cJRStoreList.getAddress();
                str = cJRStoreList.getName();
                str6 = cJRStoreList.getRating();
            } else {
                str6 = null;
                str5 = null;
                str3 = null;
                str4 = null;
                str = null;
            }
            boolean isEmpty = TextUtils.isEmpty(str7);
            boolean isEmpty2 = TextUtils.isEmpty(str5);
            boolean isEmpty3 = TextUtils.isEmpty(str3);
            boolean isEmpty4 = TextUtils.isEmpty(str4);
            boolean isEmpty5 = TextUtils.isEmpty(str6);
            if (i7 != 0) {
                j |= isEmpty ? 16 : 8;
            }
            if ((j & 5) != 0) {
                j |= isEmpty2 ? 64 : 32;
            }
            if ((j & 5) != 0) {
                j |= isEmpty3 ? 4096 : 2048;
            }
            if ((j & 5) != 0) {
                j |= isEmpty4 ? 1024 : 512;
            }
            if ((j & 5) != 0) {
                j |= isEmpty5 ? 256 : 128;
            }
            int i8 = 8;
            i2 = isEmpty ? 8 : 0;
            i4 = isEmpty2 ? 8 : 0;
            int i9 = isEmpty3 ? 4 : 0;
            if (!isEmpty4) {
                i8 = 0;
            }
            if (isEmpty5) {
                i6 = 4;
            }
            i5 = i6;
            i6 = i8;
            i3 = i9;
            String str8 = str4;
            str2 = str7;
            str7 = str8;
        } else {
            str3 = null;
            str2 = null;
            str = null;
            i5 = 0;
            i4 = 0;
            i3 = 0;
            i2 = 0;
        }
        if ((5 & j) != 0) {
            d.a(this.Addresstxt, (CharSequence) str7);
            this.Addresstxt.setVisibility(i6);
            this.call.setVisibility(i4);
            this.directiontxt.setVisibility(i5);
            d.a(this.directiontxt, (CharSequence) str3);
            this.map.setVisibility(i3);
            d.a(this.name, (CharSequence) str);
            this.timetxt.setVisibility(i2);
            d.a(this.timetxt, (CharSequence) str2);
        }
        if ((j & 4) != 0) {
            this.call.setOnClickListener(this.mCallback46);
            this.direction.setOnClickListener(this.mCallback45);
            this.directiontxt.setOnClickListener(this.mCallback44);
            this.map.setOnClickListener(this.mCallback43);
        }
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        boolean z = false;
        if (i2 == 1) {
            StoreListViewHolder storeListViewHolder = this.mHandler;
            CJRStoreList cJRStoreList = this.mItem;
            if (storeListViewHolder != null) {
                z = true;
            }
            if (z) {
                storeListViewHolder.openGoogleMaps(cJRStoreList);
            }
        } else if (i2 == 2) {
            StoreListViewHolder storeListViewHolder2 = this.mHandler;
            CJRStoreList cJRStoreList2 = this.mItem;
            if (storeListViewHolder2 != null) {
                z = true;
            }
            if (z) {
                storeListViewHolder2.openGoogleMaps(cJRStoreList2);
            }
        } else if (i2 == 3) {
            StoreListViewHolder storeListViewHolder3 = this.mHandler;
            CJRStoreList cJRStoreList3 = this.mItem;
            if (storeListViewHolder3 != null) {
                z = true;
            }
            if (z) {
                storeListViewHolder3.openGoogleMaps(cJRStoreList3);
            }
        } else if (i2 == 4) {
            StoreListViewHolder storeListViewHolder4 = this.mHandler;
            CJRStoreList cJRStoreList4 = this.mItem;
            if (storeListViewHolder4 != null) {
                if (cJRStoreList4 != null) {
                    z = true;
                }
                if (z) {
                    storeListViewHolder4.openDialer(cJRStoreList4.getContact());
                }
            }
        }
    }
}
