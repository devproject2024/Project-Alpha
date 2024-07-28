package net.one97.paytm.nativesdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.widget.RoboTextView;

public abstract class LayoutPostpaidTermsBinding extends ViewDataBinding {
    public final ImageView crossIcon;
    public final ProgressBar pbProgress;
    public final RelativeLayout rlMainView;
    public final RoboTextView tvUpiHelpTitle;
    public final WebView wvTermsNCondition;

    protected LayoutPostpaidTermsBinding(Object obj, View view, int i2, ImageView imageView, ProgressBar progressBar, RelativeLayout relativeLayout, RoboTextView roboTextView, WebView webView) {
        super(obj, view, i2);
        this.crossIcon = imageView;
        this.pbProgress = progressBar;
        this.rlMainView = relativeLayout;
        this.tvUpiHelpTitle = roboTextView;
        this.wvTermsNCondition = webView;
    }

    public static LayoutPostpaidTermsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static LayoutPostpaidTermsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LayoutPostpaidTermsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_postpaid_terms, viewGroup, z, obj);
    }

    public static LayoutPostpaidTermsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static LayoutPostpaidTermsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LayoutPostpaidTermsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_postpaid_terms, (ViewGroup) null, false, obj);
    }

    public static LayoutPostpaidTermsBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static LayoutPostpaidTermsBinding bind(View view, Object obj) {
        return (LayoutPostpaidTermsBinding) bind(obj, view, R.layout.layout_postpaid_terms);
    }
}
