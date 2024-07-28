package net.one97.paytm.nativesdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import net.one97.paytm.nativesdk.R;

public abstract class NativeInstrumentBinding extends ViewDataBinding {
    public final CoordinatorLayout clContentView;
    public final FrameLayout disableClickView;
    public final FrameLayout easypayBrowserFragment;
    public final FrameLayout fragmentContainer;

    protected NativeInstrumentBinding(Object obj, View view, int i2, CoordinatorLayout coordinatorLayout, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3) {
        super(obj, view, i2);
        this.clContentView = coordinatorLayout;
        this.disableClickView = frameLayout;
        this.easypayBrowserFragment = frameLayout2;
        this.fragmentContainer = frameLayout3;
    }

    public static NativeInstrumentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static NativeInstrumentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (NativeInstrumentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.native_instrument, viewGroup, z, obj);
    }

    public static NativeInstrumentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static NativeInstrumentBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (NativeInstrumentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.native_instrument, (ViewGroup) null, false, obj);
    }

    public static NativeInstrumentBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static NativeInstrumentBinding bind(View view, Object obj) {
        return (NativeInstrumentBinding) bind(obj, view, R.layout.native_instrument);
    }
}
