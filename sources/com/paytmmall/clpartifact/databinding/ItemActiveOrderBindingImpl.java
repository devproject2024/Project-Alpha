package com.paytmmall.clpartifact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.customViews.CLPRobotoTextView;
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.view.adapter.CLPItemRVAdapter;
import com.paytmmall.clpartifact.view.viewHolder.CLPItemRVViewHolder;

public class ItemActiveOrderBindingImpl extends ItemActiveOrderBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback75;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final CLPRobotoTextView mboundView1;
    private final ImageView mboundView2;

    public ItemActiveOrderBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 3, sIncludes, sViewsWithIds));
    }

    private ItemActiveOrderBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 1);
        this.mDirtyFlags = -1;
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.mboundView1 = objArr[1];
        this.mboundView1.setTag((Object) null);
        this.mboundView2 = objArr[2];
        this.mboundView2.setTag((Object) null);
        setRootTag(view);
        this.mCallback75 = new OnClickListener(this, 1);
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
        if (BR.item == i2) {
            setItem((Item) obj);
        } else if (BR.layoutManager == i2) {
            setLayoutManager((RecyclerView.LayoutManager) obj);
        } else if (BR.handler == i2) {
            setHandler((CLPItemRVViewHolder) obj);
        } else if (BR.adapter == i2) {
            setAdapter((CLPItemRVAdapter) obj);
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

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        this.mLayoutManager = layoutManager;
    }

    public void setHandler(CLPItemRVViewHolder cLPItemRVViewHolder) {
        this.mHandler = cLPItemRVViewHolder;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(BR.handler);
        super.requestRebind();
    }

    public void setAdapter(CLPItemRVAdapter cLPItemRVAdapter) {
        this.mAdapter = cLPItemRVAdapter;
    }

    public void setPosition(Integer num) {
        this.mPosition = num;
        synchronized (this) {
            this.mDirtyFlags |= 16;
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

    /* JADX WARNING: type inference failed for: r11v4, types: [android.text.Spanned] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r20 = this;
            r1 = r20
            monitor-enter(r20)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x006b }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x006b }
            monitor-exit(r20)     // Catch:{ all -> 0x006b }
            com.paytmmall.clpartifact.modal.clpCommon.Item r0 = r1.mItem
            com.paytmmall.clpartifact.view.viewHolder.CLPItemRVViewHolder r6 = r1.mHandler
            r7 = 37
            long r7 = r7 & r2
            r9 = 33
            r11 = 0
            int r12 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x003c
            if (r0 == 0) goto L_0x001f
            java.lang.String r7 = r0.getImageUrl()
            goto L_0x0020
        L_0x001f:
            r7 = r11
        L_0x0020:
            if (r6 == 0) goto L_0x0027
            android.content.Context r6 = r6.getContext()
            goto L_0x0028
        L_0x0027:
            r6 = r11
        L_0x0028:
            long r13 = r2 & r9
            int r8 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x0038
            if (r0 == 0) goto L_0x0034
            java.lang.String r11 = r0.getName()
        L_0x0034:
            android.text.Spanned r11 = android.text.Html.fromHtml(r11)
        L_0x0038:
            r19 = r6
            r14 = r7
            goto L_0x003f
        L_0x003c:
            r14 = r11
            r19 = r14
        L_0x003f:
            r6 = 32
            long r6 = r6 & r2
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x004d
            android.widget.LinearLayout r0 = r1.mboundView0
            android.view.View$OnClickListener r6 = r1.mCallback75
            r0.setOnClickListener(r6)
        L_0x004d:
            long r2 = r2 & r9
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x005c
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r0 = r1.mboundView1
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r11)
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r0 = r1.mboundView1
            r0.setText(r11)
        L_0x005c:
            if (r12 == 0) goto L_0x006a
            android.widget.ImageView r13 = r1.mboundView2
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder.setImageUrl(r13, r14, r15, r16, r17, r18, r19)
        L_0x006a:
            return
        L_0x006b:
            r0 = move-exception
            monitor-exit(r20)     // Catch:{ all -> 0x006b }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.databinding.ItemActiveOrderBindingImpl.executeBindings():void");
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        CLPItemRVViewHolder cLPItemRVViewHolder = this.mHandler;
        Item item = this.mItem;
        Integer num = this.mPosition;
        if (cLPItemRVViewHolder != null) {
            cLPItemRVViewHolder.handleDeepLink(item, num.intValue());
        }
    }
}
