package com.alipay.mobile.nebula.view;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5Session;
import com.alipay.mobile.nebula.appcenter.api.H5ContentProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import java.lang.ref.WeakReference;

public abstract class H5BaseEmbedView implements IH5EmbedView {
    private static final String TAG = "H5BaseEmbedView";
    public WeakReference<Context> mContext;
    public WeakReference<H5Page> mH5Page;

    public void onCreate(Context context, H5Page h5Page) {
        this.mContext = new WeakReference<>(context);
        this.mH5Page = new WeakReference<>(h5Page);
    }

    public void execJavaScript(String str, IH5EmbedViewJSCallback iH5EmbedViewJSCallback) {
        H5Page h5Page = (H5Page) this.mH5Page.get();
        if (h5Page != null) {
            h5Page.execJavaScript4EmbedView("javascript:".concat(String.valueOf(str)), iH5EmbedViewJSCallback);
        }
    }

    public void getComponentResourceDataWithUrl(String str, H5ContentProvider.ResponseListen responseListen, H5Page h5Page) {
        H5Log.d(TAG, "getComponentResourceDataWithUrl url ".concat(String.valueOf(str)));
        if (h5Page != null) {
            String absoluteUrl = getAbsoluteUrl(str, h5Page.getParams());
            H5Log.d(TAG, "getComponentResourceDataWithUrl abUrl ".concat(String.valueOf(absoluteUrl)));
            H5Session session = h5Page.getSession();
            if (session != null) {
                H5ContentProvider webProvider = session.getWebProvider();
                if (webProvider != null) {
                    webProvider.getContent(absoluteUrl, responseListen);
                    return;
                }
                H5Log.d(TAG, "getComponentResourceDataWithUrl h5ContentProvider == null");
                responseListen.onGetResponse((WebResourceResponse) null);
                return;
            }
            H5Log.d(TAG, "getComponentResourceDataWithUrl h5Session == null");
            responseListen.onGetResponse((WebResourceResponse) null);
            return;
        }
        H5Log.d(TAG, "getComponentResourceDataWithUrl h5Page == null");
        responseListen.onGetResponse((WebResourceResponse) null);
    }

    private String getAbsoluteUrl(String str, Bundle bundle) {
        String string = H5Utils.getString(bundle, "url");
        if (!TextUtils.isEmpty(string)) {
            return H5Utils.getAbsoluteUrlV2(string, str, (Bundle) null);
        }
        return null;
    }
}
