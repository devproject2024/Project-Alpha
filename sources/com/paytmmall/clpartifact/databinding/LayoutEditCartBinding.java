package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.customViews.CLPRobotoTextView;

public abstract class LayoutEditCartBinding extends ViewDataBinding {
    public final Button addItemBtn;
    public final CLPRobotoTextView itemCountTV;
    public final Button removeItemBtn;

    protected LayoutEditCartBinding(e eVar, View view, int i2, Button button, CLPRobotoTextView cLPRobotoTextView, Button button2) {
        super(eVar, view, i2);
        this.addItemBtn = button;
        this.itemCountTV = cLPRobotoTextView;
        this.removeItemBtn = button2;
    }

    public static LayoutEditCartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static LayoutEditCartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (LayoutEditCartBinding) f.a(layoutInflater, R.layout.layout_edit_cart, viewGroup, z, eVar);
    }

    public static LayoutEditCartBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static LayoutEditCartBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (LayoutEditCartBinding) f.a(layoutInflater, R.layout.layout_edit_cart, (ViewGroup) null, false, eVar);
    }

    public static LayoutEditCartBinding bind(View view) {
        return bind(view, f.a());
    }

    public static LayoutEditCartBinding bind(View view, e eVar) {
        return (LayoutEditCartBinding) bind(eVar, view, R.layout.layout_edit_cart);
    }
}
