package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.common_module.view.widget.CustomTextView;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.viewmodel.EmbedWebViewViewModel;

public abstract class MpEmbedWebViewActivityBinding extends ViewDataBinding {
    public EmbedWebViewViewModel mEmbedWebViewViewModel;
    public final Toolbar toolbar;
    public final CustomTextView tvTitle;
    public final WebView webview;

    public abstract void setEmbedWebViewViewModel(EmbedWebViewViewModel embedWebViewViewModel);

    public MpEmbedWebViewActivityBinding(Object obj, View view, int i2, Toolbar toolbar2, CustomTextView customTextView, WebView webView) {
        super(obj, view, i2);
        this.toolbar = toolbar2;
        this.tvTitle = customTextView;
        this.webview = webView;
    }

    public EmbedWebViewViewModel getEmbedWebViewViewModel() {
        return this.mEmbedWebViewViewModel;
    }

    public static MpEmbedWebViewActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpEmbedWebViewActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpEmbedWebViewActivityBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_embed_web_view_activity, viewGroup, z, obj);
    }

    public static MpEmbedWebViewActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpEmbedWebViewActivityBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpEmbedWebViewActivityBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_embed_web_view_activity, (ViewGroup) null, false, obj);
    }

    public static MpEmbedWebViewActivityBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpEmbedWebViewActivityBinding bind(View view, Object obj) {
        return (MpEmbedWebViewActivityBinding) ViewDataBinding.bind(obj, view, R.layout.mp_embed_web_view_activity);
    }
}
