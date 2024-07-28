package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;

public abstract class FragmentFilterPriceBinding extends ViewDataBinding {
    public final EditText fromTxt;
    protected String mInitialFrom;
    protected String mInitialTo;
    public final PriceRangeSeekBar seekBar;
    public final EditText toTxt;

    public abstract void setInitialFrom(String str);

    public abstract void setInitialTo(String str);

    protected FragmentFilterPriceBinding(e eVar, View view, int i2, EditText editText, PriceRangeSeekBar priceRangeSeekBar, EditText editText2) {
        super(eVar, view, i2);
        this.fromTxt = editText;
        this.seekBar = priceRangeSeekBar;
        this.toTxt = editText2;
    }

    public String getInitialFrom() {
        return this.mInitialFrom;
    }

    public String getInitialTo() {
        return this.mInitialTo;
    }

    public static FragmentFilterPriceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static FragmentFilterPriceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (FragmentFilterPriceBinding) f.a(layoutInflater, R.layout.fragment_filter_price, viewGroup, z, eVar);
    }

    public static FragmentFilterPriceBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static FragmentFilterPriceBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (FragmentFilterPriceBinding) f.a(layoutInflater, R.layout.fragment_filter_price, (ViewGroup) null, false, eVar);
    }

    public static FragmentFilterPriceBinding bind(View view) {
        return bind(view, f.a());
    }

    public static FragmentFilterPriceBinding bind(View view, e eVar) {
        return (FragmentFilterPriceBinding) bind(eVar, view, R.layout.fragment_filter_price);
    }
}
