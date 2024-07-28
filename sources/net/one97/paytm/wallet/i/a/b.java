package net.one97.paytm.wallet.i.a;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.i.f;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.paymentslimit.b.d;
import net.one97.paytm.wallet.R;

public final class b extends f {

    /* renamed from: a  reason: collision with root package name */
    private View f70387a;

    /* renamed from: b  reason: collision with root package name */
    private WebView f70388b;

    /* renamed from: c  reason: collision with root package name */
    private LottieAnimationView f70389c;

    /* renamed from: d  reason: collision with root package name */
    private Context f70390d;

    /* renamed from: e  reason: collision with root package name */
    private AppCompatImageView f70391e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap f70392f;

    public static final /* synthetic */ LottieAnimationView a(b bVar) {
        LottieAnimationView lottieAnimationView = bVar.f70389c;
        if (lottieAnimationView == null) {
            k.a("loader");
        }
        return lottieAnimationView;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.scp_terms_conditions_bottom_sheet, viewGroup, false);
        k.a((Object) inflate, "inflater.inflate(R.layou…_sheet, container, false)");
        this.f70387a = inflate;
        View view = this.f70387a;
        if (view == null) {
            k.a("rootView");
        }
        WebView webView = (WebView) view.findViewById(R.id.terms_conditions_webview);
        k.a((Object) webView, "rootView.terms_conditions_webview");
        this.f70388b = webView;
        View view2 = this.f70387a;
        if (view2 == null) {
            k.a("rootView");
        }
        LottieAnimationView lottieAnimationView = (LottieAnimationView) view2.findViewById(R.id.visa_tnc_webview_loader);
        k.a((Object) lottieAnimationView, "rootView.visa_tnc_webview_loader");
        this.f70389c = lottieAnimationView;
        View view3 = this.f70387a;
        if (view3 == null) {
            k.a("rootView");
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) view3.findViewById(R.id.close_iv);
        k.a((Object) appCompatImageView, "rootView.close_iv");
        this.f70391e = appCompatImageView;
        View view4 = this.f70387a;
        if (view4 == null) {
            k.a("rootView");
        }
        return view4;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        AppCompatImageView appCompatImageView = this.f70391e;
        if (appCompatImageView == null) {
            k.a("closeIv");
        }
        appCompatImageView.setOnClickListener(new a(this));
        LottieAnimationView lottieAnimationView = this.f70389c;
        if (lottieAnimationView == null) {
            k.a("loader");
        }
        net.one97.paytm.common.widgets.a.a(lottieAnimationView);
        WebView webView = this.f70388b;
        if (webView == null) {
            k.a("webview");
        }
        WebSettings settings = webView.getSettings();
        if (settings != null) {
            settings.setAppCacheEnabled(false);
        }
        if (settings != null) {
            settings.setCacheMode(1);
        }
        WebView webView2 = this.f70388b;
        if (webView2 == null) {
            k.a("webview");
        }
        webView2.setScrollbarFadingEnabled(true);
        WebView webView3 = this.f70388b;
        if (webView3 == null) {
            k.a("webview");
        }
        webView3.setWebViewClient(new C1421b(this));
        WebView webView4 = this.f70388b;
        if (webView4 == null) {
            k.a("webview");
        }
        webView4.loadUrl(SDKConstants.VISA_TNC_URL);
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        this.f70390d = context;
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        k.a((Object) onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        onCreateDialog.setOnShowListener(new c(this));
        return onCreateDialog;
    }

    static final class c implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f70395a;

        c(b bVar) {
            this.f70395a = bVar;
        }

        public final void onShow(DialogInterface dialogInterface) {
            if (dialogInterface != null) {
                b.a(this.f70395a, (com.google.android.material.bottomsheet.a) dialogInterface);
                return;
            }
            throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f70393a;

        a(b bVar) {
            this.f70393a = bVar;
        }

        public final void onClick(View view) {
            this.f70393a.a();
        }
    }

    /* renamed from: net.one97.paytm.wallet.i.a.b$b  reason: collision with other inner class name */
    public static final class C1421b extends WebViewClient {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f70394a;

        C1421b(b bVar) {
            this.f70394a = bVar;
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (webView == null) {
                return true;
            }
            webView.loadUrl(str);
            return true;
        }

        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            net.one97.paytm.common.widgets.a.b(b.a(this.f70394a));
        }

        public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            if (!d.c(this.f70394a.getContext())) {
                Toast.makeText(this.f70394a.getContext(), R.string.no_internet_message, 0).show();
            } else {
                Toast.makeText(this.f70394a.getContext(), R.string.some_went_wrong, 0).show();
            }
            this.f70394a.a();
        }
    }

    public final void a() {
        j supportFragmentManager;
        q a2;
        FragmentActivity activity = getActivity();
        if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null && (a2 = supportFragmentManager.a().a((Fragment) this)) != null) {
            a2.c();
        }
    }

    public static final /* synthetic */ void a(b bVar, com.google.android.material.bottomsheet.a aVar) {
        WindowManager windowManager;
        Display defaultDisplay;
        View findViewById = aVar.findViewById(R.id.design_bottom_sheet);
        if (findViewById != null) {
            FrameLayout frameLayout = (FrameLayout) findViewById;
            BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
            k.a((Object) from, "BottomSheetBehavior.from(layout)");
            ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            FragmentActivity activity = bVar.getActivity();
            if (!(activity == null || (windowManager = activity.getWindowManager()) == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null)) {
                defaultDisplay.getMetrics(displayMetrics);
            }
            int i2 = displayMetrics.heightPixels;
            if (layoutParams != null) {
                layoutParams.height = i2;
            }
            frameLayout.setLayoutParams(layoutParams);
            from.setState(3);
            return;
        }
        throw new u("null cannot be cast to non-null type android.widget.FrameLayout");
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f70392f;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
