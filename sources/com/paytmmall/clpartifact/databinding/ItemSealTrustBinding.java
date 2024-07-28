package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.view.viewHolder.CLPItemVHWithoutRV;

public abstract class ItemSealTrustBinding extends ViewDataBinding {
    protected CLPItemVHWithoutRV mHandler;
    protected Integer mPosition;
    protected View mView;
    public final android.view.View separator;
    public final TextView trustSubtitle;
    public final TextView trustTitle;

    public abstract void setHandler(CLPItemVHWithoutRV cLPItemVHWithoutRV);

    public abstract void setPosition(Integer num);

    public abstract void setView(View view);

    protected ItemSealTrustBinding(e eVar, android.view.View view, int i2, android.view.View view2, TextView textView, TextView textView2) {
        super(eVar, view, i2);
        this.separator = view2;
        this.trustSubtitle = textView;
        this.trustTitle = textView2;
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

    public static ItemSealTrustBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemSealTrustBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemSealTrustBinding) f.a(layoutInflater, R.layout.item_seal_trust, viewGroup, z, eVar);
    }

    public static ItemSealTrustBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemSealTrustBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemSealTrustBinding) f.a(layoutInflater, R.layout.item_seal_trust, (ViewGroup) null, false, eVar);
    }

    public static ItemSealTrustBinding bind(android.view.View view) {
        return bind(view, f.a());
    }

    public static ItemSealTrustBinding bind(android.view.View view, e eVar) {
        return (ItemSealTrustBinding) bind(eVar, view, R.layout.item_seal_trust);
    }
}
