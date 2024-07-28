package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.modal.clpCommon.Item;

public abstract class ItemDefaultBinding extends ViewDataBinding {
    public final TextView defaultText;
    public final ConstraintLayout linearLayout;
    protected Item mDefaultItemData;

    public abstract void setDefaultItemData(Item item);

    protected ItemDefaultBinding(e eVar, View view, int i2, TextView textView, ConstraintLayout constraintLayout) {
        super(eVar, view, i2);
        this.defaultText = textView;
        this.linearLayout = constraintLayout;
    }

    public Item getDefaultItemData() {
        return this.mDefaultItemData;
    }

    public static ItemDefaultBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemDefaultBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemDefaultBinding) f.a(layoutInflater, R.layout.item_default, viewGroup, z, eVar);
    }

    public static ItemDefaultBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemDefaultBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemDefaultBinding) f.a(layoutInflater, R.layout.item_default, (ViewGroup) null, false, eVar);
    }

    public static ItemDefaultBinding bind(View view) {
        return bind(view, f.a());
    }

    public static ItemDefaultBinding bind(View view, e eVar) {
        return (ItemDefaultBinding) bind(eVar, view, R.layout.item_default);
    }
}
