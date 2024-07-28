package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.view.viewHolder.CLPItemVHWithoutRV;

public abstract class ItemSearchWidgetBinding extends ViewDataBinding {
    public final ImageView image;
    protected CLPItemVHWithoutRV mHandler;
    protected Integer mPosition;
    protected View mView;
    public final TextView subtitle;
    public final TextView title;

    public abstract void setHandler(CLPItemVHWithoutRV cLPItemVHWithoutRV);

    public abstract void setPosition(Integer num);

    public abstract void setView(View view);

    protected ItemSearchWidgetBinding(e eVar, android.view.View view, int i2, ImageView imageView, TextView textView, TextView textView2) {
        super(eVar, view, i2);
        this.image = imageView;
        this.subtitle = textView;
        this.title = textView2;
    }

    public View getView() {
        return this.mView;
    }

    public CLPItemVHWithoutRV getHandler() {
        return this.mHandler;
    }

    public Integer getPosition() {
        return this.mPosition;
    }

    public static ItemSearchWidgetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemSearchWidgetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemSearchWidgetBinding) f.a(layoutInflater, R.layout.item_search_widget, viewGroup, z, eVar);
    }

    public static ItemSearchWidgetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemSearchWidgetBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemSearchWidgetBinding) f.a(layoutInflater, R.layout.item_search_widget, (ViewGroup) null, false, eVar);
    }

    public static ItemSearchWidgetBinding bind(android.view.View view) {
        return bind(view, f.a());
    }

    public static ItemSearchWidgetBinding bind(android.view.View view, e eVar) {
        return (ItemSearchWidgetBinding) bind(eVar, view, R.layout.item_search_widget);
    }
}
