package com.alipay.mobile.nebulacore.embedview;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5CallBack;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.nebula.config.H5EmbedViewConfig;
import com.alipay.mobile.nebula.provider.H5EmbededViewProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.view.IH5EmbedView;
import com.alipay.mobile.nebulacore.env.H5Environment;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class H5EmbededViewProviderImpl implements H5EmbededViewProvider {
    private static final String TAG = "H5EmbededViewProviderImpl";
    private Context mContext;
    private Map<String, IH5EmbedView> mEmbedViews = new ConcurrentHashMap();
    private H5Page mH5Page;

    public H5EmbededViewProviderImpl(Context context, H5Page h5Page) {
        this.mContext = context;
        this.mH5Page = h5Page;
    }

    public View getEmbedView(int i2, int i3, String str, String str2, Map<String, String> map) {
        H5Log.d(TAG, "H5EmbededViewProviderImpl getEmbedView, viewId " + str + ", mType " + str2);
        if (map != null && !map.isEmpty()) {
            String str3 = map.get("type");
            String elementId = getElementId(str, map);
            if (!this.mEmbedViews.containsKey(elementId)) {
                H5Log.d(TAG, "H5EmbededViewProviderImpl getEmbedView init");
                IH5EmbedView embedViewWrapper = getEmbedViewWrapper(str3);
                if (embedViewWrapper != null) {
                    this.mEmbedViews.put(elementId, embedViewWrapper);
                    View view = embedViewWrapper.getView(i2, i3, str, str2, map);
                    H5Page h5Page = this.mH5Page;
                    if (!(h5Page == null || h5Page.getBridge() == null)) {
                        e eVar = new e();
                        eVar.put("elementid", (Object) elementId);
                        this.mH5Page.getBridge().sendToWeb("nbcomponent.canrender", eVar, (H5CallBack) null);
                    }
                    return view;
                }
            } else {
                H5Log.d(TAG, "H5EmbededViewProviderImpl getEmbedView reuse");
                IH5EmbedView iH5EmbedView = this.mEmbedViews.get(elementId);
                if (TextUtils.equals(Item.CTA_URL_TYPE_MAP, str3)) {
                    return iH5EmbedView.getSpecialRestoreView(i2, i3, str, str2, map);
                }
                return iH5EmbedView.getView(i2, i3, str, str2, map);
            }
        }
        return null;
    }

    public void onEmbedViewAttachedToWebView(int i2, int i3, String str, String str2, Map<String, String> map) {
        IH5EmbedView iH5EmbedView;
        H5Log.d(TAG, "H5EmbededViewProviderImpl onEmbedViewAttachedToWebView, viewId " + str + ", mType " + str2);
        if (map != null && !map.isEmpty() && (iH5EmbedView = this.mEmbedViews.get(getElementId(str, map))) != null) {
            iH5EmbedView.onEmbedViewAttachedToWebView(i2, i3, str, str2, map);
        }
    }

    public void onEmbedViewDetachedFromWebView(int i2, int i3, String str, String str2, Map<String, String> map) {
        IH5EmbedView iH5EmbedView;
        H5Log.d(TAG, "H5EmbededViewProviderImpl onEmbedViewDetachedFromWebView, viewId " + str + ", mType " + str2);
        if (map != null && !map.isEmpty() && (iH5EmbedView = this.mEmbedViews.get(getElementId(str, map))) != null) {
            iH5EmbedView.onEmbedViewDetachedFromWebView(i2, i3, str, str2, map);
        }
    }

    public void onEmbedViewDestory(int i2, int i3, String str, String str2, Map<String, String> map) {
        IH5EmbedView iH5EmbedView;
        H5Log.d(TAG, "H5EmbededViewProviderImpl onEmbedViewDestory, viewId " + str + ", mType " + str2);
        if (map != null && !map.isEmpty() && (iH5EmbedView = this.mEmbedViews.get(getElementId(str, map))) != null) {
            iH5EmbedView.onEmbedViewDestory(i2, i3, str, str2, map);
        }
    }

    public void onEmbedViewParamChanged(int i2, int i3, String str, String str2, Map<String, String> map, String[] strArr, String[] strArr2) {
        IH5EmbedView iH5EmbedView;
        String str3 = str;
        Map<String, String> map2 = map;
        StringBuilder sb = new StringBuilder("H5EmbededViewProviderImpl onEmbedViewParamChanged, viewId ");
        sb.append(str);
        sb.append(", mType ");
        String str4 = str2;
        sb.append(str2);
        H5Log.d(TAG, sb.toString());
        if (map2 != null && !map.isEmpty() && (iH5EmbedView = this.mEmbedViews.get(getElementId(str, map))) != null) {
            iH5EmbedView.onEmbedViewParamChanged(i2, i3, str, str2, map, strArr, strArr2);
        }
    }

    public void onEmbedViewVisibilityChanged(int i2, int i3, String str, String str2, Map<String, String> map, int i4) {
        IH5EmbedView iH5EmbedView;
        H5Log.d(TAG, "H5EmbededViewProviderImpl onEmbedViewVisibilityChanged, viewId " + str + ", mType " + str2);
        if (map != null && !map.isEmpty() && (iH5EmbedView = this.mEmbedViews.get(getElementId(str, map))) != null) {
            iH5EmbedView.onEmbedViewVisibilityChanged(i2, i3, str, str2, map, i4);
        }
    }

    public void onWebViewResume() {
        H5Log.d(TAG, "H5EmbededViewProviderImpl onWebViewResume");
        Map<String, IH5EmbedView> map = this.mEmbedViews;
        if (map != null) {
            for (String str : map.keySet()) {
                IH5EmbedView iH5EmbedView = this.mEmbedViews.get(str);
                if (iH5EmbedView != null) {
                    iH5EmbedView.onWebViewResume();
                }
            }
        }
    }

    public void onWebViewPause() {
        H5Log.d(TAG, "H5EmbededViewProviderImpl onWebViewPause");
        Map<String, IH5EmbedView> map = this.mEmbedViews;
        if (map != null) {
            for (String str : map.keySet()) {
                IH5EmbedView iH5EmbedView = this.mEmbedViews.get(str);
                if (iH5EmbedView != null) {
                    iH5EmbedView.onWebViewPause();
                }
            }
        }
    }

    public void onWebViewDestory() {
        H5Log.d(TAG, "H5EmbededViewProviderImpl onWebViewDestory");
        Map<String, IH5EmbedView> map = this.mEmbedViews;
        if (map != null) {
            for (String str : map.keySet()) {
                IH5EmbedView iH5EmbedView = this.mEmbedViews.get(str);
                if (iH5EmbedView != null) {
                    iH5EmbedView.onWebViewDestory();
                }
            }
        }
    }

    private IH5EmbedView getEmbedViewWrapper(String str) {
        H5EmbedViewConfig config = H5EmbededViewConfigManager.getInstance().getConfig(str);
        if (config == null) {
            return null;
        }
        String bundleName = config.getBundleName();
        String className = config.getClassName();
        Class<?> cls = H5Environment.getClass(bundleName, className);
        if (cls == null) {
            H5Log.w(TAG, "getEmbedViewWrapper reflect clazz == null ".concat(String.valueOf(className)));
            return null;
        }
        try {
            if (!IH5EmbedView.class.isAssignableFrom(cls)) {
                return null;
            }
            IH5EmbedView iH5EmbedView = (IH5EmbedView) cls.newInstance();
            if (iH5EmbedView == null) {
                H5Log.w(TAG, "getEmbedViewWrapper reflect embedView == null ".concat(String.valueOf(className)));
                return null;
            }
            iH5EmbedView.onCreate(this.mContext, this.mH5Page);
            return iH5EmbedView;
        } catch (Throwable th) {
            H5Log.e(TAG, "getEmbedViewWrapper reflect catch exception ".concat(String.valueOf(className)), th);
            return null;
        }
    }

    public void releaseView() {
        this.mEmbedViews.clear();
        this.mContext = null;
        this.mH5Page = null;
    }

    public IH5EmbedView getEmbedViewWrapperById(String str) {
        return this.mEmbedViews.get(str);
    }

    public Bitmap getSnapshot(int i2, int i3, String str, String str2, Map<String, String> map) {
        IH5EmbedView iH5EmbedView;
        H5Log.d(TAG, "H5EmbededViewProviderImpl getSnapshot, viewId " + str + ", mType " + str2);
        if (map == null || map.isEmpty() || (iH5EmbedView = this.mEmbedViews.get(getElementId(str, map))) == null) {
            return null;
        }
        return iH5EmbedView.getSnapshot(i2, i3, str, str2, map);
    }

    public void triggerPreSnapshot() {
        Map<String, IH5EmbedView> map = this.mEmbedViews;
        if (map != null && !map.isEmpty()) {
            for (IH5EmbedView triggerPreSnapshot : this.mEmbedViews.values()) {
                triggerPreSnapshot.triggerPreSnapshot();
            }
        }
    }

    private String getElementId(String str, Map<String, String> map) {
        return !TextUtils.equals("TINY_COMPONENT", map.get("type")) ? map.get("id") : str;
    }
}
