package com.paytm.business.merchantprofile.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.common_module.view.widget.CustomTextView;
import com.paytm.business.merchantprofile.R;
import com.paytm.business.merchantprofile.webview.viewmodel.EmbedWebViewViewModel;

public abstract class PrEmbedWebViewActivityBinding extends ViewDataBinding {
    public EmbedWebViewViewModel mEmbedWebViewViewModel;
    public final Toolbar toolbar;
    public final CustomTextView tvTitle;
    public final WebView webview;

    public abstract void setEmbedWebViewViewModel(EmbedWebViewViewModel embedWebViewViewModel);

    public PrEmbedWebViewActivityBinding(Object obj, View view, int i2, Toolbar toolbar2, CustomTextView customTextView, WebView webView) {
        super(obj, view, i2);
        this.toolbar = toolbar2;
        this.tvTitle = customTextView;
        this.webview = webView;
    }

    public EmbedWebViewViewModel getEmbedWebViewViewModel() {
        return this.mEmbedWebViewViewModel;
    }

    public static PrEmbedWebViewActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static PrEmbedWebViewActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PrEmbedWebViewActivityBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pr_embed_web_view_activity, viewGroup, z, obj);
    }

    public static PrEmbedWebViewActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static PrEmbedWebViewActivityBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PrEmbedWebViewActivityBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pr_embed_web_view_activity, (ViewGroup) null, false, obj);
    }

    public static PrEmbedWebViewActivityBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static PrEmbedWebViewActivityBinding bind(View view, Object obj) {
        return (PrEmbedWebViewActivityBinding) ViewDataBinding.bind(obj, view, R.layout.pr_embed_web_view_activity);
    }
}
