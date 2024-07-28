package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.view.adapter.SmartGroupGridAdapter;
import com.paytmmall.clpartifact.view.viewmodel.NewSmartGroupVh;

public abstract class NewGroupGridRvBinding extends ViewDataBinding {
    public final RecyclerView expandGroup;
    public final LinearLayout llParent;
    protected SmartGroupGridAdapter mGroupAdapter;
    protected NewSmartGroupVh mHandler;
    protected View mView;
    public final TextView quickMoney;
    public final TextView showMore;

    public abstract void setGroupAdapter(SmartGroupGridAdapter smartGroupGridAdapter);

    public abstract void setHandler(NewSmartGroupVh newSmartGroupVh);

    public abstract void setView(View view);

    protected NewGroupGridRvBinding(e eVar, android.view.View view, int i2, RecyclerView recyclerView, LinearLayout linearLayout, TextView textView, TextView textView2) {
        super(eVar, view, i2);
        this.expandGroup = recyclerView;
        this.llParent = linearLayout;
        this.quickMoney = textView;
        this.showMore = textView2;
    }

    public SmartGroupGridAdapter getGroupAdapter() {
        return this.mGroupAdapter;
    }

    public View getView() {
        return this.mView;
    }

    public NewSmartGroupVh getHandler() {
        return this.mHandler;
    }

    public static NewGroupGridRvBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static NewGroupGridRvBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (NewGroupGridRvBinding) f.a(layoutInflater, R.layout.new_group_grid_rv, viewGroup, z, eVar);
    }

    public static NewGroupGridRvBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static NewGroupGridRvBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (NewGroupGridRvBinding) f.a(layoutInflater, R.layout.new_group_grid_rv, (ViewGroup) null, false, eVar);
    }

    public static NewGroupGridRvBinding bind(android.view.View view) {
        return bind(view, f.a());
    }

    public static NewGroupGridRvBinding bind(android.view.View view, e eVar) {
        return (NewGroupGridRvBinding) bind(eVar, view, R.layout.new_group_grid_rv);
    }
}
