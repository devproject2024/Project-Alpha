package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.view.viewHolder.CLPDealsVH;
import com.paytmmall.clpartifact.view.viewmodel.VoucherVHViewModel;

public abstract class ItemDeals2xnBinding extends ViewDataBinding {
    public final TextView dealsText;
    public final TextView header;
    protected CLPDealsVH mClickHandler;
    protected View mView;
    protected VoucherVHViewModel mViewModel;
    public final RecyclerView vouchers;

    public abstract void setClickHandler(CLPDealsVH cLPDealsVH);

    public abstract void setView(View view);

    public abstract void setViewModel(VoucherVHViewModel voucherVHViewModel);

    protected ItemDeals2xnBinding(e eVar, android.view.View view, int i2, TextView textView, TextView textView2, RecyclerView recyclerView) {
        super(eVar, view, i2);
        this.dealsText = textView;
        this.header = textView2;
        this.vouchers = recyclerView;
    }

    public View getView() {
        return this.mView;
    }

    public CLPDealsVH getClickHandler() {
        return this.mClickHandler;
    }

    public VoucherVHViewModel getViewModel() {
        return this.mViewModel;
    }

    public static ItemDeals2xnBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemDeals2xnBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemDeals2xnBinding) f.a(layoutInflater, R.layout.item_deals_2xn, viewGroup, z, eVar);
    }

    public static ItemDeals2xnBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemDeals2xnBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemDeals2xnBinding) f.a(layoutInflater, R.layout.item_deals_2xn, (ViewGroup) null, false, eVar);
    }

    public static ItemDeals2xnBinding bind(android.view.View view) {
        return bind(view, f.a());
    }

    public static ItemDeals2xnBinding bind(android.view.View view, e eVar) {
        return (ItemDeals2xnBinding) bind(eVar, view, R.layout.item_deals_2xn);
    }
}
