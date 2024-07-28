package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.view.viewHolder.CLPItemVHWithoutRV;

public abstract class ItemCollageThreexnBinding extends ViewDataBinding {
    protected CLPItemVHWithoutRV mHandler;
    protected View mView;

    public abstract void setHandler(CLPItemVHWithoutRV cLPItemVHWithoutRV);

    public abstract void setView(View view);

    protected ItemCollageThreexnBinding(e eVar, android.view.View view, int i2) {
        super(eVar, view, i2);
    }

    public View getView() {
        return this.mView;
    }

    public CLPItemVHWithoutRV getHandler() {
        return this.mHandler;
    }

    public static ItemCollageThreexnBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemCollageThreexnBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemCollageThreexnBinding) f.a(layoutInflater, R.layout.item_collage_threexn, viewGroup, z, eVar);
    }

    public static ItemCollageThreexnBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemCollageThreexnBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemCollageThreexnBinding) f.a(layoutInflater, R.layout.item_collage_threexn, (ViewGroup) null, false, eVar);
    }

    public static ItemCollageThreexnBinding bind(android.view.View view) {
        return bind(view, f.a());
    }

    public static ItemCollageThreexnBinding bind(android.view.View view, e eVar) {
        return (ItemCollageThreexnBinding) bind(eVar, view, R.layout.item_collage_threexn);
    }
}
