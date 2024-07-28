package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.customViews.CLPRobotoTextView;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.view.viewHolder.CLPNewSmartHeaderVH;

public abstract class ItemNewSmartHeaderDynBinding extends ViewDataBinding {
    public final ImageView gridImage1;
    public final CLPRobotoTextView gridText1;
    public final ConstraintLayout iconContainer;
    public final View imageContainer1;
    protected CLPNewSmartHeaderVH mHandler;
    protected Item mItem;
    protected Integer mPosition;

    public abstract void setHandler(CLPNewSmartHeaderVH cLPNewSmartHeaderVH);

    public abstract void setItem(Item item);

    public abstract void setPosition(Integer num);

    protected ItemNewSmartHeaderDynBinding(e eVar, View view, int i2, ImageView imageView, CLPRobotoTextView cLPRobotoTextView, ConstraintLayout constraintLayout, View view2) {
        super(eVar, view, i2);
        this.gridImage1 = imageView;
        this.gridText1 = cLPRobotoTextView;
        this.iconContainer = constraintLayout;
        this.imageContainer1 = view2;
    }

    public Item getItem() {
        return this.mItem;
    }

    public CLPNewSmartHeaderVH getHandler() {
        return this.mHandler;
    }

    public Integer getPosition() {
        return this.mPosition;
    }

    public static ItemNewSmartHeaderDynBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemNewSmartHeaderDynBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemNewSmartHeaderDynBinding) f.a(layoutInflater, R.layout.item_new_smart_header_dyn, viewGroup, z, eVar);
    }

    public static ItemNewSmartHeaderDynBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemNewSmartHeaderDynBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemNewSmartHeaderDynBinding) f.a(layoutInflater, R.layout.item_new_smart_header_dyn, (ViewGroup) null, false, eVar);
    }

    public static ItemNewSmartHeaderDynBinding bind(View view) {
        return bind(view, f.a());
    }

    public static ItemNewSmartHeaderDynBinding bind(View view, e eVar) {
        return (ItemNewSmartHeaderDynBinding) bind(eVar, view, R.layout.item_new_smart_header_dyn);
    }
}
