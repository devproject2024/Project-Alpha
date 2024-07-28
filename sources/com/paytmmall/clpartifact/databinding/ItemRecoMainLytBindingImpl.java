package com.paytmmall.clpartifact.databinding;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.databinding.h;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.view.adapter.CLPRecoListAdapter;
import com.paytmmall.clpartifact.view.viewHolder.CLPRecoListVH;
import com.paytmmall.clpartifact.view.viewmodel.StoreRatingViewModel;

public class ItemRecoMainLytBindingImpl extends ItemRecoMainLytBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback97;
    private final View.OnClickListener mCallback98;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.textLayout, 5);
        sViewsWithIds.put(R.id.expandGroup, 6);
    }

    public ItemRecoMainLytBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 7, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private ItemRecoMainLytBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 1, objArr[6], objArr[0], objArr[1], objArr[3], objArr[5], objArr[2], objArr[4]);
        this.mDirtyFlags = -1;
        this.mainLayout.setTag((Object) null);
        this.recoRv.setTag((Object) null);
        this.subTitle.setTag((Object) null);
        this.title.setTag((Object) null);
        this.upArrowImg.setTag((Object) null);
        setRootTag(view);
        this.mCallback98 = new OnClickListener(this, 2);
        this.mCallback97 = new OnClickListener(this, 1);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 32;
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
        } else if (BR.handler == i2) {
            setHandler((CLPRecoListVH) obj);
        } else if (BR.groupAdapter == i2) {
            setGroupAdapter((CLPRecoListAdapter) obj);
        } else if (BR.isCollapsed != i2) {
            return false;
        } else {
            setIsCollapsed((Boolean) obj);
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

    public void setHandler(CLPRecoListVH cLPRecoListVH) {
        this.mHandler = cLPRecoListVH;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.handler);
        super.requestRebind();
    }

    public void setGroupAdapter(CLPRecoListAdapter cLPRecoListAdapter) {
        this.mGroupAdapter = cLPRecoListAdapter;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(BR.groupAdapter);
        super.requestRebind();
    }

    public void setIsCollapsed(Boolean bool) {
        this.mIsCollapsed = bool;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(BR.isCollapsed);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return onChangeView((com.paytmmall.clpartifact.modal.clpCommon.View) obj, i3);
    }

    private boolean onChangeView(com.paytmmall.clpartifact.modal.clpCommon.View view, int i2) {
        if (i2 == BR._all) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i2 != BR.title) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        }
    }

    public void executeBindings() {
        long j;
        int i2;
        String str;
        String str2;
        int i3;
        ImageView imageView;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        com.paytmmall.clpartifact.modal.clpCommon.View view = this.mView;
        CLPRecoListAdapter cLPRecoListAdapter = this.mGroupAdapter;
        Boolean bool = this.mIsCollapsed;
        Drawable drawable = null;
        int i4 = 0;
        int i5 = ((j & 49) > 0 ? 1 : ((j & 49) == 0 ? 0 : -1));
        if (i5 != 0) {
            str = view != null ? view.getTitle() : null;
            boolean z = !TextUtils.isEmpty(str);
            if (i5 != 0) {
                j |= z ? 2048 : 1024;
            }
            i2 = z ? 0 : 8;
            int i6 = ((j & 33) > 0 ? 1 : ((j & 33) == 0 ? 0 : -1));
            if (i6 != 0) {
                str2 = view != null ? view.getSubtitle() : null;
                boolean z2 = !TextUtils.isEmpty(str2);
                if (i6 != 0) {
                    j |= z2 ? 512 : 256;
                }
                if (!z2) {
                    i4 = 8;
                }
            } else {
                str2 = null;
            }
        } else {
            str2 = null;
            str = null;
            i2 = 0;
        }
        int i7 = ((j & 40) > 0 ? 1 : ((j & 40) == 0 ? 0 : -1));
        if (i7 != 0) {
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            if (i7 != 0) {
                j |= safeUnbox ? 128 : 64;
            }
            if (safeUnbox) {
                imageView = this.upArrowImg;
                i3 = R.drawable.ic_home_down_arrow;
            } else {
                imageView = this.upArrowImg;
                i3 = R.drawable.home_up_arrow;
            }
            drawable = getDrawableFromResource(imageView, i3);
        }
        if ((j & 32) != 0) {
            this.mainLayout.setOnClickListener(this.mCallback97);
            this.recoRv.setOnClickListener(this.mCallback98);
        }
        if ((36 & j) != 0) {
            StoreRatingViewModel.bindRecyclerViewAdapter(this.recoRv, (RecyclerView.a<?>) cLPRecoListAdapter);
        }
        if ((j & 33) != 0) {
            d.a((TextView) this.subTitle, (CharSequence) str2);
            this.subTitle.setVisibility(i4);
        }
        if ((49 & j) != 0) {
            d.a((TextView) this.title, (CharSequence) str);
            this.title.setVisibility(i2);
        }
        if ((j & 40) != 0) {
            this.upArrowImg.setImageDrawable(drawable);
        }
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        boolean z = false;
        if (i2 == 1) {
            CLPRecoListVH cLPRecoListVH = this.mHandler;
            if (cLPRecoListVH != null) {
                z = true;
            }
            if (z) {
                cLPRecoListVH.handleClick();
            }
        } else if (i2 == 2) {
            CLPRecoListVH cLPRecoListVH2 = this.mHandler;
            if (cLPRecoListVH2 != null) {
                z = true;
            }
            if (z) {
                cLPRecoListVH2.handleClick();
            }
        }
    }
}
