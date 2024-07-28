package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.modal.clpCommon.Item;

public abstract class FloatingNavRvBinding extends ViewDataBinding {
    protected Item mItem;
    protected Integer mPosition;
    public final RecyclerView navRv;

    public abstract void setItem(Item item);

    public abstract void setPosition(Integer num);

    protected FloatingNavRvBinding(e eVar, View view, int i2, RecyclerView recyclerView) {
        super(eVar, view, i2);
        this.navRv = recyclerView;
    }

    public Item getItem() {
        return this.mItem;
    }

    public Integer getPosition() {
        return this.mPosition;
    }

    public static FloatingNavRvBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static FloatingNavRvBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (FloatingNavRvBinding) f.a(layoutInflater, R.layout.floating_nav_rv, viewGroup, z, eVar);
    }

    public static FloatingNavRvBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static FloatingNavRvBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (FloatingNavRvBinding) f.a(layoutInflater, R.layout.floating_nav_rv, (ViewGroup) null, false, eVar);
    }

    public static FloatingNavRvBinding bind(View view) {
        return bind(view, f.a());
    }

    public static FloatingNavRvBinding bind(View view, e eVar) {
        return (FloatingNavRvBinding) bind(eVar, view, R.layout.floating_nav_rv);
    }
}
