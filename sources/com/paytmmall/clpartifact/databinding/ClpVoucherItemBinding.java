package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;
import com.paytmmall.clpartifact.view.viewHolder.CLPVoucherRVViewHolder;

public abstract class ClpVoucherItemBinding extends ViewDataBinding {
    public final TextView CashbackVal;
    public final TextView Price;
    public final TextView Storeled;
    protected CLPVoucherRVViewHolder mHolder;
    protected CJRGridProduct mProduct;
    public final TextView viewMore;

    public abstract void setHolder(CLPVoucherRVViewHolder cLPVoucherRVViewHolder);

    public abstract void setProduct(CJRGridProduct cJRGridProduct);

    protected ClpVoucherItemBinding(e eVar, View view, int i2, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(eVar, view, i2);
        this.CashbackVal = textView;
        this.Price = textView2;
        this.Storeled = textView3;
        this.viewMore = textView4;
    }

    public CJRGridProduct getProduct() {
        return this.mProduct;
    }

    public CLPVoucherRVViewHolder getHolder() {
        return this.mHolder;
    }

    public static ClpVoucherItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ClpVoucherItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ClpVoucherItemBinding) f.a(layoutInflater, R.layout.clp_voucher_item, viewGroup, z, eVar);
    }

    public static ClpVoucherItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ClpVoucherItemBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ClpVoucherItemBinding) f.a(layoutInflater, R.layout.clp_voucher_item, (ViewGroup) null, false, eVar);
    }

    public static ClpVoucherItemBinding bind(View view) {
        return bind(view, f.a());
    }

    public static ClpVoucherItemBinding bind(View view, e eVar) {
        return (ClpVoucherItemBinding) bind(eVar, view, R.layout.clp_voucher_item);
    }
}
