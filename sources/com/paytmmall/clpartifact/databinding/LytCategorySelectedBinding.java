package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.view.actions.ICategoryClickListener;

public abstract class LytCategorySelectedBinding extends ViewDataBinding {
    protected String mCategory;
    protected ICategoryClickListener mHandler;
    protected Boolean mIsSelected;
    protected Integer mPosition;
    public final TextView txvCategory;

    public abstract void setCategory(String str);

    public abstract void setHandler(ICategoryClickListener iCategoryClickListener);

    public abstract void setIsSelected(Boolean bool);

    public abstract void setPosition(Integer num);

    protected LytCategorySelectedBinding(e eVar, View view, int i2, TextView textView) {
        super(eVar, view, i2);
        this.txvCategory = textView;
    }

    public Boolean getIsSelected() {
        return this.mIsSelected;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public ICategoryClickListener getHandler() {
        return this.mHandler;
    }

    public Integer getPosition() {
        return this.mPosition;
    }

    public static LytCategorySelectedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static LytCategorySelectedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (LytCategorySelectedBinding) f.a(layoutInflater, R.layout.lyt_category_selected, viewGroup, z, eVar);
    }

    public static LytCategorySelectedBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static LytCategorySelectedBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (LytCategorySelectedBinding) f.a(layoutInflater, R.layout.lyt_category_selected, (ViewGroup) null, false, eVar);
    }

    public static LytCategorySelectedBinding bind(View view) {
        return bind(view, f.a());
    }

    public static LytCategorySelectedBinding bind(View view, e eVar) {
        return (LytCategorySelectedBinding) bind(eVar, view, R.layout.lyt_category_selected);
    }
}
