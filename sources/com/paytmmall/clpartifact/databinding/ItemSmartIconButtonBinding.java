package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytm.ads.PaytmAdView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.view.viewHolder.CLPItemRVViewHolder;

public abstract class ItemSmartIconButtonBinding extends ViewDataBinding {
    public final PaytmAdView buttonIcon;
    public final TextView buttonText;
    public final LinearLayout cashbackView;
    protected CLPItemRVViewHolder mHandler;
    protected Item mItem;
    protected Integer mPosition;

    public abstract void setHandler(CLPItemRVViewHolder cLPItemRVViewHolder);

    public abstract void setItem(Item item);

    public abstract void setPosition(Integer num);

    protected ItemSmartIconButtonBinding(e eVar, View view, int i2, PaytmAdView paytmAdView, TextView textView, LinearLayout linearLayout) {
        super(eVar, view, i2);
        this.buttonIcon = paytmAdView;
        this.buttonText = textView;
        this.cashbackView = linearLayout;
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

    public static ItemSmartIconButtonBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemSmartIconButtonBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemSmartIconButtonBinding) f.a(layoutInflater, R.layout.item_smart_icon_button, viewGroup, z, eVar);
    }

    public static ItemSmartIconButtonBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemSmartIconButtonBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemSmartIconButtonBinding) f.a(layoutInflater, R.layout.item_smart_icon_button, (ViewGroup) null, false, eVar);
    }

    public static ItemSmartIconButtonBinding bind(View view) {
        return bind(view, f.a());
    }

    public static ItemSmartIconButtonBinding bind(View view, e eVar) {
        return (ItemSmartIconButtonBinding) bind(eVar, view, R.layout.item_smart_icon_button);
    }
}
