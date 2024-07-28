package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.customViews.CLPRobotoTextView;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.view.adapter.CLPRecoListAdapter;
import com.paytmmall.clpartifact.view.viewHolder.CLPRecoListVH;

public abstract class ItemRecoMainLytBinding extends ViewDataBinding {
    public final RecyclerView expandGroup;
    protected CLPRecoListAdapter mGroupAdapter;
    protected CLPRecoListVH mHandler;
    protected Boolean mIsCollapsed;
    protected View mView;
    public final ConstraintLayout mainLayout;
    public final RecyclerView recoRv;
    public final CLPRobotoTextView subTitle;
    public final LinearLayout textLayout;
    public final CLPRobotoTextView title;
    public final ImageView upArrowImg;

    public abstract void setGroupAdapter(CLPRecoListAdapter cLPRecoListAdapter);

    public abstract void setHandler(CLPRecoListVH cLPRecoListVH);

    public abstract void setIsCollapsed(Boolean bool);

    public abstract void setView(View view);

    protected ItemRecoMainLytBinding(e eVar, android.view.View view, int i2, RecyclerView recyclerView, ConstraintLayout constraintLayout, RecyclerView recyclerView2, CLPRobotoTextView cLPRobotoTextView, LinearLayout linearLayout, CLPRobotoTextView cLPRobotoTextView2, ImageView imageView) {
        super(eVar, view, i2);
        this.expandGroup = recyclerView;
        this.mainLayout = constraintLayout;
        this.recoRv = recyclerView2;
        this.subTitle = cLPRobotoTextView;
        this.textLayout = linearLayout;
        this.title = cLPRobotoTextView2;
        this.upArrowImg = imageView;
    }

    public CLPRecoListAdapter getGroupAdapter() {
        return this.mGroupAdapter;
    }

    public View getView() {
        return this.mView;
    }

    public CLPRecoListVH getHandler() {
        return this.mHandler;
    }

    public Boolean getIsCollapsed() {
        return this.mIsCollapsed;
    }

    public static ItemRecoMainLytBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemRecoMainLytBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemRecoMainLytBinding) f.a(layoutInflater, R.layout.item_reco_main_lyt, viewGroup, z, eVar);
    }

    public static ItemRecoMainLytBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemRecoMainLytBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemRecoMainLytBinding) f.a(layoutInflater, R.layout.item_reco_main_lyt, (ViewGroup) null, false, eVar);
    }

    public static ItemRecoMainLytBinding bind(android.view.View view) {
        return bind(view, f.a());
    }

    public static ItemRecoMainLytBinding bind(android.view.View view, e eVar) {
        return (ItemRecoMainLytBinding) bind(eVar, view, R.layout.item_reco_main_lyt);
    }
}
