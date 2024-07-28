package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.view.viewHolder.CLPCarousel4X;

public abstract class ItemReco4xRvBinding extends ViewDataBinding {
    public final RecyclerView expandGroup4x;
    protected CLPCarousel4X mHandler;
    protected Boolean mIsCollapsed;
    protected Boolean mShowMoreVisibility;
    protected View mView;
    public final ConstraintLayout mainLayout;
    public final AppCompatTextView showMore;

    public abstract void setHandler(CLPCarousel4X cLPCarousel4X);

    public abstract void setIsCollapsed(Boolean bool);

    public abstract void setShowMoreVisibility(Boolean bool);

    public abstract void setView(View view);

    protected ItemReco4xRvBinding(e eVar, android.view.View view, int i2, RecyclerView recyclerView, ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView) {
        super(eVar, view, i2);
        this.expandGroup4x = recyclerView;
        this.mainLayout = constraintLayout;
        this.showMore = appCompatTextView;
    }

    public View getView() {
        return this.mView;
    }

    public CLPCarousel4X getHandler() {
        return this.mHandler;
    }

    public Boolean getShowMoreVisibility() {
        return this.mShowMoreVisibility;
    }

    public Boolean getIsCollapsed() {
        return this.mIsCollapsed;
    }

    public static ItemReco4xRvBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemReco4xRvBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemReco4xRvBinding) f.a(layoutInflater, R.layout.item_reco_4x_rv, viewGroup, z, eVar);
    }

    public static ItemReco4xRvBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemReco4xRvBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemReco4xRvBinding) f.a(layoutInflater, R.layout.item_reco_4x_rv, (ViewGroup) null, false, eVar);
    }

    public static ItemReco4xRvBinding bind(android.view.View view) {
        return bind(view, f.a());
    }

    public static ItemReco4xRvBinding bind(android.view.View view, e eVar) {
        return (ItemReco4xRvBinding) bind(eVar, view, R.layout.item_reco_4x_rv);
    }
}
