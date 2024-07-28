package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.view.viewmodel.SearchViewModel;

public abstract class ClpActivitySearchBinding extends ViewDataBinding {
    public final ImageView BrandLogo;
    public final ImageView backButton;
    public final ImageView cross;
    public final Group group;
    public final ConstraintLayout header;
    public final TextView homeButton;
    public final ImageView imgSearch;
    protected View mView;
    protected SearchViewModel mViewModel;
    public final TextView or;
    public final EditText query;
    public final TextView rating;
    public final ScrollView scrollable;
    public final TextView searchBtn;
    public final Group searchGroup;
    public final TextView searchHeader;
    public final TextView searchSorry;
    public final ImageView star;
    public final TextView txvName;

    public abstract void setView(View view);

    public abstract void setViewModel(SearchViewModel searchViewModel);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected ClpActivitySearchBinding(e eVar, android.view.View view, int i2, ImageView imageView, ImageView imageView2, ImageView imageView3, Group group2, ConstraintLayout constraintLayout, TextView textView, ImageView imageView4, TextView textView2, EditText editText, TextView textView3, ScrollView scrollView, TextView textView4, Group group3, TextView textView5, TextView textView6, ImageView imageView5, TextView textView7) {
        super(eVar, view, i2);
        this.BrandLogo = imageView;
        this.backButton = imageView2;
        this.cross = imageView3;
        this.group = group2;
        this.header = constraintLayout;
        this.homeButton = textView;
        this.imgSearch = imageView4;
        this.or = textView2;
        this.query = editText;
        this.rating = textView3;
        this.scrollable = scrollView;
        this.searchBtn = textView4;
        this.searchGroup = group3;
        this.searchHeader = textView5;
        this.searchSorry = textView6;
        this.star = imageView5;
        this.txvName = textView7;
    }

    public View getView() {
        return this.mView;
    }

    public SearchViewModel getViewModel() {
        return this.mViewModel;
    }

    public static ClpActivitySearchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ClpActivitySearchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ClpActivitySearchBinding) f.a(layoutInflater, R.layout.clp_activity_search, viewGroup, z, eVar);
    }

    public static ClpActivitySearchBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ClpActivitySearchBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ClpActivitySearchBinding) f.a(layoutInflater, R.layout.clp_activity_search, (ViewGroup) null, false, eVar);
    }

    public static ClpActivitySearchBinding bind(android.view.View view) {
        return bind(view, f.a());
    }

    public static ClpActivitySearchBinding bind(android.view.View view, e eVar) {
        return (ClpActivitySearchBinding) bind(eVar, view, R.layout.clp_activity_search);
    }
}
