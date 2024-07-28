package net.one97.paytm.nativesdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.paymethods.viewmodel.SelectedInstrumentSheetViewModel;

public abstract class ActivityLoginBinding extends ViewDataBinding {
    public final FrameLayout fragmentContainer;
    public final LytInstrumentSelectedSheetBinding lytSelectedInstrument;
    protected SelectedInstrumentSheetViewModel mSelectedInstrumentSheetViewModel;
    public final RelativeLayout rlHeader;
    public final TextView tvAmout;

    public abstract void setSelectedInstrumentSheetViewModel(SelectedInstrumentSheetViewModel selectedInstrumentSheetViewModel);

    protected ActivityLoginBinding(Object obj, View view, int i2, FrameLayout frameLayout, LytInstrumentSelectedSheetBinding lytInstrumentSelectedSheetBinding, RelativeLayout relativeLayout, TextView textView) {
        super(obj, view, i2);
        this.fragmentContainer = frameLayout;
        this.lytSelectedInstrument = lytInstrumentSelectedSheetBinding;
        setContainedBinding(this.lytSelectedInstrument);
        this.rlHeader = relativeLayout;
        this.tvAmout = textView;
    }

    public SelectedInstrumentSheetViewModel getSelectedInstrumentSheetViewModel() {
        return this.mSelectedInstrumentSheetViewModel;
    }

    public static ActivityLoginBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static ActivityLoginBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityLoginBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_login, viewGroup, z, obj);
    }

    public static ActivityLoginBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static ActivityLoginBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityLoginBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_login, (ViewGroup) null, false, obj);
    }

    public static ActivityLoginBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static ActivityLoginBinding bind(View view, Object obj) {
        return (ActivityLoginBinding) bind(obj, view, R.layout.activity_login);
    }
}
