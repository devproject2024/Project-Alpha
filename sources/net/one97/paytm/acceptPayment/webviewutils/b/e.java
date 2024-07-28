package net.one97.paytm.acceptPayment.webviewutils.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.VideoView;
import java.lang.ref.WeakReference;
import net.one97.paytm.acceptPayment.R;
import net.one97.paytm.acceptPayment.webview.VideoEnabledWebView;
import net.one97.paytm.acceptPayment.webviewutils.a.c;
import net.one97.paytm.acceptPayment.webviewutils.activity.BaseWebViewActivity;

public class e extends WebChromeClient implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener {

    /* renamed from: a  reason: collision with root package name */
    protected WeakReference<Handler> f52256a;

    /* renamed from: b  reason: collision with root package name */
    private View f52257b;

    /* renamed from: c  reason: collision with root package name */
    private ViewGroup f52258c;

    /* renamed from: d  reason: collision with root package name */
    private View f52259d;

    /* renamed from: e  reason: collision with root package name */
    private VideoEnabledWebView f52260e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f52261f;

    /* renamed from: g  reason: collision with root package name */
    private FrameLayout f52262g;

    /* renamed from: h  reason: collision with root package name */
    private WebChromeClient.CustomViewCallback f52263h;

    /* renamed from: i  reason: collision with root package name */
    private a f52264i;

    public interface a {
        void a(boolean z);
    }

    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        return false;
    }

    public e() {
    }

    public e(Handler handler, View view, ViewGroup viewGroup, View view2, VideoEnabledWebView videoEnabledWebView) {
        this.f52256a = new WeakReference<>(handler);
        this.f52257b = view;
        this.f52258c = viewGroup;
        this.f52259d = view2;
        this.f52260e = videoEnabledWebView;
        this.f52261f = false;
    }

    public final void a(a aVar) {
        this.f52264i = aVar;
    }

    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            View focusedChild = frameLayout.getFocusedChild();
            this.f52261f = true;
            this.f52262g = frameLayout;
            this.f52263h = customViewCallback;
            this.f52257b.setVisibility(4);
            this.f52258c.addView(this.f52262g, new ViewGroup.LayoutParams(-1, -1));
            this.f52258c.setVisibility(0);
            if (focusedChild instanceof VideoView) {
                VideoView videoView = (VideoView) focusedChild;
                videoView.setOnPreparedListener(this);
                videoView.setOnCompletionListener(this);
                videoView.setOnErrorListener(this);
            } else {
                VideoEnabledWebView videoEnabledWebView = this.f52260e;
                if (videoEnabledWebView != null && videoEnabledWebView.getSettings().getJavaScriptEnabled() && (focusedChild instanceof SurfaceView)) {
                    this.f52260e.loadUrl(((((((("javascript:var _ytrp_html5_video_last;" + "var _ytrp_html5_video = document.getElementsByTagName('video')[0];") + "if (_ytrp_html5_video != undefined && _ytrp_html5_video != _ytrp_html5_video_last) {") + "_ytrp_html5_video_last = _ytrp_html5_video;") + "function _ytrp_html5_video_ended() {") + "_VideoEnabledWebView.notifyVideoEnd();") + "}") + "_ytrp_html5_video.addEventListener('ended', _ytrp_html5_video_ended);") + "}");
                }
            }
            a aVar = this.f52264i;
            if (aVar != null) {
                aVar.a(true);
            }
        }
    }

    public void onShowCustomView(View view, int i2, WebChromeClient.CustomViewCallback customViewCallback) {
        onShowCustomView(view, customViewCallback);
    }

    public void onHideCustomView() {
        if (this.f52261f) {
            this.f52258c.setVisibility(4);
            this.f52258c.removeView(this.f52262g);
            this.f52257b.setVisibility(0);
            WebChromeClient.CustomViewCallback customViewCallback = this.f52263h;
            if (customViewCallback != null && !customViewCallback.getClass().getName().contains(".chromium.")) {
                this.f52263h.onCustomViewHidden();
            }
            this.f52261f = false;
            this.f52262g = null;
            this.f52263h = null;
            a aVar = this.f52264i;
            if (aVar != null) {
                aVar.a(false);
            }
        }
    }

    public View getVideoLoadingProgressView() {
        View view = this.f52259d;
        if (view == null) {
            return super.getVideoLoadingProgressView();
        }
        view.setVisibility(0);
        return this.f52259d;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        View view = this.f52259d;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        onHideCustomView();
    }

    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        WebView webView2 = new WebView(webView.getContext());
        webView2.setLayoutParams(new FrameLayout.LayoutParams(webView.getContext().getResources().getDisplayMetrics().widthPixels, webView.getContext().getResources().getDisplayMetrics().heightPixels));
        webView2.getSettings().setJavaScriptEnabled(true);
        webView2.getSettings().setSupportMultipleWindows(true);
        webView2.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView2.addJavascriptInterface(new f(new c((BaseWebViewActivity) webView.getContext()), "UMP_Common"), "CommunicationWindow");
        webView2.getSettings().setPluginState(WebSettings.PluginState.ON);
        webView.addView(webView2);
        ((WebView.WebViewTransport) message.obj).setWebView(webView2);
        message.sendToTarget();
        webView2.setWebViewClient(new WebViewClient() {
            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                webView.loadUrl(str);
                return true;
            }
        });
        return true;
    }

    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        String[] acceptTypes = fileChooserParams.getAcceptTypes();
        WeakReference<Handler> weakReference = this.f52256a;
        if (!(weakReference == null || weakReference.get() == null)) {
            Message message = new Message();
            message.what = 8;
            message.obj = new c(valueCallback, acceptTypes[0]);
            ((Handler) this.f52256a.get()).sendMessage(message);
        }
        return true;
    }

    public Bitmap getDefaultVideoPoster() {
        if (super.getDefaultVideoPoster() == null) {
            return BitmapFactory.decodeResource(net.one97.paytm.acceptPayment.configs.a.f52046a.f52047b.getResources(), R.drawable.ic_launcher);
        }
        return super.getDefaultVideoPoster();
    }
}
