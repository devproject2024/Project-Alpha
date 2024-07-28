package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.customViews.CLPRobotoTextView;

public abstract class LayoutCategoryListItemBinding extends ViewDataBinding {
    public final ImageView categoryIcon;
    public final CLPRobotoTextView categoryTitle;
    public final LinearLayout firstItemImageContainer;
    public final Group gridContainer1;
    public final ImageView icRaises;
    protected String mImageUrl;
    protected String mLabel;
    protected String mName;
    public final TextView tvLabel;

    public abstract void setImageUrl(String str);

    public abstract void setLabel(String str);

    public abstract void setName(String str);

    protected LayoutCategoryListItemBinding(e eVar, View view, int i2, ImageView imageView, CLPRobotoTextView cLPRobotoTextView, LinearLayout linearLayout, Group group, ImageView imageView2, TextView textView) {
        super(eVar, view, i2);
        this.categoryIcon = imageView;
        this.categoryTitle = cLPRobotoTextView;
        this.firstItemImageContainer = linearLayout;
        this.gridContainer1 = group;
        this.icRaises = imageView2;
        this.tvLabel = textView;
    }

    public String getImageUrl() {
        return this.mImageUrl;
    }

    public String getLabel() {
        return this.mLabel;
    }

    public String getName() {
        return this.mName;
    }

    public static LayoutCategoryListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static LayoutCategoryListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (LayoutCategoryListItemBinding) f.a(layoutInflater, R.layout.layout_category_list_item, viewGroup, z, eVar);
    }

    public static LayoutCategoryListItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static LayoutCategoryListItemBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (LayoutCategoryListItemBinding) f.a(layoutInflater, R.layout.layout_category_list_item, (ViewGroup) null, false, eVar);
    }

    public static LayoutCategoryListItemBinding bind(View view) {
        return bind(view, f.a());
    }

    public static LayoutCategoryListItemBinding bind(View view, e eVar) {
        return (LayoutCategoryListItemBinding) bind(eVar, view, R.layout.layout_category_list_item);
    }
}
