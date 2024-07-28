package net.one97.paytm.nativesdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.paymethods.viewmodel.SelectedInstrumentSheetViewModel;

public abstract class LytInstrumentSelectedSheetBinding extends ViewDataBinding {
    public final TextView btnLogin;
    public final CardView cvSelectedInstrument;
    public final ImageView ivInstrumentSelected;
    public final LinearLayout llImgContainer;
    public final LinearLayout lytBottomLines;
    public final RelativeLayout lytSignInButton;
    protected SelectedInstrumentSheetViewModel mSelectedInstrumentSheetViewModel;
    public final RelativeLayout rlDownArrow;
    public final RelativeLayout rlSelectedInstrument;
    public final TextView tvInstrumentInfoMsg;
    public final TextView tvInstrumentName;
    public final TextView tvIntrumentBalance;
    public final TextView tvPayUsing;

    public abstract void setSelectedInstrumentSheetViewModel(SelectedInstrumentSheetViewModel selectedInstrumentSheetViewModel);

    protected LytInstrumentSelectedSheetBinding(Object obj, View view, int i2, TextView textView, CardView cardView, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        super(obj, view, i2);
        this.btnLogin = textView;
        this.cvSelectedInstrument = cardView;
        this.ivInstrumentSelected = imageView;
        this.llImgContainer = linearLayout;
        this.lytBottomLines = linearLayout2;
        this.lytSignInButton = relativeLayout;
        this.rlDownArrow = relativeLayout2;
        this.rlSelectedInstrument = relativeLayout3;
        this.tvInstrumentInfoMsg = textView2;
        this.tvInstrumentName = textView3;
        this.tvIntrumentBalance = textView4;
        this.tvPayUsing = textView5;
    }

    public SelectedInstrumentSheetViewModel getSelectedInstrumentSheetViewModel() {
        return this.mSelectedInstrumentSheetViewModel;
    }

    public static LytInstrumentSelectedSheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static LytInstrumentSelectedSheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LytInstrumentSelectedSheetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.lyt_instrument_selected_sheet, viewGroup, z, obj);
    }

    public static LytInstrumentSelectedSheetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static LytInstrumentSelectedSheetBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LytInstrumentSelectedSheetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.lyt_instrument_selected_sheet, (ViewGroup) null, false, obj);
    }

    public static LytInstrumentSelectedSheetBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static LytInstrumentSelectedSheetBinding bind(View view, Object obj) {
        return (LytInstrumentSelectedSheetBinding) bind(obj, view, R.layout.lyt_instrument_selected_sheet);
    }
}
