package com.paytmmall.clpartifact.utils;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;

public class DataBindingUtils {
    public static <T extends ViewDataBinding> T getViewBinding(ViewGroup viewGroup, int i2) {
        return f.a(LayoutInflater.from(viewGroup.getContext()), i2, viewGroup, false);
    }
}
