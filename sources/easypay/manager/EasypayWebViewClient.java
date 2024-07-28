package easypay.manager;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import easypay.actions.EasypayBrowserFragment;
import easypay.listeners.WebClientListener;
import easypay.utils.AssistInvokeException;
import easypay.utils.AssistLogs;
import java.io.Serializable;
import java.util.Iterator;

public class EasypayWebViewClient extends WebViewClient implements Serializable {
    private EasypayBrowserFragment fragment;

    public EasypayWebViewClient() {
    }

    public EasypayWebViewClient(Activity activity) {
        AssistLogs.printLog("EasypayWebViewClient" + toString(), this);
        this.fragment = AssistMerchantDetails.getInstance().getFragment();
    }

    public void addAssistWebClientListener(WebClientListener webClientListener) {
        if (AssistMerchantDetails.getInstance().getmWcListListener() != null) {
            try {
                AssistMerchantDetails.getInstance().getmWcListListener().listIterator().add(webClientListener);
            } catch (Exception e2) {
                AssistLogs.printLog("EXCEPTION", e2);
            }
        } else {
            try {
                throw new AssistInvokeException("PaytmAssist Not Configured! Did you Missed StartConfigAssist");
            } catch (AssistInvokeException e3) {
                AssistLogs.printLog("EXCEPTION", e3);
            }
        }
    }

    public synchronized void removeAssistWebClientListener(WebClientListener webClientListener) {
        if (AssistMerchantDetails.getInstance().getmWcListListener() != null) {
            try {
                Iterator<WebClientListener> it2 = AssistMerchantDetails.getInstance().getmWcListListener().iterator();
                while (it2.hasNext()) {
                    if (it2.next().equals(webClientListener)) {
                        it2.remove();
                    }
                }
            } catch (Exception e2) {
                AssistLogs.printLog("EXCEPTION", e2);
            }
        } else {
            try {
                throw new AssistInvokeException("PaytmAssist Not Configured! Did you Missed StartConfigAssist");
            } catch (AssistInvokeException e3) {
                AssistLogs.printLog("EXCEPTION", e3);
            }
        }
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        AssistLogs.printLog(String.valueOf(str), this);
        try {
            if (AssistMerchantDetails.getInstance().getmWcListListener() != null) {
                Iterator<WebClientListener> it2 = AssistMerchantDetails.getInstance().getmWcListListener().iterator();
                while (it2.hasNext()) {
                    try {
                        it2.next().OnWcPageFinish(webView, str);
                    } catch (Exception unused) {
                    }
                }
            }
        } catch (Exception e2) {
            AssistLogs.printLog("EXCEPTION", e2);
        }
        try {
            if (this.fragment == null) {
                this.fragment = AssistMerchantDetails.getInstance().getFragment();
            }
            fireActions(webView, str);
            AssistMerchantDetails.getInstance().setLastLoadedUrl(str);
        } catch (Exception e3) {
            AssistLogs.printLog("EXCEPTION", e3);
        }
    }

    private void fireActions(WebView webView, String str) {
        if (this.fragment != null) {
            AssistLogs.printLog("page finish: fire action:checkAssistFlow", this);
            this.fragment.checkAssistFlow(webView, str);
        }
    }

    public synchronized void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        try {
            if (AssistMerchantDetails.getInstance().getmWcListListener() != null) {
                Iterator<WebClientListener> it2 = AssistMerchantDetails.getInstance().getmWcListListener().iterator();
                while (it2.hasNext()) {
                    it2.next().OnWcSslError(webView, sslErrorHandler, sslError);
                }
            }
        } catch (AbstractMethodError unused) {
        }
        if (sslErrorHandler != null) {
            sslErrorHandler.cancel();
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        AssistLogs.printLog("onpage started-".concat(String.valueOf(str)), this);
        try {
            if (AssistMerchantDetails.getInstance().getmWcListListener() != null) {
                for (int i2 = 0; i2 < AssistMerchantDetails.getInstance().getmWcListListener().size(); i2++) {
                    AssistMerchantDetails.getInstance().getmWcListListener().get(i2).OnWcPageStart(webView, str, bitmap);
                }
            }
        } catch (Exception e2) {
            AssistLogs.printLog("EXCEPTION", e2);
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            if (AssistMerchantDetails.getInstance().getmWcListListener() != null) {
                Iterator<WebClientListener> it2 = AssistMerchantDetails.getInstance().getmWcListListener().iterator();
                boolean z = false;
                while (it2.hasNext()) {
                    z |= it2.next().WcshouldOverrideUrlLoading(webView, str);
                }
                return z;
            }
        } catch (Exception e2) {
            AssistLogs.printLog("EXCEPTION", e2);
        }
        return false;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        try {
            if (AssistMerchantDetails.getInstance().getmWcListListener() != null) {
                Iterator<WebClientListener> it2 = AssistMerchantDetails.getInstance().getmWcListListener().iterator();
                boolean z = false;
                while (it2.hasNext()) {
                    z |= it2.next().WcshouldOverrideUrlLoading(webView, webResourceRequest);
                }
                return z;
            }
        } catch (Exception e2) {
            AssistLogs.printLog("EXCEPTION", e2);
        }
        return false;
    }

    public void onReceivedError(WebView webView, int i2, String str, String str2) {
        super.onReceivedError(webView, i2, str, str2);
        try {
            if (AssistMerchantDetails.getInstance().getmWcListListener() != null) {
                Iterator<WebClientListener> it2 = AssistMerchantDetails.getInstance().getmWcListListener().iterator();
                while (it2.hasNext()) {
                    it2.next().onReceivedError(webView, i2, str, str2);
                }
            }
        } catch (Exception e2) {
            AssistLogs.printLog("EXCEPTION", e2);
        }
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        try {
            if (AssistMerchantDetails.getInstance().getmWcListListener() != null) {
                Iterator<WebClientListener> it2 = AssistMerchantDetails.getInstance().getmWcListListener().iterator();
                while (it2.hasNext()) {
                    it2.next().WcshouldInterceptRequest(webView, str);
                }
            }
        } catch (Exception e2) {
            AssistLogs.printLog("EXCEPTION", e2);
        }
        return super.shouldInterceptRequest(webView, str);
    }
}
