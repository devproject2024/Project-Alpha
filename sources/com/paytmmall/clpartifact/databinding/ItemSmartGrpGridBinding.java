package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytm.ads.PaytmAdView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.customViews.CLPRobotoTextView;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.view.viewHolder.SmartGroupItemVH;

public abstract class ItemSmartGrpGridBinding extends ViewDataBinding {
    public final CLPRobotoTextView categoryTitle;
    public final PaytmAdView groupImageView;
    public final View grpItem;
    public final ImageView icRaises;
    protected SmartGroupItemVH mHandler;
    protected Item mItem;
    protected Integer mPosition;
    public final TextView textView;
    public final TextView tvLabel;

    public abstract void setHandler(SmartGroupItemVH smartGroupItemVH);

    public abstract void setItem(Item item);

    public abstract void setPosition(Integer num);

    protected ItemSmartGrpGridBinding(e eVar, View view, int i2, CLPRobotoTextView cLPRobotoTextView, PaytmAdView paytmAdView, View view2, ImageView imageView, TextView textView2, TextView textView3) {
        super(eVar, view, i2);
        this.categoryTitle = cLPRobotoTextView;
        this.groupImageView = paytmAdView;
        this.grpItem = view2;
        this.icRaises = imageView;
        this.textView = textView2;
        this.tvLabel = textView3;
    }

    public Item getItem() {
        return this.mItem;
    }

    public SmartGroupItemVH getHandler() {
        return this.mHandler;
    }

    public Integer getPosition() {
        return this.mPosition;
    }

    public static ItemSmartGrpGridBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemSmartGrpGridBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemSmartGrpGridBinding) f.a(layoutInflater, R.layout.item_smart_grp_grid, viewGroup, z, eVar);
    }

    public static ItemSmartGrpGridBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemSmartGrpGridBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemSmartGrpGridBinding) f.a(layoutInflater, R.layout.item_smart_grp_grid, (ViewGroup) null, false, eVar);
    }

    public static ItemSmartGrpGridBinding bind(View view) {
        return bind(view, f.a());
    }

    public static ItemSmartGrpGridBinding bind(View view, e eVar) {
        return (ItemSmartGrpGridBinding) bind(eVar, view, R.layout.item_smart_grp_grid);
    }
}
