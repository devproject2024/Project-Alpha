package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.utils.PopupUtils;

public abstract class ClpCustomDialogBinding extends ViewDataBinding {
    protected PopupUtils.DialogDataModel mDialogDataModel;
    public final TextView txvCancel;
    public final TextView txvContent;
    public final TextView txvOk;
    public final TextView txvTitle;

    public abstract void setDialogDataModel(PopupUtils.DialogDataModel dialogDataModel);

    protected ClpCustomDialogBinding(e eVar, View view, int i2, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(eVar, view, i2);
        this.txvCancel = textView;
        this.txvContent = textView2;
        this.txvOk = textView3;
        this.txvTitle = textView4;
    }

    public PopupUtils.DialogDataModel getDialogDataModel() {
        return this.mDialogDataModel;
    }

    public static ClpCustomDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ClpCustomDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ClpCustomDialogBinding) f.a(layoutInflater, R.layout.clp_custom_dialog, viewGroup, z, eVar);
    }

    public static ClpCustomDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ClpCustomDialogBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ClpCustomDialogBinding) f.a(layoutInflater, R.layout.clp_custom_dialog, (ViewGroup) null, false, eVar);
    }

    public static ClpCustomDialogBinding bind(View view) {
        return bind(view, f.a());
    }

    public static ClpCustomDialogBinding bind(View view, e eVar) {
        return (ClpCustomDialogBinding) bind(eVar, view, R.layout.clp_custom_dialog);
    }
}
