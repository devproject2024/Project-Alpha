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
import com.paytmmall.clpartifact.utils.PopupUtils;

public class ClpCustomDialogBindingImpl extends ClpCustomDialogBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback25;
    private final View.OnClickListener mCallback26;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public ClpCustomDialogBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 5, sIncludes, sViewsWithIds));
    }

    private ClpCustomDialogBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[3], objArr[2], objArr[4], objArr[1]);
        this.mDirtyFlags = -1;
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.txvCancel.setTag((Object) null);
        this.txvContent.setTag((Object) null);
        this.txvOk.setTag((Object) null);
        this.txvTitle.setTag((Object) null);
        setRootTag(view);
        this.mCallback25 = new OnClickListener(this, 1);
        this.mCallback26 = new OnClickListener(this, 2);
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
        if (BR.dialogDataModel != i2) {
            return false;
        }
        setDialogDataModel((PopupUtils.DialogDataModel) obj);
        return true;
    }

    public void setDialogDataModel(PopupUtils.DialogDataModel dialogDataModel) {
        this.mDialogDataModel = dialogDataModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.dialogDataModel);
        super.requestRebind();
    }

    public void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        boolean z;
        boolean z2;
        String str4;
        PopupUtils.IOkListener iOkListener;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        PopupUtils.DialogDataModel dialogDataModel = this.mDialogDataModel;
        boolean z3 = true;
        String str5 = null;
        int i2 = 0;
        int i3 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i3 != 0) {
            if (dialogDataModel != null) {
                str5 = dialogDataModel.getOkButton();
                str3 = dialogDataModel.getTitle();
                str2 = dialogDataModel.getContent();
                str4 = dialogDataModel.getCancelButton();
                iOkListener = dialogDataModel.getOkListener();
            } else {
                iOkListener = null;
                str3 = null;
                str2 = null;
                str4 = null;
            }
            z = iOkListener == null;
            if (i3 != 0) {
                j = z ? j | 8 : j | 4;
            }
            str = str4;
        } else {
            str3 = null;
            str2 = null;
            str = null;
            z = false;
        }
        if ((4 & j) != 0) {
            z2 = TextUtils.isEmpty(str5);
        } else {
            z2 = false;
        }
        int i4 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i4 != 0) {
            if (!z) {
                z3 = z2;
            }
            if (i4 != 0) {
                j |= z3 ? 32 : 16;
            }
            if (z3) {
                i2 = 8;
            }
        }
        if ((2 & j) != 0) {
            this.txvCancel.setOnClickListener(this.mCallback25);
            this.txvOk.setOnClickListener(this.mCallback26);
        }
        if ((j & 3) != 0) {
            d.a(this.txvCancel, (CharSequence) str);
            d.a(this.txvContent, (CharSequence) str2);
            d.a(this.txvOk, (CharSequence) str5);
            this.txvOk.setVisibility(i2);
            d.a(this.txvTitle, (CharSequence) str3);
        }
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        boolean z = false;
        if (i2 == 1) {
            PopupUtils.DialogDataModel dialogDataModel = this.mDialogDataModel;
            if (dialogDataModel != null) {
                PopupUtils.ICancelListener cancelListener = dialogDataModel.getCancelListener();
                if (cancelListener != null) {
                    z = true;
                }
                if (z) {
                    cancelListener.onCancelClick();
                }
            }
        } else if (i2 == 2) {
            PopupUtils.DialogDataModel dialogDataModel2 = this.mDialogDataModel;
            if (dialogDataModel2 != null) {
                PopupUtils.IOkListener okListener = dialogDataModel2.getOkListener();
                if (okListener != null) {
                    z = true;
                }
                if (z) {
                    okListener.onOkClick();
                }
            }
        }
    }
}
