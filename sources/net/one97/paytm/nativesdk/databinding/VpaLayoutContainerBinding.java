package net.one97.paytm.nativesdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import net.one97.paytm.nativesdk.R;

public abstract class VpaLayoutContainerBinding extends ViewDataBinding {
    public final LinearLayout vpaContainer;

    protected VpaLayoutContainerBinding(Object obj, View view, int i2, LinearLayout linearLayout) {
        super(obj, view, i2);
        this.vpaContainer = linearLayout;
    }

    public static VpaLayoutContainerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static VpaLayoutContainerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (VpaLayoutContainerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.vpa_layout_container, viewGroup, z, obj);
    }

    public static VpaLayoutContainerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static VpaLayoutContainerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (VpaLayoutContainerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.vpa_layout_container, (ViewGroup) null, false, obj);
    }

    public static VpaLayoutContainerBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static VpaLayoutContainerBinding bind(View view, Object obj) {
        return (VpaLayoutContainerBinding) bind(obj, view, R.layout.vpa_layout_container);
    }
}
