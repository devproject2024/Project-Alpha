package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.customViews.CLPRobotoTextView;
import com.paytmmall.clpartifact.modal.grid.CJRFrontEndFilterItem;
import com.paytmmall.clpartifact.view.adapter.CategoryFilterValuesAdapter;

public abstract class ItemFilterCategoryBinding extends ViewDataBinding {
    public final CLPRobotoTextView categoryName;
    public final CLPRobotoTextView itemCount;
    protected CategoryFilterValuesAdapter.CategoryFilterValuesItemHolder mHandler;
    protected CJRFrontEndFilterItem mItem;
    protected Integer mPosition;
    public final ImageView selectedImage;

    public abstract void setHandler(CategoryFilterValuesAdapter.CategoryFilterValuesItemHolder categoryFilterValuesItemHolder);

    public abstract void setItem(CJRFrontEndFilterItem cJRFrontEndFilterItem);

    public abstract void setPosition(Integer num);

    protected ItemFilterCategoryBinding(e eVar, View view, int i2, CLPRobotoTextView cLPRobotoTextView, CLPRobotoTextView cLPRobotoTextView2, ImageView imageView) {
        super(eVar, view, i2);
        this.categoryName = cLPRobotoTextView;
        this.itemCount = cLPRobotoTextView2;
        this.selectedImage = imageView;
    }

    public Integer getPosition() {
        return this.mPosition;
    }

    public CJRFrontEndFilterItem getItem() {
        return this.mItem;
    }

    public CategoryFilterValuesAdapter.CategoryFilterValuesItemHolder getHandler() {
        return this.mHandler;
    }

    public static ItemFilterCategoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemFilterCategoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemFilterCategoryBinding) f.a(layoutInflater, R.layout.item_filter_category, viewGroup, z, eVar);
    }

    public static ItemFilterCategoryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemFilterCategoryBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemFilterCategoryBinding) f.a(layoutInflater, R.layout.item_filter_category, (ViewGroup) null, false, eVar);
    }

    public static ItemFilterCategoryBinding bind(View view) {
        return bind(view, f.a());
    }

    public static ItemFilterCategoryBinding bind(View view, e eVar) {
        return (ItemFilterCategoryBinding) bind(eVar, view, R.layout.item_filter_category);
    }
}
