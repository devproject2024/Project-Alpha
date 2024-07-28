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
import com.paytmmall.clpartifact.customViews.CLPRobotoTextView;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.view.actions.ICategoryClickListener;

public abstract class LytCategoryItemBinding extends ViewDataBinding {
    public final CLPRobotoTextView categoryTitle;
    public final ImageView groupImageView;
    public final View grpItem;
    public final ImageView icRaises;
    protected ICategoryClickListener mHandler;
    protected Item mItem;
    protected Integer mPosition;
    public final TextView textView;
    public final TextView tvLabel;

    public abstract void setHandler(ICategoryClickListener iCategoryClickListener);

    public abstract void setItem(Item item);

    public abstract void setPosition(Integer num);

    protected LytCategoryItemBinding(e eVar, View view, int i2, CLPRobotoTextView cLPRobotoTextView, ImageView imageView, View view2, ImageView imageView2, TextView textView2, TextView textView3) {
        super(eVar, view, i2);
        this.categoryTitle = cLPRobotoTextView;
        this.groupImageView = imageView;
        this.grpItem = view2;
        this.icRaises = imageView2;
        this.textView = textView2;
        this.tvLabel = textView3;
    }

    public Item getItem() {
        return this.mItem;
    }

    public ICategoryClickListener getHandler() {
        return this.mHandler;
    }

    public Integer getPosition() {
        return this.mPosition;
    }

    public static LytCategoryItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static LytCategoryItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (LytCategoryItemBinding) f.a(layoutInflater, R.layout.lyt_category_item, viewGroup, z, eVar);
    }

    public static LytCategoryItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static LytCategoryItemBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (LytCategoryItemBinding) f.a(layoutInflater, R.layout.lyt_category_item, (ViewGroup) null, false, eVar);
    }

    public static LytCategoryItemBinding bind(View view) {
        return bind(view, f.a());
    }

    public static LytCategoryItemBinding bind(View view, e eVar) {
        return (LytCategoryItemBinding) bind(eVar, view, R.layout.lyt_category_item);
    }
}
