package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.customViews.CLPRobotoTextView;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.view.viewHolder.CLPItemRVViewHolder;

public abstract class ItemSmartIconHeaderBinding extends ViewDataBinding {
    public final ImageView gridImage1;
    public final ImageView gridImage2;
    public final ImageView gridImage3;
    public final CLPRobotoTextView gridText1;
    public final CLPRobotoTextView gridText2;
    public final CLPRobotoTextView gridText3;
    public final Guideline guideline33;
    public final Guideline guideline66;
    public final ImageView icRaises1;
    public final ImageView icRaises2;
    public final ImageView icRaises3;
    public final View imageContainer1;
    public final View imageContainer2;
    public final View imageContainer3;
    protected CLPItemRVViewHolder mHandler;
    protected Item mItem;
    protected Integer mPosition;
    public final TextView tvLabel1;
    public final TextView tvLabel2;
    public final TextView tvLabel3;

    public abstract void setHandler(CLPItemRVViewHolder cLPItemRVViewHolder);

    public abstract void setItem(Item item);

    public abstract void setPosition(Integer num);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected ItemSmartIconHeaderBinding(e eVar, View view, int i2, ImageView imageView, ImageView imageView2, ImageView imageView3, CLPRobotoTextView cLPRobotoTextView, CLPRobotoTextView cLPRobotoTextView2, CLPRobotoTextView cLPRobotoTextView3, Guideline guideline, Guideline guideline2, ImageView imageView4, ImageView imageView5, ImageView imageView6, View view2, View view3, View view4, TextView textView, TextView textView2, TextView textView3) {
        super(eVar, view, i2);
        this.gridImage1 = imageView;
        this.gridImage2 = imageView2;
        this.gridImage3 = imageView3;
        this.gridText1 = cLPRobotoTextView;
        this.gridText2 = cLPRobotoTextView2;
        this.gridText3 = cLPRobotoTextView3;
        this.guideline33 = guideline;
        this.guideline66 = guideline2;
        this.icRaises1 = imageView4;
        this.icRaises2 = imageView5;
        this.icRaises3 = imageView6;
        this.imageContainer1 = view2;
        this.imageContainer2 = view3;
        this.imageContainer3 = view4;
        this.tvLabel1 = textView;
        this.tvLabel2 = textView2;
        this.tvLabel3 = textView3;
    }

    public Item getItem() {
        return this.mItem;
    }

    public CLPItemRVViewHolder getHandler() {
        return this.mHandler;
    }

    public Integer getPosition() {
        return this.mPosition;
    }

    public static ItemSmartIconHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemSmartIconHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemSmartIconHeaderBinding) f.a(layoutInflater, R.layout.item_smart_icon_header, viewGroup, z, eVar);
    }

    public static ItemSmartIconHeaderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemSmartIconHeaderBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemSmartIconHeaderBinding) f.a(layoutInflater, R.layout.item_smart_icon_header, (ViewGroup) null, false, eVar);
    }

    public static ItemSmartIconHeaderBinding bind(View view) {
        return bind(view, f.a());
    }

    public static ItemSmartIconHeaderBinding bind(View view, e eVar) {
        return (ItemSmartIconHeaderBinding) bind(eVar, view, R.layout.item_smart_icon_header);
    }
}
