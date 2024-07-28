package com.paytmmall.clpartifact.databinding;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.databinding.h;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.view.viewHolder.CLPItemRVViewHolder;
import com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder;
import com.paytmmall.clpartifact.view.viewbindings.CommonViewBindings;

public class SfItemTiBindingImpl extends SfItemTiBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback52;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.dividerView, 8);
    }

    public SfItemTiBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 9, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private SfItemTiBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 1, objArr[3], objArr[6], objArr[8], objArr[1], objArr[2], objArr[0], objArr[5], objArr[4], objArr[7]);
        this.mDirtyFlags = -1;
        this.altIcon.setTag((Object) null);
        this.backArrow.setTag((Object) null);
        this.icon.setTag((Object) null);
        this.name.setTag((Object) null);
        this.rootLayout.setTag((Object) null);
        this.subTitle.setTag((Object) null);
        this.title.setTag((Object) null);
        this.tvLabel.setTag((Object) null);
        setRootTag(view);
        this.mCallback52 = new OnClickListener(this, 1);
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
            setHandler((CLPItemRVViewHolder) obj);
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

    public void setHandler(CLPItemRVViewHolder cLPItemRVViewHolder) {
        this.mHandler = cLPItemRVViewHolder;
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
        int i2;
        long j2;
        String str;
        String str2;
        String str3;
        float f2;
        int i3;
        String str4;
        String str5;
        Context context;
        boolean z;
        String str6;
        int i4;
        String str7;
        boolean z2;
        int i5;
        String str8;
        String str9;
        float f3;
        int i6;
        String str10;
        String str11;
        String str12;
        Item.LayoutData layoutData;
        long j3;
        long j4;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Item item = this.mItem;
        CLPItemRVViewHolder cLPItemRVViewHolder = this.mHandler;
        String str13 = null;
        int i7 = 0;
        if ((j & 11) != 0) {
            if (item != null) {
                str9 = item.getImageUrl();
                str8 = item.getAltImageUrl();
                str3 = item.getParentImageUrl();
            } else {
                str9 = null;
                str8 = null;
                str3 = null;
            }
            Context context2 = cLPItemRVViewHolder != null ? cLPItemRVViewHolder.getContext() : null;
            int i8 = ((j & 9) > 0 ? 1 : ((j & 9) == 0 ? 0 : -1));
            if (i8 != 0) {
                boolean isEmpty = TextUtils.isEmpty(str8);
                boolean isEmpty2 = TextUtils.isEmpty(str3);
                if (i8 != 0) {
                    if (isEmpty) {
                        j4 = j | 32;
                        j3 = 8192;
                    } else {
                        j4 = j | 16;
                        j3 = 4096;
                    }
                    j = j4 | j3;
                }
                f3 = isEmpty ? this.title.getResources().getDimension(R.dimen.dimen_0dp) : this.title.getResources().getDimension(R.dimen.dimen_6dp);
                i6 = isEmpty ? 4 : 0;
                z = !isEmpty2;
                if ((j & 9) != 0) {
                    j = z ? j | 32768 : j | 16384;
                }
            } else {
                i6 = 0;
                f3 = 0.0f;
                z = false;
            }
            int i9 = ((j & 9) > 0 ? 1 : ((j & 9) == 0 ? 0 : -1));
            if (i9 != 0) {
                if (item != null) {
                    str12 = item.getItemSubtitle();
                    str11 = item.getTitle();
                    str10 = item.getName();
                    layoutData = item.mLayout;
                } else {
                    layoutData = null;
                    str12 = null;
                    str11 = null;
                    str10 = null;
                }
                boolean isEmpty3 = TextUtils.isEmpty(str12);
                boolean isEmpty4 = TextUtils.isEmpty(str11);
                if (i9 != 0) {
                    j |= isEmpty3 ? 512 : 256;
                }
                if ((j & 9) != 0) {
                    j |= isEmpty4 ? 128 : 64;
                }
                if (layoutData != null) {
                    str4 = layoutData.mLabel;
                } else {
                    str4 = null;
                }
                i3 = isEmpty3 ? 8 : 0;
                str = str8;
                i2 = isEmpty4 ? 4 : 0;
                str5 = str10;
                j2 = 32768;
                f2 = f3;
                str2 = str9;
                str6 = str11;
                context = context2;
                i4 = i6;
                str7 = str12;
            } else {
                f2 = f3;
                str2 = str9;
                str = str8;
                j2 = 32768;
                str6 = null;
                str5 = null;
                str4 = null;
                i3 = 0;
                i2 = 0;
                context = context2;
                i4 = i6;
                str7 = null;
            }
        } else {
            j2 = 32768;
            str7 = null;
            str6 = null;
            context = null;
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            i4 = 0;
            z = false;
            i3 = 0;
            f2 = 0.0f;
            i2 = 0;
        }
        if ((j & j2) != 0) {
            if (item != null) {
                str13 = item.getMUrl();
            }
            z2 = !TextUtils.isEmpty(str13);
        } else {
            z2 = false;
        }
        int i10 = ((j & 9) > 0 ? 1 : ((j & 9) == 0 ? 0 : -1));
        if (i10 != 0) {
            if (!z) {
                z2 = false;
            }
            if (i10 != 0) {
                j |= z2 ? 2048 : 1024;
            }
            if (!z2) {
                i7 = 4;
            }
            i5 = i7;
        } else {
            i5 = 0;
        }
        if ((9 & j) != 0) {
            this.altIcon.setVisibility(i4);
            this.backArrow.setVisibility(i5);
            d.a(this.name, (CharSequence) str5);
            d.a(this.subTitle, (CharSequence) str7);
            this.subTitle.setVisibility(i3);
            d.a(this.title, (CharSequence) str6);
            TextView textView = this.title;
            textView.setPadding(androidx.databinding.a.e.a(f2), textView.getPaddingTop(), textView.getPaddingRight(), textView.getPaddingBottom());
            this.title.setVisibility(i2);
            d.a(this.tvLabel, (CharSequence) str4);
            CommonViewBindings.setTagData(this.tvLabel, item);
        }
        if ((11 & j) != 0) {
            ClickableRVChildViewHolder.setImageUrl(this.altIcon, str, 0, false, false, 0, context);
            ClickableRVChildViewHolder.setImageUrl(this.backArrow, str3, 0, false, false, 0, context);
            ClickableRVChildViewHolder.setImageUrl(this.icon, str2, 0, false, false, 0, context);
        }
        if ((j & 8) != 0) {
            this.rootLayout.setOnClickListener(this.mCallback52);
        }
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
