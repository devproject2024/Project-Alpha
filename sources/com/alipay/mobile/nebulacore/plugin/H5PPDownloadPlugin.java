package com.alipay.mobile.nebulacore.plugin;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5CoreNode;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.nebula.provider.H5ChannelProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5ThreadType;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.Nebula;
import com.alipay.mobile.nebulacore.R;
import com.alipay.mobile.nebulacore.env.H5Environment;
import com.alipay.mobile.nebulacore.util.H5PPQueryThread;
import com.alipay.mobile.nebulacore.view.H5Toast;
import java.util.concurrent.ThreadPoolExecutor;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;

public class H5PPDownloadPlugin extends H5SimplePlugin {
    public static final String TAG = "H5PPDownloadPlugin";
    private String PP_DOWNLOAD = "ppdownload";
    /* access modifiers changed from: private */
    public H5Page h5Page = null;

    public void onInitialize(H5CoreNode h5CoreNode) {
        this.h5Page = (H5Page) h5CoreNode;
    }

    public void onPrepare(H5EventFilter h5EventFilter) {
        h5EventFilter.addAction(this.PP_DOWNLOAD);
    }

    public boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        if (!this.PP_DOWNLOAD.equals(h5Event.getAction())) {
            return true;
        }
        handlePPDownload(h5Event);
        return true;
    }

    private void handlePPDownload(H5Event h5Event) {
        final boolean z;
        e param = h5Event.getParam();
        String string = H5Utils.getString(param, "url");
        final String string2 = H5Utils.getString(param, ImagePickerUtils.IMAGE_PICKER_KEY_FILE_NAME);
        final String string3 = H5Utils.getString(param, "userAgent");
        final String string4 = H5Utils.getString(param, "contentDisposition");
        final String string5 = H5Utils.getString(param, ImagePickerUtils.IMAGE_PICKER_KEY_MIME_TYPE);
        final long j = H5Utils.getLong(param, "contentLength");
        H5ChannelProvider h5ChannelProvider = (H5ChannelProvider) Nebula.getProviderManager().getProvider(H5ChannelProvider.class.getName());
        if (h5ChannelProvider != null) {
            String channelId = h5ChannelProvider.getChannelId();
            boolean equals = "5136".equals(channelId);
            H5Log.d(TAG, "channelId is " + channelId + ", isGooglePlayChannel " + channelId);
            z = equals;
        } else {
            z = false;
        }
        H5Log.d(TAG, "isGooglePlayChannel ".concat(String.valueOf(z)));
        final String str = string;
        AnonymousClass1 r1 = new H5PPQueryThread.OnGetQueryResult() {
            public void onQueryResult(String str, String str2) {
                if (z) {
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            Nebula.startExtActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=".concat(String.valueOf(str2)))));
                        } catch (Exception unused) {
                            H5Utils.runOnMain(new Runnable() {
                                public void run() {
                                    H5Toast.showToast(H5Environment.getContext(), H5Environment.getResources().getString(R.string.h5_googleplaynotinstall), 0);
                                }
                            });
                        }
                    } else {
                        H5Log.d(H5PPDownloadPlugin.TAG, "googleplaychannel query packagename empty");
                    }
                    H5Log.d(H5PPDownloadPlugin.TAG, "download whitelistapk but googleplay channel return");
                } else if (!TextUtils.isEmpty(str)) {
                    H5PPDownloadPlugin.this.h5Page.loadUrl(str);
                    e eVar = new e();
                    eVar.put("type", (Object) "apk");
                    eVar.put("origin", (Object) str);
                    eVar.put("detailUrl", (Object) str);
                    H5PPDownloadPlugin.this.h5Page.sendEvent(H5Plugin.InternalEvents.H5_PAGE_JUMP_PP, eVar);
                } else {
                    H5PPDownloadPlugin.this.sendDownloadEvent(str, string2, string3, string4, string5, j);
                }
            }
        };
        ThreadPoolExecutor executor = H5Utils.getExecutor(H5ThreadType.URGENT);
        H5PPQueryThread instance = H5PPQueryThread.getInstance();
        instance.setParams(string, 1, r1, this.h5Page);
        executor.execute(instance);
    }

    /* access modifiers changed from: private */
    public void sendDownloadEvent(String str, String str2, String str3, String str4, String str5, long j) {
        e eVar = new e();
        eVar.put("url", (Object) str);
        eVar.put(ImagePickerUtils.IMAGE_PICKER_KEY_FILE_NAME, (Object) str2);
        eVar.put("userAgent", (Object) str3);
        eVar.put("contentDisposition", (Object) str4);
        eVar.put(ImagePickerUtils.IMAGE_PICKER_KEY_MIME_TYPE, (Object) str5);
        eVar.put("contentLength", (Object) Long.valueOf(j));
        this.h5Page.sendEvent(H5Plugin.InternalEvents.H5_PAGE_DOWNLOAD, eVar);
    }
}
