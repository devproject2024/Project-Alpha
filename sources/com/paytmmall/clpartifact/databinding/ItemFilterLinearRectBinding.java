package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.modal.grid.CJRFilterValue;
import com.paytmmall.clpartifact.view.adapter.FilterValuesAdapter;

public abstract class ItemFilterLinearRectBinding extends ViewDataBinding {
    public final View brandDivider;
    public final TextView brandLabel;
    public final ImageView colorImageView;
    public final TextView filterName;
    protected FilterValuesAdapter.FilterValuesItemHolder mHandler;
    protected Boolean mIsApplied;
    protected CJRFilterValue mItem;
    protected Integer mPosition;
    public final TextView numberCount;

    public abstract void setHandler(FilterValuesAdapter.FilterValuesItemHolder filterValuesItemHolder);

    public abstract void setIsApplied(Boolean bool);

    public abstract void setItem(CJRFilterValue cJRFilterValue);

    public abstract void setPosition(Integer num);

    protected ItemFilterLinearRectBinding(e eVar, View view, int i2, View view2, TextView textView, ImageView imageView, TextView textView2, TextView textView3) {
        super(eVar, view, i2);
        this.brandDivider = view2;
        this.brandLabel = textView;
        this.colorImageView = imageView;
        this.filterName = textView2;
        this.numberCount = textView3;
    }

    public Integer getPosition() {
        return this.mPosition;
    }

    public Boolean getIsApplied() {
        return this.mIsApplied;
    }

    public CJRFilterValue getItem() {
        return this.mItem;
    }

    public FilterValuesAdapter.FilterValuesItemHolder getHandler() {
        return this.mHandler;
    }

    public static ItemFilterLinearRectBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemFilterLinearRectBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemFilterLinearRectBinding) f.a(layoutInflater, R.layout.item_filter_linear_rect, viewGroup, z, eVar);
    }

    public static ItemFilterLinearRectBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemFilterLinearRectBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemFilterLinearRectBinding) f.a(layoutInflater, R.layout.item_filter_linear_rect, (ViewGroup) null, false, eVar);
    }

    public static ItemFilterLinearRectBinding bind(View view) {
        return bind(view, f.a());
    }

    public static ItemFilterLinearRectBinding bind(View view, e eVar) {
        return (ItemFilterLinearRectBinding) bind(eVar, view, R.layout.item_filter_linear_rect);
    }
}
