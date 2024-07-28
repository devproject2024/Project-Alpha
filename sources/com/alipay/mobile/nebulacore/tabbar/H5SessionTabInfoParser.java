package com.alipay.mobile.nebulacore.tabbar;

import android.text.TextUtils;
import com.alibaba.a.a;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.nebula.data.H5CustomHttpResponse;
import com.alipay.mobile.nebula.provider.H5FallbackStreamProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5TabbarUtils;
import com.alipay.mobile.nebula.util.H5ThreadType;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.core.H5SessionImpl;
import com.alipay.mobile.nebulacore.tabbar.H5SessionTabObserver;
import java.util.HashMap;

public class H5SessionTabInfoParser {
    private static final String TAG = "H5SessionTabInfoParser";

    public interface H5SessionTabInfoListener {
        void onGetAsyncData(e eVar);

        void onGetSyncData(e eVar);

        void onShowDefaultTab();
    }

    public static void getOfflineData(H5SessionImpl h5SessionImpl, final H5SessionTabInfoListener h5SessionTabInfoListener, final String str) {
        if (h5SessionImpl != null && h5SessionImpl.getH5SessionTabObserver() != null) {
            String data = h5SessionImpl.getH5SessionTabObserver().getData(new H5SessionTabObserver.H5SessionTabListener() {
                public final void onDataParsed(String str) {
                    H5Log.d(H5SessionTabInfoParser.TAG, "##tabbar## getOfflineData in callback data ".concat(String.valueOf(str)));
                    if (TextUtils.equals(str, "stupid")) {
                        H5SessionTabInfoListener h5SessionTabInfoListener = h5SessionTabInfoListener;
                        if (h5SessionTabInfoListener != null) {
                            h5SessionTabInfoListener.onGetAsyncData((e) null);
                        }
                    } else if (str.startsWith("http")) {
                        H5SessionTabInfoParser.getOnlineData(str, h5SessionTabInfoListener, str);
                    } else {
                        e parseObject = H5Utils.parseObject(str);
                        H5SessionTabInfoListener h5SessionTabInfoListener2 = h5SessionTabInfoListener;
                        if (h5SessionTabInfoListener2 != null) {
                            h5SessionTabInfoListener2.onGetAsyncData(parseObject);
                        }
                    }
                }
            });
            H5Log.d(TAG, "##tabbar## getOfflineData in uithread dataStr ".concat(String.valueOf(data)));
            if (!TextUtils.isEmpty(data) && !TextUtils.equals(data, "stupid")) {
                handleDataNormal(h5SessionTabInfoListener, data, str);
            } else if (TextUtils.isEmpty(data) || !TextUtils.equals(data, "stupid")) {
                try {
                    byte[] tabDataByAppId = H5TabbarUtils.getTabDataByAppId(str);
                    String str2 = null;
                    if (tabDataByAppId != null) {
                        str2 = new String(tabDataByAppId);
                    }
                    H5Log.d(TAG, "##tabbar## getOfflineData else retry ".concat(String.valueOf(str2)));
                    if (!TextUtils.isEmpty(str2) && !TextUtils.equals(str2, "stupid")) {
                        handleDataNormal(h5SessionTabInfoListener, str2, str);
                    } else if (!TextUtils.isEmpty(str2) && TextUtils.equals(str2, "stupid")) {
                        handleDataAbnormal(h5SessionTabInfoListener);
                    } else if (h5SessionTabInfoListener != null) {
                        H5Log.d(TAG, "##tabbar## getOfflineData onShowDefaultTab()");
                        h5SessionTabInfoListener.onShowDefaultTab();
                    }
                } catch (Exception e2) {
                    H5Log.e(TAG, "catch exception ", e2);
                }
            } else {
                handleDataAbnormal(h5SessionTabInfoListener);
            }
        }
    }

    private static void handleDataAbnormal(H5SessionTabInfoListener h5SessionTabInfoListener) {
        if (h5SessionTabInfoListener != null) {
            H5Log.d(TAG, "##tabbar## getOfflineData onGetSyncData(null)");
            h5SessionTabInfoListener.onGetSyncData((e) null);
        }
    }

    private static void handleDataNormal(H5SessionTabInfoListener h5SessionTabInfoListener, String str, String str2) {
        if (str.startsWith("http")) {
            getOnlineData(str, h5SessionTabInfoListener, str2);
            return;
        }
        e parseObject = H5Utils.parseObject(str);
        if (h5SessionTabInfoListener != null) {
            H5Log.d(TAG, "##tabbar## getOfflineData onGetSyncData(dataObj)");
            h5SessionTabInfoListener.onGetSyncData(parseObject);
        }
    }

    public static void getOnlineData(final String str, final H5SessionTabInfoListener h5SessionTabInfoListener, final String str2) {
        if (h5SessionTabInfoListener != null) {
            H5Log.d(TAG, "##tabbar## getOnlineData onShowDefaultTab()");
            h5SessionTabInfoListener.onShowDefaultTab();
        }
        H5Utils.getExecutor(H5ThreadType.RPC).execute(new Runnable() {
            public final void run() {
                H5FallbackStreamProvider h5FallbackStreamProvider = (H5FallbackStreamProvider) H5Utils.getProvider(H5FallbackStreamProvider.class.getName());
                if (h5FallbackStreamProvider == null) {
                    H5Log.d(H5SessionTabInfoParser.TAG, "##tabbar## getOnlineData fallbackStreamProvider == null return");
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                e eVar = null;
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8,UC/163");
                    hashMap.put("Accept-Encoding", "gzip, deflate");
                    hashMap.put("Accept-Language", "en-US,en;q=0.8");
                    H5CustomHttpResponse httpRequest = h5FallbackStreamProvider.httpRequest(str, H5Param.DEFAULT_LONG_WEBVIEW_OPENURL_METHOD, hashMap, (byte[]) null, 5000, false);
                    if (!(httpRequest == null || httpRequest.getResStream() == null)) {
                        byte[] readBytes = H5Utils.readBytes(httpRequest.getResStream());
                        H5TabbarUtils.setTabData(str2, readBytes);
                        String str = new String(readBytes);
                        H5Log.d(H5SessionTabInfoParser.TAG, "##tabbar## getOnlineData from entry onPrepareData " + str + " " + (System.currentTimeMillis() - currentTimeMillis));
                        eVar = a.parseObject(str);
                    }
                    H5SessionTabInfoListener h5SessionTabInfoListener = h5SessionTabInfoListener;
                    if (h5SessionTabInfoListener != null) {
                        h5SessionTabInfoListener.onGetAsyncData(eVar);
                    }
                } catch (Exception e2) {
                    H5Log.e(H5SessionTabInfoParser.TAG, (Throwable) e2);
                    H5SessionTabInfoListener h5SessionTabInfoListener2 = h5SessionTabInfoListener;
                    if (h5SessionTabInfoListener2 != null) {
                        h5SessionTabInfoListener2.onGetAsyncData((e) null);
                    }
                } catch (Throwable th) {
                    H5SessionTabInfoListener h5SessionTabInfoListener3 = h5SessionTabInfoListener;
                    if (h5SessionTabInfoListener3 != null) {
                        h5SessionTabInfoListener3.onGetAsyncData((e) null);
                    }
                    throw th;
                }
            }
        });
    }
}
