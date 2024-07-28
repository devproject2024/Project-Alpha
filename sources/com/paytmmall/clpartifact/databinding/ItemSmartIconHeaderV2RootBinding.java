package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.view.adapter.CLPItemRVAdapter;
import com.paytmmall.clpartifact.view.viewHolder.SmartIconHeaderV2RootVH;

public abstract class ItemSmartIconHeaderV2RootBinding extends ViewDataBinding {
    public final ImageView bannerImage;
    public final ImageView footerView;
    public final ImageView imageLogo;
    protected CLPItemRVAdapter mAdapter;
    protected SmartIconHeaderV2RootVH mHandler;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected Boolean mTitle;
    protected View mView;
    public final ConstraintLayout mainLayout;
    public final RecyclerView recoRv;
    public final RecyclerView smartIconsV2Rv;
    public final TextView subtitle;
    public final TextView title;
    public final Group topLayoutGroup;

    public abstract void setAdapter(CLPItemRVAdapter cLPItemRVAdapter);

    public abstract void setHandler(SmartIconHeaderV2RootVH smartIconHeaderV2RootVH);

    public abstract void setLayoutManager(RecyclerView.LayoutManager layoutManager);

    public abstract void setTitle(Boolean bool);

    public abstract void setView(View view);

    protected ItemSmartIconHeaderV2RootBinding(e eVar, android.view.View view, int i2, ImageView imageView, ImageView imageView2, ImageView imageView3, ConstraintLayout constraintLayout, RecyclerView recyclerView, RecyclerView recyclerView2, TextView textView, TextView textView2, Group group) {
        super(eVar, view, i2);
        this.bannerImage = imageView;
        this.footerView = imageView2;
        this.imageLogo = imageView3;
        this.mainLayout = constraintLayout;
        this.recoRv = recyclerView;
        this.smartIconsV2Rv = recyclerView2;
        this.subtitle = textView;
        this.title = textView2;
        this.topLayoutGroup = group;
    }

    public Boolean getTitle() {
        return this.mTitle;
    }

    public View getView() {
        return this.mView;
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return this.mLayoutManager;
    }

    public CLPItemRVAdapter getAdapter() {
        return this.mAdapter;
    }

    public SmartIconHeaderV2RootVH getHandler() {
        return this.mHandler;
    }

    public static ItemSmartIconHeaderV2RootBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemSmartIconHeaderV2RootBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemSmartIconHeaderV2RootBinding) f.a(layoutInflater, R.layout.item_smart_icon_header_v2_root, viewGroup, z, eVar);
    }

    public static ItemSmartIconHeaderV2RootBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemSmartIconHeaderV2RootBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemSmartIconHeaderV2RootBinding) f.a(layoutInflater, R.layout.item_smart_icon_header_v2_root, (ViewGroup) null, false, eVar);
    }

    public static ItemSmartIconHeaderV2RootBinding bind(android.view.View view) {
        return bind(view, f.a());
    }

    public static ItemSmartIconHeaderV2RootBinding bind(android.view.View view, e eVar) {
        return (ItemSmartIconHeaderV2RootBinding) bind(eVar, view, R.layout.item_smart_icon_header_v2_root);
    }
}
